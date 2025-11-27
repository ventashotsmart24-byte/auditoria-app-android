package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import b0.c1;
import b0.p1;

public class v2 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: j  reason: collision with root package name */
    public static v2 f1395j;

    /* renamed from: k  reason: collision with root package name */
    public static v2 f1396k;

    /* renamed from: a  reason: collision with root package name */
    public final View f1397a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f1398b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1399c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f1400d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f1401e = new b();

    /* renamed from: f  reason: collision with root package name */
    public int f1402f;

    /* renamed from: g  reason: collision with root package name */
    public int f1403g;

    /* renamed from: h  reason: collision with root package name */
    public w2 f1404h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1405i;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            v2.this.g(false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            v2.this.c();
        }
    }

    public v2(View view, CharSequence charSequence) {
        this.f1397a = view;
        this.f1398b = charSequence;
        this.f1399c = p1.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void e(v2 v2Var) {
        v2 v2Var2 = f1395j;
        if (v2Var2 != null) {
            v2Var2.a();
        }
        f1395j = v2Var;
        if (v2Var != null) {
            v2Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        v2 v2Var = f1395j;
        if (v2Var != null && v2Var.f1397a == view) {
            e((v2) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            v2 v2Var2 = f1396k;
            if (v2Var2 != null && v2Var2.f1397a == view) {
                v2Var2.c();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new v2(view, charSequence);
    }

    public final void a() {
        this.f1397a.removeCallbacks(this.f1400d);
    }

    public final void b() {
        this.f1402f = Integer.MAX_VALUE;
        this.f1403g = Integer.MAX_VALUE;
    }

    public void c() {
        if (f1396k == this) {
            f1396k = null;
            w2 w2Var = this.f1404h;
            if (w2Var != null) {
                w2Var.c();
                this.f1404h = null;
                b();
                this.f1397a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1395j == this) {
            e((v2) null);
        }
        this.f1397a.removeCallbacks(this.f1401e);
    }

    public final void d() {
        this.f1397a.postDelayed(this.f1400d, (long) ViewConfiguration.getLongPressTimeout());
    }

    public void g(boolean z10) {
        long j10;
        long j11;
        long j12;
        if (c1.P(this.f1397a)) {
            e((v2) null);
            v2 v2Var = f1396k;
            if (v2Var != null) {
                v2Var.c();
            }
            f1396k = this;
            this.f1405i = z10;
            w2 w2Var = new w2(this.f1397a.getContext());
            this.f1404h = w2Var;
            w2Var.e(this.f1397a, this.f1402f, this.f1403g, this.f1405i, this.f1398b);
            this.f1397a.addOnAttachStateChangeListener(this);
            if (this.f1405i) {
                j10 = 2500;
            } else {
                if ((c1.J(this.f1397a) & 1) == 1) {
                    j12 = (long) ViewConfiguration.getLongPressTimeout();
                    j11 = 3000;
                } else {
                    j12 = (long) ViewConfiguration.getLongPressTimeout();
                    j11 = 15000;
                }
                j10 = j11 - j12;
            }
            this.f1397a.removeCallbacks(this.f1401e);
            this.f1397a.postDelayed(this.f1401e, j10);
        }
    }

    public final boolean h(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (Math.abs(x10 - this.f1402f) <= this.f1399c && Math.abs(y10 - this.f1403g) <= this.f1399c) {
            return false;
        }
        this.f1402f = x10;
        this.f1403g = y10;
        return true;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1404h != null && this.f1405i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1397a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f1397a.isEnabled() && this.f1404h == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f1402f = view.getWidth() / 2;
        this.f1403g = view.getHeight() / 2;
        g(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
