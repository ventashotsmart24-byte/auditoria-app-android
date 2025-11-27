package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import java.util.ArrayList;
import java.util.List;

public class CompletedTrigger<TModel> implements Query {
    private final List<Query> triggerLogicQuery;
    private TriggerMethod<TModel> triggerMethod;

    public CompletedTrigger(TriggerMethod<TModel> triggerMethod2, Query query) {
        ArrayList arrayList = new ArrayList();
        this.triggerLogicQuery = arrayList;
        this.triggerMethod = triggerMethod2;
        arrayList.add(query);
    }

    public CompletedTrigger<TModel> and(Query query) {
        this.triggerLogicQuery.add(query);
        return this;
    }

    public void disable() {
        TriggerMethod<TModel> triggerMethod2 = this.triggerMethod;
        SqlUtils.dropTrigger((Class<?>) triggerMethod2.onTable, triggerMethod2.trigger.triggerName);
    }

    public void enable() {
        FlowManager.getDatabaseForTable(this.triggerMethod.onTable).getWritableDatabase().execSQL(getQuery());
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder(this.triggerMethod.getQuery());
        queryBuilder.append("\nBEGIN").append("\n").append(QueryBuilder.join((CharSequence) ";\n", (Iterable) this.triggerLogicQuery)).append(";").append("\nEND");
        return queryBuilder.getQuery();
    }
}
