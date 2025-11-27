package o3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import d4.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import k3.k;
import k3.x;
import m3.m;
import n3.t;

public class c implements Iterable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8458a;

    /* renamed from: b  reason: collision with root package name */
    public int f8459b;

    /* renamed from: c  reason: collision with root package name */
    public int f8460c;

    /* renamed from: d  reason: collision with root package name */
    public int f8461d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f8462e;

    /* renamed from: f  reason: collision with root package name */
    public final t[] f8463f;

    /* renamed from: g  reason: collision with root package name */
    public final Map f8464g;

    /* renamed from: h  reason: collision with root package name */
    public final Map f8465h;

    /* renamed from: i  reason: collision with root package name */
    public final Locale f8466i;

    public c(boolean z10, Collection collection, Map map, Locale locale) {
        this.f8458a = z10;
        this.f8463f = (t[]) collection.toArray(new t[collection.size()]);
        this.f8464g = map;
        this.f8466i = locale;
        this.f8465h = a(map, z10, locale);
        o(collection);
    }

    public static c j(m mVar, Collection collection, Map map, boolean z10) {
        return new c(z10, collection, map, mVar.v());
    }

    public static final int l(int i10) {
        if (i10 <= 5) {
            return 8;
        }
        if (i10 <= 12) {
            return 16;
        }
        int i11 = 32;
        while (i11 < i10 + (i10 >> 2)) {
            i11 += i11;
        }
        return i11;
    }

    public final Map a(Map map, boolean z10, Locale locale) {
        if (map == null || map.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (z10) {
                str = str.toLowerCase(locale);
            }
            for (x c10 : (List) entry.getValue()) {
                String c11 = c10.c();
                if (z10) {
                    c11 = c11.toLowerCase(locale);
                }
                hashMap.put(c11, str);
            }
        }
        return hashMap;
    }

    public final t b(String str, int i10, Object obj) {
        if (obj == null) {
            return e((String) this.f8465h.get(str));
        }
        int i11 = this.f8459b + 1;
        int i12 = ((i10 >> 1) + i11) << 1;
        Object obj2 = this.f8462e[i12];
        if (str.equals(obj2)) {
            return (t) this.f8462e[i12 + 1];
        }
        if (obj2 != null) {
            int i13 = (i11 + (i11 >> 1)) << 1;
            int i14 = this.f8461d + i13;
            while (i13 < i14) {
                Object obj3 = this.f8462e[i13];
                if (obj3 == str || str.equals(obj3)) {
                    return (t) this.f8462e[i13 + 1];
                }
                i13 += 2;
            }
        }
        return e((String) this.f8465h.get(str));
    }

    public final t c(String str, int i10, Object obj) {
        int i11 = this.f8459b + 1;
        int i12 = ((i10 >> 1) + i11) << 1;
        Object obj2 = this.f8462e[i12];
        if (str.equals(obj2)) {
            return (t) this.f8462e[i12 + 1];
        }
        if (obj2 == null) {
            return null;
        }
        int i13 = (i11 + (i11 >> 1)) << 1;
        int i14 = this.f8461d + i13;
        while (i13 < i14) {
            Object obj3 = this.f8462e[i13];
            if (obj3 == str || str.equals(obj3)) {
                return (t) this.f8462e[i13 + 1];
            }
            i13 += 2;
        }
        return null;
    }

    public final int d(t tVar) {
        int length = this.f8463f.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (this.f8463f[i10] == tVar) {
                return i10;
            }
        }
        throw new IllegalStateException("Illegal state: property '" + tVar.getName() + "' missing from _propsInOrder");
    }

    public final t e(String str) {
        if (str == null) {
            return null;
        }
        int f10 = f(str);
        int i10 = f10 << 1;
        Object obj = this.f8462e[i10];
        if (str.equals(obj)) {
            return (t) this.f8462e[i10 + 1];
        }
        if (obj == null) {
            return null;
        }
        return c(str, f10, obj);
    }

    public final int f(String str) {
        return str.hashCode() & this.f8459b;
    }

    public final List g() {
        ArrayList arrayList = new ArrayList(this.f8460c);
        int length = this.f8462e.length;
        for (int i10 = 1; i10 < length; i10 += 2) {
            t tVar = (t) this.f8462e[i10];
            if (tVar != null) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }

    public t h(t tVar, q qVar) {
        k unwrappingDeserializer;
        if (tVar == null) {
            return tVar;
        }
        t K = tVar.K(qVar.c(tVar.getName()));
        k u10 = K.u();
        if (u10 == null || (unwrappingDeserializer = u10.unwrappingDeserializer(qVar)) == u10) {
            return K;
        }
        return K.L(unwrappingDeserializer);
    }

    public c i() {
        int length = this.f8462e.length;
        int i10 = 0;
        for (int i11 = 1; i11 < length; i11 += 2) {
            t tVar = (t) this.f8462e[i11];
            if (tVar != null) {
                tVar.j(i10);
                i10++;
            }
        }
        return this;
    }

    public Iterator iterator() {
        return g().iterator();
    }

    public t k(String str) {
        if (str != null) {
            if (this.f8458a) {
                str = str.toLowerCase(this.f8466i);
            }
            int hashCode = str.hashCode() & this.f8459b;
            int i10 = hashCode << 1;
            Object obj = this.f8462e[i10];
            if (obj == str || str.equals(obj)) {
                return (t) this.f8462e[i10 + 1];
            }
            return b(str, hashCode, obj);
        }
        throw new IllegalArgumentException("Cannot pass null property name");
    }

    public t[] m() {
        return this.f8463f;
    }

    public final String n(t tVar) {
        boolean z10 = this.f8458a;
        String name = tVar.getName();
        if (z10) {
            return name.toLowerCase(this.f8466i);
        }
        return name;
    }

    public void o(Collection collection) {
        int size = collection.size();
        this.f8460c = size;
        int l10 = l(size);
        this.f8459b = l10 - 1;
        int i10 = (l10 >> 1) + l10;
        Object[] objArr = new Object[(i10 * 2)];
        Iterator it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (tVar != null) {
                String n10 = n(tVar);
                int f10 = f(n10);
                int i12 = f10 << 1;
                if (objArr[i12] != null) {
                    i12 = ((f10 >> 1) + l10) << 1;
                    if (objArr[i12] != null) {
                        i12 = (i10 << 1) + i11;
                        i11 += 2;
                        if (i12 >= objArr.length) {
                            objArr = Arrays.copyOf(objArr, objArr.length + 4);
                        }
                    }
                }
                objArr[i12] = n10;
                objArr[i12 + 1] = tVar;
            }
        }
        this.f8462e = objArr;
        this.f8461d = i11;
    }

    public boolean p() {
        return this.f8458a;
    }

    public void q(t tVar) {
        ArrayList arrayList = new ArrayList(this.f8460c);
        String n10 = n(tVar);
        int length = this.f8462e.length;
        boolean z10 = false;
        for (int i10 = 1; i10 < length; i10 += 2) {
            Object[] objArr = this.f8462e;
            t tVar2 = (t) objArr[i10];
            if (tVar2 != null) {
                if (z10 || !(z10 = n10.equals(objArr[i10 - 1]))) {
                    arrayList.add(tVar2);
                } else {
                    this.f8463f[d(tVar2)] = null;
                }
            }
        }
        if (z10) {
            o(arrayList);
            return;
        }
        throw new NoSuchElementException("No entry '" + tVar.getName() + "' found, can't remove");
    }

    public c r(q qVar) {
        if (qVar == null || qVar == q.f6290a) {
            return this;
        }
        ArrayList arrayList = new ArrayList(r0);
        for (t tVar : this.f8463f) {
            if (tVar == null) {
                arrayList.add(tVar);
            } else {
                arrayList.add(h(tVar, qVar));
            }
        }
        return new c(this.f8458a, (Collection) arrayList, this.f8464g, this.f8466i);
    }

    public void s(t tVar, t tVar2) {
        int length = this.f8462e.length;
        for (int i10 = 1; i10 <= length; i10 += 2) {
            Object[] objArr = this.f8462e;
            if (objArr[i10] == tVar) {
                objArr[i10] = tVar2;
                this.f8463f[d(tVar)] = tVar2;
                return;
            }
        }
        throw new NoSuchElementException("No entry '" + tVar.getName() + "' found, can't replace");
    }

    public int size() {
        return this.f8460c;
    }

    public c t(boolean z10) {
        if (this.f8458a == z10) {
            return this;
        }
        return new c(this, z10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Properties=[");
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            t tVar = (t) it.next();
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(tVar.getName());
            sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
            sb.append(tVar.getType());
            sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
            i10 = i11;
        }
        sb.append(']');
        if (!this.f8464g.isEmpty()) {
            sb.append("(aliases: ");
            sb.append(this.f8464g);
            sb.append(")");
        }
        return sb.toString();
    }

    public c u(t tVar) {
        String n10 = n(tVar);
        int length = this.f8462e.length;
        for (int i10 = 1; i10 < length; i10 += 2) {
            t tVar2 = (t) this.f8462e[i10];
            if (tVar2 != null && tVar2.getName().equals(n10)) {
                return new c(this, tVar, i10, d(tVar2));
            }
        }
        return new c(this, tVar, n10, f(n10));
    }

    public c v(Collection collection, Collection collection2) {
        if ((collection == null || collection.isEmpty()) && collection2 == null) {
            return this;
        }
        ArrayList arrayList = new ArrayList(r0);
        for (t tVar : this.f8463f) {
            if (tVar != null && !d4.m.c(tVar.getName(), collection, collection2)) {
                arrayList.add(tVar);
            }
        }
        return new c(this.f8458a, (Collection) arrayList, this.f8464g, this.f8466i);
    }

    public c(c cVar, t tVar, int i10, int i11) {
        this.f8458a = cVar.f8458a;
        this.f8466i = cVar.f8466i;
        this.f8459b = cVar.f8459b;
        this.f8460c = cVar.f8460c;
        this.f8461d = cVar.f8461d;
        this.f8464g = cVar.f8464g;
        this.f8465h = cVar.f8465h;
        Object[] objArr = cVar.f8462e;
        this.f8462e = Arrays.copyOf(objArr, objArr.length);
        t[] tVarArr = cVar.f8463f;
        t[] tVarArr2 = (t[]) Arrays.copyOf(tVarArr, tVarArr.length);
        this.f8463f = tVarArr2;
        this.f8462e[i10] = tVar;
        tVarArr2[i11] = tVar;
    }

    public c(c cVar, t tVar, String str, int i10) {
        this.f8458a = cVar.f8458a;
        this.f8466i = cVar.f8466i;
        this.f8459b = cVar.f8459b;
        this.f8460c = cVar.f8460c;
        this.f8461d = cVar.f8461d;
        this.f8464g = cVar.f8464g;
        this.f8465h = cVar.f8465h;
        Object[] objArr = cVar.f8462e;
        this.f8462e = Arrays.copyOf(objArr, objArr.length);
        t[] tVarArr = cVar.f8463f;
        int length = tVarArr.length;
        t[] tVarArr2 = (t[]) Arrays.copyOf(tVarArr, length + 1);
        this.f8463f = tVarArr2;
        tVarArr2[length] = tVar;
        int i11 = this.f8459b + 1;
        int i12 = i10 << 1;
        Object[] objArr2 = this.f8462e;
        if (objArr2[i12] != null) {
            i12 = ((i10 >> 1) + i11) << 1;
            if (objArr2[i12] != null) {
                int i13 = this.f8461d;
                i12 = ((i11 + (i11 >> 1)) << 1) + i13;
                this.f8461d = i13 + 2;
                if (i12 >= objArr2.length) {
                    this.f8462e = Arrays.copyOf(objArr2, objArr2.length + 4);
                }
            }
        }
        Object[] objArr3 = this.f8462e;
        objArr3[i12] = str;
        objArr3[i12 + 1] = tVar;
    }

    public c(c cVar, boolean z10) {
        this.f8458a = z10;
        this.f8466i = cVar.f8466i;
        this.f8464g = cVar.f8464g;
        this.f8465h = cVar.f8465h;
        t[] tVarArr = cVar.f8463f;
        t[] tVarArr2 = (t[]) Arrays.copyOf(tVarArr, tVarArr.length);
        this.f8463f = tVarArr2;
        o(Arrays.asList(tVarArr2));
    }
}
