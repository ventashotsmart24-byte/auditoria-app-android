package com.hpplay.sdk.source.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.OptionCentral;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.cloud.mirror.youme.OnCloudMirrorListener;
import com.hpplay.sdk.source.cloud.mirror.youme.YimConfigBean;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.mirror.yim.YimMirror;
import com.hpplay.sdk.source.mirror.yim.a;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.pass.bean.BaseBean;
import com.hpplay.sdk.source.pass.bean.MirrorStateBean;
import com.hpplay.sdk.source.pass.bean.SinkKeyEventRegisterBean;
import com.hpplay.sdk.source.pass.bean.SinkTouchEventRegisterBean;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventMonitor;
import com.hpplay.sdk.source.player.ICastPlayer;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.connect.AbsConnectBridge;
import com.hpplay.sdk.source.protocol.connect.OnPlayStateListener;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class YimBridge extends AbsBridge {
    private static final int AUDIO_SAMPLE_RATE = 48000;
    private static final int CLOUD_MIRROR_DEFAULT_BITRATE = 1500000;
    public static final int CLOUD_MIRROR_SINK_START = 1;
    public static final int CLOUD_MIRROR_SINK_WAIT = 0;
    private static final int LOW_BITRATE_EXP_FRAME = 17;
    private static final String TAG = "YimBridge";
    private static final int WHAT_CAPTURE = 1;
    private static final int WHAT_REQUEST_FIR = 2;
    /* access modifiers changed from: private */
    public int captureHeight = 720;
    /* access modifiers changed from: private */
    public int captureWidth = 1280;
    private boolean hasRegisterSinkTouchEvent = false;
    /* access modifiers changed from: private */
    public boolean isCallPrepared = false;
    private boolean isChangeExpandView = false;
    /* access modifiers changed from: private */
    public boolean isFrozen = false;
    /* access modifiers changed from: private */
    public YimConfigBean mBean = new YimConfigBean();
    private final AsyncHttpRequestListener mChangeListenerHttpParameter = new AsyncHttpRequestListener() {
        public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
            YimBridge.access$1408(YimBridge.this);
            if (asyncHttpParameter.out == null) {
                SourceLog.i(YimBridge.TAG, "notify change  onRequestResult null  mNotifyCount " + YimBridge.this.mNotifyCount);
                if (YimBridge.this.mNotifyCount < 5) {
                    YimBridge.this.delayNotify(1000);
                } else if (YimBridge.this.mSinkChangeListener != null) {
                    YimBridge.this.mSinkChangeListener.onChange(0);
                }
            } else {
                SourceLog.i(YimBridge.TAG, "notify change  onRequestResult: " + asyncHttpParameter.out.result + "  mNotifyCount " + YimBridge.this.mNotifyCount);
                AsyncHttpParameter.Out out = asyncHttpParameter.out;
                if (out.resultType == 2 || TextUtils.isEmpty(out.result)) {
                    if (YimBridge.this.mNotifyCount < 5) {
                        YimBridge.this.delayNotify(1000);
                    } else if (YimBridge.this.mSinkChangeListener != null) {
                        YimBridge.this.mSinkChangeListener.onChange(0);
                    }
                } else if (YimBridge.this.mSinkChangeListener != null) {
                    YimBridge.this.mSinkChangeListener.onChange(1);
                }
            }
        }
    };
    private DelayNotifySinkTask mDelayNotifySinkTask;
    private int mFrameCount = -1;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2 || YimBridge.this.mScreenCapture == null) {
                    return false;
                }
                YimBridge.this.mScreenCapture.requestKeyFrame();
                return false;
            } else if (YimBridge.this.mScreenCapture == null) {
                return false;
            } else {
                YimBridge yimBridge = YimBridge.this;
                if (!yimBridge.mPlayInfo.isGroup) {
                    yimBridge.setExternalMirrorData();
                }
                CaptureBridge access$000 = YimBridge.this.mScreenCapture;
                YimBridge yimBridge2 = YimBridge.this;
                access$000.onSinkPrepared(4, yimBridge2, yimBridge2.captureWidth, YimBridge.this.captureHeight, 30, YimBridge.CLOUD_MIRROR_DEFAULT_BITRATE, ParamsMap.MirrorParams.ENCODE_TYPE_H264);
                return false;
            }
        }
    });
    private BrowserInfo mIMInfo;
    /* access modifiers changed from: private */
    public String mLocalConnectionIP;
    /* access modifiers changed from: private */
    public int mLocalConnectionPort;
    /* access modifiers changed from: private */
    public int mNotifyCount;
    private long mPrintFrameTime = 0;
    private final a mPushMirrorListener = new a() {
        public void result(int i10, String str, String str2) {
            SourceLog.i(YimBridge.TAG, "IPushMirrorListener, " + i10);
            if (i10 == 200) {
                YimBridge yimBridge = YimBridge.this;
                yimBridge.mPlayInfo.roomID = str;
                yimBridge.mBean.userID = CreateUtil.createYimUserID();
                YimBridge.this.mBean.roomID = str;
                YimBridge.this.mBean.inputWidth = YimBridge.this.captureWidth;
                YimBridge.this.mBean.inputHeight = YimBridge.this.captureHeight;
                YimBridge.this.mBean.sampleRate = 48000;
                YimBridge.this.mBean.ip = YimBridge.this.mLocalConnectionIP;
                YimBridge.this.mBean.port = YimBridge.this.mLocalConnectionPort;
                YimMirror.getInstance().initSource(YimBridge.this.mContext);
                YimMirror.getInstance().login(YimBridge.this.mBean);
                SourceDataReport.getInstance().onGetRoomSuccess(YimBridge.this.mPlayInfo, str);
                OnLoadingListener onLoadingListener = YimBridge.this.mLoadingListener;
                if (onLoadingListener != null) {
                    onLoadingListener.onLoading((ICastPlayer) null, (String) null);
                }
            } else if (i10 == -1) {
                YimBridge.this.callbackError(211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, str2);
            } else {
                if (i10 == 410 || i10 == 411) {
                    OnErrorListener onErrorListener = YimBridge.this.mErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError((ICastPlayer) null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_SINK_CLOUD_UNSUPPORTED, str2);
                    }
                } else if (i10 == 403) {
                    OnErrorListener onErrorListener2 = YimBridge.this.mErrorListener;
                    if (onErrorListener2 != null) {
                        onErrorListener2.onError((ICastPlayer) null, 211000, 210004, str2);
                    }
                } else {
                    SourceLog.w(YimBridge.TAG, "onError " + i10);
                    OnErrorListener onErrorListener3 = YimBridge.this.mErrorListener;
                    if (onErrorListener3 != null) {
                        onErrorListener3.onError((ICastPlayer) null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, str2);
                    }
                }
                SourceDataReport.getInstance().onGetRoomFailed(YimBridge.this.mPlayInfo, (String) null);
            }
        }
    };
    /* access modifiers changed from: private */
    public long mRequestFirMark;
    /* access modifiers changed from: private */
    public CaptureBridge mScreenCapture;
    /* access modifiers changed from: private */
    public IOnSinkChangeListener mSinkChangeListener;
    private final OnPlayStateListener mStateListener = new OnPlayStateListener() {
        public void onError(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                OnErrorListener onErrorListener = YimBridge.this.mErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError((ICastPlayer) null, 210010, 210011, (String) null);
                    return;
                }
                return;
            }
            SourceLog.w(YimBridge.TAG, "onError ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
        }

        public void onPause(String str) {
            if (TextUtils.isEmpty(str) || TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                OnStateChangeListener onStateChangeListener = YimBridge.this.mStateChangeListener;
                if (onStateChangeListener != null) {
                    onStateChangeListener.onStateChanged((ICastPlayer) null, 4);
                    return;
                }
                return;
            }
            SourceLog.w(YimBridge.TAG, "onPause ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
        }

        public void onPlaying(String str, int i10, int i11) {
            if (TextUtils.isEmpty(str) || TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                OnInfoListener onInfoListener = YimBridge.this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo((ICastPlayer) null, 100, i10, i11);
                    return;
                }
                return;
            }
            SourceLog.w(YimBridge.TAG, "onPlaying ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
        }

        public void onStart(String str) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                SourceLog.w(YimBridge.TAG, "onStart ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
            } else if (!YimBridge.this.isCallPrepared) {
                boolean unused = YimBridge.this.isCallPrepared = true;
                OnPreparedListener onPreparedListener = YimBridge.this.mPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared((ICastPlayer) null);
                }
            } else {
                OnStateChangeListener onStateChangeListener = YimBridge.this.mStateChangeListener;
                if (onStateChangeListener != null) {
                    onStateChangeListener.onStateChanged((ICastPlayer) null, 3);
                }
            }
        }

        public void onStop(String str, int i10) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                SourceLog.w(YimBridge.TAG, "onStop ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
            } else if (i10 == 0) {
                OnCompletionListener onCompletionListener = YimBridge.this.mCompletionListener;
                if (onCompletionListener != null) {
                    onCompletionListener.onComplete((ICastPlayer) null);
                }
            } else {
                SourceLog.i(YimBridge.TAG, " STOP_NORMAL stop ");
                YimBridge yimBridge = YimBridge.this;
                if (yimBridge.mPlayInfo != null && !yimBridge.isFrozen) {
                    if (YimBridge.this.mStopListener != null) {
                        StopInfo stopInfo = new StopInfo();
                        stopInfo.type = 1;
                        YimBridge.this.mStopListener.onStop((ICastPlayer) null, stopInfo);
                    }
                    YimBridge yimBridge2 = YimBridge.this;
                    yimBridge2.stop(yimBridge2.mPlayInfo.getKey());
                }
            }
        }
    };
    private Timer mTimer = new Timer();
    /* access modifiers changed from: private */
    public OnCloudMirrorListener mYimListener = new OnCloudMirrorListener() {
        public void onEventCallback(int i10, Object... objArr) {
            boolean z10;
            SourceLog.i(YimBridge.TAG, " onEventCallback " + i10);
            if (i10 == 1) {
                int parseInt = Integer.parseInt(objArr[0].toString());
                if (parseInt == -1) {
                    SourceLog.w(YimBridge.TAG, "login failed");
                    YimBridge.this.callbackError(211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, (String) null);
                }
                SourceDataReport instance = SourceDataReport.getInstance();
                OutParameter outParameter = YimBridge.this.mPlayInfo;
                if (parseInt == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                instance.onYimInit(IMediaPlayer.MEDIA_INFO_BUFFERING_START, outParameter, z10, (String) null, (String) null);
            } else if (i10 == 2) {
                int parseInt2 = Integer.parseInt(objArr[0].toString());
                if (parseInt2 == -1) {
                    SourceLog.w(YimBridge.TAG, "join room failed");
                    YimBridge.this.callbackError(211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, (String) null);
                } else if (parseInt2 == 1 && YimBridge.this.mHandler != null) {
                    YimBridge.this.mHandler.obtainMessage(1).sendToTarget();
                }
            } else if (i10 == 3) {
                int parseInt3 = Integer.parseInt(objArr[0].toString());
                SourceLog.i(YimBridge.TAG, "EVENT_QUIT: " + parseInt3);
                if (parseInt3 == 3) {
                    YimBridge.this.stopAll();
                } else if (parseInt3 != 4) {
                    YimBridge.this.stopAll();
                } else if (YimBridge.this.isCurrentSink(objArr[1].toString())) {
                    YimBridge yimBridge = YimBridge.this;
                    yimBridge.stop(yimBridge.mPlayInfo.getKey());
                    YimMirror.getInstance().removeCloudMirrorListener(YimBridge.this.mYimListener);
                } else {
                    return;
                }
                StopInfo stopInfo = new StopInfo();
                if (parseInt3 == 2) {
                    stopInfo.type = 2;
                } else {
                    stopInfo.type = 1;
                }
                OnStopListener onStopListener = YimBridge.this.mStopListener;
                if (onStopListener != null) {
                    onStopListener.onStop((ICastPlayer) null, stopInfo);
                }
            } else if (i10 == 500) {
                try {
                    JSONObject jSONObject = new JSONObject(objArr[0].toString());
                    boolean optBoolean = jSONObject.optBoolean("fir");
                    int optInt = jSONObject.optInt(IjkMediaMeta.IJKM_KEY_BITRATE);
                    int optInt2 = jSONObject.optInt("fps");
                    if (YimBridge.this.mScreenCapture == null) {
                        return;
                    }
                    if (!YimBridge.this.isFrozen) {
                        if (optBoolean) {
                            if (System.currentTimeMillis() - YimBridge.this.mRequestFirMark < 1000) {
                                YimBridge.this.mScreenCapture.requestKeyFrame();
                                long unused = YimBridge.this.mRequestFirMark = System.currentTimeMillis();
                            } else {
                                SourceLog.i(YimBridge.TAG, "++++++++++++++++++++++++++++===delay request key f");
                                long unused2 = YimBridge.this.mRequestFirMark = System.currentTimeMillis();
                                YimBridge.this.mHandler.removeMessages(2);
                                YimBridge.this.mHandler.sendEmptyMessageDelayed(2, 1000);
                            }
                        }
                        if (optInt > 0) {
                            YimBridge.this.mScreenCapture.setBitRate(4, optInt * 1024);
                        }
                        if (optInt2 > 0) {
                            if (YimBridge.this.mScreenCapture.getBitrate() / 1024 <= 1000) {
                                YimBridge.this.mScreenCapture.setFrameRate(4, 17);
                            } else {
                                YimBridge.this.mScreenCapture.setFrameRate(4, optInt2);
                            }
                        }
                        try {
                            if (jSONObject.getBoolean("pause_encode")) {
                                SourceLog.i(YimBridge.TAG, "=============pause encoder======");
                                YimBridge.this.mScreenCapture.pauseEncode(false);
                                return;
                            }
                            SourceLog.i(YimBridge.TAG, "=============resume encoder======");
                            YimBridge.this.mScreenCapture.resumeEncode();
                        } catch (JSONException e10) {
                            SourceLog.w(YimBridge.TAG, (Throwable) e10);
                        }
                    }
                } catch (Exception e11) {
                    SourceLog.w(YimBridge.TAG, "EVENT_VIDEO_ENCODE_PARAM_REPORT :" + e11);
                }
            }
        }
    };
    private final AbsConnectBridge.OnPassReceivedListener onPassReceivedListener = new AbsConnectBridge.OnPassReceivedListener() {
        public void onPassReversed(int i10, BaseBean baseBean) {
            if (i10 != 26) {
                return;
            }
            if (((MirrorStateBean) baseBean).action == 0) {
                YimBridge yimBridge = YimBridge.this;
                yimBridge.pause(yimBridge.mPlayInfo.getKey());
                return;
            }
            YimBridge yimBridge2 = YimBridge.this;
            yimBridge2.resume(yimBridge2.mPlayInfo.getKey());
        }
    };

    public class DelayNotifySinkTask extends TimerTask {
        public DelayNotifySinkTask() {
        }

        public void run() {
            SourceLog.i(YimBridge.TAG, "start mDelayNotifySinkTask ");
            YimBridge yimBridge = YimBridge.this;
            yimBridge.notifySinkChange(yimBridge.mSinkChangeListener);
        }
    }

    public interface IOnSinkChangeListener {
        public static final int FAILED = 0;
        public static final int SUCCESS = 1;

        void onChange(int i10);
    }

    public YimBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        String str;
        BrowserInfo browserInfo = CastUtil.getBrowserInfo(outParameter.serviceInfo, 4);
        if (browserInfo == null) {
            SourceLog.w(TAG, "has no im info, never should be here");
            return;
        }
        this.mIMInfo = browserInfo;
        this.mLocalConnectionIP = browserInfo.getIp();
        BrowserInfo browserInfo2 = outParameter.serviceInfo.getBrowserInfos().get(1);
        if (browserInfo2 != null) {
            str = browserInfo2.getExtras().get("mirror");
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mLocalConnectionPort = Integer.parseInt(str);
        } else {
            this.mLocalConnectionPort = 7100;
        }
        CaptureBridge instance = CaptureBridge.getInstance();
        this.mScreenCapture = instance;
        instance.init();
        this.mScreenCapture.setPlayInfo(outParameter);
    }

    public static /* synthetic */ int access$1408(YimBridge yimBridge) {
        int i10 = yimBridge.mNotifyCount;
        yimBridge.mNotifyCount = i10 + 1;
        return i10;
    }

    /* access modifiers changed from: private */
    public void callbackError(int i10, int i11, String str) {
        OnErrorListener onErrorListener = this.mErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError((ICastPlayer) null, i10, i11, str);
        }
    }

    /* access modifiers changed from: private */
    public void delayNotify(long j10) {
        stopTask();
        DelayNotifySinkTask delayNotifySinkTask = new DelayNotifySinkTask();
        this.mDelayNotifySinkTask = delayNotifySinkTask;
        this.mTimer.schedule(delayNotifySinkTask, j10);
    }

    /* access modifiers changed from: private */
    public void doRegisterSinkTouchEvent() {
        SourceLog.i(TAG, "doRegisterSinkTouchEvent: hasRegisterSinkTouchEvent： " + this.hasRegisterSinkTouchEvent);
        if (!this.hasRegisterSinkTouchEvent) {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    SinkTouchEventMonitor instance = SinkTouchEventMonitor.getInstance();
                    YimBridge yimBridge = YimBridge.this;
                    instance.startMonitor(yimBridge.mContext, yimBridge.mPlayInfo.session, true);
                }
            }, 1000);
            PassSender.getInstance().sendSinkTouchRegister(SinkTouchEventRegisterBean.createRegisterBean().toJson(), this.mPlayInfo.session);
            this.hasRegisterSinkTouchEvent = true;
        }
    }

    /* access modifiers changed from: private */
    public void doUnregisterSinkTouchEvent() {
        SourceLog.i(TAG, "doUnregisterSinkTouchEvent: ");
        this.hasRegisterSinkTouchEvent = false;
        SinkTouchEventMonitor.getInstance().stopMonitor();
        PassSender.getInstance().sendSinkTouchRegister(SinkTouchEventRegisterBean.createUnregisterBean().toJson(), this.mPlayInfo.session);
    }

    private int getScene() {
        if (this.mPlayInfo.connectProtocol == 6) {
            return 0;
        }
        return 1;
    }

    private void initExternalAudioSource() {
        OptionCentral.setOnPCMUpdateListener(new OptionCentral.OnPCMUpdateListener() {
            public void onAudioUpdate(byte[] bArr, AudioFrameBean audioFrameBean) {
                int i10;
                SourceLog.w(YimBridge.TAG, "onAudioUpdate " + bArr.length + "  " + audioFrameBean.channel + "  / " + audioFrameBean.sampleRate);
                if (audioFrameBean.channel == 16) {
                    i10 = 1;
                } else {
                    i10 = 2;
                }
                YimMirror.getInstance().sendAudio(bArr, bArr.length, System.currentTimeMillis(), i10);
            }
        });
    }

    private void initExternalVideo() {
        OptionCentral.setOnVideoUpdateListener(new OptionCentral.OnVideoUpdateListener() {
            public void onVideoUpdate(byte[] bArr, VideoFrameBean videoFrameBean) {
                VideoFrameBean videoFrameBean2 = videoFrameBean;
                int i10 = videoFrameBean2.type;
                if (i10 == 1) {
                    YimMirror.getInstance().sendH264Data(ByteBuffer.wrap(bArr), videoFrameBean2.width, videoFrameBean2.height, videoFrameBean2.pts);
                } else if (i10 == 2) {
                    YimMirror.getInstance().sendRGBData(bArr, videoFrameBean2.width, videoFrameBean2.height, 0, videoFrameBean2.pts / 1000, 1);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean isCurrentSink(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String substring = str.substring(str.lastIndexOf("_") + 1);
            SourceLog.i(TAG, "isCurrentSink, " + substring);
            return TextUtils.equals(substring, this.mPlayInfo.serviceInfo.getUid());
        } catch (Exception unused) {
            return false;
        }
    }

    private void monitorExternalAudio() {
        OptionCentral.setOnExternalAudioStateChangedListener(new OptionCentral.OnExternalAudioStateChangedListener() {
            public void onStateChanged(boolean z10) {
                int i10;
                SourceLog.i(YimBridge.TAG, "onStateChanged: isEnable: " + z10);
                if (z10) {
                    i10 = 1;
                } else {
                    i10 = CaptureBridge.getInstance().getAudioCaptureType(YimBridge.this.mPlayInfo);
                }
                if (YimBridge.this.mScreenCapture != null) {
                    YimBridge.this.mScreenCapture.setAudioSwitch(i10, 0, YimBridge.this.mPlayInfo.requestAudioFocus, true);
                }
            }
        });
    }

    private void registerSinkKeyEvent() {
        SourceLog.i(TAG, "registerSinkKeyEvent isRegister:" + OptionCentral.isRegisterSinkKeyEvent());
        if (OptionCentral.isRegisterSinkKeyEvent()) {
            PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createRegisterBean().toJson(), this.mPlayInfo.session);
        }
        OptionCentral.setOnSinkKeyEventRegisterListener(new OptionCentral.OnSinkKeyEventRegisterListener() {
            public void onRegister() {
                PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createRegisterBean().toJson(), YimBridge.this.mPlayInfo.session);
            }

            public void onUnregister() {
                PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createUnregisterBean().toJson(), YimBridge.this.mPlayInfo.session);
            }
        });
    }

    private void registerSinkTouchEvent() {
        if (OptionCentral.isRegistSinkTouchEvent()) {
            doRegisterSinkTouchEvent();
        }
        OptionCentral.setOnSinkTouchEventRegisterListener(new OptionCentral.OnSinkTouchEventRegisterListener() {
            public void onRegister() {
                SourceLog.i(YimBridge.TAG, "onRegister: ");
                YimBridge.this.doRegisterSinkTouchEvent();
            }

            public void onUnregister() {
                YimBridge.this.doUnregisterSinkTouchEvent();
            }
        });
    }

    private void sendNoneAudioFrame() {
        if (CaptureBridge.getInstance().getAudioSwitch() == 0) {
            sendAudioData(new byte[2048], 0, 2048);
        }
    }

    /* access modifiers changed from: private */
    public void stopAll() {
        SourceLog.i(TAG, "stopAll");
        stop();
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge != null) {
            captureBridge.release();
        }
        YimMirror.getInstance().stop();
        YimMirror.getInstance().removeCloudMirrorListener(this.mYimListener);
    }

    public void frozen(boolean z10) {
        super.frozen(z10);
        SourceLog.i(TAG, "+++++++++++++++++++++++ frozen " + z10);
        this.isFrozen = z10;
        YimMirror.getInstance().frozen(z10);
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void notifySinkChange(IOnSinkChangeListener iOnSinkChangeListener) {
        if (!this.isFrozen) {
            SinkTouchEventMonitor.getInstance().createIMMonitorChannel();
            SourceLog.i(TAG, " start notify sink Change");
            this.mNotifyCount = 0;
            this.mSinkChangeListener = iOnSinkChangeListener;
            YimMirror.getInstance().requestPushMirror(this.mIMInfo, this.mPlayInfo, 1, this.mChangeListenerHttpParameter, (a) null);
        }
    }

    public void onCaptureStart(int i10) {
        SourceLog.i(TAG, "onCaptureStart,isCallPrepared " + this.isCallPrepared + ",isFrozen " + this.isFrozen);
        if (!this.isFrozen) {
            if (!this.isCallPrepared) {
                this.isCallPrepared = true;
                OnPreparedListener onPreparedListener = this.mPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared((ICastPlayer) null);
                }
            } else {
                OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
                if (onStateChangeListener != null) {
                    onStateChangeListener.onStateChanged((ICastPlayer) null, 3);
                }
            }
            SinkTouchEventMonitor.getInstance().createIMMonitorChannel();
        }
    }

    public void onCaptureStop(int i10) {
    }

    public void onInfo(int i10, String str) {
        if (i10 == 10 || i10 == 120105112) {
            super.onInfo(i10, str);
            return;
        }
        SourceLog.i(TAG, "Capture onInfo " + i10 + Operator.Operation.DIVISION + str);
        if (LelinkSdkManager.getInstance().getRetryMirrorOnce().get()) {
            LelinkSdkManager.getInstance().getRetryMirrorOnce().set(false);
            SourceLog.i(TAG, "Capture onInfo retried.");
            return;
        }
        LelinkSdkManager.getInstance().getRetryMirrorOnce().set(true);
    }

    public void pause(String str) {
        if (this.mScreenCapture != null) {
            SourceLog.i(TAG, "pause");
            PassSender.getInstance().sendMirrorState(MirrorStateBean.createPauseBean(this.mPlayInfo.urlID).toJson(), this.mPlayInfo.session);
            this.mScreenCapture.pauseEncode(true);
            OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
            if (onStateChangeListener != null) {
                onStateChangeListener.onStateChanged((ICastPlayer) null, 4);
            }
        }
    }

    public void play(String str) {
        boolean z10;
        SourceLog.i(TAG, "play " + str);
        boolean z11 = false;
        this.isCallPrepared = false;
        PublicCastClient.getInstance().setOnPlayStateListener(this.mStateListener);
        ConnectManager.getInstance().getLastConnectBridge().addOnPassReceivedListener(this, this.onPassReceivedListener);
        int i10 = Preference.getInstance().get(Constant.KEY_CLOUD_MIRROR_WIDTH, 0);
        int i11 = Preference.getInstance().get(Constant.KEY_CLOUD_MIRROR_HEIGHT, 0);
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i11 > 0) {
            z11 = true;
        }
        if (z11 && z10) {
            this.captureWidth = i10;
            this.captureHeight = i11;
        }
        ConnectManager.getInstance().getLastConnectBridge().addOnPassReceivedListener(this, this.onPassReceivedListener);
        YimMirror.getInstance().addCloudMirrorListener(this.mYimListener);
        YimMirror.getInstance().play(this.mIMInfo, this.mPlayInfo, getScene(), this.mPushMirrorListener);
    }

    public void release() {
        SourceLog.i(TAG, "release");
        PublicCastClient.getInstance().setOnPlayStateListener((OnPlayStateListener) null);
    }

    public void resume(String str) {
        if (this.mScreenCapture != null) {
            SourceLog.i(TAG, "resume");
            PassSender.getInstance().sendMirrorState(MirrorStateBean.createResumeBean(this.mPlayInfo.urlID).toJson(), this.mPlayInfo.session);
            this.mScreenCapture.resumeEncode();
        }
    }

    public void screenshot(int i10) {
    }

    public void seekTo(int i10) {
    }

    public void sendAudioData(byte[] bArr, int i10, int i11) {
        if (!OptionCentral.isEnableExternalAudio()) {
            YimMirror.getInstance().sendAudio(bArr, i11, System.currentTimeMillis(), 2);
        }
    }

    public void sendVideoData(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
        this.mFrameCount++;
        if (((float) byteBuffer.remaining()) / 1024.0f >= 10.0f && this.mScreenCapture.getBitrate() < 1000000) {
            SourceLog.i(TAG, "  onVideoDataCallback big frame size : " + (((float) byteBuffer.remaining()) / 1024.0f));
        }
        if (System.currentTimeMillis() - this.mPrintFrameTime >= 5000) {
            SourceLog.i(TAG, "sendVideoData " + j10 + "/  fps : " + (this.mFrameCount / 5) + " , " + this);
            this.mPrintFrameTime = System.currentTimeMillis();
            this.mFrameCount = 0;
            sendNoneAudioFrame();
        }
        try {
            YimMirror.getInstance().sendH264Data(byteBuffer, i10, i11, System.currentTimeMillis());
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void setExternalMirrorData() {
        SourceLog.i(TAG, "setExternalMirrorData");
        initExternalVideo();
        initExternalAudioSource();
        monitorExternalAudio();
        registerSinkKeyEvent();
        registerSinkTouchEvent();
    }

    public void setMirrorScreenSecret(boolean z10) {
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge == null) {
            SourceLog.w(TAG, "setMirrorScreenSecret ignore");
        } else {
            captureBridge.setMirrorScreenSecret(z10);
        }
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        super.setSecondMirrorView(secondMirrorView);
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge != null) {
            captureBridge.setSecondMirrorView(secondMirrorView);
        }
    }

    public void setWatermarkVisible(boolean z10) {
        if (this.mScreenCapture == null) {
            SourceLog.w(TAG, "setWatermarkVisible ignore");
            return;
        }
        SourceLog.i(TAG, "setWatermarkVisible");
        this.mScreenCapture.setWatermarkVisible(z10);
    }

    public void stop(String str) {
        if (!CastUtil.isSupportCloudMultiCast() || !this.mPlayInfo.isMultiCast) {
            stopAll();
        } else {
            stop();
        }
    }

    public void stopTask() {
        SourceLog.i(TAG, " stopTask ");
        DelayNotifySinkTask delayNotifySinkTask = this.mDelayNotifySinkTask;
        if (delayNotifySinkTask != null) {
            delayNotifySinkTask.cancel();
            this.mTimer.purge();
        }
    }

    public boolean switchExpansionScreen(boolean z10) {
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge == null) {
            return false;
        }
        OutParameter outParameter = this.mPlayInfo;
        outParameter.isExpandMirror = z10;
        this.isChangeExpandView = true;
        captureBridge.setExpansionScreenInfo(outParameter.expandActivity, outParameter.expandView);
        this.mScreenCapture.switchExpansionScreen(z10);
        return true;
    }

    private void stop() {
        SourceLog.i(TAG, "stop");
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge != null) {
            captureBridge.removeAbsBridge(4);
            this.mScreenCapture.release(2);
        }
        PublicCastClient.getInstance().stop(this.mPlayInfo);
        YimMirror.getInstance().stop();
        ConnectManager.getInstance().getLastConnectBridge().removeOnPassReceivedListener(this);
        OptionCentral.setOnSinkKeyEventRegisterListener((OptionCentral.OnSinkKeyEventRegisterListener) null);
        OptionCentral.setOnSinkTouchEventRegisterListener((OptionCentral.OnSinkTouchEventRegisterListener) null);
        doUnregisterSinkTouchEvent();
        PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createUnregisterBean().toJson(), this.mPlayInfo.session);
    }
}
