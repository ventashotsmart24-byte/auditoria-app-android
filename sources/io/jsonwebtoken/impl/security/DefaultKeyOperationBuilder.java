package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.KeyOperation;
import io.jsonwebtoken.security.KeyOperationBuilder;
import java.util.LinkedHashSet;
import java.util.Set;

public class DefaultKeyOperationBuilder implements KeyOperationBuilder {
    private String description;
    private String id;
    private final Set<String> related = new LinkedHashSet();

    public KeyOperationBuilder description(String str) {
        this.description = str;
        return this;
    }

    public KeyOperationBuilder id(String str) {
        this.id = str;
        return this;
    }

    public KeyOperationBuilder related(String str) {
        if (Strings.hasText(str)) {
            this.related.add(str);
        }
        return this;
    }

    public KeyOperation build() {
        return new DefaultKeyOperation(this.id, this.description, this.related);
    }
}
