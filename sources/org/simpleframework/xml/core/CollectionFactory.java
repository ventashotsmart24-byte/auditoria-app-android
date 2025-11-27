package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

class CollectionFactory extends Factory {
    public CollectionFactory(Context context, Type type) {
        super(context, type);
    }

    private boolean isCollection(Class cls) {
        return Collection.class.isAssignableFrom(cls);
    }

    public Class getConversion(Class cls) {
        Class<ArrayList> cls2 = ArrayList.class;
        if (cls.isAssignableFrom(cls2)) {
            return cls2;
        }
        Class<HashSet> cls3 = HashSet.class;
        if (cls.isAssignableFrom(cls3)) {
            return cls3;
        }
        Class<TreeSet> cls4 = TreeSet.class;
        if (cls.isAssignableFrom(cls4)) {
            return cls4;
        }
        throw new InstantiationException("Cannot instantiate %s for %s", cls, this.type);
    }

    public Object getInstance() {
        Class type = getType();
        Class conversion = !Factory.isInstantiable(type) ? getConversion(type) : type;
        if (isCollection(conversion)) {
            return conversion.newInstance();
        }
        throw new InstantiationException("Invalid collection %s for %s", type, this.type);
    }

    public Instance getInstance(InputNode inputNode) {
        Value override = getOverride(inputNode);
        Class type = getType();
        if (override != null) {
            return getInstance(override);
        }
        if (!Factory.isInstantiable(type)) {
            type = getConversion(type);
        }
        if (isCollection(type)) {
            return this.context.getInstance(type);
        }
        throw new InstantiationException("Invalid collection %s for %s", type, this.type);
    }

    public Instance getInstance(Value value) {
        Class type = value.getType();
        if (!Factory.isInstantiable(type)) {
            type = getConversion(type);
        }
        if (isCollection(type)) {
            return new ConversionInstance(this.context, value, type);
        }
        throw new InstantiationException("Invalid collection %s for %s", type, this.type);
    }
}
