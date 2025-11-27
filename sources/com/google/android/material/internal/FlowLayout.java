package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import b0.c1;
import b0.m;
import com.google.android.material.R;

public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private boolean singleLine;

    public FlowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int getMeasuredDimension(int i10, int i11, int i12) {
        if (i11 == Integer.MIN_VALUE) {
            return Math.min(i12, i10);
        }
        if (i11 != 1073741824) {
            return i12;
        }
        return i10;
    }

    private void loadFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        if (getChildCount() != 0) {
            boolean z11 = true;
            if (c1.z(this) != 1) {
                z11 = false;
            }
            if (z11) {
                i14 = getPaddingRight();
            } else {
                i14 = getPaddingLeft();
            }
            if (z11) {
                i15 = getPaddingLeft();
            } else {
                i15 = getPaddingRight();
            }
            int paddingTop = getPaddingTop();
            int i18 = (i12 - i10) - i15;
            int i19 = i14;
            int i20 = paddingTop;
            for (int i21 = 0; i21 < getChildCount(); i21++) {
                View childAt = getChildAt(i21);
                if (childAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i16 = m.b(marginLayoutParams);
                        i17 = m.a(marginLayoutParams);
                    } else {
                        i17 = 0;
                        i16 = 0;
                    }
                    int measuredWidth = i19 + i16 + childAt.getMeasuredWidth();
                    if (!this.singleLine && measuredWidth > i18) {
                        i20 = this.lineSpacing + paddingTop;
                        i19 = i14;
                    }
                    int i22 = i19 + i16;
                    int measuredWidth2 = childAt.getMeasuredWidth() + i22;
                    int measuredHeight = childAt.getMeasuredHeight() + i20;
                    if (z11) {
                        childAt.layout(i18 - measuredWidth2, i20, (i18 - i19) - i16, measuredHeight);
                    } else {
                        childAt.layout(i22, i20, measuredWidth2, measuredHeight);
                    }
                    i19 += i16 + i17 + childAt.getMeasuredWidth() + this.itemSpacing;
                    paddingTop = measuredHeight;
                }
            }
        }
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i12 = size;
        } else {
            i12 = Integer.MAX_VALUE;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i12 - getPaddingRight();
        int i16 = paddingTop;
        int i17 = 0;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() == 8) {
                int i19 = i10;
                int i20 = i11;
            } else {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i14 = marginLayoutParams.leftMargin + 0;
                    i13 = marginLayoutParams.rightMargin + 0;
                } else {
                    i14 = 0;
                    i13 = 0;
                }
                int i21 = paddingLeft;
                if (paddingLeft + i14 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                    i15 = i21;
                } else {
                    i15 = getPaddingLeft();
                    i16 = this.lineSpacing + paddingTop;
                }
                int measuredWidth = i15 + i14 + childAt.getMeasuredWidth();
                int measuredHeight = i16 + childAt.getMeasuredHeight();
                if (measuredWidth > i17) {
                    i17 = measuredWidth;
                }
                paddingLeft = i15 + i14 + i13 + childAt.getMeasuredWidth() + this.itemSpacing;
                if (i18 == getChildCount() - 1) {
                    i17 += i13;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i17 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i10) {
        this.itemSpacing = i10;
    }

    public void setLineSpacing(int i10) {
        this.lineSpacing = i10;
    }

    public void setSingleLine(boolean z10) {
        this.singleLine = z10;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }
}
