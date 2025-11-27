package com.umeng.analytics.pro;

import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.cr;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class cr<T extends cr<?, ?>, F extends co> implements ch<T, F> {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f14058c;

    /* renamed from: a  reason: collision with root package name */
    protected Object f14059a;

    /* renamed from: b  reason: collision with root package name */
    protected F f14060b;

    public static class a extends dq<cr> {
        private a() {
        }

        /* renamed from: a */
        public void b(dg dgVar, cr crVar) {
            crVar.f14060b = null;
            crVar.f14059a = null;
            dgVar.j();
            db l10 = dgVar.l();
            Object a10 = crVar.a(dgVar, l10);
            crVar.f14059a = a10;
            if (a10 != null) {
                crVar.f14060b = crVar.a(l10.f14131c);
            }
            dgVar.m();
            dgVar.l();
            dgVar.k();
        }

        /* renamed from: b */
        public void a(dg dgVar, cr crVar) {
            if (crVar.a() == null || crVar.b() == null) {
                throw new dh("Cannot write a TUnion with no set value!");
            }
            dgVar.a(crVar.d());
            dgVar.a(crVar.c(crVar.f14060b));
            crVar.a(dgVar);
            dgVar.c();
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

    public static class c extends dr<cr> {
        private c() {
        }

        /* renamed from: a */
        public void b(dg dgVar, cr crVar) {
            crVar.f14060b = null;
            crVar.f14059a = null;
            short v10 = dgVar.v();
            Object a10 = crVar.a(dgVar, v10);
            crVar.f14059a = a10;
            if (a10 != null) {
                crVar.f14060b = crVar.a(v10);
            }
        }

        /* renamed from: b */
        public void a(dg dgVar, cr crVar) {
            if (crVar.a() == null || crVar.b() == null) {
                throw new dh("Cannot write a TUnion with no set value!");
            }
            dgVar.a(crVar.f14060b.a());
            crVar.b(dgVar);
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
        f14058c = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
    }

    public cr() {
        this.f14060b = null;
        this.f14059a = null;
    }

    private static Object a(Object obj) {
        if (obj instanceof ch) {
            return ((ch) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return ci.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) (Map) obj) : obj;
    }

    public abstract F a(short s10);

    public abstract Object a(dg dgVar, db dbVar);

    public abstract Object a(dg dgVar, short s10);

    public abstract void a(dg dgVar);

    public Object b() {
        return this.f14059a;
    }

    public abstract void b(F f10, Object obj);

    public abstract void b(dg dgVar);

    public abstract db c(F f10);

    public boolean c() {
        return this.f14060b != null;
    }

    public final void clear() {
        this.f14060b = null;
        this.f14059a = null;
    }

    public abstract dl d();

    public void read(dg dgVar) {
        f14058c.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Operator.Operation.LESS_THAN);
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b10 = b();
            sb.append(c(a()).f14129a);
            sb.append(SOAP.DELIM);
            if (b10 instanceof ByteBuffer) {
                ci.a((ByteBuffer) b10, sb);
            } else {
                sb.append(b10.toString());
            }
        }
        sb.append(Operator.Operation.GREATER_THAN);
        return sb.toString();
    }

    public void write(dg dgVar) {
        f14058c.get(dgVar.D()).b().a(dgVar, this);
    }

    public boolean b(F f10) {
        return this.f14060b == f10;
    }

    public boolean b(int i10) {
        return b(a((short) i10));
    }

    public cr(F f10, Object obj) {
        a(f10, obj);
    }

    public cr(cr<T, F> crVar) {
        if (crVar.getClass().equals(getClass())) {
            this.f14060b = crVar.f14060b;
            this.f14059a = a(crVar.f14059a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(a(next.getKey()), a(next.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object a10 : set) {
            hashSet.add(a(a10));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object a10 : list) {
            arrayList.add(a(a10));
        }
        return arrayList;
    }

    public F a() {
        return this.f14060b;
    }

    public Object a(F f10) {
        if (f10 == this.f14060b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f10 + " because union's set field is " + this.f14060b);
    }

    public Object a(int i10) {
        return a(a((short) i10));
    }

    public void a(F f10, Object obj) {
        b(f10, obj);
        this.f14060b = f10;
        this.f14059a = obj;
    }

    public void a(int i10, Object obj) {
        a(a((short) i10), obj);
    }
}
