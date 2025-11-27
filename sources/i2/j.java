package i2;

import h9.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import t9.g;
import t9.i;

public final class j {

    /* renamed from: c  reason: collision with root package name */
    public static final b f7023c = new b((g) null);

    /* renamed from: d  reason: collision with root package name */
    public static final h9.g f7024d = h.b(a.f7027a);

    /* renamed from: a  reason: collision with root package name */
    public Disposable f7025a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7026b;

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f7027a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final j invoke() {
            return new j((g) null);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final j a() {
            return (j) j.f7024d.getValue();
        }
    }

    public interface c {
        void a();
    }

    public static final class d implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f7028a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f7029b;

        public d(j jVar, c cVar) {
            this.f7028a = jVar;
            this.f7029b = cVar;
        }

        public void a(long j10) {
            c cVar = this.f7029b;
            if (cVar != null) {
                cVar.a();
            }
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            i.g(th, "e");
        }

        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            a(((Number) obj).longValue());
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "disposable");
            this.f7028a.f7025a = disposable;
        }
    }

    public /* synthetic */ j(g gVar) {
        this();
    }

    public final void c() {
        Disposable disposable;
        Disposable disposable2 = this.f7025a;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f7025a) != null) {
            disposable.dispose();
        }
    }

    public final void d(long j10, long j11, c cVar) {
        Observable.interval(j10, j11, TimeUnit.SECONDS).compose(s2.c.b()).safeSubscribe(new d(this, cVar));
    }

    public j() {
        this.f7026b = j.class.getSimpleName();
    }
}
