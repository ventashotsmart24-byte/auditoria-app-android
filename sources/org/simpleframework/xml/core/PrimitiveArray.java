package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

class PrimitiveArray implements Converter {
    private final Type entry;
    private final ArrayFactory factory;
    private final String parent;
    private final Primitive root;
    private final Type type;

    public PrimitiveArray(Context context, Type type2, Type type3, String str) {
        this.factory = new ArrayFactory(context, type2);
        this.root = new Primitive(context, type3);
        this.parent = str;
        this.entry = type3;
        this.type = type2;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj) {
        return this.factory.setOverride(this.entry, obj, outputNode);
    }

    public Object read(InputNode inputNode) {
        Instance instance = this.factory.getInstance(inputNode);
        Object instance2 = instance.getInstance();
        return !instance.isReference() ? read(inputNode, instance2) : instance2;
    }

    public boolean validate(InputNode inputNode) {
        Instance instance = this.factory.getInstance(inputNode);
        if (instance.isReference()) {
            return true;
        }
        instance.setInstance((Object) null);
        return validate(inputNode, instance.getType());
    }

    public void write(OutputNode outputNode, Object obj) {
        int length = Array.getLength(obj);
        int i10 = 0;
        while (i10 < length) {
            OutputNode child = outputNode.getChild(this.parent);
            if (child != null) {
                write(child, obj, i10);
                i10++;
            } else {
                return;
            }
        }
    }

    private void write(OutputNode outputNode, Object obj, int i10) {
        Object obj2 = Array.get(obj, i10);
        if (obj2 != null && !isOverridden(outputNode, obj2)) {
            this.root.write(outputNode, obj2);
        }
    }

    public Object read(InputNode inputNode, Object obj) {
        int length = Array.getLength(obj);
        int i10 = 0;
        while (true) {
            Position position = inputNode.getPosition();
            InputNode next = inputNode.getNext();
            if (next == null) {
                return obj;
            }
            if (i10 < length) {
                Array.set(obj, i10, this.root.read(next));
                i10++;
            } else {
                throw new ElementException("Array length missing or incorrect for %s at %s", this.type, position);
            }
        }
    }

    private boolean validate(InputNode inputNode, Class cls) {
        while (true) {
            InputNode next = inputNode.getNext();
            if (next == null) {
                return true;
            }
            this.root.validate(next);
        }
    }
}
