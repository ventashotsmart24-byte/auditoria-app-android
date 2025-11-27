package com.mobile.brasiltv.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.RefreshAccountEvent;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.dialog.AccountRemoveDialog;
import com.msandroid.mobile.R;
import e6.n;
import e6.p;
import e6.q;
import g5.q3;
import h9.h;
import h9.t;
import i6.f;
import i6.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.o;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.i;
import t9.j;

public final class AccountSwitchAty extends f5.d implements g {

    /* renamed from: l  reason: collision with root package name */
    public final h9.g f6065l = h.b(new c(this));

    /* renamed from: m  reason: collision with root package name */
    public View f6066m;

    /* renamed from: n  reason: collision with root package name */
    public LoadingView f6067n;

    /* renamed from: o  reason: collision with root package name */
    public int f6068o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f6069p;

    /* renamed from: q  reason: collision with root package name */
    public o f6070q;

    /* renamed from: r  reason: collision with root package name */
    public final Runnable f6071r = new n(this);

    /* renamed from: s  reason: collision with root package name */
    public Map f6072s = new LinkedHashMap();

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f12285a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            Intent putExtra = intent.putExtra("extra_login_out", true);
            i.f(putExtra, "it.putExtra(LoginAty.EXTRA_LOGIN_OUT, true)");
            return putExtra;
        }
    }

    public static final class b implements q3.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountSwitchAty f12286a;

        public static final class a extends j implements s9.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AccountSwitchAty f12287a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ SwitchAccountBean f12288b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(AccountSwitchAty accountSwitchAty, SwitchAccountBean switchAccountBean) {
                super(0);
                this.f12287a = accountSwitchAty;
                this.f12288b = switchAccountBean;
            }

            public final void invoke() {
                this.f12287a.S2().C(this.f12288b);
            }
        }

        /* renamed from: com.mobile.brasiltv.mine.activity.AccountSwitchAty$b$b  reason: collision with other inner class name */
        public static final class C0189b extends j implements s9.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AccountSwitchAty f12289a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0189b(AccountSwitchAty accountSwitchAty) {
                super(0);
                this.f12289a = accountSwitchAty;
            }

            public final void invoke() {
                this.f12289a.c3().j(!this.f12289a.c3().g());
                this.f12289a.l3();
            }
        }

        public b(AccountSwitchAty accountSwitchAty) {
            this.f12286a = accountSwitchAty;
        }

        public void a(int i10, SwitchAccountBean switchAccountBean) {
            i.g(switchAccountBean, "bean");
            this.f12286a.f6068o = i10;
            this.f12286a.S2().z(switchAccountBean);
        }

        public void b(int i10, String str, SwitchAccountBean switchAccountBean) {
            i.g(str, "account");
            i.g(switchAccountBean, "bean");
            AccountSwitchAty accountSwitchAty = this.f12286a;
            new AccountRemoveDialog(accountSwitchAty, str, new a(accountSwitchAty, switchAccountBean), new C0189b(this.f12286a)).show();
        }

        public void onBack() {
            this.f12286a.finish();
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountSwitchAty f12290a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AccountSwitchAty accountSwitchAty) {
            super(0);
            this.f12290a = accountSwitchAty;
        }

        /* renamed from: b */
        public final q3 invoke() {
            return new q3(this.f12290a);
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f12291a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(1);
            this.f12291a = str;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        public final void invoke(String str) {
            f1.f12517a.x(y.p(y.f12639a, this.f12291a, (String) null, (String) null, 6, (Object) null));
        }
    }

    public static final void f3(AccountSwitchAty accountSwitchAty, View view) {
        i.g(accountSwitchAty, "this$0");
        b0.d0(accountSwitchAty, LoginAty.class, a.f12285a);
    }

    public static final void h3(AccountSwitchAty accountSwitchAty, View view) {
        i.g(accountSwitchAty, "this$0");
        accountSwitchAty.c3().j(!accountSwitchAty.c3().g());
        accountSwitchAty.l3();
    }

    public static final void i3(AccountSwitchAty accountSwitchAty) {
        i.g(accountSwitchAty, "this$0");
        ((TextView) accountSwitchAty.Y2(R$id.mTvError)).setVisibility(8);
        if (accountSwitchAty.f6069p) {
            accountSwitchAty.f6069p = false;
            LoginAty.C.b(accountSwitchAty, true, true, (SwitchAccountBean) accountSwitchAty.c3().d().get(accountSwitchAty.f6068o));
        }
    }

    public static final void m3(AccountSwitchAty accountSwitchAty, DialogInterface dialogInterface) {
        i.g(accountSwitchAty, "this$0");
        accountSwitchAty.f6067n = null;
    }

    public void B1() {
        LoadingView loadingView = this.f6067n;
        if (loadingView != null) {
            loadingView.dismiss();
        }
        ((TextView) Y2(R$id.mTvError)).setVisibility(8);
    }

    public void R2() {
        j3(new o(this, this));
        ((ListView) Y2(R$id.mAccountList)).setAdapter(c3());
        e3();
        g3();
    }

    public int T2() {
        return R.layout.aty_account_switch;
    }

    public void V1() {
        c3().notifyDataSetChanged();
        n3();
    }

    public View Y2(int i10) {
        Map map = this.f6072s;
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

    public void Z1(ArrayList arrayList) {
        i.g(arrayList, "accountListData");
        c3().i(arrayList);
        n3();
    }

    public final q3 c3() {
        return (q3) this.f6065l.getValue();
    }

    /* renamed from: d3 */
    public o S2() {
        o oVar = this.f6070q;
        if (oVar != null) {
            return oVar;
        }
        i.w("mPresenter");
        return null;
    }

    public final void e3() {
        int i10 = R$id.mAccountList;
        if (((ListView) Y2(i10)).getFooterViewsCount() == 0) {
            this.f6066m = LayoutInflater.from(this).inflate(R.layout.footer_switch_accout, (ViewGroup) null);
            ((ListView) Y2(i10)).addFooterView(this.f6066m);
            View view = this.f6066m;
            if (view != null) {
                view.setOnClickListener(new p(this));
            }
        }
    }

    public final void g3() {
        ((TitleView) Y2(R$id.mTileView)).setTvMenuClickListener(new e6.o(this));
        c3().h(new b(this));
    }

    public void h() {
        if (this.f6067n == null) {
            this.f6067n = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new q(this), 6, (Object) null);
            t tVar = t.f17319a;
        }
        LoadingView loadingView = this.f6067n;
        if (loadingView != null) {
            loadingView.setCancelable(false);
        }
        LoadingView loadingView2 = this.f6067n;
        if (loadingView2 != null) {
            loadingView2.show();
        }
        ((TextView) Y2(R$id.mTvError)).setVisibility(8);
    }

    public void j3(o oVar) {
        i.g(oVar, "<set-?>");
        this.f6070q = oVar;
    }

    public void k2() {
        n2();
    }

    /* renamed from: k3 */
    public void Y0(f fVar) {
        i.g(fVar, "presenter");
    }

    public final void l3() {
        int i10;
        int i11 = R$id.mTileView;
        ((TitleView) Y2(i11)).setTvMenuTextSize(32);
        TitleView titleView = (TitleView) Y2(i11);
        if (c3().g()) {
            i10 = R.string.switch_account_cancel;
        } else {
            i10 = R.string.switch_account_remove;
        }
        String string = getString(i10);
        i.f(string, "getString(if (mAccountLi…ng.switch_account_remove)");
        titleView.setTvMenuText(string);
        c3().notifyDataSetChanged();
    }

    public final void n3() {
        if (!(!c3().d().isEmpty())) {
            ((TitleView) Y2(R$id.mTileView)).setTvMenuText("");
        } else if (c3().d().size() != 1 || !((SwitchAccountBean) c3().d().get(0)).isLogged()) {
            l3();
        } else {
            ((TitleView) Y2(R$id.mTileView)).setTvMenuText("");
        }
    }

    public void o(String str) {
        i.g(str, "error");
        if (i.b(str, "aaa100012") || i.b(str, "aaa100022") || i.b(str, "aaa100027") || i.b(str, "aaa100028") || i.b(str, "aaa100080") || i.b(str, "aaa100081") || i.b(str, "aaa100091") || i.b(str, "aaa100081") || i.b(str, "aaa100093")) {
            this.f6069p = true;
            ((TextView) Y2(R$id.mTvError)).setText(getString(R.string.switch_account_expired));
        } else if (i.b(na.d.b(str), "EA2")) {
            this.f6069p = false;
            x.f12622a.w(Q1(), new d(str));
            return;
        } else {
            this.f6069p = false;
            ((TextView) Y2(R$id.mTvError)).setText(getString(R.string.scan_login_failed));
        }
        int i10 = R$id.mTvError;
        ((TextView) Y2(i10)).setVisibility(0);
        ((TextView) Y2(i10)).removeCallbacks(this.f6071r);
        ((TextView) Y2(i10)).postDelayed(this.f6071r, 3000);
    }

    public void onResume() {
        super.onResume();
        S2().v();
    }

    public void onStop() {
        super.onStop();
        ((TextView) Y2(R$id.mTvError)).removeCallbacks(this.f6071r);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void refreshData(RefreshAccountEvent refreshAccountEvent) {
        i.g(refreshAccountEvent, "event");
        S2().v();
        b0.c0(this, MainAty.class);
    }
}
