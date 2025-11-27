package androidx.transition;

import android.view.View;

public class k0 extends i0 {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f3219h = true;

    public void e(View view, int i10, int i11, int i12, int i13) {
        if (f3219h) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f3219h = false;
            }
        }
    }
}
