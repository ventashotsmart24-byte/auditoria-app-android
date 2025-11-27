package b6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b6.q;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.event.BannerAutoPlayEvent;
import com.mobile.brasiltv.bean.event.CouponQualificationEvent;
import com.mobile.brasiltv.bean.event.HomePageAdEvent;
import com.mobile.brasiltv.bean.event.InterstitialEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.MoveToFirst;
import com.mobile.brasiltv.bean.event.VodPageRestartEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.k;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.dialog.HomeImportantAdDialog;
import com.mobile.brasiltv.view.dialog.InterstitialDialog;
import com.mobile.brasiltv.view.vod.CouponFloatView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g5.r1;
import h9.g;
import h9.h;
import i9.r;
import io.reactivex.disposables.Disposable;
import j6.j;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.z1;
import mobile.com.requestframe.utils.response.ChildColumnList;
import org.greenrobot.eventbus.ThreadMode;
import s1.m;
import t9.i;
import w6.i;

public final class g3 extends e<z1> implements j, SwipeRefreshLayout.j, p, q {

    /* renamed from: i  reason: collision with root package name */
    public final g f4392i = h.b(new a(this));

    /* renamed from: j  reason: collision with root package name */
    public final g f4393j = h.b(new b(this));

    /* renamed from: k  reason: collision with root package name */
    public InterstitialEvent f4394k;

    /* renamed from: l  reason: collision with root package name */
    public HomePageAdEvent f4395l;

    /* renamed from: m  reason: collision with root package name */
    public z1 f4396m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4397n;

    /* renamed from: o  reason: collision with root package name */
    public CouponFloatView f4398o;

    /* renamed from: p  reason: collision with root package name */
    public Disposable f4399p;

    /* renamed from: q  reason: collision with root package name */
    public final c f4400q = new c(this);

    /* renamed from: r  reason: collision with root package name */
    public Map f4401r = new LinkedHashMap();

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g3 f10964a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g3 g3Var) {
            super(0);
            this.f10964a = g3Var;
        }

        /* renamed from: b */
        public final ChildColumnList invoke() {
            Serializable serializable;
            Bundle arguments = this.f10964a.getArguments();
            if (arguments != null) {
                serializable = arguments.getSerializable("fragment_bound_key");
            } else {
                serializable = null;
            }
            i.e(serializable, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.ChildColumnList");
            return (ChildColumnList) serializable;
        }
    }

    public static final class b extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g3 f10965a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g3 g3Var) {
            super(0);
            this.f10965a = g3Var;
        }

        /* renamed from: b */
        public final r1 invoke() {
            return new r1(this.f10965a.Z2(), this.f10965a.l3());
        }
    }

    public static final class c extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g3 f10966a;

        public c(g3 g3Var) {
            this.f10966a = g3Var;
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            i.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i10, i11);
            this.f10966a.p3();
        }
    }

    public static final void q3(g3 g3Var, View view) {
        i.g(g3Var, "this$0");
        g3Var.a3().b0(g3Var.l3());
        ((KoocanEmptyView) g3Var.h3(R$id.mRecommendLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    public static final void r3(g3 g3Var, View view) {
        i.g(g3Var, "this$0");
        g3Var.a3().b0(g3Var.l3());
        ((KoocanEmptyView) g3Var.h3(R$id.mRecommendLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    public CouponFloatView D0() {
        return this.f4398o;
    }

    @xa.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void InterstitialMessage(InterstitialEvent interstitialEvent) {
        i.g(interstitialEvent, "event");
        if (RootColumnId.recommendHomeId == -1) {
            String code = l3().getCode();
            StringBuilder sb = new StringBuilder();
            i.c cVar = w6.i.f9510g;
            sb.append(cVar.v());
            sb.append("_Recommended");
            if (t9.i.b(code, sb.toString())) {
                String code2 = l3().getCode();
                if (t9.i.b(code2, cVar.v() + "_Recommended")) {
                    xa.c.c().p(interstitialEvent);
                    this.f4394k = interstitialEvent;
                    if (n3().getData().size() > 0) {
                        v3();
                    }
                }
            }
        }
    }

    public Disposable P1() {
        return this.f4399p;
    }

    public void Q1(CouponFloatView couponFloatView) {
        this.f4398o = couponFloatView;
    }

    public void T2() {
        if (n3().getData().size() != 0 || t9.i.b(w6.i.f9510g.H(), "")) {
            n3().notifyDataSetChanged();
            n3().o(true);
            return;
        }
        a3().b0(l3());
    }

    public void U2() {
        super.U2();
        if (Q2()) {
            n3().o(false);
        }
    }

    public void X2() {
        this.f4401r.clear();
    }

    public void Y2() {
        int i10 = R$id.mRefreshLayout;
        ((SwipeRefreshLayout) h3(i10)).setColorSchemeResources(R.color.color_important);
        ((SwipeRefreshLayout) h3(i10)).setOnRefreshListener(this);
        ((SwipeRefreshLayout) h3(i10)).setDistanceToTriggerSync(AutoUtils.getPercentHeightSize(500));
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i11 = R$id.mRecommendRV;
        ((RecyclerView) h3(i11)).setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) h3(i11)).setHasFixedSize(true);
        ((RecyclerView) h3(i11)).setItemViewCacheSize(1);
        n3().bindToRecyclerView((RecyclerView) h3(i11));
        ((RecyclerView) h3(i11)).setOverScrollMode(2);
        ((RecyclerView) h3(i11)).setAdapter(n3());
        ((RecyclerView) h3(i11)).addOnScrollListener(o3());
        n3().Q(getUserVisibleHint());
    }

    public void a() {
        int i10 = R$id.mRecommendLoadingView;
        if (((KoocanEmptyView) h3(i10)) != null && !((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).isRefreshing()) {
            ((KoocanEmptyView) h3(i10)).changeType(KoocanEmptyView.Type.LOADING);
            ((KoocanEmptyView) h3(i10)).setVisibility(0);
        }
    }

    public void b() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) h3(R$id.mRefreshLayout);
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        if (n3().getData().size() != 0) {
            k();
            return;
        }
        int i10 = R$id.mRecommendLoadingView;
        if (((KoocanEmptyView) h3(i10)) != null) {
            ((KoocanEmptyView) h3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) h3(i10)).setVisibility(0);
            ((KoocanEmptyView) h3(i10)).setOnClickListener(new e3(this));
        }
    }

    public void c(String str) {
        t9.i.g(str, "errorCode");
        if (n3().getData().size() != 0) {
            k();
            return;
        }
        int i10 = R$id.mRecommendLoadingView;
        if (((KoocanEmptyView) h3(i10)) != null) {
            ((KoocanEmptyView) h3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) h3(i10)).setVisibility(0);
            ((AutoLinearLayout) ((KoocanEmptyView) h3(i10))._$_findCachedViewById(R$id.koocanEmptyContent)).setOnClickListener(new f3(this));
        }
    }

    public int c3() {
        return R.layout.frag_recommend1;
    }

    public void f(List list) {
        t9.i.g(list, "columnContentList");
        int i10 = R$id.mRecommendRV;
        if (((RecyclerView) h3(i10)) != null) {
            ((RecyclerView) h3(i10)).removeOnScrollListener(this.f4400q);
            ((RecyclerView) h3(i10)).addOnScrollListener(this.f4400q);
            n3().setNewData(r.G(list));
            k();
            u3();
            v3();
            p3();
        }
    }

    public void f1(boolean z10) {
        CouponFloatView D0;
        if (Q2()) {
            n3().R(z10);
        }
        if (!z10 && (D0 = D0()) != null) {
            D0.slideOut(0);
        }
    }

    public View h3(int i10) {
        View findViewById;
        Map map = this.f4401r;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @xa.j
    public final void handlerMoveToFirst(MoveToFirst moveToFirst) {
        t9.i.g(moveToFirst, "event");
        if (isResumed()) {
            ((RecyclerView) h3(R$id.mRecommendRV)).smoothScrollToPosition(0);
        }
    }

    public void k() {
        int i10 = R$id.mRecommendLoadingView;
        if (((KoocanEmptyView) h3(i10)) != null) {
            ((KoocanEmptyView) h3(i10)).setVisibility(8);
        }
        int i11 = R$id.mRefreshLayout;
        if (((SwipeRefreshLayout) h3(i11)) != null && ((SwipeRefreshLayout) h3(i11)).isRefreshing()) {
            ((SwipeRefreshLayout) h3(i11)).setRefreshing(false);
        }
    }

    public void k3(Context context, ViewGroup viewGroup) {
        q.a.a(this, context, viewGroup);
    }

    public final ChildColumnList l3() {
        return (ChildColumnList) this.f4392i.getValue();
    }

    /* renamed from: m3 */
    public z1 a3() {
        z1 z1Var = this.f4396m;
        if (z1Var != null) {
            return z1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final r1 n3() {
        return (r1) this.f4393j.getValue();
    }

    public RecyclerView.t o3() {
        return q.a.b(this);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onBannerAutoPlayEvent(BannerAutoPlayEvent bannerAutoPlayEvent) {
        t9.i.g(bannerAutoPlayEvent, "event");
        if (Q2() && S2()) {
            n3().o(bannerAutoPlayEvent.getAutoPlay());
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onCouponQualificationEvent(CouponQualificationEvent couponQualificationEvent) {
        t9.i.g(couponQualificationEvent, "event");
        if (this.f4397n) {
            if (!couponQualificationEvent.isHasCouponQualification()) {
                s3();
            } else {
                Activity Z2 = Z2();
                View b32 = b3();
                t9.i.e(b32, "null cannot be cast to non-null type android.view.ViewGroup");
                k3(Z2, (ViewGroup) b32);
            }
            CouponFloatView couponFloatView = this.f4398o;
            if (couponFloatView != null) {
                Activity Z22 = Z2();
                t9.i.e(Z22, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
                couponFloatView.setActivity((f5.c) Z22);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t3(new z1(this, this));
        xa.c.c().o(this);
    }

    public void onDestroy() {
        xa.c.c().r(this);
        super.onDestroy();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onLoginEvent(LoginSuccessEvent loginSuccessEvent) {
        t9.i.g(loginSuccessEvent, "event");
        k.f12594a.a();
        String code = l3().getCode();
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.v());
        sb.append("_movies");
        if (!t9.i.b(code, sb.toString())) {
            String code2 = l3().getCode();
            if (t9.i.b(code2, cVar.v() + "_series")) {
                n3().notifyDataSetChanged();
            }
        } else if (!t9.i.b(cVar.e(), "1") || (!t9.i.b(cVar.I(), "1") && !t9.i.b(cVar.I(), "2"))) {
            z1 m32 = a3();
            List data = n3().getData();
            t9.i.f(data, "mRecommendFragAdapter.data");
            m32.c0(data);
            n3().notifyDataSetChanged();
        } else {
            z1 m33 = a3();
            List data2 = n3().getData();
            t9.i.f(data2, "mRecommendFragAdapter.data");
            m33.G(data2);
            n3().notifyDataSetChanged();
        }
    }

    public void onPause() {
        super.onPause();
        k();
    }

    public void onRefresh() {
        a3().b0(l3());
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onRestart(VodPageRestartEvent vodPageRestartEvent) {
        t9.i.g(vodPageRestartEvent, "event");
        if (S2() && n3().getData().size() == 0 && !t9.i.b(w6.i.f9510g.H(), "")) {
            a3().b0(l3());
        }
    }

    public final void p3() {
        int i10 = R$id.mRecommendRV;
        RecyclerView.o layoutManager = ((RecyclerView) h3(i10)).getLayoutManager();
        t9.i.e(layoutManager, "null cannot be cast to non-null type com.mobile.brasiltv.view.LinearLayoutManagerWrapper");
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = (LinearLayoutManagerWrapper) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManagerWrapper.findFirstVisibleItemPosition();
        int childCount = linearLayoutManagerWrapper.getChildCount() + findFirstVisibleItemPosition;
        a3().N(findFirstVisibleItemPosition, childCount);
        if (childCount >= linearLayoutManagerWrapper.getItemCount()) {
            ((RecyclerView) h3(i10)).removeOnScrollListener(this.f4400q);
        }
    }

    public void r(int i10) {
        n3().notifyItemChanged(i10);
    }

    public void s3() {
        q.a.c(this);
    }

    public void setDisposable(Disposable disposable) {
        this.f4399p = disposable;
    }

    public void setUserVisibleHint(boolean z10) {
        CouponFloatView D0;
        super.setUserVisibleHint(z10);
        if (Q2()) {
            n3().Q(getUserVisibleHint());
        }
        if (!z10 && (D0 = D0()) != null) {
            D0.slideOut(0);
        }
    }

    @xa.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void showHomePageAdEvent(HomePageAdEvent homePageAdEvent) {
        t9.i.g(homePageAdEvent, "event");
        if (RootColumnId.recommendHomeId == -1) {
            String code = l3().getCode();
            if (t9.i.b(code, w6.i.f9510g.v() + "_Recommended")) {
                xa.c.c().p(homePageAdEvent);
                this.f4395l = homePageAdEvent;
                if (n3().getData().size() > 0) {
                    u3();
                }
            }
        }
    }

    public void t3(z1 z1Var) {
        t9.i.g(z1Var, "<set-?>");
        this.f4396m = z1Var;
    }

    public final void u3() {
        if (this.f4395l != null && getContext() != null) {
            m mVar = m.f9270a;
            Context context = getContext();
            t9.i.d(context);
            String i10 = a6.a.f10646a.i();
            i.c cVar = w6.i.f9510g;
            AdInfo J = m.J(mVar, context, i10, cVar.I(), (String) null, false, cVar.r(), 24, (Object) null);
            if (J != null) {
                Context context2 = getContext();
                t9.i.d(context2);
                b0.S(new HomeImportantAdDialog(context2, J), "ad");
                this.f4395l = null;
            }
        }
    }

    public final void v3() {
        if (this.f4394k != null && getContext() != null) {
            m mVar = m.f9270a;
            Context context = getContext();
            t9.i.d(context);
            String d10 = a6.a.f10646a.d();
            i.c cVar = w6.i.f9510g;
            AdInfo J = m.J(mVar, context, d10, cVar.I(), (String) null, false, cVar.r(), 24, (Object) null);
            if (J != null) {
                Context context2 = getContext();
                t9.i.d(context2);
                b0.S(new InterstitialDialog(context2, J), "ad");
                this.f4394k = null;
            }
        }
    }
}
