package com.hpplay.sdk.source.api;

public interface ICloudMirrorPlayListener {
    void onCloudMessage(long j10, String str);

    void onCloudMirrorStart(boolean z10, String str, String str2, String str3, String str4, String str5);

    void onCloudMirrorStop();
}
