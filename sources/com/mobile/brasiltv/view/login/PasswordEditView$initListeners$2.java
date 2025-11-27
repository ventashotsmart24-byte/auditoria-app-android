package com.mobile.brasiltv.view.login;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import ba.t;
import com.mobile.brasiltv.R$id;

public final class PasswordEditView$initListeners$2 implements TextWatcher {
    final /* synthetic */ PasswordEditView this$0;

    public PasswordEditView$initListeners$2(PasswordEditView passwordEditView) {
        this.this$0 = passwordEditView;
    }

    public void afterTextChanged(Editable editable) {
        PasswordEditView passwordEditView = this.this$0;
        int i10 = R$id.mEtInput;
        String obj = t.W(((EditText) passwordEditView._$_findCachedViewById(i10)).getText().toString()).toString();
        if (TextUtils.isEmpty(obj)) {
            ((ImageView) this.this$0._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else if (((EditText) this.this$0._$_findCachedViewById(i10)).isFocused()) {
            ((ImageView) this.this$0._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
        } else {
            ((ImageView) this.this$0._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        }
        IPwdEditCallback access$getMPwdEditCallback$p = this.this$0.mPwdEditCallback;
        if (access$getMPwdEditCallback$p != null) {
            access$getMPwdEditCallback$p.onTextChanged(obj);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
