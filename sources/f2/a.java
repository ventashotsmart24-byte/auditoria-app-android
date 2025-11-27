package f2;

import com.taobao.accs.utl.BaseMonitor;
import com.umeng.analytics.pro.by;
import java.util.HashMap;
import okhttp3.Dns;
import okhttp3.Interceptor;
import t9.i;

public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f6542a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public String f6543b;

    /* renamed from: c  reason: collision with root package name */
    public String f6544c;

    /* renamed from: d  reason: collision with root package name */
    public String f6545d = e.GET.b();

    /* renamed from: e  reason: collision with root package name */
    public b f6546e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f6547f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public HashMap f6548g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public String f6549h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f6550i = by.f13999b;

    /* renamed from: j  reason: collision with root package name */
    public int f6551j = by.f13999b;

    /* renamed from: k  reason: collision with root package name */
    public Dns f6552k;

    /* renamed from: l  reason: collision with root package name */
    public Interceptor f6553l;

    public a() {
        Dns dns = Dns.SYSTEM;
        i.f(dns, "SYSTEM");
        this.f6552k = dns;
    }

    public final a a(b bVar) {
        i.g(bVar, "callback");
        this.f6546e = bVar;
        return this;
    }

    public final a b(Dns dns) {
        i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        this.f6552k = dns;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final g2.a c(boolean r9) {
        /*
            r8 = this;
            g2.a r0 = new g2.a
            r0.<init>()
            java.lang.String r9 = r8.d(r9)
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L_0x0016
            int r3 = r9.length()
            if (r3 != 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r3 = 0
            goto L_0x0017
        L_0x0016:
            r3 = 1
        L_0x0017:
            if (r3 != 0) goto L_0x0113
            r3 = 0
            okhttp3.OkHttpClient$Builder r4 = new okhttp3.OkHttpClient$Builder     // Catch:{ Exception -> 0x0108 }
            r4.<init>()     // Catch:{ Exception -> 0x0108 }
            java.net.Proxy r5 = java.net.Proxy.NO_PROXY     // Catch:{ Exception -> 0x0108 }
            r4.proxy(r5)     // Catch:{ Exception -> 0x0108 }
            javax.net.ssl.X509TrustManager r5 = f2.c.a()     // Catch:{ Exception -> 0x0108 }
            java.lang.String r6 = "getTrustAllCert()"
            t9.i.f(r5, r6)     // Catch:{ Exception -> 0x0108 }
            f2.f r6 = new f2.f     // Catch:{ Exception -> 0x0108 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0108 }
            r4.sslSocketFactory(r6, r5)     // Catch:{ Exception -> 0x0108 }
            okhttp3.Interceptor r5 = r8.f6553l     // Catch:{ Exception -> 0x0108 }
            if (r5 == 0) goto L_0x003c
            r4.addInterceptor(r5)     // Catch:{ Exception -> 0x0108 }
        L_0x003c:
            int r5 = r8.f6551j     // Catch:{ Exception -> 0x0108 }
            long r5 = (long) r5     // Catch:{ Exception -> 0x0108 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0108 }
            okhttp3.OkHttpClient$Builder r4 = r4.readTimeout(r5, r7)     // Catch:{ Exception -> 0x0108 }
            int r5 = r8.f6550i     // Catch:{ Exception -> 0x0108 }
            long r5 = (long) r5     // Catch:{ Exception -> 0x0108 }
            okhttp3.OkHttpClient$Builder r4 = r4.connectTimeout(r5, r7)     // Catch:{ Exception -> 0x0108 }
            okhttp3.Dns r5 = r8.f6552k     // Catch:{ Exception -> 0x0108 }
            okhttp3.OkHttpClient$Builder r4 = r4.dns(r5)     // Catch:{ Exception -> 0x0108 }
            okhttp3.OkHttpClient r4 = r4.build()     // Catch:{ Exception -> 0x0108 }
            okhttp3.Request$Builder r5 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x0108 }
            r5.<init>()     // Catch:{ Exception -> 0x0108 }
            okhttp3.Request$Builder r9 = r5.url((java.lang.String) r9)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r5 = "User-Agent"
            java.lang.String r6 = "BigBee/3.7.0"
            okhttp3.Request$Builder r9 = r9.addHeader(r5, r6)     // Catch:{ Exception -> 0x0108 }
            java.util.HashMap r5 = r8.f6547f     // Catch:{ Exception -> 0x0108 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ Exception -> 0x0108 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0108 }
        L_0x0071:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x0108 }
            if (r6 == 0) goto L_0x008d
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x0108 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ Exception -> 0x0108 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ Exception -> 0x0108 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0108 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ Exception -> 0x0108 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0108 }
            r9.addHeader(r7, r6)     // Catch:{ Exception -> 0x0108 }
            goto L_0x0071
        L_0x008d:
            java.lang.String r5 = r8.f6545d     // Catch:{ Exception -> 0x0108 }
            f2.e r6 = f2.e.POST     // Catch:{ Exception -> 0x0108 }
            java.lang.String r6 = r6.b()     // Catch:{ Exception -> 0x0108 }
            boolean r5 = t9.i.b(r5, r6)     // Catch:{ Exception -> 0x0108 }
            if (r5 == 0) goto L_0x00af
            java.lang.String r5 = "application/json; charset=utf-8"
            okhttp3.MediaType r5 = okhttp3.MediaType.parse(r5)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r6 = r8.f6549h     // Catch:{ Exception -> 0x0108 }
            okhttp3.RequestBody r5 = okhttp3.RequestBody.create((okhttp3.MediaType) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r6 = "create(MediaType.parse(\"…et=utf-8\"), mRequestJson)"
            t9.i.f(r5, r6)     // Catch:{ Exception -> 0x0108 }
            r9.post(r5)     // Catch:{ Exception -> 0x0108 }
        L_0x00af:
            okhttp3.Request r9 = r9.build()     // Catch:{ Exception -> 0x0108 }
            okhttp3.Call r9 = r4.newCall(r9)     // Catch:{ Exception -> 0x0108 }
            okhttp3.Response r9 = r9.execute()     // Catch:{ Exception -> 0x0108 }
            int r4 = r9.code()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r0.g(r4)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            int r4 = r9.code()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x00fa
            okhttp3.ResponseBody r4 = r9.body()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            if (r4 == 0) goto L_0x00d4
            java.lang.String r3 = r4.string()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
        L_0x00d4:
            r0.f(r3)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            okhttp3.Headers r3 = r9.headers()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.String r4 = "reportClock"
            java.lang.String r3 = r3.get(r4)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            if (r3 == 0) goto L_0x00e9
            int r4 = r3.length()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            if (r4 != 0) goto L_0x00ea
        L_0x00e9:
            r1 = 1
        L_0x00ea:
            if (r1 == 0) goto L_0x00f3
            i2.a r1 = i2.a.f6993a     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            long r1 = r1.c()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            goto L_0x00f7
        L_0x00f3:
            long r1 = java.lang.Long.parseLong(r3)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
        L_0x00f7:
            r0.e(r1)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
        L_0x00fa:
            r9.close()
            return r0
        L_0x00fe:
            r0 = move-exception
            r3 = r9
            r9 = r0
            goto L_0x010d
        L_0x0102:
            r0 = move-exception
            r3 = r9
            r9 = r0
            goto L_0x0109
        L_0x0106:
            r9 = move-exception
            goto L_0x010d
        L_0x0108:
            r9 = move-exception
        L_0x0109:
            r9.printStackTrace()     // Catch:{ all -> 0x0106 }
            throw r9     // Catch:{ all -> 0x0106 }
        L_0x010d:
            if (r3 == 0) goto L_0x0112
            r3.close()
        L_0x0112:
            throw r9
        L_0x0113:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.a.c(boolean):g2.a");
    }

    public final String d(boolean z10) {
        if (z10) {
            return this.f6543b;
        }
        return this.f6544c;
    }

    public final a e(String str, String str2) {
        i.g(str, "key");
        i.g(str2, "value");
        this.f6547f.put(str, str2);
        return this;
    }

    public final a f(Interceptor interceptor) {
        this.f6553l = interceptor;
        return this;
    }

    public final a g(String str) {
        i.g(str, "json");
        this.f6549h = str;
        return this;
    }

    public final a h(e eVar) {
        i.g(eVar, "requestMethod");
        this.f6545d = eVar.b();
        return this;
    }

    public final a i(String str, String str2) {
        i.g(str, "mainUrl");
        i.g(str2, "reserveUrl");
        this.f6543b = str;
        this.f6544c = str2;
        return this;
    }

    public void run() {
        try {
            g2.a c10 = c(true);
            if (c10.d()) {
                b bVar = this.f6546e;
                if (bVar != null) {
                    bVar.a(this, c10);
                    return;
                }
                return;
            }
        } catch (Exception unused) {
        }
        try {
            g2.a c11 = c(false);
            b bVar2 = this.f6546e;
            if (bVar2 != null) {
                bVar2.a(this, c11);
            }
        } catch (Exception e10) {
            b bVar3 = this.f6546e;
            if (bVar3 != null) {
                bVar3.b(this, e10);
            }
        }
    }
}
