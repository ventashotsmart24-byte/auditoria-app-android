package androidx.recyclerview.widget;

import a0.e;
import a0.f;
import androidx.collection.d;
import androidx.collection.g;
import androidx.recyclerview.widget.RecyclerView;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public final g f3018a = new g();

    /* renamed from: b  reason: collision with root package name */
    public final d f3019b = new d();

    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static e f3020d = new f(20);

        /* renamed from: a  reason: collision with root package name */
        public int f3021a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.l.b f3022b;

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView.l.b f3023c;

        public static void a() {
            do {
            } while (f3020d.acquire() != null);
        }

        public static a b() {
            a aVar = (a) f3020d.acquire();
            if (aVar == null) {
                return new a();
            }
            return aVar;
        }

        public static void c(a aVar) {
            aVar.f3021a = 0;
            aVar.f3022b = null;
            aVar.f3023c = null;
            f3020d.release(aVar);
        }
    }

    public interface b {
        void a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void b(RecyclerView.d0 d0Var);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);
    }

    public void a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        a aVar = (a) this.f3018a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3018a.put(d0Var, aVar);
        }
        aVar.f3021a |= 2;
        aVar.f3022b = bVar;
    }

    public void b(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f3018a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3018a.put(d0Var, aVar);
        }
        aVar.f3021a |= 1;
    }

    public void c(long j10, RecyclerView.d0 d0Var) {
        this.f3019b.j(j10, d0Var);
    }

    public void d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        a aVar = (a) this.f3018a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3018a.put(d0Var, aVar);
        }
        aVar.f3023c = bVar;
        aVar.f3021a |= 8;
    }

    public void e(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        a aVar = (a) this.f3018a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3018a.put(d0Var, aVar);
        }
        aVar.f3022b = bVar;
        aVar.f3021a |= 4;
    }

    public void f() {
        this.f3018a.clear();
        this.f3019b.b();
    }

    public RecyclerView.d0 g(long j10) {
        return (RecyclerView.d0) this.f3019b.f(j10);
    }

    public boolean h(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f3018a.get(d0Var);
        if (aVar == null || (aVar.f3021a & 1) == 0) {
            return false;
        }
        return true;
    }

    public boolean i(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f3018a.get(d0Var);
        if (aVar == null || (aVar.f3021a & 4) == 0) {
            return false;
        }
        return true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    public final RecyclerView.l.b l(RecyclerView.d0 d0Var, int i10) {
        a aVar;
        RecyclerView.l.b bVar;
        int indexOfKey = this.f3018a.indexOfKey(d0Var);
        if (indexOfKey >= 0 && (aVar = (a) this.f3018a.valueAt(indexOfKey)) != null) {
            int i11 = aVar.f3021a;
            if ((i11 & i10) != 0) {
                int i12 = (i10 ^ -1) & i11;
                aVar.f3021a = i12;
                if (i10 == 4) {
                    bVar = aVar.f3022b;
                } else if (i10 == 8) {
                    bVar = aVar.f3023c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i12 & 12) == 0) {
                    this.f3018a.removeAt(indexOfKey);
                    a.c(aVar);
                }
                return bVar;
            }
        }
        return null;
    }

    public RecyclerView.l.b m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    public RecyclerView.l.b n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    public void o(b bVar) {
        for (int size = this.f3018a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 d0Var = (RecyclerView.d0) this.f3018a.keyAt(size);
            a aVar = (a) this.f3018a.removeAt(size);
            int i10 = aVar.f3021a;
            if ((i10 & 3) == 3) {
                bVar.b(d0Var);
            } else if ((i10 & 1) != 0) {
                RecyclerView.l.b bVar2 = aVar.f3022b;
                if (bVar2 == null) {
                    bVar.b(d0Var);
                } else {
                    bVar.c(d0Var, bVar2, aVar.f3023c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.a(d0Var, aVar.f3022b, aVar.f3023c);
            } else if ((i10 & 12) == 12) {
                bVar.d(d0Var, aVar.f3022b, aVar.f3023c);
            } else if ((i10 & 4) != 0) {
                bVar.c(d0Var, aVar.f3022b, (RecyclerView.l.b) null);
            } else if ((i10 & 8) != 0) {
                bVar.a(d0Var, aVar.f3022b, aVar.f3023c);
            }
            a.c(aVar);
        }
    }

    public void p(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f3018a.get(d0Var);
        if (aVar != null) {
            aVar.f3021a &= -2;
        }
    }

    public void q(RecyclerView.d0 d0Var) {
        int m10 = this.f3019b.m() - 1;
        while (true) {
            if (m10 < 0) {
                break;
            } else if (d0Var == this.f3019b.n(m10)) {
                this.f3019b.l(m10);
                break;
            } else {
                m10--;
            }
        }
        a aVar = (a) this.f3018a.remove(d0Var);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
