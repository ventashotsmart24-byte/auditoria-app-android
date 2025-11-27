package g6;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.CheckPwdSuccessEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import io.reactivex.disposables.Disposable;
import ma.m;
import mobile.com.requestframe.utils.response.PwdCheckResult;
import mobile.com.requestframe.utils.response.UpdateRestrictResult;
import s9.l;
import t9.i;
import t9.j;
import w6.i;
import xa.c;

public final class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public Disposable f17204a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f17205b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17206a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17207b;

        /* renamed from: g6.d$a$a  reason: collision with other inner class name */
        public static final class C0223a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17208a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0223a(String str) {
                super(1);
                this.f17208a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17208a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(d dVar, String str) {
            this.f17206a = dVar;
            this.f17207b = str;
        }

        /* renamed from: f */
        public void onNext(PwdCheckResult pwdCheckResult) {
            i.g(pwdCheckResult, "t");
            this.f17206a.j(false);
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String e10 = m.e(this.f17207b);
            i.f(e10, "md5(password)");
            memberInfo.putPassword(e10, false);
            MainAty.A.o(false);
            c.c().j(new CheckPwdSuccessEvent());
            this.f17206a.cancel();
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17206a.j(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f17206a.j(false);
            if (b0.T(str, "aaa100012")) {
                f1.f12517a.w(R.string.pwd_wrong);
            } else if (b0.T(str, "50010") || b0.T(str, "50011") || b0.T(str, "50012") || b0.T(str, "50014")) {
                f1.f12517a.w(R.string.pi_connect_timeout);
            } else {
                x xVar = x.f12622a;
                Context context = this.f17206a.getContext();
                i.f(context, f.X);
                xVar.w(context, new C0223a(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17209a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17210a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17210a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17210a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public b(d dVar) {
            this.f17209a = dVar;
        }

        /* renamed from: f */
        public void onNext(UpdateRestrictResult updateRestrictResult) {
            i.g(updateRestrictResult, "t");
            k7.f.e("更新限制级状态成功，发送事件", new Object[0]);
            this.f17209a.j(false);
            MainAty.A.o(false);
            c.c().j(new CheckPwdSuccessEvent());
            c.c().m(new UpdateRestrictEvent("1", true));
            this.f17209a.cancel();
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17209a.i(disposable);
            this.f17209a.j(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f17209a.j(false);
            x xVar = x.f12622a;
            Context context = this.f17209a.getContext();
            i.f(context, f.X);
            xVar.w(context, new a(str));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context, R.style.OptionDialog);
        i.g(context, f.X);
    }

    public static final void e(d dVar, View view) {
        i.g(dVar, "this$0");
        ((EditText) dVar.findViewById(R$id.mEditPassword)).setText("");
        dVar.cancel();
    }

    public static final void f(d dVar, View view) {
        boolean z10;
        i.g(dVar, "this$0");
        int i10 = R$id.mEditPassword;
        Editable text = ((EditText) dVar.findViewById(i10)).getText();
        if (text == null || text.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            String obj = ba.t.W(((EditText) dVar.findViewById(i10)).getText().toString()).toString();
            if (!j1.f(obj)) {
                int i11 = R$id.mTextErrorNotify;
                ((TextView) dVar.findViewById(i11)).setVisibility(0);
                ((TextView) dVar.findViewById(i11)).setText(dVar.getContext().getResources().getString(R.string.password_format_incorrect));
                return;
            }
            ((TextView) dVar.findViewById(R$id.mTextErrorNotify)).setVisibility(8);
            dVar.d();
            if (dVar.f17205b) {
                dVar.k(obj);
            } else {
                dVar.l(obj);
            }
        }
    }

    public static final void g(d dVar, View view) {
        i.g(dVar, "this$0");
        i.c cVar = w6.i.f9510g;
        if (!t9.i.b(cVar.c(), "1") || t9.i.b(cVar.h(), "1") || t9.i.b(cVar.j(), "1")) {
            Intent intent = new Intent(dVar.getContext(), ResetAty.class);
            if (t9.i.b(cVar.h(), "1")) {
                intent.putExtra("need_x_button", false);
                intent.putExtra("bind_from", 2);
                intent.putExtra("bind_Type", "3");
                intent.putExtra("is_edit_editable", false);
            } else if (t9.i.b(cVar.j(), "1")) {
                intent.putExtra("need_x_button", false);
                intent.putExtra("bind_from", 1);
                intent.putExtra("bind_Type", "3");
                intent.putExtra("is_edit_editable", false);
            } else {
                intent.putExtra("need_x_button", false);
                intent.putExtra("bind_from", 2);
                intent.putExtra("bind_Type", "3");
                intent.putExtra("is_edit_editable", true);
            }
            dVar.getContext().startActivity(intent);
            return;
        }
        f1.f12517a.w(R.string.mine_please_bind);
    }

    public void cancel() {
        super.cancel();
        Disposable disposable = this.f17204a;
        if (disposable != null) {
            t9.i.d(disposable);
            disposable.dispose();
        }
    }

    public final void d() {
        Object systemService = getContext().getSystemService("input_method");
        t9.i.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).toggleSoftInput(0, 2);
    }

    public final void h(boolean z10) {
        this.f17205b = z10;
    }

    public final void i(Disposable disposable) {
        this.f17204a = disposable;
    }

    public final void j(boolean z10) {
        int i10;
        ProgressBar progressBar = (ProgressBar) findViewById(R$id.mLoadingPb);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        progressBar.setVisibility(i10);
    }

    public final void k(String str) {
        t9.i.g(str, "password");
        w6.i b10 = w6.i.f9510g.b();
        String e10 = m.e(str);
        t9.i.f(e10, "md5(password)");
        b10.d2(e10).subscribe(new a(this, str));
    }

    public final void l(String str) {
        t9.i.g(str, "pwd");
        Disposable disposable = this.f17204a;
        if (disposable != null) {
            t9.i.d(disposable);
            if (!disposable.isDisposed()) {
                Disposable disposable2 = this.f17204a;
                t9.i.d(disposable2);
                disposable2.dispose();
            }
        }
        w6.i.f9510g.b().q2(m.e(str), "1").subscribe(new b(this));
    }

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView(R.layout.dialog_input_password);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = AutoUtils.getPercentWidthSize(520);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        ((ImageView) findViewById(R$id.mImageClose)).setOnClickListener(new a(this));
        ((TextView) findViewById(R$id.mTextConfirm)).setOnClickListener(new b(this));
        ((TextView) findViewById(R$id.mTextForgetPassword)).setOnClickListener(new c(this));
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        ((EditText) findViewById(R$id.mEditPassword)).setText("");
        super.setOnCancelListener(onCancelListener);
    }
}
