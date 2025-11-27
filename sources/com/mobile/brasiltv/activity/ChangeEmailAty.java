package com.mobile.brasiltv.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.MaxHeightLinearLayout;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.dialog.CommTipsDialog;
import com.mobile.brasiltv.view.input.CustomInputView;
import com.mobile.brasiltv.view.login.IVerifyCodeCallback;
import com.mobile.brasiltv.view.login.VerifyCodeView;
import com.msandroid.mobile.R;
import f5.a0;
import f5.y;
import f5.z;
import g5.c;
import h9.g;
import h9.h;
import i6.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k6.t;
import s9.l;
import t9.i;
import t9.j;

public final class ChangeEmailAty extends f5.d implements k {

    /* renamed from: l  reason: collision with root package name */
    public boolean f5917l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f5918m;

    /* renamed from: n  reason: collision with root package name */
    public LoadingView f5919n;

    /* renamed from: o  reason: collision with root package name */
    public t f5920o;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList f5921p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public String f5922q = "@gmail.com";

    /* renamed from: r  reason: collision with root package name */
    public final g f5923r = h.b(new e(this));

    /* renamed from: s  reason: collision with root package name */
    public Map f5924s = new LinkedHashMap();

    public static final class a implements CustomInputView.IEmailPrefixInputCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangeEmailAty f11976a;

        public a(ChangeEmailAty changeEmailAty) {
            this.f11976a = changeEmailAty;
        }

        public void onInputFocused() {
            this.f11976a.l3();
        }

        public void onTextChanged(boolean z10) {
            this.f11976a.f5917l = z10;
            ((VerifyCodeView) this.f11976a.Y2(R$id.mVcvVerifyCode)).setSendEnabled(this.f11976a.f5917l);
            this.f11976a.r3();
            ChangeEmailAty changeEmailAty = this.f11976a;
            changeEmailAty.m3(((CustomInputView) changeEmailAty.Y2(R$id.mEpiEmail)).getInputText());
        }
    }

    public static final class b implements IVerifyCodeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangeEmailAty f11977a;

        public b(ChangeEmailAty changeEmailAty) {
            this.f11977a = changeEmailAty;
        }

        public void onSendSms() {
            boolean z10;
            String str;
            x xVar = x.f12622a;
            ChangeEmailAty changeEmailAty = this.f11977a;
            int i10 = R$id.mEpiEmail;
            String p10 = xVar.p(((CustomInputView) changeEmailAty.Y2(i10)).getInputText());
            if (p10 == null || p10.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                ((CustomInputView) this.f11977a.Y2(i10)).setInputText(((CustomInputView) this.f11977a.Y2(i10)).getInputText() + this.f11977a.i3());
            }
            String inputText = ((CustomInputView) this.f11977a.Y2(i10)).getInputText();
            Locale locale = Locale.getDefault();
            i.f(locale, "getDefault()");
            String lowerCase = inputText.toLowerCase(locale);
            i.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String v10 = xVar.v(this.f11977a.Q1());
            if (v10 != null) {
                Locale locale2 = Locale.getDefault();
                i.f(locale2, "getDefault()");
                str = v10.toLowerCase(locale2);
                i.f(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (i.b(lowerCase, str)) {
                this.f11977a.d(R.string.not_service_email_tips);
                return;
            }
            ((TextView) this.f11977a.Y2(R$id.mTvConfirm)).requestFocus();
            b0.F(this.f11977a);
            this.f11977a.S2().r(((CustomInputView) this.f11977a.Y2(i10)).getFullEmailText());
        }

        public void onVerifyCodeChanged(String str) {
            i.g(str, "content");
            this.f11977a.f5918m = b0.K(str);
            this.f11977a.r3();
        }
    }

    public static final class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangeEmailAty f11978a;

        public c(ChangeEmailAty changeEmailAty) {
            this.f11978a = changeEmailAty;
        }

        public void onClick(String str) {
            i.g(str, "mEmailString");
            ChangeEmailAty changeEmailAty = this.f11978a;
            int i10 = R$id.mEpiEmail;
            ((CustomInputView) changeEmailAty.Y2(i10)).setInputText(str);
            ((CustomInputView) this.f11978a.Y2(i10)).setInputSelection(str.length());
            ((RecyclerView) this.f11978a.Y2(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) this.f11978a.Y2(R$id.mLlRecyEmail)).setVisibility(8);
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangeEmailAty f11979a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f11980a = new a();

            public a() {
                super(1);
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                i.g(intent, "it");
                Intent putExtra = intent.putExtra("can_back", true);
                i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, true)");
                return putExtra;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ChangeEmailAty changeEmailAty) {
            super(1);
            this.f11979a = changeEmailAty;
        }

        public final void b(CommTipsDialog commTipsDialog) {
            i.g(commTipsDialog, "it");
            b0.d0(this.f11979a, LoginAty.class, a.f11980a);
            commTipsDialog.dismiss();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return h9.t.f17319a;
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangeEmailAty f11981a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ChangeEmailAty changeEmailAty) {
            super(0);
            this.f11981a = changeEmailAty;
        }

        public final g5.c invoke() {
            return new g5.c(this.f11981a.Q1());
        }
    }

    public static final void f3(ChangeEmailAty changeEmailAty, View view) {
        i.g(changeEmailAty, "this$0");
        changeEmailAty.finish();
    }

    public static final void g3(ChangeEmailAty changeEmailAty, View view) {
        i.g(changeEmailAty, "this$0");
        xa.c.c().j(new GotoHomeTabEvent(2));
        b0.c0(changeEmailAty, MainAty.class);
    }

    public static final void h3(ChangeEmailAty changeEmailAty, View view) {
        i.g(changeEmailAty, "this$0");
        changeEmailAty.l3();
        changeEmailAty.S2().n(((CustomInputView) changeEmailAty.Y2(R$id.mEpiEmail)).getFullEmailText(), ((VerifyCodeView) changeEmailAty.Y2(R$id.mVcvVerifyCode)).getVerifyCode());
    }

    public static final void q3(ChangeEmailAty changeEmailAty, DialogInterface dialogInterface) {
        i.g(changeEmailAty, "this$0");
        changeEmailAty.f5919n = null;
    }

    public void R2() {
        n3(new t(this, this));
        int i10 = R$id.mRvCompleteList;
        ((RecyclerView) Y2(i10)).setLayoutManager(new LinearLayoutManagerWrapper(Q1()));
        ((RecyclerView) Y2(i10)).setAdapter(j3());
        int i11 = R$id.mTbvTitle;
        ((TitleBarView) Y2(i11)).setOnBackClickListener(new f5.x(this));
        ((TitleBarView) Y2(i11)).setOnCloseClickListener(new y(this));
        int i12 = R$id.mEpiEmail;
        ((CustomInputView) Y2(i12)).setInputFilter(new b7.a());
        ((CustomInputView) Y2(i12)).setEmailPrefixInputCallback(new a(this));
        ((VerifyCodeView) Y2(R$id.mVcvVerifyCode)).setVerifyCodeCallback(new b(this));
        ((TextView) Y2(R$id.mTvConfirm)).setOnClickListener(new z(this));
        j3().f(new c(this));
        x.f12622a.v(Q1());
        o3();
    }

    public int T2() {
        return R.layout.aty_change_email;
    }

    public View Y2(int i10) {
        Map map = this.f5924s;
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

    public void b2() {
        BindEmailSucAty.f11956r.b(this);
    }

    @xa.j
    public final void closePage(CloseBindEmailSucEvent closeBindEmailSucEvent) {
        i.g(closeBindEmailSucEvent, "event");
        finish();
    }

    public void d(int i10) {
        int i11 = R$id.mTvErrorHint;
        ((TextView) Y2(i11)).setVisibility(0);
        ((TextView) Y2(i11)).setTextColor(getResources().getColor(R.color.color_f23232));
        ((TextView) Y2(i11)).setText(getResources().getString(i10));
    }

    public void e(List list) {
        i.g(list, "emailSuffixList");
        if (!list.isEmpty()) {
            this.f5921p.addAll(list);
        }
    }

    public void i() {
        p3();
        com.mobile.brasiltv.utils.k.f12594a.c("key_verifycode_bind_time", System.currentTimeMillis());
        VerifyCodeView verifyCodeView = (VerifyCodeView) Y2(R$id.mVcvVerifyCode);
        i.f(verifyCodeView, "mVcvVerifyCode");
        VerifyCodeView.startCountDown$default(verifyCodeView, 0, 1, (Object) null);
    }

    public final String i3() {
        return this.f5922q;
    }

    public void j() {
        String string = getString(R.string.email_was_bound_tips);
        i.f(string, "getString(R.string.email_was_bound_tips)");
        new CommTipsDialog(this, string, getString(R.string.input_email_tips), getString(R.string.go_to_log_in), (String) null, (String) null, new d(this), (l) null, false, 432, (t9.g) null).show();
    }

    public final g5.c j3() {
        return (g5.c) this.f5923r.getValue();
    }

    public void k2() {
        n2();
    }

    /* renamed from: k3 */
    public t S2() {
        t tVar = this.f5920o;
        if (tVar != null) {
            return tVar;
        }
        i.w("mPresenter");
        return null;
    }

    public final void l3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) Y2(i10)).setVisibility(4);
        ((TextView) Y2(i10)).setText("");
    }

    public final void m3(String str) {
        if (!TextUtils.isEmpty(str) && ba.t.o(str, "@", false, 2, (Object) null)) {
            String str2 = str;
            if (ba.t.y(str2, "@", 0, false, 6, (Object) null) == ba.t.D(str2, "@", 0, false, 6, (Object) null)) {
                if (s.e(str, "@", false, 2, (Object) null)) {
                    g5.c j32 = j3();
                    String substring = str.substring(0, str.length() - 1);
                    i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    j32.g(substring);
                    j3().e(this.f5921p);
                    ((RecyclerView) Y2(R$id.mRvCompleteList)).setVisibility(0);
                    ((MaxHeightLinearLayout) Y2(R$id.mLlRecyEmail)).setVisibility(0);
                    return;
                }
                String lowerCase = str.toLowerCase();
                i.f(lowerCase, "this as java.lang.String).toLowerCase()");
                String[] strArr = (String[]) ba.t.M(lowerCase, new String[]{"@"}, false, 0, 6, (Object) null).toArray(new String[0]);
                String str3 = '@' + strArr[1];
                int size = this.f5921p.size();
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj = this.f5921p.get(i10);
                    i.f(obj, "mEmailSuffixList[i]");
                    String str4 = (String) obj;
                    String lowerCase2 = str4.toLowerCase();
                    i.f(lowerCase2, "this as java.lang.String).toLowerCase()");
                    if (s.l(lowerCase2, str3, false, 2, (Object) null)) {
                        arrayList.add(str4);
                    }
                }
                if (arrayList.isEmpty()) {
                    ((RecyclerView) Y2(R$id.mRvCompleteList)).setVisibility(8);
                    ((MaxHeightLinearLayout) Y2(R$id.mLlRecyEmail)).setVisibility(8);
                    return;
                }
                j3().g(strArr[0]);
                j3().e(arrayList);
                int i11 = R$id.mRvCompleteList;
                ((RecyclerView) Y2(i11)).setBackgroundDrawable(Q1().getResources().getDrawable(R.drawable.bg_associate_email));
                ((RecyclerView) Y2(i11)).setVisibility(0);
                ((MaxHeightLinearLayout) Y2(R$id.mLlRecyEmail)).setVisibility(0);
                return;
            }
        }
        ((RecyclerView) Y2(R$id.mRvCompleteList)).setVisibility(8);
        ((MaxHeightLinearLayout) Y2(R$id.mLlRecyEmail)).setVisibility(8);
    }

    public void n3(t tVar) {
        i.g(tVar, "<set-?>");
        this.f5920o = tVar;
    }

    public final void o3() {
        long currentTimeMillis = ((long) 180) - ((System.currentTimeMillis() - com.mobile.brasiltv.utils.k.f12594a.b("key_verifycode_bind_time")) / ((long) 1000));
        if (currentTimeMillis > 0) {
            ((VerifyCodeView) Y2(R$id.mVcvVerifyCode)).startCountDown(currentTimeMillis);
        }
    }

    public final void p3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) Y2(i10)).setVisibility(0);
        ((TextView) Y2(i10)).setTextColor(getResources().getColor(R.color.color_ffffff));
        Resources resources = getResources();
        ((TextView) Y2(i10)).setText(Html.fromHtml(resources.getString(R.string.be_goto_email_and_view, new Object[]{"<font color=\"#3cd977\">" + ((CustomInputView) Y2(R$id.mEpiEmail)).getFullEmailText() + "</font>"})));
    }

    public final void r3() {
        boolean z10;
        TextView textView = (TextView) Y2(R$id.mTvConfirm);
        if (!this.f5917l || !this.f5918m) {
            z10 = false;
        } else {
            z10 = true;
        }
        textView.setEnabled(z10);
    }

    public void showLoading(boolean z10) {
        if (this.f5919n == null) {
            this.f5919n = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new a0(this), 6, (Object) null);
            h9.t tVar = h9.t.f17319a;
        }
        if (z10) {
            LoadingView loadingView = this.f5919n;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f5919n;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }
}
