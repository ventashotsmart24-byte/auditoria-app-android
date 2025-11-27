package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import b0.c1;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final View f1231a;

    /* renamed from: b  reason: collision with root package name */
    public final k f1232b;

    /* renamed from: c  reason: collision with root package name */
    public int f1233c = -1;

    /* renamed from: d  reason: collision with root package name */
    public p2 f1234d;

    /* renamed from: e  reason: collision with root package name */
    public p2 f1235e;

    /* renamed from: f  reason: collision with root package name */
    public p2 f1236f;

    public f(View view) {
        this.f1231a = view;
        this.f1232b = k.b();
    }

    public final boolean a(Drawable drawable) {
        if (this.f1236f == null) {
            this.f1236f = new p2();
        }
        p2 p2Var = this.f1236f;
        p2Var.a();
        ColorStateList q10 = c1.q(this.f1231a);
        if (q10 != null) {
            p2Var.f1330d = true;
            p2Var.f1327a = q10;
        }
        PorterDuff.Mode r10 = c1.r(this.f1231a);
        if (r10 != null) {
            p2Var.f1329c = true;
            p2Var.f1328b = r10;
        }
        if (!p2Var.f1330d && !p2Var.f1329c) {
            return false;
        }
        k.i(drawable, p2Var, this.f1231a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f1231a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            p2 p2Var = this.f1235e;
            if (p2Var != null) {
                k.i(background, p2Var, this.f1231a.getDrawableState());
                return;
            }
            p2 p2Var2 = this.f1234d;
            if (p2Var2 != null) {
                k.i(background, p2Var2, this.f1231a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        p2 p2Var = this.f1235e;
        if (p2Var != null) {
            return p2Var.f1327a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        p2 p2Var = this.f1235e;
        if (p2Var != null) {
            return p2Var.f1328b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i10) {
        r2 u10 = r2.u(this.f1231a.getContext(), attributeSet, R$styleable.O, i10, 0);
        try {
            int i11 = R$styleable.ViewBackgroundHelper_android_background;
            if (u10.r(i11)) {
                this.f1233c = u10.n(i11, -1);
                ColorStateList f10 = this.f1232b.f(this.f1231a.getContext(), this.f1233c);
                if (f10 != null) {
                    h(f10);
                }
            }
            int i12 = R$styleable.ViewBackgroundHelper_backgroundTint;
            if (u10.r(i12)) {
                c1.p0(this.f1231a, u10.c(i12));
            }
            int i13 = R$styleable.ViewBackgroundHelper_backgroundTintMode;
            if (u10.r(i13)) {
                c1.q0(this.f1231a, o1.e(u10.k(i13, -1), (PorterDuff.Mode) null));
            }
        } finally {
            u10.v();
        }
    }

    public void f(Drawable drawable) {
        this.f1233c = -1;
        h((ColorStateList) null);
        b();
    }

    public void g(int i10) {
        ColorStateList colorStateList;
        this.f1233c = i10;
        k kVar = this.f1232b;
        if (kVar != null) {
            colorStateList = kVar.f(this.f1231a.getContext(), i10);
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1234d == null) {
                this.f1234d = new p2();
            }
            p2 p2Var = this.f1234d;
            p2Var.f1327a = colorStateList;
            p2Var.f1330d = true;
        } else {
            this.f1234d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f1235e == null) {
            this.f1235e = new p2();
        }
        p2 p2Var = this.f1235e;
        p2Var.f1327a = colorStateList;
        p2Var.f1330d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f1235e == null) {
            this.f1235e = new p2();
        }
        p2 p2Var = this.f1235e;
        p2Var.f1328b = mode;
        p2Var.f1329c = true;
        b();
    }

    public final boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 21) {
            if (this.f1234d != null) {
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
