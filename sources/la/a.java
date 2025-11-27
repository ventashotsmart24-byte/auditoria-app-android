package la;

import okhttp3.Interceptor;
import t9.i;

public final class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final String f18840a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18841b;

    public a(String str) {
        i.g(str, "alias");
        this.f18840a = str;
        String simpleName = a.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f18841b = simpleName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r21) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "path"
            java.lang.String r2 = "chain"
            t9.i.g(r0, r2)
            okhttp3.Request r2 = r21.request()
            okhttp3.HttpUrl r3 = r2.url()
            java.net.URL r3 = r3.url()
            java.lang.String r15 = r3.getPath()
            okhttp3.Request$Builder r2 = r2.newBuilder()
            okhttp3.Request r2 = r2.build()
            java.lang.String r4 = r3.getHost()
            java.lang.String r5 = a3.d.f162a
            java.lang.String r14 = a3.d.a(r4, r5)
            r3.getProtocol()
            long r17 = android.os.SystemClock.elapsedRealtime()
            t2.a r3 = t2.a.f9350a
            java.lang.String r4 = "host"
            t9.i.f(r14, r4)
            r3.v(r14)
            okhttp3.Response r0 = r0.proceed(r2)     // Catch:{ Exception -> 0x0071 }
            int r11 = r0.code()     // Catch:{ Exception -> 0x0071 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r11 == r2) goto L_0x0066
            c2.d r4 = c2.d.f4594a     // Catch:{ Exception -> 0x0071 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0071 }
            t9.i.f(r15, r1)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r12 = na.e.f19079e     // Catch:{ Exception -> 0x0071 }
            r13 = 0
            r2 = 1
            r3 = 64
            r16 = 0
            r5 = r17
            r9 = r15
            r10 = r14
            r19 = r14
            r14 = r2
            r2 = r15
            r15 = r3
            c2.d.e(r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x006f }
            goto L_0x0069
        L_0x0066:
            r19 = r14
            r2 = r15
        L_0x0069:
            java.lang.String r3 = "mResponse"
            t9.i.f(r0, r3)     // Catch:{ Exception -> 0x006f }
            return r0
        L_0x006f:
            r0 = move-exception
            goto L_0x0075
        L_0x0071:
            r0 = move-exception
            r19 = r14
            r2 = r15
        L_0x0075:
            boolean r3 = r0 instanceof mobile.com.requestframe.utils.bean.ResultException
            if (r3 != 0) goto L_0x00f1
            java.lang.String r3 = r0.getMessage()
            r4 = 0
            if (r3 == 0) goto L_0x008c
            r5 = 2
            r6 = 0
            java.lang.String r7 = "Canceled"
            boolean r3 = ba.t.o(r3, r7, r4, r5, r6)
            r5 = 1
            if (r3 != r5) goto L_0x008c
            r4 = 1
        L_0x008c:
            if (r4 != 0) goto L_0x00f1
            boolean r3 = r0 instanceof retrofit2.HttpException
            if (r3 != 0) goto L_0x00d0
            boolean r3 = r0 instanceof java.util.concurrent.TimeoutException
            if (r3 != 0) goto L_0x00c9
            boolean r3 = r0 instanceof java.net.ConnectException
            if (r3 != 0) goto L_0x00c2
            boolean r3 = r0 instanceof java.net.SocketTimeoutException
            if (r3 != 0) goto L_0x00bb
            boolean r3 = r0 instanceof javax.net.ssl.SSLException
            if (r3 != 0) goto L_0x00b4
            boolean r3 = r0 instanceof java.net.UnknownHostException
            if (r3 == 0) goto L_0x00ad
            r3 = 50014(0xc35e, float:7.0085E-41)
            r11 = 50014(0xc35e, float:7.0085E-41)
            goto L_0x00d8
        L_0x00ad:
            r3 = 50015(0xc35f, float:7.0086E-41)
            r11 = 50015(0xc35f, float:7.0086E-41)
            goto L_0x00d8
        L_0x00b4:
            r3 = 50013(0xc35d, float:7.0083E-41)
            r11 = 50013(0xc35d, float:7.0083E-41)
            goto L_0x00d8
        L_0x00bb:
            r3 = 50012(0xc35c, float:7.0082E-41)
            r11 = 50012(0xc35c, float:7.0082E-41)
            goto L_0x00d8
        L_0x00c2:
            r3 = 50011(0xc35b, float:7.008E-41)
            r11 = 50011(0xc35b, float:7.008E-41)
            goto L_0x00d8
        L_0x00c9:
            r3 = 50010(0xc35a, float:7.0079E-41)
            r11 = 50010(0xc35a, float:7.0079E-41)
            goto L_0x00d8
        L_0x00d0:
            r3 = r0
            retrofit2.HttpException r3 = (retrofit2.HttpException) r3
            int r3 = r3.code()
            r11 = r3
        L_0x00d8:
            c2.d r4 = c2.d.f4594a
            long r7 = android.os.SystemClock.elapsedRealtime()
            t9.i.f(r2, r1)
            java.lang.String r12 = na.e.f19079e
            r13 = 0
            r14 = 1
            r15 = 64
            r16 = 0
            r5 = r17
            r9 = r2
            r10 = r19
            c2.d.e(r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x00f1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: la.a.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
