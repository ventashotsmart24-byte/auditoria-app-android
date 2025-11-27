package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.a;
import java.util.Iterator;
import java.util.Map;
import u.b;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f874a;

    /* renamed from: b  reason: collision with root package name */
    public Map f875b;

    /* renamed from: c  reason: collision with root package name */
    public Map f876c;

    public c(Context context) {
        this.f874a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f875b == null) {
            this.f875b = new a();
        }
        MenuItem menuItem2 = (MenuItem) this.f875b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f874a, bVar);
        this.f875b.put(bVar, jVar);
        return jVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    public final void e() {
        Map map = this.f875b;
        if (map != null) {
            map.clear();
        }
        Map map2 = this.f876c;
        if (map2 != null) {
            map2.clear();
        }
    }

    public final void f(int i10) {
        Map map = this.f875b;
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i10 == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    public final void g(int i10) {
        Map map = this.f875b;
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i10 == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
