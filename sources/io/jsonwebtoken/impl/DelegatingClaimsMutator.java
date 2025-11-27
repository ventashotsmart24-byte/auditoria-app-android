package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.impl.lang.DelegatingMapMutator;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.MapMutator;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class DelegatingClaimsMutator<T extends MapMutator<String, Object, T> & ClaimsMutator<T>> extends DelegatingMapMutator<String, Object, ParameterMap, T> implements ClaimsMutator<T> {
    private static final Parameter<String> AUDIENCE_STRING;

    static {
        Parameter<Set<String>> parameter = DefaultClaims.AUDIENCE;
        AUDIENCE_STRING = Parameters.string(parameter.getId(), parameter.getName());
    }

    public DelegatingClaimsMutator() {
        super(new ParameterMap((Registry<String, ? extends Parameter<?>>) DefaultClaims.PARAMS));
    }

    /* access modifiers changed from: private */
    public T audienceSingle(String str) {
        if (!Strings.hasText(str)) {
            return put(DefaultClaims.AUDIENCE, (Object) null);
        }
        Parameter parameter = AUDIENCE_STRING;
        remove(parameter.getId());
        setDelegate(((ParameterMap) this.DELEGATE).replace(parameter));
        return put(parameter, str);
    }

    private Set<String> getAudience() {
        Registry<String, ? extends Parameter<?>> registry = ((ParameterMap) this.DELEGATE).PARAMS;
        Parameter<String> parameter = AUDIENCE_STRING;
        if (!((Parameter) registry.get(parameter.getId())).supports(Collections.emptySet())) {
            remove(parameter.getId());
            Parameter<Set<String>> parameter2 = DefaultClaims.AUDIENCE;
            setDelegate(((ParameterMap) this.DELEGATE).replace(parameter2));
            put(parameter2, Collections.setOf((String) get(parameter)));
        }
        return (Set) get(DefaultClaims.AUDIENCE);
    }

    public ClaimsMutator.AudienceCollection<T> audience() {
        return new AbstractAudienceCollection<T>(self(), getAudience()) {
            public void changed() {
                DelegatingClaimsMutator.this.put(DefaultClaims.AUDIENCE, Collections.asSet(getCollection()));
            }

            public T single(String str) {
                return DelegatingClaimsMutator.this.audienceSingle(str);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public <F> F get(Parameter<F> parameter) {
        return ((ParameterMap) this.DELEGATE).get(parameter);
    }

    public void putAll(Map<? extends String, ?> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
        }
    }

    public T expiration(Date date) {
        return put(DefaultClaims.EXPIRATION, date);
    }

    public T id(String str) {
        return put(DefaultClaims.JTI, str);
    }

    public T issuedAt(Date date) {
        return put(DefaultClaims.ISSUED_AT, date);
    }

    public T issuer(String str) {
        return put(DefaultClaims.ISSUER, str);
    }

    public T notBefore(Date date) {
        return put(DefaultClaims.NOT_BEFORE, date);
    }

    public <F> T put(Parameter<F> parameter, F f10) {
        ((ParameterMap) this.DELEGATE).put(parameter, (Object) f10);
        return self();
    }

    public T setAudience(String str) {
        return (MapMutator) audience().single(str);
    }

    public T setExpiration(Date date) {
        return expiration(date);
    }

    public T setId(String str) {
        return id(str);
    }

    public T setIssuedAt(Date date) {
        return issuedAt(date);
    }

    public T setIssuer(String str) {
        return issuer(str);
    }

    public T setNotBefore(Date date) {
        return notBefore(date);
    }

    public T setSubject(String str) {
        return subject(str);
    }

    public T subject(String str) {
        return put(DefaultClaims.SUBJECT, str);
    }

    public Object put(String str, Object obj) {
        if (AUDIENCE_STRING.getId().equals(str)) {
            if (obj instanceof String) {
                Object obj2 = get(str);
                audience().single((String) obj);
                return obj2;
            }
            getAudience();
        }
        return super.put(str, obj);
    }
}
