package com.raizlabs.android.dbflow.converter;

import java.util.UUID;

public class UUIDConverter extends TypeConverter<String, UUID> {
    public String getDBValue(UUID uuid) {
        if (uuid != null) {
            return uuid.toString();
        }
        return null;
    }

    public UUID getModelValue(String str) {
        if (str == null) {
            return null;
        }
        return UUID.fromString(str);
    }
}
