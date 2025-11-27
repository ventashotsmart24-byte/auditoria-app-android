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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class a implements ch<a, e>, Serializable, Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final Map<e, ct> f14995e;

    /* renamed from: f  reason: collision with root package name */
    private static final long f14996f = 9132678615281394583L;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final dl f14997g = new dl("IdJournal");
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final db f14998h = new db("domain", (byte) 11, 1);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final db f14999i = new db("old_id", (byte) 11, 2);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final db f15000j = new db("new_id", (byte) 11, 3);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final db f15001k = new db("ts", (byte) 10, 4);

    /* renamed from: l  reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f15002l;

    /* renamed from: m  reason: collision with root package name */
    private static final int f15003m = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f15004a;

    /* renamed from: b  reason: collision with root package name */
    public String f15005b;

    /* renamed from: c  reason: collision with root package name */
    public String f15006c;

    /* renamed from: d  reason: collision with root package name */
    public long f15007d;

    /* renamed from: n  reason: collision with root package name */
    private byte f15008n;

    /* renamed from: o  reason: collision with root package name */
    private e[] f15009o;

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a  reason: collision with other inner class name */
    public static class C0205a extends dq<a> {
        private C0205a() {
        }

        /* renamed from: a */
        public void b(dg dgVar, a aVar) {
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
                            if (s10 != 4) {
                                dj.a(dgVar, b10);
                            } else if (b10 == 10) {
                                aVar.f15007d = dgVar.x();
                                aVar.d(true);
                            } else {
                                dj.a(dgVar, b10);
                            }
                        } else if (b10 == 11) {
                            aVar.f15006c = dgVar.z();
                            aVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 11) {
                        aVar.f15005b = dgVar.z();
                        aVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 11) {
                    aVar.f15004a = dgVar.z();
                    aVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new dh("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        /* renamed from: b */
        public void a(dg dgVar, a aVar) {
            aVar.n();
            dgVar.a(a.f14997g);
            if (aVar.f15004a != null) {
                dgVar.a(a.f14998h);
                dgVar.a(aVar.f15004a);
                dgVar.c();
            }
            if (aVar.f15005b != null && aVar.g()) {
                dgVar.a(a.f14999i);
                dgVar.a(aVar.f15005b);
                dgVar.c();
            }
            if (aVar.f15006c != null) {
                dgVar.a(a.f15000j);
                dgVar.a(aVar.f15006c);
                dgVar.c();
            }
            dgVar.a(a.f15001k);
            dgVar.a(aVar.f15007d);
            dgVar.c();
            dgVar.d();
            dgVar.b();
        }
    }

    public static class b implements dp {
        private b() {
        }

        /* renamed from: a */
        public C0205a b() {
            return new C0205a();
        }
    }

    public static class c extends dr<a> {
        private c() {
        }

        public void a(dg dgVar, a aVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(aVar.f15004a);
            dmVar.a(aVar.f15006c);
            dmVar.a(aVar.f15007d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            dmVar.a(bitSet, 1);
            if (aVar.g()) {
                dmVar.a(aVar.f15005b);
            }
        }

        public void b(dg dgVar, a aVar) {
            dm dmVar = (dm) dgVar;
            aVar.f15004a = dmVar.z();
            aVar.a(true);
            aVar.f15006c = dmVar.z();
            aVar.c(true);
            aVar.f15007d = dmVar.x();
            aVar.d(true);
            if (dmVar.b(1).get(0)) {
                aVar.f15005b = dmVar.z();
                aVar.b(true);
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
        f15002l = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new ct("domain", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.OLD_ID, new ct("old_id", (byte) 2, new cu((byte) 11)));
        enumMap.put(e.NEW_ID, new ct("new_id", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.TS, new ct("ts", (byte) 1, new cu((byte) 10)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f14995e = unmodifiableMap;
        ct.a(a.class, unmodifiableMap);
    }

    public a() {
        this.f15008n = 0;
        this.f15009o = new e[]{e.OLD_ID};
    }

    /* renamed from: a */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f15004a;
    }

    public void c() {
        this.f15004a = null;
    }

    public void clear() {
        this.f15004a = null;
        this.f15005b = null;
        this.f15006c = null;
        d(false);
        this.f15007d = 0;
    }

    public boolean d() {
        return this.f15004a != null;
    }

    public String e() {
        return this.f15005b;
    }

    public void f() {
        this.f15005b = null;
    }

    public boolean g() {
        if (this.f15005b != null) {
            return true;
        }
        return false;
    }

    public String h() {
        return this.f15006c;
    }

    public void i() {
        this.f15006c = null;
    }

    public boolean j() {
        if (this.f15006c != null) {
            return true;
        }
        return false;
    }

    public long k() {
        return this.f15007d;
    }

    public void l() {
        this.f15008n = ce.b(this.f15008n, 0);
    }

    public boolean m() {
        return ce.a(this.f15008n, 0);
    }

    public void n() {
        if (this.f15004a == null) {
            throw new dh("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.f15006c == null) {
            throw new dh("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    public void read(dg dgVar) {
        f15002l.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f15004a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f15005b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f15006c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f15007d);
        sb.append(")");
        return sb.toString();
    }

    public void write(dg dgVar) {
        f15002l.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        

        /* renamed from: e  reason: collision with root package name */
        private static final Map<String, e> f15014e = null;

        /* renamed from: f  reason: collision with root package name */
        private final short f15016f;

        /* renamed from: g  reason: collision with root package name */
        private final String f15017g;

        /* access modifiers changed from: public */
        static {
            f15014e = new HashMap();
            Iterator<E> it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f15014e.put(eVar.b(), eVar);
            }
        }

        private e(short s10, String str) {
            this.f15016f = s10;
            this.f15017g = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return DOMAIN;
            }
            if (i10 == 2) {
                return OLD_ID;
            }
            if (i10 == 3) {
                return NEW_ID;
            }
            if (i10 != 4) {
                return null;
            }
            return TS;
        }

        public static e b(int i10) {
            e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        public String b() {
            return this.f15017g;
        }

        public static e a(String str) {
            return f15014e.get(str);
        }

        public short a() {
            return this.f15016f;
        }
    }

    public a a(String str) {
        this.f15004a = str;
        return this;
    }

    public a b(String str) {
        this.f15005b = str;
        return this;
    }

    public a c(String str) {
        this.f15006c = str;
        return this;
    }

    public void d(boolean z10) {
        this.f15008n = ce.a(this.f15008n, 0, z10);
    }

    public void a(boolean z10) {
        if (!z10) {
            this.f15004a = null;
        }
    }

    public void b(boolean z10) {
        if (!z10) {
            this.f15005b = null;
        }
    }

    public void c(boolean z10) {
        if (!z10) {
            this.f15006c = null;
        }
    }

    public a(String str, String str2, long j10) {
        this();
        this.f15004a = str;
        this.f15006c = str2;
        this.f15007d = j10;
        d(true);
    }

    public a a(long j10) {
        this.f15007d = j10;
        d(true);
        return this;
    }

    /* renamed from: a */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new da(new ds((OutputStream) objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public a(a aVar) {
        this.f15008n = 0;
        this.f15009o = new e[]{e.OLD_ID};
        this.f15008n = aVar.f15008n;
        if (aVar.d()) {
            this.f15004a = aVar.f15004a;
        }
        if (aVar.g()) {
            this.f15005b = aVar.f15005b;
        }
        if (aVar.j()) {
            this.f15006c = aVar.f15006c;
        }
        this.f15007d = aVar.f15007d;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.f15008n = 0;
            read(new da(new ds((InputStream) objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
