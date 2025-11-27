package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.Message;

class DefaultMessage<T> implements Message<T> {
    private final T payload;

    public DefaultMessage(T t10) {
        this.payload = Assert.notNull(t10, "payload cannot be null.");
        if (t10 instanceof byte[]) {
            assertBytePayload((byte[]) t10);
        }
    }

    public void assertBytePayload(byte[] bArr) {
        Assert.notEmpty(bArr, "payload byte array cannot be null or empty.");
    }

    public T getPayload() {
        return this.payload;
    }
}
