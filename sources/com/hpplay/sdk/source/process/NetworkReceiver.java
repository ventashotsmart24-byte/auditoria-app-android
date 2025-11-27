package com.hpplay.sdk.source.process;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.common.utils.WifiInfoCache;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.browser.BrowserBridge;
import com.umeng.message.api.UPushThirdTokenCallback;

public class NetworkReceiver extends BroadcastReceiver {
    private static final String TAG = "NetworkReceiver";
    private boolean firstNetworkChange = true;
    private boolean isConnected;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    private void reconnectIM() {
        PublicCastClient.getInstance().disconnectServer();
        PublicCastClient.getInstance().reconnect();
    }

    public void onReceive(Context context, Intent intent) {
        if (AuthSDK.getInstance().getAuthCode() != 402 && AuthSDK.getInstance().getAuthCode() != -101) {
            String action = intent.getAction();
            SourceLog.i(TAG, "onReceive: action := " + action);
            try {
                if ("android.net.wifi.STATE_CHANGE".equalsIgnoreCase(action)) {
                    WifiInfoCache.clearCache();
                    NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    intent.getStringExtra("bssid");
                    if (networkInfo != null) {
                        boolean isConnected2 = networkInfo.isConnected();
                        NetworkInfo.State state = networkInfo.getState();
                        SourceLog.i(TAG, "wifi connect  " + isConnected2 + " " + state);
                        if (state == NetworkInfo.State.CONNECTED) {
                            if (isConnected2) {
                                this.isConnected = true;
                                if (!Session.getInstance().isAuthSuccess && !Session.getInstance().isFirstBoot) {
                                    AuthSDK.getInstance().authSDK();
                                }
                                if (this.firstNetworkChange) {
                                    SourceLog.i(TAG, "firstNetworkChange in NetworkAndTimeChangeReceiver");
                                    this.firstNetworkChange = false;
                                    return;
                                }
                                LelinkSdkManager.getInstance().clearBrowserList();
                                this.mMainHandler.removeCallbacksAndMessages((Object) null);
                                this.mMainHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        if (!new StringBuilder(DeviceProperties.getManufacturer().toLowerCase()).reverse().toString().equals("iewauh") || !DeviceProperties.getManufacturer().toLowerCase().equals(UPushThirdTokenCallback.TYPE_HONOR)) {
                                            LelinkSdkManager.getInstance().startBrowseThread();
                                        }
                                        BusinessEntity.getInstance().onWifiConnected();
                                    }
                                }, 500);
                            }
                        } else if (state == NetworkInfo.State.DISCONNECTED) {
                            SourceLog.i(TAG, "f+++++++++++++++++DISCONNECTED+++++++++++++++++r");
                            if (this.isConnected && !isConnected2) {
                                this.isConnected = false;
                                if (this.firstNetworkChange) {
                                    SourceLog.i(TAG, "firstNetworkChange in NetworkAndTimeChangeReceiver");
                                    this.firstNetworkChange = false;
                                    return;
                                }
                                this.mMainHandler.removeCallbacksAndMessages((Object) null);
                                LelinkSdkManager.getInstance().clearBrowserList();
                                BrowserBridge.getInstance().onNetDisconnect(4);
                            }
                            ConnectManager.getInstance().onNetDisconnect();
                        }
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(action)) {
                    NetworkUtil.NetworkType networkType = NetworkUtil.getNetworkType(context);
                    SourceLog.i(TAG, "networkType:" + networkType);
                    NetworkInfo networkInfo2 = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo2 != null) {
                        if (networkInfo2.getType() == 0) {
                            if (NetworkInfo.State.CONNECTED == networkInfo2.getState() && networkInfo2.isAvailable()) {
                                if (!Session.getInstance().isAuthSuccess) {
                                    AuthSDK.getInstance().authSDK();
                                }
                                if (this.firstNetworkChange) {
                                    SourceLog.i(TAG, "firstNetworkChange in NetworkAndTimeChangeReceiver");
                                    this.firstNetworkChange = false;
                                    return;
                                }
                                SourceLog.i(TAG, "mobile is open");
                                reconnectIM();
                                LelinkSdkManager.getInstance().clearBrowserList();
                                return;
                            } else if (NetworkUtil.NetworkType.NETWORK_WIFI.equals(networkType)) {
                                return;
                            } else {
                                if (this.firstNetworkChange) {
                                    SourceLog.i(TAG, "firstNetworkChange in NetworkAndTimeChangeReceiver");
                                    this.firstNetworkChange = false;
                                    return;
                                }
                                SourceLog.i(TAG, "mobile is close");
                                LelinkSdkManager.getInstance().clearBrowserList();
                                return;
                            }
                        }
                    }
                    if (networkInfo2 != null && NetworkInfo.State.CONNECTED == networkInfo2.getState() && networkInfo2.isAvailable() && !Session.getInstance().isAuthSuccess) {
                        AuthSDK.getInstance().authSDK();
                    }
                } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                    reconnectIM();
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
    }
}
