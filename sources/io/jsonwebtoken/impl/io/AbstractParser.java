package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.Parser;
import io.jsonwebtoken.lang.Assert;
import java.io.InputStream;
import java.io.Reader;

public abstract class AbstractParser<T> implements Parser<T> {
    public final T parse(CharSequence charSequence) {
        Assert.hasText(charSequence, "CharSequence cannot be null or empty.");
        return parse(charSequence, 0, charSequence.length());
    }

    public T parse(CharSequence charSequence, int i10, int i11) {
        Assert.hasText(charSequence, "CharSequence cannot be null or empty.");
        return parse((Reader) new CharSequenceReader(charSequence, i10, i11));
    }

    public final T parse(InputStream inputStream) {
        Assert.notNull(inputStream, "InputStream cannot be null.");
        return parse(Streams.reader(inputStream));
    }
}
