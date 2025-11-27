package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;

public final class CommonAlertDialog extends CommonDialog {
    private String alertContent;
    private String cancelText;
    private String confirmText;
    private ICommonAlertCallback mCommonAlertCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonAlertDialog(Context context, String str, String str2, String str3) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
        i.g(str, "alertContent");
        i.g(str2, "cancelText");
        i.g(str3, "confirmText");
        this.alertContent = str;
        this.cancelText = str2;
        this.confirmText = str3;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(CommonAlertDialog commonAlertDialog, View view) {
        i.g(commonAlertDialog, "this$0");
        ICommonAlertCallback iCommonAlertCallback = commonAlertDialog.mCommonAlertCallback;
        if (iCommonAlertCallback != null) {
            iCommonAlertCallback.onCancel(commonAlertDialog);
        }
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(CommonAlertDialog commonAlertDialog, View view) {
        i.g(commonAlertDialog, "this$0");
        ICommonAlertCallback iCommonAlertCallback = commonAlertDialog.mCommonAlertCallback;
        if (iCommonAlertCallback != null) {
            iCommonAlertCallback.onConfirm(commonAlertDialog);
        }
    }

    public final String getAlertContent() {
        return this.alertContent;
    }

    public final String getCancelText() {
        return this.cancelText;
    }

    public final String getConfirmText() {
        return this.confirmText;
    }

    public int getDialogHeight() {
        return 360;
    }

    public int getDialogWidth() {
        return 560;
    }

    public int getLayoutId() {
        return R.layout.dialog_common_alert;
    }

    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new l(this));
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new m(this));
    }

    public void initView() {
        ((TextView) findViewById(R$id.mTvAlertContent)).setText(this.alertContent);
        ((TextView) findViewById(R$id.mTvCancel)).setText(this.cancelText);
        ((TextView) findViewById(R$id.mTvConfirm)).setText(this.confirmText);
    }

    public final void setAlertContent(String str) {
        i.g(str, "<set-?>");
        this.alertContent = str;
    }

    public final void setCancelText(String str) {
        i.g(str, "<set-?>");
        this.cancelText = str;
    }

    public final CommonAlertDialog setCommonAlertCallback(ICommonAlertCallback iCommonAlertCallback) {
        i.g(iCommonAlertCallback, "callback");
        this.mCommonAlertCallback = iCommonAlertCallback;
        return this;
    }

    public final void setConfirmText(String str) {
        i.g(str, "<set-?>");
        this.confirmText = str;
    }
}
