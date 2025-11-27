package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.bean.event.CloseForceBindEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.input.AccountInputView;
import com.mobile.brasiltv.view.input.IAccountInputCallback;
import com.msandroid.mobile.R;
import f5.d;
import f5.m4;
import f5.n4;
import f5.o4;
import i6.t0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.w3;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class SetPwdOnBeAty extends d implements t0 {

    /* renamed from: q  reason: collision with root package name */
    public static final a f6029q = new a((g) null);

    /* renamed from: l  reason: collision with root package name */
    public boolean f6030l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f6031m;

    /* renamed from: n  reason: collision with root package name */
    public String f6032n = "";

    /* renamed from: o  reason: collision with root package name */
    public w3 f6033o;

    /* renamed from: p  reason: collision with root package name */
    public Map f6034p = new LinkedHashMap();

    public static final class a {

        /* renamed from: com.mobile.brasiltv.activity.SetPwdOnBeAty$a$a  reason: collision with other inner class name */
        public static final class C0186a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12157a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0186a(String str) {
                super(1);
                this.f12157a = str;
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                i.g(intent, "it");
                Intent putExtra = intent.putExtra("extra_email", this.f12157a);
                i.f(putExtra, "it.putExtra(EXTRA_EMAIL, email)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(f5.c cVar, String str) {
            i.g(cVar, "activity");
            i.g(str, Scopes.EMAIL);
            b0.d0(cVar, SetPwdOnBeAty.class, new C0186a(str));
        }
    }

    public static final class b implements IAccountInputCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPwdOnBeAty f12158a;

        public b(SetPwdOnBeAty setPwdOnBeAty) {
            this.f12158a = setPwdOnBeAty;
        }

        public void onInputFocused() {
            this.f12158a.g3();
        }

        public void onTextChanged(boolean z10) {
            this.f12158a.f6030l = z10;
            this.f12158a.i3();
        }
    }

    public static final class c implements IAccountInputCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPwdOnBeAty f12159a;

        public c(SetPwdOnBeAty setPwdOnBeAty) {
            this.f12159a = setPwdOnBeAty;
        }

        public void onInputFocused() {
            this.f12159a.g3();
        }

        public void onTextChanged(boolean z10) {
            this.f12159a.f6031m = z10;
            this.f12159a.i3();
        }
    }

    public static final void c3(SetPwdOnBeAty setPwdOnBeAty, View view) {
        i.g(setPwdOnBeAty, "this$0");
        setPwdOnBeAty.finish();
    }

    public static final void d3(SetPwdOnBeAty setPwdOnBeAty, View view) {
        i.g(setPwdOnBeAty, "this$0");
        xa.c.c().j(new GotoHomeTabEvent(2));
        b0.c0(setPwdOnBeAty, MainAty.class);
    }

    public static final void e3(SetPwdOnBeAty setPwdOnBeAty, View view) {
        i.g(setPwdOnBeAty, "this$0");
        b0.F(setPwdOnBeAty);
        setPwdOnBeAty.S2().l(setPwdOnBeAty.f6032n, ((AccountInputView) setPwdOnBeAty.X2(R$id.mAivPwd)).getInputText(), ((AccountInputView) setPwdOnBeAty.X2(R$id.mAivRepeatPwd)).getInputText());
    }

    public void E1(boolean z10) {
        w6.i.f9510g.q0("1");
        xa.c.c().m(new UpdateRestrictEvent("1", false, 2, (g) null));
        xa.c.c().j(new CloseForceBindEvent());
        BindEmailSucAty.f11956r.c(this, true, this.f6032n, z10, !z10);
    }

    public void R2() {
        h3(new w3(this, this));
        String stringExtra = getIntent().getStringExtra("extra_email");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f6032n = stringExtra;
        int i10 = R$id.mTbvTitle;
        ((TitleBarView) X2(i10)).setOnBackClickListener(new m4(this));
        ((TitleBarView) X2(i10)).setOnCloseClickListener(new n4(this));
        int i11 = R$id.mAivPwd;
        PasswordTransformationMethod instance = PasswordTransformationMethod.getInstance();
        i.f(instance, "getInstance()");
        ((AccountInputView) X2(i11)).setTransformationMethod(instance);
        int i12 = R$id.mAivRepeatPwd;
        PasswordTransformationMethod instance2 = PasswordTransformationMethod.getInstance();
        i.f(instance2, "getInstance()");
        ((AccountInputView) X2(i12)).setTransformationMethod(instance2);
        ((AccountInputView) X2(i11)).setAccountInputCallback(new b(this));
        ((AccountInputView) X2(i12)).setAccountInputCallback(new c(this));
        ((TextView) X2(R$id.mTvConfirm)).setOnClickListener(new o4(this));
    }

    public int T2() {
        return R.layout.aty_set_pwd_on_be;
    }

    public View X2(int i10) {
        Map map = this.f6034p;
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

    public void d(int i10) {
        int i11 = R$id.mTvErrorHint;
        ((TextView) X2(i11)).setVisibility(0);
        ((TextView) X2(i11)).setText(getResources().getString(i10));
    }

    /* renamed from: f3 */
    public w3 S2() {
        w3 w3Var = this.f6033o;
        if (w3Var != null) {
            return w3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void g3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) X2(i10)).setVisibility(8);
        ((TextView) X2(i10)).setText("");
    }

    public void h3(w3 w3Var) {
        i.g(w3Var, "<set-?>");
        this.f6033o = w3Var;
    }

    public final void i3() {
        boolean z10;
        TextView textView = (TextView) X2(R$id.mTvConfirm);
        if (!this.f6030l || !this.f6031m) {
            z10 = false;
        } else {
            z10 = true;
        }
        textView.setEnabled(z10);
    }

    public void k2() {
        n2();
    }

    public void showLoading(boolean z10) {
        O2(z10);
    }
}
