package com.mobile.brasiltv.view;

import a7.e;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.utils.FragmentChangeManager;
import com.flyco.tablayout.utils.UnreadMsgUtils;
import com.flyco.tablayout.widget.MsgView;
import com.mobile.brasiltv.bean.MainTabEntity;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.ArrayList;

public class KoocanNetTabLayout extends AutoFrameLayout implements ValueAnimator.AnimatorUpdateListener {
    private static final int STYLE_BLOCK = 2;
    private static final int STYLE_NORMAL = 0;
    private static final int STYLE_TRIANGLE = 1;
    private static final int TEXT_BOLD_BOTH = 2;
    private static final int TEXT_BOLD_NONE = 0;
    private static final int TEXT_BOLD_WHEN_SELECT = 1;
    private Context mContext;
    private IndicatorPoint mCurrentP;
    /* access modifiers changed from: private */
    public int mCurrentTab;
    private int mDividerColor;
    private float mDividerPadding;
    private Paint mDividerPaint;
    private float mDividerWidth;
    private FragmentChangeManager mFragmentChangeManager;
    private int mHeight;
    private int mIconGravity;
    private float mIconHeight;
    private float mIconMargin;
    private boolean mIconVisible;
    private float mIconWidth;
    private long mIndicatorAnimDuration;
    private boolean mIndicatorAnimEnable;
    private boolean mIndicatorBounceEnable;
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
    private SparseArray<Boolean> mInitSetMap;
    private OvershootInterpolator mInterpolator;
    private boolean mIsFirstDraw;
    private IndicatorPoint mLastP;
    private int mLastTab;
    /* access modifiers changed from: private */
    public OnTabSelectListener mListener;
    private Paint mRectPaint;
    private int mTabCount;
    private ArrayList<MainTabEntity> mTabEntitys;
    private float mTabPadding;
    private boolean mTabSpaceEqual;
    private float mTabWidth;
    private LinearLayout mTabsContainer;
    private boolean mTextAllCaps;
    private int mTextBold;
    private Paint mTextPaint;
    private int mTextSelectColor;
    private int mTextUnselectColor;
    private boolean mTextVisible;
    private float mTextsize;
    private Paint mTrianglePaint;
    private Path mTrianglePath;
    private int mUnderlineColor;
    private int mUnderlineGravity;
    private float mUnderlineHeight;
    private ValueAnimator mValueAnimator;

    public class IndicatorPoint {
        public float left;
        public float right;

        public IndicatorPoint() {
        }
    }

    public class PointEvaluator implements TypeEvaluator<IndicatorPoint> {
        public PointEvaluator() {
        }

        public IndicatorPoint evaluate(float f10, IndicatorPoint indicatorPoint, IndicatorPoint indicatorPoint2) {
            float f11 = indicatorPoint.left;
            float f12 = indicatorPoint.right;
            float f13 = f12 + (f10 * (indicatorPoint2.right - f12));
            IndicatorPoint indicatorPoint3 = new IndicatorPoint();
            indicatorPoint3.left = f11 + ((indicatorPoint2.left - f11) * f10);
            indicatorPoint3.right = f13;
            return indicatorPoint3;
        }
    }

    public KoocanNetTabLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private void addTab(int i10, View view) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        textView.setText(this.mTabEntitys.get(i10).getTabTitle());
        textView.setVisibility(8);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_tab_icon);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_tab_icon_net);
        MainTabEntity mainTabEntity = this.mTabEntitys.get(i10);
        if (mainTabEntity.isUseNetIcon()) {
            e.f10706a.b(this.mContext, mainTabEntity.getUnSelectedIconUrl(), imageView2, -1);
            imageView2.setVisibility(0);
        } else {
            imageView.setVisibility(0);
            if (mainTabEntity.getSelectedDrawable() == null || mainTabEntity.getUnSelectDrawable() == null) {
                imageView.setImageResource(mainTabEntity.getTabUnselectedIcon());
            } else {
                imageView.setImageDrawable(mainTabEntity.getUnSelectDrawable());
            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (KoocanNetTabLayout.this.mCurrentTab != intValue) {
                    KoocanNetTabLayout.this.setCurrentTab(intValue);
                    if (KoocanNetTabLayout.this.mListener != null) {
                        KoocanNetTabLayout.this.mListener.onTabSelect(intValue);
                    }
                } else if (KoocanNetTabLayout.this.mListener != null) {
                    KoocanNetTabLayout.this.mListener.onTabReselect(intValue);
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
        Rect rect = this.mIndicatorRect;
        rect.left = (int) ((float) childAt.getLeft());
        rect.right = (int) ((float) childAt.getRight());
        if (this.mIndicatorWidth >= 0.0f) {
            float f10 = this.mIndicatorWidth;
            float left = ((float) childAt.getLeft()) + ((((float) childAt.getWidth()) - f10) / 2.0f);
            Rect rect2 = this.mIndicatorRect;
            int i10 = (int) left;
            rect2.left = i10;
            rect2.right = (int) (((float) i10) + f10);
        }
    }

    private void calcOffset() {
        long j10;
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentTab);
        this.mCurrentP.left = (float) childAt.getLeft();
        this.mCurrentP.right = (float) childAt.getRight();
        View childAt2 = this.mTabsContainer.getChildAt(this.mLastTab);
        this.mLastP.left = (float) childAt2.getLeft();
        this.mLastP.right = (float) childAt2.getRight();
        IndicatorPoint indicatorPoint = this.mLastP;
        float f10 = indicatorPoint.left;
        IndicatorPoint indicatorPoint2 = this.mCurrentP;
        if (f10 == indicatorPoint2.left && indicatorPoint.right == indicatorPoint2.right) {
            invalidate();
            return;
        }
        this.mValueAnimator.setObjectValues(new Object[]{indicatorPoint, indicatorPoint2});
        if (this.mIndicatorBounceEnable) {
            this.mValueAnimator.setInterpolator(this.mInterpolator);
        }
        if (this.mIndicatorAnimDuration < 0) {
            if (this.mIndicatorBounceEnable) {
                j10 = 500;
            } else {
                j10 = 250;
            }
            this.mIndicatorAnimDuration = j10;
        }
        this.mValueAnimator.setDuration(this.mIndicatorAnimDuration);
        this.mValueAnimator.start();
    }

    private void obtainAttributes(Context context, AttributeSet attributeSet) {
        String str;
        float f10;
        float f11;
        float f12;
        float f13;
        int i10;
        int i11;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.flyco.tablayout.R.styleable.CommonTabLayout);
        int i12 = obtainStyledAttributes.getInt(19, 0);
        this.mIndicatorStyle = i12;
        if (i12 == 2) {
            str = "#4B6A87";
        } else {
            str = "#ffffff";
        }
        this.mIndicatorColor = obtainStyledAttributes.getColor(11, Color.parseColor(str));
        int i13 = this.mIndicatorStyle;
        if (i13 == 1) {
            f10 = 4.0f;
        } else {
            if (i13 == 2) {
                i11 = -1;
            } else {
                i11 = 2;
            }
            f10 = (float) i11;
        }
        this.mIndicatorHeight = obtainStyledAttributes.getDimension(14, (float) dp2px(f10));
        if (this.mIndicatorStyle == 1) {
            f11 = 10.0f;
        } else {
            f11 = -1.0f;
        }
        this.mIndicatorWidth = obtainStyledAttributes.getDimension(20, (float) dp2px(f11));
        if (this.mIndicatorStyle == 2) {
            f12 = -1.0f;
        } else {
            f12 = 0.0f;
        }
        this.mIndicatorCornerRadius = obtainStyledAttributes.getDimension(12, (float) dp2px(f12));
        this.mIndicatorMarginLeft = obtainStyledAttributes.getDimension(16, (float) dp2px(0.0f));
        float f14 = 7.0f;
        if (this.mIndicatorStyle == 2) {
            f13 = 7.0f;
        } else {
            f13 = 0.0f;
        }
        this.mIndicatorMarginTop = obtainStyledAttributes.getDimension(18, (float) dp2px(f13));
        this.mIndicatorMarginRight = obtainStyledAttributes.getDimension(17, (float) dp2px(0.0f));
        if (this.mIndicatorStyle != 2) {
            f14 = 0.0f;
        }
        this.mIndicatorMarginBottom = obtainStyledAttributes.getDimension(15, (float) dp2px(f14));
        this.mIndicatorAnimEnable = obtainStyledAttributes.getBoolean(9, true);
        this.mIndicatorBounceEnable = obtainStyledAttributes.getBoolean(10, true);
        this.mIndicatorAnimDuration = (long) obtainStyledAttributes.getInt(8, -1);
        this.mIndicatorGravity = obtainStyledAttributes.getInt(13, 80);
        this.mUnderlineColor = obtainStyledAttributes.getColor(29, Color.parseColor("#ffffff"));
        this.mUnderlineHeight = obtainStyledAttributes.getDimension(31, (float) dp2px(0.0f));
        this.mUnderlineGravity = obtainStyledAttributes.getInt(30, 80);
        this.mDividerColor = obtainStyledAttributes.getColor(0, Color.parseColor("#ffffff"));
        this.mDividerWidth = obtainStyledAttributes.getDimension(2, (float) dp2px(0.0f));
        this.mDividerPadding = obtainStyledAttributes.getDimension(1, (float) dp2px(12.0f));
        this.mTextsize = obtainStyledAttributes.getDimension(28, (float) sp2px(13.0f));
        this.mTextSelectColor = obtainStyledAttributes.getColor(26, Color.parseColor("#ffffff"));
        this.mTextUnselectColor = obtainStyledAttributes.getColor(27, Color.parseColor("#AAffffff"));
        this.mTextBold = obtainStyledAttributes.getInt(25, 0);
        this.mTextAllCaps = obtainStyledAttributes.getBoolean(24, false);
        this.mIconVisible = obtainStyledAttributes.getBoolean(6, true);
        this.mIconGravity = obtainStyledAttributes.getInt(3, 48);
        this.mIconWidth = obtainStyledAttributes.getDimension(7, (float) dp2px(0.0f));
        this.mIconHeight = obtainStyledAttributes.getDimension(4, (float) dp2px(0.0f));
        this.mIconMargin = obtainStyledAttributes.getDimension(5, (float) dp2px(2.5f));
        this.mTabSpaceEqual = obtainStyledAttributes.getBoolean(22, true);
        float dimension = obtainStyledAttributes.getDimension(23, (float) dp2px(-1.0f));
        this.mTabWidth = dimension;
        if (this.mTabSpaceEqual || dimension > 0.0f) {
            i10 = dp2px(0.0f);
        } else {
            i10 = dp2px(10.0f);
        }
        this.mTabPadding = obtainStyledAttributes.getDimension(21, (float) i10);
        obtainStyledAttributes.recycle();
    }

    private void updateTabSelection(int i10) {
        boolean z10;
        int i11;
        int i12;
        Drawable drawable;
        String str;
        for (int i13 = 0; i13 < this.mTabCount; i13++) {
            View childAt = this.mTabsContainer.getChildAt(i13);
            if (i13 == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (z10) {
                i11 = this.mTextSelectColor;
            } else {
                i11 = this.mTextUnselectColor;
            }
            textView.setTextColor(i11);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            ImageView imageView2 = (ImageView) childAt.findViewById(R.id.iv_tab_icon_net);
            MainTabEntity mainTabEntity = this.mTabEntitys.get(i13);
            if (mainTabEntity.isUseNetIcon()) {
                if (z10) {
                    str = mainTabEntity.getSelectedIconUrl();
                } else {
                    str = mainTabEntity.getUnSelectedIconUrl();
                }
                e.f10706a.b(this.mContext, str, imageView2, -1);
                imageView2.setVisibility(0);
            } else {
                if (mainTabEntity.getSelectedDrawable() == null || mainTabEntity.getUnSelectDrawable() == null) {
                    if (z10) {
                        i12 = mainTabEntity.getTabSelectedIcon();
                    } else {
                        i12 = mainTabEntity.getTabUnselectedIcon();
                    }
                    imageView.setImageResource(i12);
                } else {
                    if (z10) {
                        drawable = mainTabEntity.getSelectedDrawable();
                    } else {
                        drawable = mainTabEntity.getUnSelectDrawable();
                    }
                    imageView.setImageDrawable(drawable);
                }
                imageView.setVisibility(0);
            }
            if (this.mTextBold == 1) {
                textView.getPaint().setFakeBoldText(z10);
            }
        }
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

    public int getIconGravity() {
        return this.mIconGravity;
    }

    public float getIconHeight() {
        return this.mIconHeight;
    }

    public float getIconMargin() {
        return this.mIconMargin;
    }

    public ImageView getIconView(int i10) {
        return (ImageView) this.mTabsContainer.getChildAt(i10).findViewById(R.id.iv_tab_icon);
    }

    public float getIconWidth() {
        return this.mIconWidth;
    }

    public long getIndicatorAnimDuration() {
        return this.mIndicatorAnimDuration;
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

    public ArrayList<MainTabEntity> getTabData() {
        return this.mTabEntitys;
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

    public boolean isIconVisible() {
        return this.mIconVisible;
    }

    public boolean isIndicatorAnimEnable() {
        return this.mIndicatorAnimEnable;
    }

    public boolean isIndicatorBounceEnable() {
        return this.mIndicatorBounceEnable;
    }

    public boolean isTabSpaceEqual() {
        return this.mTabSpaceEqual;
    }

    public boolean isTextAllCaps() {
        return this.mTextAllCaps;
    }

    public void notifyDataSetChanged() {
        View view;
        this.mTabsContainer.removeAllViews();
        this.mTabCount = this.mTabEntitys.size();
        for (int i10 = 0; i10 < this.mTabCount; i10++) {
            int i11 = this.mIconGravity;
            if (i11 == 3) {
                view = View.inflate(this.mContext, R.layout.layout_tab_left, (ViewGroup) null);
            } else if (i11 == 5) {
                view = View.inflate(this.mContext, R.layout.layout_tab_right, (ViewGroup) null);
            } else if (i11 == 80) {
                view = View.inflate(this.mContext, R.layout.layout_tab_bottom, (ViewGroup) null);
            } else {
                view = View.inflate(this.mContext, R.layout.layout_tab_top_2, (ViewGroup) null);
            }
            view.setTag(Integer.valueOf(i10));
            addTab(i10, view);
        }
        updateTabStyles();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentTab);
        IndicatorPoint indicatorPoint = (IndicatorPoint) valueAnimator.getAnimatedValue();
        Rect rect = this.mIndicatorRect;
        float f10 = indicatorPoint.left;
        rect.left = (int) f10;
        rect.right = (int) indicatorPoint.right;
        if (this.mIndicatorWidth >= 0.0f) {
            float f11 = this.mIndicatorWidth;
            float width = f10 + ((((float) childAt.getWidth()) - f11) / 2.0f);
            Rect rect2 = this.mIndicatorRect;
            int i10 = (int) width;
            rect2.left = i10;
            rect2.right = (int) (((float) i10) + f11);
        }
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.mTabCount > 0) {
            getHeight();
            getPaddingLeft();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mCurrentTab = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.mCurrentTab != 0 && this.mTabsContainer.getChildCount() > 0) {
                updateTabSelection(this.mCurrentTab);
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
        this.mLastTab = this.mCurrentTab;
        this.mCurrentTab = i10;
        updateTabSelection(i10);
        FragmentChangeManager fragmentChangeManager = this.mFragmentChangeManager;
        if (fragmentChangeManager != null) {
            fragmentChangeManager.setFragments(i10);
        }
        if (this.mIndicatorAnimEnable) {
            calcOffset();
        } else {
            invalidate();
        }
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

    public void setIconGravity(int i10) {
        this.mIconGravity = i10;
        notifyDataSetChanged();
    }

    public void setIconHeight(float f10) {
        this.mIconHeight = (float) dp2px(f10);
        updateTabStyles();
    }

    public void setIconMargin(float f10) {
        this.mIconMargin = (float) dp2px(f10);
        updateTabStyles();
    }

    public void setIconVisible(boolean z10) {
        this.mIconVisible = z10;
        updateTabStyles();
    }

    public void setIconWidth(float f10) {
        this.mIconWidth = (float) dp2px(f10);
        updateTabStyles();
    }

    public void setIndicatorAnimDuration(long j10) {
        this.mIndicatorAnimDuration = j10;
    }

    public void setIndicatorAnimEnable(boolean z10) {
        this.mIndicatorAnimEnable = z10;
    }

    public void setIndicatorBounceEnable(boolean z10) {
        this.mIndicatorBounceEnable = z10;
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

    public void setMsgMargin(int i10, float f10, float f11) {
        int i11;
        int i12;
        int i13 = this.mTabCount;
        if (i10 >= i13) {
            i10 = i13 - 1;
        }
        View childAt = this.mTabsContainer.getChildAt(i10);
        MsgView msgView = (MsgView) childAt.findViewById(R.id.rtv_msg_tip);
        if (msgView != null) {
            this.mTextPaint.setTextSize(this.mTextsize);
            this.mTextPaint.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString());
            float descent = this.mTextPaint.descent() - this.mTextPaint.ascent();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) msgView.getLayoutParams();
            float f12 = this.mIconHeight;
            float f13 = 0.0f;
            if (this.mIconVisible) {
                if (f12 <= 0.0f) {
                    f12 = (float) this.mContext.getResources().getDrawable(this.mTabEntitys.get(i10).getTabSelectedIcon()).getIntrinsicHeight();
                }
                f13 = this.mIconMargin;
            }
            int i14 = this.mIconGravity;
            if (i14 == 48 || i14 == 80) {
                marginLayoutParams.leftMargin = dp2px(f10);
                int i15 = this.mHeight;
                if (i15 > 0) {
                    i11 = ((((int) (((((float) i15) - descent) - f12) - f13)) / 2) - ((int) f13)) - dp2px(f11);
                } else {
                    i11 = dp2px(f11);
                }
                marginLayoutParams.topMargin = i11;
            } else {
                marginLayoutParams.leftMargin = dp2px(f10);
                int i16 = this.mHeight;
                if (i16 > 0) {
                    i12 = (((int) (((float) i16) - Math.max(descent, f12))) / 2) - dp2px(f11);
                } else {
                    i12 = dp2px(f11);
                }
                marginLayoutParams.topMargin = i12;
            }
            msgView.setLayoutParams(marginLayoutParams);
        }
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.mListener = onTabSelectListener;
    }

    public void setTabData(ArrayList<MainTabEntity> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            throw new IllegalStateException("TabEntitys can not be NULL or EMPTY !");
        }
        this.mTabEntitys.clear();
        this.mTabEntitys.addAll(arrayList);
        notifyDataSetChanged();
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

    public void setTextVisible(boolean z10) {
        this.mTextVisible = z10;
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
            if (i11 <= 0) {
                UnreadMsgUtils.setSize(msgView, dp2px(8.0f));
            }
            if (this.mInitSetMap.get(i10) == null || !this.mInitSetMap.get(i10).booleanValue()) {
                if (!this.mIconVisible) {
                    setMsgMargin(i10, 2.0f, 2.0f);
                } else {
                    if (this.mIconGravity != 3) {
                    }
                    setMsgMargin(i10, -6.0f, 4.0f);
                }
                this.mInitSetMap.put(i10, Boolean.TRUE);
            }
        }
    }

    public int sp2px(float f10) {
        return (int) ((f10 * this.mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void updateTabStyles() {
        int i10;
        int i11;
        Drawable drawable;
        String str;
        int i12;
        for (int i13 = 0; i13 < this.mTabCount; i13++) {
            View childAt = this.mTabsContainer.getChildAt(i13);
            float f10 = this.mTabPadding;
            childAt.setPadding((int) f10, 0, (int) f10, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            boolean z10 = true;
            if (this.mTextVisible) {
                if (i13 == this.mCurrentTab) {
                    i12 = this.mTextSelectColor;
                } else {
                    i12 = this.mTextUnselectColor;
                }
                textView.setTextColor(i12);
                textView.setTextSize(0, this.mTextsize);
                if (this.mTextAllCaps) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                int i14 = this.mTextBold;
                if (i14 == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (i14 == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
            } else {
                textView.setVisibility(8);
            }
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            ImageView imageView2 = (ImageView) childAt.findViewById(R.id.iv_tab_icon_net);
            if (this.mIconVisible) {
                MainTabEntity mainTabEntity = this.mTabEntitys.get(i13);
                if (i13 != this.mCurrentTab) {
                    z10 = false;
                }
                if (mainTabEntity.isUseNetIcon()) {
                    if (z10) {
                        str = mainTabEntity.getSelectedIconUrl();
                    } else {
                        str = mainTabEntity.getUnSelectedIconUrl();
                    }
                    e.f10706a.b(this.mContext, str, imageView2, -1);
                    imageView2.setVisibility(0);
                } else {
                    imageView.setVisibility(0);
                    if (mainTabEntity.getSelectedDrawable() == null || mainTabEntity.getUnSelectDrawable() == null) {
                        if (z10) {
                            i11 = mainTabEntity.getTabSelectedIcon();
                        } else {
                            i11 = mainTabEntity.getTabUnselectedIcon();
                        }
                        imageView.setImageResource(i11);
                    } else {
                        if (z10) {
                            drawable = mainTabEntity.getSelectedDrawable();
                        } else {
                            drawable = mainTabEntity.getUnSelectDrawable();
                        }
                        imageView.setImageDrawable(drawable);
                    }
                }
                float f11 = this.mIconWidth;
                int i15 = -2;
                if (f11 <= 0.0f) {
                    i10 = -2;
                } else {
                    i10 = (int) f11;
                }
                float f12 = this.mIconHeight;
                if (f12 > 0.0f) {
                    i15 = (int) f12;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, i15);
                int i16 = this.mIconGravity;
                if (i16 == 3) {
                    layoutParams.rightMargin = (int) this.mIconMargin;
                } else if (i16 == 5) {
                    layoutParams.leftMargin = (int) this.mIconMargin;
                } else if (i16 == 80) {
                    layoutParams.topMargin = (int) this.mIconMargin;
                } else {
                    layoutParams.bottomMargin = (int) this.mIconMargin;
                }
                imageView.setLayoutParams(layoutParams);
            } else {
                imageView2.setVisibility(8);
                imageView.setVisibility(8);
            }
        }
    }

    public KoocanNetTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KoocanNetTabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mTabEntitys = new ArrayList<>();
        this.mIndicatorRect = new Rect();
        this.mIndicatorDrawable = new GradientDrawable();
        this.mRectPaint = new Paint(1);
        this.mDividerPaint = new Paint(1);
        this.mTrianglePaint = new Paint(1);
        this.mTrianglePath = new Path();
        this.mIndicatorStyle = 0;
        this.mTextVisible = true;
        this.mInterpolator = new OvershootInterpolator(1.5f);
        this.mIsFirstDraw = true;
        this.mTextPaint = new Paint(1);
        this.mInitSetMap = new SparseArray<>();
        this.mCurrentP = new IndicatorPoint();
        this.mLastP = new IndicatorPoint();
        setWillNotDraw(false);
        this.mContext = context;
        setClipChildren(false);
        setClipToPadding(false);
        AutoLinearLayout autoLinearLayout = new AutoLinearLayout(context);
        this.mTabsContainer = autoLinearLayout;
        autoLinearLayout.setClipChildren(false);
        addView(this.mTabsContainer);
        obtainAttributes(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        attributeValue.hashCode();
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.mHeight = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new PointEvaluator(), new Object[]{this.mLastP, this.mCurrentP});
        this.mValueAnimator = ofObject;
        ofObject.addUpdateListener(this);
    }

    public void setTabData(ArrayList<MainTabEntity> arrayList, androidx.fragment.app.e eVar, int i10, ArrayList<Fragment> arrayList2) {
        this.mFragmentChangeManager = new FragmentChangeManager(eVar.getSupportFragmentManager(), i10, arrayList2);
        setTabData(arrayList);
    }
}
