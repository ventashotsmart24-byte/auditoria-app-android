package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

public class RequiredBitLengthConverter implements Converter<byte[], Object> {
    private final int bitLength;
    private final Converter<byte[], Object> converter;
    private final boolean exact;

    public RequiredBitLengthConverter(Converter<byte[], Object> converter2, int i10) {
        this(converter2, i10, true);
    }

    private byte[] assertLength(byte[] bArr) {
        long bitLength2 = Bytes.bitLength(bArr);
        if (this.exact && bitLength2 != ((long) this.bitLength)) {
            throw new IllegalArgumentException("Byte array must be exactly " + Bytes.bitsMsg((long) this.bitLength) + ". Found " + Bytes.bitsMsg(bitLength2));
        } else if (bitLength2 >= ((long) this.bitLength)) {
            return bArr;
        } else {
            throw new IllegalArgumentException("Byte array must be at least " + Bytes.bitsMsg((long) this.bitLength) + ". Found " + Bytes.bitsMsg(bitLength2));
        }
    }

    public RequiredBitLengthConverter(Converter<byte[], Object> converter2, int i10, boolean z10) {
        this.converter = (Converter) Assert.notNull(converter2, "Converter cannot be null.");
        this.bitLength = ((Integer) Assert.gt(Integer.valueOf(i10), 0, "bitLength must be greater than 0")).intValue();
        this.exact = z10;
    }

    public byte[] applyFrom(Object obj) {
        return assertLength(this.converter.applyFrom(obj));
    }

    public Object applyTo(byte[] bArr) {
        assertLength(bArr);
        return this.converter.applyTo(bArr);
    }
}
