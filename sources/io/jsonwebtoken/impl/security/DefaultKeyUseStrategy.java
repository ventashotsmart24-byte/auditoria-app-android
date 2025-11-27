package io.jsonwebtoken.impl.security;

public class DefaultKeyUseStrategy implements KeyUseStrategy {
    private static final String ENCRYPTION = "enc";
    static final KeyUseStrategy INSTANCE = new DefaultKeyUseStrategy();
    private static final String SIGNATURE = "sig";

    public String toJwkValue(KeyUsage keyUsage) {
        if (keyUsage.isKeyEncipherment() || keyUsage.isDataEncipherment() || keyUsage.isKeyAgreement()) {
            return ENCRYPTION;
        }
        if (keyUsage.isDigitalSignature() || keyUsage.isNonRepudiation() || keyUsage.isKeyCertSign() || keyUsage.isCRLSign()) {
            return SIGNATURE;
        }
        return null;
    }
}
