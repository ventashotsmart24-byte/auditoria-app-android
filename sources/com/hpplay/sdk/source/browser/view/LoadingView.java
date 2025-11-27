package com.hpplay.sdk.source.browser.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.math.BigDecimal;

public class LoadingView extends View {
    /* access modifiers changed from: private */
    public int A;
    private int B;
    private boolean C;
    private ValueAnimator D;
    private ValueAnimator E;
    private ValueAnimator F;

    /* renamed from: a  reason: collision with root package name */
    private Paint f11645a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f11646b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f11647c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f11648d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f11649e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f11650f;

    /* renamed from: g  reason: collision with root package name */
    private Path f11651g;

    /* renamed from: h  reason: collision with root package name */
    private Path f11652h;

    /* renamed from: i  reason: collision with root package name */
    private Path f11653i;

    /* renamed from: j  reason: collision with root package name */
    private Path f11654j;

    /* renamed from: k  reason: collision with root package name */
    private Path f11655k;

    /* renamed from: l  reason: collision with root package name */
    private Path f11656l;

    /* renamed from: m  reason: collision with root package name */
    private PathMeasure f11657m;

    /* renamed from: n  reason: collision with root package name */
    private int f11658n;

    /* renamed from: o  reason: collision with root package name */
    private int f11659o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f11660p;

    /* renamed from: q  reason: collision with root package name */
    private float f11661q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f11662r;

    /* renamed from: s  reason: collision with root package name */
    private float f11663s;

    /* renamed from: t  reason: collision with root package name */
    private int f11664t;

    /* renamed from: u  reason: collision with root package name */
    private float f11665u;

    /* renamed from: v  reason: collision with root package name */
    private float f11666v;

    /* renamed from: w  reason: collision with root package name */
    private float f11667w;

    /* renamed from: x  reason: collision with root package name */
    private float f11668x;

    /* renamed from: y  reason: collision with root package name */
    private float f11669y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public float f11670z;

    public LoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ int c(LoadingView loadingView) {
        int i10 = loadingView.A;
        loadingView.A = i10 + 1;
        return i10;
    }

    private void d() {
        float f10 = this.f11663s + (this.f11666v * 2.0f);
        RectF rectF = this.f11648d;
        float f11 = this.f11668x;
        float f12 = this.f11665u;
        rectF.set(f10, f11, f10 + f12, f12 + f11);
        RectF rectF2 = this.f11649e;
        float f13 = this.f11648d.left;
        float f14 = this.f11665u;
        float f15 = this.f11666v;
        float f16 = this.f11668x;
        rectF2.set(f13 + f14 + f15, f16, f13 + f14 + f15 + f14, f14 + f16);
        RectF rectF3 = this.f11650f;
        float f17 = this.f11649e.left;
        float f18 = this.f11665u;
        float f19 = this.f11666v;
        float f20 = this.f11668x;
        rectF3.set(f17 + f18 + f19, f20, f17 + f18 + f19 + f18, f18 + f20);
        this.f11652h.reset();
        this.f11653i.reset();
        this.f11654j.reset();
        this.f11652h.addRect(this.f11648d, Path.Direction.CW);
        this.f11653i.addRect(this.f11649e, Path.Direction.CW);
        this.f11654j.addRect(this.f11650f, Path.Direction.CW);
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.E == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f11668x, this.f11669y});
            this.E = ofFloat;
            ofFloat.setDuration((long) (this.B / 6));
            this.E.setRepeatCount(2);
            this.E.setInterpolator(new LinearInterpolator());
            this.E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = LoadingView.this.f11670z = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            });
            this.E.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LoadingView.c(LoadingView.this);
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    int unused = LoadingView.this.A = 1;
                }
            });
        }
        if (this.F == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{this.f11669y, this.f11668x});
            this.F = ofFloat2;
            ofFloat2.setDuration((long) (this.B / 6));
            this.F.setRepeatCount(2);
            this.F.setInterpolator(new BounceInterpolator());
            this.F.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = LoadingView.this.f11670z = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            });
            this.F.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LoadingView.c(LoadingView.this);
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    LoadingView.c(LoadingView.this);
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.E).before(this.F);
        animatorSet.start();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((float) getPaddingLeft(), (float) (getPaddingTop() + (this.f11659o / 2)));
        this.f11655k.reset();
        PathMeasure pathMeasure = this.f11657m;
        float f10 = this.f11660p;
        pathMeasure.getSegment(f10, this.f11661q + f10, this.f11655k, true);
        canvas.drawPath(this.f11655k, this.f11645a);
        float f11 = this.f11660p;
        float f12 = this.f11661q;
        float f13 = this.f11662r;
        if (f11 + f12 > f13) {
            this.f11656l.reset();
            this.f11657m.getSegment(0.0f, (f11 + f12) - f13, this.f11656l, true);
            canvas.drawPath(this.f11656l, this.f11645a);
        }
        a(canvas);
    }

    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f11658n = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.f11659o = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.f11663s = a((float) this.f11658n, 18.0f);
        this.f11651g.reset();
        this.f11645a.setColor(-1);
        float f10 = this.f11663s;
        RectF rectF = new RectF(f10 / 2.0f, 0.0f, ((float) this.f11658n) - (f10 / 2.0f), ((float) (this.f11659o / 2)) - (f10 / 2.0f));
        this.f11647c = rectF;
        Path path = this.f11651g;
        int i14 = this.f11664t;
        path.addRoundRect(rectF, (float) i14, (float) i14, Path.Direction.CW);
        PathMeasure pathMeasure = new PathMeasure(this.f11651g, false);
        this.f11657m = pathMeasure;
        float length = pathMeasure.getLength();
        this.f11662r = length;
        this.f11661q = length / 6.0f;
        float a10 = a(((float) this.f11658n) - (this.f11663s * 2.0f), 15.0f);
        this.f11666v = a10;
        this.f11665u = a10 * 3.0f;
        float a11 = a((this.f11647c.height() - this.f11665u) - (this.f11663s * 1.5f), 2.0f);
        this.f11667w = a11;
        this.f11668x = this.f11663s + a11;
        this.f11669y = -(this.f11647c.height() - this.f11667w);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        this.f11651g = new Path();
        Paint paint = new Paint();
        this.f11645a = paint;
        paint.setColor(-1);
        this.f11645a.setStyle(Paint.Style.STROKE);
        this.f11645a.setStrokeWidth(this.f11663s);
        this.f11645a.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f11646b = paint2;
        paint2.setColor(-1);
        this.f11646b.setAntiAlias(true);
        this.f11646b.setStyle(Paint.Style.FILL);
        this.f11648d = new RectF();
        this.f11649e = new RectF();
        this.f11650f = new RectF();
        this.f11652h = new Path();
        this.f11653i = new Path();
        this.f11654j = new Path();
        this.f11655k = new Path();
        this.f11656l = new Path();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11663s = 6.0f;
        this.f11664t = 10;
        this.A = 1;
        this.B = 1584;
        this.C = false;
        c();
    }

    public void b() {
        this.C = false;
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.E;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator3 = this.F;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
    }

    private void a(Canvas canvas) {
        float f10 = this.f11663s;
        float f11 = this.f11666v;
        float f12 = f10 + (2.0f * f11);
        int i10 = this.A;
        if (i10 == 1 || i10 == 4) {
            RectF rectF = this.f11648d;
            float f13 = this.f11670z;
            float f14 = this.f11665u;
            rectF.set(f12, f13, f12 + f14, f14 + f13);
            this.f11652h.reset();
            this.f11652h.addRect(this.f11648d, Path.Direction.CW);
        } else if (i10 == 2 || i10 == 5) {
            RectF rectF2 = this.f11649e;
            float f15 = this.f11665u;
            float f16 = this.f11670z;
            rectF2.set(f12 + f15 + f11, f16, f12 + f15 + f11 + f15, f15 + f16);
            this.f11653i.reset();
            this.f11653i.addRect(this.f11649e, Path.Direction.CW);
        } else {
            RectF rectF3 = this.f11650f;
            float f17 = this.f11649e.left;
            float f18 = this.f11665u;
            float f19 = this.f11670z;
            rectF3.set(f17 + f18 + f11, f19, f17 + f18 + f11 + f18, f18 + f19);
            this.f11654j.reset();
            this.f11654j.addRect(this.f11650f, Path.Direction.CW);
        }
        canvas.drawPath(this.f11652h, this.f11646b);
        canvas.drawPath(this.f11653i, this.f11646b);
        canvas.drawPath(this.f11654j, this.f11646b);
    }

    public void a() {
        if (this.f11662r > 0.0f && !this.C) {
            d();
            b();
            this.C = true;
            if (this.D == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, this.f11662r});
                this.D = ofFloat;
                ofFloat.setDuration((long) this.B);
                this.D.setRepeatCount(-1);
                this.D.setInterpolator(new LinearInterpolator());
                final float f10 = (this.f11662r - this.f11661q) - ((float) (this.f11664t * 2));
                this.D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float unused = LoadingView.this.f11660p = (f10 + ((Float) valueAnimator.getAnimatedValue()).floatValue()) % LoadingView.this.f11662r;
                        LoadingView.this.invalidate();
                    }
                });
                this.D.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationRepeat(Animator animator) {
                        super.onAnimationRepeat(animator);
                        LoadingView.this.e();
                    }
                });
            }
            this.D.start();
            e();
        }
    }

    private float a(float f10, float f11) {
        return new BigDecimal(Float.toString(f10)).divide(new BigDecimal(Float.toString(f11)), 2, 4).floatValue();
    }
}
