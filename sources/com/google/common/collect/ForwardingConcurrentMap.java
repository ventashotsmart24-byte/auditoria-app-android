package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
    public abstract ConcurrentMap<K, V> delegate();

    @CheckForNull
    @CanIgnoreReturnValue
    public V putIfAbsent(K k10, V v10) {
        return delegate().putIfAbsent(k10, v10);
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V replace(K k10, V v10) {
        return delegate().replace(k10, v10);
    }

    @CanIgnoreReturnValue
    public boolean replace(K k10, V v10, V v11) {
        return delegate().replace(k10, v10, v11);
    }
}
