package u0;

import android.database.sqlite.SQLiteStatement;

public class f extends e implements t0.f {

    /* renamed from: b  reason: collision with root package name */
    public final SQLiteStatement f9416b;

    public f(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f9416b = sQLiteStatement;
    }

    public long executeInsert() {
        return this.f9416b.executeInsert();
    }

    public int executeUpdateDelete() {
        return this.f9416b.executeUpdateDelete();
    }
}
