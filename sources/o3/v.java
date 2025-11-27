package o3;

import c3.k;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import k3.f;
import k3.g;
import k3.x;
import n3.t;
import n3.w;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final int f8543a;

    /* renamed from: b  reason: collision with root package name */
    public final w f8544b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f8545c;

    /* renamed from: d  reason: collision with root package name */
    public final t[] f8546d;

    public static class a extends HashMap {

        /* renamed from: a  reason: collision with root package name */
        public final Locale f8547a;

        public a(Locale locale) {
            this.f8547a = locale;
        }

        public static a a(Locale locale) {
            return new a(locale);
        }

        /* renamed from: b */
        public t get(Object obj) {
            return (t) super.get(((String) obj).toLowerCase(this.f8547a));
        }

        /* renamed from: c */
        public t put(String str, t tVar) {
            return (t) super.put(str.toLowerCase(this.f8547a), tVar);
        }
    }

    public v(g gVar, w wVar, t[] tVarArr, boolean z10, boolean z11) {
        this.f8544b = wVar;
        if (z10) {
            this.f8545c = a.a(gVar.k().v());
        } else {
            this.f8545c = new HashMap();
        }
        int length = tVarArr.length;
        this.f8543a = length;
        this.f8546d = new t[length];
        if (z11) {
            f N = gVar.k();
            for (t tVar : tVarArr) {
                if (!tVar.z()) {
                    List<x> e10 = tVar.e(N);
                    if (!e10.isEmpty()) {
                        for (x c10 : e10) {
                            this.f8545c.put(c10.c(), tVar);
                        }
                    }
                }
            }
        }
        for (int i10 = 0; i10 < length; i10++) {
            t tVar2 = tVarArr[i10];
            this.f8546d[i10] = tVar2;
            if (!tVar2.z()) {
                this.f8545c.put(tVar2.getName(), tVar2);
            }
        }
    }

    public static v b(g gVar, w wVar, t[] tVarArr, c cVar) {
        int length = tVarArr.length;
        t[] tVarArr2 = new t[length];
        for (int i10 = 0; i10 < length; i10++) {
            t tVar = tVarArr[i10];
            if (!tVar.w() && !tVar.A()) {
                tVar = tVar.L(gVar.D(tVar.getType(), tVar));
            }
            tVarArr2[i10] = tVar;
        }
        return new v(gVar, wVar, tVarArr2, cVar.p(), true);
    }

    public static v c(g gVar, w wVar, t[] tVarArr, boolean z10) {
        int length = tVarArr.length;
        t[] tVarArr2 = new t[length];
        for (int i10 = 0; i10 < length; i10++) {
            t tVar = tVarArr[i10];
            if (!tVar.w()) {
                tVar = tVar.L(gVar.D(tVar.getType(), tVar));
            }
            tVarArr2[i10] = tVar;
        }
        return new v(gVar, wVar, tVarArr2, z10, false);
    }

    public Object a(g gVar, y yVar) {
        Object u10 = this.f8544b.u(gVar, this.f8546d, yVar);
        if (u10 != null) {
            u10 = yVar.h(gVar, u10);
            for (x f10 = yVar.f(); f10 != null; f10 = f10.f8548a) {
                f10.a(u10);
            }
        }
        return u10;
    }

    public t d(String str) {
        return (t) this.f8545c.get(str);
    }

    public y e(k kVar, g gVar, s sVar) {
        return new y(kVar, gVar, this.f8543a, sVar);
    }
}
