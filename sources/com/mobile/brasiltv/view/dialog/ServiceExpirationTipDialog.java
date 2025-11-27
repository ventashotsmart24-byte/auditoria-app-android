package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.VIPMemberActivity;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Arrays;
import t9.g;
import t9.i;
import t9.z;

public final class ServiceExpirationTipDialog extends BaseDialog {
    private String hintContent;
    private int remainingDays;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServiceExpirationTipDialog(Context context, int i10, String str, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? "" : str);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(ServiceExpirationTipDialog serviceExpirationTipDialog, View view) {
        i.g(serviceExpirationTipDialog, "this$0");
        b0.j(serviceExpirationTipDialog);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(ServiceExpirationTipDialog serviceExpirationTipDialog, View view) {
        i.g(serviceExpirationTipDialog, "this$0");
        Context context = serviceExpirationTipDialog.getContext();
        if (context != null) {
            context.startActivity(new Intent(serviceExpirationTipDialog.getContext(), VIPMemberActivity.class));
        }
        b0.j(serviceExpirationTipDialog);
    }

    public final String getHintContent() {
        return this.hintContent;
    }

    public final int getRemainingDays() {
        return this.remainingDays;
    }

    public void onBackPressed() {
        b0.j(this);
    }

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_servie_expiration_tip);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = AutoUtils.getPercentWidthSize(600);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        if (this.remainingDays == 0) {
            ((TextView) findViewById(R$id.tvContent)).setText(this.hintContent);
            ((TextView) findViewById(R$id.tvConfirm)).setText(R.string.be_a_vip);
        } else {
            z zVar = z.f19601a;
            String str = this.hintContent;
            String format = String.format(str, Arrays.copyOf(new Object[]{"<font color=\"#ff3333\">" + this.remainingDays + "</font>"}, 1));
            i.f(format, "format(format, *args)");
            ((TextView) findViewById(R$id.tvContent)).setText(Html.fromHtml(format));
            ((TextView) findViewById(R$id.tvConfirm)).setText(R.string.renewal_now);
        }
        int i10 = R$id.tvCancel;
        ((TextView) findViewById(i10)).setText(R.string.cancel);
        ((TextView) findViewById(i10)).setOnClickListener(new a1(this));
        ((TextView) findViewById(R$id.tvConfirm)).setOnClickListener(new b1(this));
        setCanceledOnTouchOutside(false);
    }

    public final void setHintContent(String str) {
        i.g(str, "<set-?>");
        this.hintContent = str;
    }

    public final void setRemainingDays(int i10) {
        this.remainingDays = i10;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceExpirationTipDialog(Context context, int i10, String str) {
        super(context);
        i.g(context, f.X);
        i.g(str, "hintContent");
        this.remainingDays = i10;
        this.hintContent = str;
    }
}
