package p5;

import android.os.Build;
import android.text.TextUtils;
import t9.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19295a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final String f19296b = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static final String f19297c = "EMUI";

    /* renamed from: d  reason: collision with root package name */
    public static final String f19298d = "ro.build.version.emui";

    public final boolean a() {
        if (!f()) {
            return false;
        }
        return true;
    }

    public final boolean b() {
        if (g()) {
            return true;
        }
        return false;
    }

    public final String c() {
        String str = Build.MANUFACTURER;
        i.f(str, "MANUFACTURER");
        return str;
    }

    public final String d(String str) {
        i.g(str, "romType");
        if (i.b(str, f19297c)) {
            return e(f19298d);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063 A[SYNTHETIC, Splitter:B:18:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088 A[SYNTHETIC, Splitter:B:28:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0097 A[SYNTHETIC, Splitter:B:36:0x0097] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0070=Splitter:B:25:0x0070, B:15:0x004b=Splitter:B:15:0x004b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String e(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Exception while closing InputStream"
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            r3.<init>()     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            java.lang.String r4 = "getprop "
            r3.append(r4)     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            r3.append(r8)     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            r2 = 1024(0x400, float:1.435E-42)
            r3.<init>(r4, r2)     // Catch:{ IOException -> 0x006e, IllegalStateException -> 0x0049, all -> 0x0047 }
            java.lang.String r2 = r3.readLine()     // Catch:{ IOException -> 0x0045, IllegalStateException -> 0x0043 }
            java.lang.String r4 = "input.readLine()"
            t9.i.f(r2, r4)     // Catch:{ IOException -> 0x0045, IllegalStateException -> 0x0043 }
            r3.close()     // Catch:{ IOException -> 0x0045, IllegalStateException -> 0x0043 }
            r3.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0042
        L_0x003c:
            r8 = move-exception
            java.lang.String r1 = f19296b
            android.util.Log.e(r1, r0, r8)
        L_0x0042:
            return r2
        L_0x0043:
            r2 = move-exception
            goto L_0x004b
        L_0x0045:
            r2 = move-exception
            goto L_0x0070
        L_0x0047:
            r8 = move-exception
            goto L_0x0095
        L_0x0049:
            r2 = move-exception
            r3 = r1
        L_0x004b:
            java.lang.String r4 = f19296b     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r5.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r6 = "Illegal state and Unable to read sysprop "
            r5.append(r6)     // Catch:{ all -> 0x0093 }
            r5.append(r8)     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0093 }
            android.util.Log.e(r4, r8, r2)     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x006d
            r3.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006d
        L_0x0067:
            r8 = move-exception
            java.lang.String r2 = f19296b
            android.util.Log.e(r2, r0, r8)
        L_0x006d:
            return r1
        L_0x006e:
            r2 = move-exception
            r3 = r1
        L_0x0070:
            java.lang.String r4 = f19296b     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r5.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r6 = "Unable to read sysprop "
            r5.append(r6)     // Catch:{ all -> 0x0093 }
            r5.append(r8)     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0093 }
            android.util.Log.e(r4, r8, r2)     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x0092
            r3.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0092
        L_0x008c:
            r8 = move-exception
            java.lang.String r2 = f19296b
            android.util.Log.e(r2, r0, r8)
        L_0x0092:
            return r1
        L_0x0093:
            r8 = move-exception
            r1 = r3
        L_0x0095:
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x00a1
        L_0x009b:
            r1 = move-exception
            java.lang.String r2 = f19296b
            android.util.Log.e(r2, r0, r1)
        L_0x00a1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.a.e(java.lang.String):java.lang.String");
    }

    public final boolean f() {
        if (!h() || Build.VERSION.SDK_INT >= 21) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        String d10 = d(f19297c);
        if (!TextUtils.isEmpty(d10)) {
            return i.b(d10, "EmotionUI_3.1");
        }
        return false;
    }

    public final boolean h() {
        String c10 = c();
        if (!TextUtils.isEmpty(c10) && i.b(c10, "OPPO")) {
            return true;
        }
        return false;
    }
}
