package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.List;

public class Index<TModel> implements Query {
    private List<NameAlias> columns;
    private final String indexName;
    private boolean isUnique = false;
    private Class<TModel> table;

    public Index(String str) {
        this.indexName = str;
        this.columns = new ArrayList();
    }

    public Index<TModel> and(IProperty iProperty) {
        if (!this.columns.contains(iProperty.getNameAlias())) {
            this.columns.add(iProperty.getNameAlias());
        }
        return this;
    }

    public void disable() {
        SqlUtils.dropIndex(FlowManager.getDatabaseForTable(this.table).getWritableDatabase(), this.indexName);
    }

    public void enable(DatabaseWrapper databaseWrapper) {
        if (this.table != null) {
            List<NameAlias> list = this.columns;
            if (list == null || list.isEmpty()) {
                throw new IllegalStateException("There should be at least one column in this index");
            }
            databaseWrapper.execSQL(getQuery());
            return;
        }
        throw new IllegalStateException("Please call on() to set a table to use this index on.");
    }

    public String getIndexName() {
        return this.indexName;
    }

    public String getQuery() {
        String str;
        QueryBuilder queryBuilder = new QueryBuilder("CREATE ");
        if (this.isUnique) {
            str = "UNIQUE ";
        } else {
            str = "";
        }
        return queryBuilder.append(str).append("INDEX IF NOT EXISTS ").appendQuotedIfNeeded(this.indexName).append(" ON ").append(FlowManager.getTableName(this.table)).append("(").appendList(this.columns).append(")").getQuery();
    }

    public Class<TModel> getTable() {
        return this.table;
    }

    public boolean isUnique() {
        return this.isUnique;
    }

    public Index<TModel> on(Class<TModel> cls, IProperty... iPropertyArr) {
        this.table = cls;
        for (IProperty and : iPropertyArr) {
            and(and);
        }
        return this;
    }

    public Index<TModel> unique(boolean z10) {
        this.isUnique = z10;
        return this;
    }

    public void disable(DatabaseWrapper databaseWrapper) {
        SqlUtils.dropIndex(databaseWrapper, this.indexName);
    }

    public Index<TModel> and(NameAlias nameAlias) {
        if (!this.columns.contains(nameAlias)) {
            this.columns.add(nameAlias);
        }
        return this;
    }

    public Index<TModel> on(Class<TModel> cls, NameAlias nameAlias, NameAlias... nameAliasArr) {
        this.table = cls;
        and(nameAlias);
        for (NameAlias and : nameAliasArr) {
            and(and);
        }
        return this;
    }

    public void enable() {
        enable(FlowManager.getDatabaseForTable(this.table).getWritableDatabase());
    }
}
