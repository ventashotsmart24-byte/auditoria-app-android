package com.google.firebase.inappmessaging.display.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.q;

public class ResizableImageView extends q {
    private int mDensityDpi;

    public static class Dimensions {

        /* renamed from: h  reason: collision with root package name */
        final int f10237h;

        /* renamed from: w  reason: collision with root package name */
        final int f10238w;

        private Dimensions(int i10, int i11) {
            this.f10238w = i10;
            this.f10237h = i11;
        }
    }

    public ResizableImageView(Context context) {
        super(context);
        init(context);
    }

    private Dimensions bound(int i10, int i11) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (i10 > maxWidth) {
            Logging.logdNumber("Image: capping width", (float) maxWidth);
            i11 = (i11 * maxWidth) / i10;
            i10 = maxWidth;
        }
        if (i11 > maxHeight) {
            Logging.logdNumber("Image: capping height", (float) maxHeight);
            i10 = (i10 * maxHeight) / i11;
        } else {
            maxHeight = i11;
        }
        return new Dimensions(i10, maxHeight);
    }

    private void checkMinDim() {
        float f10;
        int max = Math.max(getMinimumWidth(), getSuggestedMinimumWidth());
        int max2 = Math.max(getMinimumHeight(), getSuggestedMinimumHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f11 = (float) max;
        float f12 = (float) max2;
        Logging.logdPair("Image: min width, height", f11, f12);
        float f13 = (float) measuredWidth;
        float f14 = (float) measuredHeight;
        Logging.logdPair("Image: actual width, height", f13, f14);
        float f15 = 1.0f;
        if (measuredWidth < max) {
            f10 = f11 / f13;
        } else {
            f10 = 1.0f;
        }
        if (measuredHeight < max2) {
            f15 = f12 / f14;
        }
        if (f10 <= f15) {
            f10 = f15;
        }
        if (((double) f10) > 1.0d) {
            int ceil = (int) Math.ceil((double) (f13 * f10));
            int ceil2 = (int) Math.ceil((double) (f14 * f10));
            Logging.logd("Measured dimension (" + measuredWidth + "x" + measuredHeight + ") too small.  Resizing to " + ceil + "x" + ceil2);
            Dimensions bound = bound(ceil, ceil2);
            setMeasuredDimension(bound.f10238w, bound.f10237h);
        }
    }

    private void init(Context context) {
        this.mDensityDpi = (int) (context.getResources().getDisplayMetrics().density * 160.0f);
    }

    private void scalePxToDp(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Logging.logdPair("Image: intrinsic width, height", (float) intrinsicWidth, (float) intrinsicHeight);
        Dimensions bound = bound((int) Math.ceil((double) ((intrinsicWidth * this.mDensityDpi) / 160)), (int) Math.ceil((double) ((intrinsicHeight * this.mDensityDpi) / 160)));
        Logging.logdPair("Image: new target dimensions", (float) bound.f10238w, (float) bound.f10237h);
        setMeasuredDimension(bound.f10238w, bound.f10237h);
    }

    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Drawable drawable = getDrawable();
        boolean adjustViewBounds = getAdjustViewBounds();
        if (drawable != null && adjustViewBounds) {
            scalePxToDp(drawable);
            checkMinDim();
        }
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context);
    }
}
