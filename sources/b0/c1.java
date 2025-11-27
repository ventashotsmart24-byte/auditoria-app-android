package b0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.app.m;
import androidx.core.R$id;
import b0.a;
import b0.f2;
import c0.g0;
import c0.l0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c1 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f4046a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    public static WeakHashMap f4047b;

    /* renamed from: c  reason: collision with root package name */
    public static WeakHashMap f4048c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Field f4049d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f4050e = false;

    /* renamed from: f  reason: collision with root package name */
    public static ThreadLocal f4051f;

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f4052g = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};

    /* renamed from: h  reason: collision with root package name */
    public static final c0 f4053h = new a();

    /* renamed from: i  reason: collision with root package name */
    public static f f4054i = new f();

    public class a implements c0 {
    }

    public class b extends g {
        public b(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        /* renamed from: j */
        public void e(View view, Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }

        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public class c extends g {
        public c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* renamed from: i */
        public CharSequence d(View view) {
            return view.getAccessibilityPaneTitle();
        }

        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class d extends g {
        public d(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* renamed from: i */
        public CharSequence d(View view) {
            return view.getStateDescription();
        }

        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class e extends g {
        public e(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        /* renamed from: j */
        public void e(View view, Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }

        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public static class f implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakHashMap f4055a = new WeakHashMap();

        public final void a(View view, boolean z10) {
            boolean z11;
            int i10;
            if (view.getVisibility() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 != z11) {
                if (z11) {
                    i10 = 16;
                } else {
                    i10 = 32;
                }
                c1.U(view, i10);
                this.f4055a.put(view, Boolean.valueOf(z11));
            }
        }

        public final void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry entry : this.f4055a.entrySet()) {
                    a((View) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static abstract class g {

        /* renamed from: a  reason: collision with root package name */
        public final int f4056a;

        /* renamed from: b  reason: collision with root package name */
        public final Class f4057b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4058c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4059d;

        public g(int i10, Class cls, int i11) {
            this(i10, cls, 0, i11);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            boolean z10;
            boolean z11;
            if (bool == null) {
                z10 = false;
            } else {
                z10 = bool.booleanValue();
            }
            if (bool2 == null) {
                z11 = false;
            } else {
                z11 = bool2.booleanValue();
            }
            if (z10 == z11) {
                return true;
            }
            return false;
        }

        public final boolean b() {
            return true;
        }

        public final boolean c() {
            if (Build.VERSION.SDK_INT >= this.f4058c) {
                return true;
            }
            return false;
        }

        public abstract Object d(View view);

        public abstract void e(View view, Object obj);

        public Object f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            Object tag = view.getTag(this.f4056a);
            if (this.f4057b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void g(View view, Object obj) {
            if (c()) {
                e(view, obj);
            } else if (b() && h(f(view), obj)) {
                c1.C(view);
                view.setTag(this.f4056a, obj);
                c1.U(view, this.f4059d);
            }
        }

        public abstract boolean h(Object obj, Object obj2);

        public g(int i10, Class cls, int i11, int i12) {
            this.f4056a = i10;
            this.f4057b = cls;
            this.f4059d = i11;
            this.f4058c = i12;
        }
    }

    public static class h {

        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            public f2 f4060a = null;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f4061b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b0 f4062c;

            public a(View view, b0 b0Var) {
                this.f4061b = view;
                this.f4062c = b0Var;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                f2 u10 = f2.u(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    h.a(windowInsets, this.f4061b);
                    if (u10.equals(this.f4060a)) {
                        return this.f4062c.onApplyWindowInsets(view, u10).s();
                    }
                }
                this.f4060a = u10;
                f2 onApplyWindowInsets = this.f4062c.onApplyWindowInsets(view, u10);
                if (i10 >= 30) {
                    return onApplyWindowInsets.s();
                }
                c1.h0(view);
                return onApplyWindowInsets.s();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static f2 b(View view) {
            return f2.a.a(view);
        }

        public static void c(View view, b0 b0Var) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.tag_on_apply_window_listener, b0Var);
            }
            if (b0Var == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, b0Var));
            }
        }
    }

    public static class i {
        public static f2 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            f2 t10 = f2.t(rootWindowInsets);
            t10.q(t10);
            t10.d(view.getRootView());
            return t10;
        }
    }

    public static class j {
        public static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    public static class k {

        /* renamed from: d  reason: collision with root package name */
        public static final ArrayList f4063d = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        public WeakHashMap f4064a = null;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray f4065b = null;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference f4066c = null;

        public static k a(View view) {
            int i10 = R$id.tag_unhandled_key_event_manager;
            k kVar = (k) view.getTag(i10);
            if (kVar != null) {
                return kVar;
            }
            k kVar2 = new k();
            view.setTag(i10, kVar2);
            return kVar2;
        }

        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c10 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c10 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c10));
                }
            }
            if (c10 != null) {
                return true;
            }
            return false;
        }

        public final View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f4064a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c10 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c10 != null) {
                            return c10;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final SparseArray d() {
            if (this.f4065b == null) {
                this.f4065b = new SparseArray();
            }
            return this.f4065b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            m.a(arrayList.get(size));
            throw null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.ref.WeakReference} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean f(android.view.KeyEvent r6) {
            /*
                r5 = this;
                java.lang.ref.WeakReference r0 = r5.f4066c
                r1 = 0
                if (r0 == 0) goto L_0x000c
                java.lang.Object r0 = r0.get()
                if (r0 != r6) goto L_0x000c
                return r1
            L_0x000c:
                java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
                r0.<init>(r6)
                r5.f4066c = r0
                android.util.SparseArray r0 = r5.d()
                int r2 = r6.getAction()
                r3 = 1
                if (r2 != r3) goto L_0x0032
                int r2 = r6.getKeyCode()
                int r2 = r0.indexOfKey(r2)
                if (r2 < 0) goto L_0x0032
                java.lang.Object r4 = r0.valueAt(r2)
                java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4
                r0.removeAt(r2)
                goto L_0x0033
            L_0x0032:
                r4 = 0
            L_0x0033:
                if (r4 != 0) goto L_0x0040
                int r2 = r6.getKeyCode()
                java.lang.Object r0 = r0.get(r2)
                r4 = r0
                java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4
            L_0x0040:
                if (r4 == 0) goto L_0x0054
                java.lang.Object r0 = r4.get()
                android.view.View r0 = (android.view.View) r0
                if (r0 == 0) goto L_0x0053
                boolean r1 = b0.c1.P(r0)
                if (r1 == 0) goto L_0x0053
                r5.e(r0, r6)
            L_0x0053:
                return r3
            L_0x0054:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b0.c1.k.f(android.view.KeyEvent):boolean");
        }

        public final void g() {
            WeakHashMap weakHashMap = this.f4064a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f4063d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f4064a == null) {
                        this.f4064a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f4063d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f4064a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f4064a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
    }

    public static int A(View view) {
        return view.getMinimumHeight();
    }

    public static void A0(View view, float f10) {
        view.setPivotX(f10);
    }

    public static int B(View view) {
        return view.getMinimumWidth();
    }

    public static void B0(View view, float f10) {
        view.setPivotY(f10);
    }

    public static a C(View view) {
        a k10 = k(view);
        if (k10 == null) {
            k10 = new a();
        }
        k0(view, k10);
        return k10;
    }

    public static void C0(View view, f0 f0Var) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (f0Var != null) {
                obj = f0Var.a();
            } else {
                obj = null;
            }
            view.setPointerIcon(o0.a(obj));
        }
    }

    public static int D(View view) {
        return view.getOverScrollMode();
    }

    public static void D0(View view, float f10) {
        view.setRotation(f10);
    }

    public static int E(View view) {
        return view.getPaddingEnd();
    }

    public static void E0(View view, float f10) {
        view.setRotationX(f10);
    }

    public static int F(View view) {
        return view.getPaddingStart();
    }

    public static void F0(View view, float f10) {
        view.setRotationY(f10);
    }

    public static f2 G(View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            return i.a(view);
        }
        if (i10 >= 21) {
            return h.b(view);
        }
        return null;
    }

    public static void G0(View view, float f10) {
        view.setScaleX(f10);
    }

    public static final CharSequence H(View view) {
        return (CharSequence) N0().f(view);
    }

    public static void H0(View view, float f10) {
        view.setScaleY(f10);
    }

    public static String I(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap weakHashMap = f4047b;
        if (weakHashMap == null) {
            return null;
        }
        return (String) weakHashMap.get(view);
    }

    public static void I0(View view, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i10, i11);
        }
    }

    public static int J(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void J0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f4047b == null) {
            f4047b = new WeakHashMap();
        }
        f4047b.put(view, str);
    }

    public static float K(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void K0(View view, float f10) {
        view.setTranslationX(f10);
    }

    public static boolean L(View view) {
        return view.hasOnClickListeners();
    }

    public static void L0(View view, float f10) {
        view.setTranslationY(f10);
    }

    public static boolean M(View view) {
        return view.hasOverlappingRendering();
    }

    public static void M0(View view) {
        if (x(view) == 0) {
            v0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (x((View) parent) == 4) {
                v0(view, 2);
                return;
            }
        }
    }

    public static boolean N(View view) {
        return view.hasTransientState();
    }

    public static g N0() {
        return new d(R$id.tag_state_description, CharSequence.class, 64, 30);
    }

    public static boolean O(View view) {
        Boolean bool = (Boolean) a().f(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void O0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof v) {
            ((v) view).stopNestedScroll();
        }
    }

    public static boolean P(View view) {
        return view.isAttachedToWindow();
    }

    public static void P0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static boolean Q(View view) {
        return view.isLaidOut();
    }

    public static boolean R(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof v) {
            return ((v) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean S(View view) {
        return view.isPaddingRelative();
    }

    public static boolean T(View view) {
        Boolean bool = (Boolean) j0().f(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void U(View view, int i10) {
        boolean z10;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            if (o(view) == null || view.getVisibility() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            int i11 = 32;
            if (n(view) != 0 || z10) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z10) {
                    i11 = 2048;
                }
                obtain.setEventType(i11);
                obtain.setContentChangeTypes(i10);
                if (z10) {
                    obtain.getText().add(o(view));
                    M0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i10 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i10);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(o(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                }
            }
        }
    }

    public static void V(View view, int i10) {
        boolean z10;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            view.offsetLeftAndRight(i10);
        } else if (i11 >= 21) {
            Rect v10 = v();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                v10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z10 = !v10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z10 = false;
            }
            e(view, i10);
            if (z10 && v10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(v10);
            }
        } else {
            e(view, i10);
        }
    }

    public static void W(View view, int i10) {
        boolean z10;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            view.offsetTopAndBottom(i10);
        } else if (i11 >= 21) {
            Rect v10 = v();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                v10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z10 = !v10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z10 = false;
            }
            f(view, i10);
            if (z10 && v10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(v10);
            }
        } else {
            f(view, i10);
        }
    }

    public static f2 X(View view, f2 f2Var) {
        WindowInsets s10;
        if (Build.VERSION.SDK_INT >= 21 && (s10 = f2Var.s()) != null) {
            WindowInsets a10 = view.onApplyWindowInsets(s10);
            if (!a10.equals(s10)) {
                return f2.u(a10, view);
            }
        }
        return f2Var;
    }

    public static void Y(View view, g0 g0Var) {
        view.onInitializeAccessibilityNodeInfo(g0Var.u0());
    }

    public static g Z() {
        return new c(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static g a() {
        return new e(R$id.tag_accessibility_heading, Boolean.class, 28);
    }

    public static boolean a0(View view, int i10, Bundle bundle) {
        return view.performAccessibilityAction(i10, bundle);
    }

    public static void b(View view, g0.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            C(view);
            f0(aVar.b(), view);
            p(view).add(aVar);
            U(view, 0);
        }
    }

    public static void b0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static a2 c(View view) {
        if (f4048c == null) {
            f4048c = new WeakHashMap();
        }
        a2 a2Var = (a2) f4048c.get(view);
        if (a2Var != null) {
            return a2Var;
        }
        a2 a2Var2 = new a2(view);
        f4048c.put(view, a2Var2);
        return a2Var2;
    }

    public static void c0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static boolean d(View view, int i10) {
        return view.canScrollVertically(i10);
    }

    public static void d0(View view, Runnable runnable, long j10) {
        view.postOnAnimationDelayed(runnable, j10);
    }

    public static void e(View view, int i10) {
        view.offsetLeftAndRight(i10);
        if (view.getVisibility() == 0) {
            P0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                P0((View) parent);
            }
        }
    }

    public static void e0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            f0(i10, view);
            U(view, 0);
        }
    }

    public static void f(View view, int i10) {
        view.offsetTopAndBottom(i10);
        if (view.getVisibility() == 0) {
            P0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                P0((View) parent);
            }
        }
    }

    public static void f0(int i10, View view) {
        List p10 = p(view);
        for (int i11 = 0; i11 < p10.size(); i11++) {
            if (((g0.a) p10.get(i11)).b() == i10) {
                p10.remove(i11);
                return;
            }
        }
    }

    public static f2 g(View view, f2 f2Var) {
        WindowInsets s10;
        if (Build.VERSION.SDK_INT >= 21 && (s10 = f2Var.s()) != null) {
            WindowInsets a10 = view.dispatchApplyWindowInsets(s10);
            if (!a10.equals(s10)) {
                return f2.u(a10, view);
            }
        }
        return f2Var;
    }

    public static void g0(View view, g0.a aVar, CharSequence charSequence, l0 l0Var) {
        if (l0Var == null && charSequence == null) {
            e0(view, aVar.b());
        } else {
            b(view, aVar.a(charSequence, l0Var));
        }
    }

    public static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return k.a(view).b(view, keyEvent);
    }

    public static void h0(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else {
            view.requestFitSystemWindows();
        }
    }

    public static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return k.a(view).f(keyEvent);
    }

    public static void i0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            j.a(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    public static int j() {
        return View.generateViewId();
    }

    public static g j0() {
        return new b(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static a k(View view) {
        View.AccessibilityDelegate l10 = l(view);
        if (l10 == null) {
            return null;
        }
        if (l10 instanceof a.C0065a) {
            return ((a.C0065a) l10).f4030a;
        }
        return new a(l10);
    }

    public static void k0(View view, a aVar) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (aVar == null && (l(view) instanceof a.C0065a)) {
            aVar = new a();
        }
        if (aVar == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = aVar.getBridge();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    public static View.AccessibilityDelegate l(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return m(view);
    }

    public static void l0(View view, boolean z10) {
        a().g(view, Boolean.valueOf(z10));
    }

    public static View.AccessibilityDelegate m(View view) {
        if (f4050e) {
            return null;
        }
        if (f4049d == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f4049d = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f4050e = true;
                return null;
            }
        }
        try {
            Object obj = f4049d.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f4050e = true;
            return null;
        }
    }

    public static void m0(View view, int i10) {
        view.setAccessibilityLiveRegion(i10);
    }

    public static int n(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static void n0(View view, float f10) {
        view.setAlpha(f10);
    }

    public static CharSequence o(View view) {
        return (CharSequence) Z().f(view);
    }

    public static void o0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static List p(View view) {
        int i10 = R$id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i10, arrayList2);
        return arrayList2;
    }

    public static void p0(View view, ColorStateList colorStateList) {
        boolean z10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (i10 == 21) {
                Drawable background = view.getBackground();
                if (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (background != null && z10) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof g0) {
            ((g0) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static ColorStateList q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof g0) {
            return ((g0) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void q0(View view, PorterDuff.Mode mode) {
        boolean z10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            view.setBackgroundTintMode(mode);
            if (i10 == 21) {
                Drawable background = view.getBackground();
                if (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (background != null && z10) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof g0) {
            ((g0) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static PorterDuff.Mode r(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof g0) {
            return ((g0) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void r0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static Rect s(View view) {
        return view.getClipBounds();
    }

    public static void s0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f10);
        }
    }

    public static Display t(View view) {
        return view.getDisplay();
    }

    public static void t0(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    public static float u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void u0(View view, boolean z10) {
        view.setHasTransientState(z10);
    }

    public static Rect v() {
        if (f4051f == null) {
            f4051f = new ThreadLocal();
        }
        Rect rect = (Rect) f4051f.get();
        if (rect == null) {
            rect = new Rect();
            f4051f.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void v0(View view, int i10) {
        view.setImportantForAccessibility(i10);
    }

    public static boolean w(View view) {
        return view.getFitsSystemWindows();
    }

    public static void w0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i10);
        }
    }

    public static int x(View view) {
        return view.getImportantForAccessibility();
    }

    public static void x0(View view, int i10, Paint paint) {
        view.setLayerType(i10, paint);
    }

    public static int y(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void y0(View view, b0 b0Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.c(view, b0Var);
        }
    }

    public static int z(View view) {
        return view.getLayoutDirection();
    }

    public static void z0(View view, int i10, int i11, int i12, int i13) {
        view.setPaddingRelative(i10, i11, i12, i13);
    }
}
