package com.hpplay.sdk.source.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.common.log.LeLog;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IConnector;
import com.hpplay.component.common.protocol.IPushController;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.protocol.push.IPushHandler;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.bean.PlayerInfoBean;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.player.ICastPlayer;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.AbsConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

public class LelinkPushBridge extends AbsBridge {
    private static final int ARG_PUSH_ERROR = 0;
    private static final int ARG_PUSH_SHOW_CAST_CODE = 2;
    private static final int ARG_PUSH_SUCCESS = 1;
    private static final int DELAY_COMPLETE = 4000;
    private static final int DELAY_PLAY = 3000;
    private static int DELAY_STOPPED = 2000;
    private static final int DELAY_UPDATE_POSITION = 1000;
    private static final int DELAY_UPDATE_STATE = 2000;
    private static final int DELAY_WHEN_BACKGROUND_UPDATE_POSITION = 10000;
    private static final String DLNA_STATE_PAUSE = "paused";
    private static final String DLNA_STATE_PLAYING = "playing";
    private static final String DLNA_STATE_STOPPED = "stopped";
    private static final int MSG_DELAY_PLAY = 200;
    protected static String TAG = "LelinkPushBridge";
    protected boolean isCallPrepared = false;
    protected boolean isJGTP = false;
    /* access modifiers changed from: private */
    public boolean isReleased = false;
    private boolean isUpdatePosition = false;
    private long mDlnaGetPlayStateTime = 0;
    private String mDlnaPreState = "";
    private final Runnable mDlnaStateRunnable = new Runnable() {
        public void run() {
            IPushController iPushController = LelinkPushBridge.this.mPushController;
            if (iPushController != null) {
                iPushController.getStateInfo();
                LelinkPushBridge.this.mHandler.postDelayed(this, 2000);
            }
        }
    };
    private String mDlnaUUID = null;
    protected int mDuration;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            try {
                if (message.what == 200) {
                    LelinkPushBridge.this.startPush();
                    return true;
                }
                LelinkPushBridge.this.handleMsg(message);
                return false;
            } catch (Exception e10) {
                SourceLog.w(LelinkPushBridge.TAG, (Throwable) e10);
                return false;
            }
        }
    });
    private long mLastPlayDuration = 0;
    private long mLastPlayPosition = 0;
    private ModuleLinker mModuleLinker;
    private LelinkProtocolListener mPlayerListener = new LelinkProtocolListener() {
        public void onResult(int i10, String... strArr) {
            if (!LelinkPushBridge.this.isReleased) {
                LelinkPushBridge.this.resolveProtocolInfo(i10, strArr);
            }
        }
    };
    private int mPosition;
    private int mPositionCount = -1;
    private final Runnable mPositionRunnable = new Runnable() {
        public void run() {
            IPushController iPushController = LelinkPushBridge.this.mPushController;
            if (iPushController != null) {
                iPushController.getPlayInfo();
                LelinkPushBridge lelinkPushBridge = LelinkPushBridge.this;
                if (lelinkPushBridge.isAppResume) {
                    lelinkPushBridge.mHandler.postDelayed(this, 1000);
                } else if (lelinkPushBridge.getRemainProgress() > 60) {
                    LelinkPushBridge.this.mHandler.postDelayed(this, NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
                } else {
                    LelinkPushBridge.this.mHandler.postDelayed(this, 1000);
                }
            }
        }
    };
    private String mPreDLNAStopUrl = null;
    protected IPushController mPushController;
    private String mReportPrepareDramaId = null;
    AbsConnectBridge.OnPassSendCompleteListener onPassReceivedListener = new AbsConnectBridge.OnPassSendCompleteListener() {
        public void onPassReversed(PassBean passBean) {
            String str = LelinkPushBridge.TAG;
            LeLog.i(str, " >>>> " + passBean.cmd + " passBean  " + passBean.result);
            if (passBean.cmd == 2) {
                LelinkPushBridge.this.mHandler.removeMessages(200);
                LelinkPushBridge.this.startPush();
            }
        }
    };

    public LelinkPushBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        this.mPlayInfo = outParameter;
        try {
            if (this.mPushController == null) {
                ModuleLinker newInstance = ModuleLinker.getNewInstance();
                this.mModuleLinker = newInstance;
                IPushController iPushController = (IPushController) newInstance.loadModule(ModuleIds.CLAZZ_ID1088_PUSHCONTROLLERIMPL);
                this.mPushController = iPushController;
                iPushController.setProtocolListener(this.mPlayerListener);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    private void callbackDlnaStateChanged(String str) {
        boolean z10;
        String str2 = TAG;
        SourceLog.i(str2, "CMD_GET_STATEINFO callbackDlnaStateChanged " + str);
        if ("playing".equals(str)) {
            callbackStart();
        } else if ("paused".equals(str)) {
            OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
            if (onStateChangeListener != null) {
                onStateChangeListener.onStateChanged((ICastPlayer) null, 4);
            }
        } else if ("stopped".equals(str)) {
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(" callbackDlnaStateChanged delayStop   ");
            if (System.currentTimeMillis() - this.mDlnaGetPlayStateTime < 2000) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            sb.append(this.mDlnaGetPlayStateTime);
            SourceLog.i(str3, sb.toString());
            if (System.currentTimeMillis() - this.mDlnaGetPlayStateTime < 4000) {
                DELAY_STOPPED = 10000;
            }
            notifyStopped(1);
        }
    }

    private void callbackStart() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null && outParameter.urls != null) {
            String str = this.mReportPrepareDramaId;
            if (str == null || !str.equals(outParameter.dramaID)) {
                this.mReportPrepareDramaId = this.mPlayInfo.dramaID;
                OnPreparedListener onPreparedListener = this.mPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared((ICastPlayer) null);
                    return;
                }
                return;
            }
            OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
            if (onStateChangeListener != null) {
                onStateChangeListener.onStateChanged((ICastPlayer) null, 3);
            }
        } else if (!this.isCallPrepared) {
            this.isCallPrepared = true;
            OnPreparedListener onPreparedListener2 = this.mPreparedListener;
            if (onPreparedListener2 != null) {
                onPreparedListener2.onPrepared((ICastPlayer) null);
            }
        } else {
            OnStateChangeListener onStateChangeListener2 = this.mStateChangeListener;
            if (onStateChangeListener2 != null) {
                onStateChangeListener2.onStateChanged((ICastPlayer) null, 3);
            }
        }
    }

    /* access modifiers changed from: private */
    public int getRemainProgress() {
        int i10 = this.mDuration - this.mPosition;
        String str = TAG;
        SourceLog.i(str, "remain progress " + i10);
        return i10;
    }

    /* access modifiers changed from: private */
    public void handleMsg(Message message) {
        String str = TAG;
        SourceLog.i(str, "handleMsg " + message.what);
        int i10 = message.what;
        if (i10 != 1) {
            if (!(i10 == 26 || i10 == 12)) {
                if (i10 == 13) {
                    callbackStart();
                    if (this.mPlayInfo.protocol == 3) {
                        SourceLog.i(TAG, "CMD_ON_START_PLAY ");
                        this.mHandler.removeCallbacks(this.mDlnaStateRunnable);
                        this.mHandler.post(this.mDlnaStateRunnable);
                        return;
                    }
                    return;
                } else if (i10 == 15) {
                    OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
                    if (onStateChangeListener != null) {
                        onStateChangeListener.onStateChanged((ICastPlayer) null, 4);
                        return;
                    }
                    return;
                } else if (i10 != 16) {
                    return;
                }
            }
            if (System.currentTimeMillis() - this.mDlnaGetPlayStateTime >= 4000) {
                cancelPositionUpdate();
                cancelStateUpdate();
                this.isCallPrepared = false;
                if (message.what != 26) {
                    release();
                }
                if (message.what == 12) {
                    OnCompletionListener onCompletionListener = this.mCompletionListener;
                    if (onCompletionListener != null) {
                        onCompletionListener.onComplete((ICastPlayer) null);
                        return;
                    }
                    return;
                }
                if (this instanceof DLNABridge) {
                    long j10 = this.mLastPlayDuration;
                    long j11 = this.mLastPlayPosition;
                    if (j10 - j11 <= 5 && j10 - j11 >= 0 && j10 > 0) {
                        OnCompletionListener onCompletionListener2 = this.mCompletionListener;
                        if (onCompletionListener2 != null) {
                            onCompletionListener2.onComplete((ICastPlayer) null);
                            return;
                        }
                        return;
                    }
                }
                if (this.mStopListener != null) {
                    StopInfo stopInfo = new StopInfo();
                    if (message.what == 26) {
                        stopInfo.type = 3;
                    } else {
                        stopInfo.type = message.arg1;
                    }
                    this.mStopListener.onStop((ICastPlayer) null, stopInfo);
                    return;
                }
                return;
            }
            return;
        }
        int i11 = message.arg1;
        if (i11 == 2) {
            OnErrorListener onErrorListener = this.mErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError((ICastPlayer) null, 210010, 211026, (String) null);
                return;
            }
            return;
        }
        String str2 = "";
        if (i11 == 1) {
            if (this.mLoadingListener != null) {
                Object obj = message.obj;
                if (obj != null) {
                    str2 = obj.toString();
                }
                this.mLoadingListener.onLoading((ICastPlayer) null, str2);
            }
            if (this.mPlayInfo.protocol == 3) {
                this.mDlnaGetPlayStateTime = System.currentTimeMillis();
                this.mHandler.postDelayed(this.mDlnaStateRunnable, 2000);
            }
        } else if (this.mErrorListener != null) {
            Object obj2 = message.obj;
            if (obj2 != null) {
                str2 = obj2.toString();
            }
            this.mErrorListener.onError((ICastPlayer) null, 210010, 210011, str2);
        }
    }

    private boolean isSameDlna(String... strArr) {
        String str;
        try {
            String str2 = null;
            if (strArr.length > 0) {
                str = strArr[0];
            } else {
                str = null;
            }
            if (strArr.length > 1) {
                str2 = strArr[1];
            }
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(this.mDlnaUUID) && !TextUtils.equals(str2, this.mDlnaUUID)) {
                    SourceLog.w(TAG, "isSameDlna unEqual uri, " + str2 + " / " + this.mDlnaUUID);
                    return false;
                }
            }
            if (!TextUtils.isEmpty(str) && !isSameUrl(str, this.mPlayInfo.getPlayUrl())) {
                SourceLog.w(TAG, "isSameDlna unEqual url, " + str + " / " + this.mPlayInfo.getPlayUrl());
                this.mPreDLNAStopUrl = str;
                return false;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        return true;
    }

    private boolean isSameLelink(String... strArr) {
        String str;
        try {
            if (strArr.length > 0) {
                str = strArr[0];
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str) || isSameUrl(str, this.mPlayInfo.urlID)) {
                return true;
            }
            String str2 = TAG;
            SourceLog.w(str2, "isSameLelink unEqual uri, " + str + Operator.Operation.DIVISION + this.mPlayInfo.urlID);
            return false;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return true;
        }
    }

    private boolean isSameUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
            try {
                if (!TextUtils.equals(URLDecoder.decode(str), str2) && !TextUtils.equals(URLDecoder.decode(str2), str)) {
                    return false;
                }
                return true;
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
        return false;
    }

    private void notifyPosition(String... strArr) {
        try {
            if (strArr.length >= 2 && !strArr[0].contains(IPushHandler.READY_PLAY)) {
                int ceil = (int) Math.ceil((double) Float.parseFloat(strArr[0]));
                int ceil2 = (int) Math.ceil((double) Float.parseFloat(strArr[1]));
                if (this instanceof DLNABridge) {
                    try {
                        String str = strArr[2];
                    } catch (Exception e10) {
                        SourceLog.w(TAG, (Throwable) e10);
                    }
                }
                if (ceil > 0) {
                    this.mDuration = ceil;
                }
                if (ceil2 >= 0) {
                    this.mPosition = ceil2;
                }
                int i10 = this.mPositionCount + 1;
                this.mPositionCount = i10;
                if (i10 % 30 == 0) {
                    printResult("notifyPosition ", "mDuration := " + this.mDuration + " mPosition := " + this.mPosition, "mInfoListener := " + this.mInfoListener);
                }
                int i11 = this.mPosition;
                if (i11 > 0) {
                    this.mLastPlayPosition = (long) i11;
                }
                int i12 = this.mDuration;
                if (i12 > 0) {
                    this.mLastPlayDuration = (long) i12;
                }
                OnInfoListener onInfoListener = this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo((ICastPlayer) null, 100, i12, i11);
                }
                if (this.isJGTP) {
                    long j10 = this.mLastPlayDuration;
                    long j11 = this.mLastPlayPosition;
                    if (j10 - j11 < 2 && j10 - j11 >= 0 && j10 > 3 && this.mDuration > 0 && this.mPosition > 0 && !this.mHandler.hasMessages(12)) {
                        SourceLog.i(TAG, "notifyPosition send CMD_ON_COMPLETION delay 4000");
                        this.mHandler.removeMessages(12);
                        this.mHandler.sendEmptyMessageDelayed(12, 4000);
                    }
                }
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, (Throwable) e11);
        }
    }

    private void notifyStopped(int i10) {
        if (this.mHandler.hasMessages(16)) {
            SourceLog.w(TAG, "notifyStopped ignore");
            return;
        }
        String str = TAG;
        SourceLog.i(str, "notifyStopped delay " + DELAY_STOPPED + " / stopType:" + i10);
        Message obtain = Message.obtain();
        obtain.what = 16;
        obtain.arg1 = i10;
        this.mHandler.sendMessageDelayed(obtain, (long) DELAY_STOPPED);
    }

    private void printResult(String str, String... strArr) {
        String str2 = "";
        for (String str3 : strArr) {
            str2 = str2 + str3 + "  ";
        }
        SourceLog.i(TAG, "cmd: " + str + "   result:" + str2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resolveProtocolInfo(int r10, java.lang.String... r11) {
        /*
            r9 = this;
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "====resolveProtocolInfo cmd "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = ","
            r1.append(r2)
            java.lang.String r2 = java.util.Arrays.toString(r11)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.hpplay.sdk.source.log.SourceLog.i(r0, r1)
            r0 = 2
            r1 = 0
            r2 = 16
            r3 = 0
            r4 = 1
            if (r10 == r4) goto L_0x01c5
            r5 = 15
            if (r10 == r0) goto L_0x01be
            r0 = 3
            if (r10 == r0) goto L_0x01b9
            r6 = 4
            if (r10 == r6) goto L_0x01b4
            r7 = 7
            if (r10 == r7) goto L_0x01aa
            r7 = 8
            if (r10 == r7) goto L_0x01a2
            r7 = 9
            if (r10 == r7) goto L_0x0168
            r7 = 26
            if (r10 == r7) goto L_0x0151
            r7 = 28
            if (r10 == r7) goto L_0x012d
            switch(r10) {
                case 11: goto L_0x0126;
                case 12: goto L_0x010d;
                case 13: goto L_0x006d;
                case 14: goto L_0x0063;
                case 15: goto L_0x0051;
                case 16: goto L_0x012d;
                case 17: goto L_0x004c;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x023b
        L_0x004c:
            r9.notifyPosition(r11)
            goto L_0x023b
        L_0x0051:
            java.lang.String r0 = "CMD_ON_PAUSE"
            r9.printResult(r0, r11)
            r9.updateDramaIdOnCallback(r10, r11)
            android.os.Handler r10 = r9.mHandler
            r10.sendEmptyMessage(r5)
            r9.cancelPositionUpdate()
            goto L_0x023b
        L_0x0063:
            java.lang.String r0 = "CMD_ON_LOADING"
            r9.printResult(r0, r11)
            r9.updateDramaIdOnCallback(r10, r11)
            goto L_0x023b
        L_0x006d:
            java.lang.String r5 = "CMD_ON_START_PLAY"
            r9.printResult(r5, r11)
            r9.updateDramaIdOnCallback(r10, r11)
            com.hpplay.sdk.source.bean.OutParameter r10 = r9.mPlayInfo     // Catch:{ Exception -> 0x0092 }
            int r10 = r10.protocol     // Catch:{ Exception -> 0x0092 }
            if (r10 != r0) goto L_0x0090
            int r10 = r11.length     // Catch:{ Exception -> 0x0092 }
            if (r10 <= 0) goto L_0x0081
            r10 = r11[r3]     // Catch:{ Exception -> 0x0092 }
            goto L_0x0082
        L_0x0081:
            r10 = r1
        L_0x0082:
            int r0 = r11.length     // Catch:{ Exception -> 0x008b }
            if (r0 <= r4) goto L_0x0088
            r11 = r11[r4]     // Catch:{ Exception -> 0x008b }
            goto L_0x0089
        L_0x0088:
            r11 = r1
        L_0x0089:
            r1 = r10
            goto L_0x009c
        L_0x008b:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x0094
        L_0x0090:
            r11 = r1
            goto L_0x009c
        L_0x0092:
            r10 = move-exception
            r11 = r1
        L_0x0094:
            java.lang.String r0 = TAG
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r10)
            r8 = r1
            r1 = r11
            r11 = r8
        L_0x009c:
            boolean r10 = android.text.TextUtils.isEmpty(r1)
            if (r10 != 0) goto L_0x00cf
            com.hpplay.sdk.source.bean.OutParameter r10 = r9.mPlayInfo
            java.lang.String r10 = r10.getPlayUrl()
            boolean r10 = r9.isSameUrl(r1, r10)
            if (r10 != 0) goto L_0x00cf
            java.lang.String r10 = TAG
            java.lang.String r11 = "CMD_ON_START_PLAY ignore"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r10, (java.lang.String) r11)
            java.lang.String r10 = r9.mPreDLNAStopUrl
            boolean r10 = android.text.TextUtils.equals(r1, r10)
            if (r10 == 0) goto L_0x00ce
            java.lang.String r10 = TAG
            java.lang.String r11 = "CMD_ON_START_PLAY not current url, callback stop"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r10, (java.lang.String) r11)
            android.os.Handler r10 = r9.mHandler
            r10.removeMessages(r2)
            android.os.Handler r10 = r9.mHandler
            r10.sendEmptyMessage(r2)
        L_0x00ce:
            return
        L_0x00cf:
            java.lang.String r10 = r9.mDlnaUUID
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x00d9
            r9.mDlnaUUID = r11
        L_0x00d9:
            android.os.Handler r10 = r9.mHandler
            boolean r10 = r10.hasMessages(r2)
            if (r10 == 0) goto L_0x0101
            com.hpplay.sdk.source.bean.OutParameter r10 = r9.mPlayInfo
            java.lang.String r10 = r10.getPlayUrl()
            boolean r10 = r9.isSameUrl(r10, r1)
            if (r10 != 0) goto L_0x00f5
            java.lang.String r10 = r9.mDlnaUUID
            boolean r10 = android.text.TextUtils.equals(r10, r11)
            if (r10 == 0) goto L_0x0101
        L_0x00f5:
            java.lang.String r10 = TAG
            java.lang.String r11 = "there has a stop msg,remove it "
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r10, (java.lang.String) r11)
            android.os.Handler r10 = r9.mHandler
            r10.removeMessages(r2)
        L_0x0101:
            android.os.Handler r10 = r9.mHandler
            r11 = 13
            r10.sendEmptyMessage(r11)
            r9.updatePosition()
            goto L_0x023b
        L_0x010d:
            java.lang.String r0 = "CMD_ON_COMPLETION"
            r9.printResult(r0, r11)
            r9.updateDramaIdOnCallback(r10, r11)
            android.os.Handler r10 = r9.mHandler
            r11 = 12
            r10.removeMessages(r11)
            android.os.Handler r10 = r9.mHandler
            r10.sendEmptyMessage(r11)
            r9.cancelPositionUpdate()
            goto L_0x023b
        L_0x0126:
            java.lang.String r10 = "CMD_CONNECT "
            r9.printResult(r10, r11)
            goto L_0x023b
        L_0x012d:
            java.lang.String r1 = "CMD_ON_STOPED"
            r9.printResult(r1, r11)
            com.hpplay.sdk.source.bean.OutParameter r1 = r9.mPlayInfo
            int r1 = r1.protocol
            if (r1 != r0) goto L_0x013f
            boolean r0 = r9.isSameDlna(r11)
            if (r0 != 0) goto L_0x0146
            return
        L_0x013f:
            boolean r0 = r9.isSameLelink(r11)
            if (r0 != 0) goto L_0x0146
            return
        L_0x0146:
            r9.updateDramaIdOnCallback(r10, r11)
            if (r10 != r7) goto L_0x014c
            r4 = 4
        L_0x014c:
            r9.notifyStopped(r4)
            goto L_0x023b
        L_0x0151:
            java.lang.String r0 = "EPISODE_STOPED"
            r9.printResult(r0, r11)
            r9.updateDramaIdOnCallback(r10, r11)
            android.os.Handler r10 = r9.mHandler
            r10.removeMessages(r7)
            android.os.Handler r10 = r9.mHandler
            r10.sendEmptyMessage(r7)
            r9.cancelPositionUpdate()
            goto L_0x023b
        L_0x0168:
            int r10 = r11.length
            if (r10 >= r4) goto L_0x016c
            return
        L_0x016c:
            r10 = r11[r3]
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0175
            return
        L_0x0175:
            r10 = r11[r3]
            java.lang.String r11 = "playing"
            boolean r11 = r11.equals(r10)
            if (r11 == 0) goto L_0x0193
            android.os.Handler r11 = r9.mHandler
            boolean r11 = r11.hasMessages(r2)
            if (r11 == 0) goto L_0x0193
            java.lang.String r11 = TAG
            java.lang.String r0 = "CMD_GET_STATEINFO there has a stop msg,remove it"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r11, (java.lang.String) r0)
            android.os.Handler r11 = r9.mHandler
            r11.removeMessages(r2)
        L_0x0193:
            java.lang.String r11 = r9.mDlnaPreState
            boolean r11 = android.text.TextUtils.equals(r11, r10)
            if (r11 != 0) goto L_0x023b
            r9.callbackDlnaStateChanged(r10)
            r9.mDlnaPreState = r10
            goto L_0x023b
        L_0x01a2:
            r9.updateDramaIdOnCallback(r10, r11)
            r9.notifyPosition(r11)
            goto L_0x023b
        L_0x01aa:
            android.os.Handler r10 = r9.mHandler
            r10.sendEmptyMessage(r2)
            r9.cancelPositionUpdate()
            goto L_0x023b
        L_0x01b4:
            r9.updatePosition()
            goto L_0x023b
        L_0x01b9:
            r9.updatePosition()
            goto L_0x023b
        L_0x01be:
            android.os.Handler r10 = r9.mHandler
            r10.sendEmptyMessage(r5)
            goto L_0x023b
        L_0x01c5:
            java.lang.String r10 = "CMD_PUSH "
            r9.printResult(r10, r11)
            android.os.Handler r10 = r9.mHandler
            r10.removeMessages(r2)
            int r10 = r11.length
            if (r10 >= r4) goto L_0x01e3
            java.lang.String r10 = TAG
            java.lang.String r11 = "push error"
            com.hpplay.sdk.source.log.SourceLog.i(r10, r11)
            android.os.Handler r10 = r9.mHandler
            android.os.Message r10 = r10.obtainMessage(r4, r3, r3)
            r10.sendToTarget()
            goto L_0x023b
        L_0x01e3:
            java.lang.String r10 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "push "
            r2.append(r5)
            r5 = r11[r3]
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.hpplay.sdk.source.log.SourceLog.i(r10, r2)
            java.lang.String r10 = "successful"
            r2 = r11[r3]
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0214
            android.os.Handler r10 = r9.mHandler
            r11 = r11[r4]
            android.os.Message r11 = android.os.Message.obtain(r1, r4, r4, r3, r11)
            r10.sendMessage(r11)
            r9.updatePosition()
            goto L_0x023b
        L_0x0214:
            java.lang.String r10 = "603"
            r2 = r11[r3]
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0230
            java.lang.String r10 = TAG
            java.lang.String r11 = "CMD_PUSH need cast code"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r10, (java.lang.String) r11)
            android.os.Handler r10 = r9.mHandler
            r11 = -1
            android.os.Message r10 = r10.obtainMessage(r4, r0, r11)
            r10.sendToTarget()
            goto L_0x023b
        L_0x0230:
            android.os.Handler r10 = r9.mHandler
            r11 = r11[r4]
            android.os.Message r11 = android.os.Message.obtain(r1, r4, r3, r3, r11)
            r10.sendMessage(r11)
        L_0x023b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.protocol.LelinkPushBridge.resolveProtocolInfo(int, java.lang.String[]):void");
    }

    private void setPlayListParams(ParamsMap paramsMap, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        String str;
        DramaInfoBean.UrlBean[] urlBeanArr;
        ParamsMap paramsMap2 = paramsMap;
        DramaInfoBean[] dramaInfoBeanArr2 = dramaInfoBeanArr;
        try {
            paramsMap2.putParam("period", Integer.valueOf(i10));
            paramsMap2.putParam("curplayid", this.mPlayInfo.dramaID);
            paramsMap2.putParam(ParamsMap.PushParams.KEY_HEAD_DURATION, Integer.valueOf(i11));
            paramsMap2.putParam(ParamsMap.PushParams.KEY_TAIL_DURATION, Integer.valueOf(i12));
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            int i13 = 0;
            int i14 = 0;
            while (i13 < dramaInfoBeanArr2.length) {
                DramaInfoBean dramaInfoBean = dramaInfoBeanArr2[i13];
                if (dramaInfoBean != null) {
                    DramaInfoBean.UrlBean[] urlBeanArr2 = dramaInfoBean.urls;
                    if (urlBeanArr2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        boolean isEmpty = TextUtils.isEmpty(dramaInfoBean.name);
                        String str2 = XML.CHARSET_UTF8;
                        if (!isEmpty) {
                            try {
                                dramaInfoBean.name = URLEncoder.encode(dramaInfoBean.name, str2);
                            } catch (Exception e10) {
                                String str3 = TAG;
                                SourceLog.w(str3, "setPlayListParams :" + e10);
                            }
                        }
                        jSONObject2.put("name", dramaInfoBean.name);
                        JSONArray jSONArray2 = new JSONArray();
                        int i15 = 0;
                        int i16 = 0;
                        while (i15 < urlBeanArr2.length) {
                            DramaInfoBean.UrlBean urlBean = urlBeanArr2[i15];
                            if (urlBean == null) {
                                urlBeanArr = urlBeanArr2;
                                str = str2;
                            } else {
                                JSONObject jSONObject3 = new JSONObject();
                                urlBeanArr = urlBeanArr2;
                                jSONObject3.put("height", urlBean.height);
                                jSONObject3.put("width", urlBean.width);
                                jSONObject3.put("playid", urlBean.id);
                                if (!TextUtils.isEmpty(urlBean.url)) {
                                    try {
                                        urlBean.url = URLEncoder.encode(urlBean.url, str2);
                                    } catch (Exception e11) {
                                        String str4 = TAG;
                                        str = str2;
                                        SourceLog.w(str4, "setPlayListParams :" + e11);
                                    }
                                }
                                str = str2;
                                jSONObject3.put("url", urlBean.url);
                                jSONObject3.put("category", urlBean.category);
                                jSONArray2.put(i16, jSONObject3);
                                i16++;
                            }
                            i15++;
                            DramaInfoBean[] dramaInfoBeanArr3 = dramaInfoBeanArr;
                            urlBeanArr2 = urlBeanArr;
                            str2 = str;
                        }
                        jSONObject2.put("urls", jSONArray2);
                        jSONArray.put(i14, jSONObject2);
                        i14++;
                    }
                }
                i13++;
                dramaInfoBeanArr2 = dramaInfoBeanArr;
            }
            jSONObject.put(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, jSONArray);
            paramsMap2.putParam(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, jSONObject);
        } catch (Exception e12) {
            String str5 = TAG;
            SourceLog.w(str5, "getPlayListParams error:" + e12.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateDramaIdOnCallback(int r2, java.lang.String... r3) {
        /*
            r1 = this;
            r0 = 8
            if (r2 != r0) goto L_0x000e
            if (r3 == 0) goto L_0x0018
            int r2 = r3.length
            r0 = 4
            if (r2 < r0) goto L_0x0018
            r2 = 3
            r2 = r3[r2]
            goto L_0x001a
        L_0x000e:
            if (r3 == 0) goto L_0x0018
            int r2 = r3.length
            r0 = 2
            if (r2 < r0) goto L_0x0018
            r2 = 1
            r2 = r3[r2]
            goto L_0x001a
        L_0x0018:
            java.lang.String r2 = ""
        L_0x001a:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x002c
            com.hpplay.sdk.source.business.BusinessEntity r3 = com.hpplay.sdk.source.business.BusinessEntity.getInstance()
            com.hpplay.sdk.source.bean.OutParameter r3 = r3.getLastPlayInfo()
            if (r3 == 0) goto L_0x002c
            r3.dramaID = r2
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.protocol.LelinkPushBridge.updateDramaIdOnCallback(int, java.lang.String[]):void");
    }

    public void addVolume() {
        super.addVolume();
        if (this.mPushController == null) {
            SourceLog.w(TAG, "addVolume ignore");
            return;
        }
        SourceLog.i(TAG, "addVolume");
        this.mPushController.increaseVolume();
    }

    public void appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        SourceLog.i(TAG, "appendPlayList");
        if (this.mPushController == null) {
            SourceLog.w(TAG, "appendPlayList ignore");
        } else if (dramaInfoBeanArr == null || dramaInfoBeanArr.length <= 0) {
            SourceLog.w(TAG, "appendPlayList ignore list invalid");
        } else {
            try {
                ParamsMap paramsMap = new ParamsMap();
                setPlayListParams(paramsMap, dramaInfoBeanArr, i10, i11, i12);
                this.mPushController.addPlayList(paramsMap);
            } catch (Exception e10) {
                String str2 = TAG;
                SourceLog.w(str2, "appendPlayList error:" + e10.getMessage());
            }
        }
    }

    public void cancelPositionUpdate() {
        this.isUpdatePosition = false;
        this.mHandler.removeCallbacks(this.mPositionRunnable);
    }

    public void cancelStateUpdate() {
        SourceLog.i(TAG, "cancelStateUpdate... ");
        this.mHandler.removeCallbacks(this.mDlnaStateRunnable);
    }

    public void clearPlayList(String str) {
        SourceLog.i(TAG, "clearPlayList");
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "clearPlayList ignore");
        } else {
            iPushController.clearPlayList();
        }
    }

    public void onAppPause() {
        super.onAppPause();
        IPushController iPushController = this.mPushController;
        if (iPushController != null) {
            iPushController.onAppPause();
        }
    }

    public void onAppResume() {
        super.onAppResume();
        IPushController iPushController = this.mPushController;
        if (iPushController != null) {
            iPushController.onAppResume();
        }
        if (this.isUpdatePosition) {
            updatePosition();
        }
    }

    public void pause(String str) {
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "pause ignore");
        } else {
            iPushController.pause();
        }
    }

    public void play(String str) {
        if (this.mPushController == null) {
            SourceLog.w(TAG, "play ignore");
            return;
        }
        if (ConnectManager.getInstance().getLastConnectBridge() != null) {
            this.mPushController.setConnector(ConnectManager.getInstance().getLastConnectBridge().getConnector());
            ConnectManager.getInstance().getLastConnectBridge().addOnPassSendCompleteListener(this, this.onPassReceivedListener);
        }
        if (CastUtil.isSupportLelinkV2(this.mPlayInfo.serviceInfo)) {
            PlayerInfoBean playerInfoBean = this.mPlayInfo.playerInfoBean;
            if (playerInfoBean != null && !playerInfoBean.isEmpty()) {
                OutParameter outParameter = this.mPlayInfo;
                outParameter.playerInfoBean.setUri(outParameter.urlID);
                PassSender instance = PassSender.getInstance();
                OutParameter outParameter2 = this.mPlayInfo;
                instance.sendPlayerInfo(outParameter2.playerInfoBean, outParameter2.session);
            }
            MediaAssetBean mediaAssetBean = this.mPlayInfo.mediaAssetBean;
            if (mediaAssetBean != null && !mediaAssetBean.isEmpty()) {
                OutParameter outParameter3 = this.mPlayInfo;
                outParameter3.mediaAssetBean.setUri(outParameter3.urlID);
                this.mHandler.sendEmptyMessageDelayed(200, 3000);
                PassSender instance2 = PassSender.getInstance();
                OutParameter outParameter4 = this.mPlayInfo;
                instance2.sendMediaAssets(outParameter4.mediaAssetBean, outParameter4.session);
                return;
            }
        }
        startPush();
    }

    public void playDrama(String str, String str2) {
        String str3 = TAG;
        SourceLog.i(str3, "playDrama :" + str2);
        if (this.mPushController == null) {
            SourceLog.w(TAG, "playDrama ignore");
            return;
        }
        ParamsMap paramsMap = new ParamsMap();
        paramsMap.putParam("curplayid", str2);
        paramsMap.putParam("width", 0);
        paramsMap.putParam("height", 0);
        this.mPushController.selectPlay(paramsMap);
    }

    public void playNextDrama(String str) {
        SourceLog.i(TAG, "playNextDrama");
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "playNextDrama ignore");
        } else {
            iPushController.playNext();
        }
    }

    public void playPreDrama(String str) {
        SourceLog.i(TAG, "playPreDrama");
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "playPreDrama ignore");
        } else {
            iPushController.playPrevious();
        }
    }

    public synchronized void release() {
        if (this.mPushController != null) {
            if (this.isReleased) {
                SourceLog.w(TAG, "release ignore");
                return;
            }
            String str = TAG;
            SourceLog.i(str, "release " + this);
            this.isReleased = true;
            this.mPushController.setProtocolListener((ProtocolListener) null);
            this.mPushController.disConnect();
            this.mHandler.removeMessages(16);
            this.mHandler.removeMessages(12);
            ConnectManager.getInstance().getLastConnectBridge().removeOnPassSendCompleteListener(this);
            ModuleLinker moduleLinker = this.mModuleLinker;
            if (moduleLinker != null) {
                moduleLinker.removeObjOfMemory(ModuleIds.CLAZZ_ID1088_PUSHCONTROLLERIMPL);
                this.mModuleLinker = null;
            }
            this.mPushController = null;
        }
    }

    public void resume(String str) {
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "resume ignore");
        } else {
            iPushController.resume();
        }
    }

    public void seekTo(int i10) {
        if (this.mPushController == null) {
            SourceLog.w(TAG, "seekTo ignore");
            return;
        }
        String str = TAG;
        SourceLog.i(str, "seekTo: second := " + i10);
        this.mPushController.seekTo(i10);
    }

    public void selectAudiotrack(int i10) {
        if (this.mPushController == null) {
            SourceLog.w(TAG, "selectAudiotrack ignore");
            return;
        }
        String str = TAG;
        SourceLog.i(str, "selectAudiotrack index = " + i10);
        this.mPushController.selectAudiotrack(i10);
    }

    public void setVolume(int i10) {
        super.setVolume(i10);
    }

    public void startPush() {
        String str;
        OutParameter outParameter = this.mPlayInfo;
        BrowserInfo browserInfo = outParameter.currentBrowserInfo;
        if (browserInfo == null) {
            SourceLog.w(TAG, "play ignore, invalid browser info");
            return;
        }
        this.isCallPrepared = false;
        this.mDuration = outParameter.duration;
        LelinkServiceInfo lelinkServiceInfo = outParameter.serviceInfo;
        if (lelinkServiceInfo != null) {
            str = lelinkServiceInfo.getName();
        } else {
            str = "";
        }
        String str2 = TAG;
        SourceLog.i(str2, "play " + this.mPlayInfo.getPlayUrl() + " to " + str + Operator.Operation.DIVISION + this);
        ParamsMap create = ParamsMap.create();
        create.putParam(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
        create.putParam(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
        String string = FieldUtil.getString(FieldUtil.f10533m);
        Session.getInstance();
        create.putParam(string, Session.DEFAULT_M);
        create.putParam("imei", "");
        create.putParam(ParamsMap.DeviceParams.KEY_SINK_NAME, str);
        create.putParam(ParamsMap.DeviceParams.KEY_SESSION_ID, this.mPlayInfo.session);
        create.putParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, this.mPlayInfo.connectSession);
        create.putParam(ParamsMap.PushParams.KEY_START_POSITION, Integer.valueOf(this.mPlayInfo.startPosition));
        create.putParam("uri", this.mPlayInfo.urlID);
        create.putParam(ParamsMap.PushParams.KEY_MEDIA_TYPE, this.mPlayInfo.mimeType + "");
        create.putParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, Integer.valueOf(this.mPlayInfo.protocol));
        create.putParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, this.mPlayInfo.connectSession);
        create.putParam(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
        create.putParam(ParamsMap.DeviceParams.KEY_RECEIVER_UID, browserInfo.getUid());
        if (!TextUtils.isEmpty(this.mPlayInfo.password)) {
            create.putParam("screencode", this.mPlayInfo.password);
        }
        try {
            if (CastUtil.isSupportLelinkV2(browserInfo)) {
                create.putParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, 5);
                create.putParam("vv", "2");
                create.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, browserInfo.getExtras().get("lelinkport") + "");
            } else {
                create.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, browserInfo.getExtras().get("airplay") + "");
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        create.putParam("ip", browserInfo.getIp());
        String str3 = TAG;
        SourceLog.debug(str3, "play " + create.toString());
        try {
            DramaInfoBean[] dramaInfoBeanArr = this.mPlayInfo.urls;
            if (dramaInfoBeanArr == null || dramaInfoBeanArr.length <= 0) {
                SourceLog.debug(TAG, "play ");
                this.mPushController.push(this.mPlayInfo.getPlayUrl(), create);
                return;
            }
            SourceLog.i(TAG, "setPlayList");
            OutParameter outParameter2 = this.mPlayInfo;
            setPlayListParams(create, outParameter2.urls, outParameter2.period, outParameter2.headLength, outParameter2.tailLength);
            this.mPushController.setPlayList(create);
        } catch (Exception e11) {
            SourceLog.w(TAG, (Throwable) e11);
        }
    }

    public void stop(String str) {
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "stop ignore");
            return;
        }
        iPushController.setConnector((IConnector) null);
        this.mPushController.stopPlay();
        cancelPositionUpdate();
        cancelStateUpdate();
        this.mLastPlayPosition = 0;
        this.mLastPlayDuration = 0;
        ConnectManager.getInstance().getLastConnectBridge().removeOnPassSendCompleteListener(this);
    }

    public void subVolume() {
        super.subVolume();
        if (this.mPushController == null) {
            SourceLog.w(TAG, "subVolume ignore");
            return;
        }
        SourceLog.i(TAG, "subVolume");
        this.mPushController.decreaseVolume();
    }

    public void updatePosition() {
        if (this.mPlayInfo.mimeType != 103) {
            this.isUpdatePosition = true;
            this.mHandler.removeCallbacks(this.mPositionRunnable);
            this.mHandler.post(this.mPositionRunnable);
        }
    }
}
