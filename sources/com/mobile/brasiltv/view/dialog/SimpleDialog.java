package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.i;

public final class SimpleDialog extends Dialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleDialog(Context context) {
        super(context, R.style.SimpleDialog);
        i.g(context, f.X);
        setContentView(R.layout.dialog_simple);
        ((TextView) findViewById(R$id.mButtonOK)).setOnClickListener(new c1(this));
        setCancelable(false);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(SimpleDialog simpleDialog, View view) {
        i.g(simpleDialog, "this$0");
        simpleDialog.cancel();
    }

    public final void setMessage(int i10) {
        ((TextView) findViewById(R$id.mTextMessage)).setText(getContext().getResources().getString(i10));
    }
}
