package com.raizlabs.android.dbflow.config;

import android.content.Context;
import com.raizlabs.android.dbflow.runtime.BaseTransactionManager;
import com.raizlabs.android.dbflow.runtime.ContentResolverNotifier;
import com.raizlabs.android.dbflow.runtime.ModelNotifier;
import com.raizlabs.android.dbflow.sql.migration.Migration;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.ModelViewAdapter;
import com.raizlabs.android.dbflow.structure.QueryModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseHelperListener;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowSQLiteOpenHelper;
import com.raizlabs.android.dbflow.structure.database.OpenHelper;
import com.raizlabs.android.dbflow.structure.database.transaction.DefaultTransactionManager;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class DatabaseDefinition {
    private DatabaseConfig databaseConfig;
    private DatabaseHelperListener helperListener;
    private boolean isResetting = false;
    private final Map<Integer, List<Migration>> migrationMap = new HashMap();
    private final Map<Class<?>, ModelAdapter> modelAdapters = new HashMap();
    private ModelNotifier modelNotifier;
    private final Map<String, Class<?>> modelTableNames = new HashMap();
    private final Map<Class<?>, ModelViewAdapter> modelViewAdapterMap = new LinkedHashMap();
    private OpenHelper openHelper;
    private final Map<Class<?>, QueryModelAdapter> queryModelAdapterMap = new LinkedHashMap();
    private BaseTransactionManager transactionManager;

    public DatabaseDefinition() {
        applyDatabaseConfig(FlowManager.getConfig().databaseConfigMap().get(getAssociatedDatabaseClassFile()));
    }

    public void addMigration(int i10, Migration migration) {
        List list = this.migrationMap.get(Integer.valueOf(i10));
        if (list == null) {
            list = new ArrayList();
            this.migrationMap.put(Integer.valueOf(i10), list);
        }
        list.add(migration);
    }

    public <T> void addModelAdapter(ModelAdapter<T> modelAdapter, DatabaseHolder databaseHolder) {
        databaseHolder.putDatabaseForTable(modelAdapter.getModelClass(), this);
        this.modelTableNames.put(modelAdapter.getTableName(), modelAdapter.getModelClass());
        this.modelAdapters.put(modelAdapter.getModelClass(), modelAdapter);
    }

    public <T> void addModelViewAdapter(ModelViewAdapter<T> modelViewAdapter, DatabaseHolder databaseHolder) {
        databaseHolder.putDatabaseForTable(modelViewAdapter.getModelClass(), this);
        this.modelViewAdapterMap.put(modelViewAdapter.getModelClass(), modelViewAdapter);
    }

    public <T> void addQueryModelAdapter(QueryModelAdapter<T> queryModelAdapter, DatabaseHolder databaseHolder) {
        databaseHolder.putDatabaseForTable(queryModelAdapter.getModelClass(), this);
        this.queryModelAdapterMap.put(queryModelAdapter.getModelClass(), queryModelAdapter);
    }

    public void applyDatabaseConfig(DatabaseConfig databaseConfig2) {
        this.databaseConfig = databaseConfig2;
        if (databaseConfig2 != null) {
            for (TableConfig next : databaseConfig2.tableConfigMap().values()) {
                ModelAdapter modelAdapter = this.modelAdapters.get(next.tableClass());
                if (modelAdapter != null) {
                    if (next.listModelLoader() != null) {
                        modelAdapter.setListModelLoader(next.listModelLoader());
                    }
                    if (next.singleModelLoader() != null) {
                        modelAdapter.setSingleModelLoader(next.singleModelLoader());
                    }
                    if (next.modelSaver() != null) {
                        modelAdapter.setModelSaver(next.modelSaver());
                    }
                }
            }
            this.helperListener = databaseConfig2.helperListener();
        }
        if (databaseConfig2 == null || databaseConfig2.transactionManagerCreator() == null) {
            this.transactionManager = new DefaultTransactionManager(this);
        } else {
            this.transactionManager = databaseConfig2.transactionManagerCreator().createManager(this);
        }
    }

    public abstract boolean areConsistencyChecksEnabled();

    public void backupDatabase() {
        getHelper().backupDB();
    }

    public abstract boolean backupEnabled();

    public Transaction.Builder beginTransactionAsync(ITransaction iTransaction) {
        return new Transaction.Builder(iTransaction, this);
    }

    public void close() {
        getTransactionManager().stopQueue();
        for (ModelAdapter next : this.modelAdapters.values()) {
            next.closeInsertStatement();
            next.closeCompiledStatement();
            next.closeDeleteStatement();
            next.closeUpdateStatement();
        }
        getHelper().closeDB();
    }

    public void destroy() {
        if (!this.isResetting) {
            this.isResetting = true;
            close();
            FlowManager.getContext().deleteDatabase(getDatabaseFileName());
            this.openHelper = null;
            this.isResetting = false;
        }
    }

    public void executeTransaction(ITransaction iTransaction) {
        DatabaseWrapper writableDatabase = getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            iTransaction.execute(writableDatabase);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public abstract Class<?> getAssociatedDatabaseClassFile();

    public String getDatabaseExtensionName() {
        DatabaseConfig databaseConfig2 = this.databaseConfig;
        if (databaseConfig2 != null) {
            return databaseConfig2.getDatabaseExtensionName();
        }
        return a.f14486d;
    }

    public String getDatabaseFileName() {
        return getDatabaseName() + getDatabaseExtensionName();
    }

    public String getDatabaseName() {
        DatabaseConfig databaseConfig2 = this.databaseConfig;
        if (databaseConfig2 != null) {
            return databaseConfig2.getDatabaseName();
        }
        return getAssociatedDatabaseClassFile().getSimpleName();
    }

    public abstract int getDatabaseVersion();

    public synchronized OpenHelper getHelper() {
        if (this.openHelper == null) {
            DatabaseConfig databaseConfig2 = FlowManager.getConfig().databaseConfigMap().get(getAssociatedDatabaseClassFile());
            if (databaseConfig2 != null) {
                if (databaseConfig2.helperCreator() != null) {
                    this.openHelper = databaseConfig2.helperCreator().createHelper(this, this.helperListener);
                    this.openHelper.performRestoreFromBackup();
                }
            }
            this.openHelper = new FlowSQLiteOpenHelper(this, this.helperListener);
            this.openHelper.performRestoreFromBackup();
        }
        return this.openHelper;
    }

    public Map<Integer, List<Migration>> getMigrations() {
        return this.migrationMap;
    }

    public <T> ModelAdapter<T> getModelAdapterForTable(Class<T> cls) {
        return this.modelAdapters.get(cls);
    }

    public List<ModelAdapter> getModelAdapters() {
        return new ArrayList(this.modelAdapters.values());
    }

    public Class<?> getModelClassForName(String str) {
        return this.modelTableNames.get(str);
    }

    public List<Class<?>> getModelClasses() {
        return new ArrayList(this.modelAdapters.keySet());
    }

    public ModelNotifier getModelNotifier() {
        if (this.modelNotifier == null) {
            DatabaseConfig databaseConfig2 = FlowManager.getConfig().databaseConfigMap().get(getAssociatedDatabaseClassFile());
            if (databaseConfig2 == null || databaseConfig2.modelNotifier() == null) {
                this.modelNotifier = new ContentResolverNotifier(FlowManager.DEFAULT_AUTHORITY);
            } else {
                this.modelNotifier = databaseConfig2.modelNotifier();
            }
        }
        return this.modelNotifier;
    }

    public List<QueryModelAdapter> getModelQueryAdapters() {
        return new ArrayList(this.queryModelAdapterMap.values());
    }

    public <T> ModelViewAdapter<T> getModelViewAdapterForTable(Class<T> cls) {
        return this.modelViewAdapterMap.get(cls);
    }

    public List<ModelViewAdapter> getModelViewAdapters() {
        return new ArrayList(this.modelViewAdapterMap.values());
    }

    public List<Class<?>> getModelViews() {
        return new ArrayList(this.modelViewAdapterMap.keySet());
    }

    public <T> QueryModelAdapter<T> getQueryModelAdapterForQueryClass(Class<T> cls) {
        return this.queryModelAdapterMap.get(cls);
    }

    public BaseTransactionManager getTransactionManager() {
        return this.transactionManager;
    }

    public DatabaseWrapper getWritableDatabase() {
        return getHelper().getDatabase();
    }

    public boolean isDatabaseIntegrityOk() {
        return getHelper().isDatabaseIntegrityOk();
    }

    public abstract boolean isForeignKeysSupported();

    public boolean isInMemory() {
        DatabaseConfig databaseConfig2 = this.databaseConfig;
        if (databaseConfig2 == null || !databaseConfig2.isInMemory()) {
            return false;
        }
        return true;
    }

    public void reopen(DatabaseConfig databaseConfig2) {
        if (!this.isResetting) {
            close();
            this.openHelper = null;
            applyDatabaseConfig(databaseConfig2);
            getHelper().getDatabase();
            this.isResetting = false;
        }
    }

    @Deprecated
    public void reset(Context context) {
        reset(this.databaseConfig);
    }

    public void reset() {
        reset(this.databaseConfig);
    }

    public void reset(DatabaseConfig databaseConfig2) {
        if (!this.isResetting) {
            destroy();
            applyDatabaseConfig(databaseConfig2);
            getHelper().getDatabase();
        }
    }

    public void reopen() {
        reopen(this.databaseConfig);
    }
}
