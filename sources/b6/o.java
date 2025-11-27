package b6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ba.t;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ColumnListAty;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.mobile.brasiltv.view.adView.AdaptiveAdContainer;
import com.mobile.brasiltv.view.adView.AdaptiveAdView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import g5.f3;
import g5.w;
import i6.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.l;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;
import t9.j;
import w6.i;

public final class o extends e<l> implements m, SwipeRefreshLayout.j, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: v  reason: collision with root package name */
    public static final a f11031v = new a((t9.g) null);

    /* renamed from: i  reason: collision with root package name */
    public int f11032i;

    /* renamed from: j  reason: collision with root package name */
    public final h9.g f11033j = h9.h.b(new f(this));

    /* renamed from: k  reason: collision with root package name */
    public final h9.g f11034k = h9.h.b(new e(this));

    /* renamed from: l  reason: collision with root package name */
    public final h9.g f11035l = h9.h.b(new b(this));

    /* renamed from: m  reason: collision with root package name */
    public final h9.g f11036m = h9.h.b(new i(this));

    /* renamed from: n  reason: collision with root package name */
    public final h9.g f11037n = h9.h.b(new c(this));

    /* renamed from: o  reason: collision with root package name */
    public l f11038o;

    /* renamed from: p  reason: collision with root package name */
    public final h9.g f11039p = h9.h.b(new g(this));

    /* renamed from: q  reason: collision with root package name */
    public int f11040q = 21;

    /* renamed from: r  reason: collision with root package name */
    public int f11041r = 1;

    /* renamed from: s  reason: collision with root package name */
    public boolean f11042s;

    /* renamed from: t  reason: collision with root package name */
    public int f11043t;

    /* renamed from: u  reason: collision with root package name */
    public Map f11044u = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f11045a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(o oVar) {
            super(0);
            this.f11045a = oVar;
        }

        public final Integer invoke() {
            Bundle arguments = this.f11045a.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("columnId") : 0);
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f11046a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(o oVar) {
            super(0);
            this.f11046a = oVar;
        }

        /* renamed from: b */
        public final Boolean invoke() {
            boolean z10;
            Bundle arguments = this.f11046a.getArguments();
            if (arguments != null) {
                z10 = arguments.getBoolean("iscr");
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class d implements AdaptiveAdView.AdaptiveAdCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f11047a;

        public d(o oVar) {
            this.f11047a = oVar;
        }

        public void onAdFailedToLoad() {
            ((TextView) this.f11047a.h3(R$id.mTvNoAd)).setVisibility(8);
        }

        public void onAdLoaded() {
            ((TextView) this.f11047a.h3(R$id.mTvNoAd)).setVisibility(0);
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f11048a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(o oVar) {
            super(0);
            this.f11048a = oVar;
        }

        /* renamed from: b */
        public final Boolean invoke() {
            boolean z10;
            Bundle arguments = this.f11048a.getArguments();
            if (arguments != null) {
                z10 = arguments.getBoolean("COLUMN_FREE");
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class f extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f11049a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(o oVar) {
            super(0);
            this.f11049a = oVar;
        }

        public final Integer invoke() {
            Bundle arguments = this.f11049a.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("COLUMN_INDEX") : 0);
        }
    }

    public static final class g extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f11050a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(o oVar) {
            super(0);
            this.f11050a = oVar;
        }

        /* renamed from: b */
        public final w invoke() {
            return new w(this.f11050a.Z2());
        }
    }

    public static final class h implements KoocanEmptyView.ReloadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f11051a;

        public h(o oVar) {
            this.f11051a = oVar;
        }

        public void onClick() {
            this.f11051a.a3().m(this.f11051a.i3(), this.f11051a.o3(), this.f11051a.n3());
        }
    }

    public static final class i extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f11052a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(o oVar) {
            super(0);
            this.f11052a = oVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r0.getString("tdc_from");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String invoke() {
            /*
                r2 = this;
                b6.o r0 = r2.f11052a
                android.os.Bundle r0 = r0.getArguments()
                if (r0 == 0) goto L_0x0010
                java.lang.String r1 = "tdc_from"
                java.lang.String r0 = r0.getString(r1)
                if (r0 != 0) goto L_0x0012
            L_0x0010:
                java.lang.String r0 = ""
            L_0x0012:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b6.o.i.invoke():java.lang.String");
        }
    }

    public static final void q3(o oVar, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        List<ShelvePoster> list;
        t9.i.g(oVar, "this$0");
        a7.d dVar = a7.d.f10697a;
        ShelveAsset shelveAsset = (ShelveAsset) oVar.l3().getData().get(i10);
        if (shelveAsset != null) {
            list = shelveAsset.getPosterList();
        } else {
            list = null;
        }
        String o10 = dVar.o(list, dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        Activity Z2 = oVar.Z2();
        t9.i.e(Z2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.r((f5.c) Z2, ((ShelveAsset) oVar.l3().getData().get(i10)).getType(), ((ShelveAsset) oVar.l3().getData().get(i10)).getProgramType(), ((ShelveAsset) oVar.l3().getData().get(i10)).getContentId(), EnterType.CATEGORY, b0.c(t.W(((ShelveAsset) oVar.l3().getData().get(i10)).getAlias()).toString(), t.W(((ShelveAsset) oVar.l3().getData().get(i10)).getName()).toString()), oVar.r3(), ColumnListAty.f11982t.b(), oVar.i3(), oVar.Z0(), str);
    }

    public static final void t3(o oVar, View view) {
        boolean z10;
        Context context;
        t9.i.g(oVar, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("beVipUrl:");
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.g());
        b0.U(oVar, sb.toString());
        if (cVar.g().length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && (context = oVar.getContext()) != null) {
            b0.j0(context, cVar.g(), false, true, false, false, 24, (Object) null);
        }
    }

    public void T2() {
        if (l3().getData().size() == 0) {
            a3().m(i3(), this.f11040q, this.f11041r);
        }
    }

    public void U2() {
        super.U2();
        if (Q2()) {
            int i10 = R$id.mRefreshLayout;
            if (((SwipeRefreshLayout) h3(i10)) != null && ((SwipeRefreshLayout) h3(i10)).isRefreshing()) {
                ((SwipeRefreshLayout) h3(i10)).setRefreshing(false);
                this.f11042s = false;
            }
        }
        if (Q2() && l3().isLoading()) {
            l3().loadMoreComplete();
        }
    }

    public void X2() {
        this.f11044u.clear();
    }

    public void Y2() {
        int i10 = R$id.mRefreshLayout;
        ((SwipeRefreshLayout) h3(i10)).setColorSchemeResources(R.color.color_important);
        ((SwipeRefreshLayout) h3(i10)).setOnRefreshListener(this);
        ((SwipeRefreshLayout) h3(i10)).setDistanceToTriggerSync(AutoUtils.getPercentHeightSize(500));
        p3();
        s3();
    }

    public final String Z0() {
        return (String) this.f11036m.getValue();
    }

    public void a() {
        int i10 = R$id.frag_column_loadingView;
        if (((KoocanEmptyView) h3(i10)) != null) {
            if (l3().getData().size() == 0) {
                ((KoocanEmptyView) h3(i10)).setVisibility(0);
                l3().setEnableLoadMore(false);
                return;
            }
            ((KoocanEmptyView) h3(i10)).setVisibility(8);
        }
    }

    public void b() {
        l3().loadMoreEnd();
        ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setEnabled(true);
        if (l3().getData().size() == 0) {
            int i10 = R$id.frag_column_loadingView;
            ((KoocanEmptyView) h3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) h3(i10)).setVisibility(0);
        }
    }

    public int c3() {
        return R.layout.frag_column_list;
    }

    public void g(List list, int i10) {
        t9.i.g(list, "data");
        if (i10 == 0) {
            ((KoocanEmptyView) h3(R$id.frag_column_loadingView)).setVisibility(8);
            l3().addData(list);
            l3().setEnableLoadMore(true);
        } else if (i10 == 1) {
            l3().getData().clear();
            l3().setNewData(list);
            ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setRefreshing(false);
            l3().setEnableLoadMore(true);
        } else if (i10 == 2) {
            if (list.size() < this.f11040q) {
                l3().loadMoreEnd();
            } else {
                l3().loadMoreComplete();
            }
            l3().addData(list);
            ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setEnabled(true);
        }
        if (l3().getData().size() == 0) {
            l3().setEmptyView((View) new KoocanEmptyView(getContext(), KoocanEmptyView.Type.NO_CONTENT));
        }
        this.f11043t = list.size();
        l3().notifyDataSetChanged();
    }

    public View h3(int i10) {
        View findViewById;
        Map map = this.f11044u;
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

    public int i3() {
        return ((Number) this.f11035l.getValue()).intValue();
    }

    public final boolean j3() {
        return ((Boolean) this.f11034k.getValue()).booleanValue();
    }

    public final int k3() {
        return ((Number) this.f11033j.getValue()).intValue();
    }

    public final w l3() {
        return (w) this.f11039p.getValue();
    }

    /* renamed from: m3 */
    public l a3() {
        l lVar = this.f11038o;
        if (lVar != null) {
            return lVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final int n3() {
        return this.f11041r;
    }

    public final int o3() {
        return this.f11040q;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v3(new l(this, this));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void onLoadMoreRequested() {
        this.f11042s = false;
        this.f11041r++;
        int i10 = R$id.mRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) h3(i10);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(false);
        }
        int size = l3().getData().size();
        int i11 = this.f11040q;
        if (size < i11) {
            l3().loadMoreEnd(false);
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) h3(i10);
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setEnabled(true);
            }
        } else if (this.f11043t < i11) {
            SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) h3(i10);
            if (swipeRefreshLayout3 != null) {
                swipeRefreshLayout3.setEnabled(true);
            }
            l3().loadMoreEnd(false);
        } else {
            a3().l(i3(), this.f11040q, this.f11041r);
        }
    }

    public void onRefresh() {
        this.f11041r = 1;
        l3().setEnableLoadMore(false);
        this.f11042s = true;
        a3().n(i3(), this.f11040q, this.f11041r);
    }

    public void onViewCreated(View view, Bundle bundle) {
        AdaptiveAdContainer adaptiveAdContainer;
        t9.i.g(view, "view");
        super.onViewCreated(view, bundle);
        if (Q2() && getUserVisibleHint() && (adaptiveAdContainer = (AdaptiveAdContainer) h3(R$id.mAavContainer)) != null) {
            adaptiveAdContainer.hostVisibilityChange(true, true);
        }
    }

    public void p(String str, int i10) {
        t9.i.g(str, "errorCode");
        int i11 = R$id.frag_column_loadingView;
        ((KoocanEmptyView) h3(i11)).setVisibility(8);
        j1.h(Z2(), str);
        if (i10 == 0) {
            ((KoocanEmptyView) h3(i11)).setReloadListener(new h(this));
            ((KoocanEmptyView) h3(i11)).setVisibility(0);
            ((KoocanEmptyView) h3(i11)).changeType(KoocanEmptyView.Type.NO_WIFI);
        } else if (i10 == 1) {
            ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setRefreshing(false);
            l3().setEnableLoadMore(true);
        } else if (i10 == 2) {
            this.f11041r--;
            ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setEnabled(true);
            l3().loadMoreFail();
        }
    }

    public final void p3() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Z2(), 3);
        int i10 = R$id.columnListRv;
        ((RecyclerView) h3(i10)).setLayoutManager(gridLayoutManager);
        l3().setOnLoadMoreListener(this, (RecyclerView) h3(i10));
        l3().setLoadMoreView(new RecyclerLoadMoreView());
        l3().disableLoadMoreIfNotFullPage();
        ((RecyclerView) h3(i10)).setAdapter(l3());
        this.f11032i = l3().getData().size();
        l3().setOnItemClickListener(new m(this));
    }

    public final boolean r3() {
        return ((Boolean) this.f11037n.getValue()).booleanValue();
    }

    public final void s3() {
        f3 f3Var;
        if (j3()) {
            if (k3() == 0) {
                Context context = getContext();
                t9.i.d(context);
                String string = context.getString(R.string.free_movie_list_ad_id);
                t9.i.f(string, "context!!.getString(R.st…ng.free_movie_list_ad_id)");
                f3Var = new f3(string, a6.a.f10646a.f(), true);
            } else {
                f3Var = null;
            }
            if (f3Var != null) {
                int i10 = R$id.mAavContainer;
                AdaptiveAdContainer adaptiveAdContainer = (AdaptiveAdContainer) h3(i10);
                t9.i.f(adaptiveAdContainer, "mAavContainer");
                AdaptiveAdContainer.loadAd$default(adaptiveAdContainer, f3Var, false, 2, (Object) null);
                ((AdaptiveAdContainer) h3(i10)).setAdaptiveAdCallback(new d(this));
                ((TextView) h3(R$id.mTvNoAd)).setOnClickListener(new n(this));
            }
        }
    }

    public void setUserVisibleHint(boolean z10) {
        AdaptiveAdContainer adaptiveAdContainer;
        super.setUserVisibleHint(z10);
        if (j3() && Q2() && (adaptiveAdContainer = (AdaptiveAdContainer) h3(R$id.mAavContainer)) != null) {
            adaptiveAdContainer.hostVisibilityChange(getUserVisibleHint(), true);
        }
    }

    public final void u3() {
        int i10 = R$id.columnListRv;
        if (((RecyclerView) h3(i10)) != null && ((RecyclerView) h3(i10)).getAdapter() != null) {
            RecyclerView.g adapter = ((RecyclerView) h3(i10)).getAdapter();
            t9.i.d(adapter);
            if (adapter.getItemCount() != 0) {
                ((RecyclerView) h3(i10)).smoothScrollToPosition(0);
            }
        }
    }

    public void v3(l lVar) {
        t9.i.g(lVar, "<set-?>");
        this.f11038o = lVar;
    }
}
