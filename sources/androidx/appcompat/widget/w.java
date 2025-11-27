package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import b0.c1;
import s.h;

public class w extends t {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f1408d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f1409e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f1410f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f1411g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1412h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1413i = false;

    public w(SeekBar seekBar) {
        super(seekBar);
        this.f1408d = seekBar;
    }

    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        r2 u10 = r2.u(this.f1408d.getContext(), attributeSet, R$styleable.f551l, i10, 0);
        Drawable h10 = u10.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h10 != null) {
            this.f1408d.setThumb(h10);
        }
        j(u10.g(R$styleable.AppCompatSeekBar_tickMark));
        int i11 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (u10.r(i11)) {
            this.f1411g = o1.e(u10.k(i11, -1), this.f1411g);
            this.f1413i = true;
        }
        int i12 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (u10.r(i12)) {
            this.f1410f = u10.c(i12);
            this.f1412h = true;
        }
        u10.v();
        f();
    }

    public final void f() {
        Drawable drawable = this.f1409e;
        if (drawable == null) {
            return;
        }
        if (this.f1412h || this.f1413i) {
            Drawable r10 = h.r(drawable.mutate());
            this.f1409e = r10;
            if (this.f1412h) {
                h.o(r10, this.f1410f);
            }
            if (this.f1413i) {
                h.p(this.f1409e, this.f1411g);
            }
            if (this.f1409e.isStateful()) {
                this.f1409e.setState(this.f1408d.getDrawableState());
            }
        }
    }

    public void g(Canvas canvas) {
        int i10;
        if (this.f1409e != null) {
            int max = this.f1408d.getMax();
            int i11 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1409e.getIntrinsicWidth();
                int intrinsicHeight = this.f1409e.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i10 = intrinsicWidth / 2;
                } else {
                    i10 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i11 = intrinsicHeight / 2;
                }
                this.f1409e.setBounds(-i10, -i11, i10, i11);
                float width = ((float) ((this.f1408d.getWidth() - this.f1408d.getPaddingLeft()) - this.f1408d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1408d.getPaddingLeft(), (float) (this.f1408d.getHeight() / 2));
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f1409e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f1409e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1408d.getDrawableState())) {
            this.f1408d.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.f1409e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.f1409e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1409e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1408d);
            h.m(drawable, c1.z(this.f1408d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1408d.getDrawableState());
            }
            f();
        }
        this.f1408d.invalidate();
    }
}
