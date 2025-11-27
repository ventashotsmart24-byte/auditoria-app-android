package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class PrimitiveValue implements Converter {
    private final Context context;
    private final Entry entry;
    private final PrimitiveFactory factory;
    private final Primitive root;
    private final Style style;
    private final Type type;

    public PrimitiveValue(Context context2, Entry entry2, Type type2) {
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
        if (str != null) {
            inputNode = inputNode.getAttribute(this.style.getAttribute(str));
        }
        if (inputNode == null) {
            return null;
        }
        return this.root.read(inputNode);
    }

    private Object readElement(InputNode inputNode, String str) {
        InputNode next = inputNode.getNext(this.style.getAttribute(str));
        if (next == null) {
            return null;
        }
        return this.root.read(next);
    }

    private boolean validateAttribute(InputNode inputNode, String str) {
        if (str != null) {
            inputNode = inputNode.getNext(this.style.getAttribute(str));
        }
        if (inputNode == null) {
            return true;
        }
        return this.root.validate(inputNode);
    }

    private boolean validateElement(InputNode inputNode, String str) {
        if (inputNode.getNext(this.style.getAttribute(str)) == null) {
            return true;
        }
        return this.root.validate(inputNode);
    }

    private void writeAttribute(OutputNode outputNode, Object obj, String str) {
        if (obj != null) {
            if (str != null) {
                outputNode = outputNode.setAttribute(this.style.getAttribute(str), (String) null);
            }
            this.root.write(outputNode, obj);
        }
    }

    private void writeElement(OutputNode outputNode, Object obj, String str) {
        OutputNode child = outputNode.getChild(this.style.getAttribute(str));
        if (obj != null && !isOverridden(child, obj)) {
            this.root.write(child, obj);
        }
    }

    public Object read(InputNode inputNode) {
        Class type2 = this.type.getType();
        String value = this.entry.getValue();
        if (this.entry.isInline()) {
            return readAttribute(inputNode, value);
        }
        if (value == null) {
            value = this.context.getName(type2);
        }
        return readElement(inputNode, value);
    }

    public boolean validate(InputNode inputNode) {
        Class type2 = this.type.getType();
        String value = this.entry.getValue();
        if (this.entry.isInline()) {
            return validateAttribute(inputNode, value);
        }
        if (value == null) {
            value = this.context.getName(type2);
        }
        return validateElement(inputNode, value);
    }

    public void write(OutputNode outputNode, Object obj) {
        Class type2 = this.type.getType();
        String value = this.entry.getValue();
        if (!this.entry.isInline()) {
            if (value == null) {
                value = this.context.getName(type2);
            }
            writeElement(outputNode, obj, value);
            return;
        }
        writeAttribute(outputNode, obj, value);
    }

    public Object read(InputNode inputNode, Object obj) {
        Class type2 = this.type.getType();
        if (obj == null) {
            return read(inputNode);
        }
        throw new PersistenceException("Can not read value of %s for %s", type2, this.entry);
    }
}
