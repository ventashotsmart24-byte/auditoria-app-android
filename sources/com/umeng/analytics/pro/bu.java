package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class bu implements ch<bu, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* renamed from: k  reason: collision with root package name */
    public static final Map<e, ct> f13933k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f13934l = 420342210744516016L;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final dl f13935m = new dl("UMEnvelope");
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final db f13936n = new db("version", (byte) 11, 1);
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final db f13937o = new db("address", (byte) 11, 2);
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final db f13938p = new db(com.umeng.ccg.a.f14531x, (byte) 11, 3);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final db f13939q = new db("serial_num", (byte) 8, 4);
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final db f13940r = new db("ts_secs", (byte) 8, 5);
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final db f13941s = new db("length", (byte) 8, 6);
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static final db f13942t = new db("entity", (byte) 11, 7);
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static final db f13943u = new db("guid", (byte) 11, 8);
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static final db f13944v = new db("checksum", (byte) 11, 9);
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static final db f13945w = new db("codex", (byte) 8, 10);

    /* renamed from: x  reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f13946x;

    /* renamed from: y  reason: collision with root package name */
    private static final int f13947y = 0;

    /* renamed from: z  reason: collision with root package name */
    private static final int f13948z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a  reason: collision with root package name */
    public String f13949a;

    /* renamed from: b  reason: collision with root package name */
    public String f13950b;

    /* renamed from: c  reason: collision with root package name */
    public String f13951c;

    /* renamed from: d  reason: collision with root package name */
    public int f13952d;

    /* renamed from: e  reason: collision with root package name */
    public int f13953e;

    /* renamed from: f  reason: collision with root package name */
    public int f13954f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f13955g;

    /* renamed from: h  reason: collision with root package name */
    public String f13956h;

    /* renamed from: i  reason: collision with root package name */
    public String f13957i;

    /* renamed from: j  reason: collision with root package name */
    public int f13958j;

    public static class a extends dq<bu> {
        private a() {
        }

        /* renamed from: a */
        public void b(dg dgVar, bu buVar) {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f14130b;
                if (b10 == 0) {
                    dgVar.k();
                    if (!buVar.m()) {
                        throw new dh("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    } else if (!buVar.p()) {
                        throw new dh("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    } else if (buVar.s()) {
                        buVar.G();
                        return;
                    } else {
                        throw new dh("Required field 'length' was not found in serialized data! Struct: " + toString());
                    }
                } else {
                    switch (l10.f14131c) {
                        case 1:
                            if (b10 != 11) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13949a = dgVar.z();
                                buVar.a(true);
                                break;
                            }
                        case 2:
                            if (b10 != 11) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13950b = dgVar.z();
                                buVar.b(true);
                                break;
                            }
                        case 3:
                            if (b10 != 11) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13951c = dgVar.z();
                                buVar.c(true);
                                break;
                            }
                        case 4:
                            if (b10 != 8) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13952d = dgVar.w();
                                buVar.d(true);
                                break;
                            }
                        case 5:
                            if (b10 != 8) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13953e = dgVar.w();
                                buVar.e(true);
                                break;
                            }
                        case 6:
                            if (b10 != 8) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13954f = dgVar.w();
                                buVar.f(true);
                                break;
                            }
                        case 7:
                            if (b10 != 11) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13955g = dgVar.A();
                                buVar.g(true);
                                break;
                            }
                        case 8:
                            if (b10 != 11) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13956h = dgVar.z();
                                buVar.h(true);
                                break;
                            }
                        case 9:
                            if (b10 != 11) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13957i = dgVar.z();
                                buVar.i(true);
                                break;
                            }
                        case 10:
                            if (b10 != 8) {
                                dj.a(dgVar, b10);
                                break;
                            } else {
                                buVar.f13958j = dgVar.w();
                                buVar.j(true);
                                break;
                            }
                        default:
                            dj.a(dgVar, b10);
                            break;
                    }
                    dgVar.m();
                }
            }
        }

        /* renamed from: b */
        public void a(dg dgVar, bu buVar) {
            buVar.G();
            dgVar.a(bu.f13935m);
            if (buVar.f13949a != null) {
                dgVar.a(bu.f13936n);
                dgVar.a(buVar.f13949a);
                dgVar.c();
            }
            if (buVar.f13950b != null) {
                dgVar.a(bu.f13937o);
                dgVar.a(buVar.f13950b);
                dgVar.c();
            }
            if (buVar.f13951c != null) {
                dgVar.a(bu.f13938p);
                dgVar.a(buVar.f13951c);
                dgVar.c();
            }
            dgVar.a(bu.f13939q);
            dgVar.a(buVar.f13952d);
            dgVar.c();
            dgVar.a(bu.f13940r);
            dgVar.a(buVar.f13953e);
            dgVar.c();
            dgVar.a(bu.f13941s);
            dgVar.a(buVar.f13954f);
            dgVar.c();
            if (buVar.f13955g != null) {
                dgVar.a(bu.f13942t);
                dgVar.a(buVar.f13955g);
                dgVar.c();
            }
            if (buVar.f13956h != null) {
                dgVar.a(bu.f13943u);
                dgVar.a(buVar.f13956h);
                dgVar.c();
            }
            if (buVar.f13957i != null) {
                dgVar.a(bu.f13944v);
                dgVar.a(buVar.f13957i);
                dgVar.c();
            }
            if (buVar.F()) {
                dgVar.a(bu.f13945w);
                dgVar.a(buVar.f13958j);
                dgVar.c();
            }
            dgVar.d();
            dgVar.b();
        }
    }

    public static class b implements dp {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    public static class c extends dr<bu> {
        private c() {
        }

        public void a(dg dgVar, bu buVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(buVar.f13949a);
            dmVar.a(buVar.f13950b);
            dmVar.a(buVar.f13951c);
            dmVar.a(buVar.f13952d);
            dmVar.a(buVar.f13953e);
            dmVar.a(buVar.f13954f);
            dmVar.a(buVar.f13955g);
            dmVar.a(buVar.f13956h);
            dmVar.a(buVar.f13957i);
            BitSet bitSet = new BitSet();
            if (buVar.F()) {
                bitSet.set(0);
            }
            dmVar.a(bitSet, 1);
            if (buVar.F()) {
                dmVar.a(buVar.f13958j);
            }
        }

        public void b(dg dgVar, bu buVar) {
            dm dmVar = (dm) dgVar;
            buVar.f13949a = dmVar.z();
            buVar.a(true);
            buVar.f13950b = dmVar.z();
            buVar.b(true);
            buVar.f13951c = dmVar.z();
            buVar.c(true);
            buVar.f13952d = dmVar.w();
            buVar.d(true);
            buVar.f13953e = dmVar.w();
            buVar.e(true);
            buVar.f13954f = dmVar.w();
            buVar.f(true);
            buVar.f13955g = dmVar.A();
            buVar.g(true);
            buVar.f13956h = dmVar.z();
            buVar.h(true);
            buVar.f13957i = dmVar.z();
            buVar.i(true);
            if (dmVar.b(1).get(0)) {
                buVar.f13958j = dmVar.w();
                buVar.j(true);
            }
        }
    }

    public static class d implements dp {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f13946x = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new ct("version", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.ADDRESS, new ct("address", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.SIGNATURE, new ct(com.umeng.ccg.a.f14531x, (byte) 1, new cu((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new ct("serial_num", (byte) 1, new cu((byte) 8)));
        enumMap.put(e.TS_SECS, new ct("ts_secs", (byte) 1, new cu((byte) 8)));
        enumMap.put(e.LENGTH, new ct("length", (byte) 1, new cu((byte) 8)));
        enumMap.put(e.ENTITY, new ct("entity", (byte) 1, new cu((byte) 11, true)));
        enumMap.put(e.GUID, new ct("guid", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.CHECKSUM, new ct("checksum", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.CODEX, new ct("codex", (byte) 2, new cu((byte) 8)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f13933k = unmodifiableMap;
        ct.a(bu.class, unmodifiableMap);
    }

    public bu() {
        this.C = 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f13957i;
    }

    public void B() {
        this.f13957i = null;
    }

    public boolean C() {
        if (this.f13957i != null) {
            return true;
        }
        return false;
    }

    public int D() {
        return this.f13958j;
    }

    public void E() {
        this.C = ce.b(this.C, 3);
    }

    public boolean F() {
        return ce.a(this.C, 3);
    }

    public void G() {
        if (this.f13949a == null) {
            throw new dh("Required field 'version' was not present! Struct: " + toString());
        } else if (this.f13950b == null) {
            throw new dh("Required field 'address' was not present! Struct: " + toString());
        } else if (this.f13951c == null) {
            throw new dh("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.f13955g == null) {
            throw new dh("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.f13956h == null) {
            throw new dh("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.f13957i == null) {
            throw new dh("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    public bu deepCopy() {
        return new bu(this);
    }

    public String b() {
        return this.f13949a;
    }

    public void c() {
        this.f13949a = null;
    }

    public void clear() {
        this.f13949a = null;
        this.f13950b = null;
        this.f13951c = null;
        d(false);
        this.f13952d = 0;
        e(false);
        this.f13953e = 0;
        f(false);
        this.f13954f = 0;
        this.f13955g = null;
        this.f13956h = null;
        this.f13957i = null;
        j(false);
        this.f13958j = 0;
    }

    public boolean d() {
        return this.f13949a != null;
    }

    public String e() {
        return this.f13950b;
    }

    public void f() {
        this.f13950b = null;
    }

    public boolean g() {
        return this.f13950b != null;
    }

    public String h() {
        return this.f13951c;
    }

    public void i() {
        this.f13951c = null;
    }

    public boolean j() {
        return this.f13951c != null;
    }

    public int k() {
        return this.f13952d;
    }

    public void l() {
        this.C = ce.b(this.C, 0);
    }

    public boolean m() {
        return ce.a(this.C, 0);
    }

    public int n() {
        return this.f13953e;
    }

    public void o() {
        this.C = ce.b(this.C, 1);
    }

    public boolean p() {
        return ce.a(this.C, 1);
    }

    public int q() {
        return this.f13954f;
    }

    public void r() {
        this.C = ce.b(this.C, 2);
    }

    public void read(dg dgVar) {
        f13946x.get(dgVar.D()).b().b(dgVar, this);
    }

    public boolean s() {
        return ce.a(this.C, 2);
    }

    public byte[] t() {
        a(ci.c(this.f13955g));
        ByteBuffer byteBuffer = this.f13955g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f13949a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f13950b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f13951c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f13952d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f13953e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f13954f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f13955g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            ci.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f13956h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f13957i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f13958j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f13955g;
    }

    public void v() {
        this.f13955g = null;
    }

    public boolean w() {
        if (this.f13955g != null) {
            return true;
        }
        return false;
    }

    public void write(dg dgVar) {
        f13946x.get(dgVar.D()).b().a(dgVar, this);
    }

    public String x() {
        return this.f13956h;
    }

    public void y() {
        this.f13956h = null;
    }

    public boolean z() {
        if (this.f13956h != null) {
            return true;
        }
        return false;
    }

    public enum e implements co {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, com.umeng.ccg.a.f14531x),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        

        /* renamed from: k  reason: collision with root package name */
        private static final Map<String, e> f13969k = null;

        /* renamed from: l  reason: collision with root package name */
        private final short f13971l;

        /* renamed from: m  reason: collision with root package name */
        private final String f13972m;

        /* access modifiers changed from: public */
        static {
            f13969k = new HashMap();
            Iterator<E> it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f13969k.put(eVar.b(), eVar);
            }
        }

        private e(short s10, String str) {
            this.f13971l = s10;
            this.f13972m = str;
        }

        public static e a(int i10) {
            switch (i10) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        public static e b(int i10) {
            e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        public String b() {
            return this.f13972m;
        }

        public static e a(String str) {
            return f13969k.get(str);
        }

        public short a() {
            return this.f13971l;
        }
    }

    public bu a(String str) {
        this.f13949a = str;
        return this;
    }

    public bu b(String str) {
        this.f13950b = str;
        return this;
    }

    public bu c(String str) {
        this.f13951c = str;
        return this;
    }

    public void d(boolean z10) {
        this.C = ce.a(this.C, 0, z10);
    }

    public void e(boolean z10) {
        this.C = ce.a(this.C, 1, z10);
    }

    public void f(boolean z10) {
        this.C = ce.a(this.C, 2, z10);
    }

    public void g(boolean z10) {
        if (!z10) {
            this.f13955g = null;
        }
    }

    public void h(boolean z10) {
        if (!z10) {
            this.f13956h = null;
        }
    }

    public void i(boolean z10) {
        if (!z10) {
            this.f13957i = null;
        }
    }

    public void j(boolean z10) {
        this.C = ce.a(this.C, 3, z10);
    }

    public void a(boolean z10) {
        if (!z10) {
            this.f13949a = null;
        }
    }

    public void b(boolean z10) {
        if (!z10) {
            this.f13950b = null;
        }
    }

    public void c(boolean z10) {
        if (!z10) {
            this.f13951c = null;
        }
    }

    public bu d(String str) {
        this.f13956h = str;
        return this;
    }

    public bu e(String str) {
        this.f13957i = str;
        return this;
    }

    public bu(String str, String str2, String str3, int i10, int i11, int i12, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f13949a = str;
        this.f13950b = str2;
        this.f13951c = str3;
        this.f13952d = i10;
        d(true);
        this.f13953e = i11;
        e(true);
        this.f13954f = i12;
        f(true);
        this.f13955g = byteBuffer;
        this.f13956h = str4;
        this.f13957i = str5;
    }

    public bu a(int i10) {
        this.f13952d = i10;
        d(true);
        return this;
    }

    public bu b(int i10) {
        this.f13953e = i10;
        e(true);
        return this;
    }

    public bu c(int i10) {
        this.f13954f = i10;
        f(true);
        return this;
    }

    public bu d(int i10) {
        this.f13958j = i10;
        j(true);
        return this;
    }

    /* renamed from: e */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public bu a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public bu a(ByteBuffer byteBuffer) {
        this.f13955g = byteBuffer;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new da(new ds((OutputStream) objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.C = 0;
            read(new da(new ds((InputStream) objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public bu(bu buVar) {
        this.C = 0;
        this.D = new e[]{e.CODEX};
        this.C = buVar.C;
        if (buVar.d()) {
            this.f13949a = buVar.f13949a;
        }
        if (buVar.g()) {
            this.f13950b = buVar.f13950b;
        }
        if (buVar.j()) {
            this.f13951c = buVar.f13951c;
        }
        this.f13952d = buVar.f13952d;
        this.f13953e = buVar.f13953e;
        this.f13954f = buVar.f13954f;
        if (buVar.w()) {
            this.f13955g = ci.d(buVar.f13955g);
        }
        if (buVar.z()) {
            this.f13956h = buVar.f13956h;
        }
        if (buVar.C()) {
            this.f13957i = buVar.f13957i;
        }
        this.f13958j = buVar.f13958j;
    }
}
