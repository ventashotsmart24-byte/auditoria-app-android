package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.strategy.Type;

class TextListLabel extends TemplateLabel {
    private final String empty;
    private final Label label;
    private final Text text;

    public TextListLabel(Label label2, Text text2) {
        this.empty = text2.empty();
        this.label = label2;
        this.text = text2;
    }

    public Annotation getAnnotation() {
        return this.label.getAnnotation();
    }

    public Contact getContact() {
        return this.label.getContact();
    }

    public Converter getConverter(Context context) {
        Contact contact = getContact();
        if (this.label.isCollection()) {
            return new TextList(context, contact, this.label);
        }
        throw new TextException("Cannot use %s to represent %s", contact, this.label);
    }

    public Decorator getDecorator() {
        return null;
    }

    public Type getDependent() {
        return this.label.getDependent();
    }

    public String getEntry() {
        return this.label.getEntry();
    }

    public Expression getExpression() {
        return this.label.getExpression();
    }

    public Object getKey() {
        return this.label.getKey();
    }

    public String getName() {
        return this.label.getName();
    }

    public String[] getNames() {
        return this.label.getNames();
    }

    public String getOverride() {
        return this.label.getOverride();
    }

    public String getPath() {
        return this.label.getPath();
    }

    public String[] getPaths() {
        return this.label.getPaths();
    }

    public Class getType() {
        return this.label.getType();
    }

    public boolean isCollection() {
        return true;
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

    public boolean isTextList() {
        return true;
    }

    public String toString() {
        return String.format("%s %s", new Object[]{this.text, this.label});
    }

    public String getEmpty(Context context) {
        return this.empty;
    }
}
