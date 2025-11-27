package io.jsonwebtoken.security;

import java.util.Collection;

public interface KeyOperationPolicy {
    Collection<KeyOperation> getOperations();

    void validate(Collection<? extends KeyOperation> collection);
}
