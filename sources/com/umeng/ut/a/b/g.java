package com.umeng.ut.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.ut.a.a.b;
import com.umeng.ut.a.c.c;
import com.umeng.ut.a.c.e;
import com.umeng.ut.b.b.a;
import com.umeng.ut.b.b.d;

public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f16225a = false;

    /* renamed from: a  reason: collision with other field name */
    private Context f60a;

    public g(Context context) {
        this.f60a = context;
    }

    private void a() {
        e.c();
        if (c.b(this.f60a) && !f16225a) {
            f16225a = true;
            if (d.a(this.f60a).b()) {
                try {
                    b();
                } catch (Throwable unused) {
                }
                f16225a = false;
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private void m29b() {
        e.c();
        String b10 = b();
        if (TextUtils.isEmpty(b10)) {
            e.a("postData is empty", new Object[0]);
        } else if (a(b10)) {
            e.a("", "upload success");
        } else {
            e.a("", "upload fail");
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r3 = this;
            long r0 = com.umeng.ut.b.b.a.b()     // Catch:{ Exception -> 0x000a }
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x000a }
            goto L_0x000a
        L_0x0008:
            r0 = move-exception
            goto L_0x000e
        L_0x000a:
            r3.a()     // Catch:{ all -> 0x0008 }
            goto L_0x0016
        L_0x000e:
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = ""
            com.umeng.ut.a.c.e.a(r2, r0, r1)
        L_0x0016:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.a.b.g.run():void");
    }

    private boolean a(String str) {
        a a10 = b.a("https://audid.umeng.com/v3/a/audid/req", str, true);
        if (a10 == null) {
            return false;
        }
        return com.umeng.ut.b.b.e.a(a10);
    }

    private String b() {
        String i10 = a.a().i();
        if (TextUtils.isEmpty(i10)) {
            return null;
        }
        String a10 = com.umeng.ut.a.a.a.a(i10);
        if (e.a()) {
            e.b("", a10);
        }
        return b.b(a10);
    }
}
