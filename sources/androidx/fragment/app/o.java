package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.e;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.fragment.app.y;
import androidx.fragment.app.z;
import androidx.lifecycle.d;
import androidx.lifecycle.x;
import com.umeng.analytics.pro.q;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class o {
    public static boolean O = false;
    public static boolean P = true;
    public androidx.activity.result.c A;
    public androidx.activity.result.c B;
    public ArrayDeque C = new ArrayDeque();
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public ArrayList L;
    public r M;
    public Runnable N = new g();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2075a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f2076b;

    /* renamed from: c  reason: collision with root package name */
    public final x f2077c = new x();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f2078d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f2079e;

    /* renamed from: f  reason: collision with root package name */
    public final m f2080f = new m(this);

    /* renamed from: g  reason: collision with root package name */
    public OnBackPressedDispatcher f2081g;

    /* renamed from: h  reason: collision with root package name */
    public final androidx.activity.b f2082h = new c(false);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f2083i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    public final Map f2084j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k  reason: collision with root package name */
    public final Map f2085k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    public ArrayList f2086l;

    /* renamed from: m  reason: collision with root package name */
    public Map f2087m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n  reason: collision with root package name */
    public final z.g f2088n = new d();

    /* renamed from: o  reason: collision with root package name */
    public final n f2089o = new n(this);

    /* renamed from: p  reason: collision with root package name */
    public final CopyOnWriteArrayList f2090p = new CopyOnWriteArrayList();

    /* renamed from: q  reason: collision with root package name */
    public int f2091q = -1;

    /* renamed from: r  reason: collision with root package name */
    public l f2092r;

    /* renamed from: s  reason: collision with root package name */
    public g f2093s;

    /* renamed from: t  reason: collision with root package name */
    public Fragment f2094t;

    /* renamed from: u  reason: collision with root package name */
    public Fragment f2095u;

    /* renamed from: v  reason: collision with root package name */
    public k f2096v = null;

    /* renamed from: w  reason: collision with root package name */
    public k f2097w = new e();

    /* renamed from: x  reason: collision with root package name */
    public k0 f2098x = null;

    /* renamed from: y  reason: collision with root package name */
    public k0 f2099y = new f();

    /* renamed from: z  reason: collision with root package name */
    public androidx.activity.result.c f2100z;

    public class a implements androidx.activity.result.b {
        public a() {
        }

        /* renamed from: b */
        public void a(androidx.activity.result.a aVar) {
            l lVar = (l) o.this.C.pollFirst();
            if (lVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No IntentSenders were started for ");
                sb.append(this);
                return;
            }
            String str = lVar.f2115a;
            int i10 = lVar.f2116b;
            Fragment i11 = o.this.f2077c.i(str);
            if (i11 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Intent Sender result delivered for unknown Fragment ");
                sb2.append(str);
                return;
            }
            i11.onActivityResult(i10, aVar.b(), aVar.a());
        }
    }

    public class b implements androidx.activity.result.b {
        public b() {
        }

        /* renamed from: b */
        public void a(Map map) {
            int i10;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                if (((Boolean) arrayList.get(i11)).booleanValue()) {
                    i10 = 0;
                } else {
                    i10 = -1;
                }
                iArr[i11] = i10;
            }
            l lVar = (l) o.this.C.pollFirst();
            if (lVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No permissions were requested for ");
                sb.append(this);
                return;
            }
            String str = lVar.f2115a;
            int i12 = lVar.f2116b;
            Fragment i13 = o.this.f2077c.i(str);
            if (i13 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Permission request result delivered for unknown Fragment ");
                sb2.append(str);
                return;
            }
            i13.onRequestPermissionsResult(i12, strArr, iArr);
        }
    }

    public class c extends androidx.activity.b {
        public c(boolean z10) {
            super(z10);
        }

        public void b() {
            o.this.B0();
        }
    }

    public class d implements z.g {
        public d() {
        }

        public void a(Fragment fragment, x.b bVar) {
            o.this.f(fragment, bVar);
        }

        public void b(Fragment fragment, x.b bVar) {
            if (!bVar.b()) {
                o.this.c1(fragment, bVar);
            }
        }
    }

    public class e extends k {
        public e() {
        }

        public Fragment a(ClassLoader classLoader, String str) {
            return o.this.t0().b(o.this.t0().f(), str, (Bundle) null);
        }
    }

    public class f implements k0 {
        public f() {
        }

        public j0 a(ViewGroup viewGroup) {
            return new c(viewGroup);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            o.this.a0(true);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2109b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f2110c;

        public h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f2108a = viewGroup;
            this.f2109b = view;
            this.f2110c = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2108a.endViewTransition(this.f2109b);
            animator.removeListener(this);
            Fragment fragment = this.f2110c;
            View view = fragment.mView;
            if (view != null && fragment.mHidden) {
                view.setVisibility(8);
            }
        }
    }

    public class i implements s {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f2112a;

        public i(Fragment fragment) {
            this.f2112a = fragment;
        }

        public void a(o oVar, Fragment fragment) {
            this.f2112a.onAttachFragment(fragment);
        }
    }

    public class j implements androidx.activity.result.b {
        public j() {
        }

        /* renamed from: b */
        public void a(androidx.activity.result.a aVar) {
            l lVar = (l) o.this.C.pollFirst();
            if (lVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No Activities were started for result for ");
                sb.append(this);
                return;
            }
            String str = lVar.f2115a;
            int i10 = lVar.f2116b;
            Fragment i11 = o.this.f2077c.i(str);
            if (i11 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Activity result delivered for unknown Fragment ");
                sb2.append(str);
                return;
            }
            i11.onActivityResult(i10, aVar.b(), aVar.a());
        }
    }

    public static class k extends c.a {
        /* renamed from: d */
        public Intent a(Context context, androidx.activity.result.e eVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a10 = eVar.a();
            if (!(a10 == null || (bundleExtra = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a10.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    eVar = new e.b(eVar.d()).b((Intent) null).c(eVar.c(), eVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar);
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("CreateIntent created the following intent: ");
                sb.append(intent);
            }
            return intent;
        }

        /* renamed from: e */
        public androidx.activity.result.a c(int i10, Intent intent) {
            return new androidx.activity.result.a(i10, intent);
        }
    }

    public interface m {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    public class n implements m {

        /* renamed from: a  reason: collision with root package name */
        public final String f2117a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2118b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2119c;

        public n(String str, int i10, int i11) {
            this.f2117a = str;
            this.f2118b = i10;
            this.f2119c = i11;
        }

        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = o.this.f2095u;
            if (fragment != null && this.f2118b < 0 && this.f2117a == null && fragment.getChildFragmentManager().X0()) {
                return false;
            }
            return o.this.Z0(arrayList, arrayList2, this.f2117a, this.f2118b, this.f2119c);
        }
    }

    /* renamed from: androidx.fragment.app.o$o  reason: collision with other inner class name */
    public static class C0030o implements Fragment.l {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f2121a;

        /* renamed from: b  reason: collision with root package name */
        public final a f2122b;

        /* renamed from: c  reason: collision with root package name */
        public int f2123c;

        public C0030o(a aVar, boolean z10) {
            this.f2121a = z10;
            this.f2122b = aVar;
        }

        public void a() {
            this.f2123c++;
        }

        public void b() {
            int i10 = this.f2123c - 1;
            this.f2123c = i10;
            if (i10 == 0) {
                this.f2122b.f1910t.l1();
            }
        }

        public void c() {
            a aVar = this.f2122b;
            aVar.f1910t.t(aVar, this.f2121a, false, false);
        }

        public void d() {
            boolean z10;
            if (this.f2123c > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            for (Fragment fragment : this.f2122b.f1910t.s0()) {
                fragment.setOnStartEnterTransitionListener((Fragment.l) null);
                if (z10 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            a aVar = this.f2122b;
            aVar.f1910t.t(aVar, this.f2121a, !z10, true);
        }

        public boolean e() {
            if (this.f2123c == 0) {
                return true;
            }
            return false;
        }
    }

    public static boolean F0(int i10) {
        if (O || Log.isLoggable("FragmentManager", i10)) {
            return true;
        }
        return false;
    }

    public static void c0(ArrayList arrayList, ArrayList arrayList2, int i10, int i11) {
        while (i10 < i11) {
            a aVar = (a) arrayList.get(i10);
            boolean z10 = true;
            if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                aVar.v(-1);
                if (i10 != i11 - 1) {
                    z10 = false;
                }
                aVar.A(z10);
            } else {
                aVar.v(1);
                aVar.z();
            }
            i10++;
        }
    }

    public static int i1(int i10) {
        if (i10 == 4097) {
            return q.a.f14406s;
        }
        if (i10 == 4099) {
            return q.a.f14390c;
        }
        if (i10 != 8194) {
            return 0;
        }
        return q.a.f14388a;
    }

    public static Fragment z0(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public void A(Configuration configuration) {
        for (Fragment fragment : this.f2077c.n()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public x A0(Fragment fragment) {
        return this.M.l(fragment);
    }

    public boolean B(MenuItem menuItem) {
        if (this.f2091q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2077c.n()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void B0() {
        a0(true);
        if (this.f2082h.c()) {
            X0();
        } else {
            this.f2081g.c();
        }
    }

    public void C() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(1);
    }

    public void C0(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("hide: ");
            sb.append(fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            p1(fragment);
        }
    }

    public boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.f2091q < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f2077c.n()) {
            if (fragment != null && H0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f2079e != null) {
            for (int i10 = 0; i10 < this.f2079e.size(); i10++) {
                Fragment fragment2 = (Fragment) this.f2079e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2079e = arrayList;
        return z10;
    }

    public void D0(Fragment fragment) {
        if (fragment.mAdded && G0(fragment)) {
            this.D = true;
        }
    }

    public void E() {
        this.G = true;
        a0(true);
        X();
        S(-1);
        this.f2092r = null;
        this.f2093s = null;
        this.f2094t = null;
        if (this.f2081g != null) {
            this.f2082h.d();
            this.f2081g = null;
        }
        androidx.activity.result.c cVar = this.f2100z;
        if (cVar != null) {
            cVar.c();
            this.A.c();
            this.B.c();
        }
    }

    public boolean E0() {
        return this.G;
    }

    public void F() {
        S(1);
    }

    public void G() {
        for (Fragment fragment : this.f2077c.n()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public final boolean G0(Fragment fragment) {
        if ((!fragment.mHasMenu || !fragment.mMenuVisible) && !fragment.mChildFragmentManager.o()) {
            return false;
        }
        return true;
    }

    public void H(boolean z10) {
        for (Fragment fragment : this.f2077c.n()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z10);
            }
        }
    }

    public boolean H0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public void I(Fragment fragment) {
        Iterator it = this.f2090p.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(this, fragment);
        }
    }

    public boolean I0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        o oVar = fragment.mFragmentManager;
        if (!fragment.equals(oVar.x0()) || !I0(oVar.f2094t)) {
            return false;
        }
        return true;
    }

    public boolean J(MenuItem menuItem) {
        if (this.f2091q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2077c.n()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean J0(int i10) {
        if (this.f2091q >= i10) {
            return true;
        }
        return false;
    }

    public void K(Menu menu) {
        if (this.f2091q >= 1) {
            for (Fragment fragment : this.f2077c.n()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public boolean K0() {
        if (this.E || this.F) {
            return true;
        }
        return false;
    }

    public final void L(Fragment fragment) {
        if (fragment != null && fragment.equals(f0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public void L0(Fragment fragment, String[] strArr, int i10) {
        if (this.B != null) {
            this.C.addLast(new l(fragment.mWho, i10));
            this.B.a(strArr);
            return;
        }
        this.f2092r.k(fragment, strArr, i10);
    }

    public void M() {
        S(5);
    }

    public void M0(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (this.f2100z != null) {
            this.C.addLast(new l(fragment.mWho, i10));
            if (!(intent == null || bundle == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.f2100z.a(intent);
            return;
        }
        this.f2092r.n(fragment, intent, i10, bundle);
    }

    public void N(boolean z10) {
        for (Fragment fragment : this.f2077c.n()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z10);
            }
        }
    }

    public void N0(Fragment fragment, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.A != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ActivityOptions ");
                    sb.append(bundle2);
                    sb.append(" were added to fillInIntent ");
                    sb.append(intent2);
                    sb.append(" for fragment ");
                    sb.append(fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            int i14 = i11;
            androidx.activity.result.e a10 = new e.b(intentSender).b(intent2).c(i12, i11).a();
            int i15 = i10;
            this.C.addLast(new l(fragment2.mWho, i10));
            if (F0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(fragment);
                sb2.append("is launching an IntentSender for result ");
            }
            this.A.a(a10);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i16 = i10;
        this.f2092r.o(fragment, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public boolean O(Menu menu) {
        boolean z10 = false;
        if (this.f2091q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2077c.n()) {
            if (fragment != null && H0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public final void O0(androidx.collection.b bVar) {
        int size = bVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            Fragment fragment = (Fragment) bVar.h(i10);
            if (!fragment.mAdded) {
                View requireView = fragment.requireView();
                fragment.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    public void P() {
        t1();
        L(this.f2095u);
    }

    public void P0(Fragment fragment) {
        if (this.f2077c.c(fragment.mWho)) {
            R0(fragment);
            View view = fragment.mView;
            if (!(view == null || !fragment.mIsNewlyAdded || fragment.mContainer == null)) {
                float f10 = fragment.mPostponedAlpha;
                if (f10 > 0.0f) {
                    view.setAlpha(f10);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                f.d c10 = f.c(this.f2092r.f(), fragment, true, fragment.getPopDirection());
                if (c10 != null) {
                    Animation animation = c10.f1989a;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        c10.f1990b.setTarget(fragment.mView);
                        c10.f1990b.start();
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                u(fragment);
            }
        } else if (F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring moving ");
            sb.append(fragment);
            sb.append(" to state ");
            sb.append(this.f2091q);
            sb.append("since it is not added to ");
            sb.append(this);
        }
    }

    public void Q() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(7);
    }

    public void Q0(int i10, boolean z10) {
        l lVar;
        boolean z11;
        if (this.f2092r == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z10 || i10 != this.f2091q) {
            this.f2091q = i10;
            if (P) {
                this.f2077c.r();
            } else {
                for (Fragment P0 : this.f2077c.n()) {
                    P0(P0);
                }
                for (v vVar : this.f2077c.k()) {
                    Fragment k10 = vVar.k();
                    if (!k10.mIsNewlyAdded) {
                        P0(k10);
                    }
                    if (!k10.mRemoving || k10.isInBackStack()) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        this.f2077c.q(vVar);
                    }
                }
            }
            r1();
            if (this.D && (lVar = this.f2092r) != null && this.f2091q == 7) {
                lVar.p();
                this.D = false;
            }
        }
    }

    public void R() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(5);
    }

    public void R0(Fragment fragment) {
        S0(fragment, this.f2091q);
    }

    /* JADX INFO: finally extract failed */
    public final void S(int i10) {
        try {
            this.f2076b = true;
            this.f2077c.d(i10);
            Q0(i10, false);
            if (P) {
                for (j0 j10 : r()) {
                    j10.j();
                }
            }
            this.f2076b = false;
            a0(true);
        } catch (Throwable th) {
            this.f2076b = false;
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r2 != 5) goto L_0x0155;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void S0(androidx.fragment.app.Fragment r10, int r11) {
        /*
            r9 = this;
            androidx.fragment.app.x r0 = r9.f2077c
            java.lang.String r1 = r10.mWho
            androidx.fragment.app.v r0 = r0.m(r1)
            r1 = 1
            if (r0 != 0) goto L_0x0017
            androidx.fragment.app.v r0 = new androidx.fragment.app.v
            androidx.fragment.app.n r2 = r9.f2089o
            androidx.fragment.app.x r3 = r9.f2077c
            r0.<init>(r2, r3, r10)
            r0.u(r1)
        L_0x0017:
            boolean r2 = r10.mFromLayout
            r3 = 2
            if (r2 == 0) goto L_0x0028
            boolean r2 = r10.mInLayout
            if (r2 == 0) goto L_0x0028
            int r2 = r10.mState
            if (r2 != r3) goto L_0x0028
            int r11 = java.lang.Math.max(r11, r3)
        L_0x0028:
            int r2 = r0.d()
            int r11 = java.lang.Math.min(r11, r2)
            int r2 = r10.mState
            r4 = 3
            r5 = -1
            r6 = 5
            r7 = 4
            if (r2 > r11) goto L_0x007a
            if (r2 >= r11) goto L_0x0045
            java.util.Map r2 = r9.f2087m
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0045
            r9.n(r10)
        L_0x0045:
            int r2 = r10.mState
            if (r2 == r5) goto L_0x0055
            if (r2 == 0) goto L_0x005a
            if (r2 == r1) goto L_0x005f
            if (r2 == r3) goto L_0x0069
            if (r2 == r7) goto L_0x006e
            if (r2 == r6) goto L_0x0073
            goto L_0x0155
        L_0x0055:
            if (r11 <= r5) goto L_0x005a
            r0.c()
        L_0x005a:
            if (r11 <= 0) goto L_0x005f
            r0.e()
        L_0x005f:
            if (r11 <= r5) goto L_0x0064
            r0.j()
        L_0x0064:
            if (r11 <= r1) goto L_0x0069
            r0.f()
        L_0x0069:
            if (r11 <= r3) goto L_0x006e
            r0.a()
        L_0x006e:
            if (r11 <= r7) goto L_0x0073
            r0.v()
        L_0x0073:
            if (r11 <= r6) goto L_0x0155
            r0.p()
            goto L_0x0155
        L_0x007a:
            if (r2 <= r11) goto L_0x0155
            if (r2 == 0) goto L_0x014e
            if (r2 == r1) goto L_0x0140
            if (r2 == r3) goto L_0x00bd
            if (r2 == r7) goto L_0x0095
            if (r2 == r6) goto L_0x0090
            r8 = 7
            if (r2 == r8) goto L_0x008b
            goto L_0x0155
        L_0x008b:
            if (r11 >= r8) goto L_0x0090
            r0.n()
        L_0x0090:
            if (r11 >= r6) goto L_0x0095
            r0.w()
        L_0x0095:
            if (r11 >= r7) goto L_0x00bd
            boolean r2 = F0(r4)
            if (r2 == 0) goto L_0x00aa
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "movefrom ACTIVITY_CREATED: "
            r2.append(r6)
            r2.append(r10)
        L_0x00aa:
            android.view.View r2 = r10.mView
            if (r2 == 0) goto L_0x00bd
            androidx.fragment.app.l r2 = r9.f2092r
            boolean r2 = r2.l(r10)
            if (r2 == 0) goto L_0x00bd
            android.util.SparseArray<android.os.Parcelable> r2 = r10.mSavedViewState
            if (r2 != 0) goto L_0x00bd
            r0.t()
        L_0x00bd:
            if (r11 >= r3) goto L_0x0140
            android.view.View r2 = r10.mView
            if (r2 == 0) goto L_0x0135
            android.view.ViewGroup r6 = r10.mContainer
            if (r6 == 0) goto L_0x0135
            r6.endViewTransition(r2)
            android.view.View r2 = r10.mView
            r2.clearAnimation()
            boolean r2 = r10.isRemovingParent()
            if (r2 != 0) goto L_0x0135
            int r2 = r9.f2091q
            r6 = 0
            if (r2 <= r5) goto L_0x00fc
            boolean r2 = r9.G
            if (r2 != 0) goto L_0x00fc
            android.view.View r2 = r10.mView
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x00fc
            float r2 = r10.mPostponedAlpha
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x00fc
            androidx.fragment.app.l r2 = r9.f2092r
            android.content.Context r2 = r2.f()
            r5 = 0
            boolean r7 = r10.getPopDirection()
            androidx.fragment.app.f$d r2 = androidx.fragment.app.f.c(r2, r10, r5, r7)
            goto L_0x00fd
        L_0x00fc:
            r2 = 0
        L_0x00fd:
            r10.mPostponedAlpha = r6
            android.view.ViewGroup r5 = r10.mContainer
            android.view.View r6 = r10.mView
            if (r2 == 0) goto L_0x010a
            androidx.fragment.app.z$g r7 = r9.f2088n
            androidx.fragment.app.f.a(r10, r2, r7)
        L_0x010a:
            r5.removeView(r6)
            boolean r2 = F0(r3)
            if (r2 == 0) goto L_0x0130
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Removing view "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = " for fragment "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r3 = " from container "
            r2.append(r3)
            r2.append(r5)
        L_0x0130:
            android.view.ViewGroup r2 = r10.mContainer
            if (r5 == r2) goto L_0x0135
            return
        L_0x0135:
            java.util.Map r2 = r9.f2087m
            java.lang.Object r2 = r2.get(r10)
            if (r2 != 0) goto L_0x0140
            r0.h()
        L_0x0140:
            if (r11 >= r1) goto L_0x014e
            java.util.Map r2 = r9.f2087m
            java.lang.Object r2 = r2.get(r10)
            if (r2 == 0) goto L_0x014b
            goto L_0x014f
        L_0x014b:
            r0.g()
        L_0x014e:
            r1 = r11
        L_0x014f:
            if (r1 >= 0) goto L_0x0154
            r0.i()
        L_0x0154:
            r11 = r1
        L_0x0155:
            int r0 = r10.mState
            if (r0 == r11) goto L_0x0180
            boolean r0 = F0(r4)
            if (r0 == 0) goto L_0x017e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r10.mState
            r0.append(r1)
        L_0x017e:
            r10.mState = r11
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.S0(androidx.fragment.app.Fragment, int):void");
    }

    public void T() {
        this.F = true;
        this.M.o(true);
        S(4);
    }

    public void T0() {
        if (this.f2092r != null) {
            this.E = false;
            this.F = false;
            this.M.o(false);
            for (Fragment fragment : this.f2077c.n()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    public void U() {
        S(2);
    }

    public void U0(i iVar) {
        View view;
        for (v vVar : this.f2077c.k()) {
            Fragment k10 = vVar.k();
            if (k10.mContainerId == iVar.getId() && (view = k10.mView) != null && view.getParent() == null) {
                k10.mContainer = iVar;
                vVar.b();
            }
        }
    }

    public final void V() {
        if (this.H) {
            this.H = false;
            r1();
        }
    }

    public void V0(v vVar) {
        Fragment k10 = vVar.k();
        if (!k10.mDeferStart) {
            return;
        }
        if (this.f2076b) {
            this.H = true;
            return;
        }
        k10.mDeferStart = false;
        if (P) {
            vVar.m();
        } else {
            R0(k10);
        }
    }

    public void W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f2077c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f2079e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.f2079e.get(i10)).toString());
            }
        }
        ArrayList arrayList2 = this.f2078d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = (a) this.f2078d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.x(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2083i.get());
        synchronized (this.f2075a) {
            int size3 = this.f2075a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i12 = 0; i12 < size3; i12++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i12);
                    printWriter.print(": ");
                    printWriter.println((m) this.f2075a.get(i12));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2092r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2093s);
        if (this.f2094t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2094t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2091q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public void W0(int i10, int i11) {
        if (i10 >= 0) {
            Y(new n((String) null, i10, i11), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public final void X() {
        if (P) {
            for (j0 j10 : r()) {
                j10.j();
            }
        } else if (!this.f2087m.isEmpty()) {
            for (Fragment fragment : this.f2087m.keySet()) {
                n(fragment);
                R0(fragment);
            }
        }
    }

    public boolean X0() {
        return Y0((String) null, -1, 0);
    }

    public void Y(m mVar, boolean z10) {
        if (!z10) {
            if (this.f2092r != null) {
                p();
            } else if (this.G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f2075a) {
            if (this.f2092r != null) {
                this.f2075a.add(mVar);
                l1();
            } else if (!z10) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final boolean Y0(String str, int i10, int i11) {
        a0(false);
        Z(true);
        Fragment fragment = this.f2095u;
        if (fragment != null && i10 < 0 && str == null && fragment.getChildFragmentManager().X0()) {
            return true;
        }
        boolean Z0 = Z0(this.I, this.J, str, i10, i11);
        if (Z0) {
            this.f2076b = true;
            try {
                e1(this.I, this.J);
            } finally {
                q();
            }
        }
        t1();
        V();
        this.f2077c.b();
        return Z0;
    }

    public final void Z(boolean z10) {
        if (this.f2076b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f2092r == null) {
            if (this.G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f2092r.g().getLooper()) {
            if (!z10) {
                p();
            }
            if (this.I == null) {
                this.I = new ArrayList();
                this.J = new ArrayList();
            }
            this.f2076b = true;
            try {
                e0((ArrayList) null, (ArrayList) null);
            } finally {
                this.f2076b = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    public boolean Z0(ArrayList arrayList, ArrayList arrayList2, String str, int i10, int i11) {
        int i12;
        ArrayList arrayList3 = this.f2078d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i10 < 0 && (i11 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2078d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i10 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = (a) this.f2078d.get(size2);
                    if ((str != null && str.equals(aVar.C())) || (i10 >= 0 && i10 == aVar.f1912v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i11 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = (a) this.f2078d.get(size2);
                        if ((str == null || !str.equals(aVar2.C())) && (i10 < 0 || i10 != aVar2.f1912v)) {
                            break;
                        }
                    }
                }
                i12 = size2;
            } else {
                i12 = -1;
            }
            if (i12 == this.f2078d.size() - 1) {
                return false;
            }
            for (int size3 = this.f2078d.size() - 1; size3 > i12; size3--) {
                arrayList.add(this.f2078d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public boolean a0(boolean z10) {
        Z(z10);
        boolean z11 = false;
        while (k0(this.I, this.J)) {
            z11 = true;
            this.f2076b = true;
            try {
                e1(this.I, this.J);
            } finally {
                q();
            }
        }
        t1();
        V();
        this.f2077c.b();
        return z11;
    }

    public final int a1(ArrayList arrayList, ArrayList arrayList2, int i10, int i11, androidx.collection.b bVar) {
        boolean z10;
        int i12 = i11;
        for (int i13 = i11 - 1; i13 >= i10; i13--) {
            a aVar = (a) arrayList.get(i13);
            boolean booleanValue = ((Boolean) arrayList2.get(i13)).booleanValue();
            if (!aVar.G() || aVar.E(arrayList, i13 + 1, i11)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                if (this.L == null) {
                    this.L = new ArrayList();
                }
                C0030o oVar = new C0030o(aVar, booleanValue);
                this.L.add(oVar);
                aVar.I(oVar);
                if (booleanValue) {
                    aVar.z();
                } else {
                    aVar.A(false);
                }
                i12--;
                if (i13 != i12) {
                    arrayList.remove(i13);
                    arrayList.add(i12, aVar);
                }
                d(bVar);
            }
        }
        return i12;
    }

    public void b0(m mVar, boolean z10) {
        if (!z10 || (this.f2092r != null && !this.G)) {
            Z(z10);
            if (mVar.a(this.I, this.J)) {
                this.f2076b = true;
                try {
                    e1(this.I, this.J);
                } finally {
                    q();
                }
            }
            t1();
            V();
            this.f2077c.b();
        }
    }

    public void b1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            s1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public void c1(Fragment fragment, x.b bVar) {
        HashSet hashSet = (HashSet) this.f2087m.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.f2087m.remove(fragment);
            if (fragment.mState < 5) {
                w(fragment);
                R0(fragment);
            }
        }
    }

    public final void d(androidx.collection.b bVar) {
        int i10 = this.f2091q;
        if (i10 >= 1) {
            int min = Math.min(i10, 5);
            for (Fragment fragment : this.f2077c.n()) {
                if (fragment.mState < min) {
                    S0(fragment, min);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        bVar.add(fragment);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d0(java.util.ArrayList r18, java.util.ArrayList r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            r15 = r18
            r5 = r19
            r4 = r20
            r3 = r21
            java.lang.Object r0 = r15.get(r4)
            androidx.fragment.app.a r0 = (androidx.fragment.app.a) r0
            boolean r2 = r0.f2188r
            java.util.ArrayList r0 = r6.K
            if (r0 != 0) goto L_0x001e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.K = r0
            goto L_0x0021
        L_0x001e:
            r0.clear()
        L_0x0021:
            java.util.ArrayList r0 = r6.K
            androidx.fragment.app.x r1 = r6.f2077c
            java.util.List r1 = r1.n()
            r0.addAll(r1)
            androidx.fragment.app.Fragment r0 = r17.x0()
            r1 = 0
            r7 = r4
            r16 = 0
        L_0x0034:
            r14 = 1
            if (r7 >= r3) goto L_0x0065
            java.lang.Object r8 = r15.get(r7)
            androidx.fragment.app.a r8 = (androidx.fragment.app.a) r8
            java.lang.Object r9 = r5.get(r7)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0050
            java.util.ArrayList r9 = r6.K
            androidx.fragment.app.Fragment r0 = r8.B(r9, r0)
            goto L_0x0056
        L_0x0050:
            java.util.ArrayList r9 = r6.K
            androidx.fragment.app.Fragment r0 = r8.J(r9, r0)
        L_0x0056:
            if (r16 != 0) goto L_0x0060
            boolean r8 = r8.f2179i
            if (r8 == 0) goto L_0x005d
            goto L_0x0060
        L_0x005d:
            r16 = 0
            goto L_0x0062
        L_0x0060:
            r16 = 1
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0034
        L_0x0065:
            java.util.ArrayList r0 = r6.K
            r0.clear()
            if (r2 != 0) goto L_0x00bd
            int r0 = r6.f2091q
            if (r0 < r14) goto L_0x00bd
            boolean r0 = P
            if (r0 == 0) goto L_0x00a4
            r0 = r4
        L_0x0075:
            if (r0 >= r3) goto L_0x00bd
            java.lang.Object r1 = r15.get(r0)
            androidx.fragment.app.a r1 = (androidx.fragment.app.a) r1
            java.util.ArrayList r1 = r1.f2173c
            java.util.Iterator r1 = r1.iterator()
        L_0x0083:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00a1
            java.lang.Object r7 = r1.next()
            androidx.fragment.app.y$a r7 = (androidx.fragment.app.y.a) r7
            androidx.fragment.app.Fragment r7 = r7.f2191b
            if (r7 == 0) goto L_0x0083
            androidx.fragment.app.o r8 = r7.mFragmentManager
            if (r8 == 0) goto L_0x0083
            androidx.fragment.app.v r7 = r6.v(r7)
            androidx.fragment.app.x r8 = r6.f2077c
            r8.p(r7)
            goto L_0x0083
        L_0x00a1:
            int r0 = r0 + 1
            goto L_0x0075
        L_0x00a4:
            androidx.fragment.app.l r0 = r6.f2092r
            android.content.Context r7 = r0.f()
            androidx.fragment.app.g r8 = r6.f2093s
            r13 = 0
            androidx.fragment.app.z$g r0 = r6.f2088n
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            r1 = 1
            r14 = r0
            androidx.fragment.app.z.B(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00be
        L_0x00bd:
            r1 = 1
        L_0x00be:
            c0(r18, r19, r20, r21)
            boolean r0 = P
            if (r0 == 0) goto L_0x0143
            int r0 = r3 + -1
            java.lang.Object r0 = r5.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = r4
        L_0x00d2:
            if (r2 >= r3) goto L_0x011c
            java.lang.Object r7 = r15.get(r2)
            androidx.fragment.app.a r7 = (androidx.fragment.app.a) r7
            if (r0 == 0) goto L_0x00fb
            java.util.ArrayList r8 = r7.f2173c
            int r8 = r8.size()
            int r8 = r8 - r1
        L_0x00e3:
            if (r8 < 0) goto L_0x0119
            java.util.ArrayList r9 = r7.f2173c
            java.lang.Object r9 = r9.get(r8)
            androidx.fragment.app.y$a r9 = (androidx.fragment.app.y.a) r9
            androidx.fragment.app.Fragment r9 = r9.f2191b
            if (r9 == 0) goto L_0x00f8
            androidx.fragment.app.v r9 = r6.v(r9)
            r9.m()
        L_0x00f8:
            int r8 = r8 + -1
            goto L_0x00e3
        L_0x00fb:
            java.util.ArrayList r7 = r7.f2173c
            java.util.Iterator r7 = r7.iterator()
        L_0x0101:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0119
            java.lang.Object r8 = r7.next()
            androidx.fragment.app.y$a r8 = (androidx.fragment.app.y.a) r8
            androidx.fragment.app.Fragment r8 = r8.f2191b
            if (r8 == 0) goto L_0x0101
            androidx.fragment.app.v r8 = r6.v(r8)
            r8.m()
            goto L_0x0101
        L_0x0119:
            int r2 = r2 + 1
            goto L_0x00d2
        L_0x011c:
            int r2 = r6.f2091q
            r6.Q0(r2, r1)
            java.util.Set r1 = r6.s(r15, r4, r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0129:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x013f
            java.lang.Object r2 = r1.next()
            androidx.fragment.app.j0 r2 = (androidx.fragment.app.j0) r2
            r2.r(r0)
            r2.p()
            r2.g()
            goto L_0x0129
        L_0x013f:
            r0 = r3
            r3 = r5
            goto L_0x0199
        L_0x0143:
            if (r2 == 0) goto L_0x0165
            androidx.collection.b r7 = new androidx.collection.b
            r7.<init>()
            r6.d(r7)
            r0 = r17
            r14 = 1
            r1 = r18
            r8 = r2
            r2 = r19
            r13 = r3
            r3 = r20
            r12 = r4
            r4 = r21
            r11 = r5
            r5 = r7
            int r0 = r0.a1(r1, r2, r3, r4, r5)
            r6.O0(r7)
            goto L_0x016b
        L_0x0165:
            r8 = r2
            r13 = r3
            r12 = r4
            r11 = r5
            r14 = 1
            r0 = r13
        L_0x016b:
            if (r0 == r12) goto L_0x0197
            if (r8 == 0) goto L_0x0197
            int r1 = r6.f2091q
            if (r1 < r14) goto L_0x018e
            androidx.fragment.app.l r1 = r6.f2092r
            android.content.Context r7 = r1.f()
            androidx.fragment.app.g r8 = r6.f2093s
            r1 = 1
            androidx.fragment.app.z$g r2 = r6.f2088n
            r9 = r18
            r10 = r19
            r3 = r11
            r11 = r20
            r12 = r0
            r0 = r13
            r13 = r1
            r1 = 1
            r14 = r2
            androidx.fragment.app.z.B(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0191
        L_0x018e:
            r3 = r11
            r0 = r13
            r1 = 1
        L_0x0191:
            int r2 = r6.f2091q
            r6.Q0(r2, r1)
            goto L_0x0199
        L_0x0197:
            r3 = r11
            r0 = r13
        L_0x0199:
            r1 = r20
        L_0x019b:
            if (r1 >= r0) goto L_0x01bc
            java.lang.Object r2 = r15.get(r1)
            androidx.fragment.app.a r2 = (androidx.fragment.app.a) r2
            java.lang.Object r4 = r3.get(r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01b6
            int r4 = r2.f1912v
            if (r4 < 0) goto L_0x01b6
            r4 = -1
            r2.f1912v = r4
        L_0x01b6:
            r2.H()
            int r1 = r1 + 1
            goto L_0x019b
        L_0x01bc:
            if (r16 == 0) goto L_0x01c1
            r17.g1()
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.d0(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public void d1(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.mBackStackNesting);
        }
        boolean z10 = !fragment.isInBackStack();
        if (!fragment.mDetached || z10) {
            this.f2077c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            p1(fragment);
        }
    }

    public void e(a aVar) {
        if (this.f2078d == null) {
            this.f2078d = new ArrayList();
        }
        this.f2078d.add(aVar);
    }

    public final void e0(ArrayList arrayList, ArrayList arrayList2) {
        int i10;
        int indexOf;
        int indexOf2;
        ArrayList arrayList3 = this.L;
        if (arrayList3 == null) {
            i10 = 0;
        } else {
            i10 = arrayList3.size();
        }
        int i11 = 0;
        while (i11 < i10) {
            C0030o oVar = (C0030o) this.L.get(i11);
            if (arrayList != null && !oVar.f2121a && (indexOf2 = arrayList.indexOf(oVar.f2122b)) != -1 && arrayList2 != null && ((Boolean) arrayList2.get(indexOf2)).booleanValue()) {
                this.L.remove(i11);
                i11--;
                i10--;
                oVar.c();
            } else if (oVar.e() || (arrayList != null && oVar.f2122b.E(arrayList, 0, arrayList.size()))) {
                this.L.remove(i11);
                i11--;
                i10--;
                if (arrayList == null || oVar.f2121a || (indexOf = arrayList.indexOf(oVar.f2122b)) == -1 || arrayList2 == null || !((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    oVar.d();
                } else {
                    oVar.c();
                }
            }
            i11++;
        }
    }

    public final void e1(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                e0(arrayList, arrayList2);
                int size = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    if (!((a) arrayList.get(i10)).f2188r) {
                        if (i11 != i10) {
                            d0(arrayList, arrayList2, i11, i10);
                        }
                        i11 = i10 + 1;
                        if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                            while (i11 < size && ((Boolean) arrayList2.get(i11)).booleanValue() && !((a) arrayList.get(i11)).f2188r) {
                                i11++;
                            }
                        }
                        d0(arrayList, arrayList2, i10, i11);
                        i10 = i11 - 1;
                    }
                    i10++;
                }
                if (i11 != size) {
                    d0(arrayList, arrayList2, i11, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public void f(Fragment fragment, x.b bVar) {
        if (this.f2087m.get(fragment) == null) {
            this.f2087m.put(fragment, new HashSet());
        }
        ((HashSet) this.f2087m.get(fragment)).add(bVar);
    }

    public Fragment f0(String str) {
        return this.f2077c.f(str);
    }

    public void f1(Fragment fragment) {
        this.M.n(fragment);
    }

    public v g(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("add: ");
            sb.append(fragment);
        }
        v v10 = v(fragment);
        fragment.mFragmentManager = this;
        this.f2077c.p(v10);
        if (!fragment.mDetached) {
            this.f2077c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
        return v10;
    }

    public Fragment g0(int i10) {
        return this.f2077c.g(i10);
    }

    public final void g1() {
        ArrayList arrayList = this.f2086l;
        if (arrayList != null && arrayList.size() > 0) {
            androidx.appcompat.app.m.a(this.f2086l.get(0));
            throw null;
        }
    }

    public void h(s sVar) {
        this.f2090p.add(sVar);
    }

    public Fragment h0(String str) {
        return this.f2077c.h(str);
    }

    public void h1(Parcelable parcelable) {
        v vVar;
        if (parcelable != null) {
            q qVar = (q) parcelable;
            if (qVar.f2124a != null) {
                this.f2077c.t();
                Iterator it = qVar.f2124a.iterator();
                while (it.hasNext()) {
                    u uVar = (u) it.next();
                    if (uVar != null) {
                        Fragment h10 = this.M.h(uVar.f2141b);
                        if (h10 != null) {
                            if (F0(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("restoreSaveState: re-attaching retained ");
                                sb.append(h10);
                            }
                            vVar = new v(this.f2089o, this.f2077c, h10, uVar);
                        } else {
                            vVar = new v(this.f2089o, this.f2077c, this.f2092r.f().getClassLoader(), q0(), uVar);
                        }
                        Fragment k10 = vVar.k();
                        k10.mFragmentManager = this;
                        if (F0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("restoreSaveState: active (");
                            sb2.append(k10.mWho);
                            sb2.append("): ");
                            sb2.append(k10);
                        }
                        vVar.o(this.f2092r.f().getClassLoader());
                        this.f2077c.p(vVar);
                        vVar.u(this.f2091q);
                    }
                }
                for (Fragment fragment : this.M.k()) {
                    if (!this.f2077c.c(fragment.mWho)) {
                        if (F0(2)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Discarding retained Fragment ");
                            sb3.append(fragment);
                            sb3.append(" that was not found in the set of active Fragments ");
                            sb3.append(qVar.f2124a);
                        }
                        this.M.n(fragment);
                        fragment.mFragmentManager = this;
                        v vVar2 = new v(this.f2089o, this.f2077c, fragment);
                        vVar2.u(1);
                        vVar2.m();
                        fragment.mRemoving = true;
                        vVar2.m();
                    }
                }
                this.f2077c.u(qVar.f2125b);
                if (qVar.f2126c != null) {
                    this.f2078d = new ArrayList(qVar.f2126c.length);
                    int i10 = 0;
                    while (true) {
                        b[] bVarArr = qVar.f2126c;
                        if (i10 >= bVarArr.length) {
                            break;
                        }
                        a a10 = bVarArr[i10].a(this);
                        if (F0(2)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("restoreAllState: back stack #");
                            sb4.append(i10);
                            sb4.append(" (index ");
                            sb4.append(a10.f1912v);
                            sb4.append("): ");
                            sb4.append(a10);
                            PrintWriter printWriter = new PrintWriter(new i0("FragmentManager"));
                            a10.y("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f2078d.add(a10);
                        i10++;
                    }
                } else {
                    this.f2078d = null;
                }
                this.f2083i.set(qVar.f2127d);
                String str = qVar.f2128e;
                if (str != null) {
                    Fragment f02 = f0(str);
                    this.f2095u = f02;
                    L(f02);
                }
                ArrayList arrayList = qVar.f2129f;
                if (arrayList != null) {
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        Bundle bundle = (Bundle) qVar.f2130g.get(i11);
                        bundle.setClassLoader(this.f2092r.f().getClassLoader());
                        this.f2084j.put(arrayList.get(i11), bundle);
                    }
                }
                this.C = new ArrayDeque(qVar.f2131h);
            }
        }
    }

    public void i(Fragment fragment) {
        this.M.f(fragment);
    }

    public Fragment i0(String str) {
        return this.f2077c.i(str);
    }

    public int j() {
        return this.f2083i.getAndIncrement();
    }

    public final void j0() {
        if (P) {
            for (j0 k10 : r()) {
                k10.k();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                ((C0030o) this.L.remove(0)).d();
            }
        }
    }

    public Parcelable j1() {
        int size;
        j0();
        X();
        a0(true);
        this.E = true;
        this.M.o(true);
        ArrayList v10 = this.f2077c.v();
        b[] bVarArr = null;
        if (v10.isEmpty()) {
            F0(2);
            return null;
        }
        ArrayList w10 = this.f2077c.w();
        ArrayList arrayList = this.f2078d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new b[size];
            for (int i10 = 0; i10 < size; i10++) {
                bVarArr[i10] = new b((a) this.f2078d.get(i10));
                if (F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveAllState: adding back stack #");
                    sb.append(i10);
                    sb.append(": ");
                    sb.append(this.f2078d.get(i10));
                }
            }
        }
        q qVar = new q();
        qVar.f2124a = v10;
        qVar.f2125b = w10;
        qVar.f2126c = bVarArr;
        qVar.f2127d = this.f2083i.get();
        Fragment fragment = this.f2095u;
        if (fragment != null) {
            qVar.f2128e = fragment.mWho;
        }
        qVar.f2129f.addAll(this.f2084j.keySet());
        qVar.f2130g.addAll(this.f2084j.values());
        qVar.f2131h = new ArrayList(this.C);
        return qVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: androidx.activity.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(androidx.fragment.app.l r3, androidx.fragment.app.g r4, androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.l r0 = r2.f2092r
            if (r0 != 0) goto L_0x0108
            r2.f2092r = r3
            r2.f2093s = r4
            r2.f2094t = r5
            if (r5 == 0) goto L_0x0015
            androidx.fragment.app.o$i r4 = new androidx.fragment.app.o$i
            r4.<init>(r5)
            r2.h(r4)
            goto L_0x001f
        L_0x0015:
            boolean r4 = r3 instanceof androidx.fragment.app.s
            if (r4 == 0) goto L_0x001f
            r4 = r3
            androidx.fragment.app.s r4 = (androidx.fragment.app.s) r4
            r2.h(r4)
        L_0x001f:
            androidx.fragment.app.Fragment r4 = r2.f2094t
            if (r4 == 0) goto L_0x0026
            r2.t1()
        L_0x0026:
            boolean r4 = r3 instanceof androidx.activity.c
            if (r4 == 0) goto L_0x003b
            r4 = r3
            androidx.activity.c r4 = (androidx.activity.c) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f2081g = r0
            if (r5 == 0) goto L_0x0036
            r4 = r5
        L_0x0036:
            androidx.activity.b r1 = r2.f2082h
            r0.a(r4, r1)
        L_0x003b:
            if (r5 == 0) goto L_0x0046
            androidx.fragment.app.o r3 = r5.mFragmentManager
            androidx.fragment.app.r r3 = r3.m0(r5)
            r2.M = r3
            goto L_0x005f
        L_0x0046:
            boolean r4 = r3 instanceof androidx.lifecycle.y
            if (r4 == 0) goto L_0x0057
            androidx.lifecycle.y r3 = (androidx.lifecycle.y) r3
            androidx.lifecycle.x r3 = r3.getViewModelStore()
            androidx.fragment.app.r r3 = androidx.fragment.app.r.j(r3)
            r2.M = r3
            goto L_0x005f
        L_0x0057:
            androidx.fragment.app.r r3 = new androidx.fragment.app.r
            r4 = 0
            r3.<init>(r4)
            r2.M = r3
        L_0x005f:
            androidx.fragment.app.r r3 = r2.M
            boolean r4 = r2.K0()
            r3.o(r4)
            androidx.fragment.app.x r3 = r2.f2077c
            androidx.fragment.app.r r4 = r2.M
            r3.x(r4)
            androidx.fragment.app.l r3 = r2.f2092r
            boolean r4 = r3 instanceof androidx.activity.result.d
            if (r4 == 0) goto L_0x0107
            androidx.activity.result.d r3 = (androidx.activity.result.d) r3
            androidx.activity.result.ActivityResultRegistry r3 = r3.getActivityResultRegistry()
            if (r5 == 0) goto L_0x0091
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r5.mWho
            r4.append(r5)
            java.lang.String r5 = ":"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x0093
        L_0x0091:
            java.lang.String r4 = ""
        L_0x0093:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "FragmentManager:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartActivityForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            c.c r0 = new c.c
            r0.<init>()
            androidx.fragment.app.o$j r1 = new androidx.fragment.app.o$j
            r1.<init>()
            androidx.activity.result.c r5 = r3.j(r5, r0, r1)
            r2.f2100z = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartIntentSenderForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.fragment.app.o$k r0 = new androidx.fragment.app.o$k
            r0.<init>()
            androidx.fragment.app.o$a r1 = new androidx.fragment.app.o$a
            r1.<init>()
            androidx.activity.result.c r5 = r3.j(r5, r0, r1)
            r2.A = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "RequestPermissions"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            c.b r5 = new c.b
            r5.<init>()
            androidx.fragment.app.o$b r0 = new androidx.fragment.app.o$b
            r0.<init>()
            androidx.activity.result.c r3 = r3.j(r4, r5, r0)
            r2.B = r3
        L_0x0107:
            return
        L_0x0108:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.k(androidx.fragment.app.l, androidx.fragment.app.g, androidx.fragment.app.Fragment):void");
    }

    public final boolean k0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f2075a) {
            if (this.f2075a.isEmpty()) {
                return false;
            }
            int size = this.f2075a.size();
            boolean z10 = false;
            for (int i10 = 0; i10 < size; i10++) {
                z10 |= ((m) this.f2075a.get(i10)).a(arrayList, arrayList2);
            }
            this.f2075a.clear();
            this.f2092r.g().removeCallbacks(this.N);
            return z10;
        }
    }

    public Fragment.m k1(Fragment fragment) {
        v m10 = this.f2077c.m(fragment.mWho);
        if (m10 == null || !m10.k().equals(fragment)) {
            s1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return m10.r();
    }

    public void l(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("attach: ");
            sb.append(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f2077c.a(fragment);
                if (F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("add from attach: ");
                    sb2.append(fragment);
                }
                if (G0(fragment)) {
                    this.D = true;
                }
            }
        }
    }

    public int l0() {
        ArrayList arrayList = this.f2078d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void l1() {
        boolean z10;
        synchronized (this.f2075a) {
            ArrayList arrayList = this.L;
            boolean z11 = false;
            if (arrayList == null || arrayList.isEmpty()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (this.f2075a.size() == 1) {
                z11 = true;
            }
            if (z10 || z11) {
                this.f2092r.g().removeCallbacks(this.N);
                this.f2092r.g().post(this.N);
                t1();
            }
        }
    }

    public y m() {
        return new a(this);
    }

    public final r m0(Fragment fragment) {
        return this.M.i(fragment);
    }

    public void m1(Fragment fragment, boolean z10) {
        ViewGroup p02 = p0(fragment);
        if (p02 != null && (p02 instanceof i)) {
            ((i) p02).setDrawDisappearingViewsLast(!z10);
        }
    }

    public final void n(Fragment fragment) {
        HashSet hashSet = (HashSet) this.f2087m.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((x.b) it.next()).a();
            }
            hashSet.clear();
            w(fragment);
            this.f2087m.remove(fragment);
        }
    }

    public g n0() {
        return this.f2093s;
    }

    public void n1(Fragment fragment, d.c cVar) {
        if (!fragment.equals(f0(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = cVar;
    }

    public boolean o() {
        boolean z10 = false;
        for (Fragment fragment : this.f2077c.l()) {
            if (fragment != null) {
                z10 = G0(fragment);
                continue;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public Fragment o0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment f02 = f0(string);
        if (f02 == null) {
            s1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return f02;
    }

    public void o1(Fragment fragment) {
        if (fragment == null || (fragment.equals(f0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f2095u;
            this.f2095u = fragment;
            L(fragment2);
            L(this.f2095u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void p() {
        if (K0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final ViewGroup p0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f2093s.d()) {
            View c10 = this.f2093s.c(fragment.mContainerId);
            if (c10 instanceof ViewGroup) {
                return (ViewGroup) c10;
            }
        }
        return null;
    }

    public final void p1(Fragment fragment) {
        ViewGroup p02 = p0(fragment);
        if (p02 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            int i10 = R$id.visible_removing_fragment_view_tag;
            if (p02.getTag(i10) == null) {
                p02.setTag(i10, fragment);
            }
            ((Fragment) p02.getTag(i10)).setPopDirection(fragment.getPopDirection());
        }
    }

    public final void q() {
        this.f2076b = false;
        this.J.clear();
        this.I.clear();
    }

    public k q0() {
        k kVar = this.f2096v;
        if (kVar != null) {
            return kVar;
        }
        Fragment fragment = this.f2094t;
        if (fragment != null) {
            return fragment.mFragmentManager.q0();
        }
        return this.f2097w;
    }

    public void q1(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("show: ");
            sb.append(fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final Set r() {
        HashSet hashSet = new HashSet();
        for (v k10 : this.f2077c.k()) {
            ViewGroup viewGroup = k10.k().mContainer;
            if (viewGroup != null) {
                hashSet.add(j0.o(viewGroup, y0()));
            }
        }
        return hashSet;
    }

    public x r0() {
        return this.f2077c;
    }

    public final void r1() {
        for (v V0 : this.f2077c.k()) {
            V0(V0);
        }
    }

    public final Set s(ArrayList arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator it = ((a) arrayList.get(i10)).f2173c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((y.a) it.next()).f2191b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(j0.n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    public List s0() {
        return this.f2077c.n();
    }

    public final void s1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new i0("FragmentManager"));
        l lVar = this.f2092r;
        if (lVar != null) {
            try {
                lVar.h("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
            }
        } else {
            try {
                W("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e11) {
                Log.e("FragmentManager", "Failed dumping state", e11);
            }
        }
        throw runtimeException;
    }

    public void t(a aVar, boolean z10, boolean z11, boolean z12) {
        if (z10) {
            aVar.A(z12);
        } else {
            aVar.z();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z10));
        if (z11 && this.f2091q >= 1) {
            z.B(this.f2092r.f(), this.f2093s, arrayList, arrayList2, 0, 1, true, this.f2088n);
        }
        if (z12) {
            Q0(this.f2091q, true);
        }
        for (Fragment fragment : this.f2077c.l()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.D(fragment.mContainerId)) {
                float f10 = fragment.mPostponedAlpha;
                if (f10 > 0.0f) {
                    fragment.mView.setAlpha(f10);
                }
                if (z12) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public l t0() {
        return this.f2092r;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (l0() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (I0(r3.f2094t) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f2082h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t1() {
        /*
            r3 = this;
            java.util.ArrayList r0 = r3.f2075a
            monitor-enter(r0)
            java.util.ArrayList r1 = r3.f2075a     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.b r1 = r3.f2082h     // Catch:{ all -> 0x002a }
            r1.f(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.b r0 = r3.f2082h
            int r1 = r3.l0()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.f2094t
            boolean r1 = r3.I0(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.f(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.t1():void");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f2094t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f2094t)));
            sb.append("}");
        } else {
            l lVar = this.f2092r;
            if (lVar != null) {
                sb.append(lVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f2092r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(Fragment fragment) {
        int i10;
        Animator animator;
        if (fragment.mView != null) {
            f.d c10 = f.c(this.f2092r.f(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c10 == null || (animator = c10.f1990b) == null) {
                if (c10 != null) {
                    fragment.mView.startAnimation(c10.f1989a);
                    c10.f1989a.start();
                }
                if (!fragment.mHidden || fragment.isHideReplaced()) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                fragment.mView.setVisibility(i10);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c10.f1990b.addListener(new h(viewGroup, view, fragment));
                }
                c10.f1990b.start();
            }
        }
        D0(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    public LayoutInflater.Factory2 u0() {
        return this.f2080f;
    }

    public v v(Fragment fragment) {
        v m10 = this.f2077c.m(fragment.mWho);
        if (m10 != null) {
            return m10;
        }
        v vVar = new v(this.f2089o, this.f2077c, fragment);
        vVar.o(this.f2092r.f().getClassLoader());
        vVar.u(this.f2091q);
        return vVar;
    }

    public n v0() {
        return this.f2089o;
    }

    public final void w(Fragment fragment) {
        fragment.performDestroyView();
        this.f2089o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.n((Object) null);
        fragment.mInLayout = false;
    }

    public Fragment w0() {
        return this.f2094t;
    }

    public void x(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("detach: ");
            sb.append(fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("remove from detach: ");
                    sb2.append(fragment);
                }
                this.f2077c.s(fragment);
                if (G0(fragment)) {
                    this.D = true;
                }
                p1(fragment);
            }
        }
    }

    public Fragment x0() {
        return this.f2095u;
    }

    public void y() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(4);
    }

    public k0 y0() {
        k0 k0Var = this.f2098x;
        if (k0Var != null) {
            return k0Var;
        }
        Fragment fragment = this.f2094t;
        if (fragment != null) {
            return fragment.mFragmentManager.y0();
        }
        return this.f2099y;
    }

    public void z() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(0);
    }

    public static class l implements Parcelable {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public String f2115a;

        /* renamed from: b  reason: collision with root package name */
        public int f2116b;

        public class a implements Parcelable.Creator {
            /* renamed from: a */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel);
            }

            /* renamed from: b */
            public l[] newArray(int i10) {
                return new l[i10];
            }
        }

        public l(String str, int i10) {
            this.f2115a = str;
            this.f2116b = i10;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f2115a);
            parcel.writeInt(this.f2116b);
        }

        public l(Parcel parcel) {
            this.f2115a = parcel.readString();
            this.f2116b = parcel.readInt();
        }
    }
}
