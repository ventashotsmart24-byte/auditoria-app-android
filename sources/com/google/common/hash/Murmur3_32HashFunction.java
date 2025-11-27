package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED, true);
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0, false);
    static final HashFunction MURMUR3_32_FIXED = new Murmur3_32HashFunction(0, true);
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;

    @CanIgnoreReturnValue
    public static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;

        /* renamed from: h1  reason: collision with root package name */
        private int f10085h1;
        private boolean isDone = false;
        private int length = 0;
        private int shift;

        public Murmur3_32Hasher(int i10) {
            this.f10085h1 = i10;
        }

        private void update(int i10, long j10) {
            long j11 = this.buffer;
            int i11 = this.shift;
            long j12 = ((j10 & 4294967295L) << i11) | j11;
            this.buffer = j12;
            int i12 = i11 + (i10 * 8);
            this.shift = i12;
            this.length += i10;
            if (i12 >= 32) {
                this.f10085h1 = Murmur3_32HashFunction.mixH1(this.f10085h1, Murmur3_32HashFunction.mixK1((int) j12));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int access$000 = this.f10085h1 ^ Murmur3_32HashFunction.mixK1((int) this.buffer);
            this.f10085h1 = access$000;
            return Murmur3_32HashFunction.fmix(access$000, this.length);
        }

        public Hasher putByte(byte b10) {
            update(1, (long) (b10 & UnsignedBytes.MAX_VALUE));
            return this;
        }

        public Hasher putChar(char c10) {
            update(2, (long) c10);
            return this;
        }

        public Hasher putInt(int i10) {
            update(4, (long) i10);
            return this;
        }

        public Hasher putLong(long j10) {
            update(4, (long) ((int) j10));
            update(4, j10 >>> 32);
            return this;
        }

        public Hasher putString(CharSequence charSequence, Charset charset) {
            if (!Charsets.UTF_8.equals(charset)) {
                return super.putString(charSequence, charset);
            }
            int length2 = charSequence.length();
            int i10 = 0;
            while (true) {
                int i11 = i10 + 4;
                if (i11 > length2) {
                    break;
                }
                char charAt = charSequence.charAt(i10);
                char charAt2 = charSequence.charAt(i10 + 1);
                char charAt3 = charSequence.charAt(i10 + 2);
                char charAt4 = charSequence.charAt(i10 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                update(4, (long) ((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i10 = i11;
            }
            while (i10 < length2) {
                char charAt5 = charSequence.charAt(i10);
                if (charAt5 < 128) {
                    update(1, (long) charAt5);
                } else if (charAt5 < 2048) {
                    update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                } else if (charAt5 < 55296 || charAt5 > 57343) {
                    update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                } else {
                    int codePointAt = Character.codePointAt(charSequence, i10);
                    if (codePointAt == charAt5) {
                        putBytes(charSequence.subSequence(i10, length2).toString().getBytes(charset));
                        return this;
                    }
                    i10++;
                    update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                }
                i10++;
            }
            return this;
        }

        public Hasher putBytes(byte[] bArr, int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (true) {
                int i13 = i12 + 4;
                if (i13 > i11) {
                    break;
                }
                update(4, (long) Murmur3_32HashFunction.getIntLittleEndian(bArr, i12 + i10));
                i12 = i13;
            }
            while (i12 < i11) {
                putByte(bArr[i10 + i12]);
                i12++;
            }
            return this;
        }

        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }
    }

    public Murmur3_32HashFunction(int i10, boolean z10) {
        this.seed = i10;
        this.supplementaryPlaneFix = z10;
    }

    /* access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c10) {
        return ((long) (c10 >>> 12)) | 224 | ((long) ((((c10 >>> 6) & 63) | 128) << 8)) | ((long) (((c10 & '?') | 128) << 16));
    }

    /* access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c10) {
        return ((long) (c10 >>> 6)) | 192 | ((long) (((c10 & '?') | 128) << 8));
    }

    /* access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int i10) {
        return ((long) (i10 >>> 18)) | 240 | ((((long) ((i10 >>> 12) & 63)) | 128) << 8) | ((((long) ((i10 >>> 6) & 63)) | 128) << 16) | ((((long) (i10 & 63)) | 128) << 24);
    }

    /* access modifiers changed from: private */
    public static HashCode fmix(int i10, int i11) {
        int i12 = i10 ^ i11;
        int i13 = (i12 ^ (i12 >>> 16)) * -2048144789;
        int i14 = (i13 ^ (i13 >>> 13)) * -1028477387;
        return HashCode.fromInt(i14 ^ (i14 >>> 16));
    }

    /* access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] bArr, int i10) {
        return Ints.fromBytes(bArr[i10 + 3], bArr[i10 + 2], bArr[i10 + 1], bArr[i10]);
    }

    /* access modifiers changed from: private */
    public static int mixH1(int i10, int i11) {
        return (Integer.rotateLeft(i10 ^ i11, 13) * 5) - 430675100;
    }

    /* access modifiers changed from: private */
    public static int mixK1(int i10) {
        return Integer.rotateLeft(i10 * C1, 15) * C2;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction)) {
            return false;
        }
        Murmur3_32HashFunction murmur3_32HashFunction = (Murmur3_32HashFunction) obj;
        if (this.seed == murmur3_32HashFunction.seed && this.supplementaryPlaneFix == murmur3_32HashFunction.supplementaryPlaneFix) {
            return true;
        }
        return false;
    }

    public HashCode hashBytes(byte[] bArr, int i10, int i11) {
        Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
        int i12 = this.seed;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i14 + 4;
            if (i15 > i11) {
                break;
            }
            i12 = mixH1(i12, mixK1(getIntLittleEndian(bArr, i14 + i10)));
            i14 = i15;
        }
        int i16 = i14;
        int i17 = 0;
        while (i16 < i11) {
            i13 ^= UnsignedBytes.toInt(bArr[i10 + i16]) << i17;
            i16++;
            i17 += 8;
        }
        return fmix(mixK1(i13) ^ i12, i11);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    public HashCode hashInt(int i10) {
        return fmix(mixH1(this.seed, mixK1(i10)), 4);
    }

    public HashCode hashLong(long j10) {
        int i10 = (int) (j10 >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j10)), mixK1(i10)), 8);
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        int i10;
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i11 = this.seed;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i13 + 4;
            if (i15 > length) {
                break;
            }
            char charAt = charSequence.charAt(i13);
            char charAt2 = charSequence.charAt(i13 + 1);
            char charAt3 = charSequence.charAt(i13 + 2);
            char charAt4 = charSequence.charAt(i13 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i11 = mixH1(i11, mixK1((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i14 = i10 + 4;
            i13 = i15;
        }
        long j10 = 0;
        while (i13 < length) {
            char charAt5 = charSequence.charAt(i13);
            if (charAt5 < 128) {
                j10 |= ((long) charAt5) << i12;
                i12 += 8;
                i10++;
            } else if (charAt5 < 2048) {
                j10 |= charToTwoUtf8Bytes(charAt5) << i12;
                i12 += 16;
                i10 += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                j10 |= charToThreeUtf8Bytes(charAt5) << i12;
                i12 += 24;
                i10 += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i13);
                if (codePointAt == charAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i13++;
                j10 |= codePointToFourUtf8Bytes(codePointAt) << i12;
                if (this.supplementaryPlaneFix) {
                    i12 += 32;
                }
                i10 += 4;
            }
            if (i12 >= 32) {
                i11 = mixH1(i11, mixK1((int) j10));
                j10 >>>= 32;
                i12 -= 32;
            }
            i13++;
        }
        return fmix(mixK1((int) j10) ^ i11, i10);
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i10 = this.seed;
        for (int i11 = 1; i11 < charSequence.length(); i11 += 2) {
            i10 = mixH1(i10, mixK1(charSequence.charAt(i11 - 1) | (charSequence.charAt(i11) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i10 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i10, charSequence.length() * 2);
    }

    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        int i10 = this.seed;
        StringBuilder sb = new StringBuilder(31);
        sb.append("Hashing.murmur3_32(");
        sb.append(i10);
        sb.append(")");
        return sb.toString();
    }
}
