package g3;

import c3.k;
import c3.n;
import c3.o;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import d3.b;
import f3.a;
import h3.c;
import j3.i;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

public class f extends b {

    /* renamed from: j0  reason: collision with root package name */
    public static final int f6803j0 = k.a.ALLOW_TRAILING_COMMA.d();

    /* renamed from: k0  reason: collision with root package name */
    public static final int f6804k0 = k.a.ALLOW_NUMERIC_LEADING_ZEROS.d();

    /* renamed from: l0  reason: collision with root package name */
    public static final int f6805l0 = k.a.ALLOW_NON_NUMERIC_NUMBERS.d();

    /* renamed from: m0  reason: collision with root package name */
    public static final int f6806m0 = k.a.ALLOW_MISSING_VALUES.d();

    /* renamed from: n0  reason: collision with root package name */
    public static final int f6807n0 = k.a.ALLOW_SINGLE_QUOTES.d();

    /* renamed from: o0  reason: collision with root package name */
    public static final int f6808o0 = k.a.ALLOW_UNQUOTED_FIELD_NAMES.d();

    /* renamed from: p0  reason: collision with root package name */
    public static final int f6809p0 = k.a.ALLOW_COMMENTS.d();

    /* renamed from: q0  reason: collision with root package name */
    public static final int f6810q0 = k.a.ALLOW_YAML_COMMENTS.d();

    /* renamed from: r0  reason: collision with root package name */
    public static final int[] f6811r0 = a.g();
    public Reader S;
    public char[] V;
    public boolean W = true;
    public o X;
    public final c Y;
    public final int Z;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f6812f0;

    /* renamed from: g0  reason: collision with root package name */
    public long f6813g0;

    /* renamed from: h0  reason: collision with root package name */
    public int f6814h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f6815i0;

    public f(f3.c cVar, int i10, Reader reader, o oVar, c cVar2) {
        super(cVar, i10);
        this.S = reader;
        this.V = cVar.g();
        this.f6214q = 0;
        this.f6215r = 0;
        this.X = oVar;
        this.Y = cVar2;
        this.Z = cVar2.l();
    }

    public final void A2() {
        this.f6812f0 = false;
        int i10 = this.f6214q;
        int i11 = this.f6215r;
        char[] cArr = this.V;
        while (true) {
            if (i10 >= i11) {
                this.f6214q = i10;
                if (!Y1()) {
                    Q0(": was expecting closing quote for a string value", n.VALUE_STRING);
                }
                i10 = this.f6214q;
                i11 = this.f6215r;
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 <= '\\') {
                if (c10 == '\\') {
                    this.f6214q = i12;
                    l1();
                    i10 = this.f6214q;
                    i11 = this.f6215r;
                } else if (c10 <= '\"') {
                    if (c10 == '\"') {
                        this.f6214q = i12;
                        return;
                    } else if (c10 < ' ') {
                        this.f6214q = i12;
                        y1(c10, "string value");
                    }
                }
            }
            i10 = i12;
        }
    }

    public final int B2() {
        if (this.f6214q >= this.f6215r && !Y1()) {
            return m1();
        }
        char[] cArr = this.V;
        int i10 = this.f6214q;
        int i11 = i10 + 1;
        this.f6214q = i11;
        char c10 = cArr[i10];
        if (c10 <= ' ') {
            if (c10 != ' ') {
                if (c10 == 10) {
                    this.f6217t++;
                    this.f6218u = i11;
                } else if (c10 == 13) {
                    u2();
                } else if (c10 != 9) {
                    V0(c10);
                }
            }
            while (true) {
                int i12 = this.f6214q;
                if (i12 >= this.f6215r) {
                    return C2();
                }
                char[] cArr2 = this.V;
                int i13 = i12 + 1;
                this.f6214q = i13;
                char c11 = cArr2[i12];
                if (c11 > ' ') {
                    if (c11 != '/' && c11 != '#') {
                        return c11;
                    }
                    this.f6214q = i13 - 1;
                    return C2();
                } else if (c11 != ' ') {
                    if (c11 == 10) {
                        this.f6217t++;
                        this.f6218u = i13;
                    } else if (c11 == 13) {
                        u2();
                    } else if (c11 != 9) {
                        V0(c11);
                    }
                }
            }
        } else if (c10 != '/' && c10 != '#') {
            return c10;
        } else {
            this.f6214q = i11 - 1;
            return C2();
        }
    }

    public final int C2() {
        char c10;
        while (true) {
            if (this.f6214q >= this.f6215r && !Y1()) {
                return m1();
            }
            char[] cArr = this.V;
            int i10 = this.f6214q;
            int i11 = i10 + 1;
            this.f6214q = i11;
            c10 = cArr[i10];
            if (c10 > ' ') {
                if (c10 == '/') {
                    y2();
                } else if (c10 != '#' || !D2()) {
                    return c10;
                }
            } else if (c10 != ' ') {
                if (c10 == 10) {
                    this.f6217t++;
                    this.f6218u = i11;
                } else if (c10 == 13) {
                    u2();
                } else if (c10 != 9) {
                    V0(c10);
                }
            }
        }
        return c10;
    }

    public final boolean D2() {
        if ((this.f4739a & f6810q0) == 0) {
            return false;
        }
        z2();
        return true;
    }

    public final void E2() {
        int i10 = this.f6214q;
        this.f6219v = this.f6216s + ((long) i10);
        this.f6220w = this.f6217t;
        this.f6221x = i10 - this.f6218u;
    }

    public final void F2() {
        int i10 = this.f6214q;
        this.f6813g0 = (long) i10;
        this.f6814h0 = this.f6217t;
        this.f6815i0 = i10 - this.f6218u;
    }

    public final char G2() {
        char c10;
        if ((this.f6214q >= this.f6215r && !Y1()) || (c10 = this.V[this.f6214q]) < '0' || c10 > '9') {
            return '0';
        }
        if ((this.f4739a & f6804k0) == 0) {
            a1("Leading zeroes not allowed");
        }
        this.f6214q++;
        if (c10 == '0') {
            do {
                if (this.f6214q >= this.f6215r && !Y1()) {
                    break;
                }
                char[] cArr = this.V;
                int i10 = this.f6214q;
                c10 = cArr[i10];
                if (c10 < '0' || c10 > '9') {
                    return '0';
                }
                this.f6214q = i10 + 1;
            } while (c10 == '0');
        }
        return c10;
    }

    public final char H2() {
        char c10;
        int i10 = this.f6214q;
        if (i10 >= this.f6215r || ((c10 = this.V[i10]) >= '0' && c10 <= '9')) {
            return G2();
        }
        return '0';
    }

    public final void I2(int i10) {
        int i11 = this.f6214q + 1;
        this.f6214q = i11;
        if (i10 == 9) {
            return;
        }
        if (i10 == 10) {
            this.f6217t++;
            this.f6218u = i11;
        } else if (i10 == 13) {
            u2();
        } else if (i10 != 32) {
            S0(i10);
        }
    }

    public char J2(String str) {
        return K2(str, (n) null);
    }

    public char K2(String str, n nVar) {
        if (this.f6214q >= this.f6215r && !Y1()) {
            Q0(str, nVar);
        }
        char[] cArr = this.V;
        int i10 = this.f6214q;
        this.f6214q = i10 + 1;
        return cArr[i10];
    }

    public final void N1(String str, int i10, int i11) {
        if (Character.isJavaIdentifierPart((char) i11)) {
            q2(str.substring(0, i10));
        }
    }

    public final void O1(int i10) {
        if (i10 == 93) {
            E2();
            if (!this.f6222y.f()) {
                w1(i10, ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
            }
            this.f6222y = this.f6222y.l();
            this.f6234c = n.END_ARRAY;
        }
        if (i10 == 125) {
            E2();
            if (!this.f6222y.g()) {
                w1(i10, ']');
            }
            this.f6222y = this.f6222y.l();
            this.f6234c = n.END_OBJECT;
        }
    }

    public byte[] P1(c3.a aVar) {
        j3.c n12 = n1();
        while (true) {
            if (this.f6214q >= this.f6215r) {
                Z1();
            }
            char[] cArr = this.V;
            int i10 = this.f6214q;
            this.f6214q = i10 + 1;
            char c10 = cArr[i10];
            if (c10 > ' ') {
                int g10 = aVar.g(c10);
                if (g10 < 0) {
                    if (c10 == '\"') {
                        return n12.v();
                    }
                    g10 = k1(aVar, c10, 0);
                    if (g10 < 0) {
                        continue;
                    }
                }
                if (this.f6214q >= this.f6215r) {
                    Z1();
                }
                char[] cArr2 = this.V;
                int i11 = this.f6214q;
                this.f6214q = i11 + 1;
                char c11 = cArr2[i11];
                int g11 = aVar.g(c11);
                if (g11 < 0) {
                    g11 = k1(aVar, c11, 1);
                }
                int i12 = (g10 << 6) | g11;
                if (this.f6214q >= this.f6215r) {
                    Z1();
                }
                char[] cArr3 = this.V;
                int i13 = this.f6214q;
                this.f6214q = i13 + 1;
                char c12 = cArr3[i13];
                int g12 = aVar.g(c12);
                if (g12 < 0) {
                    if (g12 != -2) {
                        if (c12 == '\"') {
                            n12.b(i12 >> 4);
                            if (aVar.v()) {
                                this.f6214q--;
                                p1(aVar);
                            }
                            return n12.v();
                        }
                        g12 = k1(aVar, c12, 2);
                    }
                    if (g12 == -2) {
                        if (this.f6214q >= this.f6215r) {
                            Z1();
                        }
                        char[] cArr4 = this.V;
                        int i14 = this.f6214q;
                        this.f6214q = i14 + 1;
                        char c13 = cArr4[i14];
                        if (aVar.w(c13) || k1(aVar, c13, 3) == -2) {
                            n12.b(i12 >> 4);
                        } else {
                            throw I1(aVar, c13, 3, "expected padding character '" + aVar.r() + "'");
                        }
                    }
                }
                int i15 = (i12 << 6) | g12;
                if (this.f6214q >= this.f6215r) {
                    Z1();
                }
                char[] cArr5 = this.V;
                int i16 = this.f6214q;
                this.f6214q = i16 + 1;
                char c14 = cArr5[i16];
                int g13 = aVar.g(c14);
                if (g13 < 0) {
                    if (g13 != -2) {
                        if (c14 == '\"') {
                            n12.e(i15 >> 2);
                            if (aVar.v()) {
                                this.f6214q--;
                                p1(aVar);
                            }
                            return n12.v();
                        }
                        g13 = k1(aVar, c14, 3);
                    }
                    if (g13 == -2) {
                        n12.e(i15 >> 2);
                    }
                }
                n12.c((i15 << 6) | g13);
            }
        }
    }

    public final void Q1() {
        int i10 = this.f6214q;
        int i11 = this.f6215r;
        if (i10 < i11) {
            int[] iArr = f6811r0;
            int length = iArr.length;
            while (true) {
                char[] cArr = this.V;
                char c10 = cArr[i10];
                if (c10 >= length || iArr[c10] == 0) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                } else if (c10 == '\"') {
                    j3.o oVar = this.A;
                    int i12 = this.f6214q;
                    oVar.w(cArr, i12, i10 - i12);
                    this.f6214q = i10 + 1;
                    return;
                }
            }
        }
        j3.o oVar2 = this.A;
        char[] cArr2 = this.V;
        int i13 = this.f6214q;
        oVar2.v(cArr2, i13, i10 - i13);
        this.f6214q = i10;
        R1();
    }

    public void R1() {
        char[] q10 = this.A.q();
        int r10 = this.A.r();
        int[] iArr = f6811r0;
        int length = iArr.length;
        while (true) {
            if (this.f6214q >= this.f6215r && !Y1()) {
                Q0(": was expecting closing quote for a string value", n.VALUE_STRING);
            }
            char[] cArr = this.V;
            int i10 = this.f6214q;
            this.f6214q = i10 + 1;
            char c10 = cArr[i10];
            if (c10 < length && iArr[c10] != 0) {
                if (c10 == '\"') {
                    this.A.z(r10);
                    return;
                } else if (c10 == '\\') {
                    c10 = l1();
                } else if (c10 < ' ') {
                    y1(c10, "string value");
                }
            }
            if (r10 >= q10.length) {
                q10 = this.A.o();
                r10 = 0;
            }
            q10[r10] = c10;
            r10++;
        }
    }

    public final String S1(n nVar) {
        if (nVar == null) {
            return null;
        }
        int c10 = nVar.c();
        if (c10 == 5) {
            return this.f6222y.b();
        }
        if (c10 == 6 || c10 == 7 || c10 == 8) {
            return this.A.l();
        }
        return nVar.b();
    }

    public n T1() {
        char[] m10 = this.A.m();
        int r10 = this.A.r();
        while (true) {
            if (this.f6214q >= this.f6215r && !Y1()) {
                Q0(": was expecting closing quote for a string value", n.VALUE_STRING);
            }
            char[] cArr = this.V;
            int i10 = this.f6214q;
            this.f6214q = i10 + 1;
            char c10 = cArr[i10];
            if (c10 <= '\\') {
                if (c10 == '\\') {
                    c10 = l1();
                } else if (c10 <= '\'') {
                    if (c10 == '\'') {
                        this.A.z(r10);
                        return n.VALUE_STRING;
                    } else if (c10 < ' ') {
                        y1(c10, "string value");
                    }
                }
            }
            if (r10 >= m10.length) {
                m10 = this.A.o();
                r10 = 0;
            }
            m10[r10] = c10;
            r10++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ?, r10v1 ?, r10v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public c3.n U1(
/*
Method generation error in method: g3.f.U1(int, boolean):c3.n, dex: classes.dex
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ?
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:157)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:129)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
    
*/

    public String V1(int i10) {
        boolean z10;
        if (i10 == 39 && (this.f4739a & f6807n0) != 0) {
            return h2();
        }
        if ((this.f4739a & f6808o0) == 0) {
            T0(i10, "was expecting double-quote to start field name");
        }
        int[] h10 = a.h();
        int length = h10.length;
        if (i10 >= length) {
            z10 = Character.isJavaIdentifierPart((char) i10);
        } else if (h10[i10] == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            T0(i10, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i11 = this.f6214q;
        int i12 = this.Z;
        int i13 = this.f6215r;
        if (i11 < i13) {
            do {
                char[] cArr = this.V;
                char c10 = cArr[i11];
                if (c10 < length) {
                    if (h10[c10] != 0) {
                        int i14 = this.f6214q - 1;
                        this.f6214q = i11;
                        return this.Y.k(cArr, i14, i11 - i14, i12);
                    }
                } else if (!Character.isJavaIdentifierPart((char) c10)) {
                    int i15 = this.f6214q - 1;
                    this.f6214q = i11;
                    return this.Y.k(this.V, i15, i11 - i15, i12);
                }
                i12 = (i12 * 33) + c10;
                i11++;
            } while (i11 < i13);
        }
        this.f6214q = i11;
        return W1(this.f6214q - 1, i12, h10);
    }

    public i W() {
        return b.Q;
    }

    public final String W1(int i10, int i11, int[] iArr) {
        this.A.w(this.V, i10, this.f6214q - i10);
        char[] q10 = this.A.q();
        int r10 = this.A.r();
        int length = iArr.length;
        while (true) {
            if (this.f6214q >= this.f6215r && !Y1()) {
                break;
            }
            char c10 = this.V[this.f6214q];
            if (c10 >= length) {
                if (!Character.isJavaIdentifierPart(c10)) {
                    break;
                }
            } else if (iArr[c10] != 0) {
                break;
            }
            this.f6214q++;
            i11 = (i11 * 33) + c10;
            int i12 = r10 + 1;
            q10[r10] = c10;
            if (i12 >= q10.length) {
                q10 = this.A.o();
                r10 = 0;
            } else {
                r10 = i12;
            }
        }
        this.A.z(r10);
        j3.o oVar = this.A;
        return this.Y.k(oVar.s(), oVar.t(), oVar.A(), i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r4 != 44) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r3.f6222y.f() == false) goto L_0x009a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c3.n X1(int r4) {
        /*
            r3 = this;
            r0 = 39
            if (r4 == r0) goto L_0x008e
            r0 = 73
            r1 = 1
            if (r4 == r0) goto L_0x0075
            r0 = 78
            if (r4 == r0) goto L_0x005c
            r0 = 93
            if (r4 == r0) goto L_0x003c
            r0 = 43
            if (r4 == r0) goto L_0x001b
            r0 = 44
            if (r4 == r0) goto L_0x0045
            goto L_0x009a
        L_0x001b:
            int r4 = r3.f6214q
            int r0 = r3.f6215r
            if (r4 < r0) goto L_0x002c
            boolean r4 = r3.Y1()
            if (r4 != 0) goto L_0x002c
            c3.n r4 = c3.n.VALUE_NUMBER_INT
            r3.R0(r4)
        L_0x002c:
            char[] r4 = r3.V
            int r0 = r3.f6214q
            int r1 = r0 + 1
            r3.f6214q = r1
            char r4 = r4[r0]
            r0 = 0
            c3.n r4 = r3.U1(r4, r0)
            return r4
        L_0x003c:
            g3.c r0 = r3.f6222y
            boolean r0 = r0.f()
            if (r0 != 0) goto L_0x0045
            goto L_0x009a
        L_0x0045:
            g3.c r0 = r3.f6222y
            boolean r0 = r0.h()
            if (r0 != 0) goto L_0x009a
            int r0 = r3.f4739a
            int r2 = f6806m0
            r0 = r0 & r2
            if (r0 == 0) goto L_0x009a
            int r4 = r3.f6214q
            int r4 = r4 - r1
            r3.f6214q = r4
            c3.n r4 = c3.n.VALUE_NULL
            return r4
        L_0x005c:
            java.lang.String r0 = "NaN"
            r3.c2(r0, r1)
            int r1 = r3.f4739a
            int r2 = f6805l0
            r1 = r1 & r2
            if (r1 == 0) goto L_0x006f
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            c3.n r4 = r3.K1(r0, r1)
            return r4
        L_0x006f:
            java.lang.String r0 = "Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3.L0(r0)
            goto L_0x009a
        L_0x0075:
            java.lang.String r0 = "Infinity"
            r3.c2(r0, r1)
            int r1 = r3.f4739a
            int r2 = f6805l0
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0088
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            c3.n r4 = r3.K1(r0, r1)
            return r4
        L_0x0088:
            java.lang.String r0 = "Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3.L0(r0)
            goto L_0x009a
        L_0x008e:
            int r0 = r3.f4739a
            int r1 = f6807n0
            r0 = r0 & r1
            if (r0 == 0) goto L_0x009a
            c3.n r4 = r3.T1()
            return r4
        L_0x009a:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto L_0x00b9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            r0.append(r1)
            char r1 = (char) r4
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r3.z1()
            r3.r2(r0, r1)
        L_0x00b9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "expected a valid value "
            r0.append(r1)
            java.lang.String r1 = r3.A1()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.T0(r4, r0)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.f.X1(int):c3.n");
    }

    public final String Y() {
        n nVar = this.f6234c;
        if (nVar != n.VALUE_STRING) {
            return S1(nVar);
        }
        if (this.f6812f0) {
            this.f6812f0 = false;
            Q1();
        }
        return this.A.l();
    }

    public boolean Y1() {
        Reader reader = this.S;
        if (reader != null) {
            char[] cArr = this.V;
            int read = reader.read(cArr, 0, cArr.length);
            if (read > 0) {
                int i10 = this.f6215r;
                long j10 = (long) i10;
                this.f6216s += j10;
                this.f6218u -= i10;
                this.f6813g0 -= j10;
                this.f6214q = 0;
                this.f6215r = read;
                return true;
            }
            j1();
            if (read == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.f6215r);
            }
        }
        return false;
    }

    public final char[] Z() {
        n nVar = this.f6234c;
        if (nVar == null) {
            return null;
        }
        int c10 = nVar.c();
        if (c10 != 5) {
            if (c10 != 6) {
                if (!(c10 == 7 || c10 == 8)) {
                    return this.f6234c.a();
                }
            } else if (this.f6812f0) {
                this.f6812f0 = false;
                Q1();
            }
            return this.A.s();
        }
        if (!this.C) {
            String b10 = this.f6222y.b();
            int length = b10.length();
            char[] cArr = this.B;
            if (cArr == null) {
                this.B = this.f6212o.f(length);
            } else if (cArr.length < length) {
                this.B = new char[length];
            }
            b10.getChars(0, length, this.B, 0);
            this.C = true;
        }
        return this.B;
    }

    public final String Z0(String str) {
        n nVar = this.f6234c;
        if (nVar == n.VALUE_STRING) {
            if (this.f6812f0) {
                this.f6812f0 = false;
                Q1();
            }
            return this.A.l();
        } else if (nVar == n.FIELD_NAME) {
            return E();
        } else {
            return super.Z0(str);
        }
    }

    public void Z1() {
        if (!Y1()) {
            P0();
        }
    }

    public final int a0() {
        n nVar = this.f6234c;
        if (nVar == null) {
            return 0;
        }
        int c10 = nVar.c();
        if (c10 == 5) {
            return this.f6222y.b().length();
        }
        if (c10 != 6) {
            if (!(c10 == 7 || c10 == 8)) {
                return this.f6234c.a().length;
            }
        } else if (this.f6812f0) {
            this.f6812f0 = false;
            Q1();
        }
        return this.A.A();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a2() {
        /*
            r5 = this;
            int r0 = r5.f6214q
            int r1 = r0 + 4
            int r2 = r5.f6215r
            r3 = 1
            if (r1 >= r2) goto L_0x0038
            char[] r1 = r5.V
            char r2 = r1[r0]
            r4 = 97
            if (r2 != r4) goto L_0x0038
            int r0 = r0 + r3
            char r2 = r1[r0]
            r4 = 108(0x6c, float:1.51E-43)
            if (r2 != r4) goto L_0x0038
            int r0 = r0 + r3
            char r2 = r1[r0]
            r4 = 115(0x73, float:1.61E-43)
            if (r2 != r4) goto L_0x0038
            int r0 = r0 + r3
            char r2 = r1[r0]
            r4 = 101(0x65, float:1.42E-43)
            if (r2 != r4) goto L_0x0038
            int r0 = r0 + r3
            char r1 = r1[r0]
            r2 = 48
            if (r1 < r2) goto L_0x0035
            r2 = 93
            if (r1 == r2) goto L_0x0035
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 != r2) goto L_0x0038
        L_0x0035:
            r5.f6214q = r0
            return
        L_0x0038:
            java.lang.String r0 = "false"
            r5.c2(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.f.a2():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r0 != 8) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b0() {
        /*
            r3 = this;
            c3.n r0 = r3.f6234c
            r1 = 0
            if (r0 == 0) goto L_0x0024
            int r0 = r0.c()
            r2 = 6
            if (r0 == r2) goto L_0x0014
            r2 = 7
            if (r0 == r2) goto L_0x001d
            r2 = 8
            if (r0 == r2) goto L_0x001d
            goto L_0x0024
        L_0x0014:
            boolean r0 = r3.f6812f0
            if (r0 == 0) goto L_0x001d
            r3.f6812f0 = r1
            r3.Q1()
        L_0x001d:
            j3.o r0 = r3.A
            int r0 = r0.t()
            return r0
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.f.b0():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b2() {
        /*
            r5 = this;
            int r0 = r5.f6214q
            int r1 = r0 + 3
            int r2 = r5.f6215r
            r3 = 1
            if (r1 >= r2) goto L_0x002f
            char[] r1 = r5.V
            char r2 = r1[r0]
            r4 = 117(0x75, float:1.64E-43)
            if (r2 != r4) goto L_0x002f
            int r0 = r0 + r3
            char r2 = r1[r0]
            r4 = 108(0x6c, float:1.51E-43)
            if (r2 != r4) goto L_0x002f
            int r0 = r0 + r3
            char r2 = r1[r0]
            if (r2 != r4) goto L_0x002f
            int r0 = r0 + r3
            char r1 = r1[r0]
            r2 = 48
            if (r1 < r2) goto L_0x002c
            r2 = 93
            if (r1 == r2) goto L_0x002c
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 != r2) goto L_0x002f
        L_0x002c:
            r5.f6214q = r0
            return
        L_0x002f:
            java.lang.String r0 = "null"
            r5.c2(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.f.b2():void");
    }

    public c3.i c0() {
        if (this.f6234c == n.FIELD_NAME) {
            return new c3.i(o1(), -1, this.f6216s + (this.f6813g0 - 1), this.f6814h0, this.f6815i0);
        }
        return new c3.i(o1(), -1, this.f6219v - 1, this.f6220w, this.f6221x);
    }

    public final void c2(String str, int i10) {
        int i11;
        int length = str.length();
        if (this.f6214q + length >= this.f6215r) {
            d2(str, i10);
            return;
        }
        do {
            if (this.V[this.f6214q] != str.charAt(i10)) {
                q2(str.substring(0, i10));
            }
            i11 = this.f6214q + 1;
            this.f6214q = i11;
            i10++;
        } while (i10 < length);
        char c10 = this.V[i11];
        if (c10 >= '0' && c10 != ']' && c10 != '}') {
            N1(str, i10, c10);
        }
    }

    public final void d2(String str, int i10) {
        int i11;
        char c10;
        int length = str.length();
        do {
            if ((this.f6214q >= this.f6215r && !Y1()) || this.V[this.f6214q] != str.charAt(i10)) {
                q2(str.substring(0, i10));
            }
            i11 = this.f6214q + 1;
            this.f6214q = i11;
            i10++;
        } while (i10 < length);
        if ((i11 < this.f6215r || Y1()) && (c10 = this.V[this.f6214q]) >= '0' && c10 != ']' && c10 != '}') {
            N1(str, i10, c10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e2() {
        /*
            r5 = this;
            int r0 = r5.f6214q
            int r1 = r0 + 3
            int r2 = r5.f6215r
            r3 = 1
            if (r1 >= r2) goto L_0x0031
            char[] r1 = r5.V
            char r2 = r1[r0]
            r4 = 114(0x72, float:1.6E-43)
            if (r2 != r4) goto L_0x0031
            int r0 = r0 + r3
            char r2 = r1[r0]
            r4 = 117(0x75, float:1.64E-43)
            if (r2 != r4) goto L_0x0031
            int r0 = r0 + r3
            char r2 = r1[r0]
            r4 = 101(0x65, float:1.42E-43)
            if (r2 != r4) goto L_0x0031
            int r0 = r0 + r3
            char r1 = r1[r0]
            r2 = 48
            if (r1 < r2) goto L_0x002e
            r2 = 93
            if (r1 == r2) goto L_0x002e
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 != r2) goto L_0x0031
        L_0x002e:
            r5.f6214q = r0
            return
        L_0x0031:
            java.lang.String r0 = "true"
            r5.c2(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.f.e2():void");
    }

    public final n f2() {
        this.C = false;
        n nVar = this.f6223z;
        this.f6223z = null;
        if (nVar == n.START_ARRAY) {
            this.f6222y = this.f6222y.m(this.f6220w, this.f6221x);
        } else if (nVar == n.START_OBJECT) {
            this.f6222y = this.f6222y.n(this.f6220w, this.f6221x);
        }
        this.f6234c = nVar;
        return nVar;
    }

    public final String g0() {
        n nVar = this.f6234c;
        if (nVar == n.VALUE_STRING) {
            if (this.f6812f0) {
                this.f6812f0 = false;
                Q1();
            }
            return this.A.l();
        } else if (nVar == n.FIELD_NAME) {
            return E();
        } else {
            return super.Z0((String) null);
        }
    }

    public final n g2(int i10) {
        if (i10 == 34) {
            this.f6812f0 = true;
            n nVar = n.VALUE_STRING;
            this.f6234c = nVar;
            return nVar;
        } else if (i10 == 91) {
            this.f6222y = this.f6222y.m(this.f6220w, this.f6221x);
            n nVar2 = n.START_ARRAY;
            this.f6234c = nVar2;
            return nVar2;
        } else if (i10 == 102) {
            c2("false", 1);
            n nVar3 = n.VALUE_FALSE;
            this.f6234c = nVar3;
            return nVar3;
        } else if (i10 == 110) {
            c2("null", 1);
            n nVar4 = n.VALUE_NULL;
            this.f6234c = nVar4;
            return nVar4;
        } else if (i10 == 116) {
            c2("true", 1);
            n nVar5 = n.VALUE_TRUE;
            this.f6234c = nVar5;
            return nVar5;
        } else if (i10 != 123) {
            switch (i10) {
                case 44:
                    if (!this.f6222y.h() && (this.f4739a & f6806m0) != 0) {
                        this.f6214q--;
                        n nVar6 = n.VALUE_NULL;
                        this.f6234c = nVar6;
                        return nVar6;
                    }
                case 45:
                    n m22 = m2();
                    this.f6234c = m22;
                    return m22;
                case 46:
                    n j22 = j2();
                    this.f6234c = j22;
                    return j22;
                default:
                    switch (i10) {
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                            n o22 = o2(i10);
                            this.f6234c = o22;
                            return o22;
                    }
            }
            n X1 = X1(i10);
            this.f6234c = X1;
            return X1;
        } else {
            this.f6222y = this.f6222y.n(this.f6220w, this.f6221x);
            n nVar7 = n.START_OBJECT;
            this.f6234c = nVar7;
            return nVar7;
        }
    }

    public String h2() {
        int i10 = this.f6214q;
        int i11 = this.Z;
        int i12 = this.f6215r;
        if (i10 < i12) {
            int[] iArr = f6811r0;
            int length = iArr.length;
            do {
                char[] cArr = this.V;
                char c10 = cArr[i10];
                if (c10 != '\'') {
                    if (c10 < length && iArr[c10] != 0) {
                        break;
                    }
                    i11 = (i11 * 33) + c10;
                    i10++;
                } else {
                    int i13 = this.f6214q;
                    this.f6214q = i10 + 1;
                    return this.Y.k(cArr, i13, i10 - i13, i11);
                }
            } while (i10 < i12);
        }
        int i14 = this.f6214q;
        this.f6214q = i10;
        return l2(i14, i11, 39);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r9 == 'E') goto L_0x0037;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c3.n i2(int r9, int r10, int r11, boolean r12, int r13) {
        /*
            r8 = this;
            int r0 = r8.f6215r
            r1 = 46
            r2 = 57
            r3 = 48
            r4 = 0
            if (r9 != r1) goto L_0x002d
            r9 = 0
        L_0x000c:
            if (r11 < r0) goto L_0x0013
            c3.n r9 = r8.n2(r12, r10)
            return r9
        L_0x0013:
            char[] r1 = r8.V
            int r5 = r11 + 1
            char r11 = r1[r11]
            if (r11 < r3) goto L_0x0022
            if (r11 <= r2) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            int r9 = r9 + 1
            r11 = r5
            goto L_0x000c
        L_0x0022:
            if (r9 != 0) goto L_0x0029
            java.lang.String r1 = "Decimal point not followed by a digit"
            r8.h1(r11, r1)
        L_0x0029:
            r7 = r11
            r11 = r9
            r9 = r7
            goto L_0x002f
        L_0x002d:
            r5 = r11
            r11 = 0
        L_0x002f:
            r1 = 101(0x65, float:1.42E-43)
            if (r9 == r1) goto L_0x0037
            r1 = 69
            if (r9 != r1) goto L_0x007c
        L_0x0037:
            if (r5 < r0) goto L_0x0040
            r8.f6214q = r10
            c3.n r9 = r8.n2(r12, r10)
            return r9
        L_0x0040:
            char[] r9 = r8.V
            int r1 = r5 + 1
            char r5 = r9[r5]
            r6 = 45
            if (r5 == r6) goto L_0x0052
            r6 = 43
            if (r5 != r6) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r9 = r5
        L_0x0050:
            r5 = r1
            goto L_0x005f
        L_0x0052:
            if (r1 < r0) goto L_0x005b
            r8.f6214q = r10
            c3.n r9 = r8.n2(r12, r10)
            return r9
        L_0x005b:
            int r5 = r1 + 1
            char r9 = r9[r1]
        L_0x005f:
            if (r9 > r2) goto L_0x0075
            if (r9 < r3) goto L_0x0075
            int r4 = r4 + 1
            if (r5 < r0) goto L_0x006e
            r8.f6214q = r10
            c3.n r9 = r8.n2(r12, r10)
            return r9
        L_0x006e:
            char[] r9 = r8.V
            int r1 = r5 + 1
            char r9 = r9[r5]
            goto L_0x0050
        L_0x0075:
            if (r4 != 0) goto L_0x007c
            java.lang.String r0 = "Exponent indicator not followed by a digit"
            r8.h1(r9, r0)
        L_0x007c:
            int r5 = r5 + -1
            r8.f6214q = r5
            g3.c r0 = r8.f6222y
            boolean r0 = r0.h()
            if (r0 == 0) goto L_0x008b
            r8.I2(r9)
        L_0x008b:
            int r5 = r5 - r10
            j3.o r9 = r8.A
            char[] r0 = r8.V
            r9.w(r0, r10, r5)
            c3.n r9 = r8.L1(r12, r13, r11, r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.f.i2(int, int, int, boolean, int):c3.n");
    }

    public void j1() {
        if (this.S != null) {
            if (this.f6212o.k() || l0(k.a.AUTO_CLOSE_SOURCE)) {
                this.S.close();
            }
            this.S = null;
        }
    }

    public final n j2() {
        if (!l0(d.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.c())) {
            return X1(46);
        }
        int i10 = this.f6214q;
        return i2(46, i10 - 1, i10, false, 0);
    }

    public final String k2() {
        int i10 = this.f6214q;
        int i11 = this.Z;
        int[] iArr = f6811r0;
        while (true) {
            if (i10 >= this.f6215r) {
                break;
            }
            char[] cArr = this.V;
            char c10 = cArr[i10];
            if (c10 >= iArr.length || iArr[c10] == 0) {
                i11 = (i11 * 33) + c10;
                i10++;
            } else if (c10 == '\"') {
                int i12 = this.f6214q;
                this.f6214q = i10 + 1;
                return this.Y.k(cArr, i12, i10 - i12, i11);
            }
        }
        int i13 = this.f6214q;
        this.f6214q = i10;
        return l2(i13, i11, 34);
    }

    public char l1() {
        if (this.f6214q >= this.f6215r && !Y1()) {
            Q0(" in character escape sequence", n.VALUE_STRING);
        }
        char[] cArr = this.V;
        int i10 = this.f6214q;
        this.f6214q = i10 + 1;
        char c10 = cArr[i10];
        if (c10 == '\"' || c10 == '/' || c10 == '\\') {
            return c10;
        }
        if (c10 == 'b') {
            return 8;
        }
        if (c10 == 'f') {
            return 12;
        }
        if (c10 == 'n') {
            return 10;
        }
        if (c10 == 'r') {
            return ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN;
        }
        if (c10 == 't') {
            return 9;
        }
        if (c10 != 'u') {
            return q1(c10);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            if (this.f6214q >= this.f6215r && !Y1()) {
                Q0(" in character escape sequence", n.VALUE_STRING);
            }
            char[] cArr2 = this.V;
            int i13 = this.f6214q;
            this.f6214q = i13 + 1;
            char c11 = cArr2[i13];
            int b10 = a.b(c11);
            if (b10 < 0) {
                T0(c11, "expected a hex-digit for character escape sequence");
            }
            i11 = (i11 << 4) | b10;
        }
        return (char) i11;
    }

    public final String l2(int i10, int i11, int i12) {
        this.A.w(this.V, i10, this.f6214q - i10);
        char[] q10 = this.A.q();
        int r10 = this.A.r();
        while (true) {
            if (this.f6214q >= this.f6215r && !Y1()) {
                Q0(" in field name", n.FIELD_NAME);
            }
            char[] cArr = this.V;
            int i13 = this.f6214q;
            this.f6214q = i13 + 1;
            char c10 = cArr[i13];
            if (c10 <= '\\') {
                if (c10 == '\\') {
                    c10 = l1();
                } else if (c10 <= i12) {
                    if (c10 == i12) {
                        this.A.z(r10);
                        j3.o oVar = this.A;
                        return this.Y.k(oVar.s(), oVar.t(), oVar.A(), i11);
                    } else if (c10 < ' ') {
                        y1(c10, "name");
                    }
                }
            }
            i11 = (i11 * 33) + c10;
            int i14 = r10 + 1;
            q10[r10] = c10;
            if (i14 >= q10.length) {
                q10 = this.A.o();
                r10 = 0;
            } else {
                r10 = i14;
            }
        }
    }

    public final n m2() {
        int i10 = this.f6214q;
        int i11 = i10 - 1;
        int i12 = this.f6215r;
        if (i10 >= i12) {
            return n2(true, i11);
        }
        int i13 = i10 + 1;
        char c10 = this.V[i10];
        if (c10 > '9' || c10 < '0') {
            this.f6214q = i13;
            return U1(c10, true);
        } else if (c10 == '0') {
            return n2(true, i11);
        } else {
            int i14 = 1;
            while (i13 < i12) {
                int i15 = i13 + 1;
                char c11 = this.V[i13];
                if (c11 >= '0' && c11 <= '9') {
                    i14++;
                    i13 = i15;
                } else if (c11 == '.' || c11 == 'e' || c11 == 'E') {
                    this.f6214q = i15;
                    return i2(c11, i11, i15, true, i14);
                } else {
                    int i16 = i15 - 1;
                    this.f6214q = i16;
                    if (this.f6222y.h()) {
                        I2(c11);
                    }
                    this.A.w(this.V, i11, i16 - i11);
                    return M1(true, i14);
                }
            }
            return n2(true, i11);
        }
    }

    public final n n2(boolean z10, int i10) {
        int i11;
        char c10;
        boolean z11;
        int i12;
        char c11;
        char J2;
        int i13;
        if (z10) {
            i10++;
        }
        this.f6214q = i10;
        char[] m10 = this.A.m();
        int i14 = 0;
        if (z10) {
            m10[0] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i15 = this.f6214q;
        if (i15 < this.f6215r) {
            char[] cArr = this.V;
            this.f6214q = i15 + 1;
            c10 = cArr[i15];
        } else {
            c10 = K2("No digit following minus sign", n.VALUE_NUMBER_INT);
        }
        if (c10 == '0') {
            c10 = H2();
        }
        int i16 = 0;
        while (true) {
            if (c10 >= '0' && c10 <= '9') {
                i16++;
                if (i11 >= m10.length) {
                    m10 = this.A.o();
                    i11 = 0;
                }
                int i17 = i11 + 1;
                m10[i11] = c10;
                if (this.f6214q >= this.f6215r && !Y1()) {
                    i11 = i17;
                    c10 = 0;
                    z11 = true;
                    break;
                }
                char[] cArr2 = this.V;
                int i18 = this.f6214q;
                this.f6214q = i18 + 1;
                c10 = cArr2[i18];
                i11 = i17;
            } else {
                z11 = false;
            }
        }
        z11 = false;
        if (i16 == 0) {
            return U1(c10, z10);
        }
        if (c10 == '.') {
            if (i11 >= m10.length) {
                m10 = this.A.o();
                i11 = 0;
            }
            m10[i11] = c10;
            int i19 = i11 + 1;
            i12 = 0;
            while (true) {
                if (this.f6214q >= this.f6215r && !Y1()) {
                    z11 = true;
                    break;
                }
                char[] cArr3 = this.V;
                int i20 = this.f6214q;
                this.f6214q = i20 + 1;
                c10 = cArr3[i20];
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                i12++;
                if (i11 >= m10.length) {
                    m10 = this.A.o();
                    i11 = 0;
                }
                m10[i11] = c10;
                i19 = i11 + 1;
            }
            if (i12 == 0) {
                h1(c10, "Decimal point not followed by a digit");
            }
        } else {
            i12 = 0;
        }
        if (c10 == 'e' || c10 == 'E') {
            if (i11 >= m10.length) {
                m10 = this.A.o();
                i11 = 0;
            }
            int i21 = i11 + 1;
            m10[i11] = c10;
            int i22 = this.f6214q;
            if (i22 < this.f6215r) {
                char[] cArr4 = this.V;
                this.f6214q = i22 + 1;
                c11 = cArr4[i22];
            } else {
                c11 = J2("expected a digit for number exponent");
            }
            if (c11 == '-' || c11 == '+') {
                if (i21 >= m10.length) {
                    m10 = this.A.o();
                    i21 = 0;
                }
                int i23 = i21 + 1;
                m10[i21] = c11;
                int i24 = this.f6214q;
                if (i24 < this.f6215r) {
                    char[] cArr5 = this.V;
                    this.f6214q = i24 + 1;
                    J2 = cArr5[i24];
                } else {
                    J2 = J2("expected a digit for number exponent");
                }
                i21 = i23;
            }
            char c12 = c11;
            int i25 = 0;
            while (true) {
                if (c10 <= '9' && c10 >= '0') {
                    i25++;
                    if (i21 >= m10.length) {
                        m10 = this.A.o();
                        i21 = 0;
                    }
                    i13 = i21 + 1;
                    m10[i21] = c10;
                    if (this.f6214q >= this.f6215r && !Y1()) {
                        i14 = i25;
                        z11 = true;
                        break;
                    }
                    char[] cArr6 = this.V;
                    int i26 = this.f6214q;
                    this.f6214q = i26 + 1;
                    c12 = cArr6[i26];
                    i21 = i13;
                } else {
                    i14 = i25;
                    i13 = i21;
                }
            }
            i14 = i25;
            i13 = i21;
            if (i14 == 0) {
                h1(c10, "Exponent indicator not followed by a digit");
            }
        }
        if (!z11) {
            this.f6214q--;
            if (this.f6222y.h()) {
                I2(c10);
            }
        }
        this.A.z(i11);
        return J1(z10, i16, i12, i14);
    }

    public final n o2(int i10) {
        int i11 = this.f6214q;
        int i12 = i11 - 1;
        int i13 = this.f6215r;
        if (i10 == 48) {
            return n2(false, i12);
        }
        int i14 = 1;
        while (i11 < i13) {
            int i15 = i11 + 1;
            char c10 = this.V[i11];
            if (c10 >= '0' && c10 <= '9') {
                i14++;
                i11 = i15;
            } else if (c10 == '.' || c10 == 'e' || c10 == 'E') {
                this.f6214q = i15;
                return i2(c10, i12, i15, false, i14);
            } else {
                int i16 = i15 - 1;
                this.f6214q = i16;
                if (this.f6222y.h()) {
                    I2(c10);
                }
                this.A.w(this.V, i12, i16 - i12);
                return M1(false, i14);
            }
        }
        this.f6214q = i12;
        return n2(false, i12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        if (r10 < 0) goto L_0x015f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int p2(c3.a r17, java.io.OutputStream r18, byte[] r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            int r4 = r3.length
            r5 = 3
            int r4 = r4 - r5
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x000e:
            int r9 = r0.f6214q
            int r10 = r0.f6215r
            if (r9 < r10) goto L_0x0017
            r16.Z1()
        L_0x0017:
            char[] r9 = r0.V
            int r10 = r0.f6214q
            int r11 = r10 + 1
            r0.f6214q = r11
            char r9 = r9[r10]
            r10 = 32
            if (r9 <= r10) goto L_0x015f
            int r10 = r1.g(r9)
            r11 = 34
            if (r10 >= 0) goto L_0x0039
            if (r9 != r11) goto L_0x0031
            goto L_0x0124
        L_0x0031:
            int r10 = r0.k1(r1, r9, r6)
            if (r10 >= 0) goto L_0x0039
            goto L_0x015f
        L_0x0039:
            if (r7 <= r4) goto L_0x0040
            int r8 = r8 + r7
            r2.write(r3, r6, r7)
            r7 = 0
        L_0x0040:
            int r9 = r0.f6214q
            int r12 = r0.f6215r
            if (r9 < r12) goto L_0x0049
            r16.Z1()
        L_0x0049:
            char[] r9 = r0.V
            int r12 = r0.f6214q
            int r13 = r12 + 1
            r0.f6214q = r13
            char r9 = r9[r12]
            int r12 = r1.g(r9)
            r13 = 1
            if (r12 >= 0) goto L_0x005e
            int r12 = r0.k1(r1, r9, r13)
        L_0x005e:
            int r9 = r10 << 6
            r9 = r9 | r12
            int r10 = r0.f6214q
            int r12 = r0.f6215r
            if (r10 < r12) goto L_0x006a
            r16.Z1()
        L_0x006a:
            char[] r10 = r0.V
            int r12 = r0.f6214q
            int r14 = r12 + 1
            r0.f6214q = r14
            char r10 = r10[r12]
            int r12 = r1.g(r10)
            r14 = 2
            r15 = -2
            if (r12 >= 0) goto L_0x00e8
            if (r12 == r15) goto L_0x009d
            if (r10 != r11) goto L_0x0098
            int r4 = r9 >> 4
            int r5 = r7 + 1
            byte r4 = (byte) r4
            r3[r7] = r4
            boolean r4 = r17.v()
            if (r4 == 0) goto L_0x0095
            int r4 = r0.f6214q
            int r4 = r4 - r13
            r0.f6214q = r4
            r16.p1(r17)
        L_0x0095:
            r7 = r5
            goto L_0x0124
        L_0x0098:
            int r10 = r0.k1(r1, r10, r14)
            r12 = r10
        L_0x009d:
            if (r12 != r15) goto L_0x00e8
            int r10 = r0.f6214q
            int r11 = r0.f6215r
            if (r10 < r11) goto L_0x00a8
            r16.Z1()
        L_0x00a8:
            char[] r10 = r0.V
            int r11 = r0.f6214q
            int r12 = r11 + 1
            r0.f6214q = r12
            char r10 = r10[r11]
            boolean r11 = r1.w(r10)
            if (r11 != 0) goto L_0x00de
            int r11 = r0.k1(r1, r10, r5)
            if (r11 != r15) goto L_0x00bf
            goto L_0x00de
        L_0x00bf:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "expected padding character '"
            r2.append(r3)
            char r3 = r17.r()
            r2.append(r3)
            java.lang.String r3 = "'"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.IllegalArgumentException r1 = r0.I1(r1, r10, r5, r2)
            throw r1
        L_0x00de:
            int r9 = r9 >> 4
            int r10 = r7 + 1
            byte r9 = (byte) r9
            r3[r7] = r9
            r7 = r10
            goto L_0x000e
        L_0x00e8:
            int r9 = r9 << 6
            r9 = r9 | r12
            int r10 = r0.f6214q
            int r12 = r0.f6215r
            if (r10 < r12) goto L_0x00f4
            r16.Z1()
        L_0x00f4:
            char[] r10 = r0.V
            int r12 = r0.f6214q
            int r5 = r12 + 1
            r0.f6214q = r5
            char r5 = r10[r12]
            int r10 = r1.g(r5)
            if (r10 >= 0) goto L_0x0146
            if (r10 == r15) goto L_0x0134
            if (r5 != r11) goto L_0x012d
            int r4 = r9 >> 2
            int r5 = r7 + 1
            int r9 = r4 >> 8
            byte r9 = (byte) r9
            r3[r7] = r9
            int r7 = r5 + 1
            byte r4 = (byte) r4
            r3[r5] = r4
            boolean r4 = r17.v()
            if (r4 == 0) goto L_0x0124
            int r4 = r0.f6214q
            int r4 = r4 - r13
            r0.f6214q = r4
            r16.p1(r17)
        L_0x0124:
            r0.f6812f0 = r6
            if (r7 <= 0) goto L_0x012c
            int r8 = r8 + r7
            r2.write(r3, r6, r7)
        L_0x012c:
            return r8
        L_0x012d:
            r11 = 3
            int r5 = r0.k1(r1, r5, r11)
            r10 = r5
            goto L_0x0135
        L_0x0134:
            r11 = 3
        L_0x0135:
            if (r10 != r15) goto L_0x0147
            int r5 = r9 >> 2
            int r9 = r7 + 1
            int r10 = r5 >> 8
            byte r10 = (byte) r10
            r3[r7] = r10
            int r7 = r9 + 1
            byte r5 = (byte) r5
            r3[r9] = r5
            goto L_0x0160
        L_0x0146:
            r11 = 3
        L_0x0147:
            int r5 = r9 << 6
            r5 = r5 | r10
            int r9 = r7 + 1
            int r10 = r5 >> 16
            byte r10 = (byte) r10
            r3[r7] = r10
            int r7 = r9 + 1
            int r10 = r5 >> 8
            byte r10 = (byte) r10
            r3[r9] = r10
            int r9 = r7 + 1
            byte r5 = (byte) r5
            r3[r7] = r5
            r7 = r9
            goto L_0x0160
        L_0x015f:
            r11 = 3
        L_0x0160:
            r5 = 3
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.f.p2(c3.a, java.io.OutputStream, byte[]):int");
    }

    public String q0() {
        String str;
        n nVar;
        this.F = 0;
        n nVar2 = this.f6234c;
        n nVar3 = n.FIELD_NAME;
        if (nVar2 == nVar3) {
            f2();
            return null;
        }
        if (this.f6812f0) {
            A2();
        }
        int B2 = B2();
        if (B2 < 0) {
            close();
            this.f6234c = null;
            return null;
        }
        this.E = null;
        if (B2 == 93 || B2 == 125) {
            O1(B2);
            return null;
        }
        if (this.f6222y.p()) {
            B2 = x2(B2);
            if ((this.f4739a & f6803j0) != 0 && (B2 == 93 || B2 == 125)) {
                O1(B2);
                return null;
            }
        }
        if (!this.f6222y.g()) {
            E2();
            g2(B2);
            return null;
        }
        F2();
        if (B2 == 34) {
            str = k2();
        } else {
            str = V1(B2);
        }
        this.f6222y.u(str);
        this.f6234c = nVar3;
        int v22 = v2();
        E2();
        if (v22 == 34) {
            this.f6812f0 = true;
            this.f6223z = n.VALUE_STRING;
            return str;
        }
        if (v22 == 45) {
            nVar = m2();
        } else if (v22 == 46) {
            nVar = j2();
        } else if (v22 == 91) {
            nVar = n.START_ARRAY;
        } else if (v22 == 102) {
            a2();
            nVar = n.VALUE_FALSE;
        } else if (v22 == 110) {
            b2();
            nVar = n.VALUE_NULL;
        } else if (v22 == 116) {
            e2();
            nVar = n.VALUE_TRUE;
        } else if (v22 != 123) {
            switch (v22) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    nVar = o2(v22);
                    break;
                default:
                    nVar = X1(v22);
                    break;
            }
        } else {
            nVar = n.START_OBJECT;
        }
        this.f6223z = nVar;
        return str;
    }

    public void q2(String str) {
        r2(str, z1());
    }

    public final String r0() {
        if (this.f6234c == n.FIELD_NAME) {
            this.C = false;
            n nVar = this.f6223z;
            this.f6223z = null;
            this.f6234c = nVar;
            if (nVar == n.VALUE_STRING) {
                if (this.f6812f0) {
                    this.f6812f0 = false;
                    Q1();
                }
                return this.A.l();
            }
            if (nVar == n.START_ARRAY) {
                this.f6222y = this.f6222y.m(this.f6220w, this.f6221x);
            } else if (nVar == n.START_OBJECT) {
                this.f6222y = this.f6222y.n(this.f6220w, this.f6221x);
            }
            return null;
        } else if (s0() == n.VALUE_STRING) {
            return Y();
        } else {
            return null;
        }
    }

    public void r2(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.f6214q >= this.f6215r && !Y1()) {
                break;
            }
            char c10 = this.V[this.f6214q];
            if (Character.isJavaIdentifierPart(c10)) {
                this.f6214q++;
                sb.append(c10);
                if (sb.length() >= 256) {
                    sb.append("...");
                    break;
                }
            } else {
                break;
            }
        }
        N0("Unrecognized token '%s': was expecting %s", sb, str2);
    }

    public final n s0() {
        n nVar;
        String str;
        n nVar2 = this.f6234c;
        n nVar3 = n.FIELD_NAME;
        if (nVar2 == nVar3) {
            return f2();
        }
        this.F = 0;
        if (this.f6812f0) {
            A2();
        }
        int B2 = B2();
        if (B2 < 0) {
            close();
            this.f6234c = null;
            return null;
        }
        this.E = null;
        if (B2 == 93 || B2 == 125) {
            O1(B2);
            return this.f6234c;
        }
        if (this.f6222y.p()) {
            B2 = x2(B2);
            if ((this.f4739a & f6803j0) != 0 && (B2 == 93 || B2 == 125)) {
                O1(B2);
                return this.f6234c;
            }
        }
        boolean g10 = this.f6222y.g();
        if (g10) {
            F2();
            if (B2 == 34) {
                str = k2();
            } else {
                str = V1(B2);
            }
            this.f6222y.u(str);
            this.f6234c = nVar3;
            B2 = v2();
        }
        E2();
        if (B2 == 34) {
            this.f6812f0 = true;
            nVar = n.VALUE_STRING;
        } else if (B2 == 91) {
            if (!g10) {
                this.f6222y = this.f6222y.m(this.f6220w, this.f6221x);
            }
            nVar = n.START_ARRAY;
        } else if (B2 == 102) {
            a2();
            nVar = n.VALUE_FALSE;
        } else if (B2 != 110) {
            if (B2 != 116) {
                if (B2 == 123) {
                    if (!g10) {
                        this.f6222y = this.f6222y.n(this.f6220w, this.f6221x);
                    }
                    nVar = n.START_OBJECT;
                } else if (B2 == 125) {
                    T0(B2, "expected a value");
                } else if (B2 == 45) {
                    nVar = m2();
                } else if (B2 != 46) {
                    switch (B2) {
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                            nVar = o2(B2);
                            break;
                        default:
                            nVar = X1(B2);
                            break;
                    }
                } else {
                    nVar = j2();
                }
            }
            e2();
            nVar = n.VALUE_TRUE;
        } else {
            b2();
            nVar = n.VALUE_NULL;
        }
        if (g10) {
            this.f6223z = nVar;
            return this.f6234c;
        }
        this.f6234c = nVar;
        return nVar;
    }

    public final int s2() {
        char c10;
        while (true) {
            if (this.f6214q < this.f6215r || Y1()) {
                char[] cArr = this.V;
                int i10 = this.f6214q;
                int i11 = i10 + 1;
                this.f6214q = i11;
                c10 = cArr[i10];
                if (c10 > ' ') {
                    if (c10 == '/') {
                        y2();
                    } else if (c10 != '#' || !D2()) {
                        return c10;
                    }
                } else if (c10 < ' ') {
                    if (c10 == 10) {
                        this.f6217t++;
                        this.f6218u = i11;
                    } else if (c10 == 13) {
                        u2();
                    } else if (c10 != 9) {
                        V0(c10);
                    }
                }
            } else {
                throw b("Unexpected end-of-input within/between " + this.f6222y.j() + " entries");
            }
        }
        return c10;
    }

    public final void t2() {
        while (true) {
            if (this.f6214q >= this.f6215r && !Y1()) {
                break;
            }
            char[] cArr = this.V;
            int i10 = this.f6214q;
            int i11 = i10 + 1;
            this.f6214q = i11;
            char c10 = cArr[i10];
            if (c10 <= '*') {
                if (c10 == '*') {
                    if (i11 >= this.f6215r && !Y1()) {
                        break;
                    }
                    char[] cArr2 = this.V;
                    int i12 = this.f6214q;
                    if (cArr2[i12] == '/') {
                        this.f6214q = i12 + 1;
                        return;
                    }
                } else if (c10 < ' ') {
                    if (c10 == 10) {
                        this.f6217t++;
                        this.f6218u = i11;
                    } else if (c10 == 13) {
                        u2();
                    } else if (c10 != 9) {
                        V0(c10);
                    }
                }
            }
        }
        Q0(" in a comment", (n) null);
    }

    public final void u2() {
        if (this.f6214q < this.f6215r || Y1()) {
            char[] cArr = this.V;
            int i10 = this.f6214q;
            if (cArr[i10] == 10) {
                this.f6214q = i10 + 1;
            }
        }
        this.f6217t++;
        this.f6218u = this.f6214q;
    }

    public byte[] v(c3.a aVar) {
        byte[] bArr;
        n nVar = this.f6234c;
        if (nVar == n.VALUE_EMBEDDED_OBJECT && (bArr = this.E) != null) {
            return bArr;
        }
        if (nVar != n.VALUE_STRING) {
            L0("Current token (" + this.f6234c + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.f6812f0) {
            try {
                this.E = P1(aVar);
                this.f6812f0 = false;
            } catch (IllegalArgumentException e10) {
                throw b("Failed to decode VALUE_STRING as base64 (" + aVar + "): " + e10.getMessage());
            }
        } else if (this.E == null) {
            j3.c n12 = n1();
            F0(Y(), n12, aVar);
            this.E = n12.v();
        }
        return this.E;
    }

    public void v1() {
        char[] cArr;
        super.v1();
        this.Y.q();
        if (this.W && (cArr = this.V) != null) {
            this.V = null;
            this.f6212o.o(cArr);
        }
    }

    public final int v2() {
        int i10 = this.f6214q;
        if (i10 + 4 >= this.f6215r) {
            return w2(false);
        }
        char[] cArr = this.V;
        char c10 = cArr[i10];
        if (c10 == ':') {
            int i11 = i10 + 1;
            this.f6214q = i11;
            char c11 = cArr[i11];
            if (c11 <= ' ') {
                if (c11 == ' ' || c11 == 9) {
                    int i12 = i11 + 1;
                    this.f6214q = i12;
                    char c12 = cArr[i12];
                    if (c12 > ' ') {
                        if (c12 == '/' || c12 == '#') {
                            return w2(true);
                        }
                        this.f6214q = i12 + 1;
                        return c12;
                    }
                }
                return w2(true);
            } else if (c11 == '/' || c11 == '#') {
                return w2(true);
            } else {
                this.f6214q = i11 + 1;
                return c11;
            }
        } else {
            if (c10 == ' ' || c10 == 9) {
                int i13 = i10 + 1;
                this.f6214q = i13;
                c10 = cArr[i13];
            }
            if (c10 != ':') {
                return w2(false);
            }
            int i14 = this.f6214q + 1;
            this.f6214q = i14;
            char c13 = cArr[i14];
            if (c13 <= ' ') {
                if (c13 == ' ' || c13 == 9) {
                    int i15 = i14 + 1;
                    this.f6214q = i15;
                    char c14 = cArr[i15];
                    if (c14 > ' ') {
                        if (c14 == '/' || c14 == '#') {
                            return w2(true);
                        }
                        this.f6214q = i15 + 1;
                        return c14;
                    }
                }
                return w2(true);
            } else if (c13 == '/' || c13 == '#') {
                return w2(true);
            } else {
                this.f6214q = i14 + 1;
                return c13;
            }
        }
    }

    public int w0(c3.a aVar, OutputStream outputStream) {
        if (!this.f6812f0 || this.f6234c != n.VALUE_STRING) {
            byte[] v10 = v(aVar);
            outputStream.write(v10);
            return v10.length;
        }
        byte[] d10 = this.f6212o.d();
        try {
            return p2(aVar, outputStream, d10);
        } finally {
            this.f6212o.l(d10);
        }
    }

    public final int w2(boolean z10) {
        while (true) {
            if (this.f6214q < this.f6215r || Y1()) {
                char[] cArr = this.V;
                int i10 = this.f6214q;
                int i11 = i10 + 1;
                this.f6214q = i11;
                char c10 = cArr[i10];
                if (c10 > ' ') {
                    if (c10 == '/') {
                        y2();
                    } else if (c10 != '#' || !D2()) {
                        if (z10) {
                            return c10;
                        }
                        if (c10 != ':') {
                            T0(c10, "was expecting a colon to separate field name and value");
                        }
                        z10 = true;
                    }
                } else if (c10 < ' ') {
                    if (c10 == 10) {
                        this.f6217t++;
                        this.f6218u = i11;
                    } else if (c10 == 13) {
                        u2();
                    } else if (c10 != 9) {
                        V0(c10);
                    }
                }
            } else {
                Q0(" within/between " + this.f6222y.j() + " entries", (n) null);
                return -1;
            }
        }
    }

    public final int x2(int i10) {
        if (i10 != 44) {
            T0(i10, "was expecting comma to separate " + this.f6222y.j() + " entries");
        }
        while (true) {
            int i11 = this.f6214q;
            if (i11 >= this.f6215r) {
                return s2();
            }
            char[] cArr = this.V;
            int i12 = i11 + 1;
            this.f6214q = i12;
            char c10 = cArr[i11];
            if (c10 > ' ') {
                if (c10 != '/' && c10 != '#') {
                    return c10;
                }
                this.f6214q = i12 - 1;
                return s2();
            } else if (c10 < ' ') {
                if (c10 == 10) {
                    this.f6217t++;
                    this.f6218u = i12;
                } else if (c10 == 13) {
                    u2();
                } else if (c10 != 9) {
                    V0(c10);
                }
            }
        }
    }

    public o y() {
        return this.X;
    }

    public final void y2() {
        if ((this.f4739a & f6809p0) == 0) {
            T0(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f6214q >= this.f6215r && !Y1()) {
            Q0(" in a comment", (n) null);
        }
        char[] cArr = this.V;
        int i10 = this.f6214q;
        this.f6214q = i10 + 1;
        char c10 = cArr[i10];
        if (c10 == '/') {
            z2();
        } else if (c10 == '*') {
            t2();
        } else {
            T0(c10, "was expecting either '*' or '/' for a comment");
        }
    }

    public c3.i z() {
        return new c3.i(o1(), -1, this.f6216s + ((long) this.f6214q), this.f6217t, (this.f6214q - this.f6218u) + 1);
    }

    public final void z2() {
        while (true) {
            if (this.f6214q < this.f6215r || Y1()) {
                char[] cArr = this.V;
                int i10 = this.f6214q;
                int i11 = i10 + 1;
                this.f6214q = i11;
                char c10 = cArr[i10];
                if (c10 < ' ') {
                    if (c10 == 10) {
                        this.f6217t++;
                        this.f6218u = i11;
                        return;
                    } else if (c10 == 13) {
                        u2();
                        return;
                    } else if (c10 != 9) {
                        V0(c10);
                    }
                }
            } else {
                return;
            }
        }
    }
}
