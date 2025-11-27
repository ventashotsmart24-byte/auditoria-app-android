package io.jsonwebtoken.impl;

import io.jsonwebtoken.impl.lang.Nameable;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.impl.lang.RedactedSupplier;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ParameterMap implements Map<String, Object>, ParameterReadable, Nameable {
    protected final Registry<String, ? extends Parameter<?>> PARAMS;
    protected final Map<String, Object> idiomaticValues;
    private final boolean initialized;
    private final boolean mutable;
    protected final Map<String, Object> values;

    public class EntryIterator extends ParameterMapIterator<Map.Entry<String, Object>> {
        private EntryIterator() {
            super();
        }

        public Map.Entry<String, Object> next() {
            return nextEntry();
        }
    }

    public class EntrySet extends ParameterMapSet<Map.Entry<String, Object>> {
        private EntrySet() {
            super();
        }

        public Iterator<Map.Entry<String, Object>> iterator() {
            return new EntryIterator();
        }
    }

    public class KeyIterator extends ParameterMapIterator<String> {
        private KeyIterator() {
            super();
        }

        public String next() {
            return nextEntry().getKey();
        }
    }

    public class KeySet extends ParameterMapSet<String> {
        private KeySet() {
            super();
        }

        public Iterator<String> iterator() {
            return new KeyIterator();
        }
    }

    public abstract class ParameterMapIterator<T> implements Iterator<T> {
        transient Map.Entry<String, Object> current = null;

        /* renamed from: i  reason: collision with root package name */
        final Iterator<Map.Entry<String, Object>> f17464i;

        public ParameterMapIterator() {
            this.f17464i = ParameterMap.this.values.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.f17464i.hasNext();
        }

        public Map.Entry<String, Object> nextEntry() {
            Map.Entry<String, Object> next = this.f17464i.next();
            this.current = next;
            return next;
        }

        public void remove() {
            Map.Entry<String, Object> entry = this.current;
            if (entry != null) {
                ParameterMap.this.remove(entry.getKey());
                return;
            }
            throw new IllegalStateException();
        }
    }

    public abstract class ParameterMapSet<T> extends AbstractSet<T> {
        private ParameterMapSet() {
        }

        public int size() {
            return ParameterMap.this.size();
        }
    }

    public class ValueIterator extends ParameterMapIterator<Object> {
        private ValueIterator() {
            super();
        }

        public Object next() {
            return nextEntry().getValue();
        }
    }

    public class ValueSet extends ParameterMapSet<Object> {
        private ValueSet() {
            super();
        }

        public Iterator<Object> iterator() {
            return new ValueIterator();
        }
    }

    public ParameterMap(Set<Parameter<?>> set) {
        this((Registry<String, ? extends Parameter<?>>) Parameters.registry((Collection<Parameter<?>>) set));
    }

    private <T> Object apply(Parameter<T> parameter, Object obj) {
        String id = parameter.getId();
        if (Objects.isEmpty(obj)) {
            return remove(id);
        }
        try {
            Object applyFrom = parameter.applyFrom(obj);
            Assert.notNull(applyFrom, "Parameter's resulting idiomaticValue cannot be null.");
            Object applyTo = parameter.applyTo(applyFrom);
            Assert.notNull(applyTo, "Parameter's resulting canonicalValue cannot be null.");
            this.idiomaticValues.put(id, applyFrom);
            return this.values.put(id, applyTo);
        } catch (Exception e10) {
            StringBuilder sb = new StringBuilder(100);
            sb.append("Invalid ");
            sb.append(getName());
            sb.append(" ");
            sb.append(parameter);
            sb.append(" value");
            if (parameter.isSecret()) {
                sb.append(": ");
                sb.append(RedactedSupplier.REDACTED_VALUE);
            } else if (!(obj instanceof byte[])) {
                sb.append(": ");
                sb.append(Objects.nullSafeToString(obj));
            }
            sb.append(". ");
            sb.append(e10.getMessage());
            throw new IllegalArgumentException(sb.toString(), e10);
        }
    }

    private void assertMutable() {
        if (this.initialized && !this.mutable) {
            throw new UnsupportedOperationException(getName() + " instance is immutable and may not be modified.");
        }
    }

    private Object nullSafePut(String str, Object obj) {
        if (obj == null) {
            return remove(str);
        }
        this.idiomaticValues.put(str, obj);
        return this.values.put(str, obj);
    }

    public void clear() {
        assertMutable();
        this.values.clear();
        this.idiomaticValues.clear();
    }

    public boolean containsKey(Object obj) {
        return this.values.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.values.containsValue(obj);
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return new EntrySet();
    }

    public boolean equals(Object obj) {
        return this.values.equals(obj);
    }

    public <T> T get(Parameter<T> parameter) {
        Assert.notNull(parameter, "Parameter cannot be null.");
        return parameter.cast(this.idiomaticValues.get((String) Assert.hasText(parameter.getId(), "Parameter id cannot be null or empty.")));
    }

    public String getName() {
        return "Map";
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public Set<String> keySet() {
        return new KeySet();
    }

    public void putAll(Map<? extends String, ?> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
        }
    }

    public Object remove(Object obj) {
        assertMutable();
        this.idiomaticValues.remove(obj);
        return this.values.remove(obj);
    }

    public ParameterMap replace(Parameter<?> parameter) {
        return new ParameterMap(Parameters.replace(this.PARAMS, parameter), this, this.mutable);
    }

    public int size() {
        return this.values.size();
    }

    public String toString() {
        return this.values.toString();
    }

    public Collection<Object> values() {
        return new ValueSet();
    }

    public ParameterMap(Registry<String, ? extends Parameter<?>> registry) {
        this(registry, (Map<String, ?>) null, true);
    }

    public final <T> Object put(Parameter<T> parameter, Object obj) {
        assertMutable();
        Assert.notNull(parameter, "Parameter cannot be null.");
        Assert.hasText(parameter.getId(), "Parameter id cannot be null or empty.");
        return apply(parameter, obj);
    }

    public ParameterMap(Registry<String, ? extends Parameter<?>> registry, Map<String, ?> map) {
        this(registry, (Map) Assert.notNull(map, "Map argument cannot be null."), false);
    }

    public ParameterMap(Registry<String, ? extends Parameter<?>> registry, Map<String, ?> map, boolean z10) {
        Assert.notNull(registry, "Parameter registry cannot be null.");
        Assert.notEmpty(registry.values(), "Parameter registry cannot be empty.");
        this.PARAMS = registry;
        this.values = new LinkedHashMap();
        this.idiomaticValues = new LinkedHashMap();
        if (!Collections.isEmpty((Map<?, ?>) map)) {
            putAll(map);
        }
        this.mutable = z10;
        this.initialized = true;
    }

    public Object get(Object obj) {
        return this.values.get(obj);
    }

    public final Object put(String str, Object obj) {
        assertMutable();
        String str2 = (String) Assert.notNull(Strings.clean(str), "Member name cannot be null or empty.");
        Parameter parameter = (Parameter) this.PARAMS.get(str2);
        if (parameter != null) {
            return put(parameter, obj);
        }
        return nullSafePut(str2, obj);
    }
}
