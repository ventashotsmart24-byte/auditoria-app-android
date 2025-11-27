package b0;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class f2 {

    /* renamed from: b  reason: collision with root package name */
    public static final f2 f4071b;

    /* renamed from: a  reason: collision with root package name */
    public final l f4072a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Field f4073a;

        /* renamed from: b  reason: collision with root package name */
        public static Field f4074b;

        /* renamed from: c  reason: collision with root package name */
        public static Field f4075c;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f4076d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f4073a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f4074b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f4075c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to get visible insets from AttachInfo ");
                sb.append(e10.getMessage());
            }
        }

        public static f2 a(View view) {
            if (f4076d && view.isAttachedToWindow()) {
                try {
                    Object obj = f4073a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f4074b.get(obj);
                        Rect rect2 = (Rect) f4075c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            f2 a10 = new b().b(r.c.c(rect)).c(r.c.c(rect2)).a();
                            a10.q(a10);
                            a10.d(view.getRootView());
                            return a10;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to get insets from AttachInfo. ");
                    sb.append(e10.getMessage());
                }
            }
            return null;
        }
    }

    public static class e extends d {
        public e() {
        }

        public e(f2 f2Var) {
            super(f2Var);
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final f2 f4085a;

        /* renamed from: b  reason: collision with root package name */
        public r.c[] f4086b;

        public f() {
            this(new f2((f2) null));
        }

        public final void a() {
            r.c[] cVarArr = this.f4086b;
            if (cVarArr != null) {
                r.c cVar = cVarArr[m.a(1)];
                r.c cVar2 = this.f4086b[m.a(2)];
                if (cVar2 == null) {
                    cVar2 = this.f4085a.f(2);
                }
                if (cVar == null) {
                    cVar = this.f4085a.f(1);
                }
                f(r.c.a(cVar, cVar2));
                r.c cVar3 = this.f4086b[m.a(16)];
                if (cVar3 != null) {
                    e(cVar3);
                }
                r.c cVar4 = this.f4086b[m.a(32)];
                if (cVar4 != null) {
                    c(cVar4);
                }
                r.c cVar5 = this.f4086b[m.a(64)];
                if (cVar5 != null) {
                    g(cVar5);
                }
            }
        }

        public f2 b() {
            a();
            return this.f4085a;
        }

        public void c(r.c cVar) {
        }

        public void d(r.c cVar) {
        }

        public void e(r.c cVar) {
        }

        public void f(r.c cVar) {
        }

        public void g(r.c cVar) {
        }

        public f(f2 f2Var) {
            this.f4085a = f2Var;
        }
    }

    public static class i extends h {
        public i(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var, windowInsets);
        }

        public f2 a() {
            return f2.t(this.f4093c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            if (!Objects.equals(this.f4093c, iVar.f4093c) || !Objects.equals(this.f4097g, iVar.f4097g)) {
                return false;
            }
            return true;
        }

        public h f() {
            return h.e(this.f4093c.getDisplayCutout());
        }

        public int hashCode() {
            return this.f4093c.hashCode();
        }

        public i(f2 f2Var, i iVar) {
            super(f2Var, (h) iVar);
        }
    }

    public static class k extends j {

        /* renamed from: r  reason: collision with root package name */
        public static final f2 f4102r = f2.t(WindowInsets.CONSUMED);

        public k(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var, windowInsets);
        }

        public final void d(View view) {
        }

        public r.c g(int i10) {
            return r.c.d(this.f4093c.getInsets(n.a(i10)));
        }

        public k(f2 f2Var, k kVar) {
            super(f2Var, (j) kVar);
        }
    }

    public static class l {

        /* renamed from: b  reason: collision with root package name */
        public static final f2 f4103b = new b().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        public final f2 f4104a;

        public l(f2 f2Var) {
            this.f4104a = f2Var;
        }

        public f2 a() {
            return this.f4104a;
        }

        public f2 b() {
            return this.f4104a;
        }

        public f2 c() {
            return this.f4104a;
        }

        public void d(View view) {
        }

        public void e(f2 f2Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            if (n() != lVar.n() || m() != lVar.m() || !a0.c.a(k(), lVar.k()) || !a0.c.a(i(), lVar.i()) || !a0.c.a(f(), lVar.f())) {
                return false;
            }
            return true;
        }

        public h f() {
            return null;
        }

        public r.c g(int i10) {
            return r.c.f8942e;
        }

        public r.c h() {
            return k();
        }

        public int hashCode() {
            return a0.c.b(Boolean.valueOf(n()), Boolean.valueOf(m()), k(), i(), f());
        }

        public r.c i() {
            return r.c.f8942e;
        }

        public r.c j() {
            return k();
        }

        public r.c k() {
            return r.c.f8942e;
        }

        public r.c l() {
            return k();
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void o(r.c[] cVarArr) {
        }

        public void p(r.c cVar) {
        }

        public void q(f2 f2Var) {
        }

        public void r(r.c cVar) {
        }
    }

    public static final class m {
        public static int a(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }
    }

    public static final class n {
        public static int a(int i10) {
            int i11;
            int i12 = 0;
            for (int i13 = 1; i13 <= 256; i13 <<= 1) {
                if ((i10 & i13) != 0) {
                    if (i13 == 1) {
                        i11 = WindowInsets.Type.statusBars();
                    } else if (i13 == 2) {
                        i11 = WindowInsets.Type.navigationBars();
                    } else if (i13 == 4) {
                        i11 = WindowInsets.Type.captionBar();
                    } else if (i13 == 8) {
                        i11 = WindowInsets.Type.ime();
                    } else if (i13 == 16) {
                        i11 = WindowInsets.Type.systemGestures();
                    } else if (i13 == 32) {
                        i11 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i13 == 64) {
                        i11 = WindowInsets.Type.tappableElement();
                    } else if (i13 == 128) {
                        i11 = WindowInsets.Type.displayCutout();
                    }
                    i12 |= i11;
                }
            }
            return i12;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f4071b = k.f4102r;
        } else {
            f4071b = l.f4103b;
        }
    }

    public f2(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f4072a = new k(this, windowInsets);
        } else if (i10 >= 29) {
            this.f4072a = new j(this, windowInsets);
        } else if (i10 >= 28) {
            this.f4072a = new i(this, windowInsets);
        } else if (i10 >= 21) {
            this.f4072a = new h(this, windowInsets);
        } else if (i10 >= 20) {
            this.f4072a = new g(this, windowInsets);
        } else {
            this.f4072a = new l(this);
        }
    }

    public static f2 t(WindowInsets windowInsets) {
        return u(windowInsets, (View) null);
    }

    public static f2 u(WindowInsets windowInsets, View view) {
        f2 f2Var = new f2(e2.a(a0.h.d(windowInsets)));
        if (view != null && view.isAttachedToWindow()) {
            f2Var.q(c1.G(view));
            f2Var.d(view.getRootView());
        }
        return f2Var;
    }

    public f2 a() {
        return this.f4072a.a();
    }

    public f2 b() {
        return this.f4072a.b();
    }

    public f2 c() {
        return this.f4072a.c();
    }

    public void d(View view) {
        this.f4072a.d(view);
    }

    public h e() {
        return this.f4072a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        return a0.c.a(this.f4072a, ((f2) obj).f4072a);
    }

    public r.c f(int i10) {
        return this.f4072a.g(i10);
    }

    public r.c g() {
        return this.f4072a.i();
    }

    public int h() {
        return this.f4072a.k().f8946d;
    }

    public int hashCode() {
        l lVar = this.f4072a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public int i() {
        return this.f4072a.k().f8943a;
    }

    public int j() {
        return this.f4072a.k().f8945c;
    }

    public int k() {
        return this.f4072a.k().f8944b;
    }

    public boolean l() {
        return !this.f4072a.k().equals(r.c.f8942e);
    }

    public boolean m() {
        return this.f4072a.m();
    }

    public f2 n(int i10, int i11, int i12, int i13) {
        return new b(this).c(r.c.b(i10, i11, i12, i13)).a();
    }

    public void o(r.c[] cVarArr) {
        this.f4072a.o(cVarArr);
    }

    public void p(r.c cVar) {
        this.f4072a.p(cVar);
    }

    public void q(f2 f2Var) {
        this.f4072a.q(f2Var);
    }

    public void r(r.c cVar) {
        this.f4072a.r(cVar);
    }

    public WindowInsets s() {
        l lVar = this.f4072a;
        if (lVar instanceof g) {
            return ((g) lVar).f4093c;
        }
        return null;
    }

    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        public static Field f4078e = null;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f4079f = false;

        /* renamed from: g  reason: collision with root package name */
        public static Constructor f4080g = null;

        /* renamed from: h  reason: collision with root package name */
        public static boolean f4081h = false;

        /* renamed from: c  reason: collision with root package name */
        public WindowInsets f4082c;

        /* renamed from: d  reason: collision with root package name */
        public r.c f4083d;

        public c() {
            this.f4082c = h();
        }

        private static WindowInsets h() {
            if (!f4079f) {
                try {
                    f4078e = g2.a().getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f4079f = true;
            }
            Field field = f4078e;
            if (field != null) {
                try {
                    WindowInsets a10 = e2.a(field.get((Object) null));
                    if (a10 != null) {
                        return new WindowInsets(a10);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f4081h) {
                try {
                    f4080g = g2.a().getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException unused3) {
                }
                f4081h = true;
            }
            Constructor constructor = f4080g;
            if (constructor != null) {
                try {
                    return e2.a(constructor.newInstance(new Object[]{new Rect()}));
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        public f2 b() {
            a();
            f2 t10 = f2.t(this.f4082c);
            t10.o(this.f4086b);
            t10.r(this.f4083d);
            return t10;
        }

        public void d(r.c cVar) {
            this.f4083d = cVar;
        }

        public void f(r.c cVar) {
            WindowInsets windowInsets = this.f4082c;
            if (windowInsets != null) {
                this.f4082c = windowInsets.replaceSystemWindowInsets(cVar.f8943a, cVar.f8944b, cVar.f8945c, cVar.f8946d);
            }
        }

        public c(f2 f2Var) {
            super(f2Var);
            this.f4082c = f2Var.s();
        }
    }

    public static class d extends f {

        /* renamed from: c  reason: collision with root package name */
        public final WindowInsets.Builder f4084c;

        public d() {
            this.f4084c = new WindowInsets.Builder();
        }

        public f2 b() {
            a();
            f2 t10 = f2.t(this.f4084c.build());
            t10.o(this.f4086b);
            return t10;
        }

        public void c(r.c cVar) {
            WindowInsets.Builder unused = this.f4084c.setMandatorySystemGestureInsets(cVar.e());
        }

        public void d(r.c cVar) {
            WindowInsets.Builder unused = this.f4084c.setStableInsets(cVar.e());
        }

        public void e(r.c cVar) {
            WindowInsets.Builder unused = this.f4084c.setSystemGestureInsets(cVar.e());
        }

        public void f(r.c cVar) {
            WindowInsets.Builder unused = this.f4084c.setSystemWindowInsets(cVar.e());
        }

        public void g(r.c cVar) {
            WindowInsets.Builder unused = this.f4084c.setTappableElementInsets(cVar.e());
        }

        public d(f2 f2Var) {
            super(f2Var);
            WindowInsets.Builder builder;
            WindowInsets s10 = f2Var.s();
            if (s10 != null) {
                builder = new WindowInsets.Builder(s10);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f4084c = builder;
        }
    }

    public static class h extends g {

        /* renamed from: n  reason: collision with root package name */
        public r.c f4098n = null;

        public h(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var, windowInsets);
        }

        public f2 b() {
            return f2.t(this.f4093c.consumeStableInsets());
        }

        public f2 c() {
            return f2.t(this.f4093c.consumeSystemWindowInsets());
        }

        public final r.c i() {
            if (this.f4098n == null) {
                this.f4098n = r.c.b(this.f4093c.getStableInsetLeft(), this.f4093c.getStableInsetTop(), this.f4093c.getStableInsetRight(), this.f4093c.getStableInsetBottom());
            }
            return this.f4098n;
        }

        public boolean m() {
            return this.f4093c.isConsumed();
        }

        public void r(r.c cVar) {
            this.f4098n = cVar;
        }

        public h(f2 f2Var, h hVar) {
            super(f2Var, (g) hVar);
            this.f4098n = hVar.f4098n;
        }
    }

    public static class g extends l {

        /* renamed from: h  reason: collision with root package name */
        public static boolean f4087h = false;

        /* renamed from: i  reason: collision with root package name */
        public static Method f4088i;

        /* renamed from: j  reason: collision with root package name */
        public static Class f4089j;

        /* renamed from: k  reason: collision with root package name */
        public static Class f4090k;

        /* renamed from: l  reason: collision with root package name */
        public static Field f4091l;

        /* renamed from: m  reason: collision with root package name */
        public static Field f4092m;

        /* renamed from: c  reason: collision with root package name */
        public final WindowInsets f4093c;

        /* renamed from: d  reason: collision with root package name */
        public r.c[] f4094d;

        /* renamed from: e  reason: collision with root package name */
        public r.c f4095e;

        /* renamed from: f  reason: collision with root package name */
        public f2 f4096f;

        /* renamed from: g  reason: collision with root package name */
        public r.c f4097g;

        public g(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var);
            this.f4095e = null;
            this.f4093c = windowInsets;
        }

        private r.c s(int i10, boolean z10) {
            r.c cVar = r.c.f8942e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    cVar = r.c.a(cVar, t(i11, z10));
                }
            }
            return cVar;
        }

        private r.c u() {
            f2 f2Var = this.f4096f;
            if (f2Var != null) {
                return f2Var.g();
            }
            return r.c.f8942e;
        }

        private r.c v(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f4087h) {
                    w();
                }
                Method method = f4088i;
                if (!(method == null || f4090k == null || f4091l == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            return null;
                        }
                        Rect rect = (Rect) f4091l.get(f4092m.get(invoke));
                        if (rect != null) {
                            return r.c.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e10) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        private static void w() {
            try {
                f4088i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f4089j = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f4090k = cls;
                f4091l = cls.getDeclaredField("mVisibleInsets");
                f4092m = f4089j.getDeclaredField("mAttachInfo");
                f4091l.setAccessible(true);
                f4092m.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f4087h = true;
        }

        public void d(View view) {
            r.c v10 = v(view);
            if (v10 == null) {
                v10 = r.c.f8942e;
            }
            p(v10);
        }

        public void e(f2 f2Var) {
            f2Var.q(this.f4096f);
            f2Var.p(this.f4097g);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f4097g, ((g) obj).f4097g);
        }

        public r.c g(int i10) {
            return s(i10, false);
        }

        public final r.c k() {
            if (this.f4095e == null) {
                this.f4095e = r.c.b(this.f4093c.getSystemWindowInsetLeft(), this.f4093c.getSystemWindowInsetTop(), this.f4093c.getSystemWindowInsetRight(), this.f4093c.getSystemWindowInsetBottom());
            }
            return this.f4095e;
        }

        public boolean n() {
            return this.f4093c.isRound();
        }

        public void o(r.c[] cVarArr) {
            this.f4094d = cVarArr;
        }

        public void p(r.c cVar) {
            this.f4097g = cVar;
        }

        public void q(f2 f2Var) {
            this.f4096f = f2Var;
        }

        public r.c t(int i10, boolean z10) {
            int i11;
            h hVar;
            if (i10 != 1) {
                r.c cVar = null;
                if (i10 != 2) {
                    if (i10 == 8) {
                        r.c[] cVarArr = this.f4094d;
                        if (cVarArr != null) {
                            cVar = cVarArr[m.a(8)];
                        }
                        if (cVar != null) {
                            return cVar;
                        }
                        r.c k10 = k();
                        r.c u10 = u();
                        int i12 = k10.f8946d;
                        if (i12 > u10.f8946d) {
                            return r.c.b(0, 0, 0, i12);
                        }
                        r.c cVar2 = this.f4097g;
                        if (cVar2 == null || cVar2.equals(r.c.f8942e) || (i11 = this.f4097g.f8946d) <= u10.f8946d) {
                            return r.c.f8942e;
                        }
                        return r.c.b(0, 0, 0, i11);
                    } else if (i10 == 16) {
                        return j();
                    } else {
                        if (i10 == 32) {
                            return h();
                        }
                        if (i10 == 64) {
                            return l();
                        }
                        if (i10 != 128) {
                            return r.c.f8942e;
                        }
                        f2 f2Var = this.f4096f;
                        if (f2Var != null) {
                            hVar = f2Var.e();
                        } else {
                            hVar = f();
                        }
                        if (hVar != null) {
                            return r.c.b(hVar.b(), hVar.d(), hVar.c(), hVar.a());
                        }
                        return r.c.f8942e;
                    }
                } else if (z10) {
                    r.c u11 = u();
                    r.c i13 = i();
                    return r.c.b(Math.max(u11.f8943a, i13.f8943a), 0, Math.max(u11.f8945c, i13.f8945c), Math.max(u11.f8946d, i13.f8946d));
                } else {
                    r.c k11 = k();
                    f2 f2Var2 = this.f4096f;
                    if (f2Var2 != null) {
                        cVar = f2Var2.g();
                    }
                    int i14 = k11.f8946d;
                    if (cVar != null) {
                        i14 = Math.min(i14, cVar.f8946d);
                    }
                    return r.c.b(k11.f8943a, 0, k11.f8945c, i14);
                }
            } else if (z10) {
                return r.c.b(0, Math.max(u().f8944b, k().f8944b), 0, 0);
            } else {
                return r.c.b(0, k().f8944b, 0, 0);
            }
        }

        public g(f2 f2Var, g gVar) {
            this(f2Var, new WindowInsets(gVar.f4093c));
        }
    }

    public static class j extends i {

        /* renamed from: o  reason: collision with root package name */
        public r.c f4099o = null;

        /* renamed from: p  reason: collision with root package name */
        public r.c f4100p = null;

        /* renamed from: q  reason: collision with root package name */
        public r.c f4101q = null;

        public j(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var, windowInsets);
        }

        public r.c h() {
            if (this.f4100p == null) {
                this.f4100p = r.c.d(this.f4093c.getMandatorySystemGestureInsets());
            }
            return this.f4100p;
        }

        public r.c j() {
            if (this.f4099o == null) {
                this.f4099o = r.c.d(this.f4093c.getSystemGestureInsets());
            }
            return this.f4099o;
        }

        public r.c l() {
            if (this.f4101q == null) {
                this.f4101q = r.c.d(this.f4093c.getTappableElementInsets());
            }
            return this.f4101q;
        }

        public void r(r.c cVar) {
        }

        public j(f2 f2Var, j jVar) {
            super(f2Var, (i) jVar);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final f f4077a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f4077a = new e();
            } else if (i10 >= 29) {
                this.f4077a = new d();
            } else if (i10 >= 20) {
                this.f4077a = new c();
            } else {
                this.f4077a = new f();
            }
        }

        public f2 a() {
            return this.f4077a.b();
        }

        public b b(r.c cVar) {
            this.f4077a.d(cVar);
            return this;
        }

        public b c(r.c cVar) {
            this.f4077a.f(cVar);
            return this;
        }

        public b(f2 f2Var) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f4077a = new e(f2Var);
            } else if (i10 >= 29) {
                this.f4077a = new d(f2Var);
            } else if (i10 >= 20) {
                this.f4077a = new c(f2Var);
            } else {
                this.f4077a = new f(f2Var);
            }
        }
    }

    public f2(f2 f2Var) {
        if (f2Var != null) {
            l lVar = f2Var.f4072a;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && (lVar instanceof k)) {
                this.f4072a = new k(this, (k) lVar);
            } else if (i10 >= 29 && (lVar instanceof j)) {
                this.f4072a = new j(this, (j) lVar);
            } else if (i10 >= 28 && (lVar instanceof i)) {
                this.f4072a = new i(this, (i) lVar);
            } else if (i10 >= 21 && (lVar instanceof h)) {
                this.f4072a = new h(this, (h) lVar);
            } else if (i10 < 20 || !(lVar instanceof g)) {
                this.f4072a = new l(this);
            } else {
                this.f4072a = new g(this, (g) lVar);
            }
            lVar.e(this);
            return;
        }
        this.f4072a = new l(this);
    }
}
