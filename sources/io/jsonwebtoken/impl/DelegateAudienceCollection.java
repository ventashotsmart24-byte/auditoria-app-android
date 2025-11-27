package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.lang.Assert;
import java.util.Collection;

public class DelegateAudienceCollection<P> implements ClaimsMutator.AudienceCollection<P> {
    private final ClaimsMutator.AudienceCollection<?> delegate;
    private final P parent;

    public DelegateAudienceCollection(P p10, ClaimsMutator.AudienceCollection<?> audienceCollection) {
        this.parent = Assert.notNull(p10, "Parent cannot be null.");
        this.delegate = (ClaimsMutator.AudienceCollection) Assert.notNull(audienceCollection, "Delegate cannot be null.");
    }

    public P and() {
        this.delegate.and();
        return this.parent;
    }

    public P single(String str) {
        this.delegate.single(str);
        return this.parent;
    }

    public ClaimsMutator.AudienceCollection<P> clear() {
        this.delegate.clear();
        return this;
    }

    public ClaimsMutator.AudienceCollection<P> remove(String str) {
        this.delegate.remove(str);
        return this;
    }

    public ClaimsMutator.AudienceCollection<P> add(String str) {
        this.delegate.add(str);
        return this;
    }

    public ClaimsMutator.AudienceCollection<P> add(Collection<? extends String> collection) {
        this.delegate.add(collection);
        return this;
    }
}
