package ta;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import ua.a;
import ua.c;
import ua.e;
import ua.f;
import va.b;

public abstract class g {
    public static String a(Class cls, String str) {
        StringBuffer stringBuffer = new StringBuffer(f(f.a(cls).c()));
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(" WHERE ");
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static h b(Class cls, Object obj) {
        f a10 = f.a(cls);
        a b10 = a10.b();
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer(f(a10.c()));
            stringBuffer.append(" WHERE ");
            stringBuffer.append(b10.a());
            stringBuffer.append("=?");
            h hVar = new h();
            hVar.e(stringBuffer.toString());
            hVar.a(obj);
            return hVar;
        }
        throw new b("getDeleteSQL:idValue is null");
    }

    public static h c(Object obj) {
        f a10 = f.a(obj.getClass());
        a b10 = a10.b();
        Object d10 = b10.d(obj);
        if (d10 != null) {
            StringBuffer stringBuffer = new StringBuffer(f(a10.c()));
            stringBuffer.append(" WHERE ");
            stringBuffer.append(b10.a());
            stringBuffer.append("=?");
            h hVar = new h();
            hVar.e(stringBuffer.toString());
            hVar.a(d10);
            return hVar;
        }
        throw new b("getDeleteSQL:" + obj.getClass() + " id value is null");
    }

    public static h d(Object obj) {
        List<ua.b> g10 = g(obj);
        StringBuffer stringBuffer = new StringBuffer();
        if (g10 == null || g10.size() <= 0) {
            return null;
        }
        h hVar = new h();
        stringBuffer.append("INSERT INTO ");
        stringBuffer.append(f.a(obj.getClass()).c());
        stringBuffer.append(" (");
        for (ua.b bVar : g10) {
            stringBuffer.append(bVar.a());
            stringBuffer.append(",");
            hVar.a(bVar.b());
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") VALUES ( ");
        int size = g10.size();
        for (int i10 = 0; i10 < size; i10++) {
            stringBuffer.append("?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        hVar.e(stringBuffer.toString());
        return hVar;
    }

    public static String e(Class cls) {
        f a10 = f.a(cls);
        a b10 = a10.b();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS ");
        stringBuffer.append(a10.c());
        stringBuffer.append(" ( ");
        Class<Integer> b11 = b10.b();
        Class<Long> cls2 = Long.class;
        Class<Integer> cls3 = Integer.class;
        if (b11 == Integer.TYPE || b11 == cls3 || b11 == Long.TYPE || b11 == cls2) {
            stringBuffer.append(b10.a());
            stringBuffer.append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
        } else {
            stringBuffer.append(b10.a());
            stringBuffer.append(" TEXT PRIMARY KEY,");
        }
        for (e eVar : a10.f19657d.values()) {
            stringBuffer.append(eVar.a());
            Class<Boolean> b12 = eVar.b();
            if (b12 == Integer.TYPE || b12 == cls3 || b12 == Long.TYPE || b12 == cls2) {
                stringBuffer.append(" INTEGER");
            } else if (b12 == Float.TYPE || b12 == Float.class || b12 == Double.TYPE || b12 == Double.class) {
                stringBuffer.append(" REAL");
            } else if (b12 == Boolean.TYPE || b12 == Boolean.class) {
                stringBuffer.append(" NUMERIC");
            }
            stringBuffer.append(",");
        }
        for (c a11 : a10.f19659f.values()) {
            stringBuffer.append(a11.a());
            stringBuffer.append(" INTEGER");
            stringBuffer.append(",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" )");
        return stringBuffer.toString();
    }

    public static String f(String str) {
        return "DELETE FROM " + str;
    }

    public static List g(Object obj) {
        ArrayList arrayList = new ArrayList();
        f a10 = f.a(obj.getClass());
        Object d10 = a10.b().d(obj);
        if (!(d10 instanceof Integer) && (d10 instanceof String) && d10 != null) {
            arrayList.add(new ua.b(a10.b().a(), d10));
        }
        for (e o10 : a10.f19657d.values()) {
            ua.b o11 = o(o10, obj);
            if (o11 != null) {
                arrayList.add(o11);
            }
        }
        for (c n10 : a10.f19659f.values()) {
            ua.b n11 = n(n10, obj);
            if (n11 != null) {
                arrayList.add(n11);
            }
        }
        return arrayList;
    }

    public static String h(Class cls) {
        return k(f.a(cls).c());
    }

    public static String i(Class cls, String str) {
        StringBuffer stringBuffer = new StringBuffer(k(f.a(cls).c()));
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(" WHERE ");
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static h j(Class cls, Object obj) {
        f a10 = f.a(cls);
        StringBuffer stringBuffer = new StringBuffer(k(a10.c()));
        stringBuffer.append(" WHERE ");
        stringBuffer.append(a10.b().a());
        stringBuffer.append("=?");
        h hVar = new h();
        hVar.e(stringBuffer.toString());
        hVar.a(obj);
        return hVar;
    }

    public static String k(String str) {
        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM ");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static h l(Object obj) {
        f a10 = f.a(obj.getClass());
        Object d10 = a10.b().d(obj);
        if (d10 != null) {
            ArrayList<ua.b> arrayList = new ArrayList<>();
            for (e o10 : a10.f19657d.values()) {
                ua.b o11 = o(o10, obj);
                if (o11 != null) {
                    arrayList.add(o11);
                }
            }
            for (c n10 : a10.f19659f.values()) {
                ua.b n11 = n(n10, obj);
                if (n11 != null) {
                    arrayList.add(n11);
                }
            }
            if (arrayList.size() == 0) {
                return null;
            }
            h hVar = new h();
            StringBuffer stringBuffer = new StringBuffer("UPDATE ");
            stringBuffer.append(a10.c());
            stringBuffer.append(" SET ");
            for (ua.b bVar : arrayList) {
                stringBuffer.append(bVar.a());
                stringBuffer.append("=?,");
                hVar.a(bVar.b());
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            stringBuffer.append(" WHERE ");
            stringBuffer.append(a10.b().a());
            stringBuffer.append("=?");
            hVar.a(d10);
            hVar.e(stringBuffer.toString());
            return hVar;
        }
        throw new b("this entity[" + obj.getClass() + "]'s id value is null");
    }

    public static h m(Object obj, String str) {
        f a10 = f.a(obj.getClass());
        ArrayList<ua.b> arrayList = new ArrayList<>();
        for (e o10 : a10.f19657d.values()) {
            ua.b o11 = o(o10, obj);
            if (o11 != null) {
                arrayList.add(o11);
            }
        }
        for (c n10 : a10.f19659f.values()) {
            ua.b n11 = n(n10, obj);
            if (n11 != null) {
                arrayList.add(n11);
            }
        }
        if (arrayList.size() != 0) {
            h hVar = new h();
            StringBuffer stringBuffer = new StringBuffer("UPDATE ");
            stringBuffer.append(a10.c());
            stringBuffer.append(" SET ");
            for (ua.b bVar : arrayList) {
                stringBuffer.append(bVar.a());
                stringBuffer.append("=?,");
                hVar.a(bVar.b());
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(" WHERE ");
                stringBuffer.append(str);
            }
            hVar.e(stringBuffer.toString());
            return hVar;
        }
        throw new b("this entity[" + obj.getClass() + "] has no property");
    }

    public static ua.b n(c cVar, Object obj) {
        Object obj2;
        String a10 = cVar.a();
        Object d10 = cVar.d(obj);
        if (d10 != null) {
            if (d10.getClass() == e.class) {
                obj2 = f.a(cVar.m()).b().d(((e) d10).a());
            } else {
                obj2 = f.a(d10.getClass()).b().d(d10);
            }
            if (!(a10 == null || obj2 == null)) {
                return new ua.b(a10, obj2);
            }
        }
        return null;
    }

    public static ua.b o(e eVar, Object obj) {
        String a10 = eVar.a();
        Object d10 = eVar.d(obj);
        if (d10 != null) {
            return new ua.b(a10, d10);
        }
        if (eVar.c() == null || eVar.c().trim().length() == 0) {
            return null;
        }
        return new ua.b(a10, eVar.c());
    }
}
