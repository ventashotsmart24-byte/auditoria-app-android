package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.c;
import b0.c1;
import c0.g0;
import c0.l0;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.uc.crashsdk.export.LogType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import v.a;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;
    private final ArrayList<BottomSheetCallback> callbacks = new ArrayList<>();
    int collapsedOffset;
    private final c.C0027c dragCallback = new c.C0027c() {
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(View view, int i10, int i11) {
            int i12;
            int access$300 = BottomSheetBehavior.this.getExpandedOffset();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                i12 = bottomSheetBehavior.parentHeight;
            } else {
                i12 = bottomSheetBehavior.collapsedOffset;
            }
            return a.b(i10, access$300, i12);
        }

        public int getViewVerticalDragRange(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                return bottomSheetBehavior.parentHeight;
            }
            return bottomSheetBehavior.collapsedOffset;
        }

        public void onViewDragStateChanged(int i10) {
            if (i10 == 1) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.dispatchOnSlide(i11);
        }

        public void onViewReleased(View view, float f10, float f11) {
            int i10;
            int i11;
            int i12 = 6;
            if (f11 >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.hideable || !bottomSheetBehavior.shouldHide(view, f11) || (view.getTop() <= BottomSheetBehavior.this.collapsedOffset && Math.abs(f10) >= Math.abs(f11))) {
                    if (f11 == 0.0f || Math.abs(f10) > Math.abs(f11)) {
                        int top = view.getTop();
                        if (!BottomSheetBehavior.this.fitToContents) {
                            BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                            int i13 = bottomSheetBehavior2.halfExpandedOffset;
                            if (top < i13) {
                                if (top < Math.abs(top - bottomSheetBehavior2.collapsedOffset)) {
                                    i10 = BottomSheetBehavior.this.expandedOffset;
                                } else {
                                    i10 = BottomSheetBehavior.this.halfExpandedOffset;
                                }
                            } else if (Math.abs(top - i13) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                                i10 = BottomSheetBehavior.this.halfExpandedOffset;
                            } else {
                                i11 = BottomSheetBehavior.this.collapsedOffset;
                            }
                            BottomSheetBehavior.this.startSettlingAnimation(view, i12, i10, true);
                        } else if (Math.abs(top - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i10 = BottomSheetBehavior.this.fitToContentsOffset;
                        } else {
                            i11 = BottomSheetBehavior.this.collapsedOffset;
                        }
                    } else if (BottomSheetBehavior.this.fitToContents) {
                        i11 = BottomSheetBehavior.this.collapsedOffset;
                    } else {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                            i10 = BottomSheetBehavior.this.halfExpandedOffset;
                            BottomSheetBehavior.this.startSettlingAnimation(view, i12, i10, true);
                        }
                        i11 = BottomSheetBehavior.this.collapsedOffset;
                    }
                    i12 = 4;
                    BottomSheetBehavior.this.startSettlingAnimation(view, i12, i10, true);
                }
                i10 = BottomSheetBehavior.this.parentHeight;
                i12 = 5;
                BottomSheetBehavior.this.startSettlingAnimation(view, i12, i10, true);
            } else if (BottomSheetBehavior.this.fitToContents) {
                i10 = BottomSheetBehavior.this.fitToContentsOffset;
            } else {
                int top3 = view.getTop();
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                int i14 = bottomSheetBehavior3.halfExpandedOffset;
                if (top3 > i14) {
                    i10 = i14;
                    BottomSheetBehavior.this.startSettlingAnimation(view, i12, i10, true);
                }
                i10 = bottomSheetBehavior3.expandedOffset;
            }
            i12 = 3;
            BottomSheetBehavior.this.startSettlingAnimation(view, i12, i10, true);
        }

        public boolean tryCaptureView(View view, int i10) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.state;
            if (i11 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.activePointerId == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    };
    float elevation = -1.0f;
    int expandedOffset;
    /* access modifiers changed from: private */
    public boolean fitToContents = true;
    int fitToContentsOffset;
    int halfExpandedOffset;
    float halfExpandedRatio = 0.5f;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    /* access modifiers changed from: private */
    public MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    /* access modifiers changed from: private */
    public int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int saveFlags = 0;
    private BottomSheetBehavior<V>.SettleRunnable settleRunnable = null;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    /* access modifiers changed from: private */
    public boolean skipCollapsed;
    int state = 4;
    boolean touchingScrollingChild;
    private VelocityTracker velocityTracker;
    c viewDragHelper;
    WeakReference<V> viewRef;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f10);

        public abstract void onStateChanged(View view, int i10);
    }

    public static class SavedState extends f0.a {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z10 = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z10;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i10) {
            super(parcelable);
            this.state = i10;
        }
    }

    public class SettleRunnable implements Runnable {
        /* access modifiers changed from: private */
        public boolean isPosted;
        int targetState;
        private final View view;

        public SettleRunnable(View view2, int i10) {
            this.view = view2;
            this.targetState = i10;
        }

        public void run() {
            c cVar = BottomSheetBehavior.this.viewDragHelper;
            if (cVar == null || !cVar.k(true)) {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            } else {
                c1.c0(this.view, this);
            }
            this.isPosted = false;
        }
    }

    public BottomSheetBehavior() {
    }

    private void addAccessibilityActionForState(V v10, g0.a aVar, final int i10) {
        c1.g0(v10, aVar, (CharSequence) null, new l0() {
            public boolean perform(View view, l0.a aVar) {
                BottomSheetBehavior.this.setState(i10);
                return true;
            }
        });
    }

    private void calculateCollapsedOffset() {
        int i10;
        if (this.peekHeightAuto) {
            i10 = Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16));
        } else {
            i10 = this.peekHeight;
        }
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - i10, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - i10;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (((float) this.parentHeight) * (1.0f - this.halfExpandedRatio));
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z10) {
        createMaterialShapeDrawable(context, attributeSet, z10, (ColorStateList) null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) layoutParams).f();
            if (f10 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f10;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* access modifiers changed from: private */
    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return this.expandedOffset;
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            return 0.0f;
        }
        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int i10 = this.saveFlags;
        if (i10 != 0) {
            if (i10 == -1 || (i10 & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            if (i10 == -1 || (i10 & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            if (i10 == -1 || (i10 & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            if (i10 == -1 || (i10 & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
    }

    private void settleToStatePendingLayout(final int i10) {
        final View view = (View) this.viewRef.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !c1.P(view)) {
                settleToState(view, i10);
            } else {
                view.post(new Runnable() {
                    public void run() {
                        BottomSheetBehavior.this.settleToState(view, i10);
                    }
                });
            }
        }
    }

    private void updateAccessibilityActions() {
        View view;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            c1.e0(view, 524288);
            c1.e0(view, 262144);
            c1.e0(view, LogType.ANR);
            if (this.hideable && this.state != 5) {
                addAccessibilityActionForState(view, g0.a.f4564y, 5);
            }
            int i10 = this.state;
            int i11 = 6;
            if (i10 == 3) {
                if (this.fitToContents) {
                    i11 = 4;
                }
                addAccessibilityActionForState(view, g0.a.f4563x, i11);
            } else if (i10 == 4) {
                if (this.fitToContents) {
                    i11 = 3;
                }
                addAccessibilityActionForState(view, g0.a.f4562w, i11);
            } else if (i10 == 6) {
                addAccessibilityActionForState(view, g0.a.f4563x, 4);
                addAccessibilityActionForState(view, g0.a.f4562w, 3);
            }
        }
    }

    private void updateDrawableForTargetState(int i10) {
        boolean z10;
        ValueAnimator valueAnimator;
        float f10;
        if (i10 != 2) {
            if (i10 == 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.isShapeExpanded != z10) {
                this.isShapeExpanded = z10;
                if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                    if (valueAnimator.isRunning()) {
                        this.interpolatorAnimator.reverse();
                        return;
                    }
                    if (z10) {
                        f10 = 0.0f;
                    } else {
                        f10 = 1.0f;
                    }
                    this.interpolatorAnimator.setFloatValues(new float[]{1.0f - f10, f10});
                    this.interpolatorAnimator.start();
                }
            }
        }
    }

    private void updateImportantForAccessibility(boolean z10) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z10) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i10 = 0; i10 < childCount; i10++) {
                    V childAt = coordinatorLayout.getChildAt(i10);
                    if (childAt != this.viewRef.get()) {
                        if (!z10) {
                            Map<View, Integer> map = this.importantForAccessibilityMap;
                            if (map != null && map.containsKey(childAt)) {
                                c1.v0(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                            }
                        } else {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            c1.v0(childAt, 4);
                        }
                    }
                }
                if (!z10) {
                    this.importantForAccessibilityMap = null;
                }
            }
        }
    }

    public void addBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        if (!this.callbacks.contains(bottomSheetCallback)) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int i10) {
        float f10;
        float f11;
        View view = (View) this.viewRef.get();
        if (view != null && !this.callbacks.isEmpty()) {
            int i11 = this.collapsedOffset;
            if (i10 > i11) {
                f10 = (float) (i11 - i10);
                f11 = (float) (this.parentHeight - i11);
            } else {
                f10 = (float) (i11 - i10);
                f11 = (float) (i11 - getExpandedOffset());
            }
            float f12 = f10 / f11;
            for (int i12 = 0; i12 < this.callbacks.size(); i12++) {
                this.callbacks.get(i12).onSlide(view, f12);
            }
        }
    }

    public View findScrollingChild(View view) {
        if (c1.R(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i10));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        c cVar;
        boolean z10;
        View view;
        if (!v10.isShown()) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        View view2 = null;
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                if (weakReference != null) {
                    view = weakReference.get();
                } else {
                    view = null;
                }
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x10, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            if (this.activePointerId != -1 || coordinatorLayout.isPointInChildBounds(v10, x10, this.initialY)) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.ignoreEvents = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (cVar = this.viewDragHelper) != null && cVar.H(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.u())) {
            return false;
        }
        return true;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        boolean z10;
        float f10;
        MaterialShapeDrawable materialShapeDrawable2;
        if (c1.w(coordinatorLayout) && !c1.w(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            this.viewRef = new WeakReference<>(v10);
            if (this.shapeThemingEnabled && (materialShapeDrawable2 = this.materialShapeDrawable) != null) {
                c1.o0(v10, materialShapeDrawable2);
            }
            MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
            if (materialShapeDrawable3 != null) {
                float f11 = this.elevation;
                if (f11 == -1.0f) {
                    f11 = c1.u(v10);
                }
                materialShapeDrawable3.setElevation(f11);
                if (this.state == 3) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.isShapeExpanded = z10;
                MaterialShapeDrawable materialShapeDrawable4 = this.materialShapeDrawable;
                if (z10) {
                    f10 = 0.0f;
                } else {
                    f10 = 1.0f;
                }
                materialShapeDrawable4.setInterpolation(f10);
            }
            updateAccessibilityActions();
            if (c1.x(v10) == 0) {
                c1.v0(v10, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = c.m(coordinatorLayout, this.dragCallback);
        }
        int top = v10.getTop();
        coordinatorLayout.onLayoutChild(v10, i10);
        this.parentWidth = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.parentHeight = height;
        this.fitToContentsOffset = Math.max(0, height - v10.getHeight());
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i11 = this.state;
        if (i11 == 3) {
            c1.W(v10, getExpandedOffset());
        } else if (i11 == 6) {
            c1.W(v10, this.halfExpandedOffset);
        } else if (this.hideable && i11 == 5) {
            c1.W(v10, this.parentHeight);
        } else if (i11 == 4) {
            c1.W(v10, this.collapsedOffset);
        } else if (i11 == 1 || i11 == 2) {
            c1.W(v10, top - v10.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v10));
        return true;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.state != 3 || super.onNestedPreFling(coordinatorLayout, v10, view, f10, f11)) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
        View view2;
        if (i12 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference != null) {
                view2 = weakReference.get();
            } else {
                view2 = null;
            }
            if (view == view2) {
                int top = v10.getTop();
                int i13 = top - i11;
                if (i11 > 0) {
                    if (i13 < getExpandedOffset()) {
                        int expandedOffset2 = top - getExpandedOffset();
                        iArr[1] = expandedOffset2;
                        c1.W(v10, -expandedOffset2);
                        setStateInternal(3);
                    } else {
                        iArr[1] = i11;
                        c1.W(v10, -i11);
                        setStateInternal(1);
                    }
                } else if (i11 < 0 && !view.canScrollVertically(-1)) {
                    int i14 = this.collapsedOffset;
                    if (i13 <= i14 || this.hideable) {
                        iArr[1] = i11;
                        c1.W(v10, -i11);
                        setStateInternal(1);
                    } else {
                        int i15 = top - i14;
                        iArr[1] = i15;
                        c1.W(v10, -i15);
                        setStateInternal(4);
                    }
                }
                dispatchOnSlide(v10.getTop());
                this.lastNestedScrollDy = i11;
                this.nestedScrolled = true;
            }
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v10, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i10 = savedState.state;
        if (i10 == 1 || i10 == 2) {
            this.state = 4;
        } else {
            this.state = i10;
        }
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i10 & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10) {
        int i11;
        int i12;
        int i13 = 3;
        if (v10.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                i11 = getExpandedOffset();
            } else if (!this.hideable || !shouldHide(v10, getYVelocity())) {
                if (this.lastNestedScrollDy == 0) {
                    int top = v10.getTop();
                    if (!this.fitToContents) {
                        int i14 = this.halfExpandedOffset;
                        if (top < i14) {
                            if (top < Math.abs(top - this.collapsedOffset)) {
                                i11 = this.expandedOffset;
                            } else {
                                i11 = this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top - i14) < Math.abs(top - this.collapsedOffset)) {
                            i11 = this.halfExpandedOffset;
                        } else {
                            i12 = this.collapsedOffset;
                        }
                        i13 = 6;
                    } else if (Math.abs(top - this.fitToContentsOffset) < Math.abs(top - this.collapsedOffset)) {
                        i11 = this.fitToContentsOffset;
                    } else {
                        i12 = this.collapsedOffset;
                    }
                } else if (this.fitToContents) {
                    i12 = this.collapsedOffset;
                } else {
                    int top2 = v10.getTop();
                    if (Math.abs(top2 - this.halfExpandedOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i11 = this.halfExpandedOffset;
                        i13 = 6;
                    } else {
                        i12 = this.collapsedOffset;
                    }
                }
                i13 = 4;
            } else {
                i11 = this.parentHeight;
                i13 = 5;
            }
            startSettlingAnimation(v10, i13, i11, false);
            this.nestedScrolled = false;
        }
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        c cVar = this.viewDragHelper;
        if (cVar != null) {
            cVar.A(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.u())) {
            this.viewDragHelper.b(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void setExpandedOffset(int i10) {
        if (i10 >= 0) {
            this.expandedOffset = i10;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z10) {
        int i10;
        if (this.fitToContents != z10) {
            this.fitToContents = z10;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            if (!this.fitToContents || this.state != 6) {
                i10 = this.state;
            } else {
                i10 = 3;
            }
            setStateInternal(i10);
            updateAccessibilityActions();
        }
    }

    public void setHalfExpandedRatio(float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f10;
    }

    public void setHideable(boolean z10) {
        if (this.hideable != z10) {
            this.hideable = z10;
            if (!z10 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setPeekHeight(int i10) {
        setPeekHeight(i10, false);
    }

    public void setSaveFlags(int i10) {
        this.saveFlags = i10;
    }

    public void setSkipCollapsed(boolean z10) {
        this.skipCollapsed = z10;
    }

    public void setState(int i10) {
        if (i10 != this.state) {
            if (this.viewRef != null) {
                settleToStatePendingLayout(i10);
            } else if (i10 == 4 || i10 == 3 || i10 == 6 || (this.hideable && i10 == 5)) {
                this.state = i10;
            }
        }
    }

    public void setStateInternal(int i10) {
        View view;
        if (this.state != i10) {
            this.state = i10;
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i10 == 6 || i10 == 3) {
                    updateImportantForAccessibility(true);
                } else if (i10 == 5 || i10 == 4) {
                    updateImportantForAccessibility(false);
                }
                updateDrawableForTargetState(i10);
                for (int i11 = 0; i11 < this.callbacks.size(); i11++) {
                    this.callbacks.get(i11).onStateChanged(view, i10);
                }
                updateAccessibilityActions();
            }
        }
    }

    public void settleToState(View view, int i10) {
        int i11;
        int i12;
        if (i10 == 4) {
            i11 = this.collapsedOffset;
        } else if (i10 == 6) {
            i11 = this.halfExpandedOffset;
            if (this.fitToContents && i11 <= (i12 = this.fitToContentsOffset)) {
                i11 = i12;
                i10 = 3;
            }
        } else if (i10 == 3) {
            i11 = getExpandedOffset();
        } else if (!this.hideable || i10 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i10);
        } else {
            i11 = this.parentHeight;
        }
        startSettlingAnimation(view, i10, i11, false);
    }

    public boolean shouldHide(View view, float f10) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() >= this.collapsedOffset && Math.abs((((float) view.getTop()) + (f10 * 0.1f)) - ((float) this.collapsedOffset)) / ((float) this.peekHeight) > 0.5f) {
            return true;
        }
        return false;
    }

    public void startSettlingAnimation(View view, int i10, int i11, boolean z10) {
        boolean z11;
        if (z10) {
            z11 = this.viewDragHelper.G(view.getLeft(), i11);
        } else {
            z11 = this.viewDragHelper.I(view, view.getLeft(), i11);
        }
        if (z11) {
            setStateInternal(2);
            updateDrawableForTargetState(i10);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable(view, i10);
            }
            if (!this.settleRunnable.isPosted) {
                BottomSheetBehavior<V>.SettleRunnable settleRunnable2 = this.settleRunnable;
                settleRunnable2.targetState = i10;
                c1.c0(view, settleRunnable2);
                boolean unused = this.settleRunnable.isPosted = true;
                return;
            }
            this.settleRunnable.targetState = i10;
            return;
        }
        setStateInternal(i10);
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z10, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable2;
            materialShapeDrawable2.initializeElevationOverlay(context);
            if (!z10 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
                return;
            }
            this.materialShapeDrawable.setFillColor(colorStateList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPeekHeight(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = -1
            r1 = 1
            r2 = 0
            if (r4 != r0) goto L_0x000c
            boolean r4 = r3.peekHeightAuto
            if (r4 != 0) goto L_0x0015
            r3.peekHeightAuto = r1
            goto L_0x001f
        L_0x000c:
            boolean r0 = r3.peekHeightAuto
            if (r0 != 0) goto L_0x0017
            int r0 = r3.peekHeight
            if (r0 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r1 = 0
            goto L_0x001f
        L_0x0017:
            r3.peekHeightAuto = r2
            int r4 = java.lang.Math.max(r2, r4)
            r3.peekHeight = r4
        L_0x001f:
            if (r1 == 0) goto L_0x0042
            java.lang.ref.WeakReference<V> r4 = r3.viewRef
            if (r4 == 0) goto L_0x0042
            r3.calculateCollapsedOffset()
            int r4 = r3.state
            r0 = 4
            if (r4 != r0) goto L_0x0042
            java.lang.ref.WeakReference<V> r4 = r3.viewRef
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x0042
            if (r5 == 0) goto L_0x003f
            int r4 = r3.state
            r3.settleToStatePendingLayout(r4)
            goto L_0x0042
        L_0x003f:
            r4.requestLayout()
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int, boolean):void");
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i11 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i11);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, i11));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT >= 21) {
            this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        int i12 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i12);
        if (peekValue == null || (i10 = peekValue.data) != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i12, -1));
        } else {
            setPeekHeight(i10);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        setExpandedOffset(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
