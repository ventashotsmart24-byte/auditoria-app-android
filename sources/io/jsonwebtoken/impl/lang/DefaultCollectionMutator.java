package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.lang.CollectionMutator;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class DefaultCollectionMutator<E, M extends CollectionMutator<E, M>> implements CollectionMutator<E, M> {
    private final Collection<E> collection;

    public DefaultCollectionMutator(Collection<? extends E> collection2) {
        this.collection = new LinkedHashSet(Collections.nullSafe(collection2));
    }

    private boolean doAdd(E e10) {
        if (Objects.isEmpty((Object) e10)) {
            return false;
        }
        if (!(e10 instanceof Identifiable) || Strings.hasText(((Identifiable) e10).getId())) {
            return this.collection.add(e10);
        }
        throw new IllegalArgumentException(e10.getClass() + " getId() value cannot be null or empty.");
    }

    public M add(E e10) {
        if (doAdd(e10)) {
            changed();
        }
        return self();
    }

    public void changed() {
    }

    public M clear() {
        boolean z10 = !Collections.isEmpty((Collection<?>) this.collection);
        this.collection.clear();
        if (z10) {
            changed();
        }
        return self();
    }

    public Collection<E> getCollection() {
        return Collections.immutable(this.collection);
    }

    public M remove(E e10) {
        if (this.collection.remove(e10)) {
            changed();
        }
        return self();
    }

    public final M self() {
        return this;
    }

    public M add(Collection<? extends E> collection2) {
        boolean z10;
        Iterator<T> it = Collections.nullSafe(collection2).iterator();
        loop0:
        while (true) {
            z10 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else if (doAdd(it.next()) || z10) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            changed();
        }
        return self();
    }
}
