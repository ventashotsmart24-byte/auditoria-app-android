package s8;

import io.reactivex.Completable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.CancellationException;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Function f19476a = new C0284a();

    /* renamed from: b  reason: collision with root package name */
    public static final Predicate f19477b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final Function f19478c = new c();

    /* renamed from: s8.a$a  reason: collision with other inner class name */
    public static class C0284a implements Function {
        /* renamed from: a */
        public Boolean apply(Throwable th) {
            if (th instanceof c) {
                return Boolean.TRUE;
            }
            Exceptions.propagate(th);
            return Boolean.FALSE;
        }
    }

    public static class b implements Predicate {
        /* renamed from: a */
        public boolean test(Boolean bool) {
            return bool.booleanValue();
        }
    }

    public static class c implements Function {
        /* renamed from: a */
        public Completable apply(Object obj) {
            return Completable.error((Throwable) new CancellationException());
        }
    }
}
