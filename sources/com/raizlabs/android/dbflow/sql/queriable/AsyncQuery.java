package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.sql.BaseAsyncObject;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

public class AsyncQuery<TModel> extends BaseAsyncObject<AsyncQuery<TModel>> {
    private final ModelQueriable<TModel> modelQueriable;
    private QueryTransaction.QueryResultCallback<TModel> queryResultCallback;
    private QueryTransaction.QueryResultListCallback<TModel> queryResultListCallback;
    private QueryTransaction.QueryResultSingleCallback<TModel> queryResultSingleCallback;

    public AsyncQuery(ModelQueriable<TModel> modelQueriable2) {
        super(modelQueriable2.getTable());
        this.modelQueriable = modelQueriable2;
    }

    public void execute() {
        executeTransaction(new QueryTransaction.Builder(this.modelQueriable).queryResult(this.queryResultCallback).queryListResult(this.queryResultListCallback).querySingleResult(this.queryResultSingleCallback).build());
    }

    public Class<TModel> getTable() {
        return this.modelQueriable.getTable();
    }

    public AsyncQuery<TModel> queryListResultCallback(QueryTransaction.QueryResultListCallback<TModel> queryResultListCallback2) {
        this.queryResultListCallback = queryResultListCallback2;
        return this;
    }

    public AsyncQuery<TModel> queryResultCallback(QueryTransaction.QueryResultCallback<TModel> queryResultCallback2) {
        this.queryResultCallback = queryResultCallback2;
        return this;
    }

    public AsyncQuery<TModel> querySingleResultCallback(QueryTransaction.QueryResultSingleCallback<TModel> queryResultSingleCallback2) {
        this.queryResultSingleCallback = queryResultSingleCallback2;
        return this;
    }
}
