package k2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bigkoo.pickerview.lib.WheelView;

public final class b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    public final WheelView f7294a;

    public b(WheelView wheelView) {
        this.f7294a = wheelView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        this.f7294a.g(f11);
        return true;
    }
}
