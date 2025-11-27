package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class h extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public float f1500a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f1501b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f1502c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f1503d;

    /* renamed from: e  reason: collision with root package name */
    public float f1504e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1505f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1506g = true;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f1507h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffColorFilter f1508i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f1509j;

    /* renamed from: k  reason: collision with root package name */
    public PorterDuff.Mode f1510k = PorterDuff.Mode.SRC_IN;

    public h(ColorStateList colorStateList, float f10) {
        this.f1500a = f10;
        this.f1501b = new Paint(5);
        e(colorStateList);
        this.f1502c = new RectF();
        this.f1503d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f1507h;
    }

    public float c() {
        return this.f1504e;
    }

    public float d() {
        return this.f1500a;
    }

    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f1501b;
        if (this.f1508i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f1508i);
            z10 = true;
        }
        RectF rectF = this.f1502c;
        float f10 = this.f1500a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1507h = colorStateList;
        this.f1501b.setColor(colorStateList.getColorForState(getState(), this.f1507h.getDefaultColor()));
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f10, boolean z10, boolean z11) {
        if (f10 != this.f1504e || this.f1505f != z10 || this.f1506g != z11) {
            this.f1504e = f10;
            this.f1505f = z10;
            this.f1506g = z11;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1503d, this.f1500a);
    }

    public void h(float f10) {
        if (f10 != this.f1500a) {
            this.f1500a = f10;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1502c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1503d.set(rect);
        if (this.f1505f) {
            float d10 = i.d(this.f1504e, this.f1500a, this.f1506g);
            this.f1503d.inset((int) Math.ceil((double) i.c(this.f1504e, this.f1500a, this.f1506g)), (int) Math.ceil((double) d10));
            this.f1502c.set(this.f1503d);
        }
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1509j;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && (((colorStateList = this.f1507h) == null || !colorStateList.isStateful()) && !super.isStateful())) {
            return false;
        }
        return true;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1507h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState != this.f1501b.getColor()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f1501b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1509j;
        if (colorStateList2 == null || (mode = this.f1510k) == null) {
            return z10;
        }
        this.f1508i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i10) {
        this.f1501b.setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1501b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1509j = colorStateList;
        this.f1508i = a(colorStateList, this.f1510k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f1510k = mode;
        this.f1508i = a(this.f1509j, mode);
        invalidateSelf();
    }
}
