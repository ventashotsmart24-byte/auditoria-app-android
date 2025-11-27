package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f14588a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String f14589b = "umeng+";

    /* renamed from: c  reason: collision with root package name */
    private static final String f14590c = "ek__id";

    /* renamed from: d  reason: collision with root package name */
    private static final String f14591d = "ek_key";

    /* renamed from: e  reason: collision with root package name */
    private static String f14592e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final String f14593f = bd.b().b(bd.f13854n);

    /* renamed from: g  reason: collision with root package name */
    private static String f14594g = "";

    /* renamed from: h  reason: collision with root package name */
    private static a f14595h;

    private a() {
    }

    public static a a() {
        if (f14595h == null) {
            synchronized (a.class) {
                if (f14595h == null) {
                    f14595h = new a();
                }
            }
        }
        return f14595h;
    }

    private String c(String str) {
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < substring.length(); i10++) {
                char charAt = substring.charAt(i10);
                if (!Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                }
            }
            String sb2 = sb.toString();
            return sb2 + new StringBuilder(sb2).reverse().toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String b(String str) {
        String str2;
        String str3;
        try {
            if (TextUtils.isEmpty(f14588a)) {
                return str;
            }
            return new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f14588a.getBytes()));
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            String str4 = null;
            if (TextUtils.isEmpty(f14592e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str5 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f14592e.getBytes()));
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str5;
                } catch (Exception unused2) {
                    str4 = str5;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str3 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f14594g.getBytes()));
                        try {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                            return str3;
                        } catch (Throwable unused3) {
                            str2 = str3;
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                            return str2;
                        }
                    } catch (Throwable unused4) {
                        str2 = str4;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str2;
                    }
                }
            } catch (Exception unused5) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                str3 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f14594g.getBytes()));
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                return str3;
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f14588a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f14590c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f14592e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f14592e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f14593f, 0);
                if (sharedPreferences != null) {
                    f14594g = sharedPreferences.getString(f14590c, (String) null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f14594g);
                }
                f14588a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f14588a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f14588a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f14588a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
