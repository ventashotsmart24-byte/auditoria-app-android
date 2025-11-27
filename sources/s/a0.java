package s;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import androidx.appcompat.widget.o;
import java.lang.reflect.Method;

public class a0 extends y {

    /* renamed from: h  reason: collision with root package name */
    public static Method f9193h;

    public a0(Drawable drawable) {
        super(drawable);
        g();
    }

    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f9208f;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || o.a(drawable)) {
            return true;
        }
        return false;
    }

    public final void g() {
        if (f9193h == null) {
            try {
                f9193h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    public Rect getDirtyBounds() {
        return this.f9208f.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f9208f.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f9208f;
        if (!(drawable == null || (method = f9193h) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void setHotspot(float f10, float f11) {
        this.f9208f.setHotspot(f10, f11);
    }

    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        this.f9208f.setHotspotBounds(i10, i11, i12, i13);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i10) {
        if (c()) {
            super.setTint(i10);
        } else {
            this.f9208f.setTint(i10);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f9208f.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f9208f.setTintMode(mode);
        }
    }

    public a0(b0 b0Var, Resources resources) {
        super(b0Var, resources);
        g();
    }
}
