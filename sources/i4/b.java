package i4;

import android.animation.ValueAnimator;
import f4.d;
import h4.e;

public class b extends h4.b {

    public class a extends h4.a {
        public a() {
        }

        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            return new d(this).l(fArr, 0.0f, 1.0f, 0.0f).c(1200).d(fArr).b();
        }
    }

    public e[] N() {
        a[] aVarArr = new a[12];
        for (int i10 = 0; i10 < 12; i10++) {
            a aVar = new a();
            aVarArr[i10] = aVar;
            aVar.s((i10 * 100) - 1200);
        }
        return aVarArr;
    }
}
