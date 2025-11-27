package x4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final String f19767a = String.format("CREATE TABLE %s (_id varchar(255) PRIMARY KEY NOT NULL,supportRanges integer NOT NULL,createAt long NOT NULL,uri varchar(255) NOT NULL,path varchar(255) NOT NULL,size long NOT NULL, progress long NOT NULL,status integer NOT NULL,breakPointCount integer NOT NULL);", new Object[]{"download_info"});

    /* renamed from: b  reason: collision with root package name */
    public static final String f19768b = String.format("CREATE TABLE %s (_id integer PRIMARY KEY NOT NULL,threadId integer NOT NULL,downloadInfoId varchar(255) NOT NULL,uri varchar(255) NOT NULL,start long NOT NULL,end long NOT NULL,progress long NOT NULL);", new Object[]{"download_thread_info"});

    public a(Context context, t4.a aVar) {
        super(context, aVar.b(), (SQLiteDatabase.CursorFactory) null, aVar.c());
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f19767a);
        sQLiteDatabase.execSQL(f19768b);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
