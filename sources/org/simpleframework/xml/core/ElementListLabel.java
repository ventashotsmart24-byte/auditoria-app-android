package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ElementListLabel extends TemplateLabel {
    private Expression cache;
    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private String entry;
    private Format format;
    private boolean inline;
    private Class item;
    private ElementList label;
    private String name;
    private String override;
    private String path;
    private boolean required;
    private Class type;

    public ElementListLabel(Contact contact, ElementList elementList, Format format2) {
        this.detail = new Introspector(contact, this, format2);
        this.decorator = new Qualifier(contact);
        this.required = elementList.required();
        this.type = contact.getType();
        this.override = elementList.name();
        this.inline = elementList.inline();
        this.entry = elementList.entry();
        this.data = elementList.data();
        this.item = elementList.type();
        this.format = format2;
        this.label = elementList;
    }

    private Converter getInlineConverter(Context context, String str) {
        Type dependent = getDependent();
        Contact contact = getContact();
        if (!context.isPrimitive(dependent)) {
            return new CompositeInlineList(context, contact, dependent, str);
        }
        return new PrimitiveInlineList(context, contact, dependent, str);
    }

    public Annotation getAnnotation() {
        return this.label;
    }

    public Contact getContact() {
        return this.detail.getContact();
    }

    public Converter getConverter(Context context) {
        String entry2 = getEntry();
        if (!this.label.inline()) {
            return getConverter(context, entry2);
        }
        return getInlineConverter(context, entry2);
    }

    public Decorator getDecorator() {
        return this.decorator;
    }

    public Type getDependent() {
        Contact contact = getContact();
        if (this.item == Void.TYPE) {
            this.item = contact.getDependent();
        }
        Class cls = this.item;
        if (cls != null) {
            return new ClassType(cls);
        }
        throw new ElementException("Unable to determine generic type for %s", contact);
    }

    public Object getEmpty(Context context) {
        CollectionFactory collectionFactory = new CollectionFactory(context, new ClassType(this.type));
        if (!this.label.empty()) {
            return collectionFactory.getInstance();
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

    public Class getType() {
        return this.type;
    }

    public boolean isCollection() {
        return true;
    }

    public boolean isData() {
        return this.data;
    }

    public boolean isInline() {
        return this.inline;
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
            return new CompositeList(context, contact, dependent, str);
        }
        return new PrimitiveList(context, contact, dependent, str);
    }
}
