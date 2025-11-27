package androidx.recyclerview.widget;

import android.view.View;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public final b f3011a;

    /* renamed from: b  reason: collision with root package name */
    public a f3012b = new a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3013a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f3014b;

        /* renamed from: c  reason: collision with root package name */
        public int f3015c;

        /* renamed from: d  reason: collision with root package name */
        public int f3016d;

        /* renamed from: e  reason: collision with root package name */
        public int f3017e;

        public void a(int i10) {
            this.f3013a = i10 | this.f3013a;
        }

        public boolean b() {
            int i10 = this.f3013a;
            if ((i10 & 7) != 0 && (i10 & (c(this.f3016d, this.f3014b) << 0)) == 0) {
                return false;
            }
            int i11 = this.f3013a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f3016d, this.f3015c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f3013a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f3017e, this.f3014b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f3013a;
            if ((i13 & 28672) == 0 || (i13 & (c(this.f3017e, this.f3015c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        public void d() {
            this.f3013a = 0;
        }

        public void e(int i10, int i11, int i12, int i13) {
            this.f3014b = i10;
            this.f3015c = i11;
            this.f3016d = i12;
            this.f3017e = i13;
        }
    }

    public interface b {
        View a(int i10);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    public s(b bVar) {
        this.f3011a = bVar;
    }

    public View a(int i10, int i11, int i12, int i13) {
        int i14;
        int c10 = this.f3011a.c();
        int d10 = this.f3011a.d();
        if (i11 > i10) {
            i14 = 1;
        } else {
            i14 = -1;
        }
        View view = null;
        while (i10 != i11) {
            View a10 = this.f3011a.a(i10);
            this.f3012b.e(c10, d10, this.f3011a.b(a10), this.f3011a.e(a10));
            if (i12 != 0) {
                this.f3012b.d();
                this.f3012b.a(i12);
                if (this.f3012b.b()) {
                    return a10;
                }
            }
            if (i13 != 0) {
                this.f3012b.d();
                this.f3012b.a(i13);
                if (this.f3012b.b()) {
                    view = a10;
                }
            }
            i10 += i14;
        }
        return view;
    }

    public boolean b(View view, int i10) {
        this.f3012b.e(this.f3011a.c(), this.f3011a.d(), this.f3011a.b(view), this.f3011a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f3012b.d();
        this.f3012b.a(i10);
        return this.f3012b.b();
    }
}
