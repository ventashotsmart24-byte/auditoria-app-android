package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.annotation.Collate;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Operator<T> extends BaseOperator implements IOperator<T> {
    private boolean convertToDB;
    private TypeConverter typeConverter;

    public static class Between<T> extends BaseOperator implements Query {
        private T secondValue;

        public Between<T> and(T t10) {
            this.secondValue = t10;
            return this;
        }

        public void appendConditionToQuery(QueryBuilder queryBuilder) {
            queryBuilder.append(columnName()).append(operation()).append(convertObjectToString(value(), true)).appendSpaceSeparated(Operation.AND).append(convertObjectToString(secondValue(), true)).appendSpace().appendOptional(postArgument());
        }

        public String getQuery() {
            QueryBuilder queryBuilder = new QueryBuilder();
            appendConditionToQuery(queryBuilder);
            return queryBuilder.getQuery();
        }

        public T secondValue() {
            return this.secondValue;
        }

        private Between(Operator<T> operator, T t10) {
            super(operator.nameAlias);
            this.operation = String.format(" %1s ", new Object[]{Operation.BETWEEN});
            this.value = t10;
            this.isValueSet = true;
            this.postArg = operator.postArgument();
        }
    }

    public static class Operation {
        public static final String AND = "AND";
        public static final String BETWEEN = "BETWEEN";
        public static final String CONCATENATE = "||";
        public static final String DIVISION = "/";
        public static final String EMPTY_PARAM = "?";
        public static final String EQUALS = "=";
        public static final String GLOB = "GLOB";
        public static final String GREATER_THAN = ">";
        public static final String GREATER_THAN_OR_EQUALS = ">=";
        public static final String IN = "IN";
        public static final String IS_NOT_NULL = "IS NOT NULL";
        public static final String IS_NULL = "IS NULL";
        public static final String LESS_THAN = "<";
        public static final String LESS_THAN_OR_EQUALS = "<=";
        public static final String LIKE = "LIKE";
        public static final String MINUS = "-";
        public static final String MOD = "%";
        public static final String MULTIPLY = "*";
        public static final String NOT_EQUALS = "!=";
        public static final String NOT_IN = "NOT IN";
        public static final String NOT_LIKE = "NOT LIKE";
        public static final String OR = "OR";
        public static final String PLUS = "+";
    }

    public Operator(NameAlias nameAlias) {
        super(nameAlias);
    }

    private Operator<T> assignValueOp(Object obj, String str) {
        this.operation = str;
        return value(obj);
    }

    public static String convertValueToString(Object obj) {
        return BaseOperator.convertValueToString(obj, false);
    }

    public static <T> Operator<T> op(NameAlias nameAlias) {
        return new Operator<>(nameAlias);
    }

    public void appendConditionToQuery(QueryBuilder queryBuilder) {
        queryBuilder.append(columnName()).append(operation());
        if (this.isValueSet) {
            queryBuilder.append(convertObjectToString(value(), true));
        }
        if (postArgument() != null) {
            queryBuilder.appendSpace().append(postArgument());
        }
    }

    public Between between(IConditional iConditional) {
        return new Between(iConditional);
    }

    public Operator<T> collate(String str) {
        this.postArg = "COLLATE " + str;
        return this;
    }

    public Operator<T> concatenate(Object obj) {
        this.operation = new QueryBuilder(Operation.EQUALS).append(columnName()).toString();
        TypeConverter typeConverter2 = this.typeConverter;
        if (typeConverter2 == null && obj != null) {
            typeConverter2 = FlowManager.getTypeConverterForClass(obj.getClass());
        }
        if (typeConverter2 != null && this.convertToDB) {
            obj = typeConverter2.getDBValue(obj);
        }
        if ((obj instanceof String) || (obj instanceof IOperator) || (obj instanceof Character)) {
            this.operation = String.format("%1s %1s ", new Object[]{this.operation, Operation.CONCATENATE});
        } else if (obj instanceof Number) {
            this.operation = String.format("%1s %1s ", new Object[]{this.operation, Operation.PLUS});
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = obj != null ? obj.getClass() : "null";
            throw new IllegalArgumentException(String.format("Cannot concatenate the %1s", objArr));
        }
        this.value = obj;
        this.isValueSet = true;
        return this;
    }

    public String convertObjectToString(Object obj, boolean z10) {
        TypeConverter typeConverter2 = this.typeConverter;
        if (typeConverter2 == null) {
            return super.convertObjectToString(obj, z10);
        }
        try {
            if (this.convertToDB) {
                obj = typeConverter2.getDBValue(obj);
            }
        } catch (ClassCastException unused) {
            FlowLog.Level level = FlowLog.Level.I;
            FlowLog.log(level, "Value passed to operation is not valid type for TypeConverter in the column. Preserving value " + obj + " to be used as is.");
        }
        return BaseOperator.convertValueToString(obj, z10, false);
    }

    public Operator<T> div(T t10) {
        return assignValueOp(t10, Operation.DIVISION);
    }

    public Operator<T> eq(T t10) {
        return is(t10);
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();
        appendConditionToQuery(queryBuilder);
        return queryBuilder.getQuery();
    }

    public Operator<T> glob(String str) {
        this.operation = String.format(" %1s ", new Object[]{Operation.GLOB});
        return value(str);
    }

    public Operator<T> greaterThan(T t10) {
        this.operation = Operation.GREATER_THAN;
        return value(t10);
    }

    public Operator<T> greaterThanOrEq(T t10) {
        this.operation = Operation.GREATER_THAN_OR_EQUALS;
        return value(t10);
    }

    public In in(IConditional iConditional, IConditional... iConditionalArr) {
        return new In(iConditional, true, iConditionalArr);
    }

    public Operator<T> is(T t10) {
        this.operation = Operation.EQUALS;
        return value(t10);
    }

    public Operator<T> isNot(T t10) {
        this.operation = Operation.NOT_EQUALS;
        return value(t10);
    }

    public Operator<T> isNotNull() {
        this.operation = String.format(" %1s ", new Object[]{Operation.IS_NOT_NULL});
        return this;
    }

    public Operator<T> isNull() {
        this.operation = String.format(" %1s ", new Object[]{Operation.IS_NULL});
        return this;
    }

    public Operator<T> lessThan(T t10) {
        this.operation = Operation.LESS_THAN;
        return value(t10);
    }

    public Operator<T> lessThanOrEq(T t10) {
        this.operation = Operation.LESS_THAN_OR_EQUALS;
        return value(t10);
    }

    public Operator<T> like(String str) {
        this.operation = String.format(" %1s ", new Object[]{Operation.LIKE});
        return value(str);
    }

    public Operator<T> minus(T t10) {
        return assignValueOp(t10, Operation.MINUS);
    }

    public Operator<T> notEq(T t10) {
        return isNot(t10);
    }

    public In notIn(IConditional iConditional, IConditional... iConditionalArr) {
        return new In(iConditional, false, iConditionalArr);
    }

    public Operator<T> notLike(String str) {
        this.operation = String.format(" %1s ", new Object[]{Operation.NOT_LIKE});
        return value(str);
    }

    public Operator<T> operation(String str) {
        this.operation = str;
        return this;
    }

    public Operator<T> plus(T t10) {
        return assignValueOp(t10, Operation.PLUS);
    }

    public Operator<T> postfix(String str) {
        this.postArg = str;
        return this;
    }

    public Operator<T> rem(T t10) {
        return assignValueOp(t10, Operation.MOD);
    }

    public Operator<T> times(T t10) {
        return assignValueOp(t10, Operation.MULTIPLY);
    }

    public Operator<T> value(Object obj) {
        this.value = obj;
        this.isValueSet = true;
        return this;
    }

    public static class In<T> extends BaseOperator implements Query {
        private List<T> inArguments;

        public In<T> and(T t10) {
            this.inArguments.add(t10);
            return this;
        }

        public void appendConditionToQuery(QueryBuilder queryBuilder) {
            queryBuilder.append(columnName()).append(operation()).append("(").append(BaseOperator.joinArguments(",", this.inArguments, this)).append(")");
        }

        public String getQuery() {
            QueryBuilder queryBuilder = new QueryBuilder();
            appendConditionToQuery(queryBuilder);
            return queryBuilder.getQuery();
        }

        @SafeVarargs
        private In(Operator<T> operator, T t10, boolean z10, T... tArr) {
            super(operator.columnAlias());
            ArrayList arrayList = new ArrayList();
            this.inArguments = arrayList;
            arrayList.add(t10);
            Collections.addAll(this.inArguments, tArr);
            Object[] objArr = new Object[1];
            objArr[0] = z10 ? Operation.IN : Operation.NOT_IN;
            this.operation = String.format(" %1s ", objArr);
        }

        private In(Operator<T> operator, Collection<T> collection, boolean z10) {
            super(operator.columnAlias());
            ArrayList arrayList = new ArrayList();
            this.inArguments = arrayList;
            arrayList.addAll(collection);
            Object[] objArr = new Object[1];
            objArr[0] = z10 ? Operation.IN : Operation.NOT_IN;
            this.operation = String.format(" %1s ", objArr);
        }
    }

    public Operator(NameAlias nameAlias, TypeConverter typeConverter2, boolean z10) {
        super(nameAlias);
        this.typeConverter = typeConverter2;
        this.convertToDB = z10;
    }

    public static <T> Operator<T> op(NameAlias nameAlias, TypeConverter typeConverter2, boolean z10) {
        return new Operator<>(nameAlias, typeConverter2, z10);
    }

    public Between between(BaseModelQueriable baseModelQueriable) {
        return new Between(baseModelQueriable);
    }

    public Operator<T> collate(Collate collate) {
        if (collate.equals(Collate.NONE)) {
            this.postArg = null;
        } else {
            collate(collate.name());
        }
        return this;
    }

    public Operator div(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.DIVISION);
    }

    public Operator eq(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.EQUALS);
    }

    public In in(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr) {
        return new In(baseModelQueriable, true, baseModelQueriableArr);
    }

    public Operator minus(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.MINUS);
    }

    public Operator notEq(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.NOT_EQUALS);
    }

    public In notIn(BaseModelQueriable baseModelQueriable, BaseModelQueriable[] baseModelQueriableArr) {
        return new In(baseModelQueriable, false, baseModelQueriableArr);
    }

    public Operator plus(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.PLUS);
    }

    public Operator rem(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.MOD);
    }

    public Operator<T> separator(String str) {
        this.separator = str;
        return this;
    }

    public Operator times(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.MULTIPLY);
    }

    public Between<T> between(T t10) {
        return new Between<>(t10);
    }

    public Operator div(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.DIVISION);
    }

    public Operator eq(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.EQUALS);
    }

    public Operator<T> glob(IConditional iConditional) {
        return glob(iConditional.getQuery());
    }

    public Operator<T> greaterThan(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.GREATER_THAN);
    }

    public Operator<T> greaterThanOrEq(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.GREATER_THAN_OR_EQUALS);
    }

    @SafeVarargs
    public final In<T> in(T t10, T... tArr) {
        return new In(t10, true, tArr);
    }

    public Operator is(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.EQUALS);
    }

    public Operator isNot(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.NOT_EQUALS);
    }

    public Operator<T> lessThan(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.LESS_THAN);
    }

    public Operator<T> lessThanOrEq(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.LESS_THAN_OR_EQUALS);
    }

    public Operator<T> like(IConditional iConditional) {
        return like(iConditional.getQuery());
    }

    public Operator minus(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.MINUS);
    }

    public Operator notEq(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.NOT_EQUALS);
    }

    @SafeVarargs
    public final In<T> notIn(T t10, T... tArr) {
        return new In(t10, false, tArr);
    }

    public Operator notLike(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.NOT_LIKE);
    }

    public Operator plus(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.PLUS);
    }

    public Operator rem(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.MOD);
    }

    public Operator times(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.MULTIPLY);
    }

    public Operator<T> glob(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.GLOB);
    }

    public Operator<T> greaterThan(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.GREATER_THAN);
    }

    public Operator<T> greaterThanOrEq(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.GREATER_THAN_OR_EQUALS);
    }

    public In<T> in(Collection<T> collection) {
        return new In<>((Collection) collection, true);
    }

    public Operator is(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.EQUALS);
    }

    public Operator isNot(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.NOT_EQUALS);
    }

    public Operator<T> lessThan(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.LESS_THAN);
    }

    public Operator<T> lessThanOrEq(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.LESS_THAN_OR_EQUALS);
    }

    public Operator<T> like(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.LIKE);
    }

    public In<T> notIn(Collection<T> collection) {
        return new In<>((Collection) collection, false);
    }

    public Operator notLike(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.NOT_LIKE);
    }

    public Operator(Operator operator) {
        super(operator.nameAlias);
        this.typeConverter = operator.typeConverter;
        this.convertToDB = operator.convertToDB;
        this.value = operator.value;
    }

    public Operator<T> concatenate(IConditional iConditional) {
        return concatenate((Object) iConditional);
    }
}
