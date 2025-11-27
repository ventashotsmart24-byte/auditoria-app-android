package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;

public class Trigger implements Query {
    public static final String AFTER = "AFTER";
    public static final String BEFORE = "BEFORE";
    public static final String INSTEAD_OF = "INSTEAD OF";
    String beforeOrAfter;
    boolean temporary;
    final String triggerName;

    private Trigger(String str) {
        this.triggerName = str;
    }

    public static Trigger create(String str) {
        return new Trigger(str);
    }

    public Trigger after() {
        this.beforeOrAfter = AFTER;
        return this;
    }

    public Trigger before() {
        this.beforeOrAfter = BEFORE;
        return this;
    }

    public <TModel> TriggerMethod<TModel> deleteOn(Class<TModel> cls) {
        return new TriggerMethod<>(this, "DELETE", cls, new IProperty[0]);
    }

    public String getName() {
        return this.triggerName;
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder("CREATE ");
        if (this.temporary) {
            queryBuilder.append("TEMP ");
        }
        QueryBuilder appendSpace = queryBuilder.append("TRIGGER IF NOT EXISTS ").appendQuotedIfNeeded(this.triggerName).appendSpace();
        appendSpace.appendOptional(this.beforeOrAfter + " ");
        return queryBuilder.getQuery();
    }

    public <TModel> TriggerMethod<TModel> insertOn(Class<TModel> cls) {
        return new TriggerMethod<>(this, TriggerMethod.INSERT, cls, new IProperty[0]);
    }

    public Trigger insteadOf() {
        this.beforeOrAfter = INSTEAD_OF;
        return this;
    }

    public Trigger temporary() {
        this.temporary = true;
        return this;
    }

    public <TModel> TriggerMethod<TModel> updateOn(Class<TModel> cls, IProperty... iPropertyArr) {
        return new TriggerMethod<>(this, TriggerMethod.UPDATE, cls, iPropertyArr);
    }
}
