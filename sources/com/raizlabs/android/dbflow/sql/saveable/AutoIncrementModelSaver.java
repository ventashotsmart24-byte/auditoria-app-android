package com.raizlabs.android.dbflow.sql.saveable;

import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

public class AutoIncrementModelSaver<TModel> extends ModelSaver<TModel> {
    public synchronized long insert(TModel tmodel) {
        return insert(tmodel, getWritableDatabase());
    }

    public synchronized long insert(TModel tmodel, DatabaseWrapper databaseWrapper) {
        DatabaseStatement databaseStatement;
        long executeInsert;
        boolean hasAutoIncrement = getModelAdapter().hasAutoIncrement(tmodel);
        if (hasAutoIncrement) {
            databaseStatement = getModelAdapter().getCompiledStatement(databaseWrapper);
        } else {
            databaseStatement = getModelAdapter().getInsertStatement(databaseWrapper);
        }
        try {
            getModelAdapter().saveForeignKeys(tmodel, databaseWrapper);
            if (hasAutoIncrement) {
                getModelAdapter().bindToStatement(databaseStatement, tmodel);
            } else {
                getModelAdapter().bindToInsertStatement(databaseStatement, tmodel);
            }
            executeInsert = databaseStatement.executeInsert();
            if (executeInsert > -1) {
                getModelAdapter().updateAutoIncrement(tmodel, Long.valueOf(executeInsert));
                NotifyDistributor.get().notifyModelChanged(tmodel, getModelAdapter(), BaseModel.Action.INSERT);
            }
        } finally {
            databaseStatement.close();
        }
        return executeInsert;
    }

    public synchronized long insert(TModel tmodel, DatabaseStatement databaseStatement, DatabaseWrapper databaseWrapper) {
        if (!getModelAdapter().hasAutoIncrement(tmodel)) {
            return super.insert(tmodel, databaseStatement, databaseWrapper);
        }
        FlowLog.Level level = FlowLog.Level.W;
        FlowLog.log(level, "Ignoring insert statement " + databaseStatement + " since an autoincrement column specified in the insert.");
        return insert(tmodel, databaseWrapper);
    }
}
