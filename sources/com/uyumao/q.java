package com.uyumao;

import android.content.Context;

public final class q implements Runnable {

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f16306a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16307b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f16308c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f16309d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f16310e;

        public a(q qVar, Context context, int i10, int i11, String str, long j10) {
            this.f16306a = context;
            this.f16307b = i10;
            this.f16308c = i11;
            this.f16309d = str;
            this.f16310e = j10;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(64:53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|(2:84|85)|86|88|89|90|91|92|93|94|95|96|97|98|99|100|(3:102|103|104)|105|107|108|109|110|111|112|113|114|115|116|117|118|119|(5:122|123|124|125|120)|156|129|158) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x028a */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x0295 A[Catch:{ Exception -> 0x02af, all -> 0x02b5 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r19 = this;
                r1 = r19
                java.lang.String r0 = "p"
                r2 = 0
                java.util.TreeSet r3 = new java.util.TreeSet     // Catch:{ all -> 0x02bf }
                r3.<init>()     // Catch:{ all -> 0x02bf }
                java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x02bf }
                r4.<init>()     // Catch:{ all -> 0x02bf }
                r5 = 187(0xbb, float:2.62E-43)
                byte[] r6 = new byte[r5]     // Catch:{ all -> 0x02bb }
                r6 = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, 21, 21, 12, 40, 14, 29} // fill-array     // Catch:{ all -> 0x02bb }
                r7 = 179(0xb3, float:2.51E-43)
                byte[] r5 = java.util.Arrays.copyOfRange(r6, r7, r5)     // Catch:{ all -> 0x02bb }
                byte[] r6 = java.util.Arrays.copyOf(r6, r7)     // Catch:{ all -> 0x02bb }
                com.uyumao.e.a((byte[]) r6, (byte[]) r5)     // Catch:{ all -> 0x02bb }
                com.uyumao.e.a((byte[]) r6, (java.io.OutputStream) r4)     // Catch:{ all -> 0x02bb }
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x02bb }
                java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x02bb }
                r5.<init>(r6)     // Catch:{ all -> 0x02bb }
                java.lang.String r6 = "c"
                java.lang.String r6 = r5.optString(r6)     // Catch:{ all -> 0x02bb }
                java.lang.String r7 = r5.optString(r0)     // Catch:{ all -> 0x02bb }
                android.content.Context r8 = r1.f16306a     // Catch:{ all -> 0x02bb }
                java.lang.Object r2 = com.uyumao.t.a(r6, r7, r2, r8, r2)     // Catch:{ all -> 0x02bb }
                int r6 = r1.f16307b     // Catch:{ all -> 0x02bb }
                java.lang.String r7 = "t"
                java.lang.String r8 = "n"
                java.lang.String r9 = "a"
                java.lang.String r10 = "u"
                java.lang.String r11 = "m"
                java.lang.String r12 = "v"
                java.lang.String r13 = "i"
                r14 = 1
                if (r14 != r6) goto L_0x00d7
                java.lang.String r6 = r5.optString(r13)     // Catch:{ all -> 0x02b7 }
                java.lang.Class[] r15 = new java.lang.Class[r14]     // Catch:{ all -> 0x02b7 }
                java.lang.Class<java.lang.String> r17 = java.lang.String.class
                r16 = 0
                r15[r16] = r17     // Catch:{ all -> 0x02b7 }
                java.lang.Object[] r1 = new java.lang.Object[r14]     // Catch:{ all -> 0x02b7 }
                java.lang.String r17 = r5.optString(r9)     // Catch:{ all -> 0x02b7 }
                r1[r16] = r17     // Catch:{ all -> 0x02b7 }
                java.lang.Object r1 = com.uyumao.t.a((java.lang.String) r6, (java.lang.Class<?>[]) r15, (java.lang.Object[]) r1)     // Catch:{ all -> 0x02b7 }
                java.lang.String r6 = r5.optString(r11)     // Catch:{ all -> 0x02b7 }
                java.lang.String r11 = "q"
                java.lang.String r11 = r5.optString(r11)     // Catch:{ all -> 0x02b7 }
                r15 = 2
                java.lang.Class[] r14 = new java.lang.Class[r15]     // Catch:{ all -> 0x02b7 }
                java.lang.String r18 = r5.optString(r13)     // Catch:{ all -> 0x02b7 }
                java.lang.Class r18 = com.uyumao.t.a(r18)     // Catch:{ all -> 0x02b7 }
                r16 = 0
                r14[r16] = r18     // Catch:{ all -> 0x02b7 }
                java.lang.Class r18 = java.lang.Integer.TYPE     // Catch:{ all -> 0x02b7 }
                r17 = 1
                r14[r17] = r18     // Catch:{ all -> 0x02b7 }
                java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ all -> 0x02b7 }
                r15[r16] = r1     // Catch:{ all -> 0x02b7 }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x02b7 }
                r15[r17] = r1     // Catch:{ all -> 0x02b7 }
                java.lang.Object r1 = com.uyumao.t.a(r6, r11, r14, r2, r15)     // Catch:{ all -> 0x02b7 }
                boolean r6 = r1 instanceof java.util.List     // Catch:{ all -> 0x02b7 }
                if (r6 == 0) goto L_0x0120
                java.lang.String r6 = "r"
                java.lang.String r6 = r5.optString(r6)     // Catch:{ all -> 0x02b7 }
                java.lang.String r11 = "s"
                java.lang.String r11 = r5.optString(r11)     // Catch:{ all -> 0x02b7 }
                java.lang.reflect.Field r6 = com.uyumao.t.a((java.lang.String) r6, (java.lang.String) r11)     // Catch:{ all -> 0x02b7 }
                java.lang.String r11 = r5.optString(r7)     // Catch:{ all -> 0x02b7 }
                java.lang.String r5 = r5.optString(r8)     // Catch:{ all -> 0x02b7 }
                java.lang.reflect.Field r5 = com.uyumao.t.a((java.lang.String) r11, (java.lang.String) r5)     // Catch:{ all -> 0x02b7 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x02b7 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x02b7 }
            L_0x00bd:
                boolean r8 = r1.hasNext()     // Catch:{ all -> 0x02b7 }
                if (r8 == 0) goto L_0x0120
                java.lang.Object r8 = r1.next()     // Catch:{ all -> 0x02b7 }
                java.lang.Object r8 = com.uyumao.t.a((java.lang.reflect.Field) r6, (java.lang.Object) r8)     // Catch:{ all -> 0x02b7 }
                java.lang.Object r8 = com.uyumao.t.a((java.lang.reflect.Field) r5, (java.lang.Object) r8)     // Catch:{ all -> 0x02b7 }
                if (r8 == 0) goto L_0x00bd
                java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x02b7 }
                r3.add(r8)     // Catch:{ all -> 0x02b7 }
                goto L_0x00bd
            L_0x00d7:
                java.lang.String r1 = r5.optString(r11)     // Catch:{ all -> 0x02b7 }
                java.lang.String r6 = r5.optString(r10)     // Catch:{ all -> 0x02b7 }
                r11 = 1
                java.lang.Class[] r14 = new java.lang.Class[r11]     // Catch:{ all -> 0x02b7 }
                java.lang.Class r15 = java.lang.Integer.TYPE     // Catch:{ all -> 0x02b7 }
                r16 = 0
                r14[r16] = r15     // Catch:{ all -> 0x02b7 }
                java.lang.Object[] r15 = new java.lang.Object[r11]     // Catch:{ all -> 0x02b7 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x02b7 }
                r15[r16] = r11     // Catch:{ all -> 0x02b7 }
                java.lang.Object r1 = com.uyumao.t.a(r1, r6, r14, r2, r15)     // Catch:{ all -> 0x02b7 }
                boolean r6 = r1 instanceof java.util.List     // Catch:{ all -> 0x02b7 }
                if (r6 == 0) goto L_0x0120
                java.lang.String r6 = r5.optString(r12)     // Catch:{ all -> 0x02b7 }
                java.lang.String r5 = r5.optString(r8)     // Catch:{ all -> 0x02b7 }
                java.lang.reflect.Field r5 = com.uyumao.t.a((java.lang.String) r6, (java.lang.String) r5)     // Catch:{ all -> 0x02b7 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x02b7 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x02b7 }
            L_0x010a:
                boolean r6 = r1.hasNext()     // Catch:{ all -> 0x02b7 }
                if (r6 == 0) goto L_0x0120
                java.lang.Object r6 = r1.next()     // Catch:{ all -> 0x02b7 }
                java.lang.Object r6 = com.uyumao.t.a((java.lang.reflect.Field) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x02b7 }
                if (r6 == 0) goto L_0x010a
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x02b7 }
                r3.add(r6)     // Catch:{ all -> 0x02b7 }
                goto L_0x010a
            L_0x0120:
                boolean r1 = r3.isEmpty()     // Catch:{ all -> 0x02b7 }
                if (r1 == 0) goto L_0x012a
                com.uyumao.n.a((java.io.Closeable) r4)
                return
            L_0x012a:
                if (r2 != 0) goto L_0x0130
                com.uyumao.n.a((java.io.Closeable) r4)
                return
            L_0x0130:
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x02b7 }
                r1.<init>()     // Catch:{ all -> 0x02b7 }
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ all -> 0x02b7 }
                r5.<init>()     // Catch:{ all -> 0x02b7 }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x02b7 }
                r6 = 0
            L_0x013f:
                boolean r8 = r3.hasNext()     // Catch:{ all -> 0x02b7 }
                if (r8 == 0) goto L_0x0195
                java.lang.Object r8 = r3.next()     // Catch:{ all -> 0x02b7 }
                java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x02b7 }
                r11 = 0
                java.lang.Object r8 = com.uyumao.n.a(r2, r8, r11)     // Catch:{ all -> 0x02b7 }
                if (r8 != 0) goto L_0x0153
                goto L_0x013f
            L_0x0153:
                com.uyumao.p r14 = new com.uyumao.p     // Catch:{ all -> 0x02b7 }
                r14.<init>(r2, r8)     // Catch:{ all -> 0x02b7 }
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x02b7 }
                r8.<init>()     // Catch:{ all -> 0x02b7 }
                java.lang.String r15 = r14.f16301b     // Catch:{ all -> 0x02b7 }
                r8.put(r9, r15)     // Catch:{ all -> 0x02b7 }
                java.lang.String r15 = r14.f16300a     // Catch:{ all -> 0x02b7 }
                r8.put(r0, r15)     // Catch:{ all -> 0x02b7 }
                java.lang.String r15 = r14.f16302c     // Catch:{ all -> 0x02b7 }
                r8.put(r12, r15)     // Catch:{ all -> 0x02b7 }
                int r15 = r14.f16305f     // Catch:{ all -> 0x02b7 }
                r8.put(r7, r15)     // Catch:{ all -> 0x02b7 }
                r15 = r12
                long r11 = r14.f16303d     // Catch:{ all -> 0x02b7 }
                r8.put(r13, r11)     // Catch:{ all -> 0x02b7 }
                long r11 = r14.f16304e     // Catch:{ all -> 0x02b7 }
                r8.put(r10, r11)     // Catch:{ all -> 0x02b7 }
                r5.put(r8)     // Catch:{ all -> 0x02b7 }
                int r6 = r6 + 1
                int r8 = r5.length()     // Catch:{ all -> 0x02b7 }
                r11 = r19
                int r12 = r11.f16308c     // Catch:{ all -> 0x02b5 }
                if (r8 != r12) goto L_0x0193
                r1.add(r5)     // Catch:{ all -> 0x02b5 }
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ all -> 0x02b5 }
                r5.<init>()     // Catch:{ all -> 0x02b5 }
            L_0x0193:
                r12 = r15
                goto L_0x013f
            L_0x0195:
                r11 = r19
                r15 = r12
                int r0 = r5.length()     // Catch:{ all -> 0x02b5 }
                if (r0 <= 0) goto L_0x01a1
                r1.add(r5)     // Catch:{ all -> 0x02b5 }
            L_0x01a1:
                boolean r0 = r1.isEmpty()     // Catch:{ all -> 0x02b5 }
                if (r0 == 0) goto L_0x01ab
                com.uyumao.n.a((java.io.Closeable) r4)
                return
            L_0x01ab:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x02b5 }
                r0.<init>()     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "zid"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x02b5 }
                java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getZid(r3)     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "appkey"
                java.lang.String r3 = r11.f16309d     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "umid"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x02b5 }
                java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getUMId(r3)     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "2.0"
                r3 = r15
                r0.put(r3, r2)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "sdk_v"
                java.lang.String r3 = "1.1.4"
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "os_v"
                java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "brand"
                java.lang.String r3 = com.uyumao.n.b()     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "model"
                java.lang.String r3 = com.uyumao.n.c()     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "smart_id"
                long r7 = r11.f16310e     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r7)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "src"
                java.lang.String r3 = "risk"
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "imei"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x02b5 }
                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(r3)     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "oaid"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x0217 }
                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getOaid(r3)     // Catch:{ all -> 0x0217 }
                r0.put(r2, r3)     // Catch:{ all -> 0x0217 }
            L_0x0217:
                java.lang.String r2 = "idfa"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x0222 }
                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getIdfa(r3)     // Catch:{ all -> 0x0222 }
                r0.put(r2, r3)     // Catch:{ all -> 0x0222 }
            L_0x0222:
                java.lang.String r2 = "android_id"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x02b5 }
                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(r3)     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "pkg"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x02b5 }
                java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "app_v"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x02b5 }
                java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r3)     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "board"
                java.lang.String r3 = com.uyumao.n.a()     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r3)     // Catch:{ all -> 0x02b5 }
                android.content.Context r2 = r11.f16306a     // Catch:{ all -> 0x025d }
                java.util.Locale r2 = com.umeng.commonsdk.utils.UMUtils.getLocale(r2)     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x025d
                java.lang.String r3 = "os_lang"
                java.lang.String r2 = r2.getLanguage()     // Catch:{ all -> 0x025d }
                r0.put(r3, r2)     // Catch:{ all -> 0x025d }
            L_0x025d:
                java.lang.String r2 = "c_ts"
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b5 }
                r0.put(r2, r7)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "total"
                r0.put(r2, r6)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "os_i"
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x028a }
                r0.put(r2, r3)     // Catch:{ all -> 0x028a }
                java.lang.String r2 = "os_t"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x028a }
                android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ all -> 0x028a }
                int r3 = r3.targetSdkVersion     // Catch:{ all -> 0x028a }
                r0.put(r2, r3)     // Catch:{ all -> 0x028a }
                java.lang.String r2 = "grant"
                android.content.Context r3 = r11.f16306a     // Catch:{ all -> 0x028a }
                boolean r3 = com.uyumao.n.a((android.content.Context) r3)     // Catch:{ all -> 0x028a }
                r0.put(r2, r3)     // Catch:{ all -> 0x028a }
            L_0x028a:
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x02b5 }
                r15 = 0
            L_0x028f:
                boolean r2 = r1.hasNext()     // Catch:{ all -> 0x02b5 }
                if (r2 == 0) goto L_0x02b1
                java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x02b5 }
                org.json.JSONArray r2 = (org.json.JSONArray) r2     // Catch:{ all -> 0x02b5 }
                r3 = 1
                int r15 = r15 + r3
                java.lang.String r5 = "batch"
                r0.put(r5, r15)     // Catch:{ all -> 0x02b5 }
                java.lang.String r5 = "data"
                r0.put(r5, r2)     // Catch:{ all -> 0x02b5 }
                java.lang.String r2 = "https://sss.umeng.com/api/v2/al"
                java.lang.String r5 = r11.f16309d     // Catch:{ Exception -> 0x02af }
                com.uyumao.e.a((org.json.JSONObject) r0, (java.lang.String) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x02af }
                goto L_0x028f
            L_0x02af:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x02b5 }
            L_0x02b1:
                com.uyumao.n.a((java.io.Closeable) r4)
                goto L_0x02c7
            L_0x02b5:
                r0 = move-exception
                goto L_0x02bd
            L_0x02b7:
                r0 = move-exception
                r11 = r19
                goto L_0x02bd
            L_0x02bb:
                r0 = move-exception
                r11 = r1
            L_0x02bd:
                r2 = r4
                goto L_0x02c1
            L_0x02bf:
                r0 = move-exception
                r11 = r1
            L_0x02c1:
                r0.getMessage()     // Catch:{ all -> 0x02c8 }
                com.uyumao.n.a((java.io.Closeable) r2)
            L_0x02c7:
                return
            L_0x02c8:
                r0 = move-exception
                r1 = r0
                com.uyumao.n.a((java.io.Closeable) r2)
                goto L_0x02cf
            L_0x02ce:
                throw r1
            L_0x02cf:
                goto L_0x02ce
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uyumao.q.a.run():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            android.content.Context r0 = com.uyumao.e.f16271a
            com.uyumao.o r1 = com.uyumao.o.f16296a
            if (r1 != 0) goto L_0x0019
            java.lang.Class<com.uyumao.o> r1 = com.uyumao.o.class
            monitor-enter(r1)
            com.uyumao.o r2 = com.uyumao.o.f16296a     // Catch:{ all -> 0x0016 }
            if (r2 != 0) goto L_0x0014
            com.uyumao.o r2 = new com.uyumao.o     // Catch:{ all -> 0x0016 }
            r2.<init>(r0)     // Catch:{ all -> 0x0016 }
            com.uyumao.o.f16296a = r2     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            goto L_0x0019
        L_0x0016:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            throw r0
        L_0x0019:
            com.uyumao.o r0 = com.uyumao.o.f16296a
            android.content.Context r1 = r0.f16297b
            boolean r1 = com.uyumao.n.c(r1)
            if (r1 != 0) goto L_0x0024
            goto L_0x0032
        L_0x0024:
            long r1 = r0.a()
            com.uyumao.o$a r3 = r0.f16298c
            r4 = 1
            long r1 = r1 + r4
            java.lang.String r4 = "smart_lc"
            r3.b(r4, r1)
        L_0x0032:
            com.uyumao.o$a r1 = r0.f16298c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = r1.f16299a
            r2.append(r1)
            java.lang.String r1 = "smart_lt"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 0
            java.lang.String r3 = java.lang.String.valueOf(r2)
            android.content.Context r4 = com.uyumao.e.f16271a     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            boolean r4 = com.uyumao.n.c(r4)     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            if (r4 == 0) goto L_0x0065
            com.uyumao.m r4 = com.uyumao.m.a()     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            android.content.SharedPreferences r4 = r4.f16291b     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            java.lang.String r3 = r4.getString(r1, r3)     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            goto L_0x0065
        L_0x005f:
            r0 = move-exception
            throw r0
        L_0x0061:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0065:
            int r1 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x006a }
            goto L_0x006c
        L_0x006a:
            r1 = 0
        L_0x006c:
            long r3 = r0.a()
            long r5 = (long) r1
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x0076
            return
        L_0x0076:
            java.lang.String r1 = "smart_"
            boolean r1 = r0.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x007f
            return
        L_0x007f:
            android.content.Context r5 = com.uyumao.e.f16271a     // Catch:{ all -> 0x01a5 }
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r5)     // Catch:{ all -> 0x01a5 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x01a5 }
            r1.<init>()     // Catch:{ all -> 0x01a5 }
            java.lang.String r3 = "zid"
            java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getZid(r5)     // Catch:{ all -> 0x01a5 }
            r1.put(r3, r4)     // Catch:{ all -> 0x01a5 }
            java.lang.String r3 = "imei"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(r5)     // Catch:{ all -> 0x00a5 }
            r1.put(r3, r4)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "oaid"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getOaid(r5)     // Catch:{ all -> 0x00a5 }
            r1.put(r3, r4)     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            java.lang.String r3 = "idfa"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getIdfa(r5)     // Catch:{ all -> 0x00ae }
            r1.put(r3, r4)     // Catch:{ all -> 0x00ae }
        L_0x00ae:
            java.lang.String r3 = "umid"
            java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getUMId(r5)     // Catch:{ all -> 0x01a5 }
            r1.put(r3, r4)     // Catch:{ all -> 0x01a5 }
            java.lang.String r3 = "android_id"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(r5)     // Catch:{ all -> 0x01a5 }
            r1.put(r3, r4)     // Catch:{ all -> 0x01a5 }
            java.lang.String r3 = "sdk_v"
            java.lang.String r4 = "1.1.4"
            r1.put(r3, r4)     // Catch:{ all -> 0x01a5 }
            java.lang.String r3 = "os_v"
            java.lang.String r4 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x01a5 }
            r1.put(r3, r4)     // Catch:{ all -> 0x01a5 }
            java.lang.String r3 = "lvl"
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01a5 }
            r1.put(r3, r4)     // Catch:{ all -> 0x01a5 }
            java.lang.String[] r3 = com.umeng.commonsdk.utils.UMUtils.getNetworkAccessMode(r5)     // Catch:{ all -> 0x01a5 }
            r4 = r3[r2]     // Catch:{ all -> 0x01a5 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01a5 }
            if (r4 == 0) goto L_0x00e5
            java.lang.String r4 = "Unknown"
            r3[r2] = r4     // Catch:{ all -> 0x01a5 }
        L_0x00e5:
            java.lang.String r4 = "net"
            r3 = r3[r2]     // Catch:{ all -> 0x01a5 }
            r1.put(r4, r3)     // Catch:{ all -> 0x01a5 }
            java.lang.String r3 = "brand"
            java.lang.String r4 = com.uyumao.n.b()     // Catch:{ all -> 0x01a5 }
            r1.put(r3, r4)     // Catch:{ all -> 0x01a5 }
            com.uyumao.o$a r3 = r0.f16298c     // Catch:{ all -> 0x01a5 }
            java.lang.String r4 = "smart_ts"
            r6 = 0
            long r3 = r3.a((java.lang.String) r4, (long) r6)     // Catch:{ all -> 0x01a5 }
            int r9 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x0108
            java.lang.String r9 = "last"
            r1.put(r9, r3)     // Catch:{ all -> 0x01a5 }
        L_0x0108:
            java.lang.String r3 = "https://ccs.umeng.com/ra"
            org.json.JSONObject r1 = com.uyumao.e.a(r1, r3, r8, r2)     // Catch:{ Exception -> 0x010f }
            goto L_0x0110
        L_0x010f:
            r1 = 0
        L_0x0110:
            r2 = 7200(0x1c20, double:3.5573E-320)
            if (r1 != 0) goto L_0x0118
            r0.a((long) r2)     // Catch:{ all -> 0x01a5 }
            return
        L_0x0118:
            java.lang.String r4 = "data"
            org.json.JSONObject r1 = r1.optJSONObject(r4)     // Catch:{ all -> 0x01a5 }
            if (r1 != 0) goto L_0x0124
            r0.a((long) r2)     // Catch:{ all -> 0x01a5 }
            return
        L_0x0124:
            java.lang.String r2 = "aa"
            org.json.JSONObject r2 = r1.optJSONObject(r2)     // Catch:{ all -> 0x01a5 }
            if (r2 != 0) goto L_0x0131
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x01a5 }
            r2.<init>()     // Catch:{ all -> 0x01a5 }
        L_0x0131:
            java.lang.String r3 = "launch"
            r4 = 5
            int r3 = r2.optInt(r3, r4)     // Catch:{ all -> 0x01a5 }
            com.uyumao.o$a r4 = r0.f16298c     // Catch:{ all -> 0x01a5 }
            java.lang.String r9 = "smart_lt"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a5 }
            r10.<init>()     // Catch:{ all -> 0x01a5 }
            java.lang.String r11 = r4.f16299a     // Catch:{ all -> 0x01a5 }
            r10.append(r11)     // Catch:{ all -> 0x01a5 }
            r10.append(r9)     // Catch:{ all -> 0x01a5 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x01a5 }
            java.lang.String r10 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x01a5 }
            r4.a((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ all -> 0x01a5 }
            long r9 = r0.a()     // Catch:{ all -> 0x01a5 }
            long r3 = (long) r3     // Catch:{ all -> 0x01a5 }
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x015e
            return
        L_0x015e:
            java.lang.String r3 = "ttl"
            r9 = 86400(0x15180, double:4.26873E-319)
            long r3 = r1.optLong(r3, r9)     // Catch:{ all -> 0x01a5 }
            r0.a((long) r3)     // Catch:{ all -> 0x01a5 }
            java.lang.String r0 = "id"
            r3 = -1
            long r9 = r1.optLong(r0, r3)     // Catch:{ all -> 0x01a5 }
            int r0 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x0177
            return
        L_0x0177:
            java.lang.String r0 = "batch"
            r1 = 300(0x12c, float:4.2E-43)
            int r0 = r2.optInt(r0, r1)     // Catch:{ all -> 0x01a5 }
            r1 = 100
            int r7 = java.lang.Math.max(r0, r1)     // Catch:{ all -> 0x01a5 }
            java.lang.String r0 = "action"
            r1 = 1
            int r6 = r2.optInt(r0, r1)     // Catch:{ all -> 0x01a5 }
            java.lang.String r0 = "delay"
            int r0 = r2.optInt(r0)     // Catch:{ all -> 0x01a5 }
            if (r6 == r1) goto L_0x0198
            r1 = 2
            if (r6 == r1) goto L_0x0198
            return
        L_0x0198:
            com.uyumao.q$a r1 = new com.uyumao.q$a     // Catch:{ all -> 0x01a5 }
            r3 = r1
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x01a5 }
            long r2 = (long) r0     // Catch:{ all -> 0x01a5 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x01a5 }
            com.uyumao.s.a(r1, r2, r0)     // Catch:{ all -> 0x01a5 }
        L_0x01a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.q.run():void");
    }
}
