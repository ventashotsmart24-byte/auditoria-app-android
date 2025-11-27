package i4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import f4.d;
import h4.c;
import h4.e;

public class f extends h4.f {
    public boolean G = false;

    public class a extends c {
        public a() {
        }

        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.1f, 0.25f, 0.75f, 0.9f, 1.0f};
            return new d(this).a(fArr, 0, 0, 255, 255, 0, 0).j(fArr, -180, -180, 0, 0, 0, 0).k(fArr, 0, 0, 0, 0, 180, 180).c(2400).h(new LinearInterpolator()).b();
        }
    }

    public void I(Canvas canvas) {
        Rect a10 = a(getBounds());
        for (int i10 = 0; i10 < K(); i10++) {
            int save = canvas.save();
            canvas.rotate((float) ((i10 * 90) + 45), (float) a10.centerX(), (float) a10.centerY());
            J(i10).draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public e[] N() {
        a[] aVarArr = new a[4];
        for (int i10 = 0; i10 < 4; i10++) {
            a aVar = new a();
            aVarArr[i10] = aVar;
            aVar.s((i10 * 300) - 1200);
        }
        return aVarArr;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a10 = a(rect);
        int min = Math.min(a10.width(), a10.height());
        if (this.G) {
            min = (int) Math.sqrt((double) ((min * min) / 2));
            int width = (a10.width() - min) / 2;
            int height = (a10.height() - min) / 2;
            a10 = new Rect(a10.left + width, a10.top + height, a10.right - width, a10.bottom - height);
        }
        int i10 = min / 2;
        int i11 = a10.left + i10 + 1;
        int i12 = a10.top + i10 + 1;
        for (int i13 = 0; i13 < K(); i13++) {
            e J = J(i13);
            J.u(a10.left, a10.top, i11, i12);
            J.w((float) J.d().right);
            J.x((float) J.d().bottom);
        }
    }
}
