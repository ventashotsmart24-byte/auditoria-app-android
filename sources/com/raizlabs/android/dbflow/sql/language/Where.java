package com.raizlabs.android.dbflow.sql.language;

import com.google.android.gms.actions.SearchIntents;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Where<TModel> extends BaseModelQueriable<TModel> implements Transformable<TModel> {
    private static final int VALUE_UNSET = -1;
    private final List<NameAlias> groupByList = new ArrayList();
    private OperatorGroup havingGroup;
    private int limit = -1;
    private int offset = -1;
    private OperatorGroup operatorGroup;
    private final List<OrderBy> orderByList = new ArrayList();
    private final WhereBase<TModel> whereBase;

    public Where(WhereBase<TModel> whereBase2, SQLOperator... sQLOperatorArr) {
        super(whereBase2.getTable());
        this.whereBase = whereBase2;
        this.operatorGroup = OperatorGroup.nonGroupingClause();
        this.havingGroup = OperatorGroup.nonGroupingClause();
        this.operatorGroup.andAll(sQLOperatorArr);
    }

    private void checkSelect(String str) {
        if (!(this.whereBase.getQueryBuilderBase() instanceof Select)) {
            throw new IllegalArgumentException("Please use " + str + "(). The beginning is not a ISelect");
        }
    }

    public Where<TModel> and(SQLOperator sQLOperator) {
        this.operatorGroup.and(sQLOperator);
        return this;
    }

    public Where<TModel> andAll(List<SQLOperator> list) {
        this.operatorGroup.andAll((Collection<SQLOperator>) list);
        return this;
    }

    public Where<TModel> exists(Where where) {
        this.operatorGroup.and(new ExistenceOperator().where(where));
        return this;
    }

    public BaseModel.Action getPrimaryAction() {
        return this.whereBase.getPrimaryAction();
    }

    public String getQuery() {
        QueryBuilder appendQualifier = new QueryBuilder().append(this.whereBase.getQuery().trim()).appendSpace().appendQualifier("WHERE", this.operatorGroup.getQuery()).appendQualifier("GROUP BY", QueryBuilder.join((CharSequence) ",", (Iterable) this.groupByList)).appendQualifier("HAVING", this.havingGroup.getQuery()).appendQualifier("ORDER BY", QueryBuilder.join((CharSequence) ",", (Iterable) this.orderByList));
        int i10 = this.limit;
        if (i10 > -1) {
            appendQualifier.appendQualifier("LIMIT", String.valueOf(i10));
        }
        int i11 = this.offset;
        if (i11 > -1) {
            appendQualifier.appendQualifier("OFFSET", String.valueOf(i11));
        }
        return appendQualifier.getQuery();
    }

    public WhereBase<TModel> getWhereBase() {
        return this.whereBase;
    }

    public Where<TModel> groupBy(NameAlias... nameAliasArr) {
        Collections.addAll(this.groupByList, nameAliasArr);
        return this;
    }

    public Where<TModel> having(SQLOperator... sQLOperatorArr) {
        this.havingGroup.andAll(sQLOperatorArr);
        return this;
    }

    public Where<TModel> limit(int i10) {
        this.limit = i10;
        return this;
    }

    public Where<TModel> offset(int i10) {
        this.offset = i10;
        return this;
    }

    public Where<TModel> or(SQLOperator sQLOperator) {
        this.operatorGroup.or(sQLOperator);
        return this;
    }

    public Where<TModel> orderBy(NameAlias nameAlias, boolean z10) {
        this.orderByList.add(new OrderBy(nameAlias, z10));
        return this;
    }

    public Where<TModel> orderByAll(List<OrderBy> list) {
        this.orderByList.addAll(list);
        return this;
    }

    public FlowCursor query(DatabaseWrapper databaseWrapper) {
        if (this.whereBase.getQueryBuilderBase() instanceof Select) {
            return databaseWrapper.rawQuery(getQuery(), (String[]) null);
        }
        return super.query(databaseWrapper);
    }

    public List<TModel> queryList() {
        checkSelect(SearchIntents.EXTRA_QUERY);
        return super.queryList();
    }

    public TModel querySingle() {
        checkSelect(SearchIntents.EXTRA_QUERY);
        limit(1);
        return super.querySingle();
    }

    public Where<TModel> andAll(SQLOperator... sQLOperatorArr) {
        this.operatorGroup.andAll(sQLOperatorArr);
        return this;
    }

    public Where<TModel> groupBy(IProperty... iPropertyArr) {
        for (IProperty nameAlias : iPropertyArr) {
            this.groupByList.add(nameAlias.getNameAlias());
        }
        return this;
    }

    public Where<TModel> orderBy(IProperty iProperty, boolean z10) {
        this.orderByList.add(new OrderBy(iProperty.getNameAlias(), z10));
        return this;
    }

    public Where<TModel> orderBy(OrderBy orderBy) {
        this.orderByList.add(orderBy);
        return this;
    }

    public FlowCursor query() {
        return query(FlowManager.getDatabaseForTable(getTable()).getWritableDatabase());
    }
}
