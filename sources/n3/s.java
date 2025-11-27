package n3;

import c3.n;
import d4.h;
import java.io.Closeable;
import java.io.Serializable;
import java.util.Map;
import k3.d;
import k3.f;
import k3.j;
import k3.k;
import k3.l;
import k3.p;
import k3.q;
import o3.z;
import r3.g;
import r3.i;
import w3.e;

public class s implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final d f8281a;

    /* renamed from: b  reason: collision with root package name */
    public final i f8282b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f8283c;

    /* renamed from: d  reason: collision with root package name */
    public final j f8284d;

    /* renamed from: e  reason: collision with root package name */
    public k f8285e;

    /* renamed from: f  reason: collision with root package name */
    public final e f8286f;

    /* renamed from: g  reason: collision with root package name */
    public final p f8287g;

    public static class a extends z.a {

        /* renamed from: c  reason: collision with root package name */
        public final s f8288c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f8289d;

        /* renamed from: e  reason: collision with root package name */
        public final String f8290e;

        public a(s sVar, u uVar, Class cls, Object obj, String str) {
            super(uVar, cls);
            this.f8288c = sVar;
            this.f8289d = obj;
            this.f8290e = str;
        }
    }

    public s(d dVar, i iVar, j jVar, p pVar, k kVar, e eVar) {
        this.f8281a = dVar;
        this.f8282b = iVar;
        this.f8284d = jVar;
        this.f8285e = kVar;
        this.f8286f = eVar;
        this.f8287g = pVar;
        this.f8283c = iVar instanceof g;
    }

    public void a(Exception exc, Object obj, Object obj2) {
        if (exc instanceof IllegalArgumentException) {
            String h10 = h.h(obj2);
            StringBuilder sb = new StringBuilder("Problem deserializing \"any\" property '");
            sb.append(obj);
            sb.append("' of class " + e() + " (expected type: ");
            sb.append(this.f8284d);
            sb.append("; actual type: ");
            sb.append(h10);
            sb.append(")");
            String o10 = h.o(exc);
            if (o10 != null) {
                sb.append(", problem: ");
                sb.append(o10);
            } else {
                sb.append(" (no error message provided)");
            }
            throw new l((Closeable) null, sb.toString(), (Throwable) exc);
        }
        h.i0(exc);
        h.j0(exc);
        Throwable F = h.F(exc);
        throw new l((Closeable) null, h.o(F), F);
    }

    public Object b(c3.k kVar, k3.g gVar) {
        if (kVar.j0(n.VALUE_NULL)) {
            return this.f8285e.getNullValue(gVar);
        }
        e eVar = this.f8286f;
        if (eVar != null) {
            return this.f8285e.deserializeWithType(kVar, gVar, eVar);
        }
        return this.f8285e.deserialize(kVar, gVar);
    }

    public final void c(c3.k kVar, k3.g gVar, Object obj, String str) {
        Object obj2;
        try {
            p pVar = this.f8287g;
            if (pVar == null) {
                obj2 = str;
            } else {
                obj2 = pVar.a(str, gVar);
            }
            i(obj, obj2, b(kVar, gVar));
        } catch (u e10) {
            if (this.f8285e.getObjectIdReader() != null) {
                e10.t().a(new a(this, e10, this.f8284d.q(), obj, str));
                return;
            }
            throw l.i(kVar, "Unresolved forward reference but no identity info.", e10);
        }
    }

    public void d(f fVar) {
        this.f8282b.i(fVar.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public final String e() {
        return this.f8282b.k().getName();
    }

    public d f() {
        return this.f8281a;
    }

    public j g() {
        return this.f8284d;
    }

    public boolean h() {
        if (this.f8285e != null) {
            return true;
        }
        return false;
    }

    public void i(Object obj, Object obj2, Object obj3) {
        try {
            if (this.f8283c) {
                Map map = (Map) ((g) this.f8282b).n(obj);
                if (map != null) {
                    map.put(obj2, obj3);
                    return;
                }
                return;
            }
            ((r3.j) this.f8282b).z(obj, obj2, obj3);
        } catch (Exception e10) {
            a(e10, obj2, obj3);
        }
    }

    public s j(k kVar) {
        return new s(this.f8281a, this.f8282b, this.f8284d, this.f8287g, kVar, this.f8286f);
    }

    public String toString() {
        return "[any property on class " + e() + "]";
    }
}
