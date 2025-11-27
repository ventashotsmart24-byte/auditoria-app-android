package com.raizlabs.android.dbflow.structure.cache;

public class ModelLruCache<TModel> extends ModelCache<TModel, LruCache<Long, TModel>> {
    public ModelLruCache(int i10) {
        super(new LruCache(i10));
    }

    public static <TModel> ModelLruCache<TModel> newInstance(int i10) {
        if (i10 <= 0) {
            i10 = 25;
        }
        return new ModelLruCache<>(i10);
    }

    public void addModel(Object obj, TModel tmodel) {
        if (obj instanceof Number) {
            synchronized (((LruCache) getCache())) {
                ((LruCache) getCache()).put(Long.valueOf(((Number) obj).longValue()), tmodel);
            }
            return;
        }
        throw new IllegalArgumentException("A ModelLruCache must use an id that can cast toa Number to convert it into a long");
    }

    public void clear() {
        synchronized (((LruCache) getCache())) {
            ((LruCache) getCache()).evictAll();
        }
    }

    public TModel get(Object obj) {
        if (obj instanceof Number) {
            return ((LruCache) getCache()).get(Long.valueOf(((Number) obj).longValue()));
        }
        throw new IllegalArgumentException("A ModelLruCache must use an id that can cast toa Number to convert it into a long");
    }

    public TModel removeModel(Object obj) {
        TModel remove;
        if (obj instanceof Number) {
            synchronized (((LruCache) getCache())) {
                remove = ((LruCache) getCache()).remove(Long.valueOf(((Number) obj).longValue()));
            }
            return remove;
        }
        throw new IllegalArgumentException("A ModelLruCache uses an id that can cast toa Number to convert it into a long");
    }

    public void setCacheSize(int i10) {
        ((LruCache) getCache()).resize(i10);
    }
}
