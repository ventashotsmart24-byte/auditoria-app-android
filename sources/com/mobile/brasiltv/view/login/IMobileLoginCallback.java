package com.mobile.brasiltv.view.login;

public interface IMobileLoginCallback {
    void onClosePanel();

    void onForgetPwd();

    void onMobileLogin(String str, String str2, String str3, String str4);

    void onPickArea();

    void onUseSmsLogin();
}
