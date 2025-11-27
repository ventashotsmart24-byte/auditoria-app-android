package com.ixuea.android.downloader.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.analytics.pro.bx;
import java.util.ArrayList;
import java.util.List;
import x4.a;
import x4.b;

public final class DefaultDownloadDBController implements b {

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f11922d = {bx.f13988d, "supportRanges", "createAt", "uri", "path", "size", "progress", Constant.KEY_STATUS, "breakPointCount"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f11923e = {bx.f13988d, "threadId", "downloadInfoId", "uri", "start", "end", "progress"};

    /* renamed from: f  reason: collision with root package name */
    public static final String f11924f = String.format("REPLACE INTO %s (_id,threadId,downloadInfoId,uri,start,end,progress) VALUES(?,?,?,?,?,?,?);", new Object[]{"download_thread_info"});

    /* renamed from: g  reason: collision with root package name */
    public static final String f11925g = String.format("REPLACE INTO %s (_id,supportRanges,createAt,uri,path,size,progress,status,breakPointCount) VALUES(?,?,?,?,?,?,?,?,?);", new Object[]{"download_info"});

    /* renamed from: h  reason: collision with root package name */
    public static final String f11926h = String.format("UPDATE %s SET status=? WHERE status!=?;", new Object[]{"download_info"});

    /* renamed from: a  reason: collision with root package name */
    public final a f11927a;

    /* renamed from: b  reason: collision with root package name */
    public final SQLiteDatabase f11928b;

    /* renamed from: c  reason: collision with root package name */
    public final SQLiteDatabase f11929c;

    public DefaultDownloadDBController(Context context, t4.a aVar) {
        a aVar2 = new a(context, aVar);
        this.f11927a = aVar2;
        this.f11928b = aVar2.getWritableDatabase();
        this.f11929c = aVar2.getReadableDatabase();
    }

    public void a(y4.a aVar) {
        this.f11928b.delete("download_info", "_id=?", new String[]{String.valueOf(aVar.g())});
        this.f11928b.delete("download_thread_info", "downloadInfoId=?", new String[]{String.valueOf(aVar.g())});
    }

    public List b() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = this.f11929c.query("download_info", f11922d, "status!=?", new String[]{String.valueOf(5)}, (String) null, (String) null, "createAt desc");
            while (query.moveToNext()) {
                y4.a aVar = new y4.a();
                arrayList.add(aVar);
                h(query, aVar);
                Cursor query2 = this.f11929c.query("download_thread_info", f11923e, "downloadInfoId=?", new String[]{String.valueOf(aVar.g())}, (String) null, (String) null, (String) null);
                ArrayList arrayList2 = new ArrayList();
                while (query2.moveToNext()) {
                    y4.b bVar = new y4.b();
                    arrayList2.add(bVar);
                    i(query2, bVar);
                }
                aVar.v(arrayList2);
            }
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }

    public y4.a c(String str) {
        try {
            Cursor query = this.f11929c.query("download_info", f11922d, "_id=?", new String[]{str}, (String) null, (String) null, "createAt desc");
            if (!query.moveToNext()) {
                return null;
            }
            y4.a aVar = new y4.a();
            h(query, aVar);
            return aVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public void d(y4.b bVar) {
        this.f11928b.delete("download_thread_info", "_id=?", new String[]{String.valueOf(bVar.d())});
    }

    public void e(y4.a aVar) {
        this.f11928b.execSQL(f11925g, new Object[]{aVar.g(), Integer.valueOf(aVar.l()), Long.valueOf(aVar.c()), aVar.m(), aVar.h(), Long.valueOf(aVar.j()), Long.valueOf(aVar.i()), Integer.valueOf(aVar.k()), Integer.valueOf(aVar.b())});
    }

    public void f(y4.b bVar) {
        this.f11928b.execSQL(f11924f, new Object[]{Integer.valueOf(bVar.d()), Integer.valueOf(bVar.g()), bVar.b(), bVar.h(), Long.valueOf(bVar.f()), Long.valueOf(bVar.c()), Long.valueOf(bVar.e())});
    }

    public void g() {
        this.f11928b.execSQL(f11926h, new Object[]{4, 5});
    }

    public final void h(Cursor cursor, y4.a aVar) {
        aVar.y(cursor.getString(0));
        aVar.D(cursor.getInt(1));
        aVar.t(cursor.getLong(2));
        aVar.F(cursor.getString(3));
        aVar.z(cursor.getString(4));
        aVar.B(cursor.getLong(5));
        aVar.A(cursor.getLong(6));
        aVar.C(cursor.getInt(7));
        aVar.s(cursor.getInt(8));
    }

    public final void i(Cursor cursor, y4.b bVar) {
        bVar.k(cursor.getInt(0));
        bVar.n(cursor.getInt(1));
        bVar.i(cursor.getString(2));
        bVar.o(cursor.getString(3));
        bVar.m(cursor.getLong(4));
        bVar.j(cursor.getLong(5));
        bVar.l(cursor.getLong(6));
    }
}
