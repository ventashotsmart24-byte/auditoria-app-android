package com.mobile.brasiltv.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b6.z;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.AlreadyQueryFavEvent;
import com.mobile.brasiltv.bean.event.ClickSearchChannelEvent;
import com.mobile.brasiltv.bean.event.UpdateAllChannelEvent;
import com.mobile.brasiltv.bean.event.UpdateFavStatusEvent;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.o0;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.q3;
import f5.r3;
import f5.s3;
import f5.t3;
import f5.u3;
import g5.u2;
import g5.x2;
import h9.g;
import h9.h;
import i6.m0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.h3;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;
import t9.j;

public final class Search1Aty extends f5.d implements m0 {

    /* renamed from: l  reason: collision with root package name */
    public u2 f6022l = new u2(this, new ArrayList());

    /* renamed from: m  reason: collision with root package name */
    public x2 f6023m = new x2(this, new ArrayList());

    /* renamed from: n  reason: collision with root package name */
    public ArrayList f6024n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public o0 f6025o;

    /* renamed from: p  reason: collision with root package name */
    public final g f6026p = h.b(new a(this));

    /* renamed from: q  reason: collision with root package name */
    public h3 f6027q;

    /* renamed from: r  reason: collision with root package name */
    public Map f6028r = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Search1Aty f12114a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Search1Aty search1Aty) {
            super(0);
            this.f12114a = search1Aty;
        }

        public final Integer invoke() {
            return Integer.valueOf(n5.a.f8310a.a(this.f12114a));
        }
    }

    public static final class b implements u2.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Search1Aty f12115a;

        public b(Search1Aty search1Aty) {
            this.f12115a = search1Aty;
        }

        public void a(Channel channel) {
            i.g(channel, "itemData");
            this.f12115a.S2().v(channel);
            z.f4508u.l(true);
            xa.c.c().j(new ClickSearchChannelEvent(channel));
            this.f12115a.finish();
        }
    }

    public static final class c implements u2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Search1Aty f12116a;

        public c(Search1Aty search1Aty) {
            this.f12116a = search1Aty;
        }

        public void a(Channel channel, int i10) {
            i.g(channel, "itemData");
            this.f12116a.g3(channel, i10);
        }
    }

    public static final class d implements x2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Search1Aty f12117a;

        public d(Search1Aty search1Aty) {
            this.f12117a = search1Aty;
        }

        public void a(Channel channel) {
            i.g(channel, "itemData");
            z.a aVar = z.f4508u;
            if (!(!aVar.b().isEmpty())) {
                return;
            }
            if (aVar.b().get(channel.getChannelCode()) != null) {
                aVar.l(true);
                xa.c.c().j(new ClickSearchChannelEvent(channel));
                this.f12117a.finish();
                return;
            }
            f1.f12517a.w(R.string.live_no_channel);
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Search1Aty f12118a;

        public e(Search1Aty search1Aty) {
            this.f12118a = search1Aty;
        }

        public void afterTextChanged(Editable editable) {
            Search1Aty search1Aty = this.f12118a;
            int i10 = R$id.mEditSearch;
            if (TextUtils.isEmpty(((EditText) search1Aty.Z2(i10)).getText())) {
                this.f12118a.S2().G();
                return;
            }
            this.f12118a.f3().g(new ArrayList());
            this.f12118a.S2().K(((EditText) this.f12118a.Z2(i10)).getText().toString(), this.f12118a.b3());
            this.f12118a.e3().g(true);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final void i3(Search1Aty search1Aty, View view) {
        i.g(search1Aty, "this$0");
        search1Aty.finish();
    }

    public static final void j3(Search1Aty search1Aty, View view) {
        i.g(search1Aty, "this$0");
        search1Aty.finish();
    }

    public static final void k3(Search1Aty search1Aty, View view) {
        i.g(search1Aty, "this$0");
        ((EditText) search1Aty.Z2(R$id.mEditSearch)).getText().clear();
    }

    public static final void l3(Search1Aty search1Aty, View view) {
        i.g(search1Aty, "this$0");
        search1Aty.S2().z();
    }

    public static final void m3(Search1Aty search1Aty) {
        i.g(search1Aty, "this$0");
        int i10 = R$id.mEditSearch;
        if (!TextUtils.isEmpty(((EditText) search1Aty.Z2(i10)).getText())) {
            search1Aty.e3().g(true);
            search1Aty.S2().K(((EditText) search1Aty.Z2(i10)).getText().toString(), search1Aty.f6024n);
        }
    }

    public void N() {
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(8);
        ((RecyclerView) Z2(R$id.mRecyclerHistory)).setVisibility(8);
        ((RecyclerView) Z2(R$id.mRecyclerSearch)).setVisibility(0);
        e3().g(false);
    }

    public void R1(ArrayList arrayList) {
        i.g(arrayList, "data");
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(8);
        ((RecyclerView) Z2(R$id.mRecyclerHistory)).setVisibility(8);
        ((RecyclerView) Z2(R$id.mRecyclerSearch)).setVisibility(0);
        this.f6022l.g(arrayList);
        e3().h(true);
        e3().g(false);
    }

    public void R2() {
        o3(new h3(this, this));
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) Z2(R$id.mLayoutSearch)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, c3(), 0, 0);
        d6.a aVar = d6.a.f16338a;
        if (aVar.j() == 1) {
            aVar.m();
        }
        n3();
        h3();
        ((EditText) Z2(R$id.mEditSearch)).requestFocus();
    }

    public int T2() {
        return R.layout.activity_search1;
    }

    public View Z2(int i10) {
        Map map = this.f6028r;
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

    @xa.j
    public final void alreadyQueryFav(AlreadyQueryFavEvent alreadyQueryFavEvent) {
        i.g(alreadyQueryFavEvent, "event");
        if (this.f6022l.getItemCount() > 0) {
            this.f6022l.notifyDataSetChanged();
        }
    }

    public final ArrayList b3() {
        return this.f6024n;
    }

    public final int c3() {
        return ((Number) this.f6026p.getValue()).intValue();
    }

    /* renamed from: d3 */
    public h3 S2() {
        h3 h3Var = this.f6027q;
        if (h3Var != null) {
            return h3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final o0 e3() {
        o0 o0Var = this.f6025o;
        if (o0Var != null) {
            return o0Var;
        }
        i.w("mRecyclerViewUtil");
        return null;
    }

    public final u2 f3() {
        return this.f6022l;
    }

    public final void g3(Channel channel, int i10) {
        d6.a aVar = d6.a.f16338a;
        if (!aVar.l(channel.getChannelCode())) {
            aVar.f(channel.getChannelCode());
            this.f6022l.j(channel.getChannelCode(), i10);
            if (aVar.g(channel)) {
                aVar.h(channel);
            } else {
                aVar.e(channel);
            }
        }
    }

    public final void h3() {
        ((ImageView) Z2(R$id.mIvBack)).setOnClickListener(new q3(this));
        ((TextView) Z2(R$id.mTextCancel)).setOnClickListener(new r3(this));
        ((ImageView) Z2(R$id.mImageClear)).setOnClickListener(new s3(this));
        ((ImageView) Z2(R$id.mImageDeleteHistory)).setOnClickListener(new t3(this));
        this.f6022l.i(new b(this));
        this.f6022l.h(new c(this));
        this.f6023m.f(new d(this));
        ((EditText) Z2(R$id.mEditSearch)).addTextChangedListener(new e(this));
        p3(new o0((RecyclerView) Z2(R$id.mRecyclerSearch)));
        e3().i(new u3(this));
    }

    public void k2() {
        n2();
    }

    public void l() {
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(0);
        ((RecyclerView) Z2(R$id.mRecyclerHistory)).setVisibility(0);
        ((RecyclerView) Z2(R$id.mRecyclerSearch)).setVisibility(8);
        this.f6023m.e(new ArrayList());
    }

    public final void n3() {
        int i10 = R$id.mRecyclerSearch;
        ((RecyclerView) Z2(i10)).setLayoutManager(new LinearLayoutManager(this, 1, false));
        ((RecyclerView) Z2(i10)).setAdapter(this.f6022l);
        ((RecyclerView) Z2(i10)).setVisibility(8);
        int i11 = R$id.mRecyclerHistory;
        ((RecyclerView) Z2(i11)).setLayoutManager(new LinearLayoutManager(this, 1, false));
        ((RecyclerView) Z2(i11)).setAdapter(this.f6023m);
        ((RecyclerView) Z2(i11)).setVisibility(0);
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(0);
    }

    public void o3(h3 h3Var) {
        i.g(h3Var, "<set-?>");
        this.f6027q = h3Var;
    }

    public final void p3(o0 o0Var) {
        i.g(o0Var, "<set-?>");
        this.f6025o = o0Var;
    }

    public void showLoading(boolean z10) {
        int i10;
        ProgressBar progressBar = (ProgressBar) Z2(R$id.mLoadingPb);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        progressBar.setVisibility(i10);
    }

    @xa.j(sticky = true)
    public final void updateAllChannelList(UpdateAllChannelEvent updateAllChannelEvent) {
        i.g(updateAllChannelEvent, "event");
        this.f6024n.clear();
        this.f6024n.addAll(updateAllChannelEvent.getAllChannelList());
    }

    @xa.j
    public final void updateFavStatus(UpdateFavStatusEvent updateFavStatusEvent) {
        i.g(updateFavStatusEvent, "event");
        this.f6022l.k(updateFavStatusEvent.getChannelCode());
    }

    public void y2(ArrayList arrayList) {
        i.g(arrayList, "data");
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(0);
        ((RecyclerView) Z2(R$id.mRecyclerHistory)).setVisibility(0);
        ((RecyclerView) Z2(R$id.mRecyclerSearch)).setVisibility(8);
        this.f6023m.e(arrayList);
        e3().h(false);
    }
}
