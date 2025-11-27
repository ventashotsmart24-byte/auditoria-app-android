package u1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t9.g;
import t9.i;
import u1.a;

public final class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9432a = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    public static final int f9433b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f9434c = "addb";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, f9434c, (SQLiteDatabase.CursorFactory) null, f9433b);
        i.g(context, f.X);
    }

    public final void a(SQLiteDatabase sQLiteDatabase, c cVar) {
        String str = "ALTER TABLE " + a.f9417c.l() + " ADD COLUMN " + cVar.a() + ' ' + cVar.b();
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL(str);
        }
    }

    public final String b(String str, String str2, List list) {
        StringBuffer stringBuffer = new StringBuffer("create table ");
        stringBuffer.append(str);
        stringBuffer.append(" (");
        stringBuffer.append(str2);
        stringBuffer.append(" integer primary key autoincrement");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            stringBuffer.append(",");
            stringBuffer.append(cVar.a());
            stringBuffer.append(" ");
            stringBuffer.append(cVar.b());
        }
        stringBuffer.append(")");
        String stringBuffer2 = stringBuffer.toString();
        i.f(stringBuffer2, "stringBuilder.toString()");
        return stringBuffer2;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        i.g(sQLiteDatabase, "db");
        ArrayList arrayList = new ArrayList();
        a.C0127a aVar = a.f9417c;
        arrayList.add(new c(aVar.a(), "text(40)"));
        arrayList.add(new c(aVar.b(), "text(40)"));
        arrayList.add(new c(aVar.f(), "integer"));
        arrayList.add(new c(aVar.e(), "integer"));
        arrayList.add(new c(aVar.k(), "text(60)"));
        arrayList.add(new c(aVar.d(), "integer"));
        arrayList.add(new c(aVar.j(), "text(40)"));
        arrayList.add(new c(aVar.c(), "text(40)"));
        arrayList.add(new c(aVar.i(), "Long"));
        arrayList.add(new c(aVar.g(), "Long"));
        sQLiteDatabase.execSQL(b(aVar.l(), aVar.h(), arrayList));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 <= i11) {
            while (true) {
                if (i10 == 1) {
                    a(sQLiteDatabase, new c(a.f9417c.g(), "Long"));
                }
                if (i10 != i11) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }
}
