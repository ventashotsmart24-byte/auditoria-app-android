package m;

import com.hpplay.cybergarage.soap.SOAP;
import l.i;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public m f7671a = new m(this);

    /* renamed from: b  reason: collision with root package name */
    public final f f7672b;

    /* renamed from: c  reason: collision with root package name */
    public final d f7673c;

    /* renamed from: d  reason: collision with root package name */
    public e f7674d;

    /* renamed from: e  reason: collision with root package name */
    public int f7675e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f7676f = -1;

    /* renamed from: g  reason: collision with root package name */
    public c f7677g = c.NONE;

    /* renamed from: h  reason: collision with root package name */
    public b f7678h = b.RELAXED;

    /* renamed from: i  reason: collision with root package name */
    public int f7679i = 0;

    /* renamed from: j  reason: collision with root package name */
    public i f7680j;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7681a;

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
                f7681a = r0
                m.e$d r1 = m.e.d.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7681a     // Catch:{ NoSuchFieldError -> 0x001d }
                m.e$d r1 = m.e.d.LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7681a     // Catch:{ NoSuchFieldError -> 0x0028 }
                m.e$d r1 = m.e.d.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7681a     // Catch:{ NoSuchFieldError -> 0x0033 }
                m.e$d r1 = m.e.d.TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7681a     // Catch:{ NoSuchFieldError -> 0x003e }
                m.e$d r1 = m.e.d.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7681a     // Catch:{ NoSuchFieldError -> 0x0049 }
                m.e$d r1 = m.e.d.BASELINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7681a     // Catch:{ NoSuchFieldError -> 0x0054 }
                m.e$d r1 = m.e.d.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7681a     // Catch:{ NoSuchFieldError -> 0x0060 }
                m.e$d r1 = m.e.d.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f7681a     // Catch:{ NoSuchFieldError -> 0x006c }
                m.e$d r1 = m.e.d.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m.e.a.<clinit>():void");
        }
    }

    public enum b {
        RELAXED,
        STRICT
    }

    public enum c {
        NONE,
        STRONG,
        WEAK
    }

    public enum d {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public e(f fVar, d dVar) {
        this.f7672b = fVar;
        this.f7673c = dVar;
    }

    public boolean a(e eVar, int i10, int i11, c cVar, int i12, boolean z10) {
        if (eVar == null) {
            this.f7674d = null;
            this.f7675e = 0;
            this.f7676f = -1;
            this.f7677g = c.NONE;
            this.f7679i = 2;
            return true;
        } else if (!z10 && !l(eVar)) {
            return false;
        } else {
            this.f7674d = eVar;
            if (i10 > 0) {
                this.f7675e = i10;
            } else {
                this.f7675e = 0;
            }
            this.f7676f = i11;
            this.f7677g = cVar;
            this.f7679i = i12;
            return true;
        }
    }

    public boolean b(e eVar, int i10, c cVar, int i11) {
        return a(eVar, i10, -1, cVar, i11, false);
    }

    public int c() {
        return this.f7679i;
    }

    public int d() {
        e eVar;
        if (this.f7672b.C() == 8) {
            return 0;
        }
        if (this.f7676f <= -1 || (eVar = this.f7674d) == null || eVar.f7672b.C() != 8) {
            return this.f7675e;
        }
        return this.f7676f;
    }

    public f e() {
        return this.f7672b;
    }

    public m f() {
        return this.f7671a;
    }

    public i g() {
        return this.f7680j;
    }

    public c h() {
        return this.f7677g;
    }

    public e i() {
        return this.f7674d;
    }

    public d j() {
        return this.f7673c;
    }

    public boolean k() {
        if (this.f7674d != null) {
            return true;
        }
        return false;
    }

    public boolean l(e eVar) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (eVar == null) {
            return false;
        }
        d j10 = eVar.j();
        d dVar = this.f7673c;
        if (j10 != dVar) {
            switch (a.f7681a[dVar.ordinal()]) {
                case 1:
                    if (j10 == d.BASELINE || j10 == d.CENTER_X || j10 == d.CENTER_Y) {
                        return false;
                    }
                    return true;
                case 2:
                case 3:
                    if (j10 == d.LEFT || j10 == d.RIGHT) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!(eVar.e() instanceof i)) {
                        return z10;
                    }
                    if (z10 || j10 == d.CENTER_X) {
                        z12 = true;
                    }
                    return z12;
                case 4:
                case 5:
                    if (j10 == d.TOP || j10 == d.BOTTOM) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!(eVar.e() instanceof i)) {
                        return z11;
                    }
                    if (z11 || j10 == d.CENTER_Y) {
                        z12 = true;
                    }
                    return z12;
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.f7673c.name());
            }
        } else if (dVar != d.BASELINE || (eVar.e().I() && e().I())) {
            return true;
        } else {
            return false;
        }
    }

    public void m() {
        this.f7674d = null;
        this.f7675e = 0;
        this.f7676f = -1;
        this.f7677g = c.STRONG;
        this.f7679i = 0;
        this.f7678h = b.RELAXED;
        this.f7671a.e();
    }

    public void n(l.c cVar) {
        i iVar = this.f7680j;
        if (iVar == null) {
            this.f7680j = new i(i.a.UNRESTRICTED, (String) null);
        } else {
            iVar.d();
        }
    }

    public String toString() {
        return this.f7672b.n() + SOAP.DELIM + this.f7673c.toString();
    }
}
