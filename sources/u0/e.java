package u0;

import android.database.sqlite.SQLiteProgram;
import t0.d;

public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteProgram f9415a;

    public e(SQLiteProgram sQLiteProgram) {
        this.f9415a = sQLiteProgram;
    }

    public void bindBlob(int i10, byte[] bArr) {
        this.f9415a.bindBlob(i10, bArr);
    }

    public void bindDouble(int i10, double d10) {
        this.f9415a.bindDouble(i10, d10);
    }

    public void bindLong(int i10, long j10) {
        this.f9415a.bindLong(i10, j10);
    }

    public void bindNull(int i10) {
        this.f9415a.bindNull(i10);
    }

    public void bindString(int i10, String str) {
        this.f9415a.bindString(i10, str);
    }

    public void close() {
        this.f9415a.close();
    }
}
