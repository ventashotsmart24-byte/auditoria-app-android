package x3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import k3.e;
import k3.j;
import k3.q;
import m3.m;
import w3.b;

public class s extends r {

    /* renamed from: c  reason: collision with root package name */
    public final m f9716c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentHashMap f9717d;

    /* renamed from: e  reason: collision with root package name */
    public final Map f9718e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f9719f;

    public s(m mVar, j jVar, ConcurrentHashMap concurrentHashMap, HashMap hashMap) {
        super(jVar, mVar.z());
        this.f9716c = mVar;
        this.f9717d = concurrentHashMap;
        this.f9718e = hashMap;
        this.f9719f = mVar.D(q.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    public static String g(Class cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return name;
        }
        return name.substring(lastIndexOf + 1);
    }

    public static s i(m mVar, j jVar, Collection collection, boolean z10, boolean z11) {
        HashMap hashMap;
        ConcurrentHashMap concurrentHashMap;
        String str;
        if (z10 != z11) {
            if (z10) {
                concurrentHashMap = new ConcurrentHashMap();
                hashMap = null;
            } else {
                hashMap = new HashMap();
                concurrentHashMap = new ConcurrentHashMap(4);
            }
            boolean D = mVar.D(q.ACCEPT_CASE_INSENSITIVE_VALUES);
            if (collection != null) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    Class b10 = bVar.b();
                    if (bVar.c()) {
                        str = bVar.a();
                    } else {
                        str = g(b10);
                    }
                    if (z10) {
                        concurrentHashMap.put(b10.getName(), str);
                    }
                    if (z11) {
                        if (D) {
                            str = str.toLowerCase();
                        }
                        j jVar2 = (j) hashMap.get(str);
                        if (jVar2 == null || !b10.isAssignableFrom(jVar2.q())) {
                            hashMap.put(str, mVar.e(b10));
                        }
                    }
                }
            }
            return new s(mVar, jVar, concurrentHashMap, hashMap);
        }
        throw new IllegalArgumentException();
    }

    public String a(Object obj) {
        return j(obj.getClass());
    }

    public String b() {
        TreeSet treeSet = new TreeSet();
        for (Map.Entry entry : this.f9718e.entrySet()) {
            if (((j) entry.getValue()).C()) {
                treeSet.add(entry.getKey());
            }
        }
        return treeSet.toString();
    }

    public String d(Object obj, Class cls) {
        if (obj == null) {
            return j(cls);
        }
        return a(obj);
    }

    public j f(e eVar, String str) {
        return h(str);
    }

    public j h(String str) {
        if (this.f9719f) {
            str = str.toLowerCase();
        }
        return (j) this.f9718e.get(str);
    }

    public String j(Class cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        String str = (String) this.f9717d.get(name);
        if (str == null) {
            Class q10 = this.f9714a.H(cls).q();
            if (this.f9716c.C()) {
                str = this.f9716c.g().b0(this.f9716c.A(q10).u());
            }
            if (str == null) {
                str = g(q10);
            }
            this.f9717d.put(name, str);
        }
        return str;
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", new Object[]{getClass().getName(), this.f9718e});
    }
}
