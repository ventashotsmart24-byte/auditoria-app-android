package u1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.advertlib.bean.AdReportBean;
import com.advertlib.bean.AdReportBeanWrapper;
import com.hpplay.component.protocol.PlistBuilder;
import com.umeng.analytics.pro.f;
import h9.t;
import java.util.Iterator;
import java.util.List;
import t9.g;
import t9.i;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final C0127a f9417c = new C0127a((g) null);

    /* renamed from: d  reason: collision with root package name */
    public static final String f9418d = "adtable";

    /* renamed from: e  reason: collision with root package name */
    public static final String f9419e = "id";

    /* renamed from: f  reason: collision with root package name */
    public static final String f9420f = "ad_id";

    /* renamed from: g  reason: collision with root package name */
    public static final String f9421g = "ad_name";

    /* renamed from: h  reason: collision with root package name */
    public static final String f9422h = "display_times";

    /* renamed from: i  reason: collision with root package name */
    public static final String f9423i = "click_times";

    /* renamed from: j  reason: collision with root package name */
    public static final String f9424j = "user_name";

    /* renamed from: k  reason: collision with root package name */
    public static final String f9425k = "apk_version";

    /* renamed from: l  reason: collision with root package name */
    public static final String f9426l = "media_type";

    /* renamed from: m  reason: collision with root package name */
    public static final String f9427m = "ad_type";

    /* renamed from: n  reason: collision with root package name */
    public static final String f9428n = "last_update_timestamp";

    /* renamed from: o  reason: collision with root package name */
    public static final String f9429o = "game_stay_time";

    /* renamed from: a  reason: collision with root package name */
    public b f9430a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f9431b;

    /* renamed from: u1.a$a  reason: collision with other inner class name */
    public static final class C0127a {
        public C0127a() {
        }

        public /* synthetic */ C0127a(g gVar) {
            this();
        }

        public final String a() {
            return a.f9420f;
        }

        public final String b() {
            return a.f9421g;
        }

        public final String c() {
            return a.f9427m;
        }

        public final String d() {
            return a.f9425k;
        }

        public final String e() {
            return a.f9423i;
        }

        public final String f() {
            return a.f9422h;
        }

        public final String g() {
            return a.f9429o;
        }

        public final String h() {
            return a.f9419e;
        }

        public final String i() {
            return a.f9428n;
        }

        public final String j() {
            return a.f9426l;
        }

        public final String k() {
            return a.f9424j;
        }

        public final String l() {
            return a.f9418d;
        }
    }

    public a(Context context) {
        i.g(context, f.X);
        b bVar = new b(context);
        this.f9430a = bVar;
        SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
        i.f(writableDatabase, "adHelper.writableDatabase");
        this.f9431b = writableDatabase;
    }

    /* JADX INFO: finally extract failed */
    public final void m(List list) {
        i.g(list, "ids");
        synchronized (this) {
            String[] strArr = {""};
            this.f9431b.beginTransaction();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    strArr[0] = String.valueOf(((Number) it.next()).intValue());
                    SQLiteDatabase sQLiteDatabase = this.f9431b;
                    String str = f9418d;
                    sQLiteDatabase.delete(str, f9419e + "=?", strArr);
                }
                this.f9431b.setTransactionSuccessful();
                this.f9431b.endTransaction();
                t tVar = t.f17319a;
            } catch (Throwable th) {
                this.f9431b.endTransaction();
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List n() {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            monitor-enter(r4)     // Catch:{ Exception -> 0x003d }
            android.database.sqlite.SQLiteDatabase r1 = r4.f9431b     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r2.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r3 = "SELECT * FROM "
            r2.append(r3)     // Catch:{ all -> 0x003a }
            java.lang.String r3 = f9418d     // Catch:{ all -> 0x003a }
            r2.append(r3)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x003a }
            r3 = 0
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ all -> 0x003a }
        L_0x0020:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0033
            java.lang.String r2 = "cursor"
            t9.i.f(r1, r2)     // Catch:{ all -> 0x003a }
            com.advertlib.bean.AdReportBeanWrapper r2 = r4.o(r1)     // Catch:{ all -> 0x003a }
            r0.add(r2)     // Catch:{ all -> 0x003a }
            goto L_0x0020
        L_0x0033:
            r1.close()     // Catch:{ all -> 0x003a }
            h9.t r1 = h9.t.f17319a     // Catch:{ all -> 0x003a }
            monitor-exit(r4)     // Catch:{ Exception -> 0x003d }
            goto L_0x0041
        L_0x003a:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ Exception -> 0x003d }
            throw r1     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.a.n():java.util.List");
    }

    public final AdReportBeanWrapper o(Cursor cursor) {
        Cursor cursor2 = cursor;
        int i10 = cursor2.getInt(cursor2.getColumnIndex(f9419e));
        String string = cursor2.getString(cursor2.getColumnIndex(f9420f));
        i.f(string, "cursor.getString(cursor.…ColumnIndex(FIELD_AD_ID))");
        String string2 = cursor2.getString(cursor2.getColumnIndex(f9421g));
        i.f(string2, "cursor.getString(cursor.…lumnIndex(FIELD_AD_NAME))");
        int i11 = cursor2.getInt(cursor2.getColumnIndex(f9422h));
        int i12 = cursor2.getInt(cursor2.getColumnIndex(f9423i));
        String string3 = cursor2.getString(cursor2.getColumnIndex(f9424j));
        i.f(string3, "cursor.getString(cursor.…mnIndex(FIELD_USER_NAME))");
        int i13 = cursor2.getInt(cursor2.getColumnIndex(f9425k));
        String string4 = cursor2.getString(cursor2.getColumnIndex(f9426l));
        i.f(string4, "cursor.getString(cursor.…nIndex(FIELD_MEDIA_TYPE))");
        String string5 = cursor2.getString(cursor2.getColumnIndex(f9427m));
        i.f(string5, "cursor.getString(cursor.…lumnIndex(FIELD_AD_TYPE))");
        long j10 = cursor2.getLong(cursor2.getColumnIndex(f9428n));
        long j11 = cursor2.getLong(cursor2.getColumnIndex(f9429o));
        AdReportBean adReportBean = r3;
        AdReportBean adReportBean2 = new AdReportBean(string, string2, i11, i12, "unknown", "unknown", string3, i13, "unknown", string4, string5, j10, j11);
        return new AdReportBeanWrapper(i10, adReportBean);
    }

    public final void p(ContentValues contentValues, AdReportBean adReportBean) {
        contentValues.put(f9420f, adReportBean.getAd_id());
        String str = f9421g;
        String ad_name = adReportBean.getAd_name();
        if (ad_name == null) {
            ad_name = "";
        }
        contentValues.put(str, ad_name);
        contentValues.put(f9422h, Integer.valueOf(adReportBean.getDisplay_times()));
        contentValues.put(f9423i, Integer.valueOf(adReportBean.getClick_times()));
        contentValues.put(f9424j, adReportBean.getUser_name());
        contentValues.put(f9425k, Integer.valueOf(adReportBean.getApk_version()));
        contentValues.put(f9426l, adReportBean.getMedia_type());
        contentValues.put(f9427m, adReportBean.getAd_type());
        contentValues.put(f9428n, Long.valueOf(adReportBean.getLast_update_timestamp()));
        contentValues.put(f9429o, Long.valueOf(adReportBean.getGame_stay_time()));
    }

    public final void q(AdReportBean adReportBean) {
        i.g(adReportBean, PlistBuilder.KEY_ITEM);
        ContentValues contentValues = new ContentValues();
        p(contentValues, adReportBean);
        synchronized (this) {
            this.f9431b.insert(f9418d, (String) null, contentValues);
        }
    }
}
