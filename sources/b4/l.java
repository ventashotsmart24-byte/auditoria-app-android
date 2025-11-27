package b4;

import d4.a0;
import java.util.HashMap;
import java.util.Map;
import k3.j;
import k3.o;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final a[] f4362a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4363b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4364c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final o f4365a;

        /* renamed from: b  reason: collision with root package name */
        public final a f4366b;

        /* renamed from: c  reason: collision with root package name */
        public final Class f4367c;

        /* renamed from: d  reason: collision with root package name */
        public final j f4368d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4369e;

        public a(a aVar, a0 a0Var, o oVar) {
            this.f4366b = aVar;
            this.f4365a = oVar;
            this.f4369e = a0Var.c();
            this.f4367c = a0Var.a();
            this.f4368d = a0Var.b();
        }

        public boolean a(Class cls) {
            if (this.f4367c != cls || !this.f4369e) {
                return false;
            }
            return true;
        }

        public boolean b(j jVar) {
            if (!this.f4369e || !jVar.equals(this.f4368d)) {
                return false;
            }
            return true;
        }

        public boolean c(Class cls) {
            if (this.f4367c != cls || this.f4369e) {
                return false;
            }
            return true;
        }

        public boolean d(j jVar) {
            if (this.f4369e || !jVar.equals(this.f4368d)) {
                return false;
            }
            return true;
        }
    }

    public l(Map map) {
        int a10 = a(map.size());
        this.f4363b = a10;
        this.f4364c = a10 - 1;
        a[] aVarArr = new a[a10];
        for (Map.Entry entry : map.entrySet()) {
            a0 a0Var = (a0) entry.getKey();
            int hashCode = a0Var.hashCode() & this.f4364c;
            aVarArr[hashCode] = new a(aVarArr[hashCode], a0Var, (o) entry.getValue());
        }
        this.f4362a = aVarArr;
    }

    public static final int a(int i10) {
        int i11 = 8;
        while (i11 < (i10 <= 64 ? i10 + i10 : i10 + (i10 >> 2))) {
            i11 += i11;
        }
        return i11;
    }

    public static l b(HashMap hashMap) {
        return new l(hashMap);
    }

    public o c(Class cls) {
        a aVar = this.f4362a[a0.d(cls) & this.f4364c];
        if (aVar == null) {
            return null;
        }
        if (aVar.a(cls)) {
            return aVar.f4365a;
        }
        do {
            aVar = aVar.f4366b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.a(cls));
        return aVar.f4365a;
    }

    public o d(j jVar) {
        a aVar = this.f4362a[a0.e(jVar) & this.f4364c];
        if (aVar == null) {
            return null;
        }
        if (aVar.b(jVar)) {
            return aVar.f4365a;
        }
        do {
            aVar = aVar.f4366b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.b(jVar));
        return aVar.f4365a;
    }

    public o e(Class cls) {
        a aVar = this.f4362a[a0.f(cls) & this.f4364c];
        if (aVar == null) {
            return null;
        }
        if (aVar.c(cls)) {
            return aVar.f4365a;
        }
        do {
            aVar = aVar.f4366b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.c(cls));
        return aVar.f4365a;
    }

    public o f(j jVar) {
        a aVar = this.f4362a[a0.g(jVar) & this.f4364c];
        if (aVar == null) {
            return null;
        }
        if (aVar.d(jVar)) {
            return aVar.f4365a;
        }
        do {
            aVar = aVar.f4366b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.d(jVar));
        return aVar.f4365a;
    }
}
