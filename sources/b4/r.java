package b4;

import a4.c;
import c3.h;
import d4.q;
import f3.i;
import java.util.Iterator;
import java.util.Map;
import k3.c0;
import k3.j;
import k3.m;
import k3.o;

public class r extends c {

    /* renamed from: u  reason: collision with root package name */
    public final q f4378u;

    public r(c cVar, q qVar) {
        super(cVar);
        this.f4378u = qVar;
    }

    public r F(q qVar, i iVar) {
        return new r(this, qVar, iVar);
    }

    /* renamed from: G */
    public r w(q qVar) {
        return F(q.a(qVar, this.f4378u), new i(qVar.c(this.f185c.getValue())));
    }

    public void g(z3.r rVar, m mVar) {
        m n10 = mVar.n("properties");
        if (n10 != null) {
            Iterator m10 = n10.m();
            while (m10.hasNext()) {
                Map.Entry entry = (Map.Entry) m10.next();
                String str = (String) entry.getKey();
                q qVar = this.f4378u;
                if (qVar != null) {
                    str = qVar.c(str);
                }
                rVar.G(str, (m) entry.getValue());
            }
        }
    }

    public o h(k kVar, Class cls, c0 c0Var) {
        o oVar;
        j jVar = this.f189g;
        if (jVar != null) {
            oVar = c0Var.U(c0Var.A(jVar, cls), this);
        } else {
            oVar = c0Var.S(cls, this);
        }
        q qVar = this.f4378u;
        if (oVar.isUnwrappingSerializer() && (oVar instanceof s)) {
            qVar = q.a(qVar, ((s) oVar).f4379k);
        }
        o unwrappingSerializer = oVar.unwrappingSerializer(qVar);
        this.f197o = this.f197o.i(cls, unwrappingSerializer);
        return unwrappingSerializer;
    }

    public void l(o oVar) {
        if (oVar != null) {
            q qVar = this.f4378u;
            if (oVar.isUnwrappingSerializer() && (oVar instanceof s)) {
                qVar = q.a(qVar, ((s) oVar).f4379k);
            }
            oVar = oVar.unwrappingSerializer(qVar);
        }
        super.l(oVar);
    }

    public void y(Object obj, h hVar, c0 c0Var) {
        Object p10 = p(obj);
        if (p10 != null) {
            o oVar = this.f194l;
            if (oVar == null) {
                Class<?> cls = p10.getClass();
                k kVar = this.f197o;
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    oVar = h(kVar, cls, c0Var);
                } else {
                    oVar = j10;
                }
            }
            Object obj2 = this.f199q;
            if (obj2 != null) {
                if (c.f184t == obj2) {
                    if (oVar.isEmpty(c0Var, p10)) {
                        return;
                    }
                } else if (obj2.equals(p10)) {
                    return;
                }
            }
            if (p10 != obj || !i(obj, hVar, c0Var, oVar)) {
                if (!oVar.isUnwrappingSerializer()) {
                    hVar.Y(this.f185c);
                }
                w3.h hVar2 = this.f196n;
                if (hVar2 == null) {
                    oVar.serialize(p10, hVar, c0Var);
                } else {
                    oVar.serializeWithType(p10, hVar, c0Var, hVar2);
                }
            }
        }
    }

    public r(r rVar, q qVar, i iVar) {
        super((c) rVar, iVar);
        this.f4378u = qVar;
    }
}
