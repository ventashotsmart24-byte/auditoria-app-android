package com.mobile.brasiltv.view.dialog;

import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.input.IAccountInputCallback;

public final class InputPwdDialog$initListener$2 implements IAccountInputCallback {
    final /* synthetic */ InputPwdDialog this$0;

    public InputPwdDialog$initListener$2(InputPwdDialog inputPwdDialog) {
        this.this$0 = inputPwdDialog;
    }

    public void onInputFocused() {
        this.this$0.hideErrorHint();
    }

    public void onTextChanged(boolean z10) {
        ((TextView) this.this$0.findViewById(R$id.mTvConfirm)).setEnabled(z10);
    }
}
