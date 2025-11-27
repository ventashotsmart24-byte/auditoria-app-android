package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.d2;
import androidx.appcompat.widget.z1;
import b0.c1;
import b0.j;
import java.util.ArrayList;
import java.util.List;

public final class d extends k implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int B = R$layout.abc_cascading_menu_item_layout;
    public boolean A;

    /* renamed from: b  reason: collision with root package name */
    public final Context f877b;

    /* renamed from: c  reason: collision with root package name */
    public final int f878c;

    /* renamed from: d  reason: collision with root package name */
    public final int f879d;

    /* renamed from: e  reason: collision with root package name */
    public final int f880e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f881f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f882g;

    /* renamed from: h  reason: collision with root package name */
    public final List f883h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final List f884i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f885j = new a();

    /* renamed from: k  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f886k = new b();

    /* renamed from: l  reason: collision with root package name */
    public final z1 f887l = new c();

    /* renamed from: m  reason: collision with root package name */
    public int f888m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f889n = 0;

    /* renamed from: o  reason: collision with root package name */
    public View f890o;

    /* renamed from: p  reason: collision with root package name */
    public View f891p;

    /* renamed from: q  reason: collision with root package name */
    public int f892q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f893r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f894s;

    /* renamed from: t  reason: collision with root package name */
    public int f895t;

    /* renamed from: u  reason: collision with root package name */
    public int f896u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f897v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f898w;

    /* renamed from: x  reason: collision with root package name */
    public m.a f899x;

    /* renamed from: y  reason: collision with root package name */
    public ViewTreeObserver f900y;

    /* renamed from: z  reason: collision with root package name */
    public PopupWindow.OnDismissListener f901z;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (d.this.isShowing() && d.this.f884i.size() > 0 && !((C0014d) d.this.f884i.get(0)).f909a.u()) {
                View view = d.this.f891p;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0014d dVar : d.this.f884i) {
                    dVar.f909a.show();
                }
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.f900y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.f900y = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.f900y.removeGlobalOnLayoutListener(dVar.f885j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements z1 {

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0014d f905a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ MenuItem f906b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ g f907c;

            public a(C0014d dVar, MenuItem menuItem, g gVar) {
                this.f905a = dVar;
                this.f906b = menuItem;
                this.f907c = gVar;
            }

            public void run() {
                C0014d dVar = this.f905a;
                if (dVar != null) {
                    d.this.A = true;
                    dVar.f910b.close(false);
                    d.this.A = false;
                }
                if (this.f906b.isEnabled() && this.f906b.hasSubMenu()) {
                    this.f907c.performItemAction(this.f906b, 4);
                }
            }
        }

        public c() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.appcompat.view.menu.d$d} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(androidx.appcompat.view.menu.g r6, android.view.MenuItem r7) {
            /*
                r5 = this;
                androidx.appcompat.view.menu.d r0 = androidx.appcompat.view.menu.d.this
                android.os.Handler r0 = r0.f882g
                r1 = 0
                r0.removeCallbacksAndMessages(r1)
                androidx.appcompat.view.menu.d r0 = androidx.appcompat.view.menu.d.this
                java.util.List r0 = r0.f884i
                int r0 = r0.size()
                r2 = 0
            L_0x0011:
                r3 = -1
                if (r2 >= r0) goto L_0x0026
                androidx.appcompat.view.menu.d r4 = androidx.appcompat.view.menu.d.this
                java.util.List r4 = r4.f884i
                java.lang.Object r4 = r4.get(r2)
                androidx.appcompat.view.menu.d$d r4 = (androidx.appcompat.view.menu.d.C0014d) r4
                androidx.appcompat.view.menu.g r4 = r4.f910b
                if (r6 != r4) goto L_0x0023
                goto L_0x0027
            L_0x0023:
                int r2 = r2 + 1
                goto L_0x0011
            L_0x0026:
                r2 = -1
            L_0x0027:
                if (r2 != r3) goto L_0x002a
                return
            L_0x002a:
                int r2 = r2 + 1
                androidx.appcompat.view.menu.d r0 = androidx.appcompat.view.menu.d.this
                java.util.List r0 = r0.f884i
                int r0 = r0.size()
                if (r2 >= r0) goto L_0x0041
                androidx.appcompat.view.menu.d r0 = androidx.appcompat.view.menu.d.this
                java.util.List r0 = r0.f884i
                java.lang.Object r0 = r0.get(r2)
                r1 = r0
                androidx.appcompat.view.menu.d$d r1 = (androidx.appcompat.view.menu.d.C0014d) r1
            L_0x0041:
                androidx.appcompat.view.menu.d$c$a r0 = new androidx.appcompat.view.menu.d$c$a
                r0.<init>(r1, r7, r6)
                long r1 = android.os.SystemClock.uptimeMillis()
                r3 = 200(0xc8, double:9.9E-322)
                long r1 = r1 + r3
                androidx.appcompat.view.menu.d r7 = androidx.appcompat.view.menu.d.this
                android.os.Handler r7 = r7.f882g
                r7.postAtTime(r0, r6, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.d.c.b(androidx.appcompat.view.menu.g, android.view.MenuItem):void");
        }

        public void l(g gVar, MenuItem menuItem) {
            d.this.f882g.removeCallbacksAndMessages(gVar);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$d  reason: collision with other inner class name */
    public static class C0014d {

        /* renamed from: a  reason: collision with root package name */
        public final d2 f909a;

        /* renamed from: b  reason: collision with root package name */
        public final g f910b;

        /* renamed from: c  reason: collision with root package name */
        public final int f911c;

        public C0014d(d2 d2Var, g gVar, int i10) {
            this.f909a = d2Var;
            this.f910b = gVar;
            this.f911c = i10;
        }

        public ListView a() {
            return this.f909a.m();
        }
    }

    public d(Context context, View view, int i10, int i11, boolean z10) {
        this.f877b = context;
        this.f890o = view;
        this.f879d = i10;
        this.f880e = i11;
        this.f881f = z10;
        this.f897v = false;
        this.f892q = t();
        Resources resources = context.getResources();
        this.f878c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f882g = new Handler();
    }

    public void a(g gVar) {
        gVar.addMenuPresenter(this, this.f877b);
        if (isShowing()) {
            v(gVar);
        } else {
            this.f883h.add(gVar);
        }
    }

    public boolean b() {
        return false;
    }

    public void dismiss() {
        int size = this.f884i.size();
        if (size > 0) {
            C0014d[] dVarArr = (C0014d[]) this.f884i.toArray(new C0014d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                C0014d dVar = dVarArr[i10];
                if (dVar.f909a.isShowing()) {
                    dVar.f909a.dismiss();
                }
            }
        }
    }

    public void e(View view) {
        if (this.f890o != view) {
            this.f890o = view;
            this.f889n = j.b(this.f888m, c1.z(view));
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public void g(boolean z10) {
        this.f897v = z10;
    }

    public void h(int i10) {
        if (this.f888m != i10) {
            this.f888m = i10;
            this.f889n = j.b(i10, c1.z(this.f890o));
        }
    }

    public void i(int i10) {
        this.f893r = true;
        this.f895t = i10;
    }

    public boolean isShowing() {
        if (this.f884i.size() <= 0 || !((C0014d) this.f884i.get(0)).f909a.isShowing()) {
            return false;
        }
        return true;
    }

    public void j(PopupWindow.OnDismissListener onDismissListener) {
        this.f901z = onDismissListener;
    }

    public void k(boolean z10) {
        this.f898w = z10;
    }

    public void l(int i10) {
        this.f894s = true;
        this.f896u = i10;
    }

    public ListView m() {
        if (this.f884i.isEmpty()) {
            return null;
        }
        List list = this.f884i;
        return ((C0014d) list.get(list.size() - 1)).a();
    }

    public void onCloseMenu(g gVar, boolean z10) {
        int q10 = q(gVar);
        if (q10 >= 0) {
            int i10 = q10 + 1;
            if (i10 < this.f884i.size()) {
                ((C0014d) this.f884i.get(i10)).f910b.close(false);
            }
            C0014d dVar = (C0014d) this.f884i.remove(q10);
            dVar.f910b.removeMenuPresenter(this);
            if (this.A) {
                dVar.f909a.L((Object) null);
                dVar.f909a.x(0);
            }
            dVar.f909a.dismiss();
            int size = this.f884i.size();
            if (size > 0) {
                this.f892q = ((C0014d) this.f884i.get(size - 1)).f911c;
            } else {
                this.f892q = t();
            }
            if (size == 0) {
                dismiss();
                m.a aVar = this.f899x;
                if (aVar != null) {
                    aVar.onCloseMenu(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f900y;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f900y.removeGlobalOnLayoutListener(this.f885j);
                    }
                    this.f900y = null;
                }
                this.f891p.removeOnAttachStateChangeListener(this.f886k);
                this.f901z.onDismiss();
            } else if (z10) {
                ((C0014d) this.f884i.get(0)).f910b.close(false);
            }
        }
    }

    public void onDismiss() {
        C0014d dVar;
        int size = this.f884i.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = (C0014d) this.f884i.get(i10);
            if (!dVar.f909a.isShowing()) {
                break;
            }
            i10++;
        }
        if (dVar != null) {
            dVar.f910b.close(false);
        }
    }

    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(r rVar) {
        for (C0014d dVar : this.f884i) {
            if (rVar == dVar.f910b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        a(rVar);
        m.a aVar = this.f899x;
        if (aVar != null) {
            aVar.a(rVar);
        }
        return true;
    }

    public final d2 p() {
        d2 d2Var = new d2(this.f877b, (AttributeSet) null, this.f879d, this.f880e);
        d2Var.M(this.f887l);
        d2Var.E(this);
        d2Var.D(this);
        d2Var.w(this.f890o);
        d2Var.z(this.f889n);
        d2Var.C(true);
        d2Var.B(2);
        return d2Var;
    }

    public final int q(g gVar) {
        int size = this.f884i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (gVar == ((C0014d) this.f884i.get(i10)).f910b) {
                return i10;
            }
        }
        return -1;
    }

    public final MenuItem r(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = gVar.getItem(i10);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View s(C0014d dVar, g gVar) {
        int i10;
        f fVar;
        int firstVisiblePosition;
        MenuItem r10 = r(dVar.f910b, gVar);
        if (r10 == null) {
            return null;
        }
        ListView a10 = dVar.a();
        ListAdapter adapter = a10.getAdapter();
        int i11 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i10 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i10 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i11 >= count) {
                i11 = -1;
                break;
            } else if (r10 == fVar.getItem(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1 && (firstVisiblePosition = (i11 + i10) - a10.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a10.getChildCount()) {
            return a10.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public void setCallback(m.a aVar) {
        this.f899x = aVar;
    }

    public void show() {
        boolean z10;
        if (!isShowing()) {
            for (g v10 : this.f883h) {
                v(v10);
            }
            this.f883h.clear();
            View view = this.f890o;
            this.f891p = view;
            if (view != null) {
                if (this.f900y == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f900y = viewTreeObserver;
                if (z10) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f885j);
                }
                this.f891p.addOnAttachStateChangeListener(this.f886k);
            }
        }
    }

    public final int t() {
        if (c1.z(this.f890o) == 1) {
            return 0;
        }
        return 1;
    }

    public final int u(int i10) {
        List list = this.f884i;
        ListView a10 = ((C0014d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        a10.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f891p.getWindowVisibleDisplayFrame(rect);
        if (this.f892q == 1) {
            if (iArr[0] + a10.getWidth() + i10 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i10 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void updateMenuView(boolean z10) {
        for (C0014d a10 : this.f884i) {
            k.o(a10.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public final void v(g gVar) {
        View view;
        C0014d dVar;
        boolean z10;
        int i10;
        int i11;
        int i12;
        LayoutInflater from = LayoutInflater.from(this.f877b);
        f fVar = new f(gVar, from, this.f881f, B);
        if (!isShowing() && this.f897v) {
            fVar.d(true);
        } else if (isShowing()) {
            fVar.d(k.n(gVar));
        }
        int d10 = k.d(fVar, (ViewGroup) null, this.f877b, this.f878c);
        d2 p10 = p();
        p10.k(fVar);
        p10.y(d10);
        p10.z(this.f889n);
        if (this.f884i.size() > 0) {
            List list = this.f884i;
            dVar = (C0014d) list.get(list.size() - 1);
            view = s(dVar, gVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            p10.N(false);
            p10.K((Object) null);
            int u10 = u(d10);
            if (u10 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f892q = u10;
            if (Build.VERSION.SDK_INT >= 26) {
                p10.w(view);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.f890o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f889n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f890o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.f889n & 5) != 5) {
                if (z10) {
                    d10 = view.getWidth();
                }
                i12 = i10 - d10;
                p10.c(i12);
                p10.F(true);
                p10.g(i11);
            } else if (!z10) {
                d10 = view.getWidth();
                i12 = i10 - d10;
                p10.c(i12);
                p10.F(true);
                p10.g(i11);
            }
            i12 = i10 + d10;
            p10.c(i12);
            p10.F(true);
            p10.g(i11);
        } else {
            if (this.f893r) {
                p10.c(this.f895t);
            }
            if (this.f894s) {
                p10.g(this.f896u);
            }
            p10.A(c());
        }
        this.f884i.add(new C0014d(p10, gVar, this.f892q));
        p10.show();
        ListView m10 = p10.m();
        m10.setOnKeyListener(this);
        if (dVar == null && this.f898w && gVar.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, m10, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.getHeaderTitle());
            m10.addHeaderView(frameLayout, (Object) null, false);
            p10.show();
        }
    }
}
