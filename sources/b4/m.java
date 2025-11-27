package b4;

import a4.h;
import c4.o;
import com.fasterxml.jackson.databind.ser.std.a;
import java.lang.reflect.Type;
import k3.b0;
import k3.c0;
import k3.j;
import u3.d;
import u3.f;

public class m extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final j f4370d = o.I().N(String.class);

    /* renamed from: e  reason: collision with root package name */
    public static final m f4371e = new m();

    /* renamed from: c  reason: collision with root package name */
    public final k3.o f4372c;

    public m() {
        super(String[].class);
        this.f4372c = null;
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        visitArrayFormat(fVar, jVar, d.STRING);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o b(k3.c0 r5, k3.d r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0018
            k3.b r1 = r5.W()
            r3.i r2 = r6.d()
            if (r2 == 0) goto L_0x0018
            java.lang.Object r1 = r1.g(r2)
            if (r1 == 0) goto L_0x0018
            k3.o r1 = r5.t0(r2, r1)
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            java.lang.Class<java.lang.String[]> r2 = java.lang.String[].class
            b3.k$a r3 = b3.k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r2 = r4.findFormatFeature(r5, r6, r2, r3)
            if (r1 != 0) goto L_0x0025
            k3.o r1 = r4.f4372c
        L_0x0025:
            k3.o r1 = r4.findContextualConvertingSerializer(r5, r6, r1)
            if (r1 != 0) goto L_0x0031
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            k3.o r1 = r5.G(r1, r6)
        L_0x0031:
            boolean r5 = r4.isDefaultSerializer(r1)
            if (r5 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r0 = r1
        L_0x0039:
            k3.o r5 = r4.f4372c
            if (r0 != r5) goto L_0x0046
            java.lang.Boolean r5 = r4.f5728b
            boolean r5 = java.util.Objects.equals(r2, r5)
            if (r5 == 0) goto L_0x0046
            return r4
        L_0x0046:
            b4.m r5 = new b4.m
            r5.<init>(r4, r6, r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.m.b(k3.c0, k3.d):k3.o");
    }

    public h c(w3.h hVar) {
        return this;
    }

    public k3.o f(k3.d dVar, Boolean bool) {
        return new m(this, dVar, this.f4372c, bool);
    }

    public k3.m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("array", true).G("items", createSchemaNode("string"));
    }

    /* renamed from: h */
    public boolean isEmpty(c0 c0Var, String[] strArr) {
        if (strArr.length == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public final void serialize(String[] strArr, c3.h hVar, c0 c0Var) {
        int length = strArr.length;
        if (length != 1 || ((this.f5728b != null || !c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5728b != Boolean.TRUE)) {
            hVar.u0(strArr, length);
            g(strArr, hVar, c0Var);
            hVar.V();
            return;
        }
        g(strArr, hVar, c0Var);
    }

    /* renamed from: j */
    public void g(String[] strArr, c3.h hVar, c0 c0Var) {
        if (r0 != 0) {
            k3.o oVar = this.f4372c;
            if (oVar != null) {
                k(strArr, hVar, c0Var, oVar);
                return;
            }
            for (String str : strArr) {
                if (str == null) {
                    hVar.a0();
                } else {
                    hVar.z0(str);
                }
            }
        }
    }

    public final void k(String[] strArr, c3.h hVar, c0 c0Var, k3.o oVar) {
        for (String str : strArr) {
            if (str == null) {
                c0Var.E(hVar);
            } else {
                oVar.serialize(str, hVar, c0Var);
            }
        }
    }

    public m(m mVar, k3.d dVar, k3.o oVar, Boolean bool) {
        super(mVar, dVar, bool);
        this.f4372c = oVar;
    }
}
