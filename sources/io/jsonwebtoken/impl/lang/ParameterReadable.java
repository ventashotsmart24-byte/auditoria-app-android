package io.jsonwebtoken.impl.lang;

public interface ParameterReadable {
    <T> T get(Parameter<T> parameter);
}
