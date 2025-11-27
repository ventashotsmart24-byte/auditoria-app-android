package i4;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import com.taobao.accs.flowcontrol.FlowControl;
import f4.d;
import h4.e;
import h4.f;

public class a extends f {

    /* renamed from: i4.a$a  reason: collision with other inner class name */
    public class C0091a extends h4.a {
        public C0091a() {
        }

        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            return new d(this).l(fArr, 0.0f, 1.0f, 0.0f).c(2000).d(fArr).b();
        }
    }

    public void M(e... eVarArr) {
        super.M(eVarArr);
        eVarArr[1].s(FlowControl.DELAY_MAX_BRUSH);
    }

    public e[] N() {
        return new e[]{new C0091a(), new C0091a()};
    }

    public ValueAnimator c() {
        return new d(this).i(new float[]{0.0f, 1.0f}, 0, 360).c(2000).h(new LinearInterpolator()).b();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a10 = a(rect);
        int width = (int) (((float) a10.width()) * 0.6f);
        e J = J(0);
        int i10 = a10.left;
        int i11 = a10.top;
        J.u(i10, i11, a10.right, i11 + width);
        e J2 = J(1);
        int i12 = a10.left;
        int i13 = a10.bottom;
        J2.u(i12, i13 - width, a10.right, i13);
    }
}
