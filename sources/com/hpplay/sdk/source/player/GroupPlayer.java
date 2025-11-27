package com.hpplay.sdk.source.player;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.a.a.a.d;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.screencupture.IScreenCapture;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.SDKConfig;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.mirror.a.a;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.AbsBridge;
import com.hpplay.sdk.source.protocol.CaptureBridge;
import com.hpplay.sdk.source.protocol.LelinkBridge;
import com.hpplay.sdk.source.protocol.YimBridge;
import com.hpplay.sdk.source.utils.BrowserResolver;
import com.hpplay.sdk.source.utils.KeepAliveUtitls;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.f;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

public class GroupPlayer implements ICastPlayer {
    private static final String TAG = "GroupPlayer";
    private static final int WHAT_RECONNECT_DEVICE = 2;
    private static final int WHAT_REPORT_QUALITY = 1;
    /* access modifiers changed from: private */
    public boolean isCallLoading = false;
    private boolean isCallPlay = false;
    /* access modifiers changed from: private */
    public boolean isCallPrepared = false;
    /* access modifiers changed from: private */
    public boolean isPauseSend;
    /* access modifiers changed from: private */
    public boolean isStopped = false;
    /* access modifiers changed from: private */
    public SparseArray<AbsBridge> mBridges = new SparseArray<>();
    private final ProtocolListener mBrowseListener = new ProtocolListener() {
        public void onResult(int i10, String... strArr) {
            try {
                SourceLog.i(GroupPlayer.TAG, "findLocalMirrorDevice  onResult");
                String str = "";
                if (strArr != null) {
                    str = strArr[0];
                }
                CLog.i(GroupPlayer.TAG, "restartLocalMirror onResult:" + str);
                if (20 != i10 || TextUtils.isEmpty(str)) {
                    SourceLog.i(GroupPlayer.TAG, "not find local mirror device");
                    return;
                }
                CLog.i(GroupPlayer.TAG, "restartLocalMirror  ");
                GroupPlayer.this.assembleServiceInfo(str);
            } catch (Exception e10) {
                CLog.w(GroupPlayer.TAG, (Throwable) e10);
            }
        }
    };
    private CaptureBridge.ICaptureDispatcher mCaptureDispatcher = new CaptureBridge.ICaptureDispatcher() {
        private int wrongFrameCount = 0;

        public void onAudioDataCallback(byte[] bArr, int i10, int i11, int i12) {
            if (GroupPlayer.this.mCurrentPlayer != null && GroupPlayer.this.mCurrentPlayer.getBridge() != null) {
                if ((GroupPlayer.this.mCurrentPlayer.getBridge() instanceof YimBridge) && i12 == 1) {
                    int i13 = this.wrongFrameCount + 1;
                    this.wrongFrameCount = i13;
                    if (i13 > 100) {
                        SourceLog.i(GroupPlayer.TAG, "==================== request pcm data ============ ");
                        this.wrongFrameCount = 0;
                        CaptureBridge.getInstance().setAudioSwitch(CaptureBridge.getInstance().getAudioSwitch(), 0, GroupPlayer.this.mPlayInfo.requestAudioFocus, true);
                    }
                } else if (i12 != 0 || !(GroupPlayer.this.mCurrentPlayer.getBridge() instanceof LelinkBridge)) {
                    if (System.currentTimeMillis() - GroupPlayer.this.mPrintAudioFrameType > 5000) {
                        long unused = GroupPlayer.this.mPrintAudioFrameType = System.currentTimeMillis();
                        SourceLog.i(GroupPlayer.TAG, "onAudioDataCallback print " + i12 + " ======= " + i11);
                    }
                    this.wrongFrameCount = 0;
                    GroupPlayer.this.mCurrentPlayer.getBridge().sendAudioData(bArr, i10, i11);
                } else {
                    int i14 = this.wrongFrameCount + 1;
                    this.wrongFrameCount = i14;
                    if (i14 > 100) {
                        this.wrongFrameCount = 0;
                        SourceLog.i(GroupPlayer.TAG, "==================== request aac data============ ");
                        CaptureBridge.getInstance().setAudioSwitch(CaptureBridge.getInstance().getAudioSwitch(), 1, GroupPlayer.this.mPlayInfo.requestAudioFocus, true);
                    }
                }
            }
        }

        public void onBroken(int i10) {
            SourceLog.i(GroupPlayer.TAG, "onBroken");
            long unused = GroupPlayer.this.startChangeTime = System.currentTimeMillis();
            if (i10 == 1) {
                GroupPlayer.this.doChangeChannel(4);
            }
        }

        public void onCaptureInfo(int i10, String str) {
            SourceLog.i(GroupPlayer.TAG, "onCaptureInfo " + i10 + Operator.Operation.DIVISION + str);
            if (GroupPlayer.this.mCurrentPlayer != null && GroupPlayer.this.mCurrentPlayer.getBridge() != null) {
                GroupPlayer.this.mCurrentPlayer.getBridge().onInfo(i10, str);
            }
        }

        public void onCaptureScreenshot(int i10) {
            SourceLog.i(GroupPlayer.TAG, "onCaptureScreenshot");
        }

        public void onCaptureStart(int i10) {
            SourceLog.i(GroupPlayer.TAG, "onCaptureStart " + i10);
            if (GroupPlayer.this.mCurrentPlayer != null && GroupPlayer.this.mCurrentPlayer.getBridge() != null) {
                GroupPlayer.this.mCurrentPlayer.getBridge().onCaptureStart(i10);
            }
        }

        public void onCaptureStop(int i10) {
            try {
                SourceLog.i(GroupPlayer.TAG, "onCaptureStop " + i10);
                for (int i11 = 0; i11 < GroupPlayer.this.mBridges.size(); i11++) {
                    ((AbsBridge) GroupPlayer.this.mBridges.valueAt(i11)).onCaptureStop(i10);
                }
            } catch (Exception e10) {
                SourceLog.w(GroupPlayer.TAG, (Throwable) e10);
            }
        }

        public boolean onNetworkPoor() {
            SourceLog.i(GroupPlayer.TAG, "onNetworkPoor");
            GroupPlayer.this.doChangeChannel(4);
            return true;
        }

        public void onSinkPrepared(int i10, AbsBridge absBridge, int i11, int i12, int i13, int i14, String str) {
            int i15 = i10;
            SourceLog.i(GroupPlayer.TAG, "onSinkPrepared type:" + i10);
            a aVar = new a();
            aVar.f11836a = i11;
            aVar.f11837b = i12;
            aVar.f11838c = i13;
            aVar.f11840e = str;
            aVar.f11839d = i14;
            GroupPlayer.this.mMirrorInfos.put(i10, aVar);
            AbsBridge absBridge2 = absBridge;
            GroupPlayer.this.mBridges.put(i10, absBridge);
            if ((i15 != 1 || GroupPlayer.this.mCurrentPlayer == GroupPlayer.this.mLelinkPlayer) && (i15 != 4 || GroupPlayer.this.mCurrentPlayer == GroupPlayer.this.mYimPlayer)) {
                GroupPlayer.this.mCurrentPlayer.getBridge().setExternalMirrorData();
                if (CaptureBridge.getInstance().isRunning()) {
                    CaptureBridge.getInstance().resetCaptureEncoder(i10, aVar.f11836a, aVar.f11837b, aVar.f11838c, aVar.f11839d, aVar.f11840e);
                    return;
                }
                CaptureBridge.getInstance().startScreenCapture(i10, aVar.f11836a, aVar.f11837b, aVar.f11838c, i14, aVar.f11840e);
                return;
            }
            SourceLog.i(GroupPlayer.TAG, "onSinkPrepared ignore");
        }

        public void onVideoDataCallback(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
            if (GroupPlayer.this.mCurrentPlayer == null || GroupPlayer.this.mCurrentPlayer.getBridge() == null) {
                SourceLog.i(GroupPlayer.TAG, "onVideoDataCallback ignore, has no valid player now " + i12);
                return;
            }
            if (System.currentTimeMillis() - GroupPlayer.this.mPrintFrameType > 3000) {
                long unused = GroupPlayer.this.mPrintFrameType = System.currentTimeMillis();
                SourceLog.i(GroupPlayer.TAG, "onVideoDataCallback print " + i12 + " cloud:" + (GroupPlayer.this.mCurrentPlayer instanceof YimPlayer) + "  " + i10 + "  " + i11);
            }
            if (GroupPlayer.this.startChangeTime > 0) {
                SourceLog.i(GroupPlayer.TAG, "onVideoDataCallback startChangeTime  : " + (System.currentTimeMillis() - GroupPlayer.this.startChangeTime));
                long unused2 = GroupPlayer.this.startChangeTime = 0;
            }
            if (!GroupPlayer.this.isPauseSend) {
                GroupPlayer.this.mCurrentPlayer.getBridge().sendVideoData(byteBuffer, i10, i11, i12, j10);
            }
        }
    };
    private int mChangeCount = 0;
    /* access modifiers changed from: private */
    public OnCompletionListener mCompletionListener;
    private Context mContext;
    /* access modifiers changed from: private */
    public AbsPlayer mCurrentPlayer;
    /* access modifiers changed from: private */
    public DeviceWLANCheckTask mDeviceWLANCheckTask;
    /* access modifiers changed from: private */
    public OnErrorListener mErrorListener;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    return false;
                }
                ConnectManager.getInstance().groupReconnect();
                return false;
            } else if (!GroupPlayer.this.mQualityReportEnable) {
                return false;
            } else {
                GroupPlayer.this.reportQuality();
                GroupPlayer.this.mHandler.removeMessages(1);
                GroupPlayer.this.mHandler.sendEmptyMessageDelayed(1, (long) GroupPlayer.this.mReportInterval);
                return false;
            }
        }
    });
    /* access modifiers changed from: private */
    public OnInfoListener mInfoListener;
    /* access modifiers changed from: private */
    public LelinkPlayer mLelinkPlayer;
    /* access modifiers changed from: private */
    public OnLoadingListener mLoadingListener;
    /* access modifiers changed from: private */
    public SparseArray<a> mMirrorInfos = new SparseArray<>();
    /* access modifiers changed from: private */
    public OutParameter mPlayInfo;
    /* access modifiers changed from: private */
    public OnPreparedListener mPreparedListener;
    /* access modifiers changed from: private */
    public long mPrintAudioFrameType;
    /* access modifiers changed from: private */
    public long mPrintFrameType;
    private int mQualityCount = 0;
    /* access modifiers changed from: private */
    public boolean mQualityReportEnable = false;
    /* access modifiers changed from: private */
    public int mReportInterval = d.SOCKET_READ_TIMEOUT;
    /* access modifiers changed from: private */
    public OnStateChangeListener mStateChangeListener;
    /* access modifiers changed from: private */
    public OnStopListener mStopListener;
    /* access modifiers changed from: private */
    public YimPlayer mYimPlayer;
    private OnCompletionListener onCompletionListener = new OnCompletionListener() {
        public void onComplete(ICastPlayer iCastPlayer) {
            if (GroupPlayer.this.mCompletionListener != null) {
                GroupPlayer.this.mCompletionListener.onComplete(iCastPlayer);
            }
        }
    };
    private OnErrorListener onErrorListener = new OnErrorListener() {
        public void onError(ICastPlayer iCastPlayer, int i10, int i11, String str) {
            if (GroupPlayer.this.mErrorListener != null) {
                GroupPlayer.this.mErrorListener.onError(iCastPlayer, i10, i11, str);
            }
        }
    };
    private OnInfoListener onInfoListener = new OnInfoListener() {
        public void onInfo(ICastPlayer iCastPlayer, int i10, int i11, int i12) {
            if (GroupPlayer.this.mInfoListener != null) {
                GroupPlayer.this.mInfoListener.onInfo(iCastPlayer, i10, i11, i12);
            }
        }

        public void onInfo(ICastPlayer iCastPlayer, int i10, String str) {
            if (GroupPlayer.this.mInfoListener != null) {
                GroupPlayer.this.mInfoListener.onInfo(iCastPlayer, i10, str);
            }
        }
    };
    private OnLoadingListener onLoadingListener = new OnLoadingListener() {
        public void onLoading(ICastPlayer iCastPlayer, String str) {
            if (!GroupPlayer.this.isCallLoading) {
                boolean unused = GroupPlayer.this.isCallLoading = true;
                if (GroupPlayer.this.mLoadingListener != null) {
                    GroupPlayer.this.mLoadingListener.onLoading(iCastPlayer, str);
                }
            }
        }
    };
    private OnPreparedListener onPreparedListener = new OnPreparedListener() {
        public void onPrepared(ICastPlayer iCastPlayer) {
            if (!GroupPlayer.this.isCallPrepared) {
                boolean unused = GroupPlayer.this.isCallPrepared = true;
                if (GroupPlayer.this.mPreparedListener != null) {
                    GroupPlayer.this.mPreparedListener.onPrepared(iCastPlayer);
                }
            }
            if (GroupPlayer.this.mQualityReportEnable) {
                GroupPlayer.this.mHandler.removeMessages(1);
                GroupPlayer.this.mHandler.sendEmptyMessageDelayed(1, (long) GroupPlayer.this.mReportInterval);
            }
        }
    };
    private final YimBridge.IOnSinkChangeListener onSinkChangeListener = new YimBridge.IOnSinkChangeListener() {
        public void onChange(int i10) {
            SourceLog.i(GroupPlayer.TAG, " notifySinkChange result " + i10 + " get notify Sink Change result time : " + (System.currentTimeMillis() - GroupPlayer.this.startChangeTime));
            if (i10 == 1) {
                GroupPlayer.this.onNetChangeReconnectDevice(4);
                GroupPlayer.this.startResetEncoder();
                GroupPlayer.this.getChangeReport(1, (int) (System.currentTimeMillis() - GroupPlayer.this.startChangeTime));
                return;
            }
            GroupPlayer.this.getChangeReport(0, 0);
        }
    };
    private OnStateChangeListener onStateChangeListener = new OnStateChangeListener() {
        public void onStateChanged(ICastPlayer iCastPlayer, int i10) {
            if (GroupPlayer.this.mStateChangeListener != null) {
                GroupPlayer.this.mStateChangeListener.onStateChanged(iCastPlayer, i10);
            }
        }
    };
    private final OnStopListener onStopListener = new OnStopListener() {
        public void onStop(ICastPlayer iCastPlayer, StopInfo stopInfo) {
            SourceLog.i(GroupPlayer.TAG, "OnStopListener call stop ");
            boolean unused = GroupPlayer.this.isStopped = true;
            if (GroupPlayer.this.mStopListener != null) {
                GroupPlayer.this.mStopListener.onStop(iCastPlayer, stopInfo);
            }
            GroupPlayer groupPlayer = GroupPlayer.this;
            groupPlayer.stop(groupPlayer.mPlayInfo.getKey());
        }
    };
    /* access modifiers changed from: private */
    public long startChangeTime;

    public final class DeviceWLANCheckTask extends AsyncTask<LelinkServiceInfo, Void, Boolean> {
        WeakReference<GroupPlayer> reference;

        public DeviceWLANCheckTask(GroupPlayer groupPlayer) {
            this.reference = new WeakReference<>(groupPlayer);
        }

        public Boolean doInBackground(LelinkServiceInfo... lelinkServiceInfoArr) {
            try {
                LelinkServiceInfo lelinkServiceInfo = lelinkServiceInfoArr[0];
                BrowserInfo browserInfo = lelinkServiceInfo.getBrowserInfos().get(1);
                if (browserInfo == null) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(KeepAliveUtitls.tcpCheckTvState(lelinkServiceInfo.getName(), browserInfo.getIp(), Integer.parseInt(browserInfo.getExtras().get("lelinkport")), 2000));
            } catch (Exception unused) {
                SourceLog.w(GroupPlayer.TAG, " check wlan is failed ... ");
                return Boolean.FALSE;
            }
        }

        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (!isCancelled()) {
                try {
                    if (bool.booleanValue()) {
                        SourceLog.i(GroupPlayer.TAG, "device is Online ");
                        this.reference.get().onNetChangeReconnectDevice(1);
                    } else {
                        this.reference.get().onNetChangeReconnectDevice(4);
                        SourceLog.i(GroupPlayer.TAG, "device is offline ");
                        this.reference.get().findLocalMirrorDevice();
                    }
                } catch (Exception e10) {
                    SourceLog.w(GroupPlayer.TAG, (Throwable) e10);
                }
            }
            DeviceWLANCheckTask unused = GroupPlayer.this.mDeviceWLANCheckTask = null;
        }
    }

    public GroupPlayer(Context context, OutParameter outParameter) {
        boolean z10 = false;
        this.mContext = context;
        this.mPlayInfo = outParameter;
        SourceLog.i(TAG, TAG);
        int i10 = outParameter.connectProtocol;
        if (i10 == 1) {
            createLocalPlayer(false);
            this.mCurrentPlayer = this.mLelinkPlayer;
        } else if (i10 == 4) {
            createCloudPlayer(false);
            this.mCurrentPlayer = this.mYimPlayer;
        } else if (i10 == 6) {
            createCloudPlayer(true);
            createLocalPlayer(false);
            this.mCurrentPlayer = this.mLelinkPlayer;
        }
        CaptureBridge.getInstance().setICaptureDispatcher(this.mCaptureDispatcher);
        this.mQualityReportEnable = SDKConfig.getInstance().getTransferEnable() == 1 ? true : z10;
        this.mReportInterval = SDKConfig.getInstance().getQualityInterval();
    }

    /* access modifiers changed from: private */
    public void assembleServiceInfo(String str) {
        ParamsMap create = ParamsMap.create(str);
        if (create != null) {
            this.mPlayInfo.serviceInfo.setIp(create.getIp());
            BrowserInfo browserInfo = this.mPlayInfo.serviceInfo.getBrowserInfos().get(1);
            if (browserInfo == null) {
                this.mPlayInfo.serviceInfo.getBrowserInfos().put(1, BrowserResolver.resolveLelinkInfo(str));
            } else {
                Map<String, String> extras = browserInfo.getExtras();
                extras.put("lelinkport", create.getLelinkPort() + "");
                browserInfo.getExtras().put("mirror", create.getStringParam(ParamsMap.DeviceParams.KEY_MIRROR_PORT));
                browserInfo.getExtras().put("raop", create.getStringParam(ParamsMap.DeviceParams.KEY_RAOP_PORT));
                browserInfo.getExtras().put("airplay", create.getStringParam(ParamsMap.DeviceParams.KEY_AIRPLAY_PORT));
                browserInfo.getExtras().put("remote", create.getStringParam("remote"));
                this.mPlayInfo.serviceInfo.getBrowserInfos().put(1, browserInfo);
            }
            if (this.isStopped) {
                ConnectManager.getInstance().groupReconnect();
            } else {
                onNetChangeReconnectDevice(1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void findLocalMirrorDevice() {
        SourceLog.i(TAG, "findLocalMirrorDevice ");
        ParamsMap create = ParamsMap.create();
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null) {
            create.putParam(ParamsMap.DeviceParams.KEY_SINK_NAME, outParameter.serviceInfo.getName());
            create.putParam("ip", this.mPlayInfo.serviceInfo.getIp());
            create.putParam(ParamsMap.DeviceParams.KEY_UID, this.mPlayInfo.serviceInfo.getUid());
        }
        ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DEVICEADJUSTER_REQUESTNEWDEVICES, 1, create, this.mBrowseListener);
    }

    private void initListener(AbsPlayer absPlayer) {
        absPlayer.setOnLoadingListener(this.onLoadingListener);
        absPlayer.setOnPreparedListener(this.onPreparedListener);
        absPlayer.setOnStateChangeListener(this.onStateChangeListener);
        absPlayer.setOnErrorListener(this.onErrorListener);
        absPlayer.setOnInfoListener(this.onInfoListener);
        absPlayer.setOnCompletionListener(this.onCompletionListener);
        absPlayer.setOnStopListener(this.onStopListener);
    }

    /* access modifiers changed from: private */
    public void onNetChangeReconnectDevice(final int i10) {
        SourceLog.i(TAG, "====onNetChangeReconnectDevice====" + i10);
        ConnectManager.getInstance().groupReconnect(i10, this.mPlayInfo.serviceInfo, new IConnectListener() {
            public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
                SourceLog.i(GroupPlayer.TAG, "====onNetChangeReconnectDevice  onConnect=====" + i10 + " time " + (System.currentTimeMillis() - GroupPlayer.this.startChangeTime));
                if (i10 == 1) {
                    AbsBridge bridge = GroupPlayer.this.mCurrentPlayer.getBridge();
                    if (bridge != null) {
                        bridge.frozen(true);
                    }
                    GroupPlayer.this.restartLocalPlayer();
                }
                GroupPlayer.this.mCurrentPlayer.getBridge().setExternalMirrorData();
            }

            public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
                SourceLog.i(GroupPlayer.TAG, "===onNetChangeReconnectDevice===onDisconnect===");
                GroupPlayer groupPlayer = GroupPlayer.this;
                groupPlayer.stop(groupPlayer.mPlayInfo.getKey());
            }
        });
    }

    /* access modifiers changed from: private */
    public void restartLocalPlayer() {
        CaptureBridge.getInstance().pauseEncode(true);
        try {
            LelinkPlayer lelinkPlayer = this.mLelinkPlayer;
            if (lelinkPlayer != null) {
                lelinkPlayer.setOnCompletionListener((OnCompletionListener) null);
                this.mLelinkPlayer.setOnStateChangeListener((OnStateChangeListener) null);
                this.mLelinkPlayer.setOnErrorListener((OnErrorListener) null);
                this.mLelinkPlayer.setOnInfoListener((OnInfoListener) null);
                this.mLelinkPlayer.setOnStopListener((OnStopListener) null);
                this.mLelinkPlayer.getBridge().frozen(true);
                this.mLelinkPlayer.stop(this.mPlayInfo.getKey());
            }
            this.mLelinkPlayer = null;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        SourceLog.i(TAG, " restartLocalPlayer ... ");
        createLocalPlayer(false);
        this.mLelinkPlayer.start(this.mPlayInfo.getKey());
        this.mCurrentPlayer = this.mLelinkPlayer;
        this.isPauseSend = false;
        if (LelinkSdkManager.getInstance().mOuterMirrorChangeListener != null) {
            LelinkSdkManager.getInstance().mOuterMirrorChangeListener.onMirrorChange(4, 1);
        }
    }

    /* access modifiers changed from: private */
    public void startResetEncoder() {
        int i10;
        try {
            if (this.mCurrentPlayer == this.mYimPlayer) {
                SourceLog.i(TAG, "current is yim ");
                i10 = 4;
            } else {
                i10 = 1;
            }
            a aVar = this.mMirrorInfos.get(i10);
            if (aVar == null) {
                SourceLog.i(TAG, "mirror info is null ");
                stop(this.mPlayInfo.getKey());
                return;
            }
            CaptureBridge.getInstance().resetCaptureEncoder(i10, aVar.f11836a, aVar.f11837b, aVar.f11838c, aVar.f11839d, aVar.f11840e);
            ConnectManager.getInstance().switchGroupConnection(i10);
            SourceLog.i(TAG, "setExternalMirrorData by startResetEncoder");
            this.isPauseSend = false;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void addVolume() {
        this.mCurrentPlayer.addVolume();
    }

    public boolean appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        return false;
    }

    public boolean clearPlayList(String str) {
        return false;
    }

    public void createCloudPlayer(boolean z10) {
        YimPlayer yimPlayer = new YimPlayer(this.mContext, this.mPlayInfo);
        this.mYimPlayer = yimPlayer;
        initListener(yimPlayer);
        this.mYimPlayer.getBridge().frozen(z10);
    }

    public void createLocalPlayer(boolean z10) {
        LelinkPlayer lelinkPlayer = new LelinkPlayer(this.mContext, this.mPlayInfo);
        this.mLelinkPlayer = lelinkPlayer;
        initListener(lelinkPlayer);
        this.mLelinkPlayer.getBridge().frozen(z10);
    }

    public void doChangeChannel(int i10) {
        int i11;
        AbsBridge absBridge;
        AbsBridge absBridge2;
        this.mHandler.removeMessages(2);
        this.isPauseSend = true;
        CaptureBridge.getInstance().pauseEncode(true);
        if (this.isStopped) {
            SourceLog.w(TAG, "doChangeChannel ignore");
            return;
        }
        SourceLog.i(TAG, "doChangeChannel " + i10);
        AbsPlayer absPlayer = this.mCurrentPlayer;
        LelinkPlayer lelinkPlayer = this.mLelinkPlayer;
        if (absPlayer == lelinkPlayer) {
            i11 = 1;
        } else {
            i11 = 4;
        }
        if (i10 != 1) {
            absBridge2 = lelinkPlayer.getBridge();
            absBridge = this.mYimPlayer.getBridge();
        } else if (lelinkPlayer == null) {
            try {
                findLocalMirrorDevice();
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        } else {
            absBridge2 = this.mYimPlayer.getBridge();
            absBridge = this.mLelinkPlayer.getBridge();
        }
        absBridge2.frozen(true);
        absBridge.frozen(false);
        if (absBridge instanceof YimBridge) {
            SourceLog.i(TAG, " Change to public Channel ");
            YimPlayer yimPlayer = this.mYimPlayer;
            this.mCurrentPlayer = yimPlayer;
            ((YimBridge) yimPlayer.getBridge()).notifySinkChange(this.onSinkChangeListener);
            this.startChangeTime = System.currentTimeMillis();
        } else {
            SourceLog.i(TAG, " Change to local Channel ");
            startResetEncoder();
        }
        if (LelinkSdkManager.getInstance().mOuterMirrorChangeListener != null) {
            LelinkSdkManager.getInstance().mOuterMirrorChangeListener.onMirrorChange(i11, i10);
        }
    }

    public void getChangeReport(int i10, int i11) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            int i12 = this.mChangeCount;
            this.mChangeCount = i12 + 1;
            jSONObject.put("bid", i12);
            jSONObject.put("cts", System.currentTimeMillis());
            if (this.mCurrentPlayer == this.mYimPlayer) {
                jSONObject.put("csb", "1");
                jSONObject.put("csa", CdnType.DIGITAL_TYPE_PCDN);
            } else {
                jSONObject.put("csb", CdnType.DIGITAL_TYPE_PCDN);
                jSONObject.put("csa", "1");
            }
            jSONObject.put(bd.f13864x, String.valueOf(i10));
            jSONObject.put(f.ac, String.valueOf(i11));
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        SourceDataReport.getInstance().onMirrorChange(this.mPlayInfo, jSONArray);
    }

    public void onAppPause() {
        this.mCurrentPlayer.onAppPause();
    }

    public void onAppResume() {
        this.mCurrentPlayer.onAppResume();
    }

    public void onWifiConnected() {
        if (this.isStopped) {
            SourceLog.w(TAG, "onWifiConnected ignore");
            ConnectManager.getInstance().groupReconnect();
            return;
        }
        this.startChangeTime = System.currentTimeMillis();
        try {
            ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DEVICEADJUSTER_STOPREQUESTDEVICE, new Object[0]);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                boolean z10;
                if (GroupPlayer.this.mCurrentPlayer == GroupPlayer.this.mYimPlayer) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                SourceLog.i(GroupPlayer.TAG, "onWifiConnected isYimPlayer   :" + z10);
                if (z10) {
                    GroupPlayer.this.mHandler.removeMessages(2);
                    if (GroupPlayer.this.mDeviceWLANCheckTask != null) {
                        GroupPlayer.this.mDeviceWLANCheckTask.cancel(true);
                    }
                    GroupPlayer groupPlayer = GroupPlayer.this;
                    GroupPlayer groupPlayer2 = GroupPlayer.this;
                    DeviceWLANCheckTask unused = groupPlayer.mDeviceWLANCheckTask = new DeviceWLANCheckTask(groupPlayer2);
                    GroupPlayer.this.mDeviceWLANCheckTask.executeOnExecutor(Executors.newCachedThreadPool(), new LelinkServiceInfo[]{GroupPlayer.this.mPlayInfo.serviceInfo});
                }
            }
        }, 1000);
    }

    public boolean pause(String str) {
        return this.mCurrentPlayer.pause(str);
    }

    public boolean playDrama(String str, String str2) {
        return false;
    }

    public boolean playNextDrama(String str) {
        return false;
    }

    public boolean playPreDrama(String str) {
        return false;
    }

    public void release(String str) {
        SourceLog.i(TAG, "release");
        LelinkPlayer lelinkPlayer = this.mLelinkPlayer;
        if (lelinkPlayer != null) {
            lelinkPlayer.release(str);
        }
        this.mLelinkPlayer = null;
        YimPlayer yimPlayer = this.mYimPlayer;
        if (yimPlayer != null) {
            yimPlayer.release(str);
        }
        this.mYimPlayer = null;
        CaptureBridge.getInstance().setICaptureDispatcher((CaptureBridge.ICaptureDispatcher) null);
        this.mCaptureDispatcher = null;
    }

    public void reportQuality() {
        IScreenCapture screenCapture = CaptureBridge.getInstance().getScreenCapture();
        if (screenCapture != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject = new JSONObject();
                int i10 = this.mQualityCount;
                this.mQualityCount = i10 + 1;
                jSONObject.put("bid", i10);
                jSONObject.put("cts", System.currentTimeMillis());
                jSONObject.put("cr", String.valueOf(screenCapture.getBitrate()));
                jSONObject.put("fr", String.valueOf(screenCapture.getFps()));
                jSONObject.put(Constants.KEY_MODE, screenCapture.getMirrorMode());
                jSONObject.put(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_CT, "arm");
                jSONObject.put("rr", screenCapture.getResolution());
                if (this.mCurrentPlayer == this.mYimPlayer) {
                    jSONObject.put("nct", CdnType.DIGITAL_TYPE_PCDN);
                } else {
                    jSONObject.put("nct", "1");
                }
                jSONObject.put("cq", "1");
                jSONObject.put(bd.f13864x, "1");
                jSONObject.put("mt", 102);
                jSONArray.put(jSONObject);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            SourceDataReport.getInstance().onQuality(this.mPlayInfo, jSONArray);
        }
    }

    public boolean resume(String str) {
        return this.mCurrentPlayer.resume(str);
    }

    public boolean seekTo(String str, int i10) {
        return this.mCurrentPlayer.seekTo(str, i10);
    }

    public void selectAudiotrack(int i10) {
        this.mCurrentPlayer.selectAudiotrack(i10);
    }

    public void setDataSource(OutParameter outParameter) {
        this.mPlayInfo = outParameter;
        this.mCurrentPlayer.setDataSource(outParameter);
    }

    public void setMirrorScreenSecret(boolean z10) {
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener2) {
        this.mCompletionListener = onCompletionListener2;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.mErrorListener = onErrorListener2;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener2) {
        this.mInfoListener = onInfoListener2;
    }

    public void setOnLoadingListener(OnLoadingListener onLoadingListener2) {
        this.mLoadingListener = onLoadingListener2;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener2) {
        this.mPreparedListener = onPreparedListener2;
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener2) {
        this.mStateChangeListener = onStateChangeListener2;
    }

    public void setOnStopListener(OnStopListener onStopListener2) {
        this.mStopListener = onStopListener2;
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        this.mCurrentPlayer.setSecondMirrorView(secondMirrorView);
    }

    public void setVolume(int i10) {
        this.mCurrentPlayer.setVolume(i10);
    }

    public void setWatermarkVisible(boolean z10) {
    }

    public boolean start(String str) {
        SourceLog.i(TAG, "start isCallPlay:" + this.isCallPlay);
        this.mHandler.sendEmptyMessageDelayed(2, 5000);
        if (this.isCallPlay) {
            return this.mCurrentPlayer.start(str);
        }
        this.isCallPlay = true;
        LelinkPlayer lelinkPlayer = this.mLelinkPlayer;
        if (lelinkPlayer != null && this.mYimPlayer != null) {
            lelinkPlayer.start(str);
            this.mYimPlayer.start(str);
        } else if (lelinkPlayer != null) {
            lelinkPlayer.start(str);
        } else {
            YimPlayer yimPlayer = this.mYimPlayer;
            if (yimPlayer != null) {
                yimPlayer.start(str);
            }
        }
        return true;
    }

    public void stop(String str) {
        SourceLog.i(TAG, "group play call stop ");
        this.isStopped = true;
        LelinkPlayer lelinkPlayer = this.mLelinkPlayer;
        if (lelinkPlayer != null) {
            lelinkPlayer.stop(str);
        }
        YimPlayer yimPlayer = this.mYimPlayer;
        if (yimPlayer != null) {
            yimPlayer.stop(str);
        }
        this.mHandler.removeMessages(1);
        this.mQualityReportEnable = false;
    }

    public void subVolume() {
        this.mCurrentPlayer.subVolume();
    }

    public boolean switchExpansionScreen(boolean z10) {
        return this.mCurrentPlayer.switchExpansionScreen(z10);
    }
}
