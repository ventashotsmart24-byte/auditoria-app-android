package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class CacheBuilder<K, V> {
    static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = new Supplier<AbstractCache.StatsCounter>() {
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    };
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final CacheStats EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() {
        public void recordEviction() {
        }

        public void recordHits(int i10) {
        }

        public void recordLoadException(long j10) {
        }

        public void recordLoadSuccess(long j10) {
        }

        public void recordMisses(int i10) {
        }

        public CacheStats snapshot() {
            return CacheBuilder.EMPTY_STATS;
        }
    });
    static final Ticker NULL_TICKER = new Ticker() {
        public long read() {
            return 0;
        }
    };
    static final int UNSET_INT = -1;
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    int concurrencyLevel = -1;
    long expireAfterAccessNanos = -1;
    long expireAfterWriteNanos = -1;
    int initialCapacity = -1;
    Equivalence<Object> keyEquivalence;
    LocalCache.Strength keyStrength;
    long maximumSize = -1;
    long maximumWeight = -1;
    long refreshNanos = -1;
    RemovalListener<? super K, ? super V> removalListener;
    Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;
    boolean strictParsing = true;
    Ticker ticker;
    Equivalence<Object> valueEquivalence;
    LocalCache.Strength valueStrength;
    Weigher<? super K, ? super V> weigher;

    public enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    public enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    private void checkNonLoadingCache() {
        boolean z10;
        if (this.refreshNanos == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        boolean z10 = true;
        if (this.weigher == null) {
            if (this.maximumWeight != -1) {
                z10 = false;
            }
            Preconditions.checkState(z10, "maximumWeight requires weigher");
        } else if (this.strictParsing) {
            if (this.maximumWeight == -1) {
                z10 = false;
            }
            Preconditions.checkState(z10, "weigher requires maximumWeight");
        } else if (this.maximumWeight == -1) {
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    @GwtIncompatible
    @CheckReturnValue
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    @CheckReturnValue
    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public CacheBuilder<K, V> concurrencyLevel(int i10) {
        boolean z10;
        int i11 = this.concurrencyLevel;
        boolean z11 = true;
        if (i11 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "concurrency level was already set to %s", i11);
        if (i10 <= 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        this.concurrencyLevel = i10;
        return this;
    }

    public CacheBuilder<K, V> expireAfterAccess(long j10, TimeUnit timeUnit) {
        boolean z10;
        long j11 = this.expireAfterAccessNanos;
        boolean z11 = true;
        if (j11 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "expireAfterAccess was already set to %s ns", j11);
        if (j10 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "duration cannot be negative: %s %s", j10, (Object) timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j10);
        return this;
    }

    public CacheBuilder<K, V> expireAfterWrite(long j10, TimeUnit timeUnit) {
        boolean z10;
        long j11 = this.expireAfterWriteNanos;
        boolean z11 = true;
        if (j11 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "expireAfterWrite was already set to %s ns", j11);
        if (j10 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "duration cannot be negative: %s %s", j10, (Object) timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j10);
        return this;
    }

    public int getConcurrencyLevel() {
        int i10 = this.concurrencyLevel;
        if (i10 == -1) {
            return 4;
        }
        return i10;
    }

    public long getExpireAfterAccessNanos() {
        long j10 = this.expireAfterAccessNanos;
        if (j10 == -1) {
            return 0;
        }
        return j10;
    }

    public long getExpireAfterWriteNanos() {
        long j10 = this.expireAfterWriteNanos;
        if (j10 == -1) {
            return 0;
        }
        return j10;
    }

    public int getInitialCapacity() {
        int i10 = this.initialCapacity;
        if (i10 == -1) {
            return 16;
        }
        return i10;
    }

    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    public LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    public long getMaximumWeight() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0;
        }
        if (this.weigher == null) {
            return this.maximumSize;
        }
        return this.maximumWeight;
    }

    public long getRefreshNanos() {
        long j10 = this.refreshNanos;
        if (j10 == -1) {
            return 0;
        }
        return j10;
    }

    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public Ticker getTicker(boolean z10) {
        Ticker ticker2 = this.ticker;
        if (ticker2 != null) {
            return ticker2;
        }
        if (z10) {
            return Ticker.systemTicker();
        }
        return NULL_TICKER;
    }

    public Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> initialCapacity(int i10) {
        boolean z10;
        int i11 = this.initialCapacity;
        boolean z11 = true;
        if (i11 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "initial capacity was already set to %s", i11);
        if (i10 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        this.initialCapacity = i10;
        return this;
    }

    public boolean isRecordingStats() {
        if (this.statsCounterSupplier == CACHE_STATS_COUNTER) {
            return true;
        }
        return false;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> keyEquivalence(Equivalence<Object> equivalence) {
        boolean z10;
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        if (equivalence2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "key equivalence was already set to %s", (Object) equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    public CacheBuilder<K, V> maximumSize(long j10) {
        boolean z10;
        boolean z11;
        boolean z12;
        long j11 = this.maximumSize;
        boolean z13 = true;
        if (j11 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "maximum size was already set to %s", j11);
        long j12 = this.maximumWeight;
        if (j12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "maximum weight was already set to %s", j12);
        if (this.weigher == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkState(z12, "maximum size can not be combined with weigher");
        if (j10 < 0) {
            z13 = false;
        }
        Preconditions.checkArgument(z13, "maximum size must not be negative");
        this.maximumSize = j10;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> maximumWeight(long j10) {
        boolean z10;
        boolean z11;
        long j11 = this.maximumWeight;
        boolean z12 = true;
        if (j11 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "maximum weight was already set to %s", j11);
        long j12 = this.maximumSize;
        if (j12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "maximum size was already set to %s", j12);
        if (j10 < 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12, "maximum weight must not be negative");
        this.maximumWeight = j10;
        return this;
    }

    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> refreshAfterWrite(long j10, TimeUnit timeUnit) {
        boolean z10;
        Preconditions.checkNotNull(timeUnit);
        long j11 = this.refreshNanos;
        boolean z11 = true;
        if (j11 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "refresh was already set to %s ns", j11);
        if (j10 <= 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "duration must be positive: %s %s", j10, (Object) timeUnit);
        this.refreshNanos = timeUnit.toNanos(j10);
        return this;
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener2) {
        boolean z10;
        if (this.removalListener == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener2);
        return this;
    }

    public CacheBuilder<K, V> setKeyStrength(LocalCache.Strength strength) {
        boolean z10;
        LocalCache.Strength strength2 = this.keyStrength;
        if (strength2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Key strength was already set to %s", (Object) strength2);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    public CacheBuilder<K, V> setValueStrength(LocalCache.Strength strength) {
        boolean z10;
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Value strength was already set to %s", (Object) strength2);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    public CacheBuilder<K, V> ticker(Ticker ticker2) {
        boolean z10;
        if (this.ticker == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker2);
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper((Object) this);
        int i10 = this.initialCapacity;
        if (i10 != -1) {
            stringHelper.add("initialCapacity", i10);
        }
        int i11 = this.concurrencyLevel;
        if (i11 != -1) {
            stringHelper.add("concurrencyLevel", i11);
        }
        long j10 = this.maximumSize;
        if (j10 != -1) {
            stringHelper.add("maximumSize", j10);
        }
        long j11 = this.maximumWeight;
        if (j11 != -1) {
            stringHelper.add("maximumWeight", j11);
        }
        long j12 = this.expireAfterWriteNanos;
        if (j12 != -1) {
            StringBuilder sb = new StringBuilder(22);
            sb.append(j12);
            sb.append("ns");
            stringHelper.add("expireAfterWrite", (Object) sb.toString());
        }
        long j13 = this.expireAfterAccessNanos;
        if (j13 != -1) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append(j13);
            sb2.append("ns");
            stringHelper.add("expireAfterAccess", (Object) sb2.toString());
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", (Object) Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", (Object) Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue((Object) "keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            stringHelper.addValue((Object) "valueEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue((Object) "removalListener");
        }
        return stringHelper.toString();
    }

    @GwtIncompatible
    public CacheBuilder<K, V> valueEquivalence(Equivalence<Object> equivalence) {
        boolean z10;
        Equivalence<Object> equivalence2 = this.valueEquivalence;
        if (equivalence2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "value equivalence was already set to %s", (Object) equivalence2);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher2) {
        boolean z10;
        boolean z11 = true;
        if (this.weigher == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        if (this.strictParsing) {
            long j10 = this.maximumSize;
            if (j10 != -1) {
                z11 = false;
            }
            Preconditions.checkState(z11, "weigher can not be combined with maximum size", j10);
        }
        this.weigher = (Weigher) Preconditions.checkNotNull(weigher2);
        return this;
    }

    @GwtIncompatible
    @CheckReturnValue
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }
}
