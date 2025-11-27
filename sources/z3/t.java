package z3;

import c3.a;
import c3.b;
import c3.h;
import c3.k;
import c3.n;
import j3.c;
import k3.c0;

public class t extends v {

    /* renamed from: b  reason: collision with root package name */
    public static final t f9988b = new t("");

    /* renamed from: a  reason: collision with root package name */
    public final String f9989a;

    public t(String str) {
        this.f9989a = str;
    }

    public static t w(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return f9988b;
        }
        return new t(str);
    }

    public n b() {
        return n.VALUE_STRING;
    }

    public final void d(h hVar, c0 c0Var) {
        String str = this.f9989a;
        if (str == null) {
            hVar.a0();
        } else {
            hVar.z0(str);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof t)) {
            return ((t) obj).f9989a.equals(this.f9989a);
        }
        return false;
    }

    public String g() {
        return this.f9989a;
    }

    public int hashCode() {
        return this.f9989a.hashCode();
    }

    public byte[] i() {
        return v(b.a());
    }

    public m o() {
        return m.STRING;
    }

    public String u() {
        return this.f9989a;
    }

    public byte[] v(a aVar) {
        String trim = this.f9989a.trim();
        c cVar = new c(Math.max(16, Math.min(65536, ((trim.length() >> 2) * 3) + 4)));
        try {
            aVar.e(trim, cVar);
            return cVar.v();
        } catch (IllegalArgumentException e10) {
            throw p3.c.v((k) null, String.format("Cannot access contents of TextNode as binary due to broken Base64 encoding: %s", new Object[]{e10.getMessage()}), trim, byte[].class);
        }
    }
}
