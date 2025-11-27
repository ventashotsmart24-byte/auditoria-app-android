package com.hpplay.sdk.source.device;

import android.text.TextUtils;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.browser.BrowserHistory;
import com.hpplay.sdk.source.utils.CastUtil;
import java.util.concurrent.ConcurrentHashMap;

public class DeviceCodeResolver {
    private static String TAG = "DeviceCodeResolver";
    private static DeviceCodeResolver sInstance;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, BrowserInfo> mBrowserMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> mDevicePins = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public long mParseTimeStamp = -1;
    /* access modifiers changed from: private */
    public int mReportCreateType = -1;

    public static synchronized DeviceCodeResolver getInstance() {
        DeviceCodeResolver deviceCodeResolver;
        synchronized (DeviceCodeResolver.class) {
            synchronized (DeviceCodeResolver.class) {
                if (sInstance == null) {
                    sInstance = new DeviceCodeResolver();
                }
            }
            deviceCodeResolver = sInstance;
        }
        return deviceCodeResolver;
    }

    public void clear() {
        this.mDevicePins.clear();
        this.mBrowserMap.clear();
        this.mReportCreateType = -1;
    }

    public void resolveDeviceCode(String str, int i10, IServiceInfoParseListener iServiceInfoParseListener) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "addDevicePinServiceInfo: deviceCode is empty");
        } else if (this.mDevicePins.containsKey(str)) {
            BrowserInfo browserInfo = this.mBrowserMap.get(str);
            if (browserInfo == null) {
                Integer num = this.mDevicePins.get(str);
                if (num != null && num.intValue() == i10) {
                    this.mReportCreateType = i10;
                }
            } else if (i10 != browserInfo.getCreateType()) {
                BrowserHistory.getInstance().updateBrowserInfo(browserInfo, i10, this.mParseTimeStamp);
            }
        } else {
            String str2 = TAG;
            SourceLog.i(str2, "addDevicePinServiceInfo deviceCode:" + str);
            this.mDevicePins.put(str, Integer.valueOf(i10));
            DevicePinParser devicePinParser = new DevicePinParser();
            final long currentTimeMillis = System.currentTimeMillis();
            final IServiceInfoParseListener iServiceInfoParseListener2 = iServiceInfoParseListener;
            final String str3 = str;
            devicePinParser.setParseResultListener(new IServiceInfoParseListener() {
                public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
                    BrowserInfo browserInfo;
                    IServiceInfoParseListener iServiceInfoParseListener = iServiceInfoParseListener2;
                    if (iServiceInfoParseListener != null) {
                        iServiceInfoParseListener.onParseResult(i10, lelinkServiceInfo);
                    }
                    if (lelinkServiceInfo != null && (browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 1)) != null) {
                        DeviceCodeResolver.this.mBrowserMap.put(str3, browserInfo);
                        long unused = DeviceCodeResolver.this.mParseTimeStamp = System.currentTimeMillis() - currentTimeMillis;
                        BrowserHistory.getInstance().updateBrowserInfo(browserInfo, browserInfo.getCreateType(), DeviceCodeResolver.this.mParseTimeStamp);
                        if (DeviceCodeResolver.this.mReportCreateType != -1) {
                            BrowserHistory.getInstance().updateBrowserInfo(browserInfo, DeviceCodeResolver.this.mReportCreateType, DeviceCodeResolver.this.mParseTimeStamp);
                        }
                    }
                }
            });
            devicePinParser.parse(str, i10);
        }
    }
}
