package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Process;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.bean.UpdateBean;
import com.mobile.brasiltv.utils.a;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import w6.i;

public class ForceUpgradeExceptionDialog extends Dialog {
    public ForceUpgradeExceptionDialog(Context context, UpdateBean updateBean) {
        super(context, R.style.OptionDialog);
        setContentView(R.layout.dialog_force_upgrade_exception);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(600);
            window.setAttributes(attributes);
        }
        TextView textView = (TextView) findViewById(R.id.dialog_content);
        KoocanButton koocanButton = (KoocanButton) findViewById(R.id.dialog_cancel);
        KoocanButton koocanButton2 = (KoocanButton) findViewById(R.id.dialog_submit);
        TextView textView2 = (TextView) findViewById(R.id.mTvContract);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setText(updateBean.getNote());
        i.c cVar = i.f9510g;
        if (!cVar.k().isEmpty()) {
            textView2.setText(context.getResources().getString(R.string.version_forbidden_upgrade_contract, new Object[]{cVar.k()}));
        } else {
            textView2.setText(context.getResources().getString(R.string.version_forbidden_upgrade_contract, new Object[]{context.getResources().getString(R.string.service_email_address)}));
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        koocanButton.setOnClickListener(new j());
        koocanButton2.setOnClickListener(new k(this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(View view) {
        a.b().e();
        Process.killProcess(Process.myPid());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        dismiss();
    }
}
