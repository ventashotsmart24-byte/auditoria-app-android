package h4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import f4.a;

public abstract class f extends e {
    public e[] E = N();
    public int F;

    public f() {
        L();
        M(this.E);
    }

    public void I(Canvas canvas) {
        e[] eVarArr = this.E;
        if (eVarArr != null) {
            for (e draw : eVarArr) {
                int save = canvas.save();
                draw.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
    }

    public e J(int i10) {
        e[] eVarArr = this.E;
        if (eVarArr == null) {
            return null;
        }
        return eVarArr[i10];
    }

    public int K() {
        e[] eVarArr = this.E;
        if (eVarArr == null) {
            return 0;
        }
        return eVarArr.length;
    }

    public final void L() {
        e[] eVarArr = this.E;
        if (eVarArr != null) {
            for (e callback : eVarArr) {
                callback.setCallback(this);
            }
        }
    }

    public void M(e... eVarArr) {
    }

    public abstract e[] N();

    public void b(Canvas canvas) {
    }

    public ValueAnimator c() {
        return null;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        I(canvas);
    }

    public boolean isRunning() {
        if (a.b(this.E) || super.isRunning()) {
            return true;
        }
        return false;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        for (e bounds : this.E) {
            bounds.setBounds(rect);
        }
    }

    public void start() {
        super.start();
        a.d(this.E);
    }

    public void stop() {
        super.stop();
        a.e(this.E);
    }

    public void t(int i10) {
        this.F = i10;
        for (int i11 = 0; i11 < K(); i11++) {
            J(i11).t(i10);
        }
    }
}
