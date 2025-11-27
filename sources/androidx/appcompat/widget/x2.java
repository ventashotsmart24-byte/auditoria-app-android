package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public class x2 extends Resources {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1445b = false;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f1446a;

    public x2(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1446a = new WeakReference(context);
    }

    public static boolean a() {
        return f1445b;
    }

    public static boolean b() {
        if (!a() || Build.VERSION.SDK_INT > 20) {
            return false;
        }
        return true;
    }

    public final Drawable c(int i10) {
        return super.getDrawable(i10);
    }

    public Drawable getDrawable(int i10) {
        Context context = (Context) this.f1446a.get();
        if (context != null) {
            return e2.h().t(context, this, i10);
        }
        return super.getDrawable(i10);
    }
}
