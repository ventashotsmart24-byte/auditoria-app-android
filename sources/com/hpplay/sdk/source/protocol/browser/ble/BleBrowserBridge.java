package com.hpplay.sdk.source.protocol.browser.ble;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.ble.AdvertiseManager;
import com.hpplay.ble.DiscoveryAdvertiseManager;
import com.hpplay.ble.DiscoveryResult;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.device.Device;
import com.hpplay.sdk.source.device.DevicePinParser;
import com.hpplay.sdk.source.device.ServiceUpdater;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.connect.AbsIMMsgReceiveListener;

public class BleBrowserBridge {
    private static final String TAG = "BleBrowserBridge";
    private static BleBrowserBridge sInstance;
    private boolean isBrowserSuccess = false;
    /* access modifiers changed from: private */
    public boolean isFoundDevice = false;
    /* access modifiers changed from: private */
    public boolean isStop = true;
    private DiscoveryAdvertiseManager.BleDiscoveryCallback mCallback = new DiscoveryAdvertiseManager.BleDiscoveryCallback() {
        public void onDiscoveryResult(DiscoveryResult discoveryResult) {
            if (!BleBrowserBridge.this.isStop && discoveryResult != null) {
                String pinCode = discoveryResult.getPinCode();
                if (TextUtils.isEmpty(pinCode)) {
                    SourceLog.w(BleBrowserBridge.TAG, "discoveryResult: ble is empty");
                } else if (!pinCode.equals(Preference.getInstance().get(Preference.KEY_DEVICE_ID))) {
                    boolean unused = BleBrowserBridge.this.isFoundDevice = true;
                    Device.addDeviceCodeServiceInfo(pinCode, 10, BleBrowserBridge.this.mServiceInfoParseListener);
                }
            }
        }
    };
    private AbsIMMsgReceiveListener mIMMsgReceiveListener = new AbsIMMsgReceiveListener() {
        public void onMsgReceive(int i10, String str) {
            super.onMsgReceive(i10, str);
            if (i10 == 1) {
                BleBrowserBridge.this.mServerParser.setParseResultListener(BleBrowserBridge.this.mServiceInfoParseListener);
                BleBrowserBridge.this.mServerParser.parseServiceInfo(str, 10);
            }
        }
    };
    /* access modifiers changed from: private */
    public DevicePinParser mServerParser;
    /* access modifiers changed from: private */
    public IServiceInfoParseListener mServiceInfoParseListener;

    private BleBrowserBridge() {
    }

    public static synchronized BleBrowserBridge getInstance() {
        BleBrowserBridge bleBrowserBridge;
        synchronized (BleBrowserBridge.class) {
            synchronized (BleBrowserBridge.class) {
                if (sInstance == null) {
                    sInstance = new BleBrowserBridge();
                }
            }
            bleBrowserBridge = sInstance;
        }
        return bleBrowserBridge;
    }

    public boolean isBrowserSuccess() {
        return this.isBrowserSuccess;
    }

    public void release() {
    }

    public void setServiceInfoParseListener(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mServiceInfoParseListener = iServiceInfoParseListener;
    }

    public boolean startBrowse(Context context) {
        this.isFoundDevice = false;
        if (1 != LelinkConfig.isBrowserBlueToothEnable(context)) {
            SourceLog.w(TAG, "startBrowse has no permission to use ble");
            return false;
        }
        this.isBrowserSuccess = DiscoveryAdvertiseManager.getInstance().startScan(context, this.mCallback);
        SourceLog.w(TAG, "startBrowse " + this.isBrowserSuccess);
        if (this.isBrowserSuccess) {
            this.isStop = false;
            SourceDataReport.getInstance().reportBleStartBrowseTimes();
        } else {
            this.isStop = true;
        }
        ServiceUpdater.getInstance().updateServiceInfo(context);
        return this.isBrowserSuccess;
    }

    public boolean startPublish(Context context, String str) {
        if (1 != LelinkConfig.isPublishBlueToothEnable(context)) {
            SourceLog.w(TAG, "startPublish has no permission to use ble");
            return false;
        }
        SourceLog.i(TAG, "startPublish deviceCode:" + str);
        PublicCastClient.getInstance().setIMMsgReceiveListener(this.mIMMsgReceiveListener);
        return AdvertiseManager.getInstance().startAdvertise(context, str);
    }

    public void stopBrowse(Context context) {
        if (!this.isStop) {
            SourceLog.i(TAG, "stopBrowse");
            this.isStop = true;
            this.isBrowserSuccess = false;
            DiscoveryAdvertiseManager.getInstance().stopScan();
            ServiceUpdater.getInstance().updateServiceInfo(context);
            if (this.isFoundDevice) {
                SourceDataReport.getInstance().reportFoundDeviceOfBle();
            }
            this.isFoundDevice = false;
        }
    }

    public void stopPublish(Context context) {
        SourceLog.i(TAG, "stopPublish");
        AdvertiseManager.getInstance().stopAdvertise();
        ServiceUpdater.getInstance().updateServiceInfo(context);
    }
}
