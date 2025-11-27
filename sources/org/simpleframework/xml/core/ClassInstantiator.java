package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.List;

class ClassInstantiator implements Instantiator {
    private final List<Creator> creators;
    private final Detail detail;
    private final Creator primary;
    private final ParameterMap registry;

    public ClassInstantiator(List<Creator> list, Creator creator, ParameterMap parameterMap, Detail detail2) {
        this.creators = list;
        this.registry = parameterMap;
        this.primary = creator;
        this.detail = detail2;
    }

    private Creator getCreator(Criteria criteria) {
        Creator creator = this.primary;
        double d10 = 0.0d;
        for (Creator next : this.creators) {
            double score = next.getScore(criteria);
            if (score > d10) {
                creator = next;
                d10 = score;
            }
        }
        return creator;
    }

    public List<Creator> getCreators() {
        return new ArrayList(this.creators);
    }

    public Object getInstance() {
        return this.primary.getInstance();
    }

    public Parameter getParameter(String str) {
        return (Parameter) this.registry.get(str);
    }

    public List<Parameter> getParameters() {
        return this.registry.getAll();
    }

    public boolean isDefault() {
        if (this.creators.size() > 1 || this.primary == null) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("creator for %s", new Object[]{this.detail});
    }

    public Object getInstance(Criteria criteria) {
        Creator creator = getCreator(criteria);
        if (creator != null) {
            return creator.getInstance(criteria);
        }
        throw new PersistenceException("Constructor not matched for %s", this.detail);
    }
}
