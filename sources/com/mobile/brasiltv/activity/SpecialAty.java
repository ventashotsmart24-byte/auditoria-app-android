package com.mobile.brasiltv.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.a5;
import f5.b5;
import f5.d;
import f5.x4;
import f5.y4;
import f5.z4;
import g5.i3;
import h9.h;
import j6.l;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.j2;
import mobile.com.requestframe.utils.response.ChildColumnList;
import t9.g;
import t9.i;
import t9.j;

public final class SpecialAty extends d implements l, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: q  reason: collision with root package name */
    public static final a f12193q = new a((g) null);

    /* renamed from: r  reason: collision with root package name */
    public static final String f12194r = "position";

    /* renamed from: l  reason: collision with root package name */
    public int f12195l = -1;

    /* renamed from: m  reason: collision with root package name */
    public final h9.g f12196m = h.b(new c(this));

    /* renamed from: n  reason: collision with root package name */
    public j2 f12197n;

    /* renamed from: o  reason: collision with root package name */
    public final h9.g f12198o = h.b(new b(this));

    /* renamed from: p  reason: collision with root package name */
    public Map f12199p = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return SpecialAty.f12194r;
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialAty f12200a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SpecialAty specialAty) {
            super(0);
            this.f12200a = specialAty;
        }

        public final Integer invoke() {
            return Integer.valueOf(n5.a.f8310a.a(this.f12200a));
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialAty f12201a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SpecialAty specialAty) {
            super(0);
            this.f12201a = specialAty;
        }

        /* renamed from: b */
        public final i3 invoke() {
            return new i3(this.f12201a);
        }
    }

    public static final void i3(SpecialAty specialAty, View view) {
        i.g(specialAty, "this$0");
        specialAty.finish();
    }

    public static final void j3(SpecialAty specialAty, View view) {
        i.g(specialAty, "this$0");
        int i10 = R$id.mRVSpecial;
        if (((RecyclerView) specialAty.Z2(i10)).getAdapter() != null) {
            RecyclerView.g adapter = ((RecyclerView) specialAty.Z2(i10)).getAdapter();
            i.d(adapter);
            if (adapter.getItemCount() != 0) {
                ((RecyclerView) specialAty.Z2(i10)).smoothScrollToPosition(0);
            }
        }
    }

    public static final void k3(SpecialAty specialAty, View view) {
        i.g(specialAty, "this$0");
        b0.c0(specialAty, SearchAty.class);
    }

    public static final void l3(SpecialAty specialAty, View view) {
        i.g(specialAty, "this$0");
        j2 c32 = specialAty.S2();
        ChildColumnList childColumnList = RootColumnId.specialColumn;
        i.f(childColumnList, "specialColumn");
        c32.J(childColumnList);
        ((KoocanEmptyView) specialAty.Z2(R$id.mLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    public static final void m3(SpecialAty specialAty, View view) {
        i.g(specialAty, "this$0");
        j2 c32 = specialAty.S2();
        ChildColumnList childColumnList = RootColumnId.specialColumn;
        i.f(childColumnList, "specialColumn");
        c32.J(childColumnList);
        ((KoocanEmptyView) specialAty.Z2(R$id.mLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    public void R2() {
        n3(new j2(this, this));
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) Z2(R$id.mRlTop)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, b3(), 0, 0);
        ((TextView) Z2(R$id.mTvTitle)).setText(b0.e(RootColumnId.specialColumn.getAlias(), RootColumnId.specialColumn.getName()));
        this.f12195l = getIntent().getIntExtra(f12194r, -1);
        f3();
        h3();
        g3();
    }

    public int T2() {
        return R.layout.aty_special;
    }

    public View Z2(int i10) {
        Map map = this.f12199p;
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
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) Z2(i10)) != null) {
            ((KoocanEmptyView) Z2(i10)).changeType(KoocanEmptyView.Type.LOADING);
            ((KoocanEmptyView) Z2(i10)).setVisibility(0);
        }
    }

    public void b() {
        if (d3().getData().size() != 0) {
            e3();
            return;
        }
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) Z2(i10)) != null) {
            ((KoocanEmptyView) Z2(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) Z2(i10)).setVisibility(0);
            ((KoocanEmptyView) Z2(i10)).setOnClickListener(new b5(this));
        }
    }

    public final int b3() {
        return ((Number) this.f12198o.getValue()).intValue();
    }

    public void c(String str) {
        i.g(str, "errorCode");
        if (d3().getData().size() != 0) {
            e3();
            return;
        }
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) Z2(i10)) != null) {
            ((KoocanEmptyView) Z2(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) Z2(i10)).setVisibility(0);
            ((AutoLinearLayout) ((KoocanEmptyView) Z2(i10))._$_findCachedViewById(R$id.koocanEmptyContent)).setOnClickListener(new a5(this));
        }
    }

    /* renamed from: c3 */
    public j2 S2() {
        j2 j2Var = this.f12197n;
        if (j2Var != null) {
            return j2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final i3 d3() {
        return (i3) this.f12196m.getValue();
    }

    public void e3() {
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) Z2(i10)) != null) {
            ((KoocanEmptyView) Z2(i10)).setVisibility(8);
        }
    }

    public void f(List list) {
        i.g(list, "list");
        d3().setNewData(list);
        e3();
        if (this.f12195l != -1) {
            ((RecyclerView) Z2(R$id.mRVSpecial)).scrollToPosition(this.f12195l);
            this.f12195l = -1;
        }
    }

    public final void f3() {
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(this, 1, false);
        int i10 = R$id.mRVSpecial;
        ((RecyclerView) Z2(i10)).setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) Z2(i10)).setHasFixedSize(true);
        ((RecyclerView) Z2(i10)).setItemViewCacheSize(1);
        d3().bindToRecyclerView((RecyclerView) Z2(i10));
        ((RecyclerView) Z2(i10)).setOverScrollMode(2);
        ((RecyclerView) Z2(i10)).setAdapter(d3());
        d3().setOnLoadMoreListener(this, (RecyclerView) Z2(i10));
        d3().setLoadMoreView(new RecyclerLoadMoreView());
        d3().disableLoadMoreIfNotFullPage();
    }

    public final void g3() {
        j2 c32 = S2();
        ChildColumnList childColumnList = RootColumnId.specialColumn;
        i.f(childColumnList, "specialColumn");
        c32.J(childColumnList);
    }

    public final void h3() {
        ((ImageView) Z2(R$id.mIvBack)).setOnClickListener(new x4(this));
        ((AutoRelativeLayout) Z2(R$id.mRlTop)).setOnClickListener(new y4(this));
        ((ImageView) Z2(R$id.mIvSearch)).setOnClickListener(new z4(this));
    }

    public void k2() {
        n2();
    }

    public void n1() {
        d3().loadMoreEnd();
    }

    public void n3(j2 j2Var) {
        i.g(j2Var, "<set-?>");
        this.f12197n = j2Var;
    }

    public void onLoadMoreRequested() {
        S2().C();
    }

    public void r(int i10) {
        d3().notifyItemChanged(i10);
    }

    public void u0() {
        d3().loadMoreComplete();
    }
}
