package b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class a2 {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f4033a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f4034b = null;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f4035c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f4036d = -1;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b2 f4037a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f4038b;

        public a(b2 b2Var, View view) {
            this.f4037a = b2Var;
            this.f4038b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f4037a.a(this.f4038b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f4037a.b(this.f4038b);
        }

        public void onAnimationStart(Animator animator) {
            this.f4037a.c(this.f4038b);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d2 f4040a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f4041b;

        public b(d2 d2Var, View view) {
            this.f4040a = d2Var;
            this.f4041b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f4040a.a(this.f4041b);
        }
    }

    public a2(View view) {
        this.f4033a = new WeakReference(view);
    }

    public a2 a(float f10) {
        View view = (View) this.f4033a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void b() {
        View view = (View) this.f4033a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = (View) this.f4033a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public a2 d(long j10) {
        View view = (View) this.f4033a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public a2 e(Interpolator interpolator) {
        View view = (View) this.f4033a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public a2 f(b2 b2Var) {
        View view = (View) this.f4033a.get();
        if (view != null) {
            g(view, b2Var);
        }
        return this;
    }

    public final void g(View view, b2 b2Var) {
        if (b2Var != null) {
            view.animate().setListener(new a(b2Var, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public a2 h(long j10) {
        View view = (View) this.f4033a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    public a2 i(d2 d2Var) {
        b bVar;
        View view = (View) this.f4033a.get();
        if (view != null) {
            if (d2Var != null) {
                bVar = new b(d2Var, view);
            } else {
                bVar = null;
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public void j() {
        View view = (View) this.f4033a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public a2 k(float f10) {
        View view = (View) this.f4033a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
