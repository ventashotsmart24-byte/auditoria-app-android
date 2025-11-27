package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.R$styleable;
import b0.c1;
import b0.f2;
import java.util.ArrayList;

public final class i extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f2028a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f2029b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f2030c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2031d = true;

    public i(Context context, AttributeSet attributeSet, o oVar) {
        super(context, attributeSet);
        String str;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1863e);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment g02 = oVar.g0(id);
        if (classAttribute != null && g02 == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a10 = oVar.q0().a(context.getClassLoader(), classAttribute);
            a10.onInflate(context, attributeSet, (Bundle) null);
            oVar.m().t(true).d(this, a10, string).k();
        }
        oVar.U0(this);
    }

    public final void a(View view) {
        ArrayList arrayList = this.f2029b;
        if (arrayList != null && arrayList.contains(view)) {
            if (this.f2028a == null) {
                this.f2028a = new ArrayList();
            }
            this.f2028a.add(view);
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (o.z0(view) != null) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public boolean addViewInLayout(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        if (o.z0(view) != null) {
            return super.addViewInLayout(view, i10, layoutParams, z10);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        f2 f2Var;
        f2 t10 = f2.t(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2030c;
        if (onApplyWindowInsetsListener != null) {
            f2Var = f2.t(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            f2Var = c1.X(this, t10);
        }
        if (!f2Var.m()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                c1.g(getChildAt(i10), f2Var);
            }
        }
        return windowInsets;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.f2031d && this.f2028a != null) {
            for (int i10 = 0; i10 < this.f2028a.size(); i10++) {
                super.drawChild(canvas, (View) this.f2028a.get(i10), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean drawChild(Canvas canvas, View view, long j10) {
        ArrayList arrayList;
        if (!this.f2031d || (arrayList = this.f2028a) == null || arrayList.size() <= 0 || !this.f2028a.contains(view)) {
            return super.drawChild(canvas, view, j10);
        }
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList arrayList = this.f2029b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f2028a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f2031d = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    public void removeDetachedView(View view, boolean z10) {
        if (z10) {
            a(view);
        }
        super.removeDetachedView(view, z10);
    }

    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i10) {
        a(getChildAt(i10));
        super.removeViewAt(i10);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i10, int i11) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            a(getChildAt(i12));
        }
        super.removeViews(i10, i11);
    }

    public void removeViewsInLayout(int i10, int i11) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            a(getChildAt(i12));
        }
        super.removeViewsInLayout(i10, i11);
    }

    public void setDrawDisappearingViewsLast(boolean z10) {
        this.f2031d = z10;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f2030c = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f2029b == null) {
                this.f2029b = new ArrayList();
            }
            this.f2029b.add(view);
        }
        super.startViewTransition(view);
    }
}
