package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public class e implements m, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f912a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f913b;

    /* renamed from: c  reason: collision with root package name */
    public g f914c;

    /* renamed from: d  reason: collision with root package name */
    public ExpandedMenuView f915d;

    /* renamed from: e  reason: collision with root package name */
    public int f916e;

    /* renamed from: f  reason: collision with root package name */
    public int f917f;

    /* renamed from: g  reason: collision with root package name */
    public int f918g;

    /* renamed from: h  reason: collision with root package name */
    public m.a f919h;

    /* renamed from: i  reason: collision with root package name */
    public a f920i;

    /* renamed from: j  reason: collision with root package name */
    public int f921j;

    public class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public int f922a = -1;

        public a() {
            a();
        }

        public void a() {
            i expandedItem = e.this.f914c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<i> nonActionItems = e.this.f914c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (nonActionItems.get(i10) == expandedItem) {
                        this.f922a = i10;
                        return;
                    }
                }
            }
            this.f922a = -1;
        }

        /* renamed from: b */
        public i getItem(int i10) {
            ArrayList<i> nonActionItems = e.this.f914c.getNonActionItems();
            int i11 = i10 + e.this.f916e;
            int i12 = this.f922a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return nonActionItems.get(i11);
        }

        public int getCount() {
            int size = e.this.f914c.getNonActionItems().size() - e.this.f916e;
            if (this.f922a < 0) {
                return size;
            }
            return size - 1;
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f913b.inflate(eVar.f918g, viewGroup, false);
            }
            ((n.a) view).initialize(getItem(i10), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i10) {
        this(i10, 0);
        this.f912a = context;
        this.f913b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f920i == null) {
            this.f920i = new a();
        }
        return this.f920i;
    }

    public n b(ViewGroup viewGroup) {
        if (this.f915d == null) {
            this.f915d = (ExpandedMenuView) this.f913b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f920i == null) {
                this.f920i = new a();
            }
            this.f915d.setAdapter(this.f920i);
            this.f915d.setOnItemClickListener(this);
        }
        return this.f915d;
    }

    public void c(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f915d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public boolean collapseItemActionView(g gVar, i iVar) {
        return false;
    }

    public void d(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f915d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public boolean expandItemActionView(g gVar, i iVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.f921j;
    }

    public void initForMenu(Context context, g gVar) {
        if (this.f917f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f917f);
            this.f912a = contextThemeWrapper;
            this.f913b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f912a != null) {
            this.f912a = context;
            if (this.f913b == null) {
                this.f913b = LayoutInflater.from(context);
            }
        }
        this.f914c = gVar;
        a aVar = this.f920i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onCloseMenu(g gVar, boolean z10) {
        m.a aVar = this.f919h;
        if (aVar != null) {
            aVar.onCloseMenu(gVar, z10);
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        this.f914c.performItemAction(this.f920i.getItem(i10), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        c((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.f915d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        d(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).c((IBinder) null);
        m.a aVar = this.f919h;
        if (aVar == null) {
            return true;
        }
        aVar.a(rVar);
        return true;
    }

    public void setCallback(m.a aVar) {
        this.f919h = aVar;
    }

    public void updateMenuView(boolean z10) {
        a aVar = this.f920i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public e(int i10, int i11) {
        this.f918g = i10;
        this.f917f = i11;
    }
}
