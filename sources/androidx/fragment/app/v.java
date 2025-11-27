package androidx.fragment.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j0;
import androidx.lifecycle.d;
import androidx.lifecycle.y;
import b0.c1;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public final n f2153a;

    /* renamed from: b  reason: collision with root package name */
    public final x f2154b;

    /* renamed from: c  reason: collision with root package name */
    public final Fragment f2155c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2156d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f2157e = -1;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f2158a;

        public a(View view) {
            this.f2158a = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f2158a.removeOnAttachStateChangeListener(this);
            c1.h0(this.f2158a);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2160a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.d$c[] r0 = androidx.lifecycle.d.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2160a = r0
                androidx.lifecycle.d$c r1 = androidx.lifecycle.d.c.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2160a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.d$c r1 = androidx.lifecycle.d.c.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2160a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.d$c r1 = androidx.lifecycle.d.c.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2160a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.d$c r1 = androidx.lifecycle.d.c.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.v.b.<clinit>():void");
        }
    }

    public v(n nVar, x xVar, Fragment fragment) {
        this.f2153a = nVar;
        this.f2154b = xVar;
        this.f2155c = fragment;
    }

    public void a() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto ACTIVITY_CREATED: ");
            sb.append(this.f2155c);
        }
        Fragment fragment = this.f2155c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        n nVar = this.f2153a;
        Fragment fragment2 = this.f2155c;
        nVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void b() {
        int j10 = this.f2154b.j(this.f2155c);
        Fragment fragment = this.f2155c;
        fragment.mContainer.addView(fragment.mView, j10);
    }

    public void c() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto ATTACHED: ");
            sb.append(this.f2155c);
        }
        Fragment fragment = this.f2155c;
        Fragment fragment2 = fragment.mTarget;
        v vVar = null;
        if (fragment2 != null) {
            v m10 = this.f2154b.m(fragment2.mWho);
            if (m10 != null) {
                Fragment fragment3 = this.f2155c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                vVar = m10;
            } else {
                throw new IllegalStateException("Fragment " + this.f2155c + " declared target fragment " + this.f2155c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (vVar = this.f2154b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f2155c + " declared target fragment " + this.f2155c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (vVar != null && (o.P || vVar.k().mState < 1)) {
            vVar.m();
        }
        Fragment fragment4 = this.f2155c;
        fragment4.mHost = fragment4.mFragmentManager.t0();
        Fragment fragment5 = this.f2155c;
        fragment5.mParentFragment = fragment5.mFragmentManager.w0();
        this.f2153a.g(this.f2155c, false);
        this.f2155c.performAttach();
        this.f2153a.b(this.f2155c, false);
    }

    public int d() {
        j0.e.b bVar;
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f2155c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i10 = this.f2157e;
        int i11 = b.f2160a[fragment2.mMaxState.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                i10 = Math.min(i10, 5);
            } else if (i11 == 3) {
                i10 = Math.min(i10, 1);
            } else if (i11 != 4) {
                i10 = Math.min(i10, -1);
            } else {
                i10 = Math.min(i10, 0);
            }
        }
        Fragment fragment3 = this.f2155c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i10 = Math.max(this.f2157e, 2);
                View view = this.f2155c.mView;
                if (view != null && view.getParent() == null) {
                    i10 = Math.min(i10, 2);
                }
            } else {
                i10 = this.f2157e < 4 ? Math.min(i10, fragment3.mState) : Math.min(i10, 1);
            }
        }
        if (!this.f2155c.mAdded) {
            i10 = Math.min(i10, 1);
        }
        if (!o.P || (viewGroup = fragment.mContainer) == null) {
            bVar = null;
        } else {
            bVar = j0.n(viewGroup, (fragment = this.f2155c).getParentFragmentManager()).l(this);
        }
        if (bVar == j0.e.b.ADDING) {
            i10 = Math.min(i10, 6);
        } else if (bVar == j0.e.b.REMOVING) {
            i10 = Math.max(i10, 3);
        } else {
            Fragment fragment4 = this.f2155c;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i10 = Math.min(i10, 1);
                } else {
                    i10 = Math.min(i10, -1);
                }
            }
        }
        Fragment fragment5 = this.f2155c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i10 = Math.min(i10, 4);
        }
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("computeExpectedState() of ");
            sb.append(i10);
            sb.append(" for ");
            sb.append(this.f2155c);
        }
        return i10;
    }

    public void e() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto CREATED: ");
            sb.append(this.f2155c);
        }
        Fragment fragment = this.f2155c;
        if (!fragment.mIsCreated) {
            this.f2153a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f2155c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            n nVar = this.f2153a;
            Fragment fragment3 = this.f2155c;
            nVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f2155c.mState = 1;
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r6 = this;
            androidx.fragment.app.Fragment r0 = r6.f2155c
            boolean r0 = r0.mFromLayout
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 3
            boolean r0 = androidx.fragment.app.o.F0(r0)
            if (r0 == 0) goto L_0x001d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto CREATE_VIEW: "
            r0.append(r1)
            androidx.fragment.app.Fragment r1 = r6.f2155c
            r0.append(r1)
        L_0x001d:
            androidx.fragment.app.Fragment r0 = r6.f2155c
            android.os.Bundle r1 = r0.mSavedFragmentState
            android.view.LayoutInflater r0 = r0.performGetLayoutInflater(r1)
            androidx.fragment.app.Fragment r1 = r6.f2155c
            android.view.ViewGroup r2 = r1.mContainer
            if (r2 == 0) goto L_0x002d
            goto L_0x00ad
        L_0x002d:
            int r2 = r1.mContainerId
            if (r2 == 0) goto L_0x00ac
            r3 = -1
            if (r2 == r3) goto L_0x008e
            androidx.fragment.app.o r1 = r1.mFragmentManager
            androidx.fragment.app.g r1 = r1.n0()
            androidx.fragment.app.Fragment r2 = r6.f2155c
            int r2 = r2.mContainerId
            android.view.View r1 = r1.c(r2)
            r2 = r1
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 != 0) goto L_0x00ad
            androidx.fragment.app.Fragment r1 = r6.f2155c
            boolean r3 = r1.mRestored
            if (r3 == 0) goto L_0x004e
            goto L_0x00ad
        L_0x004e:
            android.content.res.Resources r0 = r1.getResources()     // Catch:{ NotFoundException -> 0x005b }
            androidx.fragment.app.Fragment r1 = r6.f2155c     // Catch:{ NotFoundException -> 0x005b }
            int r1 = r1.mContainerId     // Catch:{ NotFoundException -> 0x005b }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x005b }
            goto L_0x005d
        L_0x005b:
            java.lang.String r0 = "unknown"
        L_0x005d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            androidx.fragment.app.Fragment r3 = r6.f2155c
            int r3 = r3.mContainerId
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            androidx.fragment.app.Fragment r0 = r6.f2155c
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x008e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            androidx.fragment.app.Fragment r2 = r6.f2155c
            r1.append(r2)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ac:
            r2 = 0
        L_0x00ad:
            androidx.fragment.app.Fragment r1 = r6.f2155c
            r1.mContainer = r2
            android.os.Bundle r3 = r1.mSavedFragmentState
            r1.performCreateView(r0, r2, r3)
            androidx.fragment.app.Fragment r0 = r6.f2155c
            android.view.View r0 = r0.mView
            r1 = 2
            if (r0 == 0) goto L_0x0169
            r3 = 0
            r0.setSaveFromParentEnabled(r3)
            androidx.fragment.app.Fragment r0 = r6.f2155c
            android.view.View r4 = r0.mView
            int r5 = androidx.fragment.R$id.fragment_container_view_tag
            r4.setTag(r5, r0)
            if (r2 == 0) goto L_0x00cf
            r6.b()
        L_0x00cf:
            androidx.fragment.app.Fragment r0 = r6.f2155c
            boolean r2 = r0.mHidden
            if (r2 == 0) goto L_0x00dc
            android.view.View r0 = r0.mView
            r2 = 8
            r0.setVisibility(r2)
        L_0x00dc:
            androidx.fragment.app.Fragment r0 = r6.f2155c
            android.view.View r0 = r0.mView
            boolean r0 = b0.c1.P(r0)
            if (r0 == 0) goto L_0x00ee
            androidx.fragment.app.Fragment r0 = r6.f2155c
            android.view.View r0 = r0.mView
            b0.c1.h0(r0)
            goto L_0x00fa
        L_0x00ee:
            androidx.fragment.app.Fragment r0 = r6.f2155c
            android.view.View r0 = r0.mView
            androidx.fragment.app.v$a r2 = new androidx.fragment.app.v$a
            r2.<init>(r0)
            r0.addOnAttachStateChangeListener(r2)
        L_0x00fa:
            androidx.fragment.app.Fragment r0 = r6.f2155c
            r0.performViewCreated()
            androidx.fragment.app.n r0 = r6.f2153a
            androidx.fragment.app.Fragment r2 = r6.f2155c
            android.view.View r4 = r2.mView
            android.os.Bundle r5 = r2.mSavedFragmentState
            r0.m(r2, r4, r5, r3)
            androidx.fragment.app.Fragment r0 = r6.f2155c
            android.view.View r0 = r0.mView
            int r0 = r0.getVisibility()
            androidx.fragment.app.Fragment r2 = r6.f2155c
            android.view.View r2 = r2.mView
            float r2 = r2.getAlpha()
            boolean r4 = androidx.fragment.app.o.P
            if (r4 == 0) goto L_0x015e
            androidx.fragment.app.Fragment r3 = r6.f2155c
            r3.setPostOnViewCreatedAlpha(r2)
            androidx.fragment.app.Fragment r2 = r6.f2155c
            android.view.ViewGroup r3 = r2.mContainer
            if (r3 == 0) goto L_0x0169
            if (r0 != 0) goto L_0x0169
            android.view.View r0 = r2.mView
            android.view.View r0 = r0.findFocus()
            if (r0 == 0) goto L_0x0155
            androidx.fragment.app.Fragment r2 = r6.f2155c
            r2.setFocusedView(r0)
            boolean r2 = androidx.fragment.app.o.F0(r1)
            if (r2 == 0) goto L_0x0155
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "requestFocus: Saved focused view "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " for Fragment "
            r2.append(r0)
            androidx.fragment.app.Fragment r0 = r6.f2155c
            r2.append(r0)
        L_0x0155:
            androidx.fragment.app.Fragment r0 = r6.f2155c
            android.view.View r0 = r0.mView
            r2 = 0
            r0.setAlpha(r2)
            goto L_0x0169
        L_0x015e:
            androidx.fragment.app.Fragment r2 = r6.f2155c
            if (r0 != 0) goto L_0x0167
            android.view.ViewGroup r0 = r2.mContainer
            if (r0 == 0) goto L_0x0167
            r3 = 1
        L_0x0167:
            r2.mIsNewlyAdded = r3
        L_0x0169:
            androidx.fragment.app.Fragment r0 = r6.f2155c
            r0.mState = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.v.f():void");
    }

    public void g() {
        boolean z10;
        boolean z11;
        Fragment f10;
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATED: ");
            sb.append(this.f2155c);
        }
        Fragment fragment = this.f2155c;
        boolean z12 = true;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 || this.f2154b.o().p(this.f2155c)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            l lVar = this.f2155c.mHost;
            if (lVar instanceof y) {
                z12 = this.f2154b.o().m();
            } else if (lVar.f() instanceof Activity) {
                z12 = true ^ ((Activity) lVar.f()).isChangingConfigurations();
            }
            if (z10 || z12) {
                this.f2154b.o().g(this.f2155c);
            }
            this.f2155c.performDestroy();
            this.f2153a.d(this.f2155c, false);
            for (v vVar : this.f2154b.k()) {
                if (vVar != null) {
                    Fragment k10 = vVar.k();
                    if (this.f2155c.mWho.equals(k10.mTargetWho)) {
                        k10.mTarget = this.f2155c;
                        k10.mTargetWho = null;
                    }
                }
            }
            Fragment fragment2 = this.f2155c;
            String str = fragment2.mTargetWho;
            if (str != null) {
                fragment2.mTarget = this.f2154b.f(str);
            }
            this.f2154b.q(this);
            return;
        }
        String str2 = this.f2155c.mTargetWho;
        if (!(str2 == null || (f10 = this.f2154b.f(str2)) == null || !f10.mRetainInstance)) {
            this.f2155c.mTarget = f10;
        }
        this.f2155c.mState = 0;
    }

    public void h() {
        View view;
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATE_VIEW: ");
            sb.append(this.f2155c);
        }
        Fragment fragment = this.f2155c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.f2155c.performDestroyView();
        this.f2153a.n(this.f2155c, false);
        Fragment fragment2 = this.f2155c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.n((Object) null);
        this.f2155c.mInLayout = false;
    }

    public void i() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom ATTACHED: ");
            sb.append(this.f2155c);
        }
        this.f2155c.performDetach();
        boolean z10 = false;
        this.f2153a.e(this.f2155c, false);
        Fragment fragment = this.f2155c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z10 = true;
        }
        if (z10 || this.f2154b.o().p(this.f2155c)) {
            if (o.F0(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("initState called for fragment: ");
                sb2.append(this.f2155c);
            }
            this.f2155c.initState();
        }
    }

    public void j() {
        Fragment fragment = this.f2155c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (o.F0(3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("moveto CREATE_VIEW: ");
                sb.append(this.f2155c);
            }
            Fragment fragment2 = this.f2155c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), (ViewGroup) null, this.f2155c.mSavedFragmentState);
            View view = this.f2155c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f2155c;
                fragment3.mView.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f2155c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f2155c.performViewCreated();
                n nVar = this.f2153a;
                Fragment fragment5 = this.f2155c;
                nVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f2155c.mState = 2;
            }
        }
    }

    public Fragment k() {
        return this.f2155c;
    }

    public final boolean l(View view) {
        if (view == this.f2155c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f2155c.mView) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f2156d) {
            boolean z10 = false;
            z10 = true;
            try {
                while (true) {
                    int d10 = d();
                    Fragment fragment = this.f2155c;
                    int i10 = fragment.mState;
                    if (d10 != i10) {
                        if (d10 <= i10) {
                            switch (i10 - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    g();
                                    break;
                                case 1:
                                    h();
                                    this.f2155c.mState = z10 ? 1 : 0;
                                    break;
                                case 2:
                                    fragment.mInLayout = z10;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (o.F0(3)) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("movefrom ACTIVITY_CREATED: ");
                                        sb.append(this.f2155c);
                                    }
                                    Fragment fragment2 = this.f2155c;
                                    if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        t();
                                    }
                                    Fragment fragment3 = this.f2155c;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        j0.n(viewGroup2, fragment3.getParentFragmentManager()).d(this);
                                    }
                                    this.f2155c.mState = 3;
                                    break;
                                case 4:
                                    w();
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    n();
                                    break;
                            }
                        } else {
                            switch (i10 + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        j0.n(viewGroup3, fragment.getParentFragmentManager()).b(j0.e.c.b(this.f2155c.mView.getVisibility()), this);
                                    }
                                    this.f2155c.mState = 4;
                                    break;
                                case 5:
                                    v();
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    p();
                                    break;
                            }
                        }
                    } else {
                        if (o.P && fragment.mHiddenChanged) {
                            if (!(fragment.mView == null || (viewGroup = fragment.mContainer) == null)) {
                                j0 n10 = j0.n(viewGroup, fragment.getParentFragmentManager());
                                if (this.f2155c.mHidden) {
                                    n10.c(this);
                                } else {
                                    n10.e(this);
                                }
                            }
                            Fragment fragment4 = this.f2155c;
                            o oVar = fragment4.mFragmentManager;
                            if (oVar != null) {
                                oVar.D0(fragment4);
                            }
                            Fragment fragment5 = this.f2155c;
                            fragment5.mHiddenChanged = z10;
                            fragment5.onHiddenChanged(fragment5.mHidden);
                        }
                        this.f2156d = z10;
                        return;
                    }
                }
            } finally {
                this.f2156d = z10;
            }
        } else if (o.F0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring re-entrant call to moveToExpectedState() for ");
            sb2.append(k());
        }
    }

    public void n() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom RESUMED: ");
            sb.append(this.f2155c);
        }
        this.f2155c.performPause();
        this.f2153a.f(this.f2155c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f2155c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f2155c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f2155c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f2155c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            Fragment fragment4 = this.f2155c;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.f2155c;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.f2155c.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.f2155c;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    public void p() {
        String str;
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto RESUMED: ");
            sb.append(this.f2155c);
        }
        View focusedView = this.f2155c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (o.F0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = "failed";
                }
                sb2.append(str);
                sb2.append(" on Fragment ");
                sb2.append(this.f2155c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f2155c.mView.findFocus());
            }
        }
        this.f2155c.setFocusedView((View) null);
        this.f2155c.performResume();
        this.f2153a.i(this.f2155c, false);
        Fragment fragment = this.f2155c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final Bundle q() {
        Bundle bundle = new Bundle();
        this.f2155c.performSaveInstanceState(bundle);
        this.f2153a.j(this.f2155c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f2155c.mView != null) {
            t();
        }
        if (this.f2155c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f2155c.mSavedViewState);
        }
        if (this.f2155c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f2155c.mSavedViewRegistryState);
        }
        if (!this.f2155c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f2155c.mUserVisibleHint);
        }
        return bundle;
    }

    public Fragment.m r() {
        Bundle q10;
        if (this.f2155c.mState <= -1 || (q10 = q()) == null) {
            return null;
        }
        return new Fragment.m(q10);
    }

    public u s() {
        u uVar = new u(this.f2155c);
        Fragment fragment = this.f2155c;
        if (fragment.mState <= -1 || uVar.f2152m != null) {
            uVar.f2152m = fragment.mSavedFragmentState;
        } else {
            Bundle q10 = q();
            uVar.f2152m = q10;
            if (this.f2155c.mTargetWho != null) {
                if (q10 == null) {
                    uVar.f2152m = new Bundle();
                }
                uVar.f2152m.putString("android:target_state", this.f2155c.mTargetWho);
                int i10 = this.f2155c.mTargetRequestCode;
                if (i10 != 0) {
                    uVar.f2152m.putInt("android:target_req_state", i10);
                }
            }
        }
        return uVar;
    }

    public void t() {
        if (this.f2155c.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f2155c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f2155c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f2155c.mViewLifecycleOwner.e(bundle);
            if (!bundle.isEmpty()) {
                this.f2155c.mSavedViewRegistryState = bundle;
            }
        }
    }

    public void u(int i10) {
        this.f2157e = i10;
    }

    public void v() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto STARTED: ");
            sb.append(this.f2155c);
        }
        this.f2155c.performStart();
        this.f2153a.k(this.f2155c, false);
    }

    public void w() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom STARTED: ");
            sb.append(this.f2155c);
        }
        this.f2155c.performStop();
        this.f2153a.l(this.f2155c, false);
    }

    public v(n nVar, x xVar, ClassLoader classLoader, k kVar, u uVar) {
        this.f2153a = nVar;
        this.f2154b = xVar;
        Fragment a10 = kVar.a(classLoader, uVar.f2140a);
        this.f2155c = a10;
        Bundle bundle = uVar.f2149j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a10.setArguments(uVar.f2149j);
        a10.mWho = uVar.f2141b;
        a10.mFromLayout = uVar.f2142c;
        a10.mRestored = true;
        a10.mFragmentId = uVar.f2143d;
        a10.mContainerId = uVar.f2144e;
        a10.mTag = uVar.f2145f;
        a10.mRetainInstance = uVar.f2146g;
        a10.mRemoving = uVar.f2147h;
        a10.mDetached = uVar.f2148i;
        a10.mHidden = uVar.f2150k;
        a10.mMaxState = d.c.values()[uVar.f2151l];
        Bundle bundle2 = uVar.f2152m;
        if (bundle2 != null) {
            a10.mSavedFragmentState = bundle2;
        } else {
            a10.mSavedFragmentState = new Bundle();
        }
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Instantiated fragment ");
            sb.append(a10);
        }
    }

    public v(n nVar, x xVar, Fragment fragment, u uVar) {
        this.f2153a = nVar;
        this.f2154b = xVar;
        this.f2155c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = uVar.f2152m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
