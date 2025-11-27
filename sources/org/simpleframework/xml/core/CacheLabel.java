package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

class CacheLabel implements Label {
    private final Annotation annotation;
    private final boolean attribute;
    private final boolean collection;
    private final Contact contact;
    private final boolean data;
    private final Decorator decorator;
    private final Type depend;
    private final String entry;
    private final Expression expression;
    private final boolean inline;
    private final Object key;
    private final Label label;
    private final boolean list;
    private final String name;
    private final String[] names;
    private final String override;
    private final String path;
    private final String[] paths;
    private final boolean required;
    private final boolean text;
    private final Class type;
    private final boolean union;

    public CacheLabel(Label label2) {
        this.annotation = label2.getAnnotation();
        this.expression = label2.getExpression();
        this.decorator = label2.getDecorator();
        this.attribute = label2.isAttribute();
        this.collection = label2.isCollection();
        this.contact = label2.getContact();
        this.depend = label2.getDependent();
        this.required = label2.isRequired();
        this.override = label2.getOverride();
        this.list = label2.isTextList();
        this.inline = label2.isInline();
        this.union = label2.isUnion();
        this.names = label2.getNames();
        this.paths = label2.getPaths();
        this.path = label2.getPath();
        this.type = label2.getType();
        this.name = label2.getName();
        this.entry = label2.getEntry();
        this.data = label2.isData();
        this.text = label2.isText();
        this.key = label2.getKey();
        this.label = label2;
    }

    public Annotation getAnnotation() {
        return this.annotation;
    }

    public Contact getContact() {
        return this.contact;
    }

    public Converter getConverter(Context context) {
        return this.label.getConverter(context);
    }

    public Decorator getDecorator() {
        return this.decorator;
    }

    public Type getDependent() {
        return this.depend;
    }

    public Object getEmpty(Context context) {
        return this.label.getEmpty(context);
    }

    public String getEntry() {
        return this.entry;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public Object getKey() {
        return this.key;
    }

    public Label getLabel(Class cls) {
        return this.label.getLabel(cls);
    }

    public String getName() {
        return this.name;
    }

    public String[] getNames() {
        return this.names;
    }

    public String getOverride() {
        return this.override;
    }

    public String getPath() {
        return this.path;
    }

    public String[] getPaths() {
        return this.paths;
    }

    public Type getType(Class cls) {
        return this.label.getType(cls);
    }

    public boolean isAttribute() {
        return this.attribute;
    }

    public boolean isCollection() {
        return this.collection;
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

    public boolean isText() {
        return this.text;
    }

    public boolean isTextList() {
        return this.list;
    }

    public boolean isUnion() {
        return this.union;
    }

    public String toString() {
        return this.label.toString();
    }

    public Class getType() {
        return this.type;
    }
}
