package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

class bm implements be {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13895a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    public String a(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(Uri.parse(f13895a), (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null) {
            if (query.moveToNext()) {
                str = query.getString(query.getColumnIndex("device_ids_grndid"));
            }
            query.close();
        }
        return str;
    }
}
