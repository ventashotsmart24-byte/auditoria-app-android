package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public class StringQuery<TModel> extends BaseModelQueriable<TModel> {
    private String[] args;
    private final String query;

    public StringQuery(Class<TModel> cls, String str) {
        super(cls);
        this.query = str;
    }

    public BaseModel.Action getPrimaryAction() {
        return BaseModel.Action.CHANGE;
    }

    public String getQuery() {
        return this.query;
    }

    public FlowCursor query() {
        return query(FlowManager.getDatabaseForTable(getTable()).getWritableDatabase());
    }

    public StringQuery<TModel> setSelectionArgs(String[] strArr) {
        this.args = strArr;
        return this;
    }

    public FlowCursor query(DatabaseWrapper databaseWrapper) {
        return databaseWrapper.rawQuery(this.query, this.args);
    }
}
