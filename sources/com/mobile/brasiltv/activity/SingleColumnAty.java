package com.mobile.brasiltv.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.t4;
import f5.u4;
import f5.v4;
import f5.w4;
import g5.w;
import h9.h;
import i6.w0;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.b4;
import mobile.com.requestframe.utils.response.HomeRecommend;
import mobile.com.requestframe.utils.response.ShelveAsset;
import t9.g;
import t9.i;
import t9.j;

public final class SingleColumnAty extends f5.d implements w0, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: t  reason: collision with root package name */
    public static final a f12179t = new a((g) null);

    /* renamed from: u  reason: collision with root package name */
    public static final String f12180u = "home_recommend";

    /* renamed from: l  reason: collision with root package name */
    public int f12181l = 21;

    /* renamed from: m  reason: collision with root package name */
    public int f12182m = 1;

    /* renamed from: n  reason: collision with root package name */
    public int f12183n;

    /* renamed from: o  reason: collision with root package name */
    public final h9.g f12184o = h.b(new c(this));

    /* renamed from: p  reason: collision with root package name */
    public final h9.g f12185p = h.b(new d(this));

    /* renamed from: q  reason: collision with root package name */
    public b4 f12186q;

    /* renamed from: r  reason: collision with root package name */
    public final h9.g f12187r = h.b(new b(this));

    /* renamed from: s  reason: collision with root package name */
    public Map f12188s = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return SingleColumnAty.f12180u;
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SingleColumnAty f12189a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SingleColumnAty singleColumnAty) {
            super(0);
            this.f12189a = singleColumnAty;
        }

        public final Integer invoke() {
            return Integer.valueOf(n5.a.f8310a.a(this.f12189a));
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SingleColumnAty f12190a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SingleColumnAty singleColumnAty) {
            super(0);
            this.f12190a = singleColumnAty;
        }

        /* renamed from: b */
        public final HomeRecommend invoke() {
            Serializable serializableExtra = this.f12190a.getIntent().getSerializableExtra(SingleColumnAty.f12179t.a());
            i.e(serializableExtra, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.HomeRecommend");
            return (HomeRecommend) serializableExtra;
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SingleColumnAty f12191a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SingleColumnAty singleColumnAty) {
            super(0);
            this.f12191a = singleColumnAty;
        }

        /* renamed from: b */
        public final w invoke() {
            return new w(this.f12191a);
        }
    }

    public static final class e implements KoocanEmptyView.ReloadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SingleColumnAty f12192a;

        public e(SingleColumnAty singleColumnAty) {
            this.f12192a = singleColumnAty;
        }

        public void onClick() {
            Integer columnId = this.f12192a.e3().getColumnId();
            if (columnId != null) {
                SingleColumnAty singleColumnAty = this.f12192a;
                singleColumnAty.S2().m(columnId.intValue(), singleColumnAty.f12181l, singleColumnAty.f12182m);
            }
        }
    }

    public static final void i3(SingleColumnAty singleColumnAty, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(singleColumnAty, "this$0");
        a7.d dVar = a7.d.f10697a;
        String o10 = dVar.o(((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        Integer columnId = singleColumnAty.e3().getColumnId();
        if (columnId != null) {
            int intValue = columnId.intValue();
            String alias = singleColumnAty.e3().getAlias();
            if (alias != null) {
                b0.r(singleColumnAty, ((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getType(), ((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getProgramType(), ((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getContentId(), EnterType.CATEGORY, ((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getName(), false, ColumnListAty.f11982t.b(), intValue, alias, str);
            }
        }
    }

    public static final void l3(SingleColumnAty singleColumnAty, View view) {
        i.g(singleColumnAty, "this$0");
        singleColumnAty.finish();
    }

    public static final void m3(SingleColumnAty singleColumnAty, View view) {
        i.g(singleColumnAty, "this$0");
        int i10 = R$id.mRvContent;
        if (((RecyclerView) singleColumnAty.Y2(i10)).getAdapter() != null) {
            RecyclerView.g adapter = ((RecyclerView) singleColumnAty.Y2(i10)).getAdapter();
            i.d(adapter);
            if (adapter.getItemCount() != 0) {
                ((RecyclerView) singleColumnAty.Y2(i10)).smoothScrollToPosition(0);
            }
        }
    }

    public static final void n3(SingleColumnAty singleColumnAty, View view) {
        i.g(singleColumnAty, "this$0");
        b0.c0(singleColumnAty, SearchAty.class);
    }

    public void R2() {
        o3(new b4(this, this));
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) Y2(R$id.mRlTop)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, d3(), 0, 0);
        ((TextView) Y2(R$id.mTvTitle)).setText(b0.e(e3().getAlias(), e3().getName()));
        h3();
        k3();
        j3();
    }

    public int T2() {
        return R.layout.aty_single_column;
    }

    public View Y2(int i10) {
        Map map = this.f12188s;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public void a() {
        ((KoocanEmptyView) Y2(R$id.column_loadingView)).setVisibility(0);
    }

    public void b() {
        f3().loadMoreEnd();
        if (f3().getData().size() == 0) {
            int i10 = R$id.column_loadingView;
            ((KoocanEmptyView) Y2(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) Y2(i10)).setVisibility(0);
        }
    }

    public final int d3() {
        return ((Number) this.f12187r.getValue()).intValue();
    }

    public final HomeRecommend e3() {
        return (HomeRecommend) this.f12184o.getValue();
    }

    public final w f3() {
        return (w) this.f12185p.getValue();
    }

    public void g(List list, int i10) {
        i.g(list, "data");
        if (i10 == 0) {
            ((KoocanEmptyView) Y2(R$id.column_loadingView)).setVisibility(8);
            f3().addData(list);
            f3().setEnableLoadMore(true);
        } else if (i10 == 2) {
            if (list.size() < this.f12181l) {
                f3().loadMoreEnd();
            } else {
                f3().loadMoreComplete();
            }
            f3().addData(list);
        }
        if (f3().getData().size() == 0) {
            f3().setEmptyView((View) new KoocanEmptyView(Q1(), KoocanEmptyView.Type.NO_CONTENT));
        }
        this.f12183n = list.size();
        f3().notifyDataSetChanged();
    }

    /* renamed from: g3 */
    public b4 S2() {
        b4 b4Var = this.f12186q;
        if (b4Var != null) {
            return b4Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void h3() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        int i10 = R$id.mRvContent;
        ((RecyclerView) Y2(i10)).setLayoutManager(gridLayoutManager);
        f3().setOnLoadMoreListener(this, (RecyclerView) Y2(i10));
        f3().setLoadMoreView(new RecyclerLoadMoreView());
        f3().disableLoadMoreIfNotFullPage();
        ((RecyclerView) Y2(i10)).setAdapter(f3());
        f3().setOnItemClickListener(new t4(this));
    }

    public final void j3() {
        Integer columnId = e3().getColumnId();
        if (columnId != null) {
            S2().m(columnId.intValue(), this.f12181l, this.f12182m);
        }
    }

    public void k2() {
        n2();
    }

    public final void k3() {
        ((ImageView) Y2(R$id.mIvBack)).setOnClickListener(new u4(this));
        ((AutoRelativeLayout) Y2(R$id.mRlTop)).setOnClickListener(new v4(this));
        ((ImageView) Y2(R$id.mIvSearch)).setOnClickListener(new w4(this));
    }

    public void o3(b4 b4Var) {
        i.g(b4Var, "<set-?>");
        this.f12186q = b4Var;
    }

    public void onLoadMoreRequested() {
        this.f12182m++;
        int size = f3().getData().size();
        int i10 = this.f12181l;
        if (size < i10) {
            f3().loadMoreEnd(false);
        } else if (this.f12183n < i10) {
            f3().loadMoreEnd(false);
        } else {
            Integer columnId = e3().getColumnId();
            if (columnId != null) {
                S2().l(columnId.intValue(), this.f12181l, this.f12182m);
            }
        }
    }

    public void p(String str, int i10) {
        i.g(str, "errorCode");
        int i11 = R$id.column_loadingView;
        ((KoocanEmptyView) Y2(i11)).setVisibility(8);
        j1.h(this, str);
        if (i10 == 0) {
            ((KoocanEmptyView) Y2(i11)).setReloadListener(new e(this));
            ((KoocanEmptyView) Y2(i11)).setVisibility(0);
            ((KoocanEmptyView) Y2(i11)).changeType(KoocanEmptyView.Type.NO_WIFI);
        } else if (i10 == 2) {
            this.f12182m--;
            f3().loadMoreFail();
        }
    }
}
