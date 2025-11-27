package androidx.activity;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f491a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque f492b = new ArrayDeque();

    public class LifecycleOnBackPressedCancellable implements e, a {

        /* renamed from: a  reason: collision with root package name */
        public final d f493a;

        /* renamed from: b  reason: collision with root package name */
        public final b f494b;

        /* renamed from: c  reason: collision with root package name */
        public a f495c;

        public LifecycleOnBackPressedCancellable(d dVar, b bVar) {
            this.f493a = dVar;
            this.f494b = bVar;
            dVar.a(this);
        }

        public void a(g gVar, d.b bVar) {
            if (bVar == d.b.ON_START) {
                this.f495c = OnBackPressedDispatcher.this.b(this.f494b);
            } else if (bVar == d.b.ON_STOP) {
                a aVar = this.f495c;
                if (aVar != null) {
                    aVar.cancel();
                }
            } else if (bVar == d.b.ON_DESTROY) {
                cancel();
            }
        }

        public void cancel() {
            this.f493a.c(this);
            this.f494b.e(this);
            a aVar = this.f495c;
            if (aVar != null) {
                aVar.cancel();
                this.f495c = null;
            }
        }
    }

    public class a implements a {

        /* renamed from: a  reason: collision with root package name */
        public final b f497a;

        public a(b bVar) {
            this.f497a = bVar;
        }

        public void cancel() {
            OnBackPressedDispatcher.this.f492b.remove(this.f497a);
            this.f497a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f491a = runnable;
    }

    public void a(g gVar, b bVar) {
        d lifecycle = gVar.getLifecycle();
        if (lifecycle.b() != d.c.DESTROYED) {
            bVar.a(new LifecycleOnBackPressedCancellable(lifecycle, bVar));
        }
    }

    public a b(b bVar) {
        this.f492b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator descendingIterator = this.f492b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b bVar = (b) descendingIterator.next();
            if (bVar.c()) {
                bVar.b();
                return;
            }
        }
        Runnable runnable = this.f491a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
