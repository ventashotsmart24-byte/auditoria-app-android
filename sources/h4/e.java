package h4;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;

public abstract class e extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable, Drawable.Callback {
    public static final Property A = new j("scaleX");
    public static final Property B = new k("scaleY");
    public static final Property C = new a("scale");
    public static final Property D = new b("alpha");

    /* renamed from: s  reason: collision with root package name */
    public static final Rect f6927s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    public static final Property f6928t = new c("rotateX");

    /* renamed from: u  reason: collision with root package name */
    public static final Property f6929u = new d("rotate");

    /* renamed from: v  reason: collision with root package name */
    public static final Property f6930v = new C0088e("rotateY");

    /* renamed from: w  reason: collision with root package name */
    public static final Property f6931w = new f("translateX");

    /* renamed from: x  reason: collision with root package name */
    public static final Property f6932x = new g("translateY");

    /* renamed from: y  reason: collision with root package name */
    public static final Property f6933y = new h("translateXPercentage");

    /* renamed from: z  reason: collision with root package name */
    public static final Property f6934z = new i("translateYPercentage");

    /* renamed from: a  reason: collision with root package name */
    public float f6935a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f6936b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f6937c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f6938d;

    /* renamed from: e  reason: collision with root package name */
    public float f6939e;

    /* renamed from: f  reason: collision with root package name */
    public int f6940f;

    /* renamed from: g  reason: collision with root package name */
    public int f6941g;

    /* renamed from: h  reason: collision with root package name */
    public int f6942h;

    /* renamed from: i  reason: collision with root package name */
    public int f6943i;

    /* renamed from: j  reason: collision with root package name */
    public int f6944j;

    /* renamed from: k  reason: collision with root package name */
    public int f6945k;

    /* renamed from: l  reason: collision with root package name */
    public float f6946l;

    /* renamed from: m  reason: collision with root package name */
    public float f6947m;

    /* renamed from: n  reason: collision with root package name */
    public ValueAnimator f6948n;

    /* renamed from: o  reason: collision with root package name */
    public int f6949o = 255;

    /* renamed from: p  reason: collision with root package name */
    public Rect f6950p = f6927s;

    /* renamed from: q  reason: collision with root package name */
    public Camera f6951q = new Camera();

    /* renamed from: r  reason: collision with root package name */
    public Matrix f6952r = new Matrix();

    public static class a extends f4.b {
        public a(String str) {
            super(str);
        }

        /* renamed from: c */
        public Float get(e eVar) {
            return Float.valueOf(eVar.j());
        }

        /* renamed from: d */
        public void b(e eVar, float f10) {
            eVar.B(f10);
        }
    }

    public static class b extends f4.c {
        public b(String str) {
            super(str);
        }

        /* renamed from: c */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.getAlpha());
        }

        /* renamed from: d */
        public void b(e eVar, int i10) {
            eVar.setAlpha(i10);
        }
    }

    public static class c extends f4.c {
        public c(String str) {
            super(str);
        }

        /* renamed from: c */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.h());
        }

        /* renamed from: d */
        public void b(e eVar, int i10) {
            eVar.z(i10);
        }
    }

    public static class d extends f4.c {
        public d(String str) {
            super(str);
        }

        /* renamed from: c */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.g());
        }

        /* renamed from: d */
        public void b(e eVar, int i10) {
            eVar.y(i10);
        }
    }

    /* renamed from: h4.e$e  reason: collision with other inner class name */
    public static class C0088e extends f4.c {
        public C0088e(String str) {
            super(str);
        }

        /* renamed from: c */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.i());
        }

        /* renamed from: d */
        public void b(e eVar, int i10) {
            eVar.A(i10);
        }
    }

    public static class f extends f4.c {
        public f(String str) {
            super(str);
        }

        /* renamed from: c */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.m());
        }

        /* renamed from: d */
        public void b(e eVar, int i10) {
            eVar.E(i10);
        }
    }

    public static class g extends f4.c {
        public g(String str) {
            super(str);
        }

        /* renamed from: c */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.o());
        }

        /* renamed from: d */
        public void b(e eVar, int i10) {
            eVar.G(i10);
        }
    }

    public static class h extends f4.b {
        public h(String str) {
            super(str);
        }

        /* renamed from: c */
        public Float get(e eVar) {
            return Float.valueOf(eVar.n());
        }

        /* renamed from: d */
        public void b(e eVar, float f10) {
            eVar.F(f10);
        }
    }

    public static class i extends f4.b {
        public i(String str) {
            super(str);
        }

        /* renamed from: c */
        public Float get(e eVar) {
            return Float.valueOf(eVar.p());
        }

        /* renamed from: d */
        public void b(e eVar, float f10) {
            eVar.H(f10);
        }
    }

    public static class j extends f4.b {
        public j(String str) {
            super(str);
        }

        /* renamed from: c */
        public Float get(e eVar) {
            return Float.valueOf(eVar.k());
        }

        /* renamed from: d */
        public void b(e eVar, float f10) {
            eVar.C(f10);
        }
    }

    public static class k extends f4.b {
        public k(String str) {
            super(str);
        }

        /* renamed from: c */
        public Float get(e eVar) {
            return Float.valueOf(eVar.l());
        }

        /* renamed from: d */
        public void b(e eVar, float f10) {
            eVar.D(f10);
        }
    }

    public void A(int i10) {
        this.f6942h = i10;
    }

    public void B(float f10) {
        this.f6935a = f10;
        C(f10);
        D(f10);
    }

    public void C(float f10) {
        this.f6936b = f10;
    }

    public void D(float f10) {
        this.f6937c = f10;
    }

    public void E(int i10) {
        this.f6943i = i10;
    }

    public void F(float f10) {
        this.f6946l = f10;
    }

    public void G(int i10) {
        this.f6944j = i10;
    }

    public void H(float f10) {
        this.f6947m = f10;
    }

    public Rect a(Rect rect) {
        int min = Math.min(rect.width(), rect.height());
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i10 = min / 2;
        return new Rect(centerX - i10, centerY - i10, centerX + i10, centerY + i10);
    }

    public abstract void b(Canvas canvas);

    public abstract ValueAnimator c();

    public Rect d() {
        return this.f6950p;
    }

    public void draw(Canvas canvas) {
        int m10 = m();
        if (m10 == 0) {
            m10 = (int) (((float) getBounds().width()) * n());
        }
        int o10 = o();
        if (o10 == 0) {
            o10 = (int) (((float) getBounds().height()) * p());
        }
        canvas.translate((float) m10, (float) o10);
        canvas.scale(k(), l(), e(), f());
        canvas.rotate((float) g(), e(), f());
        if (!(h() == 0 && i() == 0)) {
            this.f6951q.save();
            this.f6951q.rotateX((float) h());
            this.f6951q.rotateY((float) i());
            this.f6951q.getMatrix(this.f6952r);
            this.f6952r.preTranslate(-e(), -f());
            this.f6952r.postTranslate(e(), f());
            this.f6951q.restore();
            canvas.concat(this.f6952r);
        }
        b(canvas);
    }

    public float e() {
        return this.f6938d;
    }

    public float f() {
        return this.f6939e;
    }

    public int g() {
        return this.f6945k;
    }

    public int getAlpha() {
        return this.f6949o;
    }

    public int getOpacity() {
        return 1;
    }

    public int h() {
        return this.f6941g;
    }

    public int i() {
        return this.f6942h;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isRunning() {
        return f4.a.a(this.f6948n);
    }

    public float j() {
        return this.f6935a;
    }

    public float k() {
        return this.f6936b;
    }

    public float l() {
        return this.f6937c;
    }

    public int m() {
        return this.f6943i;
    }

    public float n() {
        return this.f6946l;
    }

    public int o() {
        return this.f6944j;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        v(rect);
    }

    public float p() {
        return this.f6947m;
    }

    public ValueAnimator q() {
        if (this.f6948n == null) {
            ValueAnimator c10 = c();
            this.f6948n = c10;
            if (c10 != null) {
                c10.addUpdateListener(this);
            }
        }
        ValueAnimator valueAnimator = this.f6948n;
        if (valueAnimator != null) {
            valueAnimator.setStartDelay((long) this.f6940f);
        }
        return this.f6948n;
    }

    public void r() {
        this.f6935a = 1.0f;
        this.f6941g = 0;
        this.f6942h = 0;
        this.f6943i = 0;
        this.f6944j = 0;
        this.f6945k = 0;
        this.f6946l = 0.0f;
        this.f6947m = 0.0f;
    }

    public e s(int i10) {
        this.f6940f = i10;
        return this;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
    }

    public void setAlpha(int i10) {
        this.f6949o = i10;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void start() {
        ValueAnimator q10 = q();
        this.f6948n = q10;
        if (q10 != null && !q10.isStarted()) {
            f4.a.c(this.f6948n);
            invalidateSelf();
        }
    }

    public void stop() {
        ValueAnimator valueAnimator = this.f6948n;
        if (valueAnimator != null) {
            valueAnimator.end();
            r();
            onAnimationUpdate(this.f6948n);
        }
    }

    public abstract void t(int i10);

    public void u(int i10, int i11, int i12, int i13) {
        this.f6950p = new Rect(i10, i11, i12, i13);
        w((float) d().centerX());
        x((float) d().centerY());
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public void v(Rect rect) {
        u(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void w(float f10) {
        this.f6938d = f10;
    }

    public void x(float f10) {
        this.f6939e = f10;
    }

    public void y(int i10) {
        this.f6945k = i10;
    }

    public void z(int i10) {
        this.f6941g = i10;
    }
}
