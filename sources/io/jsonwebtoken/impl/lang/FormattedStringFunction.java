package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

public class FormattedStringFunction<T> implements Function<T, String> {
    private final String msg;

    public FormattedStringFunction(String str) {
        this.msg = (String) Assert.hasText(str, "msg argument cannot be null or empty.");
    }

    public String apply(T t10) {
        return String.format(this.msg, new Object[]{t10});
    }
}
