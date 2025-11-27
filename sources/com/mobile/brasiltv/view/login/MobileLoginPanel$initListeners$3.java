package com.mobile.brasiltv.view.login;

import android.text.TextUtils;
import t9.i;

public final class MobileLoginPanel$initListeners$3 implements IPwdEditCallback {
    final /* synthetic */ MobileLoginPanel this$0;

    public MobileLoginPanel$initListeners$3(MobileLoginPanel mobileLoginPanel) {
        this.this$0 = mobileLoginPanel;
    }

    public void onTextChanged(String str) {
        i.g(str, "content");
        this.this$0.mFindPassword = !TextUtils.isEmpty(str);
        this.this$0.updateLoginBtnEnable();
    }
}
