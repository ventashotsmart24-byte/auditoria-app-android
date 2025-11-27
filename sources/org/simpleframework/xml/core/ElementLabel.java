package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

class ElementLabel extends TemplateLabel {
    private Expression cache;
    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private Class expect;
    private Format format;
    private Element label;
    private String name;
    private String override;
    private String path;
    private boolean required;
    private Class type;

    public ElementLabel(Contact contact, Element element, Format format2) {
        this.detail = new Introspector(contact, this, format2);
        this.decorator = new Qualifier(contact);
        this.required = element.required();
        this.type = contact.getType();
        this.override = element.name();
        this.expect = element.type();
        this.data = element.data();
        this.format = format2;
        this.label = element;
    }

    public Annotation getAnnotation() {
        return this.label;
    }

    public Contact getContact() {
        return this.detail.getContact();
    }

    public Converter getConverter(Context context) {
        Contact contact = getContact();
        if (context.isPrimitive((Type) contact)) {
            return new Primitive(context, contact);
        }
        Class cls = this.expect;
        if (cls == Void.TYPE) {
            return new Composite(context, contact);
        }
        return new Composite(context, contact, cls);
    }

    public Decorator getDecorator() {
        return this.decorator;
    }

    public Object getEmpty(Context context) {
        return null;
    }

    public Expression getExpression() {
        if (this.cache == null) {
            this.cache = this.detail.getExpression();
        }
        return this.cache;
    }

    public String getName() {
        if (this.name == null) {
            this.name = this.format.getStyle().getElement(this.detail.getName());
        }
        return this.name;
    }

    public String getOverride() {
        return this.override;
    }

    public String getPath() {
        if (this.path == null) {
            this.path = getExpression().getElement(getName());
        }
        return this.path;
    }

    public Type getType(Class cls) {
        Contact contact = getContact();
        Class cls2 = this.expect;
        if (cls2 == Void.TYPE) {
            return contact;
        }
        return new OverrideType(contact, cls2);
    }

    public boolean isData() {
        return this.data;
    }

    public boolean isRequired() {
        return this.required;
    }

    public String toString() {
        return this.detail.toString();
    }

    public Class getType() {
        Class cls = this.expect;
        return cls == Void.TYPE ? this.type : cls;
    }
}
