package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.stream.Format;

class ElementArrayParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public static class Contact extends ParameterContact<ElementArray> {
        public Contact(ElementArray elementArray, Constructor constructor, int i10) {
            super(elementArray, constructor, i10);
        }

        public String getName() {
            return ((ElementArray) this.label).name();
        }
    }

    public ElementArrayParameter(Constructor constructor, ElementArray elementArray, Format format, int i10) {
        Contact contact2 = new Contact(elementArray, constructor, i10);
        this.contact = contact2;
        ElementArrayLabel elementArrayLabel = new ElementArrayLabel(contact2, elementArray, format);
        this.label = elementArrayLabel;
        this.expression = elementArrayLabel.getExpression();
        this.path = elementArrayLabel.getPath();
        this.type = elementArrayLabel.getType();
        this.name = elementArrayLabel.getName();
        this.key = elementArrayLabel.getKey();
        this.index = i10;
    }

    public Annotation getAnnotation() {
        return this.contact.getAnnotation();
    }

    public Expression getExpression() {
        return this.expression;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public Class getType() {
        return this.type;
    }

    public boolean isPrimitive() {
        return this.type.isPrimitive();
    }

    public boolean isRequired() {
        return this.label.isRequired();
    }

    public String toString() {
        return this.contact.toString();
    }
}
