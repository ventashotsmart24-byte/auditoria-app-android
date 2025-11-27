package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class EmptyExpression implements Expression {
    private final List<String> list = new LinkedList();
    private final Style style;

    public EmptyExpression(Format format) {
        this.style = format.getStyle();
    }

    public String getAttribute(String str) {
        return this.style.getAttribute(str);
    }

    public String getElement(String str) {
        return this.style.getElement(str);
    }

    public String getFirst() {
        return null;
    }

    public int getIndex() {
        return 0;
    }

    public String getLast() {
        return null;
    }

    public String getPath() {
        return "";
    }

    public String getPrefix() {
        return null;
    }

    public boolean isAttribute() {
        return false;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isPath() {
        return false;
    }

    public Iterator<String> iterator() {
        return this.list.iterator();
    }

    public Expression getPath(int i10) {
        return null;
    }

    public Expression getPath(int i10, int i11) {
        return null;
    }
}
