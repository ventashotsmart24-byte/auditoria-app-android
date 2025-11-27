package m3;

import c4.f;
import java.io.Serializable;
import java.util.Map;
import k3.h;
import k3.q;

public class d implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final int f7827e = f.values().length;

    /* renamed from: a  reason: collision with root package name */
    public b f7828a;

    /* renamed from: b  reason: collision with root package name */
    public final o f7829b;

    /* renamed from: c  reason: collision with root package name */
    public o[] f7830c;

    /* renamed from: d  reason: collision with root package name */
    public Map f7831d;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7832a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                m3.e[] r0 = m3.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7832a = r0
                m3.e r1 = m3.e.EmptyArray     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7832a     // Catch:{ NoSuchFieldError -> 0x001d }
                m3.e r1 = m3.e.Float     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7832a     // Catch:{ NoSuchFieldError -> 0x0028 }
                m3.e r1 = m3.e.Integer     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m3.d.a.<clinit>():void");
        }
    }

    public d() {
        this(b.TryConvert, new o(), (o[]) null, (Map) null);
    }

    public b a(k3.f fVar, f fVar2, Class cls, e eVar) {
        o oVar;
        b a10;
        o oVar2;
        b a11;
        Map map = this.f7831d;
        if (map != null && cls != null && (oVar2 = (o) map.get(cls)) != null && (a11 = oVar2.a(eVar)) != null) {
            return a11;
        }
        o[] oVarArr = this.f7830c;
        if (oVarArr != null && fVar2 != null && (oVar = oVarArr[fVar2.ordinal()]) != null && (a10 = oVar.a(eVar)) != null) {
            return a10;
        }
        b a12 = this.f7829b.a(eVar);
        if (a12 != null) {
            return a12;
        }
        int i10 = a.f7832a[eVar.ordinal()];
        boolean z10 = true;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3 && fVar2 == f.Enum && fVar.j0(h.FAIL_ON_NUMBERS_FOR_ENUMS)) {
                    return b.Fail;
                }
            } else if (fVar2 == f.Integer) {
                if (fVar.j0(h.ACCEPT_FLOAT_AS_INT)) {
                    return b.TryConvert;
                }
                return b.Fail;
            }
            if (!(fVar2 == f.Float || fVar2 == f.Integer || fVar2 == f.Boolean || fVar2 == f.DateTime)) {
                z10 = false;
            }
            if (z10 && !fVar.D(q.ALLOW_COERCION_OF_SCALARS)) {
                return b.Fail;
            }
            if (eVar != e.EmptyString) {
                return this.f7828a;
            }
            if (z10 || fVar.j0(h.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) {
                return b.AsNull;
            }
            if (fVar2 == f.OtherScalar) {
                return b.TryConvert;
            }
            return b.Fail;
        } else if (fVar.j0(h.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
            return b.AsNull;
        } else {
            return b.Fail;
        }
    }

    public b b(k3.f fVar, f fVar2, Class cls, b bVar) {
        b bVar2;
        Boolean bool;
        o oVar;
        o oVar2;
        Map map = this.f7831d;
        if (map == null || cls == null || (oVar2 = (o) map.get(cls)) == null) {
            bool = null;
            bVar2 = null;
        } else {
            bool = oVar2.b();
            bVar2 = oVar2.a(e.EmptyString);
        }
        o[] oVarArr = this.f7830c;
        if (!(oVarArr == null || fVar2 == null || (oVar = oVarArr[fVar2.ordinal()]) == null)) {
            if (bool == null) {
                bool = oVar.b();
            }
            if (bVar2 == null) {
                bVar2 = oVar.a(e.EmptyString);
            }
        }
        if (bool == null) {
            bool = this.f7829b.b();
        }
        if (bVar2 == null) {
            bVar2 = this.f7829b.a(e.EmptyString);
        }
        if (!Boolean.TRUE.equals(bool)) {
            return bVar;
        }
        if (bVar2 != null) {
            return bVar2;
        }
        if (fVar.j0(h.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) {
            return b.AsNull;
        }
        return b.Fail;
    }

    public d(b bVar, o oVar, o[] oVarArr, Map map) {
        this.f7829b = oVar;
        this.f7828a = bVar;
        this.f7830c = oVarArr;
        this.f7831d = map;
    }
}
