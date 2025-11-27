package io.jsonwebtoken.security;

import java.io.InputStream;

public interface VerifyDigestRequest extends Request<InputStream>, DigestSupplier {
}
