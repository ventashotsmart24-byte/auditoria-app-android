package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;

public final class PaymentResultDialog extends CommonDialog {
    private String paymentResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentResultDialog(Context context, String str) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
        i.g(str, "paymentResult");
        this.paymentResult = str;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(PaymentResultDialog paymentResultDialog, View view) {
        i.g(paymentResultDialog, "this$0");
        paymentResultDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(PaymentResultDialog paymentResultDialog, View view) {
        i.g(paymentResultDialog, "this$0");
        paymentResultDialog.dismiss();
    }

    public int getDialogHeight() {
        return 460;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_payment_result;
    }

    public final String getPaymentResult() {
        return this.paymentResult;
    }

    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new p0(this));
        ((TextView) findViewById(R$id.mKbOk)).setOnClickListener(new q0(this));
    }

    public void initView() {
        ((TextView) findViewById(R$id.mTvContent)).setText(this.paymentResult);
    }

    public final void setPaymentResult(String str) {
        i.g(str, "<set-?>");
        this.paymentResult = str;
    }
}
