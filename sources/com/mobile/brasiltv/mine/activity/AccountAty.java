package com.mobile.brasiltv.mine.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import ba.t;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.EmailManagerAty;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.CancelFreezeAtyEvent;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.bean.event.ClosePageEvent;
import com.mobile.brasiltv.bean.event.RefreshAccountEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.k;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.dialog.CommonAlertDialog;
import com.mobile.brasiltv.view.dialog.ICommonAlertCallback;
import com.mobile.brasiltv.view.dialog.InputPwdDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import e6.h;
import i6.e;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.f;
import mobile.com.requestframe.utils.response.UserBindData;
import mobile.com.requestframe.utils.response.UserBindResult;
import org.greenrobot.eventbus.ThreadMode;
import t9.g;
import t9.i;
import t9.j;
import w6.i;

public final class AccountAty extends f5.d implements e, z7.a {

    /* renamed from: q  reason: collision with root package name */
    public static final a f6059q = new a((g) null);

    /* renamed from: l  reason: collision with root package name */
    public boolean f6060l;

    /* renamed from: m  reason: collision with root package name */
    public z7.b f6061m;

    /* renamed from: n  reason: collision with root package name */
    public InputPwdDialog f6062n;

    /* renamed from: o  reason: collision with root package name */
    public f f6063o;

    /* renamed from: p  reason: collision with root package name */
    public Map f6064p = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b implements ICommonAlertCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountAty f12274a;

        public b(AccountAty accountAty) {
            this.f12274a = accountAty;
        }

        public void onCancel(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
        }

        public void onConfirm(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
            b0.c0(this.f12274a, EmailAty.class);
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountAty f12275a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AccountAty accountAty) {
            super(0);
            this.f12275a = accountAty;
        }

        public final void invoke() {
            b0.F(this.f12275a);
            InputPwdDialog c32 = this.f12275a.f6062n;
            if (!j1.f(c32 != null ? c32.getPwd() : null)) {
                this.f12275a.r2(R.string.password_format_incorrect);
            } else {
                this.f12275a.A3();
            }
        }
    }

    public static final class d implements ICommonAlertCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountAty f12276a;

        public d(AccountAty accountAty) {
            this.f12276a = accountAty;
        }

        public void onCancel(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
        }

        public void onConfirm(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
            this.f12276a.u3();
        }
    }

    public static final void g3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        accountAty.n3();
    }

    public static final void h3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        b0.c0(accountAty, ChangePwdAty.class);
    }

    public static final void i3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        if (b0.T(w6.i.f9510g.i(), "1")) {
            accountAty.z3();
        } else {
            accountAty.f3();
        }
    }

    public static final void j3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        b0.c0(accountAty, AccountSwitchAty.class);
    }

    public static final void k3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        if (d6.b.f6366a.t()) {
            b0.c0(accountAty, LoginAty.class);
            return;
        }
        f m32 = accountAty.S2();
        MemberInfo memberInfo = MemberInfo.INSTANCE;
        m32.y(memberInfo.getLastUserName(), memberInfo.getLastPassword(), "0");
    }

    public static final void l3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        if (!accountAty.f6060l) {
            accountAty.finish();
        }
    }

    public static final void v3(AccountAty accountAty, DialogInterface dialogInterface) {
        i.g(accountAty, "this$0");
        accountAty.f6062n = null;
    }

    public final void A3() {
        String str;
        f m32 = S2();
        InputPwdDialog inputPwdDialog = this.f6062n;
        if (inputPwdDialog == null || (str = inputPwdDialog.getPwd()) == null) {
            str = "";
        }
        m32.z(str);
    }

    public final void B3() {
        String j10 = d6.b.f6366a.j(Q1());
        String lastUserName = MemberInfo.INSTANCE.getLastUserName();
        if (i.b(j10, CdnType.DIGITAL_TYPE_PEERSTAR)) {
            ((TextView) b3(R$id.mTextAccount)).setText(lastUserName);
            ((TextView) b3(R$id.mTextAccountDesc)).setText(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + w6.i.f9510g.H() + ASCIIPropertyListParser.ARRAY_END_TOKEN);
            return;
        }
        ((TextView) b3(R$id.mTextAccount)).setText(w6.i.f9510g.H());
        ((TextView) b3(R$id.mTextAccountDesc)).setText("");
    }

    public void M() {
        x3();
    }

    public void O() {
        InputPwdDialog inputPwdDialog = this.f6062n;
        if (inputPwdDialog != null) {
            inputPwdDialog.dismiss();
        }
    }

    public void R2() {
        q3(new f(this, this));
        p3();
        ((AutoRelativeLayout) b3(R$id.mLayoutEmail)).setOnClickListener(new e6.b(this));
        ((AutoRelativeLayout) b3(R$id.mLayoutChangePwd)).setOnClickListener(new e6.c(this));
        ((TextView) b3(R$id.mTvGoogleBindOrUnbind)).setOnClickListener(new e6.d(this));
        ((TextView) b3(R$id.mTvSwitchAccount)).setOnClickListener(new e6.e(this));
        ((TextView) b3(R$id.mTvLoginOrLogout)).setOnClickListener(new e6.f(this));
        ((TitleView) b3(R$id.title_view)).setOnBackClickListener(new e6.g(this));
    }

    public void S0(int i10, x7.a aVar) {
        String str;
        i.g(aVar, "info");
        if (i10 == 1) {
            str = "google";
        } else {
            str = "facebook";
        }
        S2().n(str, aVar);
    }

    public int T2() {
        return R.layout.aty_account;
    }

    public void U0() {
        k.f12594a.a();
        ((TextView) b3(R$id.mTvLoginOrLogout)).setText(getResources().getString(R.string.am_login_other_account));
    }

    public void X1(UserBindResult userBindResult) {
        String str;
        i.g(userBindResult, "userBindResult");
        UserBindData data = userBindResult.getData();
        String str2 = null;
        if (data != null) {
            str = data.getEmail();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            ((TextView) b3(R$id.mTextEmail)).setText(getResources().getString(R.string.not_linked));
        } else {
            TextView textView = (TextView) b3(R$id.mTextEmail);
            UserBindData data2 = userBindResult.getData();
            if (data2 != null) {
                str2 = data2.getEmail();
            }
            textView.setText(str2);
        }
        t3();
    }

    public View b3(int i10) {
        Map map = this.f6064p;
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
    public final void closePage(CloseBindEmailSucEvent closeBindEmailSucEvent) {
        i.g(closeBindEmailSucEvent, "event");
        finish();
    }

    public final void f3() {
        d6.b bVar = d6.b.f6366a;
        if (bVar.b() || bVar.d()) {
            w3();
        } else {
            s3();
        }
    }

    public void k2() {
        n2();
    }

    /* renamed from: m3 */
    public f S2() {
        f fVar = this.f6063o;
        if (fVar != null) {
            return fVar;
        }
        i.w("mPresenter");
        return null;
    }

    public void n(int i10) {
        String string = getResources().getString(i10);
        i.f(string, "resources.getString(resId)");
        z0(string);
    }

    public final void n3() {
        if (b0.T(w6.i.f9510g.h(), "0")) {
            b0.c0(this, EmailAty.class);
        } else {
            b0.c0(this, EmailManagerAty.class);
        }
    }

    public final void o3() {
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        z7.b bVar = this.f6061m;
        if (bVar != null) {
            bVar.e(i10, i11, intent);
        }
    }

    public void onBackPressed() {
        if (!this.f6060l) {
            super.onBackPressed();
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onCancelFreeze(CancelFreezeAtyEvent cancelFreezeAtyEvent) {
        i.g(cancelFreezeAtyEvent, "event");
        J2();
        showLoading(false);
        finish();
    }

    @xa.j
    public final void onEventMainThread(ClosePageEvent closePageEvent) {
        i.g(closePageEvent, "closePageEvent");
        finish();
    }

    public void onStart() {
        super.onStart();
        S2().o();
    }

    public void p1(int i10, y7.b bVar) {
        i.g(bVar, "exception");
        if (bVar.a()) {
            String string = getResources().getString(R.string.timeout_and_use_other_login);
            i.f(string, "resources.getString(R.st…eout_and_use_other_login)");
            z0(string);
        } else if (bVar.b()) {
            String string2 = getResources().getString(R.string.g_unsupport_google_service);
            i.f(string2, "resources.getString(R.st…unsupport_google_service)");
            z0(string2);
        }
    }

    public final void p3() {
        String str;
        B3();
        TextView textView = (TextView) b3(R$id.mTextEmail);
        i.c cVar = w6.i.f9510g;
        if (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.m(), "")) {
            str = getResources().getString(R.string.not_linked);
        } else {
            StringBuilder sb = new StringBuilder();
            String substring = cVar.m().substring(0, t.y(cVar.m(), "@", 0, false, 6, (Object) null) - 3);
            t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("***");
            String substring2 = cVar.m().substring(t.y(cVar.m(), "@", 0, false, 6, (Object) null));
            t9.i.f(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            str = sb.toString();
        }
        textView.setText(str);
        if (!a6.f.f10686a.a()) {
            ((AutoLinearLayout) b3(R$id.mLayoutGoogle)).setVisibility(8);
        }
        o3();
        t3();
        x3();
        y3();
    }

    public void q() {
        z7.b bVar = this.f6061m;
        if (bVar != null) {
            bVar.f(this);
        }
    }

    public void q3(f fVar) {
        t9.i.g(fVar, "<set-?>");
        this.f6063o = fVar;
    }

    public void r2(int i10) {
        InputPwdDialog inputPwdDialog = this.f6062n;
        if (inputPwdDialog != null) {
            String string = getResources().getString(i10);
            t9.i.f(string, "resources.getString(resId)");
            inputPwdDialog.setErrorHint(string);
        }
    }

    /* renamed from: r3 */
    public void Y0(i6.d dVar) {
        t9.i.g(dVar, "presenter");
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void refreshData(RefreshAccountEvent refreshAccountEvent) {
        t9.i.g(refreshAccountEvent, "event");
        p3();
        S2().o();
    }

    public final void s3() {
        String string = getResources().getString(R.string.am_dialog_bind_before_unbind);
        t9.i.f(string, "resources.getString(R.st…ialog_bind_before_unbind)");
        String string2 = getResources().getString(R.string.cancel);
        t9.i.f(string2, "resources.getString(R.string.cancel)");
        String string3 = getResources().getString(R.string.am_dialog_goto_bind);
        t9.i.f(string3, "resources.getString(R.string.am_dialog_goto_bind)");
        new CommonAlertDialog(this, string, string2, string3).setCommonAlertCallback(new b(this)).show();
    }

    public void showLoading(boolean z10) {
        int i10;
        ProgressBar progressBar = (ProgressBar) b3(R$id.mLoadingPbar);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        progressBar.setVisibility(i10);
    }

    public void t(boolean z10) {
        ((AutoRelativeLayout) b3(R$id.mLayoutEmail)).setClickable(!z10);
        ((AutoRelativeLayout) b3(R$id.mLayoutChangePwd)).setClickable(!z10);
        ((TextView) b3(R$id.mTvLoginOrLogout)).setClickable(!z10);
        this.f6060l = z10;
    }

    public final void t3() {
        int i10;
        AutoRelativeLayout autoRelativeLayout = (AutoRelativeLayout) b3(R$id.mLayoutChangePwd);
        if (d6.b.f6366a.w() || t9.i.b(w6.i.f9510g.s(), "0")) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        autoRelativeLayout.setVisibility(i10);
    }

    public void u2() {
        i.c cVar = w6.i.f9510g;
        if (cVar.h().equals("1")) {
            int i10 = R$id.mTextEmail;
            ((TextView) b3(i10)).setText(cVar.m());
            StringBuilder sb = new StringBuilder();
            String substring = cVar.m().substring(0, t.y(cVar.m(), "@", 0, false, 6, (Object) null) - 3);
            t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("***");
            String substring2 = cVar.m().substring(t.y(cVar.m(), "@", 0, false, 6, (Object) null));
            t9.i.f(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            ((TextView) b3(i10)).setText(sb.toString());
            return;
        }
        ((TextView) b3(R$id.mTextEmail)).setText(getResources().getString(R.string.not_linked));
    }

    public final void u3() {
        if (this.f6062n == null) {
            InputPwdDialog inputPwdDialog = new InputPwdDialog(this);
            this.f6062n = inputPwdDialog;
            inputPwdDialog.setConfirmCallback(new c(this));
            InputPwdDialog inputPwdDialog2 = this.f6062n;
            if (inputPwdDialog2 != null) {
                inputPwdDialog2.setOnDismissListener(new h(this));
            }
        }
        InputPwdDialog inputPwdDialog3 = this.f6062n;
        if (inputPwdDialog3 != null) {
            inputPwdDialog3.show();
        }
    }

    public final void w3() {
        String string = getResources().getString(R.string.am_dialog_not_login_after_unbind, new Object[]{w6.i.f9510g.p()});
        t9.i.f(string, "resources.getString(R.st…alService.googleNickName)");
        String string2 = getResources().getString(R.string.cancel);
        t9.i.f(string2, "resources.getString(R.string.cancel)");
        String string3 = getResources().getString(R.string.am_dialog_confirm_unbind);
        t9.i.f(string3, "resources.getString(R.st…am_dialog_confirm_unbind)");
        new CommonAlertDialog(this, string, string2, string3).setCommonAlertCallback(new d(this)).show();
    }

    public final void x3() {
        i.c cVar = w6.i.f9510g;
        if (b0.T(cVar.i(), "1")) {
            ((TextView) b3(R$id.mTvGoogleBindOrUnbind)).setText(getResources().getString(R.string.am_to_bind));
            ((TextView) b3(R$id.mTvGoogleNick)).setText("");
            return;
        }
        ((TextView) b3(R$id.mTvGoogleBindOrUnbind)).setText(getResources().getString(R.string.am_to_unbind));
        ((TextView) b3(R$id.mTvGoogleNick)).setText(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + cVar.p() + ASCIIPropertyListParser.ARRAY_END_TOKEN);
    }

    public final void y3() {
        if (d6.b.f6366a.t()) {
            ((TextView) b3(R$id.mTvLoginOrLogout)).setText(getResources().getString(R.string.am_login_other_account));
        } else {
            ((TextView) b3(R$id.mTvLoginOrLogout)).setText(getResources().getString(R.string.login_out));
        }
    }

    public final void z3() {
        if (!a6.f.f10686a.a()) {
            n(R.string.try_other_bind_method);
            return;
        }
        if (this.f6061m == null) {
            w7.a aVar = w7.a.f19762a;
            String string = getResources().getString(R.string.server_client_id);
            t9.i.f(string, "resources.getString(R.string.server_client_id)");
            z7.b a10 = aVar.a(this, 1, string);
            this.f6061m = a10;
            if (a10 != null) {
                a10.b(this);
            }
        }
        z7.b bVar = this.f6061m;
        if (bVar != null) {
            bVar.d(this);
        }
    }
}
