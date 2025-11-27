package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public abstract class b implements m {

    /* renamed from: a  reason: collision with root package name */
    public Context f864a;

    /* renamed from: b  reason: collision with root package name */
    public Context f865b;

    /* renamed from: c  reason: collision with root package name */
    public g f866c;

    /* renamed from: d  reason: collision with root package name */
    public LayoutInflater f867d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f868e;

    /* renamed from: f  reason: collision with root package name */
    public m.a f869f;

    /* renamed from: g  reason: collision with root package name */
    public int f870g;

    /* renamed from: h  reason: collision with root package name */
    public int f871h;

    /* renamed from: i  reason: collision with root package name */
    public n f872i;

    /* renamed from: j  reason: collision with root package name */
    public int f873j;

    public b(Context context, int i10, int i11) {
        this.f864a = context;
        this.f867d = LayoutInflater.from(context);
        this.f870g = i10;
        this.f871h = i11;
    }

    public void a(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f872i).addView(view, i10);
    }

    public abstract void b(i iVar, n.a aVar);

    public n.a c(ViewGroup viewGroup) {
        return (n.a) this.f867d.inflate(this.f871h, viewGroup, false);
    }

    public boolean collapseItemActionView(g gVar, i iVar) {
        return false;
    }

    public boolean d(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public m.a e() {
        return this.f869f;
    }

    public boolean expandItemActionView(g gVar, i iVar) {
        return false;
    }

    public View f(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar;
        if (view instanceof n.a) {
            aVar = (n.a) view;
        } else {
            aVar = c(viewGroup);
        }
        b(iVar, aVar);
        return (View) aVar;
    }

    public n g(ViewGroup viewGroup) {
        if (this.f872i == null) {
            n nVar = (n) this.f867d.inflate(this.f870g, viewGroup, false);
            this.f872i = nVar;
            nVar.initialize(this.f866c);
            updateMenuView(true);
        }
        return this.f872i;
    }

    public int getId() {
        return this.f873j;
    }

    public void h(int i10) {
        this.f873j = i10;
    }

    public abstract boolean i(int i10, i iVar);

    public void initForMenu(Context context, g gVar) {
        this.f865b = context;
        this.f868e = LayoutInflater.from(context);
        this.f866c = gVar;
    }

    public void onCloseMenu(g gVar, boolean z10) {
        m.a aVar = this.f869f;
        if (aVar != null) {
            aVar.onCloseMenu(gVar, z10);
        }
    }

    public boolean onSubMenuSelected(r rVar) {
        m.a aVar = this.f869f;
        if (aVar != null) {
            return aVar.a(rVar);
        }
        return false;
    }

    public void setCallback(m.a aVar) {
        this.f869f = aVar;
    }

    public void updateMenuView(boolean z10) {
        i iVar;
        ViewGroup viewGroup = (ViewGroup) this.f872i;
        if (viewGroup != null) {
            g gVar = this.f866c;
            int i10 = 0;
            if (gVar != null) {
                gVar.flagActionItems();
                ArrayList<i> visibleItems = this.f866c.getVisibleItems();
                int size = visibleItems.size();
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    i iVar2 = visibleItems.get(i12);
                    if (i(i11, iVar2)) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt instanceof n.a) {
                            iVar = ((n.a) childAt).getItemData();
                        } else {
                            iVar = null;
                        }
                        View f10 = f(iVar2, childAt, viewGroup);
                        if (iVar2 != iVar) {
                            f10.setPressed(false);
                            f10.jumpDrawablesToCurrentState();
                        }
                        if (f10 != childAt) {
                            a(f10, i11);
                        }
                        i11++;
                    }
                }
                i10 = i11;
            }
            while (i10 < viewGroup.getChildCount()) {
                if (!d(viewGroup, i10)) {
                    i10++;
                }
            }
        }
    }
}
