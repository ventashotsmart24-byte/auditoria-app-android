package m6;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.mobile.brasiltv.player.TitanPlayerController;

public final /* synthetic */ class w implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18938a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GestureDetector f18939b;

    public /* synthetic */ w(TitanPlayerController titanPlayerController, GestureDetector gestureDetector) {
        this.f18938a = titanPlayerController;
        this.f18939b = gestureDetector;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TitanPlayerController.R3(this.f18938a, this.f18939b, view, motionEvent);
    }
}
