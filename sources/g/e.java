package g;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import g.b;
import java.lang.ref.WeakReference;

public class e extends b implements g.a {

    /* renamed from: c  reason: collision with root package name */
    public Context f6631c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContextView f6632d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f6633e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference f6634f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6635g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6636h;

    /* renamed from: i  reason: collision with root package name */
    public g f6637i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f6631c = context;
        this.f6632d = actionBarContextView;
        this.f6633e = aVar;
        g defaultShowAsAction = new g(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f6637i = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.f6636h = z10;
    }

    public void a() {
        if (!this.f6635g) {
            this.f6635g = true;
            this.f6632d.sendAccessibilityEvent(32);
            this.f6633e.b(this);
        }
    }

    public View b() {
        WeakReference weakReference = this.f6634f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public Menu c() {
        return this.f6637i;
    }

    public MenuInflater d() {
        return new g(this.f6632d.getContext());
    }

    public CharSequence e() {
        return this.f6632d.getSubtitle();
    }

    public CharSequence g() {
        return this.f6632d.getTitle();
    }

    public void i() {
        this.f6633e.c(this, this.f6637i);
    }

    public boolean j() {
        return this.f6632d.j();
    }

    public void k(View view) {
        WeakReference weakReference;
        this.f6632d.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference(view);
        } else {
            weakReference = null;
        }
        this.f6634f = weakReference;
    }

    public void l(int i10) {
        m(this.f6631c.getString(i10));
    }

    public void m(CharSequence charSequence) {
        this.f6632d.setSubtitle(charSequence);
    }

    public void o(int i10) {
        p(this.f6631c.getString(i10));
    }

    public boolean onMenuItemSelected(g gVar, MenuItem menuItem) {
        return this.f6633e.a(this, menuItem);
    }

    public void onMenuModeChange(g gVar) {
        i();
        this.f6632d.l();
    }

    public void p(CharSequence charSequence) {
        this.f6632d.setTitle(charSequence);
    }

    public void q(boolean z10) {
        super.q(z10);
        this.f6632d.setTitleOptional(z10);
    }
}
