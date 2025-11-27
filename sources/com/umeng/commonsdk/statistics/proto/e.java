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

public class e implements ch<e, C0209e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<C0209e, ct> f15075d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f15076e = 7501688097813630241L;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final dl f15077f = new dl("ImprintValue");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final db f15078g = new db("value", (byte) 11, 1);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final db f15079h = new db("ts", (byte) 10, 2);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final db f15080i = new db("guid", (byte) 11, 3);

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f15081j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f15082k = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f15083a;

    /* renamed from: b  reason: collision with root package name */
    public long f15084b;

    /* renamed from: c  reason: collision with root package name */
    public String f15085c;

    /* renamed from: l  reason: collision with root package name */
    private byte f15086l;

    /* renamed from: m  reason: collision with root package name */
    private C0209e[] f15087m;

    public static class a extends dq<e> {
        private a() {
        }

        /* renamed from: a */
        public void b(dg dgVar, e eVar) {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f14130b;
                if (b10 == 0) {
                    dgVar.k();
                    eVar.k();
                    return;
                }
                short s10 = l10.f14131c;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            dj.a(dgVar, b10);
                        } else if (b10 == 11) {
                            eVar.f15085c = dgVar.z();
                            eVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 10) {
                        eVar.f15084b = dgVar.x();
                        eVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 11) {
                    eVar.f15083a = dgVar.z();
                    eVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
        }

        /* renamed from: b */
        public void a(dg dgVar, e eVar) {
            eVar.k();
            dgVar.a(e.f15077f);
            if (eVar.f15083a != null && eVar.d()) {
                dgVar.a(e.f15078g);
                dgVar.a(eVar.f15083a);
                dgVar.c();
            }
            if (eVar.g()) {
                dgVar.a(e.f15079h);
                dgVar.a(eVar.f15084b);
                dgVar.c();
            }
            if (eVar.f15085c != null && eVar.j()) {
                dgVar.a(e.f15080i);
                dgVar.a(eVar.f15085c);
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

    public static class c extends dr<e> {
        private c() {
        }

        public void a(dg dgVar, e eVar) {
            dm dmVar = (dm) dgVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            dmVar.a(bitSet, 3);
            if (eVar.d()) {
                dmVar.a(eVar.f15083a);
            }
            if (eVar.g()) {
                dmVar.a(eVar.f15084b);
            }
            if (eVar.j()) {
                dmVar.a(eVar.f15085c);
            }
        }

        public void b(dg dgVar, e eVar) {
            dm dmVar = (dm) dgVar;
            BitSet b10 = dmVar.b(3);
            if (b10.get(0)) {
                eVar.f15083a = dmVar.z();
                eVar.a(true);
            }
            if (b10.get(1)) {
                eVar.f15084b = dmVar.x();
                eVar.b(true);
            }
            if (b10.get(2)) {
                eVar.f15085c = dmVar.z();
                eVar.c(true);
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
        f15081j = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(C0209e.class);
        enumMap.put(C0209e.VALUE, new ct("value", (byte) 2, new cu((byte) 11)));
        enumMap.put(C0209e.TS, new ct("ts", (byte) 2, new cu((byte) 10)));
        enumMap.put(C0209e.GUID, new ct("guid", (byte) 2, new cu((byte) 11)));
        Map<C0209e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f15075d = unmodifiableMap;
        ct.a(e.class, unmodifiableMap);
    }

    public e() {
        this.f15086l = 0;
        this.f15087m = new C0209e[]{C0209e.VALUE, C0209e.TS, C0209e.GUID};
    }

    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f15083a;
    }

    public void c() {
        this.f15083a = null;
    }

    public void clear() {
        this.f15083a = null;
        b(false);
        this.f15084b = 0;
        this.f15085c = null;
    }

    public boolean d() {
        if (this.f15083a != null) {
            return true;
        }
        return false;
    }

    public long e() {
        return this.f15084b;
    }

    public void f() {
        this.f15086l = ce.b(this.f15086l, 0);
    }

    public boolean g() {
        return ce.a(this.f15086l, 0);
    }

    public String h() {
        return this.f15085c;
    }

    public void i() {
        this.f15085c = null;
    }

    public boolean j() {
        if (this.f15085c != null) {
            return true;
        }
        return false;
    }

    public void k() {
    }

    public void read(dg dgVar) {
        f15081j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        boolean z10;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f15083a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f15084b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f15085c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    public void write(dg dgVar) {
        f15081j.get(dgVar.D()).b().a(dgVar, this);
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e  reason: collision with other inner class name */
    public enum C0209e implements co {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, C0209e> f15091d = null;

        /* renamed from: e  reason: collision with root package name */
        private final short f15093e;

        /* renamed from: f  reason: collision with root package name */
        private final String f15094f;

        /* access modifiers changed from: public */
        static {
            f15091d = new HashMap();
            Iterator<E> it = EnumSet.allOf(C0209e.class).iterator();
            while (it.hasNext()) {
                C0209e eVar = (C0209e) it.next();
                f15091d.put(eVar.b(), eVar);
            }
        }

        private C0209e(short s10, String str) {
            this.f15093e = s10;
            this.f15094f = str;
        }

        public static C0209e a(int i10) {
            if (i10 == 1) {
                return VALUE;
            }
            if (i10 == 2) {
                return TS;
            }
            if (i10 != 3) {
                return null;
            }
            return GUID;
        }

        public static C0209e b(int i10) {
            C0209e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        public String b() {
            return this.f15094f;
        }

        public static C0209e a(String str) {
            return f15091d.get(str);
        }

        public short a() {
            return this.f15093e;
        }
    }

    public e a(String str) {
        this.f15083a = str;
        return this;
    }

    public void b(boolean z10) {
        this.f15086l = ce.a(this.f15086l, 0, z10);
    }

    public void c(boolean z10) {
        if (!z10) {
            this.f15085c = null;
        }
    }

    public void a(boolean z10) {
        if (!z10) {
            this.f15083a = null;
        }
    }

    public e b(String str) {
        this.f15085c = str;
        return this;
    }

    public e(long j10, String str) {
        this();
        this.f15084b = j10;
        b(true);
        this.f15085c = str;
    }

    public e a(long j10) {
        this.f15084b = j10;
        b(true);
        return this;
    }

    /* renamed from: a */
    public C0209e fieldForId(int i10) {
        return C0209e.a(i10);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new da(new ds((OutputStream) objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public e(e eVar) {
        this.f15086l = 0;
        this.f15087m = new C0209e[]{C0209e.VALUE, C0209e.TS, C0209e.GUID};
        this.f15086l = eVar.f15086l;
        if (eVar.d()) {
            this.f15083a = eVar.f15083a;
        }
        this.f15084b = eVar.f15084b;
        if (eVar.j()) {
            this.f15085c = eVar.f15085c;
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.f15086l = 0;
            read(new da(new ds((InputStream) objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
