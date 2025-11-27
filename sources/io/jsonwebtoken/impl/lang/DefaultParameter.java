package io.jsonwebtoken.impl.lang;

import com.raizlabs.android.dbflow.sql.language.Operator;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.util.Collection;

public class DefaultParameter<T> implements Parameter<T> {
    private final Class<? extends Collection<T>> COLLECTION_TYPE;
    private final Converter<T, Object> CONVERTER;
    private final String ID;
    private final Class<T> IDIOMATIC_TYPE;
    private final String NAME;
    private final boolean SECRET;

    public DefaultParameter(String str, String str2, boolean z10, Class<T> cls, Class<? extends Collection<T>> cls2, Converter<T, Object> converter) {
        this.ID = Strings.clean((String) Assert.hasText(str, "ID argument cannot be null or empty."));
        this.NAME = Strings.clean((String) Assert.hasText(str2, "Name argument cannot be null or empty."));
        this.IDIOMATIC_TYPE = (Class) Assert.notNull(cls, "idiomaticType argument cannot be null.");
        this.CONVERTER = (Converter) Assert.notNull(converter, "Converter argument cannot be null.");
        this.SECRET = z10;
        this.COLLECTION_TYPE = cls2;
    }

    public T applyFrom(Object obj) {
        return this.CONVERTER.applyFrom(obj);
    }

    public Object applyTo(T t10) {
        return this.CONVERTER.applyTo(t10);
    }

    public T cast(Object obj) {
        if (obj != null) {
            Class<? extends Collection<T>> cls = this.COLLECTION_TYPE;
            if (cls != null) {
                if (cls.isInstance(obj)) {
                    Collection collection = (Collection) this.COLLECTION_TYPE.cast(obj);
                    if (!collection.isEmpty()) {
                        if (!this.IDIOMATIC_TYPE.isInstance(collection.iterator().next())) {
                            throw new ClassCastException("Cannot cast " + obj.getClass().getName() + " to " + this.COLLECTION_TYPE.getName() + Operator.Operation.LESS_THAN + this.IDIOMATIC_TYPE.getName() + ">: At least one " + "element is not an instance of " + this.IDIOMATIC_TYPE.getName());
                        }
                    }
                } else {
                    throw new ClassCastException("Cannot cast " + obj.getClass().getName() + " to " + this.COLLECTION_TYPE.getName() + Operator.Operation.LESS_THAN + this.IDIOMATIC_TYPE.getName() + Operator.Operation.GREATER_THAN);
                }
            } else if (!this.IDIOMATIC_TYPE.isInstance(obj)) {
                throw new ClassCastException("Cannot cast " + obj.getClass().getName() + " to " + this.IDIOMATIC_TYPE.getName());
            }
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Parameter) {
            return this.ID.equals(((Parameter) obj).getId());
        }
        return false;
    }

    public String getId() {
        return this.ID;
    }

    public String getName() {
        return this.NAME;
    }

    public int hashCode() {
        return this.ID.hashCode();
    }

    public boolean isSecret() {
        return this.SECRET;
    }

    public boolean supports(Object obj) {
        if (obj == null) {
            return true;
        }
        Class<? extends Collection<T>> cls = this.COLLECTION_TYPE;
        if (cls == null || !cls.isInstance(obj)) {
            return this.IDIOMATIC_TYPE.isInstance(obj);
        }
        Collection collection = (Collection) this.COLLECTION_TYPE.cast(obj);
        if (collection.isEmpty() || this.IDIOMATIC_TYPE.isInstance(collection.iterator().next())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "'" + this.ID + "' (" + this.NAME + ")";
    }
}
