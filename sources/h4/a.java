package h4;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class a extends d {
    public void I(Canvas canvas, Paint paint) {
        if (d() != null) {
            canvas.drawCircle((float) d().centerX(), (float) d().centerY(), (float) (Math.min(d().width(), d().height()) / 2), paint);
        }
    }
}
