package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

public class Transformer {
    private final Cache<Transform> cache = new ConcurrentCache();
    private final Cache<Object> error = new ConcurrentCache();
    private final Matcher matcher;

    public Transformer(Matcher matcher2) {
        this.matcher = new DefaultMatcher(matcher2);
    }

    private Transform lookup(Class cls) {
        if (this.error.contains(cls)) {
            return null;
        }
        Transform fetch = this.cache.fetch(cls);
        if (fetch != null) {
            return fetch;
        }
        return match(cls);
    }

    private Transform match(Class cls) {
        Transform match = this.matcher.match(cls);
        if (match != null) {
            this.cache.cache(cls, match);
        } else {
            this.error.cache(cls, this);
        }
        return match;
    }

    public Object read(String str, Class cls) {
        Transform lookup = lookup(cls);
        if (lookup != null) {
            return lookup.read(str);
        }
        throw new TransformException("Transform of %s not supported", cls);
    }

    public boolean valid(Class cls) {
        if (lookup(cls) != null) {
            return true;
        }
        return false;
    }

    public String write(Object obj, Class cls) {
        Transform lookup = lookup(cls);
        if (lookup != null) {
            return lookup.write(obj);
        }
        throw new TransformException("Transform of %s not supported", cls);
    }
}
