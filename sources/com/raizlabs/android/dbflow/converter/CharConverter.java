package com.raizlabs.android.dbflow.converter;

public class CharConverter extends TypeConverter<String, Character> {
    public String getDBValue(Character ch) {
        if (ch == null) {
            return null;
        }
        return new String(new char[]{ch.charValue()});
    }

    public Character getModelValue(String str) {
        if (str != null) {
            return Character.valueOf(str.charAt(0));
        }
        return null;
    }
}
