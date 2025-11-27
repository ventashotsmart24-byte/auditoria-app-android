package com.umeng.message.api;

public interface UPushRegisterCallback {
    void onFailure(String str, String str2);

    void onSuccess(String str);
}
