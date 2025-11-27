package com.google.gson;

public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    public boolean equals(Object obj) {
        if (this == obj || (obj instanceof JsonNull)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    public JsonNull deepCopy() {
        return INSTANCE;
    }
}
