package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.stream.Format;

class AttributeParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public static class Contact extends ParameterContact<Attribute> {
        public Contact(Attribute attribute, Constructor constructor, int i10) {
            super(attribute, constructor, i10);
        }

        public String getName() {
            return ((Attribute) this.label).name();
        }
    }

    public AttributeParameter(Constructor constructor, Attribute attribute, Format format, int i10) {
        Contact contact2 = new Contact(attribute, constructor, i10);
        this.contact = contact2;
        AttributeLabel attributeLabel = new AttributeLabel(contact2, attribute, format);
        this.label = attributeLabel;
        this.expression = attributeLabel.getExpression();
        this.path = attributeLabel.getPath();
        this.type = attributeLabel.getType();
        this.name = attributeLabel.getName();
        this.key = attributeLabel.getKey();
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

    public boolean isAttribute() {
        return true;
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
