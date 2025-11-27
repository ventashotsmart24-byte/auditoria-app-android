package com.raizlabs.android.dbflow.sql.saveable;

import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.Collection;

public class CacheableListModelSaver<TModel> extends ListModelSaver<TModel> {
    public CacheableListModelSaver(ModelSaver<TModel> modelSaver) {
        super(modelSaver);
    }

    public synchronized void deleteAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (!collection.isEmpty()) {
            ModelSaver modelSaver = getModelSaver();
            for (TModel next : collection) {
                if (modelSaver.delete(next, databaseWrapper)) {
                    getModelSaver().getModelAdapter().removeModelFromCache(next);
                }
            }
        }
    }

    public synchronized void insertAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (!collection.isEmpty()) {
            ModelSaver modelSaver = getModelSaver();
            ModelAdapter modelAdapter = modelSaver.getModelAdapter();
            DatabaseStatement insertStatement = modelAdapter.getInsertStatement(databaseWrapper);
            try {
                for (TModel next : collection) {
                    if (modelSaver.insert(next, insertStatement, databaseWrapper) > 0) {
                        modelAdapter.storeModelInCache(next);
                    }
                }
            } finally {
                insertStatement.close();
            }
        }
    }

    public synchronized void saveAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (!collection.isEmpty()) {
            ModelSaver modelSaver = getModelSaver();
            ModelAdapter modelAdapter = modelSaver.getModelAdapter();
            DatabaseStatement insertStatement = modelAdapter.getInsertStatement(databaseWrapper);
            DatabaseStatement updateStatement = modelAdapter.getUpdateStatement(databaseWrapper);
            try {
                for (TModel next : collection) {
                    if (modelSaver.save(next, databaseWrapper, insertStatement, updateStatement)) {
                        modelAdapter.storeModelInCache(next);
                    }
                }
            } finally {
                updateStatement.close();
                insertStatement.close();
            }
        }
    }

    public synchronized void updateAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (!collection.isEmpty()) {
            ModelSaver modelSaver = getModelSaver();
            ModelAdapter modelAdapter = modelSaver.getModelAdapter();
            DatabaseStatement updateStatement = modelAdapter.getUpdateStatement(databaseWrapper);
            try {
                for (TModel next : collection) {
                    if (modelSaver.update(next, databaseWrapper, updateStatement)) {
                        modelAdapter.storeModelInCache(next);
                    }
                }
            } finally {
                updateStatement.close();
            }
        }
    }
}
