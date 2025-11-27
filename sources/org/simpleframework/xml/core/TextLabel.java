package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

class TextLabel extends TemplateLabel {
    private Contact contact;
    private boolean data;
    private Introspector detail;
    private String empty;
    private Text label;
    private Expression path;
    private boolean required;
    private Class type;

    public TextLabel(Contact contact2, Text text, Format format) {
        this.detail = new Introspector(contact2, this, format);
        this.required = text.required();
        this.type = contact2.getType();
        this.empty = text.empty();
        this.data = text.data();
        this.contact = contact2;
        this.label = text;
    }

    public Annotation getAnnotation() {
        return this.label;
    }

    public Contact getContact() {
        return this.contact;
    }

    public Converter getConverter(Context context) {
        String empty2 = getEmpty(context);
        Contact contact2 = getContact();
        if (context.isPrimitive((Type) contact2)) {
            return new Primitive(context, contact2, empty2);
        }
        throw new TextException("Cannot use %s to represent %s", contact2, this.label);
    }

    public Decorator getDecorator() {
        return null;
    }

    public Expression getExpression() {
        if (this.path == null) {
            this.path = this.detail.getExpression();
        }
        return this.path;
    }

    public String getName() {
        return "";
    }

    public String getOverride() {
        return this.contact.toString();
    }

    public String getPath() {
        return getExpression().getPath();
    }

    public Class getType() {
        return this.type;
    }

    public boolean isData() {
        return this.data;
    }

    public boolean isInline() {
        return true;
    }

    public boolean isRequired() {
        return this.required;
    }

    public boolean isText() {
        return true;
    }

    public String toString() {
        return this.detail.toString();
    }

    public String getEmpty(Context context) {
        if (this.detail.isEmpty(this.empty)) {
            return null;
        }
        return this.empty;
    }
}
