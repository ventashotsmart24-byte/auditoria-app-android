package com.mobile.brasiltv.mine.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import e6.c0;
import e6.d0;
import e6.e0;
import h9.h;
import h9.t;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import k7.f;
import mobile.com.requestframe.utils.response.EmailResetPwdResult;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import t9.w;
import t9.z;
import w6.i;

public final class ForgetPasswordAty extends f5.c {

    /* renamed from: o  reason: collision with root package name */
    public static final a f12316o = new a((g) null);

    /* renamed from: p  reason: collision with root package name */
    public static final String f12317p = "HAS_X";

    /* renamed from: k  reason: collision with root package name */
    public final h9.g f12318k = h.b(new b(this));

    /* renamed from: l  reason: collision with root package name */
    public String f12319l = "";

    /* renamed from: m  reason: collision with root package name */
    public long f12320m;

    /* renamed from: n  reason: collision with root package name */
    public Map f12321n = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return ForgetPasswordAty.f12317p;
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForgetPasswordAty f12322a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ForgetPasswordAty forgetPasswordAty) {
            super(0);
            this.f12322a = forgetPasswordAty;
        }

        /* renamed from: b */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f12322a.getIntent().getBooleanExtra(ForgetPasswordAty.f12316o.a(), false));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForgetPasswordAty f12323a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f12324b;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12325a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f12325a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12325a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(ForgetPasswordAty forgetPasswordAty, w wVar) {
            this.f12323a = forgetPasswordAty;
            this.f12324b = wVar;
        }

        /* renamed from: f */
        public void onNext(EmailResetPwdResult emailResetPwdResult) {
            i.g(emailResetPwdResult, "t");
            f.e("忘记密码发送重置邮件成功", new Object[0]);
            this.f12323a.showLoading(false);
            ((AutoRelativeLayout) this.f12323a.U2(R$id.mLayoutEmailSend)).setVisibility(0);
            ((TextView) this.f12323a.U2(R$id.mTextErrorNotify)).setVisibility(8);
            z zVar = z.f19601a;
            String string = this.f12323a.Q1().getResources().getString(R.string.forget_email_send);
            i.f(string, "context.resources.getStr…string.forget_email_send)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.f12324b.f19600a}, 1));
            i.f(format, "format(format, *args)");
            ((TextView) this.f12323a.U2(R$id.mTextSuccessNotify)).setText(format);
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f12323a.showLoading(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f12323a.showLoading(false);
            f.e("忘记密码发送重置邮件失败 returnCode:" + str, new Object[0]);
            x.f12622a.w(this.f12323a.Q1(), new a(str));
        }
    }

    public static final void Y2(ForgetPasswordAty forgetPasswordAty, View view) {
        i.g(forgetPasswordAty, "this$0");
        b0.c0(forgetPasswordAty, MainAty.class);
    }

    public static final void Z2(ForgetPasswordAty forgetPasswordAty, View view) {
        boolean z10;
        i.g(forgetPasswordAty, "this$0");
        if (((AutoRelativeLayout) forgetPasswordAty.U2(R$id.mLayoutEmailSend)).getVisibility() != 0) {
            int i10 = R$id.mEditEmail;
            Editable text = ((EditText) forgetPasswordAty.U2(i10)).getText();
            if (text == null || text.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                if (!j1.d(((EditText) forgetPasswordAty.U2(i10)).getText().toString())) {
                    int i11 = R$id.mTextErrorNotify;
                    ((TextView) forgetPasswordAty.U2(i11)).setVisibility(0);
                    ((TextView) forgetPasswordAty.U2(i11)).setText(forgetPasswordAty.getResources().getString(R.string.email_incorrect));
                } else if (!i.b(((EditText) forgetPasswordAty.U2(i10)).getText().toString(), forgetPasswordAty.f12319l) || System.currentTimeMillis() - forgetPasswordAty.f12320m > 60000) {
                    forgetPasswordAty.f12320m = System.currentTimeMillis();
                    forgetPasswordAty.f12319l = ((EditText) forgetPasswordAty.U2(i10)).getText().toString();
                    ((TextView) forgetPasswordAty.U2(R$id.mTextErrorNotify)).setVisibility(8);
                    forgetPasswordAty.c3();
                } else {
                    int i12 = R$id.mTextErrorNotify;
                    ((TextView) forgetPasswordAty.U2(i12)).setVisibility(0);
                    ((TextView) forgetPasswordAty.U2(i12)).setText(forgetPasswordAty.getResources().getString(R.string.frequent_operation));
                }
            }
        }
    }

    public static final void a3(ForgetPasswordAty forgetPasswordAty, View view) {
        i.g(forgetPasswordAty, "this$0");
        ((AutoRelativeLayout) forgetPasswordAty.U2(R$id.mLayoutEmailSend)).setVisibility(8);
    }

    public View U2(int i10) {
        Map map = this.f12321n;
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

    public final boolean W2() {
        return ((Boolean) this.f12318k.getValue()).booleanValue();
    }

    public final void X2() {
        ((TitleView) U2(R$id.title_view)).setXClickListener(new c0(this));
        ((TextView) U2(R$id.mTextConfirm)).setOnClickListener(new d0(this));
        ((ImageView) U2(R$id.mImageClose)).setOnClickListener(new e0(this));
    }

    public final void b3() {
        if (W2()) {
            ((TitleView) U2(R$id.title_view)).setXVisible(0);
        } else {
            ((TitleView) U2(R$id.title_view)).setXVisible(8);
        }
        i.c cVar = w6.i.f9510g;
        if (!TextUtils.isEmpty(cVar.m())) {
            ((EditText) U2(R$id.mEditEmail)).setText(cVar.m());
        }
    }

    public final void c3() {
        w wVar = new w();
        wVar.f19600a = ((EditText) U2(R$id.mEditEmail)).getText().toString();
        w6.i.f9510g.b().Z0((String) wVar.f19600a).compose(O1()).subscribe(new c(this, wVar));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_forget_password);
        b3();
        X2();
    }

    public final void showLoading(boolean z10) {
        int i10;
        ProgressBar progressBar = (ProgressBar) U2(R$id.mLoadingPb);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        progressBar.setVisibility(i10);
    }
}
