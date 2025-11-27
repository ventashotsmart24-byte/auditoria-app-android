package com.uyumao;

import android.content.Context;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f16311a;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f16312a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16313b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f16314c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f16315d;

        public a(Context context, int i10, int i11, String str) {
            this.f16312a = context;
            this.f16313b = i10;
            this.f16314c = i11;
            this.f16315d = str;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(72:53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|(2:81|82)|83|85|86|87|88|89|90|91|92|93|94|95|(3:96|97|(3:99|100|101))|102|104|105|106|(8:107|108|109|110|111|112|113|114)|115|117|118|119|120|121|122|(4:124|125|126|127)(4:128|129|130|(1:132)(1:133))|134|135|136|(3:138|139|140)|141|142|143|146|147|(2:150|148)|193|151|152|153|(8:156|157|158|159|160|161|162|154)|194|166|196) */
        /* JADX WARNING: Can't wrap try/catch for region: R(82:53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|(3:99|100|101)|102|104|105|106|107|108|109|110|111|112|113|114|115|117|118|119|120|121|122|(4:124|125|126|127)(4:128|129|130|(1:132)(1:133))|134|135|136|(3:138|139|140)|141|142|143|146|147|(2:150|148)|193|151|152|153|(8:156|157|158|159|160|161|162|154)|194|166|196) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:146:0x0300 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:152:0x036c */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x031b A[Catch:{ all -> 0x036c }, LOOP:3: B:148:0x0318->B:150:0x031b, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:156:0x037b A[Catch:{ Exception -> 0x03a3, all -> 0x03a9 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r24 = this;
                r1 = r24
                java.lang.String r0 = "forbid_sdk"
                java.lang.String r2 = "local_hit_sdk"
                java.lang.String r3 = "hit_sdk"
                java.lang.String r4 = "2G/3G"
                java.lang.String r5 = "sdk"
                java.lang.String r6 = "p"
                r7 = 0
                java.util.TreeSet r8 = new java.util.TreeSet     // Catch:{ all -> 0x03b3 }
                r8.<init>()     // Catch:{ all -> 0x03b3 }
                java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x03b3 }
                r9.<init>()     // Catch:{ all -> 0x03b3 }
                r10 = 187(0xbb, float:2.62E-43)
                byte[] r11 = new byte[r10]     // Catch:{ all -> 0x03af }
                r11 = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, 21, 21, 12, 40, 14, 29} // fill-array     // Catch:{ all -> 0x03af }
                r12 = 179(0xb3, float:2.51E-43)
                byte[] r10 = java.util.Arrays.copyOfRange(r11, r12, r10)     // Catch:{ all -> 0x03af }
                byte[] r11 = java.util.Arrays.copyOf(r11, r12)     // Catch:{ all -> 0x03af }
                com.uyumao.e.a((byte[]) r11, (byte[]) r10)     // Catch:{ all -> 0x03af }
                com.uyumao.e.a((byte[]) r11, (java.io.OutputStream) r9)     // Catch:{ all -> 0x03af }
                org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x03af }
                java.lang.String r11 = r9.toString()     // Catch:{ all -> 0x03af }
                r10.<init>(r11)     // Catch:{ all -> 0x03af }
                java.lang.String r11 = "c"
                java.lang.String r11 = r10.optString(r11)     // Catch:{ all -> 0x03af }
                java.lang.String r12 = r10.optString(r6)     // Catch:{ all -> 0x03af }
                android.content.Context r13 = r1.f16312a     // Catch:{ all -> 0x03af }
                java.lang.Object r7 = com.uyumao.t.a(r11, r12, r7, r13, r7)     // Catch:{ all -> 0x03af }
                int r11 = r1.f16313b     // Catch:{ all -> 0x03af }
                java.lang.String r12 = "t"
                java.lang.String r13 = "n"
                java.lang.String r14 = "a"
                java.lang.String r15 = "u"
                r16 = r0
                java.lang.String r0 = "m"
                r17 = r2
                java.lang.String r2 = "v"
                r18 = r3
                java.lang.String r3 = "i"
                r19 = r5
                r5 = 1
                r20 = r4
                if (r5 != r11) goto L_0x00eb
                java.lang.String r11 = r10.optString(r3)     // Catch:{ all -> 0x03ab }
                java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{ all -> 0x03ab }
                java.lang.Class<java.lang.String> r22 = java.lang.String.class
                r21 = 0
                r4[r21] = r22     // Catch:{ all -> 0x03ab }
                java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ all -> 0x03ab }
                java.lang.String r22 = r10.optString(r14)     // Catch:{ all -> 0x03ab }
                r1[r21] = r22     // Catch:{ all -> 0x03ab }
                java.lang.Object r1 = com.uyumao.t.a((java.lang.String) r11, (java.lang.Class<?>[]) r4, (java.lang.Object[]) r1)     // Catch:{ all -> 0x03ab }
                java.lang.String r0 = r10.optString(r0)     // Catch:{ all -> 0x03ab }
                java.lang.String r4 = "q"
                java.lang.String r4 = r10.optString(r4)     // Catch:{ all -> 0x03ab }
                r11 = 2
                java.lang.Class[] r5 = new java.lang.Class[r11]     // Catch:{ all -> 0x03ab }
                java.lang.String r23 = r10.optString(r3)     // Catch:{ all -> 0x03ab }
                java.lang.Class r23 = com.uyumao.t.a(r23)     // Catch:{ all -> 0x03ab }
                r21 = 0
                r5[r21] = r23     // Catch:{ all -> 0x03ab }
                java.lang.Class r23 = java.lang.Integer.TYPE     // Catch:{ all -> 0x03ab }
                r22 = 1
                r5[r22] = r23     // Catch:{ all -> 0x03ab }
                java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x03ab }
                r11[r21] = r1     // Catch:{ all -> 0x03ab }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r21)     // Catch:{ all -> 0x03ab }
                r11[r22] = r1     // Catch:{ all -> 0x03ab }
                java.lang.Object r0 = com.uyumao.t.a(r0, r4, r5, r7, r11)     // Catch:{ all -> 0x03ab }
                boolean r1 = r0 instanceof java.util.List     // Catch:{ all -> 0x03ab }
                if (r1 == 0) goto L_0x0134
                java.lang.String r1 = "r"
                java.lang.String r1 = r10.optString(r1)     // Catch:{ all -> 0x03ab }
                java.lang.String r4 = "s"
                java.lang.String r4 = r10.optString(r4)     // Catch:{ all -> 0x03ab }
                java.lang.reflect.Field r1 = com.uyumao.t.a((java.lang.String) r1, (java.lang.String) r4)     // Catch:{ all -> 0x03ab }
                java.lang.String r4 = r10.optString(r12)     // Catch:{ all -> 0x03ab }
                java.lang.String r5 = r10.optString(r13)     // Catch:{ all -> 0x03ab }
                java.lang.reflect.Field r4 = com.uyumao.t.a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x03ab }
                java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x03ab }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x03ab }
            L_0x00d1:
                boolean r5 = r0.hasNext()     // Catch:{ all -> 0x03ab }
                if (r5 == 0) goto L_0x0134
                java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x03ab }
                java.lang.Object r5 = com.uyumao.t.a((java.lang.reflect.Field) r1, (java.lang.Object) r5)     // Catch:{ all -> 0x03ab }
                java.lang.Object r5 = com.uyumao.t.a((java.lang.reflect.Field) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x03ab }
                if (r5 == 0) goto L_0x00d1
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x03ab }
                r8.add(r5)     // Catch:{ all -> 0x03ab }
                goto L_0x00d1
            L_0x00eb:
                java.lang.String r0 = r10.optString(r0)     // Catch:{ all -> 0x03ab }
                java.lang.String r1 = r10.optString(r15)     // Catch:{ all -> 0x03ab }
                r4 = 1
                java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x03ab }
                java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ all -> 0x03ab }
                r21 = 0
                r5[r21] = r11     // Catch:{ all -> 0x03ab }
                java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x03ab }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r21)     // Catch:{ all -> 0x03ab }
                r11[r21] = r4     // Catch:{ all -> 0x03ab }
                java.lang.Object r0 = com.uyumao.t.a(r0, r1, r5, r7, r11)     // Catch:{ all -> 0x03ab }
                boolean r1 = r0 instanceof java.util.List     // Catch:{ all -> 0x03ab }
                if (r1 == 0) goto L_0x0134
                java.lang.String r1 = r10.optString(r2)     // Catch:{ all -> 0x03ab }
                java.lang.String r4 = r10.optString(r13)     // Catch:{ all -> 0x03ab }
                java.lang.reflect.Field r1 = com.uyumao.t.a((java.lang.String) r1, (java.lang.String) r4)     // Catch:{ all -> 0x03ab }
                java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x03ab }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x03ab }
            L_0x011e:
                boolean r4 = r0.hasNext()     // Catch:{ all -> 0x03ab }
                if (r4 == 0) goto L_0x0134
                java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x03ab }
                java.lang.Object r4 = com.uyumao.t.a((java.lang.reflect.Field) r1, (java.lang.Object) r4)     // Catch:{ all -> 0x03ab }
                if (r4 == 0) goto L_0x011e
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x03ab }
                r8.add(r4)     // Catch:{ all -> 0x03ab }
                goto L_0x011e
            L_0x0134:
                boolean r0 = r8.isEmpty()     // Catch:{ all -> 0x03ab }
                if (r0 == 0) goto L_0x013e
                com.uyumao.n.a((java.io.Closeable) r9)
                return
            L_0x013e:
                if (r7 != 0) goto L_0x0144
                com.uyumao.n.a((java.io.Closeable) r9)
                return
            L_0x0144:
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x03ab }
                r0.<init>()     // Catch:{ all -> 0x03ab }
                org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x03ab }
                r1.<init>()     // Catch:{ all -> 0x03ab }
                java.util.Iterator r4 = r8.iterator()     // Catch:{ all -> 0x03ab }
                r5 = 0
            L_0x0153:
                boolean r8 = r4.hasNext()     // Catch:{ all -> 0x03ab }
                if (r8 == 0) goto L_0x01ab
                java.lang.Object r8 = r4.next()     // Catch:{ all -> 0x03ab }
                java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x03ab }
                r10 = 0
                java.lang.Object r8 = com.uyumao.n.a(r7, r8, r10)     // Catch:{ all -> 0x03ab }
                if (r8 != 0) goto L_0x0167
                goto L_0x0153
            L_0x0167:
                com.uyumao.p r10 = new com.uyumao.p     // Catch:{ all -> 0x03ab }
                r10.<init>(r7, r8)     // Catch:{ all -> 0x03ab }
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x03ab }
                r8.<init>()     // Catch:{ all -> 0x03ab }
                java.lang.String r11 = r10.f16301b     // Catch:{ all -> 0x03ab }
                r8.put(r14, r11)     // Catch:{ all -> 0x03ab }
                java.lang.String r11 = r10.f16300a     // Catch:{ all -> 0x03ab }
                r8.put(r6, r11)     // Catch:{ all -> 0x03ab }
                java.lang.String r11 = r10.f16302c     // Catch:{ all -> 0x03ab }
                r8.put(r2, r11)     // Catch:{ all -> 0x03ab }
                int r11 = r10.f16305f     // Catch:{ all -> 0x03ab }
                r8.put(r12, r11)     // Catch:{ all -> 0x03ab }
                r11 = r6
                r13 = r7
                long r6 = r10.f16303d     // Catch:{ all -> 0x03ab }
                r8.put(r3, r6)     // Catch:{ all -> 0x03ab }
                long r6 = r10.f16304e     // Catch:{ all -> 0x03ab }
                r8.put(r15, r6)     // Catch:{ all -> 0x03ab }
                r1.put(r8)     // Catch:{ all -> 0x03ab }
                int r5 = r5 + 1
                int r6 = r1.length()     // Catch:{ all -> 0x03ab }
                r8 = r24
                int r7 = r8.f16314c     // Catch:{ all -> 0x03a9 }
                if (r6 != r7) goto L_0x01a8
                r0.add(r1)     // Catch:{ all -> 0x03a9 }
                org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x03a9 }
                r1.<init>()     // Catch:{ all -> 0x03a9 }
            L_0x01a8:
                r6 = r11
                r7 = r13
                goto L_0x0153
            L_0x01ab:
                r8 = r24
                int r3 = r1.length()     // Catch:{ all -> 0x03a9 }
                if (r3 <= 0) goto L_0x01b6
                r0.add(r1)     // Catch:{ all -> 0x03a9 }
            L_0x01b6:
                boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x03a9 }
                if (r1 == 0) goto L_0x01c0
                com.uyumao.n.a((java.io.Closeable) r9)
                return
            L_0x01c0:
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x03a9 }
                r1.<init>()     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = "zid"
                android.content.Context r4 = r8.f16312a     // Catch:{ all -> 0x03a9 }
                java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getZid(r4)     // Catch:{ all -> 0x03a9 }
                r1.put(r3, r4)     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = "appkey"
                java.lang.String r4 = r8.f16315d     // Catch:{ all -> 0x03a9 }
                r1.put(r3, r4)     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = "umid"
                android.content.Context r4 = r8.f16312a     // Catch:{ all -> 0x03a9 }
                java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getUMId(r4)     // Catch:{ all -> 0x03a9 }
                r1.put(r3, r4)     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = "3.0"
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "sdk_v"
                java.lang.String r3 = "1.1.4"
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "os_v"
                java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x03a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "brand"
                java.lang.String r3 = com.uyumao.n.b()     // Catch:{ all -> 0x03a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "model"
                java.lang.String r3 = com.uyumao.n.c()     // Catch:{ all -> 0x03a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = "uuid"
                r1.put(r3, r2)     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = "smart_id"
                r1.put(r3, r2)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "src"
                java.lang.String r3 = "risk"
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "imei"
                android.content.Context r3 = r8.f16312a     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(r3)     // Catch:{ all -> 0x03a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "oaid"
                android.content.Context r3 = r8.f16312a     // Catch:{ all -> 0x0236 }
                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getOaid(r3)     // Catch:{ all -> 0x0236 }
                r1.put(r2, r3)     // Catch:{ all -> 0x0236 }
            L_0x0236:
                java.lang.String r2 = "idfa"
                android.content.Context r3 = r8.f16312a     // Catch:{ all -> 0x0241 }
                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getIdfa(r3)     // Catch:{ all -> 0x0241 }
                r1.put(r2, r3)     // Catch:{ all -> 0x0241 }
            L_0x0241:
                java.lang.String r2 = "android_id"
                android.content.Context r3 = r8.f16312a     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(r3)     // Catch:{ all -> 0x03a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "pkg"
                android.content.Context r3 = r8.f16312a     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x03a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "app_v"
                android.content.Context r3 = r8.f16312a     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r3)     // Catch:{ all -> 0x03a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "board"
                java.lang.String r3 = com.uyumao.n.a()     // Catch:{ all -> 0x03a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                android.content.Context r2 = r8.f16312a     // Catch:{ all -> 0x027c }
                java.util.Locale r2 = com.umeng.commonsdk.utils.UMUtils.getLocale(r2)     // Catch:{ all -> 0x027c }
                if (r2 == 0) goto L_0x027c
                java.lang.String r3 = "os_lang"
                java.lang.String r2 = r2.getLanguage()     // Catch:{ all -> 0x027c }
                r1.put(r3, r2)     // Catch:{ all -> 0x027c }
            L_0x027c:
                java.lang.String r2 = "c_ts"
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x03a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "total"
                r1.put(r2, r5)     // Catch:{ all -> 0x03a9 }
                java.lang.String r2 = "os_i"
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x02a9 }
                java.lang.String r2 = "os_t"
                android.content.Context r3 = r8.f16312a     // Catch:{ all -> 0x02a9 }
                android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ all -> 0x02a9 }
                int r3 = r3.targetSdkVersion     // Catch:{ all -> 0x02a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x02a9 }
                java.lang.String r2 = "grant"
                android.content.Context r3 = r8.f16312a     // Catch:{ all -> 0x02a9 }
                boolean r3 = com.uyumao.n.a((android.content.Context) r3)     // Catch:{ all -> 0x02a9 }
                r1.put(r2, r3)     // Catch:{ all -> 0x02a9 }
            L_0x02a9:
                java.lang.String r2 = "os"
                java.lang.String r3 = "Android"
                r1.put(r2, r3)     // Catch:{ all -> 0x02fe }
                android.content.Context r2 = r8.f16312a     // Catch:{ all -> 0x02fe }
                java.lang.String[] r2 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(r2)     // Catch:{ all -> 0x02fe }
                java.lang.String r3 = "Wi-Fi"
                r4 = 0
                r5 = r2[r4]     // Catch:{ all -> 0x02fe }
                boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x02fe }
                java.lang.String r4 = "access"
                if (r3 == 0) goto L_0x02cb
                java.lang.String r3 = "wifi"
                r1.put(r4, r3)     // Catch:{ all -> 0x02fe }
                r21 = 0
                goto L_0x02e0
            L_0x02cb:
                r21 = 0
                r3 = r2[r21]     // Catch:{ all -> 0x0300 }
                r5 = r20
                boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x0300 }
                if (r3 == 0) goto L_0x02db
                r1.put(r4, r5)     // Catch:{ all -> 0x0300 }
                goto L_0x02e0
            L_0x02db:
                java.lang.String r3 = "unknown"
                r1.put(r4, r3)     // Catch:{ all -> 0x0300 }
            L_0x02e0:
                java.lang.String r3 = ""
                r4 = 1
                r5 = r2[r4]     // Catch:{ all -> 0x0300 }
                boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0300 }
                if (r3 != 0) goto L_0x02f2
                java.lang.String r3 = "sub_access"
                r2 = r2[r4]     // Catch:{ all -> 0x0300 }
                r1.put(r3, r2)     // Catch:{ all -> 0x0300 }
            L_0x02f2:
                java.lang.String r2 = "display_name"
                android.content.Context r3 = r8.f16312a     // Catch:{ all -> 0x0300 }
                java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(r3)     // Catch:{ all -> 0x0300 }
                r1.put(r2, r3)     // Catch:{ all -> 0x0300 }
                goto L_0x0300
            L_0x02fe:
                r21 = 0
            L_0x0300:
                com.uyumao.r r2 = com.uyumao.r.this     // Catch:{ all -> 0x036c }
                org.json.JSONObject r2 = r2.f16311a     // Catch:{ all -> 0x036c }
                r3 = r19
                java.lang.String r2 = r2.optString(r3)     // Catch:{ all -> 0x036c }
                java.lang.String r4 = ","
                java.lang.String[] r2 = r2.split(r4)     // Catch:{ all -> 0x036c }
                org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x036c }
                r4.<init>()     // Catch:{ all -> 0x036c }
                r5 = 0
            L_0x0318:
                int r6 = r2.length     // Catch:{ all -> 0x036c }
                if (r5 >= r6) goto L_0x0323
                r6 = r2[r5]     // Catch:{ all -> 0x036c }
                r4.put(r6)     // Catch:{ all -> 0x036c }
                int r5 = r5 + 1
                goto L_0x0318
            L_0x0323:
                r1.put(r3, r4)     // Catch:{ all -> 0x036c }
                com.uyumao.r r2 = com.uyumao.r.this     // Catch:{ all -> 0x036c }
                org.json.JSONObject r2 = r2.f16311a     // Catch:{ all -> 0x036c }
                r3 = r18
                java.lang.String r2 = r2.optString(r3)     // Catch:{ all -> 0x036c }
                r1.put(r3, r2)     // Catch:{ all -> 0x036c }
                com.uyumao.r r2 = com.uyumao.r.this     // Catch:{ all -> 0x036c }
                org.json.JSONObject r2 = r2.f16311a     // Catch:{ all -> 0x036c }
                r3 = r17
                java.lang.String r2 = r2.optString(r3)     // Catch:{ all -> 0x036c }
                r1.put(r3, r2)     // Catch:{ all -> 0x036c }
                com.uyumao.r r2 = com.uyumao.r.this     // Catch:{ all -> 0x036c }
                org.json.JSONObject r2 = r2.f16311a     // Catch:{ all -> 0x036c }
                java.lang.String r3 = "actionName"
                java.lang.String r2 = r2.optString(r3)     // Catch:{ all -> 0x036c }
                org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ all -> 0x036c }
                com.uyumao.r r4 = com.uyumao.r.this     // Catch:{ all -> 0x036c }
                org.json.JSONObject r4 = r4.f16311a     // Catch:{ all -> 0x036c }
                r5 = r16
                java.lang.String r4 = r4.optString(r5)     // Catch:{ all -> 0x036c }
                r3.<init>(r4)     // Catch:{ all -> 0x036c }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x036c }
                r4.<init>()     // Catch:{ all -> 0x036c }
                r4.put(r2, r3)     // Catch:{ all -> 0x036c }
                r1.put(r5, r4)     // Catch:{ all -> 0x036c }
            L_0x036c:
                int r2 = r0.size()     // Catch:{ all -> 0x03a9 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x03a9 }
                r4 = 0
            L_0x0375:
                boolean r3 = r0.hasNext()     // Catch:{ all -> 0x03a9 }
                if (r3 == 0) goto L_0x03a5
                java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x03a9 }
                org.json.JSONArray r3 = (org.json.JSONArray) r3     // Catch:{ all -> 0x03a9 }
                r5 = 1
                int r4 = r4 + r5
                java.lang.String r6 = "batch"
                r1.put(r6, r4)     // Catch:{ all -> 0x03a9 }
                java.lang.String r6 = "batch_num"
                r1.put(r6, r2)     // Catch:{ all -> 0x03a9 }
                java.lang.String r6 = "batch_pkg_num"
                int r7 = r3.length()     // Catch:{ all -> 0x03a9 }
                r1.put(r6, r7)     // Catch:{ all -> 0x03a9 }
                java.lang.String r6 = "apl"
                r1.put(r6, r3)     // Catch:{ all -> 0x03a9 }
                java.lang.String r3 = "https://yumao.puata.info/cc_info"
                java.lang.String r6 = r8.f16315d     // Catch:{ Exception -> 0x03a3 }
                com.uyumao.e.a((org.json.JSONObject) r1, (java.lang.String) r3, (java.lang.String) r6)     // Catch:{ Exception -> 0x03a3 }
                goto L_0x0375
            L_0x03a3:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x03a9 }
            L_0x03a5:
                com.uyumao.n.a((java.io.Closeable) r9)
                goto L_0x03bb
            L_0x03a9:
                r0 = move-exception
                goto L_0x03b1
            L_0x03ab:
                r0 = move-exception
                r8 = r24
                goto L_0x03b1
            L_0x03af:
                r0 = move-exception
                r8 = r1
            L_0x03b1:
                r7 = r9
                goto L_0x03b5
            L_0x03b3:
                r0 = move-exception
                r8 = r1
            L_0x03b5:
                r0.getMessage()     // Catch:{ all -> 0x03bc }
                com.uyumao.n.a((java.io.Closeable) r7)
            L_0x03bb:
                return
            L_0x03bc:
                r0 = move-exception
                r1 = r0
                com.uyumao.n.a((java.io.Closeable) r7)
                goto L_0x03c3
            L_0x03c2:
                throw r1
            L_0x03c3:
                goto L_0x03c2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uyumao.r.a.run():void");
        }
    }

    public r(JSONObject jSONObject) {
        this.f16311a = jSONObject;
    }

    public void run() {
        if (this.f16311a != null) {
            try {
                Context context = e.f16271a;
                String appkey = UMUtils.getAppkey(context);
                int max = Math.max(this.f16311a.optInt(com.umeng.ccg.a.f14529v, 300), 100);
                int optInt = this.f16311a.optInt("action", 1);
                if (optInt == 1 || optInt == 2) {
                    s.a(new a(context, optInt, max, appkey), 0, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
