package com.alibaba.sdk.android.httpdns.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class a {

    /* renamed from: i  reason: collision with root package name */
    private int f4932i;

    /* renamed from: q  reason: collision with root package name */
    private String f4933q;

    /* renamed from: com.alibaba.sdk.android.httpdns.c.a$a  reason: collision with other inner class name */
    public static final class C0071a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final a f4934b = new a();
    }

    private a() {
        this.f4932i = 0;
        this.f4933q = "UNKNOWN";
    }

    private int a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 0;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return 1;
                    }
                    if (activeNetworkInfo.getType() != 0) {
                        return 0;
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 15:
                            return 3;
                        case 13:
                            return 4;
                        default:
                            return 0;
                    }
                }
            }
            return 255;
        } catch (Exception unused) {
        }
    }

    private void d(Context context) {
        int a10 = a(context);
        this.f4932i = a10;
        this.f4933q = "sp_" + a10;
    }

    public void c(Context context) {
        d(context);
    }

    public int getNetworkType() {
        return this.f4932i;
    }

    public boolean h() {
        return this.f4932i == 1;
    }

    public String i() {
        return this.f4933q;
    }

    public static a a() {
        return C0071a.f4934b;
    }
}
