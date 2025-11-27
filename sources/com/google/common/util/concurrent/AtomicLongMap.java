package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class AtomicLongMap<K> implements Serializable {
    @CheckForNull
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, AtomicLong> map;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new Function<AtomicLong, Long>(this) {
            public Long apply(AtomicLong atomicLong) {
                return Long.valueOf(atomicLong.get());
            }
        }));
    }

    @CanIgnoreReturnValue
    public long addAndGet(K k10, long j10) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k10);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k10, new AtomicLong(j10))) == null) {
                return j10;
            }
            while (true) {
                long j11 = atomicLong.get();
                if (j11 != 0) {
                    long j12 = j11 + j10;
                    if (atomicLong.compareAndSet(j11, j12)) {
                        return j12;
                    }
                }
            }
        } while (!this.map.replace(k10, atomicLong, new AtomicLong(j10)));
        return j10;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map2 = this.asMap;
        if (map2 != null) {
            return map2;
        }
        Map<K, Long> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public long decrementAndGet(K k10) {
        return addAndGet(k10, -1);
    }

    public long get(K k10) {
        AtomicLong atomicLong = this.map.get(k10);
        if (atomicLong == null) {
            return 0;
        }
        return atomicLong.get();
    }

    @CanIgnoreReturnValue
    public long getAndAdd(K k10, long j10) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k10);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k10, new AtomicLong(j10))) == null) {
                return 0;
            }
            while (true) {
                long j11 = atomicLong.get();
                if (j11 != 0) {
                    if (atomicLong.compareAndSet(j11, j11 + j10)) {
                        return j11;
                    }
                }
            }
        } while (!this.map.replace(k10, atomicLong, new AtomicLong(j10)));
        return 0;
    }

    @CanIgnoreReturnValue
    public long getAndDecrement(K k10) {
        return getAndAdd(k10, -1);
    }

    @CanIgnoreReturnValue
    public long getAndIncrement(K k10) {
        return getAndAdd(k10, 1);
    }

    @CanIgnoreReturnValue
    public long incrementAndGet(K k10) {
        return addAndGet(k10, 1);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @CanIgnoreReturnValue
    public long put(K k10, long j10) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k10);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k10, new AtomicLong(j10))) == null) {
                return 0;
            }
            while (true) {
                long j11 = atomicLong.get();
                if (j11 != 0) {
                    if (atomicLong.compareAndSet(j11, j10)) {
                        return j11;
                    }
                }
            }
        } while (!this.map.replace(k10, atomicLong, new AtomicLong(j10)));
        return 0;
    }

    public void putAll(Map<? extends K, ? extends Long> map2) {
        for (Map.Entry next : map2.entrySet()) {
            put(next.getKey(), ((Long) next.getValue()).longValue());
        }
    }

    public long putIfAbsent(K k10, long j10) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k10);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k10, new AtomicLong(j10))) == null) {
                return 0;
            }
            long j11 = atomicLong.get();
            if (j11 != 0) {
                return j11;
            }
        } while (!this.map.replace(k10, atomicLong, new AtomicLong(j10)));
        return 0;
    }

    @CanIgnoreReturnValue
    public long remove(K k10) {
        long j10;
        AtomicLong atomicLong = this.map.get(k10);
        if (atomicLong == null) {
            return 0;
        }
        do {
            j10 = atomicLong.get();
            if (j10 == 0 || atomicLong.compareAndSet(j10, 0)) {
                this.map.remove(k10, atomicLong);
            }
            j10 = atomicLong.get();
            break;
        } while (atomicLong.compareAndSet(j10, 0));
        this.map.remove(k10, atomicLong);
        return j10;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            AtomicLong atomicLong = (AtomicLong) it.next().getValue();
            if (atomicLong != null && atomicLong.get() == 0) {
                it.remove();
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public boolean removeIfZero(K k10) {
        return remove(k10, 0);
    }

    public boolean replace(K k10, long j10, long j11) {
        if (j10 != 0) {
            AtomicLong atomicLong = this.map.get(k10);
            if (atomicLong == null) {
                return false;
            }
            return atomicLong.compareAndSet(j10, j11);
        } else if (putIfAbsent(k10, j11) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        long j10 = 0;
        for (AtomicLong atomicLong : this.map.values()) {
            j10 += atomicLong.get();
        }
        return j10;
    }

    public String toString() {
        return this.map.toString();
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map2) {
        AtomicLongMap<K> create = create();
        create.putAll(map2);
        return create;
    }

    public boolean remove(K k10, long j10) {
        AtomicLong atomicLong = this.map.get(k10);
        if (atomicLong == null) {
            return false;
        }
        long j11 = atomicLong.get();
        if (j11 != j10) {
            return false;
        }
        if (j11 != 0 && !atomicLong.compareAndSet(j11, 0)) {
            return false;
        }
        this.map.remove(k10, atomicLong);
        return true;
    }
}
