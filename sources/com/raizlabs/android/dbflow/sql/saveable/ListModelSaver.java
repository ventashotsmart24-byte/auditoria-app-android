package com.raizlabs.android.dbflow.sql.saveable;

import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.Collection;

public class ListModelSaver<TModel> {
    private final ModelSaver<TModel> modelSaver;

    public ListModelSaver(ModelSaver<TModel> modelSaver2) {
        this.modelSaver = modelSaver2;
    }

    public synchronized void deleteAll(Collection<TModel> collection) {
        deleteAll(collection, this.modelSaver.getWritableDatabase());
    }

    public ModelSaver<TModel> getModelSaver() {
        return this.modelSaver;
    }

    public synchronized void insertAll(Collection<TModel> collection) {
        insertAll(collection, this.modelSaver.getWritableDatabase());
    }

    public synchronized void saveAll(Collection<TModel> collection) {
        saveAll(collection, this.modelSaver.getWritableDatabase());
    }

    public synchronized void updateAll(Collection<TModel> collection) {
        updateAll(collection, this.modelSaver.getWritableDatabase());
    }

    public synchronized void deleteAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (!collection.isEmpty()) {
            DatabaseStatement deleteStatement = this.modelSaver.getModelAdapter().getDeleteStatement(databaseWrapper);
            try {
                for (TModel delete : collection) {
                    this.modelSaver.delete(delete, deleteStatement, databaseWrapper);
                }
            } finally {
                deleteStatement.close();
            }
        }
    }

    public synchronized void insertAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (!collection.isEmpty()) {
            DatabaseStatement insertStatement = this.modelSaver.getModelAdapter().getInsertStatement(databaseWrapper);
            try {
                for (TModel insert : collection) {
                    this.modelSaver.insert(insert, insertStatement, databaseWrapper);
                }
            } finally {
                insertStatement.close();
            }
        }
    }

    public synchronized void saveAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (!collection.isEmpty()) {
            DatabaseStatement insertStatement = this.modelSaver.getModelAdapter().getInsertStatement(databaseWrapper);
            DatabaseStatement updateStatement = this.modelSaver.getModelAdapter().getUpdateStatement(databaseWrapper);
            try {
                for (TModel save : collection) {
                    this.modelSaver.save(save, databaseWrapper, insertStatement, updateStatement);
                }
            } finally {
                insertStatement.close();
                updateStatement.close();
            }
        }
    }

    public synchronized void updateAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (!collection.isEmpty()) {
            DatabaseStatement updateStatement = this.modelSaver.getModelAdapter().getUpdateStatement(databaseWrapper);
            try {
                for (TModel update : collection) {
                    this.modelSaver.update(update, databaseWrapper, updateStatement);
                }
            } finally {
                updateStatement.close();
            }
        }
    }
}
