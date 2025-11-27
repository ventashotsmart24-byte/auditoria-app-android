package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.view.input.AccountInputView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import s9.a;
import t9.g;
import t9.i;

public final class InputPwdDialog extends CommonDialog {
    private a mConfirmCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputPwdDialog(Context context) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(InputPwdDialog inputPwdDialog, View view) {
        i.g(inputPwdDialog, "this$0");
        inputPwdDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(InputPwdDialog inputPwdDialog, View view) {
        i.g(inputPwdDialog, "this$0");
        Intent intent = new Intent(inputPwdDialog.getContext(), ResetAty.class);
        intent.putExtra("need_x_button", true);
        intent.putExtra("bind_from", 2);
        intent.putExtra("bind_Type", "3");
        inputPwdDialog.getContext().startActivity(intent);
        inputPwdDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$2(InputPwdDialog inputPwdDialog, View view) {
        i.g(inputPwdDialog, "this$0");
        a aVar = inputPwdDialog.mConfirmCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public int getDialogHeight() {
        return 440;
    }

    public int getDialogWidth() {
        return 560;
    }

    public int getLayoutId() {
        return R.layout.dialog_input_unbind_pwd;
    }

    public final String getPwd() {
        return ((AccountInputView) findViewById(R$id.mAivPwd)).getInputText();
    }

    public final void hideErrorHint() {
        ((TextView) findViewById(R$id.mTvErrorHint)).setText("");
    }

    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new i0(this));
        ((AccountInputView) findViewById(R$id.mAivPwd)).setAccountInputCallback(new InputPwdDialog$initListener$2(this));
        ((TextView) findViewById(R$id.mTvForgetPwd)).setOnClickListener(new j0(this));
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new k0(this));
    }

    public void initView() {
        int i10 = R$id.mTvForgetPwd;
        ((TextView) findViewById(i10)).getPaint().setFlags(8);
        ((TextView) findViewById(i10)).getPaint().setAntiAlias(true);
        hideErrorHint();
    }

    public final InputPwdDialog setConfirmCallback(a aVar) {
        i.g(aVar, "callback");
        this.mConfirmCallback = aVar;
        return this;
    }

    public final void setErrorHint(String str) {
        i.g(str, "hint");
        ((TextView) findViewById(R$id.mTvErrorHint)).setText(str);
    }
}
