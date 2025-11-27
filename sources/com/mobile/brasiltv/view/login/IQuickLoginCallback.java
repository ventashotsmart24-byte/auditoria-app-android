package com.mobile.brasiltv.view.login;

import com.mobile.brasiltv.db.SwitchAccountBean;

public interface IQuickLoginCallback {
    void onAccountLogin(SwitchAccountBean switchAccountBean);

    void onClosePanel();

    void onLoginExpired(SwitchAccountBean switchAccountBean);

    void onRemoveAccount(int i10, SwitchAccountBean switchAccountBean);
}
