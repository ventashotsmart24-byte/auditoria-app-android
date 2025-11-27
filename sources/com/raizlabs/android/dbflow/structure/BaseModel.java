package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.annotation.ColumnIgnore;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

public class BaseModel implements Model {
    @ColumnIgnore
    private transient ModelAdapter modelAdapter;

    public enum Action {
        SAVE,
        INSERT,
        UPDATE,
        DELETE,
        CHANGE
    }

    public AsyncModel<? extends Model> async() {
        return new AsyncModel<>(this);
    }

    public boolean delete() {
        return getModelAdapter().delete(this);
    }

    public boolean exists() {
        return getModelAdapter().exists(this);
    }

    public ModelAdapter getModelAdapter() {
        if (this.modelAdapter == null) {
            this.modelAdapter = FlowManager.getModelAdapter(getClass());
        }
        return this.modelAdapter;
    }

    public long insert() {
        return getModelAdapter().insert(this);
    }

    public void load() {
        getModelAdapter().load(this);
    }

    public boolean save() {
        return getModelAdapter().save(this);
    }

    public boolean update() {
        return getModelAdapter().update(this);
    }

    public boolean delete(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().delete(this, databaseWrapper);
    }

    public boolean exists(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().exists(this, databaseWrapper);
    }

    public long insert(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().insert(this, databaseWrapper);
    }

    public void load(DatabaseWrapper databaseWrapper) {
        getModelAdapter().load(this, databaseWrapper);
    }

    public boolean save(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().save(this, databaseWrapper);
    }

    public boolean update(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().update(this, databaseWrapper);
    }
}
