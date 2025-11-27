package com.google.common.hash;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    public static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        public BytesHashCode(byte[] bArr) {
            this.bytes = (byte[]) Preconditions.checkNotNull(bArr);
        }

        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        public int asInt() {
            boolean z10;
            byte[] bArr = this.bytes;
            if (bArr.length >= 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.bytes;
            return ((bArr2[3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr2[0] & UnsignedBytes.MAX_VALUE) | ((bArr2[1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr2[2] & UnsignedBytes.MAX_VALUE) << 16);
        }

        public long asLong() {
            boolean z10;
            byte[] bArr = this.bytes;
            if (bArr.length >= 8) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return padToLong();
        }

        public int bits() {
            return this.bytes.length * 8;
        }

        public boolean equalsSameBits(HashCode hashCode) {
            boolean z10;
            if (this.bytes.length != hashCode.getBytesInternal().length) {
                return false;
            }
            int i10 = 0;
            boolean z11 = true;
            while (true) {
                byte[] bArr = this.bytes;
                if (i10 >= bArr.length) {
                    return z11;
                }
                if (bArr[i10] == hashCode.getBytesInternal()[i10]) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 &= z10;
                i10++;
            }
        }

        public byte[] getBytesInternal() {
            return this.bytes;
        }

        public long padToLong() {
            long j10 = (long) (this.bytes[0] & UnsignedBytes.MAX_VALUE);
            for (int i10 = 1; i10 < Math.min(this.bytes.length, 8); i10++) {
                j10 |= (((long) this.bytes[i10]) & 255) << (i10 * 8);
            }
            return j10;
        }

        public void writeBytesToImpl(byte[] bArr, int i10, int i11) {
            System.arraycopy(this.bytes, 0, bArr, i10, i11);
        }
    }

    public static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final int hash;

        public IntHashCode(int i10) {
            this.hash = i10;
        }

        public byte[] asBytes() {
            int i10 = this.hash;
            return new byte[]{(byte) i10, (byte) (i10 >> 8), (byte) (i10 >> 16), (byte) (i10 >> 24)};
        }

        public int asInt() {
            return this.hash;
        }

        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        public int bits() {
            return 32;
        }

        public boolean equalsSameBits(HashCode hashCode) {
            if (this.hash == hashCode.asInt()) {
                return true;
            }
            return false;
        }

        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }

        public void writeBytesToImpl(byte[] bArr, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                bArr[i10 + i12] = (byte) (this.hash >> (i12 * 8));
            }
        }
    }

    public static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final long hash;

        public LongHashCode(long j10) {
            this.hash = j10;
        }

        public byte[] asBytes() {
            long j10 = this.hash;
            return new byte[]{(byte) ((int) j10), (byte) ((int) (j10 >> 8)), (byte) ((int) (j10 >> 16)), (byte) ((int) (j10 >> 24)), (byte) ((int) (j10 >> 32)), (byte) ((int) (j10 >> 40)), (byte) ((int) (j10 >> 48)), (byte) ((int) (j10 >> 56))};
        }

        public int asInt() {
            return (int) this.hash;
        }

        public long asLong() {
            return this.hash;
        }

        public int bits() {
            return 64;
        }

        public boolean equalsSameBits(HashCode hashCode) {
            if (this.hash == hashCode.asLong()) {
                return true;
            }
            return false;
        }

        public long padToLong() {
            return this.hash;
        }

        public void writeBytesToImpl(byte[] bArr, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                bArr[i10 + i12] = (byte) ((int) (this.hash >> (i12 * 8)));
            }
        }
    }

    private static int decode(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        if (c10 >= 'a' && c10 <= 'f') {
            return (c10 - 'a') + 10;
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Illegal hexadecimal character: ");
        sb.append(c10);
        throw new IllegalArgumentException(sb.toString());
    }

    public static HashCode fromBytes(byte[] bArr) {
        boolean z10 = true;
        if (bArr.length < 1) {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) bArr.clone());
    }

    public static HashCode fromBytesNoCopy(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode fromInt(int i10) {
        return new IntHashCode(i10);
    }

    public static HashCode fromLong(long j10) {
        return new LongHashCode(j10);
    }

    public static HashCode fromString(String str) {
        boolean z10;
        boolean z11 = true;
        if (str.length() >= 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "input string (%s) must have at least 2 characters", (Object) str);
        if (str.length() % 2 != 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "input string (%s) must have an even number of characters", (Object) str);
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i10 = 0; i10 < str.length(); i10 += 2) {
            bArr[i10 / 2] = (byte) ((decode(str.charAt(i10)) << 4) + decode(str.charAt(i10 + 1)));
        }
        return fromBytesNoCopy(bArr);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        if (bits() != hashCode.bits() || !equalsSameBits(hashCode)) {
            return false;
        }
        return true;
    }

    public abstract boolean equalsSameBits(HashCode hashCode);

    public byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] bytesInternal = getBytesInternal();
        byte b10 = bytesInternal[0] & UnsignedBytes.MAX_VALUE;
        for (int i10 = 1; i10 < bytesInternal.length; i10++) {
            b10 |= (bytesInternal[i10] & UnsignedBytes.MAX_VALUE) << (i10 * 8);
        }
        return b10;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] bytesInternal = getBytesInternal();
        StringBuilder sb = new StringBuilder(bytesInternal.length * 2);
        for (byte b10 : bytesInternal) {
            char[] cArr = hexDigits;
            sb.append(cArr[(b10 >> 4) & 15]);
            sb.append(cArr[b10 & 15]);
        }
        return sb.toString();
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] bArr, int i10, int i11) {
        int min = Ints.min(i11, bits() / 8);
        Preconditions.checkPositionIndexes(i10, i10 + min, bArr.length);
        writeBytesToImpl(bArr, i10, min);
        return min;
    }

    public abstract void writeBytesToImpl(byte[] bArr, int i10, int i11);
}
