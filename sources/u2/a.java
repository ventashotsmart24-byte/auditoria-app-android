package u2;

import io.reactivex.functions.Function;
import retrofit2.HttpException;

public abstract class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public int f9437a = 200;

    public abstract Object a(Object obj);

    public Object apply(Object obj) {
        c((Throwable) obj);
        return a(obj);
    }

    public int b() {
        return this.f9437a;
    }

    public final void c(Throwable th) {
        if (th == null || !(th instanceof HttpException)) {
            this.f9437a = -1;
        } else {
            this.f9437a = ((HttpException) th).code();
        }
    }
}
