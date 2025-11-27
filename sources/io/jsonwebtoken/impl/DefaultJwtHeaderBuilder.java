package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Collections;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class DefaultJwtHeaderBuilder extends DefaultJweHeaderBuilder<Jwts.HeaderBuilder> implements Jwts.HeaderBuilder {
    public DefaultJwtHeaderBuilder() {
    }

    private static ParameterMap sanitizeCrit(ParameterMap parameterMap, boolean z10) {
        Parameter parameter = DefaultProtectedHeader.CRIT;
        Set<String> set = (Set) parameterMap.get(parameter);
        if (set == null) {
            return parameterMap;
        }
        ParameterMap parameterMap2 = new ParameterMap(DefaultJweHeader.PARAMS, parameterMap, true);
        parameterMap2.remove(parameter.getId());
        if (!z10) {
            return parameterMap2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        for (String str : set) {
            if (DefaultJweHeader.PARAMS.containsKey(str) || !parameterMap2.containsKey(str)) {
                linkedHashSet.remove(str);
            }
        }
        if (!Collections.isEmpty((Collection<?>) linkedHashSet)) {
            parameterMap2.put(DefaultProtectedHeader.CRIT, (Object) linkedHashSet);
        }
        return parameterMap2;
    }

    public DefaultJwtHeaderBuilder(DefaultJweHeaderMutator<?> defaultJweHeaderMutator) {
        super(defaultJweHeaderMutator);
    }

    public Header build() {
        this.x509.apply();
        ParameterMap parameterMap = (ParameterMap) this.DELEGATE;
        if (DefaultJweHeader.isCandidate(parameterMap)) {
            return new DefaultJweHeader(sanitizeCrit(parameterMap, true));
        }
        if (DefaultProtectedHeader.isCandidate(parameterMap)) {
            return new DefaultJwsHeader(sanitizeCrit(parameterMap, true));
        }
        return new DefaultHeader(sanitizeCrit(parameterMap, false));
    }
}
