package u0;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;
import t0.b;
import t0.c;

public class c implements t0.c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9403a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9404b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a f9405c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f9406d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f9407e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public a f9408f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9409g;

    public static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public final a[] f9410a;

        /* renamed from: b  reason: collision with root package name */
        public final c.a f9411b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9412c;

        /* renamed from: u0.c$a$a  reason: collision with other inner class name */
        public class C0126a implements DatabaseErrorHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.a f9413a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a[] f9414b;

            public C0126a(c.a aVar, a[] aVarArr) {
                this.f9413a = aVar;
                this.f9414b = aVarArr;
            }

            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.f9413a.c(a.b(this.f9414b, sQLiteDatabase));
            }
        }

        public a(Context context, String str, a[] aVarArr, c.a aVar) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, aVar.f9341a, new C0126a(aVar, aVarArr));
            this.f9411b = aVar;
            this.f9410a = aVarArr;
        }

        public static a b(a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        public a a(SQLiteDatabase sQLiteDatabase) {
            return b(this.f9410a, sQLiteDatabase);
        }

        public synchronized b c() {
            this.f9412c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f9412c) {
                close();
                return c();
            }
            return a(writableDatabase);
        }

        public synchronized void close() {
            super.close();
            this.f9410a[0] = null;
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f9411b.b(a(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f9411b.d(a(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f9412c = true;
            this.f9411b.e(a(sQLiteDatabase), i10, i11);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f9412c) {
                this.f9411b.f(a(sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f9412c = true;
            this.f9411b.g(a(sQLiteDatabase), i10, i11);
        }
    }

    public c(Context context, String str, c.a aVar, boolean z10) {
        this.f9403a = context;
        this.f9404b = str;
        this.f9405c = aVar;
        this.f9406d = z10;
    }

    public b A() {
        return a().c();
    }

    public final a a() {
        a aVar;
        synchronized (this.f9407e) {
            if (this.f9408f == null) {
                a[] aVarArr = new a[1];
                if (Build.VERSION.SDK_INT < 23 || this.f9404b == null || !this.f9406d) {
                    this.f9408f = new a(this.f9403a, this.f9404b, aVarArr, this.f9405c);
                } else {
                    this.f9408f = new a(this.f9403a, new File(this.f9403a.getNoBackupFilesDir(), this.f9404b).getAbsolutePath(), aVarArr, this.f9405c);
                }
                this.f9408f.setWriteAheadLoggingEnabled(this.f9409g);
            }
            aVar = this.f9408f;
        }
        return aVar;
    }

    public void close() {
        a().close();
    }

    public String getDatabaseName() {
        return this.f9404b;
    }

    public void setWriteAheadLoggingEnabled(boolean z10) {
        synchronized (this.f9407e) {
            a aVar = this.f9408f;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z10);
            }
            this.f9409g = z10;
        }
    }
}
