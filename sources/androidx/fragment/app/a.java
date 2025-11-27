package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.fragment.app.y;
import androidx.lifecycle.d;
import java.io.PrintWriter;
import java.util.ArrayList;

public final class a extends y implements o.m {

    /* renamed from: t  reason: collision with root package name */
    public final o f1910t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1911u;

    /* renamed from: v  reason: collision with root package name */
    public int f1912v;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(androidx.fragment.app.o r3) {
        /*
            r2 = this;
            androidx.fragment.app.k r0 = r3.q0()
            androidx.fragment.app.l r1 = r3.t0()
            if (r1 == 0) goto L_0x0017
            androidx.fragment.app.l r1 = r3.t0()
            android.content.Context r1 = r1.f()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r2.<init>(r0, r1)
            r0 = -1
            r2.f1912v = r0
            r2.f1910t = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.<init>(androidx.fragment.app.o):void");
    }

    public static boolean F(y.a aVar) {
        Fragment fragment = aVar.f2191b;
        if (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) {
            return false;
        }
        return true;
    }

    public void A(boolean z10) {
        for (int size = this.f2173c.size() - 1; size >= 0; size--) {
            y.a aVar = (y.a) this.f2173c.get(size);
            Fragment fragment = aVar.f2191b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(o.i1(this.f2178h));
                fragment.setSharedElementNames(this.f2187q, this.f2186p);
            }
            switch (aVar.f2190a) {
                case 1:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.m1(fragment, true);
                    this.f1910t.d1(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.g(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.q1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.m1(fragment, true);
                    this.f1910t.C0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.l(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.m1(fragment, true);
                    this.f1910t.x(fragment);
                    break;
                case 8:
                    this.f1910t.o1((Fragment) null);
                    break;
                case 9:
                    this.f1910t.o1(fragment);
                    break;
                case 10:
                    this.f1910t.n1(fragment, aVar.f2196g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2190a);
            }
            if (!this.f2188r && aVar.f2190a != 3 && fragment != null && !o.P) {
                this.f1910t.P0(fragment);
            }
        }
        if (!this.f2188r && z10 && !o.P) {
            o oVar = this.f1910t;
            oVar.Q0(oVar.f2091q, true);
        }
    }

    public Fragment B(ArrayList arrayList, Fragment fragment) {
        ArrayList arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i10 = 0;
        while (i10 < this.f2173c.size()) {
            y.a aVar = (y.a) this.f2173c.get(i10);
            int i11 = aVar.f2190a;
            if (i11 != 1) {
                if (i11 == 2) {
                    Fragment fragment3 = aVar.f2191b;
                    int i12 = fragment3.mContainerId;
                    boolean z10 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = (Fragment) arrayList2.get(size);
                        if (fragment4.mContainerId == i12) {
                            if (fragment4 == fragment3) {
                                z10 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f2173c.add(i10, new y.a(9, fragment4));
                                    i10++;
                                    fragment2 = null;
                                }
                                y.a aVar2 = new y.a(3, fragment4);
                                aVar2.f2192c = aVar.f2192c;
                                aVar2.f2194e = aVar.f2194e;
                                aVar2.f2193d = aVar.f2193d;
                                aVar2.f2195f = aVar.f2195f;
                                this.f2173c.add(i10, aVar2);
                                arrayList2.remove(fragment4);
                                i10++;
                            }
                        }
                    }
                    if (z10) {
                        this.f2173c.remove(i10);
                        i10--;
                    } else {
                        aVar.f2190a = 1;
                        arrayList2.add(fragment3);
                    }
                } else if (i11 == 3 || i11 == 6) {
                    arrayList2.remove(aVar.f2191b);
                    Fragment fragment5 = aVar.f2191b;
                    if (fragment5 == fragment2) {
                        this.f2173c.add(i10, new y.a(9, fragment5));
                        i10++;
                        fragment2 = null;
                    }
                } else if (i11 != 7) {
                    if (i11 == 8) {
                        this.f2173c.add(i10, new y.a(9, fragment2));
                        i10++;
                        fragment2 = aVar.f2191b;
                    }
                }
                i10++;
            }
            arrayList2.add(aVar.f2191b);
            i10++;
        }
        return fragment2;
    }

    public String C() {
        return this.f2181k;
    }

    public boolean D(int i10) {
        int i11;
        int size = this.f2173c.size();
        for (int i12 = 0; i12 < size; i12++) {
            Fragment fragment = ((y.a) this.f2173c.get(i12)).f2191b;
            if (fragment != null) {
                i11 = fragment.mContainerId;
            } else {
                i11 = 0;
            }
            if (i11 != 0 && i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public boolean E(ArrayList arrayList, int i10, int i11) {
        int i12;
        int i13;
        if (i11 == i10) {
            return false;
        }
        int size = this.f2173c.size();
        int i14 = -1;
        for (int i15 = 0; i15 < size; i15++) {
            Fragment fragment = ((y.a) this.f2173c.get(i15)).f2191b;
            if (fragment != null) {
                i12 = fragment.mContainerId;
            } else {
                i12 = 0;
            }
            if (!(i12 == 0 || i12 == i14)) {
                for (int i16 = i10; i16 < i11; i16++) {
                    a aVar = (a) arrayList.get(i16);
                    int size2 = aVar.f2173c.size();
                    for (int i17 = 0; i17 < size2; i17++) {
                        Fragment fragment2 = ((y.a) aVar.f2173c.get(i17)).f2191b;
                        if (fragment2 != null) {
                            i13 = fragment2.mContainerId;
                        } else {
                            i13 = 0;
                        }
                        if (i13 == i12) {
                            return true;
                        }
                    }
                }
                i14 = i12;
            }
        }
        return false;
    }

    public boolean G() {
        for (int i10 = 0; i10 < this.f2173c.size(); i10++) {
            if (F((y.a) this.f2173c.get(i10))) {
                return true;
            }
        }
        return false;
    }

    public void H() {
        if (this.f2189s != null) {
            for (int i10 = 0; i10 < this.f2189s.size(); i10++) {
                ((Runnable) this.f2189s.get(i10)).run();
            }
            this.f2189s = null;
        }
    }

    public void I(Fragment.l lVar) {
        for (int i10 = 0; i10 < this.f2173c.size(); i10++) {
            y.a aVar = (y.a) this.f2173c.get(i10);
            if (F(aVar)) {
                aVar.f2191b.setOnStartEnterTransitionListener(lVar);
            }
        }
    }

    public Fragment J(ArrayList arrayList, Fragment fragment) {
        for (int size = this.f2173c.size() - 1; size >= 0; size--) {
            y.a aVar = (y.a) this.f2173c.get(size);
            int i10 = aVar.f2190a;
            if (i10 != 1) {
                if (i10 != 3) {
                    switch (i10) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f2191b;
                            break;
                        case 10:
                            aVar.f2197h = aVar.f2196g;
                            break;
                    }
                }
                arrayList.add(aVar.f2191b);
            }
            arrayList.remove(aVar.f2191b);
        }
        return fragment;
    }

    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Run: ");
            sb.append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2179i) {
            return true;
        }
        this.f1910t.e(this);
        return true;
    }

    public int h() {
        return w(false);
    }

    public int i() {
        return w(true);
    }

    public void j() {
        m();
        this.f1910t.b0(this, false);
    }

    public void k() {
        m();
        this.f1910t.b0(this, true);
    }

    public y l(Fragment fragment) {
        o oVar = fragment.mFragmentManager;
        if (oVar == null || oVar == this.f1910t) {
            return super.l(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void n(int i10, Fragment fragment, String str, int i11) {
        super.n(i10, fragment, str, i11);
        fragment.mFragmentManager = this.f1910t;
    }

    public y o(Fragment fragment) {
        o oVar = fragment.mFragmentManager;
        if (oVar == null || oVar == this.f1910t) {
            return super.o(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public y p(Fragment fragment) {
        o oVar = fragment.mFragmentManager;
        if (oVar == null || oVar == this.f1910t) {
            return super.p(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public y s(Fragment fragment, d.c cVar) {
        if (fragment.mFragmentManager != this.f1910t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f1910t);
        } else if (cVar == d.c.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + " after the Fragment has been created");
        } else if (cVar != d.c.DESTROYED) {
            return super.s(fragment, cVar);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1912v >= 0) {
            sb.append(" #");
            sb.append(this.f1912v);
        }
        if (this.f2181k != null) {
            sb.append(" ");
            sb.append(this.f2181k);
        }
        sb.append("}");
        return sb.toString();
    }

    public y u(Fragment fragment) {
        o oVar = fragment.mFragmentManager;
        if (oVar == null || oVar == this.f1910t) {
            return super.u(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void v(int i10) {
        if (this.f2179i) {
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bump nesting in ");
                sb.append(this);
                sb.append(" by ");
                sb.append(i10);
            }
            int size = this.f2173c.size();
            for (int i11 = 0; i11 < size; i11++) {
                y.a aVar = (y.a) this.f2173c.get(i11);
                Fragment fragment = aVar.f2191b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i10;
                    if (o.F0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Bump nesting of ");
                        sb2.append(aVar.f2191b);
                        sb2.append(" to ");
                        sb2.append(aVar.f2191b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public int w(boolean z10) {
        if (!this.f1911u) {
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Commit: ");
                sb.append(this);
                PrintWriter printWriter = new PrintWriter(new i0("FragmentManager"));
                x("  ", printWriter);
                printWriter.close();
            }
            this.f1911u = true;
            if (this.f2179i) {
                this.f1912v = this.f1910t.j();
            } else {
                this.f1912v = -1;
            }
            this.f1910t.Y(this, z10);
            return this.f1912v;
        }
        throw new IllegalStateException("commit already called");
    }

    public void x(String str, PrintWriter printWriter) {
        y(str, printWriter, true);
    }

    public void y(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2181k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1912v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1911u);
            if (this.f2178h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2178h));
            }
            if (!(this.f2174d == 0 && this.f2175e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2174d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2175e));
            }
            if (!(this.f2176f == 0 && this.f2177g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2176f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2177g));
            }
            if (!(this.f2182l == 0 && this.f2183m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2182l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2183m);
            }
            if (!(this.f2184n == 0 && this.f2185o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2184n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2185o);
            }
        }
        if (!this.f2173c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f2173c.size();
            for (int i10 = 0; i10 < size; i10++) {
                y.a aVar = (y.a) this.f2173c.get(i10);
                switch (aVar.f2190a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f2190a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f2191b);
                if (z10) {
                    if (!(aVar.f2192c == 0 && aVar.f2193d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2192c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2193d));
                    }
                    if (aVar.f2194e != 0 || aVar.f2195f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2194e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2195f));
                    }
                }
            }
        }
    }

    public void z() {
        int size = this.f2173c.size();
        for (int i10 = 0; i10 < size; i10++) {
            y.a aVar = (y.a) this.f2173c.get(i10);
            Fragment fragment = aVar.f2191b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f2178h);
                fragment.setSharedElementNames(this.f2186p, this.f2187q);
            }
            switch (aVar.f2190a) {
                case 1:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.m1(fragment, false);
                    this.f1910t.g(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.d1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.C0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.m1(fragment, false);
                    this.f1910t.q1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.x(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f2192c, aVar.f2193d, aVar.f2194e, aVar.f2195f);
                    this.f1910t.m1(fragment, false);
                    this.f1910t.l(fragment);
                    break;
                case 8:
                    this.f1910t.o1(fragment);
                    break;
                case 9:
                    this.f1910t.o1((Fragment) null);
                    break;
                case 10:
                    this.f1910t.n1(fragment, aVar.f2197h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2190a);
            }
            if (!this.f2188r && aVar.f2190a != 1 && fragment != null && !o.P) {
                this.f1910t.P0(fragment);
            }
        }
        if (!this.f2188r && !o.P) {
            o oVar = this.f1910t;
            oVar.Q0(oVar.f2091q, true);
        }
    }
}
