package com.hpplay.sdk.source.process;

import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.List;

public class PushFailedRetryManager {
    private static final String TAG = "PushFailedRetryManager";
    public static volatile PushFailedRetryManager mPlayFailedRetryManager;
    IBrowseListener iBrowseListener = new IBrowseListener() {
        public void onBrowse(int i10, List<LelinkServiceInfo> list) {
            try {
                if (list.size() > 0) {
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (PushFailedRetryManager.this.mPlayRetryListener != null) {
                            BrowserInfo browserInfo = list.get(i11).getBrowserInfos().get(Integer.valueOf(PushFailedRetryManager.this.type));
                            if (browserInfo != null && (browserInfo.getName().equals(PushFailedRetryManager.this.mBrowseInfo.getName()) || browserInfo.getIp().equals(PushFailedRetryManager.this.mBrowseInfo.getIp()))) {
                                SourceLog.i(PushFailedRetryManager.TAG, "replay get device callback to player ");
                                PushFailedRetryManager.this.mPlayRetryListener.onBrowseInfoCallback(list.get(i11), browserInfo);
                                PlayRetryListener unused = PushFailedRetryManager.this.mPlayRetryListener = null;
                            }
                        }
                        if (PushFailedRetryManager.this.mConnectRetryListener != null) {
                            LelinkServiceInfo lelinkServiceInfo = list.get(i11);
                            SourceLog.i(PushFailedRetryManager.TAG, "get retry devs  " + lelinkServiceInfo.getName());
                            if (lelinkServiceInfo.getName().equals(PushFailedRetryManager.this.mServiceInfo.getName()) || lelinkServiceInfo.getIp().equals(PushFailedRetryManager.this.mServiceInfo.getIp())) {
                                SourceLog.i(PushFailedRetryManager.TAG, "reconnect get device callback to controller");
                                PushFailedRetryManager.this.mConnectRetryListener.onLelinkServiceInfoCallback(PushFailedRetryManager.this.mServiceInfo);
                                ConnectRetryListener unused2 = PushFailedRetryManager.this.mConnectRetryListener = null;
                            }
                        }
                    }
                }
            } catch (Exception unused3) {
            }
        }
    };
    /* access modifiers changed from: private */
    public BrowserInfo mBrowseInfo;
    /* access modifiers changed from: private */
    public ConnectRetryListener mConnectRetryListener;
    /* access modifiers changed from: private */
    public PlayRetryListener mPlayRetryListener;
    /* access modifiers changed from: private */
    public LelinkServiceInfo mServiceInfo;
    /* access modifiers changed from: private */
    public int type = 0;

    public interface ConnectRetryListener {
        void onLelinkServiceInfoCallback(LelinkServiceInfo lelinkServiceInfo);
    }

    public interface PlayRetryListener {
        void onBrowseInfoCallback(LelinkServiceInfo lelinkServiceInfo, BrowserInfo browserInfo);
    }

    public static PushFailedRetryManager getInstance() {
        if (mPlayFailedRetryManager == null) {
            synchronized (PushFailedRetryManager.class) {
                mPlayFailedRetryManager = new PushFailedRetryManager();
            }
        }
        return mPlayFailedRetryManager;
    }

    public void connectFailedRetry(LelinkServiceInfo lelinkServiceInfo, ConnectRetryListener connectRetryListener) {
        SourceLog.i(TAG, "connectFailedRetry ... ");
        this.mServiceInfo = lelinkServiceInfo;
        this.mConnectRetryListener = connectRetryListener;
        LelinkSdkManager.getInstance().setRetryBrowseListener(this.iBrowseListener);
        LelinkSdkManager.getInstance().stopBrowse();
        LelinkSdkManager.getInstance().browse(LelinkSdkManager.getInstance().getBrowserConfig());
    }

    public void stopRetry() {
        this.mPlayRetryListener = null;
        this.mConnectRetryListener = null;
        LelinkSdkManager.getInstance().stopBrowse();
    }
}
