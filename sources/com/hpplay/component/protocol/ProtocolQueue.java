package com.hpplay.component.protocol;

import com.hpplay.component.common.utils.CLog;
import java.util.LinkedList;
import java.util.List;

public class ProtocolQueue {
    private static final String TAG = "ProtocolQueue";
    private int mLimitSize = 30;
    private List<ProtocolInfo> mQueue = new LinkedList();

    public synchronized void enqueue(ProtocolInfo protocolInfo) {
        if (this.mQueue.size() >= this.mLimitSize) {
            try {
                this.mQueue.remove(0);
            } catch (Exception e10) {
                CLog.w(TAG, (Throwable) e10);
            }
        }
        if (this.mQueue.size() == 0) {
            notifyAll();
        }
        this.mQueue.add(protocolInfo);
    }

    public synchronized ProtocolInfo next() {
        while (this.mQueue.size() == 0) {
            wait();
        }
        if (this.mQueue.size() >= this.mLimitSize) {
            notifyAll();
        }
        try {
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return null;
        }
        return this.mQueue.remove(0);
    }

    public int queueSize() {
        return this.mQueue.size();
    }

    public void release() {
        this.mQueue.clear();
    }
}
