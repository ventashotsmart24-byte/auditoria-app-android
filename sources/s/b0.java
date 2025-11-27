package s;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

public final class b0 extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public int f9194a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable.ConstantState f9195b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f9196c = null;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f9197d = y.f9202g;

    public b0(b0 b0Var) {
        if (b0Var != null) {
            this.f9194a = b0Var.f9194a;
            this.f9195b = b0Var.f9195b;
            this.f9196c = b0Var.f9196c;
            this.f9197d = b0Var.f9197d;
        }
    }

    public boolean a() {
        if (this.f9195b != null) {
            return true;
        }
        return false;
    }

    public int getChangingConfigurations() {
        int i10;
        int i11 = this.f9194a;
        Drawable.ConstantState constantState = this.f9195b;
        if (constantState != null) {
            i10 = constantState.getChangingConfigurations();
        } else {
            i10 = 0;
        }
        return i11 | i10;
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new a0(this, resources);
        }
        return new y(this, resources);
    }
}
