package d4;

import c3.i;
import c3.m;

public class z extends m {

    /* renamed from: c  reason: collision with root package name */
    public final m f6362c;

    /* renamed from: d  reason: collision with root package name */
    public final i f6363d;

    /* renamed from: e  reason: collision with root package name */
    public String f6364e;

    /* renamed from: f  reason: collision with root package name */
    public Object f6365f;

    public z(m mVar, i iVar) {
        super(mVar);
        this.f6362c = mVar.e();
        this.f6364e = mVar.b();
        this.f6365f = mVar.c();
        this.f6363d = iVar;
    }

    public static z m(m mVar) {
        if (mVar == null) {
            return new z();
        }
        return new z(mVar, (i) null);
    }

    public String b() {
        return this.f6364e;
    }

    public Object c() {
        return this.f6365f;
    }

    public m e() {
        return this.f6362c;
    }

    public void i(Object obj) {
        this.f6365f = obj;
    }

    public z k() {
        this.f4767b++;
        return new z(this, 1, -1);
    }

    public z l() {
        this.f4767b++;
        return new z(this, 2, -1);
    }

    public z n() {
        m mVar = this.f6362c;
        if (mVar instanceof z) {
            return (z) mVar;
        }
        if (mVar == null) {
            return new z();
        }
        return new z(mVar, this.f6363d);
    }

    public void o(String str) {
        this.f6364e = str;
    }

    public void p() {
        this.f4767b++;
    }

    public z() {
        super(0, -1);
        this.f6362c = null;
        this.f6363d = i.f4732f;
    }

    public z(z zVar, int i10, int i11) {
        super(i10, i11);
        this.f6362c = zVar;
        this.f6363d = zVar.f6363d;
    }
}
