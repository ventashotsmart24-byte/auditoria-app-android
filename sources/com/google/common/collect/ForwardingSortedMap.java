package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    @Beta
    public class StandardKeySet extends Maps.SortedKeySet<K, V> {
        public StandardKeySet(ForwardingSortedMap forwardingSortedMap) {
            super(forwardingSortedMap);
        }
    }

    public static int unsafeCompare(@CheckForNull Comparator<?> comparator, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @CheckForNull
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    public abstract SortedMap<K, V> delegate();

    @ParametricNullness
    public K firstKey() {
        return delegate().firstKey();
    }

    public SortedMap<K, V> headMap(@ParametricNullness K k10) {
        return delegate().headMap(k10);
    }

    @ParametricNullness
    public K lastKey() {
        return delegate().lastKey();
    }

    @Beta
    public boolean standardContainsKey(@CheckForNull Object obj) {
        try {
            if (unsafeCompare(comparator(), tailMap(obj).firstKey(), obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    @Beta
    public SortedMap<K, V> standardSubMap(K k10, K k11) {
        boolean z10;
        if (unsafeCompare(comparator(), k10, k11) <= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "fromKey must be <= toKey");
        return tailMap(k10).headMap(k11);
    }

    public SortedMap<K, V> subMap(@ParametricNullness K k10, @ParametricNullness K k11) {
        return delegate().subMap(k10, k11);
    }

    public SortedMap<K, V> tailMap(@ParametricNullness K k10) {
        return delegate().tailMap(k10);
    }
}
