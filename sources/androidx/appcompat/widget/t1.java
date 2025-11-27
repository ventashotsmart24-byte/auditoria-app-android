package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.p;

public abstract class t1 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final float f1381a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1382b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1383c;

    /* renamed from: d  reason: collision with root package name */
    public final View f1384d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f1385e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f1386f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1387g;

    /* renamed from: h  reason: collision with root package name */
    public int f1388h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f1389i = new int[2];

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ViewParent parent = t1.this.f1384d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            t1.this.e();
        }
    }

    public t1(View view) {
        this.f1384d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1381a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1382b = tapTimeout;
        this.f1383c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        if (f10 < f13 || f11 < f13 || f10 >= ((float) (view.getRight() - view.getLeft())) + f12 || f11 >= ((float) (view.getBottom() - view.getTop())) + f12) {
            return false;
        }
        return true;
    }

    public final void a() {
        Runnable runnable = this.f1386f;
        if (runnable != null) {
            this.f1384d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1385e;
        if (runnable2 != null) {
            this.f1384d.removeCallbacks(runnable2);
        }
    }

    public abstract p b();

    public abstract boolean c();

    public boolean d() {
        p b10 = b();
        if (b10 == null || !b10.isShowing()) {
            return true;
        }
        b10.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f1384d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1387g = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        r1 r1Var;
        boolean z10;
        View view = this.f1384d;
        p b10 = b();
        if (b10 == null || !b10.isShowing() || (r1Var = (r1) b10.m()) == null || !r1Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(r1Var, obtainNoHistory);
        boolean e10 = r1Var.e(obtainNoHistory, this.f1388h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!e10 || !z10) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1384d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.f1388h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1381a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.a()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.f1388h = r6
            java.lang.Runnable r6 = r5.f1385e
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.t1$a r6 = new androidx.appcompat.widget.t1$a
            r6.<init>()
            r5.f1385e = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f1385e
            int r1 = r5.f1382b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1386f
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.t1$b r6 = new androidx.appcompat.widget.t1$b
            r6.<init>()
            r5.f1386f = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f1386f
            int r1 = r5.f1383c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t1.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1389i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1389i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f1387g;
        if (!z11) {
            if (!g(motionEvent) || !c()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1384d.onTouchEvent(obtain);
                obtain.recycle();
            }
        } else if (f(motionEvent) || !d()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f1387g = z10;
        if (z10 || z11) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1387g = false;
        this.f1388h = -1;
        Runnable runnable = this.f1385e;
        if (runnable != null) {
            this.f1384d.removeCallbacks(runnable);
        }
    }
}
