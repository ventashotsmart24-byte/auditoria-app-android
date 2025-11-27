package io.jsonwebtoken.security;

import java.io.InputStream;

public interface HashAlgorithm extends DigestAlgorithm<Request<InputStream>, VerifyDigestRequest> {
}
