package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.lang.Assert;

public class LocatorFunction<T> implements Function<Header, T> {
    private final Locator<T> locator;

    public LocatorFunction(Locator<T> locator2) {
        this.locator = (Locator) Assert.notNull(locator2, "Locator instance cannot be null.");
    }

    public T apply(Header header) {
        return this.locator.locate(header);
    }
}
