package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.AbstractSerializer;
import io.jsonwebtoken.io.SerializationException;
import io.jsonwebtoken.io.Serializer;
import java.io.OutputStream;
import java.util.Map;

public class NamedSerializer extends AbstractSerializer<Map<String, ?>> {
    private final Serializer<Map<String, ?>> DELEGATE;
    private final String name;

    /* JADX WARNING: type inference failed for: r3v0, types: [io.jsonwebtoken.io.Serializer<java.util.Map<java.lang.String, ?>>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NamedSerializer(java.lang.String r2, io.jsonwebtoken.io.Serializer<java.util.Map<java.lang.String, ?>> r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "JSON Serializer cannot be null."
            java.lang.Object r3 = io.jsonwebtoken.lang.Assert.notNull(r3, r0)
            io.jsonwebtoken.io.Serializer r3 = (io.jsonwebtoken.io.Serializer) r3
            r1.DELEGATE = r3
            java.lang.String r3 = "Name cannot be null or empty."
            java.lang.CharSequence r2 = io.jsonwebtoken.lang.Assert.hasText(r2, r3)
            java.lang.String r2 = (java.lang.String) r2
            r1.name = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.io.NamedSerializer.<init>(java.lang.String, io.jsonwebtoken.io.Serializer):void");
    }

    public void doSerialize(Map<String, ?> map, OutputStream outputStream) {
        try {
            this.DELEGATE.serialize(map, outputStream);
        } catch (Throwable th) {
            throw new SerializationException(String.format("Cannot serialize %s to JSON. Cause: %s", new Object[]{this.name, th.getMessage()}), th);
        }
    }
}
