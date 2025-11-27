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

public final class ei extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f15913a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f15914b = new Paint(3);

    /* renamed from: c  reason: collision with root package name */
    private final BitmapShader f15915c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f15916d = new Matrix();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f15917e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f15918f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private boolean f15919g = true;

    /* renamed from: h  reason: collision with root package name */
    private int f15920h;

    /* renamed from: i  reason: collision with root package name */
    private int f15921i;

    /* renamed from: j  reason: collision with root package name */
    private final int f15922j;

    public ei(Bitmap bitmap, int i10) {
        this.f15913a = bitmap;
        this.f15922j = i10;
        this.f15920h = bitmap.getWidth();
        this.f15921i = bitmap.getHeight();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f15915c = new BitmapShader(bitmap, tileMode, tileMode);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = this.f15913a;
        if (bitmap != null) {
            canvas.getClipBounds(this.f15917e);
            if (this.f15919g) {
                this.f15918f.set(this.f15917e);
                if (this.f15915c != null) {
                    Matrix matrix = this.f15916d;
                    RectF rectF = this.f15918f;
                    matrix.setTranslate(rectF.left, rectF.top);
                    int width = this.f15913a.getWidth();
                    int height = this.f15913a.getHeight();
                    if (!(width == 0 || height == 0)) {
                        this.f15916d.preScale((((float) this.f15917e.width()) * 1.0f) / ((float) width), (((float) this.f15917e.height()) * 1.0f) / ((float) height));
                        this.f15915c.setLocalMatrix(this.f15916d);
                        this.f15914b.setShader(this.f15915c);
                    }
                }
                this.f15919g = false;
            }
            if (this.f15914b.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f15917e, this.f15914b);
                return;
            }
            RectF rectF2 = this.f15918f;
            int i10 = this.f15922j;
            canvas.drawRoundRect(rectF2, (float) i10, (float) i10, this.f15914b);
        }
    }

    public final int getAlpha() {
        return this.f15914b.getAlpha();
    }

    public final ColorFilter getColorFilter() {
        return this.f15914b.getColorFilter();
    }

    public final int getIntrinsicHeight() {
        return this.f15921i;
    }

    public final int getIntrinsicWidth() {
        return this.f15920h;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f15919g = true;
    }

    public final void setAlpha(int i10) {
        if (i10 != this.f15914b.getAlpha()) {
            this.f15914b.setAlpha(i10);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f15914b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void setDither(boolean z10) {
        this.f15914b.setDither(z10);
        invalidateSelf();
    }

    public final void setFilterBitmap(boolean z10) {
        this.f15914b.setFilterBitmap(z10);
        invalidateSelf();
    }
}
