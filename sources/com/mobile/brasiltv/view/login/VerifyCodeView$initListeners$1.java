package com.mobile.brasiltv.view.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import ba.t;
import com.mobile.brasiltv.R$id;

public final class VerifyCodeView$initListeners$1 implements TextWatcher {
    final /* synthetic */ VerifyCodeView this$0;

    public VerifyCodeView$initListeners$1(VerifyCodeView verifyCodeView) {
        this.this$0 = verifyCodeView;
    }

    public void afterTextChanged(Editable editable) {
        IVerifyCodeCallback access$getMVerifyCodeCallback$p = this.this$0.mVerifyCodeCallback;
        if (access$getMVerifyCodeCallback$p != null) {
            access$getMVerifyCodeCallback$p.onVerifyCodeChanged(t.W(((EditText) this.this$0._$_findCachedViewById(R$id.mEtVerifyCode)).getText().toString()).toString());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
