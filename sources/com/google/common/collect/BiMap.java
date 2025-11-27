package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface BiMap<K, V> extends Map<K, V> {
    @CheckForNull
    @CanIgnoreReturnValue
    V forcePut(@ParametricNullness K k10, @ParametricNullness V v10);

    BiMap<V, K> inverse();

    @CheckForNull
    @CanIgnoreReturnValue
    V put(@ParametricNullness K k10, @ParametricNullness V v10);

    void putAll(Map<? extends K, ? extends V> map);

    /* bridge */ /* synthetic */ Collection values();

    Set<V> values();
}
