package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.d2;
import b0.c1;

public final class q extends k implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: v  reason: collision with root package name */
    public static final int f987v = R$layout.abc_popup_menu_item_layout;

    /* renamed from: b  reason: collision with root package name */
    public final Context f988b;

    /* renamed from: c  reason: collision with root package name */
    public final g f989c;

    /* renamed from: d  reason: collision with root package name */
    public final f f990d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f991e;

    /* renamed from: f  reason: collision with root package name */
    public final int f992f;

    /* renamed from: g  reason: collision with root package name */
    public final int f993g;

    /* renamed from: h  reason: collision with root package name */
    public final int f994h;

    /* renamed from: i  reason: collision with root package name */
    public final d2 f995i;

    /* renamed from: j  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f996j = new a();

    /* renamed from: k  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f997k = new b();

    /* renamed from: l  reason: collision with root package name */
    public PopupWindow.OnDismissListener f998l;

    /* renamed from: m  reason: collision with root package name */
    public View f999m;

    /* renamed from: n  reason: collision with root package name */
    public View f1000n;

    /* renamed from: o  reason: collision with root package name */
    public m.a f1001o;

    /* renamed from: p  reason: collision with root package name */
    public ViewTreeObserver f1002p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f1003q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1004r;

    /* renamed from: s  reason: collision with root package name */
    public int f1005s;

    /* renamed from: t  reason: collision with root package name */
    public int f1006t = 0;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1007u;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (q.this.isShowing() && !q.this.f995i.u()) {
                View view = q.this.f1000n;
                if (view == null || !view.isShown()) {
                    q.this.dismiss();
                } else {
                    q.this.f995i.show();
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
            ViewTreeObserver viewTreeObserver = q.this.f1002p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.f1002p = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.f1002p.removeGlobalOnLayoutListener(qVar.f996j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i10, int i11, boolean z10) {
        this.f988b = context;
        this.f989c = gVar;
        this.f991e = z10;
        this.f990d = new f(gVar, LayoutInflater.from(context), z10, f987v);
        this.f993g = i10;
        this.f994h = i11;
        Resources resources = context.getResources();
        this.f992f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f999m = view;
        this.f995i = new d2(context, (AttributeSet) null, i10, i11);
        gVar.addMenuPresenter(this, context);
    }

    public void a(g gVar) {
    }

    public void dismiss() {
        if (isShowing()) {
            this.f995i.dismiss();
        }
    }

    public void e(View view) {
        this.f999m = view;
    }

    public boolean flagActionItems() {
        return false;
    }

    public void g(boolean z10) {
        this.f990d.d(z10);
    }

    public void h(int i10) {
        this.f1006t = i10;
    }

    public void i(int i10) {
        this.f995i.c(i10);
    }

    public boolean isShowing() {
        if (this.f1003q || !this.f995i.isShowing()) {
            return false;
        }
        return true;
    }

    public void j(PopupWindow.OnDismissListener onDismissListener) {
        this.f998l = onDismissListener;
    }

    public void k(boolean z10) {
        this.f1007u = z10;
    }

    public void l(int i10) {
        this.f995i.g(i10);
    }

    public ListView m() {
        return this.f995i.m();
    }

    public void onCloseMenu(g gVar, boolean z10) {
        if (gVar == this.f989c) {
            dismiss();
            m.a aVar = this.f1001o;
            if (aVar != null) {
                aVar.onCloseMenu(gVar, z10);
            }
        }
    }

    public void onDismiss() {
        this.f1003q = true;
        this.f989c.close();
        ViewTreeObserver viewTreeObserver = this.f1002p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1002p = this.f1000n.getViewTreeObserver();
            }
            this.f1002p.removeGlobalOnLayoutListener(this.f996j);
            this.f1002p = null;
        }
        this.f1000n.removeOnAttachStateChangeListener(this.f997k);
        PopupWindow.OnDismissListener onDismissListener = this.f998l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f988b, rVar, this.f1000n, this.f991e, this.f993g, this.f994h);
            lVar.j(this.f1001o);
            lVar.g(k.n(rVar));
            lVar.i(this.f998l);
            this.f998l = null;
            this.f989c.close(false);
            int a10 = this.f995i.a();
            int j10 = this.f995i.j();
            if ((Gravity.getAbsoluteGravity(this.f1006t, c1.z(this.f999m)) & 7) == 5) {
                a10 += this.f999m.getWidth();
            }
            if (lVar.n(a10, j10)) {
                m.a aVar = this.f1001o;
                if (aVar == null) {
                    return true;
                }
                aVar.a(rVar);
                return true;
            }
        }
        return false;
    }

    public final boolean p() {
        View view;
        boolean z10;
        if (isShowing()) {
            return true;
        }
        if (this.f1003q || (view = this.f999m) == null) {
            return false;
        }
        this.f1000n = view;
        this.f995i.D(this);
        this.f995i.E(this);
        this.f995i.C(true);
        View view2 = this.f1000n;
        if (this.f1002p == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1002p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f996j);
        }
        view2.addOnAttachStateChangeListener(this.f997k);
        this.f995i.w(view2);
        this.f995i.z(this.f1006t);
        if (!this.f1004r) {
            this.f1005s = k.d(this.f990d, (ViewGroup) null, this.f988b, this.f992f);
            this.f1004r = true;
        }
        this.f995i.y(this.f1005s);
        this.f995i.B(2);
        this.f995i.A(c());
        this.f995i.show();
        ListView m10 = this.f995i.m();
        m10.setOnKeyListener(this);
        if (this.f1007u && this.f989c.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f988b).inflate(R$layout.abc_popup_menu_header_item_layout, m10, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f989c.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            m10.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f995i.k(this.f990d);
        this.f995i.show();
        return true;
    }

    public void setCallback(m.a aVar) {
        this.f1001o = aVar;
    }

    public void show() {
        if (!p()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void updateMenuView(boolean z10) {
        this.f1004r = false;
        f fVar = this.f990d;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }
}
