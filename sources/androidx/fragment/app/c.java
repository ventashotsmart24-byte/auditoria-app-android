package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.f;
import androidx.fragment.app.j0;
import b0.c1;
import b0.d0;
import b0.r1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x.b;

public class c extends j0 {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1927a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.j0$e$c[] r0 = androidx.fragment.app.j0.e.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1927a = r0
                androidx.fragment.app.j0$e$c r1 = androidx.fragment.app.j0.e.c.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1927a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.j0$e$c r1 = androidx.fragment.app.j0.e.c.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1927a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.j0$e$c r1 = androidx.fragment.app.j0.e.c.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1927a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.j0$e$c r1 = androidx.fragment.app.j0.e.c.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c.a.<clinit>():void");
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f1928a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j0.e f1929b;

        public b(List list, j0.e eVar) {
            this.f1928a = list;
            this.f1929b = eVar;
        }

        public void run() {
            if (this.f1928a.contains(this.f1929b)) {
                this.f1928a.remove(this.f1929b);
                c.this.s(this.f1929b);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$c  reason: collision with other inner class name */
    public class C0028c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1931a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1932b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f1933c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ j0.e f1934d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f1935e;

        public C0028c(ViewGroup viewGroup, View view, boolean z10, j0.e eVar, k kVar) {
            this.f1931a = viewGroup;
            this.f1932b = view;
            this.f1933c = z10;
            this.f1934d = eVar;
            this.f1935e = kVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1931a.endViewTransition(this.f1932b);
            if (this.f1933c) {
                this.f1934d.e().a(this.f1932b);
            }
            this.f1935e.a();
        }
    }

    public class d implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animator f1937a;

        public d(Animator animator) {
            this.f1937a = animator;
        }

        public void a() {
            this.f1937a.end();
        }
    }

    public class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1939a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1940b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f1941c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                e eVar = e.this;
                eVar.f1939a.endViewTransition(eVar.f1940b);
                e.this.f1941c.a();
            }
        }

        public e(ViewGroup viewGroup, View view, k kVar) {
            this.f1939a = viewGroup;
            this.f1940b = view;
            this.f1941c = kVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f1939a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class f implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f1944a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1945b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f1946c;

        public f(View view, ViewGroup viewGroup, k kVar) {
            this.f1944a = view;
            this.f1945b = viewGroup;
            this.f1946c = kVar;
        }

        public void a() {
            this.f1944a.clearAnimation();
            this.f1945b.endViewTransition(this.f1944a);
            this.f1946c.a();
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0.e f1948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j0.e f1949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f1950c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f1951d;

        public g(j0.e eVar, j0.e eVar2, boolean z10, androidx.collection.a aVar) {
            this.f1948a = eVar;
            this.f1949b = eVar2;
            this.f1950c = z10;
            this.f1951d = aVar;
        }

        public void run() {
            z.f(this.f1948a.f(), this.f1949b.f(), this.f1950c, this.f1951d, false);
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f1953a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1954b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Rect f1955c;

        public h(g0 g0Var, View view, Rect rect) {
            this.f1953a = g0Var;
            this.f1954b = view;
            this.f1955c = rect;
        }

        public void run() {
            this.f1953a.k(this.f1954b, this.f1955c);
        }
    }

    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1957a;

        public i(ArrayList arrayList) {
            this.f1957a = arrayList;
        }

        public void run() {
            z.A(this.f1957a, 4);
        }
    }

    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f1959a;

        public j(m mVar) {
            this.f1959a = mVar;
        }

        public void run() {
            this.f1959a.a();
        }
    }

    public static class k extends l {

        /* renamed from: c  reason: collision with root package name */
        public boolean f1961c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1962d = false;

        /* renamed from: e  reason: collision with root package name */
        public f.d f1963e;

        public k(j0.e eVar, x.b bVar, boolean z10) {
            super(eVar, bVar);
            this.f1961c = z10;
        }

        public f.d e(Context context) {
            boolean z10;
            if (this.f1962d) {
                return this.f1963e;
            }
            Fragment f10 = b().f();
            if (b().e() == j0.e.c.VISIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            f.d c10 = f.c(context, f10, z10, this.f1961c);
            this.f1963e = c10;
            this.f1962d = true;
            return c10;
        }
    }

    public static class l {

        /* renamed from: a  reason: collision with root package name */
        public final j0.e f1964a;

        /* renamed from: b  reason: collision with root package name */
        public final x.b f1965b;

        public l(j0.e eVar, x.b bVar) {
            this.f1964a = eVar;
            this.f1965b = bVar;
        }

        public void a() {
            this.f1964a.d(this.f1965b);
        }

        public j0.e b() {
            return this.f1964a;
        }

        public x.b c() {
            return this.f1965b;
        }

        public boolean d() {
            j0.e.c cVar;
            j0.e.c c10 = j0.e.c.c(this.f1964a.f().mView);
            j0.e.c e10 = this.f1964a.e();
            if (c10 == e10 || (c10 != (cVar = j0.e.c.VISIBLE) && e10 != cVar)) {
                return true;
            }
            return false;
        }
    }

    public static class m extends l {

        /* renamed from: c  reason: collision with root package name */
        public final Object f1966c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1967d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f1968e;

        public m(j0.e eVar, x.b bVar, boolean z10, boolean z11) {
            super(eVar, bVar);
            Object obj;
            Object obj2;
            boolean z12;
            if (eVar.e() == j0.e.c.VISIBLE) {
                if (z10) {
                    obj2 = eVar.f().getReenterTransition();
                } else {
                    obj2 = eVar.f().getEnterTransition();
                }
                this.f1966c = obj2;
                if (z10) {
                    z12 = eVar.f().getAllowReturnTransitionOverlap();
                } else {
                    z12 = eVar.f().getAllowEnterTransitionOverlap();
                }
                this.f1967d = z12;
            } else {
                if (z10) {
                    obj = eVar.f().getReturnTransition();
                } else {
                    obj = eVar.f().getExitTransition();
                }
                this.f1966c = obj;
                this.f1967d = true;
            }
            if (!z11) {
                this.f1968e = null;
            } else if (z10) {
                this.f1968e = eVar.f().getSharedElementReturnTransition();
            } else {
                this.f1968e = eVar.f().getSharedElementEnterTransition();
            }
        }

        public g0 e() {
            g0 f10 = f(this.f1966c);
            g0 f11 = f(this.f1968e);
            if (f10 != null && f11 != null && f10 != f11) {
                throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f1966c + " which uses a different Transition  type than its shared element transition " + this.f1968e);
            } else if (f10 != null) {
                return f10;
            } else {
                return f11;
            }
        }

        public final g0 f(Object obj) {
            if (obj == null) {
                return null;
            }
            g0 g0Var = z.f2199b;
            if (g0Var != null && g0Var.e(obj)) {
                return g0Var;
            }
            g0 g0Var2 = z.f2200c;
            if (g0Var2 != null && g0Var2.e(obj)) {
                return g0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        public Object g() {
            return this.f1968e;
        }

        public Object h() {
            return this.f1966c;
        }

        public boolean i() {
            if (this.f1968e != null) {
                return true;
            }
            return false;
        }

        public boolean j() {
            return this.f1967d;
        }
    }

    public c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void f(List list, boolean z10) {
        Iterator it = list.iterator();
        j0.e eVar = null;
        j0.e eVar2 = null;
        while (it.hasNext()) {
            j0.e eVar3 = (j0.e) it.next();
            j0.e.c c10 = j0.e.c.c(eVar3.f().mView);
            int i10 = a.f1927a[eVar3.e().ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                if (c10 == j0.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i10 == 4 && c10 != j0.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<j0.e> arrayList3 = new ArrayList<>(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            j0.e eVar4 = (j0.e) it2.next();
            x.b bVar = new x.b();
            eVar4.j(bVar);
            arrayList.add(new k(eVar4, bVar, z10));
            x.b bVar2 = new x.b();
            eVar4.j(bVar2);
            boolean z11 = false;
            if (z10) {
                if (eVar4 != eVar) {
                    arrayList2.add(new m(eVar4, bVar2, z10, z11));
                    eVar4.a(new b(arrayList3, eVar4));
                }
            } else if (eVar4 != eVar2) {
                arrayList2.add(new m(eVar4, bVar2, z10, z11));
                eVar4.a(new b(arrayList3, eVar4));
            }
            z11 = true;
            arrayList2.add(new m(eVar4, bVar2, z10, z11));
            eVar4.a(new b(arrayList3, eVar4));
        }
        Map x10 = x(arrayList2, arrayList3, z10, eVar, eVar2);
        w(arrayList, arrayList3, x10.containsValue(Boolean.TRUE), x10);
        for (j0.e s10 : arrayList3) {
            s(s10);
        }
        arrayList3.clear();
    }

    public void s(j0.e eVar) {
        eVar.e().a(eVar.f().mView);
    }

    public void t(ArrayList arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!r1.a(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    if (childAt.getVisibility() == 0) {
                        t(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public void u(Map map, View view) {
        String I = c1.I(view);
        if (I != null) {
            map.put(I, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    public void v(androidx.collection.a aVar, Collection collection) {
        Iterator<Map.Entry<Object, Object>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(c1.I((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public final void w(List list, List list2, boolean z10, Map map) {
        boolean z11;
        ViewGroup m10 = m();
        Context context = m10.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z12 = false;
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar.d()) {
                kVar.a();
            } else {
                f.d e10 = kVar.e(context);
                if (e10 == null) {
                    kVar.a();
                } else {
                    Animator animator = e10.f1990b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        j0.e b10 = kVar.b();
                        Fragment f10 = b10.f();
                        if (Boolean.TRUE.equals(map.get(b10))) {
                            if (o.F0(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Ignoring Animator set on ");
                                sb.append(f10);
                                sb.append(" as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            if (b10.e() == j0.e.c.GONE) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            List list3 = list2;
                            if (z11) {
                                list3.remove(b10);
                            }
                            View view = f10.mView;
                            m10.startViewTransition(view);
                            C0028c cVar = r0;
                            C0028c cVar2 = new C0028c(m10, view, z11, b10, kVar);
                            animator.addListener(cVar);
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().c(new d(animator));
                            z12 = true;
                        }
                    }
                }
            }
            Map map2 = map;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar2 = (k) it2.next();
            j0.e b11 = kVar2.b();
            Fragment f11 = b11.f();
            if (z10) {
                if (o.F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring Animation set on ");
                    sb2.append(f11);
                    sb2.append(" as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z12) {
                if (o.F0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Ignoring Animation set on ");
                    sb3.append(f11);
                    sb3.append(" as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = f11.mView;
                Animation animation = (Animation) a0.h.d(((f.d) a0.h.d(kVar2.e(context))).f1989a);
                if (b11.e() != j0.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    m10.startViewTransition(view2);
                    f.e eVar = new f.e(animation, m10, view2);
                    eVar.setAnimationListener(new e(m10, view2, kVar2));
                    view2.startAnimation(eVar);
                }
                kVar2.c().c(new f(view2, m10, kVar2));
            }
        }
    }

    public final Map x(List list, List list2, boolean z10, j0.e eVar, j0.e eVar2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        View view;
        View view2;
        Object obj;
        j0.e eVar3;
        j0.e eVar4;
        Object obj2;
        Object obj3;
        androidx.collection.a aVar;
        j0.e eVar5;
        g0 g0Var;
        View view3;
        Rect rect;
        ArrayList arrayList3;
        j0.e eVar6;
        ArrayList arrayList4;
        boolean z11 = z10;
        j0.e eVar7 = eVar;
        j0.e eVar8 = eVar2;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        g0 g0Var2 = null;
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (!mVar.d()) {
                g0 e10 = mVar.e();
                if (g0Var2 == null) {
                    g0Var2 = e10;
                } else if (!(e10 == null || g0Var2 == e10)) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (g0Var2 == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                m mVar2 = (m) it2.next();
                hashMap.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return hashMap;
        }
        View view4 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        androidx.collection.a aVar2 = new androidx.collection.a();
        Iterator it3 = list.iterator();
        Object obj4 = null;
        View view5 = null;
        boolean z12 = false;
        while (it3.hasNext()) {
            m mVar3 = (m) it3.next();
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                aVar = aVar2;
                arrayList4 = arrayList6;
                eVar6 = eVar7;
                arrayList3 = arrayList5;
                rect = rect2;
                view3 = view4;
                g0Var = g0Var2;
                eVar5 = eVar8;
                view5 = view5;
            } else {
                Object B = g0Var2.B(g0Var2.g(mVar3.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                Object obj5 = B;
                View view6 = view5;
                int i10 = 0;
                while (i10 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i10));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i10));
                    }
                    i10++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                if (!z11) {
                    eVar.f().getExitTransitionCallback();
                    eVar2.f().getEnterTransitionCallback();
                } else {
                    eVar.f().getEnterTransitionCallback();
                    eVar2.f().getExitTransitionCallback();
                }
                int i11 = 0;
                for (int size = sharedElementSourceNames.size(); i11 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i11), sharedElementTargetNames2.get(i11));
                    i11++;
                }
                androidx.collection.a aVar3 = new androidx.collection.a();
                u(aVar3, eVar.f().mView);
                aVar3.retainAll(sharedElementSourceNames);
                aVar2.retainAll(aVar3.keySet());
                androidx.collection.a aVar4 = new androidx.collection.a();
                u(aVar4, eVar2.f().mView);
                aVar4.retainAll(sharedElementTargetNames2);
                aVar4.retainAll(aVar2.values());
                z.x(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList4 = arrayList6;
                    eVar6 = eVar7;
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    g0Var = g0Var2;
                    view5 = view6;
                    obj4 = null;
                    eVar5 = eVar8;
                } else {
                    z.f(eVar2.f(), eVar.f(), z11, aVar3, true);
                    ArrayList<String> arrayList8 = sharedElementSourceNames;
                    g gVar = r0;
                    ViewGroup m10 = m();
                    Object obj6 = obj5;
                    androidx.collection.a aVar5 = aVar4;
                    View view7 = view6;
                    androidx.collection.a aVar6 = aVar3;
                    aVar = aVar2;
                    ArrayList arrayList9 = arrayList6;
                    g gVar2 = new g(eVar2, eVar, z10, aVar5);
                    d0.a(m10, gVar2);
                    arrayList5.addAll(aVar6.values());
                    if (!arrayList8.isEmpty()) {
                        View view8 = (View) aVar6.get(arrayList8.get(0));
                        g0Var2.v(obj6, view8);
                        view5 = view8;
                    } else {
                        view5 = view7;
                    }
                    arrayList4 = arrayList9;
                    arrayList4.addAll(aVar5.values());
                    if (!sharedElementTargetNames2.isEmpty()) {
                        View view9 = (View) aVar5.get(sharedElementTargetNames2.get(0));
                        if (view9 != null) {
                            d0.a(m(), new h(g0Var2, view9, rect2));
                            z12 = true;
                        }
                    }
                    g0Var2.z(obj6, view4, arrayList5);
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    g0Var = g0Var2;
                    g0Var2.t(obj6, (Object) null, (ArrayList) null, (Object) null, (ArrayList) null, obj6, arrayList4);
                    Boolean bool = Boolean.TRUE;
                    eVar6 = eVar;
                    hashMap.put(eVar6, bool);
                    eVar5 = eVar2;
                    hashMap.put(eVar5, bool);
                    obj4 = obj6;
                }
            }
            eVar7 = eVar6;
            arrayList5 = arrayList3;
            rect2 = rect;
            view4 = view3;
            eVar8 = eVar5;
            aVar2 = aVar;
            z11 = z10;
            arrayList6 = arrayList4;
            g0Var2 = g0Var;
        }
        View view10 = view5;
        androidx.collection.a aVar7 = aVar2;
        ArrayList arrayList10 = arrayList6;
        j0.e eVar9 = eVar7;
        ArrayList arrayList11 = arrayList5;
        Rect rect3 = rect2;
        View view11 = view4;
        g0 g0Var3 = g0Var2;
        j0.e eVar10 = eVar8;
        ArrayList arrayList12 = new ArrayList();
        Iterator it4 = list.iterator();
        Object obj7 = null;
        Object obj8 = null;
        while (it4.hasNext()) {
            m mVar4 = (m) it4.next();
            if (mVar4.d()) {
                hashMap.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object g10 = g0Var3.g(mVar4.h());
                j0.e b10 = mVar4.b();
                boolean z13 = obj4 != null && (b10 == eVar9 || b10 == eVar10);
                if (g10 == null) {
                    if (!z13) {
                        hashMap.put(b10, Boolean.FALSE);
                        mVar4.a();
                    }
                    List list3 = list2;
                    arrayList = arrayList10;
                    arrayList2 = arrayList11;
                    view = view11;
                    obj = obj7;
                    eVar3 = eVar10;
                    view2 = view10;
                } else {
                    ArrayList arrayList13 = new ArrayList();
                    Object obj9 = obj7;
                    t(arrayList13, b10.f().mView);
                    if (z13) {
                        if (b10 == eVar9) {
                            arrayList13.removeAll(arrayList11);
                        } else {
                            arrayList13.removeAll(arrayList10);
                        }
                    }
                    if (arrayList13.isEmpty()) {
                        g0Var3.a(g10, view11);
                        arrayList = arrayList10;
                        arrayList2 = arrayList11;
                        view = view11;
                        eVar4 = b10;
                        obj3 = obj8;
                        eVar3 = eVar10;
                        List list4 = list2;
                        obj2 = obj9;
                    } else {
                        g0Var3.b(g10, arrayList13);
                        view = view11;
                        obj2 = obj9;
                        j0.e eVar11 = b10;
                        arrayList2 = arrayList11;
                        obj3 = obj8;
                        arrayList = arrayList10;
                        eVar3 = eVar10;
                        g0Var3.t(g10, g10, arrayList13, (Object) null, (ArrayList) null, (Object) null, (ArrayList) null);
                        if (eVar11.e() == j0.e.c.GONE) {
                            eVar4 = eVar11;
                            list2.remove(eVar4);
                            ArrayList arrayList14 = new ArrayList(arrayList13);
                            arrayList14.remove(eVar4.f().mView);
                            g0Var3.r(g10, eVar4.f().mView, arrayList14);
                            d0.a(m(), new i(arrayList13));
                        } else {
                            List list5 = list2;
                            eVar4 = eVar11;
                        }
                    }
                    if (eVar4.e() == j0.e.c.VISIBLE) {
                        arrayList12.addAll(arrayList13);
                        if (z12) {
                            g0Var3.u(g10, rect3);
                        }
                        view2 = view10;
                    } else {
                        view2 = view10;
                        g0Var3.v(g10, view2);
                    }
                    hashMap.put(eVar4, Boolean.TRUE);
                    if (mVar4.j()) {
                        obj8 = g0Var3.n(obj3, g10, (Object) null);
                        obj = obj2;
                    } else {
                        obj = g0Var3.n(obj2, g10, (Object) null);
                        obj8 = obj3;
                    }
                }
                eVar10 = eVar3;
                obj7 = obj;
                view10 = view2;
                view11 = view;
                arrayList11 = arrayList2;
                arrayList10 = arrayList;
            }
        }
        ArrayList arrayList15 = arrayList10;
        ArrayList arrayList16 = arrayList11;
        j0.e eVar12 = eVar10;
        Object m11 = g0Var3.m(obj8, obj7, obj4);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            m mVar5 = (m) it5.next();
            if (!mVar5.d()) {
                Object h10 = mVar5.h();
                j0.e b11 = mVar5.b();
                boolean z14 = obj4 != null && (b11 == eVar9 || b11 == eVar12);
                if (h10 != null || z14) {
                    if (!c1.Q(m())) {
                        if (o.F0(2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SpecialEffectsController: Container ");
                            sb.append(m());
                            sb.append(" has not been laid out. Completing operation ");
                            sb.append(b11);
                        }
                        mVar5.a();
                    } else {
                        g0Var3.w(mVar5.b().f(), m11, mVar5.c(), new j(mVar5));
                    }
                }
            }
        }
        if (!c1.Q(m())) {
            return hashMap;
        }
        z.A(arrayList12, 4);
        ArrayList arrayList17 = arrayList15;
        ArrayList o10 = g0Var3.o(arrayList17);
        g0Var3.c(m(), m11);
        g0Var3.y(m(), arrayList16, arrayList17, o10, aVar7);
        z.A(arrayList12, 0);
        g0Var3.A(obj4, arrayList16, arrayList17);
        return hashMap;
    }
}
