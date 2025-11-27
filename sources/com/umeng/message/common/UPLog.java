package com.umeng.message.common;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.p;
import com.umeng.message.proguard.q;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class UPLog {
    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "UPush";
        }
        return "UPush.".concat(String.valueOf(str));
    }

    public static void d(String str, Object... objArr) {
        q.a().d(a(str), a(objArr));
    }

    public static void e(String str, Object... objArr) {
        q.a().e(a(str), a(objArr));
    }

    public static String getStackTrace(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void i(String str, Object... objArr) {
        q.a().i(a(str), a(objArr));
    }

    public static boolean isEnable() {
        return q.a().f16014a;
    }

    public static void setEnable(boolean z10) {
        q.a().f16014a = z10;
    }

    public static void upload() {
        q a10 = q.a();
        if (f.f15950b) {
            p pVar = a10.f16015b;
            if (!pVar.f15994b) {
                b.b(new Runnable(pVar) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ p f16002a;

                    {
                        this.f16002a = r2;
                    }

                    public final void run() {
                        boolean z10;
                        long j10;
                        Application a10 = y.a();
                        if (UMUtils.isMainProgress(a10)) {
                            MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a10);
                            String c10 = instance.c();
                            if (TextUtils.isEmpty(c10)) {
                                UPLog.d("Log", "init skipped.");
                                return;
                            }
                            String l10 = instance.l();
                            String e10 = d.e(a10);
                            if (TextUtils.isEmpty(l10) && TextUtils.isEmpty(e10)) {
                                UPLog.d("Log", "id skipped.");
                            } else if (!instance.a("l_u_q")) {
                                UPLog.i("Log", "req skipped.");
                            } else {
                                JSONObject a11 = b.a(c10, l10, e10);
                                long j11 = 86400;
                                if (a11 != null) {
                                    z10 = a11.optBoolean("enable");
                                    j11 = Math.max(60, a11.optLong(bt.f13907ba, 86400));
                                } else {
                                    z10 = false;
                                }
                                boolean m10 = instance.m();
                                instance.f15211b.a("l_u_e", z10);
                                instance.a("l_u_q", j11);
                                if (z10) {
                                    AnonymousClass1 r12 = new Runnable() {
                                        public final void run() {
                                            File file;
                                            try {
                                                b bVar = b.this;
                                                Application a10 = y.a();
                                                File file2 = new File(a10.getFilesDir(), ".upush_log");
                                                file = new File(file2, new SimpleDateFormat("yyMMddHHmmssSSS", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())));
                                                bVar.a(file2, file);
                                                if (file.length() < 512) {
                                                    UPLog.i("Log", "len small skipped! ", Long.valueOf(file.length()));
                                                    bm.a(file.getPath());
                                                } else if (file.length() > 1048576) {
                                                    UPLog.i("Log", "len large skipped! ", Long.valueOf(file.length()));
                                                    bm.a(file.getPath());
                                                } else {
                                                    String messageAppkey = PushAgent.getInstance(a10).getMessageAppkey();
                                                    JSONObject jSONObject = new JSONObject();
                                                    jSONObject.put("appkey", messageAppkey);
                                                    jSONObject.put("utdid", d.o(a10));
                                                    jSONObject.put(bt.f13913g, d.k(a10));
                                                    jSONObject.put("device_token", PushAgent.getInstance(a10).getRegistrationId());
                                                    jSONObject.put("md5", UMUtils.getFileMD5(file));
                                                    jSONObject.put("ts", System.currentTimeMillis());
                                                    jSONObject.put("app_v", d.b(a10));
                                                    jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                                                    jSONObject.put("os_v", Build.VERSION.RELEASE);
                                                    jSONObject.put(Constants.KEY_BRAND, d.f());
                                                    jSONObject.put(Constants.KEY_MODEL, d.d());
                                                    jSONObject.put("android_id", d.e(a10));
                                                    jSONObject.put(bt.al, UMUtils.getZid(a10));
                                                    jSONObject.put("os_i", Build.VERSION.SDK_INT);
                                                    g.a(jSONObject, "https://offmsg.umeng.com/log/upload", messageAppkey, file);
                                                    bm.a(file.getPath());
                                                }
                                            } catch (Throwable th) {
                                                UPLog.i("Log", UPLog.getStackTrace(th));
                                            }
                                        }
                                    };
                                    if (m10) {
                                        j10 = 0;
                                    } else {
                                        j10 = 1;
                                    }
                                    b.b(r12, j10, TimeUnit.MINUTES);
                                } else {
                                    UPLog.i("Log", "enable skipped.");
                                }
                                this.f16002a.f15993a = Boolean.valueOf(z10);
                            }
                        }
                    }
                });
                pVar.f15994b = true;
            }
        }
    }

    public static void w(String str, Object... objArr) {
        q.a().w(a(str), a(objArr));
    }

    public static void e(String str, Throwable th) {
        q.a().e(a(str), getStackTrace(th));
    }

    public static void w(String str, Throwable th) {
        q.a().w(a(str), getStackTrace(th));
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(objArr[0]);
        for (int i10 = 1; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj != null) {
                sb.append(" ");
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
