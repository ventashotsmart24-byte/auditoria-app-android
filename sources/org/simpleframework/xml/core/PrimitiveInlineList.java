package org.simpleframework.xml.core;

import java.util.Collection;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;

class PrimitiveInlineList implements Repeater {
    private final Type entry;
    private final CollectionFactory factory;
    private final String parent;
    private final Primitive root;

    public PrimitiveInlineList(Context context, Type type, Type type2, String str) {
        this.factory = new CollectionFactory(context, type);
        this.root = new Primitive(context, type2);
        this.parent = str;
        this.entry = type2;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj) {
        return this.factory.setOverride(this.entry, obj, outputNode);
    }

    public Object read(InputNode inputNode) {
        Collection collection = (Collection) this.factory.getInstance();
        if (collection != null) {
            return read(inputNode, collection);
        }
        return null;
    }

    public boolean validate(InputNode inputNode) {
        InputNode parent2 = inputNode.getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            if (!this.root.validate(inputNode)) {
                return false;
            }
            inputNode = parent2.getNext(name);
        }
        return true;
    }

    public void write(OutputNode outputNode, Object obj) {
        OutputNode parent2 = outputNode.getParent();
        Mode mode = outputNode.getMode();
        if (!outputNode.isCommitted()) {
            outputNode.remove();
        }
        write(parent2, obj, mode);
    }

    public Object read(InputNode inputNode, Object obj) {
        Collection collection = (Collection) obj;
        if (collection != null) {
            return read(inputNode, collection);
        }
        return read(inputNode);
    }

    private void write(OutputNode outputNode, Object obj, Mode mode) {
        for (Object next : (Collection) obj) {
            if (next != null) {
                OutputNode child = outputNode.getChild(this.parent);
                if (!isOverridden(child, next)) {
                    child.setMode(mode);
                    this.root.write(child, next);
                }
            }
        }
    }

    private Object read(InputNode inputNode, Collection collection) {
        InputNode parent2 = inputNode.getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            Object read = this.root.read(inputNode);
            if (read != null) {
                collection.add(read);
            }
            inputNode = parent2.getNext(name);
        }
        return collection;
    }
}
