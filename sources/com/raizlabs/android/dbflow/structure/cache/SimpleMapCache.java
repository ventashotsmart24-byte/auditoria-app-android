package com.raizlabs.android.dbflow.structure.cache;

import com.raizlabs.android.dbflow.config.FlowLog;
import java.util.HashMap;
import java.util.Map;

public class SimpleMapCache<TModel> extends ModelCache<TModel, Map<Object, TModel>> {
    public SimpleMapCache(int i10) {
        super(new HashMap(i10));
    }

    public void addModel(Object obj, TModel tmodel) {
        ((Map) getCache()).put(obj, tmodel);
    }

    public void clear() {
        ((Map) getCache()).clear();
    }

    public TModel get(Object obj) {
        return ((Map) getCache()).get(obj);
    }

    public TModel removeModel(Object obj) {
        return ((Map) getCache()).remove(obj);
    }

    public void setCacheSize(int i10) {
        FlowLog.Level level = FlowLog.Level.I;
        FlowLog.log(level, "The cache size for " + SimpleMapCache.class.getSimpleName() + " is not re-configurable.");
    }

    public SimpleMapCache(Map<Object, TModel> map) {
        super(map);
    }
}
