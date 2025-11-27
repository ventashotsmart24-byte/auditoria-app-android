package com.umeng.message.component;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.bc;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.y;
import java.util.ArrayList;
import java.util.Map;

public class UmengMessageProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private final UriMatcher f15226a = new UriMatcher(-1);

    /* renamed from: b  reason: collision with root package name */
    private volatile a f15227b;

    /* renamed from: c  reason: collision with root package name */
    private volatile b f15228c;

    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "MessageStore.db", (SQLiteDatabase.CursorFactory) null, 5);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(String.format("create table if not exists %s (time long, type varchar default NULL, alias varchar default NULL, exclusive int, ttl long, PRIMARY KEY(time))", new Object[]{"MsgAlias"}));
            } catch (Throwable th) {
                UPLog.e("MessageProvider", th);
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            try {
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgAlias")) {
                    sQLiteDatabase.execSQL("drop table MsgAlias");
                }
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
                UPLog.e("MessageProvider", th);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            if (i10 <= 3) {
                try {
                    if (UmengMessageProvider.b(sQLiteDatabase, "MsgTemp")) {
                        sQLiteDatabase.execSQL("drop table MsgTemp");
                    }
                    if (UmengMessageProvider.b(sQLiteDatabase, "MessageStore")) {
                        sQLiteDatabase.execSQL("drop table MessageStore");
                    }
                } catch (Throwable th) {
                    UPLog.e("MessageProvider", th);
                    return;
                }
            }
            if (i10 <= 4 && UmengMessageProvider.b(sQLiteDatabase, "MsgAlias")) {
                sQLiteDatabase.execSQL("drop table MsgAlias");
            }
            onCreate(sQLiteDatabase);
        }
    }

    public static class b extends SQLiteOpenHelper {
        public b(Context context) {
            super(context, "MsgLogStore.db", (SQLiteDatabase.CursorFactory) null, 8);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(String.format("create table if not exists MsgLogStore (MsgId varchar, ActionType Integer, Time long, %s varchar, PRIMARY KEY(MsgId, ActionType))", new Object[]{"pa"}));
                sQLiteDatabase.execSQL("create table if not exists InAppLogStore (Time long, MsgId varchar, MsgType Integer, NumDisplay Integer, NumOpenFull Integer, NumOpenTop Integer, NumOpenBottom Integer, NumClose Integer, NumDuration Integer, NumCustom Integer, PRIMARY KEY(Time))");
            } catch (Throwable th) {
                UPLog.e("MessageProvider", th);
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            try {
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogStore")) {
                    sQLiteDatabase.execSQL("drop table MsgLogStore");
                }
                if (UmengMessageProvider.b(sQLiteDatabase, "InAppLogStore")) {
                    sQLiteDatabase.execSQL("drop table InAppLogStore");
                }
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
                UPLog.e("MessageProvider", th);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            if (i10 <= 5) {
                try {
                    if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogStore")) {
                        sQLiteDatabase.execSQL(String.format("ALTER TABLE MsgLogStore ADD COLUMN %s varchar", new Object[]{"pa"}));
                    }
                } catch (Throwable th) {
                    UPLog.e("MessageProvider", th);
                    return;
                }
            }
            if (i10 <= 6 && UmengMessageProvider.b(sQLiteDatabase, "InAppLogStore")) {
                sQLiteDatabase.execSQL(String.format("ALTER TABLE InAppLogStore ADD COLUMN %s Integer", new Object[]{"NumCustom"}));
            }
            if (i10 <= 7) {
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogStoreForAgoo")) {
                    sQLiteDatabase.execSQL("drop table MsgLogStoreForAgoo");
                }
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogIdTypeStore")) {
                    sQLiteDatabase.execSQL("drop table MsgLogIdTypeStore");
                }
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogIdTypeStoreForAgoo")) {
                    sQLiteDatabase.execSQL("drop table MsgLogIdTypeStoreForAgoo");
                }
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgConfigInfo")) {
                    sQLiteDatabase.execSQL("drop table MsgConfigInfo");
                }
            }
            onCreate(sQLiteDatabase);
        }
    }

    private b b() {
        if (this.f15228c == null) {
            synchronized (b.class) {
                if (this.f15228c == null) {
                    this.f15228c = new b(getContext());
                }
            }
        }
        return this.f15228c;
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase writableDatabase = b().getWritableDatabase();
        if (writableDatabase == null) {
            return super.applyBatch(arrayList);
        }
        try {
            writableDatabase.beginTransaction();
            ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return applyBatch;
        } catch (Throwable unused) {
            return super.applyBatch(arrayList);
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        try {
            int match = this.f15226a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase writableDatabase = a().getWritableDatabase();
                    if (writableDatabase != null) {
                        return writableDatabase.delete("MsgAlias", str, strArr);
                    }
                } else if (match == 4) {
                    SQLiteDatabase writableDatabase2 = a().getWritableDatabase();
                    if (writableDatabase2 != null) {
                        return writableDatabase2.delete("MsgAlias", (String) null, (String[]) null);
                    }
                } else if (match == 5) {
                    SQLiteDatabase writableDatabase3 = b().getWritableDatabase();
                    if (writableDatabase3 != null) {
                        return writableDatabase3.delete("MsgLogStore", str, strArr);
                    }
                } else if (match == 10) {
                    SQLiteDatabase writableDatabase4 = b().getWritableDatabase();
                    if (writableDatabase4 != null) {
                        return writableDatabase4.delete("InAppLogStore", str, strArr);
                    }
                }
            } else if (!(strArr == null || strArr.length == 0)) {
                bc a10 = bc.a();
                if (strArr.length == 0) {
                    return 0;
                }
                SharedPreferences.Editor edit = a10.f15495a.edit();
                int i10 = 0;
                for (String str2 : strArr) {
                    if (a10.f15495a.contains(str2)) {
                        edit.remove(str2);
                        i10++;
                    }
                }
                if (i10 > 0) {
                    edit.apply();
                }
                return i10;
            }
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
        return 0;
    }

    public String getType(Uri uri) {
        int match = this.f15226a.match(uri);
        if (match == 2 || match == 3 || match == 5) {
            return "vnd.android.cursor.dir/vnd.umeng.message";
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            int match = this.f15226a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase writableDatabase = a().getWritableDatabase();
                    if (writableDatabase == null) {
                        return null;
                    }
                    writableDatabase.insertWithOnConflict("MsgAlias", (String) null, contentValues, 5);
                } else if (match == 5) {
                    SQLiteDatabase writableDatabase2 = b().getWritableDatabase();
                    if (writableDatabase2 == null) {
                        return null;
                    }
                    writableDatabase2.insertWithOnConflict("MsgLogStore", (String) null, contentValues, 5);
                } else if (match == 10) {
                    SQLiteDatabase writableDatabase3 = b().getWritableDatabase();
                    if (writableDatabase3 == null) {
                        return null;
                    }
                    writableDatabase3.insertWithOnConflict("InAppLogStore", (String) null, contentValues, 5);
                }
            } else if (contentValues == null) {
                return null;
            } else {
                String asString = contentValues.getAsString("k");
                String asString2 = contentValues.getAsString("v");
                if (!TextUtils.isEmpty(asString)) {
                    bc.a().a(asString, asString2);
                }
            }
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
        return null;
    }

    public boolean onCreate() {
        try {
            Context context = getContext();
            y.a(context);
            Uri a10 = h.a(context);
            this.f15226a.addURI(a10.getAuthority(), a10.getPath(), 3);
            Uri b10 = h.b(context);
            this.f15226a.addURI(b10.getAuthority(), b10.getPath(), 4);
            Uri d10 = h.d(context);
            this.f15226a.addURI(d10.getAuthority(), d10.getPath(), 5);
            Uri e10 = h.e(context);
            this.f15226a.addURI(e10.getAuthority(), e10.getPath(), 10);
            Uri c10 = h.c(context);
            this.f15226a.addURI(c10.getAuthority(), c10.getPath(), 2);
            return true;
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
            return true;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            int match = this.f15226a.match(uri);
            if (match == 2) {
                MatrixCursor matrixCursor = new MatrixCursor(new String[]{"k", "v"});
                Map<String, ?> all = bc.a().f15495a.getAll();
                if (strArr2 != null) {
                    if (strArr2.length != 0) {
                        for (String str3 : strArr2) {
                            Object obj = all.get(str3);
                            if (obj instanceof String) {
                                matrixCursor.addRow(new Object[]{str3, obj});
                            }
                        }
                        return matrixCursor;
                    }
                }
                for (String next : all.keySet()) {
                    Object obj2 = all.get(next);
                    if (obj2 instanceof String) {
                        matrixCursor.addRow(new Object[]{next, obj2});
                    }
                }
                return matrixCursor;
            } else if (match == 3) {
                SQLiteDatabase readableDatabase = a().getReadableDatabase();
                if (readableDatabase == null) {
                    return null;
                }
                return readableDatabase.query("MsgAlias", strArr, str, strArr2, (String) null, (String) null, str2);
            } else if (match == 5) {
                SQLiteDatabase readableDatabase2 = b().getReadableDatabase();
                if (readableDatabase2 == null) {
                    return null;
                }
                return readableDatabase2.query("MsgLogStore", strArr, str, strArr2, (String) null, (String) null, str2);
            } else if (match != 10) {
                return null;
            } else {
                SQLiteDatabase readableDatabase3 = b().getReadableDatabase();
                if (readableDatabase3 == null) {
                    return null;
                }
                return readableDatabase3.query("InAppLogStore", strArr, str, strArr2, (String) null, (String) null, str2);
            }
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            int match = this.f15226a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase writableDatabase = a().getWritableDatabase();
                    if (writableDatabase != null) {
                        return writableDatabase.updateWithOnConflict("MsgAlias", contentValues, str, strArr, 5);
                    }
                } else if (match == 10) {
                    SQLiteDatabase writableDatabase2 = b().getWritableDatabase();
                    if (writableDatabase2 != null) {
                        return writableDatabase2.updateWithOnConflict("InAppLogStore", contentValues, str, strArr, 5);
                    }
                }
            } else if (!(contentValues == null || strArr == null || strArr.length == 0)) {
                String str2 = strArr[0];
                String asString = contentValues.getAsString("v");
                if (!TextUtils.isEmpty(str2)) {
                    bc.a().a(str2, asString);
                    return 1;
                }
            }
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
        return 0;
    }

    private a a() {
        if (this.f15227b == null) {
            synchronized (a.class) {
                if (this.f15227b == null) {
                    this.f15227b = new a(getContext());
                }
            }
        }
        return this.f15227b;
    }

    /* access modifiers changed from: private */
    public static boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(String.format("select count(*) as c from sqlite_master where type = 'table' and name = '%s'", new Object[]{str.trim()}), (String[]) null);
            if (rawQuery != null) {
                if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                    z10 = true;
                }
                rawQuery.close();
            }
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
        return z10;
    }
}
