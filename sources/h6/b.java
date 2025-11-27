package h6;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CouponQualificationEvent;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.dialog.CommonAlertDialog;
import com.mobile.brasiltv.view.dialog.ICommonAlertCallback;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import h9.g;
import h9.h;
import h9.t;
import j6.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.q;
import mobile.com.requestframe.utils.response.CouponCodeList;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

public final class b extends b6.e<q> implements j6.b {

    /* renamed from: i  reason: collision with root package name */
    public q f6957i;

    /* renamed from: j  reason: collision with root package name */
    public final g f6958j = h.b(d.f17294a);

    /* renamed from: k  reason: collision with root package name */
    public final g f6959k = h.b(e.f17295a);

    /* renamed from: l  reason: collision with root package name */
    public g7.f f6960l;

    /* renamed from: m  reason: collision with root package name */
    public View.OnClickListener f6961m = new f(this);

    /* renamed from: n  reason: collision with root package name */
    public Map f6962n = new LinkedHashMap();

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17291a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar) {
            super(1);
            this.f17291a = bVar;
        }

        public final void b(CouponCodeList couponCodeList) {
            i.g(couponCodeList, "it");
            this.f17291a.m3(couponCodeList);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CouponCodeList) obj);
            return t.f17319a;
        }
    }

    /* renamed from: h6.b$b  reason: collision with other inner class name */
    public static final class C0224b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17292a;

        public C0224b(b bVar) {
            this.f17292a = bVar;
        }

        public void onClick(View view) {
            this.f17292a.Q0();
        }
    }

    public static final class c implements ICommonAlertCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17293a;

        public c(b bVar) {
            this.f17293a = bVar;
        }

        public void onCancel(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
        }

        public void onConfirm(Dialog dialog) {
            i.g(dialog, "dialog");
            Context context = this.f17293a.getContext();
            i.d(context);
            context.startActivity(new Intent(this.f17293a.getContext(), AccountBindAty.class));
            dialog.dismiss();
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f17294a = new d();

        public d() {
            super(0);
        }

        /* renamed from: b */
        public final f6.b invoke() {
            return new f6.b();
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f17295a = new e();

        public e() {
            super(0);
        }

        /* renamed from: b */
        public final f6.c invoke() {
            return new f6.c();
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17296a;

        public f(b bVar) {
            this.f17296a = bVar;
        }

        public void onClick(View view) {
            g7.f h32 = this.f17296a.f6960l;
            if (h32 != null) {
                h32.m();
            }
            this.f17296a.a3().p();
        }
    }

    public static final void p3(b bVar) {
        i.g(bVar, "this$0");
        g7.f fVar = bVar.f6960l;
        if (!(fVar instanceof g7.b)) {
            fVar = null;
        }
        if (fVar != null) {
            fVar.a(1.0f);
        }
        bVar.f6960l = null;
    }

    public void C() {
        ((ProgressBar) g3(R$id.mLoadingView)).setVisibility(8);
        ((AutoLinearLayout) g3(R$id.mLLEmpty)).setVisibility(0);
        ((RecyclerView) g3(R$id.mList)).setVisibility(8);
    }

    public void E2() {
        g7.f fVar = this.f6960l;
        if (fVar != null) {
            fVar.dismiss();
        }
        a.C0232a.a(a3(), (String) null, 1, (Object) null);
        i.c cVar = w6.i.f9510g;
        cVar.i0(false);
        cVar.r0(0);
        cVar.a(getContext());
    }

    public void K1(List list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            n3();
            j3().setNewData(list);
            return;
        }
        C();
    }

    public void Q0() {
        if (w6.i.f9510g.M()) {
            String string = getResources().getString(R.string.coupons_available_pop_title);
            t9.i.f(string, "resources.getString(R.st…pons_available_pop_title)");
            g7.f fVar = new g7.f(Z2(), string, k3());
            fVar.j();
            fVar.l();
            String string2 = getResources().getString(R.string.coupons_available_pop_btn_title);
            t9.i.f(string2, "resources.getString(R.st…_available_pop_btn_title)");
            fVar.k(string2);
            fVar.i(this.f6961m);
            Z2().getWindow().addFlags(2);
            fVar.c(true);
            this.f6960l = fVar;
            fVar.setOnDismissListener(new a(this));
        }
    }

    public void T2() {
    }

    public void X2() {
        this.f6962n.clear();
    }

    public void Y2() {
        int i10 = R$id.mList;
        ((RecyclerView) g3(i10)).setLayoutManager(new LinearLayoutManagerWrapper(getActivity()));
        j3().bindToRecyclerView((RecyclerView) g3(i10));
        j3().e(new a(this));
        ((AutoRelativeLayout) g3(R$id.mCouponAvailableLayout)).setOnClickListener(new C0224b(this));
    }

    public int c3() {
        return R.layout.frag_coupons;
    }

    public View g3(int i10) {
        View findViewById;
        Map map = this.f6962n;
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

    public void h() {
        ((ProgressBar) g3(R$id.mLoadingView)).setVisibility(0);
        ((AutoLinearLayout) g3(R$id.mLLEmpty)).setVisibility(8);
        ((RecyclerView) g3(R$id.mList)).setVisibility(8);
    }

    public final f6.b j3() {
        return (f6.b) this.f6958j.getValue();
    }

    public final f6.c k3() {
        return (f6.c) this.f6959k.getValue();
    }

    /* renamed from: l3 */
    public q a3() {
        q qVar = this.f6957i;
        if (qVar != null) {
            return qVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void m3(CouponCodeList couponCodeList) {
        boolean z10;
        if (!d6.b.f6366a.y()) {
            i.c cVar = w6.i.f9510g;
            if (cVar.g().length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                b0.k0(this, cVar.g() + "&packageCode=" + couponCodeList.getPackageCode() + "&couponId=" + couponCodeList.getId(), false, true, false, 8, (Object) null);
            }
        } else if (getActivity() != null) {
            androidx.fragment.app.e activity = getActivity();
            t9.i.d(activity);
            String string = getResources().getString(R.string.bind_account_use_coupons);
            t9.i.f(string, "resources.getString(R.st…ind_account_use_coupons )");
            String string2 = getResources().getString(R.string.cancel);
            t9.i.f(string2, "resources.getString(R.string.cancel)");
            String string3 = getResources().getString(R.string.now_bind);
            t9.i.f(string3, "resources.getString(R.string.now_bind)");
            new CommonAlertDialog(activity, string, string2, string3).setCommonAlertCallback(new c(this)).show();
        }
    }

    public final void n3() {
        ((ProgressBar) g3(R$id.mLoadingView)).setVisibility(8);
        ((AutoLinearLayout) g3(R$id.mLLEmpty)).setVisibility(8);
        ((RecyclerView) g3(R$id.mList)).setVisibility(0);
    }

    public void o1(List list) {
        k3().setNewData(list);
    }

    public void o3(q qVar) {
        t9.i.g(qVar, "<set-?>");
        this.f6957i = qVar;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onCouponQualificationEvent(CouponQualificationEvent couponQualificationEvent) {
        t9.i.g(couponQualificationEvent, "event");
        s1();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o3(new q(this, this));
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

    public void onResume() {
        super.onResume();
        if (w6.i.f9510g.M()) {
            a3().f("1");
        } else {
            a.C0232a.a(a3(), (String) null, 1, (Object) null);
        }
    }

    public void s1() {
        if (w6.i.f9510g.M()) {
            ((AutoRelativeLayout) g3(R$id.mCouponAvailableLayout)).setVisibility(0);
        } else {
            ((AutoRelativeLayout) g3(R$id.mCouponAvailableLayout)).setVisibility(8);
        }
    }

    public void t2(String str) {
        t9.i.g(str, "errorCode");
        if (t9.i.b(str, "success")) {
            String string = getResources().getString(R.string.coupons_retrieve_success);
            t9.i.f(string, "resources.getString(R.st…coupons_retrieve_success)");
            f1.f12517a.k(getContext(), string, 1);
        } else if (t9.i.b(str, "failed")) {
            if (w6.i.f9510g.B() > 2) {
                String string2 = getResources().getString(R.string.coupons_retrieve_failed_again);
                t9.i.f(string2, "resources.getString(R.st…ns_retrieve_failed_again)");
                f1.f12517a.k(getContext(), string2, 1);
            } else {
                String string3 = getResources().getString(R.string.coupons_retrieve_failed);
                t9.i.f(string3, "resources.getString(R.st….coupons_retrieve_failed)");
                f1.f12517a.k(getContext(), string3, 1);
            }
            g7.f fVar = this.f6960l;
            if (fVar != null) {
                fVar.h();
            }
        }
    }
}
