package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.DefaultNestedCollection;
import io.jsonwebtoken.impl.lang.DelegatingMapMutator;
import io.jsonwebtoken.impl.lang.IdRegistry;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterBuilder;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkBuilder;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperation;
import io.jsonwebtoken.security.KeyOperationPolicied;
import io.jsonwebtoken.security.KeyOperationPolicy;
import io.jsonwebtoken.security.MalformedKeyException;
import io.jsonwebtoken.security.SecretJwk;
import io.jsonwebtoken.security.SecretJwkBuilder;
import io.jsonwebtoken.security.SecurityBuilder;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Set;
import javax.crypto.SecretKey;

abstract class AbstractJwkBuilder<K extends Key, J extends Jwk<K>, T extends JwkBuilder<K, J, T>> extends DelegatingMapMutator<String, Object, JwkContext<K>, T> implements JwkBuilder<K, J, T> {
    static final KeyOperationPolicy DEFAULT_OPERATION_POLICY = ((KeyOperationPolicy) Jwks.OP.policy().build());
    protected final JwkFactory<K, J> jwkFactory;
    protected KeyOperationPolicy opsPolicy;

    public static class DefaultSecretJwkBuilder extends AbstractJwkBuilder<SecretKey, SecretJwk, SecretJwkBuilder> implements SecretJwkBuilder {
        public DefaultSecretJwkBuilder(JwkContext<SecretKey> jwkContext) {
            super(jwkContext);
            DefaultMacAlgorithm findByKey = DefaultMacAlgorithm.findByKey((Key) Assert.notNull(jwkContext.getKey(), "SecretKey cannot be null."));
            if (findByKey != null) {
                algorithm(findByKey.getId());
            }
        }

        public /* bridge */ /* synthetic */ Object build() {
            return AbstractJwkBuilder.super.build();
        }

        public /* bridge */ /* synthetic */ KeyOperationPolicied operationPolicy(KeyOperationPolicy keyOperationPolicy) {
            return AbstractJwkBuilder.super.operationPolicy(keyOperationPolicy);
        }

        public /* bridge */ /* synthetic */ SecurityBuilder provider(Provider provider) {
            return AbstractJwkBuilder.super.provider(provider);
        }

        public /* bridge */ /* synthetic */ SecurityBuilder random(SecureRandom secureRandom) {
            return AbstractJwkBuilder.super.random(secureRandom);
        }
    }

    public AbstractJwkBuilder(JwkContext<K> jwkContext) {
        this(jwkContext, DispatchingJwkFactory.DEFAULT_INSTANCE);
    }

    public T algorithm(String str) {
        Assert.hasText(str, "Algorithm cannot be null or empty.");
        ((JwkContext) this.DELEGATE).setAlgorithm(str);
        return (JwkBuilder) self();
    }

    public T id(String str) {
        Assert.hasText(str, "Id cannot be null or empty.");
        ((JwkContext) this.DELEGATE).setIdThumbprintAlgorithm((HashAlgorithm) null);
        ((JwkContext) this.DELEGATE).setId(str);
        return (JwkBuilder) self();
    }

    public T idFromThumbprint() {
        return idFromThumbprint(Jwks.HASH.SHA256);
    }

    public <A extends Key> JwkContext<A> newContext(A a10) {
        return this.jwkFactory.newContext((JwkContext) this.DELEGATE, a10);
    }

    public NestedCollection<KeyOperation, T> operations() {
        return new DefaultNestedCollection<KeyOperation, T>((JwkBuilder) self(), ((JwkContext) this.DELEGATE).getOperations()) {
            public void changed() {
                Collection collection = getCollection();
                AbstractJwkBuilder.this.opsPolicy.validate(collection);
                ((JwkContext) AbstractJwkBuilder.this.DELEGATE).setOperations(collection);
            }
        };
    }

    public AbstractJwkBuilder(JwkContext<K> jwkContext, JwkFactory<K, J> jwkFactory2) {
        super(jwkContext);
        this.opsPolicy = DEFAULT_OPERATION_POLICY;
        this.jwkFactory = (JwkFactory) Assert.notNull(jwkFactory2, "JwkFactory cannot be null.");
    }

    public J build() {
        Assert.stateNotNull(this.DELEGATE, "JwkContext should always be non-null");
        if (((JwkContext) this.DELEGATE).getKey() != null || !isEmpty()) {
            try {
                this.opsPolicy.validate((Collection) ((JwkContext) this.DELEGATE).get(AbstractJwk.KEY_OPS));
                return this.jwkFactory.createJwk((JwkContext) this.DELEGATE);
            } catch (IllegalArgumentException e10) {
                throw new MalformedKeyException("Unable to create JWK: " + e10.getMessage(), e10);
            }
        } else {
            throw new IllegalStateException("A " + Key.class.getName() + " or one or more name/value pairs must be provided to create a JWK.");
        }
    }

    public T idFromThumbprint(HashAlgorithm hashAlgorithm) {
        Assert.notNull(hashAlgorithm, "Thumbprint HashAlgorithm cannot be null.");
        Assert.notNull(hashAlgorithm.getId(), "Thumbprint HashAlgorithm ID cannot be null.");
        ((JwkContext) this.DELEGATE).setId((String) null);
        ((JwkContext) this.DELEGATE).setIdThumbprintAlgorithm(hashAlgorithm);
        return (JwkBuilder) self();
    }

    public T operationPolicy(KeyOperationPolicy keyOperationPolicy) {
        Assert.notNull(keyOperationPolicy, "Policy cannot be null.");
        Collection<KeyOperation> operations = keyOperationPolicy.getOperations();
        Assert.notEmpty(operations, "Policy operations cannot be null or empty.");
        this.opsPolicy = keyOperationPolicy;
        ParameterBuilder<Set<KeyOperation>> parameterBuilder = Parameters.builder(KeyOperation.class).setConverter(new KeyOperationConverter(new IdRegistry("JSON Web Key Operation", operations))).set();
        Parameter<Set<KeyOperation>> parameter = AbstractJwk.KEY_OPS;
        setDelegate(((JwkContext) this.DELEGATE).parameter((Parameter) parameterBuilder.setId(parameter.getId()).setName(parameter.getName()).build()));
        return (JwkBuilder) self();
    }

    public T provider(Provider provider) {
        ((JwkContext) this.DELEGATE).setProvider(provider);
        return (JwkBuilder) self();
    }

    public T random(SecureRandom secureRandom) {
        ((JwkContext) this.DELEGATE).setRandom(secureRandom);
        return (JwkBuilder) self();
    }
}
