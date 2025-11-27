package com.mobile.brasiltv.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import t9.i;

public final class FixGifStateDrawable extends Drawable {
    private final Drawable normalDrawable;
    private final Drawable selectDrawable;

    public FixGifStateDrawable(Drawable drawable, Drawable drawable2) {
        i.g(drawable, "normalDrawable");
        i.g(drawable2, "selectDrawable");
        this.normalDrawable = drawable;
        this.selectDrawable = drawable2;
    }

    public void draw(Canvas canvas) {
        i.g(canvas, "canvas");
    }

    public final Drawable getNormalDrawable() {
        return this.normalDrawable;
    }

    public int getOpacity() {
        return -1;
    }

    public final Drawable getSelectDrawable() {
        return this.selectDrawable;
    }

    public void setAlpha(int i10) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
