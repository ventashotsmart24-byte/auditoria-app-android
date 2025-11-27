package com.umeng.message.proguard;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bt;
import com.umeng.ccg.a;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

final class m implements Runnable {
    public final void run() {
        JSONObject jSONObject;
        if (f.f15949a && !f.f15951c) {
            MessageSharedPrefs instance = MessageSharedPrefs.getInstance(y.a());
            if (instance.f15212c == null) {
                try {
                    if (f.b(instance.f15210a)) {
                        instance.f15211b.a("smart_lc", instance.n() + 1);
                    }
                } finally {
                    instance.f15212c = Boolean.TRUE;
                }
            }
            if (instance.n() >= ((long) instance.f15211b.b("smart_lt", 0)) && instance.a("smart_")) {
                try {
                    final Application a10 = y.a();
                    final String appkey = UMUtils.getAppkey(a10);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(bt.al, UMUtils.getZid(a10));
                    try {
                        jSONObject2.put("imei", DeviceConfig.getImeiNew(a10));
                        jSONObject2.put("oaid", DeviceConfig.getOaid(a10));
                    } catch (Throwable unused) {
                    }
                    try {
                        jSONObject2.put("idfa", DeviceConfig.getIdfa(a10));
                    } catch (Throwable unused2) {
                    }
                    jSONObject2.put(bt.f13913g, d.k(a10));
                    jSONObject2.put("android_id", d.e(a10));
                    jSONObject2.put("sdk_v", MsgConstant.SDK_VERSION);
                    jSONObject2.put("os_v", Build.VERSION.RELEASE);
                    jSONObject2.put("lvl", Build.VERSION.SDK_INT);
                    String[] networkAccessMode = UMUtils.getNetworkAccessMode(a10);
                    if (TextUtils.isEmpty(networkAccessMode[0])) {
                        networkAccessMode[0] = "Unknown";
                    }
                    jSONObject2.put("net", networkAccessMode[0]);
                    jSONObject2.put(Constants.KEY_BRAND, d.f());
                    long b10 = instance.f15211b.b("smart_ts", 0);
                    if (b10 > 0) {
                        jSONObject2.put("last", b10);
                    }
                    try {
                        jSONObject = g.a(jSONObject2, "https://ccs.umeng.com/aa", appkey, false);
                    } catch (Exception unused3) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        instance.a(7200);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        instance.a(7200);
                        return;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                    if (optJSONObject2 == null) {
                        optJSONObject2 = new JSONObject();
                    }
                    int optInt = optJSONObject2.optInt("launch", 5);
                    instance.f15211b.a("smart_lt", optInt);
                    if (instance.n() >= ((long) optInt)) {
                        instance.a(optJSONObject.optLong("ttl", 86400));
                        final long optLong = optJSONObject.optLong("id", -1);
                        if (optLong > 0) {
                            final int max = Math.max(optJSONObject2.optInt(a.f14529v, 300), 100);
                            final int optInt2 = optJSONObject2.optInt("action", 1);
                            int optInt3 = optJSONObject2.optInt("delay");
                            if (optInt2 == 1 || optInt2 == 2) {
                                b.b(new Runnable() {
                                    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Class[], java.lang.Object[]] */
                                    /* JADX WARNING: type inference failed for: r5v1, types: [java.io.Closeable] */
                                    /* JADX WARNING: type inference failed for: r5v2 */
                                    /* JADX WARNING: Can't wrap try/catch for region: R(24:52|53|54|(2:55|56)|57|(2:59|60)|61|63|64|(3:65|66|(1:68))|69|71|72|73|74|75|(1:77)(1:78)|79|80|81|(5:84|85|86|87|82)|122|91|92) */
                                    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x0286 */
                                    /* JADX WARNING: Multi-variable type inference failed */
                                    /* JADX WARNING: Removed duplicated region for block: B:84:0x0291 A[Catch:{ Exception -> 0x02ab, all -> 0x02b1 }] */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final void run() {
                                        /*
                                            r18 = this;
                                            r1 = r18
                                            java.lang.String r0 = "i"
                                            java.lang.String r2 = "p"
                                            r3 = 1
                                            r5 = 0
                                            java.util.TreeSet r6 = new java.util.TreeSet     // Catch:{ all -> 0x02bb }
                                            r6.<init>()     // Catch:{ all -> 0x02bb }
                                            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x02bb }
                                            r7.<init>()     // Catch:{ all -> 0x02bb }
                                            r8 = 187(0xbb, float:2.62E-43)
                                            byte[] r9 = new byte[r8]     // Catch:{ all -> 0x02b7 }
                                            r9 = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, 21, 21, 12, 40, 14, 29} // fill-array     // Catch:{ all -> 0x02b7 }
                                            r10 = 179(0xb3, float:2.51E-43)
                                            byte[] r8 = java.util.Arrays.copyOfRange(r9, r10, r8)     // Catch:{ all -> 0x02b7 }
                                            byte[] r9 = java.util.Arrays.copyOf(r9, r10)     // Catch:{ all -> 0x02b7 }
                                            com.umeng.message.proguard.bl.a(r9, r8)     // Catch:{ all -> 0x02b7 }
                                            com.umeng.message.proguard.bq.b(r9, r7)     // Catch:{ all -> 0x02b7 }
                                            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x02b7 }
                                            java.lang.String r9 = r7.toString()     // Catch:{ all -> 0x02b7 }
                                            r8.<init>(r9)     // Catch:{ all -> 0x02b7 }
                                            java.lang.String r9 = "c"
                                            java.lang.String r9 = r8.optString(r9)     // Catch:{ all -> 0x02b7 }
                                            java.lang.String r10 = r8.optString(r2)     // Catch:{ all -> 0x02b7 }
                                            android.content.Context r11 = r6     // Catch:{ all -> 0x02b7 }
                                            java.lang.Object r5 = com.umeng.message.proguard.bn.a(r9, r10, r5, r11, r5)     // Catch:{ all -> 0x02b7 }
                                            int r9 = r7     // Catch:{ all -> 0x02b7 }
                                            java.lang.String r10 = "t"
                                            java.lang.String r11 = "n"
                                            java.lang.String r12 = "a"
                                            java.lang.String r13 = "u"
                                            java.lang.String r14 = "m"
                                            java.lang.String r15 = "v"
                                            if (r3 != r9) goto L_0x00d7
                                            java.lang.String r9 = r8.optString(r0)     // Catch:{ all -> 0x02b3 }
                                            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x02b3 }
                                            java.lang.Class<java.lang.String> r17 = java.lang.String.class
                                            r16 = 0
                                            r4[r16] = r17     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r17 = r8.optString(r12)     // Catch:{ all -> 0x02b3 }
                                            r1[r16] = r17     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object r1 = com.umeng.message.proguard.bn.a((java.lang.String) r9, (java.lang.Class<?>[]) r4, (java.lang.Object[]) r1)     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r4 = r8.optString(r14)     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r9 = "q"
                                            java.lang.String r9 = r8.optString(r9)     // Catch:{ all -> 0x02b3 }
                                            r14 = 2
                                            java.lang.Class[] r3 = new java.lang.Class[r14]     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r0 = r8.optString(r0)     // Catch:{ all -> 0x02b3 }
                                            java.lang.Class r0 = com.umeng.message.proguard.bn.a(r0)     // Catch:{ all -> 0x02b3 }
                                            r16 = 0
                                            r3[r16] = r0     // Catch:{ all -> 0x02b3 }
                                            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ all -> 0x02b3 }
                                            r17 = 1
                                            r3[r17] = r0     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object[] r0 = new java.lang.Object[r14]     // Catch:{ all -> 0x02b3 }
                                            r0[r16] = r1     // Catch:{ all -> 0x02b3 }
                                            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x02b3 }
                                            r0[r17] = r1     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object r0 = com.umeng.message.proguard.bn.a(r4, r9, r3, r5, r0)     // Catch:{ all -> 0x02b3 }
                                            boolean r1 = r0 instanceof java.util.List     // Catch:{ all -> 0x02b3 }
                                            if (r1 == 0) goto L_0x011f
                                            java.lang.String r1 = "r"
                                            java.lang.String r1 = r8.optString(r1)     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r3 = "s"
                                            java.lang.String r3 = r8.optString(r3)     // Catch:{ all -> 0x02b3 }
                                            java.lang.reflect.Field r1 = com.umeng.message.proguard.bn.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r3 = r8.optString(r10)     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r4 = r8.optString(r11)     // Catch:{ all -> 0x02b3 }
                                            java.lang.reflect.Field r3 = com.umeng.message.proguard.bn.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x02b3 }
                                            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x02b3 }
                                            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02b3 }
                                        L_0x00bd:
                                            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x02b3 }
                                            if (r4 == 0) goto L_0x011f
                                            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object r4 = com.umeng.message.proguard.bn.a((java.lang.reflect.Field) r1, (java.lang.Object) r4)     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object r4 = com.umeng.message.proguard.bn.a((java.lang.reflect.Field) r3, (java.lang.Object) r4)     // Catch:{ all -> 0x02b3 }
                                            if (r4 == 0) goto L_0x00bd
                                            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x02b3 }
                                            r6.add(r4)     // Catch:{ all -> 0x02b3 }
                                            goto L_0x00bd
                                        L_0x00d7:
                                            java.lang.String r0 = r8.optString(r14)     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r1 = r8.optString(r13)     // Catch:{ all -> 0x02b3 }
                                            r3 = 1
                                            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x02b3 }
                                            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ all -> 0x02b3 }
                                            r14 = 0
                                            r4[r14] = r9     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x02b3 }
                                            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x02b3 }
                                            r9[r14] = r3     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object r0 = com.umeng.message.proguard.bn.a(r0, r1, r4, r5, r9)     // Catch:{ all -> 0x02b3 }
                                            boolean r1 = r0 instanceof java.util.List     // Catch:{ all -> 0x02b3 }
                                            if (r1 == 0) goto L_0x011f
                                            java.lang.String r1 = r8.optString(r15)     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r3 = r8.optString(r11)     // Catch:{ all -> 0x02b3 }
                                            java.lang.reflect.Field r1 = com.umeng.message.proguard.bn.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x02b3 }
                                            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x02b3 }
                                            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02b3 }
                                        L_0x0109:
                                            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x02b3 }
                                            if (r3 == 0) goto L_0x011f
                                            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object r3 = com.umeng.message.proguard.bn.a((java.lang.reflect.Field) r1, (java.lang.Object) r3)     // Catch:{ all -> 0x02b3 }
                                            if (r3 == 0) goto L_0x0109
                                            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x02b3 }
                                            r6.add(r3)     // Catch:{ all -> 0x02b3 }
                                            goto L_0x0109
                                        L_0x011f:
                                            boolean r0 = r6.isEmpty()     // Catch:{ all -> 0x02b3 }
                                            if (r0 == 0) goto L_0x0129
                                            com.umeng.message.proguard.f.a((java.io.Closeable) r7)
                                            return
                                        L_0x0129:
                                            if (r5 != 0) goto L_0x012f
                                            com.umeng.message.proguard.f.a((java.io.Closeable) r7)
                                            return
                                        L_0x012f:
                                            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x02b3 }
                                            r0.<init>()     // Catch:{ all -> 0x02b3 }
                                            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x02b3 }
                                            r1.<init>()     // Catch:{ all -> 0x02b3 }
                                            java.util.Iterator r3 = r6.iterator()     // Catch:{ all -> 0x02b3 }
                                            r4 = 0
                                        L_0x013e:
                                            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x02b3 }
                                            if (r6 == 0) goto L_0x018e
                                            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x02b3 }
                                            java.lang.Object r6 = com.umeng.message.proguard.f.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ all -> 0x02b3 }
                                            if (r6 == 0) goto L_0x018b
                                            com.umeng.message.proguard.l r8 = new com.umeng.message.proguard.l     // Catch:{ all -> 0x02b3 }
                                            r8.<init>(r5, r6)     // Catch:{ all -> 0x02b3 }
                                            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x02b3 }
                                            r6.<init>()     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r9 = r8.f15975b     // Catch:{ all -> 0x02b3 }
                                            r6.put(r12, r9)     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r9 = r8.f15974a     // Catch:{ all -> 0x02b3 }
                                            r6.put(r2, r9)     // Catch:{ all -> 0x02b3 }
                                            java.lang.String r9 = r8.f15976c     // Catch:{ all -> 0x02b3 }
                                            r6.put(r15, r9)     // Catch:{ all -> 0x02b3 }
                                            int r9 = r8.f15978e     // Catch:{ all -> 0x02b3 }
                                            r6.put(r10, r9)     // Catch:{ all -> 0x02b3 }
                                            long r8 = r8.f15977d     // Catch:{ all -> 0x02b3 }
                                            r6.put(r13, r8)     // Catch:{ all -> 0x02b3 }
                                            r1.put(r6)     // Catch:{ all -> 0x02b3 }
                                            int r4 = r4 + 1
                                            int r6 = r1.length()     // Catch:{ all -> 0x02b3 }
                                            r8 = r18
                                            int r9 = r8     // Catch:{ all -> 0x02b1 }
                                            if (r6 != r9) goto L_0x013e
                                            r0.add(r1)     // Catch:{ all -> 0x02b1 }
                                            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x02b1 }
                                            r1.<init>()     // Catch:{ all -> 0x02b1 }
                                            goto L_0x013e
                                        L_0x018b:
                                            r8 = r18
                                            goto L_0x013e
                                        L_0x018e:
                                            r8 = r18
                                            int r2 = r1.length()     // Catch:{ all -> 0x02b1 }
                                            if (r2 <= 0) goto L_0x0199
                                            r0.add(r1)     // Catch:{ all -> 0x02b1 }
                                        L_0x0199:
                                            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x02b1 }
                                            if (r1 == 0) goto L_0x01a3
                                            com.umeng.message.proguard.f.a((java.io.Closeable) r7)
                                            return
                                        L_0x01a3:
                                            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x02b1 }
                                            r1.<init>()     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "zid"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getZid(r3)     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "appkey"
                                            java.lang.String r3 = r9     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "umid"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r3 = com.umeng.message.proguard.d.k(r3)     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "2.1"
                                            r1.put(r15, r2)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "sdk_v"
                                            java.lang.String r3 = "6.7.0"
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "os_v"
                                            java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "brand"
                                            java.lang.String r3 = com.umeng.message.proguard.d.f()     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "model"
                                            java.lang.String r3 = com.umeng.message.proguard.d.d()     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "smart_id"
                                            long r5 = r10     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r5)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "src"
                                            java.lang.String r3 = "push"
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "imei"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(r3)     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "oaid"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x020e }
                                            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getOaid(r3)     // Catch:{ all -> 0x020e }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x020e }
                                        L_0x020e:
                                            java.lang.String r2 = "idfa"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x0219 }
                                            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getIdfa(r3)     // Catch:{ all -> 0x0219 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x0219 }
                                        L_0x0219:
                                            java.lang.String r2 = "android_id"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r3 = com.umeng.message.proguard.d.e(r3)     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "pkg"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "app_v"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r3)     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "board"
                                            java.lang.String r3 = com.umeng.message.proguard.d.e()     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x02b1 }
                                            android.content.Context r2 = r6     // Catch:{ all -> 0x0254 }
                                            java.util.Locale r2 = com.umeng.commonsdk.utils.UMUtils.getLocale(r2)     // Catch:{ all -> 0x0254 }
                                            if (r2 == 0) goto L_0x0254
                                            java.lang.String r3 = "os_lang"
                                            java.lang.String r2 = r2.getLanguage()     // Catch:{ all -> 0x0254 }
                                            r1.put(r3, r2)     // Catch:{ all -> 0x0254 }
                                        L_0x0254:
                                            java.lang.String r2 = "c_ts"
                                            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b1 }
                                            r1.put(r2, r5)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "total"
                                            r1.put(r2, r4)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r2 = "os_i"
                                            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0286 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x0286 }
                                            java.lang.String r2 = "os_t"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x0286 }
                                            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ all -> 0x0286 }
                                            int r3 = r3.targetSdkVersion     // Catch:{ all -> 0x0286 }
                                            r1.put(r2, r3)     // Catch:{ all -> 0x0286 }
                                            java.lang.String r2 = "grant"
                                            android.content.Context r3 = r6     // Catch:{ all -> 0x0286 }
                                            boolean r3 = com.umeng.message.proguard.f.f(r3)     // Catch:{ all -> 0x0286 }
                                            if (r3 == 0) goto L_0x0282
                                            r3 = 1
                                            goto L_0x0283
                                        L_0x0282:
                                            r3 = 0
                                        L_0x0283:
                                            r1.put(r2, r3)     // Catch:{ all -> 0x0286 }
                                        L_0x0286:
                                            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02b1 }
                                            r2 = 0
                                        L_0x028b:
                                            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x02b1 }
                                            if (r3 == 0) goto L_0x02ad
                                            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x02b1 }
                                            org.json.JSONArray r3 = (org.json.JSONArray) r3     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r4 = "batch"
                                            r5 = 1
                                            int r2 = r2 + r5
                                            r1.put(r4, r2)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r4 = "data"
                                            r1.put(r4, r3)     // Catch:{ all -> 0x02b1 }
                                            java.lang.String r3 = "https://sss.umeng.com/api/v2/al"
                                            java.lang.String r4 = r9     // Catch:{ Exception -> 0x02ab }
                                            com.umeng.message.proguard.g.b(r1, r3, r4)     // Catch:{ Exception -> 0x02ab }
                                            goto L_0x028b
                                        L_0x02ab:
                                            r0 = move-exception
                                            throw r0     // Catch:{ all -> 0x02b1 }
                                        L_0x02ad:
                                            com.umeng.message.proguard.f.a((java.io.Closeable) r7)
                                            return
                                        L_0x02b1:
                                            r0 = move-exception
                                            goto L_0x02b9
                                        L_0x02b3:
                                            r0 = move-exception
                                            r8 = r18
                                            goto L_0x02b9
                                        L_0x02b7:
                                            r0 = move-exception
                                            r8 = r1
                                        L_0x02b9:
                                            r5 = r7
                                            goto L_0x02bd
                                        L_0x02bb:
                                            r0 = move-exception
                                            r8 = r1
                                        L_0x02bd:
                                            java.lang.String r1 = "App"
                                            r2 = 1
                                            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x02d0 }
                                            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02d0 }
                                            r3 = 0
                                            r2[r3] = r0     // Catch:{ all -> 0x02d0 }
                                            com.umeng.message.common.UPLog.e((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ all -> 0x02d0 }
                                            com.umeng.message.proguard.f.a((java.io.Closeable) r5)
                                            return
                                        L_0x02d0:
                                            r0 = move-exception
                                            com.umeng.message.proguard.f.a((java.io.Closeable) r5)
                                            goto L_0x02d6
                                        L_0x02d5:
                                            throw r0
                                        L_0x02d6:
                                            goto L_0x02d5
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.m.AnonymousClass1.run():void");
                                    }
                                }, (long) optInt3, TimeUnit.SECONDS);
                            }
                        }
                    }
                } catch (Throwable unused4) {
                }
            }
        }
    }
}
