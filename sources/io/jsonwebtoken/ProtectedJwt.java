package io.jsonwebtoken;

import io.jsonwebtoken.ProtectedHeader;
import io.jsonwebtoken.security.DigestSupplier;

public interface ProtectedJwt<H extends ProtectedHeader, P> extends Jwt<H, P>, DigestSupplier {
}
