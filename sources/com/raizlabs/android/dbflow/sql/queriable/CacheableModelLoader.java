package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public class CacheableModelLoader<TModel> extends SingleModelLoader<TModel> {
    private ModelAdapter<TModel> modelAdapter;
    private ModelCache<TModel, ?> modelCache;

    public CacheableModelLoader(Class<TModel> cls) {
        super(cls);
    }

    public TModel convertToData(FlowCursor flowCursor, TModel tmodel, boolean z10) {
        if (z10 && !flowCursor.moveToFirst()) {
            return null;
        }
        Object[] cachingColumnValuesFromCursor = getModelAdapter().getCachingColumnValuesFromCursor(new Object[getModelAdapter().getCachingColumns().length], flowCursor);
        TModel tmodel2 = getModelCache().get(getModelAdapter().getCachingId(cachingColumnValuesFromCursor));
        if (tmodel2 == null) {
            if (tmodel == null) {
                tmodel = getModelAdapter().newInstance();
            }
            getModelAdapter().loadFromCursor(flowCursor, tmodel);
            getModelCache().addModel(getModelAdapter().getCachingId(cachingColumnValuesFromCursor), tmodel);
            return tmodel;
        }
        getModelAdapter().reloadRelationships(tmodel2, flowCursor);
        return tmodel2;
    }

    public ModelAdapter<TModel> getModelAdapter() {
        if (this.modelAdapter == null) {
            if (getInstanceAdapter() instanceof ModelAdapter) {
                ModelAdapter<TModel> modelAdapter2 = (ModelAdapter) getInstanceAdapter();
                this.modelAdapter = modelAdapter2;
                if (!modelAdapter2.cachingEnabled()) {
                    throw new IllegalArgumentException("You cannot call this method for a table that has no caching id. Eitheruse one Primary Key or use the MultiCacheKeyConverter");
                }
            } else {
                throw new IllegalArgumentException("A non-Table type was used.");
            }
        }
        return this.modelAdapter;
    }

    public ModelCache<TModel, ?> getModelCache() {
        if (this.modelCache == null) {
            this.modelCache = getModelAdapter().getModelCache();
        }
        return this.modelCache;
    }
}
