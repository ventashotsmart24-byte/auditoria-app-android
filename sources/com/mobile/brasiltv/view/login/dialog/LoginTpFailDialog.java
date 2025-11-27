package com.mobile.brasiltv.view.login.dialog;

import android.content.Context;
import android.view.View;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;

public final class LoginTpFailDialog extends CommonDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginTpFailDialog(Context context) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(LoginTpFailDialog loginTpFailDialog, View view) {
        i.g(loginTpFailDialog, "this$0");
        loginTpFailDialog.dismiss();
    }

    public int getDialogHeight() {
        return 420;
    }

    public int getDialogWidth() {
        return 560;
    }

    public int getLayoutId() {
        return R.layout.dialog_login_tp_fail;
    }

    public void initListener() {
        ((KoocanButton) findViewById(R$id.mKbOk)).setOnClickListener(new h(this));
    }

    public void initView() {
        setCancelable(false);
    }
}
