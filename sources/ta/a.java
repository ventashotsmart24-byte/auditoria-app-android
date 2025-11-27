package ta;

import android.database.Cursor;
import ua.c;
import ua.d;
import ua.e;
import ua.f;

public abstract class a {
    public static Object a(Cursor cursor, Class cls, ra.a aVar) {
        if (cursor == null) {
            return null;
        }
        try {
            f a10 = f.a(cls);
            int columnCount = cursor.getColumnCount();
            if (columnCount <= 0) {
                return null;
            }
            Object newInstance = cls.newInstance();
            for (int i10 = 0; i10 < columnCount; i10++) {
                String columnName = cursor.getColumnName(i10);
                e eVar = (e) a10.f19657d.get(columnName);
                if (eVar != null) {
                    eVar.l(newInstance, cursor.getString(i10));
                } else if (a10.b().a().equals(columnName)) {
                    a10.b().l(newInstance, cursor.getString(i10));
                }
            }
            for (d dVar : a10.f19658e.values()) {
                if (dVar.b() == f.class) {
                    dVar.l(newInstance, new f(newInstance, cls, dVar.m(), aVar));
                }
            }
            for (c cVar : a10.f19659f.values()) {
                if (cVar.b() == e.class) {
                    e eVar2 = new e(newInstance, cls, cVar.m(), aVar);
                    eVar2.d(Integer.valueOf(cursor.getInt(cursor.getColumnIndex(cVar.a()))));
                    cVar.l(newInstance, eVar2);
                }
            }
            return newInstance;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
