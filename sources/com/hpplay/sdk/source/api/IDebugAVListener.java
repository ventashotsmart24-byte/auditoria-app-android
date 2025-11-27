package com.hpplay.sdk.source.api;

public interface IDebugAVListener {
    void onAudioCallback(long j10, int i10, int i11, int i12, byte[] bArr);

    void onVideoCallback(long j10, int i10, int i11, int i12, byte[] bArr);
}
