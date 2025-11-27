package com.raizlabs.android.dbflow.structure.database.transaction;

import android.os.Looper;
import android.os.Process;
import com.raizlabs.android.dbflow.config.FlowLog;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class DefaultTransactionQueue extends Thread implements ITransactionQueue {
    private boolean isQuitting = false;
    private final LinkedBlockingQueue<Transaction> queue = new LinkedBlockingQueue<>();

    public DefaultTransactionQueue(String str) {
        super(str);
    }

    public void add(Transaction transaction) {
        synchronized (this.queue) {
            if (!this.queue.contains(transaction)) {
                this.queue.add(transaction);
            }
        }
    }

    public void cancel(Transaction transaction) {
        synchronized (this.queue) {
            if (this.queue.contains(transaction)) {
                this.queue.remove(transaction);
            }
        }
    }

    public void quit() {
        synchronized (this) {
            this.isQuitting = true;
        }
        interrupt();
    }

    public void run() {
        Looper.prepare();
        Process.setThreadPriority(10);
        while (true) {
            try {
                Transaction take = this.queue.take();
                if (!this.isQuitting) {
                    take.executeSync();
                }
            } catch (InterruptedException unused) {
                synchronized (this) {
                    if (this.isQuitting) {
                        synchronized (this.queue) {
                            this.queue.clear();
                            return;
                        }
                    }
                }
            }
        }
    }

    public void startIfNotAlive() {
        synchronized (this) {
            if (!isAlive()) {
                try {
                    start();
                } catch (IllegalThreadStateException e10) {
                    FlowLog.log(FlowLog.Level.E, (Throwable) e10);
                }
            }
        }
    }

    public void cancel(String str) {
        synchronized (this.queue) {
            Iterator<Transaction> it = this.queue.iterator();
            while (it.hasNext()) {
                Transaction next = it.next();
                if (next.name() != null && next.name().equals(str)) {
                    it.remove();
                }
            }
        }
    }
}
