package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

public class w implements x {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroupOverlay f3278a;

    public w(ViewGroup viewGroup) {
        this.f3278a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f3278a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f3278a.remove(drawable);
    }

    public void c(View view) {
        this.f3278a.add(view);
    }

    public void d(View view) {
        this.f3278a.remove(view);
    }
}
