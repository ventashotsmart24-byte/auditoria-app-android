package ka;

import android.text.TextUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import ja.c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import ma.f;
import ma.r;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Retrofit f18232a;

    /* renamed from: b  reason: collision with root package name */
    public d f18233b;

    /* renamed from: c  reason: collision with root package name */
    public String f18234c;

    public class a implements Consumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f18235a;

        public a(File file) {
            this.f18235a = file;
        }

        /* renamed from: a */
        public void accept(InputStream inputStream) {
            b.this.c(inputStream, this.f18235a);
        }
    }

    /* renamed from: ka.b$b  reason: collision with other inner class name */
    public class C0256b implements Function {
        public C0256b() {
        }

        /* renamed from: a */
        public InputStream apply(ResponseBody responseBody) {
            return responseBody.byteStream();
        }
    }

    public b(String str, d dVar) {
        try {
            str = TextUtils.isEmpty(str) ? "http://www.baidu.com" : str;
            this.f18234c = str;
            this.f18233b = dVar;
            c cVar = new c(dVar);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.proxy(Proxy.NO_PROXY);
            builder.addInterceptor(cVar).retryOnConnectionFailure(true).connectTimeout(15, TimeUnit.SECONDS).addInterceptor(new la.a(".subtitle")).dns(new c(".subtitle"));
            X509TrustManager a10 = f.a();
            if (a10 != null) {
                builder.sslSocketFactory(new r(a10), a10);
            }
            this.f18232a = new Retrofit.Builder().baseUrl(str).client(builder.build()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void b(String str, File file, Observer observer) {
        try {
            ((a) this.f18232a.create(a.class)).a(str).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).map(new C0256b()).observeOn(Schedulers.computation()).doOnNext(new a(file)).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void c(InputStream inputStream, File file) {
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (FileNotFoundException e10) {
            this.f18233b.c(e10);
        } catch (IOException e11) {
            this.f18233b.c(e11);
        } catch (Exception e12) {
            this.f18233b.c(e12);
        }
    }
}
