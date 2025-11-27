package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.BaseAsyncObject;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import java.lang.ref.WeakReference;

public class AsyncModel<TModel> extends BaseAsyncObject<AsyncModel<TModel>> implements Model {
    private final TModel model;
    private ModelAdapter<TModel> modelAdapter;
    private transient WeakReference<OnModelChangedListener<TModel>> onModelChangedListener;

    public interface OnModelChangedListener<T> {
        void onModelChanged(T t10);
    }

    public AsyncModel(TModel tmodel) {
        super(tmodel.getClass());
        this.model = tmodel;
    }

    /* access modifiers changed from: private */
    public ModelAdapter<TModel> getModelAdapter() {
        if (this.modelAdapter == null) {
            this.modelAdapter = FlowManager.getModelAdapter(this.model.getClass());
        }
        return this.modelAdapter;
    }

    public AsyncModel<? extends Model> async() {
        return this;
    }

    public boolean delete(DatabaseWrapper databaseWrapper) {
        return delete();
    }

    public boolean exists(DatabaseWrapper databaseWrapper) {
        return exists();
    }

    public long insert(DatabaseWrapper databaseWrapper) {
        return insert();
    }

    public void load(DatabaseWrapper databaseWrapper) {
        load();
    }

    public void onSuccess(Transaction transaction) {
        WeakReference<OnModelChangedListener<TModel>> weakReference = this.onModelChangedListener;
        if (weakReference != null && weakReference.get() != null) {
            this.onModelChangedListener.get().onModelChanged(this.model);
        }
    }

    public boolean save(DatabaseWrapper databaseWrapper) {
        return save();
    }

    public boolean update(DatabaseWrapper databaseWrapper) {
        return update();
    }

    public AsyncModel<TModel> withListener(OnModelChangedListener<TModel> onModelChangedListener2) {
        this.onModelChangedListener = new WeakReference<>(onModelChangedListener2);
        return this;
    }

    public boolean delete() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() {
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().delete(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
        return false;
    }

    public boolean exists() {
        return getModelAdapter().exists(this.model);
    }

    public long insert() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() {
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().insert(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
        return -1;
    }

    public void load() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() {
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().load(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
    }

    public boolean save() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() {
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().save(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
        return false;
    }

    public boolean update() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() {
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().update(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
        return false;
    }
}
