package d3;

import c3.h;
import c3.m;
import c3.o;
import c3.q;
import g3.e;
import java.math.BigDecimal;

public abstract class a extends h {

    /* renamed from: j  reason: collision with root package name */
    public static final int f6206j = ((h.b.WRITE_NUMBERS_AS_STRINGS.d() | h.b.ESCAPE_NON_ASCII.d()) | h.b.STRICT_DUPLICATE_DETECTION.d());

    /* renamed from: e  reason: collision with root package name */
    public o f6207e;

    /* renamed from: f  reason: collision with root package name */
    public int f6208f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6209g;

    /* renamed from: h  reason: collision with root package name */
    public e f6210h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6211i;

    public a(int i10, o oVar) {
        g3.a aVar;
        this.f6208f = i10;
        this.f6207e = oVar;
        if (h.b.STRICT_DUPLICATE_DETECTION.c(i10)) {
            aVar = g3.a.e(this);
        } else {
            aVar = null;
        }
        this.f6210h = e.q(aVar);
        this.f6209g = h.b.WRITE_NUMBERS_AS_STRINGS.c(i10);
    }

    public String F0(BigDecimal bigDecimal) {
        if (!h.b.WRITE_BIGDECIMAL_AS_PLAIN.c(this.f6208f)) {
            return bigDecimal.toString();
        }
        int scale = bigDecimal.scale();
        if (scale < -9999 || scale > 9999) {
            a(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", new Object[]{Integer.valueOf(scale), 9999, 9999}));
        }
        return bigDecimal.toPlainString();
    }

    public void G0(int i10, int i11) {
        if ((f6206j & i11) != 0) {
            this.f6209g = h.b.WRITE_NUMBERS_AS_STRINGS.c(i10);
            h.b bVar = h.b.ESCAPE_NON_ASCII;
            if (bVar.c(i11)) {
                if (bVar.c(i10)) {
                    E(127);
                } else {
                    E(0);
                }
            }
            h.b bVar2 = h.b.STRICT_DUPLICATE_DETECTION;
            if (!bVar2.c(i11)) {
                return;
            }
            if (!bVar2.c(i10)) {
                this.f6210h = this.f6210h.v((g3.a) null);
            } else if (this.f6210h.r() == null) {
                this.f6210h = this.f6210h.v(g3.a.e(this));
            }
        }
    }

    public final int H0(int i10, int i11) {
        if (i11 < 56320 || i11 > 57343) {
            a("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i10) + ", second 0x" + Integer.toHexString(i11));
        }
        return ((i10 - 55296) << 10) + 65536 + (i11 - 56320);
    }

    public abstract void I0(String str);

    public void close() {
        this.f6211i = true;
    }

    public h q(h.b bVar) {
        int d10 = bVar.d();
        this.f6208f &= d10 ^ -1;
        if ((d10 & f6206j) != 0) {
            if (bVar == h.b.WRITE_NUMBERS_AS_STRINGS) {
                this.f6209g = false;
            } else if (bVar == h.b.ESCAPE_NON_ASCII) {
                E(0);
            } else if (bVar == h.b.STRICT_DUPLICATE_DETECTION) {
                this.f6210h = this.f6210h.v((g3.a) null);
            }
        }
        return this;
    }

    public void q0(q qVar) {
        I0("write raw value");
        n0(qVar);
    }

    public void r0(String str) {
        I0("write raw value");
        o0(str);
    }

    public m s() {
        return this.f6210h;
    }

    public final boolean v(h.b bVar) {
        if ((bVar.d() & this.f6208f) != 0) {
            return true;
        }
        return false;
    }

    public h y(int i10, int i11) {
        int i12 = this.f6208f;
        int i13 = (i10 & i11) | ((i11 ^ -1) & i12);
        int i14 = i12 ^ i13;
        if (i14 != 0) {
            this.f6208f = i13;
            G0(i13, i14);
        }
        return this;
    }

    public void z(Object obj) {
        e eVar = this.f6210h;
        if (eVar != null) {
            eVar.i(obj);
        }
    }
}
