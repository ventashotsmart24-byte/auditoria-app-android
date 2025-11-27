package com.mobile.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.zhy.autolayout.utils.AutoUtils;

public class UpgradeProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f12864a = 0;

    /* renamed from: b  reason: collision with root package name */
    public float f12865b;

    /* renamed from: c  reason: collision with root package name */
    public float f12866c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public Paint f12867d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f12868e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12869f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f12870g = new RectF();

    public UpgradeProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        Paint paint = new Paint(5);
        this.f12867d = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f12867d.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f12867d.setColor(Color.parseColor("#45454d"));
        this.f12868e = new Paint(5);
        Paint paint2 = new Paint(5);
        this.f12869f = paint2;
        paint2.setColor(-1);
        this.f12869f.setTextSize((float) AutoUtils.getPercentWidthSize(24));
    }

    public void onDraw(Canvas canvas) {
        float f10;
        super.onDraw(canvas);
        float f11 = this.f12865b;
        float f12 = this.f12865b;
        canvas.drawLine(f11, f11, ((float) getMeasuredWidth()) - f12, f12, this.f12867d);
        float measuredWidth = ((((float) this.f12864a) * 1.0f) * ((float) getMeasuredWidth())) / 100.0f;
        RectF rectF = this.f12870g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = measuredWidth;
        rectF.bottom = (float) getMeasuredHeight();
        RectF rectF2 = this.f12870g;
        float f13 = this.f12865b;
        canvas.drawRoundRect(rectF2, f13, f13, this.f12868e);
        String str = this.f12864a + Operator.Operation.MOD;
        if (this.f12864a <= 10) {
            f10 = measuredWidth + this.f12865b;
        } else {
            f10 = (measuredWidth - this.f12869f.measureText(str)) - this.f12865b;
        }
        canvas.drawText(str, f10, this.f12866c, this.f12869f);
    }

    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f12865b = (((float) getMeasuredHeight()) * 1.0f) / 2.0f;
        this.f12867d.setStrokeWidth((float) getMeasuredHeight());
        this.f12868e.setShader(new LinearGradient(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), new int[]{Color.parseColor("#56e3ff"), Color.parseColor("#33a7fe")}, (float[]) null, Shader.TileMode.CLAMP));
        this.f12868e.setStrokeWidth((float) getMeasuredHeight());
        Paint.FontMetrics fontMetrics = this.f12869f.getFontMetrics();
        float f10 = this.f12865b;
        float f11 = fontMetrics.bottom;
        this.f12866c = (f10 + ((f11 - fontMetrics.top) / 2.0f)) - f11;
    }

    public void setInvalid(boolean z10) {
        LinearGradient linearGradient;
        if (z10) {
            linearGradient = new LinearGradient(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), new int[]{Color.parseColor("#5c5c66"), Color.parseColor("#5c5c66")}, (float[]) null, Shader.TileMode.CLAMP);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), new int[]{Color.parseColor("#56e3ff"), Color.parseColor("#33a7fe")}, (float[]) null, Shader.TileMode.CLAMP);
        }
        this.f12868e.setShader(linearGradient);
        invalidate();
    }

    public void setProgress(int i10) {
        if (i10 >= 0 && i10 <= 100) {
            this.f12864a = i10;
            invalidate();
        }
    }
}
