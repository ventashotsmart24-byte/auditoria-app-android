package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedHashMap;

class Collector implements Criteria {
    private final Registry alias = new Registry();
    private final Registry registry = new Registry();

    public static class Registry extends LinkedHashMap<Object, Variable> {
        private Registry() {
        }

        public Iterator<Object> iterator() {
            return keySet().iterator();
        }
    }

    public void commit(Object obj) {
        for (Variable variable : this.registry.values()) {
            variable.getContact().set(obj, variable.getValue());
        }
    }

    public Variable get(Object obj) {
        return (Variable) this.registry.get(obj);
    }

    public Iterator<Object> iterator() {
        return this.registry.iterator();
    }

    public Variable remove(Object obj) {
        return (Variable) this.registry.remove(obj);
    }

    public Variable resolve(String str) {
        return (Variable) this.alias.get(str);
    }

    public void set(Label label, Object obj) {
        Variable variable = new Variable(label, obj);
        if (label != null) {
            String[] paths = label.getPaths();
            Object key = label.getKey();
            for (String put : paths) {
                this.alias.put(put, variable);
            }
            this.registry.put(key, variable);
        }
    }

    public Variable get(Label label) {
        if (label == null) {
            return null;
        }
        return (Variable) this.registry.get(label.getKey());
    }
}
