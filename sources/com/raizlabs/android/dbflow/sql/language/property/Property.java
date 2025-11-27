package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.sql.language.IConditional;
import com.raizlabs.android.dbflow.sql.language.IOperator;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import java.util.Collection;

public class Property<T> implements IProperty<Property<T>>, IConditional, IOperator<T> {
    public static final Property<String> ALL_PROPERTY = new Property<>((Class<?>) null, NameAlias.rawBuilder(Operator.Operation.MULTIPLY).build());
    public static final Property<?> WILDCARD = new Property<>((Class<?>) null, NameAlias.rawBuilder(Operator.Operation.EMPTY_PARAM).build());
    protected NameAlias nameAlias;
    final Class<?> table;

    public Property(Class<?> cls, NameAlias nameAlias2) {
        this.table = cls;
        this.nameAlias = nameAlias2;
    }

    public static Property<String> allProperty(Class<?> cls) {
        return new Property(cls, NameAlias.rawBuilder(Operator.Operation.MULTIPLY).build()).withTable();
    }

    public OrderBy asc() {
        return OrderBy.fromProperty(this).ascending();
    }

    public Operator.Between between(IConditional iConditional) {
        return getCondition().between(iConditional);
    }

    public OrderBy desc() {
        return OrderBy.fromProperty(this).descending();
    }

    public Operator eq(IConditional iConditional) {
        return getCondition().eq(iConditional);
    }

    public Operator<T> getCondition() {
        return Operator.op(getNameAlias());
    }

    public String getCursorKey() {
        return getNameAlias().getQuery();
    }

    public String getDefinition() {
        return getNameAlias().getFullQuery();
    }

    public NameAlias getDistinctAliasName() {
        return getNameAlias().newBuilder().distinct().build();
    }

    public NameAlias getNameAlias() {
        return this.nameAlias;
    }

    public String getQuery() {
        return getNameAlias().getQuery();
    }

    public Class<?> getTable() {
        return this.table;
    }

    public Operator glob(IConditional iConditional) {
        return getCondition().glob(iConditional);
    }

    public Operator greaterThan(IConditional iConditional) {
        return getCondition().greaterThan(iConditional);
    }

    public Operator greaterThanOrEq(IConditional iConditional) {
        return getCondition().greaterThanOrEq(iConditional);
    }

    public Operator.In in(IConditional iConditional, IConditional... iConditionalArr) {
        return getCondition().in(iConditional, iConditionalArr);
    }

    public Operator is(IConditional iConditional) {
        return getCondition().is(iConditional);
    }

    public Operator isNot(IConditional iConditional) {
        return getCondition().isNot(iConditional);
    }

    public Operator isNotNull() {
        return getCondition().isNotNull();
    }

    public Operator isNull() {
        return getCondition().isNull();
    }

    public Operator lessThan(IConditional iConditional) {
        return getCondition().lessThan(iConditional);
    }

    public Operator lessThanOrEq(IConditional iConditional) {
        return getCondition().lessThanOrEq(iConditional);
    }

    public Operator like(IConditional iConditional) {
        return getCondition().like(iConditional);
    }

    public Operator notEq(IConditional iConditional) {
        return getCondition().notEq(iConditional);
    }

    public Operator.In notIn(IConditional iConditional, IConditional... iConditionalArr) {
        return getCondition().notIn(iConditional, iConditionalArr);
    }

    public Operator<T> notLike(String str) {
        return getCondition().notLike(str);
    }

    public String toString() {
        return getNameAlias().toString();
    }

    public Property<T> as(String str) {
        return new Property<>(this.table, getNameAlias().newBuilder().as(str).build());
    }

    public Operator.Between between(BaseModelQueriable baseModelQueriable) {
        return getCondition().between(baseModelQueriable);
    }

    public Operator concatenate(IConditional iConditional) {
        return getCondition().concatenate(iConditional);
    }

    public Property<T> distinct() {
        return new Property<>(this.table, getDistinctAliasName());
    }

    public Operator div(BaseModelQueriable baseModelQueriable) {
        return getCondition().div(baseModelQueriable);
    }

    public Operator eq(BaseModelQueriable baseModelQueriable) {
        return getCondition().eq(baseModelQueriable);
    }

    public Operator<T> glob(String str) {
        return getCondition().glob(str);
    }

    public Operator greaterThan(BaseModelQueriable baseModelQueriable) {
        return getCondition().greaterThan(baseModelQueriable);
    }

    public Operator greaterThanOrEq(BaseModelQueriable baseModelQueriable) {
        return getCondition().greaterThanOrEq(baseModelQueriable);
    }

    public Operator.In in(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr) {
        return getCondition().in(baseModelQueriable, baseModelQueriableArr);
    }

    public Operator is(BaseModelQueriable baseModelQueriable) {
        return getCondition().is(baseModelQueriable);
    }

    public Operator isNot(BaseModelQueriable baseModelQueriable) {
        return getCondition().isNot(baseModelQueriable);
    }

    public Operator lessThan(BaseModelQueriable baseModelQueriable) {
        return getCondition().lessThan(baseModelQueriable);
    }

    public Operator lessThanOrEq(BaseModelQueriable baseModelQueriable) {
        return getCondition().lessThanOrEq(baseModelQueriable);
    }

    public Operator<T> like(String str) {
        return getCondition().like(str);
    }

    public Operator minus(BaseModelQueriable baseModelQueriable) {
        return getCondition().minus(baseModelQueriable);
    }

    public Operator notEq(BaseModelQueriable baseModelQueriable) {
        return getCondition().notEq(baseModelQueriable);
    }

    public Operator.In notIn(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr) {
        return getCondition().notIn(baseModelQueriable, baseModelQueriableArr);
    }

    public Operator notLike(IConditional iConditional) {
        return getCondition().notLike(iConditional);
    }

    public Operator plus(BaseModelQueriable baseModelQueriable) {
        return getCondition().plus(baseModelQueriable);
    }

    public Operator rem(BaseModelQueriable baseModelQueriable) {
        return getCondition().rem(baseModelQueriable);
    }

    public Operator times(BaseModelQueriable baseModelQueriable) {
        return getCondition().times(baseModelQueriable);
    }

    public Operator.Between<T> between(T t10) {
        return getCondition().between(t10);
    }

    public Property<T> concatenate(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.CONCATENATE, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> div(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.DIVISION, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Operator<T> eq(T t10) {
        return getCondition().eq(t10);
    }

    public Operator glob(BaseModelQueriable baseModelQueriable) {
        return getCondition().glob(baseModelQueriable);
    }

    public Operator<T> greaterThan(T t10) {
        return getCondition().greaterThan(t10);
    }

    public Operator<T> greaterThanOrEq(T t10) {
        return getCondition().greaterThanOrEq(t10);
    }

    public Operator.In<T> in(T t10, T... tArr) {
        return getCondition().in(t10, tArr);
    }

    public Operator<T> is(T t10) {
        return getCondition().is(t10);
    }

    public Operator<T> isNot(T t10) {
        return getCondition().isNot(t10);
    }

    public Operator<T> lessThan(T t10) {
        return getCondition().lessThan(t10);
    }

    public Operator<T> lessThanOrEq(T t10) {
        return getCondition().lessThanOrEq(t10);
    }

    public Operator like(BaseModelQueriable baseModelQueriable) {
        return getCondition().like(baseModelQueriable);
    }

    public Property<T> minus(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.MINUS, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Operator<T> notEq(T t10) {
        return getCondition().notEq(t10);
    }

    public Operator.In<T> notIn(T t10, T... tArr) {
        return getCondition().notIn(t10, tArr);
    }

    public Operator notLike(BaseModelQueriable baseModelQueriable) {
        return getCondition().notLike(baseModelQueriable);
    }

    public Property<T> plus(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.PLUS, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> rem(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.MOD, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> times(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.MULTIPLY, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> withTable() {
        return withTable(new NameAlias.Builder(FlowManager.getTableName(this.table)).build());
    }

    public Property(Class<?> cls, String str) {
        this.table = cls;
        if (str != null) {
            this.nameAlias = new NameAlias.Builder(str).build();
        }
    }

    public Operator.In<T> in(Collection<T> collection) {
        return getCondition().in(collection);
    }

    public Operator.In<T> notIn(Collection<T> collection) {
        return getCondition().notIn(collection);
    }

    public Property<T> withTable(NameAlias nameAlias2) {
        return new Property<>(this.table, getNameAlias().newBuilder().withTable(nameAlias2.getQuery()).build());
    }

    public Operator<T> concatenate(T t10) {
        return getCondition().concatenate((Object) t10);
    }

    public Operator<T> div(T t10) {
        return getCondition().div(t10);
    }

    public Operator<T> minus(T t10) {
        return getCondition().minus(t10);
    }

    public Operator<T> plus(T t10) {
        return getCondition().plus(t10);
    }

    public Operator<T> rem(T t10) {
        return getCondition().rem(t10);
    }

    public Operator<T> times(T t10) {
        return getCondition().times(t10);
    }

    public Property(Class<?> cls, String str, String str2) {
        this(cls, NameAlias.builder(str).as(str2).build());
    }
}
