package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.MapDifference;
import java.util.Map;
import java.util.SortedMap;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {
    /* bridge */ /* synthetic */ Map entriesDiffering();

    SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();

    /* bridge */ /* synthetic */ Map entriesInCommon();

    SortedMap<K, V> entriesInCommon();

    /* bridge */ /* synthetic */ Map entriesOnlyOnLeft();

    SortedMap<K, V> entriesOnlyOnLeft();

    /* bridge */ /* synthetic */ Map entriesOnlyOnRight();

    SortedMap<K, V> entriesOnlyOnRight();
}
