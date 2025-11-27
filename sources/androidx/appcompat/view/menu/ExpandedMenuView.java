package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.r2;

public final class ExpandedMenuView extends ListView implements g.b, n, AdapterView.OnItemClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f821c = {16842964, 16843049};

    /* renamed from: a  reason: collision with root package name */
    public g f822a;

    /* renamed from: b  reason: collision with root package name */
    public int f823b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public boolean b(i iVar) {
        return this.f822a.performItemAction(iVar, 0);
    }

    public int getWindowAnimations() {
        return this.f823b;
    }

    public void initialize(g gVar) {
        this.f822a = gVar;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        b((i) getAdapter().getItem(i10));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        r2 u10 = r2.u(context, attributeSet, f821c, i10, 0);
        if (u10.r(0)) {
            setBackgroundDrawable(u10.g(0));
        }
        if (u10.r(1)) {
            setDivider(u10.g(1));
        }
        u10.v();
    }
}
