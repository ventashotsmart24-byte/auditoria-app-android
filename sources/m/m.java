package m;

import com.hpplay.cybergarage.soap.SOAP;
import l.e;
import l.i;
import m.e;

public class m extends o {

    /* renamed from: c  reason: collision with root package name */
    public e f7777c;

    /* renamed from: d  reason: collision with root package name */
    public float f7778d;

    /* renamed from: e  reason: collision with root package name */
    public m f7779e;

    /* renamed from: f  reason: collision with root package name */
    public float f7780f;

    /* renamed from: g  reason: collision with root package name */
    public m f7781g;

    /* renamed from: h  reason: collision with root package name */
    public float f7782h;

    /* renamed from: i  reason: collision with root package name */
    public int f7783i = 0;

    /* renamed from: j  reason: collision with root package name */
    public m f7784j;

    /* renamed from: k  reason: collision with root package name */
    public float f7785k;

    /* renamed from: l  reason: collision with root package name */
    public n f7786l = null;

    /* renamed from: m  reason: collision with root package name */
    public int f7787m = 1;

    /* renamed from: n  reason: collision with root package name */
    public n f7788n = null;

    /* renamed from: o  reason: collision with root package name */
    public int f7789o = 1;

    public m(e eVar) {
        this.f7777c = eVar;
    }

    public void e() {
        super.e();
        this.f7779e = null;
        this.f7780f = 0.0f;
        this.f7786l = null;
        this.f7787m = 1;
        this.f7788n = null;
        this.f7789o = 1;
        this.f7781g = null;
        this.f7782h = 0.0f;
        this.f7778d = 0.0f;
        this.f7784j = null;
        this.f7785k = 0.0f;
        this.f7783i = 0;
    }

    public void f() {
        int i10;
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        float f10;
        float f11;
        float f12;
        m mVar7;
        boolean z10 = true;
        if (this.f7792b != 1 && (i10 = this.f7783i) != 4) {
            n nVar = this.f7786l;
            if (nVar != null) {
                if (nVar.f7792b == 1) {
                    this.f7780f = ((float) this.f7787m) * nVar.f7790c;
                } else {
                    return;
                }
            }
            n nVar2 = this.f7788n;
            if (nVar2 != null) {
                if (nVar2.f7792b == 1) {
                    this.f7785k = ((float) this.f7789o) * nVar2.f7790c;
                } else {
                    return;
                }
            }
            if (i10 == 1 && ((mVar7 = this.f7779e) == null || mVar7.f7792b == 1)) {
                if (mVar7 == null) {
                    this.f7781g = this;
                    this.f7782h = this.f7780f;
                } else {
                    this.f7781g = mVar7.f7781g;
                    this.f7782h = mVar7.f7782h + this.f7780f;
                }
                b();
            } else if (i10 == 2 && (mVar4 = this.f7779e) != null && mVar4.f7792b == 1 && (mVar5 = this.f7784j) != null && (mVar6 = mVar5.f7779e) != null && mVar6.f7792b == 1) {
                e.x();
                m mVar8 = this.f7779e;
                this.f7781g = mVar8.f7781g;
                m mVar9 = this.f7784j;
                m mVar10 = mVar9.f7779e;
                mVar9.f7781g = mVar10.f7781g;
                e eVar = this.f7777c;
                e.d dVar = eVar.f7673c;
                e.d dVar2 = e.d.RIGHT;
                int i11 = 0;
                if (!(dVar == dVar2 || dVar == e.d.BOTTOM)) {
                    z10 = false;
                }
                if (z10) {
                    f10 = mVar8.f7782h - mVar10.f7782h;
                } else {
                    f10 = mVar10.f7782h - mVar8.f7782h;
                }
                if (dVar == e.d.LEFT || dVar == dVar2) {
                    f12 = f10 - ((float) eVar.f7672b.D());
                    f11 = this.f7777c.f7672b.Z;
                } else {
                    f12 = f10 - ((float) eVar.f7672b.r());
                    f11 = this.f7777c.f7672b.f7701a0;
                }
                int d10 = this.f7777c.d();
                int d11 = this.f7784j.f7777c.d();
                if (this.f7777c.i() == this.f7784j.f7777c.i()) {
                    f11 = 0.5f;
                    d11 = 0;
                } else {
                    i11 = d10;
                }
                float f13 = (float) i11;
                float f14 = (float) d11;
                float f15 = (f12 - f13) - f14;
                if (z10) {
                    m mVar11 = this.f7784j;
                    mVar11.f7782h = mVar11.f7779e.f7782h + f14 + (f15 * f11);
                    this.f7782h = (this.f7779e.f7782h - f13) - (f15 * (1.0f - f11));
                } else {
                    this.f7782h = this.f7779e.f7782h + f13 + (f15 * f11);
                    m mVar12 = this.f7784j;
                    mVar12.f7782h = (mVar12.f7779e.f7782h - f14) - (f15 * (1.0f - f11));
                }
                b();
                this.f7784j.b();
            } else if (i10 == 3 && (mVar = this.f7779e) != null && mVar.f7792b == 1 && (mVar2 = this.f7784j) != null && (mVar3 = mVar2.f7779e) != null && mVar3.f7792b == 1) {
                l.e.x();
                m mVar13 = this.f7779e;
                this.f7781g = mVar13.f7781g;
                m mVar14 = this.f7784j;
                m mVar15 = mVar14.f7779e;
                mVar14.f7781g = mVar15.f7781g;
                this.f7782h = mVar13.f7782h + this.f7780f;
                mVar14.f7782h = mVar15.f7782h + mVar14.f7780f;
                b();
                this.f7784j.b();
            } else if (i10 == 5) {
                this.f7777c.f7672b.U();
            }
        }
    }

    public void g(l.e eVar) {
        i g10 = this.f7777c.g();
        m mVar = this.f7781g;
        if (mVar == null) {
            eVar.f(g10, (int) (this.f7782h + 0.5f));
        } else {
            eVar.e(g10, eVar.r(mVar.f7777c), (int) (this.f7782h + 0.5f), 6);
        }
    }

    public void h(int i10, m mVar, int i11) {
        this.f7783i = i10;
        this.f7779e = mVar;
        this.f7780f = (float) i11;
        mVar.a(this);
    }

    public void i(m mVar, int i10) {
        this.f7779e = mVar;
        this.f7780f = (float) i10;
        mVar.a(this);
    }

    public void j(m mVar, int i10, n nVar) {
        this.f7779e = mVar;
        mVar.a(this);
        this.f7786l = nVar;
        this.f7787m = i10;
        nVar.a(this);
    }

    public float k() {
        return this.f7782h;
    }

    public void l(m mVar, float f10) {
        int i10 = this.f7792b;
        if (i10 == 0 || !(this.f7781g == mVar || this.f7782h == f10)) {
            this.f7781g = mVar;
            this.f7782h = f10;
            if (i10 == 1) {
                c();
            }
            b();
        }
    }

    public String m(int i10) {
        if (i10 == 1) {
            return "DIRECT";
        }
        if (i10 == 2) {
            return "CENTER";
        }
        if (i10 == 3) {
            return "MATCH";
        }
        if (i10 == 4) {
            return "CHAIN";
        }
        return i10 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void n(m mVar, float f10) {
        this.f7784j = mVar;
        this.f7785k = f10;
    }

    public void o(m mVar, int i10, n nVar) {
        this.f7784j = mVar;
        this.f7788n = nVar;
        this.f7789o = i10;
    }

    public void p(int i10) {
        this.f7783i = i10;
    }

    public void q() {
        e i10 = this.f7777c.i();
        if (i10 != null) {
            if (i10.i() == this.f7777c) {
                this.f7783i = 4;
                i10.f().f7783i = 4;
            }
            int d10 = this.f7777c.d();
            e.d dVar = this.f7777c.f7673c;
            if (dVar == e.d.RIGHT || dVar == e.d.BOTTOM) {
                d10 = -d10;
            }
            i(i10.f(), d10);
        }
    }

    public String toString() {
        if (this.f7792b != 1) {
            return "{ " + this.f7777c + " UNRESOLVED} type: " + m(this.f7783i);
        } else if (this.f7781g == this) {
            return "[" + this.f7777c + ", RESOLVED: " + this.f7782h + "]  type: " + m(this.f7783i);
        } else {
            return "[" + this.f7777c + ", RESOLVED: " + this.f7781g + SOAP.DELIM + this.f7782h + "] type: " + m(this.f7783i);
        }
    }
}
