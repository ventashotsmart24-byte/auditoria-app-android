package com.raizlabs.android.dbflow.structure.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class AndroidDatabaseStatement extends BaseDatabaseStatement {
    private final SQLiteDatabase database;
    private final SQLiteStatement statement;

    public AndroidDatabaseStatement(SQLiteStatement sQLiteStatement, SQLiteDatabase sQLiteDatabase) {
        this.statement = sQLiteStatement;
        this.database = sQLiteDatabase;
    }

    public static AndroidDatabaseStatement from(SQLiteStatement sQLiteStatement, SQLiteDatabase sQLiteDatabase) {
        return new AndroidDatabaseStatement(sQLiteStatement, sQLiteDatabase);
    }

    public void bindBlob(int i10, byte[] bArr) {
        this.statement.bindBlob(i10, bArr);
    }

    public void bindDouble(int i10, double d10) {
        this.statement.bindDouble(i10, d10);
    }

    public void bindLong(int i10, long j10) {
        this.statement.bindLong(i10, j10);
    }

    public void bindNull(int i10) {
        this.statement.bindNull(i10);
    }

    public void bindString(int i10, String str) {
        this.statement.bindString(i10, str);
    }

    public void close() {
        this.statement.close();
    }

    public void execute() {
        this.statement.execute();
    }

    public long executeInsert() {
        return this.statement.executeInsert();
    }

    public long executeUpdateDelete() {
        return (long) this.statement.executeUpdateDelete();
    }

    public SQLiteStatement getStatement() {
        return this.statement;
    }

    public long simpleQueryForLong() {
        return this.statement.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        return this.statement.simpleQueryForString();
    }
}
