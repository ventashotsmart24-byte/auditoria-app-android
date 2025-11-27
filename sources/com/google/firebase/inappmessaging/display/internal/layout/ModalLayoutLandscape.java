package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.Arrays;
import java.util.List;

public class ModalLayoutLandscape extends BaseModalLayout {
    private static final int ITEM_SPACING_DP = 24;
    private static final float MAX_IMG_WIDTH_PCT = 0.4f;
    private int barrierWidth;
    private View buttonChild;
    private View imageChild;
    private int leftContentHeight;
    private int rightContentHeight;
    private View scrollChild;
    private View titleChild;
    private int vertItemSpacing;

    public ModalLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void layoutCenterHorizontal(View view, int i10, int i11, int i12, int i13) {
        int measuredWidth = view.getMeasuredWidth() / 2;
        int i14 = i10 + ((i12 - i10) / 2);
        layoutChild(view, i14 - measuredWidth, i11, i14 + measuredWidth, i13);
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        super.onLayout(z10, i10, i11, i12, i13);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i17 = this.leftContentHeight;
        int i18 = this.rightContentHeight;
        int i19 = 0;
        if (i17 < i18) {
            i14 = (i18 - i17) / 2;
            i15 = 0;
        } else {
            i15 = (i17 - i18) / 2;
            i14 = 0;
        }
        Logging.logd("Layout image");
        int i20 = paddingTop + i14;
        int desiredWidth = getDesiredWidth(this.imageChild) + paddingLeft;
        layoutChild(this.imageChild, paddingLeft, i20, desiredWidth, i20 + getDesiredHeight(this.imageChild));
        int i21 = desiredWidth + this.barrierWidth;
        Logging.logd("Layout getTitle");
        int i22 = paddingTop + i15;
        int desiredHeight = getDesiredHeight(this.titleChild) + i22;
        layoutChild(this.titleChild, i21, i22, measuredWidth, desiredHeight);
        Logging.logd("Layout getBody");
        if (this.titleChild.getVisibility() == 8) {
            i16 = 0;
        } else {
            i16 = this.vertItemSpacing;
        }
        int i23 = desiredHeight + i16;
        int desiredHeight2 = getDesiredHeight(this.scrollChild) + i23;
        layoutChild(this.scrollChild, i21, i23, measuredWidth, desiredHeight2);
        Logging.logd("Layout button");
        if (this.scrollChild.getVisibility() != 8) {
            i19 = this.vertItemSpacing;
        }
        layoutChild(this.buttonChild, i21, desiredHeight2 + i19);
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        super.onMeasure(i10, i11);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        this.buttonChild = findChildById(R.id.button);
        int i13 = 0;
        if (this.imageChild.getVisibility() == 8) {
            i12 = 0;
        } else {
            i12 = dpToPixels(24);
        }
        this.barrierWidth = i12;
        this.vertItemSpacing = dpToPixels(24);
        List<View> asList = Arrays.asList(new View[]{this.titleChild, this.scrollChild, this.buttonChild});
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int calculateBaseWidth = calculateBaseWidth(i10);
        int calculateBaseHeight = calculateBaseHeight(i11) - paddingBottom;
        int i14 = calculateBaseWidth - paddingLeft;
        Logging.logd("Measuring image");
        MeasureUtils.measureAtMost(this.imageChild, (int) (((float) i14) * 0.4f), calculateBaseHeight);
        int desiredWidth = getDesiredWidth(this.imageChild);
        int i15 = i14 - (this.barrierWidth + desiredWidth);
        float f10 = (float) desiredWidth;
        Logging.logdPair("Max col widths (l, r)", f10, (float) i15);
        int i16 = 0;
        for (View visibility : asList) {
            if (visibility.getVisibility() != 8) {
                i16++;
            }
        }
        int max = Math.max(0, (i16 - 1) * this.vertItemSpacing);
        int i17 = calculateBaseHeight - max;
        Logging.logd("Measuring getTitle");
        MeasureUtils.measureAtMost(this.titleChild, i15, i17);
        Logging.logd("Measuring button");
        MeasureUtils.measureAtMost(this.buttonChild, i15, i17);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureAtMost(this.scrollChild, i15, (i17 - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.buttonChild));
        this.leftContentHeight = getDesiredHeight(this.imageChild);
        this.rightContentHeight = max;
        for (View desiredHeight : asList) {
            this.rightContentHeight += getDesiredHeight(desiredHeight);
        }
        int max2 = Math.max(this.leftContentHeight + paddingBottom, this.rightContentHeight + paddingBottom);
        for (View desiredWidth2 : asList) {
            i13 = Math.max(getDesiredWidth(desiredWidth2), i13);
        }
        Logging.logdPair("Measured columns (l, r)", f10, (float) i13);
        int i18 = desiredWidth + i13 + this.barrierWidth + paddingLeft;
        Logging.logdPair("Measured dims", (float) i18, (float) max2);
        setMeasuredDimension(i18, max2);
    }
}
