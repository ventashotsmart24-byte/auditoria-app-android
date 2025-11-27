package com.mobile.brasiltv.view.login.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;
import x7.a;

public final class TpSetPwdDialog extends CommonDialog {
    private ISetPasswordCallback mSetPasswordCallback;
    private a socialInfo;
    private String thirdPartType;
    private String tpSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TpSetPwdDialog(Context context, String str, String str2, a aVar) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
        i.g(str, "thirdPartType");
        i.g(str2, "tpSource");
        i.g(aVar, "socialInfo");
        this.thirdPartType = str;
        this.tpSource = str2;
        this.socialInfo = aVar;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(TpSetPwdDialog tpSetPwdDialog, View view) {
        i.g(tpSetPwdDialog, "this$0");
        ISetPasswordCallback iSetPasswordCallback = tpSetPwdDialog.mSetPasswordCallback;
        if (iSetPasswordCallback != null) {
            iSetPasswordCallback.dialogRevokeAccessGoogle();
        }
        tpSetPwdDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(TpSetPwdDialog tpSetPwdDialog, View view) {
        i.g(tpSetPwdDialog, "this$0");
        int i10 = R$id.mEditPassword;
        if (b0.J(((EditText) tpSetPwdDialog.findViewById(i10)).getText())) {
            int i11 = R$id.mTvError;
            ((TextView) tpSetPwdDialog.findViewById(i11)).setVisibility(0);
            ((TextView) tpSetPwdDialog.findViewById(i11)).setText(R.string.enter_password_hint);
        } else if (!j1.f(((EditText) tpSetPwdDialog.findViewById(i10)).getText().toString())) {
            int i12 = R$id.mTvError;
            ((TextView) tpSetPwdDialog.findViewById(i12)).setVisibility(0);
            ((TextView) tpSetPwdDialog.findViewById(i12)).setText(R.string.google_set_password_error);
        } else {
            ISetPasswordCallback iSetPasswordCallback = tpSetPwdDialog.mSetPasswordCallback;
            if (iSetPasswordCallback != null) {
                iSetPasswordCallback.setPasswordAndBind(tpSetPwdDialog.thirdPartType, tpSetPwdDialog.tpSource, tpSetPwdDialog.socialInfo, ((EditText) tpSetPwdDialog.findViewById(i10)).getText().toString());
            }
            tpSetPwdDialog.dismiss();
        }
    }

    public int getDialogHeight() {
        return -2;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_tp_set_pwd;
    }

    public final a getSocialInfo() {
        return this.socialInfo;
    }

    public final String getThirdPartType() {
        return this.thirdPartType;
    }

    public final String getTpSource() {
        return this.tpSource;
    }

    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new i(this));
        ((EditText) findViewById(R$id.mEditPassword)).addTextChangedListener(new TpSetPwdDialog$initListener$2(this));
        ((KoocanButton) findViewById(R$id.mKbConfirm)).setOnClickListener(new j(this));
    }

    public void initView() {
        setCancelable(false);
    }

    public final TpSetPwdDialog setSetPasswordCallback(ISetPasswordCallback iSetPasswordCallback) {
        i.g(iSetPasswordCallback, "callback");
        this.mSetPasswordCallback = iSetPasswordCallback;
        return this;
    }

    public final void setSocialInfo(a aVar) {
        i.g(aVar, "<set-?>");
        this.socialInfo = aVar;
    }

    public final void setThirdPartType(String str) {
        i.g(str, "<set-?>");
        this.thirdPartType = str;
    }

    public final void setTpSource(String str) {
        i.g(str, "<set-?>");
        this.tpSource = str;
    }
}
