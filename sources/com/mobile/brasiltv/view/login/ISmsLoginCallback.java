package com.mobile.brasiltv.view.login;

public interface ISmsLoginCallback {
    void onClosePanel();

    void onPickArea();

    void onSendSms(String str, String str2, String str3);

    void onSmsLogin(String str, String str2, String str3, String str4);

    void onUseMobileLogin();
}
