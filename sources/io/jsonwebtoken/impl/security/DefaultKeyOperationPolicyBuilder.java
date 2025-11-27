package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.DefaultCollectionMutator;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperation;
import io.jsonwebtoken.security.KeyOperationPolicy;
import io.jsonwebtoken.security.KeyOperationPolicyBuilder;
import java.util.Collection;

public class DefaultKeyOperationPolicyBuilder extends DefaultCollectionMutator<KeyOperation, KeyOperationPolicyBuilder> implements KeyOperationPolicyBuilder {
    private boolean unrelated = false;

    public DefaultKeyOperationPolicyBuilder() {
        super(Jwks.OP.get().values());
    }

    public /* bridge */ /* synthetic */ KeyOperationPolicyBuilder add(KeyOperation keyOperation) {
        return (KeyOperationPolicyBuilder) super.add(keyOperation);
    }

    public KeyOperationPolicyBuilder unrelated() {
        this.unrelated = true;
        return this;
    }

    public /* bridge */ /* synthetic */ KeyOperationPolicyBuilder add(Collection collection) {
        return (KeyOperationPolicyBuilder) super.add(collection);
    }

    public KeyOperationPolicy build() {
        return new DefaultKeyOperationPolicy(Collections.immutable(getCollection()), this.unrelated);
    }
}
