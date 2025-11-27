package com.raizlabs.android.dbflow.converter;

import java.math.BigInteger;

public class BigIntegerConverter extends TypeConverter<String, BigInteger> {
    public String getDBValue(BigInteger bigInteger) {
        if (bigInteger == null) {
            return null;
        }
        return bigInteger.toString();
    }

    public BigInteger getModelValue(String str) {
        if (str == null) {
            return null;
        }
        return new BigInteger(str);
    }
}
