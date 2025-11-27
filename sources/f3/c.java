package f3;

import c3.e;
import j3.a;
import j3.o;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f6573a;

    /* renamed from: b  reason: collision with root package name */
    public e f6574b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6575c;

    /* renamed from: d  reason: collision with root package name */
    public final a f6576d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f6577e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6578f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f6579g;

    /* renamed from: h  reason: collision with root package name */
    public char[] f6580h;

    /* renamed from: i  reason: collision with root package name */
    public char[] f6581i;

    public c(a aVar, Object obj, boolean z10) {
        this.f6576d = aVar;
        this.f6573a = obj;
        this.f6575c = z10;
    }

    public final void a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    public final void b(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw r();
        }
    }

    public final void c(char[] cArr, char[] cArr2) {
        if (cArr != cArr2 && cArr.length < cArr2.length) {
            throw r();
        }
    }

    public byte[] d() {
        a(this.f6578f);
        byte[] a10 = this.f6576d.a(3);
        this.f6578f = a10;
        return a10;
    }

    public char[] e() {
        a(this.f6580h);
        char[] c10 = this.f6576d.c(1);
        this.f6580h = c10;
        return c10;
    }

    public char[] f(int i10) {
        a(this.f6581i);
        char[] d10 = this.f6576d.d(3, i10);
        this.f6581i = d10;
        return d10;
    }

    public char[] g() {
        a(this.f6579g);
        char[] c10 = this.f6576d.c(0);
        this.f6579g = c10;
        return c10;
    }

    public byte[] h() {
        a(this.f6577e);
        byte[] a10 = this.f6576d.a(1);
        this.f6577e = a10;
        return a10;
    }

    public o i() {
        return new o(this.f6576d);
    }

    public Object j() {
        return this.f6573a;
    }

    public boolean k() {
        return this.f6575c;
    }

    public void l(byte[] bArr) {
        if (bArr != null) {
            b(bArr, this.f6578f);
            this.f6578f = null;
            this.f6576d.i(3, bArr);
        }
    }

    public void m(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.f6580h);
            this.f6580h = null;
            this.f6576d.j(1, cArr);
        }
    }

    public void n(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.f6581i);
            this.f6581i = null;
            this.f6576d.j(3, cArr);
        }
    }

    public void o(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.f6579g);
            this.f6579g = null;
            this.f6576d.j(0, cArr);
        }
    }

    public void p(byte[] bArr) {
        if (bArr != null) {
            b(bArr, this.f6577e);
            this.f6577e = null;
            this.f6576d.i(1, bArr);
        }
    }

    public void q(e eVar) {
        this.f6574b = eVar;
    }

    public final IllegalArgumentException r() {
        return new IllegalArgumentException("Trying to release buffer smaller than original");
    }
}
