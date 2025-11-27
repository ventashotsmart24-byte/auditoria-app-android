package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.g0;
import androidx.transition.n;
import java.util.ArrayList;
import java.util.List;

public class e extends g0 {

    public class a extends n.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f3196a;

        public a(Rect rect) {
            this.f3196a = rect;
        }

        public Rect a(n nVar) {
            return this.f3196a;
        }
    }

    public class b implements n.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f3198a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3199b;

        public b(View view, ArrayList arrayList) {
            this.f3198a = view;
            this.f3199b = arrayList;
        }

        public void a(n nVar) {
        }

        public void b(n nVar) {
        }

        public void c(n nVar) {
        }

        public void d(n nVar) {
            nVar.removeListener(this);
            this.f3198a.setVisibility(8);
            int size = this.f3199b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f3199b.get(i10)).setVisibility(0);
            }
        }

        public void e(n nVar) {
        }
    }

    public class c extends o {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f3201a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3202b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f3203c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3204d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f3205e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3206f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f3201a = obj;
            this.f3202b = arrayList;
            this.f3203c = obj2;
            this.f3204d = arrayList2;
            this.f3205e = obj3;
            this.f3206f = arrayList3;
        }

        public void b(n nVar) {
            Object obj = this.f3201a;
            if (obj != null) {
                e.this.q(obj, this.f3202b, (ArrayList) null);
            }
            Object obj2 = this.f3203c;
            if (obj2 != null) {
                e.this.q(obj2, this.f3204d, (ArrayList) null);
            }
            Object obj3 = this.f3205e;
            if (obj3 != null) {
                e.this.q(obj3, this.f3206f, (ArrayList) null);
            }
        }

        public void d(n nVar) {
            nVar.removeListener(this);
        }
    }

    public class d extends n.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f3208a;

        public d(Rect rect) {
            this.f3208a = rect;
        }

        public Rect a(n nVar) {
            Rect rect = this.f3208a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f3208a;
        }
    }

    public static boolean C(n nVar) {
        if (!g0.l(nVar.getTargetIds()) || !g0.l(nVar.getTargetNames()) || !g0.l(nVar.getTargetTypes())) {
            return true;
        }
        return false;
    }

    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        r rVar = (r) obj;
        if (rVar != null) {
            rVar.getTargets().clear();
            rVar.getTargets().addAll(arrayList2);
            q(rVar, arrayList, arrayList2);
        }
    }

    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        r rVar = new r();
        rVar.w((n) obj);
        return rVar;
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((n) obj).addTarget(view);
        }
    }

    public void b(Object obj, ArrayList arrayList) {
        n nVar = (n) obj;
        if (nVar != null) {
            int i10 = 0;
            if (nVar instanceof r) {
                r rVar = (r) nVar;
                int z10 = rVar.z();
                while (i10 < z10) {
                    b(rVar.y(i10), arrayList);
                    i10++;
                }
            } else if (!C(nVar) && g0.l(nVar.getTargets())) {
                int size = arrayList.size();
                while (i10 < size) {
                    nVar.addTarget((View) arrayList.get(i10));
                    i10++;
                }
            }
        }
    }

    public void c(ViewGroup viewGroup, Object obj) {
        p.a(viewGroup, (n) obj);
    }

    public boolean e(Object obj) {
        return obj instanceof n;
    }

    public Object g(Object obj) {
        if (obj != null) {
            return ((n) obj).clone();
        }
        return null;
    }

    public Object m(Object obj, Object obj2, Object obj3) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        n nVar3 = (n) obj3;
        if (nVar != null && nVar2 != null) {
            nVar = new r().w(nVar).w(nVar2).H(1);
        } else if (nVar == null) {
            if (nVar2 != null) {
                nVar = nVar2;
            } else {
                nVar = null;
            }
        }
        if (nVar3 == null) {
            return nVar;
        }
        r rVar = new r();
        if (nVar != null) {
            rVar.w(nVar);
        }
        rVar.w(nVar3);
        return rVar;
    }

    public Object n(Object obj, Object obj2, Object obj3) {
        r rVar = new r();
        if (obj != null) {
            rVar.w((n) obj);
        }
        if (obj2 != null) {
            rVar.w((n) obj2);
        }
        if (obj3 != null) {
            rVar.w((n) obj3);
        }
        return rVar;
    }

    public void p(Object obj, View view) {
        if (obj != null) {
            ((n) obj).removeTarget(view);
        }
    }

    public void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        int i10;
        n nVar = (n) obj;
        int i11 = 0;
        if (nVar instanceof r) {
            r rVar = (r) nVar;
            int z10 = rVar.z();
            while (i11 < z10) {
                q(rVar.y(i11), arrayList, arrayList2);
                i11++;
            }
        } else if (!C(nVar)) {
            List<View> targets = nVar.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i10 = 0;
                } else {
                    i10 = arrayList2.size();
                }
                while (i11 < i10) {
                    nVar.addTarget((View) arrayList2.get(i11));
                    i11++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    nVar.removeTarget((View) arrayList.get(size));
                }
            }
        }
    }

    public void r(Object obj, View view, ArrayList arrayList) {
        ((n) obj).addListener(new b(view, arrayList));
    }

    public void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((n) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((n) obj).setEpicenterCallback(new d(rect));
        }
    }

    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((n) obj).setEpicenterCallback(new a(rect));
        }
    }

    public void z(Object obj, View view, ArrayList arrayList) {
        r rVar = (r) obj;
        List<View> targets = rVar.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            g0.d(targets, (View) arrayList.get(i10));
        }
        targets.add(view);
        arrayList.add(view);
        b(rVar, arrayList);
    }
}
