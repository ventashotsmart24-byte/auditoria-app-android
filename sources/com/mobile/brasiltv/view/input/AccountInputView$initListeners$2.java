package com.mobile.brasiltv.view.input;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;

public final class AccountInputView$initListeners$2 implements TextWatcher {
    final /* synthetic */ AccountInputView this$0;

    public AccountInputView$initListeners$2(AccountInputView accountInputView) {
        this.this$0 = accountInputView;
    }

    public void afterTextChanged(Editable editable) {
        int i10;
        boolean K = b0.K(t.W(((EditText) this.this$0._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString());
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(R$id.mIvClearInput);
        if (K) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        IAccountInputCallback access$getMAccountInputCallback$p = this.this$0.mAccountInputCallback;
        if (access$getMAccountInputCallback$p != null) {
            access$getMAccountInputCallback$p.onTextChanged(K);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
