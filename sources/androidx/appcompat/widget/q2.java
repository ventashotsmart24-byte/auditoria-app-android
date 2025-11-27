package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public class q2 extends h2 {

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference f1331b;

    public q2(Context context, Resources resources) {
        super(resources);
        this.f1331b = new WeakReference(context);
    }

    public Drawable getDrawable(int i10) {
        Drawable drawable = super.getDrawable(i10);
        Context context = (Context) this.f1331b.get();
        if (!(drawable == null || context == null)) {
            e2.h().x(context, i10, drawable);
        }
        return drawable;
    }
}
