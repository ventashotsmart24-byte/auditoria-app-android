package m6;

import android.view.MotionEvent;
import android.view.View;
import com.mobile.brasiltv.player.TitanPlayerController;

public final /* synthetic */ class v0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18936a;

    public /* synthetic */ v0(TitanPlayerController titanPlayerController) {
        this.f18936a = titanPlayerController;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TitanPlayerController.w4(this.f18936a, view, motionEvent);
    }
}
