package b0;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4043a;

    /* renamed from: b  reason: collision with root package name */
    public a f4044b;

    /* renamed from: c  reason: collision with root package name */
    public C0066b f4045c;

    public interface a {
    }

    /* renamed from: b0.b$b  reason: collision with other inner class name */
    public interface C0066b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public b(Context context) {
        this.f4043a = context;
    }

    public Context a() {
        return this.f4043a;
    }

    public boolean b() {
        return false;
    }

    public abstract boolean c();

    public abstract View d();

    public View e(MenuItem menuItem) {
        return d();
    }

    public abstract boolean f();

    public void g(SubMenu subMenu) {
    }

    public abstract boolean h();

    public void i() {
        if (this.f4045c != null && h()) {
            this.f4045c.onActionProviderVisibilityChanged(c());
        }
    }

    public void j() {
        this.f4045c = null;
        this.f4044b = null;
    }

    public void k(a aVar) {
        this.f4044b = aVar;
    }

    public void l(C0066b bVar) {
        if (!(this.f4045c == null || bVar == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb.append(getClass().getSimpleName());
            sb.append(" instance while it is still in use somewhere else?");
        }
        this.f4045c = bVar;
    }
}
