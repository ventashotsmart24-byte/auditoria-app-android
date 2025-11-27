package com.mobile.brasiltv.view.input;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.input.CustomInputView;

public final class CustomInputView$initListeners$2 implements TextWatcher {
    final /* synthetic */ CustomInputView this$0;

    public CustomInputView$initListeners$2(CustomInputView customInputView) {
        this.this$0 = customInputView;
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
        CustomInputView.IEmailPrefixInputCallback access$getMEmailPrefixInputCallback$p = this.this$0.mEmailPrefixInputCallback;
        if (access$getMEmailPrefixInputCallback$p != null) {
            access$getMEmailPrefixInputCallback$p.onTextChanged(K);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
