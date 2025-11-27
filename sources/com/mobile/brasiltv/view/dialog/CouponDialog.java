package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.mine.activity.MyBenefitsAty;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;

public final class CouponDialog extends BaseDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponDialog(Context context) {
        super(context);
        i.g(context, f.X);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(CouponDialog couponDialog, View view) {
        i.g(couponDialog, "this$0");
        couponDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(CouponDialog couponDialog, View view) {
        i.g(couponDialog, "this$0");
        if (i.b(w6.i.f9510g.I(), "1")) {
            couponDialog.getContext().startActivity(new Intent(couponDialog.getContext(), AccountBindAty.class));
            couponDialog.dismiss();
            return;
        }
        MyBenefitsAty.a aVar = MyBenefitsAty.f12342r;
        Context context = couponDialog.getContext();
        i.f(context, f.X);
        MyBenefitsAty.a.b(aVar, context, 1, false, 4, (Object) null);
    }

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_coupon);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = AutoUtils.getPercentWidthSize(520);
            layoutParams.height = AutoUtils.getPercentWidthSize(450);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        ((TextView) findViewById(R$id.mTvOff)).setOnClickListener(new o(this));
        ((TextView) findViewById(R$id.mTvUse)).setOnClickListener(new p(this));
        setCancelable(false);
    }
}
