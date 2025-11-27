package com.raizlabs.android.dbflow.structure.database;

import android.content.Context;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.umeng.message.common.inter.ITagManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DatabaseHelperDelegate extends BaseDatabaseHelper {
    public static final String TEMP_DB_NAME = "temp-";
    private final OpenHelper backupHelper;
    private DatabaseHelperListener databaseHelperListener;

    public DatabaseHelperDelegate(DatabaseHelperListener databaseHelperListener2, DatabaseDefinition databaseDefinition, OpenHelper openHelper) {
        super(databaseDefinition);
        this.databaseHelperListener = databaseHelperListener2;
        this.backupHelper = openHelper;
    }

    public static String getTempDbFileName(DatabaseDefinition databaseDefinition) {
        return TEMP_DB_NAME + databaseDefinition.getDatabaseName() + a.f14486d;
    }

    /* access modifiers changed from: private */
    public void writeDB(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
                return;
            }
        }
    }

    public void backupDB() {
        if (!getDatabaseDefinition().backupEnabled() || !getDatabaseDefinition().areConsistencyChecksEnabled()) {
            throw new IllegalStateException("Backups are not enabled for : " + getDatabaseDefinition().getDatabaseName() + ". Please consider adding both backupEnabled and consistency checks enabled to the Database annotation");
        }
        getDatabaseDefinition().beginTransactionAsync(new ITransaction() {
            public void execute(DatabaseWrapper databaseWrapper) {
                Context context = FlowManager.getContext();
                File databasePath = context.getDatabasePath(DatabaseHelperDelegate.this.getTempDbFileName());
                File databasePath2 = context.getDatabasePath("temp--2-" + DatabaseHelperDelegate.this.getDatabaseDefinition().getDatabaseFileName());
                if (databasePath2.exists()) {
                    databasePath2.delete();
                }
                databasePath.renameTo(databasePath2);
                if (databasePath.exists()) {
                    databasePath.delete();
                }
                File databasePath3 = context.getDatabasePath(DatabaseHelperDelegate.this.getDatabaseDefinition().getDatabaseFileName());
                try {
                    databasePath.getParentFile().mkdirs();
                    DatabaseHelperDelegate.this.writeDB(databasePath, new FileInputStream(databasePath3));
                    databasePath2.delete();
                } catch (Exception e10) {
                    FlowLog.logError(e10);
                }
            }
        }).build().execute();
    }

    public DatabaseWrapper getWritableDatabase() {
        return getDatabaseDefinition().getWritableDatabase();
    }

    public boolean isDatabaseIntegrityOk() {
        return isDatabaseIntegrityOk(getWritableDatabase());
    }

    public void movePrepackagedDB(String str, String str2) {
        InputStream inputStream;
        OpenHelper openHelper;
        File databasePath = FlowManager.getContext().getDatabasePath(str);
        if (databasePath.exists()) {
            if (!getDatabaseDefinition().areConsistencyChecksEnabled()) {
                return;
            }
            if (getDatabaseDefinition().areConsistencyChecksEnabled() && isDatabaseIntegrityOk(getWritableDatabase())) {
                return;
            }
        }
        databasePath.getParentFile().mkdirs();
        try {
            File databasePath2 = FlowManager.getContext().getDatabasePath(getTempDbFileName());
            if (!databasePath2.exists() || (getDatabaseDefinition().backupEnabled() && (!getDatabaseDefinition().backupEnabled() || (openHelper = this.backupHelper) == null || !isDatabaseIntegrityOk(openHelper.getDatabase())))) {
                inputStream = FlowManager.getContext().getAssets().open(str2);
            } else {
                inputStream = new FileInputStream(databasePath2);
            }
            writeDB(databasePath, inputStream);
        } catch (IOException e10) {
            FlowLog.log(FlowLog.Level.W, "Failed to open file", e10);
        }
    }

    public void onCreate(DatabaseWrapper databaseWrapper) {
        DatabaseHelperListener databaseHelperListener2 = this.databaseHelperListener;
        if (databaseHelperListener2 != null) {
            databaseHelperListener2.onCreate(databaseWrapper);
        }
        super.onCreate(databaseWrapper);
    }

    public void onDowngrade(DatabaseWrapper databaseWrapper, int i10, int i11) {
        DatabaseHelperListener databaseHelperListener2 = this.databaseHelperListener;
        if (databaseHelperListener2 != null) {
            databaseHelperListener2.onDowngrade(databaseWrapper, i10, i11);
        }
        super.onDowngrade(databaseWrapper, i10, i11);
    }

    public void onOpen(DatabaseWrapper databaseWrapper) {
        DatabaseHelperListener databaseHelperListener2 = this.databaseHelperListener;
        if (databaseHelperListener2 != null) {
            databaseHelperListener2.onOpen(databaseWrapper);
        }
        super.onOpen(databaseWrapper);
    }

    public void onUpgrade(DatabaseWrapper databaseWrapper, int i10, int i11) {
        DatabaseHelperListener databaseHelperListener2 = this.databaseHelperListener;
        if (databaseHelperListener2 != null) {
            databaseHelperListener2.onUpgrade(databaseWrapper, i10, i11);
        }
        super.onUpgrade(databaseWrapper, i10, i11);
    }

    public void performRestoreFromBackup() {
        movePrepackagedDB(getDatabaseDefinition().getDatabaseFileName(), getDatabaseDefinition().getDatabaseFileName());
        if (!getDatabaseDefinition().backupEnabled()) {
            return;
        }
        if (this.backupHelper != null) {
            restoreDatabase(getTempDbFileName(), getDatabaseDefinition().getDatabaseFileName());
            this.backupHelper.getDatabase();
            return;
        }
        throw new IllegalStateException("the passed backup helper was null, even though backup is enabled. Ensure that its passed in.");
    }

    public boolean restoreBackUp() {
        Context context = FlowManager.getContext();
        File databasePath = context.getDatabasePath(TEMP_DB_NAME + getDatabaseDefinition().getDatabaseName());
        File databasePath2 = FlowManager.getContext().getDatabasePath(getDatabaseDefinition().getDatabaseName());
        if (databasePath2.delete()) {
            try {
                writeDB(databasePath2, new FileInputStream(databasePath));
            } catch (IOException e10) {
                FlowLog.logError(e10);
                return false;
            }
        } else {
            FlowLog.log(FlowLog.Level.E, "Failed to delete DB");
        }
        return true;
    }

    public void restoreDatabase(String str, String str2) {
        InputStream inputStream;
        OpenHelper openHelper;
        File databasePath = FlowManager.getContext().getDatabasePath(str);
        if (!databasePath.exists()) {
            databasePath.getParentFile().mkdirs();
            try {
                File databasePath2 = FlowManager.getContext().getDatabasePath(getDatabaseDefinition().getDatabaseFileName());
                if (!databasePath2.exists() || !getDatabaseDefinition().backupEnabled() || (openHelper = this.backupHelper) == null || !isDatabaseIntegrityOk(openHelper.getDatabase())) {
                    inputStream = FlowManager.getContext().getAssets().open(str2);
                } else {
                    inputStream = new FileInputStream(databasePath2);
                }
                writeDB(databasePath, inputStream);
            } catch (IOException e10) {
                FlowLog.logError(e10);
            }
        }
    }

    public void setDatabaseHelperListener(DatabaseHelperListener databaseHelperListener2) {
        this.databaseHelperListener = databaseHelperListener2;
    }

    /* access modifiers changed from: private */
    public String getTempDbFileName() {
        return getTempDbFileName(getDatabaseDefinition());
    }

    public boolean isDatabaseIntegrityOk(DatabaseWrapper databaseWrapper) {
        boolean z10;
        DatabaseStatement databaseStatement = null;
        try {
            DatabaseStatement compileStatement = databaseWrapper.compileStatement("PRAGMA quick_check(1)");
            String simpleQueryForString = compileStatement.simpleQueryForString();
            if (!simpleQueryForString.equalsIgnoreCase(ITagManager.SUCCESS)) {
                FlowLog.Level level = FlowLog.Level.E;
                FlowLog.log(level, "PRAGMA integrity_check on " + getDatabaseDefinition().getDatabaseName() + " returned: " + simpleQueryForString);
                z10 = getDatabaseDefinition().backupEnabled() ? restoreBackUp() : false;
            } else {
                z10 = true;
            }
            compileStatement.close();
            return z10;
        } catch (Throwable th) {
            if (databaseStatement != null) {
                databaseStatement.close();
            }
            throw th;
        }
    }
}
