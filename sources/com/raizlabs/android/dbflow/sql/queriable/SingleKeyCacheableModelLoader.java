package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public class SingleKeyCacheableModelLoader<TModel> extends CacheableModelLoader<TModel> {
    public SingleKeyCacheableModelLoader(Class<TModel> cls) {
        super(cls);
    }

    public TModel convertToData(FlowCursor flowCursor, TModel tmodel, boolean z10) {
        if (z10 && !flowCursor.moveToFirst()) {
            return null;
        }
        Object cachingColumnValueFromCursor = getModelAdapter().getCachingColumnValueFromCursor(flowCursor);
        TModel tmodel2 = getModelCache().get(cachingColumnValueFromCursor);
        if (tmodel2 == null) {
            if (tmodel == null) {
                tmodel = getModelAdapter().newInstance();
            }
            getModelAdapter().loadFromCursor(flowCursor, tmodel);
            getModelCache().addModel(cachingColumnValueFromCursor, tmodel);
            return tmodel;
        }
        getModelAdapter().reloadRelationships(tmodel2, flowCursor);
        return tmodel2;
    }
}
