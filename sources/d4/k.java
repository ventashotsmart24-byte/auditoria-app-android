package d4;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import k3.b;
import k3.f;
import k3.q;
import r3.i;

public class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final Class f6276a;

    /* renamed from: b  reason: collision with root package name */
    public final Enum[] f6277b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f6278c;

    /* renamed from: d  reason: collision with root package name */
    public final Enum f6279d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f6280e;

    public k(Class cls, Enum[] enumArr, HashMap hashMap, Enum enumR, boolean z10) {
        this.f6276a = cls;
        this.f6277b = enumArr;
        this.f6278c = hashMap;
        this.f6279d = enumR;
        this.f6280e = z10;
    }

    public static k a(Class cls, b bVar, boolean z10) {
        Class d10 = d(cls);
        Enum[] e10 = e(cls);
        String[] o10 = bVar.o(d10, e10, new String[e10.length]);
        String[][] strArr = new String[o10.length][];
        bVar.n(d10, e10, strArr);
        HashMap hashMap = new HashMap();
        int length = e10.length;
        for (int i10 = 0; i10 < length; i10++) {
            Enum enumR = e10[i10];
            String str = o10[i10];
            if (str == null) {
                str = enumR.name();
            }
            hashMap.put(str, enumR);
            String[] strArr2 = strArr[i10];
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    if (!hashMap.containsKey(str2)) {
                        hashMap.put(str2, enumR);
                    }
                }
            }
        }
        return new k(d10, e10, hashMap, f(bVar, d10), z10);
    }

    public static k b(Class cls, i iVar, b bVar, boolean z10) {
        Class d10 = d(cls);
        Enum[] e10 = e(cls);
        HashMap hashMap = new HashMap();
        int length = e10.length;
        while (true) {
            length--;
            if (length < 0) {
                return new k(d10, e10, hashMap, f(bVar, d10), z10);
            }
            Enum enumR = e10[length];
            try {
                Object n10 = iVar.n(enumR);
                if (n10 != null) {
                    hashMap.put(n10.toString(), enumR);
                }
            } catch (Exception e11) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + enumR + ": " + e11.getMessage());
            }
        }
    }

    public static k c(Class cls, b bVar, boolean z10) {
        Class d10 = d(cls);
        Enum[] e10 = e(cls);
        HashMap hashMap = new HashMap();
        String[][] strArr = new String[e10.length][];
        bVar.n(d10, e10, strArr);
        int length = e10.length;
        while (true) {
            length--;
            if (length < 0) {
                return new k(d10, e10, hashMap, f(bVar, d10), z10);
            }
            Enum enumR = e10[length];
            hashMap.put(enumR.toString(), enumR);
            String[] strArr2 = strArr[length];
            if (strArr2 != null) {
                for (String str : strArr2) {
                    if (!hashMap.containsKey(str)) {
                        hashMap.put(str, enumR);
                    }
                }
            }
        }
    }

    public static Class d(Class cls) {
        return cls;
    }

    public static Enum[] e(Class cls) {
        Enum[] enumArr = (Enum[]) d(cls).getEnumConstants();
        if (enumArr != null) {
            return enumArr;
        }
        throw new IllegalArgumentException("No enum constants for class " + cls.getName());
    }

    public static Enum f(b bVar, Class cls) {
        if (bVar != null) {
            return bVar.j(d(cls));
        }
        return null;
    }

    public static k h(f fVar, Class cls) {
        return a(cls, fVar.g(), fVar.D(q.ACCEPT_CASE_INSENSITIVE_ENUMS));
    }

    public static k j(f fVar, Class cls, i iVar) {
        return b(cls, iVar, fVar.g(), fVar.D(q.ACCEPT_CASE_INSENSITIVE_ENUMS));
    }

    public static k k(f fVar, Class cls) {
        return c(cls, fVar.g(), fVar.D(q.ACCEPT_CASE_INSENSITIVE_ENUMS));
    }

    public Enum g(String str) {
        for (Map.Entry entry : this.f6278c.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                return (Enum) entry.getValue();
            }
        }
        return null;
    }

    public i i() {
        return i.b(this.f6278c);
    }

    public Enum l(String str) {
        Enum enumR = (Enum) this.f6278c.get(str);
        if (enumR != null || !this.f6280e) {
            return enumR;
        }
        return g(str);
    }

    public Enum m() {
        return this.f6279d;
    }

    public Class n() {
        return this.f6276a;
    }

    public Collection o() {
        return this.f6278c.keySet();
    }

    public Enum[] p() {
        return this.f6277b;
    }
}
