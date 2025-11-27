package com.hpplay.sdk.source.mdns;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReceiveMessageThread extends Thread {
    private static final String TAG = "ReceiveMessageThread";
    private AtomicBoolean isQuit = new AtomicBoolean();
    private BlockingQueue<MessageInfos> mMsgQueue = new LinkedBlockingQueue(20);

    public ReceiveMessageThread() {
        setName(TAG);
    }

    public synchronized void release() {
        this.isQuit.set(true);
        interrupt();
        this.mMsgQueue.clear();
    }

    public void run() {
        super.run();
        this.isQuit.set(false);
        while (!this.isQuit.get() && !isInterrupted()) {
            try {
                MessageInfos take = this.mMsgQueue.take();
                take.getListener().get().receiveMessage(take.getIds().get(), take.getMessage().get());
            } catch (Exception unused) {
                return;
            }
        }
    }

    public synchronized void updateReceiveData(MessageInfos messageInfos) {
        if (!this.isQuit.get()) {
            this.mMsgQueue.offer(messageInfos);
        }
    }
}
