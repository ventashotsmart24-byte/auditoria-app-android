package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.AbstractX509Context;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperation;
import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DefaultJwkContext<K extends Key> extends AbstractX509Context<JwkContext<K>> implements JwkContext<K> {
    private static final Set<Parameter<?>> DEFAULT_PARAMS;
    private HashAlgorithm idThumbprintAlgorithm;
    private K key;
    private Provider provider;
    private PublicKey publicKey;
    private SecureRandom random;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(DefaultSecretJwk.PARAMS);
        linkedHashSet.addAll(DefaultEcPrivateJwk.PARAMS);
        linkedHashSet.addAll(DefaultRsaPrivateJwk.PARAMS);
        linkedHashSet.addAll(DefaultOctetPrivateJwk.PARAMS);
        Parameter<BigInteger> parameter = DefaultEcPublicJwk.X;
        linkedHashSet.remove(parameter);
        Parameter<BigInteger> parameter2 = DefaultEcPrivateJwk.D;
        linkedHashSet.remove(parameter2);
        linkedHashSet.add(Parameters.string(parameter.getId(), "Elliptic Curve public key X coordinate"));
        linkedHashSet.add(Parameters.builder(String.class).setSecret(true).setId(parameter2.getId()).setName("Elliptic Curve private key").build());
        DEFAULT_PARAMS = Collections.immutable(linkedHashSet);
    }

    public DefaultJwkContext() {
        this(DEFAULT_PARAMS);
    }

    public String getAlgorithm() {
        return (String) get(AbstractJwk.ALG);
    }

    public String getId() {
        return (String) get(AbstractJwk.KID);
    }

    public HashAlgorithm getIdThumbprintAlgorithm() {
        return this.idThumbprintAlgorithm;
    }

    public K getKey() {
        return this.key;
    }

    public String getName() {
        StringBuilder sb;
        String str = (String) get(AbstractJwk.KTY);
        if ("oct".equals(str)) {
            str = "Secret";
        } else if ("OKP".equals(str)) {
            str = "Octet";
        }
        if (str == null) {
            sb = new StringBuilder();
        }
        Key key2 = getKey();
        if (key2 instanceof PublicKey) {
            Strings.nespace(sb).append("Public");
        } else if (key2 instanceof PrivateKey) {
            Strings.nespace(sb).append("Private");
        }
        Strings.nespace(sb).append("JWK");
        return sb.toString();
    }

    public Set<KeyOperation> getOperations() {
        return (Set) get(AbstractJwk.KEY_OPS);
    }

    public Provider getProvider() {
        return this.provider;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public String getPublicKeyUse() {
        return (String) get(AbstractAsymmetricJwk.USE);
    }

    public SecureRandom getRandom() {
        return this.random;
    }

    public String getType() {
        return (String) get(AbstractJwk.KTY);
    }

    public boolean isSigUse() {
        if ("sig".equals(getPublicKeyUse())) {
            return true;
        }
        Set<KeyOperation> operations = getOperations();
        if (Collections.isEmpty((Collection<?>) operations)) {
            return false;
        }
        if (operations.contains(Jwks.OP.SIGN) || operations.contains(Jwks.OP.VERIFY)) {
            return true;
        }
        return false;
    }

    public JwkContext<K> parameter(Parameter<?> parameter) {
        DefaultJwkContext defaultJwkContext;
        LinkedHashSet linkedHashSet = new LinkedHashSet(Parameters.replace(this.PARAMS, parameter).values());
        K k10 = this.key;
        if (k10 == null) {
            defaultJwkContext = new DefaultJwkContext((Set<Parameter<?>>) linkedHashSet, (JwkContext<?>) this, false);
        }
        return defaultJwkContext;
    }

    public void putAll(Map<? extends String, ?> map) {
        Assert.notEmpty(map, "JWK values cannot be null or empty.");
        super.putAll(map);
    }

    public JwkContext<K> setAlgorithm(String str) {
        put(AbstractJwk.ALG, (Object) str);
        return this;
    }

    public JwkContext<K> setId(String str) {
        put(AbstractJwk.KID, (Object) str);
        return this;
    }

    public JwkContext<K> setIdThumbprintAlgorithm(HashAlgorithm hashAlgorithm) {
        this.idThumbprintAlgorithm = hashAlgorithm;
        return this;
    }

    public JwkContext<K> setKey(K k10) {
        this.key = k10;
        return this;
    }

    public JwkContext<K> setOperations(Collection<? extends KeyOperation> collection) {
        put(AbstractJwk.KEY_OPS, (Object) collection);
        return this;
    }

    public JwkContext<K> setProvider(Provider provider2) {
        this.provider = provider2;
        return this;
    }

    public JwkContext<K> setPublicKey(PublicKey publicKey2) {
        this.publicKey = publicKey2;
        return this;
    }

    public JwkContext<K> setPublicKeyUse(String str) {
        put(AbstractAsymmetricJwk.USE, (Object) str);
        return this;
    }

    public JwkContext<K> setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public JwkContext<K> setType(String str) {
        put(AbstractJwk.KTY, (Object) str);
        return this;
    }

    public DefaultJwkContext(Set<Parameter<?>> set) {
        super(set);
    }

    public DefaultJwkContext(Set<Parameter<?>> set, JwkContext<?> jwkContext) {
        this(set, jwkContext, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultJwkContext(Set<Parameter<?>> set, JwkContext<?> jwkContext, K k10) {
        this(set, jwkContext, k10 == null || (k10 instanceof PublicKey));
        this.key = (Key) Assert.notNull(k10, "Key cannot be null.");
    }

    public DefaultJwkContext(Set<Parameter<?>> set, JwkContext<?> jwkContext, boolean z10) {
        super((Set) Assert.notEmpty(set, "Parameters cannot be null or empty."));
        Assert.notNull(jwkContext, "JwkContext cannot be null.");
        Assert.isInstanceOf(DefaultJwkContext.class, jwkContext, "JwkContext must be a DefaultJwkContext instance.");
        DefaultJwkContext defaultJwkContext = (DefaultJwkContext) jwkContext;
        this.provider = jwkContext.getProvider();
        this.random = jwkContext.getRandom();
        this.idThumbprintAlgorithm = jwkContext.getIdThumbprintAlgorithm();
        this.values.putAll(defaultJwkContext.values);
        for (Map.Entry next : defaultJwkContext.idiomaticValues.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            Parameter parameter = (Parameter) this.PARAMS.get(str);
            if (parameter == null || parameter.supports(value)) {
                this.idiomaticValues.put(str, value);
            } else {
                put(parameter, this.values.get(parameter.getId()));
            }
        }
        if (z10) {
            for (Parameter parameter2 : defaultJwkContext.PARAMS.values()) {
                if (parameter2.isSecret()) {
                    remove(parameter2.getId());
                }
            }
        }
    }
}
