package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import b0.c1;

public abstract class a implements View.OnTouchListener {

    /* renamed from: r  reason: collision with root package name */
    public static final int f1776r = ViewConfiguration.getTapTimeout();

    /* renamed from: a  reason: collision with root package name */
    public final C0024a f1777a = new C0024a();

    /* renamed from: b  reason: collision with root package name */
    public final Interpolator f1778b = new AccelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    public final View f1779c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f1780d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f1781e = {0.0f, 0.0f};

    /* renamed from: f  reason: collision with root package name */
    public float[] f1782f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: g  reason: collision with root package name */
    public int f1783g;

    /* renamed from: h  reason: collision with root package name */
    public int f1784h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f1785i = {0.0f, 0.0f};

    /* renamed from: j  reason: collision with root package name */
    public float[] f1786j = {0.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    public float[] f1787k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: l  reason: collision with root package name */
    public boolean f1788l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1789m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1790n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1791o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1792p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f1793q;

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    public static class C0024a {

        /* renamed from: a  reason: collision with root package name */
        public int f1794a;

        /* renamed from: b  reason: collision with root package name */
        public int f1795b;

        /* renamed from: c  reason: collision with root package name */
        public float f1796c;

        /* renamed from: d  reason: collision with root package name */
        public float f1797d;

        /* renamed from: e  reason: collision with root package name */
        public long f1798e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        public long f1799f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f1800g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f1801h = 0;

        /* renamed from: i  reason: collision with root package name */
        public long f1802i = -1;

        /* renamed from: j  reason: collision with root package name */
        public float f1803j;

        /* renamed from: k  reason: collision with root package name */
        public int f1804k;

        public void a() {
            if (this.f1799f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g10 = g(e(currentAnimationTimeMillis));
                this.f1799f = currentAnimationTimeMillis;
                float f10 = ((float) (currentAnimationTimeMillis - this.f1799f)) * g10;
                this.f1800g = (int) (this.f1796c * f10);
                this.f1801h = (int) (f10 * this.f1797d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f1800g;
        }

        public int c() {
            return this.f1801h;
        }

        public int d() {
            float f10 = this.f1796c;
            return (int) (f10 / Math.abs(f10));
        }

        public final float e(long j10) {
            long j11 = this.f1798e;
            if (j10 < j11) {
                return 0.0f;
            }
            long j12 = this.f1802i;
            if (j12 < 0 || j10 < j12) {
                return a.e(((float) (j10 - j11)) / ((float) this.f1794a), 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f1803j;
            return (1.0f - f10) + (f10 * a.e(((float) (j10 - j12)) / ((float) this.f1804k), 0.0f, 1.0f));
        }

        public int f() {
            float f10 = this.f1797d;
            return (int) (f10 / Math.abs(f10));
        }

        public final float g(float f10) {
            return (-4.0f * f10 * f10) + (f10 * 4.0f);
        }

        public boolean h() {
            if (this.f1802i <= 0 || AnimationUtils.currentAnimationTimeMillis() <= this.f1802i + ((long) this.f1804k)) {
                return false;
            }
            return true;
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1804k = a.f((int) (currentAnimationTimeMillis - this.f1798e), 0, this.f1795b);
            this.f1803j = e(currentAnimationTimeMillis);
            this.f1802i = currentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f1795b = i10;
        }

        public void k(int i10) {
            this.f1794a = i10;
        }

        public void l(float f10, float f11) {
            this.f1796c = f10;
            this.f1797d = f11;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1798e = currentAnimationTimeMillis;
            this.f1802i = -1;
            this.f1799f = currentAnimationTimeMillis;
            this.f1803j = 0.5f;
            this.f1800g = 0;
            this.f1801h = 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a aVar = a.this;
            if (aVar.f1791o) {
                if (aVar.f1789m) {
                    aVar.f1789m = false;
                    aVar.f1777a.m();
                }
                C0024a aVar2 = a.this.f1777a;
                if (aVar2.h() || !a.this.u()) {
                    a.this.f1791o = false;
                    return;
                }
                a aVar3 = a.this;
                if (aVar3.f1790n) {
                    aVar3.f1790n = false;
                    aVar3.c();
                }
                aVar2.a();
                a.this.j(aVar2.b(), aVar2.c());
                c1.c0(a.this.f1779c, this);
            }
        }
    }

    public a(View view) {
        this.f1779c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (float) ((int) ((1575.0f * f10) + 0.5f));
        o(f11, f11);
        float f12 = (float) ((int) ((f10 * 315.0f) + 0.5f));
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f1776r);
        r(500);
        q(500);
    }

    public static float e(float f10, float f11, float f12) {
        if (f10 > f12) {
            return f12;
        }
        return f10 < f11 ? f11 : f10;
    }

    public static int f(int i10, int i11, int i12) {
        if (i10 > i12) {
            return i12;
        }
        return i10 < i11 ? i11 : i10;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1779c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public final float d(int i10, float f10, float f11, float f12) {
        float h10 = h(this.f1781e[i10], f11, this.f1782f[i10], f10);
        if (h10 == 0.0f) {
            return 0.0f;
        }
        float f13 = this.f1785i[i10];
        float f14 = this.f1786j[i10];
        float f15 = this.f1787k[i10];
        float f16 = f13 * f12;
        if (h10 > 0.0f) {
            return e(h10 * f16, f14, f15);
        }
        return -e((-h10) * f16, f14, f15);
    }

    public final float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f1783g;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (!this.f1791o || i10 != 1) {
                    return 0.0f;
                }
                return 1.0f;
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    public final float h(float f10, float f11, float f12, float f13) {
        float f14;
        float e10 = e(f10 * f11, 0.0f, f12);
        float g10 = g(f11 - f13, e10) - g(f13, e10);
        if (g10 < 0.0f) {
            f14 = -this.f1778b.getInterpolation(-g10);
        } else if (g10 <= 0.0f) {
            return 0.0f;
        } else {
            f14 = this.f1778b.getInterpolation(g10);
        }
        return e(f14, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f1789m) {
            this.f1791o = false;
        } else {
            this.f1777a.i();
        }
    }

    public abstract void j(int i10, int i11);

    public a k(int i10) {
        this.f1784h = i10;
        return this;
    }

    public a l(int i10) {
        this.f1783g = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f1792p && !z10) {
            i();
        }
        this.f1792p = z10;
        return this;
    }

    public a n(float f10, float f11) {
        float[] fArr = this.f1782f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a o(float f10, float f11) {
        float[] fArr = this.f1787k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f1792p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.i()
            goto L_0x0058
        L_0x001a:
            r5.f1790n = r2
            r5.f1788l = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1779c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1779c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f1777a
            r7.l(r0, r6)
            boolean r6 = r5.f1791o
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.u()
            if (r6 == 0) goto L_0x0058
            r5.v()
        L_0x0058:
            boolean r6 = r5.f1793q
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f1791o
            if (r6 == 0) goto L_0x0061
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f10, float f11) {
        float[] fArr = this.f1786j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a q(int i10) {
        this.f1777a.j(i10);
        return this;
    }

    public a r(int i10) {
        this.f1777a.k(i10);
        return this;
    }

    public a s(float f10, float f11) {
        float[] fArr = this.f1781e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a t(float f10, float f11) {
        float[] fArr = this.f1785i;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public boolean u() {
        C0024a aVar = this.f1777a;
        int f10 = aVar.f();
        int d10 = aVar.d();
        if ((f10 == 0 || !b(f10)) && (d10 == 0 || !a(d10))) {
            return false;
        }
        return true;
    }

    public final void v() {
        int i10;
        if (this.f1780d == null) {
            this.f1780d = new b();
        }
        this.f1791o = true;
        this.f1789m = true;
        if (this.f1788l || (i10 = this.f1784h) <= 0) {
            this.f1780d.run();
        } else {
            c1.d0(this.f1779c, this.f1780d, (long) i10);
        }
        this.f1788l = true;
    }
}
