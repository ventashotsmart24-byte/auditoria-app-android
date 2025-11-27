package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.lang.Strings;
import java.io.InputStream;

@Deprecated
public class DelegateStringDecoder implements Decoder<InputStream, InputStream> {
    private final Decoder<CharSequence, byte[]> delegate;

    /* JADX WARNING: type inference failed for: r2v0, types: [io.jsonwebtoken.io.Decoder<java.lang.CharSequence, byte[]>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DelegateStringDecoder(io.jsonwebtoken.io.Decoder<java.lang.CharSequence, byte[]> r2) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "delegate cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            io.jsonwebtoken.io.Decoder r2 = (io.jsonwebtoken.io.Decoder) r2
            r1.delegate = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.io.DelegateStringDecoder.<init>(io.jsonwebtoken.io.Decoder):void");
    }

    public InputStream decode(InputStream inputStream) {
        try {
            return Streams.of(this.delegate.decode(Strings.utf8(Streams.bytes(inputStream, "Unable to Base64URL-decode input."))));
        } catch (Throwable th) {
            throw new DecodingException("Unable to Base64Url-decode InputStream: " + th.getMessage(), th);
        }
    }
}
