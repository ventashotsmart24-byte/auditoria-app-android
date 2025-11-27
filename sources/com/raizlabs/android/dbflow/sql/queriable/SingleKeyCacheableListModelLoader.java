package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.List;

public class SingleKeyCacheableListModelLoader<TModel> extends CacheableListModelLoader<TModel> {
    public SingleKeyCacheableListModelLoader(Class<TModel> cls) {
        super(cls);
    }

    public List<TModel> convertToData(FlowCursor flowCursor, List<TModel> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (flowCursor.moveToFirst()) {
            do {
                Object cachingColumnValueFromCursor = getModelAdapter().getCachingColumnValueFromCursor(flowCursor);
                Object obj = getModelCache().get(cachingColumnValueFromCursor);
                if (obj != null) {
                    getModelAdapter().reloadRelationships(obj, flowCursor);
                    list.add(obj);
                } else {
                    Object newInstance = getModelAdapter().newInstance();
                    getModelAdapter().loadFromCursor(flowCursor, newInstance);
                    getModelCache().addModel(cachingColumnValueFromCursor, newInstance);
                    list.add(newInstance);
                }
            } while (flowCursor.moveToNext());
        }
        return list;
    }
}
