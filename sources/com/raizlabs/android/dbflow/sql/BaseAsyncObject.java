package com.raizlabs.android.dbflow.sql;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

public class BaseAsyncObject<TAsync> {
    /* access modifiers changed from: private */
    public Transaction currentTransaction;
    private final DatabaseDefinition databaseDefinition;
    private final Transaction.Error error = new Transaction.Error() {
        public void onError(Transaction transaction, Throwable th) {
            if (BaseAsyncObject.this.errorCallback != null) {
                BaseAsyncObject.this.errorCallback.onError(transaction, th);
            }
            BaseAsyncObject.this.onError(transaction, th);
            Transaction unused = BaseAsyncObject.this.currentTransaction = null;
        }
    };
    /* access modifiers changed from: private */
    public Transaction.Error errorCallback;
    private final Transaction.Success success = new Transaction.Success() {
        public void onSuccess(Transaction transaction) {
            if (BaseAsyncObject.this.successCallback != null) {
                BaseAsyncObject.this.successCallback.onSuccess(transaction);
            }
            BaseAsyncObject.this.onSuccess(transaction);
            Transaction unused = BaseAsyncObject.this.currentTransaction = null;
        }
    };
    /* access modifiers changed from: private */
    public Transaction.Success successCallback;
    private final Class<?> table;

    public BaseAsyncObject(Class<?> cls) {
        this.table = cls;
        this.databaseDefinition = FlowManager.getDatabaseForTable(cls);
    }

    public void cancel() {
        Transaction transaction = this.currentTransaction;
        if (transaction != null) {
            transaction.cancel();
        }
    }

    public TAsync error(Transaction.Error error2) {
        this.errorCallback = error2;
        return this;
    }

    public void executeTransaction(ITransaction iTransaction) {
        cancel();
        Transaction build = this.databaseDefinition.beginTransactionAsync(iTransaction).error(this.error).success(this.success).build();
        this.currentTransaction = build;
        build.execute();
    }

    public Class<?> getTable() {
        return this.table;
    }

    public void onError(Transaction transaction, Throwable th) {
    }

    public void onSuccess(Transaction transaction) {
    }

    public TAsync success(Transaction.Success success2) {
        this.successCallback = success2;
        return this;
    }
}
