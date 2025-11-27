package com.raizlabs.android.dbflow.sql.language;

import android.database.sqlite.SQLiteDoneException;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.queriable.Queriable;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatementWrapper;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public abstract class BaseQueriable<TModel> implements Queriable, Actionable {
    private final Class<TModel> table;

    public BaseQueriable(Class<TModel> cls) {
        this.table = cls;
    }

    public DatabaseStatement compileStatement() {
        return compileStatement(FlowManager.getWritableDatabaseForTable(this.table));
    }

    public long count(DatabaseWrapper databaseWrapper) {
        return longValue(databaseWrapper);
    }

    public void execute() {
        FlowCursor query = query();
        if (query != null) {
            query.close();
        } else {
            NotifyDistributor.get().notifyTableChanged(getTable(), getPrimaryAction());
        }
    }

    public long executeInsert() {
        return executeInsert(FlowManager.getWritableDatabaseForTable(this.table));
    }

    public abstract BaseModel.Action getPrimaryAction();

    public Class<TModel> getTable() {
        return this.table;
    }

    public boolean hasData() {
        return count() > 0;
    }

    public long longValue() {
        return longValue(FlowManager.getWritableDatabaseForTable(this.table));
    }

    public FlowCursor query() {
        query(FlowManager.getWritableDatabaseForTable(this.table));
        return null;
    }

    public String toString() {
        return getQuery();
    }

    public DatabaseStatement compileStatement(DatabaseWrapper databaseWrapper) {
        String query = getQuery();
        FlowLog.Level level = FlowLog.Level.V;
        FlowLog.log(level, "Compiling Query Into Statement: " + query);
        return new DatabaseStatementWrapper(databaseWrapper.compileStatement(query), this);
    }

    public long count() {
        return longValue();
    }

    public long executeInsert(DatabaseWrapper databaseWrapper) {
        DatabaseStatement compileStatement = compileStatement(databaseWrapper);
        try {
            return compileStatement.executeInsert();
        } finally {
            compileStatement.close();
        }
    }

    public boolean hasData(DatabaseWrapper databaseWrapper) {
        return count(databaseWrapper) > 0;
    }

    public long longValue(DatabaseWrapper databaseWrapper) {
        try {
            String query = getQuery();
            FlowLog.Level level = FlowLog.Level.V;
            FlowLog.log(level, "Executing query: " + query);
            return SqlUtils.longForQuery(databaseWrapper, query);
        } catch (SQLiteDoneException e10) {
            FlowLog.log(FlowLog.Level.W, (Throwable) e10);
            return 0;
        }
    }

    public FlowCursor query(DatabaseWrapper databaseWrapper) {
        if (getPrimaryAction().equals(BaseModel.Action.INSERT)) {
            DatabaseStatement compileStatement = compileStatement(databaseWrapper);
            compileStatement.executeInsert();
            compileStatement.close();
            return null;
        }
        String query = getQuery();
        FlowLog.Level level = FlowLog.Level.V;
        FlowLog.log(level, "Executing query: " + query);
        databaseWrapper.execSQL(query);
        return null;
    }

    public void execute(DatabaseWrapper databaseWrapper) {
        FlowCursor query = query(databaseWrapper);
        if (query != null) {
            query.close();
        } else {
            NotifyDistributor.get().notifyTableChanged(getTable(), getPrimaryAction());
        }
    }
}
