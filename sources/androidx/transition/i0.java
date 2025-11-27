package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

public class i0 extends f0 {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f3217f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f3218g = true;

    public void h(View view, Matrix matrix) {
        if (f3217f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f3217f = false;
            }
        }
    }

    public void i(View view, Matrix matrix) {
        if (f3218g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f3218g = false;
            }
        }
    }
}
