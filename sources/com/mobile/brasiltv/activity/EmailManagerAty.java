package com.mobile.brasiltv.activity;

import android.content.DialogInterface;
import android.view.View;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.dialog.InputPwdDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import f5.d;
import f5.g0;
import f5.h0;
import f5.i0;
import f5.j0;
import f5.k0;
import h9.t;
import i6.o;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.x;
import t9.i;
import t9.j;
import xa.c;

public final class EmailManagerAty extends d implements o {

    /* renamed from: l  reason: collision with root package name */
    public InputPwdDialog f12004l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingView f12005m;

    /* renamed from: n  reason: collision with root package name */
    public x f12006n;

    /* renamed from: o  reason: collision with root package name */
    public Map f12007o = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmailManagerAty f12008a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(EmailManagerAty emailManagerAty) {
            super(0);
            this.f12008a = emailManagerAty;
        }

        public final void invoke() {
            String str;
            b0.F(this.f12008a);
            InputPwdDialog a32 = this.f12008a.f12004l;
            if (!j1.f(a32 != null ? a32.getPwd() : null)) {
                this.f12008a.R(R.string.password_format_incorrect);
                return;
            }
            x e32 = this.f12008a.S2();
            InputPwdDialog a33 = this.f12008a.f12004l;
            if (a33 == null || (str = a33.getPwd()) == null) {
                str = "";
            }
            e32.h(str);
        }
    }

    public static final void b3(EmailManagerAty emailManagerAty, View view) {
        i.g(emailManagerAty, "this$0");
        emailManagerAty.finish();
    }

    public static final void c3(EmailManagerAty emailManagerAty, View view) {
        i.g(emailManagerAty, "this$0");
        c.c().j(new GotoHomeTabEvent(2));
        b0.c0(emailManagerAty, MainAty.class);
    }

    public static final void d3(EmailManagerAty emailManagerAty, View view) {
        i.g(emailManagerAty, "this$0");
        emailManagerAty.g3();
    }

    public static final void h3(EmailManagerAty emailManagerAty, DialogInterface dialogInterface) {
        i.g(emailManagerAty, "this$0");
        emailManagerAty.f12004l = null;
    }

    public static final void i3(EmailManagerAty emailManagerAty, DialogInterface dialogInterface) {
        i.g(emailManagerAty, "this$0");
        emailManagerAty.f12005m = null;
    }

    public void O0() {
        InputPwdDialog inputPwdDialog = this.f12004l;
        if (inputPwdDialog != null) {
            inputPwdDialog.dismiss();
        }
        b0.c0(this, ChangeEmailAty.class);
    }

    public void R(int i10) {
        InputPwdDialog inputPwdDialog = this.f12004l;
        if (inputPwdDialog != null) {
            String string = getResources().getString(i10);
            i.f(string, "resources.getString(resId)");
            inputPwdDialog.setErrorHint(string);
        }
    }

    public void R2() {
        f3(new x(this, this));
        int i10 = R$id.mTbvTitle;
        ((TitleBarView) Z2(i10)).setOnBackClickListener(new g0(this));
        ((TitleBarView) Z2(i10)).setOnCloseClickListener(new h0(this));
        ((AutoFrameLayout) Z2(R$id.mAflChangeBind)).setOnClickListener(new i0(this));
    }

    public int T2() {
        return R.layout.aty_email_manager;
    }

    public View Z2(int i10) {
        Map map = this.f12007o;
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

    /* renamed from: e3 */
    public x S2() {
        x xVar = this.f12006n;
        if (xVar != null) {
            return xVar;
        }
        i.w("mPresenter");
        return null;
    }

    public void f3(x xVar) {
        i.g(xVar, "<set-?>");
        this.f12006n = xVar;
    }

    public final void g3() {
        if (this.f12004l == null) {
            InputPwdDialog inputPwdDialog = new InputPwdDialog(this);
            this.f12004l = inputPwdDialog;
            inputPwdDialog.setConfirmCallback(new a(this));
            InputPwdDialog inputPwdDialog2 = this.f12004l;
            if (inputPwdDialog2 != null) {
                inputPwdDialog2.setOnDismissListener(new j0(this));
            }
        }
        InputPwdDialog inputPwdDialog3 = this.f12004l;
        if (inputPwdDialog3 != null) {
            inputPwdDialog3.show();
        }
    }

    public void k2() {
        n2();
    }

    public void showLoading(boolean z10) {
        if (this.f12005m == null) {
            this.f12005m = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new k0(this), 6, (Object) null);
            t tVar = t.f17319a;
        }
        if (z10) {
            LoadingView loadingView = this.f12005m;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f12005m;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }
}
