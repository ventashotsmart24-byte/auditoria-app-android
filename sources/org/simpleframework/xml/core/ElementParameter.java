package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.stream.Format;

class ElementParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public static class Contact extends ParameterContact<Element> {
        public Contact(Element element, Constructor constructor, int i10) {
            super(element, constructor, i10);
        }

        public String getName() {
            return ((Element) this.label).name();
        }
    }

    public ElementParameter(Constructor constructor, Element element, Format format, int i10) {
        Contact contact2 = new Contact(element, constructor, i10);
        this.contact = contact2;
        ElementLabel elementLabel = new ElementLabel(contact2, element, format);
        this.label = elementLabel;
        this.expression = elementLabel.getExpression();
        this.path = elementLabel.getPath();
        this.type = elementLabel.getType();
        this.name = elementLabel.getName();
        this.key = elementLabel.getKey();
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
