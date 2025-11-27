package h4;

import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class b extends f {
    public void I(Canvas canvas) {
        for (int i10 = 0; i10 < K(); i10++) {
            e J = J(i10);
            int save = canvas.save();
            canvas.rotate((float) ((i10 * 360) / K()), (float) getBounds().centerX(), (float) getBounds().centerY());
            J.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a10 = a(rect);
        double width = (double) a10.width();
        Double.isNaN(width);
        double K = (double) K();
        Double.isNaN(K);
        int i10 = (int) (((width * 3.141592653589793d) / 3.5999999046325684d) / K);
        int centerX = a10.centerX() - i10;
        int centerX2 = a10.centerX() + i10;
        for (int i11 = 0; i11 < K(); i11++) {
            e J = J(i11);
            int i12 = a10.top;
            J.u(centerX, i12, centerX2, (i10 * 2) + i12);
        }
    }
}
