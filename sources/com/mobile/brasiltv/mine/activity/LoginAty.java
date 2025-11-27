package com.mobile.brasiltv.mine.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.activity.SelectNationAty;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.bean.event.SetLoginAtySelectTabEvent;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.BlackListDialog;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.MaxHeightLinearLayout;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.mobile.brasiltv.view.login.AccountEditView;
import com.mobile.brasiltv.view.login.AccountLoginPanel;
import com.mobile.brasiltv.view.login.IAccountEditCallback;
import com.mobile.brasiltv.view.login.IAccountLoginCallback;
import com.mobile.brasiltv.view.login.ILoginPanel;
import com.mobile.brasiltv.view.login.IMobileLoginCallback;
import com.mobile.brasiltv.view.login.IPwdEditCallback;
import com.mobile.brasiltv.view.login.IQuickLoginCallback;
import com.mobile.brasiltv.view.login.ISmsLoginCallback;
import com.mobile.brasiltv.view.login.MobileLoginPanel;
import com.mobile.brasiltv.view.login.PasswordEditView;
import com.mobile.brasiltv.view.login.QuickLoginPanel;
import com.mobile.brasiltv.view.login.SmsLoginPanel;
import com.mobile.brasiltv.view.login.dialog.CreateNewAccountDialog;
import com.mobile.brasiltv.view.login.dialog.GoogleEmailRegisteredDialog;
import com.mobile.brasiltv.view.login.dialog.IBindThirdPartCallback;
import com.mobile.brasiltv.view.login.dialog.ICreateNewAccountCallback;
import com.mobile.brasiltv.view.login.dialog.ISetPasswordCallback;
import com.mobile.brasiltv.view.login.dialog.LoginTpFailDialog;
import com.mobile.brasiltv.view.login.dialog.TpSetPwdDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import e6.f0;
import e6.g0;
import e6.h0;
import e6.i0;
import e6.k0;
import e6.l0;
import e6.m0;
import e6.n0;
import g5.c;
import i6.s;
import i6.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.j0;
import s9.l;
import t9.j;
import t9.z;

public final class LoginAty extends f5.d implements t, IAccountLoginCallback, IMobileLoginCallback, ISmsLoginCallback, z7.a, IBindThirdPartCallback, ICreateNewAccountCallback, IQuickLoginCallback, ISetPasswordCallback {
    public static final a C = new a((t9.g) null);
    public static boolean D;
    public j0 A;
    public Map B = new LinkedHashMap();

    /* renamed from: l  reason: collision with root package name */
    public boolean f6086l = true;

    /* renamed from: m  reason: collision with root package name */
    public boolean f6087m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f6088n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6089o;

    /* renamed from: p  reason: collision with root package name */
    public String f6090p = "Brasil";

    /* renamed from: q  reason: collision with root package name */
    public String f6091q = "55";

    /* renamed from: r  reason: collision with root package name */
    public LoadingView f6092r;

    /* renamed from: s  reason: collision with root package name */
    public ILoginPanel f6093s;

    /* renamed from: t  reason: collision with root package name */
    public z7.b f6094t;

    /* renamed from: u  reason: collision with root package name */
    public final h9.g f6095u = h9.h.b(new g(this));

    /* renamed from: v  reason: collision with root package name */
    public String f6096v = "@gmail.com";

    /* renamed from: w  reason: collision with root package name */
    public String f6097w;

    /* renamed from: x  reason: collision with root package name */
    public String f6098x;

    /* renamed from: y  reason: collision with root package name */
    public ArrayList f6099y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    public IAccountLoginCallback f6100z;

    public static final class a {

        /* renamed from: com.mobile.brasiltv.mine.activity.LoginAty$a$a  reason: collision with other inner class name */
        public static final class C0190a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f12326a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f12327b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0190a(boolean z10, boolean z11) {
                super(1);
                this.f12326a = z10;
                this.f12327b = z11;
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("can_back", this.f12326a);
                Intent putExtra = intent.putExtra("success_to_main", this.f12327b);
                t9.i.f(putExtra, "it.putExtra(SUCCESS_TO_MAIN, successToMain)");
                return putExtra;
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f12328a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f12329b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SwitchAccountBean f12330c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(boolean z10, boolean z11, SwitchAccountBean switchAccountBean) {
                super(1);
                this.f12328a = z10;
                this.f12329b = z11;
                this.f12330c = switchAccountBean;
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("can_back", this.f12328a);
                intent.putExtra("success_to_main", this.f12329b);
                Intent putExtra = intent.putExtra("extra_fill_account", this.f12330c);
                t9.i.f(putExtra, "it.putExtra(EXTRA_FILL_ACCOUNT, account)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final void a(f5.c cVar, boolean z10, boolean z11) {
            t9.i.g(cVar, "activity");
            b0.d0(cVar, LoginAty.class, new C0190a(z10, z11));
        }

        public final void b(f5.c cVar, boolean z10, boolean z11, SwitchAccountBean switchAccountBean) {
            t9.i.g(cVar, "activity");
            b0.d0(cVar, LoginAty.class, new b(z10, z11, switchAccountBean));
        }

        public final void c(boolean z10) {
            LoginAty.D = z10;
        }
    }

    public static final class b implements IPwdEditCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LoginAty f12331a;

        public b(LoginAty loginAty) {
            this.f12331a = loginAty;
        }

        public void onTextChanged(String str) {
            t9.i.g(str, "content");
            this.f12331a.f6098x = str;
        }
    }

    public static final class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LoginAty f12332a;

        public c(LoginAty loginAty) {
            this.f12332a = loginAty;
        }

        public void onClick(String str) {
            t9.i.g(str, "mEmailString");
            LoginAty loginAty = this.f12332a;
            int i10 = R$id.mEtInput;
            ((EditText) loginAty.d3(i10)).setText(str);
            ((EditText) this.f12332a.d3(i10)).setSelection(str.length());
            ((RecyclerView) this.f12332a.d3(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) this.f12332a.d3(R$id.mLlRecyEmail)).setVisibility(8);
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f12333a = new d();

        public d() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "it");
            WebViewAty.a aVar = WebViewAty.B;
            intent.putExtra(aVar.j(), a6.c.a());
            Intent putExtra = intent.putExtra(aVar.a(), false);
            t9.i.f(putExtra, "it.putExtra(WebViewAty.BUNDLE_BACK_TO_MAIN, false)");
            return putExtra;
        }
    }

    public static final class e implements IAccountEditCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LoginAty f12334a;

        public e(LoginAty loginAty) {
            this.f12334a = loginAty;
        }

        public void onTextChanged(String str) {
            t9.i.g(str, "content");
            this.f12334a.f6097w = str;
            this.f12334a.y3(str);
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LoginAty f12335a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(LoginAty loginAty) {
            super(1);
            this.f12335a = loginAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f17319a;
        }

        public final void invoke(String str) {
            z zVar = z.f19601a;
            String string = this.f12335a.Q1().getString(R.string.redemption_any_question);
            t9.i.f(string, "context.getString(R.stri….redemption_any_question)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            t9.i.f(format, "format(format, *args)");
            ((TextView) this.f12335a.d3(R$id.tvWebsite)).setText(format);
        }
    }

    public static final class g extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LoginAty f12336a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(LoginAty loginAty) {
            super(0);
            this.f12336a = loginAty;
        }

        public final g5.c invoke() {
            return new g5.c(this.f12336a.Q1());
        }
    }

    public static final class h extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LoginAty f12337a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(LoginAty loginAty) {
            super(1);
            this.f12337a = loginAty;
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "it");
            intent.putExtra("need_x_button", false);
            intent.putExtra("is_form_login", true);
            if (this.f12337a.f6093s instanceof MobileLoginPanel) {
                intent.putExtra("bind_from", 1);
            } else {
                intent.putExtra("bind_from", 2);
            }
            Intent putExtra = intent.putExtra("bind_Type", "3");
            t9.i.f(putExtra, "it.putExtra(Constant.BIND_TYPE, \"3\")");
            return putExtra;
        }
    }

    public static final class i implements GoogleEmailRegisteredDialog.IBindThirdPartCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LoginAty f12338a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f12339b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x7.a f12340c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f12341d;

        public i(LoginAty loginAty, String str, x7.a aVar, String str2) {
            this.f12338a = loginAty;
            this.f12339b = str;
            this.f12340c = aVar;
            this.f12341d = str2;
        }

        public void dialogRevokeAccessGoogle() {
            this.f12338a.q();
        }

        public void onBindThirdPart() {
            s.a.a(this.f12338a.S2(), this.f12339b, this.f12340c, "2", this.f12341d, this.f12338a.f6087m, (String) null, 32, (Object) null);
        }
    }

    public static final void C3(LoginAty loginAty, DialogInterface dialogInterface) {
        t9.i.g(loginAty, "this$0");
        loginAty.f6092r = null;
        loginAty.S2().x();
    }

    public static /* synthetic */ void F3(LoginAty loginAty, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        loginAty.E3(str, str2);
    }

    public static /* synthetic */ void I3(LoginAty loginAty, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        loginAty.H3(str, str2);
    }

    public static final void p3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        loginAty.onBackPressed();
    }

    public static final void q3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        loginAty.B3(0);
    }

    public static final void r3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        loginAty.B3(1);
    }

    public static final void s3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        b0.d0(loginAty, WebViewAty.class, d.f12333a);
    }

    public static final void t3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        if (!TextUtils.isEmpty(loginAty.f6097w) && !TextUtils.isEmpty(loginAty.f6098x)) {
            b0.F(loginAty);
            j0 l32 = loginAty.S2();
            String str = loginAty.f6097w;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            String str3 = loginAty.f6098x;
            if (str3 != null) {
                str2 = str3;
            }
            l32.v(str, str2, loginAty.f6087m);
            IAccountLoginCallback iAccountLoginCallback = loginAty.f6100z;
            if (iAccountLoginCallback != null) {
                iAccountLoginCallback.onAccountLogin(((AccountEditView) loginAty.d3(R$id.mAevAccount)).getAccount(), ((PasswordEditView) loginAty.d3(R$id.mPevPassword)).getPassword());
            }
        }
    }

    public static final void u3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        if (!a6.f.f10686a.a()) {
            loginAty.n(R.string.try_other_login_method);
        } else {
            loginAty.m3();
        }
    }

    public static final void v3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        loginAty.onForgetPwd();
    }

    public static final void w3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        b0.M(loginAty);
    }

    public void A3(j0 j0Var) {
        t9.i.g(j0Var, "<set-?>");
        this.A = j0Var;
    }

    public final void B3(int i10) {
        if (i10 == 0) {
            int i11 = R$id.mLayoutTabQuickLogin;
            ((AutoLinearLayout) d3(i11)).setSelected(true);
            int i12 = R$id.mLayoutTabLogin;
            ((AutoLinearLayout) d3(i12)).setSelected(false);
            TextView textView = (TextView) ((AutoLinearLayout) d3(i11)).getChildAt(0);
            if (textView != null) {
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            }
            TextView textView2 = (TextView) ((AutoLinearLayout) d3(i12)).getChildAt(0);
            if (textView2 != null) {
                textView2.setTypeface(Typeface.DEFAULT);
            }
            d3(R$id.mLoginNew).setVisibility(8);
            G3();
        } else if (i10 == 1) {
            int i13 = R$id.mLayoutTabQuickLogin;
            ((AutoLinearLayout) d3(i13)).setSelected(false);
            int i14 = R$id.mLayoutTabLogin;
            ((AutoLinearLayout) d3(i14)).setSelected(true);
            TextView textView3 = (TextView) ((AutoLinearLayout) d3(i13)).getChildAt(0);
            if (textView3 != null) {
                textView3.setTypeface(Typeface.DEFAULT);
            }
            TextView textView4 = (TextView) ((AutoLinearLayout) d3(i14)).getChildAt(0);
            if (textView4 != null) {
                textView4.setTypeface(Typeface.DEFAULT_BOLD);
            }
            d3(R$id.mLoginNew).setVisibility(0);
            z3();
        }
    }

    public final void D3(boolean z10, String str) {
        z3();
        AccountLoginPanel accountLoginPanel = new AccountLoginPanel(Q1(), (AttributeSet) null, 0, 6, (t9.g) null);
        accountLoginPanel.setId(R.id.other_login_panel);
        accountLoginPanel.setBackgroundColor(getResources().getColor(R.color.color_1f202a));
        accountLoginPanel.setAccountLoginCallback(this);
        accountLoginPanel.setDeviceId(w6.i.f9510g.l());
        accountLoginPanel.isEmailLogin(z10);
        accountLoginPanel.fillAccount(str);
        ((AutoFrameLayout) d3(R$id.mLoginRoot)).addView(accountLoginPanel);
        this.f6093s = accountLoginPanel;
    }

    public final void E3(String str, String str2) {
        z3();
        MobileLoginPanel mobileLoginPanel = new MobileLoginPanel(Q1(), (AttributeSet) null, 0, 6, (t9.g) null);
        mobileLoginPanel.setId(R.id.other_login_panel);
        mobileLoginPanel.setBackgroundColor(getResources().getColor(R.color.color_1f202a));
        mobileLoginPanel.setMobileLoginCallback(this);
        mobileLoginPanel.updateAreaInfo(this.f6090p, this.f6091q);
        mobileLoginPanel.fillAccount(str);
        mobileLoginPanel.fillArea(str2);
        ((AutoFrameLayout) d3(R$id.mLoginRoot)).addView(mobileLoginPanel);
        this.f6093s = mobileLoginPanel;
    }

    public void F2(String str, String str2, String str3, x7.a aVar) {
        t9.i.g(str2, "thirdPartType");
        t9.i.g(str3, "tpSource");
        t9.i.g(aVar, "socialInfo");
        Context Q1 = Q1();
        if (str == null) {
            str = "";
        }
        new GoogleEmailRegisteredDialog(Q1, str).setBindThirdPartCallback(new i(this, str2, aVar, str3)).show();
    }

    public final void G3() {
        z3();
        QuickLoginPanel quickLoginPanel = new QuickLoginPanel(Q1(), (AttributeSet) null, 0, 6, (t9.g) null);
        quickLoginPanel.setId(R.id.other_login_panel);
        quickLoginPanel.setAccountLoginCallback(this);
        quickLoginPanel.attachDataToView(S2().G());
        ((AutoFrameLayout) d3(R$id.mLoginRoot)).addView(quickLoginPanel);
        this.f6093s = quickLoginPanel;
    }

    public final void H3(String str, String str2) {
        z3();
        SmsLoginPanel smsLoginPanel = new SmsLoginPanel(Q1(), (AttributeSet) null, 0, 6, (t9.g) null);
        smsLoginPanel.setId(R.id.other_login_panel);
        smsLoginPanel.setBackgroundColor(getResources().getColor(R.color.color_1f202a));
        smsLoginPanel.setSmsLoginCallback(this);
        smsLoginPanel.updateAreaInfo(this.f6090p, this.f6091q);
        smsLoginPanel.fillAccount(str);
        smsLoginPanel.fillArea(str2);
        ((AutoFrameLayout) d3(R$id.mLoginRoot)).addView(smsLoginPanel);
        this.f6093s = smsLoginPanel;
    }

    public void M1(String str) {
        t9.i.g(str, "thirdPartType");
        if (b0.T(str, "google")) {
            m3();
        }
    }

    public void Q() {
        ILoginPanel iLoginPanel = this.f6093s;
        if (iLoginPanel != null) {
            iLoginPanel.cancelSmsCountDown();
        }
    }

    public void R2() {
        A3(new j0(this, this));
        x3();
        o3();
    }

    public void S(String str, String str2, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        new TpSetPwdDialog(this, str, str2, aVar).setSetPasswordCallback(this).show();
    }

    public void S0(int i10, x7.a aVar) {
        String str;
        t9.i.g(aVar, "info");
        if (i10 == 1) {
            str = "google";
        } else {
            str = "facebook";
        }
        s.a.a(S2(), str, aVar, "0", "2", this.f6087m, (String) null, 32, (Object) null);
    }

    public int T2() {
        return R.layout.aty_login_new;
    }

    public void U1() {
        new LoginTpFailDialog(this).show();
    }

    public void c0(String str) {
        t9.i.g(str, "error");
        if (t9.i.b("aaa100094", str)) {
            new NumberLimitDialog(Q1()).show();
            return;
        }
        ILoginPanel iLoginPanel = this.f6093s;
        if (iLoginPanel instanceof QuickLoginPanel) {
            t9.i.e(iLoginPanel, "null cannot be cast to non-null type com.mobile.brasiltv.view.login.QuickLoginPanel");
            ((QuickLoginPanel) iLoginPanel).showError(str);
        }
    }

    public void d(int i10) {
        ILoginPanel iLoginPanel = this.f6093s;
        if (iLoginPanel != null) {
            String string = getResources().getString(i10);
            t9.i.f(string, "resources.getString(strResId)");
            iLoginPanel.showErrorHint(string);
        }
    }

    public View d3(int i10) {
        Map map = this.B;
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

    public void dialogRevokeAccessGoogle() {
        q();
    }

    public void e(List list) {
        t9.i.g(list, "emailList");
        if (!list.isEmpty()) {
            this.f6099y.addAll(list);
        }
    }

    public void h1(String str, String str2) {
        String str3;
        t9.i.g(str, "areaCode");
        t9.i.g(str2, "area");
        if (b0.K(str) && b0.K(str2) && !this.f6089o) {
            ILoginPanel iLoginPanel = this.f6093s;
            if (iLoginPanel != null) {
                str3 = iLoginPanel.getMobile();
            } else {
                str3 = null;
            }
            if (b0.J(str3)) {
                this.f6090p = str2;
                this.f6091q = str;
                ILoginPanel iLoginPanel2 = this.f6093s;
                if (iLoginPanel2 != null) {
                    iLoginPanel2.updateAreaInfo(str2, str);
                }
            }
        }
    }

    public void hideErrorHint(long j10) {
        ILoginPanel iLoginPanel = this.f6093s;
        if (iLoginPanel != null) {
            iLoginPanel.hideErrorHint(j10);
        }
    }

    public void i() {
        ILoginPanel iLoginPanel = this.f6093s;
        if (iLoginPanel != null) {
            iLoginPanel.startSmsCountDown();
        }
    }

    public void k2() {
        n2();
    }

    public final g5.c k3() {
        return (g5.c) this.f6095u.getValue();
    }

    /* renamed from: l3 */
    public j0 S2() {
        j0 j0Var = this.A;
        if (j0Var != null) {
            return j0Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void m3() {
        if (!S2().O("google", this.f6087m)) {
            if (this.f6094t == null) {
                w7.a aVar = w7.a.f19762a;
                String string = getResources().getString(R.string.server_client_id);
                t9.i.f(string, "resources.getString(R.string.server_client_id)");
                z7.b a10 = aVar.a(this, 1, string);
                this.f6094t = a10;
                if (a10 != null) {
                    a10.b(this);
                }
            }
            z7.b bVar = this.f6094t;
            if (bVar != null) {
                bVar.d(this);
            }
        }
    }

    public void n(int i10) {
        f1.a aVar = f1.f12517a;
        String string = getResources().getString(i10);
        t9.i.f(string, "resources.getString(strResId)");
        aVar.x(string);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        H3(r0.getUserName(), r0.getAreaCode());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0083, code lost:
        D3(false, r0.getUserName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n3() {
        /*
            r4 = this;
            android.content.Intent r0 = r4.getIntent()
            java.lang.String r1 = "extra_fill_account"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)
            if (r0 == 0) goto L_0x00a0
            boolean r1 = r0 instanceof com.mobile.brasiltv.db.SwitchAccountBean
            if (r1 == 0) goto L_0x00a0
            com.mobile.brasiltv.db.SwitchAccountBean r0 = (com.mobile.brasiltv.db.SwitchAccountBean) r0
            java.lang.String r1 = r0.getAccountType()
            int r2 = r1.hashCode()
            r3 = -1240244679(0xffffffffb6135e39, float:-2.1959552E-6)
            if (r2 == r3) goto L_0x008c
            switch(r2) {
                case 49: goto L_0x007a;
                case 50: goto L_0x0068;
                case 51: goto L_0x0053;
                case 52: goto L_0x003e;
                case 53: goto L_0x0035;
                case 54: goto L_0x002b;
                case 55: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x00a0
        L_0x0024:
            java.lang.String r0 = "7"
            r1.equals(r0)
            goto L_0x00a0
        L_0x002b:
            java.lang.String r2 = "6"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0083
            goto L_0x00a0
        L_0x0035:
            java.lang.String r2 = "5"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0047
            goto L_0x00a0
        L_0x003e:
            java.lang.String r2 = "4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0047
            goto L_0x00a0
        L_0x0047:
            java.lang.String r1 = r0.getUserName()
            java.lang.String r0 = r0.getAreaCode()
            r4.H3(r1, r0)
            goto L_0x00a0
        L_0x0053:
            java.lang.String r2 = "3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x005c
            goto L_0x00a0
        L_0x005c:
            java.lang.String r1 = r0.getUserName()
            java.lang.String r0 = r0.getAreaCode()
            r4.E3(r1, r0)
            goto L_0x00a0
        L_0x0068:
            java.lang.String r2 = "2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0071
            goto L_0x00a0
        L_0x0071:
            r1 = 1
            java.lang.String r0 = r0.getUserName()
            r4.D3(r1, r0)
            goto L_0x00a0
        L_0x007a:
            java.lang.String r2 = "1"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0083
            goto L_0x00a0
        L_0x0083:
            r1 = 0
            java.lang.String r0 = r0.getUserName()
            r4.D3(r1, r0)
            goto L_0x00a0
        L_0x008c:
            java.lang.String r0 = "google"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0095
            goto L_0x00a0
        L_0x0095:
            a6.f r0 = a6.f.f10686a
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x00a0
            r4.m3()
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.mine.activity.LoginAty.n3():void");
    }

    public final void o3() {
        ((TitleBarView) d3(R$id.mTbvBackTitle)).setOnBackClickListener(new g0(this));
        ((AutoLinearLayout) d3(R$id.mLayoutTabQuickLogin)).setOnClickListener(new h0(this));
        ((AutoLinearLayout) d3(R$id.mLayoutTabLogin)).setOnClickListener(new i0(this));
        ((AutoLinearLayout) d3(R$id.mAllPrivacyPolicy)).setOnClickListener(new e6.j0(this));
        ((TextView) d3(R$id.mTvLogin)).setOnClickListener(new k0(this));
        ((AutoLinearLayout) d3(R$id.mLlGoogleLogin)).setOnClickListener(new l0(this));
        ((TextView) d3(R$id.mTvForgetPwd)).setOnClickListener(new m0(this));
        ((TextView) d3(R$id.mTvEncounterProblem)).setOnClickListener(new n0(this));
        ((AccountEditView) d3(R$id.mAevAccount)).setAccountEditCallback(new e(this));
        ((PasswordEditView) d3(R$id.mPevPassword)).setPwdEditCallback(new b(this));
        k3().f(new c(this));
    }

    public void onAccountLogin(SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "account");
        S2().S(switchAccountBean);
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        String str;
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1001 && i11 == SelectNationAty.f12129p.a()) {
            this.f6089o = true;
            String str2 = null;
            if (intent != null) {
                str = intent.getStringExtra("register_nation");
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = str3;
            }
            this.f6090p = str;
            if (intent != null) {
                str2 = intent.getStringExtra("register_code");
            }
            if (str2 != null) {
                str3 = str2;
            }
            this.f6091q = str3;
            ILoginPanel iLoginPanel = this.f6093s;
            if (iLoginPanel != null) {
                iLoginPanel.updateAreaInfo(this.f6090p, str3);
            }
        }
        z7.b bVar = this.f6094t;
        if (bVar != null) {
            bVar.e(i10, i11, intent);
        }
    }

    public void onBackPressed() {
        ILoginPanel iLoginPanel = this.f6093s;
        if (iLoginPanel == null || (iLoginPanel instanceof QuickLoginPanel)) {
            if (this.f6086l) {
                super.onBackPressed();
            }
            if (D) {
                b0.c0(this, ForceChangePwdAty.class);
                D = false;
            }
        } else if (iLoginPanel != null) {
            iLoginPanel.closeLoginPanel();
        }
    }

    public void onBindThirdPart(String str, String str2, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        s.a.a(S2(), str, aVar, "2", str2, this.f6087m, (String) null, 32, (Object) null);
    }

    public void onClickCreateNewAccount(String str, String str2, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        new CreateNewAccountDialog(this, str, str2, aVar).setCreateNewAccountCallback(this).show();
    }

    public void onClosePanel() {
        if (this.f6093s != null) {
            ILoginPanel iLoginPanel = this.f6093s;
            t9.i.e(iLoginPanel, "null cannot be cast to non-null type android.view.View");
            ((AutoFrameLayout) d3(R$id.mLoginRoot)).removeView((View) iLoginPanel);
            this.f6093s = null;
        }
    }

    public void onCreateNewAccount(String str, String str2, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        s.a.a(S2(), str, aVar, "1", str2, this.f6087m, (String) null, 32, (Object) null);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onForgetPwd() {
        b0.d0(this, ResetAty.class, new h(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        B3(1);
        H3(r5.getUserName(), r5.getAreaCode());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0081, code lost:
        B3(1);
        D3(false, r5.getUserName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLoginExpired(com.mobile.brasiltv.db.SwitchAccountBean r5) {
        /*
            r4 = this;
            java.lang.String r0 = "account"
            t9.i.g(r5, r0)
            java.lang.String r0 = r5.getAccountType()
            int r1 = r0.hashCode()
            r2 = -1240244679(0xffffffffb6135e39, float:-2.1959552E-6)
            r3 = 1
            if (r1 == r2) goto L_0x008d
            switch(r1) {
                case 49: goto L_0x0078;
                case 50: goto L_0x0064;
                case 51: goto L_0x004c;
                case 52: goto L_0x0033;
                case 53: goto L_0x0029;
                case 54: goto L_0x001f;
                case 55: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x00af
        L_0x0018:
            java.lang.String r5 = "7"
            r0.equals(r5)
            goto L_0x00af
        L_0x001f:
            java.lang.String r1 = "6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0081
            goto L_0x00af
        L_0x0029:
            java.lang.String r1 = "5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003d
            goto L_0x00af
        L_0x0033:
            java.lang.String r1 = "4"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003d
            goto L_0x00af
        L_0x003d:
            r4.B3(r3)
            java.lang.String r0 = r5.getUserName()
            java.lang.String r5 = r5.getAreaCode()
            r4.H3(r0, r5)
            goto L_0x00af
        L_0x004c:
            java.lang.String r1 = "3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0055
            goto L_0x00af
        L_0x0055:
            r4.B3(r3)
            java.lang.String r0 = r5.getUserName()
            java.lang.String r5 = r5.getAreaCode()
            r4.E3(r0, r5)
            goto L_0x00af
        L_0x0064:
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006d
            goto L_0x00af
        L_0x006d:
            r4.B3(r3)
            java.lang.String r5 = r5.getUserName()
            r4.D3(r3, r5)
            goto L_0x00af
        L_0x0078:
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0081
            goto L_0x00af
        L_0x0081:
            r4.B3(r3)
            r0 = 0
            java.lang.String r5 = r5.getUserName()
            r4.D3(r0, r5)
            goto L_0x00af
        L_0x008d:
            java.lang.String r5 = "google"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0096
            goto L_0x00af
        L_0x0096:
            a6.f r5 = a6.f.f10686a
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x00af
            r4.B3(r3)
            d6.b r5 = d6.b.f6366a
            android.content.Context r0 = r4.Q1()
            java.lang.String r1 = ""
            r5.I(r0, r1, r1)
            r4.m3()
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.mine.activity.LoginAty.onLoginExpired(com.mobile.brasiltv.db.SwitchAccountBean):void");
    }

    public void onMobileLogin(String str, String str2, String str3, String str4) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "mobile");
        t9.i.g(str4, "password");
        b0.F(this);
        S2().R(str3, str4, str, str2, this.f6087m);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        BlackListDialog L2 = L2();
        if (L2 != null) {
            L2.dismiss();
        }
        ILoginPanel iLoginPanel = this.f6093s;
        if (iLoginPanel == null) {
            x3();
        } else if (iLoginPanel != null) {
            iLoginPanel.closeLoginPanel();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onPickArea() {
        b0.e0(this, SelectNationAty.class, 1001);
    }

    public void onRemoveAccount(int i10, SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "account");
        S2().T(switchAccountBean);
    }

    public void onResume() {
        super.onResume();
    }

    public void onSendSms(String str, String str2, String str3) {
        t9.i.g(str, "mobile");
        t9.i.g(str2, "area");
        t9.i.g(str3, "areaCode");
        b0.F(this);
        S2().C(str, str2, str3);
    }

    public void onSmsLogin(String str, String str2, String str3, String str4) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "mobile");
        t9.i.g(str4, "verifyCode");
        b0.F(this);
        S2().b0(str3, str4, str, str2, this.f6087m);
    }

    public void onUseMobileLogin() {
        F3(this, (String) null, (String) null, 3, (Object) null);
    }

    public void onUseSmsLogin() {
        I3(this, (String) null, (String) null, 3, (Object) null);
    }

    public void p1(int i10, y7.b bVar) {
        t9.i.g(bVar, "exception");
        if (bVar.a()) {
            n(R.string.timeout_and_use_other_login);
        } else if (bVar.b()) {
            String string = getResources().getString(R.string.g_unsupport_google_service);
            t9.i.f(string, "resources.getString(R.st…unsupport_google_service)");
            z0(string);
        }
    }

    public void q() {
        z7.b bVar = this.f6094t;
        if (bVar != null) {
            bVar.f(this);
        }
    }

    public void r0() {
        if (this.f6088n) {
            S2().Q();
        }
    }

    @xa.j
    public final void receiveSelectTabEvent(SetLoginAtySelectTabEvent setLoginAtySelectTabEvent) {
        t9.i.g(setLoginAtySelectTabEvent, "event");
        B3(setLoginAtySelectTabEvent.getIndex());
    }

    public void setPasswordAndBind(String str, String str2, x7.a aVar, String str3) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        t9.i.g(str3, "password");
        S2().c(str, aVar, "4", str2, this.f6087m, str3);
    }

    public void showLoading(boolean z10) {
        if (this.f6092r == null) {
            this.f6092r = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new f0(this), 6, (Object) null);
            h9.t tVar = h9.t.f17319a;
        }
        if (z10) {
            LoadingView loadingView = this.f6092r;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f6092r;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }

    public void v0(ArrayList arrayList) {
        t9.i.g(arrayList, "list");
        if (!arrayList.isEmpty()) {
            ((AutoLinearLayout) d3(R$id.mLayoutTab)).setVisibility(0);
            B3(0);
        } else {
            ((AutoLinearLayout) d3(R$id.mLayoutTab)).setVisibility(8);
            B3(1);
        }
        ILoginPanel iLoginPanel = this.f6093s;
        if (iLoginPanel instanceof QuickLoginPanel) {
            t9.i.e(iLoginPanel, "null cannot be cast to non-null type com.mobile.brasiltv.view.login.QuickLoginPanel");
            ((QuickLoginPanel) iLoginPanel).attachDataToView(arrayList);
        }
    }

    public final void x3() {
        int i10;
        int i11 = R$id.mRvCompleteList;
        ((RecyclerView) d3(i11)).setLayoutManager(new LinearLayoutManagerWrapper(Q1()));
        ((RecyclerView) d3(i11)).setAdapter(k3());
        x.f12622a.w(Q1(), new f(this));
        this.f6086l = getIntent().getBooleanExtra("can_back", true);
        this.f6087m = getIntent().getBooleanExtra("success_to_main", false);
        this.f6088n = getIntent().getBooleanExtra("extra_login_out", false);
        TitleBarView titleBarView = (TitleBarView) d3(R$id.mTbvBackTitle);
        if (this.f6086l) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        titleBarView.setBackVisibility(i10);
        if (!a6.f.f10686a.a()) {
            ((AutoLinearLayout) d3(R$id.mLlGoogleLogin)).setVisibility(8);
        }
        if (s6.a.f9335a.a().u()) {
            d6.b bVar = d6.b.f6366a;
            if (b0.K(bVar.l())) {
                bVar.y();
            }
        }
        int i12 = R$id.mTvForgetPwd;
        ((TextView) d3(i12)).getPaint().setFlags(8);
        ((TextView) d3(i12)).getPaint().setAntiAlias(true);
        int i13 = R$id.mTvPrivacyPolicy;
        ((TextView) d3(i13)).getPaint().setFlags(8);
        ((TextView) d3(i13)).getPaint().setAntiAlias(true);
        int i14 = R$id.mTvEncounterProblem;
        ((TextView) d3(i14)).getPaint().setFlags(8);
        ((TextView) d3(i14)).getPaint().setAntiAlias(true);
        z zVar = z.f19601a;
        String string = getResources().getString(R.string.current_device_id);
        t9.i.f(string, "this.resources.getString…string.current_device_id)");
        String format = String.format(string, Arrays.copyOf(new Object[]{w6.i.f9510g.l()}, 1));
        t9.i.f(format, "format(format, *args)");
        ((TextView) d3(R$id.mTvDeviceInfo)).setText(Html.fromHtml(format));
        B3(1);
        n3();
    }

    public final void y3(String str) {
        if (!TextUtils.isEmpty(str) && ba.t.o(str, "@", false, 2, (Object) null)) {
            String str2 = str;
            if (ba.t.y(str2, "@", 0, false, 6, (Object) null) == ba.t.D(str2, "@", 0, false, 6, (Object) null)) {
                if (this.f6099y.size() == 0) {
                    this.f6099y.add("@gmail.com");
                }
                if (ba.s.e(str, "@", false, 2, (Object) null)) {
                    g5.c k32 = k3();
                    String substring = str.substring(0, str.length() - 1);
                    t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    k32.g(substring);
                    k3().e(this.f6099y);
                    ((RecyclerView) d3(R$id.mRvCompleteList)).setVisibility(0);
                    ((MaxHeightLinearLayout) d3(R$id.mLlRecyEmail)).setVisibility(0);
                    return;
                }
                String lowerCase = str.toLowerCase();
                t9.i.f(lowerCase, "this as java.lang.String).toLowerCase()");
                String[] strArr = (String[]) ba.t.M(lowerCase, new String[]{"@"}, false, 0, 6, (Object) null).toArray(new String[0]);
                String str3 = '@' + strArr[1];
                int size = this.f6099y.size();
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj = this.f6099y.get(i10);
                    t9.i.f(obj, "mEmailSuffixList[i]");
                    String str4 = (String) obj;
                    String lowerCase2 = str4.toLowerCase();
                    t9.i.f(lowerCase2, "this as java.lang.String).toLowerCase()");
                    if (ba.s.l(lowerCase2, str3, false, 2, (Object) null)) {
                        arrayList.add(str4);
                    }
                }
                if (arrayList.isEmpty()) {
                    ((RecyclerView) d3(R$id.mRvCompleteList)).setVisibility(8);
                    ((MaxHeightLinearLayout) d3(R$id.mLlRecyEmail)).setVisibility(8);
                    return;
                }
                k3().g(strArr[0]);
                k3().e(arrayList);
                int i11 = R$id.mRvCompleteList;
                ((RecyclerView) d3(i11)).setBackgroundDrawable(Q1().getResources().getDrawable(R.drawable.bg_associate_email));
                ((RecyclerView) d3(i11)).setVisibility(0);
                ((MaxHeightLinearLayout) d3(R$id.mLlRecyEmail)).setVisibility(0);
                return;
            }
        }
        ((RecyclerView) d3(R$id.mRvCompleteList)).setVisibility(8);
        ((MaxHeightLinearLayout) d3(R$id.mLlRecyEmail)).setVisibility(8);
    }

    public final void z3() {
        int i10 = R$id.mLoginRoot;
        View findViewById = ((AutoFrameLayout) d3(i10)).findViewById(R.id.other_login_panel);
        if (findViewById != null) {
            ((AutoFrameLayout) d3(i10)).removeView(findViewById);
        }
    }

    public void onAccountLogin(String str, String str2) {
        t9.i.g(str, "account");
        t9.i.g(str2, "password");
        b0.F(this);
        S2().v(str, str2, this.f6087m);
    }
}
