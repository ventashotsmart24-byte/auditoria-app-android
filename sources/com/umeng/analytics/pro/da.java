package com.umeng.analytics.pro;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class da extends dg {

    /* renamed from: d  reason: collision with root package name */
    private static final dl f14099d = new dl("");

    /* renamed from: e  reason: collision with root package name */
    private static final db f14100e = new db("", (byte) 0, 0);

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f14101f;

    /* renamed from: h  reason: collision with root package name */
    private static final byte f14102h = -126;

    /* renamed from: i  reason: collision with root package name */
    private static final byte f14103i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final byte f14104j = 31;

    /* renamed from: k  reason: collision with root package name */
    private static final byte f14105k = -32;

    /* renamed from: l  reason: collision with root package name */
    private static final int f14106l = 5;

    /* renamed from: a  reason: collision with root package name */
    byte[] f14107a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f14108b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f14109c;

    /* renamed from: m  reason: collision with root package name */
    private cf f14110m;

    /* renamed from: n  reason: collision with root package name */
    private short f14111n;

    /* renamed from: o  reason: collision with root package name */
    private db f14112o;

    /* renamed from: p  reason: collision with root package name */
    private Boolean f14113p;

    /* renamed from: q  reason: collision with root package name */
    private final long f14114q;

    /* renamed from: r  reason: collision with root package name */
    private byte[] f14115r;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final byte f14117a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final byte f14118b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final byte f14119c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final byte f14120d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final byte f14121e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final byte f14122f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final byte f14123g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final byte f14124h = 8;

        /* renamed from: i  reason: collision with root package name */
        public static final byte f14125i = 9;

        /* renamed from: j  reason: collision with root package name */
        public static final byte f14126j = 10;

        /* renamed from: k  reason: collision with root package name */
        public static final byte f14127k = 11;

        /* renamed from: l  reason: collision with root package name */
        public static final byte f14128l = 12;

        private b() {
        }
    }

    static {
        byte[] bArr = new byte[16];
        f14101f = bArr;
        bArr[0] = 0;
        bArr[2] = 1;
        bArr[3] = 3;
        bArr[6] = 4;
        bArr[8] = 5;
        bArr[10] = 6;
        bArr[4] = 7;
        bArr[11] = 8;
        bArr[15] = 9;
        bArr[14] = 10;
        bArr[13] = 11;
        bArr[12] = 12;
    }

    public da(du duVar, long j10) {
        super(duVar);
        this.f14110m = new cf(15);
        this.f14111n = 0;
        this.f14112o = null;
        this.f14113p = null;
        this.f14107a = new byte[5];
        this.f14108b = new byte[10];
        this.f14115r = new byte[1];
        this.f14109c = new byte[1];
        this.f14114q = j10;
    }

    private int E() {
        int i10 = 0;
        if (this.f14144g.h() >= 5) {
            byte[] f10 = this.f14144g.f();
            int g10 = this.f14144g.g();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                byte b10 = f10[g10 + i10];
                i11 |= (b10 & Ascii.DEL) << i12;
                if ((b10 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                    this.f14144g.a(i10 + 1);
                    return i11;
                }
                i12 += 7;
                i10++;
            }
        } else {
            int i13 = 0;
            while (true) {
                byte u10 = u();
                i10 |= (u10 & Ascii.DEL) << i13;
                if ((u10 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                    return i10;
                }
                i13 += 7;
            }
        }
    }

    private long F() {
        int i10 = 0;
        long j10 = 0;
        if (this.f14144g.h() >= 10) {
            byte[] f10 = this.f14144g.f();
            int g10 = this.f14144g.g();
            long j11 = 0;
            int i11 = 0;
            while (true) {
                byte b10 = f10[g10 + i10];
                j11 |= ((long) (b10 & Ascii.DEL)) << i11;
                if ((b10 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                    this.f14144g.a(i10 + 1);
                    return j11;
                }
                i11 += 7;
                i10++;
            }
        } else {
            while (true) {
                byte u10 = u();
                j10 |= ((long) (u10 & Ascii.DEL)) << i10;
                if ((u10 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                    return j10;
                }
                i10 += 7;
            }
        }
    }

    private int c(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    private long d(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    private int g(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public ByteBuffer A() {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.f14144g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    public void B() {
        this.f14110m.c();
        this.f14111n = 0;
    }

    public void a() {
    }

    public void b() {
        this.f14111n = this.f14110m.a();
    }

    public void e() {
    }

    public void f() {
    }

    public de h() {
        byte u10 = u();
        if (u10 == -126) {
            byte u11 = u();
            byte b10 = (byte) (u11 & 31);
            if (b10 == 1) {
                int E = E();
                return new de(z(), (byte) ((u11 >> 5) & 3), E);
            }
            throw new dh("Expected version 1 but got " + b10);
        }
        throw new dh("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u10));
    }

    public void i() {
    }

    public dl j() {
        this.f14110m.a(this.f14111n);
        this.f14111n = 0;
        return f14099d;
    }

    public void k() {
        this.f14111n = this.f14110m.a();
    }

    public db l() {
        short s10;
        Boolean bool;
        byte u10 = u();
        if (u10 == 0) {
            return f14100e;
        }
        short s11 = (short) ((u10 & 240) >> 4);
        if (s11 == 0) {
            s10 = v();
        } else {
            s10 = (short) (this.f14111n + s11);
        }
        byte b10 = (byte) (u10 & 15);
        db dbVar = new db("", d(b10), s10);
        if (c(u10)) {
            if (b10 == 1) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            this.f14113p = bool;
        }
        this.f14111n = dbVar.f14131c;
        return dbVar;
    }

    public void m() {
    }

    public dd n() {
        byte b10;
        int E = E();
        if (E == 0) {
            b10 = 0;
        } else {
            b10 = u();
        }
        return new dd(d((byte) (b10 >> 4)), d((byte) (b10 & 15)), E);
    }

    public void o() {
    }

    public dc p() {
        byte u10 = u();
        int i10 = (u10 >> 4) & 15;
        if (i10 == 15) {
            i10 = E();
        }
        return new dc(d(u10), i10);
    }

    public void q() {
    }

    public dk r() {
        return new dk(p());
    }

    public void s() {
    }

    public boolean t() {
        Boolean bool = this.f14113p;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            this.f14113p = null;
            return booleanValue;
        } else if (u() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public byte u() {
        if (this.f14144g.h() > 0) {
            byte b10 = this.f14144g.f()[this.f14144g.g()];
            this.f14144g.a(1);
            return b10;
        }
        this.f14144g.d(this.f14109c, 0, 1);
        return this.f14109c[0];
    }

    public short v() {
        return (short) g(E());
    }

    public int w() {
        return g(E());
    }

    public long x() {
        return d(F());
    }

    public double y() {
        byte[] bArr = new byte[8];
        this.f14144g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    public String z() {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.f14144g.h() < E) {
                return new String(e(E), "UTF-8");
            }
            String str = new String(this.f14144g.f(), this.f14144g.g(), E, "UTF-8");
            this.f14144g.a(E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new cn("UTF-8 not supported!");
        }
    }

    public static class a implements di {

        /* renamed from: a  reason: collision with root package name */
        private final long f14116a;

        public a() {
            this.f14116a = -1;
        }

        public dg a(du duVar) {
            return new da(duVar, this.f14116a);
        }

        public a(int i10) {
            this.f14116a = (long) i10;
        }
    }

    private void b(int i10) {
        int i11 = 0;
        while ((i10 & -128) != 0) {
            this.f14107a[i11] = (byte) ((i10 & 127) | 128);
            i10 >>>= 7;
            i11++;
        }
        byte[] bArr = this.f14107a;
        bArr[i11] = (byte) i10;
        this.f14144g.b(bArr, 0, i11 + 1);
    }

    private long c(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    private byte[] e(int i10) {
        if (i10 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        this.f14144g.d(bArr, 0, i10);
        return bArr;
    }

    private void f(int i10) {
        if (i10 >= 0) {
            long j10 = this.f14114q;
            if (j10 != -1 && ((long) i10) > j10) {
                throw new dh("Length exceeded max allowed: " + i10);
            }
            return;
        }
        throw new dh("Negative length: " + i10);
    }

    public void a(de deVar) {
        b((byte) f14102h);
        d(((deVar.f14138b << 5) & -32) | 1);
        b(deVar.f14139c);
        a(deVar.f14137a);
    }

    public void d() {
        b((byte) 0);
    }

    public void g() {
    }

    private void d(int i10) {
        b((byte) i10);
    }

    public void c() {
    }

    private boolean c(byte b10) {
        byte b11 = b10 & 15;
        return b11 == 1 || b11 == 2;
    }

    private byte d(byte b10) {
        byte b11 = (byte) (b10 & 15);
        switch (b11) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 8;
            case 6:
                return 10;
            case 7:
                return 4;
            case 8:
                return 11;
            case 9:
                return 15;
            case 10:
                return 14;
            case 11:
                return 13;
            case 12:
                return 12;
            default:
                throw new dh("don't know what type: " + b11);
        }
    }

    private byte e(byte b10) {
        return f14101f[b10];
    }

    private void b(long j10) {
        int i10 = 0;
        while ((-128 & j10) != 0) {
            this.f14108b[i10] = (byte) ((int) ((127 & j10) | 128));
            j10 >>>= 7;
            i10++;
        }
        byte[] bArr = this.f14108b;
        bArr[i10] = (byte) ((int) j10);
        this.f14144g.b(bArr, 0, i10 + 1);
    }

    public void a(dl dlVar) {
        this.f14110m.a(this.f14111n);
        this.f14111n = 0;
    }

    private void b(byte b10) {
        byte[] bArr = this.f14115r;
        bArr[0] = b10;
        this.f14144g.b(bArr);
    }

    public void a(db dbVar) {
        if (dbVar.f14130b == 2) {
            this.f14112o = dbVar;
        } else {
            a(dbVar, (byte) -1);
        }
    }

    public da(du duVar) {
        this(duVar, -1);
    }

    private void a(db dbVar, byte b10) {
        if (b10 == -1) {
            b10 = e(dbVar.f14130b);
        }
        short s10 = dbVar.f14131c;
        short s11 = this.f14111n;
        if (s10 <= s11 || s10 - s11 > 15) {
            b(b10);
            a(dbVar.f14131c);
        } else {
            d((int) b10 | ((s10 - s11) << 4));
        }
        this.f14111n = dbVar.f14131c;
    }

    public void a(dd ddVar) {
        int i10 = ddVar.f14136c;
        if (i10 == 0) {
            d(0);
            return;
        }
        b(i10);
        d((int) e(ddVar.f14135b) | (e(ddVar.f14134a) << 4));
    }

    public void a(dc dcVar) {
        a(dcVar.f14132a, dcVar.f14133b);
    }

    public void a(dk dkVar) {
        a(dkVar.f14154a, dkVar.f14155b);
    }

    public void a(boolean z10) {
        db dbVar = this.f14112o;
        byte b10 = 1;
        if (dbVar != null) {
            if (!z10) {
                b10 = 2;
            }
            a(dbVar, b10);
            this.f14112o = null;
            return;
        }
        if (!z10) {
            b10 = 2;
        }
        b(b10);
    }

    public void a(byte b10) {
        b(b10);
    }

    public void a(short s10) {
        b(c((int) s10));
    }

    public void a(int i10) {
        b(c(i10));
    }

    public void a(long j10) {
        b(c(j10));
    }

    public void a(double d10) {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d10), bArr, 0);
        this.f14144g.b(bArr);
    }

    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("UTF-8 not supported!");
        }
    }

    public void a(ByteBuffer byteBuffer) {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i10, int i11) {
        b(i11);
        this.f14144g.b(bArr, i10, i11);
    }

    public void a(byte b10, int i10) {
        if (i10 <= 14) {
            d((int) e(b10) | (i10 << 4));
            return;
        }
        d((int) e(b10) | 240);
        b(i10);
    }

    private void a(long j10, byte[] bArr, int i10) {
        bArr[i10 + 0] = (byte) ((int) (j10 & 255));
        bArr[i10 + 1] = (byte) ((int) ((j10 >> 8) & 255));
        bArr[i10 + 2] = (byte) ((int) ((j10 >> 16) & 255));
        bArr[i10 + 3] = (byte) ((int) ((j10 >> 24) & 255));
        bArr[i10 + 4] = (byte) ((int) ((j10 >> 32) & 255));
        bArr[i10 + 5] = (byte) ((int) ((j10 >> 40) & 255));
        bArr[i10 + 6] = (byte) ((int) ((j10 >> 48) & 255));
        bArr[i10 + 7] = (byte) ((int) ((j10 >> 56) & 255));
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }
}
