package com.raizlabs.android.dbflow.structure.cache;

import android.util.SparseArray;
import com.raizlabs.android.dbflow.config.FlowLog;

public class SparseArrayBasedCache<TModel> extends ModelCache<TModel, SparseArray<TModel>> {
    public SparseArrayBasedCache() {
        super(new SparseArray());
    }

    public void addModel(Object obj, TModel tmodel) {
        if (obj instanceof Number) {
            synchronized (((SparseArray) getCache())) {
                ((SparseArray) getCache()).put(((Number) obj).intValue(), tmodel);
            }
            return;
        }
        throw new IllegalArgumentException("A SparseArrayBasedCache must use an id that can cast to a Number to convert it into a int");
    }

    public void clear() {
        synchronized (((SparseArray) getCache())) {
            ((SparseArray) getCache()).clear();
        }
    }

    public TModel get(Object obj) {
        if (obj instanceof Number) {
            return ((SparseArray) getCache()).get(((Number) obj).intValue());
        }
        throw new IllegalArgumentException("A SparseArrayBasedCache uses an id that can cast to a Number to convert it into a int");
    }

    public TModel removeModel(Object obj) {
        TModel tmodel = get(obj);
        synchronized (((SparseArray) getCache())) {
            ((SparseArray) getCache()).remove(((Number) obj).intValue());
        }
        return tmodel;
    }

    public void setCacheSize(int i10) {
        FlowLog.Level level = FlowLog.Level.I;
        FlowLog.log(level, "The cache size for " + SparseArrayBasedCache.class.getSimpleName() + " is not re-configurable.");
    }

    public SparseArrayBasedCache(int i10) {
        super(new SparseArray(i10));
    }

    public SparseArrayBasedCache(SparseArray<TModel> sparseArray) {
        super(sparseArray);
    }
}
