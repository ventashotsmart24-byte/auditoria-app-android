package com.raizlabs.android.dbflow.structure.database.transaction;

import android.os.Looper;
import android.os.Process;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.structure.database.transaction.PriorityTransactionWrapper;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityTransactionQueue extends Thread implements ITransactionQueue {
    private boolean isQuitting = false;
    private final PriorityBlockingQueue<PriorityEntry<Transaction>> queue = new PriorityBlockingQueue<>();

    public class PriorityEntry<E extends Transaction> implements Comparable<PriorityEntry<Transaction>> {
        final E entry;
        final PriorityTransactionWrapper transactionWrapper;

        public PriorityEntry(E e10) {
            this.entry = e10;
            if (e10.transaction() instanceof PriorityTransactionWrapper) {
                this.transactionWrapper = (PriorityTransactionWrapper) e10.transaction();
            } else {
                this.transactionWrapper = new PriorityTransactionWrapper.Builder(e10.transaction()).build();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PriorityTransactionWrapper priorityTransactionWrapper = this.transactionWrapper;
            PriorityTransactionWrapper priorityTransactionWrapper2 = ((PriorityEntry) obj).transactionWrapper;
            if (priorityTransactionWrapper != null) {
                return priorityTransactionWrapper.equals(priorityTransactionWrapper2);
            }
            if (priorityTransactionWrapper2 == null) {
                return true;
            }
            return false;
        }

        public E getEntry() {
            return this.entry;
        }

        public int hashCode() {
            PriorityTransactionWrapper priorityTransactionWrapper = this.transactionWrapper;
            if (priorityTransactionWrapper != null) {
                return priorityTransactionWrapper.hashCode();
            }
            return 0;
        }

        public int compareTo(PriorityEntry<Transaction> priorityEntry) {
            return this.transactionWrapper.compareTo(priorityEntry.transactionWrapper);
        }
    }

    public PriorityTransactionQueue(String str) {
        super(str);
    }

    private void throwInvalidTransactionType(Transaction transaction) {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction of type:");
        if (transaction != null) {
            obj = transaction.transaction().getClass();
        } else {
            obj = "Unknown";
        }
        sb.append(obj);
        sb.append(" should be of type PriorityTransactionWrapper");
        throw new IllegalArgumentException(sb.toString());
    }

    public void add(Transaction transaction) {
        synchronized (this.queue) {
            PriorityEntry priorityEntry = new PriorityEntry(transaction);
            if (!this.queue.contains(priorityEntry)) {
                this.queue.add(priorityEntry);
            }
        }
    }

    public void cancel(Transaction transaction) {
        synchronized (this.queue) {
            PriorityEntry priorityEntry = new PriorityEntry(transaction);
            if (this.queue.contains(priorityEntry)) {
                this.queue.remove(priorityEntry);
            }
        }
    }

    public void quit() {
        this.isQuitting = true;
        interrupt();
    }

    public void run() {
        Looper.prepare();
        Process.setThreadPriority(10);
        while (true) {
            try {
                this.queue.take().entry.executeSync();
            } catch (InterruptedException unused) {
                if (this.isQuitting) {
                    synchronized (this.queue) {
                        this.queue.clear();
                        return;
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
            Iterator<PriorityEntry<Transaction>> it = this.queue.iterator();
            while (it.hasNext()) {
                E e10 = it.next().entry;
                if (e10.name() != null && e10.name().equals(str)) {
                    it.remove();
                }
            }
        }
    }
}
