package z3;

import c3.a;
import c3.b;
import c3.h;
import c3.n;
import java.util.Arrays;
import k3.c0;

public class d extends v {

    /* renamed from: b  reason: collision with root package name */
    public static final d f9940b = new d(new byte[0]);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f9941a;

    public d(byte[] bArr) {
        this.f9941a = bArr;
    }

    public static d v(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return f9940b;
        }
        return new d(bArr);
    }

    public n b() {
        return n.VALUE_EMBEDDED_OBJECT;
    }

    public final void d(h hVar, c0 c0Var) {
        a h10 = c0Var.k().h();
        byte[] bArr = this.f9941a;
        hVar.R(h10, bArr, 0, bArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof d)) {
            return Arrays.equals(((d) obj).f9941a, this.f9941a);
        }
        return false;
    }

    public String g() {
        return b.a().i(this.f9941a, false);
    }

    public int hashCode() {
        byte[] bArr = this.f9941a;
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }

    public byte[] i() {
        return this.f9941a;
    }

    public m o() {
        return m.BINARY;
    }
}
