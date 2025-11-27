package g1;

import h1.d;
import j1.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class c implements f1.a {

    /* renamed from: a  reason: collision with root package name */
    public final List f6755a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Object f6756b;

    /* renamed from: c  reason: collision with root package name */
    public d f6757c;

    /* renamed from: d  reason: collision with root package name */
    public a f6758d;

    public interface a {
        void a(List list);

        void b(List list);
    }

    public c(d dVar) {
        this.f6757c = dVar;
    }

    public void a(Object obj) {
        this.f6756b = obj;
        h(this.f6758d, obj);
    }

    public abstract boolean b(p pVar);

    public abstract boolean c(Object obj);

    public boolean d(String str) {
        Object obj = this.f6756b;
        if (obj == null || !c(obj) || !this.f6755a.contains(str)) {
            return false;
        }
        return true;
    }

    public void e(Iterable iterable) {
        this.f6755a.clear();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (b(pVar)) {
                this.f6755a.add(pVar.f7089a);
            }
        }
        if (this.f6755a.isEmpty()) {
            this.f6757c.c(this);
        } else {
            this.f6757c.a(this);
        }
        h(this.f6758d, this.f6756b);
    }

    public void f() {
        if (!this.f6755a.isEmpty()) {
            this.f6755a.clear();
            this.f6757c.c(this);
        }
    }

    public void g(a aVar) {
        if (this.f6758d != aVar) {
            this.f6758d = aVar;
            h(aVar, this.f6756b);
        }
    }

    public final void h(a aVar, Object obj) {
        if (!this.f6755a.isEmpty() && aVar != null) {
            if (obj == null || c(obj)) {
                aVar.b(this.f6755a);
            } else {
                aVar.a(this.f6755a);
            }
        }
    }
}
