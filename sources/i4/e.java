package i4;

import android.animation.ValueAnimator;
import f4.d;
import h4.b;

public class e extends b {

    public class a extends h4.a {
        public a() {
        }

        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.4f, 1.0f};
            return new d(this).a(fArr, 0, 255, 0).c(1200).d(fArr).b();
        }
    }

    public h4.e[] N() {
        a[] aVarArr = new a[12];
        for (int i10 = 0; i10 < 12; i10++) {
            a aVar = new a();
            aVarArr[i10] = aVar;
            aVar.s(i10 * 100);
        }
        return aVarArr;
    }
}
