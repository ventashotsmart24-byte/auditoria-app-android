package com.fasterxml.jackson.databind.deser.std;

import c3.n;
import c4.f;
import c4.o;
import d4.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.d;
import k3.g;
import k3.h;
import k3.j;
import k3.k;
import n3.i;
import n3.r;
import w3.e;

public class m0 extends b0 implements r, i {
    protected static final Object[] NO_OBJECTS = new Object[0];
    private static final long serialVersionUID = 1;
    protected k _listDeserializer;
    protected j _listType;
    protected k _mapDeserializer;
    protected j _mapType;
    protected final boolean _nonMerging;
    protected k _numberDeserializer;
    protected k _stringDeserializer;

    public static class a extends b0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f5653b = new a();

        /* renamed from: a  reason: collision with root package name */
        public final boolean f5654a;

        public a() {
            this(false);
        }

        public static a c(boolean z10) {
            if (z10) {
                return new a(true);
            }
            return f5653b;
        }

        public Object _mapObjectWithDups(c3.k kVar, g gVar, Map map, String str, Object obj, Object obj2, String str2) {
            boolean m02 = gVar.m0(c3.r.DUPLICATE_PROPERTIES);
            if (m02) {
                a(map, str, obj, obj2);
            }
            while (str2 != null) {
                kVar.s0();
                Object deserialize = deserialize(kVar, gVar);
                Object put = map.put(str2, deserialize);
                if (put != null && m02) {
                    a(map, str2, put, deserialize);
                }
                str2 = kVar.q0();
            }
            return map;
        }

        public final void a(Map map, String str, Object obj, Object obj2) {
            if (obj instanceof List) {
                ((List) obj).add(obj2);
                map.put(str, obj);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(obj);
            arrayList.add(obj2);
            map.put(str, arrayList);
        }

        public final Object b(c3.k kVar, g gVar, int i10) {
            switch (kVar.q()) {
                case 1:
                    if (kVar.s0() == n.END_OBJECT) {
                        return new LinkedHashMap(2);
                    }
                    break;
                case 2:
                    return new LinkedHashMap(2);
                case 3:
                    if (kVar.s0() == n.END_ARRAY) {
                        if (gVar.n0(h.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                            return m0.NO_OBJECTS;
                        }
                        return new ArrayList(2);
                    } else if (i10 > 1000) {
                        throw new c3.j(kVar, "JSON is too deeply nested.");
                    } else if (gVar.n0(h.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                        return e(kVar, gVar, i10);
                    } else {
                        return d(kVar, gVar, i10);
                    }
                case 5:
                    break;
                case 6:
                    return kVar.Y();
                case 7:
                    if (gVar.k0(b0.F_MASK_INT_COERCIONS)) {
                        return _coerceIntegral(kVar, gVar);
                    }
                    return kVar.S();
                case 8:
                    if (gVar.n0(h.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return kVar.L();
                    }
                    return kVar.S();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return kVar.N();
                default:
                    return gVar.a0(Object.class, kVar);
            }
            if (i10 <= 1000) {
                return f(kVar, gVar, i10);
            }
            throw new c3.j(kVar, "JSON is too deeply nested.");
        }

        public Object d(c3.k kVar, g gVar, int i10) {
            int i11 = i10 + 1;
            Object b10 = b(kVar, gVar, i11);
            n s02 = kVar.s0();
            n nVar = n.END_ARRAY;
            int i12 = 2;
            if (s02 == nVar) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(b10);
                return arrayList;
            }
            Object b11 = b(kVar, gVar, i11);
            if (kVar.s0() == nVar) {
                ArrayList arrayList2 = new ArrayList(2);
                arrayList2.add(b10);
                arrayList2.add(b11);
                return arrayList2;
            }
            s q02 = gVar.q0();
            Object[] i13 = q02.i();
            i13[0] = b10;
            i13[1] = b11;
            int i14 = 2;
            while (true) {
                Object b12 = b(kVar, gVar, i11);
                i12++;
                if (i14 >= i13.length) {
                    i13 = q02.c(i13);
                    i14 = 0;
                }
                int i15 = i14 + 1;
                i13[i14] = b12;
                if (kVar.s0() == n.END_ARRAY) {
                    ArrayList arrayList3 = new ArrayList(i12);
                    q02.e(i13, i15, arrayList3);
                    return arrayList3;
                }
                i14 = i15;
            }
        }

        public Object deserialize(c3.k kVar, g gVar) {
            return b(kVar, gVar, 0);
        }

        public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
            int q10 = kVar.q();
            if (!(q10 == 1 || q10 == 3)) {
                switch (q10) {
                    case 5:
                        break;
                    case 6:
                        return kVar.Y();
                    case 7:
                        if (gVar.n0(h.USE_BIG_INTEGER_FOR_INTS)) {
                            return kVar.s();
                        }
                        return kVar.S();
                    case 8:
                        if (gVar.n0(h.USE_BIG_DECIMAL_FOR_FLOATS)) {
                            return kVar.L();
                        }
                        return kVar.S();
                    case 9:
                        return Boolean.TRUE;
                    case 10:
                        return Boolean.FALSE;
                    case 11:
                        return null;
                    case 12:
                        return kVar.N();
                    default:
                        return gVar.a0(Object.class, kVar);
                }
            }
            return eVar.c(kVar, gVar);
        }

        public Object[] e(c3.k kVar, g gVar, int i10) {
            int i11 = i10 + 1;
            s q02 = gVar.q0();
            Object[] i12 = q02.i();
            int i13 = 0;
            while (true) {
                Object b10 = b(kVar, gVar, i11);
                if (i13 >= i12.length) {
                    i12 = q02.c(i12);
                    i13 = 0;
                }
                int i14 = i13 + 1;
                i12[i13] = b10;
                if (kVar.s0() == n.END_ARRAY) {
                    return q02.f(i12, i14);
                }
                i13 = i14;
            }
        }

        public Object f(c3.k kVar, g gVar, int i10) {
            int i11 = i10 + 1;
            String Y = kVar.Y();
            kVar.s0();
            Object b10 = b(kVar, gVar, i11);
            String q02 = kVar.q0();
            if (q02 == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(2);
                linkedHashMap.put(Y, b10);
                return linkedHashMap;
            }
            kVar.s0();
            Object b11 = b(kVar, gVar, i11);
            String q03 = kVar.q0();
            if (q03 == null) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(4);
                linkedHashMap2.put(Y, b10);
                if (linkedHashMap2.put(q02, b11) != null) {
                    return _mapObjectWithDups(kVar, gVar, linkedHashMap2, Y, b10, b11, q03);
                }
                return linkedHashMap2;
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put(Y, b10);
            if (linkedHashMap3.put(q02, b11) != null) {
                return _mapObjectWithDups(kVar, gVar, linkedHashMap3, Y, b10, b11, q03);
            }
            String str = q03;
            do {
                kVar.s0();
                Object b12 = b(kVar, gVar, i11);
                Object put = linkedHashMap3.put(str, b12);
                if (put != null) {
                    return _mapObjectWithDups(kVar, gVar, linkedHashMap3, str, put, b12, kVar.q0());
                }
                str = kVar.q0();
            } while (str != null);
            return linkedHashMap3;
        }

        public f logicalType() {
            return f.Untyped;
        }

        public Boolean supportsUpdate(k3.f fVar) {
            if (this.f5654a) {
                return Boolean.FALSE;
            }
            return null;
        }

        public a(boolean z10) {
            super(Object.class);
            this.f5654a = z10;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
            if (r0 != 5) goto L_0x006f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object deserialize(c3.k r5, k3.g r6, java.lang.Object r7) {
            /*
                r4 = this;
                boolean r0 = r4.f5654a
                if (r0 == 0) goto L_0x0009
                java.lang.Object r5 = r4.deserialize(r5, r6)
                return r5
            L_0x0009:
                int r0 = r5.q()
                r1 = 1
                if (r0 == r1) goto L_0x003d
                r1 = 2
                if (r0 == r1) goto L_0x003c
                r1 = 3
                if (r0 == r1) goto L_0x001d
                r1 = 4
                if (r0 == r1) goto L_0x003c
                r1 = 5
                if (r0 == r1) goto L_0x0046
                goto L_0x006f
            L_0x001d:
                c3.n r0 = r5.s0()
                c3.n r1 = c3.n.END_ARRAY
                if (r0 != r1) goto L_0x0026
                return r7
            L_0x0026:
                boolean r0 = r7 instanceof java.util.Collection
                if (r0 == 0) goto L_0x006f
                r0 = r7
                java.util.Collection r0 = (java.util.Collection) r0
            L_0x002d:
                java.lang.Object r1 = r4.deserialize(r5, r6)
                r0.add(r1)
                c3.n r1 = r5.s0()
                c3.n r2 = c3.n.END_ARRAY
                if (r1 != r2) goto L_0x002d
            L_0x003c:
                return r7
            L_0x003d:
                c3.n r0 = r5.s0()
                c3.n r1 = c3.n.END_OBJECT
                if (r0 != r1) goto L_0x0046
                return r7
            L_0x0046:
                boolean r0 = r7 instanceof java.util.Map
                if (r0 == 0) goto L_0x006f
                r0 = r7
                java.util.Map r0 = (java.util.Map) r0
                java.lang.String r1 = r5.m()
            L_0x0051:
                r5.s0()
                java.lang.Object r2 = r0.get(r1)
                if (r2 == 0) goto L_0x005f
                java.lang.Object r3 = r4.deserialize(r5, r6, r2)
                goto L_0x0063
            L_0x005f:
                java.lang.Object r3 = r4.deserialize(r5, r6)
            L_0x0063:
                if (r3 == r2) goto L_0x0068
                r0.put(r1, r3)
            L_0x0068:
                java.lang.String r1 = r5.q0()
                if (r1 != 0) goto L_0x0051
                return r7
            L_0x006f:
                java.lang.Object r5 = r4.deserialize(r5, r6)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.m0.a.deserialize(c3.k, k3.g, java.lang.Object):java.lang.Object");
        }
    }

    public m0(j jVar, j jVar2) {
        super(Object.class);
        this._listType = jVar;
        this._mapType = jVar2;
        this._nonMerging = false;
    }

    public k _clearIfStdImpl(k kVar) {
        if (d4.h.O(kVar)) {
            return null;
        }
        return kVar;
    }

    public k _findCustomDeser(g gVar, j jVar) {
        return gVar.G(jVar);
    }

    public Object _mapObjectWithDups(c3.k kVar, g gVar, Map<String, Object> map, String str, Object obj, Object obj2, String str2) {
        boolean m02 = gVar.m0(c3.r.DUPLICATE_PROPERTIES);
        if (m02) {
            a(map, str, obj, obj2);
        }
        while (str2 != null) {
            kVar.s0();
            Object deserialize = deserialize(kVar, gVar);
            Object put = map.put(str2, deserialize);
            if (put != null && m02) {
                a(map, str, put, deserialize);
            }
            str2 = kVar.q0();
        }
        return map;
    }

    public final void a(Map map, String str, Object obj, Object obj2) {
        if (obj instanceof List) {
            ((List) obj).add(obj2);
            map.put(str, obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        arrayList.add(obj2);
        map.put(str, arrayList);
    }

    public k createContextual(g gVar, d dVar) {
        boolean z10;
        if (dVar != null || !Boolean.FALSE.equals(gVar.k().M(Object.class))) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this._stringDeserializer == null && this._numberDeserializer == null && this._mapDeserializer == null && this._listDeserializer == null && getClass() == m0.class) {
            return a.c(z10);
        }
        if (z10 != this._nonMerging) {
            return new m0(this, z10);
        }
        return this;
    }

    public Object deserialize(c3.k kVar, g gVar) {
        switch (kVar.q()) {
            case 1:
            case 2:
            case 5:
                k kVar2 = this._mapDeserializer;
                if (kVar2 != null) {
                    return kVar2.deserialize(kVar, gVar);
                }
                return mapObject(kVar, gVar);
            case 3:
                if (gVar.n0(h.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(kVar, gVar);
                }
                k kVar3 = this._listDeserializer;
                if (kVar3 != null) {
                    return kVar3.deserialize(kVar, gVar);
                }
                return mapArray(kVar, gVar);
            case 6:
                k kVar4 = this._stringDeserializer;
                if (kVar4 != null) {
                    return kVar4.deserialize(kVar, gVar);
                }
                return kVar.Y();
            case 7:
                k kVar5 = this._numberDeserializer;
                if (kVar5 != null) {
                    return kVar5.deserialize(kVar, gVar);
                }
                if (gVar.k0(b0.F_MASK_INT_COERCIONS)) {
                    return _coerceIntegral(kVar, gVar);
                }
                return kVar.S();
            case 8:
                k kVar6 = this._numberDeserializer;
                if (kVar6 != null) {
                    return kVar6.deserialize(kVar, gVar);
                }
                if (gVar.n0(h.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return kVar.L();
                }
                return kVar.S();
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return kVar.N();
            default:
                return gVar.a0(Object.class, kVar);
        }
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        int q10 = kVar.q();
        if (!(q10 == 1 || q10 == 3)) {
            switch (q10) {
                case 5:
                    break;
                case 6:
                    k kVar2 = this._stringDeserializer;
                    if (kVar2 != null) {
                        return kVar2.deserialize(kVar, gVar);
                    }
                    return kVar.Y();
                case 7:
                    k kVar3 = this._numberDeserializer;
                    if (kVar3 != null) {
                        return kVar3.deserialize(kVar, gVar);
                    }
                    if (gVar.k0(b0.F_MASK_INT_COERCIONS)) {
                        return _coerceIntegral(kVar, gVar);
                    }
                    return kVar.S();
                case 8:
                    k kVar4 = this._numberDeserializer;
                    if (kVar4 != null) {
                        return kVar4.deserialize(kVar, gVar);
                    }
                    if (gVar.n0(h.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return kVar.L();
                    }
                    return kVar.S();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return kVar.N();
                default:
                    return gVar.a0(Object.class, kVar);
            }
        }
        return eVar.c(kVar, gVar);
    }

    public boolean isCachable() {
        return true;
    }

    public f logicalType() {
        return f.Untyped;
    }

    public Object mapArray(c3.k kVar, g gVar) {
        n s02 = kVar.s0();
        n nVar = n.END_ARRAY;
        int i10 = 2;
        if (s02 == nVar) {
            return new ArrayList(2);
        }
        Object deserialize = deserialize(kVar, gVar);
        if (kVar.s0() == nVar) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(deserialize);
            return arrayList;
        }
        Object deserialize2 = deserialize(kVar, gVar);
        if (kVar.s0() == nVar) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(deserialize);
            arrayList2.add(deserialize2);
            return arrayList2;
        }
        s q02 = gVar.q0();
        Object[] i11 = q02.i();
        i11[0] = deserialize;
        i11[1] = deserialize2;
        int i12 = 2;
        while (true) {
            Object deserialize3 = deserialize(kVar, gVar);
            i10++;
            if (i12 >= i11.length) {
                i11 = q02.c(i11);
                i12 = 0;
            }
            int i13 = i12 + 1;
            i11[i12] = deserialize3;
            if (kVar.s0() == n.END_ARRAY) {
                ArrayList arrayList3 = new ArrayList(i10);
                q02.e(i11, i13, arrayList3);
                return arrayList3;
            }
            i12 = i13;
        }
    }

    public Object[] mapArrayToArray(c3.k kVar, g gVar) {
        if (kVar.s0() == n.END_ARRAY) {
            return NO_OBJECTS;
        }
        s q02 = gVar.q0();
        Object[] i10 = q02.i();
        int i11 = 0;
        while (true) {
            Object deserialize = deserialize(kVar, gVar);
            if (i11 >= i10.length) {
                i10 = q02.c(i10);
                i11 = 0;
            }
            int i12 = i11 + 1;
            i10[i11] = deserialize;
            if (kVar.s0() == n.END_ARRAY) {
                return q02.f(i10, i12);
            }
            i11 = i12;
        }
    }

    public Object mapObject(c3.k kVar, g gVar) {
        String str;
        n n10 = kVar.n();
        if (n10 == n.START_OBJECT) {
            str = kVar.q0();
        } else if (n10 == n.FIELD_NAME) {
            str = kVar.m();
        } else if (n10 != n.END_OBJECT) {
            return gVar.a0(handledType(), kVar);
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 == null) {
            return new LinkedHashMap(2);
        }
        kVar.s0();
        Object deserialize = deserialize(kVar, gVar);
        String q02 = kVar.q0();
        if (q02 == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put(str2, deserialize);
            return linkedHashMap;
        }
        kVar.s0();
        Object deserialize2 = deserialize(kVar, gVar);
        String q03 = kVar.q0();
        if (q03 == null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(4);
            linkedHashMap2.put(str2, deserialize);
            return linkedHashMap2.put(q02, deserialize2) != null ? _mapObjectWithDups(kVar, gVar, linkedHashMap2, str2, deserialize, deserialize2, q03) : linkedHashMap2;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put(str2, deserialize);
        if (linkedHashMap3.put(q02, deserialize2) != null) {
            return _mapObjectWithDups(kVar, gVar, linkedHashMap3, str2, deserialize, deserialize2, q03);
        }
        do {
            kVar.s0();
            Object deserialize3 = deserialize(kVar, gVar);
            Object put = linkedHashMap3.put(q03, deserialize3);
            if (put != null) {
                return _mapObjectWithDups(kVar, gVar, linkedHashMap3, q03, put, deserialize3, kVar.q0());
            }
            q03 = kVar.q0();
        } while (q03 != null);
        return linkedHashMap3;
    }

    public void resolve(g gVar) {
        j x10 = gVar.x(Object.class);
        j x11 = gVar.x(String.class);
        o l10 = gVar.l();
        j jVar = this._listType;
        if (jVar == null) {
            this._listDeserializer = _clearIfStdImpl(_findCustomDeser(gVar, l10.z(List.class, x10)));
        } else {
            this._listDeserializer = _findCustomDeser(gVar, jVar);
        }
        j jVar2 = this._mapType;
        if (jVar2 == null) {
            this._mapDeserializer = _clearIfStdImpl(_findCustomDeser(gVar, l10.D(Map.class, x11, x10)));
        } else {
            this._mapDeserializer = _findCustomDeser(gVar, jVar2);
        }
        this._stringDeserializer = _clearIfStdImpl(_findCustomDeser(gVar, x11));
        this._numberDeserializer = _clearIfStdImpl(_findCustomDeser(gVar, l10.H(Number.class)));
        j O = o.O();
        this._mapDeserializer = gVar.Z(this._mapDeserializer, (d) null, O);
        this._listDeserializer = gVar.Z(this._listDeserializer, (d) null, O);
        this._stringDeserializer = gVar.Z(this._stringDeserializer, (d) null, O);
        this._numberDeserializer = gVar.Z(this._numberDeserializer, (d) null, O);
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return null;
    }

    public m0(m0 m0Var, boolean z10) {
        super(Object.class);
        this._mapDeserializer = m0Var._mapDeserializer;
        this._listDeserializer = m0Var._listDeserializer;
        this._stringDeserializer = m0Var._stringDeserializer;
        this._numberDeserializer = m0Var._numberDeserializer;
        this._listType = m0Var._listType;
        this._mapType = m0Var._mapType;
        this._nonMerging = z10;
    }

    public Object mapArray(c3.k kVar, g gVar, Collection<Object> collection) {
        while (kVar.s0() != n.END_ARRAY) {
            collection.add(deserialize(kVar, gVar));
        }
        return collection;
    }

    public Object deserialize(c3.k kVar, g gVar, Object obj) {
        if (this._nonMerging) {
            return deserialize(kVar, gVar);
        }
        switch (kVar.q()) {
            case 1:
            case 2:
            case 5:
                k kVar2 = this._mapDeserializer;
                if (kVar2 != null) {
                    return kVar2.deserialize(kVar, gVar, obj);
                }
                if (obj instanceof Map) {
                    return mapObject(kVar, gVar, (Map) obj);
                }
                return mapObject(kVar, gVar);
            case 3:
                k kVar3 = this._listDeserializer;
                if (kVar3 != null) {
                    return kVar3.deserialize(kVar, gVar, obj);
                }
                if (obj instanceof Collection) {
                    return mapArray(kVar, gVar, (Collection) obj);
                }
                if (gVar.n0(h.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(kVar, gVar);
                }
                return mapArray(kVar, gVar);
            case 6:
                k kVar4 = this._stringDeserializer;
                if (kVar4 != null) {
                    return kVar4.deserialize(kVar, gVar, obj);
                }
                return kVar.Y();
            case 7:
                k kVar5 = this._numberDeserializer;
                if (kVar5 != null) {
                    return kVar5.deserialize(kVar, gVar, obj);
                }
                if (gVar.k0(b0.F_MASK_INT_COERCIONS)) {
                    return _coerceIntegral(kVar, gVar);
                }
                return kVar.S();
            case 8:
                k kVar6 = this._numberDeserializer;
                if (kVar6 != null) {
                    return kVar6.deserialize(kVar, gVar, obj);
                }
                if (gVar.n0(h.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return kVar.L();
                }
                return kVar.S();
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return kVar.N();
            default:
                return deserialize(kVar, gVar);
        }
    }

    public Object mapObject(c3.k kVar, g gVar, Map<Object, Object> map) {
        Object obj;
        n n10 = kVar.n();
        if (n10 == n.START_OBJECT) {
            n10 = kVar.s0();
        }
        if (n10 == n.END_OBJECT) {
            return map;
        }
        String m10 = kVar.m();
        do {
            kVar.s0();
            Object obj2 = map.get(m10);
            if (obj2 != null) {
                obj = deserialize(kVar, gVar, obj2);
            } else {
                obj = deserialize(kVar, gVar);
            }
            if (obj != obj2) {
                map.put(m10, obj);
            }
            m10 = kVar.q0();
        } while (m10 != null);
        return map;
    }
}
