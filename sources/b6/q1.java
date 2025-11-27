package b6;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class q1 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r1 f11066a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GestureDetector f11067b;

    public /* synthetic */ q1(r1 r1Var, GestureDetector gestureDetector) {
        this.f11066a = r1Var;
        this.f11067b = gestureDetector;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return r1.h5(this.f11066a, this.f11067b, view, motionEvent);
    }
}
