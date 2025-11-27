package com.hpplay.imsdk;

public interface OnConnectServerListener {
    void onAuthCallback(String str);

    void onConnectFailed();

    void onConnectSuccess();

    void onRestart();
}
