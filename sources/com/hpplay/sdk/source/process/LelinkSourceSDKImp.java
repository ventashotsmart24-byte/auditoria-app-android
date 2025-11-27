package com.hpplay.sdk.source.process;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.sdk.source.a.a;
import com.hpplay.sdk.source.api.IBindSdkListener;
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
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.ISendPassCallback;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkServiceConnection;
import com.hpplay.sdk.source.z;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.List;

public class LelinkSourceSDKImp implements ILelinkSourceSDK {
    private static final String TAG = "LelinkSourceSDKImp";
    private static LelinkSourceSDKImp sInstance;
    private a.C0157a appLifecycleCallback = new a.C0157a() {
        public void onAppPause() {
            if (LelinkSourceSDKImp.this.mImplProxy == null) {
                SourceLog.w(LelinkSourceSDKImp.TAG, "onAppPause ignore");
                return;
            }
            SourceLog.i(LelinkSourceSDKImp.TAG, "===> app in background ");
            LelinkSourceSDKImp.this.mImplProxy.setOption(IAPI.OPTION_APP_PAUSE, new Object[0]);
        }

        public void onAppResume() {
            if (LelinkSourceSDKImp.this.mImplProxy == null) {
                SourceLog.w(LelinkSourceSDKImp.TAG, "onAppResume ignore");
                return;
            }
            SourceLog.i(LelinkSourceSDKImp.TAG, "=====> app in Foreground ");
            LelinkSourceSDKImp.this.mImplProxy.setOption(IAPI.OPTION_APP_RESUME, new Object[0]);
        }
    };
    private a mAppLifecycleListen;
    /* access modifiers changed from: private */
    public LelinkServiceConnection.OnBindStatusListener mBindStatusListener = new LelinkServiceConnection.OnBindStatusListener() {
        public void onServiceConnected(z zVar) {
            if (LelinkSourceSDKImp.this.mImplProxy == null) {
                SourceLog.w(LelinkSourceSDKImp.TAG, "onServiceConnected ignore");
                return;
            }
            SourceLog.i(LelinkSourceSDKImp.TAG, "sdk bind successful");
            LelinkSourceSDKImp.this.mImplProxy.setMultiManager(zVar, LelinkSourceSDKImp.this.mServiceConnection);
        }

        public void onServiceDisconnected() {
            if (LelinkSourceSDKImp.this.mImplProxy == null) {
                SourceLog.w(LelinkSourceSDKImp.TAG, "onServiceDisconnected ignore");
                return;
            }
            SourceLog.i(LelinkSourceSDKImp.TAG, "sdk bind failed ");
            LelinkSourceSDKImp.this.mImplProxy.retryBind();
        }
    };
    /* access modifiers changed from: private */
    public Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public LelinkSourceSDKImpProxy mImplProxy = LelinkSourceSDKImpProxy.getInstance();
    /* access modifiers changed from: private */
    public LelinkServiceConnection mServiceConnection;

    private LelinkSourceSDKImp() {
    }

    private void currentProcessBind(String str, String str2, String str3, String str4, String str5) {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "currentProcessBind ignore");
            return;
        }
        LelinkSdkManager instance = LelinkSdkManager.getInstance();
        instance.initSDK(this.mContext, str, str2, str3, str4, str5);
        this.mImplProxy.setSingleManager(instance);
    }

    public static synchronized LelinkSourceSDKImp getInstance() {
        LelinkSourceSDKImp lelinkSourceSDKImp;
        synchronized (LelinkSourceSDKImp.class) {
            synchronized (LelinkSourceSDKImp.class) {
                if (sInstance == null) {
                    sInstance = new LelinkSourceSDKImp();
                }
            }
            lelinkSourceSDKImp = sInstance;
        }
        return lelinkSourceSDKImp;
    }

    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "addFavoriteDevice ignore");
        } else {
            lelinkSourceSDKImpProxy.addFavoriteDevice(lelinkServiceInfo);
        }
    }

    public void addPinCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "addPinCodeToLelinkServiceInfo ignore");
        } else {
            lelinkSourceSDKImpProxy.addPinCodeToLelinkServiceInfo(str, iServiceInfoParseListener);
        }
    }

    public void addQRCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "addQRCodeToLelinkServiceInfo ignore");
        } else {
            lelinkSourceSDKImpProxy.addQRCodeToLelinkServiceInfo(str, iServiceInfoParseListener);
        }
    }

    public void addVolume() {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "addVolume ignore");
            return;
        }
        SourceLog.i(TAG, "addVolume");
        this.mImplProxy.addVolume();
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "appendList ignore");
        } else {
            lelinkSourceSDKImpProxy.appendPlayList(dramaInfoBeanArr, i10, i11, i12);
        }
    }

    public void bindSdk(Context context, String str, String str2, IBindSdkListener iBindSdkListener) {
        bindSdk(context, str, str2, (String) null, (String) null, (String) null, iBindSdkListener);
    }

    public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.canPlayScreen(lelinkServiceInfo);
        }
        SourceLog.w(TAG, "canPlayLocalMedia ignore");
        return false;
    }

    public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.canPlayScreen(lelinkServiceInfo);
        }
        SourceLog.w(TAG, "canPlayScreen ignore");
        return false;
    }

    public void clearPlayList() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "clearList ignore");
        } else {
            lelinkSourceSDKImpProxy.clearPlayList();
        }
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "connect ignore");
        } else {
            lelinkSourceSDKImpProxy.connect(lelinkServiceInfo);
        }
    }

    public void createLelinkServiceInfo(SinkParameterBean sinkParameterBean, IServiceInfoParseListener iServiceInfoParseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null || sinkParameterBean == null) {
            SourceLog.w(TAG, "createLelinkServiceInfo ignore");
        } else {
            lelinkSourceSDKImpProxy.createLelinkServiceInfo(sinkParameterBean, iServiceInfoParseListener);
        }
    }

    public void createLelinkServiceInfoList(List<SinkParameterBean> list, IServiceInfoListParseListener iServiceInfoListParseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null || list == null) {
            SourceLog.w(TAG, "createLelinkServiceInfoList ignore");
        } else {
            lelinkSourceSDKImpProxy.createLelinkServiceInfoList(list, iServiceInfoListParseListener);
        }
    }

    public void createPinCode(ICreatePinCodeListener iCreatePinCodeListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "createPinCode ignore");
        } else {
            lelinkSourceSDKImpProxy.createPinCode(iCreatePinCodeListener);
        }
    }

    public void createShortUrl(ICreateShortUrlListener iCreateShortUrlListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "createShortUrl ignore");
        } else {
            lelinkSourceSDKImpProxy.createShortUrl(iCreateShortUrlListener);
        }
    }

    public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.disconnect(lelinkServiceInfo);
        }
        SourceLog.w(TAG, "disconnect ignore");
        return false;
    }

    public List<LelinkServiceInfo> getConnectInfos() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.getConnectInfos();
        }
        SourceLog.w(TAG, "getConnectInfos ignore");
        return null;
    }

    public void getFavoriteDeviceList(int i10, int i11) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "getFavoriteDeviceList ignore");
        } else {
            lelinkSourceSDKImpProxy.getFavoriteDeviceList(i10, i11);
        }
    }

    public void getHistoryDeviceList(int i10, int i11) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "getHistoryDeviceList ignore");
        } else {
            lelinkSourceSDKImpProxy.getHistoryDeviceList(i10, i11);
        }
    }

    public Object getOption(int i10, Object... objArr) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.getOption(i10, objArr);
        }
        SourceLog.w(TAG, "getOption ignore");
        return null;
    }

    public String getSDKInfos(int i10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.getSDKInfos(i10);
        }
        SourceLog.w(TAG, "getSDKInfos ignore");
        return null;
    }

    public VirtualDisplay getVirtualDisplay() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.getVirtualDisplay();
        }
        return null;
    }

    public void pause() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "pause ignore");
        } else {
            lelinkSourceSDKImpProxy.pause();
        }
    }

    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "removeFavoriteDevice ignore");
        } else {
            lelinkSourceSDKImpProxy.removeFavoriteDevice(list);
        }
    }

    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "removeHistoryDeviceList ignore");
        } else {
            lelinkSourceSDKImpProxy.removeHistoryDevice(list, i10);
        }
    }

    public void resume() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "resume ignore");
        } else {
            lelinkSourceSDKImpProxy.resume();
        }
    }

    public void seekTo(int i10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "seekTo ignore");
        } else {
            lelinkSourceSDKImpProxy.seekTo(i10);
        }
    }

    public void setBrowseResultListener(IBrowseListener iBrowseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setBrowseResultListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setBrowseResultListener(iBrowseListener);
        }
    }

    public void setCommonListener(ICommonListener iCommonListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setCommonListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setCommonListener(iCommonListener);
        }
    }

    public void setConnectListener(IConnectListener iConnectListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setConnectListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setConnectListener(iConnectListener);
        }
    }

    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setDaPlayListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setDaPlayListener(iDaPlayerListener);
        }
    }

    public void setDebugAVListener(IDebugAVListener iDebugAVListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setDebugAVListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setDebugAVListener(iDebugAVListener);
        }
    }

    public void setDebugMode(boolean z10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setDebugMode ignore");
        } else {
            lelinkSourceSDKImpProxy.setDebugMode(z10);
        }
    }

    public void setDebugTimestamp(boolean z10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setDebugTimestamp ignore");
        } else {
            lelinkSourceSDKImpProxy.setDebugTimestamp(z10);
        }
    }

    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setFavoriteDeviceAlias ignore");
        } else {
            lelinkSourceSDKImpProxy.setFavoriteDeviceAlias(lelinkServiceInfo, str);
        }
    }

    public void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setFavoriteDeviceListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setFavoriteDeviceListener(iFavoriteDeviceListener);
        }
    }

    public void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setHistoryDeviceListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setHistoryDeviceListener(iHistoryDeviceListener);
        }
    }

    public void setLogCallback(ILogCallback iLogCallback) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setLogCallback ignore");
        } else {
            lelinkSourceSDKImpProxy.setLogCallback(iLogCallback);
        }
    }

    public void setMirrorChangeListener(IMirrorChangeListener iMirrorChangeListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setMirrorChangeListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setMirrorChangeListener(iMirrorChangeListener);
        }
    }

    public void setNewPlayListener(INewPlayerListener iNewPlayerListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setNewPlayListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setNewPlayListener(iNewPlayerListener);
        }
    }

    public void setOption(int i10, Object... objArr) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setOption ignore");
        } else {
            lelinkSourceSDKImpProxy.setOption(i10, objArr);
        }
    }

    public void setPlayListener(ILelinkPlayerListener iLelinkPlayerListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setPlayListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setPlayListener(iLelinkPlayerListener);
        }
    }

    public void setSearchBannerDataCallback(ISearchBannerDataCallback iSearchBannerDataCallback) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setSearchBannerDataCallback ignore");
        } else {
            lelinkSourceSDKImpProxy.setSearchBannerDataCallback(iSearchBannerDataCallback);
        }
    }

    public void setSendPassCallback(ISendPassCallback iSendPassCallback) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setSendPassCallback ignore");
        } else {
            lelinkSourceSDKImpProxy.setSendPassCallback(iSendPassCallback);
        }
    }

    public void setSinkKeyEventListener(ISinkKeyEventListener iSinkKeyEventListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setSinkKeyEventListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setSinkKeyEventListener(iSinkKeyEventListener);
        }
    }

    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, ISinkTouchEventListener iSinkTouchEventListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setSinkTouchEventListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setSinkTouchEventListener(sinkTouchEventArea, f10, iSinkTouchEventListener);
        }
    }

    public void setVolume(int i10) {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "setVolume ignore");
            return;
        }
        SourceLog.i(TAG, "setVolume " + i10);
        this.mImplProxy.setVolume(i10);
    }

    public void startBrowse(boolean z10, boolean z11) {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "startBrowse ignore");
            return;
        }
        SourceLog.i(TAG, "startBrowse " + z10 + Operator.Operation.DIVISION + z11);
        this.mImplProxy.startBrowse(z10, z11);
    }

    public void startMirror(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startMirror ignore");
        } else {
            lelinkSourceSDKImpProxy.startMirror(lelinkPlayerInfo);
        }
    }

    public void startPlayMedia(String str, int i10, boolean z10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startPlayMedia ignore");
        } else {
            lelinkSourceSDKImpProxy.startPlayMedia(str, i10, z10);
        }
    }

    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startPlayMediaImmed ignore");
        } else {
            lelinkSourceSDKImpProxy.startPlayMediaImmed(lelinkServiceInfo, str, i10, z10);
        }
    }

    public void stopBrowse() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "stopBrowse ignore");
        } else {
            lelinkSourceSDKImpProxy.stopBrowse();
        }
    }

    public void stopPlay() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "stopPlay ignore");
        } else {
            lelinkSourceSDKImpProxy.stopPlay();
        }
    }

    public void subVolume() {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "subVolume ignore");
            return;
        }
        SourceLog.i(TAG, "subVolume");
        this.mImplProxy.subVolume();
    }

    public void unBindSdk() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "unBindSdk ignore");
            return;
        }
        lelinkSourceSDKImpProxy.unBindSdk();
        a aVar = this.mAppLifecycleListen;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "updateAudioData ignore");
        } else {
            lelinkSourceSDKImpProxy.updateAudioData(bArr, audioFrameBean);
        }
    }

    public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "updateH264Data ignore");
        } else {
            lelinkSourceSDKImpProxy.updateVideoData(bArr, videoFrameBean);
        }
    }

    public void bindSdk(Context context, String str, String str2, String str3, IBindSdkListener iBindSdkListener) {
        bindSdk(context, str, str2, (String) null, (String) null, str3, iBindSdkListener);
    }

    public void bindSdk(Context context, String str, String str2, String str3, String str4, String str5, IBindSdkListener iBindSdkListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("bindSdk ");
        String str6 = str;
        sb.append(str);
        SourceLog.i(TAG, sb.toString());
        this.mContext = context.getApplicationContext();
        a aVar = new a();
        this.mAppLifecycleListen = aVar;
        aVar.a(this.appLifecycleCallback);
        this.mHandler.removeCallbacksAndMessages((Object) null);
        final String str7 = str;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str5;
        final String str11 = str4;
        final IBindSdkListener iBindSdkListener2 = iBindSdkListener;
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                if (LelinkConfig.isMultiProgress()) {
                    SourceLog.i(LelinkSourceSDKImp.TAG, "bindSdk sdk process");
                    Session instance = Session.getInstance();
                    instance.appKey = str7;
                    instance.appSecret = str8;
                    instance.userID = str9;
                    String str = str10;
                    instance.oaID = str;
                    instance.appVersion = str11;
                    DeviceUtil.setOAID(str);
                    LelinkSourceSDKImp lelinkSourceSDKImp = LelinkSourceSDKImp.this;
                    LelinkServiceConnection unused = lelinkSourceSDKImp.mServiceConnection = new LelinkServiceConnection(lelinkSourceSDKImp.mContext, LelinkSourceSDKImp.this.mBindStatusListener);
                    LelinkSourceSDKImp.this.mServiceConnection.setBindListener(iBindSdkListener2);
                    LelinkSourceSDKImp.this.mServiceConnection.startBind();
                    return;
                }
                SourceLog.i(LelinkSourceSDKImp.TAG, "bindSdk app process callback");
                iBindSdkListener2.onBindCallback(true);
            }
        }, 500);
        if (!LelinkConfig.isMultiProgress()) {
            SourceLog.i(TAG, "bindSdk app process");
            currentProcessBind(str, str2, str3, str5, str4);
        }
    }

    public void startPlayMedia(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startPlayMedia ignore");
        } else {
            lelinkSourceSDKImpProxy.startPlayMedia(lelinkPlayerInfo);
        }
    }

    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, Uri uri, int i10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startPlayMediaImmed ignore");
        } else {
            lelinkSourceSDKImpProxy.startPlayMediaImmed(lelinkServiceInfo, uri, i10);
        }
    }
}
