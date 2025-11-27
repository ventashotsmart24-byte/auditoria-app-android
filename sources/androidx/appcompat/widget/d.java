package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.widget.ActionMenuView;
import b0.b;
import java.util.ArrayList;
import s.h;

public class d extends androidx.appcompat.view.menu.b implements b.a {
    public c A;
    public b B;
    public final f C = new f();
    public int D;

    /* renamed from: k  reason: collision with root package name */
    public C0016d f1174k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f1175l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1176m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1177n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1178o;

    /* renamed from: p  reason: collision with root package name */
    public int f1179p;

    /* renamed from: q  reason: collision with root package name */
    public int f1180q;

    /* renamed from: r  reason: collision with root package name */
    public int f1181r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f1182s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f1183t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1184u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1185v;

    /* renamed from: w  reason: collision with root package name */
    public int f1186w;

    /* renamed from: x  reason: collision with root package name */
    public final SparseBooleanArray f1187x = new SparseBooleanArray();

    /* renamed from: y  reason: collision with root package name */
    public e f1188y;

    /* renamed from: z  reason: collision with root package name */
    public a f1189z;

    public class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((i) rVar.getItem()).l()) {
                View view2 = d.this.f1174k;
                f(view2 == null ? (View) d.this.f872i : view2);
            }
            j(d.this.C);
        }

        public void e() {
            d dVar = d.this;
            dVar.f1189z = null;
            dVar.D = 0;
            super.e();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }

        public p a() {
            a aVar = d.this.f1189z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public e f1192a;

        public c(e eVar) {
            this.f1192a = eVar;
        }

        public void run() {
            if (d.this.f866c != null) {
                d.this.f866c.changeMenuMode();
            }
            View view = (View) d.this.f872i;
            if (!(view == null || view.getWindowToken() == null || !this.f1192a.m())) {
                d.this.f1188y = this.f1192a;
            }
            d.this.A = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.d$d  reason: collision with other inner class name */
    public class C0016d extends q implements ActionMenuView.a {

        /* renamed from: a  reason: collision with root package name */
        public final float[] f1194a = new float[2];

        /* renamed from: androidx.appcompat.widget.d$d$a */
        public class a extends t1 {

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ d f1196j;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(View view, d dVar) {
                super(view);
                this.f1196j = dVar;
            }

            public p b() {
                e eVar = d.this.f1188y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            public boolean c() {
                d.this.B();
                return true;
            }

            public boolean d() {
                d dVar = d.this;
                if (dVar.A != null) {
                    return false;
                }
                dVar.s();
                return true;
            }
        }

        public C0016d(Context context) {
            super(context, (AttributeSet) null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            u2.a(this, getContentDescription());
            setOnTouchListener(new a(this, d.this));
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            d.this.B();
            return true;
        }

        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                h.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class e extends l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z10) {
            super(context, gVar, view, z10, R$attr.actionOverflowMenuStyle);
            h(8388613);
            j(d.this.C);
        }

        public void e() {
            if (d.this.f866c != null) {
                d.this.f866c.close();
            }
            d.this.f1188y = null;
            super.e();
        }
    }

    public class f implements m.a {
        public f() {
        }

        public boolean a(androidx.appcompat.view.menu.g gVar) {
            if (gVar == null) {
                return false;
            }
            d.this.D = ((r) gVar).getItem().getItemId();
            m.a e10 = d.this.e();
            if (e10 != null) {
                return e10.a(gVar);
            }
            return false;
        }

        public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z10) {
            if (gVar instanceof r) {
                gVar.getRootMenu().close(false);
            }
            m.a e10 = d.this.e();
            if (e10 != null) {
                e10.onCloseMenu(gVar, z10);
            }
        }
    }

    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f1200a;

        public static class a implements Parcelable.Creator {
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            /* renamed from: b */
            public g[] newArray(int i10) {
                return new g[i10];
            }
        }

        public g() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1200a);
        }

        public g(Parcel parcel) {
            this.f1200a = parcel.readInt();
        }
    }

    public d(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
    }

    public void A(boolean z10) {
        this.f1177n = z10;
        this.f1178o = true;
    }

    public boolean B() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.f1177n || v() || (gVar = this.f866c) == null || this.f872i == null || this.A != null || gVar.getNonActionItems().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f865b, this.f866c, this.f1174k, true));
        this.A = cVar;
        ((View) this.f872i).post(cVar);
        super.onSubMenuSelected((r) null);
        return true;
    }

    public void b(i iVar, n.a aVar) {
        aVar.initialize(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f872i);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    public boolean d(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f1174k) {
            return false;
        }
        return super.d(viewGroup, i10);
    }

    public View f(i iVar, View view, ViewGroup viewGroup) {
        int i10;
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.f(iVar, view, viewGroup);
        }
        if (iVar.isActionViewExpanded()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        actionView.setVisibility(i10);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public boolean flagActionItems() {
        int i10;
        ArrayList<i> arrayList;
        int i11;
        int i12;
        int i13;
        boolean z10;
        boolean z11;
        d dVar = this;
        androidx.appcompat.view.menu.g gVar = dVar.f866c;
        View view = null;
        int i14 = 0;
        if (gVar != null) {
            arrayList = gVar.getVisibleItems();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i15 = dVar.f1181r;
        int i16 = dVar.f1180q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) dVar.f872i;
        boolean z12 = false;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i10; i19++) {
            i iVar = arrayList.get(i19);
            if (iVar.o()) {
                i17++;
            } else if (iVar.n()) {
                i18++;
            } else {
                z12 = true;
            }
            if (dVar.f1185v && iVar.isActionViewExpanded()) {
                i15 = 0;
            }
        }
        if (dVar.f1177n && (z12 || i18 + i17 > i15)) {
            i15--;
        }
        int i20 = i15 - i17;
        SparseBooleanArray sparseBooleanArray = dVar.f1187x;
        sparseBooleanArray.clear();
        if (dVar.f1183t) {
            int i21 = dVar.f1186w;
            i11 = i16 / i21;
            i12 = i21 + ((i16 % i21) / i11);
        } else {
            i12 = 0;
            i11 = 0;
        }
        int i22 = 0;
        int i23 = 0;
        while (i22 < i10) {
            i iVar2 = arrayList.get(i22);
            if (iVar2.o()) {
                View f10 = dVar.f(iVar2, view, viewGroup);
                if (dVar.f1183t) {
                    i11 -= ActionMenuView.q(f10, i12, i11, makeMeasureSpec, i14);
                } else {
                    f10.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = f10.getMeasuredWidth();
                i16 -= measuredWidth;
                if (i23 == 0) {
                    i23 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                i13 = i10;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z13 = sparseBooleanArray.get(groupId2);
                if ((i20 > 0 || z13) && i16 > 0 && (!dVar.f1183t || i11 > 0)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z14 = z10;
                i13 = i10;
                if (z10) {
                    View f11 = dVar.f(iVar2, (View) null, viewGroup);
                    if (dVar.f1183t) {
                        int q10 = ActionMenuView.q(f11, i12, i11, makeMeasureSpec, 0);
                        i11 -= q10;
                        if (q10 == 0) {
                            z14 = false;
                        }
                    } else {
                        f11.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z15 = z14;
                    int measuredWidth2 = f11.getMeasuredWidth();
                    i16 -= measuredWidth2;
                    if (i23 == 0) {
                        i23 = measuredWidth2;
                    }
                    if (!dVar.f1183t ? i16 + i23 <= 0 : i16 < 0) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    z10 = z15 & z11;
                }
                if (z10 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z13) {
                    sparseBooleanArray.put(groupId2, false);
                    int i24 = 0;
                    while (i24 < i22) {
                        i iVar3 = arrayList.get(i24);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i20++;
                            }
                            iVar3.u(false);
                        }
                        i24++;
                    }
                }
                if (z10) {
                    i20--;
                }
                iVar2.u(z10);
            } else {
                i13 = i10;
                iVar2.u(false);
                i22++;
                view = null;
                dVar = this;
                i10 = i13;
                i14 = 0;
            }
            i22++;
            view = null;
            dVar = this;
            i10 = i13;
            i14 = 0;
        }
        return true;
    }

    public n g(ViewGroup viewGroup) {
        n nVar = this.f872i;
        n g10 = super.g(viewGroup);
        if (nVar != g10) {
            ((ActionMenuView) g10).setPresenter(this);
        }
        return g10;
    }

    public boolean i(int i10, i iVar) {
        return iVar.l();
    }

    public void initForMenu(Context context, androidx.appcompat.view.menu.g gVar) {
        super.initForMenu(context, gVar);
        Resources resources = context.getResources();
        g.a b10 = g.a.b(context);
        if (!this.f1178o) {
            this.f1177n = b10.f();
        }
        if (!this.f1184u) {
            this.f1179p = b10.c();
        }
        if (!this.f1182s) {
            this.f1181r = b10.d();
        }
        int i10 = this.f1179p;
        if (this.f1177n) {
            if (this.f1174k == null) {
                C0016d dVar = new C0016d(this.f864a);
                this.f1174k = dVar;
                if (this.f1176m) {
                    dVar.setImageDrawable(this.f1175l);
                    this.f1175l = null;
                    this.f1176m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1174k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f1174k.getMeasuredWidth();
        } else {
            this.f1174k = null;
        }
        this.f1180q = i10;
        this.f1186w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z10) {
        p();
        super.onCloseMenu(gVar, z10);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        MenuItem findItem;
        if ((parcelable instanceof g) && (i10 = ((g) parcelable).f1200a) > 0 && (findItem = this.f866c.findItem(i10)) != null) {
            onSubMenuSelected((r) findItem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        g gVar = new g();
        gVar.f1200a = this.D;
        return gVar;
    }

    public boolean onSubMenuSelected(r rVar) {
        boolean z10 = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        r rVar2 = rVar;
        while (rVar2.getParentMenu() != this.f866c) {
            rVar2 = (r) rVar2.getParentMenu();
        }
        View q10 = q(rVar2.getItem());
        if (q10 == null) {
            return false;
        }
        this.D = rVar.getItem().getItemId();
        int size = rVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.f865b, rVar, q10);
        this.f1189z = aVar;
        aVar.g(z10);
        this.f1189z.k();
        super.onSubMenuSelected(rVar);
        return true;
    }

    public boolean p() {
        return s() | t();
    }

    public final View q(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f872i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable r() {
        C0016d dVar = this.f1174k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1176m) {
            return this.f1175l;
        }
        return null;
    }

    public boolean s() {
        n nVar;
        c cVar = this.A;
        if (cVar == null || (nVar = this.f872i) == null) {
            e eVar = this.f1188y;
            if (eVar == null) {
                return false;
            }
            eVar.b();
            return true;
        }
        ((View) nVar).removeCallbacks(cVar);
        this.A = null;
        return true;
    }

    public boolean t() {
        a aVar = this.f1189z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean u() {
        if (this.A != null || v()) {
            return true;
        }
        return false;
    }

    public void updateMenuView(boolean z10) {
        ArrayList<i> arrayList;
        n nVar;
        super.updateMenuView(z10);
        ((View) this.f872i).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f866c;
        boolean z11 = false;
        if (gVar != null) {
            ArrayList<i> actionItems = gVar.getActionItems();
            int size = actionItems.size();
            for (int i10 = 0; i10 < size; i10++) {
                b0.b a10 = actionItems.get(i10).a();
                if (a10 != null) {
                    a10.k(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f866c;
        if (gVar2 != null) {
            arrayList = gVar2.getNonActionItems();
        } else {
            arrayList = null;
        }
        if (this.f1177n && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z11 = !arrayList.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f1174k == null) {
                this.f1174k = new C0016d(this.f864a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1174k.getParent();
            if (viewGroup != this.f872i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1174k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f872i;
                actionMenuView.addView(this.f1174k, actionMenuView.k());
            }
        } else {
            C0016d dVar = this.f1174k;
            if (dVar != null && dVar.getParent() == (nVar = this.f872i)) {
                ((ViewGroup) nVar).removeView(this.f1174k);
            }
        }
        ((ActionMenuView) this.f872i).setOverflowReserved(this.f1177n);
    }

    public boolean v() {
        e eVar = this.f1188y;
        if (eVar == null || !eVar.d()) {
            return false;
        }
        return true;
    }

    public void w(Configuration configuration) {
        if (!this.f1182s) {
            this.f1181r = g.a.b(this.f865b).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f866c;
        if (gVar != null) {
            gVar.onItemsChanged(true);
        }
    }

    public void x(boolean z10) {
        this.f1185v = z10;
    }

    public void y(ActionMenuView actionMenuView) {
        this.f872i = actionMenuView;
        actionMenuView.initialize(this.f866c);
    }

    public void z(Drawable drawable) {
        C0016d dVar = this.f1174k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.f1176m = true;
        this.f1175l = drawable;
    }
}
