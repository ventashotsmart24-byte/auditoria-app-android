package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class Source implements Context {
    private TemplateEngine engine;
    private Filter filter;
    private Session session;
    private Strategy strategy;
    private Support support;

    public Source(Strategy strategy2, Support support2, Session session2) {
        TemplateFilter templateFilter = new TemplateFilter(this, support2);
        this.filter = templateFilter;
        this.engine = new TemplateEngine(templateFilter);
        this.strategy = strategy2;
        this.support = support2;
        this.session = session2;
    }

    private Scanner getScanner(Class cls) {
        return this.support.getScanner(cls);
    }

    public Object getAttribute(Object obj) {
        return this.session.get(obj);
    }

    public Caller getCaller(Class cls) {
        return getScanner(cls).getCaller(this);
    }

    public Decorator getDecorator(Class cls) {
        return getScanner(cls).getDecorator();
    }

    public Instance getInstance(Class cls) {
        return this.support.getInstance(cls);
    }

    public String getName(Class cls) {
        return this.support.getName(cls);
    }

    public Value getOverride(Type type, InputNode inputNode) {
        NodeMap<InputNode> attributes = inputNode.getAttributes();
        if (attributes != null) {
            return this.strategy.read(type, attributes, this.session);
        }
        throw new PersistenceException("No attributes for %s", inputNode);
    }

    public String getProperty(String str) {
        return this.engine.process(str);
    }

    public Schema getSchema(Class cls) {
        Scanner scanner = getScanner(cls);
        if (scanner != null) {
            return new ClassSchema(scanner, this);
        }
        throw new PersistenceException("Invalid schema class %s", cls);
    }

    public Session getSession() {
        return this.session;
    }

    public Style getStyle() {
        return this.support.getStyle();
    }

    public Support getSupport() {
        return this.support;
    }

    public Class getType(Type type, Object obj) {
        if (obj != null) {
            return obj.getClass();
        }
        return type.getType();
    }

    public Version getVersion(Class cls) {
        return getScanner(cls).getRevision();
    }

    public boolean isFloat(Class cls) {
        return Support.isFloat(cls);
    }

    public boolean isPrimitive(Class cls) {
        return this.support.isPrimitive(cls);
    }

    public boolean isStrict() {
        return this.session.isStrict();
    }

    public boolean setOverride(Type type, Object obj, OutputNode outputNode) {
        NodeMap<OutputNode> attributes = outputNode.getAttributes();
        if (attributes != null) {
            return this.strategy.write(type, obj, attributes, this.session);
        }
        throw new PersistenceException("No attributes for %s", outputNode);
    }

    public Instance getInstance(Value value) {
        return this.support.getInstance(value);
    }

    public boolean isFloat(Type type) {
        return isFloat(type.getType());
    }

    public boolean isPrimitive(Type type) {
        return isPrimitive(type.getType());
    }
}
