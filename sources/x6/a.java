package x6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public abstract class a {

    /* renamed from: x6.a$a  reason: collision with other inner class name */
    public class C0290a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f19782a;

        public C0290a(View view) {
            this.f19782a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f19782a.setVisibility(8);
            this.f19782a.setTag(Boolean.FALSE);
        }

        public void onAnimationStart(Animator animator) {
            this.f19782a.setTag(Boolean.TRUE);
        }
    }

    public static void a(View view, int i10) {
        view.setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) (-i10), 0.0f}).setDuration(500);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
    }

    public static void b(View view, int i10) {
        Object tag = view.getTag();
        if (tag == null || !((Boolean) tag).booleanValue()) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) (-i10)}).setDuration(500);
            duration.setInterpolator(new DecelerateInterpolator());
            duration.addListener(new C0290a(view));
            duration.start();
        }
    }
}
