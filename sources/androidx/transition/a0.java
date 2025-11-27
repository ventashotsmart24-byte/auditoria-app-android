package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

public class a0 implements b0 {

    /* renamed from: a  reason: collision with root package name */
    public final ViewOverlay f3151a;

    public a0(View view) {
        this.f3151a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f3151a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f3151a.remove(drawable);
    }
}
