package com.hpplay.sdk.source.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IMirrorController;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.IDebugAVListener;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.OptionCentral;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.pass.bean.BaseBean;
import com.hpplay.sdk.source.pass.bean.MirrorStateBean;
import com.hpplay.sdk.source.pass.bean.SinkKeyEventRegisterBean;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventMonitor;
import com.hpplay.sdk.source.player.ICastPlayer;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.connect.AbsConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.nio.ByteBuffer;

public class LelinkMirrorBridge extends AbsBridge {
    private static final String TAG = "LelinkMirrorBridge";
    private static final int WHAT_CAPTURE = 1;
    private boolean hasRegisterSinkTouchEvent = false;
    /* access modifiers changed from: private */
    public boolean isCallError = false;
    private boolean isCallPrepared = false;
    private boolean isCallStop = false;
    /* access modifiers changed from: private */
    public boolean isFrozen = false;
    private final IDebugAVListener mAppAVListener;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            try {
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    CaptureBean captureBean = (CaptureBean) message.obj;
                    LelinkMirrorBridge.this.callLoading();
                    if (!LelinkMirrorBridge.this.mPlayInfo.isGroup || OptionCentral.isExternalVideo()) {
                        LelinkMirrorBridge.this.setExternalMirrorData();
                    }
                    LelinkMirrorBridge.this.mScreenCapture.onSinkPrepared(1, LelinkMirrorBridge.this, captureBean.sinkWidth, captureBean.sinkHeight, captureBean.sinkFrameRate, captureBean.bitrate, captureBean.encodeType);
                }
                LelinkMirrorBridge.this.registerSinkKeyEvent();
                LelinkMirrorBridge.this.registerSinkTouchEvent();
                return false;
            } catch (Exception e10) {
                SourceLog.w(LelinkMirrorBridge.TAG, (Throwable) e10);
                return false;
            }
        }
    });
    /* access modifiers changed from: private */
    public IMirrorController mMirrorController;
    private IMirrorStateListener mMirrorListener = new IMirrorStateListener() {
        public void onBitrateCallback(int i10) {
            if (!LelinkMirrorBridge.this.isFrozen) {
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onBitrateCallback " + i10);
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.setBitRate(1, i10);
                }
            }
        }

        public void onBroken() {
            SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onBroken isFrozen :" + LelinkMirrorBridge.this.mPlayInfo.isGroup);
            LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
            if (!lelinkMirrorBridge.mPlayInfo.isGroup) {
                lelinkMirrorBridge.stopMirror();
            } else if (lelinkMirrorBridge.mScreenCapture != null) {
                LelinkMirrorBridge.this.mScreenCapture.onBroken(1);
            }
        }

        public void onError(int i10, String str) {
            if (!LelinkMirrorBridge.this.isFrozen && !LelinkMirrorBridge.this.mScreenCapture.isGroupMirror()) {
                SourceLog.w(LelinkMirrorBridge.TAG, "Mirror onError " + i10 + "  " + str);
                if (211026 == i10) {
                    OnErrorListener onErrorListener = LelinkMirrorBridge.this.mErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError((ICastPlayer) null, 211010, 211026, (String) null);
                        return;
                    }
                    return;
                }
                LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
                if (lelinkMirrorBridge.mErrorListener != null) {
                    boolean unused = lelinkMirrorBridge.isCallError = true;
                    LelinkMirrorBridge.this.mErrorListener.onError((ICastPlayer) null, 211010, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, str);
                }
                LelinkMirrorBridge.this.stopMirror();
            }
        }

        public void onFrameCallback(int i10) {
            if (!LelinkMirrorBridge.this.isFrozen) {
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onFrameCallback " + i10);
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.setFrameRate(1, i10);
                }
            }
        }

        public void onMirrorModeCallback(String str) {
            if (!LelinkMirrorBridge.this.isFrozen && LelinkMirrorBridge.this.mScreenCapture != null) {
                LelinkMirrorBridge.this.mScreenCapture.setMirrorMode(str);
            }
        }

        public void onNetStateChange(int i10) {
            SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onNetStateChange " + i10);
        }

        public boolean onNetworkPoor() {
            if (!LelinkMirrorBridge.this.isFrozen && LelinkMirrorBridge.this.mScreenCapture != null) {
                return LelinkMirrorBridge.this.mScreenCapture.onNetworkPoor();
            }
            return false;
        }

        public void onPauseEncode() {
            if (!LelinkMirrorBridge.this.isFrozen) {
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onPauseEncode ");
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.pauseEncode(false);
                }
                OnInfoListener onInfoListener = LelinkMirrorBridge.this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo((ICastPlayer) null, PlayerListenerConstant.MIRROR_INFO_CODE, LelinkSourceSDK.EXTERNAL_ENCODE_RESUME);
                }
            }
        }

        public void onResolutionCallback(int i10, int i11) {
            if (!LelinkMirrorBridge.this.isFrozen) {
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onResolutionCallback " + i10 + Operator.Operation.DIVISION + i11);
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.setResolution(1, i10, i11);
                }
            }
        }

        public void onResumeEncode() {
            if (!LelinkMirrorBridge.this.isFrozen) {
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onResumeEncode ");
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.resumeEncode();
                }
                OnInfoListener onInfoListener = LelinkMirrorBridge.this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo((ICastPlayer) null, PlayerListenerConstant.MIRROR_INFO_CODE, LelinkSourceSDK.EXTERNAL_ENCODE_PAUSE);
                }
            }
        }

        public void onSinkPrepared(int i10, int i11, int i12, int i13, String str) {
            if (!LelinkMirrorBridge.this.isFrozen) {
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror sinkWidth " + i10 + "  sinkWidth " + i11 + "  sinkFrameRate" + i12 + " " + LelinkMirrorBridge.this);
                CaptureBean captureBean = new CaptureBean();
                captureBean.sinkWidth = i10;
                captureBean.sinkHeight = i11;
                captureBean.sinkFrameRate = i12;
                captureBean.encodeType = str;
                captureBean.bitrate = i13;
                LelinkMirrorBridge.this.mHandler.obtainMessage(1, captureBean).sendToTarget();
                if (OptionCentral.getResolution()[0] > 0 && OptionCentral.getResolution()[1] > 0) {
                    try {
                        LelinkMirrorBridge.this.mMirrorController.setAdjustResolution(false);
                    } catch (Exception e10) {
                        SourceLog.w(LelinkMirrorBridge.TAG, (Throwable) e10);
                    }
                }
            }
        }

        public void onSinkStop(String str, int i10) {
            boolean unused = LelinkMirrorBridge.this.isFrozen = false;
            SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onSinkStop " + str + Operator.Operation.DIVISION + i10);
            LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
            lelinkMirrorBridge.stop(lelinkMirrorBridge.mPlayInfo.getKey());
        }

        public void resetEncoder() {
            if (LelinkMirrorBridge.this.mScreenCapture != null) {
                LelinkMirrorBridge.this.mScreenCapture.resetEncoder();
            }
        }
    };
    private int mMirrorSendTimeout = 20;
    private ModuleLinker mModuleLinker;
    /* access modifiers changed from: private */
    public CaptureBridge mScreenCapture;
    private final OptionCentral.OnExternalAudioStateChangedListener onExternalAudioStateChangedListener = new OptionCentral.OnExternalAudioStateChangedListener() {
        public void onStateChanged(boolean z10) {
            int i10;
            if (!LelinkMirrorBridge.this.isFrozen) {
                SourceLog.i(LelinkMirrorBridge.TAG, "onStateChanged: isEnable: " + z10);
                if (z10) {
                    i10 = 1;
                } else {
                    i10 = CaptureBridge.getInstance().getAudioCaptureType(LelinkMirrorBridge.this.mPlayInfo);
                }
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.setAudioSwitch(i10, 1, LelinkMirrorBridge.this.mPlayInfo.requestAudioFocus, true);
                }
            }
        }
    };
    private final OptionCentral.OnPCMUpdateListener onPCMUpdateListener = new OptionCentral.OnPCMUpdateListener() {
        public void onAudioUpdate(byte[] bArr, AudioFrameBean audioFrameBean) {
            if (!LelinkMirrorBridge.this.isFrozen && LelinkMirrorBridge.this.mScreenCapture != null) {
                LelinkMirrorBridge.this.mScreenCapture.updatePCMData(audioFrameBean.sampleRate, audioFrameBean.channel, audioFrameBean.audioFormat, bArr, audioFrameBean.offset, audioFrameBean.length);
            }
        }
    };
    private final AbsConnectBridge.OnPassReceivedListener onPassReceivedListener = new AbsConnectBridge.OnPassReceivedListener() {
        public void onPassReversed(int i10, BaseBean baseBean) {
            if (LelinkMirrorBridge.this.isFrozen || i10 != 26) {
                return;
            }
            if (((MirrorStateBean) baseBean).action == 0) {
                LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
                lelinkMirrorBridge.pause(lelinkMirrorBridge.mPlayInfo.getKey());
                return;
            }
            LelinkMirrorBridge lelinkMirrorBridge2 = LelinkMirrorBridge.this;
            lelinkMirrorBridge2.resume(lelinkMirrorBridge2.mPlayInfo.getKey());
        }
    };
    private final OptionCentral.OnVideoUpdateListener onVideoUpdateListener = new OptionCentral.OnVideoUpdateListener() {
        public void onVideoUpdate(byte[] bArr, VideoFrameBean videoFrameBean) {
            if (LelinkMirrorBridge.this.isFrozen) {
                SourceLog.w(LelinkMirrorBridge.TAG, "updateVideoData onVideoUpdate ignore " + bArr.length);
                return;
            }
            int i10 = videoFrameBean.type;
            if (i10 == 1) {
                SourceLog.w(LelinkMirrorBridge.TAG, "updateVideoData onVideoUpdate " + bArr.length);
                if (LelinkMirrorBridge.this.mMirrorController != null && LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.updateH264Data(bArr, 0, bArr.length);
                }
            } else if (i10 == 2) {
                SourceLog.w(LelinkMirrorBridge.TAG, "onVideoUpdate rgb data not support now");
            }
        }
    };

    public static class CaptureBean {
        public int bitrate;
        public String encodeType;
        public int sinkFrameRate;
        public int sinkHeight;
        public int sinkWidth;

        private CaptureBean() {
        }
    }

    public LelinkMirrorBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        SourceLog.i(TAG, " create new  LelinkMirrorBridge");
        this.mPlayInfo = outParameter;
        try {
            ModuleLinker newInstance = ModuleLinker.getNewInstance();
            this.mModuleLinker = newInstance;
            this.mMirrorController = (IMirrorController) newInstance.loadModule(ModuleIds.CLAZZ_ID1068_MIRRORCONTROLLERIMP);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        CaptureBridge instance = CaptureBridge.getInstance();
        this.mScreenCapture = instance;
        instance.init();
        this.mScreenCapture.setPlayInfo(outParameter);
        this.mAppAVListener = Session.getInstance().getDebugAVListener();
    }

    /* access modifiers changed from: private */
    public void callLoading() {
        OnLoadingListener onLoadingListener = this.mLoadingListener;
        if (onLoadingListener != null) {
            onLoadingListener.onLoading((ICastPlayer) null, (String) null);
        }
    }

    private void callPause() {
        OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
        if (onStateChangeListener != null) {
            onStateChangeListener.onStateChanged((ICastPlayer) null, 4);
        }
    }

    private void callPlaying() {
        OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
        if (onStateChangeListener != null) {
            onStateChangeListener.onStateChanged((ICastPlayer) null, 3);
        }
    }

    private void callStart() {
        OnPreparedListener onPreparedListener;
        if (!this.isCallPrepared && (onPreparedListener = this.mPreparedListener) != null) {
            this.isCallPrepared = true;
            onPreparedListener.onPrepared((ICastPlayer) null);
        }
    }

    private void callStop() {
        SourceLog.i(TAG, "callStop   " + this.isCallStop);
        if (!this.isCallStop && !this.isFrozen) {
            try {
                if (this.mStopListener != null) {
                    int i10 = 1;
                    this.isCallStop = true;
                    StopInfo stopInfo = new StopInfo();
                    if (this.isCallError) {
                        i10 = 2;
                    }
                    stopInfo.type = i10;
                    this.mStopListener.onStop((ICastPlayer) null, stopInfo);
                    CaptureBridge captureBridge = this.mScreenCapture;
                    if (captureBridge != null) {
                        captureBridge.release(hashCode());
                    }
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
    }

    /* access modifiers changed from: private */
    public void doRegisterSinkTouchEvent() {
        SourceLog.i(TAG, "doRegisterSinkTouchEvent: hasRegisterSinkTouchEvent： " + this.hasRegisterSinkTouchEvent);
        if (!this.hasRegisterSinkTouchEvent) {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    SinkTouchEventMonitor instance = SinkTouchEventMonitor.getInstance();
                    LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
                    instance.startMonitor(lelinkMirrorBridge.mContext, lelinkMirrorBridge.mPlayInfo.session, false);
                }
            }, 1000);
            this.hasRegisterSinkTouchEvent = true;
        }
    }

    /* access modifiers changed from: private */
    public void doUnregisterSinkTouchEvent() {
        SourceLog.i(TAG, "doUnregisterSinkTouchEvent: ");
        this.hasRegisterSinkTouchEvent = false;
        SinkTouchEventMonitor.getInstance().stopMonitor();
    }

    private void initExternalAudioSource() {
        OptionCentral.setOnPCMUpdateListener(this.onPCMUpdateListener);
    }

    private void initExternalVideo() {
        OptionCentral.setOnVideoUpdateListener(this.onVideoUpdateListener);
    }

    private void monitorExternalAudio() {
        OptionCentral.setOnExternalAudioStateChangedListener(this.onExternalAudioStateChangedListener);
    }

    /* access modifiers changed from: private */
    public void registerSinkKeyEvent() {
        if (OptionCentral.isRegisterSinkKeyEvent()) {
            PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createRegisterBean().toJson(), this.mPlayInfo.session);
        }
        OptionCentral.setOnSinkKeyEventRegisterListener(new OptionCentral.OnSinkKeyEventRegisterListener() {
            public void onRegister() {
                PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createRegisterBean().toJson(), LelinkMirrorBridge.this.mPlayInfo.session);
            }

            public void onUnregister() {
                PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createUnregisterBean().toJson(), LelinkMirrorBridge.this.mPlayInfo.session);
            }
        });
    }

    /* access modifiers changed from: private */
    public void registerSinkTouchEvent() {
        if (OptionCentral.isRegistSinkTouchEvent()) {
            doRegisterSinkTouchEvent();
        }
        OptionCentral.setOnSinkTouchEventRegisterListener(new OptionCentral.OnSinkTouchEventRegisterListener() {
            public void onRegister() {
                SourceLog.i(LelinkMirrorBridge.TAG, "onRegister: ");
                LelinkMirrorBridge.this.doRegisterSinkTouchEvent();
            }

            public void onUnregister() {
                LelinkMirrorBridge.this.doUnregisterSinkTouchEvent();
            }
        });
    }

    /* access modifiers changed from: private */
    public void stopMirror() {
        CaptureBridge captureBridge;
        SourceLog.i(TAG, "stopMirror");
        if (!this.isFrozen && (captureBridge = this.mScreenCapture) != null) {
            captureBridge.stopCapture(1);
        }
        IMirrorController iMirrorController = this.mMirrorController;
        if (iMirrorController != null) {
            iMirrorController.stopMirror();
        }
        callStop();
    }

    public void frozen(boolean z10) {
        super.frozen(z10);
        SourceLog.i(TAG, "======== set frozen " + z10);
        this.isFrozen = z10;
    }

    public void onCaptureStart(int i10) {
        if (this.isFrozen) {
            SourceLog.w(TAG, "onCaptureStart ignore");
            return;
        }
        SourceLog.i(TAG, "Capture onStart " + i10);
        callStart();
        callPlaying();
    }

    public void onCaptureStop(int i10) {
        SourceLog.i(TAG, "Capture onStop " + i10);
    }

    public void onInfo(int i10, String str) {
        if (i10 == 10 || i10 == 120105112) {
            super.onInfo(i10, str);
            return;
        }
        SourceLog.i(TAG, "on info callback : " + i10 + "  extra: " + str);
        boolean z10 = LelinkSdkManager.getInstance().getRetryMirrorOnce().get();
        SourceLog.i(TAG, "Capture onInfo " + i10 + Operator.Operation.DIVISION + str);
        if (z10) {
            LelinkSdkManager.getInstance().getRetryMirrorOnce().set(false);
            SourceLog.i(TAG, "Capture onInfo retried.");
            return;
        }
        LelinkSdkManager.getInstance().getRetryMirrorOnce().set(true);
        if (this.mErrorListener != null && !TextUtils.isEmpty(str)) {
            this.isCallError = true;
            this.mErrorListener.onError((ICastPlayer) null, 211010, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, str);
        }
    }

    public void pause(String str) {
        if (this.mScreenCapture == null || this.mMirrorController == null) {
            SourceLog.w(TAG, "pause ignore");
            return;
        }
        SourceLog.i(TAG, "pause");
        PassSender.getInstance().sendMirrorState(MirrorStateBean.createPauseBean(this.mPlayInfo.urlID).toJson(), this.mPlayInfo.session);
        this.mScreenCapture.pauseEncode(true);
        callPause();
    }

    public void play(String str) {
        if (this.mScreenCapture == null || this.mMirrorController == null) {
            SourceLog.w(TAG, "play mirror ignore");
            return;
        }
        BrowserInfo browserInfo = CastUtil.getBrowserInfo(this.mPlayInfo.serviceInfo, 1);
        if (browserInfo == null) {
            SourceLog.w(TAG, "play mirror ignore 2");
            return;
        }
        SourceLog.debug(TAG, "play mirror " + this.mPlayInfo);
        if (ConnectManager.getInstance().getLastConnectBridge() != null) {
            ConnectManager.getInstance().getLastConnectBridge().addOnPassReceivedListener(this, this.onPassReceivedListener);
        } else {
            SourceLog.w(TAG, "Not connect to " + this.mPlayInfo.serviceInfo.getName() + Operator.Operation.DIVISION + this.mPlayInfo.serviceInfo.getIp());
        }
        ParamsMap create = ParamsMap.create();
        create.putParam(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
        create.putParam(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
        String string = FieldUtil.getString(FieldUtil.f10533m);
        Session.getInstance();
        create.putParam(string, Session.DEFAULT_M);
        create.putParam("imei", "");
        create.putParam(ParamsMap.DeviceParams.KEY_SESSION_ID, this.mPlayInfo.session);
        create.putParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, this.mPlayInfo.connectSession);
        create.putParam("uri", this.mPlayInfo.urlID);
        create.putParam("ip", browserInfo.getIp());
        create.putParam(ParamsMap.MirrorParams.KEY_EXTERNAL_VIDEO, String.valueOf(OptionCentral.isExternalVideo()));
        create.putParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, this.mPlayInfo.connectSession);
        if (!TextUtils.isEmpty(this.mPlayInfo.password)) {
            create.putParam("screencode", this.mPlayInfo.password);
        }
        boolean isSupportLelinkV2 = CastUtil.isSupportLelinkV2(browserInfo);
        try {
            create.putParam(ParamsMap.DeviceParams.KEY_RAOP_PORT, browserInfo.getExtras().get("raop"));
            String str2 = browserInfo.getExtras().get("mirror");
            if (!TextUtils.isEmpty(str2) && TextUtils.isDigitsOnly(str2)) {
                create.putParam(ParamsMap.DeviceParams.KEY_MIRROR_PORT, str2);
            }
            if (isSupportLelinkV2) {
                create.putParam("vv", "2");
                create.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, browserInfo.getExtras().get("lelinkport"));
            } else {
                create.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, browserInfo.getExtras().get("airplay"));
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        int i10 = this.mPlayInfo.mirrorResLevel;
        if (i10 == 1) {
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH, "1080");
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT, "1920");
        } else if (i10 != 2) {
            int[] relScreenSize = ScreenUtil.getRelScreenSize(this.mContext);
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH, relScreenSize[0] + "");
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT, relScreenSize[1] + "");
        } else {
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH, "720");
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT, "1280");
        }
        create.putParam(ParamsMap.MirrorParams.KEY_AUTO_BITRATE, String.valueOf(this.mPlayInfo.isAutoBitrate));
        create.putParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, this.mPlayInfo.protocol + "");
        create.putParam(ParamsMap.MirrorParams.KEY_MIRROR_AUDIO, Boolean.TRUE);
        create.putParam(ParamsMap.MirrorParams.KEY_EXTERNAL_VIDEO, String.valueOf(OptionCentral.isExternalVideo()));
        SourceLog.i(TAG, "play map: " + create.toString() + " mirrorSendTimeout :" + this.mPlayInfo.mirrorSendTimeout + " isSupportV2 " + isSupportLelinkV2);
        this.mMirrorController.setMirrorProtocolInfos(create);
        IMirrorController iMirrorController = this.mMirrorController;
        int i11 = this.mPlayInfo.mirrorSendTimeout;
        if (i11 <= 0) {
            i11 = this.mMirrorSendTimeout;
        }
        iMirrorController.setSendDataTimeout(i11);
        this.mMirrorController.startGetSinkInfos(this.mMirrorListener);
    }

    public void release() {
        SourceLog.i(TAG, "release");
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge != null) {
            captureBridge.removeAbsBridge(1);
            this.mScreenCapture.release(hashCode());
        }
        ModuleLinker moduleLinker = this.mModuleLinker;
        if (moduleLinker != null) {
            moduleLinker.removeObjOfMemory(ModuleIds.CLAZZ_ID1068_MIRRORCONTROLLERIMP);
            this.mModuleLinker = null;
        }
        if (this.mMirrorController != null) {
            this.mMirrorListener = null;
            this.mLoadingListener = null;
            this.mPreparedListener = null;
            this.mStateChangeListener = null;
            this.mInfoListener = null;
            this.mErrorListener = null;
            this.mCompletionListener = null;
            this.mStopListener = null;
        }
    }

    public void resume(String str) {
        if (this.mScreenCapture == null || this.mMirrorController == null) {
            SourceLog.w(TAG, "resume ignore");
            return;
        }
        SourceLog.i(TAG, "resume");
        PassSender.getInstance().sendMirrorState(MirrorStateBean.createResumeBean(this.mPlayInfo.getPlayUrl()).toJson(), this.mPlayInfo.session);
        this.mScreenCapture.resumeEncode();
        this.mScreenCapture.resetEncoder();
        callPlaying();
    }

    public void screenshot(int i10) {
        SourceLog.i(TAG, "Capture onScreenshot " + i10);
    }

    public void seekTo(int i10) {
    }

    public void sendAudioData(byte[] bArr, int i10, int i11) {
        if (!this.isFrozen) {
            super.sendAudioData(bArr, i10, i11);
            this.mMirrorController.sendAudioData(bArr, i10, i11);
            if (this.mAppAVListener != null) {
                try {
                    byte[] bArr2 = new byte[i11];
                    System.arraycopy(bArr, i10, bArr2, 0, i11);
                    this.mAppAVListener.onAudioCallback(-1, -1, -1, i11, bArr2);
                } catch (Exception e10) {
                    SourceLog.w(TAG, (Throwable) e10);
                }
            }
        }
    }

    public void sendVideoData(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
        if (this.isFrozen) {
            SourceLog.w(TAG, "sendVideoData ignore");
        } else {
            this.mMirrorController.sendVideoData(byteBuffer, i12, j10);
        }
    }

    public void setExternalMirrorData() {
        SourceLog.i(TAG, "setExternalMirrorData");
        initExternalVideo();
        initExternalAudioSource();
        monitorExternalAudio();
    }

    public void setMirrorScreenSecret(boolean z10) {
        SourceLog.i(TAG, "setMirrorScreenSecret status:" + z10);
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge == null || this.mMirrorController == null) {
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
        if (this.mScreenCapture == null || this.mMirrorController == null) {
            SourceLog.w(TAG, "setWatermarkVisible ignore");
            return;
        }
        SourceLog.i(TAG, "setWatermarkVisible");
        this.mScreenCapture.setWatermarkVisible(z10);
    }

    public void stop(String str) {
        SourceLog.i(TAG, "stop " + str + " " + this.isFrozen);
        stopMirror();
        if (ConnectManager.getInstance().getLastConnectBridge() != null) {
            ConnectManager.getInstance().getLastConnectBridge().removeOnPassReceivedListener(this);
        }
        OptionCentral.setOnPCMUpdateListener((OptionCentral.OnPCMUpdateListener) null);
        OptionCentral.setOnSinkKeyEventRegisterListener((OptionCentral.OnSinkKeyEventRegisterListener) null);
        OptionCentral.setOnSinkTouchEventRegisterListener((OptionCentral.OnSinkTouchEventRegisterListener) null);
        OptionCentral.setOnExternalAudioStateChangedListener((OptionCentral.OnExternalAudioStateChangedListener) null);
        OptionCentral.setOnVideoUpdateListener((OptionCentral.OnVideoUpdateListener) null);
        doUnregisterSinkTouchEvent();
    }

    public boolean switchExpansionScreen(boolean z10) {
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge == null) {
            return false;
        }
        OutParameter outParameter = this.mPlayInfo;
        outParameter.isExpandMirror = z10;
        captureBridge.setExpansionScreenInfo(outParameter.expandActivity, outParameter.expandView);
        this.mScreenCapture.switchExpansionScreen(z10);
        return true;
    }
}
