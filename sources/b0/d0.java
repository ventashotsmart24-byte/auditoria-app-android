package b0;

import android.view.View;
import android.view.ViewTreeObserver;

public final class d0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final View f4067a;

    /* renamed from: b  reason: collision with root package name */
    public ViewTreeObserver f4068b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f4069c;

    public d0(View view, Runnable runnable) {
        this.f4067a = view;
        this.f4068b = view.getViewTreeObserver();
        this.f4069c = runnable;
    }

    public static d0 a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            d0 d0Var = new d0(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(d0Var);
            view.addOnAttachStateChangeListener(d0Var);
            return d0Var;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public void b() {
        if (this.f4068b.isAlive()) {
            this.f4068b.removeOnPreDrawListener(this);
        } else {
            this.f4067a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f4067a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f4069c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f4068b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
