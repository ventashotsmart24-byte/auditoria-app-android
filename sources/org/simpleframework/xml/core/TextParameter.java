package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

class TextParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public static class Contact extends ParameterContact<Text> {
        public Contact(Text text, Constructor constructor, int i10) {
            super(text, constructor, i10);
        }

        public String getName() {
            return "";
        }
    }

    public TextParameter(Constructor constructor, Text text, Format format, int i10) {
        Contact contact2 = new Contact(text, constructor, i10);
        this.contact = contact2;
        TextLabel textLabel = new TextLabel(contact2, text, format);
        this.label = textLabel;
        this.expression = textLabel.getExpression();
        this.path = textLabel.getPath();
        this.type = textLabel.getType();
        this.name = textLabel.getName();
        this.key = textLabel.getKey();
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

    public boolean isText() {
        return true;
    }

    public String toString() {
        return this.contact.toString();
    }

    public String getName(Context context) {
        return getName();
    }

    public String getPath(Context context) {
        return getPath();
    }
}
