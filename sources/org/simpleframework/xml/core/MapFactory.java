package org.simpleframework.xml.core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

class MapFactory extends Factory {
    public MapFactory(Context context, Type type) {
        super(context, type);
    }

    private boolean isMap(Class cls) {
        return Map.class.isAssignableFrom(cls);
    }

    public Class getConversion(Class cls) {
        Class<HashMap> cls2 = HashMap.class;
        if (cls.isAssignableFrom(cls2)) {
            return cls2;
        }
        Class<TreeMap> cls3 = TreeMap.class;
        if (cls.isAssignableFrom(cls3)) {
            return cls3;
        }
        throw new InstantiationException("Cannot instantiate %s for %s", cls, this.type);
    }

    public Object getInstance() {
        Class type = getType();
        Class conversion = !Factory.isInstantiable(type) ? getConversion(type) : type;
        if (isMap(conversion)) {
            return conversion.newInstance();
        }
        throw new InstantiationException("Invalid map %s for %s", type, this.type);
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
        if (isMap(type)) {
            return this.context.getInstance(type);
        }
        throw new InstantiationException("Invalid map %s for %s", type, this.type);
    }

    public Instance getInstance(Value value) {
        Class type = value.getType();
        if (!Factory.isInstantiable(type)) {
            type = getConversion(type);
        }
        if (isMap(type)) {
            return new ConversionInstance(this.context, value, type);
        }
        throw new InstantiationException("Invalid map %s for %s", type, this.type);
    }
}
