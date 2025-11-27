package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Supplier;

public class RedactedSupplier<T> implements Supplier<T> {
    public static final String REDACTED_VALUE = "<redacted>";
    private final T value;

    public RedactedSupplier(T t10) {
        this.value = Assert.notNull(t10, "value cannot be null.");
    }

    public boolean equals(T t10) {
        if (t10 == this) {
            return true;
        }
        if (t10 instanceof RedactedSupplier) {
            t10 = ((RedactedSupplier) t10).value;
        }
        return Objects.nullSafeEquals(this.value, t10);
    }

    public T get() {
        return this.value;
    }

    public int hashCode() {
        return Objects.nullSafeHashCode((Object) this.value);
    }

    public String toString() {
        return REDACTED_VALUE;
    }
}
