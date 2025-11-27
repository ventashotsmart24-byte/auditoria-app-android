package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.m;
import b0.a0;
import b0.c1;
import b0.x;
import b0.y;
import b0.z;

public class ActionBarOverlayLayout extends ViewGroup implements h1, z, x, y {
    public static final int[] B = {R$attr.actionBarSize, 16842841};
    public final a0 A;

    /* renamed from: a  reason: collision with root package name */
    public int f1033a;

    /* renamed from: b  reason: collision with root package name */
    public int f1034b = 0;

    /* renamed from: c  reason: collision with root package name */
    public ContentFrameLayout f1035c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContainer f1036d;

    /* renamed from: e  reason: collision with root package name */
    public i1 f1037e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f1038f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1039g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1040h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1041i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1042j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1043k;

    /* renamed from: l  reason: collision with root package name */
    public int f1044l;

    /* renamed from: m  reason: collision with root package name */
    public int f1045m;

    /* renamed from: n  reason: collision with root package name */
    public final Rect f1046n = new Rect();

    /* renamed from: o  reason: collision with root package name */
    public final Rect f1047o = new Rect();

    /* renamed from: p  reason: collision with root package name */
    public final Rect f1048p = new Rect();

    /* renamed from: q  reason: collision with root package name */
    public final Rect f1049q = new Rect();

    /* renamed from: r  reason: collision with root package name */
    public final Rect f1050r = new Rect();

    /* renamed from: s  reason: collision with root package name */
    public final Rect f1051s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    public final Rect f1052t = new Rect();

    /* renamed from: u  reason: collision with root package name */
    public d f1053u;

    /* renamed from: v  reason: collision with root package name */
    public OverScroller f1054v;

    /* renamed from: w  reason: collision with root package name */
    public ViewPropertyAnimator f1055w;

    /* renamed from: x  reason: collision with root package name */
    public final AnimatorListenerAdapter f1056x = new a();

    /* renamed from: y  reason: collision with root package name */
    public final Runnable f1057y = new b();

    /* renamed from: z  reason: collision with root package name */
    public final Runnable f1058z = new c();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1055w = null;
            actionBarOverlayLayout.f1043k = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1055w = null;
            actionBarOverlayLayout.f1043k = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1055w = actionBarOverlayLayout.f1036d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1056x);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1055w = actionBarOverlayLayout.f1036d.animate().translationY((float) (-ActionBarOverlayLayout.this.f1036d.getHeight())).setListener(ActionBarOverlayLayout.this.f1056x);
        }
    }

    public interface d {
        void a();

        void b(int i10);

        void c();

        void d(boolean z10);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p(context);
        this.A = new a0(this);
    }

    public boolean a() {
        t();
        return this.f1037e.a();
    }

    public boolean b() {
        t();
        return this.f1037e.b();
    }

    public boolean c() {
        t();
        return this.f1037e.c();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public void d(Menu menu, m.a aVar) {
        t();
        this.f1037e.d(menu, aVar);
    }

    public void draw(Canvas canvas) {
        int i10;
        super.draw(canvas);
        if (this.f1038f != null && !this.f1039g) {
            if (this.f1036d.getVisibility() == 0) {
                i10 = (int) (((float) this.f1036d.getBottom()) + this.f1036d.getTranslationY() + 0.5f);
            } else {
                i10 = 0;
            }
            this.f1038f.setBounds(0, i10, getWidth(), this.f1038f.getIntrinsicHeight() + i10);
            this.f1038f.draw(canvas);
        }
    }

    public boolean e() {
        t();
        return this.f1037e.e();
    }

    public void f() {
        t();
        this.f1037e.f();
    }

    public boolean fitSystemWindows(Rect rect) {
        t();
        c1.J(this);
        boolean k10 = k(this.f1036d, rect, true, true, false, true);
        this.f1049q.set(rect);
        y2.a(this, this.f1049q, this.f1046n);
        if (!this.f1050r.equals(this.f1049q)) {
            this.f1050r.set(this.f1049q);
            k10 = true;
        }
        if (!this.f1047o.equals(this.f1046n)) {
            this.f1047o.set(this.f1046n);
            k10 = true;
        }
        if (k10) {
            requestLayout();
        }
        return true;
    }

    public boolean g() {
        t();
        return this.f1037e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1036d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.A.a();
    }

    public CharSequence getTitle() {
        t();
        return this.f1037e.getTitle();
    }

    public void h(int i10) {
        t();
        if (i10 == 2) {
            this.f1037e.p();
        } else if (i10 == 5) {
            this.f1037e.y();
        } else if (i10 == 109) {
            setOverlayMode(true);
        }
    }

    public void i() {
        t();
        this.f1037e.r();
    }

    public final void j() {
        o();
        this.f1058z.run();
    }

    public final boolean k(View view, Rect rect, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14;
        int i10;
        int i11;
        int i12;
        int i13;
        e eVar = (e) view.getLayoutParams();
        if (!z10 || eVar.leftMargin == (i13 = rect.left)) {
            z14 = false;
        } else {
            eVar.leftMargin = i13;
            z14 = true;
        }
        if (z11 && eVar.topMargin != (i12 = rect.top)) {
            eVar.topMargin = i12;
            z14 = true;
        }
        if (z13 && eVar.rightMargin != (i11 = rect.right)) {
            eVar.rightMargin = i11;
            z14 = true;
        }
        if (!z12 || eVar.bottomMargin == (i10 = rect.bottom)) {
            return z14;
        }
        eVar.bottomMargin = i10;
        return true;
    }

    /* renamed from: l */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    /* renamed from: m */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public final i1 n(View view) {
        if (view instanceof i1) {
            return (i1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void o() {
        removeCallbacks(this.f1057y);
        removeCallbacks(this.f1058z);
        ViewPropertyAnimator viewPropertyAnimator = this.f1055w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        p(getContext());
        c1.h0(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = eVar.leftMargin + paddingLeft;
                int i16 = eVar.topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    public void onMeasure(int i10, int i11) {
        boolean z10;
        int i12;
        t();
        measureChildWithMargins(this.f1036d, i10, 0, i11, 0);
        e eVar = (e) this.f1036d.getLayoutParams();
        int max = Math.max(0, this.f1036d.getMeasuredWidth() + eVar.leftMargin + eVar.rightMargin);
        int max2 = Math.max(0, this.f1036d.getMeasuredHeight() + eVar.topMargin + eVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1036d.getMeasuredState());
        if ((c1.J(this) & 256) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i12 = this.f1033a;
            if (this.f1041i && this.f1036d.getTabContainer() != null) {
                i12 += this.f1033a;
            }
        } else {
            i12 = this.f1036d.getVisibility() != 8 ? this.f1036d.getMeasuredHeight() : 0;
        }
        this.f1048p.set(this.f1046n);
        this.f1051s.set(this.f1049q);
        if (this.f1040h || z10) {
            Rect rect = this.f1051s;
            rect.top += i12;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.f1048p;
            rect2.top += i12;
            rect2.bottom += 0;
        }
        k(this.f1035c, this.f1048p, true, true, true, true);
        if (!this.f1052t.equals(this.f1051s)) {
            this.f1052t.set(this.f1051s);
            this.f1035c.a(this.f1051s);
        }
        measureChildWithMargins(this.f1035c, i10, 0, i11, 0);
        e eVar2 = (e) this.f1035c.getLayoutParams();
        int max3 = Math.max(max, this.f1035c.getMeasuredWidth() + eVar2.leftMargin + eVar2.rightMargin);
        int max4 = Math.max(max2, this.f1035c.getMeasuredHeight() + eVar2.topMargin + eVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1035c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f1042j || !z10) {
            return false;
        }
        if (v(f10, f11)) {
            j();
        } else {
            u();
        }
        this.f1043k = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        onNestedScroll(view, i10, i11, i12, i13, i14);
    }

    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i10) {
        boolean z10;
        super.onWindowSystemUiVisibilityChanged(i10);
        t();
        int i11 = this.f1045m ^ i10;
        this.f1045m = i10;
        boolean z11 = false;
        if ((i10 & 4) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((i10 & 256) != 0) {
            z11 = true;
        }
        d dVar = this.f1053u;
        if (dVar != null) {
            dVar.d(!z11);
            if (z10 || !z11) {
                this.f1053u.a();
            } else {
                this.f1053u.e();
            }
        }
        if ((i11 & 256) != 0 && this.f1053u != null) {
            c1.h0(this);
        }
    }

    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f1034b = i10;
        d dVar = this.f1053u;
        if (dVar != null) {
            dVar.b(i10);
        }
    }

    public final void p(Context context) {
        boolean z10;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(B);
        boolean z11 = false;
        this.f1033a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1038f = drawable;
        if (drawable == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        setWillNotDraw(z10);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z11 = true;
        }
        this.f1039g = z11;
        this.f1054v = new OverScroller(context);
    }

    public boolean q() {
        return this.f1040h;
    }

    public final void r() {
        o();
        postDelayed(this.f1058z, 600);
    }

    public final void s() {
        o();
        postDelayed(this.f1057y, 600);
    }

    public void setActionBarHideOffset(int i10) {
        o();
        this.f1036d.setTranslationY((float) (-Math.max(0, Math.min(i10, this.f1036d.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f1053u = dVar;
        if (getWindowToken() != null) {
            this.f1053u.b(this.f1034b);
            int i10 = this.f1045m;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                c1.h0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f1041i = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f1042j) {
            this.f1042j = z10;
            if (!z10) {
                o();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i10) {
        t();
        this.f1037e.setIcon(i10);
    }

    public void setLogo(int i10) {
        t();
        this.f1037e.t(i10);
    }

    public void setOverlayMode(boolean z10) {
        boolean z11;
        this.f1040h = z10;
        if (!z10 || getContext().getApplicationInfo().targetSdkVersion >= 19) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.f1039g = z11;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    public void setWindowCallback(Window.Callback callback) {
        t();
        this.f1037e.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        t();
        this.f1037e.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t() {
        if (this.f1035c == null) {
            this.f1035c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f1036d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f1037e = n(findViewById(R$id.action_bar));
        }
    }

    public final void u() {
        o();
        this.f1057y.run();
    }

    public final boolean v(float f10, float f11) {
        this.f1054v.fling(0, 0, 0, (int) f11, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f1054v.getFinalY() > this.f1036d.getHeight()) {
            return true;
        }
        return false;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.A.b(view, view2, i10);
        this.f1044l = getActionBarHideOffset();
        o();
        d dVar = this.f1053u;
        if (dVar != null) {
            dVar.f();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f1036d.getVisibility() != 0) {
            return false;
        }
        return this.f1042j;
    }

    public void onStopNestedScroll(View view) {
        if (this.f1042j && !this.f1043k) {
            if (this.f1044l <= this.f1036d.getHeight()) {
                s();
            } else {
                r();
            }
        }
        d dVar = this.f1053u;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f1044l + i11;
        this.f1044l = i14;
        setActionBarHideOffset(i14);
    }

    public void setIcon(Drawable drawable) {
        t();
        this.f1037e.setIcon(drawable);
    }
}
