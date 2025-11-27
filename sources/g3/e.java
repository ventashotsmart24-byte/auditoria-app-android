package g3;

import c3.g;
import c3.h;
import c3.m;

public class e extends m {

    /* renamed from: c  reason: collision with root package name */
    public final e f6797c;

    /* renamed from: d  reason: collision with root package name */
    public a f6798d;

    /* renamed from: e  reason: collision with root package name */
    public e f6799e;

    /* renamed from: f  reason: collision with root package name */
    public String f6800f;

    /* renamed from: g  reason: collision with root package name */
    public Object f6801g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6802h;

    public e(int i10, e eVar, a aVar) {
        this.f4766a = i10;
        this.f6797c = eVar;
        this.f6798d = aVar;
        this.f4767b = -1;
    }

    public static e q(a aVar) {
        return new e(0, (e) null, aVar);
    }

    public final String b() {
        return this.f6800f;
    }

    public Object c() {
        return this.f6801g;
    }

    public void i(Object obj) {
        this.f6801g = obj;
    }

    public final void k(a aVar, String str) {
        h hVar;
        if (aVar.c(str)) {
            Object b10 = aVar.b();
            String str2 = "Duplicate field '" + str + "'";
            if (b10 instanceof h) {
                hVar = (h) b10;
            } else {
                hVar = null;
            }
            throw new g(str2, hVar);
        }
    }

    public e l() {
        this.f6801g = null;
        return this.f6797c;
    }

    public e m() {
        a aVar;
        e eVar = this.f6799e;
        if (eVar != null) {
            return eVar.t(1);
        }
        a aVar2 = this.f6798d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a();
        }
        e eVar2 = new e(1, this, aVar);
        this.f6799e = eVar2;
        return eVar2;
    }

    public e n(Object obj) {
        a aVar;
        e eVar = this.f6799e;
        if (eVar != null) {
            return eVar.u(1, obj);
        }
        a aVar2 = this.f6798d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a();
        }
        e eVar2 = new e(1, this, aVar, obj);
        this.f6799e = eVar2;
        return eVar2;
    }

    public e o() {
        a aVar;
        e eVar = this.f6799e;
        if (eVar != null) {
            return eVar.t(2);
        }
        a aVar2 = this.f6798d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a();
        }
        e eVar2 = new e(2, this, aVar);
        this.f6799e = eVar2;
        return eVar2;
    }

    public e p(Object obj) {
        a aVar;
        e eVar = this.f6799e;
        if (eVar != null) {
            return eVar.u(2, obj);
        }
        a aVar2 = this.f6798d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a();
        }
        e eVar2 = new e(2, this, aVar, obj);
        this.f6799e = eVar2;
        return eVar2;
    }

    public a r() {
        return this.f6798d;
    }

    /* renamed from: s */
    public final e e() {
        return this.f6797c;
    }

    public e t(int i10) {
        this.f4766a = i10;
        this.f4767b = -1;
        this.f6800f = null;
        this.f6802h = false;
        this.f6801g = null;
        a aVar = this.f6798d;
        if (aVar != null) {
            aVar.d();
        }
        return this;
    }

    public e u(int i10, Object obj) {
        this.f4766a = i10;
        this.f4767b = -1;
        this.f6800f = null;
        this.f6802h = false;
        this.f6801g = obj;
        a aVar = this.f6798d;
        if (aVar != null) {
            aVar.d();
        }
        return this;
    }

    public e v(a aVar) {
        this.f6798d = aVar;
        return this;
    }

    public int w(String str) {
        if (this.f4766a != 2 || this.f6802h) {
            return 4;
        }
        this.f6802h = true;
        this.f6800f = str;
        a aVar = this.f6798d;
        if (aVar != null) {
            k(aVar, str);
        }
        if (this.f4767b < 0) {
            return 0;
        }
        return 1;
    }

    public int x() {
        int i10 = this.f4766a;
        if (i10 == 2) {
            if (!this.f6802h) {
                return 5;
            }
            this.f6802h = false;
            this.f4767b++;
            return 2;
        } else if (i10 == 1) {
            int i11 = this.f4767b;
            this.f4767b = i11 + 1;
            if (i11 < 0) {
                return 0;
            }
            return 1;
        } else {
            int i12 = this.f4767b + 1;
            this.f4767b = i12;
            if (i12 == 0) {
                return 0;
            }
            return 3;
        }
    }

    public e(int i10, e eVar, a aVar, Object obj) {
        this.f4766a = i10;
        this.f6797c = eVar;
        this.f6798d = aVar;
        this.f4767b = -1;
        this.f6801g = obj;
    }
}
