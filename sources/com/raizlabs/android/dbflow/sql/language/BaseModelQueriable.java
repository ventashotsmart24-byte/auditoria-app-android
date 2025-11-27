package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.queriable.AsyncQuery;
import com.raizlabs.android.dbflow.sql.queriable.ListModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.QueryModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.List;

public abstract class BaseModelQueriable<TModel> extends BaseQueriable<TModel> implements ModelQueriable<TModel>, Query {
    private boolean cachingEnabled = true;
    private InstanceAdapter<TModel> retrievalAdapter;

    public BaseModelQueriable(Class<TModel> cls) {
        super(cls);
    }

    private ListModelLoader<TModel> getListModelLoader() {
        if (this.cachingEnabled) {
            return getRetrievalAdapter().getListModelLoader();
        }
        return getRetrievalAdapter().getNonCacheableListModelLoader();
    }

    private InstanceAdapter<TModel> getRetrievalAdapter() {
        if (this.retrievalAdapter == null) {
            this.retrievalAdapter = FlowManager.getInstanceAdapter(getTable());
        }
        return this.retrievalAdapter;
    }

    private SingleModelLoader<TModel> getSingleModelLoader() {
        if (this.cachingEnabled) {
            return getRetrievalAdapter().getSingleModelLoader();
        }
        return getRetrievalAdapter().getNonCacheableSingleModelLoader();
    }

    public AsyncQuery<TModel> async() {
        return new AsyncQuery<>(this);
    }

    public FlowCursorList<TModel> cursorList() {
        return new FlowCursorList.Builder(getTable()).cacheModels(this.cachingEnabled).modelQueriable(this).build();
    }

    public ModelQueriable<TModel> disableCaching() {
        this.cachingEnabled = false;
        return this;
    }

    public long executeUpdateDelete() {
        return executeUpdateDelete(FlowManager.getWritableDatabaseForTable(getTable()));
    }

    public FlowQueryList<TModel> flowQueryList() {
        return new FlowQueryList.Builder(getTable()).cacheModels(this.cachingEnabled).modelQueriable(this).build();
    }

    public <QueryClass> List<QueryClass> queryCustomList(Class<QueryClass> cls) {
        String query = getQuery();
        FlowLog.Level level = FlowLog.Level.V;
        FlowLog.log(level, "Executing query: " + query);
        QueryModelAdapter<TQueryModel> queryModelAdapter = FlowManager.getQueryModelAdapter(cls);
        if (this.cachingEnabled) {
            return queryModelAdapter.getListModelLoader().load(query);
        }
        return queryModelAdapter.getNonCacheableListModelLoader().load(query);
    }

    public <QueryClass> QueryClass queryCustomSingle(Class<QueryClass> cls) {
        String query = getQuery();
        FlowLog.Level level = FlowLog.Level.V;
        FlowLog.log(level, "Executing query: " + query);
        QueryModelAdapter<TQueryModel> queryModelAdapter = FlowManager.getQueryModelAdapter(cls);
        if (this.cachingEnabled) {
            return queryModelAdapter.getSingleModelLoader().load(query);
        }
        return queryModelAdapter.getNonCacheableSingleModelLoader().load(query);
    }

    public List<TModel> queryList() {
        String query = getQuery();
        FlowLog.Level level = FlowLog.Level.V;
        FlowLog.log(level, "Executing query: " + query);
        return getListModelLoader().load(query);
    }

    public CursorResult<TModel> queryResults() {
        return new CursorResult<>(getRetrievalAdapter().getModelClass(), query());
    }

    public TModel querySingle() {
        String query = getQuery();
        FlowLog.Level level = FlowLog.Level.V;
        FlowLog.log(level, "Executing query: " + query);
        return getSingleModelLoader().load(query);
    }

    public long executeUpdateDelete(DatabaseWrapper databaseWrapper) {
        DatabaseStatement compileStatement = databaseWrapper.compileStatement(getQuery());
        try {
            long executeUpdateDelete = compileStatement.executeUpdateDelete();
            if (executeUpdateDelete > 0) {
                NotifyDistributor.get().notifyTableChanged(getTable(), getPrimaryAction());
            }
            return executeUpdateDelete;
        } finally {
            compileStatement.close();
        }
    }

    public List<TModel> queryList(DatabaseWrapper databaseWrapper) {
        String query = getQuery();
        FlowLog.Level level = FlowLog.Level.V;
        FlowLog.log(level, "Executing query: " + query);
        return getListModelLoader().load(databaseWrapper, query);
    }

    public TModel querySingle(DatabaseWrapper databaseWrapper) {
        String query = getQuery();
        FlowLog.Level level = FlowLog.Level.V;
        FlowLog.log(level, "Executing query: " + query);
        return getSingleModelLoader().load(databaseWrapper, query);
    }
}
