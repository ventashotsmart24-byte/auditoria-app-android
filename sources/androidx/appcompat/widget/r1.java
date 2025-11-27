package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.core.widget.o;
import b0.a2;
import com.google.common.primitives.Ints;
import e.m;
import java.lang.reflect.Field;
import s.h;

public class r1 extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f1335a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public int f1336b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1337c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f1338d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f1339e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1340f;

    /* renamed from: g  reason: collision with root package name */
    public Field f1341g;

    /* renamed from: h  reason: collision with root package name */
    public a f1342h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1343i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1344j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1345k;

    /* renamed from: l  reason: collision with root package name */
    public a2 f1346l;

    /* renamed from: m  reason: collision with root package name */
    public o f1347m;

    /* renamed from: n  reason: collision with root package name */
    public b f1348n;

    public static class a extends m {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1349a = true;

        public a(Drawable drawable) {
            super(drawable);
        }

        public void a(boolean z10) {
            this.f1349a = z10;
        }

        public void draw(Canvas canvas) {
            if (this.f1349a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f10, float f11) {
            if (this.f1349a) {
                super.setHotspot(f10, f11);
            }
        }

        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f1349a) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f1349a) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f1349a) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void a() {
            r1 r1Var = r1.this;
            r1Var.f1348n = null;
            r1Var.removeCallbacks(this);
        }

        public void b() {
            r1.this.post(this);
        }

        public void run() {
            r1 r1Var = r1.this;
            r1Var.f1348n = null;
            r1Var.drawableStateChanged();
        }
    }

    public r1(Context context, boolean z10) {
        super(context, (AttributeSet) null, R$attr.dropDownListViewStyle);
        this.f1344j = z10;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1341g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
        }
    }

    public final void a() {
        this.f1345k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1340f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        a2 a2Var = this.f1346l;
        if (a2Var != null) {
            a2Var.b();
            this.f1346l = null;
        }
    }

    public final void b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (!this.f1335a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1335a);
            selector.draw(canvas);
        }
    }

    public int d(int i10, int i11, int i12, int i13, int i14) {
        int i15;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i16 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < count) {
            int itemViewType = adapter.getItemViewType(i17);
            if (itemViewType != i18) {
                view = null;
                i18 = itemViewType;
            }
            view = adapter.getView(i17, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i20 = layoutParams.height;
            if (i20 > 0) {
                i15 = View.MeasureSpec.makeMeasureSpec(i20, Ints.MAX_POWER_OF_TWO);
            } else {
                i15 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i10, i15);
            view.forceLayout();
            if (i17 > 0) {
                i16 += dividerHeight;
            }
            i16 += view.getMeasuredHeight();
            if (i16 < i13) {
                if (i14 >= 0 && i17 >= i14) {
                    i19 = i16;
                }
                i17++;
            } else if (i14 < 0 || i17 <= i14 || i19 <= 0 || i16 == i13) {
                return i13;
            } else {
                return i19;
            }
        }
        return i16;
    }

    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    public void drawableStateChanged() {
        if (this.f1348n == null) {
            super.drawableStateChanged();
            j(true);
            l();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r9 = 0
            r3 = 1
            goto L_0x0046
        L_0x0011:
            r9 = 0
            r3 = 0
            goto L_0x0046
        L_0x0014:
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = 1
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto L_0x000e
            r7.b(r3, r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.a()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.o r9 = r7.f1347m
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.o r9 = new androidx.core.widget.o
            r9.<init>(r7)
            r7.f1347m = r9
        L_0x005a:
            androidx.core.widget.o r9 = r7.f1347m
            r9.m(r1)
            androidx.core.widget.o r9 = r7.f1347m
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.o r8 = r7.f1347m
            if (r8 == 0) goto L_0x006c
            r8.m(r2)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r1.e(android.view.MotionEvent, int):boolean");
    }

    public final void f(int i10, View view) {
        boolean z10;
        Rect rect = this.f1335a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1336b;
        rect.top -= this.f1337c;
        rect.right += this.f1338d;
        rect.bottom += this.f1339e;
        try {
            boolean z11 = this.f1341g.getBoolean(this);
            if (view.isEnabled() != z11) {
                Field field = this.f1341g;
                if (!z11) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                field.set(this, Boolean.valueOf(z10));
                if (i10 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        }
    }

    public final void g(int i10, View view) {
        boolean z10;
        Drawable selector = getSelector();
        boolean z11 = true;
        if (selector == null || i10 == -1) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            selector.setVisible(false, false);
        }
        f(i10, view);
        if (z10) {
            Rect rect = this.f1335a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z11 = false;
            }
            selector.setVisible(z11, false);
            h.k(selector, exactCenterX, exactCenterY);
        }
    }

    public final void h(int i10, View view, float f10, float f11) {
        g(i10, view);
        Drawable selector = getSelector();
        if (selector != null && i10 != -1) {
            h.k(selector, f10, f11);
        }
    }

    public boolean hasFocus() {
        if (this.f1344j || super.hasFocus()) {
            return true;
        }
        return false;
    }

    public boolean hasWindowFocus() {
        if (this.f1344j || super.hasWindowFocus()) {
            return true;
        }
        return false;
    }

    public final void i(View view, int i10, float f10, float f11) {
        View childAt;
        this.f1345k = true;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            drawableHotspotChanged(f10, f11);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i12 = this.f1340f;
        if (!(i12 == -1 || (childAt = getChildAt(i12 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f1340f = i10;
        float left = f10 - ((float) view.getLeft());
        float top = f11 - ((float) view.getTop());
        if (i11 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i10, view, f10, f11);
        j(false);
        refreshDrawableState();
    }

    public boolean isFocused() {
        if (this.f1344j || super.isFocused()) {
            return true;
        }
        return false;
    }

    public boolean isInTouchMode() {
        if ((!this.f1344j || !this.f1343i) && !super.isInTouchMode()) {
            return false;
        }
        return true;
    }

    public final void j(boolean z10) {
        a aVar = this.f1342h;
        if (aVar != null) {
            aVar.a(z10);
        }
    }

    public final boolean k() {
        return this.f1345k;
    }

    public final void l() {
        Drawable selector = getSelector();
        if (selector != null && k() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public void onDetachedFromWindow() {
        this.f1348n = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1348n == null) {
            b bVar = new b();
            this.f1348n = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                l();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1340f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f1348n;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f1343i = z10;
    }

    public void setSelector(Drawable drawable) {
        a aVar;
        if (drawable != null) {
            aVar = new a(drawable);
        } else {
            aVar = null;
        }
        this.f1342h = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1336b = rect.left;
        this.f1337c = rect.top;
        this.f1338d = rect.right;
        this.f1339e = rect.bottom;
    }
}
