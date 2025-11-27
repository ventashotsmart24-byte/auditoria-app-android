package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.ParameterMap;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AsymmetricJwk;
import io.jsonwebtoken.security.AsymmetricJwkBuilder;
import io.jsonwebtoken.security.EcPrivateJwk;
import io.jsonwebtoken.security.EcPrivateJwkBuilder;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.EcPublicJwkBuilder;
import io.jsonwebtoken.security.MalformedKeyException;
import io.jsonwebtoken.security.OctetPrivateJwk;
import io.jsonwebtoken.security.OctetPrivateJwkBuilder;
import io.jsonwebtoken.security.OctetPublicJwk;
import io.jsonwebtoken.security.OctetPublicJwkBuilder;
import io.jsonwebtoken.security.PrivateJwk;
import io.jsonwebtoken.security.PrivateJwkBuilder;
import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.PublicJwkBuilder;
import io.jsonwebtoken.security.RsaPrivateJwk;
import io.jsonwebtoken.security.RsaPrivateJwkBuilder;
import io.jsonwebtoken.security.RsaPublicJwk;
import io.jsonwebtoken.security.RsaPublicJwkBuilder;
import io.jsonwebtoken.security.X509Builder;
import io.jsonwebtoken.security.X509Mutator;
import java.net.URI;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

abstract class AbstractAsymmetricJwkBuilder<K extends Key, J extends AsymmetricJwk<K>, T extends AsymmetricJwkBuilder<K, J, T>> extends AbstractJwkBuilder<K, J, T> implements AsymmetricJwkBuilder<K, J, T> {
    protected Boolean applyX509KeyUse;
    private KeyUseStrategy keyUseStrategy;
    private final X509BuilderSupport x509;

    public static class DefaultEcPrivateJwkBuilder extends DefaultPrivateJwkBuilder<ECPrivateKey, ECPublicKey, EcPublicJwk, EcPrivateJwk, EcPrivateJwkBuilder> implements EcPrivateJwkBuilder {
        public DefaultEcPrivateJwkBuilder(JwkContext<ECPrivateKey> jwkContext) {
            super(jwkContext);
        }

        public DefaultEcPrivateJwkBuilder(DefaultEcPublicJwkBuilder defaultEcPublicJwkBuilder, JwkContext<ECPrivateKey> jwkContext) {
            super(defaultEcPublicJwkBuilder, jwkContext);
        }
    }

    public static class DefaultEcPublicJwkBuilder extends DefaultPublicJwkBuilder<ECPublicKey, ECPrivateKey, EcPublicJwk, EcPrivateJwk, EcPrivateJwkBuilder, EcPublicJwkBuilder> implements EcPublicJwkBuilder {
        public DefaultEcPublicJwkBuilder(JwkContext<ECPublicKey> jwkContext) {
            super(jwkContext);
        }

        public EcPrivateJwkBuilder newPrivateBuilder(JwkContext<ECPrivateKey> jwkContext) {
            return new DefaultEcPrivateJwkBuilder(this, jwkContext);
        }
    }

    public static class DefaultOctetPublicJwkBuilder<A extends PublicKey, B extends PrivateKey> extends DefaultPublicJwkBuilder<A, B, OctetPublicJwk<A>, OctetPrivateJwk<B, A>, OctetPrivateJwkBuilder<B, A>, OctetPublicJwkBuilder<A, B>> implements OctetPublicJwkBuilder<A, B> {
        public DefaultOctetPublicJwkBuilder(JwkContext<A> jwkContext) {
            super(jwkContext);
            EdwardsCurve.assertEdwards(jwkContext.getKey());
        }

        public OctetPrivateJwkBuilder<B, A> newPrivateBuilder(JwkContext<B> jwkContext) {
            return new DefaultOctetPrivateJwkBuilder(this, jwkContext);
        }
    }

    public static abstract class DefaultPrivateJwkBuilder<K extends PrivateKey, L extends PublicKey, J extends PublicJwk<L>, M extends PrivateJwk<K, L, J>, T extends PrivateJwkBuilder<K, L, J, M, T>> extends AbstractAsymmetricJwkBuilder<K, M, T> implements PrivateJwkBuilder<K, L, J, M, T> {
        public DefaultPrivateJwkBuilder(JwkContext<K> jwkContext) {
            super(jwkContext);
        }

        public T publicKey(L l10) {
            ((JwkContext) this.DELEGATE).setPublicKey(l10);
            return (PrivateJwkBuilder) self();
        }

        public /* bridge */ /* synthetic */ X509Mutator x509Chain(List list) {
            return AbstractAsymmetricJwkBuilder.super.x509Chain((List<X509Certificate>) list);
        }

        public /* bridge */ /* synthetic */ X509Builder x509Sha1Thumbprint(boolean z10) {
            return AbstractAsymmetricJwkBuilder.super.x509Sha1Thumbprint(z10);
        }

        public /* bridge */ /* synthetic */ X509Builder x509Sha256Thumbprint(boolean z10) {
            return AbstractAsymmetricJwkBuilder.super.x509Sha256Thumbprint(z10);
        }

        public /* bridge */ /* synthetic */ X509Mutator x509Url(URI uri) {
            return AbstractAsymmetricJwkBuilder.super.x509Url(uri);
        }

        public DefaultPrivateJwkBuilder(DefaultPublicJwkBuilder<L, K, J, M, ?, ?> defaultPublicJwkBuilder, JwkContext<K> jwkContext) {
            super(defaultPublicJwkBuilder, jwkContext);
            ((JwkContext) this.DELEGATE).setPublicKey((PublicKey) ((JwkContext) defaultPublicJwkBuilder.DELEGATE).getKey());
        }

        public /* bridge */ /* synthetic */ X509Mutator x509Sha1Thumbprint(byte[] bArr) {
            return AbstractAsymmetricJwkBuilder.super.x509Sha1Thumbprint(bArr);
        }

        public /* bridge */ /* synthetic */ X509Mutator x509Sha256Thumbprint(byte[] bArr) {
            return AbstractAsymmetricJwkBuilder.super.x509Sha256Thumbprint(bArr);
        }
    }

    public static abstract class DefaultPublicJwkBuilder<K extends PublicKey, L extends PrivateKey, J extends PublicJwk<K>, M extends PrivateJwk<L, K, J>, P extends PrivateJwkBuilder<L, K, J, M, P>, T extends PublicJwkBuilder<K, L, J, M, P, T>> extends AbstractAsymmetricJwkBuilder<K, J, T> implements PublicJwkBuilder<K, L, J, M, P, T> {
        public DefaultPublicJwkBuilder(JwkContext<K> jwkContext) {
            super(jwkContext);
        }

        public abstract P newPrivateBuilder(JwkContext<L> jwkContext);

        public P privateKey(L l10) {
            Assert.notNull(l10, "PrivateKey argument cannot be null.");
            return newPrivateBuilder(newContext(l10)).publicKey((PublicKey) Assert.notNull(((JwkContext) this.DELEGATE).getKey(), "PublicKey cannot be null."));
        }

        public /* bridge */ /* synthetic */ X509Mutator x509Chain(List list) {
            return AbstractAsymmetricJwkBuilder.super.x509Chain((List<X509Certificate>) list);
        }

        public /* bridge */ /* synthetic */ X509Builder x509Sha1Thumbprint(boolean z10) {
            return AbstractAsymmetricJwkBuilder.super.x509Sha1Thumbprint(z10);
        }

        public /* bridge */ /* synthetic */ X509Builder x509Sha256Thumbprint(boolean z10) {
            return AbstractAsymmetricJwkBuilder.super.x509Sha256Thumbprint(z10);
        }

        public /* bridge */ /* synthetic */ X509Mutator x509Url(URI uri) {
            return AbstractAsymmetricJwkBuilder.super.x509Url(uri);
        }

        public /* bridge */ /* synthetic */ X509Mutator x509Sha1Thumbprint(byte[] bArr) {
            return AbstractAsymmetricJwkBuilder.super.x509Sha1Thumbprint(bArr);
        }

        public /* bridge */ /* synthetic */ X509Mutator x509Sha256Thumbprint(byte[] bArr) {
            return AbstractAsymmetricJwkBuilder.super.x509Sha256Thumbprint(bArr);
        }
    }

    public static class DefaultRsaPrivateJwkBuilder extends DefaultPrivateJwkBuilder<RSAPrivateKey, RSAPublicKey, RsaPublicJwk, RsaPrivateJwk, RsaPrivateJwkBuilder> implements RsaPrivateJwkBuilder {
        public DefaultRsaPrivateJwkBuilder(JwkContext<RSAPrivateKey> jwkContext) {
            super(jwkContext);
        }

        public DefaultRsaPrivateJwkBuilder(DefaultRsaPublicJwkBuilder defaultRsaPublicJwkBuilder, JwkContext<RSAPrivateKey> jwkContext) {
            super(defaultRsaPublicJwkBuilder, jwkContext);
        }
    }

    public static class DefaultRsaPublicJwkBuilder extends DefaultPublicJwkBuilder<RSAPublicKey, RSAPrivateKey, RsaPublicJwk, RsaPrivateJwk, RsaPrivateJwkBuilder, RsaPublicJwkBuilder> implements RsaPublicJwkBuilder {
        public DefaultRsaPublicJwkBuilder(JwkContext<RSAPublicKey> jwkContext) {
            super(jwkContext);
        }

        public RsaPrivateJwkBuilder newPrivateBuilder(JwkContext<RSAPrivateKey> jwkContext) {
            return new DefaultRsaPrivateJwkBuilder(this, jwkContext);
        }
    }

    public AbstractAsymmetricJwkBuilder(JwkContext<K> jwkContext) {
        super(jwkContext);
        this.applyX509KeyUse = null;
        this.keyUseStrategy = DefaultKeyUseStrategy.INSTANCE;
        this.x509 = new X509BuilderSupport((ParameterMap) Assert.isInstanceOf(ParameterMap.class, this.DELEGATE), MalformedKeyException.class);
    }

    public T publicKeyUse(String str) {
        Assert.hasText(str, "publicKeyUse cannot be null or empty.");
        ((JwkContext) this.DELEGATE).setPublicKeyUse(str);
        return (AsymmetricJwkBuilder) self();
    }

    public static class DefaultOctetPrivateJwkBuilder<A extends PrivateKey, B extends PublicKey> extends DefaultPrivateJwkBuilder<A, B, OctetPublicJwk<B>, OctetPrivateJwk<A, B>, OctetPrivateJwkBuilder<A, B>> implements OctetPrivateJwkBuilder<A, B> {
        public DefaultOctetPrivateJwkBuilder(JwkContext<A> jwkContext) {
            super(jwkContext);
            EdwardsCurve.assertEdwards(jwkContext.getKey());
        }

        public DefaultOctetPrivateJwkBuilder(DefaultOctetPublicJwkBuilder<B, A> defaultOctetPublicJwkBuilder, JwkContext<A> jwkContext) {
            super(defaultOctetPublicJwkBuilder, jwkContext);
            EdwardsCurve.assertEdwards(jwkContext.getKey());
            EdwardsCurve.assertEdwards(jwkContext.getPublicKey());
        }
    }

    public T x509Chain(List<X509Certificate> list) {
        Assert.notEmpty(list, "X509Certificate chain cannot be null or empty.");
        this.x509.x509Chain(list);
        return (AsymmetricJwkBuilder) self();
    }

    public T x509Url(URI uri) {
        Assert.notNull(uri, "X509Url cannot be null.");
        this.x509.x509Url(uri);
        return (AsymmetricJwkBuilder) self();
    }

    public J build() {
        this.x509.apply();
        return (AsymmetricJwk) super.build();
    }

    public T x509Sha1Thumbprint(byte[] bArr) {
        this.x509.x509Sha1Thumbprint(bArr);
        return (AsymmetricJwkBuilder) self();
    }

    public T x509Sha256Thumbprint(byte[] bArr) {
        this.x509.x509Sha256Thumbprint(bArr);
        return (AsymmetricJwkBuilder) self();
    }

    public T x509Sha1Thumbprint(boolean z10) {
        this.x509.x509Sha1Thumbprint(z10);
        return (AsymmetricJwkBuilder) self();
    }

    public T x509Sha256Thumbprint(boolean z10) {
        this.x509.x509Sha256Thumbprint(z10);
        return (AsymmetricJwkBuilder) self();
    }

    public AbstractAsymmetricJwkBuilder(AbstractAsymmetricJwkBuilder<?, ?, ?> abstractAsymmetricJwkBuilder, JwkContext<K> jwkContext) {
        this(jwkContext);
        this.applyX509KeyUse = abstractAsymmetricJwkBuilder.applyX509KeyUse;
        this.keyUseStrategy = abstractAsymmetricJwkBuilder.keyUseStrategy;
    }
}
