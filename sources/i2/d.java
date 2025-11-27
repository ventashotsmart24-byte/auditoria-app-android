package i2;

import h9.h;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import t9.g;
import t9.i;
import t9.j;

public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final b f7007c = new b((g) null);

    /* renamed from: d  reason: collision with root package name */
    public static final h9.g f7008d = h.b(a.f7011a);

    /* renamed from: a  reason: collision with root package name */
    public Disposable f7009a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7010b;

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f7011a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final d invoke() {
            return new d((g) null);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final d a() {
            return (d) d.f7008d.getValue();
        }
    }

    public interface c {
        void a();
    }

    /* renamed from: i2.d$d  reason: collision with other inner class name */
    public static final class C0090d implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f7012a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f7013b;

        public C0090d(d dVar, c cVar) {
            this.f7012a = dVar;
            this.f7013b = cVar;
        }

        /* renamed from: a */
        public void onNext(String str) {
            c cVar;
            i.g(str, "s");
            Disposable c10 = this.f7012a.f7009a;
            boolean z10 = false;
            if (c10 != null && !c10.isDisposed()) {
                z10 = true;
            }
            if (z10 && (cVar = this.f7013b) != null) {
                cVar.a();
            }
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            i.g(th, "e");
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            this.f7012a.f7009a = disposable;
        }
    }

    public /* synthetic */ d(g gVar) {
        this();
    }

    public static final void g(ObservableEmitter observableEmitter) {
        i.g(observableEmitter, "emitter");
        observableEmitter.onNext("insert");
        observableEmitter.onComplete();
    }

    public final void e() {
        Disposable disposable;
        Disposable disposable2 = this.f7009a;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f7009a) != null) {
            disposable.dispose();
        }
    }

    public final void f(c cVar) {
        Observable.create(new c()).compose(s2.c.b()).subscribe(new C0090d(this, cVar));
    }

    public d() {
        this.f7010b = d.class.getSimpleName();
    }
}
