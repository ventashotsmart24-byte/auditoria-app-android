package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;

    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        public L getAt(int i10) {
            return this.array[i10];
        }

        public int size() {
            return this.array.length;
        }

        private CompactStriped(int i10, Supplier<L> supplier) {
            super(i10);
            int i11 = 0;
            Preconditions.checkArgument(i10 <= 1073741824, "Stripes must be <= 2^30)");
            this.array = new Object[(this.mask + 1)];
            while (true) {
                Object[] objArr = this.array;
                if (i11 < objArr.length) {
                    objArr[i11] = supplier.get();
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    @VisibleForTesting
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final int size;
        final Supplier<L> supplier;

        public LargeLazyStriped(int i10, Supplier<L> supplier2) {
            super(i10);
            int i11;
            int i12 = this.mask;
            if (i12 == -1) {
                i11 = Integer.MAX_VALUE;
            } else {
                i11 = i12 + 1;
            }
            this.size = i11;
            this.supplier = supplier2;
            this.locks = new MapMaker().weakValues().makeMap();
        }

        public L getAt(int i10) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i10, size());
            }
            L l10 = this.locks.get(Integer.valueOf(i10));
            if (l10 != null) {
                return l10;
            }
            L l11 = this.supplier.get();
            return MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(i10), l11), l11);
        }

        public int size() {
            return this.size;
        }
    }

    public static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public PaddedSemaphore(int i10) {
            super(i10, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        final int mask;

        public PowerOfTwoStriped(int i10) {
            super();
            boolean z10;
            int i11;
            if (i10 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "Stripes must be positive");
            if (i10 > 1073741824) {
                i11 = -1;
            } else {
                i11 = Striped.ceilToPowerOfTwo(i10) - 1;
            }
            this.mask = i11;
        }

        public final L get(Object obj) {
            return getAt(indexFor(obj));
        }

        public final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.mask;
        }
    }

    @VisibleForTesting
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final ReferenceQueue<L> queue = new ReferenceQueue<>();
        final int size;
        final Supplier<L> supplier;

        public static final class ArrayReference<L> extends WeakReference<L> {
            final int index;

            public ArrayReference(L l10, int i10, ReferenceQueue<L> referenceQueue) {
                super(l10, referenceQueue);
                this.index = i10;
            }
        }

        public SmallLazyStriped(int i10, Supplier<L> supplier2) {
            super(i10);
            int i11;
            int i12 = this.mask;
            if (i12 == -1) {
                i11 = Integer.MAX_VALUE;
            } else {
                i11 = i12 + 1;
            }
            this.size = i11;
            this.locks = new AtomicReferenceArray<>(i11);
            this.supplier = supplier2;
        }

        private void drainQueue() {
            while (true) {
                Reference<? extends L> poll = this.queue.poll();
                if (poll != null) {
                    ArrayReference arrayReference = (ArrayReference) poll;
                    r.a(this.locks, arrayReference.index, arrayReference, (Object) null);
                } else {
                    return;
                }
            }
        }

        public L getAt(int i10) {
            L l10;
            L l11;
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i10, size());
            }
            ArrayReference arrayReference = this.locks.get(i10);
            if (arrayReference == null) {
                l10 = null;
            } else {
                l10 = arrayReference.get();
            }
            if (l10 != null) {
                return l10;
            }
            L l12 = this.supplier.get();
            ArrayReference arrayReference2 = new ArrayReference(l12, i10, this.queue);
            while (!r.a(this.locks, i10, arrayReference, arrayReference2)) {
                arrayReference = this.locks.get(i10);
                if (arrayReference == null) {
                    l11 = null;
                    continue;
                } else {
                    l11 = arrayReference.get();
                    continue;
                }
                if (l11 != null) {
                    return l11;
                }
            }
            drainQueue();
            return l12;
        }

        public int size() {
            return this.size;
        }
    }

    public static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }

        public Condition delegate() {
            return this.delegate;
        }
    }

    public static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }

        public Lock delegate() {
            return this.delegate;
        }

        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }
    }

    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate = new ReentrantReadWriteLock();

        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }
    }

    private Striped() {
    }

    /* access modifiers changed from: private */
    public static int ceilToPowerOfTwo(int i10) {
        return 1 << IntMath.log2(i10, RoundingMode.CEILING);
    }

    public static <L> Striped<L> custom(int i10, Supplier<L> supplier) {
        return new CompactStriped(i10, supplier);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Lock lambda$lazyWeakLock$0() {
        return new ReentrantLock(false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$lazyWeakSemaphore$2(int i10) {
        return new Semaphore(i10, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$semaphore$1(int i10) {
        return new PaddedSemaphore(i10);
    }

    private static <L> Striped<L> lazy(int i10, Supplier<L> supplier) {
        if (i10 < 1024) {
            return new SmallLazyStriped(i10, supplier);
        }
        return new LargeLazyStriped(i10, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i10) {
        return lazy(i10, new p());
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i10) {
        return lazy(i10, new n());
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i10, int i11) {
        return lazy(i10, new m(i11));
    }

    public static Striped<Lock> lock(int i10) {
        return custom(i10, new q());
    }

    public static Striped<ReadWriteLock> readWriteLock(int i10) {
        return custom(i10, new o());
    }

    public static Striped<Semaphore> semaphore(int i10, int i11) {
        return custom(i10, new l(i11));
    }

    /* access modifiers changed from: private */
    public static int smear(int i10) {
        int i11 = i10 ^ ((i10 >>> 20) ^ (i10 >>> 12));
        return (i11 >>> 4) ^ ((i11 >>> 7) ^ i11);
    }

    public Iterable<L> bulkGet(Iterable<? extends Object> iterable) {
        ArrayList<E> newArrayList = Lists.newArrayList(iterable);
        if (newArrayList.isEmpty()) {
            return ImmutableList.of();
        }
        int[] iArr = new int[newArrayList.size()];
        for (int i10 = 0; i10 < newArrayList.size(); i10++) {
            iArr[i10] = indexFor(newArrayList.get(i10));
        }
        Arrays.sort(iArr);
        int i11 = iArr[0];
        newArrayList.set(0, getAt(i11));
        for (int i12 = 1; i12 < newArrayList.size(); i12++) {
            int i13 = iArr[i12];
            if (i13 == i11) {
                newArrayList.set(i12, newArrayList.get(i12 - 1));
            } else {
                newArrayList.set(i12, getAt(i13));
                i11 = i13;
            }
        }
        return Collections.unmodifiableList(newArrayList);
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i10);

    public abstract int indexFor(Object obj);

    public abstract int size();
}
