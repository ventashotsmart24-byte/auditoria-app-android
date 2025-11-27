package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final C0041b f2884a;

    /* renamed from: b  reason: collision with root package name */
    public final a f2885b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final List f2886c = new ArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f2887a = 0;

        /* renamed from: b  reason: collision with root package name */
        public a f2888b;

        public void a(int i10) {
            if (i10 >= 64) {
                a aVar = this.f2888b;
                if (aVar != null) {
                    aVar.a(i10 - 64);
                    return;
                }
                return;
            }
            this.f2887a &= (1 << i10) ^ -1;
        }

        public int b(int i10) {
            a aVar = this.f2888b;
            if (aVar == null) {
                if (i10 >= 64) {
                    return Long.bitCount(this.f2887a);
                }
                return Long.bitCount(this.f2887a & ((1 << i10) - 1));
            } else if (i10 < 64) {
                return Long.bitCount(this.f2887a & ((1 << i10) - 1));
            } else {
                return aVar.b(i10 - 64) + Long.bitCount(this.f2887a);
            }
        }

        public final void c() {
            if (this.f2888b == null) {
                this.f2888b = new a();
            }
        }

        public boolean d(int i10) {
            if (i10 >= 64) {
                c();
                return this.f2888b.d(i10 - 64);
            } else if ((this.f2887a & (1 << i10)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        public void e(int i10, boolean z10) {
            boolean z11;
            if (i10 >= 64) {
                c();
                this.f2888b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f2887a;
            if ((Long.MIN_VALUE & j10) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            long j11 = (1 << i10) - 1;
            this.f2887a = ((j10 & (j11 ^ -1)) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f2888b != null) {
                c();
                this.f2888b.e(0, z11);
            }
        }

        public boolean f(int i10) {
            boolean z10;
            if (i10 >= 64) {
                c();
                return this.f2888b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f2887a;
            if ((j11 & j10) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            long j12 = j11 & (j10 ^ -1);
            this.f2887a = j12;
            long j13 = j10 - 1;
            this.f2887a = (j12 & j13) | Long.rotateRight((j13 ^ -1) & j12, 1);
            a aVar = this.f2888b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f2888b.f(0);
            }
            return z10;
        }

        public void g() {
            this.f2887a = 0;
            a aVar = this.f2888b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i10) {
            if (i10 >= 64) {
                c();
                this.f2888b.h(i10 - 64);
                return;
            }
            this.f2887a |= 1 << i10;
        }

        public String toString() {
            if (this.f2888b == null) {
                return Long.toBinaryString(this.f2887a);
            }
            return this.f2888b.toString() + "xx" + Long.toBinaryString(this.f2887a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    public interface C0041b {
        View a(int i10);

        void b(View view);

        int c();

        RecyclerView.d0 d(View view);

        void e(int i10);

        void f(View view, int i10);

        void g();

        int h(View view);

        void i(View view);

        void j(int i10);

        void k(View view, int i10, ViewGroup.LayoutParams layoutParams);
    }

    public b(C0041b bVar) {
        this.f2884a = bVar;
    }

    public void a(View view, int i10, boolean z10) {
        int i11;
        if (i10 < 0) {
            i11 = this.f2884a.c();
        } else {
            i11 = h(i10);
        }
        this.f2885b.e(i11, z10);
        if (z10) {
            l(view);
        }
        this.f2884a.f(view, i11);
    }

    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int i11;
        if (i10 < 0) {
            i11 = this.f2884a.c();
        } else {
            i11 = h(i10);
        }
        this.f2885b.e(i11, z10);
        if (z10) {
            l(view);
        }
        this.f2884a.k(view, i11, layoutParams);
    }

    public void d(int i10) {
        int h10 = h(i10);
        this.f2885b.f(h10);
        this.f2884a.e(h10);
    }

    public View e(int i10) {
        int size = this.f2886c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) this.f2886c.get(i11);
            RecyclerView.d0 d10 = this.f2884a.d(view);
            if (d10.getLayoutPosition() == i10 && !d10.isInvalid() && !d10.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i10) {
        return this.f2884a.a(h(i10));
    }

    public int g() {
        return this.f2884a.c() - this.f2886c.size();
    }

    public final int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int c10 = this.f2884a.c();
        int i11 = i10;
        while (i11 < c10) {
            int b10 = i10 - (i11 - this.f2885b.b(i11));
            if (b10 == 0) {
                while (this.f2885b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += b10;
        }
        return -1;
    }

    public View i(int i10) {
        return this.f2884a.a(i10);
    }

    public int j() {
        return this.f2884a.c();
    }

    public void k(View view) {
        int h10 = this.f2884a.h(view);
        if (h10 >= 0) {
            this.f2885b.h(h10);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public final void l(View view) {
        this.f2886c.add(view);
        this.f2884a.b(view);
    }

    public int m(View view) {
        int h10 = this.f2884a.h(view);
        if (h10 != -1 && !this.f2885b.d(h10)) {
            return h10 - this.f2885b.b(h10);
        }
        return -1;
    }

    public boolean n(View view) {
        return this.f2886c.contains(view);
    }

    public void o() {
        this.f2885b.g();
        for (int size = this.f2886c.size() - 1; size >= 0; size--) {
            this.f2884a.i((View) this.f2886c.get(size));
            this.f2886c.remove(size);
        }
        this.f2884a.g();
    }

    public void p(View view) {
        int h10 = this.f2884a.h(view);
        if (h10 >= 0) {
            if (this.f2885b.f(h10)) {
                t(view);
            }
            this.f2884a.j(h10);
        }
    }

    public void q(int i10) {
        int h10 = h(i10);
        View a10 = this.f2884a.a(h10);
        if (a10 != null) {
            if (this.f2885b.f(h10)) {
                t(a10);
            }
            this.f2884a.j(h10);
        }
    }

    public boolean r(View view) {
        int h10 = this.f2884a.h(view);
        if (h10 == -1) {
            t(view);
            return true;
        } else if (!this.f2885b.d(h10)) {
            return false;
        } else {
            this.f2885b.f(h10);
            t(view);
            this.f2884a.j(h10);
            return true;
        }
    }

    public void s(View view) {
        int h10 = this.f2884a.h(view);
        if (h10 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2885b.d(h10)) {
            this.f2885b.a(h10);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f2886c.remove(view)) {
            return false;
        }
        this.f2884a.i(view);
        return true;
    }

    public String toString() {
        return this.f2885b.toString() + ", hidden list:" + this.f2886c.size();
    }
}
