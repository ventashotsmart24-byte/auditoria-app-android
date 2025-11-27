package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dg;
import com.umeng.analytics.pro.dh;
import com.umeng.analytics.pro.dj;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dm;
import com.umeng.analytics.pro.dp;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.ds;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class b implements ch<b, e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<e, ct> f15018d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f15019e = -6496538196005191531L;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final dl f15020f = new dl("IdSnapshot");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final db f15021g = new db("identity", (byte) 11, 1);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final db f15022h = new db("ts", (byte) 10, 2);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final db f15023i = new db("version", (byte) 8, 3);

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f15024j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f15025k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f15026l = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f15027a;

    /* renamed from: b  reason: collision with root package name */
    public long f15028b;

    /* renamed from: c  reason: collision with root package name */
    public int f15029c;

    /* renamed from: m  reason: collision with root package name */
    private byte f15030m;

    public static class a extends dq<b> {
        private a() {
        }

        /* renamed from: a */
        public void b(dg dgVar, b bVar) {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f14130b;
                if (b10 == 0) {
                    break;
                }
                short s10 = l10.f14131c;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            dj.a(dgVar, b10);
                        } else if (b10 == 8) {
                            bVar.f15029c = dgVar.w();
                            bVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 10) {
                        bVar.f15028b = dgVar.x();
                        bVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 11) {
                    bVar.f15027a = dgVar.z();
                    bVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (!bVar.g()) {
                throw new dh("Required field 'ts' was not found in serialized data! Struct: " + toString());
            } else if (bVar.j()) {
                bVar.k();
            } else {
                throw new dh("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
        }

        /* renamed from: b */
        public void a(dg dgVar, b bVar) {
            bVar.k();
            dgVar.a(b.f15020f);
            if (bVar.f15027a != null) {
                dgVar.a(b.f15021g);
                dgVar.a(bVar.f15027a);
                dgVar.c();
            }
            dgVar.a(b.f15022h);
            dgVar.a(bVar.f15028b);
            dgVar.c();
            dgVar.a(b.f15023i);
            dgVar.a(bVar.f15029c);
            dgVar.c();
            dgVar.d();
            dgVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b  reason: collision with other inner class name */
    public static class C0206b implements dp {
        private C0206b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    public static class c extends dr<b> {
        private c() {
        }

        public void a(dg dgVar, b bVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(bVar.f15027a);
            dmVar.a(bVar.f15028b);
            dmVar.a(bVar.f15029c);
        }

        public void b(dg dgVar, b bVar) {
            dm dmVar = (dm) dgVar;
            bVar.f15027a = dmVar.z();
            bVar.a(true);
            bVar.f15028b = dmVar.x();
            bVar.b(true);
            bVar.f15029c = dmVar.w();
            bVar.c(true);
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
        f15024j = hashMap;
        hashMap.put(dq.class, new C0206b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new ct("identity", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.TS, new ct("ts", (byte) 1, new cu((byte) 10)));
        enumMap.put(e.VERSION, new ct("version", (byte) 1, new cu((byte) 8)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f15018d = unmodifiableMap;
        ct.a(b.class, unmodifiableMap);
    }

    public b() {
        this.f15030m = 0;
    }

    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f15027a;
    }

    public void c() {
        this.f15027a = null;
    }

    public void clear() {
        this.f15027a = null;
        b(false);
        this.f15028b = 0;
        c(false);
        this.f15029c = 0;
    }

    public boolean d() {
        if (this.f15027a != null) {
            return true;
        }
        return false;
    }

    public long e() {
        return this.f15028b;
    }

    public void f() {
        this.f15030m = ce.b(this.f15030m, 0);
    }

    public boolean g() {
        return ce.a(this.f15030m, 0);
    }

    public int h() {
        return this.f15029c;
    }

    public void i() {
        this.f15030m = ce.b(this.f15030m, 1);
    }

    public boolean j() {
        return ce.a(this.f15030m, 1);
    }

    public void k() {
        if (this.f15027a == null) {
            throw new dh("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    public void read(dg dgVar) {
        f15024j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f15027a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f15028b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f15029c);
        sb.append(")");
        return sb.toString();
    }

    public void write(dg dgVar) {
        f15024j.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f15034d = null;

        /* renamed from: e  reason: collision with root package name */
        private final short f15036e;

        /* renamed from: f  reason: collision with root package name */
        private final String f15037f;

        /* access modifiers changed from: public */
        static {
            f15034d = new HashMap();
            Iterator<E> it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f15034d.put(eVar.b(), eVar);
            }
        }

        private e(short s10, String str) {
            this.f15036e = s10;
            this.f15037f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return IDENTITY;
            }
            if (i10 == 2) {
                return TS;
            }
            if (i10 != 3) {
                return null;
            }
            return VERSION;
        }

        public static e b(int i10) {
            e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        public String b() {
            return this.f15037f;
        }

        public static e a(String str) {
            return f15034d.get(str);
        }

        public short a() {
            return this.f15036e;
        }
    }

    public b a(String str) {
        this.f15027a = str;
        return this;
    }

    public void b(boolean z10) {
        this.f15030m = ce.a(this.f15030m, 0, z10);
    }

    public void c(boolean z10) {
        this.f15030m = ce.a(this.f15030m, 1, z10);
    }

    public b(String str, long j10, int i10) {
        this();
        this.f15027a = str;
        this.f15028b = j10;
        b(true);
        this.f15029c = i10;
        c(true);
    }

    public void a(boolean z10) {
        if (!z10) {
            this.f15027a = null;
        }
    }

    /* renamed from: b */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public b a(long j10) {
        this.f15028b = j10;
        b(true);
        return this;
    }

    public b a(int i10) {
        this.f15029c = i10;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new da(new ds((OutputStream) objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public b(b bVar) {
        this.f15030m = 0;
        this.f15030m = bVar.f15030m;
        if (bVar.d()) {
            this.f15027a = bVar.f15027a;
        }
        this.f15028b = bVar.f15028b;
        this.f15029c = bVar.f15029c;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.f15030m = 0;
            read(new da(new ds((InputStream) objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
