package w2;

import okhttp3.Interceptor;
import t9.i;

public final class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final String f9498a;

    public a() {
        String simpleName = a.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f9498a = simpleName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bb, code lost:
        if (ba.t.o(r3, "Canceled", false, 2, r15) == true) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r20) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "path"
            java.lang.String r2 = "chain"
            t9.i.g(r0, r2)
            okhttp3.Request r2 = r20.request()
            okhttp3.Request$Builder r2 = r2.newBuilder()
            okhttp3.Request r2 = r2.build()
            okhttp3.HttpUrl r3 = r2.url()
            java.net.URL r3 = r3.url()
            java.lang.String r13 = r3.getPath()
            java.lang.String r4 = r3.getHost()
            java.lang.String r5 = a3.d.f162a
            java.lang.String r14 = a3.d.a(r4, r5)
            r3.getProtocol()
            long r15 = android.os.SystemClock.elapsedRealtime()
            t2.a r3 = t2.a.f9350a
            java.lang.String r12 = "host"
            t9.i.f(r14, r12)
            r3.v(r14)
            android.content.Context r4 = r3.a()
            if (r4 == 0) goto L_0x0051
            a3.j r5 = a3.j.f171a
            boolean r4 = r5.f(r4)
            if (r4 == 0) goto L_0x004b
            goto L_0x0051
        L_0x004b:
            com.dcs.bean.NetWorkUnavailableException r0 = new com.dcs.bean.NetWorkUnavailableException
            r0.<init>()
            throw r0
        L_0x0051:
            r11 = 0
            r10 = 2
            r9 = 0
            okhttp3.Response r0 = r0.proceed(r2)     // Catch:{ Exception -> 0x00a7 }
            int r2 = r0.code()     // Catch:{ Exception -> 0x00a7 }
            t9.i.f(r13, r1)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r4 = "v1"
            boolean r4 = ba.t.o(r13, r4, r9, r10, r11)     // Catch:{ Exception -> 0x00a7 }
            if (r4 != 0) goto L_0x006f
            java.lang.String r4 = "n1"
            boolean r4 = ba.t.o(r13, r4, r9, r10, r11)     // Catch:{ Exception -> 0x00a7 }
            if (r4 == 0) goto L_0x0078
        L_0x006f:
            java.lang.String r4 = "timestamp"
            java.lang.String r4 = r0.header(r4)     // Catch:{ Exception -> 0x00a7 }
            r3.x(r4)     // Catch:{ Exception -> 0x00a7 }
        L_0x0078:
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 == r4) goto L_0x009b
            r4 = 304(0x130, float:4.26E-43)
            if (r2 == r4) goto L_0x009b
            v2.b r4 = r3.f()     // Catch:{ Exception -> 0x00a7 }
            if (r4 == 0) goto L_0x009b
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00a7 }
            t9.i.f(r14, r12)     // Catch:{ Exception -> 0x00a7 }
            r3 = 1
            r5 = r15
            r9 = r13
            r10 = r14
            r17 = r15
            r15 = r11
            r11 = r2
            r2 = r12
            r12 = r3
            r4.a(r5, r7, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x009f
        L_0x009b:
            r2 = r12
            r17 = r15
            r15 = r11
        L_0x009f:
            java.lang.String r3 = "mResponse"
            t9.i.f(r0, r3)     // Catch:{ Exception -> 0x00a5 }
            return r0
        L_0x00a5:
            r0 = move-exception
            goto L_0x00ac
        L_0x00a7:
            r0 = move-exception
            r2 = r12
            r17 = r15
            r15 = r11
        L_0x00ac:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x00be
            java.lang.String r4 = "Canceled"
            r5 = 2
            r6 = 0
            boolean r3 = ba.t.o(r3, r4, r6, r5, r15)
            r9 = 1
            if (r3 != r9) goto L_0x00bf
            goto L_0x00c0
        L_0x00be:
            r6 = 0
        L_0x00bf:
            r9 = 0
        L_0x00c0:
            if (r9 != 0) goto L_0x0126
            boolean r3 = r0 instanceof retrofit2.HttpException
            if (r3 == 0) goto L_0x00cf
            r3 = r0
            retrofit2.HttpException r3 = (retrofit2.HttpException) r3
            int r3 = r3.code()
            r11 = r3
            goto L_0x010c
        L_0x00cf:
            boolean r3 = r0 instanceof java.util.concurrent.TimeoutException
            if (r3 == 0) goto L_0x00da
            r3 = 50010(0xc35a, float:7.0079E-41)
            r11 = 50010(0xc35a, float:7.0079E-41)
            goto L_0x010c
        L_0x00da:
            boolean r3 = r0 instanceof java.net.ConnectException
            if (r3 == 0) goto L_0x00e5
            r3 = 50011(0xc35b, float:7.008E-41)
            r11 = 50011(0xc35b, float:7.008E-41)
            goto L_0x010c
        L_0x00e5:
            boolean r3 = r0 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L_0x00f0
            r3 = 50012(0xc35c, float:7.0082E-41)
            r11 = 50012(0xc35c, float:7.0082E-41)
            goto L_0x010c
        L_0x00f0:
            boolean r3 = r0 instanceof javax.net.ssl.SSLException
            if (r3 == 0) goto L_0x00fb
            r3 = 50013(0xc35d, float:7.0083E-41)
            r11 = 50013(0xc35d, float:7.0083E-41)
            goto L_0x010c
        L_0x00fb:
            boolean r3 = r0 instanceof java.net.UnknownHostException
            if (r3 == 0) goto L_0x0106
            r3 = 50014(0xc35e, float:7.0085E-41)
            r11 = 50014(0xc35e, float:7.0085E-41)
            goto L_0x010c
        L_0x0106:
            r3 = 50015(0xc35f, float:7.0086E-41)
            r11 = 50015(0xc35f, float:7.0086E-41)
        L_0x010c:
            t2.a r3 = t2.a.f9350a
            v2.b r4 = r3.f()
            if (r4 == 0) goto L_0x0126
            long r7 = android.os.SystemClock.elapsedRealtime()
            t9.i.f(r13, r1)
            t9.i.f(r14, r2)
            r12 = 1
            r5 = r17
            r9 = r13
            r10 = r14
            r4.a(r5, r7, r9, r10, r11, r12)
        L_0x0126:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.a.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
