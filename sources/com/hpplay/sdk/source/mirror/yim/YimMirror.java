package com.hpplay.sdk.source.mirror.yim;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.asyncmanager.AsyncRunnableListener;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.api.MirrorFrameCallback;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.SourceErrorLog;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.cloud.mirror.youme.CloudMirrorImpl;
import com.hpplay.sdk.source.cloud.mirror.youme.OnCloudMirrorListener;
import com.hpplay.sdk.source.cloud.mirror.youme.YimConfigBean;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventIMChannel;
import com.hpplay.sdk.source.protocol.CaptureBridge;
import com.hpplay.sdk.source.utils.ErrorCode;
import com.hpplay.sdk.source.utils.Feature;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class YimMirror {
    private static final int LOW_BITRATE_EXP_FRAME = 17;
    private static final String TAG = "YimMirror";
    private static final int WHAT_REQUEST_FIR = 1;
    /* access modifiers changed from: private */
    public static AtomicBoolean mRequestRoomId = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static volatile String mRoomId;
    private static YimMirror sInstance;
    /* access modifiers changed from: private */
    public boolean isFrozen = false;
    private CloudMirrorImpl mCloudMirror = CloudMirrorImpl.getInstance();
    /* access modifiers changed from: private */
    public ConcurrentLinkedQueue<OnCloudMirrorListener> mCloudMirrorListenerList = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1 || YimMirror.this.mScreenCapture == null) {
                return false;
            }
            YimMirror.this.mScreenCapture.requestKeyFrame();
            return false;
        }
    });
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    /* access modifiers changed from: private */
    public long mRCEventTimestamp = 0;
    /* access modifiers changed from: private */
    public long mRequestFirMark;
    /* access modifiers changed from: private */
    public CaptureBridge mScreenCapture = CaptureBridge.getInstance();
    private OnCloudMirrorListener mYimListener = new OnCloudMirrorListener() {
        public void a(int i10, Object... objArr) {
            SourceLog.i(YimMirror.TAG, " onEventCallback " + i10 + ", mCloudMirrorListenerList :" + YimMirror.this.mCloudMirrorListenerList.size());
            if (i10 == 1) {
                boolean unused = YimMirror.this.isFrozen = false;
            } else if (!(i10 == 2 || i10 == 3)) {
                if (i10 == 500) {
                    try {
                        JSONObject jSONObject = new JSONObject(objArr[0].toString());
                        boolean optBoolean = jSONObject.optBoolean("fir");
                        int optInt = jSONObject.optInt(IjkMediaMeta.IJKM_KEY_BITRATE);
                        int optInt2 = jSONObject.optInt("fps");
                        if (YimMirror.this.mScreenCapture == null) {
                            return;
                        }
                        if (!YimMirror.this.isFrozen) {
                            if (optBoolean) {
                                if (System.currentTimeMillis() - YimMirror.this.mRequestFirMark < 1000) {
                                    YimMirror.this.mScreenCapture.requestKeyFrame();
                                    long unused2 = YimMirror.this.mRequestFirMark = System.currentTimeMillis();
                                } else {
                                    SourceLog.i(YimMirror.TAG, "++++++++++++++++++++++++++++===delay request key f");
                                    long unused3 = YimMirror.this.mRequestFirMark = System.currentTimeMillis();
                                    YimMirror.this.mHandler.removeMessages(1);
                                    YimMirror.this.mHandler.sendEmptyMessageDelayed(1, 1000);
                                }
                            }
                            if (optInt > 0) {
                                YimMirror.this.mScreenCapture.setBitRate(4, optInt * 1024);
                            }
                            if (optInt2 > 0) {
                                if (YimMirror.this.mScreenCapture.getBitrate() / 1024 <= 1000) {
                                    YimMirror.this.mScreenCapture.setFrameRate(4, 17);
                                } else {
                                    YimMirror.this.mScreenCapture.setFrameRate(4, optInt2);
                                }
                            }
                            try {
                                if (jSONObject.getBoolean("pause_encode")) {
                                    SourceLog.i(YimMirror.TAG, "=============pause encoder======");
                                    YimMirror.this.mScreenCapture.pauseEncode(false);
                                    return;
                                }
                                SourceLog.i(YimMirror.TAG, "=============resume encoder======");
                                YimMirror.this.mScreenCapture.resumeEncode();
                                return;
                            } catch (JSONException unused4) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Exception e10) {
                        SourceLog.w(YimMirror.TAG, "EVENT_VIDEO_ENCODE_PARAM_REPORT :" + e10);
                        return;
                    }
                } else if (i10 == 10000) {
                    try {
                        long longValue = objArr[1].longValue();
                        if (longValue >= YimMirror.this.mRCEventTimestamp) {
                            long unused5 = YimMirror.this.mRCEventTimestamp = longValue;
                            SinkTouchEventIMChannel.getInstance().onReceiveYouMeTouchEvent(objArr[0]);
                            return;
                        }
                        return;
                    } catch (Exception e11) {
                        SourceLog.w(YimMirror.TAG, (Throwable) e11);
                        return;
                    }
                } else {
                    return;
                }
            }
            Iterator it = YimMirror.this.mCloudMirrorListenerList.iterator();
            while (it.hasNext()) {
                ((OnCloudMirrorListener) it.next()).onEventCallback(i10, objArr);
            }
        }
    };

    private YimMirror() {
    }

    public static synchronized YimMirror getInstance() {
        YimMirror yimMirror;
        synchronized (YimMirror.class) {
            synchronized (YimMirror.class) {
                if (sInstance == null) {
                    sInstance = new YimMirror();
                }
            }
            yimMirror = sInstance;
        }
        return yimMirror;
    }

    /* access modifiers changed from: private */
    public void notifyPushMirror(boolean z10) {
        synchronized (this.mLock) {
            if (!z10) {
                mRequestRoomId.set(false);
            }
            this.mLock.notifyAll();
        }
    }

    /* access modifiers changed from: private */
    public void requestPushMirrorAndJoin(BrowserInfo browserInfo, OutParameter outParameter, int i10, final a aVar) {
        requestPushMirror(browserInfo, outParameter, i10, new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                String str;
                AsyncHttpParameter.Out out = asyncHttpParameter.out;
                if (out == null || out.resultType == 2 || TextUtils.isEmpty(out.result)) {
                    SourceLog.i(YimMirror.TAG, "requestPushMirrorAndJoin error");
                    YimMirror.this.notifyPushMirror(false);
                    return;
                }
                SourceLog.i(YimMirror.TAG, "requestPushMirrorAndJoin result: " + asyncHttpParameter.out.result);
                String str2 = "";
                int i10 = -1;
                try {
                    JSONObject jSONObject = new JSONObject(asyncHttpParameter.out.result);
                    i10 = jSONObject.optInt(Constant.KEY_STATUS);
                    if (i10 == 200) {
                        str2 = jSONObject.getJSONObject("data").optString("roomid");
                        String unused = YimMirror.mRoomId = str2;
                        YimMirror.this.notifyPushMirror(true);
                    } else {
                        YimMirror.this.notifyPushMirror(false);
                    }
                } catch (Exception e10) {
                    SourceLog.w(YimMirror.TAG, (Throwable) e10);
                    YimMirror.this.notifyPushMirror(false);
                }
                if (i10 != 200) {
                    str = SourceErrorLog.getInstance().getErrorReportExtra(ErrorCode.MIRROR_ERROR_YIM_PUSH_FAIL, asyncHttpParameter.out.result);
                } else {
                    str = null;
                }
                a aVar = aVar;
                if (aVar != null) {
                    aVar.result(i10, str2, str);
                }
            }
        }, aVar);
    }

    private void waitRoomIdInMultiCast(BrowserInfo browserInfo, OutParameter outParameter, int i10, a aVar) {
        final BrowserInfo browserInfo2 = browserInfo;
        final OutParameter outParameter2 = outParameter;
        final int i11 = i10;
        final a aVar2 = aVar;
        AsyncManager.getInstance().exeRunnable(new Runnable() {
            public void run() {
                synchronized (YimMirror.this.mLock) {
                    if (TextUtils.isEmpty(YimMirror.mRoomId) && YimMirror.mRequestRoomId.get()) {
                        try {
                            YimMirror.this.mLock.wait();
                        } catch (InterruptedException e10) {
                            SourceLog.w(YimMirror.TAG, "waitRoomIdInMultiCast error: " + e10);
                        }
                    }
                    SourceLog.i(YimMirror.TAG, "waitRoomIdInMultiCast: " + YimMirror.mRoomId + " / " + YimMirror.mRequestRoomId.get());
                    if (TextUtils.isEmpty(YimMirror.mRoomId)) {
                        YimMirror.this.requestPushMirrorAndJoin(browserInfo2, outParameter2, i11, aVar2);
                    } else {
                        YimMirror.this.requestPushMirror(browserInfo2, outParameter2, i11, (AsyncHttpRequestListener) null, aVar2);
                    }
                }
            }
        }, (AsyncRunnableListener) null);
    }

    public void addCloudMirrorListener(OnCloudMirrorListener onCloudMirrorListener) {
        this.mCloudMirrorListenerList.add(onCloudMirrorListener);
    }

    public void frozen(boolean z10) {
        this.isFrozen = z10;
    }

    public void initSink(Context context) {
        this.mCloudMirror.initSink(context);
    }

    public void initSource(Context context) {
        this.mCloudMirror.initSource(context);
    }

    public boolean isInitOK() {
        return this.mCloudMirror.isInitOK();
    }

    public boolean login(YimConfigBean yimConfigBean) {
        this.mCloudMirror.setCloudMirrorListener(this.mYimListener);
        return this.mCloudMirror.login(yimConfigBean);
    }

    public void maskVideoByUserId(String str, boolean z10) {
        this.mCloudMirror.maskVideoByUserId(str, z10);
    }

    public void play(BrowserInfo browserInfo, OutParameter outParameter, int i10, a aVar) {
        if (!outParameter.isMultiCast || !mRequestRoomId.get()) {
            requestPushMirrorAndJoin(browserInfo, outParameter, i10, aVar);
        } else if (!TextUtils.isEmpty(mRoomId)) {
            requestPushMirror(browserInfo, outParameter, i10, (AsyncHttpRequestListener) null, aVar);
        } else {
            waitRoomIdInMultiCast(browserInfo, outParameter, i10, aVar);
        }
    }

    public void release() {
        this.mCloudMirror.release();
    }

    public void removeCloudMirrorListener(OnCloudMirrorListener onCloudMirrorListener) {
        this.mCloudMirrorListenerList.remove(onCloudMirrorListener);
    }

    public void requestPushMirror(BrowserInfo browserInfo, OutParameter outParameter, int i10, AsyncHttpRequestListener asyncHttpRequestListener, final a aVar) {
        String str;
        mRequestRoomId.set(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            jSONObject.put("u", browserInfo.getUid());
            jSONObject.put("ra", browserInfo.getExtras().get("a"));
            jSONObject.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
            jSONObject.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BrowserInfo.KEY_POL, Feature.cloudMirrorSupportProtocol());
            jSONObject2.put("server", "");
            jSONObject2.put("suid", Session.getInstance().getUID());
            jSONObject2.put("timeout", AgooConstants.ACK_REMOVE_PACKAGE);
            jSONObject2.put("sdkv", "4.12.14");
            jSONObject2.put("app_id", Session.getInstance().appKey);
            jSONObject2.put("sa", AgooConstants.ACK_PACK_ERROR);
            jSONObject2.put("sid", outParameter.connectSession);
            jSONObject2.put("uri", outParameter.urlID);
            try {
                String str2 = Preference.getInstance().get(Constant.KEY_USERNAME);
                if (TextUtils.isEmpty(str2)) {
                    str = URLEncoder.encode(DeviceUtil.getBluetoothName());
                } else {
                    str = URLEncoder.encode(str2);
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                str = "";
            }
            jSONObject2.put("username", str);
            jSONObject2.put(com.umeng.ccg.a.f14517j, i10);
            if (i10 == 1) {
                SourceLog.i(TAG, "requestPushMirror roomid:" + mRoomId);
                jSONObject2.put("roomid", mRoomId);
            }
            jSONObject2.put("rc_channel", 1);
            jSONObject.put("content", "020002ff," + jSONObject2.toString());
            jSONObject.put(BrowserInfo.KEY_VER, Constant.DATAREPORT_PROTOCOL_VER);
            SourceLog.i(TAG, "requestPushMirror " + CloudAPI.sPushMirror + " / " + jSONObject.toString());
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sPushMirror, jSONObject.toString());
            AsyncHttpParameter.In in = asyncHttpParameter.in;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            in.connectTimeout = (int) timeUnit.toMillis(10);
            asyncHttpParameter.in.readTimeout = (int) timeUnit.toMillis(10);
            asyncHttpParameter.in.requestMethod = 1;
            if (asyncHttpRequestListener != null) {
                AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, asyncHttpRequestListener);
            } else {
                AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
                    public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                        AsyncHttpParameter.Out out = asyncHttpParameter.out;
                        int i10 = -1;
                        if (out == null || out.resultType == 2 || TextUtils.isEmpty(out.result)) {
                            a aVar = aVar;
                            if (aVar != null) {
                                aVar.result(-1, (String) null, (String) null);
                                return;
                            }
                            return;
                        }
                        SourceLog.i(YimMirror.TAG, "requestPushMirror result: " + asyncHttpParameter.out.result);
                        try {
                            i10 = new JSONObject(asyncHttpParameter.out.result).optInt(Constant.KEY_STATUS);
                            if (i10 == 200) {
                                return;
                            }
                        } catch (Exception e10) {
                            SourceLog.w(YimMirror.TAG, (Throwable) e10);
                        }
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.result(i10, (String) null, SourceErrorLog.getInstance().getErrorReportExtra(ErrorCode.MIRROR_ERROR_YIM_PUSH_FAIL, asyncHttpParameter.out.result));
                        }
                    }
                });
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, (Throwable) e11);
            notifyPushMirror(false);
            if (aVar != null) {
                aVar.result(-1, (String) null, (String) null);
            }
        }
    }

    public void resetMultiCast() {
        mRoomId = null;
        mRequestRoomId.set(false);
    }

    public void sendAudio(byte[] bArr, int i10, long j10, int i11) {
        this.mCloudMirror.sendAudio(bArr, i10, j10, i11);
    }

    public void sendCameraRGBData(byte[] bArr, int i10, int i11, int i12, long j10, int i13) {
        this.mCloudMirror.sendCameraRGBData(bArr, i10, i11, i12, j10, i13);
    }

    public void sendH264Data(ByteBuffer byteBuffer, int i10, int i11, long j10) {
        this.mCloudMirror.sendH264Data(i10, i11, j10, new ByteBuffer[]{byteBuffer});
    }

    public void sendRGBData(byte[] bArr, int i10, int i11, int i12, long j10, int i13) {
        this.mCloudMirror.sendRGBData(bArr, i10, i11, i12, j10, i13);
    }

    public void sendTextureID(int i10, int i11, int i12, int i13, long j10, int i14) {
        this.mCloudMirror.sendTextureID(i10, i11, i12, i13, j10, i14);
    }

    public void setVideoFrameCallback(MirrorFrameCallback mirrorFrameCallback) {
        this.mCloudMirror.setVideoFrameCallback(mirrorFrameCallback);
    }

    public void stop() {
        this.mCloudMirror.stop();
        this.mCloudMirror.setCloudMirrorListener((OnCloudMirrorListener) null);
        resetMultiCast();
    }

    public void sendH264Data(byte[] bArr, int i10, int i11, long j10) {
        this.mCloudMirror.sendH264Data(i10, i11, j10, bArr);
    }
}
