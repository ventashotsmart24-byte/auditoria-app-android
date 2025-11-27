package com.mobile.brasiltv.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import java.util.HashMap;
import java.util.Locale;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f12504a = new a(7);

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

    public static void a(Context context, String str) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale a10 = c1.a(str);
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(a10);
            return;
        }
        configuration.locale = a10;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public static Context b(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return d(context, str);
        }
        a(context, str);
        return context;
    }

    public static void c(Context context, String str) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(e(str));
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public static Context d(Context context, String str) {
        Locale locale;
        Configuration configuration = context.getResources().getConfiguration();
        if (TextUtils.isEmpty(str)) {
            locale = c1.b();
        } else {
            locale = c1.a(str);
        }
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    public static Locale e(String str) {
        if (f(str)) {
            return (Locale) f12504a.get(str);
        }
        Locale locale = Locale.getDefault();
        for (String str2 : f12504a.keySet()) {
            if (TextUtils.equals(((Locale) f12504a.get(str2)).getLanguage(), locale.getLanguage())) {
                return locale;
            }
        }
        return Locale.SIMPLIFIED_CHINESE;
    }

    public static boolean f(String str) {
        return f12504a.containsKey(str);
    }
}
