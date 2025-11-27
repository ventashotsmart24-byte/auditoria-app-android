package org.simpleframework.xml.core;

import java.util.Collection;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class TextList implements Repeater {
    private final CollectionFactory factory;
    private final Primitive primitive;
    private final Type type;

    public TextList(Context context, Type type2, Label label) {
        ClassType classType = new ClassType(String.class);
        this.type = classType;
        this.factory = new CollectionFactory(context, type2);
        this.primitive = new Primitive(context, classType);
    }

    public Object read(InputNode inputNode) {
        Instance instance = this.factory.getInstance(inputNode);
        Object instance2 = instance.getInstance();
        if (instance.isReference()) {
            return instance.getInstance();
        }
        return read(inputNode, instance2);
    }

    public boolean validate(InputNode inputNode) {
        return true;
    }

    public void write(OutputNode outputNode, Object obj) {
        OutputNode parent = outputNode.getParent();
        for (Object write : (Collection) obj) {
            this.primitive.write(parent, write);
        }
    }

    public Object read(InputNode inputNode, Object obj) {
        Collection collection = (Collection) obj;
        Object read = this.primitive.read(inputNode);
        if (read != null) {
            collection.add(read);
        }
        return obj;
    }
}
