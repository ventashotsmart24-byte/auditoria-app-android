package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.security.KeyOperation;
import io.jsonwebtoken.security.KeyOperationPolicy;
import java.util.Collection;
import java.util.Iterator;

final class DefaultKeyOperationPolicy implements KeyOperationPolicy {
    private final boolean allowUnrelated;
    private final Collection<KeyOperation> ops;

    public DefaultKeyOperationPolicy(Collection<KeyOperation> collection, boolean z10) {
        Assert.notEmpty(collection, "KeyOperation collection cannot be null or empty.");
        this.ops = Collections.immutable(collection);
        this.allowUnrelated = z10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultKeyOperationPolicy)) {
            return false;
        }
        DefaultKeyOperationPolicy defaultKeyOperationPolicy = (DefaultKeyOperationPolicy) obj;
        if (this.allowUnrelated == defaultKeyOperationPolicy.allowUnrelated && Collections.size((Collection<?>) this.ops) == Collections.size((Collection<?>) defaultKeyOperationPolicy.ops) && this.ops.containsAll(defaultKeyOperationPolicy.ops)) {
            return true;
        }
        return false;
    }

    public Collection<KeyOperation> getOperations() {
        return this.ops;
    }

    public int hashCode() {
        return (Boolean.valueOf(this.allowUnrelated).hashCode() * 31) + Objects.nullSafeHashCode((Object[]) (KeyOperation[]) this.ops.toArray(new KeyOperation[0]));
    }

    public void validate(Collection<? extends KeyOperation> collection) {
        if (!this.allowUnrelated && !Collections.isEmpty((Collection<?>) collection)) {
            for (KeyOperation keyOperation : collection) {
                Iterator<? extends KeyOperation> it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        KeyOperation keyOperation2 = (KeyOperation) it.next();
                        if (!keyOperation.isRelated(keyOperation2)) {
                            throw new IllegalArgumentException("Unrelated key operations are not allowed. KeyOperation [" + keyOperation2 + "] is unrelated to [" + keyOperation + "].");
                        }
                    }
                }
            }
        }
    }
}
