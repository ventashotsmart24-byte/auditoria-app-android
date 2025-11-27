package com.uyumao;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public static volatile o f16296a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f16297b;

    /* renamed from: c  reason: collision with root package name */
    public final a f16298c = new a(this, "AZX");

    public o(Context context) {
        this.f16297b = context.getApplicationContext();
    }

    public void a(long j10) {
        a aVar = this.f16298c;
        aVar.b("smart_" + bt.f13907ba, j10);
        a aVar2 = this.f16298c;
        aVar2.b("smart_" + "ts", System.currentTimeMillis());
    }

    public final boolean a(String str) {
        a aVar = this.f16298c;
        long a10 = aVar.a(str + bt.f13907ba, 0);
        if (a10 <= 0) {
            return true;
        }
        a aVar2 = this.f16298c;
        if (Math.abs(System.currentTimeMillis() - aVar2.a(str + "ts", 0)) / 1000 >= a10) {
            return true;
        }
        return false;
    }

    public long a() {
        return this.f16298c.a("smart_lc", 0);
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f16299a;

        public a(o oVar, String str) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "_";
            }
            this.f16299a = str;
        }

        public final void a(String str, String str2) {
            try {
                if (n.c(e.f16271a)) {
                    m a10 = m.a();
                    a10.getClass();
                    if (!TextUtils.isEmpty(str)) {
                        a10.f16291b.edit().putString(str, str2).apply();
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public void b(String str, long j10) {
            a(this.f16299a + str, String.valueOf(j10));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
            r3.printStackTrace();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long a(java.lang.String r3, long r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r2.f16299a
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                java.lang.String r0 = java.lang.String.valueOf(r4)
                android.content.Context r1 = com.uyumao.e.f16271a     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
                boolean r1 = com.uyumao.n.c(r1)     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
                if (r1 == 0) goto L_0x002e
                com.uyumao.m r1 = com.uyumao.m.a()     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
                android.content.SharedPreferences r1 = r1.f16291b     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
                java.lang.String r0 = r1.getString(r3, r0)     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
                goto L_0x002e
            L_0x0028:
                r3 = move-exception
                throw r3
            L_0x002a:
                r3 = move-exception
                r3.printStackTrace()
            L_0x002e:
                long r3 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0033 }
                return r3
            L_0x0033:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uyumao.o.a.a(java.lang.String, long):long");
        }
    }
}
