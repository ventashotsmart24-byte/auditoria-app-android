package u0;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import java.util.List;
import t0.e;
import t0.f;

public class a implements t0.b {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f9396b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f9397c = new String[0];

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f9398a;

    /* renamed from: u0.a$a  reason: collision with other inner class name */
    public class C0125a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f9399a;

        public C0125a(e eVar) {
            this.f9399a = eVar;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f9399a.a(new e(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public class b implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f9401a;

        public b(e eVar) {
            this.f9401a = eVar;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f9401a.a(new e(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f9398a = sQLiteDatabase;
    }

    public Cursor B(String str) {
        return w(new t0.a(str));
    }

    public boolean G() {
        return this.f9398a.inTransaction();
    }

    public boolean a(SQLiteDatabase sQLiteDatabase) {
        if (this.f9398a == sQLiteDatabase) {
            return true;
        }
        return false;
    }

    public void beginTransaction() {
        this.f9398a.beginTransaction();
    }

    public void close() {
        this.f9398a.close();
    }

    public f compileStatement(String str) {
        return new f(this.f9398a.compileStatement(str));
    }

    public void endTransaction() {
        this.f9398a.endTransaction();
    }

    public void execSQL(String str) {
        this.f9398a.execSQL(str);
    }

    public String getPath() {
        return this.f9398a.getPath();
    }

    public List i() {
        return this.f9398a.getAttachedDbs();
    }

    public boolean isOpen() {
        return this.f9398a.isOpen();
    }

    public Cursor k(e eVar, CancellationSignal cancellationSignal) {
        return this.f9398a.rawQueryWithFactory(new b(eVar), eVar.b(), f9397c, (String) null, cancellationSignal);
    }

    public void l(String str, Object[] objArr) {
        this.f9398a.execSQL(str, objArr);
    }

    public void setTransactionSuccessful() {
        this.f9398a.setTransactionSuccessful();
    }

    public Cursor w(e eVar) {
        return this.f9398a.rawQueryWithFactory(new C0125a(eVar), eVar.b(), f9397c, (String) null);
    }
}
