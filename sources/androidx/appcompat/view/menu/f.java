package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public g f924a;

    /* renamed from: b  reason: collision with root package name */
    public int f925b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f926c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f927d;

    /* renamed from: e  reason: collision with root package name */
    public final LayoutInflater f928e;

    /* renamed from: f  reason: collision with root package name */
    public final int f929f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f927d = z10;
        this.f928e = layoutInflater;
        this.f924a = gVar;
        this.f929f = i10;
        a();
    }

    public void a() {
        i expandedItem = this.f924a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<i> nonActionItems = this.f924a.getNonActionItems();
            int size = nonActionItems.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (nonActionItems.get(i10) == expandedItem) {
                    this.f925b = i10;
                    return;
                }
            }
        }
        this.f925b = -1;
    }

    public g b() {
        return this.f924a;
    }

    /* renamed from: c */
    public i getItem(int i10) {
        ArrayList<i> arrayList;
        if (this.f927d) {
            arrayList = this.f924a.getNonActionItems();
        } else {
            arrayList = this.f924a.getVisibleItems();
        }
        int i11 = this.f925b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return arrayList.get(i10);
    }

    public void d(boolean z10) {
        this.f926c = z10;
    }

    public int getCount() {
        ArrayList<i> arrayList;
        if (this.f927d) {
            arrayList = this.f924a.getNonActionItems();
        } else {
            arrayList = this.f924a.getVisibleItems();
        }
        if (this.f925b < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        int i11;
        boolean z10;
        if (view == null) {
            view = this.f928e.inflate(this.f929f, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i12 = i10 - 1;
        if (i12 >= 0) {
            i11 = getItem(i12).getGroupId();
        } else {
            i11 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (!this.f924a.isGroupDividerEnabled() || groupId == i11) {
            z10 = false;
        } else {
            z10 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z10);
        n.a aVar = (n.a) view;
        if (this.f926c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i10), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
