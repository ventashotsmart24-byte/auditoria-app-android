package com.mobile.brasiltv.view.login;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.i0;
import t9.i;

public final class PickAreaView$initListeners$3 implements TextWatcher {
    final /* synthetic */ PickAreaView this$0;

    public PickAreaView$initListeners$3(PickAreaView pickAreaView) {
        this.this$0 = pickAreaView;
    }

    public void afterTextChanged(Editable editable) {
        i0 i0Var = i0.f12587a;
        PickAreaView pickAreaView = this.this$0;
        int i10 = R$id.mEtInput;
        EditText editText = (EditText) pickAreaView._$_findCachedViewById(i10);
        i.f(editText, "mEtInput");
        i0Var.a(editText, this, this.this$0.mArea);
        String obj = t.W(((EditText) this.this$0._$_findCachedViewById(i10)).getText().toString()).toString();
        if (TextUtils.isEmpty(obj)) {
            ((ImageView) this.this$0._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else {
            ((ImageView) this.this$0._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
        }
        IPickAreaCallback access$getMPickAreaCallback$p = this.this$0.mPickAreaCallback;
        if (access$getMPickAreaCallback$p != null) {
            access$getMPickAreaCallback$p.onTextChanged(obj);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
