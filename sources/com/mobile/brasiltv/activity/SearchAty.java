package com.mobile.brasiltv.activity;

import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.q0;
import com.mobile.brasiltv.utils.s;
import com.mobile.brasiltv.view.GridLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.RecyclerNoMoreView;
import com.mobile.brasiltv.view.SpaceItemDecoration;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.a4;
import f5.b4;
import f5.c4;
import f5.d4;
import f5.e4;
import f5.v3;
import f5.w3;
import f5.x3;
import f5.y3;
import f5.z3;
import g5.b3;
import g5.f0;
import g5.v2;
import h9.g;
import h9.h;
import h9.t;
import i6.n0;
import i6.o0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.s3;
import mobile.com.requestframe.utils.response.ShelveAsset;
import s9.l;
import t9.i;
import t9.j;

public final class SearchAty extends f5.d implements o0, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: l  reason: collision with root package name */
    public String f12119l = "";

    /* renamed from: m  reason: collision with root package name */
    public final g f12120m = h.b(new a(this));

    /* renamed from: n  reason: collision with root package name */
    public final g f12121n = h.b(new c(this));

    /* renamed from: o  reason: collision with root package name */
    public final g f12122o = h.b(new b(this));

    /* renamed from: p  reason: collision with root package name */
    public s3 f12123p;

    /* renamed from: q  reason: collision with root package name */
    public Map f12124q = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SearchAty f12125a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SearchAty searchAty) {
            super(0);
            this.f12125a = searchAty;
        }

        /* renamed from: b */
        public final v2 invoke() {
            return new v2(this.f12125a);
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SearchAty f12126a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SearchAty searchAty) {
            super(0);
            this.f12126a = searchAty;
        }

        /* renamed from: b */
        public final f0 invoke() {
            return new f0(this.f12126a);
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SearchAty f12127a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SearchAty searchAty) {
            super(0);
            this.f12127a = searchAty;
        }

        /* renamed from: b */
        public final b3 invoke() {
            return new b3(this.f12127a, new ArrayList());
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SearchAty f12128a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SearchAty searchAty) {
            super(1);
            this.f12128a = searchAty;
        }

        public final void b(Editable editable) {
            boolean z10;
            Editable text = ((EditText) this.f12128a.e3(R$id.searchEt)).getText();
            i.f(text, "searchEt.text");
            if (text.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                ((Button) this.f12128a.e3(R$id.searchCancel)).setText(this.f12128a.Q1().getResources().getString(R.string.cancel));
                ((ImageView) this.f12128a.e3(R$id.searchClear)).setVisibility(8);
                return;
            }
            ((Button) this.f12128a.e3(R$id.searchCancel)).setText(this.f12128a.Q1().getResources().getString(R.string.search_search));
            ((ImageView) this.f12128a.e3(R$id.searchClear)).setVisibility(0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Editable) obj);
            return t.f17319a;
        }
    }

    public static final void h3(SearchAty searchAty, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(searchAty, "this$0");
        Object obj = baseQuickAdapter.getData().get(i10);
        i.e(obj, "null cannot be cast to non-null type kotlin.String");
        searchAty.F3((String) obj);
    }

    public static final void i3(SearchAty searchAty, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        SearchAty searchAty2 = searchAty;
        i.g(searchAty, "this$0");
        ShelveAsset shelveAsset = (ShelveAsset) searchAty.u3().getData().get(i10);
        a7.d dVar = a7.d.f10697a;
        String o10 = dVar.o(shelveAsset.getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        SearchAty searchAty3 = searchAty;
        b0.t(searchAty3, shelveAsset.getType(), shelveAsset.getProgramType(), shelveAsset.getContentId(), EnterType.SEARCH, b0.c(ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString()), false, false, 0, "hotSearch", o10, 224, (Object) null);
    }

    public static final boolean k3(SearchAty searchAty, TextView textView, int i10, KeyEvent keyEvent) {
        i.g(searchAty, "this$0");
        if (i10 != 3) {
            return false;
        }
        searchAty.z3();
        return false;
    }

    public static final boolean l3(SearchAty searchAty, View view, int i10, KeyEvent keyEvent) {
        i.g(searchAty, "this$0");
        if (i10 != 66 || keyEvent.getAction() != 1) {
            return false;
        }
        searchAty.A3();
        return false;
    }

    public static final void m3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void n3(SearchAty searchAty, View view) {
        i.g(searchAty, "this$0");
        searchAty.finish();
    }

    public static final void o3(SearchAty searchAty, View view) {
        boolean z10;
        i.g(searchAty, "this$0");
        Editable text = ((EditText) searchAty.e3(R$id.searchEt)).getText();
        i.f(text, "searchEt.text");
        if (text.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            searchAty.finish();
            return;
        }
        searchAty.z3();
        searchAty.A3();
    }

    public static final void p3(SearchAty searchAty, View view) {
        i.g(searchAty, "this$0");
        ((EditText) searchAty.e3(R$id.searchEt)).setText("");
        searchAty.S2().V("");
        searchAty.f3();
    }

    public static final void q3(SearchAty searchAty, View view) {
        i.g(searchAty, "this$0");
        q0.a(searchAty.getApplicationContext());
        searchAty.s3();
    }

    public static final void r3(SearchAty searchAty, View view) {
        i.g(searchAty, "this$0");
        searchAty.S2().P();
        i1.F(searchAty);
    }

    public final void A3() {
        if (getCurrentFocus() != null) {
            Object systemService = getSystemService("input_method");
            i.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            View currentFocus = getCurrentFocus();
            i.d(currentFocus);
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        } else {
            Object systemService2 = getSystemService("input_method");
            i.e(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService2).hideSoftInputFromWindow(((EditText) e3(R$id.searchEt)).getWindowToken(), 2);
        }
        int i10 = R$id.searchEt;
        if (((EditText) e3(i10)) != null) {
            S2().S(((EditText) e3(i10)).getText().toString());
        }
    }

    public void B3(s3 s3Var) {
        i.g(s3Var, "<set-?>");
        this.f12123p = s3Var;
    }

    public void C2(String str) {
        i.g(str, "searchKey");
        this.f12119l = str;
        ((AutoLinearLayout) e3(R$id.mLlSearchEmpty)).setVisibility(0);
        ((RecyclerView) e3(R$id.searchResultList)).setVisibility(8);
        List data = v3().getData();
        if (data != null) {
            data.clear();
        }
        v3().notifyDataSetChanged();
        v3().setEnableLoadMore(false);
    }

    /* renamed from: C3 */
    public void Y0(n0 n0Var) {
        i.g(n0Var, "presenter");
    }

    public final void D3(int i10) {
        if (!u3().getData().isEmpty()) {
            ((AutoLinearLayout) e3(R$id.hotSearch)).setVisibility(i10);
            if (i10 == 0) {
                y3();
            }
        }
    }

    public final void E3(int i10) {
        ((AutoLinearLayout) e3(R$id.searchHistoryLayout)).setVisibility(i10);
    }

    public void F0(int i10, List list) {
        i.g(list, "assetList");
        ((AutoLinearLayout) e3(R$id.hotSearch)).setVisibility(0);
        u3().b(i10);
        u3().setNewData(list);
    }

    public final void F3(String str) {
        S2().S(str);
        int i10 = R$id.searchEt;
        ((EditText) e3(i10)).setText(str);
        Editable text = ((EditText) e3(i10)).getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
    }

    public void M0(String str) {
        i.g(str, "searchKey");
        C2(str);
        h0(8);
        v3().loadMoreFail();
    }

    public void R2() {
        B3(new s3(this, this));
        ((ImageView) e3(R$id.mIvBack)).setOnClickListener(new v3(this));
        ((Button) e3(R$id.searchCancel)).setOnClickListener(new w3(this));
        ((ImageView) e3(R$id.searchClear)).setOnClickListener(new x3(this));
        ((ImageView) e3(R$id.historyDelete)).setOnClickListener(new y3(this));
        ((ImageView) e3(R$id.mIvHotRefresh)).setOnClickListener(new z3(this));
        j3();
        g3();
        s3();
        i1.t(this);
    }

    public void T0() {
        LoadingDialog.Companion.hidden();
    }

    public int T2() {
        return R.layout.aty_search;
    }

    public String X() {
        Editable text;
        String obj;
        EditText editText = (EditText) e3(R$id.searchEt);
        if (editText == null || (text = editText.getText()) == null || (obj = text.toString()) == null) {
            return "";
        }
        return obj;
    }

    public void a1(List list, String str, boolean z10) {
        i.g(list, "showResults");
        i.g(str, "searchKey");
        h0(0);
        if (!i.b(this.f12119l, str)) {
            ((RecyclerView) e3(R$id.searchResultList)).scrollToPosition(0);
            v3().i(list, str);
            v3().setEnableLoadMore(true);
            this.f12119l = str;
        } else {
            v3().addData(list);
        }
        v3().loadMoreComplete();
    }

    public View e3(int i10) {
        Map map = this.f12124q;
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

    public final void f3() {
        s3();
        D3(0);
        x3();
    }

    public final void g3() {
        int i10 = R$id.searchHistoryList;
        ((RecyclerView) e3(i10)).setLayoutManager(new GridLayoutManagerWrapper(Q1(), 2));
        ((RecyclerView) e3(i10)).addItemDecoration(new SpaceItemDecoration(AutoUtils.getPercentHeightSize(20), AutoUtils.getPercentWidthSize(17), 2));
        t3().bindToRecyclerView((RecyclerView) e3(i10));
        t3().setOnItemClickListener(new a4(this));
        int i11 = R$id.searchResultList;
        ((RecyclerView) e3(i11)).setLayoutManager(new GridLayoutManagerWrapper(Q1(), 3));
        ((RecyclerView) e3(i11)).addItemDecoration(new SpaceItemDecoration(AutoUtils.getPercentHeightSize(36), AutoUtils.getPercentWidthSize(10), 3));
        v3().setOnLoadMoreListener(this, (RecyclerView) e3(i11));
        v3().setLoadMoreView(new RecyclerNoMoreView());
        v3().disableLoadMoreIfNotFullPage();
        ((RecyclerView) e3(i11)).setAdapter(v3());
        int i12 = R$id.hotSearchList;
        ((RecyclerView) e3(i12)).setLayoutManager(new LinearLayoutManagerWrapper(Q1(), 1, false));
        u3().bindToRecyclerView((RecyclerView) e3(i12));
        u3().setOnItemClickListener(new b4(this));
    }

    public void h() {
        LoadingDialog.Companion.show(getFragmentManager());
    }

    public void h0(int i10) {
        ((RecyclerView) e3(R$id.searchResultList)).setVisibility(i10);
        E3(8);
        if (i10 == 8) {
            D3(0);
        } else {
            D3(8);
        }
    }

    public void j0() {
        v3().loadMoreEnd();
    }

    public final void j3() {
        int i10 = R$id.searchEt;
        EditText editText = (EditText) e3(i10);
        if (editText != null) {
            editText.setOnEditorActionListener(new c4(this));
        }
        EditText editText2 = (EditText) e3(i10);
        if (editText2 != null) {
            editText2.setOnKeyListener(new d4(this));
        }
        s sVar = s.f12613a;
        EditText editText3 = (EditText) e3(i10);
        i.f(editText3, "searchEt");
        sVar.j(editText3).subscribe(new e4(new d(this)));
    }

    public void onLoadMoreRequested() {
        if (!TextUtils.isEmpty(X())) {
            F3(X());
        }
    }

    public final void s3() {
        ArrayList b10 = q0.b(getApplicationContext());
        if (b10.size() > 0) {
            t3().setNewData(b10);
            E3(0);
            return;
        }
        E3(8);
    }

    public final v2 t3() {
        return (v2) this.f12120m.getValue();
    }

    public final f0 u3() {
        return (f0) this.f12122o.getValue();
    }

    public void v2() {
    }

    public final b3 v3() {
        return (b3) this.f12121n.getValue();
    }

    /* renamed from: w3 */
    public s3 S2() {
        s3 s3Var = this.f12123p;
        if (s3Var != null) {
            return s3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void x0() {
        int i10 = R$id.searchEt;
        ((EditText) e3(i10)).setHint(b0.A(this, R.string.please_type_search_content));
        ((EditText) e3(i10)).setHintTextColor(b0.y(R.color.color_f23232));
    }

    public final void x3() {
        ((AutoLinearLayout) e3(R$id.mLlSearchEmpty)).setVisibility(8);
    }

    public final void y3() {
        ((RecyclerView) e3(R$id.searchResultList)).setVisibility(8);
    }

    public final void z3() {
        S2().Q(ba.t.W(((EditText) e3(R$id.searchEt)).getText().toString()).toString());
    }
}
