package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;

public class IdLocator<H extends Header, R extends Identifiable> implements Locator<R>, Function<H, R> {
    private final Parameter<String> param;
    private final Registry<String, R> registry;
    private final String requiredMsg;
    private final boolean valueRequired;

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, io.jsonwebtoken.impl.lang.Parameter<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IdLocator(io.jsonwebtoken.impl.lang.Parameter<java.lang.String> r2, io.jsonwebtoken.lang.Registry<java.lang.String, R> r3, java.lang.String r4) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Header param cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            io.jsonwebtoken.impl.lang.Parameter r2 = (io.jsonwebtoken.impl.lang.Parameter) r2
            r1.param = r2
            java.lang.String r2 = io.jsonwebtoken.lang.Strings.clean((java.lang.String) r4)
            r1.requiredMsg = r2
            boolean r2 = io.jsonwebtoken.lang.Strings.hasText((java.lang.String) r2)
            r1.valueRequired = r2
            java.lang.String r2 = "Registry cannot be null or empty."
            io.jsonwebtoken.lang.Assert.notEmpty(r3, (java.lang.String) r2)
            r1.registry = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.IdLocator.<init>(io.jsonwebtoken.impl.lang.Parameter, io.jsonwebtoken.lang.Registry, java.lang.String):void");
    }

    private static String type(Header header) {
        if (header instanceof JweHeader) {
            return "JWE";
        }
        if (header instanceof JwsHeader) {
            return "JWS";
        }
        return Header.JWT_TYPE;
    }

    public R apply(H h10) {
        return locate((Header) h10);
    }

    public R locate(Header header) {
        Assert.notNull(header, "Header argument cannot be null.");
        Object obj = header.get(this.param.getId());
        String obj2 = obj != null ? obj.toString() : null;
        if (Strings.hasText(obj2)) {
            try {
                return (Identifiable) this.registry.forKey(obj2);
            } catch (Exception e10) {
                throw new UnsupportedJwtException("Unrecognized " + type(header) + " " + this.param + " header value: " + obj2, e10);
            }
        } else if (!this.valueRequired) {
            return null;
        } else {
            throw new MalformedJwtException(this.requiredMsg);
        }
    }
}
