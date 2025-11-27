package f4;

import android.animation.Animator;
import android.animation.ValueAnimator;
import h4.e;

public abstract class a {
    public static boolean a(ValueAnimator valueAnimator) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return false;
        }
        return true;
    }

    public static boolean b(e... eVarArr) {
        for (e isRunning : eVarArr) {
            if (isRunning.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public static void c(Animator animator) {
        if (animator != null && !animator.isStarted()) {
            animator.start();
        }
    }

    public static void d(e... eVarArr) {
        for (e start : eVarArr) {
            start.start();
        }
    }

    public static void e(e... eVarArr) {
        for (e stop : eVarArr) {
            stop.stop();
        }
    }
}
