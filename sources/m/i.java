package m;

import java.util.ArrayList;
import l.e;
import m.e;
import m.f;

public class i extends f {
    public boolean A0;
    public int B0;
    public l C0;
    public int D0;

    /* renamed from: v0  reason: collision with root package name */
    public float f7768v0 = -1.0f;

    /* renamed from: w0  reason: collision with root package name */
    public int f7769w0 = -1;

    /* renamed from: x0  reason: collision with root package name */
    public int f7770x0 = -1;

    /* renamed from: y0  reason: collision with root package name */
    public e f7771y0 = this.f7741v;

    /* renamed from: z0  reason: collision with root package name */
    public int f7772z0;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7773a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                m.e$d[] r0 = m.e.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7773a = r0
                m.e$d r1 = m.e.d.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7773a     // Catch:{ NoSuchFieldError -> 0x001d }
                m.e$d r1 = m.e.d.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7773a     // Catch:{ NoSuchFieldError -> 0x0028 }
                m.e$d r1 = m.e.d.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7773a     // Catch:{ NoSuchFieldError -> 0x0033 }
                m.e$d r1 = m.e.d.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7773a     // Catch:{ NoSuchFieldError -> 0x003e }
                m.e$d r1 = m.e.d.BASELINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7773a     // Catch:{ NoSuchFieldError -> 0x0049 }
                m.e$d r1 = m.e.d.CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7773a     // Catch:{ NoSuchFieldError -> 0x0054 }
                m.e$d r1 = m.e.d.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7773a     // Catch:{ NoSuchFieldError -> 0x0060 }
                m.e$d r1 = m.e.d.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f7773a     // Catch:{ NoSuchFieldError -> 0x006c }
                m.e$d r1 = m.e.d.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m.i.a.<clinit>():void");
        }
    }

    public i() {
        this.f7772z0 = 0;
        this.A0 = false;
        this.B0 = 0;
        this.C0 = new l();
        this.D0 = 8;
        this.D.clear();
        this.D.add(this.f7771y0);
        int length = this.C.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.C[i10] = this.f7771y0;
        }
    }

    public void G0(e eVar) {
        if (u() != null) {
            int y10 = eVar.y(this.f7771y0);
            if (this.f7772z0 == 1) {
                C0(y10);
                D0(0);
                b0(u().r());
                y0(0);
                return;
            }
            C0(0);
            D0(y10);
            y0(u().D());
            b0(0);
        }
    }

    public int I0() {
        return this.f7772z0;
    }

    public void J0(int i10) {
        if (i10 > -1) {
            this.f7768v0 = -1.0f;
            this.f7769w0 = i10;
            this.f7770x0 = -1;
        }
    }

    public void K0(int i10) {
        if (i10 > -1) {
            this.f7768v0 = -1.0f;
            this.f7769w0 = -1;
            this.f7770x0 = i10;
        }
    }

    public void L0(float f10) {
        if (f10 > -1.0f) {
            this.f7768v0 = f10;
            this.f7769w0 = -1;
            this.f7770x0 = -1;
        }
    }

    public void M0(int i10) {
        if (this.f7772z0 != i10) {
            this.f7772z0 = i10;
            this.D.clear();
            if (this.f7772z0 == 1) {
                this.f7771y0 = this.f7740u;
            } else {
                this.f7771y0 = this.f7741v;
            }
            this.D.add(this.f7771y0);
            int length = this.C.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.C[i11] = this.f7771y0;
            }
        }
    }

    public void b(e eVar) {
        boolean z10;
        g gVar = (g) u();
        if (gVar != null) {
            e h10 = gVar.h(e.d.LEFT);
            e h11 = gVar.h(e.d.RIGHT);
            f fVar = this.F;
            boolean z11 = true;
            if (fVar == null || fVar.E[0] != f.b.WRAP_CONTENT) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (this.f7772z0 == 0) {
                h10 = gVar.h(e.d.TOP);
                h11 = gVar.h(e.d.BOTTOM);
                f fVar2 = this.F;
                if (fVar2 == null || fVar2.E[1] != f.b.WRAP_CONTENT) {
                    z11 = false;
                }
                z10 = z11;
            }
            if (this.f7769w0 != -1) {
                l.i r10 = eVar.r(this.f7771y0);
                eVar.e(r10, eVar.r(h10), this.f7769w0, 6);
                if (z10) {
                    eVar.i(eVar.r(h11), r10, 0, 5);
                }
            } else if (this.f7770x0 != -1) {
                l.i r11 = eVar.r(this.f7771y0);
                l.i r12 = eVar.r(h11);
                eVar.e(r11, r12, -this.f7770x0, 6);
                if (z10) {
                    eVar.i(r11, eVar.r(h10), 0, 5);
                    eVar.i(r12, r11, 0, 5);
                }
            } else if (this.f7768v0 != -1.0f) {
                eVar.d(l.e.t(eVar, eVar.r(this.f7771y0), eVar.r(h10), eVar.r(h11), this.f7768v0, this.A0));
            }
        }
    }

    public boolean c() {
        return true;
    }

    public void d(int i10) {
        f u10 = u();
        if (u10 != null) {
            if (I0() == 1) {
                this.f7741v.f().h(1, u10.f7741v.f(), 0);
                this.f7743x.f().h(1, u10.f7741v.f(), 0);
                if (this.f7769w0 != -1) {
                    this.f7740u.f().h(1, u10.f7740u.f(), this.f7769w0);
                    this.f7742w.f().h(1, u10.f7740u.f(), this.f7769w0);
                } else if (this.f7770x0 != -1) {
                    this.f7740u.f().h(1, u10.f7742w.f(), -this.f7770x0);
                    this.f7742w.f().h(1, u10.f7742w.f(), -this.f7770x0);
                } else if (this.f7768v0 != -1.0f && u10.s() == f.b.FIXED) {
                    int i11 = (int) (((float) u10.G) * this.f7768v0);
                    this.f7740u.f().h(1, u10.f7740u.f(), i11);
                    this.f7742w.f().h(1, u10.f7740u.f(), i11);
                }
            } else {
                this.f7740u.f().h(1, u10.f7740u.f(), 0);
                this.f7742w.f().h(1, u10.f7740u.f(), 0);
                if (this.f7769w0 != -1) {
                    this.f7741v.f().h(1, u10.f7741v.f(), this.f7769w0);
                    this.f7743x.f().h(1, u10.f7741v.f(), this.f7769w0);
                } else if (this.f7770x0 != -1) {
                    this.f7741v.f().h(1, u10.f7743x.f(), -this.f7770x0);
                    this.f7743x.f().h(1, u10.f7743x.f(), -this.f7770x0);
                } else if (this.f7768v0 != -1.0f && u10.B() == f.b.FIXED) {
                    int i12 = (int) (((float) u10.H) * this.f7768v0);
                    this.f7741v.f().h(1, u10.f7741v.f(), i12);
                    this.f7743x.f().h(1, u10.f7741v.f(), i12);
                }
            }
        }
    }

    public e h(e.d dVar) {
        switch (a.f7773a[dVar.ordinal()]) {
            case 1:
            case 2:
                if (this.f7772z0 == 1) {
                    return this.f7771y0;
                }
                break;
            case 3:
            case 4:
                if (this.f7772z0 == 0) {
                    return this.f7771y0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(dVar.name());
    }

    public ArrayList i() {
        return this.D;
    }
}
