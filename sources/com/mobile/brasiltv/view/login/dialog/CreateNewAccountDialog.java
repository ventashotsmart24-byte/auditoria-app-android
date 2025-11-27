package com.mobile.brasiltv.view.login.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;
import x7.a;

public final class CreateNewAccountDialog extends CommonDialog {
    private ICreateNewAccountCallback mCreateNewAccountCallback;
    private a socialInfo;
    private String thirdPartType;
    private String tpSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateNewAccountDialog(Context context, String str, String str2, a aVar) {
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
    public static final void initListener$lambda$0(CreateNewAccountDialog createNewAccountDialog, View view) {
        i.g(createNewAccountDialog, "this$0");
        ICreateNewAccountCallback iCreateNewAccountCallback = createNewAccountDialog.mCreateNewAccountCallback;
        if (iCreateNewAccountCallback != null) {
            iCreateNewAccountCallback.dialogRevokeAccessGoogle();
        }
        createNewAccountDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(CreateNewAccountDialog createNewAccountDialog, View view) {
        i.g(createNewAccountDialog, "this$0");
        ICreateNewAccountCallback iCreateNewAccountCallback = createNewAccountDialog.mCreateNewAccountCallback;
        if (iCreateNewAccountCallback != null) {
            iCreateNewAccountCallback.onCreateNewAccount(createNewAccountDialog.thirdPartType, createNewAccountDialog.tpSource, createNewAccountDialog.socialInfo);
        }
        createNewAccountDialog.dismiss();
    }

    public int getDialogHeight() {
        return 420;
    }

    public int getDialogWidth() {
        return 560;
    }

    public int getLayoutId() {
        return R.layout.dialog_create_new_account;
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
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new d(this));
        ((KoocanButton) findViewById(R$id.mKbOk)).setOnClickListener(new e(this));
    }

    public void initView() {
        ((TextView) findViewById(R$id.mTvHint)).setText(getContext().getResources().getString(R.string.create_new_account_for_you));
        setCancelable(false);
    }

    public final CreateNewAccountDialog setCreateNewAccountCallback(ICreateNewAccountCallback iCreateNewAccountCallback) {
        i.g(iCreateNewAccountCallback, "callback");
        this.mCreateNewAccountCallback = iCreateNewAccountCallback;
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
