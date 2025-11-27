package com.hpplay.component.browse;

import com.hpplay.component.common.utils.CLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class LelinkBrowseTask extends LelinkBrowseCore implements Runnable {
    private static final String TAG = "LelinkBrowseTask";
    private int count = 1;
    private AtomicBoolean isScaning = new AtomicBoolean();
    private final Object mLock = new Object();
    long releasestart;

    public boolean isScaning() {
        return this.isScaning.get();
    }

    public void releae() {
        CLog.i(TAG, " releae");
        this.releasestart = System.currentTimeMillis();
        this.isScaning.set(false);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }

    public void run() {
        this.isScaning.set(true);
        int i10 = 10;
        while (true) {
            try {
                if (!this.isScaning.get()) {
                    break;
                }
                sendBrowseData(LelinkBrowseCore.BROWSE_PORT);
                int i11 = this.count;
                if (i11 > 60) {
                    break;
                }
                this.count = i11 + 1;
                if (this.isScaning.get()) {
                    synchronized (this.mLock) {
                        this.mLock.wait((long) (this.count * i10));
                    }
                }
                if (i10 < 1000 && (i10 = i10 + (i10 * 2)) > 1000) {
                    i10 = 1000;
                }
            } catch (Exception e10) {
                CLog.w(TAG, (Throwable) e10);
            }
        }
        closeBrowseBroadCast();
        CLog.i(TAG, " stop time " + (System.currentTimeMillis() - this.releasestart));
        CLog.i(TAG, "exit the search thread");
    }
}
