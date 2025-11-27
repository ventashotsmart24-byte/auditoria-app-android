package com.mobile.brasiltv.view.login;

import android.text.TextUtils;
import t9.i;

public final class AccountLoginPanel$initListeners$4 implements IPwdEditCallback {
    final /* synthetic */ AccountLoginPanel this$0;

    public AccountLoginPanel$initListeners$4(AccountLoginPanel accountLoginPanel) {
        this.this$0 = accountLoginPanel;
    }

    public void onTextChanged(String str) {
        i.g(str, "content");
        this.this$0.mFindPassword = !TextUtils.isEmpty(str);
        this.this$0.updateLoginBtnEnable();
    }
}
