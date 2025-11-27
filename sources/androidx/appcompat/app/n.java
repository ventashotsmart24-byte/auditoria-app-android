package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.s2;
import b0.c1;
import java.util.ArrayList;

public class n extends a {

    /* renamed from: a  reason: collision with root package name */
    public i1 f737a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f738b;

    /* renamed from: c  reason: collision with root package name */
    public Window.Callback f739c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f740d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f741e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f742f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f743g = new a();

    /* renamed from: h  reason: collision with root package name */
    public final Toolbar.f f744h;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            n.this.B();
        }
    }

    public class b implements Toolbar.f {
        public b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return n.this.f739c.onMenuItemSelected(0, menuItem);
        }
    }

    public final class c implements m.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f747a;

        public c() {
        }

        public boolean a(g gVar) {
            Window.Callback callback = n.this.f739c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, gVar);
            return true;
        }

        public void onCloseMenu(g gVar, boolean z10) {
            if (!this.f747a) {
                this.f747a = true;
                n.this.f737a.r();
                Window.Callback callback = n.this.f739c;
                if (callback != null) {
                    callback.onPanelClosed(108, gVar);
                }
                this.f747a = false;
            }
        }
    }

    public final class d implements g.a {
        public d() {
        }

        public boolean onMenuItemSelected(g gVar, MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(g gVar) {
            n nVar = n.this;
            if (nVar.f739c == null) {
                return;
            }
            if (nVar.f737a.e()) {
                n.this.f739c.onPanelClosed(108, gVar);
            } else if (n.this.f739c.onPreparePanel(0, (View) null, gVar)) {
                n.this.f739c.onMenuOpened(108, gVar);
            }
        }
    }

    public class e extends g.m {
        public e(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                return new View(n.this.f737a.getContext());
            }
            return super.onCreatePanelView(i10);
        }

        public boolean onPreparePanel(int i10, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i10, view, menu);
            if (onPreparePanel) {
                n nVar = n.this;
                if (!nVar.f738b) {
                    nVar.f737a.f();
                    n.this.f738b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public n(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f744h = bVar;
        this.f737a = new s2(toolbar, false);
        e eVar = new e(callback);
        this.f739c = eVar;
        this.f737a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f737a.setWindowTitle(charSequence);
    }

    public Window.Callback A() {
        return this.f739c;
    }

    public void B() {
        g gVar;
        Menu z10 = z();
        if (z10 instanceof g) {
            gVar = (g) z10;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            gVar.stopDispatchingItemsChanged();
        }
        try {
            z10.clear();
            if (!this.f739c.onCreatePanelMenu(0, z10) || !this.f739c.onPreparePanel(0, (View) null, z10)) {
                z10.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.startDispatchingItemsChanged();
            }
        }
    }

    public void C(int i10, int i11) {
        this.f737a.i((i10 & i11) | ((i11 ^ -1) & this.f737a.x()));
    }

    public boolean g() {
        return this.f737a.b();
    }

    public boolean h() {
        if (!this.f737a.h()) {
            return false;
        }
        this.f737a.collapseActionView();
        return true;
    }

    public void i(boolean z10) {
        if (z10 != this.f741e) {
            this.f741e = z10;
            if (this.f742f.size() > 0) {
                m.a(this.f742f.get(0));
                throw null;
            }
        }
    }

    public int j() {
        return this.f737a.x();
    }

    public Context k() {
        return this.f737a.getContext();
    }

    public boolean l() {
        this.f737a.n().removeCallbacks(this.f743g);
        c1.c0(this.f737a.n(), this.f743g);
        return true;
    }

    public void m(Configuration configuration) {
        super.m(configuration);
    }

    public void n() {
        this.f737a.n().removeCallbacks(this.f743g);
    }

    public boolean o(int i10, KeyEvent keyEvent) {
        int i11;
        Menu z10 = z();
        if (z10 == null) {
            return false;
        }
        if (keyEvent != null) {
            i11 = keyEvent.getDeviceId();
        } else {
            i11 = -1;
        }
        boolean z11 = true;
        if (KeyCharacterMap.load(i11).getKeyboardType() == 1) {
            z11 = false;
        }
        z10.setQwertyMode(z11);
        return z10.performShortcut(i10, keyEvent, 0);
    }

    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    public boolean q() {
        return this.f737a.c();
    }

    public void r(boolean z10) {
    }

    public void s(boolean z10) {
        int i10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        C(i10, 4);
    }

    public void t(int i10) {
        this.f737a.u(i10);
    }

    public void u(boolean z10) {
    }

    public void v(CharSequence charSequence) {
        this.f737a.j(charSequence);
    }

    public void w(CharSequence charSequence) {
        this.f737a.setTitle(charSequence);
    }

    public void x(CharSequence charSequence) {
        this.f737a.setWindowTitle(charSequence);
    }

    public final Menu z() {
        if (!this.f740d) {
            this.f737a.v(new c(), new d());
            this.f740d = true;
        }
        return this.f737a.k();
    }
}
