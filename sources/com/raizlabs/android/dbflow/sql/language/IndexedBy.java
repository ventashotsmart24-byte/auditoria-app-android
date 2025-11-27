package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IndexProperty;
import com.raizlabs.android.dbflow.structure.BaseModel;

public class IndexedBy<TModel> extends BaseTransformable<TModel> {
    private final IndexProperty<TModel> indexProperty;
    private final WhereBase<TModel> whereBase;

    public IndexedBy(IndexProperty<TModel> indexProperty2, WhereBase<TModel> whereBase2) {
        super(whereBase2.getTable());
        this.indexProperty = indexProperty2;
        this.whereBase = whereBase2;
    }

    public BaseModel.Action getPrimaryAction() {
        return this.whereBase.getPrimaryAction();
    }

    public String getQuery() {
        return new QueryBuilder(this.whereBase.getQuery()).append(" INDEXED BY ").append(QueryBuilder.quoteIfNeeded(this.indexProperty.getIndexName())).appendSpace().getQuery();
    }

    public Query getQueryBuilderBase() {
        return this.whereBase.getQueryBuilderBase();
    }
}
