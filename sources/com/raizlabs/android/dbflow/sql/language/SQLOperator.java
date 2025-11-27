package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.QueryBuilder;

public interface SQLOperator {
    void appendConditionToQuery(QueryBuilder queryBuilder);

    String columnName();

    boolean hasSeparator();

    String operation();

    SQLOperator separator(String str);

    String separator();

    Object value();
}
