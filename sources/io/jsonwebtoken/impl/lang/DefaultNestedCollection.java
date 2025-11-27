package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.NestedCollection;
import java.util.Collection;

public class DefaultNestedCollection<E, P> extends DefaultCollectionMutator<E, NestedCollection<E, P>> implements NestedCollection<E, P> {
    private final P parent;

    public DefaultNestedCollection(P p10, Collection<? extends E> collection) {
        super(collection);
        this.parent = Assert.notNull(p10, "Parent cannot be null.");
    }

    public P and() {
        return this.parent;
    }
}
