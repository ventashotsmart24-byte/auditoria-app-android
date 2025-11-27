package io.jsonwebtoken;

import java.security.Key;

@Deprecated
public interface SigningKeyResolver {
    Key resolveSigningKey(JwsHeader jwsHeader, Claims claims);

    Key resolveSigningKey(JwsHeader jwsHeader, byte[] bArr);
}
