package t9;

import i9.j;
import i9.y;
import i9.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import s9.c;
import s9.d;
import s9.f;
import s9.g;
import s9.h;
import s9.i;
import s9.k;
import s9.l;
import s9.m;
import s9.n;
import s9.o;
import s9.p;
import s9.q;
import s9.r;
import s9.s;
import s9.t;
import s9.u;
import s9.v;
import s9.w;
import z9.b;

public final class e implements b, d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19587b = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    public static final Map f19588c;

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap f19589d;

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap f19590e;

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap f19591f;

    /* renamed from: g  reason: collision with root package name */
    public static final Map f19592g;

    /* renamed from: a  reason: collision with root package name */
    public final Class f19593a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        int i10 = 0;
        List g10 = j.g(s9.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, s9.b.class, c.class, d.class, s9.e.class, f.class, g.class, h.class, i.class, s9.j.class, k.class, m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(i9.k.k(g10, 10));
        for (Object next : g10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                j.j();
            }
            arrayList.add(h9.p.a((Class) next, Integer.valueOf(i10)));
            i10 = i11;
        }
        f19588c = z.g(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f19589d = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f19590e = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        i.f(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            i.f(str, "kotlinName");
            sb.append(ba.t.R(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            h9.k a10 = h9.p.a(sb2, str + ".Companion");
            hashMap3.put(a10.c(), a10.d());
        }
        for (Map.Entry entry : f19588c.entrySet()) {
            int intValue = ((Number) entry.getValue()).intValue();
            String name = ((Class) entry.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f19591f = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(y.a(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), ba.t.R((String) entry2.getValue(), '.', (String) null, 2, (Object) null));
        }
        f19592g = linkedHashMap;
    }

    public e(Class cls) {
        i.g(cls, "jClass");
        this.f19593a = cls;
    }

    public Class a() {
        return this.f19593a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e) || !i.b(r9.a.a(this), r9.a.a((b) obj))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return r9.a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
