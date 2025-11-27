package c0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.app.m;
import androidx.core.R$id;
import c0.l0;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import com.uc.crashsdk.export.LogType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class g0 {

    /* renamed from: d  reason: collision with root package name */
    public static int f4540d;

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityNodeInfo f4541a;

    /* renamed from: b  reason: collision with root package name */
    public int f4542b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f4543c = -1;

    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;

        /* renamed from: e  reason: collision with root package name */
        public static final a f4544e = new a(1, (CharSequence) null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f4545f = new a(2, (CharSequence) null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f4546g = new a(4, (CharSequence) null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f4547h = new a(8, (CharSequence) null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f4548i = new a(16, (CharSequence) null);

        /* renamed from: j  reason: collision with root package name */
        public static final a f4549j = new a(32, (CharSequence) null);

        /* renamed from: k  reason: collision with root package name */
        public static final a f4550k = new a(64, (CharSequence) null);

        /* renamed from: l  reason: collision with root package name */
        public static final a f4551l = new a(128, (CharSequence) null);

        /* renamed from: m  reason: collision with root package name */
        public static final a f4552m;

        /* renamed from: n  reason: collision with root package name */
        public static final a f4553n;

        /* renamed from: o  reason: collision with root package name */
        public static final a f4554o;

        /* renamed from: p  reason: collision with root package name */
        public static final a f4555p;

        /* renamed from: q  reason: collision with root package name */
        public static final a f4556q = new a(4096, (CharSequence) null);

        /* renamed from: r  reason: collision with root package name */
        public static final a f4557r = new a(8192, (CharSequence) null);

        /* renamed from: s  reason: collision with root package name */
        public static final a f4558s = new a(16384, (CharSequence) null);

        /* renamed from: t  reason: collision with root package name */
        public static final a f4559t = new a(32768, (CharSequence) null);

        /* renamed from: u  reason: collision with root package name */
        public static final a f4560u = new a(65536, (CharSequence) null);

        /* renamed from: v  reason: collision with root package name */
        public static final a f4561v = new a(131072, (CharSequence) null, l0.g.class);

        /* renamed from: w  reason: collision with root package name */
        public static final a f4562w = new a(262144, (CharSequence) null);

        /* renamed from: x  reason: collision with root package name */
        public static final a f4563x = new a(524288, (CharSequence) null);

        /* renamed from: y  reason: collision with root package name */
        public static final a f4564y = new a(LogType.ANR, (CharSequence) null);

        /* renamed from: z  reason: collision with root package name */
        public static final a f4565z = new a(AutoStrategy.BITRATE_LOW4, (CharSequence) null, l0.h.class);

        /* renamed from: a  reason: collision with root package name */
        public final Object f4566a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4567b;

        /* renamed from: c  reason: collision with root package name */
        public final Class f4568c;

        /* renamed from: d  reason: collision with root package name */
        public final l0 f4569d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17 = null;
            Class<l0.b> cls = l0.b.class;
            f4552m = new a(256, (CharSequence) null, cls);
            f4553n = new a(512, (CharSequence) null, cls);
            Class<l0.c> cls2 = l0.c.class;
            f4554o = new a(1024, (CharSequence) null, cls2);
            f4555p = new a(2048, (CharSequence) null, cls2);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            } else {
                accessibilityAction = null;
            }
            A = new a(accessibilityAction, 16908342, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 23) {
                accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
            } else {
                accessibilityAction2 = null;
            }
            B = new a(accessibilityAction2, 16908343, (CharSequence) null, (l0) null, l0.e.class);
            if (i10 >= 23) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
            } else {
                accessibilityAction3 = null;
            }
            C = new a(accessibilityAction3, 16908344, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 23) {
                accessibilityAction4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
            } else {
                accessibilityAction4 = null;
            }
            D = new a(accessibilityAction4, 16908345, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 23) {
                accessibilityAction5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
            } else {
                accessibilityAction5 = null;
            }
            E = new a(accessibilityAction5, 16908346, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 23) {
                accessibilityAction6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
            } else {
                accessibilityAction6 = null;
            }
            F = new a(accessibilityAction6, 16908347, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 29) {
                accessibilityAction7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            } else {
                accessibilityAction7 = null;
            }
            G = new a(accessibilityAction7, 16908358, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 29) {
                accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            } else {
                accessibilityAction8 = null;
            }
            H = new a(accessibilityAction8, 16908359, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 29) {
                accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
            } else {
                accessibilityAction9 = null;
            }
            I = new a(accessibilityAction9, 16908360, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 29) {
                accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            } else {
                accessibilityAction10 = null;
            }
            J = new a(accessibilityAction10, 16908361, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 23) {
                accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            } else {
                accessibilityAction11 = null;
            }
            K = new a(accessibilityAction11, 16908348, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 24) {
                accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            } else {
                accessibilityAction12 = null;
            }
            L = new a(accessibilityAction12, 16908349, (CharSequence) null, (l0) null, l0.f.class);
            if (i10 >= 26) {
                accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            } else {
                accessibilityAction13 = null;
            }
            M = new a(accessibilityAction13, 16908354, (CharSequence) null, (l0) null, l0.d.class);
            if (i10 >= 28) {
                accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            } else {
                accessibilityAction14 = null;
            }
            N = new a(accessibilityAction14, 16908356, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 28) {
                accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            } else {
                accessibilityAction15 = null;
            }
            O = new a(accessibilityAction15, 16908357, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 30) {
                accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
            } else {
                accessibilityAction16 = null;
            }
            P = new a(accessibilityAction16, 16908362, (CharSequence) null, (l0) null, (Class) null);
            if (i10 >= 30) {
                accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            }
            Q = new a(accessibilityAction17, 16908372, (CharSequence) null, (l0) null, (Class) null);
        }

        public a(int i10, CharSequence charSequence) {
            this((Object) null, i10, charSequence, (l0) null, (Class) null);
        }

        public a a(CharSequence charSequence, l0 l0Var) {
            return new a((Object) null, this.f4567b, charSequence, l0Var, this.f4568c);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return i.a(this.f4566a).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return i.a(this.f4566a).getLabel();
            }
            return null;
        }

        public boolean d(View view, Bundle bundle) {
            String str;
            if (this.f4569d == null) {
                return false;
            }
            Class cls = this.f4568c;
            if (cls != null) {
                try {
                    m.a(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    throw null;
                } catch (Exception e10) {
                    Class cls2 = this.f4568c;
                    if (cls2 == null) {
                        str = "null";
                    } else {
                        str = cls2.getName();
                    }
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + str, e10);
                }
            }
            return this.f4569d.perform(view, (l0.a) null);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f4566a;
            if (obj2 == null) {
                if (aVar.f4566a != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(aVar.f4566a)) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            Object obj = this.f4566a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(Object obj) {
            this(obj, 0, (CharSequence) null, (l0) null, (Class) null);
        }

        public a(int i10, CharSequence charSequence, Class cls) {
            this((Object) null, i10, charSequence, (l0) null, cls);
        }

        public a(Object obj, int i10, CharSequence charSequence, l0 l0Var, Class cls) {
            this.f4567b = i10;
            this.f4569d = l0Var;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.f4566a = obj;
            } else {
                this.f4566a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            }
            this.f4568c = cls;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Object f4570a;

        public b(Object obj) {
            this.f4570a = obj;
        }

        public static b a(int i10, int i11, boolean z10) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
        }

        public static b b(int i10, int i11, boolean z10, int i12) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
            }
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Object f4571a;

        public c(Object obj) {
            this.f4571a = obj;
        }

        public static c a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
            }
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10));
        }
    }

    public g0(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f4541a = accessibilityNodeInfo;
    }

    public static g0 K() {
        return v0(AccessibilityNodeInfo.obtain());
    }

    public static g0 L(View view) {
        return v0(AccessibilityNodeInfo.obtain(view));
    }

    public static g0 M(g0 g0Var) {
        return v0(AccessibilityNodeInfo.obtain(g0Var.f4541a));
    }

    public static String i(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case AutoStrategy.BITRATE_LOW4 /*2097152*/:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908372:
                return "ACTION_IME_ENTER";
            default:
                switch (i10) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static g0 v0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new g0(accessibilityNodeInfo);
    }

    public boolean A() {
        return this.f4541a.isChecked();
    }

    public boolean B() {
        return this.f4541a.isClickable();
    }

    public boolean C() {
        return this.f4541a.isEnabled();
    }

    public boolean D() {
        return this.f4541a.isFocusable();
    }

    public boolean E() {
        return this.f4541a.isFocused();
    }

    public boolean F() {
        return this.f4541a.isLongClickable();
    }

    public boolean G() {
        return this.f4541a.isPassword();
    }

    public boolean H() {
        return this.f4541a.isScrollable();
    }

    public boolean I() {
        return this.f4541a.isSelected();
    }

    public boolean J() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f4541a.isShowingHintText();
        }
        return k(4);
    }

    public boolean N(int i10, Bundle bundle) {
        return this.f4541a.performAction(i10, bundle);
    }

    public void O() {
        this.f4541a.recycle();
    }

    public final void P(View view) {
        SparseArray u10 = u(view);
        if (u10 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < u10.size(); i10++) {
                if (((WeakReference) u10.valueAt(i10)).get() == null) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                u10.remove(((Integer) arrayList.get(i11)).intValue());
            }
        }
    }

    public void Q(boolean z10) {
        this.f4541a.setAccessibilityFocused(z10);
    }

    public final void R(int i10, boolean z10) {
        Bundle r10 = r();
        if (r10 != null) {
            int i11 = r10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i10 ^ -1);
            if (!z10) {
                i10 = 0;
            }
            r10.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    public void S(Rect rect) {
        this.f4541a.setBoundsInParent(rect);
    }

    public void T(Rect rect) {
        this.f4541a.setBoundsInScreen(rect);
    }

    public void U(boolean z10) {
        this.f4541a.setCheckable(z10);
    }

    public void V(boolean z10) {
        this.f4541a.setChecked(z10);
    }

    public void W(CharSequence charSequence) {
        this.f4541a.setClassName(charSequence);
    }

    public void X(boolean z10) {
        this.f4541a.setClickable(z10);
    }

    public void Y(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4541a;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f4570a;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public void Z(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4541a;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f4571a;
        }
        accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    }

    public void a(int i10) {
        this.f4541a.addAction(i10);
    }

    public void a0(CharSequence charSequence) {
        this.f4541a.setContentDescription(charSequence);
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4541a.addAction(i.a(aVar.f4566a));
        }
    }

    public void b0(boolean z10) {
        this.f4541a.setContentInvalid(z10);
    }

    public void c(View view, int i10) {
        this.f4541a.addChild(view, i10);
    }

    public void c0(boolean z10) {
        this.f4541a.setDismissable(z10);
    }

    public final void d(ClickableSpan clickableSpan, Spanned spanned, int i10) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i10));
    }

    public void d0(boolean z10) {
        this.f4541a.setEnabled(z10);
    }

    public void e(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            f();
            P(view);
            ClickableSpan[] p10 = p(charSequence);
            if (p10 != null && p10.length > 0) {
                r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
                SparseArray s10 = s(view);
                for (int i10 = 0; i10 < p10.length; i10++) {
                    int y10 = y(p10[i10], s10);
                    s10.put(y10, new WeakReference(p10[i10]));
                    d(p10[i10], (Spanned) charSequence, y10);
                }
            }
        }
    }

    public void e0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4541a.setError(charSequence);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4541a;
        if (accessibilityNodeInfo == null) {
            if (g0Var.f4541a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(g0Var.f4541a)) {
            return false;
        }
        if (this.f4543c == g0Var.f4543c && this.f4542b == g0Var.f4542b) {
            return true;
        }
        return false;
    }

    public final void f() {
        this.f4541a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f4541a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f4541a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f4541a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    public void f0(boolean z10) {
        this.f4541a.setFocusable(z10);
    }

    public final List g(String str) {
        ArrayList<Integer> integerArrayList = this.f4541a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f4541a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void g0(boolean z10) {
        this.f4541a.setFocused(z10);
    }

    public List h() {
        List list;
        if (Build.VERSION.SDK_INT >= 21) {
            list = this.f4541a.getActionList();
        } else {
            list = null;
        }
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(list.get(i10)));
        }
        return arrayList;
    }

    public void h0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4541a.setHeading(z10);
        } else {
            R(2, z10);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4541a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4541a.setHintText(charSequence);
        } else {
            this.f4541a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public int j() {
        return this.f4541a.getActions();
    }

    public void j0(CharSequence charSequence) {
        this.f4541a.setPackageName(charSequence);
    }

    public final boolean k(int i10) {
        Bundle r10 = r();
        if (r10 != null && (r10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) == i10) {
            return true;
        }
        return false;
    }

    public void k0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4541a.setPaneTitle(charSequence);
        } else {
            this.f4541a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void l(Rect rect) {
        this.f4541a.getBoundsInParent(rect);
    }

    public void l0(View view) {
        this.f4542b = -1;
        this.f4541a.setParent(view);
    }

    public void m(Rect rect) {
        this.f4541a.getBoundsInScreen(rect);
    }

    public void m0(View view, int i10) {
        this.f4542b = i10;
        this.f4541a.setParent(view, i10);
    }

    public int n() {
        return this.f4541a.getChildCount();
    }

    public void n0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4541a.setScreenReaderFocusable(z10);
        } else {
            R(1, z10);
        }
    }

    public CharSequence o() {
        return this.f4541a.getClassName();
    }

    public void o0(boolean z10) {
        this.f4541a.setScrollable(z10);
    }

    public void p0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4541a.setShowingHintText(z10);
        } else {
            R(4, z10);
        }
    }

    public CharSequence q() {
        return this.f4541a.getContentDescription();
    }

    public void q0(View view, int i10) {
        this.f4543c = i10;
        this.f4541a.setSource(view, i10);
    }

    public Bundle r() {
        return this.f4541a.getExtras();
    }

    public void r0(CharSequence charSequence) {
        if (x.a.b()) {
            this.f4541a.setStateDescription(charSequence);
        } else {
            this.f4541a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public final SparseArray s(View view) {
        SparseArray u10 = u(view);
        if (u10 != null) {
            return u10;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(R$id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public void s0(CharSequence charSequence) {
        this.f4541a.setText(charSequence);
    }

    public CharSequence t() {
        return this.f4541a.getPackageName();
    }

    public void t0(boolean z10) {
        this.f4541a.setVisibleToUser(z10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(t());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(v());
        sb.append("; contentDescription: ");
        sb.append(q());
        sb.append("; viewId: ");
        sb.append(w());
        sb.append("; checkable: ");
        sb.append(z());
        sb.append("; checked: ");
        sb.append(A());
        sb.append("; focusable: ");
        sb.append(D());
        sb.append("; focused: ");
        sb.append(E());
        sb.append("; selected: ");
        sb.append(I());
        sb.append("; clickable: ");
        sb.append(B());
        sb.append("; longClickable: ");
        sb.append(F());
        sb.append("; enabled: ");
        sb.append(C());
        sb.append("; password: ");
        sb.append(G());
        sb.append("; scrollable: " + H());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List h10 = h();
            for (int i10 = 0; i10 < h10.size(); i10++) {
                a aVar = (a) h10.get(i10);
                String i11 = i(aVar.b());
                if (i11.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    i11 = aVar.c().toString();
                }
                sb.append(i11);
                if (i10 != h10.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int j10 = j();
            while (j10 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(j10);
                j10 &= numberOfTrailingZeros ^ -1;
                sb.append(i(numberOfTrailingZeros));
                if (j10 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final SparseArray u(View view) {
        return (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
    }

    public AccessibilityNodeInfo u0() {
        return this.f4541a;
    }

    public CharSequence v() {
        if (!x()) {
            return this.f4541a.getText();
        }
        List g10 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List g11 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List g12 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List g13 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f4541a.getText(), 0, this.f4541a.getText().length()));
        for (int i10 = 0; i10 < g10.size(); i10++) {
            spannableString.setSpan(new a(((Integer) g13.get(i10)).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) g10.get(i10)).intValue(), ((Integer) g11.get(i10)).intValue(), ((Integer) g12.get(i10)).intValue());
        }
        return spannableString;
    }

    public String w() {
        return this.f4541a.getViewIdResourceName();
    }

    public final boolean x() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public final int y(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i10)).get())) {
                    return sparseArray.keyAt(i10);
                }
            }
        }
        int i11 = f4540d;
        f4540d = i11 + 1;
        return i11;
    }

    public boolean z() {
        return this.f4541a.isCheckable();
    }
}
