package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {
    Map<K, Collection<V>> asMap();

    /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object obj);

    /* bridge */ /* synthetic */ Set get(@ParametricNullness Object obj);

    SortedSet<V> get(@ParametricNullness K k10);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    SortedSet<V> removeAll(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object obj, Iterable iterable);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Set replaceValues(@ParametricNullness Object obj, Iterable iterable);

    @CanIgnoreReturnValue
    SortedSet<V> replaceValues(@ParametricNullness K k10, Iterable<? extends V> iterable);

    @CheckForNull
    Comparator<? super V> valueComparator();
}
