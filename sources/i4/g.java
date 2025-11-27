package i4;

import android.animation.ValueAnimator;
import f4.d;
import h4.a;

public class g extends a {
    public ValueAnimator c() {
        float[] fArr = {0.0f, 1.0f};
        return new d(this).l(fArr, 0.0f, 1.0f).a(fArr, 255, 0).c(1000).d(fArr).b();
    }
}
