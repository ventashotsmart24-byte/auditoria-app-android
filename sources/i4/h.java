package i4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import f4.d;
import h4.c;

public class h extends c {
    public void I(Canvas canvas, Paint paint) {
        super.I(canvas, paint);
    }

    public ValueAnimator c() {
        float[] fArr = {0.0f, 0.5f, 1.0f};
        return new d(this).j(fArr, 0, -180, -180).k(fArr, 0, 0, -180).c(1200).d(fArr).b();
    }

    public void onBoundsChange(Rect rect) {
        v(a(rect));
    }
}
