package oa;

import com.dcs.bean.DomainInfo;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import ja.c;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f19147a = 10;

    /* renamed from: b  reason: collision with root package name */
    public qa.a f19148b;

    /* renamed from: c  reason: collision with root package name */
    public qa.a f19149c;

    /* renamed from: d  reason: collision with root package name */
    public DomainInfo f19150d;

    public class a extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19151b;

        public a(String str) {
            this.f19151b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (b.this.f19149c != null) {
                return b.this.f19149c.b(this.f19151b);
            }
            return Observable.error(th);
        }
    }

    public b(DomainInfo domainInfo) {
        this.f19150d = domainInfo;
        this.f19148b = e("http://" + this.f19150d.getFirst());
        this.f19149c = e("http://" + this.f19150d.getSecond());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(Throwable th) {
        t2.a.f9350a.q(this.f19150d, "key_epg");
    }

    public Observable c(String str) {
        String str2 = "/epg/live/app/" + str;
        return this.f19148b.b(str2).onErrorResumeNext(new a(str2)).observeOn(Schedulers.computation()).doOnError(new a(this));
    }

    public final qa.a e(String str) {
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(Proxy.NO_PROXY);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (qa.a) new Retrofit.Builder().client(builder.retryOnConnectionFailure(true).connectTimeout((long) this.f19147a, timeUnit).readTimeout((long) this.f19147a, timeUnit).writeTimeout((long) this.f19147a, timeUnit).dispatcher(new Dispatcher(na.a.f())).addInterceptor(new la.b()).dns(new c(".epg")).build()).baseUrl(str).addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync()).addConverterFactory(GsonConverterFactory.create()).build().create(qa.a.class);
    }
}
