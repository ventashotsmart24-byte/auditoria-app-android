package androidx.transition;

import android.view.View;

public class f0 extends o0 {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f3210e = true;

    public void a(View view) {
    }

    public float c(View view) {
        if (f3210e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f3210e = false;
            }
        }
        return view.getAlpha();
    }

    public void d(View view) {
    }

    public void f(View view, float f10) {
        if (f3210e) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f3210e = false;
            }
        }
        view.setAlpha(f10);
    }
}
