package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import b0.c1;

public class d extends RecyclerView.n implements RecyclerView.s {
    public static final int[] D = {16842919};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.t C;

    /* renamed from: a  reason: collision with root package name */
    public final int f2940a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2941b;

    /* renamed from: c  reason: collision with root package name */
    public final StateListDrawable f2942c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f2943d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2944e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2945f;

    /* renamed from: g  reason: collision with root package name */
    public final StateListDrawable f2946g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f2947h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2948i;

    /* renamed from: j  reason: collision with root package name */
    public final int f2949j;

    /* renamed from: k  reason: collision with root package name */
    public int f2950k;

    /* renamed from: l  reason: collision with root package name */
    public int f2951l;

    /* renamed from: m  reason: collision with root package name */
    public float f2952m;

    /* renamed from: n  reason: collision with root package name */
    public int f2953n;

    /* renamed from: o  reason: collision with root package name */
    public int f2954o;

    /* renamed from: p  reason: collision with root package name */
    public float f2955p;

    /* renamed from: q  reason: collision with root package name */
    public int f2956q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f2957r = 0;

    /* renamed from: s  reason: collision with root package name */
    public RecyclerView f2958s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2959t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2960u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f2961v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f2962w = 0;

    /* renamed from: x  reason: collision with root package name */
    public final int[] f2963x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    public final int[] f2964y = new int[2];

    /* renamed from: z  reason: collision with root package name */
    public final ValueAnimator f2965z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d.this.h(500);
        }
    }

    public class b extends RecyclerView.t {
        public b() {
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            d.this.s(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2968a = false;

        public c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f2968a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f2968a) {
                this.f2968a = false;
            } else if (((Float) d.this.f2965z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.p(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.m();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d  reason: collision with other inner class name */
    public class C0043d implements ValueAnimator.AnimatorUpdateListener {
        public C0043d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f2942c.setAlpha(floatValue);
            d.this.f2943d.setAlpha(floatValue);
            d.this.m();
        }
    }

    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f2965z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f2942c = stateListDrawable;
        this.f2943d = drawable;
        this.f2946g = stateListDrawable2;
        this.f2947h = drawable2;
        this.f2944e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f2945f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f2948i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f2949j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f2940a = i11;
        this.f2941b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new C0043d());
        a(recyclerView);
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2958s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                c();
            }
            this.f2958s = recyclerView;
            if (recyclerView != null) {
                q();
            }
        }
    }

    public final void b() {
        this.f2958s.removeCallbacks(this.B);
    }

    public final void c() {
        this.f2958s.removeItemDecoration(this);
        this.f2958s.removeOnItemTouchListener(this);
        this.f2958s.removeOnScrollListener(this.C);
        b();
    }

    public final void d(Canvas canvas) {
        int i10 = this.f2957r;
        int i11 = this.f2948i;
        int i12 = i10 - i11;
        int i13 = this.f2954o;
        int i14 = this.f2953n;
        int i15 = i13 - (i14 / 2);
        this.f2946g.setBounds(0, 0, i14, i11);
        this.f2947h.setBounds(0, 0, this.f2956q, this.f2949j);
        canvas.translate(0.0f, (float) i12);
        this.f2947h.draw(canvas);
        canvas.translate((float) i15, 0.0f);
        this.f2946g.draw(canvas);
        canvas.translate((float) (-i15), (float) (-i12));
    }

    public final void e(Canvas canvas) {
        int i10 = this.f2956q;
        int i11 = this.f2944e;
        int i12 = i10 - i11;
        int i13 = this.f2951l;
        int i14 = this.f2950k;
        int i15 = i13 - (i14 / 2);
        this.f2942c.setBounds(0, 0, i11, i14);
        this.f2943d.setBounds(0, 0, this.f2945f, this.f2957r);
        if (j()) {
            this.f2943d.draw(canvas);
            canvas.translate((float) this.f2944e, (float) i15);
            canvas.scale(-1.0f, 1.0f);
            this.f2942c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate((float) (-this.f2944e), (float) (-i15));
            return;
        }
        canvas.translate((float) i12, 0.0f);
        this.f2943d.draw(canvas);
        canvas.translate(0.0f, (float) i15);
        this.f2942c.draw(canvas);
        canvas.translate((float) (-i12), (float) (-i15));
    }

    public final int[] f() {
        int[] iArr = this.f2964y;
        int i10 = this.f2941b;
        iArr[0] = i10;
        iArr[1] = this.f2956q - i10;
        return iArr;
    }

    public final int[] g() {
        int[] iArr = this.f2963x;
        int i10 = this.f2941b;
        iArr[0] = i10;
        iArr[1] = this.f2957r - i10;
        return iArr;
    }

    public void h(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f2965z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f2965z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f2965z.setDuration((long) i10);
        this.f2965z.start();
    }

    public final void i(float f10) {
        int[] f11 = f();
        float max = Math.max((float) f11[0], Math.min((float) f11[1], f10));
        if (Math.abs(((float) this.f2954o) - max) >= 2.0f) {
            int o10 = o(this.f2955p, max, f11, this.f2958s.computeHorizontalScrollRange(), this.f2958s.computeHorizontalScrollOffset(), this.f2956q);
            if (o10 != 0) {
                this.f2958s.scrollBy(o10, 0);
            }
            this.f2955p = max;
        }
    }

    public final boolean j() {
        if (c1.z(this.f2958s) == 1) {
            return true;
        }
        return false;
    }

    public boolean k(float f10, float f11) {
        if (f11 >= ((float) (this.f2957r - this.f2948i))) {
            int i10 = this.f2954o;
            int i11 = this.f2953n;
            if (f10 < ((float) (i10 - (i11 / 2))) || f10 > ((float) (i10 + (i11 / 2)))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean l(float f10, float f11) {
        if (!j() ? f10 >= ((float) (this.f2956q - this.f2944e)) : f10 <= ((float) (this.f2944e / 2))) {
            int i10 = this.f2951l;
            int i11 = this.f2950k;
            if (f11 < ((float) (i10 - (i11 / 2))) || f11 > ((float) (i10 + (i11 / 2)))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void m() {
        this.f2958s.invalidate();
    }

    public final void n(int i10) {
        b();
        this.f2958s.postDelayed(this.B, (long) i10);
    }

    public final int o(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / ((float) i13)) * ((float) i14));
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.f2956q != this.f2958s.getWidth() || this.f2957r != this.f2958s.getHeight()) {
            this.f2956q = this.f2958s.getWidth();
            this.f2957r = this.f2958s.getHeight();
            p(0);
        } else if (this.A != 0) {
            if (this.f2959t) {
                e(canvas);
            }
            if (this.f2960u) {
                d(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f2961v;
        if (i10 == 1) {
            boolean l10 = l(motionEvent.getX(), motionEvent.getY());
            boolean k10 = k(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!l10 && !k10) {
                return false;
            }
            if (k10) {
                this.f2962w = 1;
                this.f2955p = (float) ((int) motionEvent.getX());
            } else if (l10) {
                this.f2962w = 2;
                this.f2952m = (float) ((int) motionEvent.getY());
            }
            p(2);
        } else if (i10 == 2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f2961v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean l10 = l(motionEvent.getX(), motionEvent.getY());
                boolean k10 = k(motionEvent.getX(), motionEvent.getY());
                if (l10 || k10) {
                    if (k10) {
                        this.f2962w = 1;
                        this.f2955p = (float) ((int) motionEvent.getX());
                    } else if (l10) {
                        this.f2962w = 2;
                        this.f2952m = (float) ((int) motionEvent.getY());
                    }
                    p(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f2961v == 2) {
                this.f2952m = 0.0f;
                this.f2955p = 0.0f;
                p(1);
                this.f2962w = 0;
            } else if (motionEvent.getAction() == 2 && this.f2961v == 2) {
                r();
                if (this.f2962w == 1) {
                    i(motionEvent.getX());
                }
                if (this.f2962w == 2) {
                    t(motionEvent.getY());
                }
            }
        }
    }

    public void p(int i10) {
        if (i10 == 2 && this.f2961v != 2) {
            this.f2942c.setState(D);
            b();
        }
        if (i10 == 0) {
            m();
        } else {
            r();
        }
        if (this.f2961v == 2 && i10 != 2) {
            this.f2942c.setState(E);
            n(1200);
        } else if (i10 == 1) {
            n(1500);
        }
        this.f2961v = i10;
    }

    public final void q() {
        this.f2958s.addItemDecoration(this);
        this.f2958s.addOnItemTouchListener(this);
        this.f2958s.addOnScrollListener(this.C);
    }

    public void r() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 == 3) {
                this.f2965z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f2965z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f2965z.setDuration(500);
        this.f2965z.setStartDelay(0);
        this.f2965z.start();
    }

    public void s(int i10, int i11) {
        boolean z10;
        boolean z11;
        int computeVerticalScrollRange = this.f2958s.computeVerticalScrollRange();
        int i12 = this.f2957r;
        if (computeVerticalScrollRange - i12 <= 0 || i12 < this.f2940a) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f2959t = z10;
        int computeHorizontalScrollRange = this.f2958s.computeHorizontalScrollRange();
        int i13 = this.f2956q;
        if (computeHorizontalScrollRange - i13 <= 0 || i13 < this.f2940a) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.f2960u = z11;
        boolean z12 = this.f2959t;
        if (z12 || z11) {
            if (z12) {
                float f10 = (float) i12;
                this.f2951l = (int) ((f10 * (((float) i11) + (f10 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f2950k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
            }
            if (this.f2960u) {
                float f11 = (float) i13;
                this.f2954o = (int) ((f11 * (((float) i10) + (f11 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f2953n = Math.min(i13, (i13 * i13) / computeHorizontalScrollRange);
            }
            int i14 = this.f2961v;
            if (i14 == 0 || i14 == 1) {
                p(1);
            }
        } else if (this.f2961v != 0) {
            p(0);
        }
    }

    public final void t(float f10) {
        int[] g10 = g();
        float max = Math.max((float) g10[0], Math.min((float) g10[1], f10));
        if (Math.abs(((float) this.f2951l) - max) >= 2.0f) {
            int o10 = o(this.f2952m, max, g10, this.f2958s.computeVerticalScrollRange(), this.f2958s.computeVerticalScrollOffset(), this.f2957r);
            if (o10 != 0) {
                this.f2958s.scrollBy(0, o10);
            }
            this.f2952m = max;
        }
    }
}
