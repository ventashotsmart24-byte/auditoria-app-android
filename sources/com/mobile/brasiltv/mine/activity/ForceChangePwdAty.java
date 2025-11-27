package com.mobile.brasiltv.mine.activity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import b6.z;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import e6.a0;
import java.util.LinkedHashMap;
import java.util.Map;
import ma.m;
import mobile.com.requestframe.utils.response.UpdatePwdResult;
import s9.l;
import t9.i;
import t9.j;
import t9.w;
import w6.i;

public final class ForceChangePwdAty extends f5.c implements s5.b {

    /* renamed from: k  reason: collision with root package name */
    public final s5.a f6082k = new s5.a();

    /* renamed from: l  reason: collision with root package name */
    public s5.d f6083l;

    /* renamed from: m  reason: collision with root package name */
    public long f6084m;

    /* renamed from: n  reason: collision with root package name */
    public Map f6085n = new LinkedHashMap();

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f12307a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", false);
            Intent putExtra = intent.putExtra("is_force", true);
            i.f(putExtra, "intent.putExtra(ResetAty.IS_FORCE,true)");
            return putExtra;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f12308a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("bind_from", 1);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", false);
            Intent putExtra = intent.putExtra("is_force", true);
            i.f(putExtra, "intent.putExtra(ResetAty.IS_FORCE,true)");
            return putExtra;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f12309a = new c();

        public c() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", true);
            Intent putExtra = intent.putExtra("is_force", true);
            i.f(putExtra, "intent.putExtra(ResetAty.IS_FORCE,true)");
            return putExtra;
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForceChangePwdAty f12310a;

        public d(ForceChangePwdAty forceChangePwdAty) {
            this.f12310a = forceChangePwdAty;
        }

        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) this.f12310a.U2(R$id.mTextConfirm);
            ForceChangePwdAty forceChangePwdAty = this.f12310a;
            EditText editText = (EditText) forceChangePwdAty.U2(R$id.mEditOldPassword);
            i.f(editText, "mEditOldPassword");
            if (!forceChangePwdAty.d3(editText)) {
                ForceChangePwdAty forceChangePwdAty2 = this.f12310a;
                EditText editText2 = (EditText) forceChangePwdAty2.U2(R$id.mEditNewPassword);
                i.f(editText2, "mEditNewPassword");
                if (!forceChangePwdAty2.d3(editText2)) {
                    ForceChangePwdAty forceChangePwdAty3 = this.f12310a;
                    EditText editText3 = (EditText) forceChangePwdAty3.U2(R$id.mEditPasswordAgain);
                    i.f(editText3, "mEditPasswordAgain");
                    if (!forceChangePwdAty3.d3(editText3)) {
                        z10 = true;
                        textView.setEnabled(z10);
                    }
                }
            }
            z10 = false;
            textView.setEnabled(z10);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForceChangePwdAty f12311a;

        public e(ForceChangePwdAty forceChangePwdAty) {
            this.f12311a = forceChangePwdAty;
        }

        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) this.f12311a.U2(R$id.mTextConfirm);
            ForceChangePwdAty forceChangePwdAty = this.f12311a;
            EditText editText = (EditText) forceChangePwdAty.U2(R$id.mEditOldPassword);
            i.f(editText, "mEditOldPassword");
            if (!forceChangePwdAty.d3(editText)) {
                ForceChangePwdAty forceChangePwdAty2 = this.f12311a;
                EditText editText2 = (EditText) forceChangePwdAty2.U2(R$id.mEditNewPassword);
                i.f(editText2, "mEditNewPassword");
                if (!forceChangePwdAty2.d3(editText2)) {
                    ForceChangePwdAty forceChangePwdAty3 = this.f12311a;
                    EditText editText3 = (EditText) forceChangePwdAty3.U2(R$id.mEditPasswordAgain);
                    i.f(editText3, "mEditPasswordAgain");
                    if (!forceChangePwdAty3.d3(editText3)) {
                        z10 = true;
                        textView.setEnabled(z10);
                    }
                }
            }
            z10 = false;
            textView.setEnabled(z10);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForceChangePwdAty f12312a;

        public f(ForceChangePwdAty forceChangePwdAty) {
            this.f12312a = forceChangePwdAty;
        }

        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) this.f12312a.U2(R$id.mTextConfirm);
            ForceChangePwdAty forceChangePwdAty = this.f12312a;
            EditText editText = (EditText) forceChangePwdAty.U2(R$id.mEditOldPassword);
            i.f(editText, "mEditOldPassword");
            if (!forceChangePwdAty.d3(editText)) {
                ForceChangePwdAty forceChangePwdAty2 = this.f12312a;
                EditText editText2 = (EditText) forceChangePwdAty2.U2(R$id.mEditNewPassword);
                i.f(editText2, "mEditNewPassword");
                if (!forceChangePwdAty2.d3(editText2)) {
                    ForceChangePwdAty forceChangePwdAty3 = this.f12312a;
                    EditText editText3 = (EditText) forceChangePwdAty3.U2(R$id.mEditPasswordAgain);
                    i.f(editText3, "mEditPasswordAgain");
                    if (!forceChangePwdAty3.d3(editText3)) {
                        z10 = true;
                        textView.setEnabled(z10);
                    }
                }
            }
            z10 = false;
            textView.setEnabled(z10);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f12313a = new g();

        public g() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            Intent putExtra = intent.putExtra("can_back", false);
            i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, false)");
            return putExtra;
        }
    }

    public static final class h extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForceChangePwdAty f12314a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f12315b;

        public h(ForceChangePwdAty forceChangePwdAty, w wVar) {
            this.f12314a = forceChangePwdAty;
            this.f12315b = wVar;
        }

        /* renamed from: f */
        public void onNext(UpdatePwdResult updatePwdResult) {
            i.g(updatePwdResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            Object obj = this.f12315b.f19600a;
            i.f(obj, "enNewPwd");
            memberInfo.putPassword((String) obj, false);
            this.f12314a.X2();
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            ((ProgressBar) this.f12314a.U2(R$id.mLoadingPbar)).setVisibility(8);
            String p10 = y.p(y.f12639a, str, (String) null, (String) null, 6, (Object) null);
            if (i.b(str, "aaa100022")) {
                p10 = this.f12314a.getResources().getString(R.string.origin_password_error_tips);
                i.f(p10, "resources.getString(R.st…igin_password_error_tips)");
            }
            f1.a.f(f1.f12517a, this.f12314a, p10, false, 0, 8, (Object) null);
        }
    }

    public static final void a3(ForceChangePwdAty forceChangePwdAty, View view) {
        i.g(forceChangePwdAty, "this$0");
        int i10 = R$id.mEditNewPassword;
        if (!j1.g(((EditText) forceChangePwdAty.U2(i10)).getText().toString())) {
            f1.a aVar = f1.f12517a;
            String string = forceChangePwdAty.getResources().getString(R.string.password_format_error_tips);
            i.f(string, "this.resources.getString…ssword_format_error_tips)");
            f1.a.f(aVar, forceChangePwdAty, string, false, 0, 8, (Object) null);
        } else {
            int i11 = R$id.mEditPasswordAgain;
            if (!j1.g(((EditText) forceChangePwdAty.U2(i11)).getText().toString())) {
                f1.a aVar2 = f1.f12517a;
                String string2 = forceChangePwdAty.getResources().getString(R.string.password_error_tips);
                i.f(string2, "this.resources.getString…ring.password_error_tips)");
                f1.a.f(aVar2, forceChangePwdAty, string2, false, 0, 8, (Object) null);
            } else if (!i.b(((EditText) forceChangePwdAty.U2(i10)).getText().toString(), ((EditText) forceChangePwdAty.U2(i11)).getText().toString())) {
                f1.a aVar3 = f1.f12517a;
                String string3 = forceChangePwdAty.getResources().getString(R.string.not_match_password);
                i.f(string3, "this.resources.getString…tring.not_match_password)");
                f1.a.f(aVar3, forceChangePwdAty, string3, false, 0, 8, (Object) null);
            } else {
                forceChangePwdAty.e3();
            }
        }
        Context Q1 = forceChangePwdAty.Q1();
        i.e(Q1, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.F((f5.c) Q1);
    }

    public static final void b3(ForceChangePwdAty forceChangePwdAty, View view) {
        i.g(forceChangePwdAty, "this$0");
        i.c cVar = w6.i.f9510g;
        Class<ResetAty> cls = ResetAty.class;
        if (t9.i.b(cVar.h(), "1")) {
            b0.d0(forceChangePwdAty, cls, a.f12307a);
        } else if (t9.i.b(cVar.j(), "1")) {
            b0.d0(forceChangePwdAty, cls, b.f12308a);
        } else {
            b0.d0(forceChangePwdAty, cls, c.f12309a);
        }
    }

    public static final void c3(ForceChangePwdAty forceChangePwdAty, View view) {
        t9.i.g(forceChangePwdAty, "this$0");
        LoginAty.C.c(true);
        b0.c0(forceChangePwdAty, LoginAty.class);
    }

    public View U2(int i10) {
        Map map = this.f6085n;
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

    public final void X2() {
        s5.d dVar = this.f6083l;
        if (dVar != null) {
            SwitchAccountBean f10 = dVar.f();
            if (f10 != null) {
                f10.setPassword(MemberInfo.INSTANCE.getLastPassword());
            }
            dVar.l(MemberInfo.INSTANCE.getLastPassword());
            dVar.k(false);
            s5.e.f19464a.m(dVar);
        }
        this.f6082k.a(this, s5.e.f19464a, this);
    }

    public final void Y2() {
        if (System.currentTimeMillis() - this.f6084m > 2000) {
            f1.f12517a.w(R.string.twice_end_koocan);
            this.f6084m = System.currentTimeMillis();
            return;
        }
        Object systemService = Q1().getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
        q8.e.a("stop");
        c2.i.f4633q.a().h();
        z.f4508u.g().clear();
        finish();
        ma.h.f18994a.d(Q1(), "");
    }

    public final void Z2() {
        int i10 = R$id.mTextConfirm;
        ((TextView) U2(i10)).setEnabled(false);
        ((AutoRelativeLayout) U2(R$id.mLayoutChange)).setVisibility(0);
        ((AutoLinearLayout) U2(R$id.mLayoutSuccess)).setVisibility(8);
        int i11 = R$id.mTextForgetPassword;
        ((TextView) U2(i11)).getPaint().setFlags(8);
        int i12 = R$id.mTextForgetAccount;
        ((TextView) U2(i12)).getPaint().setFlags(8);
        int i13 = R$id.mEditOldPassword;
        ((EditText) U2(i13)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        int i14 = R$id.mEditNewPassword;
        ((EditText) U2(i14)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        int i15 = R$id.mEditPasswordAgain;
        ((EditText) U2(i15)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        SpannableString spannableString = new SpannableString(getString(R.string.login_forget_pwd));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        ((TextView) U2(i11)).setText(spannableString);
        ((TextView) U2(i10)).setOnClickListener(new e6.z(this));
        ((TextView) U2(i11)).setOnClickListener(new a0(this));
        ((EditText) U2(i13)).addTextChangedListener(new d(this));
        ((EditText) U2(i14)).addTextChangedListener(new e(this));
        ((EditText) U2(i15)).addTextChangedListener(new f(this));
        ((TextView) U2(i12)).setOnClickListener(new e6.b0(this));
        this.f6083l = s5.e.f19464a.l();
    }

    public final boolean d3(EditText editText) {
        String obj = t.W(editText.getText().toString()).toString();
        if (obj == null || obj.length() == 0) {
            return true;
        }
        return false;
    }

    public final void e3() {
        String e10 = m.e(((EditText) U2(R$id.mEditOldPassword)).getText().toString());
        String obj = t.W(((EditText) U2(R$id.mEditNewPassword)).getText().toString()).toString();
        w wVar = new w();
        wVar.f19600a = m.e(obj);
        ((ProgressBar) U2(R$id.mLoadingPbar)).setVisibility(0);
        w6.i b10 = w6.i.f9510g.b();
        t9.i.f(e10, "oldPwd");
        Object obj2 = wVar.f19600a;
        t9.i.f(obj2, "enNewPwd");
        b10.p2(e10, (String) obj2).compose(O1()).subscribe(new h(this, wVar));
    }

    public void f1() {
    }

    public void k2() {
        n2();
    }

    public void onBackPressed() {
        Y2();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_force_change_password);
        Z2();
    }

    @xa.j
    public final void onEventMainThread(CloseForcePageEvent closeForcePageEvent) {
        t9.i.g(closeForcePageEvent, "closePageEvent");
        finish();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f6083l = s5.e.f19464a.l();
    }

    public void q0(String str) {
        t9.i.g(str, "loginStatus");
        ((ProgressBar) U2(R$id.mLoadingPbar)).setVisibility(8);
        if (t9.i.b(str, "0")) {
            s5.e.f19464a.a();
            b0.c0(this, MainAty.class);
            finish();
            return;
        }
        s5.e.f19464a.a();
        b0.d0(this, LoginAty.class, g.f12313a);
        finish();
    }
}
