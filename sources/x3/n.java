package x3;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.b;
import k3.j;
import m3.m;
import r3.c;
import r3.i;
import w3.d;

public class n extends d implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashSet f9694a;

    public Collection a(m mVar, c cVar) {
        b g10 = mVar.g();
        HashMap hashMap = new HashMap();
        if (this.f9694a != null) {
            Class e10 = cVar.e();
            Iterator it = this.f9694a.iterator();
            while (it.hasNext()) {
                w3.b bVar = (w3.b) it.next();
                if (e10.isAssignableFrom(bVar.b())) {
                    f(r3.d.m(mVar, bVar.b()), bVar, mVar, g10, hashMap);
                }
            }
        }
        f(cVar, new w3.b(cVar.e(), (String) null), mVar, g10, hashMap);
        return new ArrayList(hashMap.values());
    }

    public Collection b(m mVar, i iVar, j jVar) {
        Class cls;
        List<w3.b> a02;
        b g10 = mVar.g();
        if (jVar == null) {
            cls = iVar.e();
        } else {
            cls = jVar.q();
        }
        HashMap hashMap = new HashMap();
        LinkedHashSet linkedHashSet = this.f9694a;
        if (linkedHashSet != null) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                w3.b bVar = (w3.b) it.next();
                if (cls.isAssignableFrom(bVar.b())) {
                    f(r3.d.m(mVar, bVar.b()), bVar, mVar, g10, hashMap);
                }
            }
        }
        if (!(iVar == null || (a02 = g10.a0(iVar)) == null)) {
            for (w3.b bVar2 : a02) {
                f(r3.d.m(mVar, bVar2.b()), bVar2, mVar, g10, hashMap);
            }
        }
        f(r3.d.m(mVar, cls), new w3.b(cls, (String) null), mVar, g10, hashMap);
        return new ArrayList(hashMap.values());
    }

    public Collection c(m mVar, c cVar) {
        Class e10 = cVar.e();
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        g(cVar, new w3.b(e10, (String) null), mVar, hashSet, linkedHashMap);
        LinkedHashSet linkedHashSet = this.f9694a;
        if (linkedHashSet != null) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                w3.b bVar = (w3.b) it.next();
                if (e10.isAssignableFrom(bVar.b())) {
                    g(r3.d.m(mVar, bVar.b()), bVar, mVar, hashSet, linkedHashMap);
                }
            }
        }
        return h(e10, hashSet, linkedHashMap);
    }

    public Collection d(m mVar, i iVar, j jVar) {
        List<w3.b> a02;
        b g10 = mVar.g();
        Class q10 = jVar.q();
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        g(r3.d.m(mVar, q10), new w3.b(q10, (String) null), mVar, hashSet, linkedHashMap);
        if (!(iVar == null || (a02 = g10.a0(iVar)) == null)) {
            for (w3.b bVar : a02) {
                g(r3.d.m(mVar, bVar.b()), bVar, mVar, hashSet, linkedHashMap);
            }
        }
        LinkedHashSet linkedHashSet = this.f9694a;
        if (linkedHashSet != null) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                w3.b bVar2 = (w3.b) it.next();
                if (q10.isAssignableFrom(bVar2.b())) {
                    g(r3.d.m(mVar, bVar2.b()), bVar2, mVar, hashSet, linkedHashMap);
                }
            }
        }
        return h(q10, hashSet, linkedHashMap);
    }

    public void e(w3.b... bVarArr) {
        if (this.f9694a == null) {
            this.f9694a = new LinkedHashSet();
        }
        for (w3.b add : bVarArr) {
            this.f9694a.add(add);
        }
    }

    public void f(c cVar, w3.b bVar, m mVar, b bVar2, HashMap hashMap) {
        String b02;
        if (!bVar.c() && (b02 = bVar2.b0(cVar)) != null) {
            bVar = new w3.b(bVar.b(), b02);
        }
        w3.b bVar3 = new w3.b(bVar.b());
        if (!hashMap.containsKey(bVar3)) {
            hashMap.put(bVar3, bVar);
            List<w3.b> a02 = bVar2.a0(cVar);
            if (a02 != null && !a02.isEmpty()) {
                for (w3.b bVar4 : a02) {
                    f(r3.d.m(mVar, bVar4.b()), bVar4, mVar, bVar2, hashMap);
                }
            }
        } else if (bVar.c() && !((w3.b) hashMap.get(bVar3)).c()) {
            hashMap.put(bVar3, bVar);
        }
    }

    public void g(c cVar, w3.b bVar, m mVar, Set set, Map map) {
        List<w3.b> a02;
        String b02;
        b g10 = mVar.g();
        if (!bVar.c() && (b02 = g10.b0(cVar)) != null) {
            bVar = new w3.b(bVar.b(), b02);
        }
        if (bVar.c()) {
            map.put(bVar.a(), bVar);
        }
        if (set.add(bVar.b()) && (a02 = g10.a0(cVar)) != null && !a02.isEmpty()) {
            for (w3.b bVar2 : a02) {
                g(r3.d.m(mVar, bVar2.b()), bVar2, mVar, set, map);
            }
        }
    }

    public Collection h(Class cls, Set set, Map map) {
        ArrayList arrayList = new ArrayList(map.values());
        for (w3.b b10 : map.values()) {
            set.remove(b10.b());
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Class cls2 = (Class) it.next();
            if (cls2 != cls || !Modifier.isAbstract(cls2.getModifiers())) {
                arrayList.add(new w3.b(cls2));
            }
        }
        return arrayList;
    }
}
