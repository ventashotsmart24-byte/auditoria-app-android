package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.u1;
import com.google.common.primitives.Ints;

public class ActionMenuView extends u1 implements g.b, n {

    /* renamed from: a  reason: collision with root package name */
    public g f1062a;

    /* renamed from: b  reason: collision with root package name */
    public Context f1063b;

    /* renamed from: c  reason: collision with root package name */
    public int f1064c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1065d;

    /* renamed from: e  reason: collision with root package name */
    public d f1066e;

    /* renamed from: f  reason: collision with root package name */
    public m.a f1067f;

    /* renamed from: g  reason: collision with root package name */
    public g.a f1068g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1069h;

    /* renamed from: i  reason: collision with root package name */
    public int f1070i;

    /* renamed from: j  reason: collision with root package name */
    public int f1071j;

    /* renamed from: k  reason: collision with root package name */
    public int f1072k;

    /* renamed from: l  reason: collision with root package name */
    public e f1073l;

    public interface a {
        boolean a();

        boolean b();
    }

    public static class b implements m.a {
        public boolean a(g gVar) {
            return false;
        }

        public void onCloseMenu(g gVar, boolean z10) {
        }
    }

    public static class c extends u1.a {

        /* renamed from: c  reason: collision with root package name */
        public boolean f1074c;

        /* renamed from: d  reason: collision with root package name */
        public int f1075d;

        /* renamed from: e  reason: collision with root package name */
        public int f1076e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1077f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f1078g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f1079h;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f1074c = cVar.f1074c;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f1074c = false;
        }
    }

    public class d implements g.a {
        public d() {
        }

        public boolean onMenuItemSelected(g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.f1073l;
            if (eVar == null || !eVar.onMenuItemClick(menuItem)) {
                return false;
            }
            return true;
        }

        public void onMenuModeChange(g gVar) {
            g.a aVar = ActionMenuView.this.f1068g;
            if (aVar != null) {
                aVar.onMenuModeChange(gVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static int q(View view, int i10, int i11, int i12, int i13) {
        ActionMenuItemView actionMenuItemView;
        boolean z10;
        int i14;
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12) - i13, View.MeasureSpec.getMode(i12));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z11 = true;
        if (actionMenuItemView == null || !actionMenuItemView.d()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (i11 > 0) {
            i14 = 2;
            if (!z10 || i11 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i10, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i15 = measuredWidth / i10;
                if (measuredWidth % i10 != 0) {
                    i15++;
                }
                if (!z10 || i15 >= 2) {
                    i14 = i15;
                }
                if (cVar.f1074c || !z10) {
                    z11 = false;
                }
                cVar.f1077f = z11;
                cVar.f1075d = i14;
                view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, Ints.MAX_POWER_OF_TWO), makeMeasureSpec);
                return i14;
            }
        }
        i14 = 0;
        z11 = false;
        cVar.f1077f = z11;
        cVar.f1075d = i14;
        view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, Ints.MAX_POWER_OF_TWO), makeMeasureSpec);
        return i14;
    }

    public boolean b(i iVar) {
        return this.f1062a.performItemAction(iVar, 0);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void g() {
        d dVar = this.f1066e;
        if (dVar != null) {
            dVar.p();
        }
    }

    public Menu getMenu() {
        if (this.f1062a == null) {
            Context context = getContext();
            g gVar = new g(context);
            this.f1062a = gVar;
            gVar.setCallback(new d());
            d dVar = new d(context);
            this.f1066e = dVar;
            dVar.A(true);
            d dVar2 = this.f1066e;
            m.a aVar = this.f1067f;
            if (aVar == null) {
                aVar = new b();
            }
            dVar2.setCallback(aVar);
            this.f1062a.addMenuPresenter(this.f1066e, this.f1063b);
            this.f1066e.y(this);
        }
        return this.f1062a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1066e.r();
    }

    public int getPopupTheme() {
        return this.f1064c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* renamed from: h */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.f1393b = 16;
        return cVar;
    }

    /* renamed from: i */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public void initialize(g gVar) {
        this.f1062a = gVar;
    }

    /* renamed from: j */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        if (layoutParams instanceof c) {
            cVar = new c((c) layoutParams);
        } else {
            cVar = new c(layoutParams);
        }
        if (cVar.f1393b <= 0) {
            cVar.f1393b = 16;
        }
        return cVar;
    }

    public c k() {
        c h10 = generateDefaultLayoutParams();
        h10.f1074c = true;
        return h10;
    }

    public boolean l(int i10) {
        boolean z10 = false;
        if (i10 == 0) {
            return false;
        }
        View childAt = getChildAt(i10 - 1);
        View childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            z10 = false | ((a) childAt).a();
        }
        if (i10 <= 0 || !(childAt2 instanceof a)) {
            return z10;
        }
        return z10 | ((a) childAt2).b();
    }

    public boolean m() {
        d dVar = this.f1066e;
        if (dVar == null || !dVar.s()) {
            return false;
        }
        return true;
    }

    public boolean n() {
        d dVar = this.f1066e;
        if (dVar == null || !dVar.u()) {
            return false;
        }
        return true;
    }

    public boolean o() {
        d dVar = this.f1066e;
        if (dVar == null || !dVar.v()) {
            return false;
        }
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d dVar = this.f1066e;
        if (dVar != null) {
            dVar.updateMenuView(false);
            if (this.f1066e.v()) {
                this.f1066e.s();
                this.f1066e.B();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        if (!this.f1069h) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i17 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i18 = i12 - i10;
        int paddingRight = (i18 - getPaddingRight()) - getPaddingLeft();
        boolean b10 = y2.b(this);
        int i19 = 0;
        int i20 = 0;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1074c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (l(i21)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b10) {
                        i15 = getPaddingLeft() + cVar.leftMargin;
                        i16 = i15 + measuredWidth;
                    } else {
                        i16 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i15 = i16 - measuredWidth;
                    }
                    int i22 = i17 - (measuredHeight / 2);
                    childAt.layout(i15, i22, i16, measuredHeight + i22);
                    paddingRight -= measuredWidth;
                    i19 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    l(i21);
                    i20++;
                }
            }
        }
        if (childCount == 1 && i19 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i23 = (i18 / 2) - (measuredWidth2 / 2);
            int i24 = i17 - (measuredHeight2 / 2);
            childAt2.layout(i23, i24, measuredWidth2 + i23, measuredHeight2 + i24);
            return;
        }
        int i25 = i20 - (i19 ^ 1);
        if (i25 > 0) {
            i14 = paddingRight / i25;
        } else {
            i14 = 0;
        }
        int max = Math.max(0, i14);
        if (b10) {
            int width = getWidth() - getPaddingRight();
            for (int i26 = 0; i26 < childCount; i26++) {
                View childAt3 = getChildAt(i26);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1074c) {
                    int i27 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i28 = i17 - (measuredHeight3 / 2);
                    childAt3.layout(i27 - measuredWidth3, i28, i27, measuredHeight3 + i28);
                    width = i27 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i29 = 0; i29 < childCount; i29++) {
            View childAt4 = getChildAt(i29);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f1074c) {
                int i30 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i31 = i17 - (measuredHeight4 / 2);
                childAt4.layout(i30, i31, i30 + measuredWidth4, measuredHeight4 + i31);
                paddingLeft = i30 + measuredWidth4 + cVar3.rightMargin + max;
            }
        }
    }

    public void onMeasure(int i10, int i11) {
        boolean z10;
        g gVar;
        boolean z11 = this.f1069h;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f1069h = z10;
        if (z11 != z10) {
            this.f1070i = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (!(!this.f1069h || (gVar = this.f1062a) == null || size == this.f1070i)) {
            this.f1070i = size;
            gVar.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.f1069h || childCount <= 0) {
            for (int i12 = 0; i12 < childCount; i12++) {
                c cVar = (c) getChildAt(i12).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i10, i11);
            return;
        }
        r(i10, i11);
    }

    public boolean p() {
        return this.f1065d;
    }

    public final void r(int i10, int i11) {
        boolean z10;
        int i12;
        boolean z11;
        int i13;
        int i14;
        boolean z12;
        boolean z13;
        int i15;
        int i16;
        boolean z14;
        int i17;
        boolean z15;
        boolean z16;
        int i18;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i19 = size - paddingLeft;
        int i20 = this.f1071j;
        int i21 = i19 / i20;
        int i22 = i19 % i20;
        if (i21 == 0) {
            setMeasuredDimension(i19, 0);
            return;
        }
        int i23 = i20 + (i22 / i21);
        int childCount = getChildCount();
        int i24 = 0;
        int i25 = 0;
        boolean z17 = false;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        long j10 = 0;
        while (i25 < childCount) {
            View childAt = getChildAt(i25);
            int i29 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z18 = childAt instanceof ActionMenuItemView;
                int i30 = i26 + 1;
                if (z18) {
                    int i31 = this.f1072k;
                    i17 = i30;
                    z15 = false;
                    childAt.setPadding(i31, 0, i31, 0);
                } else {
                    i17 = i30;
                    z15 = false;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f1079h = z15;
                cVar.f1076e = z15 ? 1 : 0;
                cVar.f1075d = z15;
                cVar.f1077f = z15;
                cVar.leftMargin = z15;
                cVar.rightMargin = z15;
                if (!z18 || !((ActionMenuItemView) childAt).d()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                cVar.f1078g = z16;
                if (cVar.f1074c) {
                    i18 = 1;
                } else {
                    i18 = i21;
                }
                int q10 = q(childAt, i23, i18, childMeasureSpec, paddingTop);
                i27 = Math.max(i27, q10);
                if (cVar.f1077f) {
                    i28++;
                }
                if (cVar.f1074c) {
                    z17 = true;
                }
                i21 -= q10;
                i24 = Math.max(i24, childAt.getMeasuredHeight());
                if (q10 == 1) {
                    j10 |= (long) (1 << i25);
                    i24 = i24;
                } else {
                    int i32 = i24;
                }
                i26 = i17;
            }
            i25++;
            size2 = i29;
        }
        int i33 = size2;
        if (!z17 || i26 != 2) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean z19 = false;
        while (true) {
            if (i28 <= 0 || i21 <= 0) {
                i14 = mode;
                i12 = i19;
                z11 = z19;
                i13 = i24;
            } else {
                int i34 = 0;
                int i35 = 0;
                int i36 = Integer.MAX_VALUE;
                long j11 = 0;
                while (i35 < childCount) {
                    boolean z20 = z19;
                    c cVar2 = (c) getChildAt(i35).getLayoutParams();
                    int i37 = i24;
                    if (cVar2.f1077f) {
                        int i38 = cVar2.f1075d;
                        if (i38 < i36) {
                            j11 = 1 << i35;
                            i36 = i38;
                            i34 = 1;
                        } else if (i38 == i36) {
                            i34++;
                            j11 |= 1 << i35;
                        }
                    }
                    i35++;
                    i24 = i37;
                    z19 = z20;
                }
                z11 = z19;
                i13 = i24;
                j10 |= j11;
                if (i34 > i21) {
                    i14 = mode;
                    i12 = i19;
                    break;
                }
                int i39 = i36 + 1;
                int i40 = 0;
                while (i40 < childCount) {
                    View childAt2 = getChildAt(i40);
                    c cVar3 = (c) childAt2.getLayoutParams();
                    int i41 = i19;
                    int i42 = mode;
                    long j12 = (long) (1 << i40);
                    if ((j11 & j12) == 0) {
                        if (cVar3.f1075d == i39) {
                            j10 |= j12;
                        }
                        z14 = z10;
                    } else {
                        if (!z10 || !cVar3.f1078g || i21 != 1) {
                            z14 = z10;
                        } else {
                            int i43 = this.f1072k;
                            z14 = z10;
                            childAt2.setPadding(i43 + i23, 0, i43, 0);
                        }
                        cVar3.f1075d++;
                        cVar3.f1079h = true;
                        i21--;
                    }
                    i40++;
                    mode = i42;
                    i19 = i41;
                    z10 = z14;
                }
                i24 = i13;
                z19 = true;
            }
        }
        if (z17 || i26 != 1) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (i21 <= 0 || j10 == 0 || (i21 >= i26 - 1 && !z12 && i27 <= 1)) {
            z13 = z11;
        } else {
            float bitCount = (float) Long.bitCount(j10);
            if (!z12) {
                if ((j10 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f1078g) {
                    bitCount -= 0.5f;
                }
                int i44 = childCount - 1;
                if ((j10 & ((long) (1 << i44))) != 0 && !((c) getChildAt(i44).getLayoutParams()).f1078g) {
                    bitCount -= 0.5f;
                }
            }
            if (bitCount > 0.0f) {
                i16 = (int) (((float) (i21 * i23)) / bitCount);
            } else {
                i16 = 0;
            }
            z13 = z11;
            for (int i45 = 0; i45 < childCount; i45++) {
                if ((j10 & ((long) (1 << i45))) != 0) {
                    View childAt3 = getChildAt(i45);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f1076e = i16;
                        cVar4.f1079h = true;
                        if (i45 == 0 && !cVar4.f1078g) {
                            cVar4.leftMargin = (-i16) / 2;
                        }
                    } else if (cVar4.f1074c) {
                        cVar4.f1076e = i16;
                        cVar4.f1079h = true;
                        cVar4.rightMargin = (-i16) / 2;
                    } else {
                        if (i45 != 0) {
                            cVar4.leftMargin = i16 / 2;
                        }
                        if (i45 != childCount - 1) {
                            cVar4.rightMargin = i16 / 2;
                        }
                    }
                    z13 = true;
                }
            }
        }
        if (z13) {
            for (int i46 = 0; i46 < childCount; i46++) {
                View childAt4 = getChildAt(i46);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f1079h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f1075d * i23) + cVar5.f1076e, Ints.MAX_POWER_OF_TWO), childMeasureSpec);
                }
            }
        }
        if (i14 != 1073741824) {
            i15 = i13;
        } else {
            i15 = i33;
        }
        setMeasuredDimension(i12, i15);
    }

    public g s() {
        return this.f1062a;
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f1066e.x(z10);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f1073l = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1066e.z(drawable);
    }

    public void setOverflowReserved(boolean z10) {
        this.f1065d = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.f1064c != i10) {
            this.f1064c = i10;
            if (i10 == 0) {
                this.f1063b = getContext();
            } else {
                this.f1063b = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(d dVar) {
        this.f1066e = dVar;
        dVar.y(this);
    }

    public void t(m.a aVar, g.a aVar2) {
        this.f1067f = aVar;
        this.f1068g = aVar2;
    }

    public boolean u() {
        d dVar = this.f1066e;
        if (dVar == null || !dVar.B()) {
            return false;
        }
        return true;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f1071j = (int) (56.0f * f10);
        this.f1072k = (int) (f10 * 4.0f);
        this.f1063b = context;
        this.f1064c = 0;
    }
}
