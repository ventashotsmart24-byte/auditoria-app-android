package ka;

import okhttp3.Interceptor;
import okhttp3.Response;

public class c implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public d f18238a;

    public c(d dVar) {
        this.f18238a = dVar;
    }

    public Response intercept(Interceptor.Chain chain) {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new e(proceed.body(), this.f18238a)).build();
    }
}
