package i4;

import android.animation.ValueAnimator;
import com.taobao.accs.flowcontrol.FlowControl;
import h4.e;
import h4.f;

public class d extends f {

    public class a extends h4.a {
        public a() {
            setAlpha(153);
        }

        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            return new f4.d(this).l(fArr, 0.0f, 1.0f, 0.0f).c(2000).d(fArr).b();
        }
    }

    public void M(e... eVarArr) {
        super.M(eVarArr);
        eVarArr[1].s(FlowControl.DELAY_MAX_BRUSH);
    }

    public e[] N() {
        return new e[]{new a(), new a()};
    }
}
