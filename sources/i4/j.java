package i4;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import f4.d;
import h4.c;
import h4.e;
import h4.f;

public class j extends f {

    public class a extends c {
        public a() {
        }

        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.25f, 0.5f, 0.51f, 0.75f, 1.0f};
            return new d(this).i(fArr, 0, -90, -179, -180, -270, -360).m(fArr, 0.0f, 0.75f, 0.75f, 0.75f, 0.0f, 0.0f).n(fArr, 0.0f, 0.0f, 0.75f, 0.75f, 0.75f, 0.0f).l(fArr, 1.0f, 0.5f, 1.0f, 1.0f, 0.5f, 1.0f).c(1800).d(fArr).b();
        }
    }

    public void M(e... eVarArr) {
        super.M(eVarArr);
        eVarArr[1].s(-900);
    }

    public e[] N() {
        return new e[]{new a(), new a()};
    }

    public void onBoundsChange(Rect rect) {
        Rect a10 = a(rect);
        super.onBoundsChange(a10);
        for (int i10 = 0; i10 < K(); i10++) {
            e J = J(i10);
            int i11 = a10.left;
            J.u(i11, a10.top, (a10.width() / 4) + i11, a10.top + (a10.height() / 4));
        }
    }
}
