package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.j2;
import b0.a2;
import b0.b2;
import b0.c1;
import b0.c2;
import b0.d2;
import g.b;
import g.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class q extends a implements ActionBarOverlayLayout.d {
    public static final Interpolator E = new AccelerateInterpolator();
    public static final Interpolator F = new DecelerateInterpolator();
    public boolean A;
    public final b2 B = new a();
    public final b2 C = new b();
    public final d2 D = new c();

    /* renamed from: a  reason: collision with root package name */
    public Context f765a;

    /* renamed from: b  reason: collision with root package name */
    public Context f766b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f767c;

    /* renamed from: d  reason: collision with root package name */
    public Dialog f768d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarOverlayLayout f769e;

    /* renamed from: f  reason: collision with root package name */
    public ActionBarContainer f770f;

    /* renamed from: g  reason: collision with root package name */
    public i1 f771g;

    /* renamed from: h  reason: collision with root package name */
    public ActionBarContextView f772h;

    /* renamed from: i  reason: collision with root package name */
    public View f773i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f774j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public int f775k = -1;

    /* renamed from: l  reason: collision with root package name */
    public boolean f776l;

    /* renamed from: m  reason: collision with root package name */
    public d f777m;

    /* renamed from: n  reason: collision with root package name */
    public g.b f778n;

    /* renamed from: o  reason: collision with root package name */
    public b.a f779o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f780p;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList f781q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public boolean f782r;

    /* renamed from: s  reason: collision with root package name */
    public int f783s = 0;

    /* renamed from: t  reason: collision with root package name */
    public boolean f784t = true;

    /* renamed from: u  reason: collision with root package name */
    public boolean f785u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f786v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f787w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f788x = true;

    /* renamed from: y  reason: collision with root package name */
    public h f789y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f790z;

    public class a extends c2 {
        public a() {
        }

        public void b(View view) {
            View view2;
            q qVar = q.this;
            if (qVar.f784t && (view2 = qVar.f773i) != null) {
                view2.setTranslationY(0.0f);
                q.this.f770f.setTranslationY(0.0f);
            }
            q.this.f770f.setVisibility(8);
            q.this.f770f.setTransitioning(false);
            q qVar2 = q.this;
            qVar2.f789y = null;
            qVar2.B();
            ActionBarOverlayLayout actionBarOverlayLayout = q.this.f769e;
            if (actionBarOverlayLayout != null) {
                c1.h0(actionBarOverlayLayout);
            }
        }
    }

    public class b extends c2 {
        public b() {
        }

        public void b(View view) {
            q qVar = q.this;
            qVar.f789y = null;
            qVar.f770f.requestLayout();
        }
    }

    public class c implements d2 {
        public c() {
        }

        public void a(View view) {
            ((View) q.this.f770f.getParent()).invalidate();
        }
    }

    public class d extends g.b implements g.a {

        /* renamed from: c  reason: collision with root package name */
        public final Context f794c;

        /* renamed from: d  reason: collision with root package name */
        public final g f795d;

        /* renamed from: e  reason: collision with root package name */
        public b.a f796e;

        /* renamed from: f  reason: collision with root package name */
        public WeakReference f797f;

        public d(Context context, b.a aVar) {
            this.f794c = context;
            this.f796e = aVar;
            g defaultShowAsAction = new g(context).setDefaultShowAsAction(1);
            this.f795d = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public void a() {
            q qVar = q.this;
            if (qVar.f777m == this) {
                if (!q.A(qVar.f785u, qVar.f786v, false)) {
                    q qVar2 = q.this;
                    qVar2.f778n = this;
                    qVar2.f779o = this.f796e;
                } else {
                    this.f796e.b(this);
                }
                this.f796e = null;
                q.this.z(false);
                q.this.f772h.g();
                q.this.f771g.n().sendAccessibilityEvent(32);
                q qVar3 = q.this;
                qVar3.f769e.setHideOnContentScrollEnabled(qVar3.A);
                q.this.f777m = null;
            }
        }

        public View b() {
            WeakReference weakReference = this.f797f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public Menu c() {
            return this.f795d;
        }

        public MenuInflater d() {
            return new g.g(this.f794c);
        }

        public CharSequence e() {
            return q.this.f772h.getSubtitle();
        }

        public CharSequence g() {
            return q.this.f772h.getTitle();
        }

        public void i() {
            if (q.this.f777m == this) {
                this.f795d.stopDispatchingItemsChanged();
                try {
                    this.f796e.c(this, this.f795d);
                } finally {
                    this.f795d.startDispatchingItemsChanged();
                }
            }
        }

        public boolean j() {
            return q.this.f772h.j();
        }

        public void k(View view) {
            q.this.f772h.setCustomView(view);
            this.f797f = new WeakReference(view);
        }

        public void l(int i10) {
            m(q.this.f765a.getResources().getString(i10));
        }

        public void m(CharSequence charSequence) {
            q.this.f772h.setSubtitle(charSequence);
        }

        public void o(int i10) {
            p(q.this.f765a.getResources().getString(i10));
        }

        public boolean onMenuItemSelected(g gVar, MenuItem menuItem) {
            b.a aVar = this.f796e;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(g gVar) {
            if (this.f796e != null) {
                i();
                q.this.f772h.l();
            }
        }

        public void p(CharSequence charSequence) {
            q.this.f772h.setTitle(charSequence);
        }

        public void q(boolean z10) {
            super.q(z10);
            q.this.f772h.setTitleOptional(z10);
        }

        public boolean r() {
            this.f795d.stopDispatchingItemsChanged();
            try {
                return this.f796e.d(this, this.f795d);
            } finally {
                this.f795d.startDispatchingItemsChanged();
            }
        }
    }

    public q(Activity activity, boolean z10) {
        this.f767c = activity;
        View decorView = activity.getWindow().getDecorView();
        H(decorView);
        if (!z10) {
            this.f773i = decorView.findViewById(16908290);
        }
    }

    public static boolean A(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return !z10 && !z11;
    }

    public void B() {
        b.a aVar = this.f779o;
        if (aVar != null) {
            aVar.b(this.f778n);
            this.f778n = null;
            this.f779o = null;
        }
    }

    public void C(boolean z10) {
        View view;
        h hVar = this.f789y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f783s != 0 || (!this.f790z && !z10)) {
            this.B.b((View) null);
            return;
        }
        this.f770f.setAlpha(1.0f);
        this.f770f.setTransitioning(true);
        h hVar2 = new h();
        float f10 = (float) (-this.f770f.getHeight());
        if (z10) {
            int[] iArr = {0, 0};
            this.f770f.getLocationInWindow(iArr);
            f10 -= (float) iArr[1];
        }
        a2 k10 = c1.c(this.f770f).k(f10);
        k10.i(this.D);
        hVar2.c(k10);
        if (this.f784t && (view = this.f773i) != null) {
            hVar2.c(c1.c(view).k(f10));
        }
        hVar2.f(E);
        hVar2.e(250);
        hVar2.g(this.B);
        this.f789y = hVar2;
        hVar2.h();
    }

    public void D(boolean z10) {
        View view;
        View view2;
        h hVar = this.f789y;
        if (hVar != null) {
            hVar.a();
        }
        this.f770f.setVisibility(0);
        if (this.f783s != 0 || (!this.f790z && !z10)) {
            this.f770f.setAlpha(1.0f);
            this.f770f.setTranslationY(0.0f);
            if (this.f784t && (view = this.f773i) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.b((View) null);
        } else {
            this.f770f.setTranslationY(0.0f);
            float f10 = (float) (-this.f770f.getHeight());
            if (z10) {
                int[] iArr = {0, 0};
                this.f770f.getLocationInWindow(iArr);
                f10 -= (float) iArr[1];
            }
            this.f770f.setTranslationY(f10);
            h hVar2 = new h();
            a2 k10 = c1.c(this.f770f).k(0.0f);
            k10.i(this.D);
            hVar2.c(k10);
            if (this.f784t && (view2 = this.f773i) != null) {
                view2.setTranslationY(f10);
                hVar2.c(c1.c(this.f773i).k(0.0f));
            }
            hVar2.f(F);
            hVar2.e(250);
            hVar2.g(this.C);
            this.f789y = hVar2;
            hVar2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f769e;
        if (actionBarOverlayLayout != null) {
            c1.h0(actionBarOverlayLayout);
        }
    }

    public final i1 E(View view) {
        String str;
        if (view instanceof i1) {
            return (i1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        if (view != null) {
            str = view.getClass().getSimpleName();
        } else {
            str = "null";
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    public int F() {
        return this.f771g.l();
    }

    public final void G() {
        if (this.f787w) {
            this.f787w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f769e;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            P(false);
        }
    }

    public final void H(View view) {
        boolean z10;
        boolean z11;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f769e = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f771g = E(view.findViewById(R$id.action_bar));
        this.f772h = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f770f = actionBarContainer;
        i1 i1Var = this.f771g;
        if (i1Var == null || this.f772h == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f765a = i1Var.getContext();
        if ((this.f771g.x() & 4) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f776l = true;
        }
        g.a b10 = g.a.b(this.f765a);
        if (b10.a() || z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        M(z11);
        K(b10.e());
        TypedArray obtainStyledAttributes = this.f765a.obtainStyledAttributes((AttributeSet) null, R$styleable.f540a, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            L(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            J((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public void I(int i10, int i11) {
        int x10 = this.f771g.x();
        if ((i11 & 4) != 0) {
            this.f776l = true;
        }
        this.f771g.i((i10 & i11) | ((i11 ^ -1) & x10));
    }

    public void J(float f10) {
        c1.s0(this.f770f, f10);
    }

    public final void K(boolean z10) {
        boolean z11;
        boolean z12;
        this.f782r = z10;
        if (!z10) {
            this.f771g.s((j2) null);
            this.f770f.setTabContainer((j2) null);
        } else {
            this.f770f.setTabContainer((j2) null);
            this.f771g.s((j2) null);
        }
        boolean z13 = true;
        if (F() == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        i1 i1Var = this.f771g;
        if (this.f782r || !z11) {
            z12 = false;
        } else {
            z12 = true;
        }
        i1Var.q(z12);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f769e;
        if (this.f782r || !z11) {
            z13 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z13);
    }

    public void L(boolean z10) {
        if (!z10 || this.f769e.q()) {
            this.A = z10;
            this.f769e.setHideOnContentScrollEnabled(z10);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void M(boolean z10) {
        this.f771g.o(z10);
    }

    public final boolean N() {
        return c1.Q(this.f770f);
    }

    public final void O() {
        if (!this.f787w) {
            this.f787w = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f769e;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            P(false);
        }
    }

    public final void P(boolean z10) {
        if (A(this.f785u, this.f786v, this.f787w)) {
            if (!this.f788x) {
                this.f788x = true;
                D(z10);
            }
        } else if (this.f788x) {
            this.f788x = false;
            C(z10);
        }
    }

    public void a() {
        if (this.f786v) {
            this.f786v = false;
            P(true);
        }
    }

    public void b(int i10) {
        this.f783s = i10;
    }

    public void c() {
    }

    public void d(boolean z10) {
        this.f784t = z10;
    }

    public void e() {
        if (!this.f786v) {
            this.f786v = true;
            P(true);
        }
    }

    public void f() {
        h hVar = this.f789y;
        if (hVar != null) {
            hVar.a();
            this.f789y = null;
        }
    }

    public boolean h() {
        i1 i1Var = this.f771g;
        if (i1Var == null || !i1Var.h()) {
            return false;
        }
        this.f771g.collapseActionView();
        return true;
    }

    public void i(boolean z10) {
        if (z10 != this.f780p) {
            this.f780p = z10;
            if (this.f781q.size() > 0) {
                m.a(this.f781q.get(0));
                throw null;
            }
        }
    }

    public int j() {
        return this.f771g.x();
    }

    public Context k() {
        if (this.f766b == null) {
            TypedValue typedValue = new TypedValue();
            this.f765a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f766b = new ContextThemeWrapper(this.f765a, i10);
            } else {
                this.f766b = this.f765a;
            }
        }
        return this.f766b;
    }

    public void m(Configuration configuration) {
        K(g.a.b(this.f765a).e());
    }

    public boolean o(int i10, KeyEvent keyEvent) {
        Menu c10;
        int i11;
        d dVar = this.f777m;
        if (dVar == null || (c10 = dVar.c()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i11 = keyEvent.getDeviceId();
        } else {
            i11 = -1;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(i11).getKeyboardType() == 1) {
            z10 = false;
        }
        c10.setQwertyMode(z10);
        return c10.performShortcut(i10, keyEvent, 0);
    }

    public void r(boolean z10) {
        if (!this.f776l) {
            s(z10);
        }
    }

    public void s(boolean z10) {
        int i10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        I(i10, 4);
    }

    public void t(int i10) {
        this.f771g.u(i10);
    }

    public void u(boolean z10) {
        h hVar;
        this.f790z = z10;
        if (!z10 && (hVar = this.f789y) != null) {
            hVar.a();
        }
    }

    public void v(CharSequence charSequence) {
        this.f771g.j(charSequence);
    }

    public void w(CharSequence charSequence) {
        this.f771g.setTitle(charSequence);
    }

    public void x(CharSequence charSequence) {
        this.f771g.setWindowTitle(charSequence);
    }

    public g.b y(b.a aVar) {
        d dVar = this.f777m;
        if (dVar != null) {
            dVar.a();
        }
        this.f769e.setHideOnContentScrollEnabled(false);
        this.f772h.k();
        d dVar2 = new d(this.f772h.getContext(), aVar);
        if (!dVar2.r()) {
            return null;
        }
        this.f777m = dVar2;
        dVar2.i();
        this.f772h.h(dVar2);
        z(true);
        this.f772h.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void z(boolean z10) {
        a2 a2Var;
        a2 a2Var2;
        if (z10) {
            O();
        } else {
            G();
        }
        if (N()) {
            if (z10) {
                a2Var = this.f771g.m(4, 100);
                a2Var2 = this.f772h.f(0, 200);
            } else {
                a2Var2 = this.f771g.m(0, 200);
                a2Var = this.f772h.f(8, 100);
            }
            h hVar = new h();
            hVar.d(a2Var, a2Var2);
            hVar.h();
        } else if (z10) {
            this.f771g.w(4);
            this.f772h.setVisibility(0);
        } else {
            this.f771g.w(0);
            this.f772h.setVisibility(8);
        }
    }

    public q(Dialog dialog) {
        this.f768d = dialog;
        H(dialog.getWindow().getDecorView());
    }
}
