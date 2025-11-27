package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ElementArrayLabel extends TemplateLabel {
    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private String entry;
    private Format format;
    private ElementArray label;
    private String name;
    private Expression path;
    private boolean required;
    private Class type;

    public ElementArrayLabel(Contact contact, ElementArray elementArray, Format format2) {
        this.detail = new Introspector(contact, this, format2);
        this.decorator = new Qualifier(contact);
        this.required = elementArray.required();
        this.type = contact.getType();
        this.entry = elementArray.entry();
        this.data = elementArray.data();
        this.name = elementArray.name();
        this.format = format2;
        this.label = elementArray;
    }

    public Annotation getAnnotation() {
        return this.label;
    }

    public Contact getContact() {
        return this.detail.getContact();
    }

    public Converter getConverter(Context context) {
        Contact contact = getContact();
        String entry2 = getEntry();
        if (this.type.isArray()) {
            return getConverter(context, entry2);
        }
        throw new InstantiationException("Type is not an array %s for %s", this.type, contact);
    }

    public Decorator getDecorator() {
        return this.decorator;
    }

    public Type getDependent() {
        Class<?> componentType = this.type.getComponentType();
        if (componentType == null) {
            return new ClassType(this.type);
        }
        return new ClassType(componentType);
    }

    public Object getEmpty(Context context) {
        ArrayFactory arrayFactory = new ArrayFactory(context, new ClassType(this.type));
        if (!this.label.empty()) {
            return arrayFactory.getInstance();
        }
        return null;
    }

    public String getEntry() {
        Style style = this.format.getStyle();
        if (this.detail.isEmpty(this.entry)) {
            this.entry = this.detail.getEntry();
        }
        return style.getElement(this.entry);
    }

    public Expression getExpression() {
        if (this.path == null) {
            this.path = this.detail.getExpression();
        }
        return this.path;
    }

    public String getName() {
        return this.format.getStyle().getElement(this.detail.getName());
    }

    public String getOverride() {
        return this.name;
    }

    public String getPath() {
        return getExpression().getElement(getName());
    }

    public Class getType() {
        return this.type;
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

    private Converter getConverter(Context context, String str) {
        Type dependent = getDependent();
        Contact contact = getContact();
        if (!context.isPrimitive(dependent)) {
            return new CompositeArray(context, contact, dependent, str);
        }
        return new PrimitiveArray(context, contact, dependent, str);
    }
}
