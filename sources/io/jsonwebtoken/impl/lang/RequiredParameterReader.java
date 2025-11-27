package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.impl.security.JwkContext;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.MalformedKeyException;

public class RequiredParameterReader implements ParameterReadable {
    private final ParameterReadable src;

    public RequiredParameterReader(Header header) {
        this((ParameterReadable) Assert.isInstanceOf(ParameterReadable.class, header, "Header implementations must implement ParameterReadable: "));
    }

    private JwtException malformed(String str) {
        ParameterReadable parameterReadable = this.src;
        if ((parameterReadable instanceof JwkContext) || (parameterReadable instanceof Jwk)) {
            return new MalformedKeyException(str);
        }
        return new MalformedJwtException(str);
    }

    private String name() {
        return ((Nameable) this.src).getName();
    }

    public <T> T get(Parameter<T> parameter) {
        T t10 = this.src.get(parameter);
        if (t10 != null) {
            return t10;
        }
        throw malformed(name() + " is missing required " + parameter + " value.");
    }

    public RequiredParameterReader(ParameterReadable parameterReadable) {
        this.src = (ParameterReadable) Assert.notNull(parameterReadable, "Source ParameterReadable cannot be null.");
        Assert.isInstanceOf(Nameable.class, parameterReadable, "ParameterReadable implementations must implement Nameable.");
    }
}
