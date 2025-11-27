package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;

public class ExistenceOperator implements SQLOperator, Query {
    private Where innerWhere;

    public void appendConditionToQuery(QueryBuilder queryBuilder) {
        queryBuilder.appendQualifier("EXISTS", "(" + this.innerWhere.getQuery().trim() + ")");
    }

    public String columnName() {
        throw new RuntimeException("Method not valid for ExistenceOperator");
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();
        appendConditionToQuery(queryBuilder);
        return queryBuilder.getQuery();
    }

    public boolean hasSeparator() {
        return false;
    }

    public String operation() {
        return "";
    }

    public String separator() {
        throw new RuntimeException("Method not valid for ExistenceOperator");
    }

    public Object value() {
        return this.innerWhere;
    }

    public ExistenceOperator where(Where where) {
        this.innerWhere = where;
        return this;
    }

    public SQLOperator separator(String str) {
        throw new RuntimeException("Method not valid for ExistenceOperator");
    }
}
