package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;

class SignatureScanner {
    private final SignatureBuilder builder;
    private final Constructor constructor;
    private final ParameterFactory factory;
    private final ParameterMap registry;
    private final Class type;

    public SignatureScanner(Constructor constructor2, ParameterMap parameterMap, Support support) {
        this.builder = new SignatureBuilder(constructor2);
        this.factory = new ParameterFactory(support);
        Class declaringClass = constructor2.getDeclaringClass();
        this.type = declaringClass;
        this.constructor = constructor2;
        this.registry = parameterMap;
        scan(declaringClass);
    }

    private List<Parameter> create(Annotation annotation, int i10) {
        Parameter instance = this.factory.getInstance(this.constructor, annotation, i10);
        if (instance != null) {
            register(instance);
        }
        return Collections.singletonList(instance);
    }

    private Annotation[] extract(Annotation annotation) {
        Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
        if (declaredMethods.length == 1) {
            return (Annotation[]) declaredMethods[0].invoke(annotation, new Object[0]);
        }
        throw new UnionException("Annotation '%s' is not a valid union for %s", annotation, this.type);
    }

    private List<Parameter> process(Annotation annotation, int i10) {
        if (annotation instanceof Attribute) {
            return create(annotation, i10);
        }
        if (annotation instanceof Element) {
            return create(annotation, i10);
        }
        if (annotation instanceof ElementList) {
            return create(annotation, i10);
        }
        if (annotation instanceof ElementArray) {
            return create(annotation, i10);
        }
        if (annotation instanceof ElementMap) {
            return create(annotation, i10);
        }
        if (annotation instanceof ElementListUnion) {
            return union(annotation, i10);
        }
        if (annotation instanceof ElementMapUnion) {
            return union(annotation, i10);
        }
        if (annotation instanceof ElementUnion) {
            return union(annotation, i10);
        }
        if (annotation instanceof Text) {
            return create(annotation, i10);
        }
        return Collections.emptyList();
    }

    private void register(Parameter parameter) {
        String path = parameter.getPath();
        Object key = parameter.getKey();
        if (this.registry.containsKey(key)) {
            validate(parameter, key);
        }
        if (this.registry.containsKey(path)) {
            validate(parameter, path);
        }
        this.registry.put(path, parameter);
        this.registry.put(key, parameter);
    }

    private void scan(Class cls) {
        Class[] parameterTypes = this.constructor.getParameterTypes();
        for (int i10 = 0; i10 < parameterTypes.length; i10++) {
            scan(parameterTypes[i10], i10);
        }
    }

    private List<Parameter> union(Annotation annotation, int i10) {
        Signature signature = new Signature(this.constructor);
        Annotation[] extract = extract(annotation);
        int length = extract.length;
        int i11 = 0;
        while (i11 < length) {
            Parameter instance = this.factory.getInstance(this.constructor, annotation, extract[i11], i10);
            String path = instance.getPath();
            if (!signature.contains(path)) {
                signature.set(path, instance);
                register(instance);
                i11++;
            } else {
                throw new UnionException("Annotation name '%s' used more than once in %s for %s", path, annotation, this.type);
            }
        }
        return signature.getAll();
    }

    private void validate(Parameter parameter, Object obj) {
        Parameter parameter2 = (Parameter) this.registry.get(obj);
        if (parameter.isText() != parameter2.isText()) {
            Annotation annotation = parameter.getAnnotation();
            Annotation annotation2 = parameter2.getAnnotation();
            String path = parameter.getPath();
            if (!annotation.equals(annotation2)) {
                throw new ConstructorException("Annotations do not match for '%s' in %s", path, this.type);
            } else if (parameter2.getType() != parameter.getType()) {
                throw new ConstructorException("Parameter types do not match for '%s' in %s", path, this.type);
            }
        }
    }

    public List<Signature> getSignatures() {
        return this.builder.build();
    }

    public boolean isValid() {
        return this.builder.isValid();
    }

    private void scan(Class cls, int i10) {
        Annotation[][] parameterAnnotations = this.constructor.getParameterAnnotations();
        int i11 = 0;
        while (true) {
            Annotation[] annotationArr = parameterAnnotations[i10];
            if (i11 < annotationArr.length) {
                for (Parameter insert : process(annotationArr[i11], i10)) {
                    this.builder.insert(insert, i10);
                }
                i11++;
            } else {
                return;
            }
        }
    }
}
