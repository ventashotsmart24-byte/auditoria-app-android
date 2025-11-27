package d7;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

public final class f implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    public final b f16375a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f16376b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f16377c;

    /* renamed from: d  reason: collision with root package name */
    public int f16378d;

    public f(b bVar, boolean z10) {
        this.f16375a = bVar;
        this.f16376b = z10;
    }

    public void a(Handler handler, int i10) {
        this.f16377c = handler;
        this.f16378d = i10;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point c10 = this.f16375a.c();
        if (!this.f16376b) {
            camera.setPreviewCallback((Camera.PreviewCallback) null);
        }
        Handler handler = this.f16377c;
        if (handler != null) {
            handler.obtainMessage(this.f16378d, c10.x, c10.y, bArr).sendToTarget();
            this.f16377c = null;
        }
    }
}
