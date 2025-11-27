package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.InternalAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FastStoreModelTransaction<TModel> implements ITransaction {
    final InternalAdapter<TModel> internalAdapter;
    final List<TModel> models;
    final ProcessModelList<TModel> processModelList;

    public static final class Builder<TModel> {
        /* access modifiers changed from: private */
        public final InternalAdapter<TModel> internalAdapter;
        List<TModel> models = new ArrayList();
        /* access modifiers changed from: private */
        public final ProcessModelList<TModel> processModelList;

        public Builder(ProcessModelList<TModel> processModelList2, InternalAdapter<TModel> internalAdapter2) {
            this.processModelList = processModelList2;
            this.internalAdapter = internalAdapter2;
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

        public FastStoreModelTransaction<TModel> build() {
            return new FastStoreModelTransaction<>(this);
        }

        public Builder<TModel> addAll(Collection<? extends TModel> collection) {
            if (collection != null) {
                this.models.addAll(collection);
            }
            return this;
        }
    }

    public interface ProcessModelList<TModel> {
        void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper);
    }

    public FastStoreModelTransaction(Builder<TModel> builder) {
        this.models = builder.models;
        this.processModelList = builder.processModelList;
        this.internalAdapter = builder.internalAdapter;
    }

    public static <TModel> Builder<TModel> deleteBuilder(InternalAdapter<TModel> internalAdapter2) {
        return new Builder<>(new ProcessModelList<TModel>() {
            public void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper) {
                internalAdapter.deleteAll(list, databaseWrapper);
            }
        }, internalAdapter2);
    }

    public static <TModel> Builder<TModel> insertBuilder(InternalAdapter<TModel> internalAdapter2) {
        return new Builder<>(new ProcessModelList<TModel>() {
            public void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper) {
                internalAdapter.insertAll(list, databaseWrapper);
            }
        }, internalAdapter2);
    }

    public static <TModel> Builder<TModel> saveBuilder(InternalAdapter<TModel> internalAdapter2) {
        return new Builder<>(new ProcessModelList<TModel>() {
            public void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper) {
                internalAdapter.saveAll(list, databaseWrapper);
            }
        }, internalAdapter2);
    }

    public static <TModel> Builder<TModel> updateBuilder(InternalAdapter<TModel> internalAdapter2) {
        return new Builder<>(new ProcessModelList<TModel>() {
            public void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper) {
                internalAdapter.updateAll(list, databaseWrapper);
            }
        }, internalAdapter2);
    }

    public void execute(DatabaseWrapper databaseWrapper) {
        List<TModel> list = this.models;
        if (list != null) {
            this.processModelList.processModel(list, this.internalAdapter, databaseWrapper);
        }
    }
}
