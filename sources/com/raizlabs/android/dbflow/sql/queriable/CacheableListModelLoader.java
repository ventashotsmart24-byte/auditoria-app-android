package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.List;

public class CacheableListModelLoader<TModel> extends ListModelLoader<TModel> {
    private ModelAdapter<TModel> modelAdapter;
    private ModelCache<TModel, ?> modelCache;

    public CacheableListModelLoader(Class<TModel> cls) {
        super(cls);
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
            ModelCache<TModel, ?> modelCache2 = this.modelAdapter.getModelCache();
            this.modelCache = modelCache2;
            if (modelCache2 == null) {
                throw new IllegalArgumentException("ModelCache specified in convertToCacheableList() must not be null.");
            }
        }
        return this.modelCache;
    }

    public List<TModel> convertToData(FlowCursor flowCursor, List<TModel> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        Object[] objArr = new Object[getModelAdapter().getCachingColumns().length];
        if (flowCursor.moveToFirst()) {
            do {
                Object[] cachingColumnValuesFromCursor = getModelAdapter().getCachingColumnValuesFromCursor(objArr, flowCursor);
                Object obj = getModelCache().get(getModelAdapter().getCachingId(cachingColumnValuesFromCursor));
                if (obj != null) {
                    getModelAdapter().reloadRelationships(obj, flowCursor);
                    list.add(obj);
                } else {
                    Object newInstance = getModelAdapter().newInstance();
                    getModelAdapter().loadFromCursor(flowCursor, newInstance);
                    getModelCache().addModel(getModelAdapter().getCachingId(cachingColumnValuesFromCursor), newInstance);
                    list.add(newInstance);
                }
            } while (flowCursor.moveToNext());
        }
        return list;
    }
}
