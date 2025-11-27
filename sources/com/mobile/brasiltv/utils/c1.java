package com.mobile.brasiltv.utils;

import android.os.Build;
import android.os.LocaleList;
import com.hpplay.cybergarage.xml.XML;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class c1 {

    /* renamed from: a  reason: collision with root package name */
    public static Map f12511a = new a(3);

    public class a extends HashMap {
        public a(int i10) {
            super(i10);
            put(XML.DEFAULT_CONTENT_LANGUAGE, Locale.ENGLISH);
            put("zh", Locale.SIMPLIFIED_CHINESE);
            put("zh-hant", Locale.TRADITIONAL_CHINESE);
            put("pt", new Locale("pt"));
            put("es", new Locale("es"));
        }
    }

    public static Locale a(String str) {
        if (c(str)) {
            return (Locale) f12511a.get(str);
        }
        return b();
    }

    public static Locale b() {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleList.getDefault().get(0);
        }
        return Locale.getDefault();
    }

    public static boolean c(String str) {
        return f12511a.containsKey(str);
    }
}
