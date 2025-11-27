package b0;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static Field f4112a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4113b;

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        Class<LayoutInflater> cls = LayoutInflater.class;
        if (!f4113b) {
            try {
                Field declaredField = cls.getDeclaredField("mFactory2");
                f4112a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + cls.getName() + "; inflation may have unexpected results.", e10);
            }
            f4113b = true;
        }
        Field field = f4112a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e11) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e11);
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                a(layoutInflater, factory2);
            }
        }
    }
}
