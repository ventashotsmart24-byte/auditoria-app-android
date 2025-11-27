package io.jsonwebtoken.lang;

import io.jsonwebtoken.lang.CollectionMutator;
import java.util.Collection;

public interface CollectionMutator<E, M extends CollectionMutator<E, M>> {
    M add(E e10);

    M add(Collection<? extends E> collection);

    M clear();

    M remove(E e10);
}
