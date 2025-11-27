package m;

import java.util.ArrayList;
import m.f;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public f f7654a;

    /* renamed from: b  reason: collision with root package name */
    public f f7655b;

    /* renamed from: c  reason: collision with root package name */
    public f f7656c;

    /* renamed from: d  reason: collision with root package name */
    public f f7657d;

    /* renamed from: e  reason: collision with root package name */
    public f f7658e;

    /* renamed from: f  reason: collision with root package name */
    public f f7659f;

    /* renamed from: g  reason: collision with root package name */
    public f f7660g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f7661h;

    /* renamed from: i  reason: collision with root package name */
    public int f7662i;

    /* renamed from: j  reason: collision with root package name */
    public int f7663j;

    /* renamed from: k  reason: collision with root package name */
    public float f7664k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public int f7665l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f7666m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f7667n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f7668o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f7669p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f7670q;

    public d(f fVar, int i10, boolean z10) {
        this.f7654a = fVar;
        this.f7665l = i10;
        this.f7666m = z10;
    }

    public static boolean c(f fVar, int i10) {
        int i11;
        if (fVar.C() != 8 && fVar.E[i10] == f.b.MATCH_CONSTRAINT && ((i11 = fVar.f7712g[i10]) == 0 || i11 == 3)) {
            return true;
        }
        return false;
    }

    public void a() {
        if (!this.f7670q) {
            b();
        }
        this.f7670q = true;
    }

    public final void b() {
        int i10;
        int i11 = this.f7665l * 2;
        f fVar = this.f7654a;
        boolean z10 = false;
        f fVar2 = fVar;
        boolean z11 = false;
        while (!z11) {
            this.f7662i++;
            f[] fVarArr = fVar.f7735r0;
            int i12 = this.f7665l;
            f fVar3 = null;
            fVarArr[i12] = null;
            fVar.f7733q0[i12] = null;
            if (fVar.C() != 8) {
                if (this.f7655b == null) {
                    this.f7655b = fVar;
                }
                this.f7657d = fVar;
                f.b[] bVarArr = fVar.E;
                int i13 = this.f7665l;
                if (bVarArr[i13] == f.b.MATCH_CONSTRAINT && ((i10 = fVar.f7712g[i13]) == 0 || i10 == 3 || i10 == 2)) {
                    this.f7663j++;
                    float f10 = fVar.f7731p0[i13];
                    if (f10 > 0.0f) {
                        this.f7664k += f10;
                    }
                    if (c(fVar, i13)) {
                        if (f10 < 0.0f) {
                            this.f7667n = true;
                        } else {
                            this.f7668o = true;
                        }
                        if (this.f7661h == null) {
                            this.f7661h = new ArrayList();
                        }
                        this.f7661h.add(fVar);
                    }
                    if (this.f7659f == null) {
                        this.f7659f = fVar;
                    }
                    f fVar4 = this.f7660g;
                    if (fVar4 != null) {
                        fVar4.f7733q0[this.f7665l] = fVar;
                    }
                    this.f7660g = fVar;
                }
            }
            if (fVar2 != fVar) {
                fVar2.f7735r0[this.f7665l] = fVar;
            }
            e eVar = fVar.C[i11 + 1].f7674d;
            if (eVar != null) {
                f fVar5 = eVar.f7672b;
                e eVar2 = fVar5.C[i11].f7674d;
                if (eVar2 != null && eVar2.f7672b == fVar) {
                    fVar3 = fVar5;
                }
            }
            if (fVar3 == null) {
                fVar3 = fVar;
                z11 = true;
            }
            fVar2 = fVar;
            fVar = fVar3;
        }
        this.f7656c = fVar;
        if (this.f7665l != 0 || !this.f7666m) {
            this.f7658e = this.f7654a;
        } else {
            this.f7658e = fVar;
        }
        if (this.f7668o && this.f7667n) {
            z10 = true;
        }
        this.f7669p = z10;
    }
}
