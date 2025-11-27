package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public final class ar extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f15414a;

    public ar(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f15414a = paint;
        paint.setAntiAlias(true);
        paint.setColor(-9733746);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) bo.a(1.3f));
    }

    public final void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float min = ((float) Math.min(width, height)) * 0.618f;
        float f10 = (float) width;
        float f11 = f10 - min;
        float f12 = (float) height;
        float f13 = f10 + min;
        Canvas canvas2 = canvas;
        float f14 = f12 - min;
        float f15 = f12 + min;
        canvas2.drawLine(f11, f14, f13, f15, this.f15414a);
        canvas2.drawLine(f13, f14, f11, f15, this.f15414a);
    }
}
