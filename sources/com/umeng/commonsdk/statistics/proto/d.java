package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class d implements ch<d, e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<e, ct> f15056d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f15057e = 2846460275012375038L;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final dl f15058f = new dl("Imprint");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final db f15059g = new db("property", (byte) 13, 1);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final db f15060h = new db("version", (byte) 8, 2);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final db f15061i = new db("checksum", (byte) 11, 3);

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f15062j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f15063k = 0;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, e> f15064a;

    /* renamed from: b  reason: collision with root package name */
    public int f15065b;

    /* renamed from: c  reason: collision with root package name */
    public String f15066c;

    /* renamed from: l  reason: collision with root package name */
    private byte f15067l;

    public static class a extends dq<d> {
        private a() {
        }

        /* renamed from: a */
        public void b(dg dgVar, d dVar) {
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
                        } else if (b10 == 11) {
                            dVar.f15066c = dgVar.z();
                            dVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 8) {
                        dVar.f15065b = dgVar.w();
                        dVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 13) {
                    dd n10 = dgVar.n();
                    dVar.f15064a = new HashMap(n10.f14136c * 2);
                    for (int i10 = 0; i10 < n10.f14136c; i10++) {
                        String z10 = dgVar.z();
                        e eVar = new e();
                        eVar.read(dgVar);
                        dVar.f15064a.put(z10, eVar);
                    }
                    dgVar.o();
                    dVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new dh("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        /* renamed from: b */
        public void a(dg dgVar, d dVar) {
            dVar.l();
            dgVar.a(d.f15058f);
            if (dVar.f15064a != null) {
                dgVar.a(d.f15059g);
                dgVar.a(new dd((byte) 11, (byte) 12, dVar.f15064a.size()));
                for (Map.Entry next : dVar.f15064a.entrySet()) {
                    dgVar.a((String) next.getKey());
                    ((e) next.getValue()).write(dgVar);
                }
                dgVar.e();
                dgVar.c();
            }
            dgVar.a(d.f15060h);
            dgVar.a(dVar.f15065b);
            dgVar.c();
            if (dVar.f15066c != null) {
                dgVar.a(d.f15061i);
                dgVar.a(dVar.f15066c);
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

    public static class c extends dr<d> {
        private c() {
        }

        public void a(dg dgVar, d dVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(dVar.f15064a.size());
            for (Map.Entry next : dVar.f15064a.entrySet()) {
                dmVar.a((String) next.getKey());
                ((e) next.getValue()).write(dmVar);
            }
            dmVar.a(dVar.f15065b);
            dmVar.a(dVar.f15066c);
        }

        public void b(dg dgVar, d dVar) {
            dm dmVar = (dm) dgVar;
            dd ddVar = new dd((byte) 11, (byte) 12, dmVar.w());
            dVar.f15064a = new HashMap(ddVar.f14136c * 2);
            for (int i10 = 0; i10 < ddVar.f14136c; i10++) {
                String z10 = dmVar.z();
                e eVar = new e();
                eVar.read(dmVar);
                dVar.f15064a.put(z10, eVar);
            }
            dVar.a(true);
            dVar.f15065b = dmVar.w();
            dVar.b(true);
            dVar.f15066c = dmVar.z();
            dVar.c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d  reason: collision with other inner class name */
    public static class C0208d implements dp {
        private C0208d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f15062j = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new C0208d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new ct("property", (byte) 1, new cw((byte) 13, new cu((byte) 11), new cy((byte) 12, e.class))));
        enumMap.put(e.VERSION, new ct("version", (byte) 1, new cu((byte) 8)));
        enumMap.put(e.CHECKSUM, new ct("checksum", (byte) 1, new cu((byte) 11)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f15056d = unmodifiableMap;
        ct.a(d.class, unmodifiableMap);
    }

    public d() {
        this.f15067l = 0;
    }

    /* renamed from: a */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, e> map = this.f15064a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, e> c() {
        return this.f15064a;
    }

    public void clear() {
        this.f15064a = null;
        b(false);
        this.f15065b = 0;
        this.f15066c = null;
    }

    public void d() {
        this.f15064a = null;
    }

    public boolean e() {
        if (this.f15064a != null) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f15065b;
    }

    public void g() {
        this.f15067l = ce.b(this.f15067l, 0);
    }

    public boolean h() {
        return ce.a(this.f15067l, 0);
    }

    public String i() {
        return this.f15066c;
    }

    public void j() {
        this.f15066c = null;
    }

    public boolean k() {
        if (this.f15066c != null) {
            return true;
        }
        return false;
    }

    public void l() {
        if (this.f15064a == null) {
            throw new dh("Required field 'property' was not present! Struct: " + toString());
        } else if (this.f15066c == null) {
            throw new dh("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    public void read(dg dgVar) {
        f15062j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, e> map = this.f15064a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f15065b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f15066c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    public void write(dg dgVar) {
        f15062j.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f15071d = null;

        /* renamed from: e  reason: collision with root package name */
        private final short f15073e;

        /* renamed from: f  reason: collision with root package name */
        private final String f15074f;

        /* access modifiers changed from: public */
        static {
            f15071d = new HashMap();
            Iterator<E> it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f15071d.put(eVar.b(), eVar);
            }
        }

        private e(short s10, String str) {
            this.f15073e = s10;
            this.f15074f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return PROPERTY;
            }
            if (i10 == 2) {
                return VERSION;
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
            return this.f15074f;
        }

        public static e a(String str) {
            return f15071d.get(str);
        }

        public short a() {
            return this.f15073e;
        }
    }

    public void a(String str, e eVar) {
        if (this.f15064a == null) {
            this.f15064a = new HashMap();
        }
        this.f15064a.put(str, eVar);
    }

    public void b(boolean z10) {
        this.f15067l = ce.a(this.f15067l, 0, z10);
    }

    public void c(boolean z10) {
        if (!z10) {
            this.f15066c = null;
        }
    }

    public d(Map<String, e> map, int i10, String str) {
        this();
        this.f15064a = map;
        this.f15065b = i10;
        b(true);
        this.f15066c = str;
    }

    /* renamed from: b */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public d a(Map<String, e> map) {
        this.f15064a = map;
        return this;
    }

    public void a(boolean z10) {
        if (!z10) {
            this.f15064a = null;
        }
    }

    public d a(int i10) {
        this.f15065b = i10;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f15067l = 0;
        this.f15067l = dVar.f15067l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : dVar.f15064a.entrySet()) {
                hashMap.put((String) next.getKey(), new e((e) next.getValue()));
            }
            this.f15064a = hashMap;
        }
        this.f15065b = dVar.f15065b;
        if (dVar.k()) {
            this.f15066c = dVar.f15066c;
        }
    }

    public d a(String str) {
        this.f15066c = str;
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
            this.f15067l = 0;
            read(new da(new ds((InputStream) objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
