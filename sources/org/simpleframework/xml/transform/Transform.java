package org.simpleframework.xml.transform;

public interface Transform<T> {
    T read(String str);

    String write(T t10);
}
