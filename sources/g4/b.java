package g4;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

public class b implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public TimeInterpolator f6834a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f6835b;

    public b(TimeInterpolator timeInterpolator) {
        this.f6834a = timeInterpolator;
    }

    public static b a(float... fArr) {
        b bVar = new b(a.a());
        bVar.b(fArr);
        return bVar;
    }

    public void b(float... fArr) {
        this.f6835b = fArr;
    }

    public synchronized float getInterpolation(float f10) {
        if (this.f6835b.length > 1) {
            int i10 = 0;
            while (true) {
                float[] fArr = this.f6835b;
                if (i10 < fArr.length - 1) {
                    float f11 = fArr[i10];
                    i10++;
                    float f12 = fArr[i10];
                    float f13 = f12 - f11;
                    if (f10 >= f11 && f10 <= f12) {
                        return f11 + (this.f6834a.getInterpolation((f10 - f11) / f13) * f13);
                    }
                }
            }
        }
        return this.f6834a.getInterpolation(f10);
    }
}
