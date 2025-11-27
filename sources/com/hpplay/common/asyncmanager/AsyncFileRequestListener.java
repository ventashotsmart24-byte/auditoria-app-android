package com.hpplay.common.asyncmanager;

public abstract class AsyncFileRequestListener {
    public abstract void onDownloadFinish(AsyncFileParameter asyncFileParameter);

    public void onDownloadUpdate(long j10, long j11) {
    }
}
