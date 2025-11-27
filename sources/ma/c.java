package ma;

import android.content.Context;
import com.umeng.analytics.pro.f;
import okhttp3.Interceptor;
import t9.i;

public final class c implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final Context f7911a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7912b;

    public c(Context context) {
        i.g(context, f.X);
        this.f7911a = context;
        String simpleName = c.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f7912b = simpleName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00aa, code lost:
        if (ba.t.o(r9, "Canceled", r6, 2, (java.lang.Object) null) == true) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0051, code lost:
        if (ba.t.o(r14, "epg/", false, 2, (java.lang.Object) null) == false) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "mTemporaryAccount"
            java.lang.String r3 = ".bigbee"
            java.lang.String r4 = "path"
            java.lang.String r5 = "host"
            java.lang.String r6 = "chain"
            t9.i.g(r0, r6)
            okhttp3.Request r6 = r18.request()
            okhttp3.HttpUrl r7 = r6.url()
            java.net.URL r7 = r7.url()
            java.lang.String r14 = r7.getPath()
            okhttp3.Request$Builder r6 = r6.newBuilder()
            okhttp3.Request r6 = r6.build()
            java.lang.String r8 = r7.getHost()
            r7.getProtocol()
            android.os.SystemClock.elapsedRealtime()
            r7 = 0
            r15 = 2
            r13 = 0
            okhttp3.Response r0 = r0.proceed(r6)     // Catch:{ Exception -> 0x009b }
            int r12 = r0.code()     // Catch:{ Exception -> 0x009b }
            r6 = 200(0xc8, float:2.8E-43)
            r9 = 304(0x130, float:4.26E-43)
            if (r12 == r6) goto L_0x0046
            if (r12 != r9) goto L_0x0053
        L_0x0046:
            if (r12 != r9) goto L_0x0092
            t9.i.f(r14, r4)     // Catch:{ Exception -> 0x009b }
            java.lang.String r6 = "epg/"
            boolean r6 = ba.t.o(r14, r6, r13, r15, r7)     // Catch:{ Exception -> 0x009b }
            if (r6 != 0) goto L_0x0092
        L_0x0053:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b }
            r6.<init>()     // Catch:{ Exception -> 0x009b }
            na.g r9 = na.g.f19081a     // Catch:{ Exception -> 0x009b }
            t9.i.f(r8, r5)     // Catch:{ Exception -> 0x009b }
            java.lang.String r9 = r9.a(r8)     // Catch:{ Exception -> 0x009b }
            r6.append(r9)     // Catch:{ Exception -> 0x009b }
            r6.append(r3)     // Catch:{ Exception -> 0x009b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x009b }
            ma.d r8 = ma.d.f18993a     // Catch:{ Exception -> 0x008b }
            android.content.Context r9 = r1.f7911a     // Catch:{ Exception -> 0x008b }
            t9.i.f(r14, r4)     // Catch:{ Exception -> 0x008b }
            t9.i.f(r6, r5)     // Catch:{ Exception -> 0x008b }
            java.lang.String r11 = na.e.f19079e     // Catch:{ Exception -> 0x008b }
            t9.i.f(r11, r2)     // Catch:{ Exception -> 0x008b }
            r10 = r14
            r16 = r11
            r11 = r6
            r18 = r6
            r6 = 0
            r13 = r16
            r8.b(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0089 }
            r8 = r18
            goto L_0x0093
        L_0x0089:
            r0 = move-exception
            goto L_0x008f
        L_0x008b:
            r0 = move-exception
            r18 = r6
            r6 = 0
        L_0x008f:
            r8 = r18
            goto L_0x009d
        L_0x0092:
            r6 = 0
        L_0x0093:
            java.lang.String r9 = "mResponse"
            t9.i.f(r0, r9)     // Catch:{ Exception -> 0x0099 }
            return r0
        L_0x0099:
            r0 = move-exception
            goto L_0x009d
        L_0x009b:
            r0 = move-exception
            r6 = 0
        L_0x009d:
            java.lang.String r9 = r0.getMessage()
            if (r9 == 0) goto L_0x00ad
            java.lang.String r10 = "Canceled"
            boolean r7 = ba.t.o(r9, r10, r6, r15, r7)
            r13 = 1
            if (r7 != r13) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r13 = 0
        L_0x00ae:
            if (r13 != 0) goto L_0x0125
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            na.g r7 = na.g.f19081a
            t9.i.f(r8, r5)
            java.lang.String r7 = r7.a(r8)
            r6.append(r7)
            r6.append(r3)
            java.lang.String r11 = r6.toString()
            boolean r3 = r0 instanceof retrofit2.HttpException
            if (r3 != 0) goto L_0x010a
            boolean r3 = r0 instanceof java.util.concurrent.TimeoutException
            if (r3 != 0) goto L_0x0103
            boolean r3 = r0 instanceof java.net.ConnectException
            if (r3 != 0) goto L_0x00fc
            boolean r3 = r0 instanceof java.net.SocketTimeoutException
            if (r3 != 0) goto L_0x00f5
            boolean r3 = r0 instanceof javax.net.ssl.SSLException
            if (r3 != 0) goto L_0x00ee
            boolean r3 = r0 instanceof java.net.UnknownHostException
            if (r3 == 0) goto L_0x00e7
            r3 = 50014(0xc35e, float:7.0085E-41)
            r12 = 50014(0xc35e, float:7.0085E-41)
            goto L_0x0112
        L_0x00e7:
            r3 = 50015(0xc35f, float:7.0086E-41)
            r12 = 50015(0xc35f, float:7.0086E-41)
            goto L_0x0112
        L_0x00ee:
            r3 = 50013(0xc35d, float:7.0083E-41)
            r12 = 50013(0xc35d, float:7.0083E-41)
            goto L_0x0112
        L_0x00f5:
            r3 = 50012(0xc35c, float:7.0082E-41)
            r12 = 50012(0xc35c, float:7.0082E-41)
            goto L_0x0112
        L_0x00fc:
            r3 = 50011(0xc35b, float:7.008E-41)
            r12 = 50011(0xc35b, float:7.008E-41)
            goto L_0x0112
        L_0x0103:
            r3 = 50010(0xc35a, float:7.0079E-41)
            r12 = 50010(0xc35a, float:7.0079E-41)
            goto L_0x0112
        L_0x010a:
            r3 = r0
            retrofit2.HttpException r3 = (retrofit2.HttpException) r3
            int r3 = r3.code()
            r12 = r3
        L_0x0112:
            ma.d r8 = ma.d.f18993a
            android.content.Context r9 = r1.f7911a
            t9.i.f(r14, r4)
            t9.i.f(r11, r5)
            java.lang.String r13 = na.e.f19079e
            t9.i.f(r13, r2)
            r10 = r14
            r8.b(r9, r10, r11, r12, r13)
        L_0x0125:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.c.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
