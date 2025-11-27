package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.RedactedSupplier;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.security.Password;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class PasswordSpec implements Password, KeySpec {
    private static final String DESTROYED_MSG = "Password has been destroyed. Password character array may not be obtained.";
    private static final String ENCODED_DISABLED_MSG = "getEncoded() is disabled for Password instances as they are intended to be used with key derivation algorithms only. Because passwords rarely have the length or entropy necessary for secure cryptographic operations such as authenticated hashing or encryption, they are disabled as direct inputs for these operations to help avoid accidental misuse; if you see this exception message, it is likely that the associated Password instance is being used incorrectly.";
    private static final String NONE_ALGORITHM = "NONE";
    private volatile boolean destroyed;
    private final char[] password;

    public PasswordSpec(char[] cArr) {
        this.password = Assert.notEmpty(cArr, "Password character array cannot be null or empty.");
    }

    private void assertActive() {
        if (this.destroyed) {
            throw new IllegalStateException(DESTROYED_MSG);
        }
    }

    public void destroy() {
        this.destroyed = true;
        Arrays.fill(this.password, 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PasswordSpec) {
            return Objects.nullSafeEquals(this.password, ((PasswordSpec) obj).password);
        }
        return false;
    }

    public String getAlgorithm() {
        return NONE_ALGORITHM;
    }

    public byte[] getEncoded() {
        throw new UnsupportedOperationException(ENCODED_DISABLED_MSG);
    }

    public String getFormat() {
        return null;
    }

    public int hashCode() {
        return Objects.nullSafeHashCode(this.password);
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    public char[] toCharArray() {
        assertActive();
        return (char[]) this.password.clone();
    }

    public final String toString() {
        return RedactedSupplier.REDACTED_VALUE;
    }
}
