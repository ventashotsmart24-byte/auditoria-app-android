package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.stream.Format;

class ElementUnionParameter extends TemplateParameter {
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

    public ElementUnionParameter(Constructor constructor, ElementUnion elementUnion, Element element, Format format, int i10) {
        Contact contact2 = new Contact(element, constructor, i10);
        this.contact = contact2;
        ElementUnionLabel elementUnionLabel = new ElementUnionLabel(contact2, elementUnion, element, format);
        this.label = elementUnionLabel;
        this.expression = elementUnionLabel.getExpression();
        this.path = elementUnionLabel.getPath();
        this.type = elementUnionLabel.getType();
        this.name = elementUnionLabel.getName();
        this.key = elementUnionLabel.getKey();
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
