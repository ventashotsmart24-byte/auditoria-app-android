package s8;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public abstract class d {

    public static class a implements Predicate {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f19480a;

        public a(Object obj) {
            this.f19480a = obj;
        }

        public boolean test(Object obj) {
            return obj.equals(this.f19480a);
        }
    }

    public static class b implements BiFunction {
        /* renamed from: a */
        public Boolean apply(Object obj, Object obj2) {
            return Boolean.valueOf(obj2.equals(obj));
        }
    }

    public static b a(Observable observable) {
        return new b(observable);
    }

    public static b b(Observable observable, Function function) {
        v8.a.a(observable, "lifecycle == null");
        v8.a.a(function, "correspondingEvents == null");
        return a(d(observable.share(), function));
    }

    public static b c(Observable observable, Object obj) {
        v8.a.a(observable, "lifecycle == null");
        v8.a.a(obj, "event == null");
        return a(e(observable, obj));
    }

    public static Observable d(Observable observable, Function function) {
        return Observable.combineLatest(observable.take(1).map(function), observable.skip(1), new b()).onErrorReturn(a.f19476a).filter(a.f19477b);
    }

    public static Observable e(Observable observable, Object obj) {
        return observable.filter(new a(obj));
    }
}
