package com.raizlabs.android.dbflow.converter;

public class BooleanConverter extends TypeConverter<Integer, Boolean> {
    public Integer getDBValue(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return Integer.valueOf(bool.booleanValue() ? 1 : 0);
    }

    public Boolean getModelValue(Integer num) {
        if (num == null) {
            return null;
        }
        boolean z10 = true;
        if (num.intValue() != 1) {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
