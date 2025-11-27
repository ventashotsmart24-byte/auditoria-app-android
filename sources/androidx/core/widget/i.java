package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public EdgeEffect f1814a;

    public i(Context context) {
        this.f1814a = new EdgeEffect(context);
    }

    public static void d(EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f10, f11);
        } else {
            edgeEffect.onPull(f10);
        }
    }

    public boolean a(Canvas canvas) {
        return this.f1814a.draw(canvas);
    }

    public void b() {
        this.f1814a.finish();
    }

    public boolean c() {
        return this.f1814a.isFinished();
    }

    public boolean e(float f10) {
        this.f1814a.onPull(f10);
        return true;
    }

    public boolean f() {
        this.f1814a.onRelease();
        return this.f1814a.isFinished();
    }

    public void g(int i10, int i11) {
        this.f1814a.setSize(i10, i11);
    }
}
