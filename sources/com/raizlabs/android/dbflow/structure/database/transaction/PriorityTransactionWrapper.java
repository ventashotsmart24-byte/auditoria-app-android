package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class PriorityTransactionWrapper implements ITransaction, Comparable<PriorityTransactionWrapper> {
    public static final int PRIORITY_HIGH = 2;
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_NORMAL = 1;
    public static final int PRIORITY_UI = 5;
    private final int priority;
    private final ITransaction transaction;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int priority;
        /* access modifiers changed from: private */
        public final ITransaction transaction;

        public Builder(ITransaction iTransaction) {
            this.transaction = iTransaction;
        }

        public PriorityTransactionWrapper build() {
            return new PriorityTransactionWrapper(this);
        }

        public Builder priority(int i10) {
            this.priority = i10;
            return this;
        }
    }

    public PriorityTransactionWrapper(Builder builder) {
        if (builder.priority == 0) {
            this.priority = 1;
        } else {
            this.priority = builder.priority;
        }
        this.transaction = builder.transaction;
    }

    public void execute(DatabaseWrapper databaseWrapper) {
        this.transaction.execute(databaseWrapper);
    }

    public int compareTo(PriorityTransactionWrapper priorityTransactionWrapper) {
        return priorityTransactionWrapper.priority - this.priority;
    }
}
