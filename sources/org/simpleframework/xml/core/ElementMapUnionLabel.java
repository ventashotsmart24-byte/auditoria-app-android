package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

class ElementMapUnionLabel extends TemplateLabel {
    private Contact contact;
    private GroupExtractor extractor;
    private Label label;
    private Expression path;

    public ElementMapUnionLabel(Contact contact2, ElementMapUnion elementMapUnion, ElementMap elementMap, Format format) {
        this.extractor = new GroupExtractor(contact2, elementMapUnion, format);
        this.label = new ElementMapLabel(contact2, elementMap, format);
        this.contact = contact2;
    }

    public Annotation getAnnotation() {
        return this.label.getAnnotation();
    }

    public Contact getContact() {
        return this.contact;
    }

    public Converter getConverter(Context context) {
        Expression expression = getExpression();
        Contact contact2 = getContact();
        if (contact2 != null) {
            return new CompositeMapUnion(context, this.extractor, expression, contact2);
        }
        throw new UnionException("Union %s was not declared on a field or method", this.label);
    }

    public Decorator getDecorator() {
        return this.label.getDecorator();
    }

    public Type getDependent() {
        return this.label.getDependent();
    }

    public Object getEmpty(Context context) {
        return this.label.getEmpty(context);
    }

    public String getEntry() {
        return this.label.getEntry();
    }

    public Expression getExpression() {
        if (this.path == null) {
            this.path = this.label.getExpression();
        }
        return this.path;
    }

    public Label getLabel(Class cls) {
        return this;
    }

    public String getName() {
        return this.label.getName();
    }

    public String[] getNames() {
        return this.extractor.getNames();
    }

    public String getOverride() {
        return this.label.getOverride();
    }

    public String getPath() {
        return this.label.getPath();
    }

    public String[] getPaths() {
        return this.extractor.getPaths();
    }

    public Type getType(Class cls) {
        return getContact();
    }

    public boolean isCollection() {
        return this.label.isCollection();
    }

    public boolean isData() {
        return this.label.isData();
    }

    public boolean isInline() {
        return this.label.isInline();
    }

    public boolean isRequired() {
        return this.label.isRequired();
    }

    public boolean isUnion() {
        return true;
    }

    public String toString() {
        return this.label.toString();
    }

    public Class getType() {
        return this.label.getType();
    }
}
