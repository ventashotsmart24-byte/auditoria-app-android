package o3;

import b3.k0;
import b3.o0;
import c3.i;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import k3.g;
import k3.j;
import n3.u;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public final k0.a f8563a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList f8564b;

    public z(k0.a aVar) {
        this.f8563a = aVar;
    }

    public void a(a aVar) {
        if (this.f8564b == null) {
            this.f8564b = new LinkedList();
        }
        this.f8564b.add(aVar);
    }

    public void b(Object obj) {
        throw null;
    }

    public k0.a c() {
        return this.f8563a;
    }

    public boolean d() {
        LinkedList linkedList = this.f8564b;
        if (linkedList == null || linkedList.isEmpty()) {
            return false;
        }
        return true;
    }

    public Iterator e() {
        LinkedList linkedList = this.f8564b;
        if (linkedList == null) {
            return Collections.emptyList().iterator();
        }
        return linkedList.iterator();
    }

    public Object f() {
        throw null;
    }

    public void g(o0 o0Var) {
    }

    public boolean h(g gVar) {
        return false;
    }

    public String toString() {
        return String.valueOf(this.f8563a);
    }

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final u f8565a;

        /* renamed from: b  reason: collision with root package name */
        public final Class f8566b;

        public a(u uVar, Class cls) {
            this.f8565a = uVar;
            this.f8566b = cls;
        }

        public Class a() {
            return this.f8566b;
        }

        public i b() {
            return this.f8565a.a();
        }

        public a(u uVar, j jVar) {
            this.f8565a = uVar;
            this.f8566b = jVar.q();
        }
    }
}
