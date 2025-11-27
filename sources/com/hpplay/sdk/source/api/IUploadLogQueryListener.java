package com.hpplay.sdk.source.api;

public interface IUploadLogQueryListener {
    void onError();

    void onQueryResult(String str);
}
