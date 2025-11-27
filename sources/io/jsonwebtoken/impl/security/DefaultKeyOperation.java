package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.KeyOperation;
import java.util.Set;

final class DefaultKeyOperation implements KeyOperation {
    private static final String CUSTOM_DESCRIPTION = "Custom key operation";
    static final KeyOperation DECRYPT = of("decrypt", "Decrypt content and validate decryption, if applicable", "encrypt");
    static final KeyOperation DERIVE_BITS = of("deriveBits", "Derive bits not to be used as a key", (String) null);
    static final KeyOperation DERIVE_KEY = of("deriveKey", "Derive key", (String) null);
    static final KeyOperation ENCRYPT = of("encrypt", "Encrypt content", "decrypt");
    static final KeyOperation SIGN = of("sign", "Compute digital signature or MAC", "verify");
    static final KeyOperation UNWRAP = of("unwrapKey", "Decrypt key and validate decryption, if applicable", "wrapKey");
    static final KeyOperation VERIFY = of("verify", "Verify digital signature or MAC", "sign");
    static final KeyOperation WRAP = of("wrapKey", "Encrypt key", "unwrapKey");
    final String description;
    final String id;
    final Set<String> related;

    public DefaultKeyOperation(String str) {
        this(str, (String) null, (Set<String>) null);
    }

    public static KeyOperation of(String str, String str2, String str3) {
        return new DefaultKeyOperation(str, str2, Collections.setOf(str3));
    }

    public boolean equals(Object obj) {
        if (obj == this || ((obj instanceof KeyOperation) && this.id.equals(((KeyOperation) obj).getId()))) {
            return true;
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean isRelated(KeyOperation keyOperation) {
        if (equals(keyOperation) || (keyOperation != null && this.related.contains(keyOperation.getId()))) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "'" + this.id + "' (" + this.description + ")";
    }

    public DefaultKeyOperation(String str, String str2, Set<String> set) {
        this.id = (String) Assert.hasText(str, "id cannot be null or empty.");
        this.description = !Strings.hasText(str2) ? CUSTOM_DESCRIPTION : str2;
        this.related = set != null ? Collections.immutable(set) : Collections.emptySet();
    }
}
