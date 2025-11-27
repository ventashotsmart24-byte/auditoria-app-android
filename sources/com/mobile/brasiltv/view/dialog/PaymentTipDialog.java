package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import s9.l;
import t9.g;
import t9.i;

public final class PaymentTipDialog extends CommonDialog {
    private l onContinueCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentTipDialog(Context context, l lVar) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
        i.g(lVar, "onContinueCallback");
        this.onContinueCallback = lVar;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(PaymentTipDialog paymentTipDialog, View view) {
        i.g(paymentTipDialog, "this$0");
        paymentTipDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(PaymentTipDialog paymentTipDialog, View view) {
        i.g(paymentTipDialog, "this$0");
        paymentTipDialog.onContinueCallback.invoke(paymentTipDialog);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$2(PaymentTipDialog paymentTipDialog, View view) {
        i.g(paymentTipDialog, "this$0");
        paymentTipDialog.dismiss();
    }

    public int getDialogHeight() {
        return 570;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_payment_tip;
    }

    public final l getOnContinueCallback() {
        return this.onContinueCallback;
    }

    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new r0(this));
        ((TextView) findViewById(R$id.mKbContinue)).setOnClickListener(new s0(this));
        ((TextView) findViewById(R$id.mKbCancel)).setOnClickListener(new t0(this));
    }

    public void initView() {
    }

    public final void setOnContinueCallback(l lVar) {
        i.g(lVar, "<set-?>");
        this.onContinueCallback = lVar;
    }
}
