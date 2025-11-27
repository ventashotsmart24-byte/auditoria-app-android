package d7;

import android.hardware.Camera;
import android.os.Handler;

public final class a implements Camera.AutoFocusCallback {

    /* renamed from: a  reason: collision with root package name */
    public Handler f16348a;

    /* renamed from: b  reason: collision with root package name */
    public int f16349b;

    public void a(Handler handler, int i10) {
        this.f16348a = handler;
        this.f16349b = i10;
    }

    public void onAutoFocus(boolean z10, Camera camera) {
        Handler handler = this.f16348a;
        if (handler != null) {
            this.f16348a.sendMessageDelayed(handler.obtainMessage(this.f16349b, Boolean.valueOf(z10)), 1500);
            this.f16348a = null;
        }
    }
}
