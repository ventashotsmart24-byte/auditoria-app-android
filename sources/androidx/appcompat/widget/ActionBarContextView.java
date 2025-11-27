package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import b0.a2;
import b0.c1;
import com.google.common.primitives.Ints;
import g.b;

public class ActionBarContextView extends a {

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f1020i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f1021j;

    /* renamed from: k  reason: collision with root package name */
    public View f1022k;

    /* renamed from: l  reason: collision with root package name */
    public View f1023l;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f1024m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f1025n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f1026o;

    /* renamed from: p  reason: collision with root package name */
    public int f1027p;

    /* renamed from: q  reason: collision with root package name */
    public int f1028q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1029r;

    /* renamed from: s  reason: collision with root package name */
    public int f1030s;

    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f1031a;

        public a(b bVar) {
            this.f1031a = bVar;
        }

        public void onClick(View view) {
            this.f1031a.a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public /* bridge */ /* synthetic */ a2 f(int i10, long j10) {
        return super.f(i10, j10);
    }

    public void g() {
        if (this.f1022k == null) {
            k();
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1021j;
    }

    public CharSequence getTitle() {
        return this.f1020i;
    }

    public void h(b bVar) {
        View view = this.f1022k;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f1030s, this, false);
            this.f1022k = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f1022k);
        }
        this.f1022k.findViewById(R$id.action_mode_close_button).setOnClickListener(new a(bVar));
        g gVar = (g) bVar.c();
        d dVar = this.f1165d;
        if (dVar != null) {
            dVar.p();
        }
        d dVar2 = new d(getContext());
        this.f1165d = dVar2;
        dVar2.A(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.addMenuPresenter(this.f1165d, this.f1163b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1165d.g(this);
        this.f1164c = actionMenuView;
        c1.o0(actionMenuView, (Drawable) null);
        addView(this.f1164c, layoutParams);
    }

    public final void i() {
        int i10;
        if (this.f1024m == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1024m = linearLayout;
            this.f1025n = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f1026o = (TextView) this.f1024m.findViewById(R$id.action_bar_subtitle);
            if (this.f1027p != 0) {
                this.f1025n.setTextAppearance(getContext(), this.f1027p);
            }
            if (this.f1028q != 0) {
                this.f1026o.setTextAppearance(getContext(), this.f1028q);
            }
        }
        this.f1025n.setText(this.f1020i);
        this.f1026o.setText(this.f1021j);
        boolean z10 = !TextUtils.isEmpty(this.f1020i);
        boolean z11 = !TextUtils.isEmpty(this.f1021j);
        TextView textView = this.f1026o;
        int i11 = 0;
        if (z11) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView.setVisibility(i10);
        LinearLayout linearLayout2 = this.f1024m;
        if (!z10 && !z11) {
            i11 = 8;
        }
        linearLayout2.setVisibility(i11);
        if (this.f1024m.getParent() == null) {
            addView(this.f1024m);
        }
    }

    public boolean j() {
        return this.f1029r;
    }

    public void k() {
        removeAllViews();
        this.f1023l = null;
        this.f1164c = null;
    }

    public boolean l() {
        d dVar = this.f1165d;
        if (dVar != null) {
            return dVar.B();
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f1165d;
        if (dVar != null) {
            dVar.s();
            this.f1165d.t();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1020i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        boolean b10 = y2.b(this);
        if (b10) {
            i14 = (i12 - i10) - getPaddingRight();
        } else {
            i14 = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1022k;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1022k.getLayoutParams();
            if (b10) {
                i16 = marginLayoutParams.rightMargin;
            } else {
                i16 = marginLayoutParams.leftMargin;
            }
            if (b10) {
                i17 = marginLayoutParams.leftMargin;
            } else {
                i17 = marginLayoutParams.rightMargin;
            }
            int d10 = a.d(i14, i16, b10);
            i14 = a.d(d10 + e(this.f1022k, d10, paddingTop, paddingTop2, b10), i17, b10);
        }
        int i18 = i14;
        LinearLayout linearLayout = this.f1024m;
        if (!(linearLayout == null || this.f1023l != null || linearLayout.getVisibility() == 8)) {
            i18 += e(this.f1024m, i18, paddingTop, paddingTop2, b10);
        }
        int i19 = i18;
        View view2 = this.f1023l;
        if (view2 != null) {
            e(view2, i19, paddingTop, paddingTop2, b10);
        }
        if (b10) {
            i15 = getPaddingLeft();
        } else {
            i15 = (i12 - i10) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f1164c;
        if (actionMenuView != null) {
            e(actionMenuView, i15, paddingTop, paddingTop2, !b10);
        }
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        boolean z10;
        int i13;
        int mode = View.MeasureSpec.getMode(i10);
        int i14 = Ints.MAX_POWER_OF_TWO;
        if (mode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i11) != 0) {
            int size = View.MeasureSpec.getSize(i10);
            int i15 = this.f1166e;
            if (i15 <= 0) {
                i15 = View.MeasureSpec.getSize(i11);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i16 = i15 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE);
            View view = this.f1022k;
            if (view != null) {
                int c10 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1022k.getLayoutParams();
                paddingLeft = c10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f1164c;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f1164c, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f1024m;
            if (linearLayout != null && this.f1023l == null) {
                if (this.f1029r) {
                    this.f1024m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f1024m.getMeasuredWidth();
                    if (measuredWidth <= paddingLeft) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        paddingLeft -= measuredWidth;
                    }
                    LinearLayout linearLayout2 = this.f1024m;
                    if (z10) {
                        i13 = 0;
                    } else {
                        i13 = 8;
                    }
                    linearLayout2.setVisibility(i13);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f1023l;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i17 = layoutParams.width;
                if (i17 != -2) {
                    i12 = Ints.MAX_POWER_OF_TWO;
                } else {
                    i12 = Integer.MIN_VALUE;
                }
                if (i17 >= 0) {
                    paddingLeft = Math.min(i17, paddingLeft);
                }
                int i18 = layoutParams.height;
                if (i18 == -2) {
                    i14 = Integer.MIN_VALUE;
                }
                if (i18 >= 0) {
                    i16 = Math.min(i18, i16);
                }
                this.f1023l.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i12), View.MeasureSpec.makeMeasureSpec(i16, i14));
            }
            if (this.f1166e <= 0) {
                int childCount = getChildCount();
                int i19 = 0;
                for (int i20 = 0; i20 < childCount; i20++) {
                    int measuredHeight = getChildAt(i20).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i19) {
                        i19 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i19);
                return;
            }
            setMeasuredDimension(size, i15);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i10) {
        this.f1166e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1023l;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1023l = view;
        if (!(view == null || (linearLayout = this.f1024m) == null)) {
            removeView(linearLayout);
            this.f1024m = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1021j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1020i = charSequence;
        i();
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f1029r) {
            requestLayout();
        }
        this.f1029r = z10;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        r2 u10 = r2.u(context, attributeSet, R$styleable.f544e, i10, 0);
        c1.o0(this, u10.g(R$styleable.ActionMode_background));
        this.f1027p = u10.n(R$styleable.ActionMode_titleTextStyle, 0);
        this.f1028q = u10.n(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f1166e = u10.m(R$styleable.ActionMode_height, 0);
        this.f1030s = u10.n(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        u10.v();
    }
}
