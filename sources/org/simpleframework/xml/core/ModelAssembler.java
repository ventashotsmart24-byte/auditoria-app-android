package org.simpleframework.xml.core;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.stream.Format;

class ModelAssembler {
    private final ExpressionBuilder builder;
    private final Detail detail;
    private final Format format;

    public ModelAssembler(ExpressionBuilder expressionBuilder, Detail detail2, Support support) {
        this.format = support.getFormat();
        this.builder = expressionBuilder;
        this.detail = detail2;
    }

    private void assembleAttributes(Model model, Order order) {
        String[] attributes = order.attributes();
        int length = attributes.length;
        int i10 = 0;
        while (i10 < length) {
            String str = attributes[i10];
            Expression build = this.builder.build(str);
            if (build.isAttribute() || !build.isPath()) {
                if (!build.isPath()) {
                    model.registerAttribute(this.format.getStyle().getAttribute(str));
                } else {
                    registerAttributes(model, build);
                }
                i10++;
            } else {
                throw new PathException("Ordered attribute '%s' references an element in %s", build, this.detail);
            }
        }
    }

    private void assembleElements(Model model, Order order) {
        String[] elements = order.elements();
        int length = elements.length;
        int i10 = 0;
        while (i10 < length) {
            Expression build = this.builder.build(elements[i10]);
            if (!build.isAttribute()) {
                registerElements(model, build);
                i10++;
            } else {
                throw new PathException("Ordered element '%s' references an attribute in %s", build, this.detail);
            }
        }
    }

    private void registerAttribute(Model model, Expression expression) {
        String first = expression.getFirst();
        if (first != null) {
            model.registerAttribute(first);
        }
    }

    private void registerAttributes(Model model, Expression expression) {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (expression.isPath()) {
            Model register = model.register(first, prefix, index);
            Expression path = expression.getPath(1);
            if (register != null) {
                registerAttributes(register, path);
            } else {
                throw new PathException("Element '%s' does not exist in %s", first, this.detail);
            }
        } else {
            registerAttribute(model, expression);
        }
    }

    private void registerElement(Model model, Expression expression) {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (index <= 1 || model.lookup(first, index - 1) != null) {
            model.register(first, prefix, index);
        } else {
            throw new PathException("Ordered element '%s' in path '%s' is out of sequence for %s", first, expression, this.detail);
        }
    }

    private void registerElements(Model model, Expression expression) {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (first != null) {
            Model register = model.register(first, prefix, index);
            Expression path = expression.getPath(1);
            if (expression.isPath()) {
                registerElements(register, path);
            }
        }
        registerElement(model, expression);
    }

    public void assemble(Model model, Order order) {
        assembleElements(model, order);
        assembleAttributes(model, order);
    }
}
