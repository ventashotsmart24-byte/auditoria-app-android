package i2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;
import t9.i;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f7018a = new f();

    public final long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "addr"
            t9.i.g(r9, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 0
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            java.lang.String r3 = ":"
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r9
            int r0 = ba.t.y(r2, r3, r4, r5, r6, r7)
            r2 = -1
            if (r0 == r2) goto L_0x006f
            ba.i r0 = new ba.i
            java.lang.String r2 = ":"
            r0.<init>((java.lang.String) r2)
            java.util.List r0 = r0.e(r9, r1)
            boolean r2 = r0.isEmpty()
            r3 = 1
            if (r2 != 0) goto L_0x0056
            int r2 = r0.size()
            java.util.ListIterator r2 = r0.listIterator(r2)
        L_0x0035:
            boolean r4 = r2.hasPrevious()
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r2.previous()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0049
            r4 = 1
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            if (r4 != 0) goto L_0x0035
            int r2 = r2.nextIndex()
            int r2 = r2 + r3
            java.util.List r0 = i9.r.D(r0, r2)
            goto L_0x005a
        L_0x0056:
            java.util.List r0 = i9.j.d()
        L_0x005a:
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.Object[] r0 = r0.toArray(r2)
            java.lang.String[] r0 = (java.lang.String[]) r0
            if (r0 == 0) goto L_0x006f
            int r2 = r0.length
            if (r2 != 0) goto L_0x0069
            r2 = 1
            goto L_0x006a
        L_0x0069:
            r2 = 0
        L_0x006a:
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x006f
            r9 = r0[r1]
        L_0x006f:
            int r0 = r9.length()
            r2 = 7
            if (r0 < r2) goto L_0x0096
            int r0 = r9.length()
            r2 = 15
            if (r0 > r2) goto L_0x0096
            java.lang.String r0 = ""
            boolean r0 = t9.i.b(r0, r9)
            if (r0 == 0) goto L_0x0087
            goto L_0x0096
        L_0x0087:
            java.lang.String r0 = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r9 = r0.matcher(r9)
            boolean r9 = r9.find()
            return r9
        L_0x0096:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.f.b(java.lang.String):boolean");
    }

    public final boolean c(Context context) {
        i.g(context, com.umeng.analytics.pro.f.X);
        Object systemService = context.getSystemService("connectivity");
        i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }
}
