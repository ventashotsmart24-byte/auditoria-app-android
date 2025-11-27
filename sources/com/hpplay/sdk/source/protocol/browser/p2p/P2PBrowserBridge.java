package com.hpplay.sdk.source.protocol.browser.p2p;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Handler;
import android.os.Looper;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.common.wifidirect.IWDirectController;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.permission.ContextCompat;

public class P2PBrowserBridge {
    private static final String TAG = "P2PBrowserBridge";
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private IWDirectController mWDIRECTController;

    public P2PBrowserBridge(Context context) {
        this.mContext = context;
        try {
            IWDirectController iWDirectController = (IWDirectController) ModuleLinker.getInstance().loadModule(ModuleIds.CLAZZ_ID1073_WDIRECTCONTROLLER);
            this.mWDIRECTController = iWDirectController;
            if (iWDirectController.isSupportWifiP2p()) {
                this.mWDIRECTController.setWDirectStateListener(new ProtocolListener() {
                    public void onResult(final int i10, final String... strArr) {
                        P2PBrowserBridge.this.mHandler.post(new Runnable() {
                            public void run() {
                                P2PBrowserBridge.this.WDIRECTCmdParse(i10, strArr);
                            }
                        });
                    }
                });
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    /* access modifiers changed from: private */
    public void WDIRECTCmdParse(int i10, String... strArr) {
        String str;
        switch (i10) {
            case 1:
                String str2 = "unkown";
                if (strArr.length > 0) {
                    str = strArr[0];
                } else {
                    str = str2;
                }
                if (strArr.length > 1) {
                    str2 = strArr[1];
                }
                SourceLog.i(TAG, " 连接成功 当前网络频率" + str + "  " + str2);
                return;
            case 2:
                SourceLog.i(TAG, "连接断开");
                return;
            case 3:
                SourceLog.i(TAG, "服务端启动成功, 请重新初始化接收端SDK");
                return;
            case 4:
                SourceLog.i(TAG, "服务端启动失败");
                return;
            case 5:
                SourceLog.i(TAG, "启动搜索成功");
                return;
            case 6:
                SourceLog.i(TAG, "启动搜索失败");
                return;
            case 7:
                SourceLog.i(TAG, "启动连接成功");
                return;
            case 8:
                SourceLog.i(TAG, "启动连接失败");
                return;
            case 9:
                SourceLog.i(TAG, "连接失败");
                return;
            case 10:
                SourceLog.i(TAG, "当前设备状态为: " + getDeviceStatus(Integer.valueOf(strArr[0]).intValue()));
                return;
            default:
                return;
        }
    }

    public static String getDeviceStatus(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "未知" : "不可用的" : "可用的" : "失败的" : "邀请中" : "已连接";
    }

    public boolean checkP2pNeedPermission() {
        if (ContextCompat.checkSelfPermission(this.mContext, "android.permission.CHANGE_NETWORK_STATE") == 0 && ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_NETWORK_STATE") == 0 && ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_WIFI_STATE") == 0 && ContextCompat.checkSelfPermission(this.mContext, "android.permission.CHANGE_WIFI_STATE") == 0 && ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.checkSelfPermission(this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public void connect(WifiP2pDevice wifiP2pDevice) {
        this.mWDIRECTController.connect(wifiP2pDevice);
    }

    public void startBrowser() {
    }

    public void stopBrowser() {
        this.mWDIRECTController.disConnect();
    }
}
