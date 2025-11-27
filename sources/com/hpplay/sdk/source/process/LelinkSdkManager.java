package com.hpplay.sdk.source.process;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import anet.channel.util.HttpConstant;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.asyncmanager.AsyncRunnableListener;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.common.utils.FileUtil;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.ICloudMirrorPlayListener;
import com.hpplay.sdk.source.api.ICommonListener;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.api.IDaPlayerListener;
import com.hpplay.sdk.source.api.IDebugAVListener;
import com.hpplay.sdk.source.api.IFavoriteDeviceListener;
import com.hpplay.sdk.source.api.IHistoryDeviceListener;
import com.hpplay.sdk.source.api.ILelinkPlayerListener;
import com.hpplay.sdk.source.api.ILogCallback;
import com.hpplay.sdk.source.api.IMirrorChangeListener;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.api.IReceiverPropertiesCallback;
import com.hpplay.sdk.source.api.IRelevantInfoListener;
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.ISendPassCallback;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;
import com.hpplay.sdk.source.api.IUploadLogQueryListener;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.BrowserConfigBean;
import com.hpplay.sdk.source.bean.DanmakuBean;
import com.hpplay.sdk.source.bean.DanmakuPropertyBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.HeicBean;
import com.hpplay.sdk.source.bean.HistoryConfigBean;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.ReceiverPropertyBean;
import com.hpplay.sdk.source.bean.ServiceInfoParseBean;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.bean.VipAuthSetting;
import com.hpplay.sdk.source.browse.api.AuthListener;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IAPICallbackListener;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.api.OptionCentral;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.PlayController;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.FavoriteDeviceManager;
import com.hpplay.sdk.source.business.cloud.HistoryDeviceManager;
import com.hpplay.sdk.source.business.cloud.LicenseManager;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.da.e;
import com.hpplay.sdk.source.device.Device;
import com.hpplay.sdk.source.device.DeviceCodeResolver;
import com.hpplay.sdk.source.device.ServiceUpdater;
import com.hpplay.sdk.source.localserver.LelinkServerInstance;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.mirror.yim.YimMirror;
import com.hpplay.sdk.source.mirror.yim.render.MirrorPlayerActivity;
import com.hpplay.sdk.source.pass.HarassCode;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.pass.sinkkey.SinkKeyEventDispatcher;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventDispatcher;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventMonitor;
import com.hpplay.sdk.source.permission.ContextCompat;
import com.hpplay.sdk.source.permission.OnRequestPermissionListener;
import com.hpplay.sdk.source.permission.PermissionBridgeActivity;
import com.hpplay.sdk.source.process.DevicePreChecker;
import com.hpplay.sdk.source.process.OnlineManager;
import com.hpplay.sdk.source.process.PushFailedRetryManager;
import com.hpplay.sdk.source.protocol.CaptureBridge;
import com.hpplay.sdk.source.protocol.browser.BrowserBridge;
import com.hpplay.sdk.source.protocol.browser.BrowserHistory;
import com.hpplay.sdk.source.protocol.browser.ble.BleProxy;
import com.hpplay.sdk.source.protocol.browser.sonic.SonicProxy;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.protocol.connect.OnConnectIMListener;
import com.hpplay.sdk.source.transceiver.bean.NotifyMirrorBean;
import com.hpplay.sdk.source.utils.AppContextUtils;
import com.hpplay.sdk.source.utils.BrowseResultOnlineCheck;
import com.hpplay.sdk.source.utils.BrowserResolver;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CrashHandler;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.hpplay.sdk.source.utils.Feature;
import com.hpplay.sdk.source.utils.LeboUtil;
import com.hpplay.sdk.source.utils.LogUpload;
import com.hpplay.sdk.source.utils.UploadLogCallback;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class LelinkSdkManager {
    private static final int DELAY_DELETE_HEIC_IMG = 60000;
    private static final int DELAY_NOTIFY_LIST = 500;
    private static final int DELAY_PUSH_FAILED_RESEARCH_DELAY_TIME = 5000;
    private static final int MAX_PLAY_LIST_SIZE = 100;
    private static final int PARSER_TYPE_CREATE_LELINK_SERVICE = 3;
    private static final int PARSER_TYPE_PINCODE = 2;
    private static final int PARSER_TYPE_QR = 1;
    private static final String TAG = "LelinkSdkManager";
    private static final int WHAT_DELAY_CAST = 3;
    private static final int WHAT_DELAY_DEVICE_OFFLINE = 4;
    private static final int WHAT_DELAY_NOTIFY_LIST = 1;
    private static final int WHAT_DELETE_HEIC_IMG = 2;
    private static boolean mIsFirstBrowser = true;
    private static LelinkSdkManager sInstance;
    public long mAuthSuccessTime = -1;
    private BrowserConfigBean mBrowserConfig;
    private BrowserDispatcher mBrowserDispatcher = new BrowserDispatcher();
    private BrowserThread mBrowserThread;
    private long mBrowserTimeStamp = -1;
    /* access modifiers changed from: private */
    public Context mContext;
    private DevicePreChecker mDevicePreChecker;
    private Activity mExpandActivity = null;
    private View mExpandView = null;
    public int mExpireTime = 0;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                LelinkSdkManager.this.notifyBrowseList();
            } else if (i10 == 2) {
                SourceLog.i(LelinkSdkManager.TAG, "msg, delete heic img");
                final String str = (String) message.obj;
                AsyncManager.getInstance().exeRunnable(new Runnable() {
                    public void run() {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }, (AsyncRunnableListener) null);
            } else if (i10 == 3) {
                SourceLog.i(LelinkSdkManager.TAG, "msg, heic img delay cast");
                HeicBean heicBean = (HeicBean) message.obj;
                if (heicBean == null) {
                    SourceLog.w(LelinkSdkManager.TAG, "value is invalid");
                    return false;
                }
                LelinkSdkManager.this.dispatchPlayMedia(heicBean.lelinkServiceInfo, heicBean.lelinkPlayerInfo, heicBean.path, heicBean.type);
            } else if (i10 == 4 && BusinessEntity.getInstance().getListenerDispatcher() != null) {
                OutParameter outParameter = new OutParameter();
                Object obj = message.obj;
                if (obj != null) {
                    outParameter = (OutParameter) obj;
                }
                BusinessEntity.getInstance().getListenerDispatcher().onError(outParameter, 210010, 210004, " pre check offline ");
            }
            return false;
        }
    });
    private LelinkPlayerInfo mMirrorPlayInfo;
    private NetworkReceiver mNetworkChangeReceiver = null;
    private OnlineCheckThread mOnlineCheckThread;
    /* access modifiers changed from: private */
    public AuthListener mOuterAuthListener = null;
    public ICloudMirrorPlayListener mOuterCloudMirrorPlayListener;
    public IMirrorChangeListener mOuterMirrorChangeListener;
    /* access modifiers changed from: private */
    public IServiceInfoListParseListener mOuterParseListListener;
    /* access modifiers changed from: private */
    public IServiceInfoParseListener mOuterParseListener;
    public IRelevantInfoListener mOuterRelevantInfoListener;
    private AuthListener mOwnerAuthListener = new AuthListener() {
        public void onAuthFailed(int i10) {
            Session.getInstance().isFirstBoot = false;
            if (LelinkSdkManager.this.mOuterAuthListener != null) {
                LelinkSdkManager.this.mOuterAuthListener.onAuthFailed(i10);
            }
        }

        public void onAuthSuccess(String str, String str2) {
            Session.getInstance().isFirstBoot = false;
            if (LelinkSdkManager.this.mOuterAuthListener != null) {
                LelinkSdkManager.this.mOuterAuthListener.onAuthSuccess(str, str2);
            }
            LelinkSdkManager.this.mAuthSuccessTime = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(str2).getJSONObject("data");
                LelinkSdkManager.this.mExpireTime = jSONObject.getInt("expire_time");
                SourceLog.i(LelinkSdkManager.TAG, "onAuthSuccess: expireTime =" + LelinkSdkManager.this.mExpireTime);
            } catch (Exception e10) {
                SourceLog.w(LelinkSdkManager.TAG, (Throwable) e10);
            }
        }
    };
    private IServiceInfoParseListener mOwnerBlueToothListener = new IServiceInfoParseListener() {
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            BrowserResolver.updateServiceList(lelinkServiceInfo);
        }
    };
    private IServiceInfoParseListener mOwnerHistoryListener = new IServiceInfoParseListener() {
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            BrowserResolver.updateServiceList(lelinkServiceInfo);
        }
    };
    /* access modifiers changed from: private */
    public IServiceInfoListParseListener mOwnerParseListListener = new IServiceInfoListParseListener() {
        public void onParseResult(List<ServiceInfoParseBean> list) {
            if (LelinkSdkManager.this.mOuterParseListListener != null) {
                BrowserResolver.updateParseServiceList(list);
                LelinkSdkManager.this.mOuterParseListListener.onParseResult(list);
            }
        }
    };
    /* access modifiers changed from: private */
    public IServiceInfoParseListener mOwnerParseListener = new IServiceInfoParseListener() {
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            if (LelinkSdkManager.this.mOuterParseListener != null) {
                LelinkSdkManager.this.mOuterParseListener.onParseResult(i10, BrowserResolver.updateServiceList(lelinkServiceInfo));
            }
        }
    };
    private IServiceInfoParseListener mOwnerSonicPinParseListener = new IServiceInfoParseListener() {
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            BrowserResolver.updateServiceList(lelinkServiceInfo);
        }
    };
    public ISendPassCallback mPassCallback;
    public OnRequestPermissionListener mPermissionListener = null;
    private long mPreBrowserTime = 0;
    public IReceiverPropertiesCallback mReceiverPropertiesCallback;
    private final AtomicBoolean mRetryMirrorOnce = new AtomicBoolean(false);
    public ISearchBannerDataCallback mSearchBannerDataCallback;
    private SecondMirrorView mSecondMirrorView = null;
    private TimeTickReceiver mTimeTickReceiver = null;

    public static class CheckConnectListener implements IConnectListener {
        private final ConnectCallback callback;
        private final boolean isGroup;
        private final LelinkServiceInfo mServiceInfo;

        public CheckConnectListener(LelinkServiceInfo lelinkServiceInfo, ConnectCallback connectCallback, boolean z10) {
            this.mServiceInfo = lelinkServiceInfo;
            this.callback = connectCallback;
            this.isGroup = z10;
        }

        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            LelinkServiceInfo lelinkServiceInfo2 = this.mServiceInfo;
            if (lelinkServiceInfo2 == null || lelinkServiceInfo == null || !lelinkServiceInfo.equals(lelinkServiceInfo2)) {
                SourceLog.i(LelinkSdkManager.TAG, "CheckConnectListener  onConnect, ignore ");
                return;
            }
            SourceLog.i(LelinkSdkManager.TAG, "CheckConnectListener  onConnect");
            this.callback.onConnect(i10, this.isGroup);
            ConnectManager.getInstance().removeConnectCheckListener(this);
        }

        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            SourceLog.i(LelinkSdkManager.TAG, "onDisconnect");
        }
    }

    public interface ConnectCallback {
        void onConnect(int i10, boolean z10);
    }

    public class DevicePreCheckCallback implements DevicePreChecker.OnDevicePreCheckResultCallback {
        /* access modifiers changed from: private */
        public LelinkPlayerInfo lelinkPlayerInfo;

        public DevicePreCheckCallback(LelinkPlayerInfo lelinkPlayerInfo2) {
            this.lelinkPlayerInfo = lelinkPlayerInfo2;
        }

        public void onResult(LelinkServiceInfo lelinkServiceInfo, int i10) {
            try {
                SourceLog.i(LelinkSdkManager.TAG, "DevicePreCheckCallback : " + i10);
                if (i10 == 0 || i10 == 2) {
                    ConnectManager.getInstance().disconnect(lelinkServiceInfo);
                }
                LelinkSdkManager lelinkSdkManager = LelinkSdkManager.this;
                LelinkPlayerInfo lelinkPlayerInfo2 = this.lelinkPlayerInfo;
                OutParameter access$700 = lelinkSdkManager.getOutParameter(lelinkServiceInfo, lelinkPlayerInfo2, lelinkPlayerInfo2.getUrl(), this.lelinkPlayerInfo.getType());
                if (i10 != 0) {
                    this.lelinkPlayerInfo.setLelinkServiceInfo(lelinkServiceInfo);
                    LelinkSdkManager.this.startPlay(this.lelinkPlayerInfo);
                } else if (NetworkUtil.isWifiConnected(LelinkSdkManager.this.mContext)) {
                    PushFailedRetryManager.getInstance().connectFailedRetry(lelinkServiceInfo, new PushFailedRetryManager.ConnectRetryListener() {
                        public void onLelinkServiceInfoCallback(LelinkServiceInfo lelinkServiceInfo) {
                            LelinkSdkManager.this.mHandler.removeMessages(4);
                            DevicePreCheckCallback.this.lelinkPlayerInfo.setLelinkServiceInfo(lelinkServiceInfo);
                            DevicePreCheckCallback devicePreCheckCallback = DevicePreCheckCallback.this;
                            LelinkSdkManager.this.startPlay(devicePreCheckCallback.lelinkPlayerInfo);
                            PushFailedRetryManager.getInstance().stopRetry();
                        }
                    });
                    LelinkSdkManager.this.mHandler.sendMessageDelayed(Message.obtain((Handler) null, 4, access$700), 5000);
                } else {
                    LelinkSdkManager.this.mHandler.sendMessageDelayed(Message.obtain((Handler) null, 4, access$700), 5000);
                }
            } catch (Exception e10) {
                SourceLog.w(LelinkSdkManager.TAG, (Throwable) e10);
            }
        }
    }

    private LelinkSdkManager() {
    }

    private void bleBrowse() {
        if (1 == LelinkConfig.isBrowserBlueToothEnable(this.mContext)) {
            SourceLog.i(TAG, "bleBrowse");
            BleProxy.setServiceInfoParseListener(this.mOwnerBlueToothListener);
            if (BleProxy.startBrowse(this.mContext)) {
                BrowserHistory.getInstance().startBLEBrowser();
            }
        } else {
            SourceLog.i(TAG, "bleBrowse ignore");
        }
        if (1 != LelinkConfig.isPublishBlueToothEnable(this.mContext)) {
            SourceDataReport.getInstance().onBlePublish(0, (String) null);
            return;
        }
        if (!PublicCastClient.getInstance().isConnectedServer()) {
            PublicCastClient.getInstance().connectServer(CloudAPI.sImServer, a.a(), (OnConnectIMListener) null);
        } else {
            SourceLog.i(TAG, "bleBrowse startPublish");
            BleProxy.startPublish(this.mContext, Preference.getInstance().get(Preference.KEY_DEVICE_ID));
        }
        ServiceUpdater.getInstance().updateServiceInfo(this.mContext);
    }

    private boolean canDisableDLNA() {
        if (Feature.isMUIChannel() || Feature.isKangka() || Feature.isOPPOChannel() || Feature.isVivoChannel() || Feature.isSmartis() || Feature.isNubiaChannel() || Feature.isYoulexueChannel() || Feature.isLeboApp() || Feature.isHweiChannel() || Feature.isHappyTest()) {
            return true;
        }
        return false;
    }

    private boolean canReverseControl() {
        if (Feature.isLeboApp()) {
            return true;
        }
        SourceLog.i(TAG, "canReverseControl " + LelinkConfig.isReverseControlEnable());
        if (LelinkConfig.isReverseControlEnable()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void checkConnect(LelinkServiceInfo lelinkServiceInfo, ConnectCallback connectCallback, boolean z10) {
        if (lelinkServiceInfo == null) {
            SourceLog.w(TAG, "checkConnect ignore, serviceInfo is null");
            return;
        }
        SourceLog.w(TAG, "checkConnect " + z10);
        if (ConnectManager.getInstance().getConnectSession(lelinkServiceInfo, z10) != null) {
            SourceLog.i(TAG, "checkConnect: connect inner " + lelinkServiceInfo.getName() + Operator.Operation.DIVISION + lelinkServiceInfo.getIp());
            ConnectManager.getInstance().resetLastConnectBridge(lelinkServiceInfo);
            int connectProtocol = ConnectManager.getInstance().getConnectProtocol(lelinkServiceInfo);
            SourceLog.i(TAG, "connectProtocol : " + connectProtocol);
            if (connectProtocol != -1) {
                SourceLog.i(TAG, " do onConnect callback : " + connectProtocol);
                connectCallback.onConnect(connectProtocol, z10);
                return;
            }
            SourceLog.i(TAG, "checkConnect: has no valid protocol " + lelinkServiceInfo.getName() + Operator.Operation.DIVISION + lelinkServiceInfo.getIp());
            ConnectManager.getInstance().removeBridge(lelinkServiceInfo);
            SourceLog.i(TAG, "checkConnect: connect inner " + lelinkServiceInfo.getName() + Operator.Operation.DIVISION + lelinkServiceInfo.getIp());
        }
        ConnectManager.getInstance().setConnectCheckListener(new CheckConnectListener(lelinkServiceInfo, connectCallback, z10));
        ConnectManager.getInstance().connect(this.mContext, lelinkServiceInfo, z10);
    }

    private void checkDevice(LelinkServiceInfo lelinkServiceInfo, final ConnectCallback connectCallback, final boolean z10) {
        boolean z11;
        LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        if (!z10) {
            z11 = ConnectManager.getInstance().checkOnline(findSameServiceInfo, new OnlineManager.OnlineListener() {
                public void OnLineCheckResult(LelinkServiceInfo lelinkServiceInfo, boolean z10) {
                    if (z10) {
                        LelinkSdkManager.this.checkConnect(lelinkServiceInfo, connectCallback, z10);
                    } else {
                        ConnectManager.getInstance().notifyInvalid(lelinkServiceInfo);
                    }
                }
            });
        } else {
            z11 = false;
        }
        if (!z11) {
            checkConnect(findSameServiceInfo, connectCallback, z10);
        }
    }

    private void checkLicense(final LicenseManager.ILicenseCheckListener iLicenseCheckListener) {
        if (LelinkConfig.isSdkFree()) {
            iLicenseCheckListener.checkLicense(true);
        } else if (!LelinkConfig.isLicenseMode()) {
            SourceLog.e(TAG, "checkLicense ignore, sdk is not free, do you forget to set permission mode?");
        } else {
            LicenseManager.getInstance().checkLicense(new LicenseManager.ILicenseCheckListener() {
                public void checkLicense(boolean z10) {
                    iLicenseCheckListener.checkLicense(z10);
                }
            });
        }
    }

    private void createListBySinkServer(List<SinkParameterBean> list) {
        final ArrayList arrayList = new ArrayList();
        for (final SinkParameterBean next : list) {
            Device.createBySinkServer(next.ip, next.port, new IServiceInfoParseListener() {
                public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
                    String str = next.uid;
                    if (str == null) {
                        str = null;
                    }
                    arrayList.add(new ServiceInfoParseBean(i10, str, lelinkServiceInfo));
                    LelinkSdkManager.this.mOwnerParseListListener.onParseResult(arrayList);
                }
            });
        }
    }

    private void deleteHeicFileDir() {
        SourceLog.i(TAG, "deleteHeicFileDir");
        AsyncManager.getInstance().exeRunnable(new Runnable() {
            public void run() {
                String heicDirPath = LelinkServerInstance.getInstance().getHeicDirPath();
                if (!TextUtils.isEmpty(heicDirPath)) {
                    FileUtil.deleteFile(heicDirPath);
                }
            }
        }, (AsyncRunnableListener) null);
    }

    private void dispatchMirror(Intent intent, LelinkPlayerInfo lelinkPlayerInfo, boolean z10, boolean z11) {
        View view;
        SourceLog.w(TAG, "dispatchMirror ,mirrorIntent:" + intent);
        if (lelinkPlayerInfo == null) {
            SourceLog.w(TAG, "dispatchMirror ignore,invalid playerInfo");
            if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError((OutParameter) null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_INVALID_INPUT);
                return;
            }
            return;
        }
        OutParameter outParameter = new OutParameter();
        outParameter.castType = 2;
        outParameter.mimeType = 102;
        outParameter.mirrorIntent = intent;
        outParameter.originPlayerInfo = lelinkPlayerInfo;
        outParameter.isMultiCast = z11;
        if (lelinkPlayerInfo.getLelinkServiceInfo() == null) {
            outParameter.serviceInfo = ConnectManager.getInstance().getLastServiceInfo();
        } else {
            LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkPlayerInfo.getLelinkServiceInfo());
            lelinkPlayerInfo.setLelinkServiceInfo(findSameServiceInfo);
            outParameter.serviceInfo = findSameServiceInfo;
        }
        if (outParameter.serviceInfo == null) {
            SourceLog.w(TAG, "dispatchMirror ignore,invalid service info");
            if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError((OutParameter) null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_INVALID_INPUT);
                return;
            }
            return;
        }
        SourceLog.i(TAG, "dispatchMirror " + outParameter.serviceInfo.getName() + " / " + lelinkPlayerInfo.getMirrorSendTimeout());
        outParameter.mirrorResLevel = lelinkPlayerInfo.getResolutionLevel();
        outParameter.mirrorBitRateLevel = lelinkPlayerInfo.getBitRateLevel();
        outParameter.mirrorAudioType = lelinkPlayerInfo.getMirrorAudioType();
        outParameter.requestAudioFocus = lelinkPlayerInfo.isRequestAudioFocus();
        outParameter.fullScreenType = lelinkPlayerInfo.getFullScreen();
        outParameter.isAutoBitrate = lelinkPlayerInfo.isAutoBitrate();
        outParameter.session = getSessionId(outParameter.serviceInfo);
        outParameter.urlID = CreateUtil.createMirrorUri();
        outParameter.mirrorSendTimeout = lelinkPlayerInfo.getMirrorSendTimeout();
        outParameter.isExpandMirror = z10;
        if (z10) {
            Activity activity = this.mExpandActivity;
            if (activity == null || (view = this.mExpandView) == null) {
                SourceLog.w(TAG, "dispatchMirror ExpansionScreen ignore");
                if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                    BusinessEntity.getInstance().getListenerDispatcher().onError((OutParameter) null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_INVALID_INPUT);
                    return;
                }
                return;
            }
            outParameter.expandActivity = activity;
            outParameter.expandView = view;
            outParameter.secondMirrorView = this.mSecondMirrorView;
        }
        outParameter.isGroup = CastUtil.isSupportMultiChannel(outParameter.serviceInfo);
        outParameter.password = lelinkPlayerInfo.getCastPwd();
        checkDevice(outParameter.serviceInfo, new MirrorConnectCallback(this.mContext, outParameter, lelinkPlayerInfo), outParameter.isGroup);
        CastUtil.printSDKInfo();
    }

    /* access modifiers changed from: private */
    public void dispatchPlayMedia(LelinkServiceInfo lelinkServiceInfo, LelinkPlayerInfo lelinkPlayerInfo, String str, int i10) {
        OutParameter outParameter = getOutParameter(lelinkServiceInfo, lelinkPlayerInfo, str, i10);
        if (outParameter != null) {
            checkDevice(outParameter.serviceInfo, new PushConnectCallback(this.mContext, outParameter, lelinkPlayerInfo, lelinkServiceInfo), false);
            CastUtil.printSDKInfo();
            SourceLog.i(TAG, "startPlayMedia " + outParameter.getPlayUrl());
        }
    }

    private void enableLog(boolean z10) {
        SourceLog.i(TAG, "enableLog," + z10);
        if (this.mContext == null) {
            SourceLog.i(TAG, "enableLog,value is invalid");
            return;
        }
        if (z10) {
            if (Feature.isLeboApp() || Feature.isHappyTest()) {
                SourceLog.enableLogWriter(this.mContext.getApplicationContext(), 100);
            } else {
                SourceLog.enableLogWriter(this.mContext.getApplicationContext(), 1);
            }
        } else if (Feature.isLeboApp() || Feature.isHappyTest()) {
            SourceLog.disableLog(this.mContext.getApplicationContext(), 100);
        } else {
            SourceLog.disableLog(this.mContext.getApplicationContext(), 1);
        }
        CLog.enableTrace(z10);
    }

    private LelinkServiceInfo findSameServiceInfo(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null || this.mBrowserDispatcher.getBrowserList() == null) {
            SourceLog.i(TAG, "findSameServiceInfo ignore " + lelinkServiceInfo + "\n" + this.mBrowserDispatcher.getBrowserList());
            return lelinkServiceInfo;
        }
        try {
            for (LelinkServiceInfo next : this.mBrowserDispatcher.getBrowserList()) {
                if (next.equals(lelinkServiceInfo)) {
                    return next;
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        SourceLog.w(TAG, "not findSameServiceInfo, use outside info " + lelinkServiceInfo);
        return lelinkServiceInfo;
    }

    public static synchronized LelinkSdkManager getInstance() {
        LelinkSdkManager lelinkSdkManager;
        synchronized (LelinkSdkManager.class) {
            synchronized (LelinkSdkManager.class) {
                if (sInstance == null) {
                    sInstance = new LelinkSdkManager();
                }
                lelinkSdkManager = sInstance;
            }
        }
        return lelinkSdkManager;
    }

    /* access modifiers changed from: private */
    public OutParameter getOutParameter(LelinkServiceInfo lelinkServiceInfo, LelinkPlayerInfo lelinkPlayerInfo, String str, int i10) {
        OutParameter outParameter = new OutParameter();
        outParameter.setUrl(str);
        if (lelinkPlayerInfo != null) {
            outParameter.urls = lelinkPlayerInfo.getUrlList();
            outParameter.period = lelinkPlayerInfo.getPeriod();
            outParameter.headLength = lelinkPlayerInfo.getHeadDuration();
            outParameter.tailLength = lelinkPlayerInfo.getTailDuration();
            String dramaID = lelinkPlayerInfo.getDramaID();
            outParameter.dramaID = dramaID;
            DramaInfoBean[] dramaInfoBeanArr = outParameter.urls;
            if (dramaInfoBeanArr != null && dramaInfoBeanArr.length > 0 && (TextUtils.isEmpty(dramaID) || outParameter.urls.length > 100)) {
                if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                    BusinessEntity.getInstance().getListenerDispatcher().onError((OutParameter) null, 210000, 100000);
                }
                return null;
            }
        }
        SourceLog.i(TAG, "startPlayMedia " + outParameter.getPlayUrl());
        outParameter.mimeType = i10;
        outParameter.castType = 1;
        outParameter.originPlayerInfo = lelinkPlayerInfo;
        outParameter.serviceInfo = lelinkServiceInfo;
        if (lelinkPlayerInfo != null) {
            outParameter.playerInfoBean = lelinkPlayerInfo.getPlayInfoBean();
            outParameter.mediaAssetBean = lelinkPlayerInfo.getMediaAsset();
            outParameter.microAppInfoBean = lelinkPlayerInfo.getMicroAppInfoBean();
            outParameter.startPosition = lelinkPlayerInfo.getStartPosition();
            MediaAssetBean mediaAssetBean = outParameter.mediaAssetBean;
            if (mediaAssetBean != null) {
                outParameter.duration = (int) mediaAssetBean.getDuration();
            }
            outParameter.password = lelinkPlayerInfo.getCastPwd();
            outParameter.retryDLNAHttp = lelinkPlayerInfo.isRetryDLNAHttp();
        }
        outParameter.urlID = CreateUtil.createPushUri(outParameter.getPlayUrl());
        outParameter.session = getSessionId(lelinkServiceInfo);
        return outParameter;
    }

    private LelinkServiceInfo getPlayServiceInfo(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkServiceInfo lelinkServiceInfo = lelinkPlayerInfo.getLelinkServiceInfo();
        if (lelinkServiceInfo != null || CastUtil.isSupportCloudMultiCast()) {
            LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
            lelinkPlayerInfo.setLelinkServiceInfo(findSameServiceInfo);
            return findSameServiceInfo;
        }
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo == null) {
            SourceLog.w(TAG, "startPlayMedia ignore ,there has no valid service info");
            return null;
        }
        SourceLog.w(TAG, "startPlayMedia has no service info, use last connect service info " + lastServiceInfo.getName() + Operator.Operation.DIVISION + lastServiceInfo.getIp());
        lelinkPlayerInfo.setLelinkServiceInfo(lastServiceInfo);
        return lastServiceInfo;
    }

    private String getSessionId(LelinkServiceInfo lelinkServiceInfo) {
        ConnectBridge connectBridge;
        if (lelinkServiceInfo == null || TextUtils.isEmpty(lelinkServiceInfo.getUid()) || (connectBridge = ConnectManager.getInstance().getConnectBridge(lelinkServiceInfo.getUid())) == null || TextUtils.isEmpty(connectBridge.getConnectSession())) {
            return CreateUtil.createSessionId();
        }
        return connectBridge.getConnectSession();
    }

    /* access modifiers changed from: private */
    public String heicChangeToJpeg(String str, String str2) {
        String heicToJpegPath = LelinkServerInstance.getInstance().getHeicToJpegPath(str);
        if (!TextUtils.isEmpty(heicToJpegPath)) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = heicToJpegPath;
            this.mHandler.sendMessageDelayed(obtainMessage, 60000);
            str = heicToJpegPath;
        }
        return LelinkServerInstance.getInstance().getFileDownloadUrl(str, str2);
    }

    private boolean isControllerMirroring(PlayController playController) {
        OutParameter playInfo;
        if (playController == null || (playInfo = playController.getPlayInfo()) == null) {
            return false;
        }
        int currentPlayState = playController.getCurrentPlayState();
        if (playInfo.castType != 2) {
            return false;
        }
        if (currentPlayState == 1 || currentPlayState == 5 || currentPlayState == 11) {
            return true;
        }
        return false;
    }

    private boolean isControllerPusing(PlayController playController) {
        if (playController == null) {
            return false;
        }
        return playController.isInPlaybackState();
    }

    private boolean isMirroring() {
        Iterator<PlayController> it = BusinessEntity.getInstance().getControllers().iterator();
        while (it.hasNext()) {
            if (isControllerMirroring(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean isPushing() {
        Iterator<PlayController> it = BusinessEntity.getInstance().getControllers().iterator();
        while (it.hasNext()) {
            if (isControllerPusing(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void registerReceiver() {
        if (this.mNetworkChangeReceiver == null) {
            this.mNetworkChangeReceiver = new NetworkReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.mContext.registerReceiver(this.mNetworkChangeReceiver, intentFilter);
        }
        if (this.mTimeTickReceiver == null) {
            this.mTimeTickReceiver = new TimeTickReceiver();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.TIME_TICK");
            this.mContext.registerReceiver(this.mTimeTickReceiver, intentFilter2);
        }
    }

    private void setConferenceBrowseListener(Object[] objArr) {
        SourceLog.i(TAG, "LEBO_OPTION_23 value: " + objArr[0]);
    }

    private void setConferenceServerUrl(Object[] objArr) {
        if (objArr.length < 1) {
            SourceLog.i(TAG, "setConferenceServerUrl need more parameter");
            return;
        }
        SourceLog.i(TAG, "setConferenceServerUrl: " + objArr[0]);
        Object obj = objArr[0];
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.startsWith(HttpConstant.HTTP)) {
                if (obj2.endsWith(Operator.Operation.DIVISION)) {
                    CloudAPI.sConferenceRoot = obj2.substring(0, obj2.lastIndexOf(Operator.Operation.DIVISION));
                } else {
                    CloudAPI.sConferenceRoot = obj2;
                }
                CloudAPI.updateDynamicUrls();
                return;
            }
            return;
        }
        SourceLog.w(TAG, "setConferenceServerUrl values is Invalid");
    }

    private void setStaffInfo(Object[] objArr) {
        if (objArr.length < 2) {
            SourceLog.i(TAG, "setStaffInfo need more parameter");
            return;
        }
        String str = objArr[0];
        String str2 = objArr[1];
        SourceLog.i(TAG, "setStaffInfo value0:" + str + " value1:" + str2);
        if ((str instanceof String) && (str2 instanceof String)) {
            Session.getInstance().department = str;
            Session.getInstance().jobNumber = str2;
        }
    }

    private void sonicBrowse() {
        if (SonicProxy.canStartSonicBrowse(this.mContext)) {
            SonicProxy.setServiceInfoParseListener(this.mOwnerSonicPinParseListener);
            if (SonicProxy.startBrowse(this.mContext)) {
                BrowserHistory.getInstance().startSonicBrowser();
                return;
            }
            return;
        }
        SourceLog.w(TAG, "browse has no permission to use sonic");
    }

    /* access modifiers changed from: private */
    public void startBrowseInValidLicense(BrowserConfigBean browserConfigBean) {
        if (System.currentTimeMillis() - this.mPreBrowserTime < 200) {
            SourceLog.w(TAG, "startBrowseThread ignore, space less than 200ms");
        } else if (browserConfigBean == null) {
            SourceLog.w(TAG, "startBrowseThread ignore, invalid input");
        } else {
            BrowserThread browserThread = this.mBrowserThread;
            if (browserThread == null || !browserThread.isAlive()) {
                BrowserThread browserThread2 = new BrowserThread(browserConfigBean);
                this.mBrowserThread = browserThread2;
                browserThread2.start();
            } else {
                this.mBrowserThread.setConfigBean(browserConfigBean);
            }
            SourceLog.i(TAG, "startBrowseThread " + this.mBrowserThread.isAlive());
            this.mBrowserThread.startBrowse();
            this.mPreBrowserTime = System.currentTimeMillis();
        }
    }

    private void startGetSDCardPermission(Context context) {
        Intent intent = new Intent(context, PermissionBridgeActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(PermissionBridgeActivity.KEY_PERMISSION_TYPE, 2);
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void startMirrorAfterCheck(Intent intent, LelinkPlayerInfo lelinkPlayerInfo, boolean z10) {
        if (lelinkPlayerInfo.getSubMirrorInfos() == null || lelinkPlayerInfo.getSubMirrorInfos().size() <= 0) {
            BusinessEntity.getInstance().enableMultiCast(false);
            dispatchMirror(intent, lelinkPlayerInfo, z10, false);
            return;
        }
        BusinessEntity.getInstance().release();
        if (Feature.hasCloudMirror()) {
            YimMirror.getInstance().resetMultiCast();
        }
        BusinessEntity.getInstance().enableMultiCast(true);
        Iterator<LelinkServiceInfo> it = lelinkPlayerInfo.getSubMirrorInfos().iterator();
        while (it.hasNext()) {
            LelinkPlayerInfo cloneNoSubDevice = lelinkPlayerInfo.cloneNoSubDevice();
            cloneNoSubDevice.setLelinkServiceInfo(it.next());
            dispatchMirror(intent, cloneNoSubDevice, z10, true);
        }
    }

    /* access modifiers changed from: private */
    public void startPlay(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkServiceInfo playServiceInfo = getPlayServiceInfo(lelinkPlayerInfo);
        if (playServiceInfo != null) {
            if (!TextUtils.isEmpty(lelinkPlayerInfo.getLocalPath())) {
                startPlayMedia(playServiceInfo, lelinkPlayerInfo, lelinkPlayerInfo.getLocalPath(), lelinkPlayerInfo.getType(), true);
            } else if (lelinkPlayerInfo.getLocalUri() != null) {
                startPlayMedia(playServiceInfo, lelinkPlayerInfo, lelinkPlayerInfo.getLocalUri().toString(), lelinkPlayerInfo.getType(), true);
            } else {
                startPlayMedia(playServiceInfo, lelinkPlayerInfo, lelinkPlayerInfo.getUrl(), lelinkPlayerInfo.getType(), false);
            }
        }
    }

    private void startPlayMediaAfterCheck(LelinkServiceInfo lelinkServiceInfo, LelinkPlayerInfo lelinkPlayerInfo, String str, int i10) {
        if (lelinkPlayerInfo.getSubMirrorInfos() == null || lelinkPlayerInfo.getSubMirrorInfos().size() <= 0) {
            BusinessEntity.getInstance().enableMultiCast(false);
            dispatchPlayMedia(lelinkServiceInfo, lelinkPlayerInfo, str, i10);
            return;
        }
        BusinessEntity.getInstance().enableMultiCast(true);
        Iterator<LelinkServiceInfo> it = lelinkPlayerInfo.getSubMirrorInfos().iterator();
        while (it.hasNext()) {
            LelinkServiceInfo next = it.next();
            lelinkPlayerInfo.cloneNoSubDevice().setLelinkServiceInfo(next);
            dispatchPlayMedia(next, lelinkPlayerInfo, str, i10);
        }
    }

    private void unregisterReceiver() {
        NetworkReceiver networkReceiver = this.mNetworkChangeReceiver;
        if (networkReceiver != null) {
            try {
                this.mContext.unregisterReceiver(networkReceiver);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            this.mNetworkChangeReceiver = null;
        }
        TimeTickReceiver timeTickReceiver = this.mTimeTickReceiver;
        if (timeTickReceiver != null) {
            try {
                this.mContext.unregisterReceiver(timeTickReceiver);
            } catch (Exception e11) {
                SourceLog.w(TAG, (Throwable) e11);
            }
        }
    }

    private void uploadLogQuery() {
        SourceLog.w(TAG, "uploadLogQuery");
        LogUpload.uploadLogFileQuery(this.mContext, new IUploadLogQueryListener() {
            public void onError() {
                SourceLog.w(LelinkSdkManager.TAG, "uploadLogQuery error");
            }

            public void onQueryResult(String str) {
                try {
                    SourceLog.w(LelinkSdkManager.TAG, "log query result = " + str);
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(Constants.KEY_HTTP_CODE);
                    jSONObject.optString(Constant.KEY_MSG);
                    int optInt2 = jSONObject.optInt("report_err");
                    int optInt3 = jSONObject.optInt("eid");
                    if (optInt == 200 && optInt2 != 0) {
                        Context access$500 = LelinkSdkManager.this.mContext;
                        LogUpload.uploadLogFile(access$500, optInt3 + "", (String) null, "", "", (UploadLogCallback) null);
                    }
                } catch (Exception e10) {
                    SourceLog.w(LelinkSdkManager.TAG, (Throwable) e10);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void uploadLogStatus(int i10) {
        int i11;
        if (i10 != 200) {
            i11 = -1;
            if (i10 != 202) {
                if (i10 == 400) {
                    i11 = 2;
                } else if (i10 == 405) {
                    i11 = 4;
                } else if (i10 == 406) {
                    i11 = 3;
                }
            }
        } else {
            i11 = 1;
        }
        IRelevantInfoListener iRelevantInfoListener = this.mOuterRelevantInfoListener;
        if (iRelevantInfoListener != null) {
            iRelevantInfoListener.onReverseInfoResult(IAPI.OPTION_UPLOAD_LOG, i11 + "");
        }
    }

    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        FavoriteDeviceManager.getInstance().addFavoriteDevice(lelinkServiceInfo);
    }

    public void addPinCodeToLelinkServiceInfo(final String str) {
        SourceLog.i(TAG, "addPinCodeToLelinkServiceInfo " + str);
        checkLicense(new LicenseManager.ILicenseCheckListener() {
            public void checkLicense(boolean z10) {
                if (z10) {
                    BrowserHistory.getInstance().startPinCodeBrowser();
                    Device.addPinCodeServiceInfo(LelinkSdkManager.this.mContext, str, LelinkSdkManager.this.mOwnerParseListener);
                    return;
                }
                SourceLog.w(LelinkSdkManager.TAG, "addPinCodeToLelinkServiceInfo ignore, invalid license");
            }
        });
    }

    public void addQRCodeToLelinkServiceInfo(final String str) {
        SourceLog.i(TAG, "addQRCodeToLelinkServiceInfo " + str);
        checkLicense(new LicenseManager.ILicenseCheckListener() {
            public void checkLicense(boolean z10) {
                if (z10) {
                    BrowserHistory.getInstance().startQRBrowser();
                    Device.addQRLelinkServiceInfo(str, LelinkSdkManager.this.mOwnerParseListener);
                    return;
                }
                SourceLog.w(LelinkSdkManager.TAG, "addQRCodeToLelinkServiceInfo ignore, invalid license");
            }
        });
    }

    public void addVolume() {
        BusinessEntity.getInstance().addVolume();
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        if (dramaInfoBeanArr == null || dramaInfoBeanArr.length > 100) {
            SourceLog.w(TAG, "appendPlayList values ignore");
        } else {
            BusinessEntity.getInstance().appendPlayList(dramaInfoBeanArr, i10, i11, i12);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void browse(com.hpplay.sdk.source.bean.BrowserConfigBean r11) {
        /*
            r10 = this;
            java.lang.String r0 = "LelinkSdkManager"
            if (r11 != 0) goto L_0x000a
            java.lang.String r11 = "browse ignore"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.String) r11)
            return
        L_0x000a:
            r10.mBrowserConfig = r11
            boolean r1 = r10.canDisableDLNA()
            r2 = 1
            if (r1 != 0) goto L_0x0015
            r11.useDlna = r2
        L_0x0015:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "browse "
            r1.append(r3)
            boolean r3 = r11.useLelink
            r1.append(r3)
            java.lang.String r3 = "/"
            r1.append(r3)
            boolean r4 = r11.useDlna
            r1.append(r4)
            r1.append(r3)
            boolean r3 = r11.useHistory
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.hpplay.sdk.source.log.SourceLog.i(r0, r1)
            boolean r0 = r11.useLelink
            r1 = 3
            if (r0 == 0) goto L_0x0047
            boolean r3 = r11.useDlna
            if (r3 == 0) goto L_0x0047
            goto L_0x0050
        L_0x0047:
            if (r0 == 0) goto L_0x004a
            goto L_0x0051
        L_0x004a:
            boolean r0 = r11.useDlna
            if (r0 == 0) goto L_0x0050
            r2 = 2
            goto L_0x0051
        L_0x0050:
            r2 = 3
        L_0x0051:
            r10.clearBrowserList()
            com.hpplay.sdk.source.protocol.browser.BrowserBridge r0 = com.hpplay.sdk.source.protocol.browser.BrowserBridge.getInstance()
            com.hpplay.sdk.source.process.BrowserDispatcher r1 = r10.mBrowserDispatcher
            r0.setBrowserListener(r1)
            com.hpplay.sdk.source.protocol.browser.BrowserBridge r0 = com.hpplay.sdk.source.protocol.browser.BrowserBridge.getInstance()
            android.content.Context r1 = r10.mContext
            r0.startBrowse(r1, r2)
            com.hpplay.sdk.source.protocol.browser.BrowserHistory r0 = com.hpplay.sdk.source.protocol.browser.BrowserHistory.getInstance()
            r0.startLocalBrowser(r2)
            boolean r0 = r11.useSonic
            if (r0 == 0) goto L_0x0074
            r10.sonicBrowse()
        L_0x0074:
            boolean r0 = r11.useBLE
            if (r0 == 0) goto L_0x007b
            r10.bleBrowse()
        L_0x007b:
            boolean r0 = r11.useHistory
            if (r0 == 0) goto L_0x0082
            r10.historyBrowse(r11)
        L_0x0082:
            com.hpplay.sdk.source.process.BrowserDispatcher r11 = r10.mBrowserDispatcher
            r11.browser()
            long r0 = java.lang.System.currentTimeMillis()
            r10.mBrowserTimeStamp = r0
            com.hpplay.sdk.source.process.RelationReportTask r2 = com.hpplay.sdk.source.process.RelationReportTask.getInstance()
            android.content.Context r3 = r10.mContext
            long r4 = r10.mBrowserTimeStamp
            r0 = 30000(0x7530, double:1.4822E-319)
            long r6 = r4 + r0
            com.hpplay.sdk.source.business.cloud.SDKConfig r11 = com.hpplay.sdk.source.business.cloud.SDKConfig.getInstance()
            int r11 = r11.getSearchOutTime()
            int r11 = r11 * 1000
            long r8 = (long) r11
            r2.report(r3, r4, r6, r8)
            com.hpplay.sdk.source.utils.CastUtil.printSDKInfo()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.process.LelinkSdkManager.browse(com.hpplay.sdk.source.bean.BrowserConfigBean):void");
    }

    public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
        Integer[] protocols;
        LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        if (!(findSameServiceInfo == null || (protocols = findSameServiceInfo.getProtocols()) == null || protocols.length <= 0)) {
            for (Integer num : protocols) {
                if (num.intValue() == 1 || num.intValue() == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
        Integer[] protocols;
        LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        if (!(findSameServiceInfo == null || (protocols = findSameServiceInfo.getProtocols()) == null || protocols.length <= 0)) {
            for (Integer num : protocols) {
                if (num.intValue() == 1 || (num.intValue() == 4 && Feature.hasCloudMirror())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBrowserList() {
        this.mBrowserDispatcher.clearBrowserList();
        DeviceCodeResolver.getInstance().clear();
        BrowserHistory.getInstance().clearHistory();
        RelationReportTask.getInstance().clear();
    }

    public void clearPermissionIntentAndRetryMirror() {
        startMirror(this.mMirrorPlayInfo, false);
    }

    public void clearPlayList() {
        BusinessEntity.getInstance().clearPlayList();
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        boolean z10;
        SourceLog.i(TAG, "connect info:" + lelinkServiceInfo.getName());
        final LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        if (findSameServiceInfo != null) {
            if (!CastUtil.isSupportMultiChannel(lelinkServiceInfo)) {
                z10 = ConnectManager.getInstance().checkOnline(findSameServiceInfo, new OnlineManager.OnlineListener() {
                    public void OnLineCheckResult(LelinkServiceInfo lelinkServiceInfo, boolean z10) {
                        if (z10) {
                            ConnectManager instance = ConnectManager.getInstance();
                            Context access$500 = LelinkSdkManager.this.mContext;
                            LelinkServiceInfo lelinkServiceInfo2 = findSameServiceInfo;
                            instance.connect(access$500, lelinkServiceInfo2, CastUtil.isSupportMultiChannel(lelinkServiceInfo2));
                            return;
                        }
                        ConnectManager.getInstance().notifyInvalid(lelinkServiceInfo);
                    }
                });
            } else {
                z10 = false;
            }
            if (!z10) {
                ConnectManager.getInstance().connect(this.mContext, findSameServiceInfo, CastUtil.isSupportMultiChannel(findSameServiceInfo));
            }
        }
    }

    public void createLelinkServiceInfo(SinkParameterBean sinkParameterBean) {
        SourceLog.i(TAG, "createLelinkServiceInfo " + sinkParameterBean);
        if (sinkParameterBean != null) {
            if (sinkParameterBean.createType == SinkParameterBean.CREATE_BY_SINK_SERVER) {
                Device.createBySinkServer(sinkParameterBean.ip, sinkParameterBean.port, this.mOwnerParseListener);
            } else {
                Device.createLelinkServiceInfo(sinkParameterBean, this.mOwnerParseListener);
            }
        }
    }

    public void createLelinkServiceInfoList(List<SinkParameterBean> list) {
        SourceLog.i(TAG, "createLelinkServiceInfoList " + list);
        if (list != null && list.size() > 0) {
            if (list.get(0).createType == SinkParameterBean.CREATE_BY_SINK_SERVER) {
                createListBySinkServer(list);
            } else {
                Device.createLelinkServiceInfoList(list, this.mOwnerParseListListener);
            }
        }
    }

    public void createPinCode(ICreatePinCodeListener iCreatePinCodeListener) {
        Device.createPinCode(iCreatePinCodeListener);
    }

    public void createPreChecker() {
        DevicePreChecker devicePreChecker = this.mDevicePreChecker;
        if (devicePreChecker != null && !devicePreChecker.isRunning()) {
            this.mDevicePreChecker.release();
            this.mDevicePreChecker = null;
        }
        if (this.mDevicePreChecker == null) {
            DevicePreChecker devicePreChecker2 = new DevicePreChecker(this.mContext);
            this.mDevicePreChecker = devicePreChecker2;
            devicePreChecker2.start();
        }
    }

    public void createShortUrl(ICreateShortUrlListener iCreateShortUrlListener) {
        Device.createShortUrl(iCreateShortUrlListener);
    }

    public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
        LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        SourceLog.i(TAG, "disconnect " + findSameServiceInfo);
        BusinessEntity.getInstance().stop(Constant.STOP_USER_DISCONNECT);
        BusinessEntity.getInstance().release();
        ConnectManager.getInstance().disconnect(findSameServiceInfo);
        return true;
    }

    public BrowserConfigBean getBrowserConfig() {
        return this.mBrowserConfig;
    }

    public List<LelinkServiceInfo> getBrowserList() {
        return this.mBrowserDispatcher.getBrowserList();
    }

    public List<LelinkServiceInfo> getConnectInfos() {
        return ConnectManager.getInstance().getConnections();
    }

    public Context getContext() {
        return this.mContext;
    }

    public void getFavoriteDeviceList(int i10, int i11) {
        FavoriteDeviceManager.getInstance().getFavoriteDeviceList(i10, i11);
    }

    public void getHistoryDeviceList(int i10, int i11) {
        HistoryDeviceManager.getInstance().getHistoryDeviceList(i10, i11);
    }

    public Object getOption(int i10, Object... objArr) {
        ConnectBridge lastConnectBridge = ConnectManager.getInstance().getLastConnectBridge();
        int i11 = 0;
        switch (i10) {
            case IAPI.OPTION_32:
                return Integer.valueOf(getPlayState());
            case IAPI.OPTION_35:
                SourceLog.i(TAG, "OPTION_35");
                if (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(12)) {
                    return -1;
                }
                return 0;
            case IAPI.OPTION_37:
                SourceLog.i(TAG, "OPTION_37");
                if (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(15)) {
                    return -1;
                }
                return 0;
            case IAPI.OPTION_63:
                SourceLog.i(TAG, "OPTION_63");
                if (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(6)) {
                    return -1;
                }
                return 0;
            case IAPI.OPTION_GET_LOG_DIR:
                SourceLog.flushLogWriter();
                return SourceLog.getLogDir();
            case IAPI.OPTION_QUERY_SUPPORT_MULTI_CHANNEL:
                try {
                    LelinkServiceInfo lelinkServiceInfo = objArr[0];
                    if (lelinkServiceInfo == null) {
                        return -1;
                    }
                    if (!CastUtil.isSupportMultiChannel(lelinkServiceInfo)) {
                        i11 = -1;
                    }
                    return Integer.valueOf(i11);
                } catch (Exception e10) {
                    SourceLog.w(TAG, (Throwable) e10);
                    return -1;
                }
            case IAPI.OPTION_QUERY_SUPPORT_URL_LIST:
                if (lastConnectBridge == null || !lastConnectBridge.isSupportUrlList()) {
                    return -1;
                }
                return 0;
            case IAPI.OPTION_QUERY_SUPPORT_REVERSE_CONTROL:
                try {
                    if (objArr[0] == null || lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(31)) {
                        return -1;
                    }
                    return 0;
                } catch (Exception e11) {
                    SourceLog.w(TAG, (Throwable) e11);
                }
                break;
            case IAPI.OPTION_TEMP_RESTRICT:
                if (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(36)) {
                    return -1;
                }
                return 0;
            case IAPI.OPTION_QUERY_SUPPORT_TRACK:
                if (lastConnectBridge == null || !lastConnectBridge.isSupportTrack()) {
                    return -1;
                }
                return 0;
            case IAPI.OPTION_IS_MIRRORING:
                return String.valueOf(isMirroring());
            case IAPI.OPTION_SET_RECEIVER_PROPERTY:
                if (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(49)) {
                    return -1;
                }
                return 0;
            case IAPI.OPTION_GET_RECEIVER_PROPERTIES:
                if (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(50)) {
                    return -1;
                }
                return 0;
            default:
                return -1;
        }
    }

    public int getPlayState() {
        return BusinessEntity.getInstance().getLastPlayState();
    }

    public AtomicBoolean getRetryMirrorOnce() {
        return this.mRetryMirrorOnce;
    }

    public String getSDKInfos(int i10) {
        if (i10 == 1) {
            return Session.getInstance().getUID();
        }
        if (i10 == 2) {
            return Session.getInstance().getHID();
        }
        return "";
    }

    public VirtualDisplay getVirtualDisplay() {
        return CaptureBridge.getInstance().getVirtualDisplay();
    }

    public void historyBrowse(BrowserConfigBean browserConfigBean) {
        if (TextUtils.isEmpty(browserConfigBean.encryptNumberId)) {
            if (!TextUtils.isEmpty(browserConfigBean.numberId)) {
                browserConfigBean.encryptNumberId = LeboUtil.anonymizeBySHA256For60Bits(browserConfigBean.numberId);
            } else {
                return;
            }
        }
        BrowserBridge.getInstance().setServiceInfoParseListener(this.mOwnerHistoryListener);
        if (BrowserBridge.getInstance().startBrowseHistory(this.mContext, browserConfigBean.encryptNumberId)) {
            BrowserHistory.getInstance().startHistoryBrowser();
        }
    }

    public void initSDK(Context context, String str, String str2, String str3, String str4, String str5) {
        this.mContext = context;
        if (!Feature.isLeboApp() && !Feature.isDisableCrs(str)) {
            CrashHandler.getInstance().init(this.mContext.getApplicationContext());
        }
        ModuleLinker.getInstance().init(this.mContext, new String[0]);
        AppContextUtils.getInstance().setAppContext(this.mContext);
        SourceLog.i(TAG, "initSDK " + str + Operator.Operation.DIVISION + str5);
        Preference.initPreference(this.mContext);
        Session.initSession(this.mContext);
        Session.getInstance().initManufacture();
        Session.getInstance().appKey = str;
        Session.getInstance().appSecret = str2;
        Session.getInstance().appVersion = str5;
        Session.getInstance().userID = str3;
        Session.getInstance().oaID = str4;
        DeviceUtil.setOAID(str4);
        PublicCastClient.init(this.mContext.getApplicationContext());
        SourceDataReport.initDataReport(this.mContext.getApplicationContext());
        LelinkServerInstance.getInstance().init(this.mContext.getApplicationContext());
        BrowseResultOnlineCheck.getInstance().setContext(this.mContext.getApplicationContext());
        if (!LelinkConfig.isSdkFree() && LelinkConfig.isLicenseMode()) {
            LicenseManager.getInstance().readCachedLicense();
        }
        if (Feature.isVivoChannel()) {
            NetworkUtil.setSSIDStatus(false);
            NetworkUtil.setBSSIDStatus(false);
        }
        AuthSDK.getInstance().init(this.mContext.getApplicationContext());
        AuthSDK.getInstance().addAuthListener(this.mOwnerAuthListener);
        AuthSDK.getInstance().authSDK();
        if (LelinkConfig.isSupportDA()) {
            e.d().a(this.mContext);
        }
        registerReceiver();
        enableLog(Preference.getInstance().get(Preference.KEY_ENABLE_LOG, true));
    }

    public void isDebug(boolean z10) {
        SourceLog.i(TAG, "isDebug," + z10);
        Preference.getInstance().put(Preference.KEY_ENABLE_LOG, z10);
        enableLog(z10);
    }

    public void isDebugTimestamp(boolean z10) {
        Session.getInstance().setDebugTimestamp(z10);
    }

    public void multiMirrorControl(boolean z10, List<LelinkServiceInfo> list) {
        LelinkPlayerInfo lelinkPlayerInfo;
        SourceLog.w(TAG, "multiMirrorControl " + z10 + " " + list.size());
        if (!isMirroring()) {
            SourceLog.w(TAG, "multiMirrorControl ignore");
            return;
        }
        OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
        if (lastPlayInfo != null && (lelinkPlayerInfo = lastPlayInfo.originPlayerInfo) != null && list.size() > 0) {
            if (z10) {
                BusinessEntity.getInstance().enableMultiCast(true);
                for (LelinkServiceInfo lelinkServiceInfo : list) {
                    LelinkPlayerInfo cloneNoSubDevice = lelinkPlayerInfo.cloneNoSubDevice();
                    cloneNoSubDevice.setLelinkServiceInfo(lelinkServiceInfo);
                    dispatchMirror(lastPlayInfo.mirrorIntent, cloneNoSubDevice, lastPlayInfo.isExpandMirror, true);
                }
                return;
            }
            for (LelinkServiceInfo next : list) {
                BusinessEntity instance = BusinessEntity.getInstance();
                if (instance != null) {
                    instance.stop(1000, next);
                }
            }
        }
    }

    public void multiPushControl(boolean z10, List<LelinkServiceInfo> list, String str, int i10) {
        LelinkPlayerInfo lelinkPlayerInfo;
        SourceLog.w(TAG, "multiPushControl " + z10 + " " + list.size());
        if (!isPushing()) {
            SourceLog.w(TAG, "multiPushControl ignore");
            return;
        }
        OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
        if (lastPlayInfo != null && (lelinkPlayerInfo = lastPlayInfo.originPlayerInfo) != null && list.size() > 0) {
            if (z10) {
                BusinessEntity.getInstance().enableMultiCast(true);
                for (LelinkServiceInfo next : list) {
                    lelinkPlayerInfo.cloneNoSubDevice().setLelinkServiceInfo(next);
                    dispatchPlayMedia(next, lelinkPlayerInfo, str, i10);
                }
                return;
            }
            for (LelinkServiceInfo next2 : list) {
                BusinessEntity instance = BusinessEntity.getInstance();
                if (instance != null) {
                    instance.stop(1000, next2);
                }
            }
        }
    }

    public void notifyBrowseList() {
        this.mBrowserDispatcher.notifyBrowserSuccess();
        try {
            for (LelinkServiceInfo notifyBrowseResult : getBrowserList()) {
                ConnectManager.getInstance().notifyBrowseResult(notifyBrowseResult);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void notifyBrowserListIfNeeded(boolean z10) {
        if (z10) {
            notifyBrowseList();
            return;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 500);
    }

    public void pause() {
        BusinessEntity.getInstance().pause();
    }

    public void release() {
        SourceLog.i(TAG, "release");
        deleteHeicFileDir();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        BrowserBridge.release();
        SonicProxy.release();
        unregisterReceiver();
        SourceDataReport.getInstance().logout();
        this.mBrowserDispatcher.clearBrowserList();
        OnlineCheckThread onlineCheckThread = this.mOnlineCheckThread;
        if (onlineCheckThread != null) {
            onlineCheckThread.release();
        }
        RelationReportTask.unInit();
        SourceLog.flushLogWriter();
        SourceLog.disableLogWriter();
        e.d().c();
        CommonListenerWrapper.getInstance().release();
    }

    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        FavoriteDeviceManager.getInstance().removeFavoriteDevice(list);
    }

    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        HistoryDeviceManager.getInstance().removeHistoryDevice(list, i10);
    }

    public void resume() {
        BusinessEntity.getInstance().resume();
    }

    public void seekTo(int i10) {
        BusinessEntity.getInstance().seekTo(i10);
    }

    public void selectAudiotrack(int i10) {
        BusinessEntity.getInstance().selectAudioTrack(i10);
    }

    public void setAuthListener(AuthListener authListener) {
        this.mOuterAuthListener = authListener;
    }

    public void setBrowseListener(IBrowseListener iBrowseListener) {
        this.mBrowserDispatcher.setBrowseListener(iBrowseListener);
    }

    public void setCloudMirrorPlayListener(ICloudMirrorPlayListener iCloudMirrorPlayListener) {
        this.mOuterCloudMirrorPlayListener = iCloudMirrorPlayListener;
    }

    public void setCommonListener(ICommonListener iCommonListener) {
        CommonListenerWrapper.getInstance().setCommonListener(iCommonListener);
    }

    public void setConnectListener(IConnectListener iConnectListener) {
        ConnectManager.getInstance().setConnectListener(iConnectListener);
    }

    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        BusinessEntity.getInstance().setDaPlayListener(iDaPlayerListener);
    }

    public void setDebugAVListener(IDebugAVListener iDebugAVListener) {
        Session.getInstance().setDebugAVListener(iDebugAVListener);
    }

    public void setExpansionScreenInfo(Activity activity, View view) {
        SourceLog.i(TAG, "setExpansionScreenInfo " + activity + " / " + view);
        this.mExpandActivity = activity;
        this.mExpandView = view;
    }

    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        FavoriteDeviceManager.getInstance().setFavoriteDeviceAlias(lelinkServiceInfo, str);
    }

    public void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener) {
        FavoriteDeviceManager.getInstance().setFavoriteDeviceListener(iFavoriteDeviceListener);
    }

    public void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener) {
        HistoryDeviceManager.getInstance().setHistoryDeviceListener(iHistoryDeviceListener);
    }

    public void setLogCallback(ILogCallback iLogCallback) {
        Session.getInstance().setLogCallback(iLogCallback);
    }

    public void setMirrorChangeListener(IMirrorChangeListener iMirrorChangeListener) {
        this.mOuterMirrorChangeListener = iMirrorChangeListener;
    }

    public void setMirrorScreenSecret(boolean z10) {
        SourceLog.i(TAG, "setMirrorScreenSecret status:" + z10);
        Preference.getInstance().put(Preference.KEY_MIRROR_SECRET_SWITCH, z10);
        BusinessEntity.getInstance().setMirrorScreenSecret(z10);
    }

    public void setNewPlayerListener(INewPlayerListener iNewPlayerListener) {
        BusinessEntity.getInstance().setNewPlayerListener(iNewPlayerListener);
    }

    public void setOption(int i10, Object... objArr) {
        Object obj;
        String str;
        int i11;
        String str2 = null;
        String str3 = "";
        boolean z10 = true;
        int i12 = 0;
        switch (i10) {
            case 22:
                PassSender.getInstance().sendVIPQuery(objArr[0].toString());
                return;
            case 100:
            case 10000:
                Object obj2 = objArr[0];
                if (obj2 != null && (obj2 instanceof String) && (obj = objArr[1]) != null && (obj instanceof String) && objArr[2] != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("data", objArr[0]);
                        jSONObject.put("manifestVer", 1);
                        jSONObject.put("appID", objArr[1]);
                    } catch (Exception e10) {
                        SourceLog.w(TAG, (Throwable) e10);
                    }
                    PassSender.getInstance().sendPass(i10, jSONObject.toString(), Boolean.parseBoolean(String.valueOf(objArr[2])));
                    return;
                }
                return;
            case IAPI.OPTION_5:
                Boolean bool = objArr[0];
                if (bool instanceof Boolean) {
                    Session.getInstance().isFilter501Version = bool.booleanValue();
                    return;
                }
                return;
            case IAPI.OPTION_7:
                release();
                return;
            case IAPI.OPTION_11:
                setConferenceServerUrl(objArr);
                return;
            case IAPI.OPTION_12:
                setStaffInfo(objArr);
                return;
            case IAPI.OPTION_23:
                setConferenceBrowseListener(objArr);
                return;
            case IAPI.OPTION_35:
                JSONObject jSONObject2 = new JSONObject();
                try {
                    float parseFloat = Float.parseFloat(objArr[0] + str3);
                    jSONObject2.put("manifestVer", 1);
                    jSONObject2.put("rate", (double) parseFloat);
                    PassSender.getInstance().playRate(jSONObject2.toString());
                    return;
                } catch (Exception e11) {
                    SourceLog.w(TAG, (Throwable) e11);
                    return;
                }
            case IAPI.OPTION_37:
                PassSender.getInstance().queryRate();
                return;
            case IAPI.OPTION_41:
                String str4 = objArr[0];
                String str5 = objArr[1];
                Preference.getInstance().put(Constant.KEY_VUUID, str4);
                Preference.getInstance().put(Constant.KEY_VSESSION, str5);
                SourceLog.i(TAG, "vip info " + str4 + "  " + str5);
                if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4)) {
                    RightsManager.getInstance().logout();
                    return;
                } else if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str4)) {
                    VipAuthSetting vipAuthSetting = new VipAuthSetting();
                    vipAuthSetting.uuid = str4;
                    vipAuthSetting.ssid = str5;
                    RightsManager.getInstance().loginVipAuth(vipAuthSetting);
                    return;
                } else {
                    return;
                }
            case IAPI.OPTION_44:
                try {
                    int parseInt = Integer.parseInt(objArr[0]);
                    int parseInt2 = Integer.parseInt(objArr[1]);
                    int parseInt3 = Integer.parseInt(objArr[2]);
                    Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_MAX_BITRATE, parseInt);
                    Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_MIN_BITRATE, parseInt2);
                    Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_FRAME_BITRATE, parseInt3);
                    if (objArr.length > 3) {
                        int parseInt4 = Integer.parseInt(objArr[3].toString());
                        int parseInt5 = Integer.parseInt(objArr[4].toString());
                        Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_WIDTH, parseInt4);
                        Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_HEIGHT, parseInt5);
                        return;
                    }
                    return;
                } catch (Exception e12) {
                    SourceLog.w(TAG, (Throwable) e12);
                    return;
                }
            case IAPI.OPTION_48:
                Preference.getInstance().put(Constant.KEY_USERNAME, objArr[0]);
                return;
            case IAPI.OPTION_49:
                boolean parseBoolean = Boolean.parseBoolean(objArr[0].toString());
                if (parseBoolean) {
                    uploadLogQuery();
                }
                enableLog(parseBoolean);
                return;
            case IAPI.OPTION_51:
                AuthSDK.getInstance().authSDK();
                return;
            case IAPI.OPTION_53:
                try {
                    str = objArr[0];
                    try {
                        str3 = objArr[1];
                    } catch (Exception e13) {
                        e = e13;
                        SourceLog.w(TAG, (Throwable) e);
                        uploadLog(str, str3);
                        return;
                    }
                } catch (Exception e14) {
                    e = e14;
                    str = str3;
                    SourceLog.w(TAG, (Throwable) e);
                    uploadLog(str, str3);
                    return;
                }
                uploadLog(str, str3);
                return;
            case IAPI.OPTION_EXTERNAL_AUDIO:
                OptionCentral.changeExternalAudioState(Boolean.parseBoolean(objArr[0]));
                return;
            case IAPI.OPTION_63:
                if (objArr != null && objArr[0] != null) {
                    try {
                        OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
                        if (lastPlayInfo == null) {
                            SourceLog.i(TAG, "danmaku ignore");
                            return;
                        }
                        DanmakuBean danmakuBean = objArr[0];
                        if (danmakuBean instanceof String) {
                            JSONObject jSONObject3 = new JSONObject(objArr[0]);
                            jSONObject3.put("manifestVer", 1);
                            jSONObject3.put("uri", lastPlayInfo.urlID);
                            str2 = jSONObject3.toString();
                        } else if (danmakuBean instanceof DanmakuBean) {
                            str2 = danmakuBean.toJson(lastPlayInfo.urlID, 1);
                        }
                        SourceLog.i(TAG, "danmaku json body :" + str2);
                        PassSender.getInstance().sendDanmu(str2);
                        return;
                    } catch (Exception e15) {
                        SourceLog.w(TAG, (Throwable) e15);
                        return;
                    }
                } else {
                    return;
                }
            case IAPI.OPTION_64:
                if (objArr != null && objArr.length > 0) {
                    DanmakuPropertyBean danmakuPropertyBean = objArr[0];
                    if (danmakuPropertyBean instanceof DanmakuPropertyBean) {
                        PassSender.getInstance().setDanmuProperty(danmakuPropertyBean.toString());
                        return;
                    }
                    return;
                }
                return;
            case IAPI.OPTION_REGISTER_SINK_KEY_EVENT:
                if (canReverseControl()) {
                    OptionCentral.registerOrUnregisterSinkKeyEvent(Boolean.parseBoolean(objArr[0]));
                    return;
                }
                return;
            case IAPI.OPTION_REGISTER_SINK_TOUCH_EVENT:
                if (canReverseControl()) {
                    OptionCentral.registerOrUnregisterSinkTouchEvent(Boolean.parseBoolean(objArr[0]));
                    return;
                }
                return;
            case IAPI.OPTION_CACHE_LIST:
                PassSender.getInstance().sendShortVideoList(objArr[0].toString());
                return;
            case IAPI.START_PLAY_CLOUDMIRROR:
                if (objArr != null && objArr.length > 3) {
                    String str6 = objArr[0];
                    if (str6 instanceof String) {
                        String str7 = objArr[1];
                        if (str7 instanceof String) {
                            String str8 = objArr[2];
                            if (str8 instanceof String) {
                                String str9 = objArr[3];
                                if (str9 instanceof String) {
                                    startRenderCloudMirror(str6, str7, str8, str9);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 1179654:
                String str10 = objArr[0];
                SourceLog.i(TAG, "OPTION_SUPER_DEVICE_ID " + str10);
                Preference.getInstance().put(Constant.KEY_SUPER_DEVICE_ID, str10);
                RightsManager.getInstance().vipAuth();
                return;
            case IAPI.OPTION_SET_EXPANSITION_INFOS:
                setExpansionScreenInfo(objArr[0], objArr[1]);
                return;
            case IAPI.OPTION_APP_PAUSE:
                BusinessEntity.getInstance().onAppPause();
                return;
            case IAPI.OPTION_APP_RESUME:
                BusinessEntity.getInstance().onAppResume();
                return;
            case IAPI.OPTION_EXTERNAL_VIDEO:
                OptionCentral.setExternalVideo(Boolean.parseBoolean(objArr[0].toString()));
                return;
            case IAPI.OPTION_BROWSER:
                try {
                    BrowserConfigBean formJSON = BrowserConfigBean.formJSON(objArr[0].toString());
                    SourceLog.i(TAG, "OPTION_BROWSER " + formJSON);
                    if (formJSON != null) {
                        startBrowseThread(formJSON);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    SourceLog.w(TAG, (Throwable) e16);
                    return;
                }
            case IAPI.OPTION_MULTI_CHANNEL:
                Preference.getInstance().put(Preference.KEY_MULTI_CHANNEL, objArr[0].toString());
                return;
            case IAPI.OPTION_CHANGE_MIRROR:
                try {
                    int parseInt6 = Integer.parseInt(objArr[0].toString());
                    if (parseInt6 == 4) {
                        BusinessEntity.getInstance().switchYim();
                        return;
                    } else if (parseInt6 == 1) {
                        BusinessEntity.getInstance().switchLelink();
                        return;
                    } else {
                        SourceLog.w(TAG, "OPTION_CHANGE_MIRROR invalid protocol:" + parseInt6);
                        return;
                    }
                } catch (Exception e17) {
                    SourceLog.w(TAG, (Throwable) e17);
                    return;
                }
            case IAPI.OPTION_CREATE_LELINK_SERVICE:
                try {
                    createLelinkServiceInfo(SinkParameterBean.formJson(objArr[0].toString()));
                    return;
                } catch (Exception e18) {
                    SourceLog.w(TAG, (Throwable) e18);
                    return;
                }
            case IAPI.OPTION_SET_DRAMA_ID:
                BusinessEntity.getInstance().playDrama(objArr[0].toString());
                return;
            case IAPI.OPTION_OVERLAY_PERMISSION:
                try {
                    i11 = Integer.parseInt(objArr[0].toString());
                } catch (Exception e19) {
                    SourceLog.w(TAG, (Throwable) e19);
                    i11 = 1;
                }
                SourceLog.i(TAG, "OPTION_OVERLAY_PERMISSION enable:" + i11);
                Preference instance = Preference.getInstance();
                if (i11 == 0) {
                    z10 = false;
                }
                instance.put(Constant.KEY_REQUEST_SYSTEM_WINDOW_PERMISS, z10);
                return;
            case IAPI.OPTION_MICRO_PASS:
                PassSender.getInstance().sendMicroPass(objArr[0].toString(), str3, Integer.parseInt(objArr[1].toString()));
                return;
            case IAPI.OPTION_STOP_MICRO:
                PassSender.getInstance().sendStopMicro(str3, Integer.parseInt(objArr[0].toString()));
                return;
            case IAPI.OPTION_SELECT_TRACK:
                if (BusinessEntity.getInstance().getLastPlayInfo() == null) {
                    SourceLog.i(TAG, "danmaku ignore");
                    return;
                }
                try {
                    selectAudiotrack(Integer.parseInt(objArr[0].toString()));
                    return;
                } catch (Exception e20) {
                    SourceLog.w(TAG, (Throwable) e20);
                    return;
                }
            case IAPI.OPTION_TEMP_RESTRICT:
                try {
                    if (!isMirroring()) {
                        if (!isPushing()) {
                            SourceLog.i(TAG, "sendTempRestrict ignore, try again when casting");
                            return;
                        }
                    }
                    PassSender.getInstance().sendTempRestrict(str3, Boolean.parseBoolean(objArr[0].toString()));
                    return;
                } catch (Exception e21) {
                    SourceLog.w(TAG, (Throwable) e21);
                    return;
                }
            case IAPI.OPTION_MIRROR_NOTIFICATION:
                try {
                    z10 = Boolean.parseBoolean(objArr[0].toString());
                } catch (Exception e22) {
                    SourceLog.w(TAG, (Throwable) e22);
                }
                SourceLog.i(TAG, "OPTION_MIRROR_NOTIFICATION enable:" + z10);
                Preference.getInstance().put(Constant.KEY_MIRROR_NOTIFICATION, z10);
                return;
            case IAPI.OPTION_DISABLE_CLOUD_CAST:
                Session.getInstance().disableIM(Boolean.parseBoolean(objArr[0].toString()));
                return;
            case IAPI.OPTION_MIRROR_WATERMARK_INFO:
                String str11 = objArr[0];
                if (str11 instanceof String) {
                    str2 = str11;
                }
                setWatermarkInfo(str2);
                return;
            case IAPI.OPTION_MIRROR_WATERMARK_SWITCH:
                getInstance().setWatermarkVisible(Boolean.parseBoolean(objArr[0].toString()));
                return;
            case IAPI.OPTION_REGISTER_LISTENER_BY_COMMON:
                CommonListenerWrapper.getInstance().registerListener(objArr);
                return;
            case IAPI.OPTION_UNREGISTER_LISTENER_BY_COMMON:
                CommonListenerWrapper.getInstance().unRegisterListener(objArr);
                return;
            case IAPI.OPTION_NOTIFY_SINK_MIRROR:
                PassSender.getInstance().sendNotifyMirrorMsg(NotifyMirrorBean.formJSON(objArr[0].toString()));
                return;
            case IAPI.OPTION_NOTIFY_REMOTE_SERVER:
                PassSender.getInstance().sendNotifyRemoteMsg(objArr[0].toString(), Integer.parseInt(objArr[1].toString()), Integer.parseInt(objArr[2].toString()));
                return;
            case IAPI.OPTION_PERMISSION_MODE:
                if (LelinkConfig.isSdkFree()) {
                    SourceLog.w(TAG, "OPTION_PERMISSION_MODE ignore, sdk is free");
                    return;
                }
                try {
                    int parseInt7 = Integer.parseInt(objArr[0].toString());
                    SourceLog.i(TAG, "OPTION_PERMISSION_MODE mode:" + parseInt7);
                    Preference.getInstance().put(Preference.KEY_PERMISSION_MODE, parseInt7);
                    if (parseInt7 == 1) {
                        if (objArr.length > 1) {
                            Preference.getInstance().put(Preference.KEY_LICENSE_TSN, objArr[1].toString());
                        }
                        LicenseManager.getInstance().requestLicense(this.mContext);
                        return;
                    }
                    return;
                } catch (Exception e23) {
                    SourceLog.w(TAG, "OPTION_PERMISSION_MODE :" + e23);
                    return;
                }
            case IAPI.OPTION_MIRROR_SCREEN_SECRET:
                getInstance().setMirrorScreenSecret(Boolean.parseBoolean(objArr[0].toString()));
                return;
            case IAPI.OPTION_CHANGE_SINK_HOST_SETTING:
                PassSender.getInstance().sendSinkHostSettingMsg(objArr[0].toString());
                return;
            case IAPI.OPTION_CHANGE_SINK_PAINT:
                PassSender.getInstance().sendChangeSinkPaint(objArr[0].toString());
                return;
            case IAPI.OPTION_MIRROR_ROTATION:
                if (objArr.length > 1) {
                    CaptureBridge.getInstance().setRotation(Integer.parseInt(objArr[0].toString()), Boolean.parseBoolean(objArr[1].toString()));
                    return;
                }
                return;
            case IAPI.OPTION_SET_CONNECT_DEVICE:
                try {
                    HistoryConfigBean formJSON2 = HistoryConfigBean.formJSON(objArr[0].toString());
                    if (formJSON2 != null) {
                        ConnectManager.getInstance().setConnectDeviceReport(formJSON2);
                        return;
                    }
                    return;
                } catch (Exception e24) {
                    SourceLog.w(TAG, (Throwable) e24);
                    return;
                }
            case IAPI.OPTION_MIRROR_NOTIFY_TYPE:
                try {
                    i12 = Integer.parseInt(objArr[0].toString());
                } catch (Exception e25) {
                    SourceLog.w(TAG, (Throwable) e25);
                }
                SourceLog.i(TAG, "OPTION_MIRROR_NOTIFY_TYPE :" + i12);
                Preference.getInstance().put(Constant.KEY_MIRROR_NOTIFY_TYPE, i12);
                return;
            case IAPI.OPTION_SEND_HARASS_CODE:
                String obj3 = objArr[0].toString();
                int canSend = HarassCode.getInstance().canSend(obj3);
                if (canSend == 0) {
                    PassSender.getInstance().sendHarassCode(obj3);
                    return;
                } else if (canSend == 1 && BusinessEntity.getInstance().getListenerDispatcher() != null) {
                    BusinessEntity.getInstance().getListenerDispatcher().onInfo((OutParameter) null, 47, str3);
                    return;
                } else {
                    return;
                }
            case IAPI.OPTION_CLOUD_MULTI_CAST:
                try {
                    i12 = Integer.parseInt(objArr[0].toString());
                } catch (Exception e26) {
                    SourceLog.w(TAG, (Throwable) e26);
                }
                SourceLog.i(TAG, "OPTION_CLOUD_MULTI_CAST :" + i12);
                Preference.getInstance().put(Constant.KEY_CLOUD_MULTI_CAST, i12);
                return;
            case IAPI.OPTION_SET_FRAME_RATE:
                try {
                    SourceLog.i(TAG, "========OPTION_SET_FRAME_RATE=========" + objArr[0]);
                    Preference.getInstance().put(Preference.KEY_MIRROR_FPS, Integer.parseInt(objArr[0].toString()));
                    CaptureBridge.getInstance().setFrameRate(0, Integer.parseInt(objArr[0].toString()));
                    return;
                } catch (Exception e27) {
                    SourceLog.w(TAG, (Throwable) e27);
                    return;
                }
            case IAPI.OPTION_BROWSER_HISTORY:
                try {
                    BrowserConfigBean formJSON3 = BrowserConfigBean.formJSON(objArr[0].toString());
                    if (formJSON3 != null) {
                        startBrowseHisThread(formJSON3);
                        return;
                    }
                    return;
                } catch (Exception e28) {
                    SourceLog.w(TAG, (Throwable) e28);
                    return;
                }
            case IAPI.OPTION_MIRROR_REUSE_DISPLAY:
                try {
                    CaptureBridge.getInstance().setDisplayReuse(Boolean.parseBoolean(objArr[0].toString()));
                    return;
                } catch (Exception e29) {
                    SourceLog.w(TAG, (Throwable) e29);
                    return;
                }
            case IAPI.OPTION_RESIZE_MIRROR_SCREEN:
                try {
                    CaptureBridge.getInstance().resize(Integer.parseInt(objArr[0].toString()));
                    return;
                } catch (Exception e30) {
                    SourceLog.w(TAG, (Throwable) e30);
                    return;
                }
            case IAPI.OPTION_SOURCE_ID:
                try {
                    String obj4 = objArr[0].toString();
                    String md5EncryData = EncryptUtil.md5EncryData(obj4);
                    SourceLog.i(TAG, "OPTION_SOURCE_ID: " + obj4 + " / " + md5EncryData);
                    Session.getInstance().setSourceID(md5EncryData);
                    return;
                } catch (Exception e31) {
                    SourceLog.w(TAG, (Throwable) e31);
                    return;
                }
            case IAPI.OPTION_ENABLE_HISTORY_DEV:
                try {
                    boolean parseBoolean2 = Boolean.parseBoolean(objArr[0].toString());
                    Preference.getInstance().put(Constant.KEY_ENABLE_HISTORY_DEV, parseBoolean2);
                    SourceLog.i(TAG, "OPTION_ENABLE_HISTORY_DEV: " + parseBoolean2);
                    return;
                } catch (Exception e32) {
                    SourceLog.w(TAG, (Throwable) e32);
                    return;
                }
            case IAPI.OPTION_CREATE_LELINK_SERVICE_LIST:
                SourceLog.i(TAG, "createLelinkServiceInfoList OPTION_CREATE_LELINK_SERVICE_LIST ");
                try {
                    JSONArray jSONArray = new JSONArray(objArr[0].toString());
                    ArrayList arrayList = new ArrayList();
                    while (i12 < jSONArray.length()) {
                        String str12 = (String) jSONArray.get(i12);
                        SourceLog.i(TAG, "createLelinkServiceInfoList OPTION_CREATE_LELINK_SERVICE_LIST :" + str12);
                        arrayList.add(SinkParameterBean.formJson(str12));
                        i12++;
                    }
                    createLelinkServiceInfoList(arrayList);
                    return;
                } catch (Exception e33) {
                    SourceLog.w(TAG, (Throwable) e33);
                    return;
                }
            case IAPI.OPTION_ENCODE_ERROR_EXIT_MIRROR:
                if (objArr.length > 0) {
                    Preference.getInstance().put(Preference.KEY_ENCODE_ERROR_EXIT_MIRROR, objArr[0].toString().equals("true"));
                    return;
                }
                return;
            case IAPI.OPTION_SET_RESOLUTION:
                try {
                    OptionCentral.setResolution(Integer.parseInt(objArr[0].toString()), Integer.parseInt(objArr[1].toString()));
                    return;
                } catch (Exception e34) {
                    SourceLog.w(TAG, (Throwable) e34);
                    return;
                }
            case IAPI.OPTION_SET_NOTIFICATION_PID:
                try {
                    OptionCentral.NOTIFICATION_PID = Integer.parseInt(objArr[0].toString());
                    return;
                } catch (Exception e35) {
                    SourceLog.w(TAG, (Throwable) e35);
                    return;
                }
            case IAPI.OPTION_SET_RC_EVENT_NO_FILTER:
                try {
                    OptionCentral.RC_CONTROL_NO_FILTER = Boolean.parseBoolean(objArr[0].toString());
                    SourceLog.i(TAG, "RC_CONTROL_NO_FILTER " + OptionCentral.RC_CONTROL_NO_FILTER);
                    return;
                } catch (Exception e36) {
                    SourceLog.w(TAG, (Throwable) e36);
                    return;
                }
            case IAPI.OPTION_SET_MIRROR_VIRTUAL_DISPLAY_NAME:
                try {
                    OptionCentral.disPlayName = objArr[0].toString();
                    SourceLog.i(TAG, "OPTION_SET_MIRROR_VIRTUAL_DISPLAY_NAME " + OptionCentral.disPlayName);
                    return;
                } catch (Exception e37) {
                    SourceLog.w(TAG, (Throwable) e37);
                    return;
                }
            case IAPI.OPTION_SET_QCOM_OPT_BITRATE:
                try {
                    OptionCentral.isOptBitrate = Boolean.parseBoolean(objArr[0].toString());
                    SourceLog.i(TAG, "OPTION_SET_QCOM_OPT_BITRATE " + OptionCentral.isOptBitrate);
                    return;
                } catch (Exception e38) {
                    SourceLog.w(TAG, (Throwable) e38);
                    return;
                }
            case IAPI.OPTION_SET_RECEIVER_PROPERTY:
                try {
                    SourceLog.i(TAG, "OPTION_SET_RECEIVER_PROPERTY" + objArr[0]);
                    PassSender.getInstance().sendReceiverProperty(ReceiverPropertyBean.fromString(objArr[0].toString()).toJson());
                    return;
                } catch (Exception e39) {
                    SourceLog.w(TAG, (Throwable) e39);
                    return;
                }
            case IAPI.OPTION_GET_RECEIVER_PROPERTIES:
                try {
                    SourceLog.i(TAG, "OPTION_GET_RECEIVER_PROPERTIES");
                    PassSender.getInstance().sendReceiverPropertiesSync();
                    return;
                } catch (Exception e40) {
                    SourceLog.w(TAG, (Throwable) e40);
                    return;
                }
            case IAPI.OPTION_SET_DLNA_CUSTOM_IDS:
                try {
                    OptionCentral.SET_DLNA_CUSTOM_IDS = Boolean.parseBoolean(objArr[0].toString());
                    SourceLog.i(TAG, "OPTION_SET_DLNA_CUSTOM_IDS " + OptionCentral.SET_DLNA_CUSTOM_IDS);
                    return;
                } catch (Exception e41) {
                    SourceLog.w(TAG, (Throwable) e41);
                    return;
                }
            case IAPI.OPTION_SET_OPTIONAL_CAPTURE:
                try {
                    SourceLog.i(TAG, "OPTION_SET_OPTIONAL_CAPTURE,value: " + objArr[0]);
                    OptionCentral.isOptionalCapture = Boolean.parseBoolean(objArr[0].toString());
                    return;
                } catch (Exception e42) {
                    SourceLog.w(TAG, (Throwable) e42);
                    return;
                }
            case IAPI.OPTION_PLAY_NEXT_DRAMA:
                BusinessEntity.getInstance().playNextDrama();
                return;
            case IAPI.OPTION_PLAY_PRE_DRAMA:
                BusinessEntity.getInstance().playPreDrama();
                return;
            default:
                return;
        }
    }

    public void setPassCallback(ISendPassCallback iSendPassCallback) {
        this.mPassCallback = iSendPassCallback;
    }

    public void setPlayerListener(ILelinkPlayerListener iLelinkPlayerListener) {
        BusinessEntity.getInstance().setPlayerListener(iLelinkPlayerListener);
    }

    public void setReceiverPropertiesCallback(IReceiverPropertiesCallback iReceiverPropertiesCallback) {
        this.mReceiverPropertiesCallback = iReceiverPropertiesCallback;
    }

    public void setRelevantInfoListener(IRelevantInfoListener iRelevantInfoListener) {
        this.mOuterRelevantInfoListener = iRelevantInfoListener;
    }

    public void setRetryBrowseListener(IBrowseListener iBrowseListener) {
        BrowserDispatcher browserDispatcher = this.mBrowserDispatcher;
        if (browserDispatcher != null) {
            browserDispatcher.setRetryBrowseListener(iBrowseListener);
        }
    }

    public void setSearchBannerDataCallback(ISearchBannerDataCallback iSearchBannerDataCallback) {
        this.mSearchBannerDataCallback = iSearchBannerDataCallback;
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        this.mSecondMirrorView = secondMirrorView;
        PlayController lastPlayController = BusinessEntity.getInstance().getLastPlayController();
        if (lastPlayController == null) {
            SourceLog.w(TAG, "setSecondMirrorView ignore 2 ");
            return;
        }
        SourceLog.i(TAG, "setSecondMirrorView " + secondMirrorView);
        lastPlayController.getPlayInfo().secondMirrorView = this.mSecondMirrorView;
        lastPlayController.setSecondMirrorView(secondMirrorView);
    }

    public void setServiceInfoListParseListener(IServiceInfoListParseListener iServiceInfoListParseListener) {
        this.mOuterParseListListener = iServiceInfoListParseListener;
    }

    public void setServiceInfoParseListener(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mOuterParseListener = iServiceInfoParseListener;
    }

    public void setSinkKeyEventListener(final ISinkKeyEventListener iSinkKeyEventListener) {
        if (iSinkKeyEventListener != null) {
            if (!canReverseControl()) {
                SourceLog.w(TAG, "setSinkKeyEventListener ignore, this channel not support this feature");
                return;
            }
            SourceLog.i(TAG, "setSinkKeyEventListener " + iSinkKeyEventListener);
            SinkKeyEventDispatcher.getInstance().setSinkKeyEventListener(new ISinkKeyEventListener() {
                public void onKeyEvent(final KeyEvent keyEvent) {
                    LelinkSdkManager.this.mHandler.post(new Runnable() {
                        public void run() {
                            iSinkKeyEventListener.onKeyEvent(keyEvent);
                        }
                    });
                }
            });
        }
    }

    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, final ISinkTouchEventListener iSinkTouchEventListener) {
        if (iSinkTouchEventListener != null) {
            if (!canReverseControl()) {
                SourceLog.w(TAG, "setSinkTouchEventListener ignore, this channel not support this feature");
                return;
            }
            SourceLog.i(TAG, "setSinkTouchEventListener " + iSinkTouchEventListener);
            SinkTouchEventMonitor.getInstance().setTouchEventArea(sinkTouchEventArea);
            SinkTouchEventMonitor.getInstance().setTouchScaleModulus(f10);
            SinkTouchEventDispatcher.getInstance().setSinkTouchEventListener(new ISinkTouchEventListener() {
                public void onTouchEvent(final MotionEvent motionEvent) {
                    LelinkSdkManager.this.mHandler.post(new Runnable() {
                        public void run() {
                            iSinkTouchEventListener.onTouchEvent(motionEvent);
                        }
                    });
                }
            });
        }
    }

    public void setSystemApp(boolean z10) {
        Preference.getInstance().put(Constant.KEY_IS_SYSTEM_APP, z10);
    }

    public void setVolume(int i10) {
        BusinessEntity.getInstance().setVolume(i10);
    }

    public void setWatermarkInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "setWatermarkInfo values ignore");
        } else {
            Preference.getInstance().put(Preference.KEY_MIRROR_WATERMARK_OBJ_JSON_STR, str);
        }
    }

    public void setWatermarkVisible(boolean z10) {
        SourceLog.i(TAG, "setWatermarkVisible isVisible:" + z10);
        Preference.getInstance().put(Preference.KEY_MIRROR_WATERMARK_SWITCH, z10);
        BusinessEntity.getInstance().setWatermarkVisible(z10);
    }

    public void startBrowseHisThread(BrowserConfigBean browserConfigBean) {
        stopBrowseThread();
        clearBrowserList();
        historyBrowse(browserConfigBean);
    }

    public void startBrowseThread() {
        startBrowseThread(this.mBrowserConfig);
    }

    public void startExpandMirror(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkServiceInfo lelinkServiceInfo;
        if (lelinkPlayerInfo == null) {
            SourceLog.w(TAG, "startExpandMirror ignore,LelinkPlayerInfo is null");
            return;
        }
        if (isMirroring()) {
            OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
            if (!(lelinkPlayerInfo.getLelinkServiceInfo() == null || lastPlayInfo == null || (lelinkServiceInfo = lastPlayInfo.serviceInfo) == null || !lelinkServiceInfo.equals(lelinkPlayerInfo.getLelinkServiceInfo()))) {
                SourceLog.i(TAG, "startExpandMirror is mirroring now, use switchExpansionScreen");
                switchExpansionScreen(true);
                return;
            }
        }
        this.mRetryMirrorOnce.set(true);
        startMirror(lelinkPlayerInfo, true);
    }

    public void startMirror(LelinkPlayerInfo lelinkPlayerInfo) {
        this.mRetryMirrorOnce.set(false);
        startMirror(lelinkPlayerInfo, false);
    }

    public void startOnlineCheck(IAPICallbackListener iAPICallbackListener, List<LelinkServiceInfo> list) {
        if (!(iAPICallbackListener == null || list == null)) {
            try {
                OnlineCheckThread onlineCheckThread = this.mOnlineCheckThread;
                if (onlineCheckThread == null || onlineCheckThread.isCompletion()) {
                    OnlineCheckThread onlineCheckThread2 = new OnlineCheckThread(iAPICallbackListener, list);
                    this.mOnlineCheckThread = onlineCheckThread2;
                    onlineCheckThread2.start();
                    return;
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
        SourceLog.w(TAG, "setInteractListener values is Invalid");
    }

    public void startPlayCheck(LelinkPlayerInfo lelinkPlayerInfo) {
        if (lelinkPlayerInfo == null) {
            SourceLog.w(TAG, "startPlayMedia ignore, invalid player info");
        } else if (!TextUtils.isEmpty(lelinkPlayerInfo.getUrl()) || !TextUtils.isEmpty(lelinkPlayerInfo.getLocalPath()) || lelinkPlayerInfo.getLoaclUri() != null) {
            createPreChecker();
            if (lelinkPlayerInfo.getLelinkServiceInfo() != null) {
                SourceLog.i(TAG, " new device start check ");
                lelinkPlayerInfo.setLelinkServiceInfo(lelinkPlayerInfo.getLelinkServiceInfo());
                this.mDevicePreChecker.setOnDevicePreCheckResult(lelinkPlayerInfo.getLelinkServiceInfo(), new DevicePreCheckCallback(lelinkPlayerInfo));
            } else if (ConnectManager.getInstance().getLastServiceInfo() != null) {
                SourceLog.i(TAG, " connected device start check ");
                this.mDevicePreChecker.setOnDevicePreCheckResult(ConnectManager.getInstance().getLastServiceInfo(), new DevicePreCheckCallback(lelinkPlayerInfo));
            } else {
                startPlay(lelinkPlayerInfo);
            }
        } else {
            SourceLog.e(TAG, "startPlayMedia ignore, invalid url");
        }
    }

    public void startPlayMedia(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
        startPlayMedia(lelinkServiceInfo, (LelinkPlayerInfo) null, str, i10, z10);
    }

    public void startRenderCloudMirror(String str, String str2, String str3, String str4) {
        if (!LelinkConfig.isSupportYimMirror()) {
            SourceLog.w(TAG, "startRenderCloudMirror ignore, cloud mirror not support");
            return;
        }
        Intent intent = new Intent(this.mContext, MirrorPlayerActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("session", str3);
        intent.putExtra("uri", str4);
        intent.putExtra(MirrorPlayerActivity.f11854c, str);
        intent.putExtra(MirrorPlayerActivity.f11855d, str2);
        this.mContext.startActivity(intent);
    }

    public void stopBrowse() {
        SourceLog.i(TAG, "stopBrowse");
        RelationReportTask.getInstance().stopBrowser();
        BrowserBridge.getInstance().stopBrowse();
        if (SonicProxy.canStartSonicBrowse(this.mContext)) {
            SonicProxy.stopBrowse(this.mContext);
        }
        if (LelinkConfig.isPublishBlueToothEnable(this.mContext) == 1) {
            BleProxy.stopPublish(this.mContext);
        }
        if (LelinkConfig.isBrowserBlueToothEnable(this.mContext) == 1) {
            BleProxy.stopBrowse(this.mContext);
        }
        this.mBrowserDispatcher.stopBrowser();
        ServiceUpdater.getInstance().updateServiceInfo(this.mContext);
    }

    public void stopBrowseThread() {
        stopBrowseThread(true);
    }

    public void stopExpandMirror() {
        stopPlay();
        SourceLog.flushLogWriter();
    }

    public void stopPlay() {
        BusinessEntity instance = BusinessEntity.getInstance();
        if (instance != null) {
            instance.stop(1000);
        }
        SourceLog.flushLogWriter();
    }

    public void stopPlayWithCallback(int i10) {
        BusinessEntity instance = BusinessEntity.getInstance();
        if (instance != null) {
            instance.stopWithCallback(i10);
        }
        SourceLog.flushLogWriter();
    }

    public void subVolume() {
        BusinessEntity.getInstance().subVolume();
    }

    public void switchExpansionScreen(boolean z10) {
        if ((this.mExpandActivity == null || this.mExpandView == null) && z10) {
            SourceLog.w(TAG, "switchExpansionScreen ignore");
            return;
        }
        PlayController lastPlayController = BusinessEntity.getInstance().getLastPlayController();
        if (lastPlayController == null) {
            SourceLog.w(TAG, "switchExpansionScreen ignore 2 " + z10);
            return;
        }
        SourceLog.i(TAG, "switchExpansionScreen " + z10);
        lastPlayController.getPlayInfo().expandActivity = this.mExpandActivity;
        lastPlayController.getPlayInfo().expandView = this.mExpandView;
        lastPlayController.switchExpansionScreen(z10);
    }

    public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        OptionCentral.updateAudioData(bArr, audioFrameBean);
    }

    public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        OptionCentral.updateVideoData(bArr, videoFrameBean);
    }

    public void uploadLog(String str, String str2) {
        String createEid = CreateUtil.createEid();
        LogUpload.uploadLogFile(this.mContext, (String) null, createEid, str, str2, new UploadLogCallback() {
            public void uploadStatus(int i10) {
                SourceLog.i(LelinkSdkManager.TAG, "uploadStatus i =" + i10);
                LelinkSdkManager.this.uploadLogStatus(i10);
            }
        });
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ParamsMap.DeviceParams.KEY_UID, lastServiceInfo.getUid());
                jSONObject.put("manifestVer", 1);
                jSONObject.put("euqid", createEid);
                jSONObject.put("et", str);
                PassSender.getInstance().syncLogReport(lastServiceInfo, jSONObject.toString());
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
    }

    public void startBrowseThread(boolean z10, boolean z11) {
        BrowserConfigBean browserConfigBean = new BrowserConfigBean();
        browserConfigBean.useLelink = z10;
        browserConfigBean.useDlna = z11;
        startBrowseThread(browserConfigBean);
    }

    public void startPlayMedia(LelinkServiceInfo lelinkServiceInfo, LelinkPlayerInfo lelinkPlayerInfo, String str, int i10, boolean z10) {
        if (lelinkServiceInfo != null || CastUtil.isSupportCloudMultiCast()) {
            final LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
            if (!z10 || ContextCompat.checkSelfPermission(this.mContext, "android.permission.READ_EXTERNAL_STORAGE") != -1) {
                if (z10) {
                    if (i10 != 103 || Build.VERSION.SDK_INT < 28 || TextUtils.isEmpty(str) || (!str.endsWith(".heic") && !str.endsWith(".HEIC"))) {
                        str = LelinkServerInstance.getInstance().getFileDownloadUrl(str, lelinkPlayerInfo.getParams());
                    } else {
                        SourceLog.i(TAG, "startPlayMedia,is heic local photo");
                        final LelinkPlayerInfo lelinkPlayerInfo2 = lelinkPlayerInfo;
                        final String str2 = str;
                        final int i11 = i10;
                        AsyncManager.getInstance().exeRunnable(new Runnable() {
                            public void run() {
                                HeicBean heicBean = new HeicBean();
                                heicBean.lelinkServiceInfo = findSameServiceInfo;
                                LelinkPlayerInfo lelinkPlayerInfo = lelinkPlayerInfo2;
                                heicBean.lelinkPlayerInfo = lelinkPlayerInfo;
                                heicBean.path = LelinkSdkManager.this.heicChangeToJpeg(str2, lelinkPlayerInfo.getParams());
                                heicBean.type = i11;
                                Message obtainMessage = LelinkSdkManager.this.mHandler.obtainMessage();
                                obtainMessage.what = 3;
                                obtainMessage.obj = heicBean;
                                LelinkSdkManager.this.mHandler.sendMessage(obtainMessage);
                            }
                        }, (AsyncRunnableListener) null);
                        return;
                    }
                }
                startPlayMediaAfterCheck(findSameServiceInfo, lelinkPlayerInfo, str, i10);
                return;
            }
            SourceLog.i(TAG, " not permission ");
            final LelinkPlayerInfo lelinkPlayerInfo3 = lelinkPlayerInfo;
            final String str3 = str;
            final int i12 = i10;
            final boolean z11 = z10;
            this.mPermissionListener = new OnRequestPermissionListener() {
                public void onNotifyCast(Intent intent) {
                    LelinkSdkManager lelinkSdkManager = LelinkSdkManager.this;
                    lelinkSdkManager.mPermissionListener = null;
                    lelinkSdkManager.startPlayMedia(findSameServiceInfo, lelinkPlayerInfo3, str3, i12, z11);
                }
            };
            startGetSDCardPermission(this.mContext);
            return;
        }
        SourceLog.w(TAG, "startPlayMedia ignore, invalid service info");
    }

    public void stopBrowseThread(boolean z10) {
        if (this.mBrowserThread != null && System.currentTimeMillis() - this.mPreBrowserTime > 200) {
            this.mBrowserThread.stopBrowser();
        }
        if (z10) {
            this.mBrowserDispatcher.notifyBrowserStop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009a, code lost:
        if (r6.isUseSystemMirrorCapture() == false) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startMirror(final com.hpplay.sdk.source.api.LelinkPlayerInfo r6, final boolean r7) {
        /*
            r5 = this;
            boolean r0 = com.hpplay.sdk.source.config.LelinkConfig.isSystemSupportMirror()
            r1 = 211000(0x33838, float:2.95674E-40)
            r2 = 0
            java.lang.String r3 = "LelinkSdkManager"
            if (r0 != 0) goto L_0x002a
            java.lang.String r6 = "startMirror ignore,system not support"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.String) r6)
            com.hpplay.sdk.source.business.BusinessEntity r6 = com.hpplay.sdk.source.business.BusinessEntity.getInstance()
            com.hpplay.sdk.source.business.LelinkPlayerListenerDispatcher r6 = r6.getListenerDispatcher()
            if (r6 == 0) goto L_0x0029
            com.hpplay.sdk.source.business.BusinessEntity r6 = com.hpplay.sdk.source.business.BusinessEntity.getInstance()
            com.hpplay.sdk.source.business.LelinkPlayerListenerDispatcher r6 = r6.getListenerDispatcher()
            r7 = 211004(0x3383c, float:2.9568E-40)
            r6.onError(r2, r1, r7)
        L_0x0029:
            return
        L_0x002a:
            boolean r0 = com.hpplay.sdk.source.config.LelinkConfig.isSupportMirror()
            if (r0 != 0) goto L_0x004e
            java.lang.String r6 = "startMirror ignore,mirror not support"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.String) r6)
            com.hpplay.sdk.source.business.BusinessEntity r6 = com.hpplay.sdk.source.business.BusinessEntity.getInstance()
            com.hpplay.sdk.source.business.LelinkPlayerListenerDispatcher r6 = r6.getListenerDispatcher()
            if (r6 == 0) goto L_0x004d
            com.hpplay.sdk.source.business.BusinessEntity r6 = com.hpplay.sdk.source.business.BusinessEntity.getInstance()
            com.hpplay.sdk.source.business.LelinkPlayerListenerDispatcher r6 = r6.getListenerDispatcher()
            r7 = 211051(0x3386b, float:2.95745E-40)
            r6.onError(r2, r1, r7)
        L_0x004d:
            return
        L_0x004e:
            com.hpplay.sdk.source.browse.api.LelinkServiceInfo r0 = r6.getLelinkServiceInfo()
            com.hpplay.sdk.source.browse.api.LelinkServiceInfo r0 = r5.findSameServiceInfo(r0)
            if (r0 == 0) goto L_0x005b
            r6.setLelinkServiceInfo(r0)
        L_0x005b:
            if (r0 == 0) goto L_0x0081
            boolean r0 = com.hpplay.sdk.source.utils.CastUtil.isSinkSupportMirror(r0)
            if (r0 != 0) goto L_0x0081
            java.lang.String r6 = "startMirror ignore,mirror not support 2"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.String) r6)
            com.hpplay.sdk.source.business.BusinessEntity r6 = com.hpplay.sdk.source.business.BusinessEntity.getInstance()
            com.hpplay.sdk.source.business.LelinkPlayerListenerDispatcher r6 = r6.getListenerDispatcher()
            if (r6 == 0) goto L_0x0080
            com.hpplay.sdk.source.business.BusinessEntity r6 = com.hpplay.sdk.source.business.BusinessEntity.getInstance()
            com.hpplay.sdk.source.business.LelinkPlayerListenerDispatcher r6 = r6.getListenerDispatcher()
            r7 = 211052(0x3386c, float:2.95747E-40)
            r6.onError(r2, r1, r7)
        L_0x0080:
            return
        L_0x0081:
            r5.mMirrorPlayInfo = r6
            boolean r0 = com.hpplay.sdk.source.browse.api.OptionCentral.isExternalVideo()
            if (r0 != 0) goto L_0x009c
            com.hpplay.sdk.source.common.store.Preference r0 = com.hpplay.sdk.source.common.store.Preference.getInstance()
            java.lang.String r1 = "is_system_app"
            r4 = 0
            boolean r0 = r0.get((java.lang.String) r1, (boolean) r4)
            if (r0 != 0) goto L_0x009c
            boolean r0 = r6.isUseSystemMirrorCapture()
            if (r0 == 0) goto L_0x009d
        L_0x009c:
            r4 = 1
        L_0x009d:
            if (r4 == 0) goto L_0x00a3
            r5.startMirrorAfterCheck(r2, r6, r7)
            return
        L_0x00a3:
            com.hpplay.sdk.source.process.LelinkSdkManager$11 r0 = new com.hpplay.sdk.source.process.LelinkSdkManager$11     // Catch:{ Exception -> 0x00d1 }
            r0.<init>(r6, r7)     // Catch:{ Exception -> 0x00d1 }
            r5.mPermissionListener = r0     // Catch:{ Exception -> 0x00d1 }
            android.content.Intent r7 = new android.content.Intent     // Catch:{ Exception -> 0x00d1 }
            android.content.Context r0 = r5.mContext     // Catch:{ Exception -> 0x00d1 }
            java.lang.Class<com.hpplay.sdk.source.permission.PermissionBridgeActivity> r1 = com.hpplay.sdk.source.permission.PermissionBridgeActivity.class
            r7.<init>(r0, r1)     // Catch:{ Exception -> 0x00d1 }
            boolean r6 = r6.isClearActivityTaskWhenStartMirror()     // Catch:{ Exception -> 0x00d1 }
            if (r6 == 0) goto L_0x00c0
            r6 = 268468224(0x10008000, float:2.5342157E-29)
            r7.setFlags(r6)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00c5
        L_0x00c0:
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r7.setFlags(r6)     // Catch:{ Exception -> 0x00d1 }
        L_0x00c5:
            java.lang.String r6 = "permission_type"
            r0 = 3
            r7.putExtra(r6, r0)     // Catch:{ Exception -> 0x00d1 }
            android.content.Context r6 = r5.mContext     // Catch:{ Exception -> 0x00d1 }
            r6.startActivity(r7)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00d5
        L_0x00d1:
            r6 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r6)
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.process.LelinkSdkManager.startMirror(com.hpplay.sdk.source.api.LelinkPlayerInfo, boolean):void");
    }

    public void startBrowseThread(boolean z10, boolean z11, String str) {
        BrowserConfigBean browserConfigBean = new BrowserConfigBean();
        browserConfigBean.useLelink = z10;
        browserConfigBean.useDlna = z11;
        browserConfigBean.encryptNumberId = str;
        startBrowseThread(browserConfigBean);
    }

    public void startBrowseThread(final BrowserConfigBean browserConfigBean) {
        if (mIsFirstBrowser) {
            mIsFirstBrowser = false;
            e.d().a();
        }
        checkLicense(new LicenseManager.ILicenseCheckListener() {
            public void checkLicense(boolean z10) {
                if (z10) {
                    LelinkSdkManager.this.startBrowseInValidLicense(browserConfigBean);
                } else {
                    SourceLog.w(LelinkSdkManager.TAG, "startBrowseThread ignore, invalid license");
                }
            }
        });
    }
}
