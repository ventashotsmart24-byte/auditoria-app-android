package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

class CompositeArray implements Converter {
    private final Type entry;
    private final ArrayFactory factory;
    private final String parent;
    private final Traverser root;
    private final Type type;

    public CompositeArray(Context context, Type type2, Type type3, String str) {
        this.factory = new ArrayFactory(context, type2);
        this.root = new Traverser(context);
        this.parent = str;
        this.entry = type3;
        this.type = type2;
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
        for (int i10 = 0; i10 < length; i10++) {
            this.root.write(outputNode, Array.get(obj, i10), this.entry.getType(), this.parent);
        }
        outputNode.commit();
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
                read(next, obj, i10);
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
            if (!next.isEmpty()) {
                this.root.validate(next, cls);
            }
        }
    }

    private void read(InputNode inputNode, Object obj, int i10) {
        Array.set(obj, i10, !inputNode.isEmpty() ? this.root.read(inputNode, this.entry.getType()) : null);
    }
}
