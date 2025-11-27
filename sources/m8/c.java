package m8;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import t9.i;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Disposable f18978a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18979b = "RxTimerUtil";

    public interface a {
        void a(String str);
    }

    public static final class b implements Function {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s9.a f18980a;

        public b(s9.a aVar) {
            this.f18980a = aVar;
        }

        /* renamed from: a */
        public final String apply(Long l10) {
            i.h(l10, "it");
            return (String) this.f18980a.invoke();
        }
    }

    /* renamed from: m8.c$c  reason: collision with other inner class name */
    public static final class C0275c implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18981a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f18982b;

        public C0275c(c cVar, a aVar) {
            this.f18981a = cVar;
            this.f18982b = aVar;
        }

        /* renamed from: a */
        public void onNext(String str) {
            i.h(str, "programData");
            a aVar = this.f18982b;
            if (aVar != null) {
                aVar.a(str);
            }
        }

        public void onComplete() {
            String unused = this.f18981a.f18979b;
        }

        public void onError(Throwable th) {
            i.h(th, "e");
        }

        public void onSubscribe(Disposable disposable) {
            i.h(disposable, "disposable");
            this.f18981a.f18978a = disposable;
        }
    }

    public final void c() {
        Disposable disposable;
        Disposable disposable2 = this.f18978a;
        if (!(disposable2 == null || disposable2.isDisposed() || (disposable = this.f18978a) == null)) {
            disposable.dispose();
        }
        this.f18978a = null;
    }

    public final void d(long j10, s9.a aVar, a aVar2) {
        i.h(aVar, "subscribe");
        Observable.interval(j10, TimeUnit.SECONDS).map(new b(aVar)).compose(b.a()).subscribe(new C0275c(this, aVar2));
    }
}
