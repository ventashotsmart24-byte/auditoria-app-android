package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.JwkThumbprint;
import java.net.URI;
import java.security.MessageDigest;

class DefaultJwkThumbprint implements JwkThumbprint {
    private static final String URI_PREFIX = "urn:ietf:params:oauth:jwk-thumbprint:";
    private final HashAlgorithm alg;
    private final byte[] digest;
    private final int hashcode;
    private final String sval;
    private final URI uri;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultJwkThumbprint(byte[] r7, io.jsonwebtoken.security.HashAlgorithm r8) {
        /*
            r6 = this;
            r6.<init>()
            java.lang.String r0 = "Thumbprint digest byte array cannot be null or empty."
            byte[] r0 = io.jsonwebtoken.lang.Assert.notEmpty((byte[]) r7, (java.lang.String) r0)
            r6.digest = r0
            java.lang.String r1 = "Thumbprint HashAlgorithm cannot be null."
            java.lang.Object r1 = io.jsonwebtoken.lang.Assert.notNull(r8, r1)
            io.jsonwebtoken.security.HashAlgorithm r1 = (io.jsonwebtoken.security.HashAlgorithm) r1
            r6.alg = r1
            java.lang.String r8 = r8.getId()
            java.lang.String r8 = io.jsonwebtoken.lang.Strings.clean((java.lang.String) r8)
            java.lang.String r2 = "Thumbprint HashAlgorithm id cannot be null or empty."
            java.lang.CharSequence r8 = io.jsonwebtoken.lang.Assert.hasText(r8, r2)
            java.lang.String r8 = (java.lang.String) r8
            io.jsonwebtoken.io.Encoder<byte[], java.lang.String> r2 = io.jsonwebtoken.io.Encoders.BASE64URL
            java.lang.Object r3 = r2.encode(r7)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "urn:ietf:params:oauth:jwk-thumbprint:"
            r4.append(r5)
            r4.append(r8)
            java.lang.String r8 = ":"
            r4.append(r8)
            r4.append(r3)
            java.lang.String r8 = r4.toString()
            java.net.URI r8 = java.net.URI.create(r8)
            r6.uri = r8
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r3 = 0
            r8[r3] = r0
            r0 = 1
            r8[r0] = r1
            int r8 = io.jsonwebtoken.lang.Objects.nullSafeHashCode((java.lang.Object[]) r8)
            r6.hashcode = r8
            java.lang.Object r7 = r2.encode(r7)
            java.lang.String r7 = (java.lang.String) r7
            r6.sval = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.DefaultJwkThumbprint.<init>(byte[], io.jsonwebtoken.security.HashAlgorithm):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultJwkThumbprint)) {
            return false;
        }
        DefaultJwkThumbprint defaultJwkThumbprint = (DefaultJwkThumbprint) obj;
        if (!this.alg.equals(defaultJwkThumbprint.alg) || !MessageDigest.isEqual(this.digest, defaultJwkThumbprint.digest)) {
            return false;
        }
        return true;
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.alg;
    }

    public int hashCode() {
        return this.hashcode;
    }

    public byte[] toByteArray() {
        return (byte[]) this.digest.clone();
    }

    public String toString() {
        return this.sval;
    }

    public URI toURI() {
        return this.uri;
    }
}
