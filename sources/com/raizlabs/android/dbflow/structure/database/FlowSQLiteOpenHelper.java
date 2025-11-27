package com.raizlabs.android.dbflow.structure.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;

public class FlowSQLiteOpenHelper extends SQLiteOpenHelper implements OpenHelper {
    private AndroidDatabase androidDatabase;
    private DatabaseHelperDelegate databaseHelperDelegate;

    public class BackupHelper extends SQLiteOpenHelper implements OpenHelper {
        private AndroidDatabase androidDatabase;
        private final BaseDatabaseHelper baseDatabaseHelper;

        public BackupHelper(Context context, String str, int i10, DatabaseDefinition databaseDefinition) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
            this.baseDatabaseHelper = new BaseDatabaseHelper(databaseDefinition);
        }

        public void backupDB() {
        }

        public void closeDB() {
        }

        public DatabaseWrapper getDatabase() {
            if (this.androidDatabase == null) {
                this.androidDatabase = AndroidDatabase.from(getWritableDatabase());
            }
            return this.androidDatabase;
        }

        public DatabaseHelperDelegate getDelegate() {
            return null;
        }

        public boolean isDatabaseIntegrityOk() {
            return false;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.baseDatabaseHelper.onCreate(AndroidDatabase.from(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.baseDatabaseHelper.onDowngrade(AndroidDatabase.from(sQLiteDatabase), i10, i11);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            this.baseDatabaseHelper.onOpen(AndroidDatabase.from(sQLiteDatabase));
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.baseDatabaseHelper.onUpgrade(AndroidDatabase.from(sQLiteDatabase), i10, i11);
        }

        public void performRestoreFromBackup() {
        }

        public void setDatabaseListener(DatabaseHelperListener databaseHelperListener) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlowSQLiteOpenHelper(com.raizlabs.android.dbflow.config.DatabaseDefinition r10, com.raizlabs.android.dbflow.structure.database.DatabaseHelperListener r11) {
        /*
            r9 = this;
            android.content.Context r0 = com.raizlabs.android.dbflow.config.FlowManager.getContext()
            boolean r1 = r10.isInMemory()
            r2 = 0
            if (r1 == 0) goto L_0x000d
            r1 = r2
            goto L_0x0011
        L_0x000d:
            java.lang.String r1 = r10.getDatabaseFileName()
        L_0x0011:
            int r3 = r10.getDatabaseVersion()
            r9.<init>(r0, r1, r2, r3)
            boolean r0 = r10.backupEnabled()
            if (r0 == 0) goto L_0x0032
            com.raizlabs.android.dbflow.structure.database.FlowSQLiteOpenHelper$BackupHelper r2 = new com.raizlabs.android.dbflow.structure.database.FlowSQLiteOpenHelper$BackupHelper
            android.content.Context r5 = com.raizlabs.android.dbflow.config.FlowManager.getContext()
            java.lang.String r6 = com.raizlabs.android.dbflow.structure.database.DatabaseHelperDelegate.getTempDbFileName(r10)
            int r7 = r10.getDatabaseVersion()
            r3 = r2
            r4 = r9
            r8 = r10
            r3.<init>(r5, r6, r7, r8)
        L_0x0032:
            com.raizlabs.android.dbflow.structure.database.DatabaseHelperDelegate r0 = new com.raizlabs.android.dbflow.structure.database.DatabaseHelperDelegate
            r0.<init>(r11, r10, r2)
            r9.databaseHelperDelegate = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.structure.database.FlowSQLiteOpenHelper.<init>(com.raizlabs.android.dbflow.config.DatabaseDefinition, com.raizlabs.android.dbflow.structure.database.DatabaseHelperListener):void");
    }

    public void backupDB() {
        this.databaseHelperDelegate.backupDB();
    }

    public void closeDB() {
        getDatabase();
        this.androidDatabase.getDatabase().close();
    }

    public DatabaseWrapper getDatabase() {
        AndroidDatabase androidDatabase2 = this.androidDatabase;
        if (androidDatabase2 == null || !androidDatabase2.getDatabase().isOpen()) {
            this.androidDatabase = AndroidDatabase.from(getWritableDatabase());
        }
        return this.androidDatabase;
    }

    public DatabaseHelperDelegate getDelegate() {
        return this.databaseHelperDelegate;
    }

    public boolean isDatabaseIntegrityOk() {
        return this.databaseHelperDelegate.isDatabaseIntegrityOk();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.databaseHelperDelegate.onCreate(AndroidDatabase.from(sQLiteDatabase));
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.databaseHelperDelegate.onDowngrade(AndroidDatabase.from(sQLiteDatabase), i10, i11);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.databaseHelperDelegate.onOpen(AndroidDatabase.from(sQLiteDatabase));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.databaseHelperDelegate.onUpgrade(AndroidDatabase.from(sQLiteDatabase), i10, i11);
    }

    public void performRestoreFromBackup() {
        this.databaseHelperDelegate.performRestoreFromBackup();
    }

    public void setDatabaseListener(DatabaseHelperListener databaseHelperListener) {
        this.databaseHelperDelegate.setDatabaseHelperListener(databaseHelperListener);
    }
}
