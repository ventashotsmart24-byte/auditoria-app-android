package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.mobile.brasiltv.utils.s0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;
import y6.a;

public final class CurTimeSeekBar extends AppCompatSeekBar {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Rect mProgressTextRect;
    private TextPaint mTextPaint;
    private final int textSizePx;
    private final float textSizeSp;

    /* renamed from: y  reason: collision with root package name */
    private final int f12679y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CurTimeSeekBar(Context context) {
        super(context);
        i.g(context, f.X);
        this.mTextPaint = new TextPaint();
        this.mProgressTextRect = new Rect();
        this.textSizePx = 24;
        this.textSizeSp = 12.0f;
        this.f12679y = AutoUtils.getPercentHeightSize(24);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public void onDraw(Canvas canvas) {
        i.g(canvas, "canvas");
        super.onDraw(canvas);
        String k10 = a.k((long) getProgress());
        this.mTextPaint.getTextBounds(k10, 0, k10.length(), this.mProgressTextRect);
        canvas.drawText(k10, (((((float) getWidth()) - (((float) getPaddingLeft()) * 2.0f)) * ((float) getProgress())) / ((float) getMax())) + ((float) getPaddingLeft()), (float) this.f12679y, this.mTextPaint);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CurTimeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.g(context, f.X);
        i.g(attributeSet, "attrs");
        this.mTextPaint = new TextPaint();
        this.mProgressTextRect = new Rect();
        this.textSizePx = 24;
        this.textSizeSp = 12.0f;
        int percentHeightSize = AutoUtils.getPercentHeightSize(24);
        this.f12679y = percentHeightSize;
        this.mTextPaint.setColor(context.getResources().getColor(R.color.color_important_white));
        this.mTextPaint.setTextSize((float) s0.d(context, 12.0f));
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        setPadding(getPaddingLeft(), percentHeightSize, getPaddingRight(), getPaddingBottom());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CurTimeSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        i.g(attributeSet, "attrs");
        this.mTextPaint = new TextPaint();
        this.mProgressTextRect = new Rect();
        this.textSizePx = 24;
        this.textSizeSp = 12.0f;
        this.f12679y = AutoUtils.getPercentHeightSize(24);
    }
}
