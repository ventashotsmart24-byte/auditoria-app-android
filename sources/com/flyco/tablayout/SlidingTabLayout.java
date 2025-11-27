package com.flyco.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.o;
import androidx.fragment.app.t;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.utils.UnreadMsgUtils;
import com.flyco.tablayout.widget.MsgView;
import java.util.ArrayList;
import java.util.Collections;

public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.j {
    private static final int STYLE_BLOCK = 2;
    private static final int STYLE_NORMAL = 0;
    private static final int STYLE_TRIANGLE = 1;
    private static final int TEXT_BOLD_BOTH = 2;
    private static final int TEXT_BOLD_NONE = 0;
    private static final int TEXT_BOLD_WHEN_SELECT = 1;
    private Context mContext;
    private float mCurrentPositionOffset;
    private int mCurrentTab;
    private int mDividerColor;
    private float mDividerPadding;
    private Paint mDividerPaint;
    private float mDividerWidth;
    private int mHeight;
    private int mIndicatorColor;
    private float mIndicatorCornerRadius;
    private GradientDrawable mIndicatorDrawable;
    private int mIndicatorGravity;
    private float mIndicatorHeight;
    private float mIndicatorMarginBottom;
    private float mIndicatorMarginLeft;
    private float mIndicatorMarginRight;
    private float mIndicatorMarginTop;
    private Rect mIndicatorRect;
    private int mIndicatorStyle;
    private float mIndicatorWidth;
    private boolean mIndicatorWidthEqualTitle;
    private SparseArray<Boolean> mInitSetMap;
    private int mLastScrollX;
    /* access modifiers changed from: private */
    public OnTabSelectListener mListener;
    private Paint mRectPaint;
    /* access modifiers changed from: private */
    public boolean mSnapOnTabClick;
    private int mTabCount;
    private float mTabPadding;
    private Rect mTabRect;
    private boolean mTabSpaceEqual;
    private float mTabWidth;
    /* access modifiers changed from: private */
    public LinearLayout mTabsContainer;
    private boolean mTextAllCaps;
    private int mTextBold;
    private Paint mTextPaint;
    private int mTextSelectColor;
    private int mTextUnselectColor;
    private float mTextsize;
    private ArrayList<String> mTitles;
    private Paint mTrianglePaint;
    private Path mTrianglePath;
    private int mUnderlineColor;
    private int mUnderlineGravity;
    private float mUnderlineHeight;
    /* access modifiers changed from: private */
    public ViewPager mViewPager;
    private float margin;

    public class InnerPagerAdapter extends t {
        private ArrayList<Fragment> fragments;
        private String[] titles;

        public InnerPagerAdapter(o oVar, ArrayList<Fragment> arrayList, String[] strArr) {
            super(oVar);
            new ArrayList();
            this.fragments = arrayList;
            this.titles = strArr;
        }

        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        }

        public int getCount() {
            return this.fragments.size();
        }

        public Fragment getItem(int i10) {
            return this.fragments.get(i10);
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public CharSequence getPageTitle(int i10) {
            return this.titles[i10];
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private void addTab(int i10, String str, View view) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        if (!(textView == null || str == null)) {
            textView.setText(str);
        }
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int indexOfChild = SlidingTabLayout.this.mTabsContainer.indexOfChild(view);
                if (indexOfChild == -1) {
                    return;
                }
                if (SlidingTabLayout.this.mViewPager.getCurrentItem() != indexOfChild) {
                    if (SlidingTabLayout.this.mSnapOnTabClick) {
                        SlidingTabLayout.this.mViewPager.setCurrentItem(indexOfChild, false);
                    } else {
                        SlidingTabLayout.this.mViewPager.setCurrentItem(indexOfChild);
                    }
                    if (SlidingTabLayout.this.mListener != null) {
                        SlidingTabLayout.this.mListener.onTabSelect(indexOfChild);
                    }
                } else if (SlidingTabLayout.this.mListener != null) {
                    SlidingTabLayout.this.mListener.onTabReselect(indexOfChild);
                }
            }
        });
        if (this.mTabSpaceEqual) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        if (this.mTabWidth > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.mTabWidth, -1);
        }
        this.mTabsContainer.addView(view, i10, layoutParams);
    }

    private void calcIndicatorRect() {
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentTab);
        if (childAt != null) {
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
                this.mTextPaint.setTextSize(this.mTextsize);
                this.margin = ((right - left) - this.mTextPaint.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f;
            }
            int i10 = this.mCurrentTab;
            if (i10 < this.mTabCount - 1) {
                View childAt2 = this.mTabsContainer.getChildAt(i10 + 1);
                float left2 = (float) childAt2.getLeft();
                float right2 = (float) childAt2.getRight();
                float f10 = this.mCurrentPositionOffset;
                left += (left2 - left) * f10;
                right += f10 * (right2 - right);
                if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
                    this.mTextPaint.setTextSize(this.mTextsize);
                    float f11 = this.margin;
                    this.margin = f11 + (this.mCurrentPositionOffset * ((((right2 - left2) - this.mTextPaint.measureText(((TextView) childAt2.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f) - f11));
                }
            }
            Rect rect = this.mIndicatorRect;
            int i11 = (int) left;
            rect.left = i11;
            int i12 = (int) right;
            rect.right = i12;
            if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
                float f12 = this.margin;
                rect.left = (int) ((left + f12) - 1.0f);
                rect.right = (int) ((right - f12) - 1.0f);
            }
            Rect rect2 = this.mTabRect;
            rect2.left = i11;
            rect2.right = i12;
            if (this.mIndicatorWidth >= 0.0f) {
                float left3 = ((float) childAt.getLeft()) + ((((float) childAt.getWidth()) - this.mIndicatorWidth) / 2.0f);
                int i13 = this.mCurrentTab;
                if (i13 < this.mTabCount - 1) {
                    left3 += this.mCurrentPositionOffset * ((float) ((childAt.getWidth() / 2) + (this.mTabsContainer.getChildAt(i13 + 1).getWidth() / 2)));
                }
                Rect rect3 = this.mIndicatorRect;
                int i14 = (int) left3;
                rect3.left = i14;
                rect3.right = (int) (((float) i14) + this.mIndicatorWidth);
            }
        }
    }

    private void obtainAttributes(Context context, AttributeSet attributeSet) {
        String str;
        float f10;
        float f11;
        float f12;
        float f13;
        int i10;
        int i11;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingTabLayout);
        int i12 = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_style, 0);
        this.mIndicatorStyle = i12;
        int i13 = R.styleable.SlidingTabLayout_tl_indicator_color;
        if (i12 == 2) {
            str = "#4B6A87";
        } else {
            str = "#ffffff";
        }
        this.mIndicatorColor = obtainStyledAttributes.getColor(i13, Color.parseColor(str));
        int i14 = R.styleable.SlidingTabLayout_tl_indicator_height;
        int i15 = this.mIndicatorStyle;
        if (i15 == 1) {
            f10 = 4.0f;
        } else {
            if (i15 == 2) {
                i11 = -1;
            } else {
                i11 = 2;
            }
            f10 = (float) i11;
        }
        this.mIndicatorHeight = obtainStyledAttributes.getDimension(i14, (float) dp2px(f10));
        int i16 = R.styleable.SlidingTabLayout_tl_indicator_width;
        if (this.mIndicatorStyle == 1) {
            f11 = 10.0f;
        } else {
            f11 = -1.0f;
        }
        this.mIndicatorWidth = obtainStyledAttributes.getDimension(i16, (float) dp2px(f11));
        int i17 = R.styleable.SlidingTabLayout_tl_indicator_corner_radius;
        if (this.mIndicatorStyle == 2) {
            f12 = -1.0f;
        } else {
            f12 = 0.0f;
        }
        this.mIndicatorCornerRadius = obtainStyledAttributes.getDimension(i17, (float) dp2px(f12));
        this.mIndicatorMarginLeft = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_left, (float) dp2px(0.0f));
        int i18 = R.styleable.SlidingTabLayout_tl_indicator_margin_top;
        float f14 = 7.0f;
        if (this.mIndicatorStyle == 2) {
            f13 = 7.0f;
        } else {
            f13 = 0.0f;
        }
        this.mIndicatorMarginTop = obtainStyledAttributes.getDimension(i18, (float) dp2px(f13));
        this.mIndicatorMarginRight = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_right, (float) dp2px(0.0f));
        int i19 = R.styleable.SlidingTabLayout_tl_indicator_margin_bottom;
        if (this.mIndicatorStyle != 2) {
            f14 = 0.0f;
        }
        this.mIndicatorMarginBottom = obtainStyledAttributes.getDimension(i19, (float) dp2px(f14));
        this.mIndicatorGravity = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_gravity, 80);
        this.mIndicatorWidthEqualTitle = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_indicator_width_equal_title, false);
        this.mUnderlineColor = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_underline_color, Color.parseColor("#ffffff"));
        this.mUnderlineHeight = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_underline_height, (float) dp2px(0.0f));
        this.mUnderlineGravity = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_underline_gravity, 80);
        this.mDividerColor = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_divider_color, Color.parseColor("#ffffff"));
        this.mDividerWidth = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_width, (float) dp2px(0.0f));
        this.mDividerPadding = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_padding, (float) dp2px(12.0f));
        this.mTextsize = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_textsize, (float) sp2px(14.0f));
        this.mTextSelectColor = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.mTextUnselectColor = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textUnselectColor, Color.parseColor("#AAffffff"));
        this.mTextBold = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_textBold, 0);
        this.mTextAllCaps = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_textAllCaps, false);
        this.mTabSpaceEqual = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_tab_space_equal, false);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_tab_width, (float) dp2px(-1.0f));
        this.mTabWidth = dimension;
        int i20 = R.styleable.SlidingTabLayout_tl_tab_padding;
        if (this.mTabSpaceEqual || dimension > 0.0f) {
            i10 = dp2px(0.0f);
        } else {
            i10 = dp2px(19.0f);
        }
        this.mTabPadding = obtainStyledAttributes.getDimension(i20, (float) i10);
        obtainStyledAttributes.recycle();
    }

    private void scrollToCurrentTab() {
        if (this.mTabCount > 0 && this.mTabsContainer.getChildAt(this.mCurrentTab) != null) {
            int width = (int) (this.mCurrentPositionOffset * ((float) this.mTabsContainer.getChildAt(this.mCurrentTab).getWidth()));
            int left = this.mTabsContainer.getChildAt(this.mCurrentTab).getLeft() + width;
            if (this.mCurrentTab > 0 || width > 0) {
                int width2 = left - ((getWidth() / 2) - getPaddingLeft());
                calcIndicatorRect();
                Rect rect = this.mTabRect;
                left = width2 + ((rect.right - rect.left) / 2);
            }
            if (left != this.mLastScrollX) {
                this.mLastScrollX = left;
                scrollTo(left, 0);
            }
        }
    }

    private void updateTabSelection(int i10) {
        boolean z10;
        int i11;
        for (int i12 = 0; i12 < this.mTabCount; i12++) {
            View childAt = this.mTabsContainer.getChildAt(i12);
            if (i12 == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (textView != null) {
                if (z10) {
                    i11 = this.mTextSelectColor;
                } else {
                    i11 = this.mTextUnselectColor;
                }
                textView.setTextColor(i11);
                if (this.mTextBold == 1) {
                    textView.getPaint().setFakeBoldText(z10);
                }
            }
        }
    }

    private void updateTabStyles() {
        int i10;
        for (int i11 = 0; i11 < this.mTabCount; i11++) {
            TextView textView = (TextView) this.mTabsContainer.getChildAt(i11).findViewById(R.id.tv_tab_title);
            if (textView != null) {
                if (i11 == this.mCurrentTab) {
                    i10 = this.mTextSelectColor;
                } else {
                    i10 = this.mTextUnselectColor;
                }
                textView.setTextColor(i10);
                textView.setTextSize(0, this.mTextsize);
                float f10 = this.mTabPadding;
                textView.setPadding((int) f10, 0, (int) f10, 0);
                if (this.mTextAllCaps) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                int i12 = this.mTextBold;
                if (i12 == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (i12 == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
            }
        }
    }

    public void addNewTab(String str) {
        CharSequence charSequence;
        int i10;
        View inflate = View.inflate(this.mContext, R.layout.layout_tab, (ViewGroup) null);
        ArrayList<String> arrayList = this.mTitles;
        if (arrayList != null) {
            arrayList.add(str);
        }
        ArrayList<String> arrayList2 = this.mTitles;
        if (arrayList2 == null) {
            charSequence = this.mViewPager.getAdapter().getPageTitle(this.mTabCount);
        } else {
            charSequence = arrayList2.get(this.mTabCount);
        }
        addTab(this.mTabCount, charSequence.toString(), inflate);
        ArrayList<String> arrayList3 = this.mTitles;
        if (arrayList3 == null) {
            i10 = this.mViewPager.getAdapter().getCount();
        } else {
            i10 = arrayList3.size();
        }
        this.mTabCount = i10;
        updateTabStyles();
    }

    public int dp2px(float f10) {
        return (int) ((f10 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public int getDividerColor() {
        return this.mDividerColor;
    }

    public float getDividerPadding() {
        return this.mDividerPadding;
    }

    public float getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getIndicatorColor() {
        return this.mIndicatorColor;
    }

    public float getIndicatorCornerRadius() {
        return this.mIndicatorCornerRadius;
    }

    public float getIndicatorHeight() {
        return this.mIndicatorHeight;
    }

    public float getIndicatorMarginBottom() {
        return this.mIndicatorMarginBottom;
    }

    public float getIndicatorMarginLeft() {
        return this.mIndicatorMarginLeft;
    }

    public float getIndicatorMarginRight() {
        return this.mIndicatorMarginRight;
    }

    public float getIndicatorMarginTop() {
        return this.mIndicatorMarginTop;
    }

    public int getIndicatorStyle() {
        return this.mIndicatorStyle;
    }

    public float getIndicatorWidth() {
        return this.mIndicatorWidth;
    }

    public MsgView getMsgView(int i10) {
        int i11 = this.mTabCount;
        if (i10 >= i11) {
            i10 = i11 - 1;
        }
        return (MsgView) this.mTabsContainer.getChildAt(i10).findViewById(R.id.rtv_msg_tip);
    }

    public int getTabCount() {
        return this.mTabCount;
    }

    public float getTabPadding() {
        return this.mTabPadding;
    }

    public float getTabWidth() {
        return this.mTabWidth;
    }

    public int getTextBold() {
        return this.mTextBold;
    }

    public int getTextSelectColor() {
        return this.mTextSelectColor;
    }

    public int getTextUnselectColor() {
        return this.mTextUnselectColor;
    }

    public float getTextsize() {
        return this.mTextsize;
    }

    public TextView getTitleView(int i10) {
        return (TextView) this.mTabsContainer.getChildAt(i10).findViewById(R.id.tv_tab_title);
    }

    public int getUnderlineColor() {
        return this.mUnderlineColor;
    }

    public float getUnderlineHeight() {
        return this.mUnderlineHeight;
    }

    public void hideMsg(int i10) {
        int i11 = this.mTabCount;
        if (i10 >= i11) {
            i10 = i11 - 1;
        }
        MsgView msgView = (MsgView) this.mTabsContainer.getChildAt(i10).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            msgView.setVisibility(8);
        }
    }

    public boolean isTabSpaceEqual() {
        return this.mTabSpaceEqual;
    }

    public boolean isTextAllCaps() {
        return this.mTextAllCaps;
    }

    public void notifyDataSetChanged() {
        int i10;
        CharSequence charSequence;
        this.mTabsContainer.removeAllViews();
        ArrayList<String> arrayList = this.mTitles;
        if (arrayList == null) {
            i10 = this.mViewPager.getAdapter().getCount();
        } else {
            i10 = arrayList.size();
        }
        this.mTabCount = i10;
        for (int i11 = 0; i11 < this.mTabCount; i11++) {
            View inflate = View.inflate(this.mContext, R.layout.layout_tab, (ViewGroup) null);
            ArrayList<String> arrayList2 = this.mTitles;
            if (arrayList2 == null) {
                charSequence = this.mViewPager.getAdapter().getPageTitle(i11);
            } else {
                charSequence = arrayList2.get(i11);
            }
            addTab(i11, charSequence.toString(), inflate);
        }
        updateTabStyles();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.mTabCount > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            float f10 = this.mDividerWidth;
            if (f10 > 0.0f) {
                this.mDividerPaint.setStrokeWidth(f10);
                this.mDividerPaint.setColor(this.mDividerColor);
                for (int i10 = 0; i10 < this.mTabCount - 1; i10++) {
                    View childAt = this.mTabsContainer.getChildAt(i10);
                    canvas.drawLine((float) (childAt.getRight() + paddingLeft), this.mDividerPadding, (float) (childAt.getRight() + paddingLeft), ((float) height) - this.mDividerPadding, this.mDividerPaint);
                }
            }
            if (this.mUnderlineHeight > 0.0f) {
                this.mRectPaint.setColor(this.mUnderlineColor);
                if (this.mUnderlineGravity == 80) {
                    float f11 = (float) height;
                    canvas.drawRect((float) paddingLeft, f11 - this.mUnderlineHeight, (float) (this.mTabsContainer.getWidth() + paddingLeft), f11, this.mRectPaint);
                } else {
                    canvas.drawRect((float) paddingLeft, 0.0f, (float) (this.mTabsContainer.getWidth() + paddingLeft), this.mUnderlineHeight, this.mRectPaint);
                }
            }
            calcIndicatorRect();
            int i11 = this.mIndicatorStyle;
            if (i11 == 1) {
                if (this.mIndicatorHeight > 0.0f) {
                    this.mTrianglePaint.setColor(this.mIndicatorColor);
                    this.mTrianglePath.reset();
                    float f12 = (float) height;
                    this.mTrianglePath.moveTo((float) (this.mIndicatorRect.left + paddingLeft), f12);
                    Path path = this.mTrianglePath;
                    Rect rect = this.mIndicatorRect;
                    path.lineTo((float) ((rect.left / 2) + paddingLeft + (rect.right / 2)), f12 - this.mIndicatorHeight);
                    this.mTrianglePath.lineTo((float) (paddingLeft + this.mIndicatorRect.right), f12);
                    this.mTrianglePath.close();
                    canvas.drawPath(this.mTrianglePath, this.mTrianglePaint);
                }
            } else if (i11 == 2) {
                if (this.mIndicatorHeight < 0.0f) {
                    this.mIndicatorHeight = (((float) height) - this.mIndicatorMarginTop) - this.mIndicatorMarginBottom;
                }
                float f13 = this.mIndicatorHeight;
                if (f13 > 0.0f) {
                    float f14 = this.mIndicatorCornerRadius;
                    if (f14 < 0.0f || f14 > f13 / 2.0f) {
                        this.mIndicatorCornerRadius = f13 / 2.0f;
                    }
                    this.mIndicatorDrawable.setColor(this.mIndicatorColor);
                    GradientDrawable gradientDrawable = this.mIndicatorDrawable;
                    Rect rect2 = this.mIndicatorRect;
                    int i12 = ((int) this.mIndicatorMarginLeft) + paddingLeft + rect2.left;
                    float f15 = this.mIndicatorMarginTop;
                    gradientDrawable.setBounds(i12, (int) f15, (int) (((float) (paddingLeft + rect2.right)) - this.mIndicatorMarginRight), (int) (f15 + this.mIndicatorHeight));
                    this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
                    this.mIndicatorDrawable.draw(canvas);
                }
            } else if (this.mIndicatorHeight > 0.0f) {
                this.mIndicatorDrawable.setColor(this.mIndicatorColor);
                if (this.mIndicatorGravity == 80) {
                    GradientDrawable gradientDrawable2 = this.mIndicatorDrawable;
                    Rect rect3 = this.mIndicatorRect;
                    float f16 = this.mIndicatorMarginBottom;
                    gradientDrawable2.setBounds(((int) this.mIndicatorMarginLeft) + paddingLeft + rect3.left, (height - ((int) this.mIndicatorHeight)) - ((int) f16), (paddingLeft + rect3.right) - ((int) this.mIndicatorMarginRight), height - ((int) f16));
                } else {
                    GradientDrawable gradientDrawable3 = this.mIndicatorDrawable;
                    Rect rect4 = this.mIndicatorRect;
                    int i13 = ((int) this.mIndicatorMarginLeft) + paddingLeft + rect4.left;
                    float f17 = this.mIndicatorMarginTop;
                    gradientDrawable3.setBounds(i13, (int) f17, (paddingLeft + rect4.right) - ((int) this.mIndicatorMarginRight), ((int) this.mIndicatorHeight) + ((int) f17));
                }
                this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
                this.mIndicatorDrawable.draw(canvas);
            }
        }
    }

    public void onPageScrollStateChanged(int i10) {
    }

    public void onPageScrolled(int i10, float f10, int i11) {
        this.mCurrentTab = i10;
        this.mCurrentPositionOffset = f10;
        scrollToCurrentTab();
        invalidate();
    }

    public void onPageSelected(int i10) {
        updateTabSelection(i10);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mCurrentTab = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.mCurrentTab != 0 && this.mTabsContainer.getChildCount() > 0) {
                updateTabSelection(this.mCurrentTab);
                scrollToCurrentTab();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.mCurrentTab);
        return bundle;
    }

    public void setCurrentTab(int i10) {
        this.mCurrentTab = i10;
        this.mViewPager.setCurrentItem(i10);
    }

    public void setDividerColor(int i10) {
        this.mDividerColor = i10;
        invalidate();
    }

    public void setDividerPadding(float f10) {
        this.mDividerPadding = (float) dp2px(f10);
        invalidate();
    }

    public void setDividerWidth(float f10) {
        this.mDividerWidth = (float) dp2px(f10);
        invalidate();
    }

    public void setIndicatorColor(int i10) {
        this.mIndicatorColor = i10;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f10) {
        this.mIndicatorCornerRadius = (float) dp2px(f10);
        invalidate();
    }

    public void setIndicatorGravity(int i10) {
        this.mIndicatorGravity = i10;
        invalidate();
    }

    public void setIndicatorHeight(float f10) {
        this.mIndicatorHeight = (float) dp2px(f10);
        invalidate();
    }

    public void setIndicatorMargin(float f10, float f11, float f12, float f13) {
        this.mIndicatorMarginLeft = (float) dp2px(f10);
        this.mIndicatorMarginTop = (float) dp2px(f11);
        this.mIndicatorMarginRight = (float) dp2px(f12);
        this.mIndicatorMarginBottom = (float) dp2px(f13);
        invalidate();
    }

    public void setIndicatorStyle(int i10) {
        this.mIndicatorStyle = i10;
        invalidate();
    }

    public void setIndicatorWidth(float f10) {
        this.mIndicatorWidth = (float) dp2px(f10);
        invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean z10) {
        this.mIndicatorWidthEqualTitle = z10;
        invalidate();
    }

    public void setMsgMargin(int i10, float f10, float f11) {
        float f12;
        int i11;
        int i12 = this.mTabCount;
        if (i10 >= i12) {
            i10 = i12 - 1;
        }
        View childAt = this.mTabsContainer.getChildAt(i10);
        MsgView msgView = (MsgView) childAt.findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            this.mTextPaint.setTextSize(this.mTextsize);
            float measureText = this.mTextPaint.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString());
            float descent = this.mTextPaint.descent() - this.mTextPaint.ascent();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) msgView.getLayoutParams();
            float f13 = this.mTabWidth;
            if (f13 >= 0.0f) {
                f12 = f13 / 2.0f;
                measureText /= 2.0f;
            } else {
                f12 = this.mTabPadding;
            }
            marginLayoutParams.leftMargin = (int) (f12 + measureText + ((float) dp2px(f10)));
            int i13 = this.mHeight;
            if (i13 > 0) {
                i11 = (((int) (((float) i13) - descent)) / 2) - dp2px(f11);
            } else {
                i11 = 0;
            }
            marginLayoutParams.topMargin = i11;
            msgView.setLayoutParams(marginLayoutParams);
        }
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.mListener = onTabSelectListener;
    }

    public void setSnapOnTabClick(boolean z10) {
        this.mSnapOnTabClick = z10;
    }

    public void setTabPadding(float f10) {
        this.mTabPadding = (float) dp2px(f10);
        updateTabStyles();
    }

    public void setTabSpaceEqual(boolean z10) {
        this.mTabSpaceEqual = z10;
        updateTabStyles();
    }

    public void setTabWidth(float f10) {
        this.mTabWidth = (float) dp2px(f10);
        updateTabStyles();
    }

    public void setTextAllCaps(boolean z10) {
        this.mTextAllCaps = z10;
        updateTabStyles();
    }

    public void setTextBold(int i10) {
        this.mTextBold = i10;
        updateTabStyles();
    }

    public void setTextSelectColor(int i10) {
        this.mTextSelectColor = i10;
        updateTabStyles();
    }

    public void setTextUnselectColor(int i10) {
        this.mTextUnselectColor = i10;
        updateTabStyles();
    }

    public void setTextsize(float f10) {
        this.mTextsize = (float) sp2px(f10);
        updateTabStyles();
    }

    public void setUnderlineColor(int i10) {
        this.mUnderlineColor = i10;
        invalidate();
    }

    public void setUnderlineGravity(int i10) {
        this.mUnderlineGravity = i10;
        invalidate();
    }

    public void setUnderlineHeight(float f10) {
        this.mUnderlineHeight = (float) dp2px(f10);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager == null || viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
        }
        this.mViewPager = viewPager;
        viewPager.removeOnPageChangeListener(this);
        this.mViewPager.addOnPageChangeListener(this);
        notifyDataSetChanged();
    }

    public void showDot(int i10) {
        int i11 = this.mTabCount;
        if (i10 >= i11) {
            i10 = i11 - 1;
        }
        showMsg(i10, 0);
    }

    public void showMsg(int i10, int i11) {
        int i12 = this.mTabCount;
        if (i10 >= i12) {
            i10 = i12 - 1;
        }
        MsgView msgView = (MsgView) this.mTabsContainer.getChildAt(i10).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            UnreadMsgUtils.show(msgView, i11);
            if (this.mInitSetMap.get(i10) == null || !this.mInitSetMap.get(i10).booleanValue()) {
                setMsgMargin(i10, 4.0f, 2.0f);
                this.mInitSetMap.put(i10, Boolean.TRUE);
            }
        }
    }

    public void showNumMsg(int i10, String str) {
        int i11 = this.mTabCount;
        if (i10 >= i11) {
            i10 = i11 - 1;
        }
        MsgView msgView = (MsgView) this.mTabsContainer.getChildAt(i10).findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            msgView.setVisibility(0);
            msgView.setText(str);
        }
    }

    public int sp2px(float f10) {
        return (int) ((f10 * this.mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIndicatorRect = new Rect();
        this.mTabRect = new Rect();
        this.mIndicatorDrawable = new GradientDrawable();
        this.mRectPaint = new Paint(1);
        this.mDividerPaint = new Paint(1);
        this.mTrianglePaint = new Paint(1);
        this.mTrianglePath = new Path();
        this.mIndicatorStyle = 0;
        this.mTextPaint = new Paint(1);
        this.mInitSetMap = new SparseArray<>();
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.mTabsContainer = linearLayout;
        addView(linearLayout);
        obtainAttributes(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.mHeight = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
    }

    public void setCurrentTab(int i10, boolean z10) {
        this.mCurrentTab = i10;
        this.mViewPager.setCurrentItem(i10, z10);
    }

    public void setViewPager(ViewPager viewPager, String[] strArr) {
        if (viewPager == null || viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
        } else if (strArr == null || strArr.length == 0) {
            throw new IllegalStateException("Titles can not be EMPTY !");
        } else if (strArr.length == viewPager.getAdapter().getCount()) {
            this.mViewPager = viewPager;
            ArrayList<String> arrayList = new ArrayList<>();
            this.mTitles = arrayList;
            Collections.addAll(arrayList, strArr);
            this.mViewPager.removeOnPageChangeListener(this);
            this.mViewPager.addOnPageChangeListener(this);
            notifyDataSetChanged();
        } else {
            throw new IllegalStateException("Titles length must be the same as the page count !");
        }
    }

    public void setViewPager(ViewPager viewPager, String[] strArr, e eVar, ArrayList<Fragment> arrayList) {
        if (viewPager == null) {
            throw new IllegalStateException("ViewPager can not be NULL !");
        } else if (strArr == null || strArr.length == 0) {
            throw new IllegalStateException("Titles can not be EMPTY !");
        } else {
            this.mViewPager = viewPager;
            viewPager.setAdapter(new InnerPagerAdapter(eVar.getSupportFragmentManager(), arrayList, strArr));
            this.mViewPager.removeOnPageChangeListener(this);
            this.mViewPager.addOnPageChangeListener(this);
            notifyDataSetChanged();
        }
    }
}
