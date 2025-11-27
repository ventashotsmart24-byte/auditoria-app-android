package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.d;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public final h f2333a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f2334b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public a f2335c;

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final h f2336a;

        /* renamed from: b  reason: collision with root package name */
        public final d.b f2337b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2338c = false;

        public a(h hVar, d.b bVar) {
            this.f2336a = hVar;
            this.f2337b = bVar;
        }

        public void run() {
            if (!this.f2338c) {
                this.f2336a.h(this.f2337b);
                this.f2338c = true;
            }
        }
    }

    public u(g gVar) {
        this.f2333a = new h(gVar);
    }

    public d a() {
        return this.f2333a;
    }

    public void b() {
        f(d.b.ON_START);
    }

    public void c() {
        f(d.b.ON_CREATE);
    }

    public void d() {
        f(d.b.ON_STOP);
        f(d.b.ON_DESTROY);
    }

    public void e() {
        f(d.b.ON_START);
    }

    public final void f(d.b bVar) {
        a aVar = this.f2335c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f2333a, bVar);
        this.f2335c = aVar2;
        this.f2334b.postAtFrontOfQueue(aVar2);
    }
}
