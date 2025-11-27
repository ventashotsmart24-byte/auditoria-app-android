package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CloseResetPageEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.input.AccountInputView;
import com.mobile.brasiltv.view.input.IAccountInputCallback;
import com.msandroid.mobile.R;
import f5.d;
import f5.p4;
import f5.q4;
import f5.r4;
import i6.u0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.x3;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class SetPwdOnResetAty extends d implements u0 {

    /* renamed from: t  reason: collision with root package name */
    public static final a f12160t = new a((g) null);

    /* renamed from: l  reason: collision with root package name */
    public boolean f12161l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f12162m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f12163n;

    /* renamed from: o  reason: collision with root package name */
    public String f12164o = "";

    /* renamed from: p  reason: collision with root package name */
    public String f12165p = "";

    /* renamed from: q  reason: collision with root package name */
    public boolean f12166q;

    /* renamed from: r  reason: collision with root package name */
    public x3 f12167r;

    /* renamed from: s  reason: collision with root package name */
    public Map f12168s = new LinkedHashMap();

    public static final class a {

        /* renamed from: com.mobile.brasiltv.activity.SetPwdOnResetAty$a$a  reason: collision with other inner class name */
        public static final class C0187a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12169a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f12170b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f12171c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f12172d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f12173e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0187a(String str, boolean z10, String str2, boolean z11, boolean z12) {
                super(1);
                this.f12169a = str;
                this.f12170b = z10;
                this.f12171c = str2;
                this.f12172d = z11;
                this.f12173e = z12;
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                i.g(intent, "it");
                intent.putExtra("extra_email", this.f12169a);
                intent.putExtra("extra_from_login", this.f12170b);
                intent.putExtra("extra_verify_code", this.f12171c);
                intent.putExtra("extra_need_auto_login", this.f12172d);
                Intent putExtra = intent.putExtra("is_force", this.f12173e);
                i.f(putExtra, "it.putExtra(ResetAty.IS_FORCE,mIsForce)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(f5.c cVar, String str, String str2, boolean z10, boolean z11, boolean z12) {
            i.g(cVar, "activity");
            i.g(str, Scopes.EMAIL);
            i.g(str2, "verifyCode");
            b0.d0(cVar, SetPwdOnResetAty.class, new C0187a(str, z10, str2, z11, z12));
        }
    }

    public static final class b implements IAccountInputCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPwdOnResetAty f12174a;

        public b(SetPwdOnResetAty setPwdOnResetAty) {
            this.f12174a = setPwdOnResetAty;
        }

        public void onInputFocused() {
            this.f12174a.g3();
        }

        public void onTextChanged(boolean z10) {
            this.f12174a.f12162m = z10;
            this.f12174a.i3();
        }
    }

    public static final class c implements IAccountInputCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPwdOnResetAty f12175a;

        public c(SetPwdOnResetAty setPwdOnResetAty) {
            this.f12175a = setPwdOnResetAty;
        }

        public void onInputFocused() {
            this.f12175a.g3();
        }

        public void onTextChanged(boolean z10) {
            this.f12175a.f12163n = z10;
            this.f12175a.i3();
        }
    }

    public static final void c3(SetPwdOnResetAty setPwdOnResetAty, View view) {
        i.g(setPwdOnResetAty, "this$0");
        setPwdOnResetAty.finish();
    }

    public static final void d3(SetPwdOnResetAty setPwdOnResetAty, View view) {
        i.g(setPwdOnResetAty, "this$0");
        if (setPwdOnResetAty.f12166q) {
            xa.c.c().j(new CloseResetPageEvent());
            setPwdOnResetAty.finish();
        } else if (setPwdOnResetAty.f12161l) {
            xa.c.c().j(new CloseResetPageEvent());
            setPwdOnResetAty.finish();
        } else {
            xa.c.c().j(new GotoHomeTabEvent(2));
            b0.c0(setPwdOnResetAty, MainAty.class);
        }
    }

    public static final void e3(SetPwdOnResetAty setPwdOnResetAty, View view) {
        i.g(setPwdOnResetAty, "this$0");
        b0.F(setPwdOnResetAty);
        setPwdOnResetAty.S2().l(setPwdOnResetAty.f12164o, ((AccountInputView) setPwdOnResetAty.X2(R$id.mAivPwd)).getInputText(), ((AccountInputView) setPwdOnResetAty.X2(R$id.mAivRepeatPwd)).getInputText(), setPwdOnResetAty.f12165p, setPwdOnResetAty.getIntent().getBooleanExtra("extra_need_auto_login", true));
    }

    public void R2() {
        h3(new x3(this, this));
        String stringExtra = getIntent().getStringExtra("extra_email");
        String str = "";
        if (stringExtra == null) {
            stringExtra = str;
        }
        this.f12164o = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("extra_verify_code");
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        this.f12165p = str;
        this.f12166q = getIntent().getBooleanExtra("extra_from_login", false);
        this.f12161l = getIntent().getBooleanExtra("is_force", false);
        int i10 = R$id.mTbvTitle;
        ((TitleBarView) X2(i10)).setOnBackClickListener(new p4(this));
        ((TitleBarView) X2(i10)).setOnCloseClickListener(new q4(this));
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
        ((TextView) X2(R$id.mTvConfirm)).setOnClickListener(new r4(this));
    }

    public int T2() {
        return R.layout.aty_set_pwd_on_reset;
    }

    public View X2(int i10) {
        Map map = this.f12168s;
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

    public void d(int i10) {
        int i11 = R$id.mTvErrorHint;
        ((TextView) X2(i11)).setVisibility(0);
        ((TextView) X2(i11)).setText(getResources().getString(i10));
    }

    /* renamed from: f3 */
    public x3 S2() {
        x3 x3Var = this.f12167r;
        if (x3Var != null) {
            return x3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void g3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) X2(i10)).setVisibility(8);
        ((TextView) X2(i10)).setText("");
    }

    public void h3(x3 x3Var) {
        i.g(x3Var, "<set-?>");
        this.f12167r = x3Var;
    }

    public final void i3() {
        boolean z10;
        TextView textView = (TextView) X2(R$id.mTvConfirm);
        if (!this.f12162m || !this.f12163n) {
            z10 = false;
        } else {
            z10 = true;
        }
        textView.setEnabled(z10);
    }

    public void j1(boolean z10) {
        ResetPwdSucAty.f12105q.a(this, z10);
        xa.c.c().j(new CloseResetPageEvent());
        finish();
    }

    public void k2() {
        n2();
    }

    public void showLoading(boolean z10) {
        O2(z10);
    }

    public void x() {
        xa.c.c().j(new CloseResetPageEvent());
        finish();
    }
}
