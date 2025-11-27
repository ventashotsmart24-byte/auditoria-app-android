package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
    public V apply(K k10) {
        return delegate().apply(k10);
    }

    public abstract LoadingCache<K, V> delegate();

    public V get(K k10) {
        return delegate().get(k10);
    }

    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) {
        return delegate().getAll(iterable);
    }

    public V getUnchecked(K k10) {
        return delegate().getUnchecked(k10);
    }

    public void refresh(K k10) {
        delegate().refresh(k10);
    }

    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        private final LoadingCache<K, V> delegate;

        public SimpleForwardingLoadingCache(LoadingCache<K, V> loadingCache) {
            this.delegate = (LoadingCache) Preconditions.checkNotNull(loadingCache);
        }

        public final LoadingCache<K, V> delegate() {
            return this.delegate;
        }
    }
}
