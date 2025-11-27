package com.hpplay.glide.request.target;

import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.hpplay.glide.request.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce = false;
    private static Integer tagId;
    private final SizeDeterminer sizeDeterminer;
    protected final T view;

    public static class SizeDeterminer {
        private static final int PENDING_SIZE = 0;
        private final List<SizeReadyCallback> cbs = new ArrayList();
        private Point displayDimens;
        private SizeDeterminerLayoutListener layoutListener;
        private final View view;

        public static class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called listener=");
                    sb.append(this);
                }
                SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.checkCurrentDimens();
                return true;
            }
        }

        public SizeDeterminer(View view2) {
            this.view = view2;
        }

        /* access modifiers changed from: private */
        public void checkCurrentDimens() {
            if (!this.cbs.isEmpty()) {
                int viewWidthOrParam = getViewWidthOrParam();
                int viewHeightOrParam = getViewHeightOrParam();
                if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                    notifyCbs(viewWidthOrParam, viewHeightOrParam);
                    ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
                    }
                    this.layoutListener = null;
                }
            }
        }

        private Point getDisplayDimens() {
            Point point = this.displayDimens;
            if (point != null) {
                return point;
            }
            Display defaultDisplay = ((WindowManager) this.view.getContext().getSystemService("window")).getDefaultDisplay();
            Point point2 = new Point();
            this.displayDimens = point2;
            defaultDisplay.getSize(point2);
            return this.displayDimens;
        }

        private int getSizeForParam(int i10, boolean z10) {
            if (i10 != -2) {
                return i10;
            }
            Point displayDimens2 = getDisplayDimens();
            if (z10) {
                return displayDimens2.y;
            }
            return displayDimens2.x;
        }

        private int getViewHeightOrParam() {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getHeight())) {
                return this.view.getHeight();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.height, true);
            }
            return 0;
        }

        private int getViewWidthOrParam() {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getWidth())) {
                return this.view.getWidth();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.width, false);
            }
            return 0;
        }

        private boolean isSizeValid(int i10) {
            return i10 > 0 || i10 == -2;
        }

        private void notifyCbs(int i10, int i11) {
            for (SizeReadyCallback onSizeReady : this.cbs) {
                onSizeReady.onSizeReady(i10, i11);
            }
            this.cbs.clear();
        }

        public void getSize(SizeReadyCallback sizeReadyCallback) {
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (!isSizeValid(viewWidthOrParam) || !isSizeValid(viewHeightOrParam)) {
                if (!this.cbs.contains(sizeReadyCallback)) {
                    this.cbs.add(sizeReadyCallback);
                }
                if (this.layoutListener == null) {
                    ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                    SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                    this.layoutListener = sizeDeterminerLayoutListener;
                    viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
                    return;
                }
                return;
            }
            sizeReadyCallback.onSizeReady(viewWidthOrParam, viewHeightOrParam);
        }
    }

    public ViewTarget(T t10) {
        if (t10 != null) {
            this.view = t10;
            this.sizeDeterminer = new SizeDeterminer(t10);
            return;
        }
        throw new NullPointerException("View must not be null!");
    }

    private Object getTag() {
        Integer num = tagId;
        if (num == null) {
            return this.view.getTag();
        }
        return this.view.getTag(num.intValue());
    }

    private void setTag(Object obj) {
        Integer num = tagId;
        if (num == null) {
            isTagUsedAtLeastOnce = true;
            this.view.setTag(obj);
            return;
        }
        this.view.setTag(num.intValue(), obj);
    }

    public static void setTagId(int i10) {
        if (tagId != null || isTagUsedAtLeastOnce) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        tagId = Integer.valueOf(i10);
    }

    public Request getRequest() {
        Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    public T getView() {
        return this.view;
    }

    public void setRequest(Request request) {
        setTag(request);
    }

    public String toString() {
        return "Target for: " + this.view;
    }
}
