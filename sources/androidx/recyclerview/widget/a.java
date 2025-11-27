package androidx.recyclerview.widget;

import a0.e;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.List;

public class a implements l.a {

    /* renamed from: a  reason: collision with root package name */
    public e f2872a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f2873b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2874c;

    /* renamed from: d  reason: collision with root package name */
    public final C0040a f2875d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f2876e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2877f;

    /* renamed from: g  reason: collision with root package name */
    public final l f2878g;

    /* renamed from: h  reason: collision with root package name */
    public int f2879h;

    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    public interface C0040a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(b bVar);

        void d(int i10, int i11);

        void e(int i10, int i11, Object obj);

        RecyclerView.d0 f(int i10);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2880a;

        /* renamed from: b  reason: collision with root package name */
        public int f2881b;

        /* renamed from: c  reason: collision with root package name */
        public Object f2882c;

        /* renamed from: d  reason: collision with root package name */
        public int f2883d;

        public b(int i10, int i11, int i12, Object obj) {
            this.f2880a = i10;
            this.f2881b = i11;
            this.f2883d = i12;
            this.f2882c = obj;
        }

        public String a() {
            int i10 = this.f2880a;
            if (i10 == 1) {
                return "add";
            }
            if (i10 == 2) {
                return "rm";
            }
            if (i10 == 4) {
                return f.R;
            }
            if (i10 != 8) {
                return "??";
            }
            return "mv";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f2880a;
            if (i10 != bVar.f2880a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f2883d - this.f2881b) == 1 && this.f2883d == bVar.f2881b && this.f2881b == bVar.f2883d) {
                return true;
            }
            if (this.f2883d != bVar.f2883d || this.f2881b != bVar.f2881b) {
                return false;
            }
            Object obj2 = this.f2882c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f2882c)) {
                    return false;
                }
            } else if (bVar.f2882c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f2880a * 31) + this.f2881b) * 31) + this.f2883d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f2881b + "c:" + this.f2883d + ",p:" + this.f2882c + "]";
        }
    }

    public a(C0040a aVar) {
        this(aVar, false);
    }

    public b a(int i10, int i11, int i12, Object obj) {
        b bVar = (b) this.f2872a.acquire();
        if (bVar == null) {
            return new b(i10, i11, i12, obj);
        }
        bVar.f2880a = i10;
        bVar.f2881b = i11;
        bVar.f2883d = i12;
        bVar.f2882c = obj;
        return bVar;
    }

    public void b(b bVar) {
        if (!this.f2877f) {
            bVar.f2882c = null;
            this.f2872a.release(bVar);
        }
    }

    public final void c(b bVar) {
        v(bVar);
    }

    public final void d(b bVar) {
        v(bVar);
    }

    public int e(int i10) {
        int size = this.f2873b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f2873b.get(i11);
            int i12 = bVar.f2880a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f2881b;
                    if (i13 <= i10) {
                        int i14 = bVar.f2883d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f2881b;
                    if (i15 == i10) {
                        i10 = bVar.f2883d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f2883d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f2881b <= i10) {
                i10 += bVar.f2883d;
            }
        }
        return i10;
    }

    public final void f(b bVar) {
        char c10;
        boolean z10;
        boolean z11;
        int i10 = bVar.f2881b;
        int i11 = bVar.f2883d + i10;
        char c11 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f2875d.f(i12) != null || h(i12)) {
                if (c11 == 0) {
                    k(a(2, i10, i13, (Object) null));
                    z11 = true;
                } else {
                    z11 = false;
                }
                c10 = 1;
            } else {
                if (c11 == 1) {
                    v(a(2, i10, i13, (Object) null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f2883d) {
            b(bVar);
            bVar = a(2, i10, i13, (Object) null);
        }
        if (c11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final void g(b bVar) {
        int i10 = bVar.f2881b;
        int i11 = bVar.f2883d + i10;
        int i12 = i10;
        char c10 = 65535;
        int i13 = 0;
        while (i10 < i11) {
            if (this.f2875d.f(i10) != null || h(i10)) {
                if (c10 == 0) {
                    k(a(4, i12, i13, bVar.f2882c));
                    i12 = i10;
                    i13 = 0;
                }
                c10 = 1;
            } else {
                if (c10 == 1) {
                    v(a(4, i12, i13, bVar.f2882c));
                    i12 = i10;
                    i13 = 0;
                }
                c10 = 0;
            }
            i13++;
            i10++;
        }
        if (i13 != bVar.f2883d) {
            Object obj = bVar.f2882c;
            b(bVar);
            bVar = a(4, i12, i13, obj);
        }
        if (c10 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final boolean h(int i10) {
        int size = this.f2874c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f2874c.get(i11);
            int i12 = bVar.f2880a;
            if (i12 == 8) {
                if (n(bVar.f2883d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f2881b;
                int i14 = bVar.f2883d + i13;
                while (i13 < i14) {
                    if (n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.f2874c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f2875d.c((b) this.f2874c.get(i10));
        }
        x(this.f2874c);
        this.f2879h = 0;
    }

    public void j() {
        i();
        int size = this.f2873b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f2873b.get(i10);
            int i11 = bVar.f2880a;
            if (i11 == 1) {
                this.f2875d.c(bVar);
                this.f2875d.g(bVar.f2881b, bVar.f2883d);
            } else if (i11 == 2) {
                this.f2875d.c(bVar);
                this.f2875d.h(bVar.f2881b, bVar.f2883d);
            } else if (i11 == 4) {
                this.f2875d.c(bVar);
                this.f2875d.e(bVar.f2881b, bVar.f2883d, bVar.f2882c);
            } else if (i11 == 8) {
                this.f2875d.c(bVar);
                this.f2875d.a(bVar.f2881b, bVar.f2883d);
            }
            Runnable runnable = this.f2876e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f2873b);
        this.f2879h = 0;
    }

    public final void k(b bVar) {
        int i10;
        boolean z10;
        int i11 = bVar.f2880a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z11 = z(bVar.f2881b, i11);
        int i12 = bVar.f2881b;
        int i13 = bVar.f2880a;
        if (i13 == 2) {
            i10 = 0;
        } else if (i13 == 4) {
            i10 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f2883d; i15++) {
            int z12 = z(bVar.f2881b + (i10 * i15), bVar.f2880a);
            int i16 = bVar.f2880a;
            if (i16 == 2 ? z12 != z11 : !(i16 == 4 && z12 == z11 + 1)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                i14++;
            } else {
                b a10 = a(i16, z11, i14, bVar.f2882c);
                l(a10, i12);
                b(a10);
                if (bVar.f2880a == 4) {
                    i12 += i14;
                }
                z11 = z12;
                i14 = 1;
            }
        }
        Object obj = bVar.f2882c;
        b(bVar);
        if (i14 > 0) {
            b a11 = a(bVar.f2880a, z11, i14, obj);
            l(a11, i12);
            b(a11);
        }
    }

    public void l(b bVar, int i10) {
        this.f2875d.b(bVar);
        int i11 = bVar.f2880a;
        if (i11 == 2) {
            this.f2875d.h(i10, bVar.f2883d);
        } else if (i11 == 4) {
            this.f2875d.e(i10, bVar.f2883d, bVar.f2882c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public int m(int i10) {
        return n(i10, 0);
    }

    public int n(int i10, int i11) {
        int size = this.f2874c.size();
        while (i11 < size) {
            b bVar = (b) this.f2874c.get(i11);
            int i12 = bVar.f2880a;
            if (i12 == 8) {
                int i13 = bVar.f2881b;
                if (i13 == i10) {
                    i10 = bVar.f2883d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f2883d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f2881b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f2883d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f2883d;
                }
            }
            i11++;
        }
        return i10;
    }

    public boolean o(int i10) {
        if ((i10 & this.f2879h) != 0) {
            return true;
        }
        return false;
    }

    public boolean p() {
        if (this.f2873b.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (this.f2874c.isEmpty() || this.f2873b.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f2873b.add(a(4, i10, i11, obj));
        this.f2879h |= 4;
        if (this.f2873b.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f2873b.add(a(1, i10, i11, (Object) null));
        this.f2879h |= 1;
        if (this.f2873b.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 == 1) {
            this.f2873b.add(a(8, i10, i11, (Object) null));
            this.f2879h |= 8;
            if (this.f2873b.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public boolean u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f2873b.add(a(2, i10, i11, (Object) null));
        this.f2879h |= 2;
        if (this.f2873b.size() == 1) {
            return true;
        }
        return false;
    }

    public final void v(b bVar) {
        this.f2874c.add(bVar);
        int i10 = bVar.f2880a;
        if (i10 == 1) {
            this.f2875d.g(bVar.f2881b, bVar.f2883d);
        } else if (i10 == 2) {
            this.f2875d.d(bVar.f2881b, bVar.f2883d);
        } else if (i10 == 4) {
            this.f2875d.e(bVar.f2881b, bVar.f2883d, bVar.f2882c);
        } else if (i10 == 8) {
            this.f2875d.a(bVar.f2881b, bVar.f2883d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void w() {
        this.f2878g.b(this.f2873b);
        int size = this.f2873b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f2873b.get(i10);
            int i11 = bVar.f2880a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                f(bVar);
            } else if (i11 == 4) {
                g(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f2876e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f2873b.clear();
    }

    public void x(List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            b((b) list.get(i10));
        }
        list.clear();
    }

    public void y() {
        x(this.f2873b);
        x(this.f2874c);
        this.f2879h = 0;
    }

    public final int z(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f2874c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f2874c.get(size);
            int i14 = bVar.f2880a;
            if (i14 == 8) {
                int i15 = bVar.f2881b;
                int i16 = bVar.f2883d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f2881b = i15 + 1;
                            bVar.f2883d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f2881b = i15 - 1;
                            bVar.f2883d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f2883d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f2883d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f2881b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f2881b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f2881b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f2883d;
                    } else if (i14 == 2) {
                        i10 += bVar.f2883d;
                    }
                } else if (i11 == 1) {
                    bVar.f2881b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f2881b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f2874c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f2874c.get(size2);
            if (bVar2.f2880a == 8) {
                int i18 = bVar2.f2883d;
                if (i18 == bVar2.f2881b || i18 < 0) {
                    this.f2874c.remove(size2);
                    b(bVar2);
                }
            } else if (bVar2.f2883d <= 0) {
                this.f2874c.remove(size2);
                b(bVar2);
            }
        }
        return i10;
    }

    public a(C0040a aVar, boolean z10) {
        this.f2872a = new a0.f(30);
        this.f2873b = new ArrayList();
        this.f2874c = new ArrayList();
        this.f2879h = 0;
        this.f2875d = aVar;
        this.f2877f = z10;
        this.f2878g = new l(this);
    }
}
