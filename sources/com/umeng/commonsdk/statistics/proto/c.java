package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dc;
import com.umeng.analytics.pro.dd;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c implements ch<c, e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<e, ct> f15038d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f15039e = -5764118265293965743L;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final dl f15040f = new dl("IdTracking");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final db f15041g = new db("snapshots", (byte) 13, 1);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final db f15042h = new db("journals", (byte) 15, 2);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final db f15043i = new db("checksum", (byte) 11, 3);

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f15044j;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, b> f15045a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f15046b;

    /* renamed from: c  reason: collision with root package name */
    public String f15047c;

    /* renamed from: k  reason: collision with root package name */
    private e[] f15048k;

    public static class a extends dq<c> {
        private a() {
        }

        /* renamed from: a */
        public void b(dg dgVar, c cVar) {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f14130b;
                if (b10 == 0) {
                    dgVar.k();
                    cVar.n();
                    return;
                }
                short s10 = l10.f14131c;
                int i10 = 0;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            dj.a(dgVar, b10);
                        } else if (b10 == 11) {
                            cVar.f15047c = dgVar.z();
                            cVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 15) {
                        dc p10 = dgVar.p();
                        cVar.f15046b = new ArrayList(p10.f14133b);
                        while (i10 < p10.f14133b) {
                            a aVar = new a();
                            aVar.read(dgVar);
                            cVar.f15046b.add(aVar);
                            i10++;
                        }
                        dgVar.q();
                        cVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 13) {
                    dd n10 = dgVar.n();
                    cVar.f15045a = new HashMap(n10.f14136c * 2);
                    while (i10 < n10.f14136c) {
                        String z10 = dgVar.z();
                        b bVar = new b();
                        bVar.read(dgVar);
                        cVar.f15045a.put(z10, bVar);
                        i10++;
                    }
                    dgVar.o();
                    cVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
        }

        /* renamed from: b */
        public void a(dg dgVar, c cVar) {
            cVar.n();
            dgVar.a(c.f15040f);
            if (cVar.f15045a != null) {
                dgVar.a(c.f15041g);
                dgVar.a(new dd((byte) 11, (byte) 12, cVar.f15045a.size()));
                for (Map.Entry next : cVar.f15045a.entrySet()) {
                    dgVar.a((String) next.getKey());
                    ((b) next.getValue()).write(dgVar);
                }
                dgVar.e();
                dgVar.c();
            }
            if (cVar.f15046b != null && cVar.j()) {
                dgVar.a(c.f15042h);
                dgVar.a(new dc((byte) 12, cVar.f15046b.size()));
                for (a write : cVar.f15046b) {
                    write.write(dgVar);
                }
                dgVar.f();
                dgVar.c();
            }
            if (cVar.f15047c != null && cVar.m()) {
                dgVar.a(c.f15043i);
                dgVar.a(cVar.f15047c);
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

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c  reason: collision with other inner class name */
    public static class C0207c extends dr<c> {
        private C0207c() {
        }

        public void a(dg dgVar, c cVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(cVar.f15045a.size());
            for (Map.Entry next : cVar.f15045a.entrySet()) {
                dmVar.a((String) next.getKey());
                ((b) next.getValue()).write(dmVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            dmVar.a(bitSet, 2);
            if (cVar.j()) {
                dmVar.a(cVar.f15046b.size());
                for (a write : cVar.f15046b) {
                    write.write(dmVar);
                }
            }
            if (cVar.m()) {
                dmVar.a(cVar.f15047c);
            }
        }

        public void b(dg dgVar, c cVar) {
            dm dmVar = (dm) dgVar;
            dd ddVar = new dd((byte) 11, (byte) 12, dmVar.w());
            cVar.f15045a = new HashMap(ddVar.f14136c * 2);
            for (int i10 = 0; i10 < ddVar.f14136c; i10++) {
                String z10 = dmVar.z();
                b bVar = new b();
                bVar.read(dmVar);
                cVar.f15045a.put(z10, bVar);
            }
            cVar.a(true);
            BitSet b10 = dmVar.b(2);
            if (b10.get(0)) {
                dc dcVar = new dc((byte) 12, dmVar.w());
                cVar.f15046b = new ArrayList(dcVar.f14133b);
                for (int i11 = 0; i11 < dcVar.f14133b; i11++) {
                    a aVar = new a();
                    aVar.read(dmVar);
                    cVar.f15046b.add(aVar);
                }
                cVar.b(true);
            }
            if (b10.get(1)) {
                cVar.f15047c = dmVar.z();
                cVar.c(true);
            }
        }
    }

    public static class d implements dp {
        private d() {
        }

        /* renamed from: a */
        public C0207c b() {
            return new C0207c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f15044j = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new ct("snapshots", (byte) 1, new cw((byte) 13, new cu((byte) 11), new cy((byte) 12, b.class))));
        enumMap.put(e.JOURNALS, new ct("journals", (byte) 2, new cv((byte) 15, new cy((byte) 12, a.class))));
        enumMap.put(e.CHECKSUM, new ct("checksum", (byte) 2, new cu((byte) 11)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f15038d = unmodifiableMap;
        ct.a(c.class, unmodifiableMap);
    }

    public c() {
        this.f15048k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    /* renamed from: a */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, b> map = this.f15045a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, b> c() {
        return this.f15045a;
    }

    public void clear() {
        this.f15045a = null;
        this.f15046b = null;
        this.f15047c = null;
    }

    public void d() {
        this.f15045a = null;
    }

    public boolean e() {
        if (this.f15045a != null) {
            return true;
        }
        return false;
    }

    public int f() {
        List<a> list = this.f15046b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<a> g() {
        List<a> list = this.f15046b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<a> h() {
        return this.f15046b;
    }

    public void i() {
        this.f15046b = null;
    }

    public boolean j() {
        if (this.f15046b != null) {
            return true;
        }
        return false;
    }

    public String k() {
        return this.f15047c;
    }

    public void l() {
        this.f15047c = null;
    }

    public boolean m() {
        if (this.f15047c != null) {
            return true;
        }
        return false;
    }

    public void n() {
        if (this.f15045a == null) {
            throw new dh("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }

    public void read(dg dgVar) {
        f15044j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, b> map = this.f15045a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<a> list = this.f15046b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f15047c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void write(dg dgVar) {
        f15044j.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f15052d = null;

        /* renamed from: e  reason: collision with root package name */
        private final short f15054e;

        /* renamed from: f  reason: collision with root package name */
        private final String f15055f;

        /* access modifiers changed from: public */
        static {
            f15052d = new HashMap();
            Iterator<E> it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f15052d.put(eVar.b(), eVar);
            }
        }

        private e(short s10, String str) {
            this.f15054e = s10;
            this.f15055f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return SNAPSHOTS;
            }
            if (i10 == 2) {
                return JOURNALS;
            }
            if (i10 != 3) {
                return null;
            }
            return CHECKSUM;
        }

        public static e b(int i10) {
            e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        public String b() {
            return this.f15055f;
        }

        public static e a(String str) {
            return f15052d.get(str);
        }

        public short a() {
            return this.f15054e;
        }
    }

    public void a(String str, b bVar) {
        if (this.f15045a == null) {
            this.f15045a = new HashMap();
        }
        this.f15045a.put(str, bVar);
    }

    public void b(boolean z10) {
        if (!z10) {
            this.f15046b = null;
        }
    }

    public void c(boolean z10) {
        if (!z10) {
            this.f15047c = null;
        }
    }

    public c(Map<String, b> map) {
        this();
        this.f15045a = map;
    }

    public c(c cVar) {
        this.f15048k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : cVar.f15045a.entrySet()) {
                hashMap.put((String) next.getKey(), new b((b) next.getValue()));
            }
            this.f15045a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            for (a aVar : cVar.f15046b) {
                arrayList.add(new a(aVar));
            }
            this.f15046b = arrayList;
        }
        if (cVar.m()) {
            this.f15047c = cVar.f15047c;
        }
    }

    public c a(Map<String, b> map) {
        this.f15045a = map;
        return this;
    }

    public void a(boolean z10) {
        if (!z10) {
            this.f15045a = null;
        }
    }

    public void a(a aVar) {
        if (this.f15046b == null) {
            this.f15046b = new ArrayList();
        }
        this.f15046b.add(aVar);
    }

    public c a(List<a> list) {
        this.f15046b = list;
        return this;
    }

    public c a(String str) {
        this.f15047c = str;
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

    private void a(ObjectInputStream objectInputStream) {
        try {
            read(new da(new ds((InputStream) objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
