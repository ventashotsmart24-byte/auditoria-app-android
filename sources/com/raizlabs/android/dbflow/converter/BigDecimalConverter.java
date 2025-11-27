package com.raizlabs.android.dbflow.converter;

import java.math.BigDecimal;

public class BigDecimalConverter extends TypeConverter<String, BigDecimal> {
    public String getDBValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        }
        return bigDecimal.toString();
    }

    public BigDecimal getModelValue(String str) {
        if (str == null) {
            return null;
        }
        return new BigDecimal(str);
    }
}
