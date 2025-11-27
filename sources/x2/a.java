package x2;

import a3.c;
import a3.h;
import a3.j;
import com.dcs.bean.NetWorkUnavailableException;
import com.dcs.bean.V1Bean;
import com.dcs.bean.V1Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public y2.a f9674a;

    /* renamed from: b  reason: collision with root package name */
    public y2.a f9675b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f9676c;

    /* renamed from: d  reason: collision with root package name */
    public int f9677d;

    /* renamed from: x2.a$a  reason: collision with other inner class name */
    public class C0130a extends u2.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f9679c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f9680d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RequestBody f9681e;

        public C0130a(String str, String str2, String str3, RequestBody requestBody) {
            this.f9678b = str;
            this.f9679c = str2;
            this.f9680d = str3;
            this.f9681e = requestBody;
        }

        /* renamed from: d */
        public Observable a(Throwable th) {
            if (th instanceof NetWorkUnavailableException) {
                return Observable.never();
            }
            if (a.this.f9675b != null) {
                if (!"304,500,404,400,506,401".contains(b() + "")) {
                    return a.this.f9675b.a(this.f9678b, this.f9679c, this.f9680d, this.f9681e);
                }
            }
            return Observable.error(th);
        }
    }

    public a() {
        this.f9677d = 15;
        this.f9676c = new GsonBuilder().disableHtmlEscaping().create();
    }

    public final y2.a b(String str) {
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(Proxy.NO_PROXY);
        X509TrustManager a10 = c.a();
        if (a10 != null) {
            builder.sslSocketFactory(new h(a10), a10);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.retryOnConnectionFailure(true).connectTimeout((long) this.f9677d, timeUnit).readTimeout((long) this.f9677d, timeUnit).writeTimeout((long) this.f9677d, timeUnit).dispatcher(new Dispatcher(j.f171a.d())).addInterceptor(new w2.a());
        Dns g10 = t2.a.f9350a.g();
        if (g10 != null) {
            builder.dns(g10);
        }
        return (y2.a) new Retrofit.Builder().client(builder.build()).baseUrl(str).addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync()).addConverterFactory(GsonConverterFactory.create()).build().create(y2.a.class);
    }

    public Observable c(V1Data v1Data) {
        RequestBody create = RequestBody.create(MediaType.parse("application/json"), this.f9676c.toJson((Object) new V1Bean(a3.a.c(this.f9676c.toJson((Object) v1Data)), 0)));
        j jVar = j.f171a;
        String e10 = jVar.e(jVar.b());
        String e11 = jVar.e(jVar.c());
        String e12 = t2.a.f9350a.e();
        return this.f9674a.a(e10, e11, e12, create).onErrorResumeNext(new C0130a(e10, e11, e12, create));
    }

    public a(String str, String str2) {
        this();
        this.f9674a = b(str);
        this.f9675b = b(str2);
    }
}
