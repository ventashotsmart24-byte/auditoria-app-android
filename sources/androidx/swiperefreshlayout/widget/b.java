package androidx.swiperefreshlayout.widget;

import a0.h;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.mobile.brasiltv.view.RoundedDrawable;

public class b extends Drawable implements Animatable {

    /* renamed from: g  reason: collision with root package name */
    public static final Interpolator f3112g = new LinearInterpolator();

    /* renamed from: h  reason: collision with root package name */
    public static final Interpolator f3113h = new h0.b();

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f3114i = {RoundedDrawable.DEFAULT_BORDER_COLOR};

    /* renamed from: a  reason: collision with root package name */
    public final c f3115a;

    /* renamed from: b  reason: collision with root package name */
    public float f3116b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f3117c;

    /* renamed from: d  reason: collision with root package name */
    public Animator f3118d;

    /* renamed from: e  reason: collision with root package name */
    public float f3119e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3120f;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f3121a;

        public a(c cVar) {
            this.f3121a = cVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(floatValue, this.f3121a);
            b.this.b(floatValue, this.f3121a, false);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.b$b  reason: collision with other inner class name */
    public class C0052b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f3123a;

        public C0052b(c cVar) {
            this.f3123a = cVar;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.f3123a, true);
            this.f3123a.A();
            this.f3123a.l();
            b bVar = b.this;
            if (bVar.f3120f) {
                bVar.f3120f = false;
                animator.cancel();
                animator.setDuration(1332);
                animator.start();
                this.f3123a.x(false);
                return;
            }
            bVar.f3119e += 1.0f;
        }

        public void onAnimationStart(Animator animator) {
            b.this.f3119e = 0.0f;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final RectF f3125a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        public final Paint f3126b;

        /* renamed from: c  reason: collision with root package name */
        public final Paint f3127c;

        /* renamed from: d  reason: collision with root package name */
        public final Paint f3128d;

        /* renamed from: e  reason: collision with root package name */
        public float f3129e;

        /* renamed from: f  reason: collision with root package name */
        public float f3130f;

        /* renamed from: g  reason: collision with root package name */
        public float f3131g;

        /* renamed from: h  reason: collision with root package name */
        public float f3132h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f3133i;

        /* renamed from: j  reason: collision with root package name */
        public int f3134j;

        /* renamed from: k  reason: collision with root package name */
        public float f3135k;

        /* renamed from: l  reason: collision with root package name */
        public float f3136l;

        /* renamed from: m  reason: collision with root package name */
        public float f3137m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f3138n;

        /* renamed from: o  reason: collision with root package name */
        public Path f3139o;

        /* renamed from: p  reason: collision with root package name */
        public float f3140p;

        /* renamed from: q  reason: collision with root package name */
        public float f3141q;

        /* renamed from: r  reason: collision with root package name */
        public int f3142r;

        /* renamed from: s  reason: collision with root package name */
        public int f3143s;

        /* renamed from: t  reason: collision with root package name */
        public int f3144t;

        /* renamed from: u  reason: collision with root package name */
        public int f3145u;

        public c() {
            Paint paint = new Paint();
            this.f3126b = paint;
            Paint paint2 = new Paint();
            this.f3127c = paint2;
            Paint paint3 = new Paint();
            this.f3128d = paint3;
            this.f3129e = 0.0f;
            this.f3130f = 0.0f;
            this.f3131g = 0.0f;
            this.f3132h = 5.0f;
            this.f3140p = 1.0f;
            this.f3144t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void A() {
            this.f3135k = this.f3129e;
            this.f3136l = this.f3130f;
            this.f3137m = this.f3131g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f3125a;
            float f10 = this.f3141q;
            float f11 = (this.f3132h / 2.0f) + f10;
            if (f10 <= 0.0f) {
                f11 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f3142r) * this.f3140p) / 2.0f, this.f3132h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f11, ((float) rect.centerY()) - f11, ((float) rect.centerX()) + f11, ((float) rect.centerY()) + f11);
            float f12 = this.f3129e;
            float f13 = this.f3131g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f3130f + f13) * 360.0f) - f14;
            this.f3126b.setColor(this.f3145u);
            this.f3126b.setAlpha(this.f3144t);
            float f16 = this.f3132h / 2.0f;
            rectF.inset(f16, f16);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f3128d);
            float f17 = -f16;
            rectF.inset(f17, f17);
            canvas.drawArc(rectF, f14, f15, false, this.f3126b);
            b(canvas, f14, f15, rectF);
        }

        public void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f3138n) {
                Path path = this.f3139o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f3139o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f3139o.moveTo(0.0f, 0.0f);
                this.f3139o.lineTo(((float) this.f3142r) * this.f3140p, 0.0f);
                Path path3 = this.f3139o;
                float f12 = this.f3140p;
                path3.lineTo((((float) this.f3142r) * f12) / 2.0f, ((float) this.f3143s) * f12);
                this.f3139o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.f3142r) * this.f3140p) / 2.0f), rectF.centerY() + (this.f3132h / 2.0f));
                this.f3139o.close();
                this.f3127c.setColor(this.f3145u);
                this.f3127c.setAlpha(this.f3144t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f3139o, this.f3127c);
                canvas.restore();
            }
        }

        public int c() {
            return this.f3144t;
        }

        public float d() {
            return this.f3130f;
        }

        public int e() {
            return this.f3133i[f()];
        }

        public int f() {
            return (this.f3134j + 1) % this.f3133i.length;
        }

        public float g() {
            return this.f3129e;
        }

        public int h() {
            return this.f3133i[this.f3134j];
        }

        public float i() {
            return this.f3136l;
        }

        public float j() {
            return this.f3137m;
        }

        public float k() {
            return this.f3135k;
        }

        public void l() {
            t(f());
        }

        public void m() {
            this.f3135k = 0.0f;
            this.f3136l = 0.0f;
            this.f3137m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        public void n(int i10) {
            this.f3144t = i10;
        }

        public void o(float f10, float f11) {
            this.f3142r = (int) f10;
            this.f3143s = (int) f11;
        }

        public void p(float f10) {
            if (f10 != this.f3140p) {
                this.f3140p = f10;
            }
        }

        public void q(float f10) {
            this.f3141q = f10;
        }

        public void r(int i10) {
            this.f3145u = i10;
        }

        public void s(ColorFilter colorFilter) {
            this.f3126b.setColorFilter(colorFilter);
        }

        public void t(int i10) {
            this.f3134j = i10;
            this.f3145u = this.f3133i[i10];
        }

        public void u(int[] iArr) {
            this.f3133i = iArr;
            t(0);
        }

        public void v(float f10) {
            this.f3130f = f10;
        }

        public void w(float f10) {
            this.f3131g = f10;
        }

        public void x(boolean z10) {
            if (this.f3138n != z10) {
                this.f3138n = z10;
            }
        }

        public void y(float f10) {
            this.f3129e = f10;
        }

        public void z(float f10) {
            this.f3132h = f10;
            this.f3126b.setStrokeWidth(f10);
        }
    }

    public b(Context context) {
        this.f3117c = ((Context) h.d(context)).getResources();
        c cVar = new c();
        this.f3115a = cVar;
        cVar.u(f3114i);
        k(2.5f);
        m();
    }

    public final void a(float f10, c cVar) {
        n(f10, cVar);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f10));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((((float) (Math.floor((double) (cVar.j() / 0.8f)) + 1.0d)) - cVar.j()) * f10));
    }

    public void b(float f10, c cVar, boolean z10) {
        float f11;
        float f12;
        if (this.f3120f) {
            a(f10, cVar);
        } else if (f10 != 1.0f || z10) {
            float j10 = cVar.j();
            if (f10 < 0.5f) {
                f11 = cVar.k();
                f12 = (f3113h.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + f11;
            } else {
                float k10 = cVar.k() + 0.79f;
                float f13 = k10;
                f11 = k10 - (((1.0f - f3113h.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f12 = f13;
            }
            cVar.y(f11);
            cVar.v(f12);
            cVar.w(j10 + (0.20999998f * f10));
            h((f10 + this.f3119e) * 216.0f);
        }
    }

    public final int c(float f10, int i10, int i11) {
        int i12 = (i10 >> 24) & 255;
        int i13 = (i10 >> 16) & 255;
        int i14 = (i10 >> 8) & 255;
        int i15 = i10 & 255;
        return ((i12 + ((int) (((float) (((i11 >> 24) & 255) - i12)) * f10))) << 24) | ((i13 + ((int) (((float) (((i11 >> 16) & 255) - i13)) * f10))) << 16) | ((i14 + ((int) (((float) (((i11 >> 8) & 255) - i14)) * f10))) << 8) | (i15 + ((int) (f10 * ((float) ((i11 & 255) - i15)))));
    }

    public void d(boolean z10) {
        this.f3115a.x(z10);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f3116b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f3115a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f10) {
        this.f3115a.p(f10);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f3115a.u(iArr);
        this.f3115a.t(0);
        invalidateSelf();
    }

    public void g(float f10) {
        this.f3115a.w(f10);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f3115a.c();
    }

    public int getOpacity() {
        return -3;
    }

    public final void h(float f10) {
        this.f3116b = f10;
    }

    public final void i(float f10, float f11, float f12, float f13) {
        c cVar = this.f3115a;
        float f14 = this.f3117c.getDisplayMetrics().density;
        cVar.z(f11 * f14);
        cVar.q(f10 * f14);
        cVar.t(0);
        cVar.o(f12 * f14, f13 * f14);
    }

    public boolean isRunning() {
        return this.f3118d.isRunning();
    }

    public void j(float f10, float f11) {
        this.f3115a.y(f10);
        this.f3115a.v(f11);
        invalidateSelf();
    }

    public void k(float f10) {
        this.f3115a.z(f10);
        invalidateSelf();
    }

    public void l(int i10) {
        if (i10 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void m() {
        c cVar = this.f3115a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f3112g);
        ofFloat.addListener(new C0052b(cVar));
        this.f3118d = ofFloat;
    }

    public void n(float f10, c cVar) {
        if (f10 > 0.75f) {
            cVar.r(c((f10 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    public void setAlpha(int i10) {
        this.f3115a.n(i10);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3115a.s(colorFilter);
        invalidateSelf();
    }

    public void start() {
        this.f3118d.cancel();
        this.f3115a.A();
        if (this.f3115a.d() != this.f3115a.g()) {
            this.f3120f = true;
            this.f3118d.setDuration(666);
            this.f3118d.start();
            return;
        }
        this.f3115a.t(0);
        this.f3115a.m();
        this.f3118d.setDuration(1332);
        this.f3118d.start();
    }

    public void stop() {
        this.f3118d.cancel();
        h(0.0f);
        this.f3115a.x(false);
        this.f3115a.t(0);
        this.f3115a.m();
        invalidateSelf();
    }
}
