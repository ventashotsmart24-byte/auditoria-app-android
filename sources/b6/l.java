package b6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.bean.event.BannerAutoPlayEvent;
import com.mobile.brasiltv.bean.event.CheckPwdSuccessEvent;
import com.mobile.brasiltv.bean.event.VodPageRestartEvent;
import com.mobile.brasiltv.mine.activity.EmailAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LoadingDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.c;
import g5.k;
import h9.g;
import h9.h;
import i6.j;
import i9.r;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.i;
import mobile.com.requestframe.utils.response.ChildColumnList;
import org.greenrobot.eventbus.ThreadMode;
import w6.i;

public final class l extends e<i> implements j, SwipeRefreshLayout.j, p {

    /* renamed from: i  reason: collision with root package name */
    public i f4411i;

    /* renamed from: j  reason: collision with root package name */
    public final g f4412j = h.b(new a(this));

    /* renamed from: k  reason: collision with root package name */
    public final g f4413k = h.b(new b(this));

    /* renamed from: l  reason: collision with root package name */
    public Map f4414l = new LinkedHashMap();

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f10999a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l lVar) {
            super(0);
            this.f10999a = lVar;
        }

        /* renamed from: b */
        public final ChildColumnList invoke() {
            Serializable serializable;
            Bundle arguments = this.f10999a.getArguments();
            if (arguments != null) {
                serializable = arguments.getSerializable("fragment_bound_key");
            } else {
                serializable = null;
            }
            t9.i.e(serializable, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.ChildColumnList");
            return (ChildColumnList) serializable;
        }
    }

    public static final class b extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f11000a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(l lVar) {
            super(0);
            this.f11000a = lVar;
        }

        /* renamed from: b */
        public final k invoke() {
            return new k(this.f11000a.Z2(), this.f11000a.m3());
        }
    }

    public static final void t3(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        lVar.a3().J(lVar.m3());
        ((KoocanEmptyView) lVar.k3(R$id.mLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    public static final void u3(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        lVar.a3().J(lVar.m3());
        ((KoocanEmptyView) lVar.k3(R$id.mLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    public static final void w3(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        Context context = lVar.getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.c0((c) context, EmailAty.class);
    }

    public static final void x3(l lVar, View view) {
        boolean z10;
        t9.i.g(lVar, "this$0");
        int i10 = R$id.mEditPassword;
        Editable text = ((EditText) lVar.k3(i10)).getText();
        if (text == null || text.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            String obj = t.W(((EditText) lVar.k3(i10)).getText().toString()).toString();
            if (!j1.f(obj)) {
                int i11 = R$id.mTextErrorNotify;
                ((TextView) lVar.k3(i11)).setVisibility(0);
                Context context = lVar.getContext();
                t9.i.d(context);
                ((TextView) lVar.k3(i11)).setText(context.getResources().getString(R.string.password_format_incorrect));
                return;
            }
            lVar.a3().w(obj);
        }
    }

    public static final void y3(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        i.c cVar = w6.i.f9510g;
        if (!t9.i.b(cVar.c(), "1") || t9.i.b(cVar.h(), "1") || t9.i.b(cVar.j(), "1")) {
            Intent intent = new Intent(lVar.getContext(), ResetAty.class);
            if (t9.i.b(cVar.h(), "1")) {
                intent.putExtra("need_x_button", false);
                intent.putExtra("bind_from", 2);
                intent.putExtra("bind_Type", "3");
                intent.putExtra("is_edit_editable", false);
            } else if (t9.i.b(cVar.j(), "1")) {
                intent.putExtra("need_x_button", false);
                intent.putExtra("bind_from", 1);
                intent.putExtra("bind_Type", "3");
                intent.putExtra("is_edit_editable", false);
            } else {
                intent.putExtra("need_x_button", false);
                intent.putExtra("bind_from", 2);
                intent.putExtra("bind_Type", "3");
                intent.putExtra("is_edit_editable", true);
            }
            Context context = lVar.getContext();
            if (context != null) {
                context.startActivity(intent);
                return;
            }
            return;
        }
        f1.f12517a.w(R.string.mine_please_bind);
    }

    public final void A3() {
        k3(R$id.mIncludeBindNotication).setVisibility(0);
        k3(R$id.mIncludePassword).setVisibility(8);
        ((ImageView) k3(R$id.mIvClose)).setVisibility(4);
    }

    public final void B3() {
        ((SwipeRefreshLayout) k3(R$id.mRefreshLayout)).setVisibility(0);
        if (S2() && !t9.i.b(w6.i.f9510g.H(), "")) {
            if (n3().getData().size() == 0) {
                ((KoocanEmptyView) k3(R$id.mLoadingView)).setVisibility(0);
                a3().J(m3());
            } else {
                n3().i(true);
            }
            ((RecyclerView) k3(R$id.mRvCr)).setVisibility(0);
        }
    }

    public final void C3() {
        ((EditText) k3(R$id.mEditPassword)).getText().clear();
        ((TextView) k3(R$id.mTextErrorNotify)).setVisibility(8);
        k3(R$id.mIncludeBindNotication).setVisibility(8);
        k3(R$id.mIncludePassword).setVisibility(0);
        ((ImageView) k3(R$id.mImageClose)).setVisibility(4);
    }

    public void I() {
        MainAty.A.o(false);
        xa.c.c().j(new CheckPwdSuccessEvent());
    }

    public void T2() {
        if (getView() != null) {
            if (MainAty.A.f()) {
                q3();
                s3();
                return;
            }
            p3();
            r3();
            B3();
        }
    }

    public void U2() {
        super.U2();
        if (Q2()) {
            n3().i(false);
        }
    }

    public void V2() {
        k n32;
        super.V2();
        if (((RecyclerView) k3(R$id.mRvCr)) != null && (n32 = n3()) != null) {
            n32.notifyDataSetChanged();
        }
    }

    public void X2() {
        this.f4414l.clear();
    }

    public void Y2() {
        int i10 = R$id.mRefreshLayout;
        ((SwipeRefreshLayout) k3(i10)).setColorSchemeResources(R.color.color_important);
        ((SwipeRefreshLayout) k3(i10)).setOnRefreshListener(this);
        ((SwipeRefreshLayout) k3(i10)).setDistanceToTriggerSync(AutoUtils.getPercentHeightSize(500));
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i11 = R$id.mRvCr;
        ((RecyclerView) k3(i11)).setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) k3(i11)).setHasFixedSize(true);
        ((RecyclerView) k3(i11)).setItemViewCacheSize(1);
        n3().bindToRecyclerView((RecyclerView) k3(i11));
        ((RecyclerView) k3(i11)).setOverScrollMode(2);
        ((RecyclerView) k3(i11)).setAdapter(n3());
        n3().z(getUserVisibleHint());
        v3();
    }

    public void a() {
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) k3(i10)) != null && !((SwipeRefreshLayout) k3(R$id.mRefreshLayout)).isRefreshing()) {
            ((KoocanEmptyView) k3(i10)).changeType(KoocanEmptyView.Type.LOADING);
            ((KoocanEmptyView) k3(i10)).setVisibility(0);
        }
    }

    public void b() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) k3(R$id.mRefreshLayout);
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        if (n3().getData().size() != 0) {
            k();
            return;
        }
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) k3(i10)) != null) {
            ((KoocanEmptyView) k3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) k3(i10)).setVisibility(0);
            ((KoocanEmptyView) k3(i10)).setOnClickListener(new j(this));
        }
    }

    public void c(String str) {
        t9.i.g(str, "errorCode");
        if (n3().getData().size() != 0) {
            k();
            return;
        }
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) k3(i10)) != null) {
            ((KoocanEmptyView) k3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) k3(i10)).setVisibility(0);
            ((AutoLinearLayout) ((KoocanEmptyView) k3(i10))._$_findCachedViewById(R$id.koocanEmptyContent)).setOnClickListener(new k(this));
        }
    }

    public int c3() {
        return R.layout.frag_cr;
    }

    @xa.j
    public final void checkPwdSuccess(CheckPwdSuccessEvent checkPwdSuccessEvent) {
        t9.i.g(checkPwdSuccessEvent, "event");
        if (isVisible()) {
            p3();
            r3();
            B3();
        }
    }

    public void f(List list) {
        t9.i.g(list, "columnContentList");
        n3().setNewData(r.G(list));
        k();
    }

    public void f1(boolean z10) {
        if (Q2()) {
            n3().A(z10);
        }
    }

    public void k() {
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) k3(i10)) != null) {
            ((KoocanEmptyView) k3(i10)).setVisibility(8);
        }
        int i11 = R$id.mRefreshLayout;
        if (((SwipeRefreshLayout) k3(i11)) != null && ((SwipeRefreshLayout) k3(i11)).isRefreshing()) {
            ((SwipeRefreshLayout) k3(i11)).setRefreshing(false);
        }
    }

    public View k3(int i10) {
        View findViewById;
        Map map = this.f4414l;
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

    public final ChildColumnList m3() {
        return (ChildColumnList) this.f4412j.getValue();
    }

    public final k n3() {
        return (k) this.f4413k.getValue();
    }

    /* renamed from: o3 */
    public l6.i a3() {
        l6.i iVar = this.f4411i;
        if (iVar != null) {
            return iVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onBannerAutoPlayEvent(BannerAutoPlayEvent bannerAutoPlayEvent) {
        t9.i.g(bannerAutoPlayEvent, "event");
        if (Q2() && S2()) {
            n3().i(bannerAutoPlayEvent.getAutoPlay());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z3(new l6.i(this, this));
        xa.c.c().o(this);
    }

    public void onDestroy() {
        super.onDestroy();
        xa.c.c().r(this);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void onRefresh() {
        a3().J(m3());
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onRestart(VodPageRestartEvent vodPageRestartEvent) {
        t9.i.g(vodPageRestartEvent, "event");
        if (isVisible()) {
            MainAty.a aVar = MainAty.A;
            if (aVar.f()) {
                q3();
                s3();
            } else if (!aVar.f() && ((SwipeRefreshLayout) k3(R$id.mRefreshLayout)).getVisibility() != 0) {
                p3();
                r3();
                B3();
            }
        }
    }

    public final void p3() {
        k3(R$id.mIncludeBindNotication).setVisibility(8);
    }

    public final void q3() {
        k();
        ((SwipeRefreshLayout) k3(R$id.mRefreshLayout)).setVisibility(8);
        ((RecyclerView) k3(R$id.mRvCr)).setVisibility(8);
    }

    public void r(int i10) {
        n3().notifyItemChanged(i10);
    }

    public final void r3() {
        k3(R$id.mIncludePassword).setVisibility(8);
        ((EditText) k3(R$id.mEditPassword)).getText().clear();
        ((TextView) k3(R$id.mTextErrorNotify)).setVisibility(8);
    }

    public final void s3() {
        d6.b bVar = d6.b.f6366a;
        if (!bVar.a() || (bVar.c() && !bVar.b() && !bVar.d())) {
            A3();
        } else {
            C3();
        }
    }

    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        if (Q2()) {
            n3().z(getUserVisibleHint());
        }
        if (!getUserVisibleHint()) {
            LoadingDialog.Companion.hidden();
        }
    }

    public final void v3() {
        ((TextView) k3(R$id.mTvGotoBind)).setOnClickListener(new g(this));
        ((TextView) k3(R$id.mTextConfirm)).setOnClickListener(new h(this));
        ((TextView) k3(R$id.mTextForgetPassword)).setOnClickListener(new i(this));
    }

    public void y(boolean z10) {
        int i10;
        ProgressBar progressBar = (ProgressBar) k3(R$id.mLoadingPb);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        progressBar.setVisibility(i10);
    }

    public void z3(l6.i iVar) {
        t9.i.g(iVar, "<set-?>");
        this.f4411i = iVar;
    }
}
