package com.umeng.message.proguard;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public final class au extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f15429a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f15430b = new Paint(3);

    /* renamed from: c  reason: collision with root package name */
    private final BitmapShader f15431c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f15432d = new Matrix();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f15433e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f15434f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private boolean f15435g = true;

    /* renamed from: h  reason: collision with root package name */
    private final int f15436h;

    /* renamed from: i  reason: collision with root package name */
    private final int f15437i;

    /* renamed from: j  reason: collision with root package name */
    private final int f15438j;

    public au(Bitmap bitmap, int i10) {
        this.f15429a = bitmap;
        this.f15438j = i10;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f15431c = new BitmapShader(bitmap, tileMode, tileMode);
        this.f15436h = bitmap.getWidth();
        this.f15437i = bitmap.getHeight();
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap;
        if (canvas != null && (bitmap = this.f15429a) != null) {
            canvas.getClipBounds(this.f15433e);
            if (this.f15435g) {
                this.f15434f.set(this.f15433e);
                if (this.f15431c != null) {
                    Matrix matrix = this.f15432d;
                    RectF rectF = this.f15434f;
                    matrix.setTranslate(rectF.left, rectF.top);
                    int width = this.f15429a.getWidth();
                    int height = this.f15429a.getHeight();
                    if (!(width == 0 || height == 0)) {
                        this.f15432d.preScale((((float) this.f15433e.width()) * 1.0f) / ((float) width), (((float) this.f15433e.height()) * 1.0f) / ((float) height));
                        this.f15431c.setLocalMatrix(this.f15432d);
                        this.f15430b.setShader(this.f15431c);
                    }
                }
                this.f15435g = false;
            }
            if (this.f15430b.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f15433e, this.f15430b);
                return;
            }
            RectF rectF2 = this.f15434f;
            int i10 = this.f15438j;
            canvas.drawRoundRect(rectF2, (float) i10, (float) i10, this.f15430b);
        }
    }

    public final int getAlpha() {
        return this.f15430b.getAlpha();
    }

    public final ColorFilter getColorFilter() {
        return this.f15430b.getColorFilter();
    }

    public final int getIntrinsicHeight() {
        return this.f15437i;
    }

    public final int getIntrinsicWidth() {
        return this.f15436h;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f15435g = true;
    }

    public final void setAlpha(int i10) {
        if (i10 != this.f15430b.getAlpha()) {
            this.f15430b.setAlpha(i10);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f15430b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void setDither(boolean z10) {
        this.f15430b.setDither(z10);
        invalidateSelf();
    }

    public final void setFilterBitmap(boolean z10) {
        this.f15430b.setFilterBitmap(z10);
        invalidateSelf();
    }
}
