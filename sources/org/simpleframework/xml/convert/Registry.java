package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

public class Registry {
    private final RegistryBinder binder = new RegistryBinder();
    private final Cache<Converter> cache = new ConcurrentCache();

    private Converter create(Class cls) {
        Converter lookup = this.binder.lookup(cls);
        if (lookup != null) {
            this.cache.cache(cls, lookup);
        }
        return lookup;
    }

    public Registry bind(Class cls, Class cls2) {
        if (cls != null) {
            this.binder.bind(cls, cls2);
        }
        return this;
    }

    public Converter lookup(Class cls) {
        Converter fetch = this.cache.fetch(cls);
        if (fetch == null) {
            return create(cls);
        }
        return fetch;
    }

    public Registry bind(Class cls, Converter converter) {
        if (cls != null) {
            this.cache.cache(cls, converter);
        }
        return this;
    }
}
