package com.umeng.analytics.pro;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class cz extends dg {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f14075a = -65536;

    /* renamed from: b  reason: collision with root package name */
    protected static final int f14076b = -2147418112;

    /* renamed from: h  reason: collision with root package name */
    private static final dl f14077h = new dl();

    /* renamed from: c  reason: collision with root package name */
    protected boolean f14078c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f14079d;

    /* renamed from: e  reason: collision with root package name */
    protected int f14080e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f14081f;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f14082i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f14083j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f14084k;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f14085l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f14086m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f14087n;

    /* renamed from: o  reason: collision with root package name */
    private byte[] f14088o;

    /* renamed from: p  reason: collision with root package name */
    private byte[] f14089p;

    public static class a implements di {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f14090a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f14091b;

        /* renamed from: c  reason: collision with root package name */
        protected int f14092c;

        public a() {
            this(false, true);
        }

        public dg a(du duVar) {
            cz czVar = new cz(duVar, this.f14090a, this.f14091b);
            int i10 = this.f14092c;
            if (i10 != 0) {
                czVar.c(i10);
            }
            return czVar;
        }

        public a(boolean z10, boolean z11) {
            this(z10, z11, 0);
        }

        public a(boolean z10, boolean z11, int i10) {
            this.f14090a = z10;
            this.f14091b = z11;
            this.f14092c = i10;
        }
    }

    public cz(du duVar) {
        this(duVar, false, true);
    }

    public ByteBuffer A() {
        int w10 = w();
        d(w10);
        if (this.f14144g.h() >= w10) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f14144g.f(), this.f14144g.g(), w10);
            this.f14144g.a(w10);
            return wrap;
        }
        byte[] bArr = new byte[w10];
        this.f14144g.d(bArr, 0, w10);
        return ByteBuffer.wrap(bArr);
    }

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
        a((byte) 0);
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public de h() {
        int w10 = w();
        if (w10 < 0) {
            if ((f14075a & w10) == f14076b) {
                return new de(z(), (byte) (w10 & 255), w());
            }
            throw new dh(4, "Bad version in readMessageBegin");
        } else if (!this.f14078c) {
            return new de(b(w10), u(), w());
        } else {
            throw new dh(4, "Missing version in readMessageBegin, old client?");
        }
    }

    public void i() {
    }

    public dl j() {
        return f14077h;
    }

    public void k() {
    }

    public db l() {
        short s10;
        byte u10 = u();
        if (u10 == 0) {
            s10 = 0;
        } else {
            s10 = v();
        }
        return new db("", u10, s10);
    }

    public void m() {
    }

    public dd n() {
        return new dd(u(), u(), w());
    }

    public void o() {
    }

    public dc p() {
        return new dc(u(), w());
    }

    public void q() {
    }

    public dk r() {
        return new dk(u(), w());
    }

    public void s() {
    }

    public boolean t() {
        if (u() == 1) {
            return true;
        }
        return false;
    }

    public byte u() {
        if (this.f14144g.h() >= 1) {
            byte b10 = this.f14144g.f()[this.f14144g.g()];
            this.f14144g.a(1);
            return b10;
        }
        a(this.f14086m, 0, 1);
        return this.f14086m[0];
    }

    public short v() {
        int i10;
        byte[] bArr = this.f14087n;
        if (this.f14144g.h() >= 2) {
            bArr = this.f14144g.f();
            i10 = this.f14144g.g();
            this.f14144g.a(2);
        } else {
            a(this.f14087n, 0, 2);
            i10 = 0;
        }
        return (short) ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) | ((bArr[i10] & UnsignedBytes.MAX_VALUE) << 8));
    }

    public int w() {
        int i10;
        byte[] bArr = this.f14088o;
        if (this.f14144g.h() >= 4) {
            bArr = this.f14144g.f();
            i10 = this.f14144g.g();
            this.f14144g.a(4);
        } else {
            a(this.f14088o, 0, 4);
            i10 = 0;
        }
        return (bArr[i10 + 3] & UnsignedBytes.MAX_VALUE) | ((bArr[i10] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i10 + 2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public long x() {
        int i10;
        byte[] bArr = this.f14089p;
        if (this.f14144g.h() >= 8) {
            bArr = this.f14144g.f();
            i10 = this.f14144g.g();
            this.f14144g.a(8);
        } else {
            a(this.f14089p, 0, 8);
            i10 = 0;
        }
        return ((long) (bArr[i10 + 7] & UnsignedBytes.MAX_VALUE)) | (((long) (bArr[i10] & UnsignedBytes.MAX_VALUE)) << 56) | (((long) (bArr[i10 + 1] & UnsignedBytes.MAX_VALUE)) << 48) | (((long) (bArr[i10 + 2] & UnsignedBytes.MAX_VALUE)) << 40) | (((long) (bArr[i10 + 3] & UnsignedBytes.MAX_VALUE)) << 32) | (((long) (bArr[i10 + 4] & UnsignedBytes.MAX_VALUE)) << 24) | (((long) (bArr[i10 + 5] & UnsignedBytes.MAX_VALUE)) << 16) | (((long) (bArr[i10 + 6] & UnsignedBytes.MAX_VALUE)) << 8);
    }

    public double y() {
        return Double.longBitsToDouble(x());
    }

    public String z() {
        int w10 = w();
        if (this.f14144g.h() < w10) {
            return b(w10);
        }
        try {
            String str = new String(this.f14144g.f(), this.f14144g.g(), w10, "UTF-8");
            this.f14144g.a(w10);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public cz(du duVar, boolean z10, boolean z11) {
        super(duVar);
        this.f14081f = false;
        this.f14082i = new byte[1];
        this.f14083j = new byte[2];
        this.f14084k = new byte[4];
        this.f14085l = new byte[8];
        this.f14086m = new byte[1];
        this.f14087n = new byte[2];
        this.f14088o = new byte[4];
        this.f14089p = new byte[8];
        this.f14078c = z10;
        this.f14079d = z11;
    }

    public void a(dl dlVar) {
    }

    public String b(int i10) {
        try {
            d(i10);
            byte[] bArr = new byte[i10];
            this.f14144g.d(bArr, 0, i10);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void c(int i10) {
        this.f14080e = i10;
        this.f14081f = true;
    }

    public void d(int i10) {
        if (i10 < 0) {
            throw new dh("Negative length: " + i10);
        } else if (this.f14081f) {
            int i11 = this.f14080e - i10;
            this.f14080e = i11;
            if (i11 < 0) {
                throw new dh("Message length exceeded: " + i10);
            }
        }
    }

    public void a(de deVar) {
        if (this.f14079d) {
            a((int) deVar.f14138b | f14076b);
            a(deVar.f14137a);
            a(deVar.f14139c);
            return;
        }
        a(deVar.f14137a);
        a(deVar.f14138b);
        a(deVar.f14139c);
    }

    public void a(db dbVar) {
        a(dbVar.f14130b);
        a(dbVar.f14131c);
    }

    public void a(dd ddVar) {
        a(ddVar.f14134a);
        a(ddVar.f14135b);
        a(ddVar.f14136c);
    }

    public void a(dc dcVar) {
        a(dcVar.f14132a);
        a(dcVar.f14133b);
    }

    public void a(dk dkVar) {
        a(dkVar.f14154a);
        a(dkVar.f14155b);
    }

    public void a(boolean z10) {
        a(z10 ? (byte) 1 : 0);
    }

    public void a(byte b10) {
        byte[] bArr = this.f14082i;
        bArr[0] = b10;
        this.f14144g.b(bArr, 0, 1);
    }

    public void a(short s10) {
        byte[] bArr = this.f14083j;
        bArr[0] = (byte) ((s10 >> 8) & 255);
        bArr[1] = (byte) (s10 & 255);
        this.f14144g.b(bArr, 0, 2);
    }

    public void a(int i10) {
        byte[] bArr = this.f14084k;
        bArr[0] = (byte) ((i10 >> 24) & 255);
        bArr[1] = (byte) ((i10 >> 16) & 255);
        bArr[2] = (byte) ((i10 >> 8) & 255);
        bArr[3] = (byte) (i10 & 255);
        this.f14144g.b(bArr, 0, 4);
    }

    public void a(long j10) {
        byte[] bArr = this.f14085l;
        bArr[0] = (byte) ((int) ((j10 >> 56) & 255));
        bArr[1] = (byte) ((int) ((j10 >> 48) & 255));
        bArr[2] = (byte) ((int) ((j10 >> 40) & 255));
        bArr[3] = (byte) ((int) ((j10 >> 32) & 255));
        bArr[4] = (byte) ((int) ((j10 >> 24) & 255));
        bArr[5] = (byte) ((int) ((j10 >> 16) & 255));
        bArr[6] = (byte) ((int) ((j10 >> 8) & 255));
        bArr[7] = (byte) ((int) (j10 & 255));
        this.f14144g.b(bArr, 0, 8);
    }

    public void a(double d10) {
        a(Double.doubleToLongBits(d10));
    }

    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f14144g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void a(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.f14144g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    private int a(byte[] bArr, int i10, int i11) {
        d(i11);
        return this.f14144g.d(bArr, i10, i11);
    }
}
