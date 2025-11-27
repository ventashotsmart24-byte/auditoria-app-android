package o3;

import c3.k;
import d4.q;
import d4.y;
import java.util.ArrayList;
import java.util.List;
import k3.g;
import n3.t;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final List f8476a;

    public d0() {
        this.f8476a = new ArrayList();
    }

    public void a(t tVar) {
        this.f8476a.add(tVar);
    }

    public Object b(k kVar, g gVar, Object obj, y yVar) {
        int size = this.f8476a.size();
        for (int i10 = 0; i10 < size; i10++) {
            k R0 = yVar.R0();
            R0.s0();
            ((t) this.f8476a.get(i10)).l(R0, gVar, obj);
        }
        return obj;
    }

    public d0 c(q qVar) {
        k3.k unwrappingDeserializer;
        ArrayList arrayList = new ArrayList(this.f8476a.size());
        for (t tVar : this.f8476a) {
            t K = tVar.K(qVar.c(tVar.getName()));
            k3.k u10 = K.u();
            if (!(u10 == null || (unwrappingDeserializer = u10.unwrappingDeserializer(qVar)) == u10)) {
                K = K.L(unwrappingDeserializer);
            }
            arrayList.add(K);
        }
        return new d0(arrayList);
    }

    public d0(List list) {
        this.f8476a = list;
    }
}
