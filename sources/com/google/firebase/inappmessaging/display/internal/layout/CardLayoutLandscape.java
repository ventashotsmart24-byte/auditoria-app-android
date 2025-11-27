package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.Arrays;
import java.util.List;

public class CardLayoutLandscape extends BaseModalLayout {
    private static double IMAGE_MAX_WIDTH_PCT = 0.6d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;

    public CardLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Logging.logd("Layout image");
        int desiredWidth = getDesiredWidth(this.imageChild);
        layoutChild(this.imageChild, 0, 0, desiredWidth, getDesiredHeight(this.imageChild));
        Logging.logd("Layout title");
        int desiredHeight = getDesiredHeight(this.titleChild);
        int i14 = desiredWidth;
        int i15 = measuredWidth;
        layoutChild(this.titleChild, i14, 0, i15, desiredHeight);
        Logging.logd("Layout scroll");
        layoutChild(this.scrollChild, i14, desiredHeight, i15, desiredHeight + getDesiredHeight(this.scrollChild));
        Logging.logd("Layout action bar");
        layoutChild(this.actionBarChild, i14, measuredHeight - getDesiredHeight(this.actionBarChild), i15, measuredHeight);
    }

    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        View findChildById = findChildById(R.id.action_bar);
        this.actionBarChild = findChildById;
        int i12 = 0;
        List<View> asList = Arrays.asList(new View[]{this.titleChild, this.scrollChild, findChildById});
        int calculateBaseWidth = calculateBaseWidth(i10);
        int calculateBaseHeight = calculateBaseHeight(i11);
        double d10 = IMAGE_MAX_WIDTH_PCT;
        double d11 = (double) calculateBaseWidth;
        Double.isNaN(d11);
        int roundToNearest = roundToNearest((int) (d10 * d11), 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullHeight(this.imageChild, calculateBaseWidth, calculateBaseHeight);
        if (getDesiredWidth(this.imageChild) > roundToNearest) {
            Logging.logd("Image exceeded maximum width, remeasuring image");
            MeasureUtils.measureFullWidth(this.imageChild, roundToNearest, calculateBaseHeight);
        }
        int desiredHeight = getDesiredHeight(this.imageChild);
        int desiredWidth = getDesiredWidth(this.imageChild);
        int i13 = calculateBaseWidth - desiredWidth;
        float f10 = (float) desiredWidth;
        Logging.logdPair("Max col widths (l, r)", f10, (float) i13);
        Logging.logd("Measuring title");
        MeasureUtils.measureAtMost(this.titleChild, i13, desiredHeight);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureAtMost(this.actionBarChild, i13, desiredHeight);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullHeight(this.scrollChild, i13, (desiredHeight - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.actionBarChild));
        for (View desiredWidth2 : asList) {
            i12 = Math.max(getDesiredWidth(desiredWidth2), i12);
        }
        Logging.logdPair("Measured columns (l, r)", f10, (float) i12);
        int i14 = desiredWidth + i12;
        Logging.logdPair("Measured dims", (float) i14, (float) desiredHeight);
        setMeasuredDimension(i14, desiredHeight);
    }
}
