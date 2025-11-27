package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.y;
import b0.c1;
import b0.d0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class z {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f2198a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    public static final g0 f2199b;

    /* renamed from: c  reason: collision with root package name */
    public static final g0 f2200c = w();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f2201a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Fragment f2202b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x.b f2203c;

        public a(g gVar, Fragment fragment, x.b bVar) {
            this.f2201a = gVar;
            this.f2202b = fragment;
            this.f2203c = bVar;
        }

        public void run() {
            this.f2201a.b(this.f2202b, this.f2203c);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2204a;

        public b(ArrayList arrayList) {
            this.f2204a = arrayList;
        }

        public void run() {
            z.A(this.f2204a, 4);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f2205a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Fragment f2206b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x.b f2207c;

        public c(g gVar, Fragment fragment, x.b bVar) {
            this.f2205a = gVar;
            this.f2206b = fragment;
            this.f2207c = bVar;
        }

        public void run() {
            this.f2205a.b(this.f2206b, this.f2207c);
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f2208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g0 f2209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f2210c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Fragment f2211d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2212e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2213f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2214g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f2215h;

        public d(Object obj, g0 g0Var, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f2208a = obj;
            this.f2209b = g0Var;
            this.f2210c = view;
            this.f2211d = fragment;
            this.f2212e = arrayList;
            this.f2213f = arrayList2;
            this.f2214g = arrayList3;
            this.f2215h = obj2;
        }

        public void run() {
            Object obj = this.f2208a;
            if (obj != null) {
                this.f2209b.p(obj, this.f2210c);
                this.f2213f.addAll(z.k(this.f2209b, this.f2208a, this.f2211d, this.f2212e, this.f2210c));
            }
            if (this.f2214g != null) {
                if (this.f2215h != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f2210c);
                    this.f2209b.q(this.f2215h, this.f2214g, arrayList);
                }
                this.f2214g.clear();
                this.f2214g.add(this.f2210c);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f2216a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Fragment f2217b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f2218c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f2219d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f2220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g0 f2221f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Rect f2222g;

        public e(Fragment fragment, Fragment fragment2, boolean z10, androidx.collection.a aVar, View view, g0 g0Var, Rect rect) {
            this.f2216a = fragment;
            this.f2217b = fragment2;
            this.f2218c = z10;
            this.f2219d = aVar;
            this.f2220e = view;
            this.f2221f = g0Var;
            this.f2222g = rect;
        }

        public void run() {
            z.f(this.f2216a, this.f2217b, this.f2218c, this.f2219d, false);
            View view = this.f2220e;
            if (view != null) {
                this.f2221f.k(view, this.f2222g);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f2223a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f2224b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f2225c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f2226d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2227e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f2228f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Fragment f2229g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Fragment f2230h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f2231i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2232j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Object f2233k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ Rect f2234l;

        public f(g0 g0Var, androidx.collection.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z10, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f2223a = g0Var;
            this.f2224b = aVar;
            this.f2225c = obj;
            this.f2226d = hVar;
            this.f2227e = arrayList;
            this.f2228f = view;
            this.f2229g = fragment;
            this.f2230h = fragment2;
            this.f2231i = z10;
            this.f2232j = arrayList2;
            this.f2233k = obj2;
            this.f2234l = rect;
        }

        public void run() {
            androidx.collection.a h10 = z.h(this.f2223a, this.f2224b, this.f2225c, this.f2226d);
            if (h10 != null) {
                this.f2227e.addAll(h10.values());
                this.f2227e.add(this.f2228f);
            }
            z.f(this.f2229g, this.f2230h, this.f2231i, h10, false);
            Object obj = this.f2225c;
            if (obj != null) {
                this.f2223a.A(obj, this.f2232j, this.f2227e);
                View s10 = z.s(h10, this.f2226d, this.f2233k, this.f2231i);
                if (s10 != null) {
                    this.f2223a.k(s10, this.f2234l);
                }
            }
        }
    }

    public interface g {
        void a(Fragment fragment, x.b bVar);

        void b(Fragment fragment, x.b bVar);
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f2235a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2236b;

        /* renamed from: c  reason: collision with root package name */
        public a f2237c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f2238d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2239e;

        /* renamed from: f  reason: collision with root package name */
        public a f2240f;
    }

    static {
        f0 f0Var;
        if (Build.VERSION.SDK_INT >= 21) {
            f0Var = new f0();
        } else {
            f0Var = null;
        }
        f2199b = f0Var;
    }

    public static void A(ArrayList arrayList, int i10) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i10);
            }
        }
    }

    public static void B(Context context, g gVar, ArrayList arrayList, ArrayList arrayList2, int i10, int i11, boolean z10, g gVar2) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i12 = i10; i12 < i11; i12++) {
            a aVar = (a) arrayList.get(i12);
            if (((Boolean) arrayList2.get(i12)).booleanValue()) {
                e(aVar, sparseArray, z10);
            } else {
                c(aVar, sparseArray, z10);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i13 = 0; i13 < size; i13++) {
                int keyAt = sparseArray.keyAt(i13);
                androidx.collection.a d10 = d(keyAt, arrayList, arrayList2, i10, i11);
                h hVar = (h) sparseArray.valueAt(i13);
                if (gVar.d() && (viewGroup = (ViewGroup) gVar.c(keyAt)) != null) {
                    if (z10) {
                        o(viewGroup, hVar, view, d10, gVar2);
                    } else {
                        n(viewGroup, hVar, view, d10, gVar2);
                    }
                }
            }
        }
    }

    public static void a(ArrayList arrayList, androidx.collection.a aVar, Collection collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.valueAt(size);
            if (collection.contains(c1.I(view))) {
                arrayList.add(view);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006e, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008a, code lost:
        if (r0.mHidden == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008c, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(androidx.fragment.app.a r8, androidx.fragment.app.y.a r9, android.util.SparseArray r10, boolean r11, boolean r12) {
        /*
            androidx.fragment.app.Fragment r0 = r9.f2191b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r1 = r0.mContainerId
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r11 == 0) goto L_0x0013
            int[] r2 = f2198a
            int r9 = r9.f2190a
            r9 = r2[r9]
            goto L_0x0015
        L_0x0013:
            int r9 = r9.f2190a
        L_0x0015:
            r2 = 0
            r3 = 1
            if (r9 == r3) goto L_0x007f
            r4 = 3
            if (r9 == r4) goto L_0x0057
            r4 = 4
            if (r9 == r4) goto L_0x003f
            r4 = 5
            if (r9 == r4) goto L_0x002d
            r4 = 6
            if (r9 == r4) goto L_0x0057
            r4 = 7
            if (r9 == r4) goto L_0x007f
            r9 = 0
            r3 = 0
        L_0x002a:
            r4 = 0
            goto L_0x0092
        L_0x002d:
            if (r12 == 0) goto L_0x003c
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x008e
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008e
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x008e
            goto L_0x008c
        L_0x003c:
            boolean r9 = r0.mHidden
            goto L_0x008f
        L_0x003f:
            if (r12 == 0) goto L_0x004e
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 == 0) goto L_0x0070
        L_0x004d:
            goto L_0x006e
        L_0x004e:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0070
            goto L_0x004d
        L_0x0057:
            if (r12 == 0) goto L_0x0072
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x0070
            android.view.View r9 = r0.mView
            if (r9 == 0) goto L_0x0070
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x0070
            float r9 = r0.mPostponedAlpha
            r4 = 0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0070
        L_0x006e:
            r9 = 1
            goto L_0x007b
        L_0x0070:
            r9 = 0
            goto L_0x007b
        L_0x0072:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0070
            goto L_0x006e
        L_0x007b:
            r4 = r9
            r9 = 1
            r3 = 0
            goto L_0x0092
        L_0x007f:
            if (r12 == 0) goto L_0x0084
            boolean r9 = r0.mIsNewlyAdded
            goto L_0x008f
        L_0x0084:
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x008e
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008e
        L_0x008c:
            r9 = 1
            goto L_0x008f
        L_0x008e:
            r9 = 0
        L_0x008f:
            r2 = r9
            r9 = 0
            goto L_0x002a
        L_0x0092:
            java.lang.Object r5 = r10.get(r1)
            androidx.fragment.app.z$h r5 = (androidx.fragment.app.z.h) r5
            if (r2 == 0) goto L_0x00a4
            androidx.fragment.app.z$h r5 = p(r5, r10, r1)
            r5.f2235a = r0
            r5.f2236b = r11
            r5.f2237c = r8
        L_0x00a4:
            r2 = 0
            if (r12 != 0) goto L_0x00c5
            if (r3 == 0) goto L_0x00c5
            if (r5 == 0) goto L_0x00b1
            androidx.fragment.app.Fragment r3 = r5.f2238d
            if (r3 != r0) goto L_0x00b1
            r5.f2238d = r2
        L_0x00b1:
            boolean r3 = r8.f2188r
            if (r3 != 0) goto L_0x00c5
            androidx.fragment.app.o r3 = r8.f1910t
            androidx.fragment.app.v r6 = r3.v(r0)
            androidx.fragment.app.x r7 = r3.r0()
            r7.p(r6)
            r3.R0(r0)
        L_0x00c5:
            if (r4 == 0) goto L_0x00d7
            if (r5 == 0) goto L_0x00cd
            androidx.fragment.app.Fragment r3 = r5.f2238d
            if (r3 != 0) goto L_0x00d7
        L_0x00cd:
            androidx.fragment.app.z$h r5 = p(r5, r10, r1)
            r5.f2238d = r0
            r5.f2239e = r11
            r5.f2240f = r8
        L_0x00d7:
            if (r12 != 0) goto L_0x00e3
            if (r9 == 0) goto L_0x00e3
            if (r5 == 0) goto L_0x00e3
            androidx.fragment.app.Fragment r8 = r5.f2235a
            if (r8 != r0) goto L_0x00e3
            r5.f2235a = r2
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.z.b(androidx.fragment.app.a, androidx.fragment.app.y$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(a aVar, SparseArray sparseArray, boolean z10) {
        int size = aVar.f2173c.size();
        for (int i10 = 0; i10 < size; i10++) {
            b(aVar, (y.a) aVar.f2173c.get(i10), sparseArray, false, z10);
        }
    }

    public static androidx.collection.a d(int i10, ArrayList arrayList, ArrayList arrayList2, int i11, int i12) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        androidx.collection.a aVar = new androidx.collection.a();
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            a aVar2 = (a) arrayList.get(i13);
            if (aVar2.D(i10)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i13)).booleanValue();
                ArrayList arrayList5 = aVar2.f2186p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f2186p;
                        arrayList4 = aVar2.f2187q;
                    } else {
                        ArrayList arrayList6 = aVar2.f2186p;
                        arrayList3 = aVar2.f2187q;
                        arrayList4 = arrayList6;
                    }
                    for (int i14 = 0; i14 < size; i14++) {
                        String str = (String) arrayList4.get(i14);
                        String str2 = (String) arrayList3.get(i14);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(a aVar, SparseArray sparseArray, boolean z10) {
        if (aVar.f1910t.n0().d()) {
            for (int size = aVar.f2173c.size() - 1; size >= 0; size--) {
                b(aVar, (y.a) aVar.f2173c.get(size), sparseArray, true, z10);
            }
        }
    }

    public static void f(Fragment fragment, Fragment fragment2, boolean z10, androidx.collection.a aVar, boolean z11) {
        if (z10) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static boolean g(g0 g0Var, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!g0Var.e(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static androidx.collection.a h(g0 g0Var, androidx.collection.a aVar, Object obj, h hVar) {
        ArrayList arrayList;
        Fragment fragment = hVar.f2235a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        androidx.collection.a aVar2 = new androidx.collection.a();
        g0Var.j(aVar2, view);
        a aVar3 = hVar.f2237c;
        if (hVar.f2236b) {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2186p;
        } else {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2187q;
        }
        if (arrayList != null) {
            aVar2.retainAll(arrayList);
            aVar2.retainAll(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    public static androidx.collection.a i(g0 g0Var, androidx.collection.a aVar, Object obj, h hVar) {
        ArrayList arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f2238d;
        androidx.collection.a aVar2 = new androidx.collection.a();
        g0Var.j(aVar2, fragment.requireView());
        a aVar3 = hVar.f2240f;
        if (hVar.f2239e) {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2187q;
        } else {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2186p;
        }
        if (arrayList != null) {
            aVar2.retainAll(arrayList);
        }
        aVar.retainAll(aVar2.keySet());
        return aVar2;
    }

    public static g0 j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        g0 g0Var = f2199b;
        if (g0Var != null && g(g0Var, arrayList)) {
            return g0Var;
        }
        g0 g0Var2 = f2200c;
        if (g0Var2 != null && g(g0Var2, arrayList)) {
            return g0Var2;
        }
        if (g0Var == null && g0Var2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList k(g0 g0Var, Object obj, Fragment fragment, ArrayList arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        View view2 = fragment.getView();
        if (view2 != null) {
            g0Var.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        g0Var.b(obj, arrayList2);
        return arrayList2;
    }

    public static Object l(g0 g0Var, ViewGroup viewGroup, View view, androidx.collection.a aVar, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        androidx.collection.a aVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        g0 g0Var2 = g0Var;
        h hVar2 = hVar;
        ArrayList arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = hVar2.f2235a;
        Fragment fragment2 = hVar2.f2238d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z10 = hVar2.f2236b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            obj3 = null;
        } else {
            obj3 = t(g0Var2, fragment, fragment2, z10);
            aVar2 = aVar;
        }
        androidx.collection.a i10 = i(g0Var2, aVar2, obj3, hVar2);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(i10.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z10, i10, true);
        if (obj4 != null) {
            rect = new Rect();
            g0Var2.z(obj4, view, arrayList3);
            z(g0Var, obj4, obj2, i10, hVar2.f2239e, hVar2.f2240f);
            if (obj5 != null) {
                g0Var2.u(obj5, rect);
            }
        } else {
            rect = null;
        }
        f fVar = r0;
        f fVar2 = new f(g0Var, aVar, obj4, hVar, arrayList2, view, fragment, fragment2, z10, arrayList, obj, rect);
        d0.a(viewGroup, fVar);
        return obj4;
    }

    public static Object m(g0 g0Var, ViewGroup viewGroup, View view, androidx.collection.a aVar, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Rect rect;
        View view2;
        g0 g0Var2 = g0Var;
        View view3 = view;
        androidx.collection.a aVar2 = aVar;
        h hVar2 = hVar;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = hVar2.f2235a;
        Fragment fragment2 = hVar2.f2238d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z10 = hVar2.f2236b;
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = t(g0Var, fragment, fragment2, z10);
        }
        androidx.collection.a i10 = i(g0Var, aVar2, obj3, hVar2);
        androidx.collection.a h10 = h(g0Var, aVar2, obj3, hVar2);
        if (aVar.isEmpty()) {
            if (i10 != null) {
                i10.clear();
            }
            if (h10 != null) {
                h10.clear();
            }
            obj4 = null;
        } else {
            a(arrayList3, i10, aVar.keySet());
            a(arrayList4, h10, aVar.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z10, i10, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            g0Var.z(obj4, view3, arrayList3);
            z(g0Var, obj4, obj2, i10, hVar2.f2239e, hVar2.f2240f);
            Rect rect2 = new Rect();
            View s10 = s(h10, hVar2, obj5, z10);
            if (s10 != null) {
                g0Var.u(obj5, rect2);
            }
            rect = rect2;
            view2 = s10;
        } else {
            view2 = null;
            rect = null;
        }
        d0.a(viewGroup, new e(fragment, fragment2, z10, h10, view2, g0Var, rect));
        return obj4;
    }

    public static void n(ViewGroup viewGroup, h hVar, View view, androidx.collection.a aVar, g gVar) {
        Object obj;
        ViewGroup viewGroup2 = viewGroup;
        h hVar2 = hVar;
        View view2 = view;
        androidx.collection.a aVar2 = aVar;
        g gVar2 = gVar;
        Fragment fragment = hVar2.f2235a;
        Fragment fragment2 = hVar2.f2238d;
        g0 j10 = j(fragment2, fragment);
        if (j10 != null) {
            boolean z10 = hVar2.f2236b;
            boolean z11 = hVar2.f2239e;
            Object q10 = q(j10, fragment, z10);
            Object r10 = r(j10, fragment2, z11);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = r10;
            g0 g0Var = j10;
            Object l10 = l(j10, viewGroup, view, aVar, hVar, arrayList, arrayList2, q10, obj2);
            Object obj3 = q10;
            if (obj3 == null && l10 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList k10 = k(g0Var, obj, fragment2, arrayList4, view2);
            if (k10 == null || k10.isEmpty()) {
                obj = null;
            }
            Object obj4 = obj;
            g0Var.a(obj3, view2);
            Object u10 = u(g0Var, obj3, obj4, l10, fragment, hVar2.f2236b);
            if (!(fragment2 == null || k10 == null || (k10.size() <= 0 && arrayList4.size() <= 0))) {
                x.b bVar = new x.b();
                gVar2.a(fragment2, bVar);
                g0Var.w(fragment2, u10, bVar, new c(gVar2, fragment2, bVar));
            }
            if (u10 != null) {
                ArrayList arrayList5 = new ArrayList();
                g0 g0Var2 = g0Var;
                g0Var2.t(u10, obj3, arrayList5, obj4, k10, l10, arrayList2);
                y(g0Var2, viewGroup, fragment, view, arrayList2, obj3, arrayList5, obj4, k10);
                ViewGroup viewGroup3 = viewGroup;
                g0 g0Var3 = g0Var;
                ArrayList arrayList6 = arrayList2;
                g0Var3.x(viewGroup3, arrayList6, aVar2);
                g0Var3.c(viewGroup3, u10);
                g0Var3.s(viewGroup3, arrayList6, aVar2);
            }
        }
    }

    public static void o(ViewGroup viewGroup, h hVar, View view, androidx.collection.a aVar, g gVar) {
        Object obj;
        h hVar2 = hVar;
        View view2 = view;
        g gVar2 = gVar;
        Fragment fragment = hVar2.f2235a;
        Fragment fragment2 = hVar2.f2238d;
        g0 j10 = j(fragment2, fragment);
        if (j10 != null) {
            boolean z10 = hVar2.f2236b;
            boolean z11 = hVar2.f2239e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object q10 = q(j10, fragment, z10);
            Object r10 = r(j10, fragment2, z11);
            ArrayList arrayList3 = arrayList2;
            Object m10 = m(j10, viewGroup, view, aVar, hVar, arrayList2, arrayList, q10, r10);
            Object obj2 = q10;
            if (obj2 == null && m10 == null) {
                obj = r10;
                if (obj == null) {
                    return;
                }
            } else {
                obj = r10;
            }
            ArrayList k10 = k(j10, obj, fragment2, arrayList3, view2);
            ArrayList k11 = k(j10, obj2, fragment, arrayList, view2);
            A(k11, 4);
            Fragment fragment3 = fragment;
            ArrayList arrayList4 = k10;
            Object u10 = u(j10, obj2, obj, m10, fragment3, z10);
            if (!(fragment2 == null || arrayList4 == null || (arrayList4.size() <= 0 && arrayList3.size() <= 0))) {
                x.b bVar = new x.b();
                g gVar3 = gVar;
                gVar3.a(fragment2, bVar);
                j10.w(fragment2, u10, bVar, new a(gVar3, fragment2, bVar));
            }
            if (u10 != null) {
                v(j10, obj, fragment2, arrayList4);
                ArrayList o10 = j10.o(arrayList);
                g0 g0Var = j10;
                g0Var.t(u10, obj2, k11, obj, arrayList4, m10, arrayList);
                ViewGroup viewGroup2 = viewGroup;
                j10.c(viewGroup2, u10);
                g0Var.y(viewGroup2, arrayList3, arrayList, o10, aVar);
                A(k11, 0);
                j10.A(m10, arrayList3, arrayList);
            }
        }
    }

    public static h p(h hVar, SparseArray sparseArray, int i10) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i10, hVar2);
        return hVar2;
    }

    public static Object q(g0 g0Var, Fragment fragment, boolean z10) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z10) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return g0Var.g(obj);
    }

    public static Object r(g0 g0Var, Fragment fragment, boolean z10) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z10) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return g0Var.g(obj);
    }

    public static View s(androidx.collection.a aVar, h hVar, Object obj, boolean z10) {
        ArrayList arrayList;
        String str;
        a aVar2 = hVar.f2237c;
        if (obj == null || aVar == null || (arrayList = aVar2.f2186p) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z10) {
            str = (String) aVar2.f2186p.get(0);
        } else {
            str = (String) aVar2.f2187q.get(0);
        }
        return (View) aVar.get(str);
    }

    public static Object t(g0 g0Var, Fragment fragment, Fragment fragment2, boolean z10) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z10) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return g0Var.B(g0Var.g(obj));
    }

    public static Object u(g0 g0Var, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z10) {
        boolean z11;
        if (obj == null || obj2 == null || fragment == null) {
            z11 = true;
        } else if (z10) {
            z11 = fragment.getAllowReturnTransitionOverlap();
        } else {
            z11 = fragment.getAllowEnterTransitionOverlap();
        }
        if (z11) {
            return g0Var.n(obj2, obj, obj3);
        }
        return g0Var.m(obj2, obj, obj3);
    }

    public static void v(g0 g0Var, Object obj, Fragment fragment, ArrayList arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            g0Var.r(obj, fragment.getView(), arrayList);
            d0.a(fragment.mContainer, new b(arrayList));
        }
    }

    public static g0 w() {
        try {
            return androidx.transition.e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void x(androidx.collection.a aVar, androidx.collection.a aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.valueAt(size))) {
                aVar.removeAt(size);
            }
        }
    }

    public static void y(g0 g0Var, ViewGroup viewGroup, Fragment fragment, View view, ArrayList arrayList, Object obj, ArrayList arrayList2, Object obj2, ArrayList arrayList3) {
        ViewGroup viewGroup2 = viewGroup;
        d0.a(viewGroup, new d(obj, g0Var, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    public static void z(g0 g0Var, Object obj, Object obj2, androidx.collection.a aVar, boolean z10, a aVar2) {
        String str;
        ArrayList arrayList = aVar2.f2186p;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z10) {
                str = (String) aVar2.f2187q.get(0);
            } else {
                str = (String) aVar2.f2186p.get(0);
            }
            View view = (View) aVar.get(str);
            g0Var.v(obj, view);
            if (obj2 != null) {
                g0Var.v(obj2, view);
            }
        }
    }
}
