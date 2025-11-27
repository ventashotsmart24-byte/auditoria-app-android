package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;

public class CaseCondition<TReturn> implements Query {
    private final Case<TReturn> caze;
    private boolean isThenPropertySet;
    private IProperty property;
    private SQLOperator sqlOperator;
    private IProperty thenProperty;
    private TReturn thenValue;
    private TReturn whenValue;

    public CaseCondition(Case<TReturn> caseR, SQLOperator sQLOperator) {
        this.caze = caseR;
        this.sqlOperator = sQLOperator;
    }

    public String getQuery() {
        TReturn treturn;
        QueryBuilder queryBuilder = new QueryBuilder(" WHEN ");
        if (this.caze.isEfficientCase()) {
            TReturn treturn2 = this.property;
            if (treturn2 == null) {
                treturn2 = this.whenValue;
            }
            queryBuilder.append(BaseOperator.convertValueToString(treturn2, false));
        } else {
            this.sqlOperator.appendConditionToQuery(queryBuilder);
        }
        QueryBuilder append = queryBuilder.append(" THEN ");
        if (this.isThenPropertySet) {
            treturn = this.thenProperty;
        } else {
            treturn = this.thenValue;
        }
        append.append(BaseOperator.convertValueToString(treturn, false));
        return queryBuilder.getQuery();
    }

    public Case<TReturn> then(TReturn treturn) {
        this.thenValue = treturn;
        return this.caze;
    }

    public String toString() {
        return getQuery();
    }

    public Case<TReturn> then(IProperty iProperty) {
        this.thenProperty = iProperty;
        this.isThenPropertySet = true;
        return this.caze;
    }

    public CaseCondition(Case<TReturn> caseR, TReturn treturn) {
        this.caze = caseR;
        this.whenValue = treturn;
    }

    public CaseCondition(Case<TReturn> caseR, IProperty iProperty) {
        this.caze = caseR;
        this.property = iProperty;
    }
}
