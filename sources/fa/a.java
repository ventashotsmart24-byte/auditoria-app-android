package fa;

import io.reactivex.functions.Function;
import retrofit2.adapter.rxjava2.HttpException;

public abstract class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public int f16849a = 200;

    public abstract Object a(Object obj);

    public Object apply(Object obj) {
        b((Throwable) obj);
        return a(obj);
    }

    public final void b(Throwable th) {
        if (th == null || !(th instanceof HttpException)) {
            this.f16849a = -1;
        } else {
            this.f16849a = ((HttpException) th).code();
        }
    }
}
