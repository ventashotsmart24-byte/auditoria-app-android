package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class q extends RecyclerView.l {

    /* renamed from: g  reason: collision with root package name */
    public boolean f3004g = true;

    public final void A(RecyclerView.d0 d0Var) {
        I(d0Var);
        h(d0Var);
    }

    public final void B(RecyclerView.d0 d0Var) {
        J(d0Var);
    }

    public final void C(RecyclerView.d0 d0Var, boolean z10) {
        K(d0Var, z10);
        h(d0Var);
    }

    public final void D(RecyclerView.d0 d0Var, boolean z10) {
        L(d0Var, z10);
    }

    public final void E(RecyclerView.d0 d0Var) {
        M(d0Var);
        h(d0Var);
    }

    public final void F(RecyclerView.d0 d0Var) {
        N(d0Var);
    }

    public final void G(RecyclerView.d0 d0Var) {
        O(d0Var);
        h(d0Var);
    }

    public final void H(RecyclerView.d0 d0Var) {
        P(d0Var);
    }

    public void I(RecyclerView.d0 d0Var) {
    }

    public void J(RecyclerView.d0 d0Var) {
    }

    public void K(RecyclerView.d0 d0Var, boolean z10) {
    }

    public void L(RecyclerView.d0 d0Var, boolean z10) {
    }

    public void M(RecyclerView.d0 d0Var) {
    }

    public void N(RecyclerView.d0 d0Var) {
    }

    public void O(RecyclerView.d0 d0Var) {
    }

    public void P(RecyclerView.d0 d0Var) {
    }

    public boolean a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i10;
        int i11;
        if (bVar == null || ((i10 = bVar.f2778a) == (i11 = bVar2.f2778a) && bVar.f2779b == bVar2.f2779b)) {
            return w(d0Var);
        }
        return y(d0Var, i10, bVar.f2779b, i11, bVar2.f2779b);
    }

    public boolean b(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i10;
        int i11;
        int i12 = bVar.f2778a;
        int i13 = bVar.f2779b;
        if (d0Var2.shouldIgnore()) {
            int i14 = bVar.f2778a;
            i10 = bVar.f2779b;
            i11 = i14;
        } else {
            i11 = bVar2.f2778a;
            i10 = bVar2.f2779b;
        }
        return x(d0Var, d0Var2, i12, i13, i11, i10);
    }

    public boolean c(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i10;
        int i11;
        int i12 = bVar.f2778a;
        int i13 = bVar.f2779b;
        View view = d0Var.itemView;
        if (bVar2 == null) {
            i10 = view.getLeft();
        } else {
            i10 = bVar2.f2778a;
        }
        int i14 = i10;
        if (bVar2 == null) {
            i11 = view.getTop();
        } else {
            i11 = bVar2.f2779b;
        }
        int i15 = i11;
        if (d0Var.isRemoved() || (i12 == i14 && i13 == i15)) {
            return z(d0Var);
        }
        view.layout(i14, i15, view.getWidth() + i14, view.getHeight() + i15);
        return y(d0Var, i12, i13, i14, i15);
    }

    public boolean d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i10 = bVar.f2778a;
        int i11 = bVar2.f2778a;
        if (i10 == i11 && bVar.f2779b == bVar2.f2779b) {
            E(d0Var);
            return false;
        }
        return y(d0Var, i10, bVar.f2779b, i11, bVar2.f2779b);
    }

    public boolean f(RecyclerView.d0 d0Var) {
        if (!this.f3004g || d0Var.isInvalid()) {
            return true;
        }
        return false;
    }

    public abstract boolean w(RecyclerView.d0 d0Var);

    public abstract boolean x(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13);

    public abstract boolean y(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13);

    public abstract boolean z(RecyclerView.d0 d0Var);
}
