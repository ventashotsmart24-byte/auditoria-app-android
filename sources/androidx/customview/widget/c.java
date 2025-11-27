package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import b0.c1;
import java.util.Arrays;

public class c {

    /* renamed from: w  reason: collision with root package name */
    public static final Interpolator f1830w = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f1831a;

    /* renamed from: b  reason: collision with root package name */
    public int f1832b;

    /* renamed from: c  reason: collision with root package name */
    public int f1833c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float[] f1834d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f1835e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f1836f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f1837g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f1838h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f1839i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f1840j;

    /* renamed from: k  reason: collision with root package name */
    public int f1841k;

    /* renamed from: l  reason: collision with root package name */
    public VelocityTracker f1842l;

    /* renamed from: m  reason: collision with root package name */
    public float f1843m;

    /* renamed from: n  reason: collision with root package name */
    public float f1844n;

    /* renamed from: o  reason: collision with root package name */
    public int f1845o;

    /* renamed from: p  reason: collision with root package name */
    public int f1846p;

    /* renamed from: q  reason: collision with root package name */
    public OverScroller f1847q;

    /* renamed from: r  reason: collision with root package name */
    public final C0027c f1848r;

    /* renamed from: s  reason: collision with root package name */
    public View f1849s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f1850t;

    /* renamed from: u  reason: collision with root package name */
    public final ViewGroup f1851u;

    /* renamed from: v  reason: collision with root package name */
    public final Runnable f1852v = new b();

    public static class a implements Interpolator {
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            c.this.F(0);
        }
    }

    /* renamed from: androidx.customview.widget.c$c  reason: collision with other inner class name */
    public static abstract class C0027c {
        public abstract int clampViewPositionHorizontal(View view, int i10, int i11);

        public abstract int clampViewPositionVertical(View view, int i10, int i11);

        public int getOrderedChildIndex(int i10) {
            return i10;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i10, int i11) {
        }

        public boolean onEdgeLock(int i10) {
            return false;
        }

        public void onEdgeTouched(int i10, int i11) {
        }

        public void onViewCaptured(View view, int i10) {
        }

        public abstract void onViewDragStateChanged(int i10);

        public abstract void onViewPositionChanged(View view, int i10, int i11, int i12, int i13);

        public abstract void onViewReleased(View view, float f10, float f11);

        public abstract boolean tryCaptureView(View view, int i10);
    }

    public c(Context context, ViewGroup viewGroup, C0027c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cVar != null) {
            this.f1851u = viewGroup;
            this.f1848r = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1845o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1832b = viewConfiguration.getScaledTouchSlop();
            this.f1843m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1844n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1847q = new OverScroller(context, f1830w);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public static c l(ViewGroup viewGroup, float f10, C0027c cVar) {
        c m10 = m(viewGroup, cVar);
        m10.f1832b = (int) (((float) m10.f1832b) * (1.0f / f10));
        return m10;
    }

    public static c m(ViewGroup viewGroup, C0027c cVar) {
        return new c(viewGroup.getContext(), viewGroup, cVar);
    }

    public void A(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1842l == null) {
            this.f1842l = VelocityTracker.obtain();
        }
        this.f1842l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View r10 = r((int) x10, (int) y10);
            D(x10, y10, pointerId);
            J(r10, pointerId);
            int i12 = this.f1838h[pointerId];
            int i13 = this.f1846p;
            if ((i12 & i13) != 0) {
                this.f1848r.onEdgeTouched(i12 & i13, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f1831a == 1) {
                B();
            }
            a();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f1831a == 1) {
                    n(0.0f, 0.0f);
                }
                a();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x11 = motionEvent.getX(actionIndex);
                float y11 = motionEvent.getY(actionIndex);
                D(x11, y11, pointerId2);
                if (this.f1831a == 0) {
                    J(r((int) x11, (int) y11), pointerId2);
                    int i14 = this.f1838h[pointerId2];
                    int i15 = this.f1846p;
                    if ((i14 & i15) != 0) {
                        this.f1848r.onEdgeTouched(i14 & i15, pointerId2);
                    }
                } else if (w((int) x11, (int) y11)) {
                    J(this.f1849s, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f1831a == 1 && pointerId3 == this.f1833c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i11 >= pointerCount) {
                            i10 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i11);
                        if (pointerId4 != this.f1833c) {
                            View r11 = r((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                            View view = this.f1849s;
                            if (r11 == view && J(view, pointerId4)) {
                                i10 = this.f1833c;
                                break;
                            }
                        }
                        i11++;
                    }
                    if (i10 == -1) {
                        B();
                    }
                }
                h(pointerId3);
            }
        } else if (this.f1831a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i11 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i11);
                if (y(pointerId5)) {
                    float x12 = motionEvent.getX(i11);
                    float y12 = motionEvent.getY(i11);
                    float f10 = x12 - this.f1834d[pointerId5];
                    float f11 = y12 - this.f1835e[pointerId5];
                    C(f10, f11, pointerId5);
                    if (this.f1831a != 1) {
                        View r12 = r((int) x12, (int) y12);
                        if (d(r12, f10, f11) && J(r12, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i11++;
            }
            E(motionEvent);
        } else if (y(this.f1833c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f1833c);
            float x13 = motionEvent.getX(findPointerIndex);
            float y13 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f1836f;
            int i16 = this.f1833c;
            int i17 = (int) (x13 - fArr[i16]);
            int i18 = (int) (y13 - this.f1837g[i16]);
            p(this.f1849s.getLeft() + i17, this.f1849s.getTop() + i18, i17, i18);
            E(motionEvent);
        }
    }

    public final void B() {
        this.f1842l.computeCurrentVelocity(1000, this.f1843m);
        n(e(this.f1842l.getXVelocity(this.f1833c), this.f1844n, this.f1843m), e(this.f1842l.getYVelocity(this.f1833c), this.f1844n, this.f1843m));
    }

    public final void C(float f10, float f11, int i10) {
        boolean c10 = c(f10, f11, i10, 1);
        if (c(f11, f10, i10, 4)) {
            c10 |= true;
        }
        if (c(f10, f11, i10, 2)) {
            c10 |= true;
        }
        if (c(f11, f10, i10, 8)) {
            c10 |= true;
        }
        if (c10) {
            int[] iArr = this.f1839i;
            iArr[i10] = iArr[i10] | c10;
            this.f1848r.onEdgeDragStarted(c10 ? 1 : 0, i10);
        }
    }

    public final void D(float f10, float f11, int i10) {
        q(i10);
        float[] fArr = this.f1834d;
        this.f1836f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f1835e;
        this.f1837g[i10] = f11;
        fArr2[i10] = f11;
        this.f1838h[i10] = t((int) f10, (int) f11);
        this.f1841k |= 1 << i10;
    }

    public final void E(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (y(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f1836f[pointerId] = x10;
                this.f1837g[pointerId] = y10;
            }
        }
    }

    public void F(int i10) {
        this.f1851u.removeCallbacks(this.f1852v);
        if (this.f1831a != i10) {
            this.f1831a = i10;
            this.f1848r.onViewDragStateChanged(i10);
            if (this.f1831a == 0) {
                this.f1849s = null;
            }
        }
    }

    public boolean G(int i10, int i11) {
        if (this.f1850t) {
            return s(i10, i11, (int) this.f1842l.getXVelocity(this.f1833c), (int) this.f1842l.getYVelocity(this.f1833c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean H(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.a()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f1842l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f1842l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f1842l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.h(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.D(r7, r1, r2)
            int r3 = r0.f1831a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.f1838h
            r1 = r1[r2]
            int r3 = r0.f1846p
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            androidx.customview.widget.c$c r4 = r0.f1848r
            r1 = r1 & r3
            r4.onEdgeTouched(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.r(r3, r1)
            android.view.View r3 = r0.f1849s
            if (r1 != r3) goto L_0x0031
            r0.J(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.f1834d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.f1835e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.y(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f1834d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f1835e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.r(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.d(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = 1
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.widget.c$c r14 = r0.f1848r
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.widget.c$c r5 = r0.f1848r
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            androidx.customview.widget.c$c r14 = r0.f1848r
            int r14 = r14.getViewHorizontalDragRange(r7)
            androidx.customview.widget.c$c r15 = r0.f1848r
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.C(r9, r10, r4)
            int r5 = r0.f1831a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.J(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.E(r17)
            goto L_0x0031
        L_0x00ff:
            r16.a()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.D(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.r(r2, r3)
            android.view.View r3 = r0.f1849s
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f1831a
            if (r3 != r4) goto L_0x0125
            r0.J(r2, r1)
        L_0x0125:
            int[] r2 = r0.f1838h
            r2 = r2[r1]
            int r3 = r0.f1846p
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            androidx.customview.widget.c$c r4 = r0.f1848r
            r2 = r2 & r3
            r4.onEdgeTouched(r2, r1)
        L_0x0135:
            int r1 = r0.f1831a
            if (r1 != r6) goto L_0x013a
            r5 = 1
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.c.H(android.view.MotionEvent):boolean");
    }

    public boolean I(View view, int i10, int i11) {
        this.f1849s = view;
        this.f1833c = -1;
        boolean s10 = s(i10, i11, 0, 0);
        if (!s10 && this.f1831a == 0 && this.f1849s != null) {
            this.f1849s = null;
        }
        return s10;
    }

    public boolean J(View view, int i10) {
        if (view == this.f1849s && this.f1833c == i10) {
            return true;
        }
        if (view == null || !this.f1848r.tryCaptureView(view, i10)) {
            return false;
        }
        this.f1833c = i10;
        b(view, i10);
        return true;
    }

    public void a() {
        this.f1833c = -1;
        g();
        VelocityTracker velocityTracker = this.f1842l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1842l = null;
        }
    }

    public void b(View view, int i10) {
        if (view.getParent() == this.f1851u) {
            this.f1849s = view;
            this.f1833c = i10;
            this.f1848r.onViewCaptured(view, i10);
            F(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1851u + ")");
    }

    public final boolean c(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f1838h[i10] & i11) != i11 || (this.f1846p & i11) == 0 || (this.f1840j[i10] & i11) == i11 || (this.f1839i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f1832b;
        if (abs <= ((float) i12) && abs2 <= ((float) i12)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f1848r.onEdgeLock(i11)) {
            int[] iArr = this.f1840j;
            iArr[i10] = iArr[i10] | i11;
            return false;
        } else if ((this.f1839i[i10] & i11) != 0 || abs <= ((float) this.f1832b)) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean d(View view, float f10, float f11) {
        boolean z10;
        boolean z11;
        if (view == null) {
            return false;
        }
        if (this.f1848r.getViewHorizontalDragRange(view) > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f1848r.getViewVerticalDragRange(view) > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && z11) {
            int i10 = this.f1832b;
            if ((f10 * f10) + (f11 * f11) > ((float) (i10 * i10))) {
                return true;
            }
            return false;
        } else if (z10) {
            if (Math.abs(f10) > ((float) this.f1832b)) {
                return true;
            }
            return false;
        } else if (!z11 || Math.abs(f11) <= ((float) this.f1832b)) {
            return false;
        } else {
            return true;
        }
    }

    public final float e(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return 0.0f;
        }
        if (abs <= f12) {
            return f10;
        }
        if (f10 > 0.0f) {
            return f12;
        }
        return -f12;
    }

    public final int f(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        if (abs <= i12) {
            return i10;
        }
        if (i10 > 0) {
            return i12;
        }
        return -i12;
    }

    public final void g() {
        float[] fArr = this.f1834d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f1835e, 0.0f);
            Arrays.fill(this.f1836f, 0.0f);
            Arrays.fill(this.f1837g, 0.0f);
            Arrays.fill(this.f1838h, 0);
            Arrays.fill(this.f1839i, 0);
            Arrays.fill(this.f1840j, 0);
            this.f1841k = 0;
        }
    }

    public final void h(int i10) {
        if (this.f1834d != null && x(i10)) {
            this.f1834d[i10] = 0.0f;
            this.f1835e[i10] = 0.0f;
            this.f1836f[i10] = 0.0f;
            this.f1837g[i10] = 0.0f;
            this.f1838h[i10] = 0;
            this.f1839i[i10] = 0;
            this.f1840j[i10] = 0;
            this.f1841k = ((1 << i10) ^ -1) & this.f1841k;
        }
    }

    public final int i(int i10, int i11, int i12) {
        int i13;
        if (i10 == 0) {
            return 0;
        }
        int width = this.f1851u.getWidth();
        float f10 = (float) (width / 2);
        float o10 = f10 + (o(Math.min(1.0f, ((float) Math.abs(i10)) / ((float) width))) * f10);
        int abs = Math.abs(i11);
        if (abs > 0) {
            i13 = Math.round(Math.abs(o10 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i13 = (int) (((((float) Math.abs(i10)) / ((float) i12)) + 1.0f) * 256.0f);
        }
        return Math.min(i13, 600);
    }

    public final int j(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int f14 = f(i12, (int) this.f1844n, (int) this.f1843m);
        int f15 = f(i13, (int) this.f1844n, (int) this.f1843m);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(f14);
        int abs4 = Math.abs(f15);
        int i14 = abs3 + abs4;
        int i15 = abs + abs2;
        if (f14 != 0) {
            f11 = (float) abs3;
            f10 = (float) i14;
        } else {
            f11 = (float) abs;
            f10 = (float) i15;
        }
        float f16 = f11 / f10;
        if (f15 != 0) {
            f13 = (float) abs4;
            f12 = (float) i14;
        } else {
            f13 = (float) abs2;
            f12 = (float) i15;
        }
        float f17 = f13 / f12;
        return (int) ((((float) i(i10, f14, this.f1848r.getViewHorizontalDragRange(view))) * f16) + (((float) i(i11, f15, this.f1848r.getViewVerticalDragRange(view))) * f17));
    }

    public boolean k(boolean z10) {
        if (this.f1831a == 2) {
            boolean computeScrollOffset = this.f1847q.computeScrollOffset();
            int currX = this.f1847q.getCurrX();
            int currY = this.f1847q.getCurrY();
            int left = currX - this.f1849s.getLeft();
            int top = currY - this.f1849s.getTop();
            if (left != 0) {
                c1.V(this.f1849s, left);
            }
            if (top != 0) {
                c1.W(this.f1849s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1848r.onViewPositionChanged(this.f1849s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f1847q.getFinalX() && currY == this.f1847q.getFinalY()) {
                this.f1847q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z10) {
                    this.f1851u.post(this.f1852v);
                } else {
                    F(0);
                }
            }
        }
        if (this.f1831a == 2) {
            return true;
        }
        return false;
    }

    public final void n(float f10, float f11) {
        this.f1850t = true;
        this.f1848r.onViewReleased(this.f1849s, f10, f11);
        this.f1850t = false;
        if (this.f1831a == 1) {
            F(0);
        }
    }

    public final float o(float f10) {
        return (float) Math.sin((double) ((f10 - 0.5f) * 0.47123894f));
    }

    public final void p(int i10, int i11, int i12, int i13) {
        int left = this.f1849s.getLeft();
        int top = this.f1849s.getTop();
        if (i12 != 0) {
            i10 = this.f1848r.clampViewPositionHorizontal(this.f1849s, i10, i12);
            c1.V(this.f1849s, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f1848r.clampViewPositionVertical(this.f1849s, i11, i13);
            c1.W(this.f1849s, i11 - top);
        }
        int i15 = i11;
        if (i12 != 0 || i13 != 0) {
            this.f1848r.onViewPositionChanged(this.f1849s, i14, i15, i14 - left, i15 - top);
        }
    }

    public final void q(int i10) {
        float[] fArr = this.f1834d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f1835e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f1836f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f1837g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1838h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1839i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1840j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1834d = fArr2;
            this.f1835e = fArr3;
            this.f1836f = fArr4;
            this.f1837g = fArr5;
            this.f1838h = iArr;
            this.f1839i = iArr2;
            this.f1840j = iArr3;
        }
    }

    public View r(int i10, int i11) {
        for (int childCount = this.f1851u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1851u.getChildAt(this.f1848r.getOrderedChildIndex(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean s(int i10, int i11, int i12, int i13) {
        int left = this.f1849s.getLeft();
        int top = this.f1849s.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f1847q.abortAnimation();
            F(0);
            return false;
        }
        this.f1847q.startScroll(left, top, i14, i15, j(this.f1849s, i14, i15, i12, i13));
        F(2);
        return true;
    }

    public final int t(int i10, int i11) {
        int i12;
        if (i10 < this.f1851u.getLeft() + this.f1845o) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        if (i11 < this.f1851u.getTop() + this.f1845o) {
            i12 |= 4;
        }
        if (i10 > this.f1851u.getRight() - this.f1845o) {
            i12 |= 2;
        }
        if (i11 > this.f1851u.getBottom() - this.f1845o) {
            return i12 | 8;
        }
        return i12;
    }

    public int u() {
        return this.f1832b;
    }

    public int v() {
        return this.f1831a;
    }

    public boolean w(int i10, int i11) {
        return z(this.f1849s, i10, i11);
    }

    public boolean x(int i10) {
        if (((1 << i10) & this.f1841k) != 0) {
            return true;
        }
        return false;
    }

    public final boolean y(int i10) {
        if (x(i10)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean z(View view, int i10, int i11) {
        if (view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom()) {
            return true;
        }
        return false;
    }
}
