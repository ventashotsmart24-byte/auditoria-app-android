package a4;

import c3.h;
import com.fasterxml.jackson.databind.ser.std.t;
import java.util.Map;
import k3.a0;
import k3.c0;
import k3.d;
import k3.o;
import k3.q;
import r3.i;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final d f175a;

    /* renamed from: b  reason: collision with root package name */
    public final i f176b;

    /* renamed from: c  reason: collision with root package name */
    public o f177c;

    /* renamed from: d  reason: collision with root package name */
    public t f178d;

    public a(d dVar, i iVar, o oVar) {
        this.f176b = iVar;
        this.f175a = dVar;
        this.f177c = oVar;
        if (oVar instanceof t) {
            this.f178d = (t) oVar;
        }
    }

    public void a(a0 a0Var) {
        this.f176b.i(a0Var.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public void b(Object obj, h hVar, c0 c0Var) {
        Object n10 = this.f176b.n(obj);
        if (n10 != null) {
            if (!(n10 instanceof Map)) {
                c0Var.q(this.f175a.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", new Object[]{this.f176b.d(), n10.getClass().getName()}));
            }
            t tVar = this.f178d;
            if (tVar != null) {
                tVar.w((Map) n10, hVar, c0Var);
            } else {
                this.f177c.serialize(n10, hVar, c0Var);
            }
        }
    }

    public void c(c0 c0Var) {
        o oVar = this.f177c;
        if (oVar instanceof i) {
            o h02 = c0Var.h0(oVar, this.f175a);
            this.f177c = h02;
            if (h02 instanceof t) {
                this.f178d = (t) h02;
            }
        }
    }
}
