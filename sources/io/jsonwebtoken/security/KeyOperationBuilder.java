package io.jsonwebtoken.security;

import io.jsonwebtoken.lang.Builder;

public interface KeyOperationBuilder extends Builder<KeyOperation> {
    KeyOperationBuilder description(String str);

    KeyOperationBuilder id(String str);

    KeyOperationBuilder related(String str);
}
