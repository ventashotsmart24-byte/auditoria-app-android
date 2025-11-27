package com.mobile.brasiltv.utils.zxing.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.hpplay.cybergarage.upnp.UPnP;
import com.mobile.brasiltv.R$styleable;
import d7.c;
import java.util.Collection;
import java.util.HashSet;

public final class ViewfinderView extends View {

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f12664m = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: n  reason: collision with root package name */
    public static int f12665n = 0;

    /* renamed from: o  reason: collision with root package name */
    public static int f12666o = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Paint f12667a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f12668b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12669c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12670d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12671e;

    /* renamed from: f  reason: collision with root package name */
    public final int f12672f;

    /* renamed from: g  reason: collision with root package name */
    public final int f12673g;

    /* renamed from: h  reason: collision with root package name */
    public final int f12674h;

    /* renamed from: i  reason: collision with root package name */
    public int f12675i = 0;

    /* renamed from: j  reason: collision with root package name */
    public final int f12676j;

    /* renamed from: k  reason: collision with root package name */
    public final float f12677k;

    /* renamed from: l  reason: collision with root package name */
    public Collection f12678l = new HashSet(5);

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.F);
        this.f12672f = obtainStyledAttributes.getColor(5, 65280);
        this.f12673g = obtainStyledAttributes.getColor(0, 65280);
        this.f12671e = obtainStyledAttributes.getColor(1, UPnP.CONFIGID_UPNP_ORG_MAX);
        this.f12674h = obtainStyledAttributes.getColor(8, -1056964864);
        this.f12669c = obtainStyledAttributes.getColor(6, 0);
        this.f12670d = obtainStyledAttributes.getColor(7, -1342177280);
        this.f12676j = obtainStyledAttributes.getColor(3, -1862270977);
        this.f12677k = obtainStyledAttributes.getFloat(4, 36.0f);
        Paint paint = new Paint();
        this.f12667a = paint;
        paint.setAntiAlias(true);
    }

    public void a(ResultPoint resultPoint) {
        this.f12678l.add(resultPoint);
    }

    public final void b(Canvas canvas, Rect rect) {
        this.f12667a.setColor(this.f12673g);
        int i10 = rect.left;
        int i11 = rect.top;
        canvas.drawRect((float) i10, (float) i11, (float) (i10 + 8), (float) (i11 + 40), this.f12667a);
        int i12 = rect.left;
        int i13 = rect.top;
        canvas.drawRect((float) i12, (float) i13, (float) (i12 + 40), (float) (i13 + 8), this.f12667a);
        int i14 = rect.right;
        int i15 = rect.top;
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) (i14 - 8), (float) i15, (float) i14, (float) (i15 + 40), this.f12667a);
        int i16 = rect.right;
        int i17 = rect.top;
        canvas2.drawRect((float) (i16 - 40), (float) i17, (float) i16, (float) (i17 + 8), this.f12667a);
        int i18 = rect.left;
        int i19 = rect.bottom;
        canvas.drawRect((float) i18, (float) (i19 - 8), (float) (i18 + 40), (float) i19, this.f12667a);
        int i20 = rect.left;
        int i21 = rect.bottom;
        canvas.drawRect((float) i20, (float) (i21 - 40), (float) (i20 + 8), (float) i21, this.f12667a);
        int i22 = rect.right;
        int i23 = rect.bottom;
        Canvas canvas3 = canvas;
        canvas3.drawRect((float) (i22 - 8), (float) (i23 - 40), (float) i22, (float) i23, this.f12667a);
        int i24 = rect.right;
        int i25 = rect.bottom;
        canvas3.drawRect((float) (i24 - 40), (float) (i25 - 8), (float) i24, (float) i25, this.f12667a);
    }

    public final void c(Canvas canvas, Rect rect, int i10, int i11) {
        int i12;
        Rect rect2 = rect;
        Paint paint = this.f12667a;
        if (this.f12668b != null) {
            i12 = this.f12670d;
        } else {
            i12 = this.f12669c;
        }
        paint.setColor(i12);
        float f10 = (float) i10;
        canvas.drawRect(0.0f, 0.0f, f10, (float) rect2.top, this.f12667a);
        canvas.drawRect(0.0f, (float) rect2.top, (float) rect2.left, (float) (rect2.bottom + 1), this.f12667a);
        Canvas canvas2 = canvas;
        float f11 = f10;
        canvas2.drawRect((float) (rect2.right + 1), (float) rect2.top, f11, (float) (rect2.bottom + 1), this.f12667a);
        canvas2.drawRect(0.0f, (float) (rect2.bottom + 1), f11, (float) i11, this.f12667a);
    }

    public final void d(Canvas canvas, Rect rect) {
        this.f12667a.setColor(this.f12671e);
        float f10 = (float) rect.left;
        int i10 = rect.top;
        canvas.drawRect(f10, (float) i10, (float) (rect.right + 1), (float) (i10 + 2), this.f12667a);
        int i11 = rect.left;
        canvas.drawRect((float) i11, (float) (rect.top + 2), (float) (i11 + 2), (float) (rect.bottom - 1), this.f12667a);
        int i12 = rect.right;
        canvas.drawRect((float) (i12 - 1), (float) rect.top, (float) (i12 + 1), (float) (rect.bottom - 1), this.f12667a);
        float f11 = (float) rect.left;
        int i13 = rect.bottom;
        canvas.drawRect(f11, (float) (i13 - 1), (float) (rect.right + 1), (float) (i13 + 1), this.f12667a);
    }

    public final void e(Canvas canvas, Rect rect) {
        Rect rect2 = rect;
        this.f12667a.setColor(this.f12672f);
        int i10 = rect2.left;
        int i11 = f12665n;
        LinearGradient linearGradient = new LinearGradient((float) i10, (float) i11, (float) i10, (float) (i11 + 10), h(this.f12672f), this.f12672f, Shader.TileMode.MIRROR);
        float width = (float) (rect2.left + (rect.width() / 2));
        float f10 = (float) (f12665n + 5);
        int i12 = this.f12672f;
        RadialGradient radialGradient = new RadialGradient(width, f10, 360.0f, i12, h(i12), Shader.TileMode.MIRROR);
        new SweepGradient((float) (rect2.left + (rect.width() / 2)), (float) (f12665n + 10), h(this.f12672f), this.f12672f);
        new ComposeShader(radialGradient, linearGradient, PorterDuff.Mode.ADD);
        this.f12667a.setShader(radialGradient);
        if (f12665n <= f12666o) {
            int i13 = f12665n;
            canvas.drawOval(new RectF((float) (rect2.left + 20), (float) i13, (float) (rect2.right - 20), (float) (i13 + 10)), this.f12667a);
            f12665n += 5;
        } else {
            f12665n = rect2.top;
        }
        this.f12667a.setShader((Shader) null);
    }

    public final void f(Canvas canvas, Rect rect) {
        this.f12667a.setColor(this.f12676j);
        this.f12667a.setTextSize(this.f12677k);
        this.f12667a.setTextAlign(Paint.Align.CENTER);
    }

    public void g() {
        this.f12668b = null;
        invalidate();
    }

    public int h(int i10) {
        String hexString = Integer.toHexString(i10);
        return Integer.valueOf("20" + hexString.substring(2), 16).intValue();
    }

    public void onDraw(Canvas canvas) {
        Rect d10 = c.c().d();
        if (d10 != null) {
            if (f12665n == 0 || f12666o == 0) {
                f12665n = d10.top;
                f12666o = d10.bottom;
            }
            c(canvas, d10, canvas.getWidth(), canvas.getHeight());
            if (this.f12668b != null) {
                this.f12667a.setAlpha(255);
                canvas.drawBitmap(this.f12668b, (float) d10.left, (float) d10.top, this.f12667a);
                return;
            }
            d(canvas, d10);
            b(canvas, d10);
            f(canvas, d10);
            e(canvas, d10);
            postInvalidateDelayed(10, d10.left, d10.top, d10.right, d10.bottom);
        }
    }
}
