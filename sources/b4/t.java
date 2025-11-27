package b4;

import b3.k0;
import c3.h;
import c3.q;
import k3.c0;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final k0 f4380a;

    /* renamed from: b  reason: collision with root package name */
    public Object f4381b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4382c = false;

    public t(k0 k0Var) {
        this.f4380a = k0Var;
    }

    public Object a(Object obj) {
        if (this.f4381b == null) {
            this.f4381b = this.f4380a.c(obj);
        }
        return this.f4381b;
    }

    public void b(h hVar, c0 c0Var, i iVar) {
        String str;
        this.f4382c = true;
        if (hVar.m()) {
            Object obj = this.f4381b;
            if (obj == null) {
                str = null;
            } else {
                str = String.valueOf(obj);
            }
            hVar.j0(str);
            return;
        }
        q qVar = iVar.f4343b;
        if (qVar != null) {
            hVar.Y(qVar);
            iVar.f4345d.serialize(this.f4381b, hVar, c0Var);
        }
    }

    public boolean c(h hVar, c0 c0Var, i iVar) {
        if (this.f4381b == null) {
            return false;
        }
        if (!this.f4382c && !iVar.f4346e) {
            return false;
        }
        if (hVar.m()) {
            hVar.k0(String.valueOf(this.f4381b));
            return true;
        }
        iVar.f4345d.serialize(this.f4381b, hVar, c0Var);
        return true;
    }
}
