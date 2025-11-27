package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f14974a;

    /* renamed from: b  reason: collision with root package name */
    private String f14975b;

    /* renamed from: c  reason: collision with root package name */
    private String f14976c;

    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a  reason: collision with other inner class name */
    public static class C0204a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f14977a = new a();

        private C0204a() {
        }
    }

    public static a a(Context context) {
        if (f14974a == null && context != null) {
            f14974a = context.getApplicationContext();
        }
        return C0204a.f14977a;
    }

    private void f(String str) {
        try {
            String replaceAll = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", Operator.Operation.DIVISION);
            this.f14975b = replaceAll + Operator.Operation.DIVISION + "Android" + " " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f14974a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f14974a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("&=");
                StringBuilder sb = new StringBuilder();
                sb.append(bt.aW);
                for (String str3 : split) {
                    if (!TextUtils.isEmpty(str3)) {
                        String substring = str3.substring(0, 2);
                        if (substring.endsWith(Operator.Operation.EQUALS)) {
                            substring = substring.replace(Operator.Operation.EQUALS, "");
                        }
                        sb.append(substring);
                    }
                }
                this.f14976c = sb.toString();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f14974a, th);
        }
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith("t");
        }
        return false;
    }

    public boolean c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(bt.aJ);
        }
        return false;
    }

    public boolean d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith("h");
        }
        return false;
    }

    public void e(String str) {
        String substring = str.substring(0, str.indexOf(95));
        g(substring);
        f(substring);
    }

    private a() {
        this.f14975b = null;
        this.f14976c = null;
    }

    public String b() {
        return this.f14975b;
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith("a");
        }
        return false;
    }

    public String a() {
        return this.f14976c;
    }
}
