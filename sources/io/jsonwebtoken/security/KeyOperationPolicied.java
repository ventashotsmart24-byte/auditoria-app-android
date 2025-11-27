package io.jsonwebtoken.security;

import io.jsonwebtoken.security.KeyOperationPolicied;

public interface KeyOperationPolicied<T extends KeyOperationPolicied<T>> {
    T operationPolicy(KeyOperationPolicy keyOperationPolicy);
}
