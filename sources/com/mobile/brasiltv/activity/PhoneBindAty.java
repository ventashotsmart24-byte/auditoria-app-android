package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.k;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.input.EmailPrefixInputView;
import com.mobile.brasiltv.view.input.IEmailPrefixInputCallback;
import com.mobile.brasiltv.view.login.IVerifyCodeCallback;
import com.mobile.brasiltv.view.login.VerifyCodeView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.bt;
import com.zhy.autolayout.AutoLinearLayout;
import f5.q2;
import f5.r2;
import h9.g;
import h9.h;
import i6.c0;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.i1;
import na.f;
import t9.i;
import t9.j;

public final class PhoneBindAty extends f5.d implements c0 {
    public Map A = new LinkedHashMap();

    /* renamed from: l  reason: collision with root package name */
    public boolean f5957l;

    /* renamed from: m  reason: collision with root package name */
    public String f5958m = "Brazil";

    /* renamed from: n  reason: collision with root package name */
    public String f5959n = "55";

    /* renamed from: o  reason: collision with root package name */
    public String f5960o = "1";

    /* renamed from: p  reason: collision with root package name */
    public int f5961p = 1;

    /* renamed from: q  reason: collision with root package name */
    public Handler f5962q = new Handler();

    /* renamed from: r  reason: collision with root package name */
    public boolean f5963r;

    /* renamed from: s  reason: collision with root package name */
    public String f5964s = "1";

    /* renamed from: t  reason: collision with root package name */
    public int f5965t = 180;

    /* renamed from: u  reason: collision with root package name */
    public boolean f5966u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f5967v;

    /* renamed from: w  reason: collision with root package name */
    public final g f5968w = h.b(new d(this));

    /* renamed from: x  reason: collision with root package name */
    public Runnable f5969x = new c();

    /* renamed from: y  reason: collision with root package name */
    public Runnable f5970y = new q2(this);

    /* renamed from: z  reason: collision with root package name */
    public i1 f5971z;

    public static final class a implements IEmailPrefixInputCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneBindAty f12082a;

        public a(PhoneBindAty phoneBindAty) {
            this.f12082a = phoneBindAty;
        }

        public void onInputFocused() {
            this.f12082a.f3();
        }

        public void onTextChanged(boolean z10) {
            this.f12082a.f5966u = z10;
            ((VerifyCodeView) this.f12082a.W2(R$id.mVcvVerifyCode)).setSendEnabled(this.f12082a.f5966u);
            this.f12082a.m3();
        }
    }

    public static final class b implements IVerifyCodeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneBindAty f12083a;

        public b(PhoneBindAty phoneBindAty) {
            this.f12083a = phoneBindAty;
        }

        public void onSendSms() {
            ((TextView) this.f12083a.W2(R$id.mTvConfirm)).requestFocus();
            b0.F(this.f12083a);
            this.f12083a.S2().o(((EmailPrefixInputView) this.f12083a.W2(R$id.mEpiEmail)).getFullEmailText());
        }

        public void onVerifyCodeChanged(String str) {
            i.g(str, "content");
            this.f12083a.f5967v = b0.K(str);
            this.f12083a.m3();
        }
    }

    public static final class c implements Runnable {
        public void run() {
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneBindAty f12084a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(PhoneBindAty phoneBindAty) {
            super(0);
            this.f12084a = phoneBindAty;
        }

        /* renamed from: b */
        public final Serializable invoke() {
            return this.f12084a.getIntent().getSerializableExtra("type");
        }
    }

    public static final void d3(PhoneBindAty phoneBindAty, View view) {
        i.g(phoneBindAty, "this$0");
        phoneBindAty.f3();
        phoneBindAty.S2().k(((EmailPrefixInputView) phoneBindAty.W2(R$id.mEpiEmail)).getFullEmailText(), ((VerifyCodeView) phoneBindAty.W2(R$id.mVcvVerifyCode)).getVerifyCode());
    }

    public static final void i3(PhoneBindAty phoneBindAty) {
        i.g(phoneBindAty, "this$0");
        TextView textView = (TextView) phoneBindAty.W2(R$id.errorTx);
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void B() {
        BindEmailSucAty.f11956r.a(this);
    }

    public void K() {
        SetPwdOnBeAty.f6029q.a(this, ((EmailPrefixInputView) W2(R$id.mEpiEmail)).getFullEmailText());
    }

    public void R2() {
        j3(new i1(this, this));
        g3();
        h3();
        this.f5963r = getIntent().getBooleanExtra("toLogin", false);
        int i10 = R$id.mEpiEmail;
        ((EmailPrefixInputView) W2(i10)).setInputFilter(new b7.a());
        ((EmailPrefixInputView) W2(i10)).setEmailSuffixList(i9.j.c("@gmail.com"));
        ((EmailPrefixInputView) W2(i10)).setEmailPrefixInputCallback(new a(this));
        ((VerifyCodeView) W2(R$id.mVcvVerifyCode)).setVerifyCodeCallback(new b(this));
        ((TextView) W2(R$id.mTvConfirm)).setOnClickListener(new r2(this));
        k3();
    }

    public int T2() {
        return R.layout.activity_phonebind;
    }

    public View W2(int i10) {
        Map map = this.A;
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

    public final void c3(String str) {
        int i10 = R$id.errorTx;
        ((TextView) W2(i10)).setVisibility(8);
        if (i.b(str, "1")) {
            this.f5961p = 1;
            ((AutoLinearLayout) W2(R$id.mailBindPage)).setVisibility(8);
            ((TextView) W2(i10)).setVisibility(8);
        } else if (i.b(str, "2")) {
            this.f5961p = 2;
            ((TextView) W2(i10)).setVisibility(8);
            ((AutoLinearLayout) W2(R$id.mailBindPage)).setVisibility(0);
        }
    }

    @xa.j
    public final void closePage(CloseBindEmailSucEvent closeBindEmailSucEvent) {
        i.g(closeBindEmailSucEvent, "event");
        finish();
    }

    public void d(int i10) {
        int i11 = R$id.mTvErrorHint;
        ((TextView) W2(i11)).setVisibility(0);
        ((TextView) W2(i11)).setTextColor(getResources().getColor(R.color.color_f23232));
        ((TextView) W2(i11)).setText(getResources().getString(i10));
    }

    public void e(List list) {
        i.g(list, "emailSuffixList");
        ((EmailPrefixInputView) W2(R$id.mEpiEmail)).setEmailSuffixList(list);
    }

    /* renamed from: e3 */
    public i1 S2() {
        i1 i1Var = this.f5971z;
        if (i1Var != null) {
            return i1Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void f3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) W2(i10)).setVisibility(4);
        ((TextView) W2(i10)).setText("");
    }

    public final void g3() {
        String stringExtra = getIntent().getStringExtra("bind_from");
        if (stringExtra == null) {
            stringExtra = "1";
        }
        this.f5960o = stringExtra;
        c3("2");
    }

    public final void h3() {
        int i10 = R$id.titleView;
        ((TitleView) W2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) W2(i10)).getSettingView().setVisibility(8);
        ((TitleView) W2(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) W2(i10)).setIvMenuSrc(0);
        ((TitleView) W2(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) W2(i10)).setTvMenuText("");
    }

    public void i() {
        l3();
        k.f12594a.c("key_verifycode_bind_time", System.currentTimeMillis());
        VerifyCodeView verifyCodeView = (VerifyCodeView) W2(R$id.mVcvVerifyCode);
        i.f(verifyCodeView, "mVcvVerifyCode");
        VerifyCodeView.startCountDown$default(verifyCodeView, 0, 1, (Object) null);
    }

    public void j3(i1 i1Var) {
        i.g(i1Var, "<set-?>");
        this.f5971z = i1Var;
    }

    public void k2() {
        n2();
    }

    public final void k3() {
        long currentTimeMillis = ((long) 180) - ((System.currentTimeMillis() - k.f12594a.b("key_verifycode_bind_time")) / ((long) 1000));
        if (currentTimeMillis > 0) {
            ((VerifyCodeView) W2(R$id.mVcvVerifyCode)).startCountDown(currentTimeMillis);
        }
    }

    public final void l3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) W2(i10)).setVisibility(0);
        ((TextView) W2(i10)).setTextColor(getResources().getColor(R.color.color_ffffff));
        Resources resources = getResources();
        ((TextView) W2(i10)).setText(Html.fromHtml(resources.getString(R.string.be_goto_email_and_view, new Object[]{"<font color=\"#3cd977\">" + ((EmailPrefixInputView) W2(R$id.mEpiEmail)).getFullEmailText() + "</font>"})));
    }

    public final void m3() {
        boolean z10;
        TextView textView = (TextView) W2(R$id.mTvConfirm);
        if (!this.f5966u || !this.f5967v) {
            z10 = false;
        } else {
            z10 = true;
        }
        textView.setEnabled(z10);
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        String str;
        super.onActivityResult(i10, i11, intent);
        if (i11 == SelectNationAty.f12129p.a() && i10 == 1002) {
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
            this.f5958m = str;
            if (intent != null) {
                str2 = intent.getStringExtra("register_code");
            }
            if (str2 != null) {
                str3 = str2;
            }
            this.f5959n = str3;
            f.k(this, "login_area_code", str3);
            this.f5957l = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        S2().i();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5962q.removeCallbacks(this.f5969x);
        this.f5962q.removeCallbacks(this.f5970y);
    }

    public void showLoading(boolean z10) {
        int i10;
        ProgressBar progressBar = (ProgressBar) W2(R$id.mLoadingPbar);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        progressBar.setVisibility(i10);
    }

    public void v(String str, String str2) {
        i.g(str, "areaCode");
        i.g(str2, bt.O);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !this.f5957l) {
            this.f5959n = str;
            this.f5958m = str2;
        }
    }
}
