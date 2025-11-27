package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Button;
import com.mobile.brasiltv.view.RoundedDrawable;

public final class br extends Button {

    /* renamed from: a  reason: collision with root package name */
    private Paint f15525a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private float f15526b;

    /* renamed from: c  reason: collision with root package name */
    private float f15527c;

    /* renamed from: d  reason: collision with root package name */
    private float f15528d;

    /* renamed from: e  reason: collision with root package name */
    private float f15529e;

    /* renamed from: f  reason: collision with root package name */
    private float f15530f = ((float) bo.a(2.0f));

    /* renamed from: g  reason: collision with root package name */
    private int f15531g = bo.a(1.0f);

    public br(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15526b = (float) (getWidth() / 2);
        this.f15527c = (float) (getHeight() / 2);
        float min = (float) ((Math.min(getHeight(), getWidth()) / 2) - this.f15531g);
        this.f15528d = min;
        this.f15529e = min / 1.4142f;
        this.f15525a.setAntiAlias(true);
        this.f15525a.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.f15525a.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.f15526b, this.f15527c, this.f15528d, this.f15525a);
        this.f15525a.setColor(-1);
        this.f15525a.setStrokeWidth(this.f15530f);
        this.f15525a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(this.f15526b, this.f15527c, this.f15528d, this.f15525a);
        float f10 = this.f15526b;
        float f11 = this.f15529e;
        float f12 = this.f15527c;
        canvas.drawLine(f10 - f11, f12 - f11, f10 + f11, f12 + f11, this.f15525a);
        float f13 = this.f15526b;
        float f14 = this.f15529e;
        float f15 = this.f15527c;
        canvas.drawLine(f13 + f14, f15 - f14, f13 - f14, f15 + f14, this.f15525a);
    }
}
