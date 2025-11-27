package r3;

import d4.h;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import k3.b;

public abstract class u {

    /* renamed from: b  reason: collision with root package name */
    public static final p[] f9169b = new p[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Annotation[] f9170c = new Annotation[0];

    /* renamed from: a  reason: collision with root package name */
    public final b f9171a;

    public u(b bVar) {
        this.f9171a = bVar;
    }

    public static p a() {
        return new p();
    }

    public static p[] b(int i10) {
        if (i10 == 0) {
            return f9169b;
        }
        p[] pVarArr = new p[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            pVarArr[i11] = a();
        }
        return pVarArr;
    }

    public static final boolean c(Annotation annotation) {
        if ((annotation instanceof Target) || (annotation instanceof Retention)) {
            return true;
        }
        return false;
    }

    public final o d(o oVar, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            oVar = oVar.a(annotation);
            if (this.f9171a.q0(annotation)) {
                oVar = h(oVar, annotation);
            }
        }
        return oVar;
    }

    public final o e(Annotation[] annotationArr) {
        o e10 = o.e();
        for (Annotation annotation : annotationArr) {
            e10 = e10.a(annotation);
            if (this.f9171a.q0(annotation)) {
                e10 = h(e10, annotation);
            }
        }
        return e10;
    }

    public final o f(o oVar, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!oVar.f(annotation)) {
                oVar = oVar.a(annotation);
                if (this.f9171a.q0(annotation)) {
                    oVar = g(oVar, annotation);
                }
            }
        }
        return oVar;
    }

    public final o g(o oVar, Annotation annotation) {
        for (Annotation annotation2 : h.p(annotation.annotationType())) {
            if (!c(annotation2) && !oVar.f(annotation2)) {
                oVar = oVar.a(annotation2);
                if (this.f9171a.q0(annotation2)) {
                    oVar = h(oVar, annotation2);
                }
            }
        }
        return oVar;
    }

    public final o h(o oVar, Annotation annotation) {
        for (Annotation annotation2 : h.p(annotation.annotationType())) {
            if (!c(annotation2)) {
                if (!this.f9171a.q0(annotation2)) {
                    oVar = oVar.a(annotation2);
                } else if (!oVar.f(annotation2)) {
                    oVar = h(oVar.a(annotation2), annotation2);
                }
            }
        }
        return oVar;
    }
}
