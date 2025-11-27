package org.simpleframework.xml.convert;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public interface Converter<T> {
    T read(InputNode inputNode);

    void write(OutputNode outputNode, T t10);
}
