package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.VerifyDigestRequest;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Locale;

public final class DefaultHashAlgorithm extends CryptoAlgorithm implements HashAlgorithm {
    public static final HashAlgorithm SHA1 = new DefaultHashAlgorithm("sha-1");

    public DefaultHashAlgorithm(String str) {
        super(str, str.toUpperCase(Locale.ENGLISH));
    }

    public byte[] digest(Request<InputStream> request) {
        Assert.notNull(request, "Request cannot be null.");
        final InputStream inputStream = (InputStream) Assert.notNull(request.getPayload(), "Request payload cannot be null.");
        return (byte[]) jca(request).withMessageDigest(new CheckedFunction<MessageDigest, byte[]>() {
            public byte[] apply(MessageDigest messageDigest) {
                byte[] bArr = new byte[1024];
                int i10 = 0;
                while (i10 != -1) {
                    i10 = inputStream.read(bArr);
                    if (i10 > 0) {
                        messageDigest.update(bArr, 0, i10);
                    }
                }
                return messageDigest.digest();
            }
        });
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public boolean verify(VerifyDigestRequest verifyDigestRequest) {
        Assert.notNull(verifyDigestRequest, "VerifyDigestRequest cannot be null.");
        return MessageDigest.isEqual(digest(verifyDigestRequest), (byte[]) Assert.notNull(verifyDigestRequest.getDigest(), "Digest cannot be null."));
    }
}
