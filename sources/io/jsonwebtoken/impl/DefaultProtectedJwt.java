package io.jsonwebtoken.impl;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import io.jsonwebtoken.ProtectedHeader;
import io.jsonwebtoken.ProtectedJwt;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import java.security.MessageDigest;

abstract class DefaultProtectedJwt<H extends ProtectedHeader, P> extends DefaultJwt<H, P> implements ProtectedJwt<H, P> {
    protected final byte[] digest;
    private final String digestName;

    public DefaultProtectedJwt(H h10, P p10, byte[] bArr, String str) {
        super(h10, p10);
        this.digest = Assert.notEmpty(bArr, "Digest byte array cannot be null or empty.");
        this.digestName = (String) Assert.hasText(str, "digestName cannot be null or empty.");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultProtectedJwt)) {
            return false;
        }
        DefaultProtectedJwt defaultProtectedJwt = (DefaultProtectedJwt) obj;
        if (!super.equals(defaultProtectedJwt) || !MessageDigest.isEqual(this.digest, defaultProtectedJwt.digest)) {
            return false;
        }
        return true;
    }

    public byte[] getDigest() {
        return (byte[]) this.digest.clone();
    }

    public int hashCode() {
        return Objects.nullSafeHashCode(getHeader(), getPayload(), this.digest);
    }

    public StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        stringBuilder.append(this.digestName);
        stringBuilder.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
        stringBuilder.append(Encoders.BASE64URL.encode(this.digest));
        return stringBuilder;
    }
}
