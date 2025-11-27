package com.mobile.brasiltv.view.shortvideo;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.widget.i;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import b0.c1;
import b0.h0;
import b0.p1;
import b0.u;
import c0.g0;
import c0.k0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import x.o;
import x.p;

public class VerticalViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() {
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    /* access modifiers changed from: private */
    public static final int[] LAYOUT_ATTRS = {16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    };
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
    private final int TYPE_VIEW_SCROLLED = 4096;
    private int mActivePointerId = -1;
    /* access modifiers changed from: private */
    public a mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private i mBottomEdge;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    /* access modifiers changed from: private */
    public int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new Runnable() {
        public void run() {
            VerticalViewPager.this.setScrollState(0);
            VerticalViewPager.this.populate();
        }
    };
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private ViewPager.j mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems = new ArrayList<>();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private int mLeftPageBounds;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit = 1;
    private ViewPager.j mOnPageChangeListener;
    private int mPageMargin;
    private ViewPager.k mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private int mRightPageBounds;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem = new ItemInfo();
    private final Rect mTempRect = new Rect();
    private i mTopEdge;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public interface Decor {
    }

    public static class ItemInfo {
        float heightFactor;
        Object object;
        float offset;
        int position;
        boolean scrolling;
    }

    public class MyAccessibilityDelegate extends b0.a {
        public MyAccessibilityDelegate() {
        }

        private boolean canScroll() {
            if (VerticalViewPager.this.mAdapter == null || VerticalViewPager.this.mAdapter.getCount() <= 1) {
                return false;
            }
            return true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            k0 a10 = k0.a();
            a10.f(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && VerticalViewPager.this.mAdapter != null) {
                a10.c(VerticalViewPager.this.mAdapter.getCount());
                a10.b(VerticalViewPager.this.mCurItem);
                a10.h(VerticalViewPager.this.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.W(ViewPager.class.getName());
            g0Var.o0(canScroll());
            if (VerticalViewPager.this.internalCanScrollVertically(1)) {
                g0Var.a(4096);
            }
            if (VerticalViewPager.this.internalCanScrollVertically(-1)) {
                g0Var.a(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            if (i10 != 4096) {
                if (i10 != 8192 || !VerticalViewPager.this.internalCanScrollVertically(-1)) {
                    return false;
                }
                VerticalViewPager verticalViewPager = VerticalViewPager.this;
                verticalViewPager.setCurrentItem(verticalViewPager.mCurItem - 1);
                return true;
            } else if (!VerticalViewPager.this.internalCanScrollVertically(1)) {
                return false;
            } else {
                VerticalViewPager verticalViewPager2 = VerticalViewPager.this;
                verticalViewPager2.setCurrentItem(verticalViewPager2.mCurItem + 1);
                return true;
            }
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(a aVar, a aVar2);
    }

    public class PagerObserver extends DataSetObserver {
        public void onChanged() {
            VerticalViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            VerticalViewPager.this.dataSetChanged();
        }

        private PagerObserver() {
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = o.a(new p() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i10);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    public static class ViewPositionComparator implements Comparator<View> {
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z10 = layoutParams.isDecor;
            if (z10 != layoutParams2.isDecor) {
                return z10 ? 1 : -1;
            }
            return layoutParams.position - layoutParams2.position;
        }
    }

    public VerticalViewPager(Context context) {
        super(context);
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i10, ItemInfo itemInfo2) {
        float f10;
        float f11;
        float f12;
        int i11;
        int i12;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        int clientHeight = getClientHeight();
        if (clientHeight > 0) {
            f10 = ((float) this.mPageMargin) / ((float) clientHeight);
        } else {
            f10 = 0.0f;
        }
        if (itemInfo2 != null) {
            int i13 = itemInfo2.position;
            int i14 = itemInfo.position;
            if (i13 < i14) {
                float f13 = itemInfo2.offset + itemInfo2.heightFactor + f10;
                int i15 = i13 + 1;
                int i16 = 0;
                while (i15 <= itemInfo.position && i16 < this.mItems.size()) {
                    Object obj = this.mItems.get(i16);
                    while (true) {
                        itemInfo4 = (ItemInfo) obj;
                        if (i15 > itemInfo4.position && i16 < this.mItems.size() - 1) {
                            i16++;
                            obj = this.mItems.get(i16);
                        }
                    }
                    while (i15 < itemInfo4.position) {
                        f13 += this.mAdapter.getPageWidth(i15) + f10;
                        i15++;
                    }
                    itemInfo4.offset = f13;
                    f13 += itemInfo4.heightFactor + f10;
                    i15++;
                }
            } else if (i13 > i14) {
                int size = this.mItems.size() - 1;
                float f14 = itemInfo2.offset;
                while (true) {
                    i13--;
                    if (i13 < itemInfo.position || size < 0) {
                        break;
                    }
                    Object obj2 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = (ItemInfo) obj2;
                        if (i13 < itemInfo3.position && size > 0) {
                            size--;
                            obj2 = this.mItems.get(size);
                        }
                    }
                    while (i13 > itemInfo3.position) {
                        f14 -= this.mAdapter.getPageWidth(i13) + f10;
                        i13--;
                    }
                    f14 -= itemInfo3.heightFactor + f10;
                    itemInfo3.offset = f14;
                }
            }
        }
        int size2 = this.mItems.size();
        float f15 = itemInfo.offset;
        int i17 = itemInfo.position;
        int i18 = i17 - 1;
        if (i17 == 0) {
            f11 = f15;
        } else {
            f11 = -3.4028235E38f;
        }
        this.mFirstOffset = f11;
        int i19 = count - 1;
        if (i17 == i19) {
            f12 = (itemInfo.heightFactor + f15) - 1.0f;
        } else {
            f12 = Float.MAX_VALUE;
        }
        this.mLastOffset = f12;
        int i20 = i10 - 1;
        while (i20 >= 0) {
            ItemInfo itemInfo5 = this.mItems.get(i20);
            while (true) {
                i12 = itemInfo5.position;
                if (i18 <= i12) {
                    break;
                }
                f15 -= this.mAdapter.getPageWidth(i18) + f10;
                i18--;
            }
            f15 -= itemInfo5.heightFactor + f10;
            itemInfo5.offset = f15;
            if (i12 == 0) {
                this.mFirstOffset = f15;
            }
            i20--;
            i18--;
        }
        float f16 = itemInfo.offset + itemInfo.heightFactor + f10;
        int i21 = itemInfo.position + 1;
        int i22 = i10 + 1;
        while (i22 < size2) {
            ItemInfo itemInfo6 = this.mItems.get(i22);
            while (true) {
                i11 = itemInfo6.position;
                if (i21 >= i11) {
                    break;
                }
                f16 += this.mAdapter.getPageWidth(i21) + f10;
                i21++;
            }
            if (i11 == i19) {
                this.mLastOffset = (itemInfo6.heightFactor + f16) - 1.0f;
            }
            itemInfo6.offset = f16;
            f16 += itemInfo6.heightFactor + f10;
            i22++;
            i21++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z10) {
        boolean z11;
        if (this.mScrollState == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.mPopulatePending = false;
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            ItemInfo itemInfo = this.mItems.get(i10);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z11 = true;
            }
        }
        if (!z11) {
            return;
        }
        if (z10) {
            c1.c0(this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i10, float f10, int i11, int i12) {
        float f11;
        if (Math.abs(i12) <= this.mFlingDistance || Math.abs(i11) <= this.mMinimumVelocity) {
            if (i10 >= this.mCurItem) {
                f11 = 0.4f;
            } else {
                f11 = 0.6f;
            }
            i10 = (int) (((float) i10) + f10 + f11);
        } else if (i11 <= 0) {
            i10++;
        }
        if (this.mItems.size() <= 0) {
            return i10;
        }
        ArrayList<ItemInfo> arrayList = this.mItems;
        return Math.max(this.mItems.get(0).position, Math.min(i10, arrayList.get(arrayList.size() - 1).position));
    }

    private void enableLayers(boolean z10) {
        int i10;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (z10) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            c1.x0(getChildAt(i11), i10, (Paint) null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        float f10;
        float f11;
        int i10;
        int clientHeight = getClientHeight();
        float f12 = 0.0f;
        if (clientHeight > 0) {
            f10 = ((float) getScrollY()) / ((float) clientHeight);
        } else {
            f10 = 0.0f;
        }
        if (clientHeight > 0) {
            f11 = ((float) this.mPageMargin) / ((float) clientHeight);
        } else {
            f11 = 0.0f;
        }
        ItemInfo itemInfo = null;
        float f13 = 0.0f;
        int i11 = -1;
        int i12 = 0;
        boolean z10 = true;
        while (i12 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i12);
            if (!z10 && itemInfo2.position != (i10 = i11 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f12 + f13 + f11;
                itemInfo2.position = i10;
                itemInfo2.heightFactor = this.mAdapter.getPageWidth(i10);
                i12--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f12 = itemInfo3.offset;
            float f14 = itemInfo3.heightFactor + f12 + f11;
            if (!z10 && f10 < f12) {
                return itemInfo;
            }
            if (f10 < f14 || i12 == this.mItems.size() - 1) {
                return itemInfo3;
            }
            int i13 = itemInfo3.position;
            float f15 = itemInfo3.heightFactor;
            i12++;
            z10 = false;
            ItemInfo itemInfo4 = itemInfo3;
            i11 = i13;
            f13 = f15;
            itemInfo = itemInfo4;
        }
        return itemInfo;
    }

    private boolean isGutterDrag(float f10, float f11) {
        if ((f10 >= ((float) this.mGutterSize) || f11 <= 0.0f) && (f10 <= ((float) (getHeight() - this.mGutterSize)) || f11 >= 0.0f)) {
            return false;
        }
        return true;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i10;
        int b10 = u.b(motionEvent);
        if (u.d(motionEvent, b10) == this.mActivePointerId) {
            if (b10 == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.mLastMotionY = u.f(motionEvent, i10);
            this.mActivePointerId = u.d(motionEvent, i10);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i10) {
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientHeight = getClientHeight();
        int i11 = this.mPageMargin;
        int i12 = clientHeight + i11;
        float f10 = (float) clientHeight;
        int i13 = infoForCurrentScrollPosition.position;
        float f11 = ((((float) i10) / f10) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.heightFactor + (((float) i11) / f10));
        this.mCalledSuper = false;
        onPageScrolled(i13, f11, (int) (((float) i12) * f11));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float f10) {
        boolean z10;
        float f11 = this.mLastMotionY - f10;
        this.mLastMotionY = f10;
        float scrollY = ((float) getScrollY()) + f11;
        float clientHeight = (float) getClientHeight();
        float f12 = this.mFirstOffset * clientHeight;
        float f13 = this.mLastOffset * clientHeight;
        boolean z11 = false;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        boolean z12 = true;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.position != 0) {
            f12 = itemInfo.offset * clientHeight;
            z10 = false;
        } else {
            z10 = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f13 = itemInfo2.offset * clientHeight;
            z12 = false;
        }
        if (scrollY < f12) {
            if (z10) {
                z11 = this.mTopEdge.e(Math.abs(f12 - scrollY) / clientHeight);
            }
            scrollY = f12;
        } else if (scrollY > f13) {
            if (z12) {
                z11 = this.mBottomEdge.e(Math.abs(scrollY - f13) / clientHeight);
            }
            scrollY = f13;
        }
        int i10 = (int) scrollY;
        this.mLastMotionX += scrollY - ((float) i10);
        scrollTo(getScrollX(), i10);
        pageScrolled(i10);
        return z11;
    }

    private void recomputeScrollPosition(int i10, int i11, int i12, int i13) {
        float f10;
        if (i11 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            if (infoForPosition != null) {
                f10 = Math.min(infoForPosition.offset, this.mLastOffset);
            } else {
                f10 = 0.0f;
            }
            int paddingTop = (int) (f10 * ((float) ((i10 - getPaddingTop()) - getPaddingBottom())));
            if (paddingTop != getScrollY()) {
                completeScroll(false);
                scrollTo(getScrollX(), paddingTop);
                return;
            }
            return;
        }
        int scrollY = (int) ((((float) getScrollY()) / ((float) (((i11 - getPaddingTop()) - getPaddingBottom()) + i13))) * ((float) (((i10 - getPaddingTop()) - getPaddingBottom()) + i12)));
        scrollTo(getScrollX(), scrollY);
        if (!this.mScroller.isFinished()) {
            this.mScroller.startScroll(0, scrollY, 0, (int) (infoForPosition(this.mCurItem).offset * ((float) i10)), this.mScroller.getDuration() - this.mScroller.timePassed());
        }
    }

    private void removeNonDecorViews() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i10).getLayoutParams()).isDecor) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    private void scrollToItem(int i10, boolean z10, int i11, boolean z11) {
        int i12;
        ViewPager.j jVar;
        ViewPager.j jVar2;
        ViewPager.j jVar3;
        ViewPager.j jVar4;
        ItemInfo infoForPosition = infoForPosition(i10);
        if (infoForPosition != null) {
            i12 = (int) (((float) getClientHeight()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)));
        } else {
            i12 = 0;
        }
        if (z10) {
            smoothScrollTo(0, i12, i11);
            if (z11 && (jVar4 = this.mOnPageChangeListener) != null) {
                jVar4.onPageSelected(i10);
            }
            if (z11 && (jVar3 = this.mInternalPageChangeListener) != null) {
                jVar3.onPageSelected(i10);
                return;
            }
            return;
        }
        if (z11 && (jVar2 = this.mOnPageChangeListener) != null) {
            jVar2.onPageSelected(i10);
        }
        if (z11 && (jVar = this.mInternalPageChangeListener) != null) {
            jVar.onPageSelected(i10);
        }
        completeScroll(false);
        scrollTo(0, i12);
        pageScrolled(i12);
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i10) {
        boolean z10;
        if (this.mScrollState != i10) {
            this.mScrollState = i10;
            if (this.mPageTransformer != null) {
                if (i10 != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                enableLayers(z10);
            }
            ViewPager.j jVar = this.mOnPageChangeListener;
            if (jVar != null) {
                jVar.onPageScrollStateChanged(i10);
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.mScrollingCacheEnabled != z10) {
            this.mScrollingCacheEnabled = z10;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.mDrawingOrderedChildren.add(getChildAt(i10));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        ItemInfo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i11 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    public ItemInfo addNewItem(int i10, int i11) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i10;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i10);
        itemInfo.heightFactor = this.mAdapter.getPageWidth(i10);
        if (i11 < 0 || i11 >= this.mItems.size()) {
            this.mItems.add(itemInfo);
        } else {
            this.mItems.add(i11, itemInfo);
        }
        return itemInfo;
    }

    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z10 = layoutParams2.isDecor | (view instanceof Decor);
        layoutParams2.isDecor = z10;
        if (!this.mInLayout) {
            super.addView(view, i10, layoutParams);
        } else if (!z10) {
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i10, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto L_0x000b
        L_0x0009:
            r0 = r3
            goto L_0x0069
        L_0x000b:
            if (r0 == 0) goto L_0x0069
            android.view.ViewParent r4 = r0.getParent()
        L_0x0011:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x001e
            if (r4 != r6) goto L_0x0019
            r4 = 1
            goto L_0x001f
        L_0x0019:
            android.view.ViewParent r4 = r4.getParent()
            goto L_0x0011
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r4 != 0) goto L_0x0069
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L_0x0035:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x004e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0035
        L_0x004e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
            goto L_0x0009
        L_0x0069:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 130(0x82, float:1.82E-43)
            r5 = 33
            if (r3 == 0) goto L_0x00ba
            if (r3 == r0) goto L_0x00ba
            if (r7 != r5) goto L_0x009a
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.getChildRectInPagerCoordinates(r1, r3)
            int r1 = r1.top
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.getChildRectInPagerCoordinates(r2, r0)
            int r2 = r2.top
            if (r0 == 0) goto L_0x0094
            if (r1 < r2) goto L_0x0094
            boolean r0 = r6.pageUp()
            goto L_0x0098
        L_0x0094:
            boolean r0 = r3.requestFocus()
        L_0x0098:
            r2 = r0
            goto L_0x00cd
        L_0x009a:
            if (r7 != r4) goto L_0x00cd
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.getChildRectInPagerCoordinates(r1, r3)
            int r1 = r1.bottom
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.getChildRectInPagerCoordinates(r2, r0)
            int r2 = r2.bottom
            if (r0 == 0) goto L_0x00b5
            if (r1 > r2) goto L_0x00b5
            boolean r0 = r6.pageDown()
            goto L_0x0098
        L_0x00b5:
            boolean r0 = r3.requestFocus()
            goto L_0x0098
        L_0x00ba:
            if (r7 == r5) goto L_0x00c9
            if (r7 != r1) goto L_0x00bf
            goto L_0x00c9
        L_0x00bf:
            if (r7 == r4) goto L_0x00c4
            r0 = 2
            if (r7 != r0) goto L_0x00cd
        L_0x00c4:
            boolean r2 = r6.pageDown()
            goto L_0x00cd
        L_0x00c9:
            boolean r2 = r6.pageUp()
        L_0x00cd:
            if (r2 == 0) goto L_0x00d6
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        L_0x00d6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionY = 0.0f;
        this.mInitialMotionY = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public boolean canScroll(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i12 + scrollY;
                if (i14 >= childAt.getTop() && i14 < childAt.getBottom() && (i13 = i11 + scrollX) >= childAt.getLeft() && i13 < childAt.getRight()) {
                    if (canScroll(childAt, true, i10, i13 - childAt.getLeft(), i14 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z10 || !c1.d(view, -i10)) {
            return false;
        }
        return true;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public void computeScroll() {
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currY)) {
                this.mScroller.abortAnimation();
                scrollTo(currX, 0);
            }
        }
        c1.b0(this);
    }

    /* access modifiers changed from: package-private */
    public void dataSetChanged() {
        boolean z10;
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        if (this.mItems.size() >= (this.mOffscreenPageLimit * 2) + 1 || this.mItems.size() >= count) {
            z10 = false;
        } else {
            z10 = true;
        }
        int i10 = this.mCurItem;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i11);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i11);
                    i11--;
                    if (!z11) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z11 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i12 = this.mCurItem;
                    if (i12 == itemInfo.position) {
                        i10 = Math.max(0, Math.min(i12, count - 1));
                    }
                } else {
                    int i13 = itemInfo.position;
                    if (i13 != itemPosition) {
                        if (i13 == this.mCurItem) {
                            i10 = itemPosition;
                        }
                        itemInfo.position = itemPosition;
                    }
                }
                z10 = true;
            }
            i11++;
        }
        if (z11) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z10) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i14).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.heightFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i10, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public float distanceInfluenceForSnapDuration(float f10) {
        double d10 = (double) (f10 - 0.5f);
        Double.isNaN(d10);
        return (float) Math.sin((double) ((float) (d10 * 0.4712389167638204d)));
    }

    public void draw(Canvas canvas) {
        a aVar;
        super.draw(canvas);
        int D = c1.D(this);
        boolean z10 = false;
        if (D == 0 || (D == 1 && (aVar = this.mAdapter) != null && aVar.getCount() > 1)) {
            if (!this.mTopEdge.c()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), this.mFirstOffset * ((float) height));
                this.mTopEdge.g(width, height);
                z10 = false | this.mTopEdge.a(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mBottomEdge.c()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((float) ((-width2) - getPaddingLeft()), (-(this.mLastOffset + 1.0f)) * ((float) height2));
                this.mBottomEdge.g(width2, height2);
                z10 |= this.mBottomEdge.a(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mTopEdge.b();
            this.mBottomEdge.b();
        }
        if (z10) {
            c1.b0(this);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
            int b10 = (int) h0.b(velocityTracker, this.mActivePointerId);
            this.mPopulatePending = true;
            int clientHeight = getClientHeight();
            int scrollY = getScrollY();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollY) / ((float) clientHeight)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.heightFactor, b10, (int) (this.mLastMotionY - this.mInitialMotionY)), true, true, b10);
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return arrowScroll(17);
            }
            if (keyCode == 22) {
                return arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f10) {
        if (this.mFakeDragging) {
            this.mLastMotionY += f10;
            float scrollY = ((float) getScrollY()) - f10;
            float clientHeight = (float) getClientHeight();
            float f11 = this.mFirstOffset * clientHeight;
            float f12 = this.mLastOffset * clientHeight;
            ItemInfo itemInfo = this.mItems.get(0);
            ArrayList<ItemInfo> arrayList = this.mItems;
            ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
            if (itemInfo.position != 0) {
                f11 = itemInfo.offset * clientHeight;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f12 = itemInfo2.offset * clientHeight;
            }
            if (scrollY < f11) {
                scrollY = f11;
            } else if (scrollY > f12) {
                scrollY = f12;
            }
            int i10 = (int) scrollY;
            this.mLastMotionY += scrollY - ((float) i10);
            scrollTo(getScrollX(), i10);
            pageScrolled(i10);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, 0.0f, this.mLastMotionY, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    public int getChildDrawingOrder(int i10, int i11) {
        if (this.mDrawingOrder == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i11).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public ItemInfo infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public ItemInfo infoForChild(View view) {
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            ItemInfo itemInfo = this.mItems.get(i10);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    public ItemInfo infoForPosition(int i10) {
        for (int i11 = 0; i11 < this.mItems.size(); i11++) {
            ItemInfo itemInfo = this.mItems.get(i11);
            if (itemInfo.position == i10) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = p1.d(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f10);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mTopEdge = new i(context);
        this.mBottomEdge = new i(context);
        this.mFlingDistance = (int) (25.0f * f10);
        this.mCloseEnough = (int) (2.0f * f10);
        this.mDefaultGutterSize = (int) (f10 * 16.0f);
        c1.k0(this, new MyAccessibilityDelegate());
        if (c1.x(this) == 0) {
            c1.v0(this, 1);
        }
    }

    public boolean internalCanScrollVertically(int i10) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        if (i10 < 0) {
            if (scrollY > ((int) (((float) clientHeight) * this.mFirstOffset))) {
                return true;
            }
            return false;
        } else if (i10 <= 0 || scrollY >= ((int) (((float) clientHeight) * this.mLastOffset))) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r19) {
        /*
            r18 = this;
            r0 = r18
            super.onDraw(r19)
            int r1 = r0.mPageMargin
            if (r1 <= 0) goto L_0x00a6
            android.graphics.drawable.Drawable r1 = r0.mMarginDrawable
            if (r1 == 0) goto L_0x00a6
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r1 = r0.mItems
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00a6
            androidx.viewpager.widget.a r1 = r0.mAdapter
            if (r1 == 0) goto L_0x00a6
            int r1 = r18.getScrollY()
            int r2 = r18.getHeight()
            int r3 = r0.mPageMargin
            float r3 = (float) r3
            float r4 = (float) r2
            float r3 = r3 / r4
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r5 = r0.mItems
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r5 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r5
            float r7 = r5.offset
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r8 = r0.mItems
            int r8 = r8.size()
            int r9 = r5.position
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r10 = r0.mItems
            int r11 = r8 + -1
            java.lang.Object r10 = r10.get(r11)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r10 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r10
            int r10 = r10.position
        L_0x0045:
            if (r9 >= r10) goto L_0x00a6
        L_0x0047:
            int r11 = r5.position
            if (r9 <= r11) goto L_0x0058
            if (r6 >= r8) goto L_0x0058
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r5 = r0.mItems
            int r6 = r6 + 1
            java.lang.Object r5 = r5.get(r6)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r5 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r5
            goto L_0x0047
        L_0x0058:
            if (r9 != r11) goto L_0x0065
            float r7 = r5.offset
            float r11 = r5.heightFactor
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r7 = r7 + r11
            float r7 = r7 + r3
            goto L_0x0071
        L_0x0065:
            androidx.viewpager.widget.a r11 = r0.mAdapter
            float r11 = r11.getPageWidth(r9)
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r11 = r11 + r3
            float r7 = r7 + r11
        L_0x0071:
            int r11 = r0.mPageMargin
            float r13 = (float) r11
            float r13 = r13 + r12
            float r14 = (float) r1
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r13 <= 0) goto L_0x0095
            android.graphics.drawable.Drawable r13 = r0.mMarginDrawable
            int r14 = r0.mLeftPageBounds
            int r15 = (int) r12
            r16 = r3
            int r3 = r0.mRightPageBounds
            float r11 = (float) r11
            float r11 = r11 + r12
            r17 = 1056964608(0x3f000000, float:0.5)
            float r11 = r11 + r17
            int r11 = (int) r11
            r13.setBounds(r14, r15, r3, r11)
            android.graphics.drawable.Drawable r3 = r0.mMarginDrawable
            r11 = r19
            r3.draw(r11)
            goto L_0x0099
        L_0x0095:
            r11 = r19
            r16 = r3
        L_0x0099:
            int r3 = r1 + r2
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a1
            goto L_0x00a6
        L_0x00a1:
            int r9 = r9 + 1
            r3 = r16
            goto L_0x0045
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f10;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.mInitialMotionX = x10;
            this.mLastMotionX = x10;
            float y10 = motionEvent.getY();
            this.mInitialMotionY = y10;
            this.mLastMotionY = y10;
            this.mActivePointerId = u.d(motionEvent2, 0);
            this.mIsUnableToDrag = false;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalY() - this.mScroller.getCurrY()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i10 = this.mActivePointerId;
            if (i10 != -1) {
                int a10 = u.a(motionEvent2, i10);
                float f11 = u.f(motionEvent2, a10);
                float f12 = f11 - this.mLastMotionY;
                float abs = Math.abs(f12);
                float e10 = u.e(motionEvent2, a10);
                float abs2 = Math.abs(e10 - this.mInitialMotionX);
                if (f12 != 0.0f && !isGutterDrag(this.mLastMotionY, f12)) {
                    if (canScroll(this, false, (int) f12, (int) e10, (int) f11)) {
                        this.mLastMotionX = e10;
                        this.mLastMotionY = f11;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                int i11 = this.mTouchSlop;
                if (abs > ((float) i11) && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    if (f12 > 0.0f) {
                        f10 = this.mInitialMotionY + ((float) this.mTouchSlop);
                    } else {
                        f10 = this.mInitialMotionY - ((float) this.mTouchSlop);
                    }
                    this.mLastMotionY = f10;
                    this.mLastMotionX = e10;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i11)) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(f11)) {
                    c1.b0(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent2);
        return this.mIsBeingDragged;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r18.getPaddingLeft()
            int r5 = r18.getPaddingTop()
            int r6 = r18.getPaddingRight()
            int r7 = r18.getPaddingBottom()
            int r8 = r18.getScrollY()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b6
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b2
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$LayoutParams r12 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.LayoutParams) r12
            boolean r14 = r12.isDecor
            if (r14 == 0) goto L_0x00b2
            int r12 = r12.gravity
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x005c
            r15 = 3
            if (r14 == r15) goto L_0x0056
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006d
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
            goto L_0x0068
        L_0x0056:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006d
        L_0x005c:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
        L_0x0068:
            r17 = r14
            r14 = r4
            r4 = r17
        L_0x006d:
            r15 = 16
            if (r12 == r15) goto L_0x008e
            r15 = 48
            if (r12 == r15) goto L_0x0088
            r15 = 80
            if (r12 == r15) goto L_0x007b
            r12 = r5
            goto L_0x009f
        L_0x007b:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
            goto L_0x009a
        L_0x0088:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x009f
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
        L_0x009a:
            r17 = r12
            r12 = r5
            r5 = r17
        L_0x009f:
            int r5 = r5 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r5 + r16
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b6:
            int r3 = r3 - r5
            int r3 = r3 - r7
            r7 = 0
        L_0x00b9:
            if (r7 >= r1) goto L_0x0108
            android.view.View r8 = r0.getChildAt(r7)
            int r9 = r8.getVisibility()
            if (r9 == r12) goto L_0x0105
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$LayoutParams r9 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.LayoutParams) r9
            boolean r10 = r9.isDecor
            if (r10 != 0) goto L_0x0105
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r10 = r0.infoForChild(r8)
            if (r10 == 0) goto L_0x0105
            float r13 = (float) r3
            float r10 = r10.offset
            float r10 = r10 * r13
            int r10 = (int) r10
            int r10 = r10 + r5
            boolean r14 = r9.needsMeasure
            if (r14 == 0) goto L_0x00f8
            r14 = 0
            r9.needsMeasure = r14
            int r14 = r2 - r4
            int r14 = r14 - r6
            r15 = 1073741824(0x40000000, float:2.0)
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r15)
            float r9 = r9.heightFactor
            float r13 = r13 * r9
            int r9 = (int) r13
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r15)
            r8.measure(r14, r9)
        L_0x00f8:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r4
            int r13 = r8.getMeasuredHeight()
            int r13 = r13 + r10
            r8.layout(r4, r10, r9, r13)
        L_0x0105:
            int r7 = r7 + 1
            goto L_0x00b9
        L_0x0108:
            r0.mLeftPageBounds = r4
            int r2 = r2 - r6
            r0.mRightPageBounds = r2
            r0.mDecorChildCount = r11
            boolean r1 = r0.mFirstLayout
            if (r1 == 0) goto L_0x011a
            int r1 = r0.mCurItem
            r2 = 0
            r0.scrollToItem(r1, r2, r2, r2)
            goto L_0x011b
        L_0x011a:
            r2 = 0
        L_0x011b:
            r0.mFirstLayout = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r0 = 0
            int r14 = android.view.View.getDefaultSize(r0, r14)
            int r15 = android.view.View.getDefaultSize(r0, r15)
            r13.setMeasuredDimension(r14, r15)
            int r14 = r13.getMeasuredHeight()
            int r15 = r14 / 10
            int r1 = r13.mDefaultGutterSize
            int r15 = java.lang.Math.min(r15, r1)
            r13.mGutterSize = r15
            int r15 = r13.getMeasuredWidth()
            int r1 = r13.getPaddingLeft()
            int r15 = r15 - r1
            int r1 = r13.getPaddingRight()
            int r15 = r15 - r1
            int r1 = r13.getPaddingTop()
            int r14 = r14 - r1
            int r1 = r13.getPaddingBottom()
            int r14 = r14 - r1
            int r1 = r13.getChildCount()
            r2 = 0
        L_0x0037:
            r3 = 8
            r4 = 1
            r5 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r1) goto L_0x00b2
            android.view.View r6 = r13.getChildAt(r2)
            int r7 = r6.getVisibility()
            if (r7 == r3) goto L_0x00af
            android.view.ViewGroup$LayoutParams r3 = r6.getLayoutParams()
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$LayoutParams r3 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.LayoutParams) r3
            if (r3 == 0) goto L_0x00af
            boolean r7 = r3.isDecor
            if (r7 == 0) goto L_0x00af
            int r7 = r3.gravity
            r8 = r7 & 7
            r7 = r7 & 112(0x70, float:1.57E-43)
            r9 = 48
            if (r7 == r9) goto L_0x0065
            r9 = 80
            if (r7 != r9) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r7 = 0
            goto L_0x0066
        L_0x0065:
            r7 = 1
        L_0x0066:
            r9 = 3
            if (r8 == r9) goto L_0x006e
            r9 = 5
            if (r8 != r9) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r7 == 0) goto L_0x0075
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x007a
        L_0x0075:
            if (r4 == 0) goto L_0x007a
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x007c
        L_0x007a:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x007c:
            int r10 = r3.width
            r11 = -1
            r12 = -2
            if (r10 == r12) goto L_0x0089
            if (r10 == r11) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r10 = r15
        L_0x0086:
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x008a
        L_0x0089:
            r10 = r15
        L_0x008a:
            int r3 = r3.height
            if (r3 == r12) goto L_0x0093
            if (r3 == r11) goto L_0x0091
            goto L_0x0095
        L_0x0091:
            r3 = r14
            goto L_0x0095
        L_0x0093:
            r3 = r14
            r5 = r9
        L_0x0095:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r8)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r5)
            r6.measure(r8, r3)
            if (r7 == 0) goto L_0x00a8
            int r3 = r6.getMeasuredHeight()
            int r14 = r14 - r3
            goto L_0x00af
        L_0x00a8:
            if (r4 == 0) goto L_0x00af
            int r3 = r6.getMeasuredWidth()
            int r15 = r15 - r3
        L_0x00af:
            int r2 = r2 + 1
            goto L_0x0037
        L_0x00b2:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r5)
            r13.mChildWidthMeasureSpec = r15
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r5)
            r13.mChildHeightMeasureSpec = r15
            r13.mInLayout = r4
            r13.populate()
            r13.mInLayout = r0
            int r15 = r13.getChildCount()
        L_0x00c9:
            if (r0 >= r15) goto L_0x00f3
            android.view.View r1 = r13.getChildAt(r0)
            int r2 = r1.getVisibility()
            if (r2 == r3) goto L_0x00f0
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$LayoutParams r2 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.LayoutParams) r2
            if (r2 != 0) goto L_0x00e1
            boolean r4 = r2.isDecor
            if (r4 != 0) goto L_0x00f0
        L_0x00e1:
            float r4 = (float) r14
            float r2 = r2.heightFactor
            float r4 = r4 * r2
            int r2 = (int) r4
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r5)
            int r4 = r13.mChildWidthMeasureSpec
            r1.measure(r4, r2)
        L_0x00f0:
            int r0 = r0 + 1
            goto L_0x00c9
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.onMeasure(int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageScrolled(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.mDecorChildCount
            r1 = 0
            if (r0 <= 0) goto L_0x006e
            int r0 = r11.getScrollY()
            int r2 = r11.getPaddingTop()
            int r3 = r11.getPaddingBottom()
            int r4 = r11.getHeight()
            int r5 = r11.getChildCount()
            r6 = 0
        L_0x001a:
            if (r6 >= r5) goto L_0x006e
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$LayoutParams r8 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.LayoutParams) r8
            boolean r9 = r8.isDecor
            if (r9 != 0) goto L_0x002b
            goto L_0x006b
        L_0x002b:
            int r8 = r8.gravity
            r8 = r8 & 112(0x70, float:1.57E-43)
            r9 = 16
            if (r8 == r9) goto L_0x0050
            r9 = 48
            if (r8 == r9) goto L_0x004a
            r9 = 80
            if (r8 == r9) goto L_0x003d
            r8 = r2
            goto L_0x005f
        L_0x003d:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredHeight()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredHeight()
            int r3 = r3 + r9
            goto L_0x005c
        L_0x004a:
            int r8 = r7.getHeight()
            int r8 = r8 + r2
            goto L_0x005f
        L_0x0050:
            int r8 = r7.getMeasuredHeight()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
        L_0x005c:
            r10 = r8
            r8 = r2
            r2 = r10
        L_0x005f:
            int r2 = r2 + r0
            int r9 = r7.getTop()
            int r2 = r2 - r9
            if (r2 == 0) goto L_0x006a
            r7.offsetTopAndBottom(r2)
        L_0x006a:
            r2 = r8
        L_0x006b:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x006e:
            androidx.viewpager.widget.ViewPager$j r0 = r11.mOnPageChangeListener
            if (r0 == 0) goto L_0x0075
            r0.onPageScrolled(r12, r13, r14)
        L_0x0075:
            androidx.viewpager.widget.ViewPager$j r0 = r11.mInternalPageChangeListener
            if (r0 == 0) goto L_0x007c
            r0.onPageScrolled(r12, r13, r14)
        L_0x007c:
            androidx.viewpager.widget.ViewPager$k r12 = r11.mPageTransformer
            if (r12 == 0) goto L_0x00ad
            int r12 = r11.getScrollY()
            int r13 = r11.getChildCount()
        L_0x0088:
            if (r1 >= r13) goto L_0x00ad
            android.view.View r14 = r11.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r14.getLayoutParams()
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$LayoutParams r0 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.LayoutParams) r0
            boolean r0 = r0.isDecor
            if (r0 == 0) goto L_0x0099
            goto L_0x00aa
        L_0x0099:
            int r0 = r14.getTop()
            int r0 = r0 - r12
            float r0 = (float) r0
            int r2 = r11.getClientHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            androidx.viewpager.widget.ViewPager$k r2 = r11.mPageTransformer
            r2.transformPage(r14, r0)
        L_0x00aa:
            int r1 = r1 + 1
            goto L_0x0088
        L_0x00ad:
            r12 = 1
            r11.mCalledSuper = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.onPageScrolled(int, float, int):void");
    }

    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        ItemInfo infoForChild;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = childCount;
            i13 = 0;
            i11 = 1;
        } else {
            i13 = childCount - 1;
            i12 = -1;
            i11 = -1;
        }
        while (i13 != i12) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i13 += i11;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
            return;
        }
        this.mRestoredCurItem = savedState.position;
        this.mRestoredAdapterState = savedState.adapterState;
        this.mRestoredClassLoader = savedState.loader;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        a aVar = this.mAdapter;
        if (aVar != null) {
            savedState.adapterState = aVar.saveState();
        }
        return savedState;
    }

    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i11 != i13) {
            int i14 = this.mPageMargin;
            recomputeScrollPosition(i11, i13, i14, i14);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        boolean z10;
        boolean z11;
        float f10;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z12 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.mAdapter) == null || aVar.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.mIsBeingDragged) {
                        int a10 = u.a(motionEvent, this.mActivePointerId);
                        float f11 = u.f(motionEvent, a10);
                        float abs = Math.abs(f11 - this.mLastMotionY);
                        float e10 = u.e(motionEvent, a10);
                        float abs2 = Math.abs(e10 - this.mLastMotionX);
                        if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            float f12 = this.mInitialMotionY;
                            if (f11 - f12 > 0.0f) {
                                f10 = f12 + ((float) this.mTouchSlop);
                            } else {
                                f10 = f12 - ((float) this.mTouchSlop);
                            }
                            this.mLastMotionY = f10;
                            this.mLastMotionX = e10;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.mIsBeingDragged) {
                        z12 = false | performDrag(u.f(motionEvent, u.a(motionEvent, this.mActivePointerId)));
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int b10 = u.b(motionEvent);
                        this.mLastMotionY = u.f(motionEvent, b10);
                        this.mActivePointerId = u.d(motionEvent, b10);
                    } else if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                        this.mLastMotionY = u.f(motionEvent, u.a(motionEvent, this.mActivePointerId));
                    }
                } else if (this.mIsBeingDragged) {
                    scrollToItem(this.mCurItem, true, 0, false);
                    this.mActivePointerId = -1;
                    endDrag();
                    z10 = this.mTopEdge.f();
                    z11 = this.mBottomEdge.f();
                }
            } else if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int b11 = (int) h0.b(velocityTracker, this.mActivePointerId);
                this.mPopulatePending = true;
                int clientHeight = getClientHeight();
                int scrollY = getScrollY();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollY) / ((float) clientHeight)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.heightFactor, b11, (int) (u.f(motionEvent, u.a(motionEvent, this.mActivePointerId)) - this.mInitialMotionY)), true, true, b11);
                this.mActivePointerId = -1;
                endDrag();
                z10 = this.mTopEdge.f();
                z11 = this.mBottomEdge.f();
            }
            z12 = z10 | z11;
        } else {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x10 = motionEvent.getX();
            this.mInitialMotionX = x10;
            this.mLastMotionX = x10;
            float y10 = motionEvent.getY();
            this.mInitialMotionY = y10;
            this.mLastMotionY = y10;
            this.mActivePointerId = u.d(motionEvent, 0);
        }
        if (z12) {
            c1.b0(this);
        }
        return true;
    }

    public boolean pageDown() {
        a aVar = this.mAdapter;
        if (aVar == null || this.mCurItem >= aVar.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public boolean pageUp() {
        int i10 = this.mCurItem;
        if (i10 <= 0) {
            return false;
        }
        setCurrentItem(i10 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void populate() {
        populate(this.mCurItem);
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(a aVar) {
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i10 = 0; i10 < this.mItems.size(); i10++) {
                ItemInfo itemInfo = this.mItems.get(i10);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        this.mExpectedAdapterCount = 0;
        if (aVar != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z10 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z10) {
                populate();
            } else {
                requestLayout();
            }
        }
        OnAdapterChangeListener onAdapterChangeListener = this.mAdapterChangeListener;
        if (onAdapterChangeListener != null && aVar3 != aVar) {
            onAdapterChangeListener.onAdapterChanged(aVar3, aVar);
        }
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z10) {
        if (this.mSetChildrenDrawingOrderEnabled == null) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                this.mSetChildrenDrawingOrderEnabled = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException e10) {
                Log.e(TAG, "Can't find setChildrenDrawingOrderEnabled", e10);
            }
        }
        try {
            this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[]{Boolean.valueOf(z10)});
        } catch (Exception e11) {
            Log.e(TAG, "Error changing children drawing order", e11);
        }
    }

    public void setCurrentItem(int i10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, !this.mFirstLayout, false);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i10, boolean z10, boolean z11) {
        setCurrentItemInternal(i10, z10, z11, 0);
    }

    /* access modifiers changed from: package-private */
    public ViewPager.j setInternalPageChangeListener(ViewPager.j jVar) {
        ViewPager.j jVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = jVar;
        return jVar2;
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(i10);
            sb.append(" too small; defaulting to ");
            sb.append(1);
            i10 = 1;
        }
        if (i10 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i10;
            populate();
        }
    }

    public void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.mAdapterChangeListener = onAdapterChangeListener;
    }

    public void setOnPageChangeListener(ViewPager.j jVar) {
        this.mOnPageChangeListener = jVar;
    }

    public void setPageMargin(int i10) {
        int i11 = this.mPageMargin;
        this.mPageMargin = i10;
        int height = getHeight();
        recomputeScrollPosition(height, height, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z10, ViewPager.k kVar) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i10 = 1;
        if (kVar != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.mPageTransformer != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 != z12) {
            z13 = true;
        } else {
            z13 = false;
        }
        this.mPageTransformer = kVar;
        setChildrenDrawingOrderEnabledCompat(z11);
        if (z11) {
            if (z10) {
                i10 = 2;
            }
            this.mDrawingOrder = i10;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z13) {
            populate();
        }
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i10, int i11) {
        smoothScrollTo(i10, i11, 0);
    }

    public boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) {
            return true;
        }
        return false;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        float heightFactor = 0.0f;
        public boolean isDecor;
        boolean needsMeasure;
        int position;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r10 == r11) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populate(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.mCurItem
            if (r2 == r1) goto L_0x0016
            if (r2 >= r1) goto L_0x000d
            r4 = 130(0x82, float:1.82E-43)
            goto L_0x000f
        L_0x000d:
            r4 = 33
        L_0x000f:
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r2 = r0.infoForPosition(r2)
            r0.mCurItem = r1
            goto L_0x0018
        L_0x0016:
            r4 = 2
            r2 = 0
        L_0x0018:
            androidx.viewpager.widget.a r1 = r0.mAdapter
            if (r1 != 0) goto L_0x0020
            r17.sortChildDrawingOrder()
            return
        L_0x0020:
            boolean r1 = r0.mPopulatePending
            if (r1 == 0) goto L_0x0028
            r17.sortChildDrawingOrder()
            return
        L_0x0028:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x002f
            return
        L_0x002f:
            androidx.viewpager.widget.a r1 = r0.mAdapter
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.mOffscreenPageLimit
            int r5 = r0.mCurItem
            int r5 = r5 - r1
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            androidx.viewpager.widget.a r7 = r0.mAdapter
            int r7 = r7.getCount()
            int r8 = r7 + -1
            int r9 = r0.mCurItem
            int r9 = r9 + r1
            int r1 = java.lang.Math.min(r8, r9)
            int r8 = r0.mExpectedAdapterCount
            if (r7 != r8) goto L_0x021a
            r8 = 0
        L_0x0052:
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r9 = r0.mItems
            int r9 = r9.size()
            if (r8 >= r9) goto L_0x006e
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r9 = r0.mItems
            java.lang.Object r9 = r9.get(r8)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r9 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r9
            int r10 = r9.position
            int r11 = r0.mCurItem
            if (r10 < r11) goto L_0x006b
            if (r10 != r11) goto L_0x006e
            goto L_0x006f
        L_0x006b:
            int r8 = r8 + 1
            goto L_0x0052
        L_0x006e:
            r9 = 0
        L_0x006f:
            if (r9 != 0) goto L_0x0079
            if (r7 <= 0) goto L_0x0079
            int r9 = r0.mCurItem
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r9 = r0.addNewItem(r9, r8)
        L_0x0079:
            if (r9 == 0) goto L_0x0198
            int r11 = r8 + -1
            if (r11 < 0) goto L_0x0088
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r12 = r0.mItems
            java.lang.Object r12 = r12.get(r11)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r12 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r12
            goto L_0x0089
        L_0x0088:
            r12 = 0
        L_0x0089:
            int r13 = r17.getClientHeight()
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 > 0) goto L_0x0093
            r15 = 0
            goto L_0x009f
        L_0x0093:
            float r15 = r9.heightFactor
            float r15 = r14 - r15
            int r3 = r17.getPaddingLeft()
            float r3 = (float) r3
            float r6 = (float) r13
            float r3 = r3 / r6
            float r15 = r15 + r3
        L_0x009f:
            int r3 = r0.mCurItem
            int r3 = r3 + -1
            r6 = 0
        L_0x00a4:
            if (r3 < 0) goto L_0x0103
            int r16 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r16 < 0) goto L_0x00d2
            if (r3 >= r5) goto L_0x00d2
            if (r12 != 0) goto L_0x00af
            goto L_0x0103
        L_0x00af:
            int r10 = r12.position
            if (r3 != r10) goto L_0x0100
            boolean r10 = r12.scrolling
            if (r10 != 0) goto L_0x0100
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r10 = r0.mItems
            r10.remove(r11)
            androidx.viewpager.widget.a r10 = r0.mAdapter
            java.lang.Object r12 = r12.object
            r10.destroyItem((android.view.ViewGroup) r0, (int) r3, (java.lang.Object) r12)
            int r11 = r11 + -1
            int r8 = r8 + -1
            if (r11 < 0) goto L_0x00fe
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r10 = r0.mItems
            java.lang.Object r10 = r10.get(r11)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r10 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r10
            goto L_0x00ff
        L_0x00d2:
            if (r12 == 0) goto L_0x00e8
            int r10 = r12.position
            if (r3 != r10) goto L_0x00e8
            float r10 = r12.heightFactor
            float r6 = r6 + r10
            int r11 = r11 + -1
            if (r11 < 0) goto L_0x00fe
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r10 = r0.mItems
            java.lang.Object r10 = r10.get(r11)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r10 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r10
            goto L_0x00ff
        L_0x00e8:
            int r10 = r11 + 1
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r10 = r0.addNewItem(r3, r10)
            float r10 = r10.heightFactor
            float r6 = r6 + r10
            int r8 = r8 + 1
            if (r11 < 0) goto L_0x00fe
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r10 = r0.mItems
            java.lang.Object r10 = r10.get(r11)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r10 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r10
            goto L_0x00ff
        L_0x00fe:
            r10 = 0
        L_0x00ff:
            r12 = r10
        L_0x0100:
            int r3 = r3 + -1
            goto L_0x00a4
        L_0x0103:
            float r3 = r9.heightFactor
            int r5 = r8 + 1
            int r6 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x0195
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r6 = r0.mItems
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x011c
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r6 = r0.mItems
            java.lang.Object r6 = r6.get(r5)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r6 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r6
            goto L_0x011d
        L_0x011c:
            r6 = 0
        L_0x011d:
            if (r13 > 0) goto L_0x0121
            r10 = 0
            goto L_0x0129
        L_0x0121:
            int r10 = r17.getPaddingRight()
            float r10 = (float) r10
            float r11 = (float) r13
            float r10 = r10 / r11
            float r10 = r10 + r14
        L_0x0129:
            int r11 = r0.mCurItem
        L_0x012b:
            int r11 = r11 + 1
            if (r11 >= r7) goto L_0x0195
            int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x015f
            if (r11 <= r1) goto L_0x015f
            if (r6 != 0) goto L_0x0138
            goto L_0x0195
        L_0x0138:
            int r12 = r6.position
            if (r11 != r12) goto L_0x0194
            boolean r12 = r6.scrolling
            if (r12 != 0) goto L_0x0194
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r12 = r0.mItems
            r12.remove(r5)
            androidx.viewpager.widget.a r12 = r0.mAdapter
            java.lang.Object r6 = r6.object
            r12.destroyItem((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r6)
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r6 = r0.mItems
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x015d
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r6 = r0.mItems
            java.lang.Object r6 = r6.get(r5)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r6 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r6
            goto L_0x0194
        L_0x015d:
            r6 = 0
            goto L_0x0194
        L_0x015f:
            if (r6 == 0) goto L_0x017b
            int r12 = r6.position
            if (r11 != r12) goto L_0x017b
            float r6 = r6.heightFactor
            float r3 = r3 + r6
            int r5 = r5 + 1
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r6 = r0.mItems
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x015d
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r6 = r0.mItems
            java.lang.Object r6 = r6.get(r5)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r6 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r6
            goto L_0x0194
        L_0x017b:
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r6 = r0.addNewItem(r11, r5)
            int r5 = r5 + 1
            float r6 = r6.heightFactor
            float r3 = r3 + r6
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r6 = r0.mItems
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x015d
            java.util.ArrayList<com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo> r6 = r0.mItems
            java.lang.Object r6 = r6.get(r5)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r6 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.ItemInfo) r6
        L_0x0194:
            goto L_0x012b
        L_0x0195:
            r0.calculatePageOffsets(r9, r8, r2)
        L_0x0198:
            androidx.viewpager.widget.a r1 = r0.mAdapter
            int r2 = r0.mCurItem
            if (r9 == 0) goto L_0x01a1
            java.lang.Object r3 = r9.object
            goto L_0x01a2
        L_0x01a1:
            r3 = 0
        L_0x01a2:
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
            androidx.viewpager.widget.a r1 = r0.mAdapter
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x01af:
            if (r2 >= r1) goto L_0x01db
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$LayoutParams r5 = (com.mobile.brasiltv.view.shortvideo.VerticalViewPager.LayoutParams) r5
            r5.childIndex = r2
            boolean r6 = r5.isDecor
            if (r6 != 0) goto L_0x01d7
            float r6 = r5.heightFactor
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x01d8
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r3 = r0.infoForChild(r3)
            if (r3 == 0) goto L_0x01d8
            float r6 = r3.heightFactor
            r5.heightFactor = r6
            int r3 = r3.position
            r5.position = r3
            goto L_0x01d8
        L_0x01d7:
            r7 = 0
        L_0x01d8:
            int r2 = r2 + 1
            goto L_0x01af
        L_0x01db:
            r17.sortChildDrawingOrder()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x0219
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01ef
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r3 = r0.infoForAnyChild(r1)
            goto L_0x01f0
        L_0x01ef:
            r3 = 0
        L_0x01f0:
            if (r3 == 0) goto L_0x01f8
            int r1 = r3.position
            int r2 = r0.mCurItem
            if (r1 == r2) goto L_0x0219
        L_0x01f8:
            r6 = 0
        L_0x01f9:
            int r1 = r17.getChildCount()
            if (r6 >= r1) goto L_0x0219
            android.view.View r1 = r0.getChildAt(r6)
            com.mobile.brasiltv.view.shortvideo.VerticalViewPager$ItemInfo r2 = r0.infoForChild(r1)
            if (r2 == 0) goto L_0x0216
            int r2 = r2.position
            int r3 = r0.mCurItem
            if (r2 != r3) goto L_0x0216
            boolean r1 = r1.requestFocus(r4)
            if (r1 == 0) goto L_0x0216
            goto L_0x0219
        L_0x0216:
            int r6 = r6 + 1
            goto L_0x01f9
        L_0x0219:
            return
        L_0x021a:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x0227 }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x0227 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0227 }
            goto L_0x022f
        L_0x0227:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x022f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.mExpectedAdapterCount
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.a r1 = r0.mAdapter
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            goto L_0x0273
        L_0x0272:
            throw r2
        L_0x0273:
            goto L_0x0272
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.populate(int):void");
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i10, boolean z10, boolean z11, int i11) {
        ViewPager.j jVar;
        ViewPager.j jVar2;
        a aVar = this.mAdapter;
        boolean z12 = false;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z11 || this.mCurItem != i10 || this.mItems.size() == 0) {
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 >= this.mAdapter.getCount()) {
                i10 = this.mAdapter.getCount() - 1;
            }
            int i12 = this.mOffscreenPageLimit;
            int i13 = this.mCurItem;
            if (i10 > i13 + i12 || i10 < i13 - i12) {
                for (int i14 = 0; i14 < this.mItems.size(); i14++) {
                    this.mItems.get(i14).scrolling = true;
                }
            }
            if (this.mCurItem != i10) {
                z12 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i10;
                if (z12 && (jVar2 = this.mOnPageChangeListener) != null) {
                    jVar2.onPageSelected(i10);
                }
                if (z12 && (jVar = this.mInternalPageChangeListener) != null) {
                    jVar.onPageSelected(i10);
                }
                requestLayout();
                return;
            }
            populate(i10);
            scrollToItem(i10, z10, i11, z12);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i10, int i11, int i12) {
        int i13;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i14 = i10 - scrollX;
        int i15 = i11 - scrollY;
        if (i14 == 0 && i15 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i16 = clientHeight / 2;
        float f10 = (float) clientHeight;
        float f11 = (float) i16;
        float distanceInfluenceForSnapDuration = f11 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i14)) * 1.0f) / f10)) * f11);
        int abs = Math.abs(i12);
        if (abs > 0) {
            i13 = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4;
        } else {
            i13 = (int) (((((float) Math.abs(i14)) / ((f10 * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f);
        }
        this.mScroller.startScroll(scrollX, scrollY, i14, i15, Math.min(i13, 600));
        c1.b0(this);
    }

    public void setCurrentItem(int i10, boolean z10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, z10, false);
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i10));
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }
}
