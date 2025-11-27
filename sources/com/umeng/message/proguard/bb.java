package com.umeng.message.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;

public final class bb {

    /* renamed from: b  reason: collision with root package name */
    private static bb f15489b;

    /* renamed from: a  reason: collision with root package name */
    public final Context f15490a;

    private bb(Context context) {
        this.f15490a = context.getApplicationContext();
    }

    public static bb a(Context context) {
        if (f15489b == null) {
            f15489b = new bb(context);
        }
        return f15489b;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f15491a;

        /* renamed from: b  reason: collision with root package name */
        public long f15492b;

        /* renamed from: c  reason: collision with root package name */
        public int f15493c;

        public a(String str, int i10, long j10) {
            this.f15491a = str;
            this.f15493c = i10;
            this.f15492b = j10;
        }

        public final ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("MsgId", this.f15491a);
            contentValues.put("Time", Long.valueOf(this.f15492b));
            contentValues.put("ActionType", Integer.valueOf(this.f15493c));
            return contentValues;
        }

        public a(Cursor cursor) {
            this.f15491a = cursor.getString(cursor.getColumnIndex("MsgId"));
            this.f15492b = cursor.getLong(cursor.getColumnIndex("Time"));
            this.f15493c = cursor.getInt(cursor.getColumnIndex("ActionType"));
        }
    }

    public final void a(String str, int i10, long j10) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f15490a.getContentResolver().insert(h.d(this.f15490a), new a(str, i10, j10).a());
            } catch (Exception e10) {
                UPLog.e("MsgLog", (Throwable) e10);
            }
        }
    }
}
