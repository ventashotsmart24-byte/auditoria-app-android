package com.qiniu.android.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.qiniu.android.dns.a;
import com.umeng.analytics.pro.bd;
import java.util.Locale;
import o7.a;

public final class NetworkReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f12871a = Uri.parse("content://telephony/carriers/preferapn");

    /* renamed from: b  reason: collision with root package name */
    public static a f12872b;

    public static a a(NetworkInfo networkInfo, Context context) {
        a.C0191a aVar;
        String extraInfo;
        if (networkInfo == null) {
            return a.f12873c;
        }
        int i10 = 0;
        if (networkInfo.getType() == 1) {
            aVar = a.C0191a.WIFI;
        } else {
            a.C0191a aVar2 = a.C0191a.MOBILE;
            Cursor query = context.getContentResolver().query(f12871a, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query != null) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(bd.f13853m));
                if (!TextUtils.isEmpty(string) && (string.startsWith("ctwap") || string.startsWith("ctnet"))) {
                    i10 = 1;
                }
            }
            query.close();
            if (!(i10 == 1 || (extraInfo = networkInfo.getExtraInfo()) == null)) {
                String lowerCase = extraInfo.toLowerCase(Locale.getDefault());
                if (lowerCase.equals("cmwap") || lowerCase.equals("cmnet")) {
                    i10 = 3;
                } else if (lowerCase.equals("3gnet") || lowerCase.equals("uninet") || lowerCase.equals("3gwap") || lowerCase.equals("uniwap")) {
                    i10 = 2;
                }
            }
            aVar = aVar2;
        }
        return new a(aVar, i10);
    }

    public void onReceive(Context context, Intent intent) {
        if (f12872b != null) {
            f12872b.d(a(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo(), context));
        }
    }
}
