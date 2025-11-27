package cn.bingoogolapple.bgabanner;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import b0.c1;
import cn.bingoogolapple.bgabanner.BGAViewPager;
import cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer;
import cn.bingoogolapple.bgabanner.transformer.TransitionEffect;
import com.google.common.primitives.Ints;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BGABanner extends RelativeLayout implements BGAViewPager.AutoPlayDelegate, ViewPager.j {
    private static final int LWC = -2;
    private static final int NO_PLACEHOLDER_DRAWABLE = -1;
    private static final int RMP = -1;
    private static final int RWC = -2;
    private static final int VEL_THRESHOLD = 400;
    private static final ImageView.ScaleType[] sScaleTypeArray = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    /* access modifiers changed from: private */
    public Adapter mAdapter;
    private boolean mAllowUserScrollable;
    private float mAspectRatio;
    /* access modifiers changed from: private */
    public boolean mAutoPlayAble;
    private int mAutoPlayInterval;
    private AutoPlayTask mAutoPlayTask;
    private int mContentBottomMargin;
    /* access modifiers changed from: private */
    public Delegate mDelegate;
    private View mEnterView;
    /* access modifiers changed from: private */
    public GuideDelegate mGuideDelegate;
    private BGAOnNoDoubleClickListener mGuideOnNoDoubleClickListener;
    /* access modifiers changed from: private */
    public List<View> mHackyViews;
    private boolean mIsFirstInvisible;
    private boolean mIsNeedShowIndicatorOnOnlyOnePage;
    private boolean mIsNumberIndicator;
    /* access modifiers changed from: private */
    public List<? extends Object> mModels;
    private Drawable mNumberIndicatorBackground;
    private int mNumberIndicatorTextColor;
    private int mNumberIndicatorTextSize;
    private TextView mNumberIndicatorTv;
    private ViewPager.j mOnPageChangeListener;
    private int mOverScrollMode;
    private int mPageChangeDuration;
    private int mPageScrollPosition;
    private float mPageScrollPositionOffset;
    private int mPlaceholderDrawableResId;
    private ImageView mPlaceholderIv;
    private Drawable mPointContainerBackgroundDrawable;
    private int mPointContainerLeftRightPadding;
    private RelativeLayout mPointContainerRl;
    private int mPointDrawableResId;
    private int mPointGravity;
    private int mPointLeftRightMargin;
    private LinearLayout mPointRealContainerLl;
    private int mPointTopBottomMargin;
    private ImageView.ScaleType mScaleType;
    private View mSkipView;
    private int mTipTextColor;
    private int mTipTextSize;
    private TextView mTipTv;
    private List<String> mTips;
    private TransitionEffect mTransitionEffect;
    /* access modifiers changed from: private */
    public BGAViewPager mViewPager;
    /* access modifiers changed from: private */
    public List<View> mViews;

    public interface Adapter<V extends View, M> {
        void fillBannerItem(BGABanner bGABanner, V v10, M m10, int i10);
    }

    public static class AutoPlayTask implements Runnable {
        private final WeakReference<BGABanner> mBanner;

        public void run() {
            BGABanner bGABanner = this.mBanner.get();
            if (bGABanner != null) {
                bGABanner.startAutoPlay();
                bGABanner.switchToNextPage();
            }
        }

        private AutoPlayTask(BGABanner bGABanner) {
            this.mBanner = new WeakReference<>(bGABanner);
        }
    }

    public interface Delegate<V extends View, M> {
        void onBannerItemClick(BGABanner bGABanner, V v10, M m10, int i10);
    }

    public interface GuideDelegate {
        void onClickEnterOrSkip();
    }

    public class PageAdapter extends a {
        private PageAdapter() {
        }

        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        }

        public int getCount() {
            if (BGABanner.this.mViews == null) {
                return 0;
            }
            if (BGABanner.this.mAutoPlayAble) {
                return Integer.MAX_VALUE;
            }
            return BGABanner.this.mViews.size();
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            View view;
            if (BGABannerUtil.isCollectionEmpty(BGABanner.this.mViews, new Collection[0])) {
                return null;
            }
            int size = i10 % BGABanner.this.mViews.size();
            if (BGABanner.this.mHackyViews == null) {
                view = (View) BGABanner.this.mViews.get(size);
            } else {
                view = (View) BGABanner.this.mHackyViews.get(i10 % BGABanner.this.mHackyViews.size());
            }
            if (BGABanner.this.mDelegate != null) {
                view.setOnClickListener(new BGAOnNoDoubleClickListener() {
                    public void onNoDoubleClick(View view) {
                        int currentItem = BGABanner.this.mViewPager.getCurrentItem() % BGABanner.this.mViews.size();
                        if (BGABannerUtil.isIndexNotOutOfBounds(currentItem, BGABanner.this.mModels)) {
                            Delegate access$600 = BGABanner.this.mDelegate;
                            BGABanner bGABanner = BGABanner.this;
                            access$600.onBannerItemClick(bGABanner, view, bGABanner.mModels.get(currentItem), currentItem);
                        } else if (BGABannerUtil.isCollectionEmpty(BGABanner.this.mModels, new Collection[0])) {
                            BGABanner.this.mDelegate.onBannerItemClick(BGABanner.this, view, null, currentItem);
                        }
                    }
                });
            }
            if (BGABanner.this.mAdapter != null) {
                if (BGABannerUtil.isIndexNotOutOfBounds(size, BGABanner.this.mModels)) {
                    Adapter access$900 = BGABanner.this.mAdapter;
                    BGABanner bGABanner = BGABanner.this;
                    access$900.fillBannerItem(bGABanner, view, bGABanner.mModels.get(size), size);
                } else if (BGABannerUtil.isCollectionEmpty(BGABanner.this.mModels, new Collection[0])) {
                    BGABanner.this.mAdapter.fillBannerItem(BGABanner.this, view, null, size);
                }
            }
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public BGABanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void handleGuideViewVisibility(int i10, float f10) {
        if (this.mEnterView != null || this.mSkipView != null) {
            if (getItemCount() < 2) {
                View view = this.mEnterView;
                if (view != null) {
                    view.setVisibility(0);
                    View view2 = this.mSkipView;
                    if (view2 != null) {
                        view2.setVisibility(8);
                        return;
                    }
                    return;
                }
                View view3 = this.mSkipView;
                if (view3 != null) {
                    view3.setVisibility(0);
                    return;
                }
            }
            if (i10 == getItemCount() - 2) {
                View view4 = this.mEnterView;
                if (view4 != null) {
                    c1.n0(view4, f10);
                }
                View view5 = this.mSkipView;
                if (view5 != null) {
                    c1.n0(view5, 1.0f - f10);
                }
                if (f10 > 0.5f) {
                    View view6 = this.mEnterView;
                    if (view6 != null) {
                        view6.setVisibility(0);
                    }
                    View view7 = this.mSkipView;
                    if (view7 != null) {
                        view7.setVisibility(8);
                        return;
                    }
                    return;
                }
                View view8 = this.mEnterView;
                if (view8 != null) {
                    view8.setVisibility(8);
                }
                View view9 = this.mSkipView;
                if (view9 != null) {
                    view9.setVisibility(0);
                }
            } else if (i10 == getItemCount() - 1) {
                View view10 = this.mEnterView;
                if (view10 != null) {
                    c1.n0(view10, 1.0f - f10);
                }
                View view11 = this.mSkipView;
                if (view11 != null) {
                    c1.n0(view11, f10);
                }
                if (f10 < 0.5f) {
                    View view12 = this.mEnterView;
                    if (view12 != null) {
                        view12.setVisibility(0);
                    }
                    View view13 = this.mSkipView;
                    if (view13 != null) {
                        view13.setVisibility(8);
                        return;
                    }
                    return;
                }
                View view14 = this.mEnterView;
                if (view14 != null) {
                    view14.setVisibility(8);
                }
                View view15 = this.mSkipView;
                if (view15 != null) {
                    view15.setVisibility(0);
                }
            } else {
                View view16 = this.mSkipView;
                if (view16 != null) {
                    view16.setVisibility(0);
                    c1.n0(this.mSkipView, 1.0f);
                }
                View view17 = this.mEnterView;
                if (view17 != null) {
                    view17.setVisibility(8);
                }
            }
        }
    }

    private View inflateItemView(int i10) {
        View inflate = View.inflate(getContext(), i10, (ViewGroup) null);
        if (inflate instanceof ImageView) {
            ((ImageView) inflate).setScaleType(this.mScaleType);
        }
        return inflate;
    }

    private void initCustomAttr(int i10, TypedArray typedArray) {
        int i11;
        if (i10 == R.styleable.BGABanner_banner_pointDrawable) {
            this.mPointDrawableResId = typedArray.getResourceId(i10, R.drawable.bga_banner_selector_point_solid);
        } else if (i10 == R.styleable.BGABanner_banner_pointContainerBackground) {
            this.mPointContainerBackgroundDrawable = typedArray.getDrawable(i10);
        } else if (i10 == R.styleable.BGABanner_banner_pointLeftRightMargin) {
            this.mPointLeftRightMargin = typedArray.getDimensionPixelSize(i10, this.mPointLeftRightMargin);
        } else if (i10 == R.styleable.BGABanner_banner_pointContainerLeftRightPadding) {
            this.mPointContainerLeftRightPadding = typedArray.getDimensionPixelSize(i10, this.mPointContainerLeftRightPadding);
        } else if (i10 == R.styleable.BGABanner_banner_pointTopBottomMargin) {
            this.mPointTopBottomMargin = typedArray.getDimensionPixelSize(i10, this.mPointTopBottomMargin);
        } else if (i10 == R.styleable.BGABanner_banner_indicatorGravity) {
            this.mPointGravity = typedArray.getInt(i10, this.mPointGravity);
        } else if (i10 == R.styleable.BGABanner_banner_pointAutoPlayAble) {
            this.mAutoPlayAble = typedArray.getBoolean(i10, this.mAutoPlayAble);
        } else if (i10 == R.styleable.BGABanner_banner_pointAutoPlayInterval) {
            this.mAutoPlayInterval = typedArray.getInteger(i10, this.mAutoPlayInterval);
        } else if (i10 == R.styleable.BGABanner_banner_pageChangeDuration) {
            this.mPageChangeDuration = typedArray.getInteger(i10, this.mPageChangeDuration);
        } else if (i10 == R.styleable.BGABanner_banner_transitionEffect) {
            this.mTransitionEffect = TransitionEffect.values()[typedArray.getInt(i10, TransitionEffect.Accordion.ordinal())];
        } else if (i10 == R.styleable.BGABanner_banner_tipTextColor) {
            this.mTipTextColor = typedArray.getColor(i10, this.mTipTextColor);
        } else if (i10 == R.styleable.BGABanner_banner_tipTextSize) {
            this.mTipTextSize = typedArray.getDimensionPixelSize(i10, this.mTipTextSize);
        } else if (i10 == R.styleable.BGABanner_banner_placeholderDrawable) {
            this.mPlaceholderDrawableResId = typedArray.getResourceId(i10, this.mPlaceholderDrawableResId);
        } else if (i10 == R.styleable.BGABanner_banner_isNumberIndicator) {
            this.mIsNumberIndicator = typedArray.getBoolean(i10, this.mIsNumberIndicator);
        } else if (i10 == R.styleable.BGABanner_banner_numberIndicatorTextColor) {
            this.mNumberIndicatorTextColor = typedArray.getColor(i10, this.mNumberIndicatorTextColor);
        } else if (i10 == R.styleable.BGABanner_banner_numberIndicatorTextSize) {
            this.mNumberIndicatorTextSize = typedArray.getDimensionPixelSize(i10, this.mNumberIndicatorTextSize);
        } else if (i10 == R.styleable.BGABanner_banner_numberIndicatorBackground) {
            this.mNumberIndicatorBackground = typedArray.getDrawable(i10);
        } else if (i10 == R.styleable.BGABanner_banner_isNeedShowIndicatorOnOnlyOnePage) {
            this.mIsNeedShowIndicatorOnOnlyOnePage = typedArray.getBoolean(i10, this.mIsNeedShowIndicatorOnOnlyOnePage);
        } else if (i10 == R.styleable.BGABanner_banner_contentBottomMargin) {
            this.mContentBottomMargin = typedArray.getDimensionPixelSize(i10, this.mContentBottomMargin);
        } else if (i10 == R.styleable.BGABanner_banner_aspectRatio) {
            this.mAspectRatio = typedArray.getFloat(i10, this.mAspectRatio);
        } else if (i10 == R.styleable.BGABanner_android_scaleType && (i11 = typedArray.getInt(i10, -1)) >= 0) {
            ImageView.ScaleType[] scaleTypeArr = sScaleTypeArray;
            if (i11 < scaleTypeArr.length) {
                this.mScaleType = scaleTypeArr[i11];
            }
        }
    }

    private void initCustomAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BGABanner);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            initCustomAttr(obtainStyledAttributes.getIndex(i10), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
    }

    private void initDefaultAttrs(Context context) {
        this.mAutoPlayTask = new AutoPlayTask();
        this.mPointLeftRightMargin = BGABannerUtil.dp2px(context, 3.0f);
        this.mPointTopBottomMargin = BGABannerUtil.dp2px(context, 6.0f);
        this.mPointContainerLeftRightPadding = BGABannerUtil.dp2px(context, 10.0f);
        this.mTipTextSize = BGABannerUtil.sp2px(context, 10.0f);
        this.mPointContainerBackgroundDrawable = new ColorDrawable(Color.parseColor("#44aaaaaa"));
        this.mTransitionEffect = TransitionEffect.Default;
        this.mNumberIndicatorTextSize = BGABannerUtil.sp2px(context, 10.0f);
        this.mContentBottomMargin = 0;
        this.mAspectRatio = 0.0f;
    }

    private void initIndicator() {
        LinearLayout linearLayout = this.mPointRealContainerLl;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            boolean z10 = this.mIsNeedShowIndicatorOnOnlyOnePage;
            if (z10 || (!z10 && this.mViews.size() > 1)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int i10 = this.mPointLeftRightMargin;
                layoutParams.setMargins(i10, 0, i10, 0);
                for (int i11 = 0; i11 < this.mViews.size(); i11++) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageResource(this.mPointDrawableResId);
                    this.mPointRealContainerLl.addView(imageView);
                }
            }
        }
        if (this.mNumberIndicatorTv != null) {
            boolean z11 = this.mIsNeedShowIndicatorOnOnlyOnePage;
            if (z11 || (!z11 && this.mViews.size() > 1)) {
                this.mNumberIndicatorTv.setVisibility(0);
            } else {
                this.mNumberIndicatorTv.setVisibility(4);
            }
        }
    }

    private void initView(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mPointContainerRl = relativeLayout;
        relativeLayout.setBackground(this.mPointContainerBackgroundDrawable);
        RelativeLayout relativeLayout2 = this.mPointContainerRl;
        int i10 = this.mPointContainerLeftRightPadding;
        int i11 = this.mPointTopBottomMargin;
        relativeLayout2.setPadding(i10, i11, i10, i11);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if ((this.mPointGravity & 112) == 48) {
            layoutParams.addRule(10);
        } else {
            layoutParams.addRule(12);
        }
        addView(this.mPointContainerRl, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        if (this.mIsNumberIndicator) {
            TextView textView = new TextView(context);
            this.mNumberIndicatorTv = textView;
            textView.setId(R.id.banner_indicatorId);
            this.mNumberIndicatorTv.setGravity(16);
            this.mNumberIndicatorTv.setSingleLine(true);
            this.mNumberIndicatorTv.setEllipsize(TextUtils.TruncateAt.END);
            this.mNumberIndicatorTv.setTextColor(this.mNumberIndicatorTextColor);
            this.mNumberIndicatorTv.setTextSize(0, (float) this.mNumberIndicatorTextSize);
            this.mNumberIndicatorTv.setVisibility(4);
            Drawable drawable = this.mNumberIndicatorBackground;
            if (drawable != null) {
                this.mNumberIndicatorTv.setBackground(drawable);
            }
            this.mPointContainerRl.addView(this.mNumberIndicatorTv, layoutParams2);
        } else {
            LinearLayout linearLayout = new LinearLayout(context);
            this.mPointRealContainerLl = linearLayout;
            linearLayout.setId(R.id.banner_indicatorId);
            this.mPointRealContainerLl.setOrientation(0);
            this.mPointRealContainerLl.setGravity(16);
            this.mPointContainerRl.addView(this.mPointRealContainerLl, layoutParams2);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(15);
        TextView textView2 = new TextView(context);
        this.mTipTv = textView2;
        textView2.setGravity(16);
        this.mTipTv.setSingleLine(true);
        this.mTipTv.setEllipsize(TextUtils.TruncateAt.END);
        this.mTipTv.setTextColor(this.mTipTextColor);
        this.mTipTv.setTextSize(0, (float) this.mTipTextSize);
        this.mPointContainerRl.addView(this.mTipTv, layoutParams3);
        int i12 = this.mPointGravity & 7;
        if (i12 == 3) {
            layoutParams2.addRule(9);
            layoutParams3.addRule(1, R.id.banner_indicatorId);
            this.mTipTv.setGravity(21);
        } else if (i12 == 5) {
            layoutParams2.addRule(11);
            layoutParams3.addRule(0, R.id.banner_indicatorId);
        } else {
            layoutParams2.addRule(14);
            layoutParams3.addRule(0, R.id.banner_indicatorId);
        }
        showPlaceholder();
    }

    private void initViewPager() {
        BGAViewPager bGAViewPager = this.mViewPager;
        if (bGAViewPager != null && equals(bGAViewPager.getParent())) {
            removeView(this.mViewPager);
            this.mViewPager = null;
        }
        BGAViewPager bGAViewPager2 = new BGAViewPager(getContext());
        this.mViewPager = bGAViewPager2;
        bGAViewPager2.setOffscreenPageLimit(1);
        this.mViewPager.setAdapter(new PageAdapter());
        this.mViewPager.addOnPageChangeListener(this);
        this.mViewPager.setOverScrollMode(this.mOverScrollMode);
        this.mViewPager.setAllowUserScrollable(this.mAllowUserScrollable);
        this.mViewPager.setPageTransformer(true, BGAPageTransformer.getPageTransformer(this.mTransitionEffect));
        setPageChangeDuration(this.mPageChangeDuration);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, this.mContentBottomMargin);
        addView(this.mViewPager, 0, layoutParams);
        if (!this.mAutoPlayAble || BGABannerUtil.isCollectionEmpty(this.mViews, new Collection[0])) {
            switchToPoint(0);
            return;
        }
        this.mViewPager.setAutoPlayDelegate(this);
        this.mViewPager.setCurrentItem(1073741823 - (1073741823 % this.mViews.size()));
        startAutoPlay();
    }

    private void onInvisibleToUser() {
        stopAutoPlay();
        if (!this.mIsFirstInvisible && this.mAutoPlayAble && this.mViewPager != null && getItemCount() > 0 && this.mPageScrollPositionOffset != 0.0f) {
            BGAViewPager bGAViewPager = this.mViewPager;
            bGAViewPager.setCurrentItem(bGAViewPager.getCurrentItem() - 1);
            BGAViewPager bGAViewPager2 = this.mViewPager;
            bGAViewPager2.setCurrentItem(bGAViewPager2.getCurrentItem() + 1);
        }
        this.mIsFirstInvisible = false;
    }

    /* access modifiers changed from: private */
    public void switchToNextPage() {
        BGAViewPager bGAViewPager = this.mViewPager;
        if (bGAViewPager != null) {
            bGAViewPager.setCurrentItem(bGAViewPager.getCurrentItem() + 1);
        }
    }

    private void switchToPoint(int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.mTipTv != null) {
            List<String> list = this.mTips;
            if (list == null || list.size() < 1 || i10 >= this.mTips.size()) {
                this.mTipTv.setVisibility(8);
            } else {
                this.mTipTv.setVisibility(0);
                this.mTipTv.setText(this.mTips.get(i10));
            }
        }
        if (this.mPointRealContainerLl != null) {
            List<View> list2 = this.mViews;
            if (list2 == null || list2.size() <= 0 || i10 >= this.mViews.size() || (!(z11 = this.mIsNeedShowIndicatorOnOnlyOnePage) && (z11 || this.mViews.size() <= 1))) {
                this.mPointRealContainerLl.setVisibility(8);
            } else {
                this.mPointRealContainerLl.setVisibility(0);
                for (int i11 = 0; i11 < this.mPointRealContainerLl.getChildCount(); i11++) {
                    View childAt = this.mPointRealContainerLl.getChildAt(i11);
                    if (i11 == i10) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    childAt.setSelected(z12);
                    this.mPointRealContainerLl.getChildAt(i11).requestLayout();
                }
            }
        }
        if (this.mNumberIndicatorTv != null) {
            List<View> list3 = this.mViews;
            if (list3 == null || list3.size() <= 0 || i10 >= this.mViews.size() || (!(z10 = this.mIsNeedShowIndicatorOnOnlyOnePage) && (z10 || this.mViews.size() <= 1))) {
                this.mNumberIndicatorTv.setVisibility(8);
                return;
            }
            this.mNumberIndicatorTv.setVisibility(0);
            TextView textView = this.mNumberIndicatorTv;
            textView.setText((i10 + 1) + Operator.Operation.DIVISION + this.mViews.size());
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mAutoPlayAble) {
            int action = motionEvent.getAction();
            if (action == 0) {
                stopAutoPlay();
            } else if (action == 1 || action == 3) {
                startAutoPlay();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        if (this.mViewPager == null || BGABannerUtil.isCollectionEmpty(this.mViews, new Collection[0])) {
            return -1;
        }
        return this.mViewPager.getCurrentItem() % this.mViews.size();
    }

    public int getItemCount() {
        List<View> list = this.mViews;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public ImageView getItemImageView(int i10) {
        return (ImageView) getItemView(i10);
    }

    public <VT extends View> VT getItemView(int i10) {
        List<View> list = this.mViews;
        if (list == null) {
            return null;
        }
        return (View) list.get(i10);
    }

    public List<String> getTips() {
        return this.mTips;
    }

    public BGAViewPager getViewPager() {
        return this.mViewPager;
    }

    public List<? extends View> getViews() {
        return this.mViews;
    }

    public void handleAutoPlayActionUpOrCancel(float f10) {
        BGAViewPager bGAViewPager = this.mViewPager;
        if (bGAViewPager == null) {
            return;
        }
        if (this.mPageScrollPosition < bGAViewPager.getCurrentItem()) {
            if (f10 > 400.0f || (this.mPageScrollPositionOffset < 0.7f && f10 > -400.0f)) {
                this.mViewPager.setBannerCurrentItemInternal(this.mPageScrollPosition, true);
            } else {
                this.mViewPager.setBannerCurrentItemInternal(this.mPageScrollPosition + 1, true);
            }
        } else if (this.mPageScrollPosition != this.mViewPager.getCurrentItem()) {
            this.mViewPager.setBannerCurrentItemInternal(this.mPageScrollPosition, true);
        } else if (f10 < -400.0f || (this.mPageScrollPositionOffset > 0.3f && f10 < 400.0f)) {
            this.mViewPager.setBannerCurrentItemInternal(this.mPageScrollPosition + 1, true);
        } else {
            this.mViewPager.setBannerCurrentItemInternal(this.mPageScrollPosition, true);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAutoPlay();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onInvisibleToUser();
    }

    public void onMeasure(int i10, int i11) {
        if (this.mAspectRatio > 0.0f) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) (((float) View.MeasureSpec.getSize(i10)) / this.mAspectRatio), Ints.MAX_POWER_OF_TWO);
        }
        super.onMeasure(i10, i11);
    }

    public void onPageScrollStateChanged(int i10) {
        ViewPager.j jVar = this.mOnPageChangeListener;
        if (jVar != null) {
            jVar.onPageScrollStateChanged(i10);
        }
    }

    public void onPageScrolled(int i10, float f10, int i11) {
        if (!BGABannerUtil.isCollectionEmpty(this.mViews, new Collection[0])) {
            handleGuideViewVisibility(i10 % this.mViews.size(), f10);
            this.mPageScrollPosition = i10;
            this.mPageScrollPositionOffset = f10;
            if (this.mTipTv != null) {
                if (BGABannerUtil.isCollectionNotEmpty(this.mTips, new Collection[0])) {
                    this.mTipTv.setVisibility(0);
                    int size = i10 % this.mTips.size();
                    int size2 = (i10 + 1) % this.mTips.size();
                    if (size2 < this.mTips.size() && size < this.mTips.size()) {
                        if (((double) f10) > 0.5d) {
                            this.mTipTv.setText(this.mTips.get(size2));
                            c1.n0(this.mTipTv, f10);
                        } else {
                            c1.n0(this.mTipTv, 1.0f - f10);
                            this.mTipTv.setText(this.mTips.get(size));
                        }
                    }
                } else {
                    this.mTipTv.setVisibility(8);
                }
            }
            ViewPager.j jVar = this.mOnPageChangeListener;
            if (jVar != null) {
                jVar.onPageScrolled(i10 % this.mViews.size(), f10, i11);
            }
        }
    }

    public void onPageSelected(int i10) {
        if (!BGABannerUtil.isCollectionEmpty(this.mViews, new Collection[0])) {
            int size = i10 % this.mViews.size();
            switchToPoint(size);
            ViewPager.j jVar = this.mOnPageChangeListener;
            if (jVar != null) {
                jVar.onPageSelected(size);
            }
        }
    }

    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            startAutoPlay();
        } else if (i10 == 4 || i10 == 8) {
            onInvisibleToUser();
        }
    }

    public void removePlaceholder() {
        ImageView imageView = this.mPlaceholderIv;
        if (imageView != null && equals(imageView.getParent())) {
            removeView(this.mPlaceholderIv);
            this.mPlaceholderIv = null;
        }
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void setAllowUserScrollable(boolean z10) {
        this.mAllowUserScrollable = z10;
        BGAViewPager bGAViewPager = this.mViewPager;
        if (bGAViewPager != null) {
            bGAViewPager.setAllowUserScrollable(z10);
        }
    }

    public void setAspectRatio(float f10) {
        this.mAspectRatio = f10;
        requestLayout();
    }

    public void setAutoPlayAble(boolean z10) {
        this.mAutoPlayAble = z10;
        stopAutoPlay();
        BGAViewPager bGAViewPager = this.mViewPager;
        if (bGAViewPager != null && bGAViewPager.getAdapter() != null) {
            this.mViewPager.getAdapter().notifyDataSetChanged();
        }
    }

    public void setAutoPlayInterval(int i10) {
        this.mAutoPlayInterval = i10;
    }

    public void setCurrentItem(int i10) {
        if (this.mViewPager != null && this.mViews != null) {
            if (i10 <= getItemCount() - 1) {
                if (this.mAutoPlayAble) {
                    int currentItem = this.mViewPager.getCurrentItem();
                    int size = i10 - (currentItem % this.mViews.size());
                    if (size < 0) {
                        for (int i11 = -1; i11 >= size; i11--) {
                            this.mViewPager.setCurrentItem(currentItem + i11, false);
                        }
                    } else if (size > 0) {
                        for (int i12 = 1; i12 <= size; i12++) {
                            this.mViewPager.setCurrentItem(currentItem + i12, false);
                        }
                    }
                    startAutoPlay();
                    return;
                }
                this.mViewPager.setCurrentItem(i10, false);
            }
        }
    }

    public void setData(List<View> list, List<? extends Object> list2, List<String> list3) {
        if (BGABannerUtil.isCollectionEmpty(list, new Collection[0])) {
            this.mAutoPlayAble = false;
            list = new ArrayList<>();
            list2 = new ArrayList<>();
            list3 = new ArrayList<>();
        }
        if (this.mAutoPlayAble && list.size() < 3 && this.mHackyViews == null) {
            this.mAutoPlayAble = false;
        }
        this.mModels = list2;
        this.mViews = list;
        this.mTips = list3;
        initIndicator();
        initViewPager();
        removePlaceholder();
        handleGuideViewVisibility(0, 0.0f);
    }

    public void setDelegate(Delegate delegate) {
        this.mDelegate = delegate;
    }

    public void setEnterSkipViewId(int i10, int i11) {
        if (i10 != 0) {
            this.mEnterView = ((Activity) getContext()).findViewById(i10);
        }
        if (i11 != 0) {
            this.mSkipView = ((Activity) getContext()).findViewById(i11);
        }
    }

    public void setEnterSkipViewIdAndDelegate(int i10, int i11, GuideDelegate guideDelegate) {
        if (guideDelegate != null) {
            this.mGuideDelegate = guideDelegate;
            if (i10 != 0) {
                View findViewById = ((Activity) getContext()).findViewById(i10);
                this.mEnterView = findViewById;
                findViewById.setOnClickListener(this.mGuideOnNoDoubleClickListener);
            }
            if (i11 != 0) {
                View findViewById2 = ((Activity) getContext()).findViewById(i11);
                this.mSkipView = findViewById2;
                findViewById2.setOnClickListener(this.mGuideOnNoDoubleClickListener);
            }
        }
        handleGuideViewVisibility(0, 0.0f);
    }

    public void setIndicatorTopBottomMarginDp(int i10) {
        setIndicatorTopBottomMarginPx(BGABannerUtil.dp2px(getContext(), (float) i10));
    }

    public void setIndicatorTopBottomMarginPx(int i10) {
        this.mPointTopBottomMargin = i10;
        RelativeLayout relativeLayout = this.mPointContainerRl;
        int i11 = this.mPointContainerLeftRightPadding;
        relativeLayout.setPadding(i11, i10, i11, i10);
    }

    public void setIndicatorTopBottomMarginRes(int i10) {
        setIndicatorTopBottomMarginPx(getResources().getDimensionPixelOffset(i10));
    }

    public void setIndicatorVisibility(boolean z10) {
        int i10;
        RelativeLayout relativeLayout = this.mPointContainerRl;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        relativeLayout.setVisibility(i10);
    }

    public void setIsNeedShowIndicatorOnOnlyOnePage(boolean z10) {
        this.mIsNeedShowIndicatorOnOnlyOnePage = z10;
    }

    public void setOnPageChangeListener(ViewPager.j jVar) {
        this.mOnPageChangeListener = jVar;
    }

    public void setOverScrollMode(int i10) {
        this.mOverScrollMode = i10;
        BGAViewPager bGAViewPager = this.mViewPager;
        if (bGAViewPager != null) {
            bGAViewPager.setOverScrollMode(i10);
        }
    }

    public void setPageChangeDuration(int i10) {
        if (i10 >= 0 && i10 <= 2000) {
            this.mPageChangeDuration = i10;
            BGAViewPager bGAViewPager = this.mViewPager;
            if (bGAViewPager != null) {
                bGAViewPager.setPageChangeDuration(i10);
            }
        }
    }

    public void setPageTransformer(ViewPager.k kVar) {
        BGAViewPager bGAViewPager;
        if (kVar != null && (bGAViewPager = this.mViewPager) != null) {
            bGAViewPager.setPageTransformer(true, kVar);
        }
    }

    public void setTransitionEffect(TransitionEffect transitionEffect) {
        this.mTransitionEffect = transitionEffect;
        if (this.mViewPager != null) {
            initViewPager();
            List<View> list = this.mHackyViews;
            if (list == null) {
                BGABannerUtil.resetPageTransformer(this.mViews);
            } else {
                BGABannerUtil.resetPageTransformer(list);
            }
        }
    }

    public void showPlaceholder() {
        if (this.mPlaceholderIv == null && this.mPlaceholderDrawableResId != -1) {
            this.mPlaceholderIv = BGABannerUtil.getItemImageView(getContext(), this.mPlaceholderDrawableResId, new BGALocalImageSize(720, 360, 640.0f, 320.0f), this.mScaleType);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(0, 0, 0, this.mContentBottomMargin);
            addView(this.mPlaceholderIv, layoutParams);
        }
    }

    public void startAutoPlay() {
        stopAutoPlay();
        if (this.mAutoPlayAble) {
            postDelayed(this.mAutoPlayTask, (long) this.mAutoPlayInterval);
        }
    }

    public void stopAutoPlay() {
        AutoPlayTask autoPlayTask = this.mAutoPlayTask;
        if (autoPlayTask != null) {
            removeCallbacks(autoPlayTask);
        }
    }

    public BGABanner(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAutoPlayAble = true;
        this.mAutoPlayInterval = 3000;
        this.mPageChangeDuration = 800;
        this.mPointGravity = 81;
        this.mTipTextColor = -1;
        this.mPointDrawableResId = R.drawable.bga_banner_selector_point_solid;
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.mPlaceholderDrawableResId = -1;
        this.mOverScrollMode = 2;
        this.mIsNumberIndicator = false;
        this.mNumberIndicatorTextColor = -1;
        this.mAllowUserScrollable = true;
        this.mIsFirstInvisible = true;
        this.mGuideOnNoDoubleClickListener = new BGAOnNoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                if (BGABanner.this.mGuideDelegate != null) {
                    BGABanner.this.mGuideDelegate.onClickEnterOrSkip();
                }
            }
        };
        initDefaultAttrs(context);
        initCustomAttrs(context, attributeSet);
        initView(context);
    }

    public void setData(int i10, List<? extends Object> list, List<String> list2) {
        this.mViews = new ArrayList();
        if (list == null) {
            list = new ArrayList<>();
            list2 = new ArrayList<>();
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.mViews.add(inflateItemView(i10));
        }
        if (this.mAutoPlayAble && this.mViews.size() < 3) {
            ArrayList arrayList = new ArrayList(this.mViews);
            this.mHackyViews = arrayList;
            arrayList.add(inflateItemView(i10));
            if (this.mHackyViews.size() == 2) {
                this.mHackyViews.add(inflateItemView(i10));
            }
        }
        setData(this.mViews, list, list2);
    }

    public void setData(List<? extends Object> list, List<String> list2) {
        setData(R.layout.bga_banner_item_image, list, list2);
    }

    public void setData(List<View> list) {
        setData(list, (List<? extends Object>) null, (List<String>) null);
    }

    public void setData(BGALocalImageSize bGALocalImageSize, ImageView.ScaleType scaleType, int... iArr) {
        if (bGALocalImageSize == null) {
            bGALocalImageSize = new BGALocalImageSize(720, 1280, 320.0f, 640.0f);
        }
        if (scaleType != null) {
            this.mScaleType = scaleType;
        }
        ArrayList arrayList = new ArrayList();
        for (int itemImageView : iArr) {
            arrayList.add(BGABannerUtil.getItemImageView(getContext(), itemImageView, bGALocalImageSize, this.mScaleType));
        }
        setData(arrayList);
    }
}
