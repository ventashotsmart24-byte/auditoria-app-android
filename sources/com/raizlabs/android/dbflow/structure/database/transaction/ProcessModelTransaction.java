package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProcessModelTransaction<TModel> implements ITransaction {
    final List<TModel> models;
    final OnModelProcessListener<TModel> processListener;
    final ProcessModel<TModel> processModel;
    final boolean runProcessListenerOnSameThread;

    public static final class Builder<TModel> {
        List<TModel> models = new ArrayList();
        OnModelProcessListener<TModel> processListener;
        /* access modifiers changed from: private */
        public final ProcessModel<TModel> processModel;
        /* access modifiers changed from: private */
        public boolean runProcessListenerOnSameThread;

        public Builder(ProcessModel<TModel> processModel2) {
            this.processModel = processModel2;
        }

        public Builder<TModel> add(TModel tmodel) {
            this.models.add(tmodel);
            return this;
        }

        @SafeVarargs
        public final Builder<TModel> addAll(TModel... tmodelArr) {
            this.models.addAll(Arrays.asList(tmodelArr));
            return this;
        }

        public ProcessModelTransaction<TModel> build() {
            return new ProcessModelTransaction<>(this);
        }

        public Builder<TModel> processListener(OnModelProcessListener<TModel> onModelProcessListener) {
            this.processListener = onModelProcessListener;
            return this;
        }

        public Builder<TModel> runProcessListenerOnSameThread(boolean z10) {
            this.runProcessListenerOnSameThread = z10;
            return this;
        }

        public Builder<TModel> addAll(Collection<? extends TModel> collection) {
            if (collection != null) {
                this.models.addAll(collection);
            }
            return this;
        }

        public Builder(Collection<TModel> collection, ProcessModel<TModel> processModel2) {
            this.processModel = processModel2;
            this.models = new ArrayList(collection);
        }
    }

    public interface OnModelProcessListener<TModel> {
        void onModelProcessed(long j10, long j11, TModel tmodel);
    }

    public interface ProcessModel<TModel> {
        void processModel(TModel tmodel, DatabaseWrapper databaseWrapper);
    }

    public ProcessModelTransaction(Builder<TModel> builder) {
        this.processListener = builder.processListener;
        this.models = builder.models;
        this.processModel = builder.processModel;
        this.runProcessListenerOnSameThread = builder.runProcessListenerOnSameThread;
    }

    public void execute(DatabaseWrapper databaseWrapper) {
        List<TModel> list = this.models;
        if (list != null) {
            final int size = list.size();
            for (final int i10 = 0; i10 < size; i10++) {
                final TModel tmodel = this.models.get(i10);
                this.processModel.processModel(tmodel, databaseWrapper);
                OnModelProcessListener<TModel> onModelProcessListener = this.processListener;
                if (onModelProcessListener != null) {
                    if (this.runProcessListenerOnSameThread) {
                        onModelProcessListener.onModelProcessed((long) i10, (long) size, tmodel);
                    } else {
                        Transaction.getTransactionHandler().post(new Runnable() {
                            public void run() {
                                ProcessModelTransaction.this.processListener.onModelProcessed((long) i10, (long) size, tmodel);
                            }
                        });
                    }
                }
            }
        }
    }
}
