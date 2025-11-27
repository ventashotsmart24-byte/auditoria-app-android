package com.raizlabs.android.dbflow.runtime;

import android.os.Looper;
import android.os.Process;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.Model;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import java.util.ArrayList;
import java.util.Collection;

public class DBBatchSaveQueue extends Thread {
    private static final int MODEL_SAVE_SIZE = 50;
    private static final int sMODEL_SAVE_CHECK_TIME = 30000;
    private DatabaseDefinition databaseDefinition;
    private Runnable emptyTransactionListener;
    private final Transaction.Error errorCallback = new Transaction.Error() {
        public void onError(Transaction transaction, Throwable th) {
            if (DBBatchSaveQueue.this.errorListener != null) {
                DBBatchSaveQueue.this.errorListener.onError(transaction, th);
            }
        }
    };
    /* access modifiers changed from: private */
    public Transaction.Error errorListener;
    private boolean isQuitting = false;
    private long modelSaveCheckTime = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
    private int modelSaveSize = 50;
    private final ProcessModelTransaction.ProcessModel modelSaver = new ProcessModelTransaction.ProcessModel() {
        public void processModel(Object obj, DatabaseWrapper databaseWrapper) {
            if (obj instanceof Model) {
                ((Model) obj).save();
            } else if (obj != null) {
                FlowManager.getModelAdapter(obj.getClass()).save(obj);
            }
        }
    };
    private final ArrayList<Object> models;
    private final Transaction.Success successCallback = new Transaction.Success() {
        public void onSuccess(Transaction transaction) {
            if (DBBatchSaveQueue.this.successListener != null) {
                DBBatchSaveQueue.this.successListener.onSuccess(transaction);
            }
        }
    };
    /* access modifiers changed from: private */
    public Transaction.Success successListener;

    public DBBatchSaveQueue(DatabaseDefinition databaseDefinition2) {
        super("DBBatchSaveQueue");
        this.databaseDefinition = databaseDefinition2;
        this.models = new ArrayList<>();
    }

    public void add(Object obj) {
        synchronized (this.models) {
            this.models.add(obj);
            if (this.models.size() > this.modelSaveSize) {
                interrupt();
            }
        }
    }

    public void addAll(Collection<Object> collection) {
        synchronized (this.models) {
            this.models.addAll(collection);
            if (this.models.size() > this.modelSaveSize) {
                interrupt();
            }
        }
    }

    public void addAll2(Collection<?> collection) {
        synchronized (this.models) {
            this.models.addAll(collection);
            if (this.models.size() > this.modelSaveSize) {
                interrupt();
            }
        }
    }

    public void purgeQueue() {
        interrupt();
    }

    public void quit() {
        this.isQuitting = true;
    }

    public void remove(Object obj) {
        synchronized (this.models) {
            this.models.remove(obj);
        }
    }

    public void removeAll(Collection<Object> collection) {
        synchronized (this.models) {
            this.models.removeAll(collection);
        }
    }

    public void removeAll2(Collection<?> collection) {
        synchronized (this.models) {
            this.models.removeAll(collection);
        }
    }

    public void run() {
        ArrayList arrayList;
        super.run();
        Looper.prepare();
        Process.setThreadPriority(10);
        do {
            synchronized (this.models) {
                arrayList = new ArrayList(this.models);
                this.models.clear();
            }
            if (arrayList.size() > 0) {
                this.databaseDefinition.beginTransactionAsync(new ProcessModelTransaction.Builder(this.modelSaver).addAll(arrayList).build()).success(this.successCallback).error(this.errorCallback).build().execute();
            } else {
                Runnable runnable = this.emptyTransactionListener;
                if (runnable != null) {
                    runnable.run();
                }
            }
            try {
                Thread.sleep(this.modelSaveCheckTime);
            } catch (InterruptedException unused) {
                FlowLog.log(FlowLog.Level.I, "DBRequestQueue Batch interrupted to start saving");
            }
        } while (!this.isQuitting);
    }

    public void setEmptyTransactionListener(Runnable runnable) {
        this.emptyTransactionListener = runnable;
    }

    public void setErrorListener(Transaction.Error error) {
        this.errorListener = error;
    }

    public void setModelSaveCheckTime(long j10) {
        this.modelSaveCheckTime = j10;
    }

    public void setModelSaveSize(int i10) {
        this.modelSaveSize = i10;
    }

    public void setSuccessListener(Transaction.Success success) {
        this.successListener = success;
    }
}
