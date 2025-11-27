package com.umeng.message.proguard;

import android.util.Log;
import anet.channel.util.ALog;
import com.taobao.accs.utl.ALog;

public final class q implements ALog.ILog, ALog.ILog {

    /* renamed from: c  reason: collision with root package name */
    private static final q f16013c = new q();

    /* renamed from: a  reason: collision with root package name */
    public boolean f16014a = false;

    /* renamed from: b  reason: collision with root package name */
    public final p f16015b = new p();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f16016d = "1".equals(d.k());

    private q() {
    }

    public static q a() {
        return f16013c;
    }

    private static void b(int i10, String str, String str2) {
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                Log.println(i10, str, str2);
                return;
            default:
                return;
        }
    }

    public final void d(String str, String str2) {
        if (this.f16014a) {
            a(3, str, str2);
        }
    }

    public final void e(String str, String str2) {
        if (this.f16016d || this.f16014a) {
            a(6, str, str2);
        }
        if (this.f16015b.a()) {
            this.f16015b.a(6, str, str2);
        }
    }

    public final void i(String str, String str2) {
        if (this.f16016d || this.f16014a) {
            a(4, str, str2);
        }
        if (this.f16015b.a()) {
            this.f16015b.a(4, str, str2);
        }
    }

    public final boolean isPrintLog(int i10) {
        return true;
    }

    public final boolean isValid() {
        return true;
    }

    public final void setLogLevel(int i10) {
    }

    public final void w(String str, String str2) {
        if (this.f16016d || this.f16014a) {
            a(5, str, str2);
        }
        if (this.f16015b.a()) {
            this.f16015b.a(5, str, str2);
        }
    }

    private static void a(int i10, String str, String str2) {
        if (str2 != null) {
            while (str2.length() > 3072) {
                b(i10, str, str2.substring(0, 3072));
                str2 = str2.substring(3072);
            }
            if (str2.length() > 0) {
                b(i10, str, str2);
            }
        }
    }

    public final void e(String str, String str2, Throwable th) {
        if (this.f16016d || this.f16014a) {
            a(6, str, str2 + "\n" + Log.getStackTraceString(th));
        }
        if (this.f16015b.a()) {
            p pVar = this.f16015b;
            pVar.a(6, str, str2 + "\n" + Log.getStackTraceString(th));
        }
    }

    public final void w(String str, String str2, Throwable th) {
        if (this.f16016d || this.f16014a) {
            a(5, str, str2 + "\n" + Log.getStackTraceString(th));
        }
        if (this.f16015b.a()) {
            p pVar = this.f16015b;
            pVar.a(5, str, str2 + "\n" + Log.getStackTraceString(th));
        }
    }
}
