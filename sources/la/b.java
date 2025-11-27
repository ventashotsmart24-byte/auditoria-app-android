package la;

import okhttp3.Interceptor;
import s9.l;
import t9.g;
import t9.i;

public final class b implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18842b = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    public static l f18843c;

    /* renamed from: a  reason: collision with root package name */
    public final String f18844a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(l lVar) {
            i.g(lVar, "slbCallback");
            b(lVar);
        }

        public final void b(l lVar) {
            b.f18843c = lVar;
        }
    }

    public b() {
        String simpleName = b.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f18844a = simpleName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f2, code lost:
        if (ba.t.o(r4, "Canceled", false, r3, r2) == true) goto L_0x00f7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r24) {
        /*
            r23 = this;
            r0 = r24
            java.lang.String r1 = "host"
            java.lang.String r2 = "chain"
            t9.i.g(r0, r2)
            okhttp3.Request r2 = r24.request()
            okhttp3.Request$Builder r3 = r2.newBuilder()
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json;charset=utf-8"
            okhttp3.Request$Builder r3 = r3.addHeader(r4, r5)
            java.lang.String r4 = "apk"
            java.lang.String r5 = na.a.g()
            okhttp3.Request$Builder r3 = r3.addHeader(r4, r5)
            int r4 = na.a.b()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "apkVer"
            okhttp3.Request$Builder r3 = r3.addHeader(r5, r4)
            java.lang.String r4 = "spkgVer"
            java.lang.String r5 = android.os.Build.VERSION.RELEASE
            okhttp3.Request$Builder r3 = r3.addHeader(r4, r5)
            okhttp3.HttpUrl r2 = r2.url()
            java.net.URL r2 = r2.url()
            java.lang.String r15 = r2.getPath()
            java.lang.String r4 = "path"
            t9.i.f(r15, r4)
            java.lang.String r4 = "dcs/getAddr"
            r14 = 0
            r13 = 2
            r12 = 0
            boolean r4 = ba.t.o(r15, r4, r14, r13, r12)
            if (r4 == 0) goto L_0x0071
            android.content.Context r4 = na.a.f8315a
            java.lang.String r5 = "key_user_id"
            java.lang.String r6 = ""
            java.lang.String r4 = na.f.f(r4, r5, r6)
            android.content.Context r5 = na.a.f8315a
            java.lang.String r7 = "key_user_identity"
            java.lang.String r5 = na.f.f(r5, r7, r6)
            java.lang.String r6 = "userId"
            r3.addHeader(r6, r4)
            java.lang.String r4 = "userIdentity"
            r3.addHeader(r4, r5)
        L_0x0071:
            okhttp3.Request r3 = r3.build()
            java.lang.String r4 = r2.getHost()
            java.lang.String r5 = a3.d.f162a
            java.lang.String r11 = a3.d.a(r4, r5)
            r2.getProtocol()
            long r17 = android.os.SystemClock.elapsedRealtime()
            okhttp3.Response r0 = r0.proceed(r3)     // Catch:{ Exception -> 0x00d9 }
            int r2 = r0.code()     // Catch:{ Exception -> 0x00d9 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r2 == r3) goto L_0x0096
            if (r2 != r4) goto L_0x00a0
        L_0x0096:
            if (r2 != r4) goto L_0x00cb
            java.lang.String r3 = "epg/"
            boolean r3 = ba.t.o(r15, r3, r14, r13, r12)     // Catch:{ Exception -> 0x00d9 }
            if (r3 != 0) goto L_0x00cb
        L_0x00a0:
            c2.d r4 = c2.d.f4594a     // Catch:{ Exception -> 0x00d9 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00d9 }
            t9.i.f(r11, r1)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r3 = na.e.f19079e     // Catch:{ Exception -> 0x00d9 }
            r16 = 0
            r19 = 1
            r20 = 64
            r21 = 0
            r5 = r17
            r9 = r15
            r10 = r11
            r22 = r11
            r11 = r2
            r2 = r12
            r12 = r3
            r3 = 2
            r13 = r16
            r14 = r19
            r19 = r15
            r15 = r20
            r16 = r21
            c2.d.e(r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00d1
        L_0x00cb:
            r22 = r11
            r2 = r12
            r19 = r15
            r3 = 2
        L_0x00d1:
            java.lang.String r4 = "mResponse"
            t9.i.f(r0, r4)     // Catch:{ Exception -> 0x00d7 }
            return r0
        L_0x00d7:
            r0 = move-exception
            goto L_0x00e0
        L_0x00d9:
            r0 = move-exception
            r22 = r11
            r2 = r12
            r19 = r15
            r3 = 2
        L_0x00e0:
            boolean r4 = r0 instanceof mobile.com.requestframe.utils.bean.ResultException
            if (r4 != 0) goto L_0x015e
            java.lang.String r4 = r0.getMessage()
            if (r4 == 0) goto L_0x00f5
            java.lang.String r5 = "Canceled"
            r6 = 0
            boolean r2 = ba.t.o(r4, r5, r6, r3, r2)
            r14 = 1
            if (r2 != r14) goto L_0x00f6
            goto L_0x00f7
        L_0x00f5:
            r6 = 0
        L_0x00f6:
            r14 = 0
        L_0x00f7:
            if (r14 != 0) goto L_0x015e
            boolean r2 = r0 instanceof retrofit2.HttpException
            if (r2 != 0) goto L_0x013b
            boolean r2 = r0 instanceof java.util.concurrent.TimeoutException
            if (r2 != 0) goto L_0x0134
            boolean r2 = r0 instanceof java.net.ConnectException
            if (r2 != 0) goto L_0x012d
            boolean r2 = r0 instanceof java.net.SocketTimeoutException
            if (r2 != 0) goto L_0x0126
            boolean r2 = r0 instanceof javax.net.ssl.SSLException
            if (r2 != 0) goto L_0x011f
            boolean r2 = r0 instanceof java.net.UnknownHostException
            if (r2 == 0) goto L_0x0118
            r2 = 50014(0xc35e, float:7.0085E-41)
            r11 = 50014(0xc35e, float:7.0085E-41)
            goto L_0x0143
        L_0x0118:
            r2 = 50015(0xc35f, float:7.0086E-41)
            r11 = 50015(0xc35f, float:7.0086E-41)
            goto L_0x0143
        L_0x011f:
            r2 = 50013(0xc35d, float:7.0083E-41)
            r11 = 50013(0xc35d, float:7.0083E-41)
            goto L_0x0143
        L_0x0126:
            r2 = 50012(0xc35c, float:7.0082E-41)
            r11 = 50012(0xc35c, float:7.0082E-41)
            goto L_0x0143
        L_0x012d:
            r2 = 50011(0xc35b, float:7.008E-41)
            r11 = 50011(0xc35b, float:7.008E-41)
            goto L_0x0143
        L_0x0134:
            r2 = 50010(0xc35a, float:7.0079E-41)
            r11 = 50010(0xc35a, float:7.0079E-41)
            goto L_0x0143
        L_0x013b:
            r2 = r0
            retrofit2.HttpException r2 = (retrofit2.HttpException) r2
            int r2 = r2.code()
            r11 = r2
        L_0x0143:
            c2.d r4 = c2.d.f4594a
            long r7 = android.os.SystemClock.elapsedRealtime()
            r2 = r22
            t9.i.f(r2, r1)
            java.lang.String r12 = na.e.f19079e
            r13 = 0
            r14 = 1
            r15 = 64
            r16 = 0
            r5 = r17
            r9 = r19
            r10 = r2
            c2.d.e(r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x015e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: la.b.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
