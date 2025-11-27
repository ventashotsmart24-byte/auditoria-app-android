package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ElementMapLabel extends TemplateLabel {
    private Expression cache;
    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private Entry entry;
    private Format format;
    private boolean inline;
    private Class[] items;
    private ElementMap label;
    private String name;
    private String override;
    private String parent;
    private String path;
    private boolean required;
    private Class type;

    public ElementMapLabel(Contact contact, ElementMap elementMap, Format format2) {
        this.detail = new Introspector(contact, this, format2);
        this.decorator = new Qualifier(contact);
        this.entry = new Entry(contact, elementMap);
        this.required = elementMap.required();
        this.type = contact.getType();
        this.inline = elementMap.inline();
        this.override = elementMap.name();
        this.data = elementMap.data();
        this.format = format2;
        this.label = elementMap;
    }

    private Type getMap() {
        return new ClassType(this.type);
    }

    public Annotation getAnnotation() {
        return this.label;
    }

    public Contact getContact() {
        return this.detail.getContact();
    }

    public Converter getConverter(Context context) {
        Type map = getMap();
        if (!this.label.inline()) {
            return new CompositeMap(context, this.entry, map);
        }
        return new CompositeInlineMap(context, this.entry, map);
    }

    public Decorator getDecorator() {
        return this.decorator;
    }

    public Type getDependent() {
        Contact contact = getContact();
        if (this.items == null) {
            this.items = contact.getDependents();
        }
        Class[] clsArr = this.items;
        if (clsArr == null) {
            throw new ElementException("Unable to determine type for %s", contact);
        } else if (clsArr.length == 0) {
            return new ClassType(Object.class);
        } else {
            return new ClassType(clsArr[0]);
        }
    }

    public Object getEmpty(Context context) {
        MapFactory mapFactory = new MapFactory(context, new ClassType(this.type));
        if (!this.label.empty()) {
            return mapFactory.getInstance();
        }
        return null;
    }

    public String getEntry() {
        Style style = this.format.getStyle();
        if (this.detail.isEmpty(this.parent)) {
            this.parent = this.detail.getEntry();
        }
        return style.getElement(this.parent);
    }

    public Expression getExpression() {
        if (this.cache == null) {
            this.cache = this.detail.getExpression();
        }
        return this.cache;
    }

    public String getName() {
        if (this.name == null) {
            Style style = this.format.getStyle();
            String entry2 = this.entry.getEntry();
            if (!this.label.inline()) {
                entry2 = this.detail.getName();
            }
            this.name = style.getElement(entry2);
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
}
