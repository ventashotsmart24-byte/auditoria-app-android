package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R$color;
import androidx.cardview.R$dimen;

public class i extends Drawable {

    /* renamed from: q  reason: collision with root package name */
    public static final double f1511q = Math.cos(Math.toRadians(45.0d));

    /* renamed from: r  reason: collision with root package name */
    public static a f1512r;

    /* renamed from: a  reason: collision with root package name */
    public final int f1513a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f1514b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f1515c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f1516d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f1517e;

    /* renamed from: f  reason: collision with root package name */
    public float f1518f;

    /* renamed from: g  reason: collision with root package name */
    public Path f1519g;

    /* renamed from: h  reason: collision with root package name */
    public float f1520h;

    /* renamed from: i  reason: collision with root package name */
    public float f1521i;

    /* renamed from: j  reason: collision with root package name */
    public float f1522j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f1523k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1524l = true;

    /* renamed from: m  reason: collision with root package name */
    public final int f1525m;

    /* renamed from: n  reason: collision with root package name */
    public final int f1526n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1527o = true;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1528p = false;

    public interface a {
        void a(Canvas canvas, RectF rectF, float f10, Paint paint);
    }

    public i(Resources resources, ColorStateList colorStateList, float f10, float f11, float f12) {
        this.f1525m = resources.getColor(R$color.cardview_shadow_start_color);
        this.f1526n = resources.getColor(R$color.cardview_shadow_end_color);
        this.f1513a = resources.getDimensionPixelSize(R$dimen.cardview_compat_inset_shadow);
        this.f1514b = new Paint(5);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f1515c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1518f = (float) ((int) (f10 + 0.5f));
        this.f1517e = new RectF();
        Paint paint2 = new Paint(this.f1515c);
        this.f1516d = paint2;
        paint2.setAntiAlias(false);
        s(f11, f12);
    }

    public static float c(float f10, float f11, boolean z10) {
        if (!z10) {
            return f10;
        }
        double d10 = (double) f10;
        double d11 = (double) f11;
        Double.isNaN(d11);
        Double.isNaN(d10);
        return (float) (d10 + ((1.0d - f1511q) * d11));
    }

    public static float d(float f10, float f11, boolean z10) {
        if (!z10) {
            return f10 * 1.5f;
        }
        double d10 = (double) (f10 * 1.5f);
        double d11 = (double) f11;
        Double.isNaN(d11);
        Double.isNaN(d10);
        return (float) (d10 + ((1.0d - f1511q) * d11));
    }

    public final void a(Rect rect) {
        float f10 = this.f1520h;
        float f11 = 1.5f * f10;
        this.f1517e.set(((float) rect.left) + f10, ((float) rect.top) + f11, ((float) rect.right) - f10, ((float) rect.bottom) - f11);
        b();
    }

    public final void b() {
        float f10 = this.f1518f;
        RectF rectF = new RectF(-f10, -f10, f10, f10);
        RectF rectF2 = new RectF(rectF);
        float f11 = this.f1521i;
        rectF2.inset(-f11, -f11);
        Path path = this.f1519g;
        if (path == null) {
            this.f1519g = new Path();
        } else {
            path.reset();
        }
        this.f1519g.setFillType(Path.FillType.EVEN_ODD);
        this.f1519g.moveTo(-this.f1518f, 0.0f);
        this.f1519g.rLineTo(-this.f1521i, 0.0f);
        this.f1519g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1519g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1519g.close();
        float f12 = this.f1518f;
        float f13 = f12 / (this.f1521i + f12);
        Paint paint = this.f1515c;
        float f14 = this.f1518f + this.f1521i;
        int i10 = this.f1525m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f14, new int[]{i10, i10, this.f1526n}, new float[]{0.0f, f13, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1516d;
        float f15 = this.f1518f;
        float f16 = this.f1521i;
        float f17 = (-f15) - f16;
        int i11 = this.f1525m;
        paint2.setShader(new LinearGradient(0.0f, (-f15) + f16, 0.0f, f17, new int[]{i11, i11, this.f1526n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1516d.setAntiAlias(false);
    }

    public void draw(Canvas canvas) {
        if (this.f1524l) {
            a(getBounds());
            this.f1524l = false;
        }
        canvas.translate(0.0f, this.f1522j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f1522j) / 2.0f);
        f1512r.a(canvas, this.f1517e, this.f1518f, this.f1514b);
    }

    public final void e(Canvas canvas) {
        boolean z10;
        boolean z11;
        float f10 = this.f1518f;
        float f11 = (-f10) - this.f1521i;
        float f12 = f10 + ((float) this.f1513a) + (this.f1522j / 2.0f);
        float f13 = f12 * 2.0f;
        if (this.f1517e.width() - f13 > 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f1517e.height() - f13 > 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        int save = canvas.save();
        RectF rectF = this.f1517e;
        canvas.translate(rectF.left + f12, rectF.top + f12);
        canvas.drawPath(this.f1519g, this.f1515c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1517e.width() - f13, -this.f1518f, this.f1516d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1517e;
        canvas.translate(rectF2.right - f12, rectF2.bottom - f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1519g, this.f1515c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1517e.width() - f13, (-this.f1518f) + this.f1521i, this.f1516d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1517e;
        canvas.translate(rectF3.left + f12, rectF3.bottom - f12);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1519g, this.f1515c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1517e.height() - f13, -this.f1518f, this.f1516d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1517e;
        canvas.translate(rectF4.right - f12, rectF4.top + f12);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1519g, this.f1515c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1517e.height() - f13, -this.f1518f, this.f1516d);
        }
        canvas.restoreToCount(save4);
    }

    public ColorStateList f() {
        return this.f1523k;
    }

    public float g() {
        return this.f1518f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) d(this.f1520h, this.f1518f, this.f1527o));
        int ceil2 = (int) Math.ceil((double) c(this.f1520h, this.f1518f, this.f1527o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public void h(Rect rect) {
        getPadding(rect);
    }

    public float i() {
        return this.f1520h;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f1523k;
        if ((colorStateList == null || !colorStateList.isStateful()) && !super.isStateful()) {
            return false;
        }
        return true;
    }

    public float j() {
        float f10 = this.f1520h;
        return (Math.max(f10, this.f1518f + ((float) this.f1513a) + ((f10 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1520h * 1.5f) + ((float) this.f1513a)) * 2.0f);
    }

    public float k() {
        float f10 = this.f1520h;
        return (Math.max(f10, this.f1518f + ((float) this.f1513a) + (f10 / 2.0f)) * 2.0f) + ((this.f1520h + ((float) this.f1513a)) * 2.0f);
    }

    public float l() {
        return this.f1522j;
    }

    public void m(boolean z10) {
        this.f1527o = z10;
        invalidateSelf();
    }

    public final void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1523k = colorStateList;
        this.f1514b.setColor(colorStateList.getColorForState(getState(), this.f1523k.getDefaultColor()));
    }

    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1524l = true;
    }

    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1523k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1514b.getColor() == colorForState) {
            return false;
        }
        this.f1514b.setColor(colorForState);
        this.f1524l = true;
        invalidateSelf();
        return true;
    }

    public void p(float f10) {
        if (f10 >= 0.0f) {
            float f11 = (float) ((int) (f10 + 0.5f));
            if (this.f1518f != f11) {
                this.f1518f = f11;
                this.f1524l = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f10 + ". Must be >= 0");
    }

    public void q(float f10) {
        s(this.f1522j, f10);
    }

    public void r(float f10) {
        s(f10, this.f1520h);
    }

    public final void s(float f10, float f11) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f10 + ". Must be >= 0");
        } else if (f11 >= 0.0f) {
            float t10 = (float) t(f10);
            float t11 = (float) t(f11);
            if (t10 > t11) {
                if (!this.f1528p) {
                    this.f1528p = true;
                }
                t10 = t11;
            }
            if (this.f1522j != t10 || this.f1520h != t11) {
                this.f1522j = t10;
                this.f1520h = t11;
                this.f1521i = (float) ((int) ((t10 * 1.5f) + ((float) this.f1513a) + 0.5f));
                this.f1524l = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f11 + ". Must be >= 0");
        }
    }

    public void setAlpha(int i10) {
        this.f1514b.setAlpha(i10);
        this.f1515c.setAlpha(i10);
        this.f1516d.setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1514b.setColorFilter(colorFilter);
    }

    public final int t(float f10) {
        int i10 = (int) (f10 + 0.5f);
        if (i10 % 2 == 1) {
            return i10 - 1;
        }
        return i10;
    }
}
