package io.jsonwebtoken.security;

import java.io.InputStream;
import javax.crypto.SecretKey;

public interface AeadRequest extends SecureRequest<InputStream, SecretKey>, AssociatedDataSupplier {
}
