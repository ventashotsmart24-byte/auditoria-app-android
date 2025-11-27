package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.lang.Assert;
import java.io.Reader;
import java.util.Map;

public class ConvertingParser<T> extends AbstractParser<T> {
    private final Converter<T, Object> converter;
    private final Function<Reader, Map<String, ?>> deserializer;

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, io.jsonwebtoken.impl.lang.Function<java.io.Reader, java.util.Map<java.lang.String, ?>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ConvertingParser(io.jsonwebtoken.impl.lang.Function<java.io.Reader, java.util.Map<java.lang.String, ?>> r2, io.jsonwebtoken.impl.lang.Converter<T, java.lang.Object> r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Deserializer function cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            io.jsonwebtoken.impl.lang.Function r2 = (io.jsonwebtoken.impl.lang.Function) r2
            r1.deserializer = r2
            java.lang.String r2 = "Converter cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r3, r2)
            io.jsonwebtoken.impl.lang.Converter r2 = (io.jsonwebtoken.impl.lang.Converter) r2
            r1.converter = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.io.ConvertingParser.<init>(io.jsonwebtoken.impl.lang.Function, io.jsonwebtoken.impl.lang.Converter):void");
    }

    public final T parse(Reader reader) {
        Assert.notNull(reader, "Reader cannot be null.");
        return this.converter.applyFrom(this.deserializer.apply(reader));
    }
}
