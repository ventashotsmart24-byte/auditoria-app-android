package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import java.util.List;

public class TagCloudView extends ViewGroup {
    private static final boolean DEFAULT_CAN_TAG_CLICK = true;
    private static final String DEFAULT_END_TEXT_STRING = " … ";
    private static final int DEFAULT_RIGHT_IMAGE = 2131230814;
    private static final boolean DEFAULT_SHOW_END_TEXT = true;
    private static final boolean DEFAULT_SHOW_RIGHT_IMAGE = true;
    private static final boolean DEFAULT_SINGLE_LINE = false;
    private static final int DEFAULT_TAG_RESID = 2131558681;
    private static final int DEFAULT_TEXT_BACKGROUND = 2131231681;
    private static final int DEFAULT_TEXT_BORDER_HORIZONTAL = 8;
    private static final int DEFAULT_TEXT_BORDER_VERTICAL = 5;
    private static final int DEFAULT_TEXT_COLOR = -1;
    private static final int DEFAULT_TEXT_SIZE = 14;
    private static final int DEFAULT_VIEW_BORDER = 6;
    private static final int TYPE_TEXT_NORMAL = 1;
    private TextView endText;
    private int endTextHeight;
    private String endTextString;
    private int endTextWidth;
    private int imageHeight;
    private ImageView imageView;
    private int imageWidth;
    private int mBackground;
    private boolean mCanTagClick;
    private LayoutInflater mInflater;
    private int mRightImageResId;
    private boolean mShowEndText;
    private boolean mShowRightImage;
    private boolean mSingleLine;
    private int mTagBorderHor;
    private int mTagBorderVer;
    private int mTagColor;
    private int mTagResId;
    private float mTagSize;
    private int mViewBorder;
    /* access modifiers changed from: private */
    public OnTagClickListener onTagClickListener;
    private int sizeHeight;
    private int sizeWidth;
    private List<String> tags;

    public interface OnTagClickListener {
        void onTagClick(int i10);
    }

    public TagCloudView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getMultiTotalHeight(int i10, int i11) {
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i13 = this.mViewBorder;
            i10 += measuredWidth + i13;
            if (i12 == 0) {
                i11 = measuredHeight + i13;
            }
            int i14 = this.mTagBorderHor;
            if (i10 + i14 + i13 > this.sizeWidth) {
                i11 += this.mTagBorderVer + measuredHeight;
                int i15 = i13 + measuredWidth;
                childAt.layout(i13 + i14, i11 - measuredHeight, i14 + i15, i11);
                i10 = i15;
            } else {
                childAt.layout((i10 - measuredWidth) + i14, i11 - measuredHeight, i14 + i10, i11);
            }
        }
        return i11 + this.mViewBorder;
    }

    private int getSingleTotalHeight(int i10, int i11) {
        int i12 = i10 + this.mViewBorder;
        int i13 = 0;
        if (getTextTotalWidth() < this.sizeWidth - this.imageWidth) {
            this.endText = null;
            this.endTextWidth = 0;
        }
        while (true) {
            if (i13 >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i13);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i13 == 0) {
                i12 += measuredWidth;
                i11 = this.mViewBorder + measuredHeight;
            } else {
                i12 += this.mTagBorderHor + measuredWidth;
            }
            if (childAt.getTag() != null && ((Integer) childAt.getTag()).intValue() == 1) {
                int i14 = this.mViewBorder;
                if (this.mTagBorderHor + i12 + i14 + i14 + this.endTextWidth + this.imageWidth >= this.sizeWidth) {
                    i12 -= measuredWidth + i14;
                    break;
                }
                int i15 = this.mTagBorderVer;
                childAt.layout((i12 - measuredWidth) + i15, i11 - measuredHeight, i15 + i12, i11);
            }
            i13++;
        }
        TextView textView = this.endText;
        if (textView != null) {
            int i16 = this.mViewBorder;
            int i17 = this.mTagBorderVer;
            textView.layout(i12 + i16 + i17, i11 - this.endTextHeight, i12 + i16 + i17 + this.endTextWidth, i11);
        }
        int i18 = this.mViewBorder;
        int i19 = i11 + i18;
        ImageView imageView2 = this.imageView;
        if (imageView2 != null) {
            int i20 = this.sizeWidth;
            int i21 = this.imageHeight;
            imageView2.layout((i20 - this.imageWidth) - i18, (i19 - i21) / 2, i20 - i18, ((i19 - i21) / 2) + i21);
        }
        return i19;
    }

    private int getTextTotalWidth() {
        if (getChildCount() == 0) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getTag() != null && ((Integer) childAt.getTag()).intValue() == 1) {
                i10 += childAt.getMeasuredWidth() + this.mViewBorder;
            }
        }
        return i10 + (this.mTagBorderHor * 2);
    }

    private void initSingleLineView(int i10, int i11) {
        String str;
        if (this.mSingleLine) {
            if (this.mShowRightImage) {
                ImageView imageView2 = new ImageView(getContext());
                this.imageView = imageView2;
                imageView2.setImageResource(this.mRightImageResId);
                this.imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                measureChild(this.imageView, i10, i11);
                this.imageWidth = this.imageView.getMeasuredWidth();
                this.imageHeight = this.imageView.getMeasuredHeight();
                addView(this.imageView);
            }
            if (this.mShowEndText) {
                TextView textView = (TextView) this.mInflater.inflate(this.mTagResId, (ViewGroup) null);
                this.endText = textView;
                if (this.mTagResId == R.layout.item_tag) {
                    textView.setBackgroundResource(this.mBackground);
                    this.endText.setTextSize(2, this.mTagSize);
                    this.endText.setTextColor(this.mTagColor);
                }
                this.endText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                TextView textView2 = this.endText;
                String str2 = this.endTextString;
                if (str2 == null || str2.equals("")) {
                    str = DEFAULT_END_TEXT_STRING;
                } else {
                    str = this.endTextString;
                }
                textView2.setText(str);
                measureChild(this.endText, i10, i11);
                this.endTextHeight = this.endText.getMeasuredHeight();
                this.endTextWidth = this.endText.getMeasuredWidth();
                addView(this.endText);
                this.endText.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (TagCloudView.this.onTagClickListener != null) {
                            TagCloudView.this.onTagClickListener.onTagClick(-1);
                        }
                    }
                });
            }
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((this.mCanTagClick || !this.mSingleLine) && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        View.MeasureSpec.getMode(i10);
        int mode = View.MeasureSpec.getMode(i11);
        this.sizeWidth = View.MeasureSpec.getSize(i10);
        this.sizeHeight = View.MeasureSpec.getSize(i11);
        measureChildren(i10, i11);
        initSingleLineView(i10, i11);
        int i13 = this.mTagBorderVer;
        if (this.mSingleLine) {
            i12 = getSingleTotalHeight(0, i13);
        } else {
            i12 = getMultiTotalHeight(0, i13);
        }
        int i14 = this.sizeWidth;
        if (mode == 1073741824) {
            i12 = this.sizeHeight;
        }
        setMeasuredDimension(i14, i12);
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener2) {
        this.onTagClickListener = onTagClickListener2;
    }

    public void setTags(List<String> list) {
        this.tags = list;
        removeAllViews();
        List<String> list2 = this.tags;
        if (list2 != null && list2.size() > 0) {
            for (final int i10 = 0; i10 < this.tags.size(); i10++) {
                TextView textView = (TextView) this.mInflater.inflate(this.mTagResId, (ViewGroup) null);
                if (this.mTagResId == R.layout.item_tag) {
                    textView.setBackgroundResource(this.mBackground);
                    textView.setTextSize(2, this.mTagSize);
                    textView.setTextColor(this.mTagColor);
                }
                textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                textView.setText(this.tags.get(i10));
                textView.setTag(1);
                textView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (TagCloudView.this.onTagClickListener != null) {
                            TagCloudView.this.onTagClickListener.onTagClick(i10);
                        }
                    }
                });
                addView(textView);
            }
        }
        postInvalidate();
    }

    public void singleLine(boolean z10) {
        this.mSingleLine = z10;
        setTags(this.tags);
    }

    public TagCloudView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagCloudView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.imageView = null;
        this.endTextWidth = 0;
        this.endTextHeight = 0;
        this.endText = null;
        this.mInflater = LayoutInflater.from(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f11955z, i10, i10);
        this.mTagSize = (float) obtainStyledAttributes.getInteger(13, 14);
        this.mTagColor = obtainStyledAttributes.getColor(12, -1);
        this.mBackground = obtainStyledAttributes.getResourceId(0, R.drawable.tag_background);
        this.mViewBorder = obtainStyledAttributes.getDimensionPixelSize(1, 6);
        this.mTagBorderHor = obtainStyledAttributes.getDimensionPixelSize(5, 8);
        this.mTagBorderVer = obtainStyledAttributes.getDimensionPixelSize(6, 5);
        this.mCanTagClick = obtainStyledAttributes.getBoolean(3, true);
        this.mRightImageResId = obtainStyledAttributes.getResourceId(7, R.drawable.app_icon_forward);
        this.mSingleLine = obtainStyledAttributes.getBoolean(10, false);
        this.mShowRightImage = obtainStyledAttributes.getBoolean(9, true);
        this.mShowEndText = obtainStyledAttributes.getBoolean(8, true);
        this.endTextString = obtainStyledAttributes.getString(4);
        this.mTagResId = obtainStyledAttributes.getResourceId(11, R.layout.item_tag);
        obtainStyledAttributes.recycle();
    }
}
