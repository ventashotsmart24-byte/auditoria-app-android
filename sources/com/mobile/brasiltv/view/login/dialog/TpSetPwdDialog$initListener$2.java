package com.mobile.brasiltv.view.login.dialog;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;

public final class TpSetPwdDialog$initListener$2 implements TextWatcher {
    final /* synthetic */ TpSetPwdDialog this$0;

    public TpSetPwdDialog$initListener$2(TpSetPwdDialog tpSetPwdDialog) {
        this.this$0 = tpSetPwdDialog;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        ((TextView) this.this$0.findViewById(R$id.mTvError)).setVisibility(8);
    }
}
