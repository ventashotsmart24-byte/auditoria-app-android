package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.c;
import b0.c1;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance = 0.5f;
    float alphaStartSwipeDistance = 0.0f;
    private final c.C0027c dragCallback = new c.C0027c() {
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0025 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0034 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean shouldDismiss(android.view.View r6, float r7) {
            /*
                r5 = this;
                r0 = 0
                r1 = 1
                r2 = 0
                int r3 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x0036
                int r6 = b0.c1.z(r6)
                if (r6 != r1) goto L_0x000f
                r6 = 1
                goto L_0x0010
            L_0x000f:
                r6 = 0
            L_0x0010:
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r3 = r3.swipeDirection
                r4 = 2
                if (r3 != r4) goto L_0x0018
                return r1
            L_0x0018:
                if (r3 != 0) goto L_0x0027
                if (r6 == 0) goto L_0x0021
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 >= 0) goto L_0x0026
                goto L_0x0025
            L_0x0021:
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 <= 0) goto L_0x0026
            L_0x0025:
                r0 = 1
            L_0x0026:
                return r0
            L_0x0027:
                if (r3 != r1) goto L_0x0035
                if (r6 == 0) goto L_0x0030
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 <= 0) goto L_0x0035
                goto L_0x0034
            L_0x0030:
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 >= 0) goto L_0x0035
            L_0x0034:
                r0 = 1
            L_0x0035:
                return r0
            L_0x0036:
                int r7 = r6.getLeft()
                int r2 = r5.originalCapturedViewLeft
                int r7 = r7 - r2
                int r6 = r6.getWidth()
                float r6 = (float) r6
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r2 = r2.dragDismissThreshold
                float r6 = r6 * r2
                int r6 = java.lang.Math.round(r6)
                int r7 = java.lang.Math.abs(r7)
                if (r7 < r6) goto L_0x0053
                r0 = 1
            L_0x0053:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.shouldDismiss(android.view.View, float):boolean");
        }

        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            boolean z10;
            int i12;
            int i13;
            int width;
            if (c1.z(view) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i14 = SwipeDismissBehavior.this.swipeDirection;
            if (i14 != 0) {
                if (i14 != 1) {
                    i12 = this.originalCapturedViewLeft - view.getWidth();
                    i13 = view.getWidth() + this.originalCapturedViewLeft;
                } else if (z10) {
                    i12 = this.originalCapturedViewLeft;
                    width = view.getWidth();
                } else {
                    i12 = this.originalCapturedViewLeft - view.getWidth();
                    i13 = this.originalCapturedViewLeft;
                }
                return SwipeDismissBehavior.clamp(i12, i10, i13);
            } else if (z10) {
                i12 = this.originalCapturedViewLeft - view.getWidth();
                i13 = this.originalCapturedViewLeft;
                return SwipeDismissBehavior.clamp(i12, i10, i13);
            } else {
                i12 = this.originalCapturedViewLeft;
                width = view.getWidth();
            }
            i13 = width + i12;
            return SwipeDismissBehavior.clamp(i12, i10, i13);
        }

        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        public void onViewCaptured(View view, int i10) {
            this.activePointerId = i10;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void onViewDragStateChanged(int i10) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i10);
            }
        }

        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            float width = ((float) this.originalCapturedViewLeft) + (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaStartSwipeDistance);
            float width2 = ((float) this.originalCapturedViewLeft) + (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaEndSwipeDistance);
            float f10 = (float) i10;
            if (f10 <= width) {
                view.setAlpha(1.0f);
            } else if (f10 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(width, width2, f10), 1.0f));
            }
        }

        public void onViewReleased(View view, float f10, float f11) {
            boolean z10;
            int i10;
            OnDismissListener onDismissListener;
            this.activePointerId = -1;
            int width = view.getWidth();
            if (shouldDismiss(view, f10)) {
                int left = view.getLeft();
                int i11 = this.originalCapturedViewLeft;
                if (left < i11) {
                    i10 = i11 - width;
                } else {
                    i10 = i11 + width;
                }
                z10 = true;
            } else {
                i10 = this.originalCapturedViewLeft;
                z10 = false;
            }
            if (SwipeDismissBehavior.this.viewDragHelper.G(i10, view.getTop())) {
                c1.c0(view, new SettleRunnable(view, z10));
            } else if (z10 && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(view);
            }
        }

        public boolean tryCaptureView(View view, int i10) {
            int i11 = this.activePointerId;
            if ((i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return true;
            }
            return false;
        }
    };
    float dragDismissThreshold = 0.5f;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private float sensitivity = 0.0f;
    private boolean sensitivitySet;
    int swipeDirection = 2;
    c viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i10);
    }

    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        public SettleRunnable(View view2, boolean z10) {
            this.view = view2;
            this.dismiss = z10;
        }

        public void run() {
            OnDismissListener onDismissListener;
            c cVar = SwipeDismissBehavior.this.viewDragHelper;
            if (cVar != null && cVar.k(true)) {
                c1.c0(this.view, this);
            } else if (this.dismiss && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(this.view);
            }
        }
    }

    public static float clamp(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        c cVar;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                cVar = c.l(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                cVar = c.m(viewGroup, this.dragCallback);
            }
            this.viewDragHelper = cVar;
        }
    }

    public static float fraction(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    public int getDragState() {
        c cVar = this.viewDragHelper;
        if (cVar != null) {
            return cVar.v();
        }
        return 0;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10 = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z10 = coordinatorLayout.isPointInChildBounds(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!z10) {
            return false;
        }
        ensureViewDragHelper(coordinatorLayout);
        return this.viewDragHelper.H(motionEvent);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        c cVar = this.viewDragHelper;
        if (cVar == null) {
            return false;
        }
        cVar.A(motionEvent);
        return true;
    }

    public void setDragDismissDistance(float f10) {
        this.dragDismissThreshold = clamp(0.0f, f10, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f10) {
        this.alphaEndSwipeDistance = clamp(0.0f, f10, 1.0f);
    }

    public void setListener(OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public void setSensitivity(float f10) {
        this.sensitivity = f10;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f10) {
        this.alphaStartSwipeDistance = clamp(0.0f, f10, 1.0f);
    }

    public void setSwipeDirection(int i10) {
        this.swipeDirection = i10;
    }

    public static int clamp(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }
}
