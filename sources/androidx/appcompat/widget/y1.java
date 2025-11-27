package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.p;
import androidx.core.widget.t;
import b0.c1;
import java.lang.reflect.Method;

public class y1 implements p {
    public static Method H;
    public static Method I;
    public static Method J;
    public final c A;
    public Runnable B;
    public final Handler C;
    public final Rect D;
    public Rect E;
    public boolean F;
    public PopupWindow G;

    /* renamed from: a  reason: collision with root package name */
    public Context f1447a;

    /* renamed from: b  reason: collision with root package name */
    public ListAdapter f1448b;

    /* renamed from: c  reason: collision with root package name */
    public r1 f1449c;

    /* renamed from: d  reason: collision with root package name */
    public int f1450d;

    /* renamed from: e  reason: collision with root package name */
    public int f1451e;

    /* renamed from: f  reason: collision with root package name */
    public int f1452f;

    /* renamed from: g  reason: collision with root package name */
    public int f1453g;

    /* renamed from: h  reason: collision with root package name */
    public int f1454h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1455i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1456j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1457k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1458l;

    /* renamed from: m  reason: collision with root package name */
    public int f1459m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1460n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1461o;

    /* renamed from: p  reason: collision with root package name */
    public int f1462p;

    /* renamed from: q  reason: collision with root package name */
    public View f1463q;

    /* renamed from: r  reason: collision with root package name */
    public int f1464r;

    /* renamed from: s  reason: collision with root package name */
    public DataSetObserver f1465s;

    /* renamed from: t  reason: collision with root package name */
    public View f1466t;

    /* renamed from: u  reason: collision with root package name */
    public Drawable f1467u;

    /* renamed from: v  reason: collision with root package name */
    public AdapterView.OnItemClickListener f1468v;

    /* renamed from: w  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f1469w;

    /* renamed from: x  reason: collision with root package name */
    public final g f1470x;

    /* renamed from: y  reason: collision with root package name */
    public final f f1471y;

    /* renamed from: z  reason: collision with root package name */
    public final e f1472z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            View q10 = y1.this.q();
            if (q10 != null && q10.getWindowToken() != null) {
                y1.this.show();
            }
        }
    }

    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
            r1 r1Var;
            if (i10 != -1 && (r1Var = y1.this.f1449c) != null) {
                r1Var.setListSelectionHidden(false);
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            y1.this.o();
        }
    }

    public class d extends DataSetObserver {
        public d() {
        }

        public void onChanged() {
            if (y1.this.isShowing()) {
                y1.this.show();
            }
        }

        public void onInvalidated() {
            y1.this.dismiss();
        }
    }

    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 1 && !y1.this.t() && y1.this.G.getContentView() != null) {
                y1 y1Var = y1.this;
                y1Var.C.removeCallbacks(y1Var.f1470x);
                y1.this.f1470x.run();
            }
        }
    }

    public class f implements View.OnTouchListener {
        public f() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = y1.this.G) != null && popupWindow.isShowing() && x10 >= 0 && x10 < y1.this.G.getWidth() && y10 >= 0 && y10 < y1.this.G.getHeight()) {
                y1 y1Var = y1.this;
                y1Var.C.postDelayed(y1Var.f1470x, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                y1 y1Var2 = y1.this;
                y1Var2.C.removeCallbacks(y1Var2.f1470x);
                return false;
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            r1 r1Var = y1.this.f1449c;
            if (r1Var != null && c1.P(r1Var) && y1.this.f1449c.getCount() > y1.this.f1449c.getChildCount()) {
                int childCount = y1.this.f1449c.getChildCount();
                y1 y1Var = y1.this;
                if (childCount <= y1Var.f1462p) {
                    y1Var.G.setInputMethodMode(2);
                    y1.this.show();
                }
            }
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                H = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
            }
            try {
                J = cls.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                I = cls.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public y1(Context context) {
        this(context, (AttributeSet) null, R$attr.listPopupWindowStyle);
    }

    public void A(Rect rect) {
        Rect rect2;
        if (rect != null) {
            rect2 = new Rect(rect);
        } else {
            rect2 = null;
        }
        this.E = rect2;
    }

    public void B(int i10) {
        this.G.setInputMethodMode(i10);
    }

    public void C(boolean z10) {
        this.F = z10;
        this.G.setFocusable(z10);
    }

    public void D(PopupWindow.OnDismissListener onDismissListener) {
        this.G.setOnDismissListener(onDismissListener);
    }

    public void E(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1468v = onItemClickListener;
    }

    public void F(boolean z10) {
        this.f1458l = true;
        this.f1457k = z10;
    }

    public final void G(boolean z10) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = H;
            if (method != null) {
                try {
                    method.invoke(this.G, new Object[]{Boolean.valueOf(z10)});
                } catch (Exception unused) {
                }
            }
        } else {
            this.G.setIsClippedToScreen(z10);
        }
    }

    public void H(int i10) {
        this.f1464r = i10;
    }

    public void I(int i10) {
        r1 r1Var = this.f1449c;
        if (isShowing() && r1Var != null) {
            r1Var.setListSelectionHidden(false);
            r1Var.setSelection(i10);
            if (r1Var.getChoiceMode() != 0) {
                r1Var.setItemChecked(i10, true);
            }
        }
    }

    public void J(int i10) {
        this.f1451e = i10;
    }

    public int a() {
        return this.f1452f;
    }

    public void c(int i10) {
        this.f1452f = i10;
    }

    public void dismiss() {
        this.G.dismiss();
        v();
        this.G.setContentView((View) null);
        this.f1449c = null;
        this.C.removeCallbacks(this.f1470x);
    }

    public Drawable e() {
        return this.G.getBackground();
    }

    public void g(int i10) {
        this.f1453g = i10;
        this.f1455i = true;
    }

    public boolean isShowing() {
        return this.G.isShowing();
    }

    public int j() {
        if (!this.f1455i) {
            return 0;
        }
        return this.f1453g;
    }

    public void k(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1465s;
        if (dataSetObserver == null) {
            this.f1465s = new d();
        } else {
            ListAdapter listAdapter2 = this.f1448b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1448b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1465s);
        }
        r1 r1Var = this.f1449c;
        if (r1Var != null) {
            r1Var.setAdapter(this.f1448b);
        }
    }

    public ListView m() {
        return this.f1449c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.r1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.r1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.r1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int n() {
        /*
            r12 = this;
            androidx.appcompat.widget.r1 r0 = r12.f1449c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00bf
            android.content.Context r0 = r12.f1447a
            androidx.appcompat.widget.y1$a r5 = new androidx.appcompat.widget.y1$a
            r5.<init>()
            r12.B = r5
            boolean r5 = r12.F
            r5 = r5 ^ r3
            androidx.appcompat.widget.r1 r5 = r12.p(r0, r5)
            r12.f1449c = r5
            android.graphics.drawable.Drawable r6 = r12.f1467u
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.r1 r5 = r12.f1449c
            android.widget.ListAdapter r6 = r12.f1448b
            r5.setAdapter(r6)
            androidx.appcompat.widget.r1 r5 = r12.f1449c
            android.widget.AdapterView$OnItemClickListener r6 = r12.f1468v
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.r1 r5 = r12.f1449c
            r5.setFocusable(r3)
            androidx.appcompat.widget.r1 r5 = r12.f1449c
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.r1 r5 = r12.f1449c
            androidx.appcompat.widget.y1$b r6 = new androidx.appcompat.widget.y1$b
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.r1 r5 = r12.f1449c
            androidx.appcompat.widget.y1$e r6 = r12.f1472z
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.f1469w
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.r1 r6 = r12.f1449c
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.r1 r5 = r12.f1449c
            android.view.View r6 = r12.f1463q
            if (r6 == 0) goto L_0x00b8
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f1464r
            if (r8 == 0) goto L_0x008f
            if (r8 == r3) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.f1464r
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0095
        L_0x0088:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0095
        L_0x008f:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0095:
            int r0 = r12.f1451e
            if (r0 < 0) goto L_0x009c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x009e
        L_0x009c:
            r0 = 0
            r5 = 0
        L_0x009e:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b9
        L_0x00b8:
            r0 = 0
        L_0x00b9:
            android.widget.PopupWindow r6 = r12.G
            r6.setContentView(r5)
            goto L_0x00dd
        L_0x00bf:
            android.widget.PopupWindow r0 = r12.G
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f1463q
            if (r0 == 0) goto L_0x00dc
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00dd
        L_0x00dc:
            r0 = 0
        L_0x00dd:
            android.widget.PopupWindow r5 = r12.G
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f9
            android.graphics.Rect r6 = r12.D
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.D
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.f1455i
            if (r7 != 0) goto L_0x00ff
            int r6 = -r6
            r12.f1453g = r6
            goto L_0x00ff
        L_0x00f9:
            android.graphics.Rect r5 = r12.D
            r5.setEmpty()
            r5 = 0
        L_0x00ff:
            android.widget.PopupWindow r6 = r12.G
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0109
            goto L_0x010a
        L_0x0109:
            r3 = 0
        L_0x010a:
            android.view.View r4 = r12.q()
            int r6 = r12.f1453g
            int r3 = r12.r(r4, r6, r3)
            boolean r4 = r12.f1460n
            if (r4 != 0) goto L_0x017b
            int r4 = r12.f1450d
            if (r4 != r2) goto L_0x011d
            goto L_0x017b
        L_0x011d:
            int r4 = r12.f1451e
            r6 = -2
            if (r4 == r6) goto L_0x0144
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x012b
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x015c
        L_0x012b:
            android.content.Context r2 = r12.f1447a
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.D
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x015c
        L_0x0144:
            android.content.Context r2 = r12.f1447a
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.D
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x015c:
            r7 = r1
            androidx.appcompat.widget.r1 r6 = r12.f1449c
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.d(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0179
            androidx.appcompat.widget.r1 r2 = r12.f1449c
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.r1 r3 = r12.f1449c
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0179:
            int r1 = r1 + r0
            return r1
        L_0x017b:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y1.n():int");
    }

    public void o() {
        r1 r1Var = this.f1449c;
        if (r1Var != null) {
            r1Var.setListSelectionHidden(true);
            r1Var.requestLayout();
        }
    }

    public r1 p(Context context, boolean z10) {
        return new r1(context, z10);
    }

    public View q() {
        return this.f1466t;
    }

    public final int r(View view, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.G.getMaxAvailableHeight(view, i10, z10);
        }
        Method method = I;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.G, new Object[]{view, Integer.valueOf(i10), Boolean.valueOf(z10)})).intValue();
            } catch (Exception unused) {
            }
        }
        return this.G.getMaxAvailableHeight(view, i10);
    }

    public int s() {
        return this.f1451e;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    public void show() {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        int n10 = n();
        boolean t10 = t();
        t.b(this.G, this.f1454h);
        boolean z11 = true;
        if (!this.G.isShowing()) {
            int i14 = this.f1451e;
            if (i14 == -1) {
                i14 = -1;
            } else if (i14 == -2) {
                i14 = q().getWidth();
            }
            int i15 = this.f1450d;
            if (i15 == -1) {
                n10 = -1;
            } else if (i15 != -2) {
                n10 = i15;
            }
            this.G.setWidth(i14);
            this.G.setHeight(n10);
            G(true);
            PopupWindow popupWindow = this.G;
            if (this.f1461o || this.f1460n) {
                z10 = false;
            } else {
                z10 = true;
            }
            popupWindow.setOutsideTouchable(z10);
            this.G.setTouchInterceptor(this.f1471y);
            if (this.f1458l) {
                t.a(this.G, this.f1457k);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = J;
                if (method != null) {
                    try {
                        method.invoke(this.G, new Object[]{this.E});
                    } catch (Exception e10) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e10);
                    }
                }
            } else {
                this.G.setEpicenterBounds(this.E);
            }
            t.c(this.G, q(), this.f1452f, this.f1453g, this.f1459m);
            this.f1449c.setSelection(-1);
            if (!this.F || this.f1449c.isInTouchMode()) {
                o();
            }
            if (!this.F) {
                this.C.post(this.A);
            }
        } else if (c1.P(q())) {
            int i16 = this.f1451e;
            if (i16 == -1) {
                i16 = -1;
            } else if (i16 == -2) {
                i16 = q().getWidth();
            }
            int i17 = this.f1450d;
            if (i17 == -1) {
                if (!t10) {
                    n10 = -1;
                }
                if (t10) {
                    PopupWindow popupWindow2 = this.G;
                    if (this.f1451e == -1) {
                        i13 = -1;
                    } else {
                        i13 = 0;
                    }
                    popupWindow2.setWidth(i13);
                    this.G.setHeight(0);
                } else {
                    PopupWindow popupWindow3 = this.G;
                    if (this.f1451e == -1) {
                        i12 = -1;
                    } else {
                        i12 = 0;
                    }
                    popupWindow3.setWidth(i12);
                    this.G.setHeight(-1);
                }
            } else if (i17 != -2) {
                n10 = i17;
            }
            PopupWindow popupWindow4 = this.G;
            if (this.f1461o || this.f1460n) {
                z11 = false;
            }
            popupWindow4.setOutsideTouchable(z11);
            PopupWindow popupWindow5 = this.G;
            View q10 = q();
            int i18 = this.f1452f;
            int i19 = this.f1453g;
            if (i16 < 0) {
                i10 = -1;
            } else {
                i10 = i16;
            }
            if (n10 < 0) {
                i11 = -1;
            } else {
                i11 = n10;
            }
            popupWindow5.update(q10, i18, i19, i10, i11);
        }
    }

    public boolean t() {
        if (this.G.getInputMethodMode() == 2) {
            return true;
        }
        return false;
    }

    public boolean u() {
        return this.F;
    }

    public final void v() {
        View view = this.f1463q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1463q);
            }
        }
    }

    public void w(View view) {
        this.f1466t = view;
    }

    public void x(int i10) {
        this.G.setAnimationStyle(i10);
    }

    public void y(int i10) {
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            this.f1451e = rect.left + rect.right + i10;
            return;
        }
        J(i10);
    }

    public void z(int i10) {
        this.f1459m = i10;
    }

    public y1(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public y1(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f1450d = -2;
        this.f1451e = -2;
        this.f1454h = 1002;
        this.f1456j = true;
        this.f1459m = 0;
        this.f1460n = false;
        this.f1461o = false;
        this.f1462p = Integer.MAX_VALUE;
        this.f1464r = 0;
        this.f1470x = new g();
        this.f1471y = new f();
        this.f1472z = new e();
        this.A = new c();
        this.D = new Rect();
        this.f1447a = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f565z, i10, i11);
        this.f1452f = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1453g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1455i = true;
        }
        obtainStyledAttributes.recycle();
        s sVar = new s(context, attributeSet, i10, i11);
        this.G = sVar;
        sVar.setInputMethodMode(1);
    }
}
