package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.core.widget.n;
import d.b;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f1304a;

    /* renamed from: b  reason: collision with root package name */
    public p2 f1305b;

    /* renamed from: c  reason: collision with root package name */
    public p2 f1306c;

    /* renamed from: d  reason: collision with root package name */
    public p2 f1307d;

    public p(ImageView imageView) {
        this.f1304a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f1307d == null) {
            this.f1307d = new p2();
        }
        p2 p2Var = this.f1307d;
        p2Var.a();
        ColorStateList a10 = n.a(this.f1304a);
        if (a10 != null) {
            p2Var.f1330d = true;
            p2Var.f1327a = a10;
        }
        PorterDuff.Mode b10 = n.b(this.f1304a);
        if (b10 != null) {
            p2Var.f1329c = true;
            p2Var.f1328b = b10;
        }
        if (!p2Var.f1330d && !p2Var.f1329c) {
            return false;
        }
        k.i(drawable, p2Var, this.f1304a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable drawable = this.f1304a.getDrawable();
        if (drawable != null) {
            o1.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!j() || !a(drawable)) {
            p2 p2Var = this.f1306c;
            if (p2Var != null) {
                k.i(drawable, p2Var, this.f1304a.getDrawableState());
                return;
            }
            p2 p2Var2 = this.f1305b;
            if (p2Var2 != null) {
                k.i(drawable, p2Var2, this.f1304a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        p2 p2Var = this.f1306c;
        if (p2Var != null) {
            return p2Var.f1327a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        p2 p2Var = this.f1306c;
        if (p2Var != null) {
            return p2Var.f1328b;
        }
        return null;
    }

    public boolean e() {
        Drawable background = this.f1304a.getBackground();
        if (Build.VERSION.SDK_INT < 21 || !o.a(background)) {
            return true;
        }
        return false;
    }

    public void f(AttributeSet attributeSet, int i10) {
        int n10;
        r2 u10 = r2.u(this.f1304a.getContext(), attributeSet, R$styleable.f550k, i10, 0);
        try {
            Drawable drawable = this.f1304a.getDrawable();
            if (!(drawable != null || (n10 = u10.n(R$styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = b.d(this.f1304a.getContext(), n10)) == null)) {
                this.f1304a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                o1.b(drawable);
            }
            int i11 = R$styleable.AppCompatImageView_tint;
            if (u10.r(i11)) {
                n.c(this.f1304a, u10.c(i11));
            }
            int i12 = R$styleable.AppCompatImageView_tintMode;
            if (u10.r(i12)) {
                n.d(this.f1304a, o1.e(u10.k(i12, -1), (PorterDuff.Mode) null));
            }
        } finally {
            u10.v();
        }
    }

    public void g(int i10) {
        if (i10 != 0) {
            Drawable d10 = b.d(this.f1304a.getContext(), i10);
            if (d10 != null) {
                o1.b(d10);
            }
            this.f1304a.setImageDrawable(d10);
        } else {
            this.f1304a.setImageDrawable((Drawable) null);
        }
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (this.f1306c == null) {
            this.f1306c = new p2();
        }
        p2 p2Var = this.f1306c;
        p2Var.f1327a = colorStateList;
        p2Var.f1330d = true;
        b();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.f1306c == null) {
            this.f1306c = new p2();
        }
        p2 p2Var = this.f1306c;
        p2Var.f1328b = mode;
        p2Var.f1329c = true;
        b();
    }

    public final boolean j() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 21) {
            if (this.f1305b != null) {
                return true;
            }
            return false;
        } else if (i10 == 21) {
            return true;
        } else {
            return false;
        }
    }
}
