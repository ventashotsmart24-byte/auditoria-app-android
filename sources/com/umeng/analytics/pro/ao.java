package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.component.protocol.PlistBuilder;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.umeng.ccg.a;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ao {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f13757a;

    public static JSONObject a(Context context, JSONArray jSONArray, String str) {
        JSONObject jSONObject = f13757a;
        if (jSONObject != null && jSONObject.length() > 0) {
            return f13757a;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("os", "Android");
            jSONObject2.put("dm", Build.MODEL);
            jSONObject2.put("av", DeviceConfig.getAppVersionName(context));
            jSONObject2.put(bt.f13913g, UMUtils.getUMId(context));
            jSONObject2.put("ov", Build.VERSION.RELEASE);
            jSONObject2.put("chn", UMUtils.getChannel(context));
            jSONObject2.put(bt.al, UMUtils.getZid(context));
            jSONObject2.put("sv", "9.7.9");
            jSONObject2.put("ak", UMUtils.getAppkey(context));
            String idfa = DeviceConfig.getIdfa(context);
            if (!TextUtils.isEmpty(idfa)) {
                jSONObject2.put("tk_idfa", idfa);
            }
            jSONObject2.put("db", Build.BRAND);
            jSONObject2.put("tk_aid", DeviceConfig.getAndroidId(context));
            String oaid = DeviceConfig.getOaid(context);
            if (!TextUtils.isEmpty(oaid)) {
                jSONObject2.put("tk_oaid", oaid);
            }
            String imeiNew = DeviceConfig.getImeiNew(context);
            if (!TextUtils.isEmpty(imeiNew)) {
                jSONObject2.put("tk_imei", imeiNew);
            }
            jSONObject2.put("boa", Build.BOARD);
            jSONObject2.put("mant", Build.TIME);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            jSONObject2.put(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_CT, localeInfo[0]);
            jSONObject2.put("lang", localeInfo[1]);
            jSONObject2.put("tz", DeviceConfig.getTimeZone(context));
            jSONObject2.put("pkg", DeviceConfig.getPackageName(context));
            jSONObject2.put("disn", DeviceConfig.getAppName(context));
            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "wifi");
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "2G/3G");
            } else {
                jSONObject2.put("ac", "unknown");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject2.put(PlistBuilder.KEY_AUDIO_SOCKET_TYPE, networkAccessMode[1]);
            }
            jSONObject2.put("nt", DeviceConfig.getNetworkType(context));
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject2.put(bt.f13903a, deviceToken);
            }
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            if (resolutionArray != null) {
                jSONObject2.put("rl", resolutionArray[1] + Operator.Operation.MULTIPLY + resolutionArray[0]);
            }
            jSONObject2.put("car", DeviceConfig.getNetworkOperatorName(context));
            jSONObject2.put(bt.f13906b, "9.7.9");
            if (DeviceConfig.isHarmony(context)) {
                jSONObject2.put("oos", "harmony");
            } else {
                jSONObject2.put("oos", "Android");
            }
            jSONObject2.put(a.f14525r, str);
            jSONObject2.put(a.f14528u, jSONArray);
            f13757a = jSONObject2;
        } catch (Throwable unused) {
        }
        return f13757a;
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("ekv", jSONArray);
                return jSONObject3;
            } catch (Throwable unused) {
                jSONObject2 = jSONObject3;
            }
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("header", jSONObject);
            jSONObject3.put("analytics", jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject3;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:9|10|11|12|13|(2:15|16)|17|18|(1:23)(1:22)|24) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x013c */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0152 A[Catch:{ all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x015d A[Catch:{ all -> 0x016b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(android.content.Context r9, java.lang.String r10) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "[getCloudConfigParam] error "
            java.lang.String r2 = "MobclickRT"
            r3 = 0
            com.umeng.analytics.pro.an r4 = new com.umeng.analytics.pro.an     // Catch:{ all -> 0x018a }
            r4.<init>()     // Catch:{ all -> 0x018a }
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.getUMId(r9)     // Catch:{ all -> 0x018a }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x0017
            return r3
        L_0x0017:
            r4.a((java.lang.String) r5)     // Catch:{ all -> 0x018a }
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r9)     // Catch:{ all -> 0x018a }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x0025
            return r3
        L_0x0025:
            r4.b((java.lang.String) r5)     // Catch:{ all -> 0x018a }
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r9)     // Catch:{ all -> 0x018a }
            r4.c(r5)     // Catch:{ all -> 0x018a }
            java.lang.String r5 = "9.7.9"
            r4.d(r5)     // Catch:{ all -> 0x018a }
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.getChannel(r9)     // Catch:{ all -> 0x018a }
            r4.e(r5)     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r5.<init>()     // Catch:{ all -> 0x018a }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x018a }
            r5.append(r6)     // Catch:{ all -> 0x018a }
            r5.append(r0)     // Catch:{ all -> 0x018a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x018a }
            r4.f(r5)     // Catch:{ all -> 0x018a }
            java.lang.String r5 = android.os.Build.BRAND     // Catch:{ all -> 0x018a }
            r4.g(r5)     // Catch:{ all -> 0x018a }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x018a }
            r4.h(r5)     // Catch:{ all -> 0x018a }
            java.lang.String[] r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getLocaleInfo(r9)     // Catch:{ all -> 0x018a }
            r6 = 1
            r7 = r5[r6]     // Catch:{ all -> 0x018a }
            r4.i(r7)     // Catch:{ all -> 0x018a }
            r7 = 0
            r5 = r5[r7]     // Catch:{ all -> 0x018a }
            r4.j(r5)     // Catch:{ all -> 0x018a }
            int[] r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getResolutionArray(r9)     // Catch:{ all -> 0x018a }
            r8 = r5[r6]     // Catch:{ all -> 0x018a }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018a }
            r4.b((java.lang.Integer) r8)     // Catch:{ all -> 0x018a }
            r5 = r5[r7]     // Catch:{ all -> 0x018a }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x018a }
            r4.a((java.lang.Integer) r5)     // Catch:{ all -> 0x018a }
            java.lang.String r5 = "install_datetime"
            java.lang.String r0 = com.umeng.analytics.pro.as.a(r9, r5, r0)     // Catch:{ all -> 0x018a }
            r4.k(r0)     // Catch:{ all -> 0x018a }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0172 }
            r0.<init>()     // Catch:{ JSONException -> 0x0172 }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13731a     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.a()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13733c     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.c()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13732b     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.b()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13734d     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.d()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13735e     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.e()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13736f     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.f()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13737g     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.g()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13738h     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.h()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13741k     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.Integer r5 = r4.k()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13740j     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.Integer r5 = r4.j()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13742l     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.l()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13739i     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r5 = r4.i()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = com.umeng.analytics.pro.an.f13743m     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r4 = r4.m()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r3 = "zid"
            java.lang.String r9 = com.umeng.commonsdk.utils.UMUtils.getZid(r9)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r0.put(r3, r9)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r9 = "platform"
            java.lang.String r3 = "android"
            r0.put(r9, r3)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.util.Map r9 = com.umeng.analytics.pro.as.a()     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r3.<init>(r9)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r9 = "optional"
            r0.put(r9, r3)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            java.lang.String r9 = "@"
            java.lang.String[] r9 = r10.split(r9)     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            int r10 = r9.length     // Catch:{ JSONException -> 0x016f, all -> 0x016c }
            r1 = 4
            if (r10 != r1) goto L_0x013c
            r10 = r9[r7]     // Catch:{ all -> 0x013c }
            long r1 = java.lang.Long.parseLong(r10)     // Catch:{ all -> 0x013c }
            r9 = r9[r6]     // Catch:{ all -> 0x013c }
            java.lang.String r10 = "s1"
            r0.put(r10, r1)     // Catch:{ all -> 0x013c }
            java.lang.String r10 = "s2"
            r0.put(r10, r9)     // Catch:{ all -> 0x013c }
        L_0x013c:
            java.lang.String r9 = android.os.Build.BRAND     // Catch:{ all -> 0x016b }
            java.lang.String r10 = com.umeng.analytics.pro.at.a(r9)     // Catch:{ all -> 0x016b }
            java.lang.String r9 = com.umeng.analytics.pro.at.b(r9)     // Catch:{ all -> 0x016b }
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x016b }
            if (r1 != 0) goto L_0x015d
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x016b }
            if (r1 != 0) goto L_0x015d
            java.lang.String r1 = com.umeng.analytics.pro.an.f13744n     // Catch:{ all -> 0x016b }
            r0.put(r1, r10)     // Catch:{ all -> 0x016b }
            java.lang.String r10 = com.umeng.analytics.pro.an.f13745o     // Catch:{ all -> 0x016b }
            r0.put(r10, r9)     // Catch:{ all -> 0x016b }
            goto L_0x016b
        L_0x015d:
            java.lang.String r9 = com.umeng.analytics.pro.an.f13744n     // Catch:{ all -> 0x016b }
            java.lang.String r10 = "Android"
            r0.put(r9, r10)     // Catch:{ all -> 0x016b }
            java.lang.String r9 = com.umeng.analytics.pro.an.f13745o     // Catch:{ all -> 0x016b }
            java.lang.String r10 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x016b }
            r0.put(r9, r10)     // Catch:{ all -> 0x016b }
        L_0x016b:
            return r0
        L_0x016c:
            r9 = move-exception
            r3 = r0
            goto L_0x018b
        L_0x016f:
            r9 = move-exception
            r3 = r0
            goto L_0x0173
        L_0x0172:
            r9 = move-exception
        L_0x0173:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r10.<init>()     // Catch:{ all -> 0x018a }
            r10.append(r1)     // Catch:{ all -> 0x018a }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x018a }
            r10.append(r9)     // Catch:{ all -> 0x018a }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x018a }
            com.umeng.commonsdk.debug.UMRTLog.e(r2, r9)     // Catch:{ all -> 0x018a }
            goto L_0x01a1
        L_0x018a:
            r9 = move-exception
        L_0x018b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r1)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.umeng.commonsdk.debug.UMRTLog.e(r2, r9)
        L_0x01a1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.ao.a(android.content.Context, java.lang.String):org.json.JSONObject");
    }

    public static JSONObject a(Context context, int i10, JSONArray jSONArray, String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String zid = UMUtils.getZid(context);
                if (TextUtils.isEmpty(zid)) {
                    return jSONObject2;
                }
                jSONObject2.put("atoken", zid);
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject2.put("device_token", deviceToken);
                }
                jSONObject2.put(Constants.KEY_MODEL, Build.MODEL);
                jSONObject2.put("os", "android");
                jSONObject2.put(bt.f13931y, Build.VERSION.RELEASE);
                jSONObject2.put(a.f14525r, str);
                jSONObject2.put(a.f14528u, jSONArray);
                jSONObject2.put("e", i10);
                return jSONObject2;
            } catch (Throwable unused) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }
}
