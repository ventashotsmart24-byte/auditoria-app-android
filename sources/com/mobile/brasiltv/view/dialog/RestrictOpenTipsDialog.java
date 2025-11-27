package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.GotoCREvent;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;
import xa.c;

public final class RestrictOpenTipsDialog extends BaseDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RestrictOpenTipsDialog(Context context) {
        super(context);
        i.g(context, f.X);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(RestrictOpenTipsDialog restrictOpenTipsDialog, View view) {
        i.g(restrictOpenTipsDialog, "this$0");
        restrictOpenTipsDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(RestrictOpenTipsDialog restrictOpenTipsDialog, View view) {
        i.g(restrictOpenTipsDialog, "this$0");
        c.c().j(new GotoCREvent());
        restrictOpenTipsDialog.dismiss();
    }

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_restrict_open_tips);
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
        ((TextView) findViewById(R$id.tvCancel)).setOnClickListener(new y0(this));
        ((TextView) findViewById(R$id.tvConfirm)).setOnClickListener(new z0(this));
    }
}
