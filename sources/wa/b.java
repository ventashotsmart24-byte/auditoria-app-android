package wa;

import com.umeng.analytics.pro.bt;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import sa.a;
import sa.c;
import sa.d;
import sa.f;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f19766a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Method a(Class cls, String str) {
        String str2 = bt.ae + str.substring(0, 1).toUpperCase() + str.substring(1);
        if (!i(str)) {
            str = str2;
        }
        try {
            return cls.getDeclaredMethod(str, new Class[0]);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Method b(Class cls, Field field) {
        String name = field.getName();
        String str = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
        if (i(field.getName())) {
            str = "set" + name.substring(2, 3).toUpperCase() + name.substring(3);
        }
        try {
            return cls.getDeclaredMethod(str, new Class[]{field.getType()});
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String c(Field field) {
        d dVar = (d) field.getAnnotation(d.class);
        if (dVar != null && dVar.column().trim().length() != 0) {
            return dVar.column();
        }
        sa.b bVar = (sa.b) field.getAnnotation(sa.b.class);
        if (bVar != null && bVar.column().trim().length() != 0) {
            return bVar.column();
        }
        c cVar = (c) field.getAnnotation(c.class);
        if (cVar != null && cVar.manyColumn() != null && cVar.manyColumn().trim().length() != 0) {
            return cVar.manyColumn();
        }
        a aVar = (a) field.getAnnotation(a.class);
        if (aVar == null || aVar.column().trim().length() == 0) {
            return field.getName();
        }
        return aVar.column();
    }

    public static Method d(Class cls, String str) {
        try {
            return cls.getDeclaredMethod("get" + str.substring(0, 1).toUpperCase() + str.substring(1), new Class[0]);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Method e(Class cls, Field field) {
        Method method;
        String name = field.getName();
        if (field.getType() == Boolean.TYPE) {
            method = a(cls, name);
        } else {
            method = null;
        }
        if (method == null) {
            return d(cls, name);
        }
        return method;
    }

    public static Method f(Class cls, Field field) {
        String name = field.getName();
        try {
            return cls.getDeclaredMethod("set" + name.substring(0, 1).toUpperCase() + name.substring(1), new Class[]{field.getType()});
        } catch (NoSuchMethodException unused) {
            if (field.getType() == Boolean.TYPE) {
                return b(cls, field);
            }
            return null;
        }
    }

    public static String g(Field field) {
        d dVar = (d) field.getAnnotation(d.class);
        if (dVar == null || dVar.defaultValue().trim().length() == 0) {
            return null;
        }
        return dVar.defaultValue();
    }

    public static boolean h(Field field) {
        Class<?> type = field.getType();
        if (!type.equals(String.class) && !type.equals(Integer.class) && !type.equals(Byte.class) && !type.equals(Long.class) && !type.equals(Double.class) && !type.equals(Float.class) && !type.equals(Character.class) && !type.equals(Short.class) && !type.equals(Boolean.class)) {
            Class<Date> cls = Date.class;
            if (type.equals(cls) || type.equals(cls) || type.equals(java.sql.Date.class) || type.isPrimitive()) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean i(String str) {
        if (str == null || str.trim().length() == 0 || !str.startsWith(bt.ae) || Character.isLowerCase(str.charAt(2))) {
            return false;
        }
        return true;
    }

    public static boolean j(Field field) {
        if (field.getAnnotation(sa.b.class) != null) {
            return true;
        }
        return false;
    }

    public static boolean k(Field field) {
        if (field.getAnnotation(c.class) != null) {
            return true;
        }
        return false;
    }

    public static boolean l(Field field) {
        if (field.getAnnotation(f.class) != null) {
            return true;
        }
        return false;
    }

    public static Date m(String str) {
        if (str == null) {
            return null;
        }
        try {
            return f19766a.parse(str);
        } catch (ParseException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
