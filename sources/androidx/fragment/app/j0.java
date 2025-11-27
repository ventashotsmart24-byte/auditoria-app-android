package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import b0.c1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import x.b;

public abstract class j0 {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f2035a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f2036b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2037c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f2038d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2039e = false;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2040a;

        public a(d dVar) {
            this.f2040a = dVar;
        }

        public void run() {
            if (j0.this.f2036b.contains(this.f2040a)) {
                this.f2040a.e().a(this.f2040a.f().mView);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2042a;

        public b(d dVar) {
            this.f2042a = dVar;
        }

        public void run() {
            j0.this.f2036b.remove(this.f2042a);
            j0.this.f2037c.remove(this.f2042a);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2044a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f2045b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.j0$e$b[] r0 = androidx.fragment.app.j0.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2045b = r0
                r1 = 1
                androidx.fragment.app.j0$e$b r2 = androidx.fragment.app.j0.e.b.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f2045b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.j0$e$b r3 = androidx.fragment.app.j0.e.b.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f2045b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.j0$e$b r4 = androidx.fragment.app.j0.e.b.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.j0$e$c[] r3 = androidx.fragment.app.j0.e.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f2044a = r3
                androidx.fragment.app.j0$e$c r4 = androidx.fragment.app.j0.e.c.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f2044a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.j0$e$c r3 = androidx.fragment.app.j0.e.c.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f2044a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.j0$e$c r1 = androidx.fragment.app.j0.e.c.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f2044a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.j0$e$c r1 = androidx.fragment.app.j0.e.c.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j0.c.<clinit>():void");
        }
    }

    public static class d extends e {

        /* renamed from: h  reason: collision with root package name */
        public final v f2046h;

        public d(e.c cVar, e.b bVar, v vVar, x.b bVar2) {
            super(cVar, bVar, vVar.k(), bVar2);
            this.f2046h = vVar;
        }

        public void c() {
            super.c();
            this.f2046h.m();
        }

        public void l() {
            if (g() == e.b.ADDING) {
                Fragment k10 = this.f2046h.k();
                View findFocus = k10.mView.findFocus();
                if (findFocus != null) {
                    k10.setFocusedView(findFocus);
                    if (o.F0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("requestFocus: Saved focused view ");
                        sb.append(findFocus);
                        sb.append(" for Fragment ");
                        sb.append(k10);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f2046h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k10.getPostOnViewCreatedAlpha());
            }
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public c f2047a;

        /* renamed from: b  reason: collision with root package name */
        public b f2048b;

        /* renamed from: c  reason: collision with root package name */
        public final Fragment f2049c;

        /* renamed from: d  reason: collision with root package name */
        public final List f2050d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public final HashSet f2051e = new HashSet();

        /* renamed from: f  reason: collision with root package name */
        public boolean f2052f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2053g = false;

        public class a implements b.a {
            public a() {
            }

            public void a() {
                e.this.b();
            }
        }

        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c b(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i10);
            }

            public static c c(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return b(view.getVisibility());
            }

            public void a(View view) {
                int i10 = c.f2044a[ordinal()];
                if (i10 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (o.F0(2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SpecialEffectsController: Removing view ");
                            sb.append(view);
                            sb.append(" from container ");
                            sb.append(viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i10 == 2) {
                    if (o.F0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: Setting view ");
                        sb2.append(view);
                        sb2.append(" to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (i10 == 3) {
                    if (o.F0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: Setting view ");
                        sb3.append(view);
                        sb3.append(" to GONE");
                    }
                    view.setVisibility(8);
                } else if (i10 == 4) {
                    if (o.F0(2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("SpecialEffectsController: Setting view ");
                        sb4.append(view);
                        sb4.append(" to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }
        }

        public e(c cVar, b bVar, Fragment fragment, x.b bVar2) {
            this.f2047a = cVar;
            this.f2048b = bVar;
            this.f2049c = fragment;
            bVar2.c(new a());
        }

        public final void a(Runnable runnable) {
            this.f2050d.add(runnable);
        }

        public final void b() {
            if (!h()) {
                this.f2052f = true;
                if (this.f2051e.isEmpty()) {
                    c();
                    return;
                }
                Iterator it = new ArrayList(this.f2051e).iterator();
                while (it.hasNext()) {
                    ((x.b) it.next()).a();
                }
            }
        }

        public void c() {
            if (!this.f2053g) {
                if (o.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    sb.append(this);
                    sb.append(" has called complete.");
                }
                this.f2053g = true;
                for (Runnable run : this.f2050d) {
                    run.run();
                }
            }
        }

        public final void d(x.b bVar) {
            if (this.f2051e.remove(bVar) && this.f2051e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f2047a;
        }

        public final Fragment f() {
            return this.f2049c;
        }

        public b g() {
            return this.f2048b;
        }

        public final boolean h() {
            return this.f2052f;
        }

        public final boolean i() {
            return this.f2053g;
        }

        public final void j(x.b bVar) {
            l();
            this.f2051e.add(bVar);
        }

        public final void k(c cVar, b bVar) {
            int i10 = c.f2045b[bVar.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    if (o.F0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: For fragment ");
                        sb.append(this.f2049c);
                        sb.append(" mFinalState = ");
                        sb.append(this.f2047a);
                        sb.append(" -> REMOVED. mLifecycleImpact  = ");
                        sb.append(this.f2048b);
                        sb.append(" to REMOVING.");
                    }
                    this.f2047a = c.REMOVED;
                    this.f2048b = b.REMOVING;
                } else if (i10 == 3 && this.f2047a != c.REMOVED) {
                    if (o.F0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: For fragment ");
                        sb2.append(this.f2049c);
                        sb2.append(" mFinalState = ");
                        sb2.append(this.f2047a);
                        sb2.append(" -> ");
                        sb2.append(cVar);
                        sb2.append(". ");
                    }
                    this.f2047a = cVar;
                }
            } else if (this.f2047a == c.REMOVED) {
                if (o.F0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: For fragment ");
                    sb3.append(this.f2049c);
                    sb3.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    sb3.append(this.f2048b);
                    sb3.append(" to ADDING.");
                }
                this.f2047a = c.VISIBLE;
                this.f2048b = b.ADDING;
            }
        }

        public abstract void l();

        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.f2047a + "} " + "{" + "mLifecycleImpact = " + this.f2048b + "} " + "{" + "mFragment = " + this.f2049c + "}";
        }
    }

    public j0(ViewGroup viewGroup) {
        this.f2035a = viewGroup;
    }

    public static j0 n(ViewGroup viewGroup, o oVar) {
        return o(viewGroup, oVar.y0());
    }

    public static j0 o(ViewGroup viewGroup, k0 k0Var) {
        int i10 = R$id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof j0) {
            return (j0) tag;
        }
        j0 a10 = k0Var.a(viewGroup);
        viewGroup.setTag(i10, a10);
        return a10;
    }

    public final void a(e.c cVar, e.b bVar, v vVar) {
        synchronized (this.f2036b) {
            x.b bVar2 = new x.b();
            e h10 = h(vVar.k());
            if (h10 != null) {
                h10.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, vVar, bVar2);
            this.f2036b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    public void b(e.c cVar, v vVar) {
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb.append(vVar.k());
        }
        a(cVar, e.b.ADDING, vVar);
    }

    public void c(v vVar) {
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb.append(vVar.k());
        }
        a(e.c.GONE, e.b.NONE, vVar);
    }

    public void d(v vVar) {
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb.append(vVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, vVar);
    }

    public void e(v vVar) {
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb.append(vVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, vVar);
    }

    public abstract void f(List list, boolean z10);

    public void g() {
        if (!this.f2039e) {
            if (!c1.P(this.f2035a)) {
                j();
                this.f2038d = false;
                return;
            }
            synchronized (this.f2036b) {
                if (!this.f2036b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f2037c);
                    this.f2037c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        if (o.F0(2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SpecialEffectsController: Cancelling operation ");
                            sb.append(eVar);
                        }
                        eVar.b();
                        if (!eVar.i()) {
                            this.f2037c.add(eVar);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f2036b);
                    this.f2036b.clear();
                    this.f2037c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).l();
                    }
                    f(arrayList2, this.f2038d);
                    this.f2038d = false;
                }
            }
        }
    }

    public final e h(Fragment fragment) {
        Iterator it = this.f2036b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    public final e i(Fragment fragment) {
        Iterator it = this.f2037c.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    public void j() {
        String str;
        String str2;
        boolean P = c1.P(this.f2035a);
        synchronized (this.f2036b) {
            q();
            Iterator it = this.f2036b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).l();
            }
            Iterator it2 = new ArrayList(this.f2037c).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                if (o.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (P) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f2035a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(eVar);
                }
                eVar.b();
            }
            Iterator it3 = new ArrayList(this.f2036b).iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (o.F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (P) {
                        str = "";
                    } else {
                        str = "Container " + this.f2035a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(eVar2);
                }
                eVar2.b();
            }
        }
    }

    public void k() {
        if (this.f2039e) {
            this.f2039e = false;
            g();
        }
    }

    public e.b l(v vVar) {
        e.b bVar;
        e h10 = h(vVar.k());
        if (h10 != null) {
            bVar = h10.g();
        } else {
            bVar = null;
        }
        e i10 = i(vVar.k());
        if (i10 == null || (bVar != null && bVar != e.b.NONE)) {
            return bVar;
        }
        return i10.g();
    }

    public ViewGroup m() {
        return this.f2035a;
    }

    public void p() {
        synchronized (this.f2036b) {
            q();
            this.f2039e = false;
            int size = this.f2036b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e eVar = (e) this.f2036b.get(size);
                e.c c10 = e.c.c(eVar.f().mView);
                e.c e10 = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (e10 == cVar && c10 != cVar) {
                    this.f2039e = eVar.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    public final void q() {
        Iterator it = this.f2036b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.g() == e.b.ADDING) {
                eVar.k(e.c.b(eVar.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    public void r(boolean z10) {
        this.f2038d = z10;
    }
}
