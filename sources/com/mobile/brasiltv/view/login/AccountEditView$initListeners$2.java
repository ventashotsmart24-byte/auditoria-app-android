package com.mobile.brasiltv.view.login;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import ba.t;
import com.mobile.brasiltv.R$id;

public final class AccountEditView$initListeners$2 implements TextWatcher {
    final /* synthetic */ AccountEditView this$0;

    public AccountEditView$initListeners$2(AccountEditView accountEditView) {
        this.this$0 = accountEditView;
    }

    public void afterTextChanged(Editable editable) {
        String obj = t.W(((EditText) this.this$0._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString();
        if (TextUtils.isEmpty(obj)) {
            ((ImageView) this.this$0._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else {
            ((ImageView) this.this$0._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
        }
        IAccountEditCallback access$getMAccountEditCallback$p = this.this$0.mAccountEditCallback;
        if (access$getMAccountEditCallback$p != null) {
            access$getMAccountEditCallback$p.onTextChanged(obj);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
