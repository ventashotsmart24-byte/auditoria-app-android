package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;

public class UnSafeStringOperator implements SQLOperator, Query {
    private final String conditionString;
    private String separator = "";

    public UnSafeStringOperator(String str, String[] strArr) {
        if (str != null) {
            for (String replaceFirst : strArr) {
                str = str.replaceFirst("\\?", replaceFirst);
            }
        }
        this.conditionString = str;
    }

    public void appendConditionToQuery(QueryBuilder queryBuilder) {
        queryBuilder.append(this.conditionString);
    }

    public String columnName() {
        return "";
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();
        appendConditionToQuery(queryBuilder);
        return queryBuilder.getQuery();
    }

    public boolean hasSeparator() {
        return StringUtils.isNotNullOrEmpty(this.separator);
    }

    public String operation() {
        return "";
    }

    public String separator() {
        return this.separator;
    }

    public Object value() {
        return "";
    }

    public SQLOperator separator(String str) {
        this.separator = str;
        return this;
    }
}
