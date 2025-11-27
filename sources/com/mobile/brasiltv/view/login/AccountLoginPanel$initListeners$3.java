package com.mobile.brasiltv.view.login;

import android.text.TextUtils;
import t9.i;

public final class AccountLoginPanel$initListeners$3 implements IAccountEditCallback {
    final /* synthetic */ AccountLoginPanel this$0;

    public AccountLoginPanel$initListeners$3(AccountLoginPanel accountLoginPanel) {
        this.this$0 = accountLoginPanel;
    }

    public void onTextChanged(String str) {
        i.g(str, "content");
        this.this$0.mFindAccount = !TextUtils.isEmpty(str);
        this.this$0.updateLoginBtnEnable();
    }
}
