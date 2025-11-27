package h0;

import android.view.animation.Interpolator;

public abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f6853a;

    /* renamed from: b  reason: collision with root package name */
    public final float f6854b;

    public d(float[] fArr) {
        this.f6853a = fArr;
        this.f6854b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f6853a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f10), fArr.length - 2);
        float f11 = this.f6854b;
        float f12 = (f10 - (((float) min) * f11)) / f11;
        float[] fArr2 = this.f6853a;
        float f13 = fArr2[min];
        return f13 + (f12 * (fArr2[min + 1] - f13));
    }
}
