package z8;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import java.nio.charset.Charset;
import y8.j0;
import y8.k1;
import y8.l0;
import y8.v0;
import z8.a;

public abstract class t0 extends a.c {

    /* renamed from: w  reason: collision with root package name */
    public static final j0.a f20965w;

    /* renamed from: x  reason: collision with root package name */
    public static final v0.g f20966x;

    /* renamed from: s  reason: collision with root package name */
    public k1 f20967s;

    /* renamed from: t  reason: collision with root package name */
    public v0 f20968t;

    /* renamed from: u  reason: collision with root package name */
    public Charset f20969u = Charsets.UTF_8;

    /* renamed from: v  reason: collision with root package name */
    public boolean f20970v;

    public class a implements j0.a {
        /* renamed from: c */
        public Integer b(byte[] bArr) {
            if (bArr.length >= 3) {
                return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
            }
            throw new NumberFormatException("Malformed status code " + new String(bArr, j0.f20030a));
        }

        /* renamed from: d */
        public byte[] a(Integer num) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        a aVar = new a();
        f20965w = aVar;
        f20966x = j0.b(":status", aVar);
    }

    public t0(int i10, g2 g2Var, m2 m2Var) {
        super(i10, g2Var, m2Var);
    }

    public static Charset O(v0 v0Var) {
        String str = (String) v0Var.g(q0.f20881j);
        if (str != null) {
            String[] split = str.split("charset=", 2);
            try {
                return Charset.forName(split[split.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return Charsets.UTF_8;
    }

    public static void R(v0 v0Var) {
        v0Var.e(f20966x);
        v0Var.e(l0.f20087b);
        v0Var.e(l0.f20086a);
    }

    public abstract void P(k1 k1Var, boolean z10, v0 v0Var);

    public final k1 Q(v0 v0Var) {
        k1 k1Var;
        k1 k1Var2 = (k1) v0Var.g(l0.f20087b);
        if (k1Var2 != null) {
            return k1Var2.r((String) v0Var.g(l0.f20086a));
        }
        if (this.f20970v) {
            return k1.f20043h.r("missing GRPC status in response");
        }
        Integer num = (Integer) v0Var.g(f20966x);
        if (num != null) {
            k1Var = q0.l(num.intValue());
        } else {
            k1Var = k1.f20055t.r("missing HTTP status code");
        }
        return k1Var.f("missing GRPC status, inferred error from HTTP status code");
    }

    public void S(t1 t1Var, boolean z10) {
        k1 k1Var = this.f20967s;
        if (k1Var != null) {
            this.f20967s = k1Var.f("DATA-----------------------------\n" + u1.e(t1Var, this.f20969u));
            t1Var.close();
            if (this.f20967s.o().length() > 1000 || z10) {
                P(this.f20967s, false, this.f20968t);
            }
        } else if (!this.f20970v) {
            P(k1.f20055t.r("headers not received before payload"), false, new v0());
        } else {
            int h10 = t1Var.h();
            D(t1Var);
            if (z10) {
                if (h10 > 0) {
                    this.f20967s = k1.f20055t.r("Received unexpected EOS on non-empty DATA frame from server");
                } else {
                    this.f20967s = k1.f20055t.r("Received unexpected EOS on empty DATA frame from server");
                }
                v0 v0Var = new v0();
                this.f20968t = v0Var;
                N(this.f20967s, false, v0Var);
            }
        }
    }

    public void T(v0 v0Var) {
        Preconditions.checkNotNull(v0Var, "headers");
        k1 k1Var = this.f20967s;
        if (k1Var != null) {
            this.f20967s = k1Var.f("headers: " + v0Var);
            return;
        }
        try {
            if (this.f20970v) {
                k1 r10 = k1.f20055t.r("Received headers twice");
                this.f20967s = r10;
                if (r10 != null) {
                    this.f20967s = r10.f("headers: " + v0Var);
                    this.f20968t = v0Var;
                    this.f20969u = O(v0Var);
                    return;
                }
                return;
            }
            Integer num = (Integer) v0Var.g(f20966x);
            if (num == null || num.intValue() < 100 || num.intValue() >= 200) {
                this.f20970v = true;
                k1 V = V(v0Var);
                this.f20967s = V;
                if (V == null) {
                    R(v0Var);
                    E(v0Var);
                    k1 k1Var2 = this.f20967s;
                    if (k1Var2 != null) {
                        this.f20967s = k1Var2.f("headers: " + v0Var);
                        this.f20968t = v0Var;
                        this.f20969u = O(v0Var);
                    }
                } else if (V != null) {
                    this.f20967s = V.f("headers: " + v0Var);
                    this.f20968t = v0Var;
                    this.f20969u = O(v0Var);
                }
            }
        } finally {
            k1 k1Var3 = this.f20967s;
            if (k1Var3 != null) {
                this.f20967s = k1Var3.f("headers: " + v0Var);
                this.f20968t = v0Var;
                this.f20969u = O(v0Var);
            }
        }
    }

    public void U(v0 v0Var) {
        Preconditions.checkNotNull(v0Var, "trailers");
        if (this.f20967s == null && !this.f20970v) {
            k1 V = V(v0Var);
            this.f20967s = V;
            if (V != null) {
                this.f20968t = v0Var;
            }
        }
        k1 k1Var = this.f20967s;
        if (k1Var != null) {
            k1 f10 = k1Var.f("trailers: " + v0Var);
            this.f20967s = f10;
            P(f10, false, this.f20968t);
            return;
        }
        k1 Q = Q(v0Var);
        R(v0Var);
        F(v0Var, Q);
    }

    public final k1 V(v0 v0Var) {
        Integer num = (Integer) v0Var.g(f20966x);
        if (num == null) {
            return k1.f20055t.r("Missing HTTP status code");
        }
        String str = (String) v0Var.g(q0.f20881j);
        if (q0.m(str)) {
            return null;
        }
        k1 l10 = q0.l(num.intValue());
        return l10.f("invalid content-type: " + str);
    }

    public /* bridge */ /* synthetic */ void e(boolean z10) {
        super.e(z10);
    }
}
