package com.raizlabs.android.dbflow.structure;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.saveable.ListModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;
import com.raizlabs.android.dbflow.structure.cache.IMultiKeyCacheConverter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.cache.SimpleMapCache;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.Collection;

public abstract class ModelAdapter<TModel> extends InstanceAdapter<TModel> implements InternalAdapter<TModel> {
    private String[] cachingColumns;
    private DatabaseStatement compiledStatement;
    private DatabaseStatement deleteStatement;
    private DatabaseStatement insertStatement;
    private ListModelSaver<TModel> listModelSaver;
    private ModelCache<TModel, ?> modelCache;
    private ModelSaver<TModel> modelSaver;
    private DatabaseStatement updateStatement;

    public ModelAdapter(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
        if (getTableConfig() != null && getTableConfig().modelSaver() != null) {
            ModelSaver<TModel> modelSaver2 = getTableConfig().modelSaver();
            this.modelSaver = modelSaver2;
            modelSaver2.setModelAdapter(this);
        }
    }

    private void throwCachingError() {
        throw new InvalidDBConfiguration(String.format("This method may have been called in error. The model class %1s must containan auto-incrementing or at least one primary key (if used in a ModelCache, this method may be called)", new Object[]{getModelClass()}));
    }

    private void throwSingleCachingError() {
        throw new InvalidDBConfiguration(String.format("This method may have been called in error. The model class %1s must containan auto-incrementing or one primary key (if used in a ModelCache, this method may be called)", new Object[]{getModelClass()}));
    }

    public void bindToContentValues(ContentValues contentValues, TModel tmodel) {
        bindToInsertValues(contentValues, tmodel);
    }

    public void bindToInsertStatement(DatabaseStatement databaseStatement, TModel tmodel) {
        bindToInsertStatement(databaseStatement, tmodel, 0);
    }

    public void bindToStatement(DatabaseStatement databaseStatement, TModel tmodel) {
        bindToInsertStatement(databaseStatement, tmodel, 0);
    }

    public boolean cachingEnabled() {
        return false;
    }

    public void closeCompiledStatement() {
        DatabaseStatement databaseStatement = this.compiledStatement;
        if (databaseStatement != null) {
            databaseStatement.close();
            this.compiledStatement = null;
        }
    }

    public void closeDeleteStatement() {
        DatabaseStatement databaseStatement = this.deleteStatement;
        if (databaseStatement != null) {
            databaseStatement.close();
            this.deleteStatement = null;
        }
    }

    public void closeInsertStatement() {
        DatabaseStatement databaseStatement = this.insertStatement;
        if (databaseStatement != null) {
            databaseStatement.close();
            this.insertStatement = null;
        }
    }

    public void closeUpdateStatement() {
        DatabaseStatement databaseStatement = this.updateStatement;
        if (databaseStatement != null) {
            databaseStatement.close();
            this.updateStatement = null;
        }
    }

    public String[] createCachingColumns() {
        return new String[]{getAutoIncrementingColumnName()};
    }

    public ListModelSaver<TModel> createListModelSaver() {
        return new ListModelSaver<>(getModelSaver());
    }

    public ModelCache<TModel, ?> createModelCache() {
        return new SimpleMapCache(getCacheSize());
    }

    public ModelSaver<TModel> createSingleModelSaver() {
        return new ModelSaver<>();
    }

    public boolean createWithDatabase() {
        return true;
    }

    public boolean delete(TModel tmodel) {
        return getModelSaver().delete(tmodel);
    }

    public void deleteAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        getListModelSaver().deleteAll(collection, databaseWrapper);
    }

    public void deleteForeignKeys(TModel tmodel, DatabaseWrapper databaseWrapper) {
    }

    public abstract IProperty[] getAllColumnProperties();

    public String getAutoIncrementingColumnName() {
        throw new InvalidDBConfiguration(String.format("This method may have been called in error. The model class %1s must contain an autoincrementing or single int/long primary key (if used in a ModelCache, this method may be called)", new Object[]{getModelClass()}));
    }

    public Number getAutoIncrementingId(TModel tmodel) {
        throw new InvalidDBConfiguration(String.format("This method may have been called in error. The model class %1s must containa single primary key (if used in a ModelCache, this method may be called)", new Object[]{getModelClass()}));
    }

    public IMultiKeyCacheConverter<?> getCacheConverter() {
        throw new InvalidDBConfiguration("For multiple primary keys, a public static IMultiKeyCacheConverter field mustbe  marked with @MultiCacheField in the corresponding model class. The resulting keymust be a unique combination of the multiple keys, otherwise inconsistencies may occur.");
    }

    public int getCacheSize() {
        return 25;
    }

    public Object getCachingColumnValueFromCursor(FlowCursor flowCursor) {
        throwSingleCachingError();
        return null;
    }

    public Object getCachingColumnValueFromModel(TModel tmodel) {
        throwSingleCachingError();
        return null;
    }

    public Object[] getCachingColumnValuesFromCursor(Object[] objArr, FlowCursor flowCursor) {
        throwCachingError();
        return null;
    }

    public Object[] getCachingColumnValuesFromModel(Object[] objArr, TModel tmodel) {
        throwCachingError();
        return null;
    }

    public String[] getCachingColumns() {
        if (this.cachingColumns == null) {
            this.cachingColumns = createCachingColumns();
        }
        return this.cachingColumns;
    }

    public Object getCachingId(Object[] objArr) {
        if (objArr.length == 1) {
            return objArr[0];
        }
        return getCacheConverter().getCachingKey(objArr);
    }

    public DatabaseStatement getCompiledStatement() {
        if (this.compiledStatement == null) {
            this.compiledStatement = getCompiledStatement(FlowManager.getWritableDatabaseForTable(getModelClass()));
        }
        return this.compiledStatement;
    }

    public abstract String getCompiledStatementQuery();

    public abstract String getCreationQuery();

    public DatabaseStatement getDeleteStatement() {
        if (this.deleteStatement == null) {
            this.deleteStatement = getDeleteStatement(FlowManager.getWritableDatabaseForTable(getModelClass()));
        }
        return this.deleteStatement;
    }

    public abstract String getDeleteStatementQuery();

    public ConflictAction getInsertOnConflictAction() {
        return ConflictAction.ABORT;
    }

    public DatabaseStatement getInsertStatement() {
        if (this.insertStatement == null) {
            this.insertStatement = getInsertStatement(FlowManager.getWritableDatabaseForTable(getModelClass()));
        }
        return this.insertStatement;
    }

    public String getInsertStatementQuery() {
        return getCompiledStatementQuery();
    }

    public ListModelSaver<TModel> getListModelSaver() {
        if (this.listModelSaver == null) {
            this.listModelSaver = createListModelSaver();
        }
        return this.listModelSaver;
    }

    public ModelCache<TModel, ?> getModelCache() {
        if (this.modelCache == null) {
            this.modelCache = createModelCache();
        }
        return this.modelCache;
    }

    public ModelSaver<TModel> getModelSaver() {
        if (this.modelSaver == null) {
            ModelSaver<TModel> createSingleModelSaver = createSingleModelSaver();
            this.modelSaver = createSingleModelSaver;
            createSingleModelSaver.setModelAdapter(this);
        }
        return this.modelSaver;
    }

    public abstract Property getProperty(String str);

    public ConflictAction getUpdateOnConflictAction() {
        return ConflictAction.ABORT;
    }

    public DatabaseStatement getUpdateStatement() {
        if (this.updateStatement == null) {
            this.updateStatement = getUpdateStatement(FlowManager.getWritableDatabaseForTable(getModelClass()));
        }
        return this.updateStatement;
    }

    public abstract String getUpdateStatementQuery();

    public boolean hasAutoIncrement(TModel tmodel) {
        Number autoIncrementingId = getAutoIncrementingId(tmodel);
        if (autoIncrementingId == null || autoIncrementingId.longValue() <= 0) {
            return false;
        }
        return true;
    }

    public long insert(TModel tmodel) {
        return getModelSaver().insert(tmodel);
    }

    public void insertAll(Collection<TModel> collection) {
        getListModelSaver().insertAll(collection);
    }

    public TModel loadFromCursor(FlowCursor flowCursor) {
        TModel newInstance = newInstance();
        loadFromCursor(flowCursor, newInstance);
        return newInstance;
    }

    public void reloadRelationships(TModel tmodel, FlowCursor flowCursor) {
        if (!cachingEnabled()) {
            throwCachingError();
        }
    }

    public void removeModelFromCache(TModel tmodel) {
        getModelCache().removeModel(getCachingId(tmodel));
    }

    public boolean save(TModel tmodel) {
        return getModelSaver().save(tmodel);
    }

    public void saveAll(Collection<TModel> collection) {
        getListModelSaver().saveAll(collection);
    }

    public void saveForeignKeys(TModel tmodel, DatabaseWrapper databaseWrapper) {
    }

    public void setModelSaver(ModelSaver<TModel> modelSaver2) {
        this.modelSaver = modelSaver2;
        modelSaver2.setModelAdapter(this);
    }

    public void storeModelInCache(TModel tmodel) {
        getModelCache().addModel(getCachingId(tmodel), tmodel);
    }

    public boolean update(TModel tmodel) {
        return getModelSaver().update(tmodel);
    }

    public void updateAll(Collection<TModel> collection) {
        getListModelSaver().updateAll(collection);
    }

    public void updateAutoIncrement(TModel tmodel, Number number) {
    }

    public boolean delete(TModel tmodel, DatabaseWrapper databaseWrapper) {
        return getModelSaver().delete(tmodel, databaseWrapper);
    }

    public void deleteAll(Collection<TModel> collection) {
        getListModelSaver().deleteAll(collection);
    }

    public long insert(TModel tmodel, DatabaseWrapper databaseWrapper) {
        return getModelSaver().insert(tmodel, databaseWrapper);
    }

    public void insertAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        getListModelSaver().insertAll(collection, databaseWrapper);
    }

    public boolean save(TModel tmodel, DatabaseWrapper databaseWrapper) {
        return getModelSaver().save(tmodel, databaseWrapper);
    }

    public void saveAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        getListModelSaver().saveAll(collection, databaseWrapper);
    }

    public boolean update(TModel tmodel, DatabaseWrapper databaseWrapper) {
        return getModelSaver().update(tmodel, databaseWrapper);
    }

    public void updateAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        getListModelSaver().updateAll(collection, databaseWrapper);
    }

    public Object getCachingId(TModel tmodel) {
        return getCachingId(getCachingColumnValuesFromModel(new Object[getCachingColumns().length], tmodel));
    }

    public DatabaseStatement getCompiledStatement(DatabaseWrapper databaseWrapper) {
        return databaseWrapper.compileStatement(getCompiledStatementQuery());
    }

    public DatabaseStatement getDeleteStatement(DatabaseWrapper databaseWrapper) {
        return databaseWrapper.compileStatement(getDeleteStatementQuery());
    }

    public DatabaseStatement getInsertStatement(DatabaseWrapper databaseWrapper) {
        return databaseWrapper.compileStatement(getInsertStatementQuery());
    }

    public DatabaseStatement getUpdateStatement(DatabaseWrapper databaseWrapper) {
        return databaseWrapper.compileStatement(getUpdateStatementQuery());
    }
}
