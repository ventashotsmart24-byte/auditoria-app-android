package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.Codec;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Converters;
import java.math.BigInteger;

final class FieldElementConverter implements Converter<BigInteger, byte[]> {
    static final Converter<BigInteger, Object> B64URL_CONVERTER;
    static final FieldElementConverter INSTANCE;
    private static final int P256_BYTE_LEN = bytelen(ECCurve.P256);
    private static final int P384_BYTE_LEN = bytelen(ECCurve.P384);
    private static final int P521_BYTE_LEN = bytelen(ECCurve.P521);

    static {
        FieldElementConverter fieldElementConverter = new FieldElementConverter();
        INSTANCE = fieldElementConverter;
        B64URL_CONVERTER = Converters.forEncoded(BigInteger.class, Converters.compound(fieldElementConverter, Codec.BASE64URL));
    }

    private static int bytelen(ECCurve eCCurve) {
        return Bytes.length(eCCurve.toParameterSpec().getCurve().getField().getFieldSize());
    }

    public BigInteger applyFrom(byte[] bArr) {
        return Converters.BIGINT_UBYTES.applyFrom(bArr);
    }

    public byte[] applyTo(BigInteger bigInteger) {
        int i10;
        int i11;
        byte[] applyTo = Converters.BIGINT_UBYTES.applyTo(bigInteger);
        int length = applyTo.length;
        int i12 = P256_BYTE_LEN;
        if (length == i12 || length == (i10 = P384_BYTE_LEN) || length == (i11 = P521_BYTE_LEN)) {
            return applyTo;
        }
        if (length < i12) {
            return Bytes.prepad(applyTo, i12);
        }
        if (length < i10) {
            return Bytes.prepad(applyTo, i10);
        }
        return Bytes.prepad(applyTo, i11);
    }
}
