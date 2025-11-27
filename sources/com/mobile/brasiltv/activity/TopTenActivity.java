package com.mobile.brasiltv.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.t;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ColumnListAty;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.a6;
import f5.b6;
import f5.y5;
import f5.z5;
import g5.n2;
import h9.h;
import i6.a1;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.o4;
import mobile.com.requestframe.utils.response.ShelveAsset;
import t9.i;
import t9.j;

public final class TopTenActivity extends f5.d implements a1, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: v  reason: collision with root package name */
    public static final a f12233v = new a((t9.g) null);

    /* renamed from: w  reason: collision with root package name */
    public static final String f12234w = "recommend_name";

    /* renamed from: x  reason: collision with root package name */
    public static final String f12235x = "recommend_alias";

    /* renamed from: y  reason: collision with root package name */
    public static final String f12236y = "recommend_columnId";

    /* renamed from: l  reason: collision with root package name */
    public int f12237l = 21;

    /* renamed from: m  reason: collision with root package name */
    public int f12238m = 1;

    /* renamed from: n  reason: collision with root package name */
    public int f12239n;

    /* renamed from: o  reason: collision with root package name */
    public final h9.g f12240o = h.b(new g(this));

    /* renamed from: p  reason: collision with root package name */
    public final h9.g f12241p = h.b(new e(this));

    /* renamed from: q  reason: collision with root package name */
    public final h9.g f12242q = h.b(new f(this));

    /* renamed from: r  reason: collision with root package name */
    public final h9.g f12243r = h.b(new c(this));

    /* renamed from: s  reason: collision with root package name */
    public o4 f12244s;

    /* renamed from: t  reason: collision with root package name */
    public final h9.g f12245t = h.b(new b(this));

    /* renamed from: u  reason: collision with root package name */
    public Map f12246u = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return TopTenActivity.f12235x;
        }

        public final String b() {
            return TopTenActivity.f12236y;
        }

        public final String c() {
            return TopTenActivity.f12234w;
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopTenActivity f12247a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TopTenActivity topTenActivity) {
            super(0);
            this.f12247a = topTenActivity;
        }

        public final Integer invoke() {
            return Integer.valueOf(n5.a.f8310a.a(this.f12247a));
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopTenActivity f12248a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(TopTenActivity topTenActivity) {
            super(0);
            this.f12248a = topTenActivity;
        }

        /* renamed from: b */
        public final n2 invoke() {
            return new n2(this.f12248a);
        }
    }

    public static final class d implements KoocanEmptyView.ReloadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopTenActivity f12249a;

        public d(TopTenActivity topTenActivity) {
            this.f12249a = topTenActivity;
        }

        public void onClick() {
            this.f12249a.S2().l(this.f12249a.j3(), this.f12249a.f12237l, this.f12249a.f12238m);
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopTenActivity f12250a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(TopTenActivity topTenActivity) {
            super(0);
            this.f12250a = topTenActivity;
        }

        public final String invoke() {
            String stringExtra = this.f12250a.getIntent().getStringExtra(TopTenActivity.f12233v.a());
            return stringExtra == null ? "" : stringExtra;
        }
    }

    public static final class f extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopTenActivity f12251a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(TopTenActivity topTenActivity) {
            super(0);
            this.f12251a = topTenActivity;
        }

        public final Integer invoke() {
            return Integer.valueOf(this.f12251a.getIntent().getIntExtra(TopTenActivity.f12233v.b(), 0));
        }
    }

    public static final class g extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopTenActivity f12252a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(TopTenActivity topTenActivity) {
            super(0);
            this.f12252a = topTenActivity;
        }

        public final String invoke() {
            String stringExtra = this.f12252a.getIntent().getStringExtra(TopTenActivity.f12233v.c());
            return stringExtra == null ? "" : stringExtra;
        }
    }

    public static final void m3(TopTenActivity topTenActivity, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(topTenActivity, "this$0");
        a7.d dVar = a7.d.f10697a;
        String o10 = dVar.o(((ShelveAsset) topTenActivity.g3().getData().get(i10)).getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        String type = ((ShelveAsset) topTenActivity.g3().getData().get(i10)).getType();
        String programType = ((ShelveAsset) topTenActivity.g3().getData().get(i10)).getProgramType();
        String contentId = ((ShelveAsset) topTenActivity.g3().getData().get(i10)).getContentId();
        EnterType enterType = EnterType.CATEGORY;
        String c10 = b0.c(t.W(((ShelveAsset) topTenActivity.g3().getData().get(i10)).getAlias()).toString(), t.W(((ShelveAsset) topTenActivity.g3().getData().get(i10)).getName()).toString());
        ColumnListAty.a aVar = ColumnListAty.f11982t;
        b0.r(topTenActivity, type, programType, contentId, enterType, c10, aVar.e(), aVar.b(), topTenActivity.j3(), topTenActivity.i3(), str);
    }

    public static final void p3(TopTenActivity topTenActivity, View view) {
        i.g(topTenActivity, "this$0");
        topTenActivity.finish();
    }

    public static final void q3(TopTenActivity topTenActivity, View view) {
        i.g(topTenActivity, "this$0");
        int i10 = R$id.mRvContent;
        if (((RecyclerView) topTenActivity.Y2(i10)).getAdapter() != null) {
            RecyclerView.g adapter = ((RecyclerView) topTenActivity.Y2(i10)).getAdapter();
            i.d(adapter);
            if (adapter.getItemCount() != 0) {
                ((RecyclerView) topTenActivity.Y2(i10)).smoothScrollToPosition(0);
            }
        }
    }

    public static final void r3(TopTenActivity topTenActivity, View view) {
        i.g(topTenActivity, "this$0");
        b0.c0(topTenActivity, SearchAty.class);
    }

    public void R2() {
        s3(new o4(this, this));
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) Y2(R$id.mRlTop)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, f3(), 0, 0);
        ((TextView) Y2(R$id.mTvTitle)).setText(b0.e(i3(), k3()));
        l3();
        o3();
        n3();
    }

    public int T2() {
        return R.layout.aty_single_column;
    }

    public View Y2(int i10) {
        Map map = this.f12246u;
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
        g3().loadMoreEnd();
        if (g3().getData().size() == 0) {
            int i10 = R$id.column_loadingView;
            ((KoocanEmptyView) Y2(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) Y2(i10)).setVisibility(0);
        }
    }

    public final int f3() {
        return ((Number) this.f12245t.getValue()).intValue();
    }

    public void g(List list, int i10) {
        i.g(list, "data");
        if (i10 == 0) {
            ((KoocanEmptyView) Y2(R$id.column_loadingView)).setVisibility(8);
            g3().addData(list);
            g3().setEnableLoadMore(true);
        } else if (i10 == 2) {
            if (list.size() < this.f12237l) {
                g3().loadMoreEnd();
            } else {
                g3().loadMoreComplete();
            }
            g3().addData(list);
        }
        if (g3().getData().size() == 0) {
            g3().setEmptyView((View) new KoocanEmptyView(Q1(), KoocanEmptyView.Type.NO_CONTENT));
        }
        this.f12239n = list.size();
        g3().notifyDataSetChanged();
    }

    public final n2 g3() {
        return (n2) this.f12243r.getValue();
    }

    /* renamed from: h3 */
    public o4 S2() {
        o4 o4Var = this.f12244s;
        if (o4Var != null) {
            return o4Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final String i3() {
        return (String) this.f12241p.getValue();
    }

    public final int j3() {
        return ((Number) this.f12242q.getValue()).intValue();
    }

    public void k2() {
        n2();
    }

    public final String k3() {
        return (String) this.f12240o.getValue();
    }

    public final void l3() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        int i10 = R$id.mRvContent;
        ((RecyclerView) Y2(i10)).setLayoutManager(gridLayoutManager);
        g3().setOnLoadMoreListener(this, (RecyclerView) Y2(i10));
        g3().setLoadMoreView(new RecyclerLoadMoreView());
        g3().disableLoadMoreIfNotFullPage();
        ((RecyclerView) Y2(i10)).setAdapter(g3());
        g3().setOnItemClickListener(new y5(this));
    }

    public final void n3() {
        S2().l(j3(), this.f12237l, this.f12238m);
    }

    public final void o3() {
        ((ImageView) Y2(R$id.mIvBack)).setOnClickListener(new z5(this));
        ((AutoRelativeLayout) Y2(R$id.mRlTop)).setOnClickListener(new a6(this));
        ((ImageView) Y2(R$id.mIvSearch)).setOnClickListener(new b6(this));
    }

    public void onLoadMoreRequested() {
        this.f12238m++;
        int size = g3().getData().size();
        int i10 = this.f12237l;
        if (size < i10) {
            g3().loadMoreEnd(false);
        } else if (this.f12239n < i10) {
            g3().loadMoreEnd(false);
        } else {
            S2().k(j3(), this.f12237l, this.f12238m);
        }
    }

    public void p(String str, int i10) {
        i.g(str, "errorCode");
        int i11 = R$id.column_loadingView;
        ((KoocanEmptyView) Y2(i11)).setVisibility(8);
        j1.h(this, str);
        if (i10 == 0) {
            ((KoocanEmptyView) Y2(i11)).setReloadListener(new d(this));
            ((KoocanEmptyView) Y2(i11)).setVisibility(0);
            ((KoocanEmptyView) Y2(i11)).changeType(KoocanEmptyView.Type.NO_WIFI);
        } else if (i10 == 2) {
            this.f12238m--;
            g3().loadMoreFail();
        }
    }

    public void s3(o4 o4Var) {
        i.g(o4Var, "<set-?>");
        this.f12244s = o4Var;
    }
}
