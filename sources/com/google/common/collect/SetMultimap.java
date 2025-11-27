package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface SetMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    /* bridge */ /* synthetic */ Collection entries();

    Set<Map.Entry<K, V>> entries();

    boolean equals(@CheckForNull Object obj);

    /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object obj);

    Set<V> get(@ParametricNullness K k10);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    Set<V> removeAll(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object obj, Iterable iterable);

    @CanIgnoreReturnValue
    Set<V> replaceValues(@ParametricNullness K k10, Iterable<? extends V> iterable);
}
