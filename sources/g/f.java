package g;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.collection.g;
import g.b;
import java.util.ArrayList;

public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6638a;

    /* renamed from: b  reason: collision with root package name */
    public final b f6639b;

    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f6640a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f6641b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList f6642c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public final g f6643d = new g();

        public a(Context context, ActionMode.Callback callback) {
            this.f6641b = context;
            this.f6640a = callback;
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.f6640a.onActionItemClicked(e(bVar), new j(this.f6641b, (u.b) menuItem));
        }

        public void b(b bVar) {
            this.f6640a.onDestroyActionMode(e(bVar));
        }

        public boolean c(b bVar, Menu menu) {
            return this.f6640a.onPrepareActionMode(e(bVar), f(menu));
        }

        public boolean d(b bVar, Menu menu) {
            return this.f6640a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f6642c.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = (f) this.f6642c.get(i10);
                if (fVar != null && fVar.f6639b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f6641b, bVar);
            this.f6642c.add(fVar2);
            return fVar2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f6643d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f6641b, (u.a) menu);
            this.f6643d.put(menu, oVar);
            return oVar;
        }
    }

    public f(Context context, b bVar) {
        this.f6638a = context;
        this.f6639b = bVar;
    }

    public void finish() {
        this.f6639b.a();
    }

    public View getCustomView() {
        return this.f6639b.b();
    }

    public Menu getMenu() {
        return new o(this.f6638a, (u.a) this.f6639b.c());
    }

    public MenuInflater getMenuInflater() {
        return this.f6639b.d();
    }

    public CharSequence getSubtitle() {
        return this.f6639b.e();
    }

    public Object getTag() {
        return this.f6639b.f();
    }

    public CharSequence getTitle() {
        return this.f6639b.g();
    }

    public boolean getTitleOptionalHint() {
        return this.f6639b.h();
    }

    public void invalidate() {
        this.f6639b.i();
    }

    public boolean isTitleOptional() {
        return this.f6639b.j();
    }

    public void setCustomView(View view) {
        this.f6639b.k(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f6639b.m(charSequence);
    }

    public void setTag(Object obj) {
        this.f6639b.n(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f6639b.p(charSequence);
    }

    public void setTitleOptionalHint(boolean z10) {
        this.f6639b.q(z10);
    }

    public void setSubtitle(int i10) {
        this.f6639b.l(i10);
    }

    public void setTitle(int i10) {
        this.f6639b.o(i10);
    }
}
