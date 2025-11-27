package ta;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

public class b extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public String f19602a;

    public b(Context context, String str) {
        super(context);
        this.f19602a = str;
    }

    public File getDatabasePath(String str) {
        return new File(this.f19602a, str);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i10, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }
}
