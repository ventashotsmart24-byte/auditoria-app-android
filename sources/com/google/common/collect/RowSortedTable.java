package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface RowSortedTable<R, C, V> extends Table<R, C, V> {
    /* bridge */ /* synthetic */ Set rowKeySet();

    SortedSet<R> rowKeySet();

    /* bridge */ /* synthetic */ Map rowMap();

    SortedMap<R, Map<C, V>> rowMap();
}
