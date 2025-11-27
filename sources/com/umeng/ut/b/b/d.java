package com.umeng.ut.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.taobao.accs.common.Constants;
import com.umeng.ut.a.a;
import com.umeng.ut.a.c.e;
import com.umeng.ut.b.a.a.b;
import com.umeng.ut.b.a.a.c;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.Config;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f16245a;

    /* renamed from: a  reason: collision with other field name */
    private static final Object f65a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Pattern f16246b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    /* renamed from: a  reason: collision with other field name */
    private Context f66a;

    /* renamed from: c  reason: collision with root package name */
    private String f16247c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f16248d = -1;

    private d(Context context) {
        this.f66a = context.getApplicationContext();
        a.a().a(this.f66a);
    }

    public static d a(Context context) {
        if (context != null && f16245a == null) {
            synchronized (f65a) {
                if (f16245a == null) {
                    f16245a = new d(context);
                }
            }
        }
        return f16245a;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !f16246b.matcher(str).find();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r0 > 7776000) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long c() {
        /*
            r5 = this;
            java.lang.String r0 = "um_push_ut"
            android.content.SharedPreferences r0 = r5.a((java.lang.String) r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r1 = "v_i"
            r2 = 604800(0x93a80, double:2.98811E-318)
            long r0 = r0.getLong(r1, r2)     // Catch:{ all -> 0x0010 }
            goto L_0x0012
        L_0x0010:
            r0 = 0
        L_0x0012:
            r2 = 600(0x258, double:2.964E-321)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x001a
        L_0x0018:
            r0 = r2
            goto L_0x0022
        L_0x001a:
            r2 = 7776000(0x76a700, double:3.8418545E-317)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0022
            goto L_0x0018
        L_0x0022:
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.b.b.d.c():long");
    }

    private void e() {
        try {
            a("um_push_ut").edit().remove("v_r").commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017 A[Catch:{ Exception -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052 A[Catch:{ Exception -> 0x0065 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String j() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.c()     // Catch:{ all -> 0x006c }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0014
            android.content.Context r0 = r4.f66a     // Catch:{ all -> 0x006c }
            boolean r0 = com.umeng.ut.a.c.a.a(r0)     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            if (r0 == 0) goto L_0x004c
            java.lang.String r3 = r4.l()     // Catch:{ all -> 0x006c }
            r4.f16247c = r3     // Catch:{ all -> 0x006c }
            boolean r3 = com.umeng.ut.b.a.a.d.isEmpty(r3)     // Catch:{ all -> 0x006c }
            if (r3 != 0) goto L_0x002f
            java.lang.String r3 = r4.f16247c     // Catch:{ all -> 0x006c }
            boolean r3 = r4.b(r3)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x002f
            java.lang.String r0 = r4.f16247c     // Catch:{ all -> 0x006c }
            monitor-exit(r4)
            return r0
        L_0x002f:
            java.lang.String r3 = r4.k()     // Catch:{ all -> 0x006c }
            r4.f16247c = r3     // Catch:{ all -> 0x006c }
            boolean r3 = com.umeng.ut.b.a.a.d.isEmpty(r3)     // Catch:{ all -> 0x006c }
            if (r3 != 0) goto L_0x004c
            java.lang.String r3 = r4.f16247c     // Catch:{ all -> 0x006c }
            boolean r3 = r4.b(r3)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x004c
            java.lang.String r0 = r4.f16247c     // Catch:{ all -> 0x006c }
            r4.a((java.lang.String) r0, (boolean) r1)     // Catch:{ all -> 0x006c }
            java.lang.String r0 = r4.f16247c     // Catch:{ all -> 0x006c }
            monitor-exit(r4)
            return r0
        L_0x004c:
            byte[] r1 = r4.a()     // Catch:{ Exception -> 0x0065 }
            if (r1 == 0) goto L_0x0069
            r3 = 2
            java.lang.String r1 = com.umeng.ut.b.a.a.a.a((byte[]) r1, (int) r3)     // Catch:{ Exception -> 0x0065 }
            r4.f16247c = r1     // Catch:{ Exception -> 0x0065 }
            r4.a((java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x0065 }
            if (r0 != 0) goto L_0x0061
            r4.e()     // Catch:{ Exception -> 0x0065 }
        L_0x0061:
            java.lang.String r0 = r4.f16247c     // Catch:{ Exception -> 0x0065 }
            monitor-exit(r4)
            return r0
        L_0x0065:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x006c }
        L_0x0069:
            monitor-exit(r4)
            r0 = 0
            return r0
        L_0x006c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.b.b.d.j():java.lang.String");
    }

    private String k() {
        try {
            SharedPreferences a10 = a(Config.PREFERENCES);
            String string = a10.getString("deviceId", (String) null);
            if (string == null || string.length() <= 0) {
                return null;
            }
            String string2 = a10.getString("utdid", (String) null);
            if (string2 != null) {
                try {
                    if (string2.length() == 0) {
                    }
                } catch (Throwable unused) {
                }
                return string2;
            }
            return a(Constants.SP_FILE_NAME).getString("utdid", (String) null);
        } catch (Throwable unused2) {
            return null;
        }
    }

    private String l() {
        try {
            return a("um_push_ut").getString("d_id", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean d() {
        try {
            return a("um_push_ut").getBoolean("t_f", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void f() {
        try {
            a("um_push_ut").edit().remove("t_id").remove("t_f").commit();
        } catch (Throwable unused) {
        }
    }

    public synchronized String getValue() {
        String str = this.f16247c;
        if (str != null) {
            return str;
        }
        return j();
    }

    public String m() {
        String str;
        try {
            str = a("um_push_ut").getString("t_id", (String) null);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null && !"-1".equals(str) && str.length() >= 2 && str.length() <= 128) {
            return str;
        }
        return null;
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m33c() {
        try {
            return a("um_push_ut").getBoolean("v_r", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    private void a(String str, boolean z10) {
        if (b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24) {
                b(str, z10);
            }
        }
    }

    public boolean b() {
        try {
            SharedPreferences a10 = a("um_push_ut");
            if (this.f16248d == -1) {
                this.f16248d = a10.getLong("v_ts", 0);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f16248d) >= c()) {
                this.f16248d = currentTimeMillis;
                a10.edit().putLong("v_ts", currentTimeMillis).commit();
                e.a("UTUtdid", "req valid");
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private byte[] a() {
        String str;
        e.a("UTUtdid", "generate UTDid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = b.getBytes(currentTimeMillis);
        byte[] bytes2 = b.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = c.f();
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(b.getBytes(com.umeng.ut.b.a.a.d.a(str)), 0, 4);
        byteArrayOutputStream.write(b.getBytes(com.umeng.ut.b.a.a.d.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private void b(String str, boolean z10) {
        try {
            a("um_push_ut").edit().putString("d_id", str).putBoolean("t_f", z10).commit();
        } catch (Throwable unused) {
        }
    }

    private static String a(byte[] bArr) {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, Ascii.RS, -122, SignedBytes.MAX_POWER_OF_TWO, -104, 74, -49, 106, 85, -38, -93};
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(com.umeng.ut.a.c.d.b(bArr2), instance.getAlgorithm()));
        return com.umeng.ut.b.a.a.a.a(instance.doFinal(bArr), 2);
    }

    public void a(String str, long j10) {
        boolean z10;
        try {
            SharedPreferences.Editor edit = a("um_push_ut").edit();
            boolean z11 = true;
            if (j10 > 0) {
                edit.putLong("v_i", j10);
                edit.putLong("v_ts", System.currentTimeMillis());
                z10 = true;
            } else {
                z10 = false;
            }
            if (str == null || "-1".equals(str) || str.length() < 2 || str.length() > 128) {
                z11 = z10;
            } else {
                edit.putString("t_id", str);
                edit.putBoolean("v_r", false);
            }
            if (z11) {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private SharedPreferences a(String str) {
        return this.f66a.getSharedPreferences(str, 0);
    }
}
