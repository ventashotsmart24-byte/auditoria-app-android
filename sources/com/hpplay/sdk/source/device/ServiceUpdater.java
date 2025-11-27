package com.hpplay.sdk.source.device;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.common.utils.HttpEncrypt;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.browser.ble.BleProxy;
import com.hpplay.sdk.source.protocol.browser.sonic.SonicProxy;
import com.hpplay.sdk.source.utils.LeboUtil;
import com.hpplay.sdk.source.utils.Memory;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import org.json.JSONObject;

public class ServiceUpdater {
    private static final int DELAY_UPLOAD_SERVICE = 5000;
    private static final String TAG = "ServiceUpdater";
    private static final int WHAT_UPLOAD_SERVICE = 1;
    private static ServiceUpdater sInstance;
    /* access modifiers changed from: private */
    public AsyncTask mAsyncTask = null;
    /* access modifiers changed from: private */
    public Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ServiceUpdater serviceUpdater = ServiceUpdater.this;
            serviceUpdater.uploadServiceInfo(serviceUpdater.mContext);
            return false;
        }
    });
    private Session mSession = Session.getInstance();

    public static synchronized ServiceUpdater getInstance() {
        ServiceUpdater serviceUpdater;
        synchronized (ServiceUpdater.class) {
            synchronized (ServiceUpdater.class) {
                if (sInstance == null) {
                    sInstance = new ServiceUpdater();
                }
            }
            serviceUpdater = sInstance;
        }
        return serviceUpdater;
    }

    private String getTotalMemInfo(Context context) {
        Memory.update(context);
        if (Memory.RAM == 0) {
            return "";
        }
        return ((((float) Memory.RAM) / 1024.0f) / 1024.0f) + " MB";
    }

    /* access modifiers changed from: private */
    public void uploadServiceInfo(Context context) {
        String str;
        if (context != null) {
            String str2 = Preference.getInstance().get(Preference.KEY_DEVICE_ID);
            int i10 = this.mSession.serverPort;
            if (TextUtils.isEmpty(str2) || i10 <= 0) {
                SourceLog.i(TAG, "upLoadServiceInfo invalid deviceCode:" + str2 + ", port:" + i10);
                return;
            }
            String iPAddress = DeviceUtil.getIPAddress(context);
            HashMap hashMap = new HashMap();
            hashMap.put("id", str2);
            hashMap.put("ipAddress", iPAddress);
            hashMap.put("networkModel", "" + NetworkUtil.getNetType(context));
            String str3 = "true";
            if (BleProxy.isBrowserSuccess()) {
                str = str3;
            } else {
                str = "false";
            }
            hashMap.put("openBluetooth", str);
            if (!SonicProxy.isBrowserSuccess()) {
                str3 = "false";
            }
            hashMap.put("openVoiceprint", str3);
            hashMap.put("route" + FieldUtil.getString(FieldUtil.M), NetworkUtil.getWifiBSSID(context));
            hashMap.put("routeName", NetworkUtil.getNetWorkName(context));
            hashMap.put("serviceBody", "");
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sDEVICE_SERVICE_UPLOAD_URL, HapplayUtils.getJsonParams(hashMap));
            asyncHttpParameter.in.requestMethod = 1;
            this.mAsyncTask = AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    AsyncTask unused = ServiceUpdater.this.mAsyncTask = null;
                    AsyncHttpParameter.Out out = asyncHttpParameter.out;
                    if (out.result != null) {
                        int i10 = out.resultType;
                    }
                }
            });
        }
    }

    public void updateServiceInfo(Context context) {
    }

    public void uploadDeviceInfo(Context context) {
        String str;
        if (context != null && TextUtils.isEmpty(Preference.getInstance().get(Preference.KEY_DEVICE_ID))) {
            HashMap hashMap = new HashMap();
            hashMap.put(FieldUtil.getString(FieldUtil.aId), LeboUtil.getAID(context));
            hashMap.put("appId", this.mSession.appKey);
            hashMap.put(Constants.KEY_BRAND, DeviceProperties.getBrand());
            hashMap.put("deviceModel", DeviceProperties.getModel());
            hashMap.put(ParamsMap.DeviceParams.KEY_HID, this.mSession.getHID());
            String string = FieldUtil.getString(FieldUtil.f10533m);
            Session.getInstance();
            hashMap.put(string, Session.DEFAULT_M);
            hashMap.put(BrowserInfo.KEY_MANUFACTURER, DeviceProperties.getManufacturer());
            hashMap.put(Constants.KEY_SDK_VERSION, this.mSession.appVersion);
            hashMap.put(ParamsMap.DeviceParams.KEY_UID, this.mSession.getUID());
            hashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("decodeResolution", "");
            hashMap.put("displayResolution", ScreenUtil.getScreenWidth(context) + Operator.Operation.MULTIPLY + ScreenUtil.getScreenHeight(context));
            hashMap.put("ram", getTotalMemInfo(context));
            if (LelinkConfig.isDeviceBrowserBlueToothEnable(context)) {
                str = "true";
            } else {
                str = "false";
            }
            hashMap.put("supportBluetooth", str);
            hashMap.put("supportH265", "true");
            String jsonParams = HapplayUtils.getJsonParams(hashMap);
            final HttpEncrypt httpEncrypt = new HttpEncrypt();
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sREAL_TIME_DEVICE_INFO_UPLOAD_URL, httpEncrypt.encode(jsonParams));
            AsyncHttpParameter.In in = asyncHttpParameter.in;
            in.requestMethod = 1;
            in.requestHeaders = httpEncrypt.buildHeader();
            this.mAsyncTask = AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    AsyncTask unused = ServiceUpdater.this.mAsyncTask = null;
                    int i10 = asyncHttpParameter.out.resultType;
                    if (i10 != 2 && i10 == 0) {
                        SourceLog.debug(ServiceUpdater.TAG, "upLoadDeviceInfo result" + asyncHttpParameter.out.result);
                        try {
                            String optString = new JSONObject(httpEncrypt.decode(asyncHttpParameter.out)).optJSONObject("data").optString("id");
                            if (!TextUtils.isEmpty(optString) && !TextUtils.equals(Preference.getInstance().get(Preference.KEY_DEVICE_ID), optString)) {
                                Preference.getInstance().put(Preference.KEY_DEVICE_ID, optString);
                            }
                        } catch (Exception e10) {
                            SourceLog.w(ServiceUpdater.TAG, (Throwable) e10);
                        }
                    }
                }
            });
        }
    }
}
