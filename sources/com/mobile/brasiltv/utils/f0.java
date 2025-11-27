package com.mobile.brasiltv.utils;

import java.util.Locale;

public abstract class f0 {
    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static boolean b() {
        return Locale.getDefault().getLanguage().equalsIgnoreCase("es");
    }

    public static boolean c() {
        return Locale.getDefault().getLanguage().equalsIgnoreCase("pt");
    }
}
