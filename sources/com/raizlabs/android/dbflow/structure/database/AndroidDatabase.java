package com.raizlabs.android.dbflow.structure.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class AndroidDatabase implements DatabaseWrapper {
    private final SQLiteDatabase database;

    public AndroidDatabase(SQLiteDatabase sQLiteDatabase) {
        this.database = sQLiteDatabase;
    }

    public static AndroidDatabase from(SQLiteDatabase sQLiteDatabase) {
        return new AndroidDatabase(sQLiteDatabase);
    }

    public void beginTransaction() {
        this.database.beginTransaction();
    }

    public DatabaseStatement compileStatement(String str) {
        return AndroidDatabaseStatement.from(this.database.compileStatement(str), this.database);
    }

    public int delete(String str, String str2, String[] strArr) {
        return this.database.delete(str, str2, strArr);
    }

    public void endTransaction() {
        this.database.endTransaction();
    }

    public void execSQL(String str) {
        this.database.execSQL(str);
    }

    public SQLiteDatabase getDatabase() {
        return this.database;
    }

    public int getVersion() {
        return this.database.getVersion();
    }

    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i10) {
        return this.database.insertWithOnConflict(str, str2, contentValues, i10);
    }

    public FlowCursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return FlowCursor.from(this.database.query(str, strArr, str2, strArr2, str3, str4, str5));
    }

    public FlowCursor rawQuery(String str, String[] strArr) {
        return FlowCursor.from(this.database.rawQuery(str, strArr));
    }

    public void setTransactionSuccessful() {
        this.database.setTransactionSuccessful();
    }

    public long updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i10) {
        return (long) this.database.updateWithOnConflict(str, contentValues, str2, strArr, i10);
    }
}
