package com.efs.sdk.base.core.config.remote;

import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.core.util.secure.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class RemoteConfig {
    public static final double FULL_RATE = 100.0d;

    /* renamed from: a  reason: collision with root package name */
    String f5216a;

    /* renamed from: b  reason: collision with root package name */
    String f5217b = "https://";

    /* renamed from: c  reason: collision with root package name */
    String f5218c = "errnewlog.umeng.com";

    /* renamed from: d  reason: collision with root package name */
    long f5219d = 480;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f5220e = null;
    public int mConfigVersion = -1;
    public Map<String, String> mSDKConfigMap = new HashMap();
    public Map<String, Object> mStrategyMap = new HashMap();
    public Map<String, Double> mUploadSampleRateMap = new HashMap();

    private RemoteConfig() {
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f5216a = str;
                String str2 = new String(a.a(EncodeUtil.base64Decode(str.getBytes()), ControllerCenter.getGlobalEnvStruct().getSecret().getBytes()));
                String[] split = str2.split("\\|");
                if (split.length > 1) {
                    String str3 = split[1];
                    JSONArray jSONArray = new JSONArray(str2.substring(split[0].length() + split[1].length() + 2));
                    this.mStrategyMap.put("rate", Integer.valueOf(Integer.parseInt(str3)));
                    this.mStrategyMap.put("stra", jSONArray);
                }
            } catch (JSONException e10) {
                throw new RuntimeException(e10);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static RemoteConfig a() {
        RemoteConfig remoteConfig = new RemoteConfig();
        if (ControllerCenter.getGlobalEnvStruct().isIntl()) {
            remoteConfig.f5218c = "errnewlogos.umeng.com";
        } else {
            remoteConfig.f5218c = "errnewlog.umeng.com";
        }
        return remoteConfig;
    }

    public final void a(Map<String, String> map) {
        double d10;
        if (map.containsKey("gate_way")) {
            String str = map.get("gate_way");
            if (!TextUtils.isEmpty(str)) {
                this.f5218c = str;
            }
        }
        if (map.containsKey("gate_way_https")) {
            String str2 = map.get("gate_way_https");
            if (!TextUtils.isEmpty(str2)) {
                this.f5217b = Boolean.parseBoolean(str2) ? "https://" : "http://";
            }
        }
        try {
            if (map.containsKey("updateInteval")) {
                String str3 = map.get("updateInteval");
                if (!TextUtils.isEmpty(str3)) {
                    this.f5219d = Long.parseLong(str3);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str4 = (String) next.getKey();
            if (str4.startsWith("data_sampling_rate_") || str4.startsWith("file_sampling_rate_")) {
                String replace = str4.replace("data_sampling_rate_", "").replace("file_sampling_rate_", "");
                try {
                    d10 = Double.parseDouble((String) next.getValue());
                } catch (Throwable unused) {
                    d10 = 100.0d;
                }
                hashMap.put(replace, Double.valueOf(d10));
            }
        }
        this.mUploadSampleRateMap = hashMap;
        this.mSDKConfigMap = map;
    }
}
