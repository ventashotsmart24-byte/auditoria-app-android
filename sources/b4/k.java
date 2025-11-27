package b4;

import java.util.Arrays;
import k3.c0;
import k3.j;
import k3.o;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4348a;

    public static final class a extends k {

        /* renamed from: b  reason: collision with root package name */
        public final Class f4349b;

        /* renamed from: c  reason: collision with root package name */
        public final Class f4350c;

        /* renamed from: d  reason: collision with root package name */
        public final o f4351d;

        /* renamed from: e  reason: collision with root package name */
        public final o f4352e;

        public a(k kVar, Class cls, o oVar, Class cls2, o oVar2) {
            super(kVar);
            this.f4349b = cls;
            this.f4351d = oVar;
            this.f4350c = cls2;
            this.f4352e = oVar2;
        }

        public k i(Class cls, o oVar) {
            return new c(this, new f[]{new f(this.f4349b, this.f4351d), new f(this.f4350c, this.f4352e), new f(cls, oVar)});
        }

        public o j(Class cls) {
            if (cls == this.f4349b) {
                return this.f4351d;
            }
            if (cls == this.f4350c) {
                return this.f4352e;
            }
            return null;
        }
    }

    public static final class b extends k {

        /* renamed from: b  reason: collision with root package name */
        public static final b f4353b = new b(false);

        /* renamed from: c  reason: collision with root package name */
        public static final b f4354c = new b(true);

        public b(boolean z10) {
            super(z10);
        }

        public k i(Class cls, o oVar) {
            return new e(this, cls, oVar);
        }

        public o j(Class cls) {
            return null;
        }
    }

    public static final class c extends k {

        /* renamed from: b  reason: collision with root package name */
        public final f[] f4355b;

        public c(k kVar, f[] fVarArr) {
            super(kVar);
            this.f4355b = fVarArr;
        }

        public k i(Class cls, o oVar) {
            f[] fVarArr = this.f4355b;
            int length = fVarArr.length;
            if (length != 8) {
                f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, length + 1);
                fVarArr2[length] = new f(cls, oVar);
                return new c(this, fVarArr2);
            } else if (this.f4348a) {
                return new e(this, cls, oVar);
            } else {
                return this;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
            r1 = r0[6];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
            if (r1.f4360a != r4) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
            return r1.f4361b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            r1 = r0[5];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
            if (r1.f4360a != r4) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
            return r1.f4361b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
            r1 = r0[4];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
            if (r1.f4360a != r4) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
            return r1.f4361b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
            r0 = r0[3];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0052, code lost:
            if (r0.f4360a != r4) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0056, code lost:
            return r0.f4361b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public k3.o j(java.lang.Class r4) {
            /*
                r3 = this;
                b4.k$f[] r0 = r3.f4355b
                r1 = 0
                r1 = r0[r1]
                java.lang.Class r2 = r1.f4360a
                if (r2 != r4) goto L_0x000c
                k3.o r4 = r1.f4361b
                return r4
            L_0x000c:
                r1 = 1
                r1 = r0[r1]
                java.lang.Class r2 = r1.f4360a
                if (r2 != r4) goto L_0x0016
                k3.o r4 = r1.f4361b
                return r4
            L_0x0016:
                r1 = 2
                r1 = r0[r1]
                java.lang.Class r2 = r1.f4360a
                if (r2 != r4) goto L_0x0020
                k3.o r4 = r1.f4361b
                return r4
            L_0x0020:
                int r1 = r0.length
                switch(r1) {
                    case 4: goto L_0x004d;
                    case 5: goto L_0x0043;
                    case 6: goto L_0x0039;
                    case 7: goto L_0x002f;
                    case 8: goto L_0x0025;
                    default: goto L_0x0024;
                }
            L_0x0024:
                goto L_0x0057
            L_0x0025:
                r1 = 7
                r1 = r0[r1]
                java.lang.Class r2 = r1.f4360a
                if (r2 != r4) goto L_0x002f
                k3.o r4 = r1.f4361b
                return r4
            L_0x002f:
                r1 = 6
                r1 = r0[r1]
                java.lang.Class r2 = r1.f4360a
                if (r2 != r4) goto L_0x0039
                k3.o r4 = r1.f4361b
                return r4
            L_0x0039:
                r1 = 5
                r1 = r0[r1]
                java.lang.Class r2 = r1.f4360a
                if (r2 != r4) goto L_0x0043
                k3.o r4 = r1.f4361b
                return r4
            L_0x0043:
                r1 = 4
                r1 = r0[r1]
                java.lang.Class r2 = r1.f4360a
                if (r2 != r4) goto L_0x004d
                k3.o r4 = r1.f4361b
                return r4
            L_0x004d:
                r1 = 3
                r0 = r0[r1]
                java.lang.Class r1 = r0.f4360a
                if (r1 != r4) goto L_0x0057
                k3.o r4 = r0.f4361b
                return r4
            L_0x0057:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: b4.k.c.j(java.lang.Class):k3.o");
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final o f4356a;

        /* renamed from: b  reason: collision with root package name */
        public final k f4357b;

        public d(o oVar, k kVar) {
            this.f4356a = oVar;
            this.f4357b = kVar;
        }
    }

    public static final class e extends k {

        /* renamed from: b  reason: collision with root package name */
        public final Class f4358b;

        /* renamed from: c  reason: collision with root package name */
        public final o f4359c;

        public e(k kVar, Class cls, o oVar) {
            super(kVar);
            this.f4358b = cls;
            this.f4359c = oVar;
        }

        public k i(Class cls, o oVar) {
            return new a(this, this.f4358b, this.f4359c, cls, oVar);
        }

        public o j(Class cls) {
            if (cls == this.f4358b) {
                return this.f4359c;
            }
            return null;
        }
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final Class f4360a;

        /* renamed from: b  reason: collision with root package name */
        public final o f4361b;

        public f(Class cls, o oVar) {
            this.f4360a = cls;
            this.f4361b = oVar;
        }
    }

    public k(boolean z10) {
        this.f4348a = z10;
    }

    public static k c() {
        return b.f4353b;
    }

    public final d a(Class cls, o oVar) {
        return new d(oVar, i(cls, oVar));
    }

    public final d b(j jVar, o oVar) {
        return new d(oVar, i(jVar.q(), oVar));
    }

    public final d d(Class cls, c0 c0Var, k3.d dVar) {
        o I = c0Var.I(cls, dVar);
        return new d(I, i(cls, I));
    }

    public final d e(Class cls, c0 c0Var, k3.d dVar) {
        o N = c0Var.N(cls, dVar);
        return new d(N, i(cls, N));
    }

    public final d f(j jVar, c0 c0Var, k3.d dVar) {
        o O = c0Var.O(jVar, dVar);
        return new d(O, i(jVar.q(), O));
    }

    public final d g(Class cls, c0 c0Var, k3.d dVar) {
        o G = c0Var.G(cls, dVar);
        return new d(G, i(cls, G));
    }

    public final d h(j jVar, c0 c0Var, k3.d dVar) {
        o H = c0Var.H(jVar, dVar);
        return new d(H, i(jVar.q(), H));
    }

    public abstract k i(Class cls, o oVar);

    public abstract o j(Class cls);

    public k(k kVar) {
        this.f4348a = kVar.f4348a;
    }
}
