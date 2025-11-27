package s;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public class y extends Drawable implements Drawable.Callback, x, w {

    /* renamed from: g  reason: collision with root package name */
    public static final PorterDuff.Mode f9202g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f9203a;

    /* renamed from: b  reason: collision with root package name */
    public PorterDuff.Mode f9204b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9205c;

    /* renamed from: d  reason: collision with root package name */
    public b0 f9206d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9207e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f9208f;

    public y(b0 b0Var, Resources resources) {
        this.f9206d = b0Var;
        e(resources);
    }

    public final Drawable a() {
        return this.f9208f;
    }

    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f9208f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f9208f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            b0 b0Var = this.f9206d;
            if (b0Var != null) {
                b0Var.f9195b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public boolean c() {
        return true;
    }

    public final b0 d() {
        return new b0(this.f9206d);
    }

    public void draw(Canvas canvas) {
        this.f9208f.draw(canvas);
    }

    public final void e(Resources resources) {
        Drawable.ConstantState constantState;
        b0 b0Var = this.f9206d;
        if (b0Var != null && (constantState = b0Var.f9195b) != null) {
            b(constantState.newDrawable(resources));
        }
    }

    public final boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        b0 b0Var = this.f9206d;
        ColorStateList colorStateList = b0Var.f9196c;
        PorterDuff.Mode mode = b0Var.f9197d;
        if (colorStateList == null || mode == null) {
            this.f9205c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f9205c && colorForState == this.f9203a && mode == this.f9204b)) {
                setColorFilter(colorForState, mode);
                this.f9203a = colorForState;
                this.f9204b = mode;
                this.f9205c = true;
                return true;
            }
        }
        return false;
    }

    public int getChangingConfigurations() {
        int i10;
        int changingConfigurations = super.getChangingConfigurations();
        b0 b0Var = this.f9206d;
        if (b0Var != null) {
            i10 = b0Var.getChangingConfigurations();
        } else {
            i10 = 0;
        }
        return changingConfigurations | i10 | this.f9208f.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        b0 b0Var = this.f9206d;
        if (b0Var == null || !b0Var.a()) {
            return null;
        }
        this.f9206d.f9194a = getChangingConfigurations();
        return this.f9206d;
    }

    public Drawable getCurrent() {
        return this.f9208f.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f9208f.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f9208f.getIntrinsicWidth();
    }

    public int getLayoutDirection() {
        return h.f(this.f9208f);
    }

    public int getMinimumHeight() {
        return this.f9208f.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f9208f.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f9208f.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f9208f.getPadding(rect);
    }

    public int[] getState() {
        return this.f9208f.getState();
    }

    public Region getTransparentRegion() {
        return this.f9208f.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return h.h(this.f9208f);
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        b0 b0Var;
        if (!c() || (b0Var = this.f9206d) == null) {
            colorStateList = null;
        } else {
            colorStateList = b0Var.f9196c;
        }
        if ((colorStateList == null || !colorStateList.isStateful()) && !this.f9208f.isStateful()) {
            return false;
        }
        return true;
    }

    public void jumpToCurrentState() {
        this.f9208f.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable.ConstantState constantState;
        if (!this.f9207e && super.mutate() == this) {
            this.f9206d = d();
            Drawable drawable = this.f9208f;
            if (drawable != null) {
                drawable.mutate();
            }
            b0 b0Var = this.f9206d;
            if (b0Var != null) {
                Drawable drawable2 = this.f9208f;
                if (drawable2 != null) {
                    constantState = drawable2.getConstantState();
                } else {
                    constantState = null;
                }
                b0Var.f9195b = constantState;
            }
            this.f9207e = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9208f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i10) {
        return h.m(this.f9208f, i10);
    }

    public boolean onLevelChange(int i10) {
        return this.f9208f.setLevel(i10);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    public void setAlpha(int i10) {
        this.f9208f.setAlpha(i10);
    }

    public void setAutoMirrored(boolean z10) {
        h.j(this.f9208f, z10);
    }

    public void setChangingConfigurations(int i10) {
        this.f9208f.setChangingConfigurations(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f9208f.setColorFilter(colorFilter);
    }

    public void setDither(boolean z10) {
        this.f9208f.setDither(z10);
    }

    public void setFilterBitmap(boolean z10) {
        this.f9208f.setFilterBitmap(z10);
    }

    public boolean setState(int[] iArr) {
        boolean state = this.f9208f.setState(iArr);
        if (f(iArr) || state) {
            return true;
        }
        return false;
    }

    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f9206d.f9196c = colorStateList;
        f(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f9206d.f9197d = mode;
        f(getState());
    }

    public boolean setVisible(boolean z10, boolean z11) {
        if (super.setVisible(z10, z11) || this.f9208f.setVisible(z10, z11)) {
            return true;
        }
        return false;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public y(Drawable drawable) {
        this.f9206d = d();
        b(drawable);
    }
}
