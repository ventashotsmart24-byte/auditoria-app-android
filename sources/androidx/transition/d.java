package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import b0.c1;

public class d extends p0 {

    public class a extends o {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f3192a;

        public a(View view) {
            this.f3192a = view;
        }

        public void d(n nVar) {
            c0.g(this.f3192a, 1.0f);
            c0.a(this.f3192a);
            nVar.removeListener(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final View f3194a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3195b = false;

        public b(View view) {
            this.f3194a = view;
        }

        public void onAnimationEnd(Animator animator) {
            c0.g(this.f3194a, 1.0f);
            if (this.f3195b) {
                this.f3194a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (c1.M(this.f3194a) && this.f3194a.getLayerType() == 0) {
                this.f3195b = true;
                this.f3194a.setLayerType(2, (Paint) null);
            }
        }
    }

    public d(int i10) {
        w(i10);
    }

    public static float y(u uVar, float f10) {
        Float f11;
        if (uVar == null || (f11 = (Float) uVar.f3271a.get("android:fade:transitionAlpha")) == null) {
            return f10;
        }
        return f11.floatValue();
    }

    public void captureStartValues(u uVar) {
        super.captureStartValues(uVar);
        uVar.f3271a.put("android:fade:transitionAlpha", Float.valueOf(c0.c(uVar.f3272b)));
    }

    public Animator s(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        float f10 = 0.0f;
        float y10 = y(uVar, 0.0f);
        if (y10 != 1.0f) {
            f10 = y10;
        }
        return x(view, f10, 1.0f);
    }

    public Animator u(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        c0.e(view);
        return x(view, y(uVar, 1.0f), 0.0f);
    }

    public final Animator x(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        c0.g(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c0.f3190b, new float[]{f11});
        ofFloat.addListener(new b(view));
        addListener(new a(view));
        return ofFloat;
    }
}
