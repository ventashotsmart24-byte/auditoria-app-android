package com.umeng.message.proguard;

import android.app.Application;
import com.umeng.ccg.a;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final JSONObject f15985a;

    public n(JSONObject jSONObject) {
        this.f15985a = jSONObject;
    }

    public final void run() {
        if (f.f15949a && this.f15985a != null) {
            try {
                final Application a10 = y.a();
                final String appkey = UMUtils.getAppkey(a10);
                final int max = Math.max(this.f15985a.optInt(a.f14529v, 300), 100);
                final int optInt = this.f15985a.optInt("action", 1);
                if (optInt == 1 || optInt == 2) {
                    b.c(new Runnable() {
                        /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.Class[], java.lang.Object[]] */
                        /* JADX WARNING: type inference failed for: r10v1, types: [java.io.Closeable] */
                        /* JADX WARNING: type inference failed for: r10v2 */
                        /* JADX WARNING: Can't wrap try/catch for region: R(35:52|53|54|(2:55|56)|57|(2:59|60)|61|63|64|(3:65|66|(1:68))|69|71|72|73|(4:74|75|(1:77)(1:78)|79)|80|82|83|84|(3:86|87|88)(2:89|(1:91)(1:92))|93|(1:95)|96|97|98|(2:101|99)|147|102|(1:104)|105|106|(5:109|110|111|112|107)|148|116|117) */
                        /* JADX WARNING: Can't wrap try/catch for region: R(42:52|53|54|55|56|57|59|60|61|63|64|65|66|(1:68)|69|71|72|73|74|75|(1:77)(1:78)|79|80|82|83|84|(3:86|87|88)(2:89|(1:91)(1:92))|93|(1:95)|96|97|98|(2:101|99)|147|102|(1:104)|105|106|(5:109|110|111|112|107)|148|116|117) */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x0360 */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x02f8 */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* JADX WARNING: Removed duplicated region for block: B:101:0x0311 A[Catch:{ all -> 0x0360 }, LOOP:3: B:99:0x030e->B:101:0x0311, LOOP_END] */
                        /* JADX WARNING: Removed duplicated region for block: B:104:0x0350 A[Catch:{ all -> 0x0360 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:109:0x036b A[Catch:{ Exception -> 0x0385, all -> 0x038b }] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                                r23 = this;
                                r1 = r23
                                java.lang.String r0 = "forbid_sdk"
                                java.lang.String r2 = "local_hit_sdk"
                                java.lang.String r3 = "hit_sdk"
                                java.lang.String r4 = "2G/3G"
                                java.lang.String r5 = "sdk"
                                java.lang.String r6 = "i"
                                java.lang.String r7 = "p"
                                r10 = 0
                                java.util.TreeSet r11 = new java.util.TreeSet     // Catch:{ all -> 0x0395 }
                                r11.<init>()     // Catch:{ all -> 0x0395 }
                                java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0395 }
                                r12.<init>()     // Catch:{ all -> 0x0395 }
                                r13 = 187(0xbb, float:2.62E-43)
                                byte[] r14 = new byte[r13]     // Catch:{ all -> 0x0391 }
                                r14 = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, 21, 21, 12, 40, 14, 29} // fill-array     // Catch:{ all -> 0x0391 }
                                r15 = 179(0xb3, float:2.51E-43)
                                byte[] r13 = java.util.Arrays.copyOfRange(r14, r15, r13)     // Catch:{ all -> 0x0391 }
                                byte[] r14 = java.util.Arrays.copyOf(r14, r15)     // Catch:{ all -> 0x0391 }
                                com.umeng.message.proguard.bl.a(r14, r13)     // Catch:{ all -> 0x0391 }
                                com.umeng.message.proguard.bq.b(r14, r12)     // Catch:{ all -> 0x0391 }
                                org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x0391 }
                                java.lang.String r14 = r12.toString()     // Catch:{ all -> 0x0391 }
                                r13.<init>(r14)     // Catch:{ all -> 0x0391 }
                                java.lang.String r14 = "c"
                                java.lang.String r14 = r13.optString(r14)     // Catch:{ all -> 0x0391 }
                                java.lang.String r15 = r13.optString(r7)     // Catch:{ all -> 0x0391 }
                                android.content.Context r9 = r3     // Catch:{ all -> 0x0391 }
                                java.lang.Object r9 = com.umeng.message.proguard.bn.a(r14, r15, r10, r9, r10)     // Catch:{ all -> 0x0391 }
                                int r10 = r4     // Catch:{ all -> 0x0391 }
                                java.lang.String r14 = "t"
                                java.lang.String r15 = "n"
                                java.lang.String r8 = "a"
                                r18 = r0
                                java.lang.String r0 = "u"
                                r19 = r2
                                java.lang.String r2 = "m"
                                r20 = r3
                                java.lang.String r3 = "v"
                                r21 = r5
                                r5 = 1
                                if (r5 != r10) goto L_0x00eb
                                java.lang.String r10 = r13.optString(r6)     // Catch:{ all -> 0x038d }
                                r22 = r4
                                java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{ all -> 0x038d }
                                java.lang.Class<java.lang.String> r17 = java.lang.String.class
                                r16 = 0
                                r4[r16] = r17     // Catch:{ all -> 0x038d }
                                java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ all -> 0x038d }
                                java.lang.String r5 = r13.optString(r8)     // Catch:{ all -> 0x038d }
                                r1[r16] = r5     // Catch:{ all -> 0x038d }
                                java.lang.Object r1 = com.umeng.message.proguard.bn.a((java.lang.String) r10, (java.lang.Class<?>[]) r4, (java.lang.Object[]) r1)     // Catch:{ all -> 0x038d }
                                java.lang.String r2 = r13.optString(r2)     // Catch:{ all -> 0x038d }
                                java.lang.String r4 = "q"
                                java.lang.String r4 = r13.optString(r4)     // Catch:{ all -> 0x038d }
                                r5 = 2
                                java.lang.Class[] r10 = new java.lang.Class[r5]     // Catch:{ all -> 0x038d }
                                java.lang.String r6 = r13.optString(r6)     // Catch:{ all -> 0x038d }
                                java.lang.Class r6 = com.umeng.message.proguard.bn.a(r6)     // Catch:{ all -> 0x038d }
                                r16 = 0
                                r10[r16] = r6     // Catch:{ all -> 0x038d }
                                java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ all -> 0x038d }
                                r17 = 1
                                r10[r17] = r6     // Catch:{ all -> 0x038d }
                                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x038d }
                                r5[r16] = r1     // Catch:{ all -> 0x038d }
                                java.lang.Integer r1 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x038d }
                                r5[r17] = r1     // Catch:{ all -> 0x038d }
                                java.lang.Object r1 = com.umeng.message.proguard.bn.a(r2, r4, r10, r9, r5)     // Catch:{ all -> 0x038d }
                                boolean r2 = r1 instanceof java.util.List     // Catch:{ all -> 0x038d }
                                if (r2 == 0) goto L_0x0135
                                java.lang.String r2 = "r"
                                java.lang.String r2 = r13.optString(r2)     // Catch:{ all -> 0x038d }
                                java.lang.String r4 = "s"
                                java.lang.String r4 = r13.optString(r4)     // Catch:{ all -> 0x038d }
                                java.lang.reflect.Field r2 = com.umeng.message.proguard.bn.a((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ all -> 0x038d }
                                java.lang.String r4 = r13.optString(r14)     // Catch:{ all -> 0x038d }
                                java.lang.String r5 = r13.optString(r15)     // Catch:{ all -> 0x038d }
                                java.lang.reflect.Field r4 = com.umeng.message.proguard.bn.a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x038d }
                                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x038d }
                                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x038d }
                            L_0x00d1:
                                boolean r5 = r1.hasNext()     // Catch:{ all -> 0x038d }
                                if (r5 == 0) goto L_0x0135
                                java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x038d }
                                java.lang.Object r5 = com.umeng.message.proguard.bn.a((java.lang.reflect.Field) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x038d }
                                java.lang.Object r5 = com.umeng.message.proguard.bn.a((java.lang.reflect.Field) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x038d }
                                if (r5 == 0) goto L_0x00d1
                                java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x038d }
                                r11.add(r5)     // Catch:{ all -> 0x038d }
                                goto L_0x00d1
                            L_0x00eb:
                                r22 = r4
                                java.lang.String r1 = r13.optString(r2)     // Catch:{ all -> 0x038d }
                                java.lang.String r2 = r13.optString(r0)     // Catch:{ all -> 0x038d }
                                r4 = 1
                                java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x038d }
                                java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ all -> 0x038d }
                                r10 = 0
                                r5[r10] = r6     // Catch:{ all -> 0x038d }
                                java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x038d }
                                java.lang.Integer r4 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x038d }
                                r6[r10] = r4     // Catch:{ all -> 0x038d }
                                java.lang.Object r1 = com.umeng.message.proguard.bn.a(r1, r2, r5, r9, r6)     // Catch:{ all -> 0x038d }
                                boolean r2 = r1 instanceof java.util.List     // Catch:{ all -> 0x038d }
                                if (r2 == 0) goto L_0x0135
                                java.lang.String r2 = r13.optString(r3)     // Catch:{ all -> 0x038d }
                                java.lang.String r4 = r13.optString(r15)     // Catch:{ all -> 0x038d }
                                java.lang.reflect.Field r2 = com.umeng.message.proguard.bn.a((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ all -> 0x038d }
                                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x038d }
                                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x038d }
                            L_0x011f:
                                boolean r4 = r1.hasNext()     // Catch:{ all -> 0x038d }
                                if (r4 == 0) goto L_0x0135
                                java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x038d }
                                java.lang.Object r4 = com.umeng.message.proguard.bn.a((java.lang.reflect.Field) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x038d }
                                if (r4 == 0) goto L_0x011f
                                java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x038d }
                                r11.add(r4)     // Catch:{ all -> 0x038d }
                                goto L_0x011f
                            L_0x0135:
                                boolean r1 = r11.isEmpty()     // Catch:{ all -> 0x038d }
                                if (r1 == 0) goto L_0x013f
                                com.umeng.message.proguard.f.a((java.io.Closeable) r12)
                                return
                            L_0x013f:
                                if (r9 != 0) goto L_0x0145
                                com.umeng.message.proguard.f.a((java.io.Closeable) r12)
                                return
                            L_0x0145:
                                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x038d }
                                r1.<init>()     // Catch:{ all -> 0x038d }
                                org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x038d }
                                r2.<init>()     // Catch:{ all -> 0x038d }
                                java.util.Iterator r4 = r11.iterator()     // Catch:{ all -> 0x038d }
                                r5 = 0
                            L_0x0154:
                                boolean r6 = r4.hasNext()     // Catch:{ all -> 0x038d }
                                if (r6 == 0) goto L_0x01a4
                                java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x038d }
                                java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x038d }
                                java.lang.Object r6 = com.umeng.message.proguard.f.a((java.lang.Object) r9, (java.lang.String) r6)     // Catch:{ all -> 0x038d }
                                if (r6 == 0) goto L_0x01a1
                                com.umeng.message.proguard.l r10 = new com.umeng.message.proguard.l     // Catch:{ all -> 0x038d }
                                r10.<init>(r9, r6)     // Catch:{ all -> 0x038d }
                                org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x038d }
                                r6.<init>()     // Catch:{ all -> 0x038d }
                                java.lang.String r11 = r10.f15975b     // Catch:{ all -> 0x038d }
                                r6.put(r8, r11)     // Catch:{ all -> 0x038d }
                                java.lang.String r11 = r10.f15974a     // Catch:{ all -> 0x038d }
                                r6.put(r7, r11)     // Catch:{ all -> 0x038d }
                                java.lang.String r11 = r10.f15976c     // Catch:{ all -> 0x038d }
                                r6.put(r3, r11)     // Catch:{ all -> 0x038d }
                                int r11 = r10.f15978e     // Catch:{ all -> 0x038d }
                                r6.put(r14, r11)     // Catch:{ all -> 0x038d }
                                long r10 = r10.f15977d     // Catch:{ all -> 0x038d }
                                r6.put(r0, r10)     // Catch:{ all -> 0x038d }
                                r2.put(r6)     // Catch:{ all -> 0x038d }
                                int r5 = r5 + 1
                                int r6 = r2.length()     // Catch:{ all -> 0x038d }
                                r11 = r23
                                int r10 = r5     // Catch:{ all -> 0x038b }
                                if (r6 != r10) goto L_0x0154
                                r1.add(r2)     // Catch:{ all -> 0x038b }
                                org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x038b }
                                r2.<init>()     // Catch:{ all -> 0x038b }
                                goto L_0x0154
                            L_0x01a1:
                                r11 = r23
                                goto L_0x0154
                            L_0x01a4:
                                r11 = r23
                                int r0 = r2.length()     // Catch:{ all -> 0x038b }
                                if (r0 <= 0) goto L_0x01af
                                r1.add(r2)     // Catch:{ all -> 0x038b }
                            L_0x01af:
                                boolean r0 = r1.isEmpty()     // Catch:{ all -> 0x038b }
                                if (r0 == 0) goto L_0x01b9
                                com.umeng.message.proguard.f.a((java.io.Closeable) r12)
                                return
                            L_0x01b9:
                                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x038b }
                                r0.<init>()     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "zid"
                                android.content.Context r4 = r3     // Catch:{ all -> 0x038b }
                                java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getZid(r4)     // Catch:{ all -> 0x038b }
                                r0.put(r2, r4)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "appkey"
                                java.lang.String r4 = r6     // Catch:{ all -> 0x038b }
                                r0.put(r2, r4)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "umid"
                                android.content.Context r4 = r3     // Catch:{ all -> 0x038b }
                                java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getUMId(r4)     // Catch:{ all -> 0x038b }
                                r0.put(r2, r4)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "3.1"
                                r0.put(r3, r2)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "sdk_v"
                                java.lang.String r3 = "6.7.0"
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "os_v"
                                java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x038b }
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "brand"
                                java.lang.String r3 = com.umeng.message.proguard.d.f()     // Catch:{ all -> 0x038b }
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "model"
                                java.lang.String r3 = com.umeng.message.proguard.d.d()     // Catch:{ all -> 0x038b }
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x038b }
                                java.lang.String r3 = "uuid"
                                r0.put(r3, r2)     // Catch:{ all -> 0x038b }
                                java.lang.String r3 = "smart_id"
                                r0.put(r3, r2)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "src"
                                java.lang.String r3 = "push"
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "imei"
                                android.content.Context r3 = r3     // Catch:{ all -> 0x038b }
                                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(r3)     // Catch:{ all -> 0x038b }
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "oaid"
                                android.content.Context r3 = r3     // Catch:{ all -> 0x022f }
                                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getOaid(r3)     // Catch:{ all -> 0x022f }
                                r0.put(r2, r3)     // Catch:{ all -> 0x022f }
                            L_0x022f:
                                java.lang.String r2 = "idfa"
                                android.content.Context r3 = r3     // Catch:{ all -> 0x023a }
                                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getIdfa(r3)     // Catch:{ all -> 0x023a }
                                r0.put(r2, r3)     // Catch:{ all -> 0x023a }
                            L_0x023a:
                                java.lang.String r2 = "android_id"
                                android.content.Context r3 = r3     // Catch:{ all -> 0x038b }
                                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(r3)     // Catch:{ all -> 0x038b }
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "pkg"
                                android.content.Context r3 = r3     // Catch:{ all -> 0x038b }
                                java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x038b }
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "app_v"
                                android.content.Context r3 = r3     // Catch:{ all -> 0x038b }
                                java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r3)     // Catch:{ all -> 0x038b }
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "board"
                                java.lang.String r3 = com.umeng.message.proguard.d.e()     // Catch:{ all -> 0x038b }
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                android.content.Context r2 = r3     // Catch:{ all -> 0x0275 }
                                java.util.Locale r2 = com.umeng.commonsdk.utils.UMUtils.getLocale(r2)     // Catch:{ all -> 0x0275 }
                                if (r2 == 0) goto L_0x0275
                                java.lang.String r3 = "os_lang"
                                java.lang.String r2 = r2.getLanguage()     // Catch:{ all -> 0x0275 }
                                r0.put(r3, r2)     // Catch:{ all -> 0x0275 }
                            L_0x0275:
                                java.lang.String r2 = "c_ts"
                                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x038b }
                                r0.put(r2, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "total"
                                r0.put(r2, r5)     // Catch:{ all -> 0x038b }
                                java.lang.String r2 = "os_i"
                                int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02a7 }
                                r0.put(r2, r3)     // Catch:{ all -> 0x02a7 }
                                java.lang.String r2 = "os_t"
                                android.content.Context r3 = r3     // Catch:{ all -> 0x02a7 }
                                android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ all -> 0x02a7 }
                                int r3 = r3.targetSdkVersion     // Catch:{ all -> 0x02a7 }
                                r0.put(r2, r3)     // Catch:{ all -> 0x02a7 }
                                java.lang.String r2 = "grant"
                                android.content.Context r3 = r3     // Catch:{ all -> 0x02a7 }
                                boolean r3 = com.umeng.message.proguard.f.f(r3)     // Catch:{ all -> 0x02a7 }
                                if (r3 == 0) goto L_0x02a3
                                r3 = 1
                                goto L_0x02a4
                            L_0x02a3:
                                r3 = 0
                            L_0x02a4:
                                r0.put(r2, r3)     // Catch:{ all -> 0x02a7 }
                            L_0x02a7:
                                java.lang.String r2 = "os"
                                java.lang.String r3 = "Android"
                                r0.put(r2, r3)     // Catch:{ all -> 0x02f8 }
                                android.content.Context r2 = r3     // Catch:{ all -> 0x02f8 }
                                java.lang.String[] r2 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(r2)     // Catch:{ all -> 0x02f8 }
                                java.lang.String r3 = "Wi-Fi"
                                r4 = 0
                                r5 = r2[r4]     // Catch:{ all -> 0x02f8 }
                                boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x02f8 }
                                java.lang.String r4 = "access"
                                if (r3 == 0) goto L_0x02c7
                                java.lang.String r3 = "wifi"
                                r0.put(r4, r3)     // Catch:{ all -> 0x02f8 }
                                goto L_0x02db
                            L_0x02c7:
                                r3 = 0
                                r5 = r2[r3]     // Catch:{ all -> 0x02f8 }
                                r3 = r22
                                boolean r5 = r3.equals(r5)     // Catch:{ all -> 0x02f8 }
                                if (r5 == 0) goto L_0x02d6
                                r0.put(r4, r3)     // Catch:{ all -> 0x02f8 }
                                goto L_0x02db
                            L_0x02d6:
                                java.lang.String r3 = "unknown"
                                r0.put(r4, r3)     // Catch:{ all -> 0x02f8 }
                            L_0x02db:
                                java.lang.String r3 = ""
                                r4 = 1
                                r5 = r2[r4]     // Catch:{ all -> 0x02f8 }
                                boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x02f8 }
                                if (r3 != 0) goto L_0x02ed
                                java.lang.String r3 = "sub_access"
                                r2 = r2[r4]     // Catch:{ all -> 0x02f8 }
                                r0.put(r3, r2)     // Catch:{ all -> 0x02f8 }
                            L_0x02ed:
                                java.lang.String r2 = "display_name"
                                android.content.Context r3 = r3     // Catch:{ all -> 0x02f8 }
                                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(r3)     // Catch:{ all -> 0x02f8 }
                                r0.put(r2, r3)     // Catch:{ all -> 0x02f8 }
                            L_0x02f8:
                                com.umeng.message.proguard.n r2 = com.umeng.message.proguard.n.this     // Catch:{ all -> 0x0360 }
                                org.json.JSONObject r2 = r2.f15985a     // Catch:{ all -> 0x0360 }
                                r3 = r21
                                java.lang.String r2 = r2.optString(r3)     // Catch:{ all -> 0x0360 }
                                java.lang.String r4 = ","
                                java.lang.String[] r2 = r2.split(r4)     // Catch:{ all -> 0x0360 }
                                org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x0360 }
                                r4.<init>()     // Catch:{ all -> 0x0360 }
                                r5 = 0
                            L_0x030e:
                                int r6 = r2.length     // Catch:{ all -> 0x0360 }
                                if (r5 >= r6) goto L_0x0319
                                r6 = r2[r5]     // Catch:{ all -> 0x0360 }
                                r4.put(r6)     // Catch:{ all -> 0x0360 }
                                int r5 = r5 + 1
                                goto L_0x030e
                            L_0x0319:
                                r0.put(r3, r4)     // Catch:{ all -> 0x0360 }
                                com.umeng.message.proguard.n r2 = com.umeng.message.proguard.n.this     // Catch:{ all -> 0x0360 }
                                org.json.JSONObject r2 = r2.f15985a     // Catch:{ all -> 0x0360 }
                                r3 = r20
                                java.lang.String r2 = r2.optString(r3)     // Catch:{ all -> 0x0360 }
                                r0.put(r3, r2)     // Catch:{ all -> 0x0360 }
                                com.umeng.message.proguard.n r2 = com.umeng.message.proguard.n.this     // Catch:{ all -> 0x0360 }
                                org.json.JSONObject r2 = r2.f15985a     // Catch:{ all -> 0x0360 }
                                r3 = r19
                                java.lang.String r2 = r2.optString(r3)     // Catch:{ all -> 0x0360 }
                                r0.put(r3, r2)     // Catch:{ all -> 0x0360 }
                                com.umeng.message.proguard.n r2 = com.umeng.message.proguard.n.this     // Catch:{ all -> 0x0360 }
                                org.json.JSONObject r2 = r2.f15985a     // Catch:{ all -> 0x0360 }
                                java.lang.String r3 = "actionName"
                                java.lang.String r2 = r2.optString(r3)     // Catch:{ all -> 0x0360 }
                                com.umeng.message.proguard.n r3 = com.umeng.message.proguard.n.this     // Catch:{ all -> 0x0360 }
                                org.json.JSONObject r3 = r3.f15985a     // Catch:{ all -> 0x0360 }
                                r4 = r18
                                java.lang.String r3 = r3.optString(r4)     // Catch:{ all -> 0x0360 }
                                boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0360 }
                                if (r5 != 0) goto L_0x0360
                                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ all -> 0x0360 }
                                r5.<init>(r3)     // Catch:{ all -> 0x0360 }
                                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0360 }
                                r3.<init>()     // Catch:{ all -> 0x0360 }
                                r3.put(r2, r5)     // Catch:{ all -> 0x0360 }
                                r0.put(r4, r3)     // Catch:{ all -> 0x0360 }
                            L_0x0360:
                                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x038b }
                                r2 = 0
                            L_0x0365:
                                boolean r3 = r1.hasNext()     // Catch:{ all -> 0x038b }
                                if (r3 == 0) goto L_0x0387
                                java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x038b }
                                org.json.JSONArray r3 = (org.json.JSONArray) r3     // Catch:{ all -> 0x038b }
                                java.lang.String r4 = "batch"
                                r5 = 1
                                int r2 = r2 + r5
                                r0.put(r4, r2)     // Catch:{ all -> 0x038b }
                                java.lang.String r4 = "apl"
                                r0.put(r4, r3)     // Catch:{ all -> 0x038b }
                                java.lang.String r3 = "https://yumao.puata.info/cc_info"
                                java.lang.String r4 = r6     // Catch:{ Exception -> 0x0385 }
                                com.umeng.message.proguard.g.b(r0, r3, r4)     // Catch:{ Exception -> 0x0385 }
                                goto L_0x0365
                            L_0x0385:
                                r0 = move-exception
                                throw r0     // Catch:{ all -> 0x038b }
                            L_0x0387:
                                com.umeng.message.proguard.f.a((java.io.Closeable) r12)
                                return
                            L_0x038b:
                                r0 = move-exception
                                goto L_0x0393
                            L_0x038d:
                                r0 = move-exception
                                r11 = r23
                                goto L_0x0393
                            L_0x0391:
                                r0 = move-exception
                                r11 = r1
                            L_0x0393:
                                r10 = r12
                                goto L_0x0397
                            L_0x0395:
                                r0 = move-exception
                                r11 = r1
                            L_0x0397:
                                java.lang.String r1 = "App2"
                                r2 = 1
                                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x03aa }
                                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x03aa }
                                r3 = 0
                                r2[r3] = r0     // Catch:{ all -> 0x03aa }
                                com.umeng.message.common.UPLog.e((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ all -> 0x03aa }
                                com.umeng.message.proguard.f.a((java.io.Closeable) r10)
                                return
                            L_0x03aa:
                                r0 = move-exception
                                com.umeng.message.proguard.f.a((java.io.Closeable) r10)
                                goto L_0x03b0
                            L_0x03af:
                                throw r0
                            L_0x03b0:
                                goto L_0x03af
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.n.AnonymousClass1.run():void");
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }
}
