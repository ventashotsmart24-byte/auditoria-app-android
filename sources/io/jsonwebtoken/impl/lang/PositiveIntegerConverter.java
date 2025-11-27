package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.util.concurrent.atomic.AtomicInteger;

public class PositiveIntegerConverter implements Converter<Integer, Object> {
    public static final PositiveIntegerConverter INSTANCE = new PositiveIntegerConverter();

    public Object applyTo(Integer num) {
        return num;
    }

    public Integer applyFrom(Object obj) {
        int i10;
        Assert.notNull(obj, "Argument cannot be null.");
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof AtomicInteger)) {
            i10 = ((Number) obj).intValue();
        } else {
            try {
                i10 = Integer.parseInt(String.valueOf(obj));
            } catch (NumberFormatException e10) {
                throw new IllegalArgumentException("Value cannot be represented as a java.lang.Integer.", e10);
            }
        }
        if (i10 > 0) {
            return Integer.valueOf(i10);
        }
        throw new IllegalArgumentException("Value must be a positive integer.");
    }
}
