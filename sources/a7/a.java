package a7;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Interceptor;
import t9.g;
import t9.i;

public final class a implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final C0141a f10690b = new C0141a((g) null);

    /* renamed from: c  reason: collision with root package name */
    public static final Set f10691c = new LinkedHashSet();

    /* renamed from: a  reason: collision with root package name */
    public final String f10692a;

    /* renamed from: a7.a$a  reason: collision with other inner class name */
    public static final class C0141a {
        public C0141a() {
        }

        public /* synthetic */ C0141a(g gVar) {
            this();
        }
    }

    public a() {
        String simpleName = a.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f10692a = simpleName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r23) {
        /*
            r22 = this;
            r0 = r23
            java.lang.String r1 = "host"
            java.lang.String r2 = "path"
            java.lang.String r3 = "chain"
            t9.i.g(r0, r3)
            okhttp3.Request r3 = r23.request()
            okhttp3.HttpUrl r4 = r3.url()
            java.net.URL r4 = r4.url()
            java.lang.String r15 = r4.getPath()
            java.lang.String r5 = "ReqSource"
            java.lang.String r5 = r3.header(r5)
            java.lang.String r6 = "own"
            boolean r5 = t9.i.b(r5, r6)
            if (r5 != 0) goto L_0x0033
            okhttp3.Response r0 = r0.proceed(r3)
            java.lang.String r1 = "chain.proceed(original)"
            t9.i.f(r0, r1)
            return r0
        L_0x0033:
            okhttp3.Request$Builder r3 = r3.newBuilder()
            okhttp3.Request r3 = r3.build()
            java.lang.String r5 = r4.getHost()
            java.lang.String r6 = a3.d.f162a
            java.lang.String r14 = a3.d.a(r5, r6)
            r4.getProtocol()
            long r18 = android.os.SystemClock.elapsedRealtime()
            okhttp3.Response r0 = r0.proceed(r3)     // Catch:{ Exception -> 0x00a9 }
            int r12 = r0.code()     // Catch:{ Exception -> 0x00a9 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r12 == r3) goto L_0x009e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a9 }
            r3.<init>()     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r5 = r4.getHost()     // Catch:{ Exception -> 0x00a9 }
            r3.append(r5)     // Catch:{ Exception -> 0x00a9 }
            r3.append(r12)     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00a9 }
            java.util.Set r5 = f10691c     // Catch:{ Exception -> 0x00a9 }
            boolean r6 = r5.contains(r3)     // Catch:{ Exception -> 0x00a9 }
            if (r6 == 0) goto L_0x0074
            goto L_0x009e
        L_0x0074:
            r5.add(r3)     // Catch:{ Exception -> 0x00a9 }
            c2.d r5 = c2.d.f4594a     // Catch:{ Exception -> 0x00a9 }
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00a9 }
            t9.i.f(r15, r2)     // Catch:{ Exception -> 0x00a9 }
            t9.i.f(r14, r1)     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r13 = na.e.f19079e     // Catch:{ Exception -> 0x00a9 }
            r3 = 0
            r16 = 1
            r17 = 64
            r20 = 0
            r6 = r18
            r10 = r15
            r11 = r14
            r21 = r14
            r14 = r3
            r3 = r15
            r15 = r16
            r16 = r17
            r17 = r20
            c2.d.e(r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00a1
        L_0x009e:
            r21 = r14
            r3 = r15
        L_0x00a1:
            java.lang.String r5 = "mResponse"
            t9.i.f(r0, r5)     // Catch:{ Exception -> 0x00a7 }
            return r0
        L_0x00a7:
            r0 = move-exception
            goto L_0x00ad
        L_0x00a9:
            r0 = move-exception
            r21 = r14
            r3 = r15
        L_0x00ad:
            boolean r5 = r0 instanceof mobile.com.requestframe.utils.bean.ResultException
            if (r5 != 0) goto L_0x014c
            java.lang.String r5 = r0.getMessage()
            r6 = 0
            if (r5 == 0) goto L_0x00c4
            r7 = 2
            r8 = 0
            java.lang.String r9 = "Canceled"
            boolean r5 = ba.t.o(r5, r9, r6, r7, r8)
            r7 = 1
            if (r5 != r7) goto L_0x00c4
            r6 = 1
        L_0x00c4:
            if (r6 != 0) goto L_0x014c
            boolean r5 = r0 instanceof retrofit2.HttpException
            if (r5 == 0) goto L_0x00d3
            r5 = r0
            retrofit2.HttpException r5 = (retrofit2.HttpException) r5
            int r5 = r5.code()
            r12 = r5
            goto L_0x0110
        L_0x00d3:
            boolean r5 = r0 instanceof java.util.concurrent.TimeoutException
            if (r5 == 0) goto L_0x00de
            r5 = 50010(0xc35a, float:7.0079E-41)
            r12 = 50010(0xc35a, float:7.0079E-41)
            goto L_0x0110
        L_0x00de:
            boolean r5 = r0 instanceof java.net.ConnectException
            if (r5 == 0) goto L_0x00e9
            r5 = 50011(0xc35b, float:7.008E-41)
            r12 = 50011(0xc35b, float:7.008E-41)
            goto L_0x0110
        L_0x00e9:
            boolean r5 = r0 instanceof java.net.SocketTimeoutException
            if (r5 == 0) goto L_0x00f4
            r5 = 50012(0xc35c, float:7.0082E-41)
            r12 = 50012(0xc35c, float:7.0082E-41)
            goto L_0x0110
        L_0x00f4:
            boolean r5 = r0 instanceof javax.net.ssl.SSLException
            if (r5 == 0) goto L_0x00ff
            r5 = 50013(0xc35d, float:7.0083E-41)
            r12 = 50013(0xc35d, float:7.0083E-41)
            goto L_0x0110
        L_0x00ff:
            boolean r5 = r0 instanceof java.net.UnknownHostException
            if (r5 == 0) goto L_0x010a
            r5 = 50014(0xc35e, float:7.0085E-41)
            r12 = 50014(0xc35e, float:7.0085E-41)
            goto L_0x0110
        L_0x010a:
            r5 = 50015(0xc35f, float:7.0086E-41)
            r12 = 50015(0xc35f, float:7.0086E-41)
        L_0x0110:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.getHost()
            r5.append(r4)
            r5.append(r12)
            java.lang.String r4 = r5.toString()
            java.util.Set r5 = f10691c
            boolean r6 = r5.contains(r4)
            if (r6 == 0) goto L_0x012c
            goto L_0x014c
        L_0x012c:
            r5.add(r4)
            c2.d r5 = c2.d.f4594a
            long r8 = android.os.SystemClock.elapsedRealtime()
            t9.i.f(r3, r2)
            r2 = r21
            t9.i.f(r2, r1)
            java.lang.String r13 = na.e.f19079e
            r14 = 0
            r15 = 1
            r16 = 64
            r17 = 0
            r6 = r18
            r10 = r3
            r11 = r2
            c2.d.e(r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x014c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.a.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
