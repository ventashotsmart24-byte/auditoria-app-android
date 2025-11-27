package com.hpplay.sdk.source.process;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.sdk.source.api.IBindSdkListener;
import com.hpplay.sdk.source.api.ICloudMirrorPlayListener;
import com.hpplay.sdk.source.api.ICommonListener;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.api.IDaPlayerListener;
import com.hpplay.sdk.source.api.IDebugAVListener;
import com.hpplay.sdk.source.api.IFavoriteDeviceListener;
import com.hpplay.sdk.source.api.IHistoryDeviceListener;
import com.hpplay.sdk.source.api.ILelinkPlayerListener;
import com.hpplay.sdk.source.api.ILelinkSourceSDK;
import com.hpplay.sdk.source.api.ILogCallback;
import com.hpplay.sdk.source.api.IMirrorChangeListener;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.api.IReceiverPropertiesCallback;
import com.hpplay.sdk.source.api.IRelevantInfoListener;
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.ISendPassCallback;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.DebugTimestampBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.ReceiverProperties;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.AuthListener;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.c;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.q;
import com.hpplay.sdk.source.r;
import com.hpplay.sdk.source.utils.HpplayUtil;
import com.hpplay.sdk.source.z;
import java.util.List;
import org.json.JSONArray;

public class LelinkSourceSDKImpProxy implements ILelinkSourceSDK {
    private static final int MAX_TRYBIND = 3;
    private static final String TAG = "LelinkSourceSdkImpProxy";
    private static LelinkSourceSDKImpProxy sInstance = new LelinkSourceSDKImpProxy();
    private boolean isDebug = true;
    private boolean isDebugTimestamp = false;
    /* access modifiers changed from: private */
    public boolean isMultiProcessBind = false;
    private boolean isSetDebugModeWork = false;
    private AuthListener mAppAuthListener;
    private IBrowseListener mAppBrowseListener;
    /* access modifiers changed from: private */
    public ICloudMirrorPlayListener mAppCloudMirrorPlayListener;
    private IConnectListener mAppConnectListener;
    private IDaPlayerListener mAppDaPlayerListener;
    private IDebugAVListener mAppDebugAVListener;
    private ILelinkPlayerListener mAppLelinkPlayerListener;
    private INewPlayerListener mAppNewPlayerListener;
    /* access modifiers changed from: private */
    public IReceiverPropertiesCallback mAppReceiverPropertiesCallback;
    /* access modifiers changed from: private */
    public IRelevantInfoListener mAppRelevantInfoListener;
    private int mBindCount = 0;
    private c mCloudMirrorPlayListener = new c.a() {
        public void onCloudMessage(long j10, String str) {
            if (LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener != null) {
                LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener.onCloudMessage(j10, str);
            }
        }

        public void onCloudMirrorStart(boolean z10, String str, String str2, String str3, String str4, String str5) {
            if (LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener != null) {
                LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener.onCloudMirrorStart(z10, str, str2, str3, str4, str5);
            }
        }

        public void onCloudMirrorStop() {
            if (LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener != null) {
                LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener.onCloudMirrorStop();
            }
        }
    };
    private ICommonListener mCommonListener;
    private DebugTSThread mDebugTSThread;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            return false;
        }
    });
    /* access modifiers changed from: private */
    public LelinkServiceConnection mMultiConnection;
    private z mMultiManager;
    private q mReceiverPropertiesCallback = new q.a() {
        public void callback(ReceiverProperties receiverProperties) {
            if (LelinkSourceSDKImpProxy.this.mAppReceiverPropertiesCallback != null) {
                LelinkSourceSDKImpProxy.this.mAppReceiverPropertiesCallback.callback(receiverProperties);
            }
        }
    };
    private r mRelevantInfoListener = new r.a() {
        public void onReverseInfoResult(int i10, String str) {
            if (LelinkSourceSDKImpProxy.this.mAppRelevantInfoListener != null) {
                LelinkSourceSDKImpProxy.this.mAppRelevantInfoListener.onReverseInfoResult(i10, str);
            }
        }

        public void onSendRelevantInfoResult(int i10, String str) {
            if (LelinkSourceSDKImpProxy.this.mAppRelevantInfoListener != null) {
                LelinkSourceSDKImpProxy.this.mAppRelevantInfoListener.onSendRelevantInfoResult(i10, str);
            }
        }
    };
    private LelinkSdkManager mSingleManager;
    private long startDebugTime = 0;

    private LelinkSourceSDKImpProxy() {
    }

    public static /* synthetic */ int access$404(LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy) {
        int i10 = lelinkSourceSDKImpProxy.mBindCount + 1;
        lelinkSourceSDKImpProxy.mBindCount = i10;
        return i10;
    }

    public static synchronized LelinkSourceSDKImpProxy getInstance() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy;
        synchronized (LelinkSourceSDKImpProxy.class) {
            lelinkSourceSDKImpProxy = sInstance;
        }
        return lelinkSourceSDKImpProxy;
    }

    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.addFavoriteDevice(lelinkServiceInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.addFavoriteDevice(lelinkServiceInfo);
            }
        }
    }

    public void addPinCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setServiceInfoParseListener(iServiceInfoParseListener);
                this.mMultiManager.addPinCodeToLelinkServiceInfo(str);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setServiceInfoParseListener(iServiceInfoParseListener);
                this.mSingleManager.addPinCodeToLelinkServiceInfo(str);
            }
        }
    }

    public void addQRCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setServiceInfoParseListener(iServiceInfoParseListener);
                this.mMultiManager.addQRCodeToLelinkServiceInfo(str);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setServiceInfoParseListener(iServiceInfoParseListener);
                this.mSingleManager.addQRCodeToLelinkServiceInfo(str);
            }
        }
    }

    public void addVolume() {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.addVolume();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.addVolume();
            }
        }
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.appendPlayList(dramaInfoBeanArr, i10, i11, i12);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.appendPlayList(dramaInfoBeanArr, i10, i11, i12);
            }
        }
    }

    public void bindSdk(Context context, String str, String str2, IBindSdkListener iBindSdkListener) {
    }

    public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
        if (this.isMultiProcessBind) {
            try {
                return this.mMultiManager.canPlayLocalMedia(lelinkServiceInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                return false;
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                return lelinkSdkManager.canPlayLocalMedia(lelinkServiceInfo);
            }
            return false;
        }
    }

    public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
        if (this.isMultiProcessBind) {
            try {
                return this.mMultiManager.canPlayScreen(lelinkServiceInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                return false;
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                return lelinkSdkManager.canPlayScreen(lelinkServiceInfo);
            }
            return false;
        }
    }

    public void clearPlayList() {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.clearPlayList();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.clearPlayList();
            }
        }
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.connect(lelinkServiceInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.connect(lelinkServiceInfo);
            }
        }
    }

    public void createLelinkServiceInfo(SinkParameterBean sinkParameterBean, IServiceInfoParseListener iServiceInfoParseListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setServiceInfoParseListener(iServiceInfoParseListener);
                this.mMultiManager.setOption(IAPI.OPTION_CREATE_LELINK_SERVICE, new String[]{sinkParameterBean.toJson()});
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setServiceInfoParseListener(iServiceInfoParseListener);
                this.mSingleManager.createLelinkServiceInfo(sinkParameterBean);
            }
        }
    }

    public void createLelinkServiceInfoList(List<SinkParameterBean> list, IServiceInfoListParseListener iServiceInfoListParseListener) {
        SourceLog.i(TAG, "createLelinkServiceInfoList isMultiProcessBind：" + this.isMultiProcessBind);
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setServiceInfoListParseListener(iServiceInfoListParseListener);
                JSONArray jSONArray = new JSONArray();
                for (SinkParameterBean json : list) {
                    jSONArray.put(json.toJson());
                }
                this.mMultiManager.setOption(IAPI.OPTION_CREATE_LELINK_SERVICE_LIST, new String[]{jSONArray.toString()});
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setServiceInfoListParseListener(iServiceInfoListParseListener);
                this.mSingleManager.createLelinkServiceInfoList(list);
            }
        }
    }

    public void createPinCode(ICreatePinCodeListener iCreatePinCodeListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setAICreatePinCodeListener(iCreatePinCodeListener);
                this.mMultiManager.createPinCode();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.createPinCode(iCreatePinCodeListener);
            }
        }
    }

    public void createShortUrl(ICreateShortUrlListener iCreateShortUrlListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setAICreateShortUrlListener(iCreateShortUrlListener);
                this.mMultiManager.createShortUrl();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.createShortUrl(iCreateShortUrlListener);
            }
        }
    }

    public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
        if (this.isMultiProcessBind) {
            try {
                return this.mMultiManager.disconnect(lelinkServiceInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
                return true;
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                return lelinkSdkManager.disconnect(lelinkServiceInfo);
            }
            return true;
        }
    }

    public List<LelinkServiceInfo> getConnectInfos() {
        if (this.isMultiProcessBind) {
            try {
                return this.mMultiManager.getConnectInfos();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
                return null;
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                return lelinkSdkManager.getConnectInfos();
            }
            return null;
        }
    }

    public void getFavoriteDeviceList(int i10, int i11) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.getFavoriteDeviceList(i10, i11);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.getFavoriteDeviceList(i10, i11);
            }
        }
    }

    public void getHistoryDeviceList(int i10, int i11) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.getHistoryDeviceList(i10, i11);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.getHistoryDeviceList(i10, i11);
            }
        }
    }

    public Object getOption(int i10, Object... objArr) {
        SourceLog.i(TAG, "getOption " + i10);
        switch (i10) {
            case IAPI.OPTION_35:
            case IAPI.OPTION_37:
            case IAPI.OPTION_63:
            case IAPI.OPTION_QUERY_SUPPORT_MULTI_CHANNEL:
            case IAPI.OPTION_QUERY_SUPPORT_URL_LIST:
            case IAPI.OPTION_QUERY_SUPPORT_REVERSE_CONTROL:
            case IAPI.OPTION_TEMP_RESTRICT:
            case IAPI.OPTION_QUERY_SUPPORT_TRACK:
            case IAPI.OPTION_SET_RECEIVER_PROPERTY:
            case IAPI.OPTION_GET_RECEIVER_PROPERTIES:
                if (objArr != null && objArr.length > 0) {
                    LelinkServiceInfo lelinkServiceInfo = objArr[0];
                    if (lelinkServiceInfo instanceof LelinkServiceInfo) {
                        LelinkServiceInfo lelinkServiceInfo2 = lelinkServiceInfo;
                        if (this.isMultiProcessBind) {
                            try {
                                return Boolean.valueOf(this.mMultiManager.setLelinkServiceInfoOption(i10, lelinkServiceInfo2));
                            } catch (Exception e10) {
                                SourceLog.w(TAG, (Throwable) e10);
                            }
                        } else {
                            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                            if (lelinkSdkManager != null) {
                                Object option = lelinkSdkManager.getOption(i10, lelinkServiceInfo2);
                                if (option == null || TextUtils.isEmpty(option.toString()) || !HpplayUtil.isDigitsOnly(option.toString()) || Integer.parseInt(option.toString()) != 0) {
                                    return Boolean.FALSE;
                                }
                                return Boolean.TRUE;
                            }
                        }
                    }
                }
                return Boolean.FALSE;
            default:
                if (this.isMultiProcessBind) {
                    try {
                        String option2 = this.mMultiManager.getOption(i10);
                        if (TextUtils.isEmpty(option2) || !HpplayUtil.isDigitsOnly(option2)) {
                            return option2;
                        }
                        return Integer.valueOf(Integer.parseInt(option2));
                    } catch (Exception e11) {
                        SourceLog.w(TAG, (Throwable) e11);
                    }
                } else {
                    LelinkSdkManager lelinkSdkManager2 = this.mSingleManager;
                    if (lelinkSdkManager2 != null) {
                        return lelinkSdkManager2.getOption(i10, objArr);
                    }
                    return -1;
                }
                break;
        }
    }

    public String getSDKInfos(int i10) {
        if (this.isMultiProcessBind) {
            try {
                return this.mMultiManager.getSDKInfos(i10);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                return "";
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                return lelinkSdkManager.getSDKInfos(i10);
            }
            return "";
        }
    }

    public VirtualDisplay getVirtualDisplay() {
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            return lelinkSdkManager.getVirtualDisplay();
        }
        return null;
    }

    public void pause() {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.pause();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.pause();
            }
        }
    }

    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.removeFavoriteDevice(list);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.removeFavoriteDevice(list);
            }
        }
    }

    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.removeHistoryDevice(list, i10);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.removeHistoryDevice(list, i10);
            }
        }
    }

    public void resume() {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.resume();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.resume();
            }
        }
    }

    public void retryBind() {
        Handler handler = this.mHandler;
        if (handler != null && this.mBindCount < 3) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    if (LelinkSourceSDKImpProxy.this.mMultiConnection != null) {
                        LelinkSourceSDKImpProxy.this.mMultiConnection.startBind();
                    }
                    LelinkSourceSDKImpProxy.access$404(LelinkSourceSDKImpProxy.this);
                    boolean unused = LelinkSourceSDKImpProxy.this.isMultiProcessBind = false;
                }
            }, 500);
        }
    }

    public void seekTo(int i10) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.seekTo(i10);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.seekTo(i10);
            }
        }
    }

    public void setBrowseResultListener(IBrowseListener iBrowseListener) {
        this.mAppBrowseListener = iBrowseListener;
        SourceLog.i(TAG, "LelinkSourceSdkImp setBrowseResultListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setBrowseResultListener(iBrowseListener);
                return;
            }
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setBrowseListener(iBrowseListener);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void setCommonListener(ICommonListener iCommonListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setCommonListener(iCommonListener);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setCommonListener(iCommonListener);
            }
        }
    }

    public void setConnectListener(IConnectListener iConnectListener) {
        this.mAppConnectListener = iConnectListener;
        try {
            SourceLog.i(TAG, "LelinkSourceSdkImp setConnectListener " + this.isMultiProcessBind);
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setConnectListener(iConnectListener);
                return;
            }
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setConnectListener(iConnectListener);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        this.mAppDaPlayerListener = iDaPlayerListener;
        SourceLog.i(TAG, "setDaPlayListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setDaPlayListener(iDaPlayerListener);
                return;
            }
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setDaPlayListener(iDaPlayerListener);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void setDebugAVListener(IDebugAVListener iDebugAVListener) {
        this.mAppDebugAVListener = iDebugAVListener;
        SourceLog.i(TAG, "LelinkSourceSdkImp setDebugAVListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setDebugAVListener(iDebugAVListener);
                return;
            }
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setDebugAVListener(iDebugAVListener);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void setDebugMode(boolean z10) {
        this.isDebug = z10;
        if (LelinkConfig.isMultiProgress() && !this.isMultiProcessBind) {
            SourceLog.w(TAG, "service is binding");
            this.isSetDebugModeWork = false;
        } else if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setDebugMode(z10);
                this.isSetDebugModeWork = true;
                SourceLog.i(TAG, "setDebugMode," + z10);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.isDebug(z10);
            }
        }
    }

    public void setDebugTimestamp(boolean z10) {
        this.isDebugTimestamp = z10;
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setDebugTimestamp(z10);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.isDebugTimestamp(z10);
            }
        }
    }

    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.setFavoriteDeviceAlias(lelinkServiceInfo, str);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setFavoriteDeviceAlias(lelinkServiceInfo, str);
            }
        }
    }

    public void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setFavoriteDeviceListener(iFavoriteDeviceListener);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setFavoriteDeviceListener(iFavoriteDeviceListener);
            }
        }
    }

    public void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setHistoryDeviceListener(iHistoryDeviceListener);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setHistoryDeviceListener(iHistoryDeviceListener);
            }
        }
    }

    public void setLogCallback(ILogCallback iLogCallback) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setLogCallback(iLogCallback);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setLogCallback(iLogCallback);
            }
        }
    }

    public void setMirrorChangeListener(IMirrorChangeListener iMirrorChangeListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setMirrorChangeListener(iMirrorChangeListener);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setMirrorChangeListener(iMirrorChangeListener);
            }
        }
    }

    public void setMultiManager(z zVar, LelinkServiceConnection lelinkServiceConnection) {
        this.isMultiProcessBind = true;
        this.mMultiManager = zVar;
        this.mMultiConnection = lelinkServiceConnection;
        lelinkServiceConnection.setDebugAVListener(this.mAppDebugAVListener);
        this.mMultiConnection.setBrowseResultListener(this.mAppBrowseListener);
        this.mMultiConnection.setConnectListener(this.mAppConnectListener);
        this.mMultiConnection.setPlayListener(this.mAppLelinkPlayerListener);
        this.mMultiConnection.setNewPlayListener(this.mAppNewPlayerListener);
        this.mMultiConnection.setDaPlayListener(this.mAppDaPlayerListener);
        this.mMultiConnection.setAuthListener(this.mAppAuthListener);
        if (!this.isSetDebugModeWork) {
            this.mMultiConnection.setDebugMode(this.isDebug);
        }
        this.mMultiConnection.setCommonListener(this.mCommonListener);
    }

    public void setNewPlayListener(INewPlayerListener iNewPlayerListener) {
        this.mAppNewPlayerListener = iNewPlayerListener;
        SourceLog.i(TAG, "setNewPlayListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setNewPlayListener(iNewPlayerListener);
                return;
            }
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setNewPlayerListener(iNewPlayerListener);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:155:0x02d6 A[Catch:{ Exception -> 0x02e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02de A[Catch:{ Exception -> 0x02e6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOption(int r9, java.lang.Object... r10) {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = "LelinkSourceSdkImpProxy"
            r2 = 1
            r3 = 0
            switch(r9) {
                case 65539: goto L_0x0278;
                case 65540: goto L_0x025a;
                case 1048615: goto L_0x024a;
                case 1048617: goto L_0x0224;
                case 1048675: goto L_0x01f3;
                case 1048676: goto L_0x01c2;
                case 1179648: goto L_0x018e;
                case 1179649: goto L_0x018e;
                case 1179650: goto L_0x0169;
                case 1179651: goto L_0x0144;
                case 2097207: goto L_0x00c7;
                case 2097208: goto L_0x009d;
                case 2097234: goto L_0x0054;
                case 2097235: goto L_0x000d;
                default: goto L_0x0008;
            }
        L_0x0008:
            if (r10 == 0) goto L_0x02b4
            int r0 = r10.length     // Catch:{ Exception -> 0x02e6 }
            goto L_0x02a2
        L_0x000d:
            if (r10 == 0) goto L_0x0307
            int r2 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r2 <= 0) goto L_0x0307
            r2 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            boolean r2 = r2 instanceof com.hpplay.sdk.source.api.IReceiverPropertiesCallback     // Catch:{ Exception -> 0x02a0 }
            if (r2 == 0) goto L_0x0307
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a0 }
            r2.<init>()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r4 = "OPTION_GET_RECEIVER_PROPERTIES: "
            r2.append(r4)     // Catch:{ Exception -> 0x02a0 }
            r4 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            r2.append(r4)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.log.SourceLog.i(r1, r2)     // Catch:{ Exception -> 0x02a0 }
            r10 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.api.IReceiverPropertiesCallback r10 = (com.hpplay.sdk.source.api.IReceiverPropertiesCallback) r10     // Catch:{ Exception -> 0x02a0 }
            r8.mAppReceiverPropertiesCallback = r10     // Catch:{ Exception -> 0x02a0 }
            boolean r2 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r2 == 0) goto L_0x0046
            com.hpplay.sdk.source.z r10 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.q r2 = r8.mReceiverPropertiesCallback     // Catch:{ Exception -> 0x02a0 }
            r10.setReceiverPropertiesCallback(r2)     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.z r10 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            r10.setOption(r9, r0)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0046:
            com.hpplay.sdk.source.process.LelinkSdkManager r2 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            if (r2 == 0) goto L_0x0307
            r2.setReceiverPropertiesCallback(r10)     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.process.LelinkSdkManager r10 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            r10.setOption(r9, r0)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0054:
            if (r10 == 0) goto L_0x0307
            int r0 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r0 <= 0) goto L_0x0307
            r0 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r0 instanceof com.hpplay.sdk.source.bean.ReceiverPropertyBean     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a0 }
            r0.<init>()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r4 = "OPTION_SET_RECEIVER_PROPERTY"
            r0.append(r4)     // Catch:{ Exception -> 0x02a0 }
            r4 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            r0.append(r4)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.log.SourceLog.i(r1, r0)     // Catch:{ Exception -> 0x02a0 }
            r10 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.bean.ReceiverPropertyBean r10 = (com.hpplay.sdk.source.bean.ReceiverPropertyBean) r10     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x008c
            com.hpplay.sdk.source.z r0 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r10 = r10.toJson()     // Catch:{ Exception -> 0x02a0 }
            r2[r3] = r10     // Catch:{ Exception -> 0x02a0 }
            r0.setOption(r9, r2)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x008c:
            com.hpplay.sdk.source.process.LelinkSdkManager r0 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r10 = r10.toJson()     // Catch:{ Exception -> 0x02a0 }
            r2[r3] = r10     // Catch:{ Exception -> 0x02a0 }
            r0.setOption(r9, r2)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x009d:
            if (r10 == 0) goto L_0x0307
            int r2 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r2 <= 0) goto L_0x0307
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x02a0 }
            r2.<init>()     // Catch:{ Exception -> 0x02a0 }
            r4 = 0
        L_0x00a8:
            int r5 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r4 >= r5) goto L_0x00b5
            r5 = r10[r4]     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.browse.api.LelinkServiceInfo r5 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r5     // Catch:{ Exception -> 0x02a0 }
            r2.add(r5)     // Catch:{ Exception -> 0x02a0 }
            int r4 = r4 + 1
            goto L_0x00a8
        L_0x00b5:
            boolean r10 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r10 == 0) goto L_0x00c0
            com.hpplay.sdk.source.z r10 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            r10.multiPushControl(r3, r2, r0, r3)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x00c0:
            com.hpplay.sdk.source.process.LelinkSdkManager r10 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            r10.multiPushControl(r3, r2, r0, r3)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x00c7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a0 }
            r0.<init>()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r4 = "MULTIPUSH_ADDED_DEVES values:"
            r0.append(r4)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r4 = java.util.Arrays.toString(r10)     // Catch:{ Exception -> 0x02a0 }
            r0.append(r4)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.log.SourceLog.i(r1, r0)     // Catch:{ Exception -> 0x02a0 }
            if (r10 == 0) goto L_0x0307
            int r0 = r10.length     // Catch:{ Exception -> 0x02a0 }
            r4 = 2
            if (r0 <= r4) goto L_0x0307
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x02a0 }
            r0.<init>()     // Catch:{ Exception -> 0x02a0 }
            r4 = r10[r4]     // Catch:{ Exception -> 0x02a0 }
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch:{ Exception -> 0x02a0 }
            r5 = 0
        L_0x00ef:
            int r6 = r4.length     // Catch:{ Exception -> 0x02a0 }
            if (r5 >= r6) goto L_0x011a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a0 }
            r6.<init>()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r7 = "MULTIPUSH_ADDED_DEVES values :"
            r6.append(r7)     // Catch:{ Exception -> 0x02a0 }
            r6.append(r5)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r7 = ", "
            r6.append(r7)     // Catch:{ Exception -> 0x02a0 }
            r7 = r4[r5]     // Catch:{ Exception -> 0x02a0 }
            r6.append(r7)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.log.SourceLog.i(r1, r6)     // Catch:{ Exception -> 0x02a0 }
            r6 = r4[r5]     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.browse.api.LelinkServiceInfo r6 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r6     // Catch:{ Exception -> 0x02a0 }
            r0.add(r6)     // Catch:{ Exception -> 0x02a0 }
            int r5 = r5 + 1
            goto L_0x00ef
        L_0x011a:
            boolean r4 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r4 == 0) goto L_0x0131
            com.hpplay.sdk.source.z r4 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            r3 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x02a0 }
            r10 = r10[r2]     // Catch:{ Exception -> 0x02a0 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ Exception -> 0x02a0 }
            int r10 = r10.intValue()     // Catch:{ Exception -> 0x02a0 }
            r4.multiPushControl(r2, r0, r3, r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0131:
            com.hpplay.sdk.source.process.LelinkSdkManager r4 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            r3 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x02a0 }
            r10 = r10[r2]     // Catch:{ Exception -> 0x02a0 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ Exception -> 0x02a0 }
            int r10 = r10.intValue()     // Catch:{ Exception -> 0x02a0 }
            r4.multiPushControl(r2, r0, r3, r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0144:
            if (r10 == 0) goto L_0x0307
            int r0 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r0 <= 0) goto L_0x0307
            r10 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r10 instanceof com.hpplay.sdk.source.api.ICloudMirrorPlayListener     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            com.hpplay.sdk.source.api.ICloudMirrorPlayListener r10 = (com.hpplay.sdk.source.api.ICloudMirrorPlayListener) r10     // Catch:{ Exception -> 0x02a0 }
            r8.mAppCloudMirrorPlayListener = r10     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0160
            com.hpplay.sdk.source.z r10 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.c r0 = r8.mCloudMirrorPlayListener     // Catch:{ Exception -> 0x02a0 }
            r10.setCloudMirrorPlayListener(r0)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0160:
            com.hpplay.sdk.source.process.LelinkSdkManager r0 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            r0.setCloudMirrorPlayListener(r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0169:
            if (r10 == 0) goto L_0x0307
            int r0 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r0 <= 0) goto L_0x0307
            r10 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r10 instanceof com.hpplay.sdk.source.api.IRelevantInfoListener     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            com.hpplay.sdk.source.api.IRelevantInfoListener r10 = (com.hpplay.sdk.source.api.IRelevantInfoListener) r10     // Catch:{ Exception -> 0x02a0 }
            r8.mAppRelevantInfoListener = r10     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0185
            com.hpplay.sdk.source.z r10 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.r r0 = r8.mRelevantInfoListener     // Catch:{ Exception -> 0x02a0 }
            r10.setRelevantInfoListener(r0)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0185:
            com.hpplay.sdk.source.process.LelinkSdkManager r0 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            r0.setRelevantInfoListener(r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x018e:
            if (r10 == 0) goto L_0x0307
            int r0 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r0 <= 0) goto L_0x0307
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x02a0 }
            r0.<init>()     // Catch:{ Exception -> 0x02a0 }
            r4 = 0
        L_0x0199:
            int r5 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r4 >= r5) goto L_0x01a6
            r5 = r10[r4]     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.browse.api.LelinkServiceInfo r5 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r5     // Catch:{ Exception -> 0x02a0 }
            r0.add(r5)     // Catch:{ Exception -> 0x02a0 }
            int r4 = r4 + 1
            goto L_0x0199
        L_0x01a6:
            boolean r10 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            r4 = 1179648(0x120000, float:1.653039E-39)
            if (r10 == 0) goto L_0x01b7
            com.hpplay.sdk.source.z r10 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            if (r4 != r9) goto L_0x01b1
            goto L_0x01b2
        L_0x01b1:
            r2 = 0
        L_0x01b2:
            r10.multiMirrorControl(r2, r0)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x01b7:
            com.hpplay.sdk.source.process.LelinkSdkManager r10 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            if (r4 != r9) goto L_0x01bc
            goto L_0x01bd
        L_0x01bc:
            r2 = 0
        L_0x01bd:
            r10.multiMirrorControl(r2, r0)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x01c2:
            if (r10 == 0) goto L_0x0307
            int r0 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r0 <= 0) goto L_0x0307
            r10 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r10 instanceof com.hpplay.sdk.source.bean.DanmakuPropertyBean     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            com.hpplay.sdk.source.bean.DanmakuPropertyBean r10 = (com.hpplay.sdk.source.bean.DanmakuPropertyBean) r10     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x01e2
            com.hpplay.sdk.source.z r0 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r10 = r10.toJson(r3)     // Catch:{ Exception -> 0x02a0 }
            r2[r3] = r10     // Catch:{ Exception -> 0x02a0 }
            r0.setOption(r9, r2)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x01e2:
            com.hpplay.sdk.source.process.LelinkSdkManager r0 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r10 = r10.toJson(r3)     // Catch:{ Exception -> 0x02a0 }
            r2[r3] = r10     // Catch:{ Exception -> 0x02a0 }
            r0.setOption(r9, r2)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x01f3:
            if (r10 == 0) goto L_0x0307
            int r4 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r4 <= 0) goto L_0x0307
            r10 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            boolean r4 = r10 instanceof com.hpplay.sdk.source.bean.DanmakuBean     // Catch:{ Exception -> 0x02a0 }
            if (r4 == 0) goto L_0x0307
            com.hpplay.sdk.source.bean.DanmakuBean r10 = (com.hpplay.sdk.source.bean.DanmakuBean) r10     // Catch:{ Exception -> 0x02a0 }
            boolean r4 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r4 == 0) goto L_0x0213
            com.hpplay.sdk.source.z r4 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r10 = r10.toJson(r0, r3)     // Catch:{ Exception -> 0x02a0 }
            r2[r3] = r10     // Catch:{ Exception -> 0x02a0 }
            r4.setOption(r9, r2)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0213:
            com.hpplay.sdk.source.process.LelinkSdkManager r4 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            if (r4 == 0) goto L_0x0307
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r10 = r10.toJson(r0, r3)     // Catch:{ Exception -> 0x02a0 }
            r2[r3] = r10     // Catch:{ Exception -> 0x02a0 }
            r4.setOption(r9, r2)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0224:
            r10 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r10 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            boolean r0 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x023b
            com.hpplay.sdk.source.z r0 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ Exception -> 0x02a0 }
            boolean r10 = r10.booleanValue()     // Catch:{ Exception -> 0x02a0 }
            r0.setSystemApp(r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x023b:
            com.hpplay.sdk.source.process.LelinkSdkManager r0 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ Exception -> 0x02a0 }
            boolean r10 = r10.booleanValue()     // Catch:{ Exception -> 0x02a0 }
            r0.setSystemApp(r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x024a:
            int r0 = r10.length     // Catch:{ Exception -> 0x02a0 }
            if (r0 <= 0) goto L_0x0307
            r10 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r10 instanceof com.hpplay.sdk.source.api.ILogCallback     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            com.hpplay.sdk.source.api.ILogCallback r10 = (com.hpplay.sdk.source.api.ILogCallback) r10     // Catch:{ Exception -> 0x02a0 }
            r8.setLogCallback(r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x025a:
            r10 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.browse.api.AuthListener r10 = (com.hpplay.sdk.source.browse.api.AuthListener) r10     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x026d
            com.hpplay.sdk.source.process.LelinkServiceConnection r0 = r8.mMultiConnection     // Catch:{ Exception -> 0x0268 }
            r0.setAuthListener(r10)     // Catch:{ Exception -> 0x0268 }
            goto L_0x0274
        L_0x0268:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r1, (java.lang.Throwable) r0)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0274
        L_0x026d:
            com.hpplay.sdk.source.process.LelinkSdkManager r0 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0274
            r0.setAuthListener(r10)     // Catch:{ Exception -> 0x02a0 }
        L_0x0274:
            r8.mAppAuthListener = r10     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x0278:
            r0 = r10[r3]     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.browse.api.IAPICallbackListener r0 = (com.hpplay.sdk.source.browse.api.IAPICallbackListener) r0     // Catch:{ Exception -> 0x02a0 }
            r10 = r10[r2]     // Catch:{ Exception -> 0x02a0 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0307
            if (r10 != 0) goto L_0x0286
            goto L_0x0307
        L_0x0286:
            boolean r2 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02a0 }
            if (r2 == 0) goto L_0x029a
            com.hpplay.sdk.source.process.LelinkServiceConnection r2 = r8.mMultiConnection     // Catch:{ Exception -> 0x02a0 }
            r2.setOnlineCheckListener(r0)     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.z r0 = r8.mMultiManager     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.process.LelinkServiceConnection r2 = r8.mMultiConnection     // Catch:{ Exception -> 0x02a0 }
            com.hpplay.sdk.source.p r2 = r2.mOnlineCheckListener     // Catch:{ Exception -> 0x02a0 }
            r0.startOnlineCheck(r2, r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x029a:
            com.hpplay.sdk.source.process.LelinkSdkManager r2 = r8.mSingleManager     // Catch:{ Exception -> 0x02a0 }
            r2.startOnlineCheck(r0, r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x02a0:
            r10 = move-exception
            goto L_0x02eb
        L_0x02a2:
            if (r0 <= 0) goto L_0x02b4
            int r0 = r10.length     // Catch:{ Exception -> 0x02e6 }
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ Exception -> 0x02e6 }
        L_0x02a7:
            if (r3 >= r0) goto L_0x02b6
            r4 = r10[r3]     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x02e6 }
            r2[r3] = r4     // Catch:{ Exception -> 0x02e6 }
            int r3 = r3 + 1
            goto L_0x02a7
        L_0x02b4:
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x02e6 }
        L_0x02b6:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e6 }
            r10.<init>()     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r0 = "isMultiProcessBind "
            r10.append(r0)     // Catch:{ Exception -> 0x02e6 }
            r10.append(r9)     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r0 = " / "
            r10.append(r0)     // Catch:{ Exception -> 0x02e6 }
            r10.append(r2)     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x02e6 }
            com.hpplay.sdk.source.log.SourceLog.i(r1, r10)     // Catch:{ Exception -> 0x02e6 }
            boolean r10 = r8.isMultiProcessBind     // Catch:{ Exception -> 0x02e6 }
            if (r10 == 0) goto L_0x02de
            com.hpplay.sdk.source.z r10 = r8.mMultiManager     // Catch:{ Exception -> 0x02e6 }
            if (r10 == 0) goto L_0x0307
            r10.setOption(r9, r2)     // Catch:{ Exception -> 0x02e6 }
            goto L_0x0307
        L_0x02de:
            com.hpplay.sdk.source.process.LelinkSdkManager r10 = r8.mSingleManager     // Catch:{ Exception -> 0x02e6 }
            if (r10 == 0) goto L_0x0307
            r10.setOption(r9, r2)     // Catch:{ Exception -> 0x02e6 }
            goto L_0x0307
        L_0x02e6:
            r10 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r1, (java.lang.Throwable) r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0307
        L_0x02eb:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "setOption: process may be closed "
            r0.append(r2)
            r0.append(r9)
            java.lang.String r9 = " , "
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = r0.toString()
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r1, (java.lang.String) r9)
        L_0x0307:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.process.LelinkSourceSDKImpProxy.setOption(int, java.lang.Object[]):void");
    }

    public void setPlayListener(ILelinkPlayerListener iLelinkPlayerListener) {
        this.mAppLelinkPlayerListener = iLelinkPlayerListener;
        SourceLog.i(TAG, "setPlayListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setPlayListener(iLelinkPlayerListener);
                return;
            }
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setPlayerListener(iLelinkPlayerListener);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void setSearchBannerDataCallback(ISearchBannerDataCallback iSearchBannerDataCallback) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setSearchBannerDataCallback(iSearchBannerDataCallback);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setSearchBannerDataCallback(iSearchBannerDataCallback);
            }
        }
    }

    public void setSendPassCallback(ISendPassCallback iSendPassCallback) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setPassCallback(iSendPassCallback);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setPassCallback(iSendPassCallback);
            }
        }
    }

    public void setSingleManager(LelinkSdkManager lelinkSdkManager) {
        this.mSingleManager = lelinkSdkManager;
        lelinkSdkManager.setDebugAVListener(this.mAppDebugAVListener);
        this.mSingleManager.setBrowseListener(this.mAppBrowseListener);
        this.mSingleManager.setConnectListener(this.mAppConnectListener);
        this.mSingleManager.setPlayerListener(this.mAppLelinkPlayerListener);
        this.mSingleManager.setNewPlayerListener(this.mAppNewPlayerListener);
        this.mSingleManager.setDaPlayListener(this.mAppDaPlayerListener);
        this.mSingleManager.setAuthListener(this.mAppAuthListener);
        this.mSingleManager.setCommonListener(this.mCommonListener);
    }

    public void setSinkKeyEventListener(ISinkKeyEventListener iSinkKeyEventListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setSinkKeyEventListener(iSinkKeyEventListener);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setSinkKeyEventListener(iSinkKeyEventListener);
            }
        }
    }

    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, ISinkTouchEventListener iSinkTouchEventListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setSinkTouchEventListener(sinkTouchEventArea, f10, iSinkTouchEventListener);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setSinkTouchEventListener(sinkTouchEventArea, f10, iSinkTouchEventListener);
            }
        }
    }

    public void setVolume(int i10) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.setVolume(i10);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setVolume(i10);
            }
        }
    }

    public void startBrowse(boolean z10, boolean z11) {
        SourceLog.i(TAG, "startBrowse " + this.isMultiProcessBind);
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.browse(z10, z11);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.startBrowseThread(z10, z11);
            }
        }
    }

    public void startDebugThread() {
        if (Session.getInstance().getDebugTimestamp() && System.currentTimeMillis() - this.startDebugTime >= 200) {
            DebugTSThread debugTSThread = this.mDebugTSThread;
            if (debugTSThread == null || !debugTSThread.isAlive()) {
                DebugTimestampBean debugTimestampBean = new DebugTimestampBean();
                Session.getInstance().setDebugTimestampBean(debugTimestampBean);
                DebugTSThread debugTSThread2 = new DebugTSThread(debugTimestampBean);
                this.mDebugTSThread = debugTSThread2;
                debugTSThread2.start();
            }
            this.mDebugTSThread.startThread();
            this.startDebugTime = System.currentTimeMillis();
        }
    }

    public void startMirror(LelinkPlayerInfo lelinkPlayerInfo) {
        SourceLog.i(TAG, "startMirror " + this.isMultiProcessBind);
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.startMirrorForPlayerInfo(lelinkPlayerInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.startMirror(lelinkPlayerInfo);
                startDebugThread();
            }
        }
    }

    public void startPlayMedia(String str, int i10, boolean z10) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.startPlayMedia(str, i10, z10);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.startPlayMedia((LelinkServiceInfo) null, str, i10, z10);
            }
        }
    }

    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.startPlayMediaImmed(lelinkServiceInfo, str, i10, z10);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.startPlayMedia(lelinkServiceInfo, str, i10, z10);
            }
        }
    }

    public void stopBrowse() {
        SourceLog.i(TAG, "LelinkSourceSdkImp stopBrowse " + this.isMultiProcessBind);
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.stopBrowse();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.stopBrowseThread();
            }
        }
    }

    public void stopDebugThread() {
        if (this.mDebugTSThread != null && System.currentTimeMillis() - this.startDebugTime > 200) {
            this.mDebugTSThread.stopThread();
        }
    }

    public void stopPlay() {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.stopPlay();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.stopPlay();
                stopDebugThread();
            }
        }
    }

    public void subVolume() {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.subVolume();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.subVolume();
            }
        }
    }

    public void unBindSdk() {
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.unBind();
                return;
            }
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.release();
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.updateAudioData(bArr, audioFrameBean);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.updateAudioData(bArr, audioFrameBean);
            }
        }
    }

    public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.updateVideoData(bArr, videoFrameBean);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.updateVideoData(bArr, videoFrameBean);
            }
        }
    }

    public void bindSdk(Context context, String str, String str2, String str3, IBindSdkListener iBindSdkListener) {
    }

    public void bindSdk(Context context, String str, String str2, String str3, String str4, String str5, IBindSdkListener iBindSdkListener) {
    }

    public void startPlayMedia(LelinkPlayerInfo lelinkPlayerInfo) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.startPlayMediaForPlayerInfo(lelinkPlayerInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.startPlayCheck(lelinkPlayerInfo);
            }
        }
    }

    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, Uri uri, int i10) {
        LelinkPlayerInfo lelinkPlayerInfo = new LelinkPlayerInfo();
        lelinkPlayerInfo.setLelinkServiceInfo(lelinkServiceInfo);
        lelinkPlayerInfo.setLocalUri(uri);
        lelinkPlayerInfo.setType(i10);
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.startPlayMediaForPlayerInfo(lelinkPlayerInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                retryBind();
            }
        } else {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.startPlayCheck(lelinkPlayerInfo);
            }
        }
    }
}
