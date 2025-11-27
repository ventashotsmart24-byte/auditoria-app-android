package io.jsonwebtoken.security;

import io.jsonwebtoken.lang.Builder;
import io.jsonwebtoken.lang.CollectionMutator;
import java.util.Collection;

public interface KeyOperationPolicyBuilder extends CollectionMutator<KeyOperation, KeyOperationPolicyBuilder>, Builder<KeyOperationPolicy> {
    KeyOperationPolicyBuilder add(KeyOperation keyOperation);

    KeyOperationPolicyBuilder add(Collection<? extends KeyOperation> collection);

    KeyOperationPolicyBuilder unrelated();
}
