package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;

public class Codec implements Converter<byte[], CharSequence> {
    public static final Codec BASE64 = new Codec(Encoders.BASE64, Decoders.BASE64);
    public static final Codec BASE64URL = new Codec(Encoders.BASE64URL, Decoders.BASE64URL);
    private final Decoder<CharSequence, byte[]> decoder;
    private final Encoder<byte[], String> encoder;

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, io.jsonwebtoken.io.Encoder<byte[], java.lang.String>] */
    /* JADX WARNING: type inference failed for: r3v0, types: [io.jsonwebtoken.io.Decoder<java.lang.CharSequence, byte[]>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Codec(io.jsonwebtoken.io.Encoder<byte[], java.lang.String> r2, io.jsonwebtoken.io.Decoder<java.lang.CharSequence, byte[]> r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Encoder cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            io.jsonwebtoken.io.Encoder r2 = (io.jsonwebtoken.io.Encoder) r2
            r1.encoder = r2
            java.lang.String r2 = "Decoder cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r3, r2)
            io.jsonwebtoken.io.Decoder r2 = (io.jsonwebtoken.io.Decoder) r2
            r1.decoder = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.io.Codec.<init>(io.jsonwebtoken.io.Encoder, io.jsonwebtoken.io.Decoder):void");
    }

    public byte[] applyFrom(CharSequence charSequence) {
        try {
            return this.decoder.decode(charSequence);
        } catch (DecodingException e10) {
            throw new IllegalArgumentException("Cannot decode input String. Cause: " + e10.getMessage(), e10);
        }
    }

    public String applyTo(byte[] bArr) {
        return this.encoder.encode(bArr);
    }
}
