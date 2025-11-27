package com.raizlabs.android.dbflow;

public class StringUtils {
    public static boolean isNotNullOrEmpty(String str) {
        if (str == null || str.equals("") || str.length() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.equals("") || str.length() <= 0) {
            return true;
        }
        return false;
    }
}
