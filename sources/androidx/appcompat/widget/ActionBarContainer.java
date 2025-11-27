package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import b0.c1;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1010a;

    /* renamed from: b  reason: collision with root package name */
    public View f1011b;

    /* renamed from: c  reason: collision with root package name */
    public View f1012c;

    /* renamed from: d  reason: collision with root package name */
    public View f1013d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f1014e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f1015f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f1016g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1017h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1018i;

    /* renamed from: j  reason: collision with root package name */
    public int f1019j;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c1.o0(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f540a);
        this.f1014e = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f1015f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f1019j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == R$id.split_action_bar) {
            this.f1017h = true;
            this.f1016g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1017h ? !(this.f1014e == null && this.f1015f == null) : this.f1016g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        if (view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0) {
            return true;
        }
        return false;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1014e;
        if (drawable != null && drawable.isStateful()) {
            this.f1014e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1015f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1015f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1016g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f1016g.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1011b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1014e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1015f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1016g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1012c = findViewById(R$id.action_bar);
        this.f1013d = findViewById(R$id.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f1010a || super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        Drawable drawable;
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f1011b;
        boolean z12 = true;
        boolean z13 = false;
        if (view == null || view.getVisibility() == 8) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i14 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i10, (measuredHeight - view.getMeasuredHeight()) - i14, i12, measuredHeight - i14);
        }
        if (this.f1017h) {
            Drawable drawable2 = this.f1016g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z12 = false;
            }
        } else {
            if (this.f1014e != null) {
                if (this.f1012c.getVisibility() == 0) {
                    this.f1014e.setBounds(this.f1012c.getLeft(), this.f1012c.getTop(), this.f1012c.getRight(), this.f1012c.getBottom());
                } else {
                    View view2 = this.f1013d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f1014e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f1014e.setBounds(this.f1013d.getLeft(), this.f1013d.getTop(), this.f1013d.getRight(), this.f1013d.getBottom());
                    }
                }
                z13 = true;
            }
            this.f1018i = z11;
            if (!z11 || (drawable = this.f1015f) == null) {
                z12 = z13;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z12) {
            invalidate();
        }
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        if (this.f1012c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i14 = this.f1019j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i14, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f1012c != null) {
            int mode = View.MeasureSpec.getMode(i11);
            View view = this.f1011b;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f1012c)) {
                    i12 = a(this.f1012c);
                } else if (!b(this.f1013d)) {
                    i12 = a(this.f1013d);
                } else {
                    i12 = 0;
                }
                if (mode == Integer.MIN_VALUE) {
                    i13 = View.MeasureSpec.getSize(i11);
                } else {
                    i13 = Integer.MAX_VALUE;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i12 + a(this.f1011b), i13));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1014e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1014e);
        }
        this.f1014e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1012c;
            if (view != null) {
                this.f1014e.setBounds(view.getLeft(), this.f1012c.getTop(), this.f1012c.getRight(), this.f1012c.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f1017h ? !(this.f1014e == null && this.f1015f == null) : this.f1016g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1016g;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1016g);
        }
        this.f1016g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1017h && (drawable2 = this.f1016g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1017h ? this.f1014e == null && this.f1015f == null : this.f1016g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1015f;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1015f);
        }
        this.f1015f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1018i && (drawable2 = this.f1015f) != null) {
                drawable2.setBounds(this.f1011b.getLeft(), this.f1011b.getTop(), this.f1011b.getRight(), this.f1011b.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f1017h ? !(this.f1014e == null && this.f1015f == null) : this.f1016g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(j2 j2Var) {
        View view = this.f1011b;
        if (view != null) {
            removeView(view);
        }
        this.f1011b = j2Var;
    }

    public void setTransitioning(boolean z10) {
        int i10;
        this.f1010a = z10;
        if (z10) {
            i10 = 393216;
        } else {
            i10 = 262144;
        }
        setDescendantFocusability(i10);
    }

    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.f1014e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f1015f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f1016g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public boolean verifyDrawable(Drawable drawable) {
        if ((drawable != this.f1014e || this.f1017h) && ((drawable != this.f1015f || !this.f1018i) && ((drawable != this.f1016g || !this.f1017h) && !super.verifyDrawable(drawable)))) {
            return false;
        }
        return true;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
