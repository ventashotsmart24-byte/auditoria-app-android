package c5;

import android.content.Context;
import android.content.pm.PackageManager;
import com.dcs.bean.DomainInfo;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.bean.UpdateBean;
import d5.d;
import h7.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import j7.f;
import java.net.Proxy;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import m7.c;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f11360a;

    /* renamed from: b  reason: collision with root package name */
    public b f11361b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f11362c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f11363d;

    /* renamed from: e  reason: collision with root package name */
    public DomainInfo f11364e = t2.a.f9350a.b(c.j().first.toString(), c.j().second.toString(), "key_update");

    /* renamed from: c5.a$a  reason: collision with other inner class name */
    public class C0151a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h7.a f11365a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11366b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f11367c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f11368d;

        public C0151a(h7.a aVar, String str, String str2, String str3) {
            this.f11365a = aVar;
            this.f11366b = str;
            this.f11367c = str2;
            this.f11368d = str3;
        }

        /* renamed from: a */
        public void onNext(UpdateBean updateBean) {
            a aVar = a.this;
            aVar.k("main return result " + updateBean);
            this.f11365a.onOver(updateBean);
        }

        public void onComplete() {
            this.f11365a.onCompleted();
            a.this.k("main completed");
        }

        public void onError(Throwable th) {
            a aVar = a.this;
            aVar.k("main error " + th.toString());
            if (!(th instanceof NullPointerException) || !th.getMessage().contains("Null is not a valid element")) {
                h.e("updateA", th);
                a.this.j(this.f11366b, this.f11367c, this.f11368d, this.f11365a);
                return;
            }
            a.this.k("main check no update info");
            this.f11365a.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            Disposable unused = a.this.f11362c = disposable;
        }
    }

    public class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h7.a f11370a;

        public b(h7.a aVar) {
            this.f11370a = aVar;
        }

        /* renamed from: a */
        public void onNext(UpdateBean updateBean) {
            a aVar = a.this;
            aVar.k("second return result " + updateBean);
            this.f11370a.onOver(updateBean);
        }

        public void onComplete() {
            a.this.k("second completed");
            this.f11370a.onCompleted();
        }

        public void onError(Throwable th) {
            a aVar = a.this;
            aVar.k("second error " + th.toString());
            this.f11370a.onError(th);
            h.e("updateB", th);
            t2.a.f9350a.q(a.this.f11364e, "key_update");
        }

        public void onSubscribe(Disposable disposable) {
            Disposable unused = a.this.f11363d = disposable;
        }
    }

    public a(Dns dns, Interceptor interceptor) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(Proxy.NO_PROXY);
        OkHttpClient build = builder.connectTimeout(20, TimeUnit.SECONDS).addInterceptor(httpLoggingInterceptor).addInterceptor(interceptor).dns(dns).build();
        this.f11360a = l("http://" + this.f11364e.getFirst(), build);
        this.f11361b = l("http://" + this.f11364e.getSecond(), build);
    }

    public void f() {
        Disposable disposable = this.f11362c;
        if (disposable != null) {
            disposable.dispose();
            this.f11362c = null;
        }
        Disposable disposable2 = this.f11363d;
        if (disposable2 != null) {
            disposable2.dispose();
            this.f11363d = null;
        }
    }

    public void g(Context context, String str, String str2, h7.a aVar) {
        String packageName = context.getApplicationContext().getPackageName();
        int i10 = 0;
        try {
            i10 = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 0).versionCode;
            str = j7.c.a(str, "tvmarket");
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        h(packageName, i10, str, str2, aVar);
    }

    public void h(String str, int i10, String str2, String str3, h7.a aVar) {
        i(str + "," + i10, str2, str3, aVar);
    }

    public final void i(String str, String str2, String str3, h7.a aVar) {
        m(this.f11360a, str, str2, str3).subscribe(new C0151a(aVar, str, str2, str3));
    }

    public final void j(String str, String str2, String str3, h7.a aVar) {
        m(this.f11361b, str, str2, str3).subscribe(new b(aVar));
    }

    public final void k(String str) {
    }

    public final b l(String str, OkHttpClient okHttpClient) {
        return (b) new Retrofit.Builder().baseUrl(str).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(new d()).client(okHttpClient).build().create(b.class);
    }

    public final Observable m(b bVar, String str, String str2, String str3) {
        String str4;
        if ("zh".equals(Locale.getDefault().getLanguage())) {
            str4 = XML.DEFAULT_CONTENT_LANGUAGE;
        } else {
            str4 = Locale.getDefault().getLanguage();
        }
        String str5 = str4;
        if (str3.isEmpty()) {
            str3 = "unknown";
        }
        return bVar.a("checkUpdate", str, str5, str2, str3).compose(f.a());
    }
}
