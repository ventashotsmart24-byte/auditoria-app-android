package com.alibaba.sdk.android.httpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.sdk.android.httpdns.b.b;
import java.util.ArrayList;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5005a = null;

    /* renamed from: i  reason: collision with root package name */
    static boolean f5006i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static String f5007j;

    /* access modifiers changed from: private */
    public static String f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) f5005a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                String typeName = activeNetworkInfo.getTypeName();
                i.d("[detectCurrentNetwork] - Network name:" + typeName + " subType name: " + activeNetworkInfo.getSubtypeName());
                return typeName == null ? "None_Network" : typeName;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return "None_Network";
    }

    public static void setContext(Context context) {
        if (context != null) {
            f5005a = context;
            AnonymousClass1 r22 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    try {
                        if (!isInitialStickyBroadcast() && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            b.b(context);
                            String g10 = p.f();
                            if (g10 != "None_Network" && !g10.equalsIgnoreCase(p.f5007j)) {
                                i.d("[BroadcastReceiver.onReceive] - Network state changed");
                                ArrayList a10 = d.a().a();
                                d.a().clear();
                                d.a().a();
                                if (p.f5006i && HttpDns.instance != null) {
                                    i.d("[BroadcastReceiver.onReceive] - refresh host");
                                    HttpDns.instance.setPreResolveHosts(a10);
                                }
                            }
                            String unused = p.f5007j = g10;
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            };
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f5005a.registerReceiver(r22, intentFilter);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else {
            throw new IllegalStateException("Context can't be null");
        }
    }
}
