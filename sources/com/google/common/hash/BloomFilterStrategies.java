package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 {
        public <T> boolean mightContain(@ParametricNullness T t10, Funnel<? super T> funnel, int i10, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t10, funnel).asLong();
            int i11 = (int) asLong;
            int i12 = (int) (asLong >>> 32);
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 ^= -1;
                }
                if (!lockFreeBitArray.get(((long) i14) % bitSize)) {
                    return false;
                }
            }
            return true;
        }

        public <T> boolean put(@ParametricNullness T t10, Funnel<? super T> funnel, int i10, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t10, funnel).asLong();
            int i11 = (int) asLong;
            int i12 = (int) (asLong >>> 32);
            boolean z10 = false;
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 ^= -1;
                }
                z10 |= lockFreeBitArray.set(((long) i14) % bitSize);
            }
            return z10;
        }
    },
    MURMUR128_MITZ_64 {
        private long lowerEight(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        public <T> boolean mightContain(@ParametricNullness T t10, Funnel<? super T> funnel, int i10, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t10, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i11 = 0; i11 < i10; i11++) {
                if (!lockFreeBitArray.get((Long.MAX_VALUE & lowerEight) % bitSize)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        public <T> boolean put(@ParametricNullness T t10, Funnel<? super T> funnel, int i10, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t10, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z10 = false;
            for (int i11 = 0; i11 < i10; i11++) {
                z10 |= lockFreeBitArray.set((Long.MAX_VALUE & lowerEight) % bitSize);
                lowerEight += upperEight;
            }
            return z10;
        }
    };

    public static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        private final LongAddable bitCount;
        final AtomicLongArray data;

        public LockFreeBitArray(long j10) {
            Preconditions.checkArgument(j10 > 0, "data length is zero!");
            this.data = new AtomicLongArray(Ints.checkedCast(LongMath.divide(j10, 64, RoundingMode.CEILING)));
            this.bitCount = LongAddables.create();
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = atomicLongArray.get(i10);
            }
            return jArr;
        }

        public long bitCount() {
            return this.bitCount.sum();
        }

        public long bitSize() {
            return ((long) this.data.length()) * 64;
        }

        public LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        public int dataLength() {
            return this.data.length();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) obj).data));
            }
            return false;
        }

        public boolean get(long j10) {
            if (((1 << ((int) j10)) & this.data.get((int) (j10 >>> 6))) != 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }

        public void putAll(LockFreeBitArray lockFreeBitArray) {
            boolean z10;
            if (this.data.length() == lockFreeBitArray.data.length()) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "BitArrays must be of equal length (%s != %s)", this.data.length(), lockFreeBitArray.data.length());
            for (int i10 = 0; i10 < this.data.length(); i10++) {
                putData(i10, lockFreeBitArray.data.get(i10));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void putData(int r12, long r13) {
            /*
                r11 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicLongArray r0 = r11.data
                long r7 = r0.get(r12)
                long r9 = r7 | r13
                int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r0 != 0) goto L_0x000e
                r12 = 0
                goto L_0x001a
            L_0x000e:
                java.util.concurrent.atomic.AtomicLongArray r1 = r11.data
                r2 = r12
                r3 = r7
                r5 = r9
                boolean r0 = r1.compareAndSet(r2, r3, r5)
                if (r0 == 0) goto L_0x0000
                r12 = 1
            L_0x001a:
                if (r12 == 0) goto L_0x002b
                int r12 = java.lang.Long.bitCount(r9)
                int r13 = java.lang.Long.bitCount(r7)
                int r12 = r12 - r13
                com.google.common.hash.LongAddable r13 = r11.bitCount
                long r0 = (long) r12
                r13.add(r0)
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.BloomFilterStrategies.LockFreeBitArray.putData(int, long):void");
        }

        public boolean set(long j10) {
            long j11;
            long j12;
            if (get(j10)) {
                return false;
            }
            int i10 = (int) (j10 >>> 6);
            long j13 = 1 << ((int) j10);
            do {
                j11 = this.data.get(i10);
                j12 = j11 | j13;
                if (j11 == j12) {
                    return false;
                }
            } while (!this.data.compareAndSet(i10, j11, j12));
            this.bitCount.increment();
            return true;
        }

        public LockFreeBitArray(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.data = new AtomicLongArray(jArr);
            this.bitCount = LongAddables.create();
            long j10 = 0;
            for (long bitCount2 : jArr) {
                j10 += (long) Long.bitCount(bitCount2);
            }
            this.bitCount.add(j10);
        }
    }
}
