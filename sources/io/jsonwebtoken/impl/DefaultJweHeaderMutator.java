package io.jsonwebtoken.impl;

import io.jsonwebtoken.JweHeaderMutator;
import io.jsonwebtoken.impl.lang.DefaultNestedCollection;
import io.jsonwebtoken.impl.lang.DelegatingMapMutator;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.security.X509BuilderSupport;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.PublicJwk;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;

public class DefaultJweHeaderMutator<T extends JweHeaderMutator<T>> extends DelegatingMapMutator<String, Object, ParameterMap, T> implements JweHeaderMutator<T> {
    protected X509BuilderSupport x509;

    public DefaultJweHeaderMutator() {
        super(new ParameterMap((Registry<String, ? extends Parameter<?>>) DefaultJweHeader.PARAMS));
        clear();
    }

    /* access modifiers changed from: private */
    public <F> T put(Parameter<F> parameter, F f10) {
        ((ParameterMap) this.DELEGATE).put(parameter, (Object) f10);
        return (JweHeaderMutator) self();
    }

    public T agreementPartyUInfo(byte[] bArr) {
        return put(DefaultJweHeader.APU, bArr);
    }

    public T agreementPartyVInfo(byte[] bArr) {
        return put(DefaultJweHeader.APV, bArr);
    }

    public void clear() {
        super.clear();
        this.x509 = new X509BuilderSupport((ParameterMap) this.DELEGATE, IllegalStateException.class);
    }

    public NestedCollection<String, T> critical() {
        return new DefaultNestedCollection<String, T>((JweHeaderMutator) self(), (Collection) ((ParameterMap) this.DELEGATE).get(DefaultProtectedHeader.CRIT)) {
            public void changed() {
                JweHeaderMutator unused = DefaultJweHeaderMutator.this.put(DefaultProtectedHeader.CRIT, Collections.asSet(getCollection()));
            }
        };
    }

    public T pbes2Count(int i10) {
        return put(DefaultJweHeader.P2C, Integer.valueOf(i10));
    }

    public T agreementPartyUInfo(String str) {
        return agreementPartyUInfo(Strings.utf8((CharSequence) Strings.clean(str)));
    }

    public T agreementPartyVInfo(String str) {
        return agreementPartyVInfo(Strings.utf8((CharSequence) Strings.clean(str)));
    }

    public T contentType(String str) {
        return put(DefaultHeader.CONTENT_TYPE, str);
    }

    public T jwk(PublicJwk<?> publicJwk) {
        return put(DefaultProtectedHeader.JWK, publicJwk);
    }

    public T jwkSetUrl(URI uri) {
        return put(DefaultProtectedHeader.JKU, uri);
    }

    public T keyId(String str) {
        return put(DefaultProtectedHeader.KID, str);
    }

    public T setAlgorithm(String str) {
        return put(DefaultHeader.ALGORITHM, str);
    }

    public T setCompressionAlgorithm(String str) {
        return put(DefaultHeader.COMPRESSION_ALGORITHM, str);
    }

    public T setContentType(String str) {
        return contentType(str);
    }

    public T setKeyId(String str) {
        return keyId(str);
    }

    public T setType(String str) {
        return type(str);
    }

    public T type(String str) {
        return put(DefaultHeader.TYPE, str);
    }

    public T x509Chain(List<X509Certificate> list) {
        this.x509.x509Chain(list);
        return (JweHeaderMutator) self();
    }

    public T x509Sha1Thumbprint(byte[] bArr) {
        this.x509.x509Sha1Thumbprint(bArr);
        return (JweHeaderMutator) self();
    }

    public T x509Sha256Thumbprint(byte[] bArr) {
        this.x509.x509Sha256Thumbprint(bArr);
        return (JweHeaderMutator) self();
    }

    public T x509Url(URI uri) {
        this.x509.x509Url(uri);
        return (JweHeaderMutator) self();
    }

    public DefaultJweHeaderMutator(DefaultJweHeaderMutator<?> defaultJweHeaderMutator) {
        super(defaultJweHeaderMutator.DELEGATE);
        this.x509 = defaultJweHeaderMutator.x509;
    }
}
