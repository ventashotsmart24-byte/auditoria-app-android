package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.mobile.brasiltv.utils.s0;

public class SideBar extends View {

    /* renamed from: b  reason: collision with root package name */
    public static String[] f12680b = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static int selectTextColor = 2131099927;
    private static int textColor = 2131099927;
    private int bigTextSize;
    private int choose;
    private float oldX;
    private float oldY;
    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    private Paint paint;
    float recordY;
    private int textSize;
    private int touchState;

    public interface OnTouchingLetterChangedListener {
        void onTouchingLetterChanged(String str);
    }

    public SideBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.choose = -1;
        this.paint = new Paint();
        this.textSize = 20;
        this.bigTextSize = 42;
        this.recordY = -1.0f;
        init(context);
    }

    private void upDateView(MotionEvent motionEvent, int i10, OnTouchingLetterChangedListener onTouchingLetterChangedListener2, int i11) {
        this.recordY = motionEvent.getY();
        if (i10 != i11 && i11 >= 0) {
            String[] strArr = f12680b;
            if (i11 < strArr.length) {
                if (onTouchingLetterChangedListener2 != null) {
                    onTouchingLetterChangedListener2.onTouchingLetterChanged(strArr[i11]);
                }
                this.choose = i11;
            }
        }
    }

    public void init(Context context) {
        this.textSize = s0.a(context, 14.0f);
        this.bigTextSize = s0.a(context, 30.0f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        int height = getHeight();
        int width = getWidth();
        int length = height / f12680b.length;
        for (int i10 = 0; i10 < f12680b.length; i10++) {
            this.paint.setColor(getResources().getColor(textColor));
            this.paint.setTypeface(Typeface.DEFAULT_BOLD);
            this.paint.setAntiAlias(true);
            int i11 = this.textSize;
            this.paint.setTextSize((float) i11);
            float measureText = ((float) (width / 2)) - (this.paint.measureText(f12680b[i10]) / 2.0f);
            float f10 = (float) ((length * i10) + length);
            float f11 = this.recordY;
            if (f11 >= 0.0f) {
                float abs = (measureText - ((float) (this.textSize * 6))) + Math.abs(f11 - f10);
                if (abs < 0.0f) {
                    measureText += abs;
                    double d10 = (double) (abs / 2.0f);
                    Double.isNaN(d10);
                    i11 -= (int) (d10 + 0.5d);
                    Paint paint2 = this.paint;
                    double d11 = (double) (((float) (this.textSize * 6)) + abs);
                    Double.isNaN(d11);
                    paint2.setColor(Color.argb((int) (d11 - 0.5d), 63, 63, 63));
                }
                if (i10 == this.choose) {
                    this.paint.setColor(getResources().getColor(selectTextColor));
                    this.paint.setFakeBoldText(true);
                }
            }
            this.paint.setTextSize((float) i11);
            canvas.drawText(f12680b[i10], measureText, f10, this.paint);
            this.paint.reset();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y10 = motionEvent.getY();
        int i10 = this.choose;
        OnTouchingLetterChangedListener onTouchingLetterChangedListener2 = this.onTouchingLetterChangedListener;
        int height = (int) ((y10 / ((float) getHeight())) * ((float) f12680b.length));
        if (action == 0) {
            this.touchState = 0;
            this.oldX = motionEvent.getX();
            this.oldY = motionEvent.getY();
            upDateView(motionEvent, i10, onTouchingLetterChangedListener2, height);
        } else if (action != 1) {
            int i11 = this.touchState;
            if (i11 == 0) {
                float x10 = motionEvent.getX();
                float y11 = motionEvent.getY();
                float f10 = this.oldX;
                float f11 = (f10 - x10) * (f10 - x10);
                float f12 = this.oldY;
                if (f11 + ((f12 - y11) * (f12 - y11)) > ((float) this.bigTextSize)) {
                    if ((f10 - x10) * (f10 - x10) > (f12 - y11) * (f12 - y11)) {
                        this.recordY = -1.0f;
                        this.choose = -1;
                        invalidate();
                        this.touchState = 2;
                        return true;
                    }
                    this.touchState = 1;
                }
            } else if (i11 == 2) {
                return true;
            }
            upDateView(motionEvent, i10, onTouchingLetterChangedListener2, height);
        } else {
            this.recordY = -1.0f;
            this.choose = -1;
            invalidate();
        }
        invalidate();
        return true;
    }

    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener2) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener2;
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SideBar(Context context) {
        super(context);
        this.choose = -1;
        this.paint = new Paint();
        this.textSize = 20;
        this.bigTextSize = 42;
        this.recordY = -1.0f;
        init(context);
    }
}
