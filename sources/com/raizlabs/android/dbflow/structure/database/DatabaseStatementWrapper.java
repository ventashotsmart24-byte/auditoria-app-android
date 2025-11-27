package com.raizlabs.android.dbflow.structure.database;

import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.sql.language.BaseQueriable;

public class DatabaseStatementWrapper<TModel> extends BaseDatabaseStatement {
    private final DatabaseStatement databaseStatement;
    private final BaseQueriable<TModel> modelQueriable;

    public DatabaseStatementWrapper(DatabaseStatement databaseStatement2, BaseQueriable<TModel> baseQueriable) {
        this.databaseStatement = databaseStatement2;
        this.modelQueriable = baseQueriable;
    }

    public void bindBlob(int i10, byte[] bArr) {
        this.databaseStatement.bindBlob(i10, bArr);
    }

    public void bindDouble(int i10, double d10) {
        this.databaseStatement.bindDouble(i10, d10);
    }

    public void bindLong(int i10, long j10) {
        this.databaseStatement.bindLong(i10, j10);
    }

    public void bindNull(int i10) {
        this.databaseStatement.bindNull(i10);
    }

    public void bindString(int i10, String str) {
        this.databaseStatement.bindString(i10, str);
    }

    public void close() {
        this.databaseStatement.close();
    }

    public void execute() {
        this.databaseStatement.execute();
    }

    public long executeInsert() {
        long executeInsert = this.databaseStatement.executeInsert();
        if (executeInsert > 0) {
            NotifyDistributor.get().notifyTableChanged(this.modelQueriable.getTable(), this.modelQueriable.getPrimaryAction());
        }
        return executeInsert;
    }

    public long executeUpdateDelete() {
        long executeUpdateDelete = this.databaseStatement.executeUpdateDelete();
        if (executeUpdateDelete > 0) {
            NotifyDistributor.get().notifyTableChanged(this.modelQueriable.getTable(), this.modelQueriable.getPrimaryAction());
        }
        return executeUpdateDelete;
    }

    public long simpleQueryForLong() {
        return this.databaseStatement.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        return this.databaseStatement.simpleQueryForString();
    }
}
