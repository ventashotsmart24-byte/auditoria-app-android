package com.uyumao;

import android.content.Context;
import android.util.Log;
import com.umeng.analytics.pro.bd;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f16251a = false;

    /* renamed from: b  reason: collision with root package name */
    public static h f16252b;

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x0158 */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A[SYNTHETIC, Splitter:B:22:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051 A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060 A[SYNTHETIC, Splitter:B:28:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d4 A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e3 A[SYNTHETIC, Splitter:B:65:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0136 A[SYNTHETIC, Splitter:B:97:0x0136] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(android.content.Context r9, com.uyumao.i r10, org.json.JSONArray r11) {
        /*
            java.lang.String r0 = "imp"
            java.lang.String r1 = ""
            r2 = 1
            r3 = 0
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x00da }
            r5.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r6 = "ak"
            java.lang.String r7 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r9)     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getUMId(r9)     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = "umid"
            if (r6 != 0) goto L_0x0021
            r5.put(r7, r1)     // Catch:{ all -> 0x00d8 }
            goto L_0x0028
        L_0x0021:
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getUMId(r9)     // Catch:{ all -> 0x00d8 }
            r5.put(r7, r6)     // Catch:{ all -> 0x00d8 }
        L_0x0028:
            java.lang.String[] r6 = com.umeng.commonsdk.utils.UMUtils.getActiveUser(r9)     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = "puid"
            if (r6 == 0) goto L_0x0042
            java.lang.String[] r6 = com.umeng.commonsdk.utils.UMUtils.getActiveUser(r9)     // Catch:{ all -> 0x00d8 }
            int r6 = r6.length     // Catch:{ all -> 0x00d8 }
            r8 = 2
            if (r6 != r8) goto L_0x0042
            java.lang.String[] r6 = com.umeng.commonsdk.utils.UMUtils.getActiveUser(r9)     // Catch:{ all -> 0x00d8 }
            r6 = r6[r2]     // Catch:{ all -> 0x00d8 }
            r5.put(r7, r6)     // Catch:{ all -> 0x00d8 }
            goto L_0x0045
        L_0x0042:
            r5.put(r7, r1)     // Catch:{ all -> 0x00d8 }
        L_0x0045:
            java.lang.String r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(r9)     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = "aid"
            if (r6 != 0) goto L_0x0051
            r5.put(r7, r1)     // Catch:{ all -> 0x00d8 }
            goto L_0x0058
        L_0x0051:
            java.lang.String r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(r9)     // Catch:{ all -> 0x00d8 }
            r5.put(r7, r6)     // Catch:{ all -> 0x00d8 }
        L_0x0058:
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getZid(r9)     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = "atoken"
            if (r6 != 0) goto L_0x0064
            r5.put(r7, r1)     // Catch:{ all -> 0x00d8 }
            goto L_0x006b
        L_0x0064:
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getZid(r9)     // Catch:{ all -> 0x00d8 }
            r5.put(r7, r6)     // Catch:{ all -> 0x00d8 }
        L_0x006b:
            java.lang.String r6 = "oaid"
            java.lang.String r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.getOaid(r9)     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "idfa"
            java.lang.String r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.getIdfa(r9)     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "db"
            java.lang.String r7 = android.os.Build.BRAND     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "dm"
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "os"
            java.lang.String r7 = "Android"
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "ov"
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "sv"
            java.lang.String r7 = "1.1.4"
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "av"
            java.lang.String r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(r9)     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "chn"
            java.lang.String r7 = com.umeng.commonsdk.utils.UMUtils.getChannel(r9)     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "cts"
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "pkg"
            java.lang.String r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.getPackageName(r9)     // Catch:{ all -> 0x00d8 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "uyumao_info"
            android.content.SharedPreferences r6 = r9.getSharedPreferences(r6, r3)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = r6.getString(r0, r1)     // Catch:{ all -> 0x00d8 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00d8 }
            if (r7 != 0) goto L_0x00df
            r5.put(r0, r6)     // Catch:{ all -> 0x00d8 }
            goto L_0x00df
        L_0x00d8:
            r0 = move-exception
            goto L_0x00dc
        L_0x00da:
            r0 = move-exception
            r5 = r4
        L_0x00dc:
            r0.printStackTrace()
        L_0x00df:
            if (r5 != 0) goto L_0x00e3
            goto L_0x0183
        L_0x00e3:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x017e }
            r0.<init>()     // Catch:{ all -> 0x017e }
            if (r10 == 0) goto L_0x0114
            java.lang.String r4 = "le"
            int r6 = r10.f16280a     // Catch:{ all -> 0x017e }
            r0.put(r4, r6)     // Catch:{ all -> 0x017e }
            java.lang.String r4 = "vo"
            int r6 = r10.f16281b     // Catch:{ all -> 0x017e }
            r0.put(r4, r6)     // Catch:{ all -> 0x017e }
            java.lang.String r4 = "te"
            int r6 = r10.f16282c     // Catch:{ all -> 0x017e }
            r0.put(r4, r6)     // Catch:{ all -> 0x017e }
            java.lang.String r4 = "st"
            int r6 = r10.f16283d     // Catch:{ all -> 0x017e }
            r0.put(r4, r6)     // Catch:{ all -> 0x017e }
            java.lang.String r4 = "ch"
            int r6 = r10.f16284e     // Catch:{ all -> 0x017e }
            r0.put(r4, r6)     // Catch:{ all -> 0x017e }
            java.lang.String r4 = "ts"
            long r6 = r10.f16285f     // Catch:{ all -> 0x017e }
            r0.put(r4, r6)     // Catch:{ all -> 0x017e }
        L_0x0114:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x017e }
            r10.<init>()     // Catch:{ all -> 0x017e }
            java.lang.String r4 = "mcc"
            if (r9 != 0) goto L_0x011e
            goto L_0x012d
        L_0x011e:
            android.content.res.Resources r6 = r9.getResources()     // Catch:{ all -> 0x012d }
            android.content.res.Configuration r6 = r6.getConfiguration()     // Catch:{ all -> 0x012d }
            int r6 = r6.mcc     // Catch:{ all -> 0x012d }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x012d }
            goto L_0x012e
        L_0x012d:
            r6 = r1
        L_0x012e:
            r10.put(r4, r6)     // Catch:{ all -> 0x017e }
            java.lang.String r4 = "mnc"
            if (r9 != 0) goto L_0x0136
            goto L_0x0158
        L_0x0136:
            android.content.res.Resources r6 = r9.getResources()     // Catch:{ all -> 0x0158 }
            android.content.res.Configuration r6 = r6.getConfiguration()     // Catch:{ all -> 0x0158 }
            int r6 = r6.mnc     // Catch:{ all -> 0x0158 }
            java.lang.String r7 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0158 }
            r8 = 10
            if (r6 >= r8) goto L_0x0157
            java.lang.String r7 = "%02d"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0158 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0158 }
            r2[r3] = r6     // Catch:{ all -> 0x0158 }
            java.lang.String r1 = java.lang.String.format(r7, r2)     // Catch:{ all -> 0x0158 }
            goto L_0x0158
        L_0x0157:
            r1 = r7
        L_0x0158:
            r10.put(r4, r1)     // Catch:{ all -> 0x017e }
            java.lang.String r1 = "net"
            java.lang.String[] r9 = com.uyumao.e.c(r9)     // Catch:{ all -> 0x017e }
            r9 = r9[r3]     // Catch:{ all -> 0x017e }
            r10.put(r1, r9)     // Catch:{ all -> 0x017e }
            java.lang.String r9 = "battery"
            r10.put(r9, r0)     // Catch:{ all -> 0x017e }
            if (r11 == 0) goto L_0x0178
            int r9 = r11.length()     // Catch:{ all -> 0x017e }
            if (r9 == 0) goto L_0x0178
            java.lang.String r9 = "net_state"
            r10.put(r9, r11)     // Catch:{ all -> 0x017e }
        L_0x0178:
            java.lang.String r9 = "anti"
            r5.put(r9, r10)     // Catch:{ all -> 0x017e }
            goto L_0x0182
        L_0x017e:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0182:
            r4 = r5
        L_0x0183:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.c.a(android.content.Context, com.uyumao.i, org.json.JSONArray):org.json.JSONObject");
    }

    public static void a(Context context, JSONObject jSONObject, boolean z10) {
        if (jSONObject == null) {
            Log.e("UYMInnerManager", "JSONObject in sendInitData() is null.");
            return;
        }
        String a10 = k.a(context, "https://yumao.puata.info/anti_logs", jSONObject.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("msg: ");
        sb.append(a10);
        sb.append("; json: ");
        sb.append(jSONObject);
        if (a10 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(a10);
                if (jSONObject2.has(bd.f13843c)) {
                    context.getSharedPreferences("uyumao_info", 0).edit().putString(bd.f13843c, jSONObject2.optString(bd.f13843c)).apply();
                }
                if (z10) {
                    if (jSONObject2.has("resp_code") && jSONObject2.optInt("resp_code") == 0) {
                        context.getSharedPreferences("uyumao_info", 0).edit().putBoolean(new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()), true).apply();
                    }
                    e.a(new File(context.getCacheDir() + File.separator + "net_change"));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
