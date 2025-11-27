package ta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ra.a;

public class c extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static c f19603b;

    /* renamed from: a  reason: collision with root package name */
    public a.b f19604a;

    public c(Context context, String str, int i10, a.b bVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f19604a = bVar;
    }

    public static c a(Context context, String str, int i10, a.b bVar) {
        if (f19603b == null) {
            f19603b = new c(context, str, i10, bVar);
        }
        return f19603b;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a.b bVar = this.f19604a;
        if (bVar != null) {
            bVar.onCreate(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        a.b bVar = this.f19604a;
        if (bVar != null) {
            bVar.onUpgrade(sQLiteDatabase, i10, i11);
        }
    }
}
