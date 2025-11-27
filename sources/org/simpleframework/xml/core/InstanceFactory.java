package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class InstanceFactory {
    private final Cache<Constructor> cache = new ConcurrentCache();

    public class ClassInstance implements Instance {
        private Class type;
        private Object value;

        public ClassInstance(Class cls) {
            this.type = cls;
        }

        public Object getInstance() {
            if (this.value == null) {
                this.value = InstanceFactory.this.getObject(this.type);
            }
            return this.value;
        }

        public Class getType() {
            return this.type;
        }

        public boolean isReference() {
            return false;
        }

        public Object setInstance(Object obj) {
            this.value = obj;
            return obj;
        }
    }

    public class ValueInstance implements Instance {
        private final Class type;
        private final Value value;

        public ValueInstance(Value value2) {
            this.type = value2.getType();
            this.value = value2;
        }

        public Object getInstance() {
            if (this.value.isReference()) {
                return this.value.getValue();
            }
            Object object = InstanceFactory.this.getObject(this.type);
            Value value2 = this.value;
            if (value2 != null) {
                value2.setValue(object);
            }
            return object;
        }

        public Class getType() {
            return this.type;
        }

        public boolean isReference() {
            return this.value.isReference();
        }

        public Object setInstance(Object obj) {
            Value value2 = this.value;
            if (value2 != null) {
                value2.setValue(obj);
            }
            return obj;
        }
    }

    public Instance getInstance(Value value) {
        return new ValueInstance(value);
    }

    public Object getObject(Class cls) {
        Constructor fetch = this.cache.fetch(cls);
        if (fetch == null) {
            fetch = cls.getDeclaredConstructor(new Class[0]);
            if (!fetch.isAccessible()) {
                fetch.setAccessible(true);
            }
            this.cache.cache(cls, fetch);
        }
        return fetch.newInstance(new Object[0]);
    }

    public Instance getInstance(Class cls) {
        return new ClassInstance(cls);
    }
}
