package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.m;
import b0.c1;
import b0.j;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public final Context f973a;

    /* renamed from: b  reason: collision with root package name */
    public final g f974b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f975c;

    /* renamed from: d  reason: collision with root package name */
    public final int f976d;

    /* renamed from: e  reason: collision with root package name */
    public final int f977e;

    /* renamed from: f  reason: collision with root package name */
    public View f978f;

    /* renamed from: g  reason: collision with root package name */
    public int f979g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f980h;

    /* renamed from: i  reason: collision with root package name */
    public m.a f981i;

    /* renamed from: j  reason: collision with root package name */
    public k f982j;

    /* renamed from: k  reason: collision with root package name */
    public PopupWindow.OnDismissListener f983k;

    /* renamed from: l  reason: collision with root package name */
    public final PopupWindow.OnDismissListener f984l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        public void onDismiss() {
            l.this.e();
        }
    }

    public l(Context context, g gVar, View view, boolean z10, int i10) {
        this(context, gVar, view, z10, i10, 0);
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.m, androidx.appcompat.view.menu.k] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.q] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.d] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.appcompat.view.menu.k a() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f973a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            r0.getRealSize(r1)
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f973a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R$dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x002e
            r0 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 == 0) goto L_0x0042
            androidx.appcompat.view.menu.d r0 = new androidx.appcompat.view.menu.d
            android.content.Context r2 = r14.f973a
            android.view.View r3 = r14.f978f
            int r4 = r14.f976d
            int r5 = r14.f977e
            boolean r6 = r14.f975c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0054
        L_0x0042:
            androidx.appcompat.view.menu.q r0 = new androidx.appcompat.view.menu.q
            android.content.Context r8 = r14.f973a
            androidx.appcompat.view.menu.g r9 = r14.f974b
            android.view.View r10 = r14.f978f
            int r11 = r14.f976d
            int r12 = r14.f977e
            boolean r13 = r14.f975c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0054:
            androidx.appcompat.view.menu.g r1 = r14.f974b
            r0.a(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f984l
            r0.j(r1)
            android.view.View r1 = r14.f978f
            r0.e(r1)
            androidx.appcompat.view.menu.m$a r1 = r14.f981i
            r0.setCallback(r1)
            boolean r1 = r14.f980h
            r0.g(r1)
            int r1 = r14.f979g
            r0.h(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.l.a():androidx.appcompat.view.menu.k");
    }

    public void b() {
        if (d()) {
            this.f982j.dismiss();
        }
    }

    public k c() {
        if (this.f982j == null) {
            this.f982j = a();
        }
        return this.f982j;
    }

    public boolean d() {
        k kVar = this.f982j;
        if (kVar == null || !kVar.isShowing()) {
            return false;
        }
        return true;
    }

    public void e() {
        this.f982j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f983k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f978f = view;
    }

    public void g(boolean z10) {
        this.f980h = z10;
        k kVar = this.f982j;
        if (kVar != null) {
            kVar.g(z10);
        }
    }

    public void h(int i10) {
        this.f979g = i10;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f983k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.f981i = aVar;
        k kVar = this.f982j;
        if (kVar != null) {
            kVar.setCallback(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i10, int i11, boolean z10, boolean z11) {
        k c10 = c();
        c10.k(z11);
        if (z10) {
            if ((j.b(this.f979g, c1.z(this.f978f)) & 7) == 5) {
                i10 -= this.f978f.getWidth();
            }
            c10.i(i10);
            c10.l(i11);
            int i12 = (int) ((this.f973a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c10.f(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        c10.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f978f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i10, int i11) {
        if (d()) {
            return true;
        }
        if (this.f978f == null) {
            return false;
        }
        l(i10, i11, true, true);
        return true;
    }

    public l(Context context, g gVar, View view, boolean z10, int i10, int i11) {
        this.f979g = 8388611;
        this.f984l = new a();
        this.f973a = context;
        this.f974b = gVar;
        this.f978f = view;
        this.f975c = z10;
        this.f976d = i10;
        this.f977e = i11;
    }
}
