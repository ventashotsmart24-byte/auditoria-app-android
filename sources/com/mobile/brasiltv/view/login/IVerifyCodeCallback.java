package com.mobile.brasiltv.view.login;

public interface IVerifyCodeCallback {
    void onSendSms();

    void onVerifyCodeChanged(String str);
}
