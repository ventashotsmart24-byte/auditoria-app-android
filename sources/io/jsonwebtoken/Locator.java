package io.jsonwebtoken;

public interface Locator<T> {
    T locate(Header header);
}
