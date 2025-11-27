package x1;

import anet.channel.util.HttpConstant;
import com.advertlib.bean.AdReportRequest;
import com.advertlib.bean.AdvertBean;
import com.advertlib.bean.AdvertResult;
import com.advertlib.bean.ReportResult;
import com.dcs.bean.DomainInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.taobao.accs.utl.BaseMonitor;
import h9.h;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import s9.l;
import t9.i;
import t9.j;

public final class d {

    /* renamed from: g  reason: collision with root package name */
    public static final b f9657g = new b((t9.g) null);

    /* renamed from: h  reason: collision with root package name */
    public static final String f9658h = HttpConstant.HTTP;

    /* renamed from: i  reason: collision with root package name */
    public static final h9.g f9659i = h.b(a.f9666a);

    /* renamed from: a  reason: collision with root package name */
    public Dns f9660a;

    /* renamed from: b  reason: collision with root package name */
    public Interceptor f9661b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9662c = d.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public final h9.g f9663d = h.b(new e(this));

    /* renamed from: e  reason: collision with root package name */
    public final Gson f9664e;

    /* renamed from: f  reason: collision with root package name */
    public long f9665f = 15;

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f9666a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final DomainInfo invoke() {
            return t2.a.f9350a.b(m7.c.a().first.toString(), m7.c.a().second.toString(), "key_ads");
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final String a() {
            return d.f9658h;
        }

        public final DomainInfo b() {
            return (DomainInfo) d.f9659i.getValue();
        }
    }

    public static final class c implements Function {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f9667a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RequestBody f9668b;

        public c(d dVar, RequestBody requestBody) {
            this.f9667a = dVar;
            this.f9668b = requestBody;
        }

        /* renamed from: a */
        public Observable apply(Throwable th) {
            i.g(th, "t");
            a d10 = this.f9667a.i();
            b bVar = d.f9657g;
            return d10.b(bVar.a(), bVar.b().getSecond(), this.f9668b);
        }
    }

    /* renamed from: x1.d$d  reason: collision with other inner class name */
    public static final class C0129d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final C0129d f9669a = new C0129d();

        public C0129d() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            t2.a.f9350a.q(d.f9657g.b(), "key_ads");
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f9670a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d dVar) {
            super(0);
            this.f9670a = dVar;
        }

        /* renamed from: b */
        public final a invoke() {
            return (a) this.f9670a.j().create(a.class);
        }
    }

    public static final class f implements Function {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f9671a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RequestBody f9672b;

        public f(d dVar, RequestBody requestBody) {
            this.f9671a = dVar;
            this.f9672b = requestBody;
        }

        /* renamed from: a */
        public Observable apply(Throwable th) {
            i.g(th, "t");
            a d10 = this.f9671a.i();
            b bVar = d.f9657g;
            return d10.a(bVar.a(), bVar.b().getSecond(), this.f9672b);
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f9673a = new g();

        public g() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            t2.a.f9350a.q(d.f9657g.b(), "key_ads");
        }
    }

    public d(Dns dns, Interceptor interceptor) {
        i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        this.f9660a = dns;
        this.f9661b = interceptor;
        Gson create = new GsonBuilder().disableHtmlEscaping().create();
        i.f(create, "GsonBuilder().disableHtmlEscaping().create()");
        this.f9664e = create;
    }

    public static final void h(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void l(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final Observable g(AdvertBean advertBean) {
        i.g(advertBean, "bean");
        String json = this.f9664e.toJson((Object) advertBean);
        i.f(json, "mGson.toJson(bean)");
        RequestBody n10 = n(json);
        Observable<AdvertResult> doOnError = i().b(f9658h, f9657g.b().getFirst(), n10).onErrorResumeNext(new c(this, n10)).doOnError(new b(C0129d.f9669a));
        i.f(doOnError, "fun getAd(bean: AdvertBe…\n                }\n\n    }");
        return doOnError;
    }

    public final a i() {
        Object value = this.f9663d.getValue();
        i.f(value, "<get-mAdApi>(...)");
        return (a) value;
    }

    public final Retrofit j() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j10 = this.f9665f;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder dns = builder.connectTimeout(j10, timeUnit).readTimeout(this.f9665f, timeUnit).writeTimeout(this.f9665f, timeUnit).connectionPool(o2.a.a()).dns(this.f9660a);
        Interceptor interceptor = this.f9661b;
        if (interceptor != null) {
            dns.addInterceptor(interceptor);
        }
        X509TrustManager a10 = y1.a.a();
        if (a10 != null) {
            dns.sslSocketFactory(new y1.d(a10), a10);
        }
        OkHttpClient build = dns.build();
        i.f(build, "builder.build()");
        Retrofit build2 = new Retrofit.Builder().baseUrl("http://www.baidu.com").client(build).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        i.f(build2, "Builder()\n              …\n                .build()");
        return build2;
    }

    public final Observable k(AdReportRequest adReportRequest) {
        i.g(adReportRequest, "bean");
        String json = this.f9664e.toJson((Object) adReportRequest);
        i.f(json, "mGson.toJson(bean)");
        RequestBody n10 = n(json);
        Observable<ReportResult> doOnError = i().a(f9658h, f9657g.b().getFirst(), n10).onErrorResumeNext(new f(this, n10)).doOnError(new c(g.f9673a));
        i.f(doOnError, "fun reportAd(bean: AdRep…)\n                }\n    }");
        return doOnError;
    }

    public final Call m(String str) {
        i.g(str, "videoUrl");
        return i().c(str);
    }

    public final RequestBody n(String str) {
        RequestBody create = RequestBody.create(MediaType.parse("application/json"), str);
        i.f(create, "create(MediaType.parse(\"application/json\"), str)");
        return create;
    }
}
