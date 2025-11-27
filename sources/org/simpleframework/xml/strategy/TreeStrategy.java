package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.Map;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

public class TreeStrategy implements Strategy {
    private final String label;
    private final String length;
    private final Loader loader;

    public TreeStrategy() {
        this(Name.LABEL, "length");
    }

    private Value readArray(Class cls, NodeMap nodeMap) {
        int i10;
        Node remove = nodeMap.remove(this.length);
        if (remove != null) {
            i10 = Integer.parseInt(remove.getValue());
        } else {
            i10 = 0;
        }
        return new ArrayValue(cls, i10);
    }

    private Class readValue(Type type, NodeMap nodeMap) {
        Node remove = nodeMap.remove(this.label);
        Class<?> type2 = type.getType();
        if (type2.isArray()) {
            type2 = type2.getComponentType();
        }
        if (remove == null) {
            return type2;
        }
        return this.loader.load(remove.getValue());
    }

    private Class writeArray(Class cls, Object obj, NodeMap nodeMap) {
        int length2 = Array.getLength(obj);
        String str = this.length;
        if (str != null) {
            nodeMap.put(str, String.valueOf(length2));
        }
        return cls.getComponentType();
    }

    public Value read(Type type, NodeMap nodeMap, Map map) {
        Class readValue = readValue(type, nodeMap);
        Class type2 = type.getType();
        if (type2.isArray()) {
            return readArray(readValue, nodeMap);
        }
        if (type2 != readValue) {
            return new ObjectValue(readValue);
        }
        return null;
    }

    public boolean write(Type type, Object obj, NodeMap nodeMap, Map map) {
        Class<?> cls;
        Class<?> cls2 = obj.getClass();
        Class<?> type2 = type.getType();
        if (cls2.isArray()) {
            cls = writeArray(type2, obj, nodeMap);
        } else {
            cls = cls2;
        }
        if (cls2 == type2) {
            return false;
        }
        nodeMap.put(this.label, cls.getName());
        return false;
    }

    public TreeStrategy(String str, String str2) {
        this.loader = new Loader();
        this.length = str2;
        this.label = str;
    }
}
