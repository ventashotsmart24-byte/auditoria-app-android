package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import b0.a2;
import b0.c1;
import b0.c2;

public class s2 implements i1 {

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f1356a;

    /* renamed from: b  reason: collision with root package name */
    public int f1357b;

    /* renamed from: c  reason: collision with root package name */
    public View f1358c;

    /* renamed from: d  reason: collision with root package name */
    public View f1359d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f1360e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f1361f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f1362g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1363h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f1364i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f1365j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1366k;

    /* renamed from: l  reason: collision with root package name */
    public Window.Callback f1367l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1368m;

    /* renamed from: n  reason: collision with root package name */
    public d f1369n;

    /* renamed from: o  reason: collision with root package name */
    public int f1370o;

    /* renamed from: p  reason: collision with root package name */
    public int f1371p;

    /* renamed from: q  reason: collision with root package name */
    public Drawable f1372q;

    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final androidx.appcompat.view.menu.a f1373a;

        public a() {
            this.f1373a = new androidx.appcompat.view.menu.a(s2.this.f1356a.getContext(), 0, 16908332, 0, 0, s2.this.f1364i);
        }

        public void onClick(View view) {
            s2 s2Var = s2.this;
            Window.Callback callback = s2Var.f1367l;
            if (callback != null && s2Var.f1368m) {
                callback.onMenuItemSelected(0, this.f1373a);
            }
        }
    }

    public class b extends c2 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1375a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f1376b;

        public b(int i10) {
            this.f1376b = i10;
        }

        public void a(View view) {
            this.f1375a = true;
        }

        public void b(View view) {
            if (!this.f1375a) {
                s2.this.f1356a.setVisibility(this.f1376b);
            }
        }

        public void c(View view) {
            s2.this.f1356a.setVisibility(0);
        }
    }

    public s2(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    public void A(View view) {
        View view2 = this.f1359d;
        if (!(view2 == null || (this.f1357b & 16) == 0)) {
            this.f1356a.removeView(view2);
        }
        this.f1359d = view;
        if (view != null && (this.f1357b & 16) != 0) {
            this.f1356a.addView(view);
        }
    }

    public void B(int i10) {
        if (i10 != this.f1371p) {
            this.f1371p = i10;
            if (TextUtils.isEmpty(this.f1356a.getNavigationContentDescription())) {
                D(this.f1371p);
            }
        }
    }

    public void C(Drawable drawable) {
        this.f1361f = drawable;
        J();
    }

    public void D(int i10) {
        String str;
        if (i10 == 0) {
            str = null;
        } else {
            str = getContext().getString(i10);
        }
        E(str);
    }

    public void E(CharSequence charSequence) {
        this.f1366k = charSequence;
        H();
    }

    public void F(Drawable drawable) {
        this.f1362g = drawable;
        I();
    }

    public final void G(CharSequence charSequence) {
        this.f1364i = charSequence;
        if ((this.f1357b & 8) != 0) {
            this.f1356a.setTitle(charSequence);
        }
    }

    public final void H() {
        if ((this.f1357b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1366k)) {
            this.f1356a.setNavigationContentDescription(this.f1371p);
        } else {
            this.f1356a.setNavigationContentDescription(this.f1366k);
        }
    }

    public final void I() {
        if ((this.f1357b & 4) != 0) {
            Toolbar toolbar = this.f1356a;
            Drawable drawable = this.f1362g;
            if (drawable == null) {
                drawable = this.f1372q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1356a.setNavigationIcon((Drawable) null);
    }

    public final void J() {
        Drawable drawable;
        int i10 = this.f1357b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) != 0) {
            drawable = this.f1361f;
            if (drawable == null) {
                drawable = this.f1360e;
            }
        } else {
            drawable = this.f1360e;
        }
        this.f1356a.setLogo(drawable);
    }

    public boolean a() {
        return this.f1356a.canShowOverflowMenu();
    }

    public boolean b() {
        return this.f1356a.hideOverflowMenu();
    }

    public boolean c() {
        return this.f1356a.showOverflowMenu();
    }

    public void collapseActionView() {
        this.f1356a.collapseActionView();
    }

    public void d(Menu menu, m.a aVar) {
        if (this.f1369n == null) {
            d dVar = new d(this.f1356a.getContext());
            this.f1369n = dVar;
            dVar.h(R$id.action_menu_presenter);
        }
        this.f1369n.setCallback(aVar);
        this.f1356a.setMenu((g) menu, this.f1369n);
    }

    public boolean e() {
        return this.f1356a.isOverflowMenuShowing();
    }

    public void f() {
        this.f1368m = true;
    }

    public boolean g() {
        return this.f1356a.isOverflowMenuShowPending();
    }

    public Context getContext() {
        return this.f1356a.getContext();
    }

    public CharSequence getTitle() {
        return this.f1356a.getTitle();
    }

    public boolean h() {
        return this.f1356a.hasExpandedActionView();
    }

    public void i(int i10) {
        View view;
        int i11 = this.f1357b ^ i10;
        this.f1357b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i11 & 3) != 0) {
                J();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f1356a.setTitle(this.f1364i);
                    this.f1356a.setSubtitle(this.f1365j);
                } else {
                    this.f1356a.setTitle((CharSequence) null);
                    this.f1356a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) != 0 && (view = this.f1359d) != null) {
                if ((i10 & 16) != 0) {
                    this.f1356a.addView(view);
                } else {
                    this.f1356a.removeView(view);
                }
            }
        }
    }

    public void j(CharSequence charSequence) {
        this.f1365j = charSequence;
        if ((this.f1357b & 8) != 0) {
            this.f1356a.setSubtitle(charSequence);
        }
    }

    public Menu k() {
        return this.f1356a.getMenu();
    }

    public int l() {
        return this.f1370o;
    }

    public a2 m(int i10, long j10) {
        float f10;
        a2 c10 = c1.c(this.f1356a);
        if (i10 == 0) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        return c10.a(f10).d(j10).f(new b(i10));
    }

    public ViewGroup n() {
        return this.f1356a;
    }

    public void o(boolean z10) {
    }

    public void p() {
    }

    public void q(boolean z10) {
        this.f1356a.setCollapsible(z10);
    }

    public void r() {
        this.f1356a.dismissPopupMenus();
    }

    public void s(j2 j2Var) {
        Toolbar toolbar;
        View view = this.f1358c;
        if (view != null && view.getParent() == (toolbar = this.f1356a)) {
            toolbar.removeView(this.f1358c);
        }
        this.f1358c = j2Var;
    }

    public void setIcon(int i10) {
        setIcon(i10 != 0 ? d.b.d(getContext(), i10) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1363h = true;
        G(charSequence);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f1367l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1363h) {
            G(charSequence);
        }
    }

    public void t(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = d.b.d(getContext(), i10);
        } else {
            drawable = null;
        }
        C(drawable);
    }

    public void u(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = d.b.d(getContext(), i10);
        } else {
            drawable = null;
        }
        F(drawable);
    }

    public void v(m.a aVar, g.a aVar2) {
        this.f1356a.setMenuCallbacks(aVar, aVar2);
    }

    public void w(int i10) {
        this.f1356a.setVisibility(i10);
    }

    public int x() {
        return this.f1357b;
    }

    public void y() {
    }

    public final int z() {
        if (this.f1356a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1372q = this.f1356a.getNavigationIcon();
        return 15;
    }

    public s2(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f1370o = 0;
        this.f1371p = 0;
        this.f1356a = toolbar;
        this.f1364i = toolbar.getTitle();
        this.f1365j = toolbar.getSubtitle();
        this.f1363h = this.f1364i != null;
        this.f1362g = toolbar.getNavigationIcon();
        r2 u10 = r2.u(toolbar.getContext(), (AttributeSet) null, R$styleable.f540a, R$attr.actionBarStyle, 0);
        this.f1372q = u10.g(R$styleable.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence p10 = u10.p(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(p10)) {
                setTitle(p10);
            }
            CharSequence p11 = u10.p(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p11)) {
                j(p11);
            }
            Drawable g10 = u10.g(R$styleable.ActionBar_logo);
            if (g10 != null) {
                C(g10);
            }
            Drawable g11 = u10.g(R$styleable.ActionBar_icon);
            if (g11 != null) {
                setIcon(g11);
            }
            if (this.f1362g == null && (drawable = this.f1372q) != null) {
                F(drawable);
            }
            i(u10.k(R$styleable.ActionBar_displayOptions, 0));
            int n10 = u10.n(R$styleable.ActionBar_customNavigationLayout, 0);
            if (n10 != 0) {
                A(LayoutInflater.from(this.f1356a.getContext()).inflate(n10, this.f1356a, false));
                i(this.f1357b | 16);
            }
            int m10 = u10.m(R$styleable.ActionBar_height, 0);
            if (m10 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1356a.getLayoutParams();
                layoutParams.height = m10;
                this.f1356a.setLayoutParams(layoutParams);
            }
            int e10 = u10.e(R$styleable.ActionBar_contentInsetStart, -1);
            int e11 = u10.e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (e10 >= 0 || e11 >= 0) {
                this.f1356a.setContentInsetsRelative(Math.max(e10, 0), Math.max(e11, 0));
            }
            int n11 = u10.n(R$styleable.ActionBar_titleTextStyle, 0);
            if (n11 != 0) {
                Toolbar toolbar2 = this.f1356a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), n11);
            }
            int n12 = u10.n(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (n12 != 0) {
                Toolbar toolbar3 = this.f1356a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), n12);
            }
            int n13 = u10.n(R$styleable.ActionBar_popupTheme, 0);
            if (n13 != 0) {
                this.f1356a.setPopupTheme(n13);
            }
        } else {
            this.f1357b = z();
        }
        u10.v();
        B(i10);
        this.f1366k = this.f1356a.getNavigationContentDescription();
        this.f1356a.setNavigationOnClickListener(new a());
    }

    public void setIcon(Drawable drawable) {
        this.f1360e = drawable;
        J();
    }
}
