package x3;

import b3.e0;
import c3.k;
import c3.n;
import d4.h;
import d4.y;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import k3.d;
import k3.g;
import k3.j;
import k3.q;
import r3.s;
import w3.b;
import w3.e;
import w3.f;

public class c extends g {

    /* renamed from: m  reason: collision with root package name */
    public static final BitSet f9683m = new BitSet(0);

    /* renamed from: k  reason: collision with root package name */
    public final Map f9684k;

    /* renamed from: l  reason: collision with root package name */
    public final Map f9685l;

    public c(j jVar, f fVar, j jVar2, k3.f fVar2, Collection collection) {
        super(jVar, fVar, (String) null, false, jVar2, (e0.a) null);
        this.f9684k = new HashMap();
        this.f9685l = y(fVar2, collection);
    }

    public static void z(List list, int i10) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((BitSet) it.next()).get(i10)) {
                it.remove();
            }
        }
    }

    public Object e(k kVar, g gVar) {
        String str;
        n n10 = kVar.n();
        if (n10 == n.START_OBJECT) {
            n10 = kVar.s0();
        } else if (n10 != n.FIELD_NAME) {
            return x(kVar, gVar, (y) null, "Unexpected input");
        }
        if (n10 == n.END_OBJECT && (str = (String) this.f9685l.get(f9683m)) != null) {
            return w(kVar, gVar, (y) null, str);
        }
        LinkedList linkedList = new LinkedList(this.f9685l.keySet());
        y yVar = new y(kVar, gVar);
        boolean o02 = gVar.o0(q.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            if (o02) {
                m10 = m10.toLowerCase();
            }
            yVar.V0(kVar);
            Integer num = (Integer) this.f9684k.get(m10);
            if (num != null) {
                z(linkedList, num.intValue());
                if (linkedList.size() == 1) {
                    return w(kVar, gVar, yVar, (String) this.f9685l.get(linkedList.get(0)));
                }
            }
            n10 = kVar.s0();
        }
        return x(kVar, gVar, yVar, String.format("Cannot deduce unique subtype of %s (%d candidates match)", new Object[]{h.G(this.f9707b), Integer.valueOf(linkedList.size())}));
    }

    public e g(d dVar) {
        if (dVar == this.f9708c) {
            return this;
        }
        return new c(this, dVar);
    }

    public Map y(k3.f fVar, Collection collection) {
        boolean D = fVar.D(q.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        HashMap hashMap = new HashMap();
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            List<s> o10 = fVar.g0(fVar.z().H(bVar.b())).o();
            BitSet bitSet = new BitSet(o10.size() + i10);
            for (s name : o10) {
                String name2 = name.getName();
                if (D) {
                    name2 = name2.toLowerCase();
                }
                Integer num = (Integer) this.f9684k.get(name2);
                if (num == null) {
                    num = Integer.valueOf(i10);
                    this.f9684k.put(name2, Integer.valueOf(i10));
                    i10++;
                }
                bitSet.set(num.intValue());
            }
            String str = (String) hashMap.put(bitSet, bVar.b().getName());
            if (str != null) {
                throw new IllegalStateException(String.format("Subtypes %s and %s have the same signature and cannot be uniquely deduced.", new Object[]{str, bVar.b().getName()}));
            }
        }
        return hashMap;
    }

    public c(c cVar, d dVar) {
        super(cVar, dVar);
        this.f9684k = cVar.f9684k;
        this.f9685l = cVar.f9685l;
    }
}
