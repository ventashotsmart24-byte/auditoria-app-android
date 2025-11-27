package androidx.transition;

import android.os.Build;
import android.view.View;

public class m0 extends k0 {

    /* renamed from: i  reason: collision with root package name */
    public static boolean f3221i = true;

    public void g(View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i10);
        } else if (f3221i) {
            try {
                view.setTransitionVisibility(i10);
            } catch (NoSuchMethodError unused) {
                f3221i = false;
            }
        }
    }
}
