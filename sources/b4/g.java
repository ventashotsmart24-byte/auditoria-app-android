package b4;

import com.fasterxml.jackson.databind.ser.std.b;
import java.util.Iterator;
import k3.c0;
import k3.d;
import k3.j;
import k3.o;
import w3.h;

public class g extends b {
    public g(j jVar, boolean z10, h hVar) {
        super(Iterator.class, jVar, z10, hVar, (o) null);
    }

    public a4.h c(h hVar) {
        return new g(this, this.f5731b, hVar, this.f5735f, this.f5733d);
    }

    public void i(Iterator it, c3.h hVar, c0 c0Var) {
        o oVar;
        h hVar2 = this.f5734e;
        k kVar = this.f5736g;
        do {
            Object next = it.next();
            if (next == null) {
                c0Var.E(hVar);
            } else {
                Class<?> cls = next.getClass();
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    if (this.f5730a.w()) {
                        oVar = f(kVar, c0Var.A(this.f5730a, cls), c0Var);
                    } else {
                        oVar = e(kVar, cls, c0Var);
                    }
                    j10 = oVar;
                    kVar = this.f5736g;
                }
                if (hVar2 == null) {
                    j10.serialize(next, hVar, c0Var);
                } else {
                    j10.serializeWithType(next, hVar, c0Var, hVar2);
                }
            }
        } while (it.hasNext());
    }

    /* renamed from: j */
    public boolean isEmpty(c0 c0Var, Iterator it) {
        return !it.hasNext();
    }

    /* renamed from: k */
    public final void serialize(Iterator it, c3.h hVar, c0 c0Var) {
        hVar.t0(it);
        g(it, hVar, c0Var);
        hVar.V();
    }

    /* renamed from: l */
    public void g(Iterator it, c3.h hVar, c0 c0Var) {
        if (it.hasNext()) {
            o oVar = this.f5735f;
            if (oVar == null) {
                i(it, hVar, c0Var);
                return;
            }
            h hVar2 = this.f5734e;
            do {
                Object next = it.next();
                if (next == null) {
                    c0Var.E(hVar);
                } else if (hVar2 == null) {
                    oVar.serialize(next, hVar, c0Var);
                } else {
                    oVar.serializeWithType(next, hVar, c0Var, hVar2);
                }
            } while (it.hasNext());
        }
    }

    /* renamed from: m */
    public g h(d dVar, h hVar, o oVar, Boolean bool) {
        return new g(this, dVar, hVar, oVar, bool);
    }

    public g(g gVar, d dVar, h hVar, o oVar, Boolean bool) {
        super((b) gVar, dVar, hVar, oVar, bool);
    }
}
