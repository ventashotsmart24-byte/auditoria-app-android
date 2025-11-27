package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.i;

public final class NumberLimitDialog extends BaseDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NumberLimitDialog(Context context) {
        super(context);
        i.g(context, f.X);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(NumberLimitDialog numberLimitDialog, View view) {
        i.g(numberLimitDialog, "this$0");
        numberLimitDialog.dismiss();
        Intent intent = new Intent(numberLimitDialog.getContext(), LoginAty.class);
        intent.putExtra("can_back", false);
        numberLimitDialog.getContext().startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_number_limit);
        setCancelable(false);
        ((TextView) findViewById(R$id.mReLogin)).setOnClickListener(new o0(this));
    }
}
