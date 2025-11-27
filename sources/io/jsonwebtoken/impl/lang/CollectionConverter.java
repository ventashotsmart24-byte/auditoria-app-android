package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class CollectionConverter<T, C extends Collection<T>> implements Converter<C, Object> {
    private final Converter<T, Object> elementConverter;
    private final Function<Integer, C> fn;

    public static class CreateListFunction<A> implements Function<Integer, List<A>> {
        private CreateListFunction() {
        }

        public List<A> apply(Integer num) {
            return num.intValue() > 0 ? new ArrayList(num.intValue()) : new ArrayList();
        }
    }

    public static class CreateSetFunction<T> implements Function<Integer, Set<T>> {
        private CreateSetFunction() {
        }

        public Set<T> apply(Integer num) {
            return num.intValue() > 0 ? new LinkedHashSet(num.intValue()) : new LinkedHashSet();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [io.jsonwebtoken.impl.lang.Function<java.lang.Integer, C>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollectionConverter(io.jsonwebtoken.impl.lang.Converter<T, java.lang.Object> r2, io.jsonwebtoken.impl.lang.Function<java.lang.Integer, C> r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Element converter cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            io.jsonwebtoken.impl.lang.Converter r2 = (io.jsonwebtoken.impl.lang.Converter) r2
            r1.elementConverter = r2
            java.lang.String r2 = "Collection function cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r3, r2)
            io.jsonwebtoken.impl.lang.Function r2 = (io.jsonwebtoken.impl.lang.Function) r2
            r1.fn = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.lang.CollectionConverter.<init>(io.jsonwebtoken.impl.lang.Converter, io.jsonwebtoken.impl.lang.Function):void");
    }

    public static <T> CollectionConverter<T, List<T>> forList(Converter<T, Object> converter) {
        return new CollectionConverter<>(converter, new CreateListFunction());
    }

    public static <T> CollectionConverter<T, Set<T>> forSet(Converter<T, Object> converter) {
        return new CollectionConverter<>(converter, new CreateSetFunction());
    }

    private C toElementList(Collection<?> collection) {
        Assert.notEmpty(collection, "Collection cannot be null or empty.");
        C c10 = (Collection) this.fn.apply(Integer.valueOf(collection.size()));
        for (Object applyFrom : collection) {
            c10.add(this.elementConverter.applyFrom(applyFrom));
        }
        return c10;
    }

    public C applyFrom(Object obj) {
        Collection collection;
        if (obj == null) {
            return null;
        }
        if (obj.getClass().isArray() && !obj.getClass().getComponentType().isPrimitive()) {
            collection = Collections.arrayToList(obj);
        } else if (obj instanceof Collection) {
            collection = (Collection) obj;
        } else {
            collection = java.util.Collections.singletonList(obj);
        }
        if (Collections.isEmpty((Collection<?>) collection)) {
            return (Collection) this.fn.apply(0);
        }
        return toElementList(collection);
    }

    public Object applyTo(C c10) {
        if (Collections.isEmpty((Collection<?>) c10)) {
            return c10;
        }
        Collection collection = (Collection) this.fn.apply(Integer.valueOf(c10.size()));
        for (Object applyTo : c10) {
            collection.add(this.elementConverter.applyTo(applyTo));
        }
        return collection;
    }
}
