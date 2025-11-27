package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class PrimitiveKey implements Converter {
    private final Context context;
    private final Entry entry;
    private final PrimitiveFactory factory;
    private final Primitive root;
    private final Style style;
    private final Type type;

    public PrimitiveKey(Context context2, Entry entry2, Type type2) {
        this.factory = new PrimitiveFactory(context2, type2);
        this.root = new Primitive(context2, type2);
        this.style = context2.getStyle();
        this.context = context2;
        this.entry = entry2;
        this.type = type2;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj) {
        return this.factory.setOverride(this.type, obj, outputNode);
    }

    private Object readAttribute(InputNode inputNode, String str) {
        InputNode attribute = inputNode.getAttribute(this.style.getAttribute(str));
        if (attribute == null) {
            return null;
        }
        return this.root.read(attribute);
    }

    private Object readElement(InputNode inputNode, String str) {
        InputNode next = inputNode.getNext(this.style.getElement(str));
        if (next == null) {
            return null;
        }
        return this.root.read(next);
    }

    private boolean validateAttribute(InputNode inputNode, String str) {
        InputNode attribute = inputNode.getAttribute(this.style.getElement(str));
        if (attribute == null) {
            return true;
        }
        return this.root.validate(attribute);
    }

    private boolean validateElement(InputNode inputNode, String str) {
        InputNode next = inputNode.getNext(this.style.getElement(str));
        if (next == null) {
            return true;
        }
        return this.root.validate(next);
    }

    private void writeAttribute(OutputNode outputNode, Object obj) {
        Class type2 = this.type.getType();
        String text = this.factory.getText(obj);
        String key = this.entry.getKey();
        if (key == null) {
            key = this.context.getName(type2);
        }
        String attribute = this.style.getAttribute(key);
        if (text != null) {
            outputNode.setAttribute(attribute, text);
        }
    }

    private void writeElement(OutputNode outputNode, Object obj) {
        Class type2 = this.type.getType();
        String key = this.entry.getKey();
        if (key == null) {
            key = this.context.getName(type2);
        }
        OutputNode child = outputNode.getChild(this.style.getElement(key));
        if (obj != null && !isOverridden(child, obj)) {
            this.root.write(child, obj);
        }
    }

    public Object read(InputNode inputNode) {
        Class type2 = this.type.getType();
        String key = this.entry.getKey();
        if (key == null) {
            key = this.context.getName(type2);
        }
        if (!this.entry.isAttribute()) {
            return readElement(inputNode, key);
        }
        return readAttribute(inputNode, key);
    }

    public boolean validate(InputNode inputNode) {
        Class type2 = this.type.getType();
        String key = this.entry.getKey();
        if (key == null) {
            key = this.context.getName(type2);
        }
        if (!this.entry.isAttribute()) {
            return validateElement(inputNode, key);
        }
        return validateAttribute(inputNode, key);
    }

    public void write(OutputNode outputNode, Object obj) {
        if (!this.entry.isAttribute()) {
            writeElement(outputNode, obj);
        } else if (obj != null) {
            writeAttribute(outputNode, obj);
        }
    }

    public Object read(InputNode inputNode, Object obj) {
        Class type2 = this.type.getType();
        if (obj == null) {
            return read(inputNode);
        }
        throw new PersistenceException("Can not read key of %s for %s", type2, this.entry);
    }
}
