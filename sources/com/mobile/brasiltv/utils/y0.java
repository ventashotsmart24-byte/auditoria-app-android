package com.mobile.brasiltv.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.common.store.Session;
import com.umeng.analytics.pro.f;
import h9.t;
import io.reactivex.Observable;
import java.io.File;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import s9.l;
import t9.i;
import t9.j;
import t9.z;
import w6.i;

public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public static final y0 f12657a = new y0();

    /* renamed from: b  reason: collision with root package name */
    public static final String f12658b = "nsecived";

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12659a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(1);
            this.f12659a = context;
        }

        /* renamed from: b */
        public final String invoke(String str) {
            i.g(str, "it");
            if (Build.VERSION.SDK_INT <= 29) {
                y0 y0Var = y0.f12657a;
                y0Var.S();
                y0Var.T(this.f12659a);
            } else {
                y0 y0Var2 = y0.f12657a;
                y0Var2.R(this.f12659a);
                y0Var2.T(this.f12659a);
            }
            return str;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f12660a = new b();

        public b() {
            super(1);
        }

        public final void invoke(String str) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f12661a = new c();

        public c() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final String O(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (String) lVar.invoke(obj);
    }

    public static final void P(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Q(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final String A() {
        byte[] hardwareAddress;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName == null || (hardwareAddress = byName.getHardwareAddress()) == null) {
                return Session.DEFAULT_M;
            }
            for (byte valueOf : hardwareAddress) {
                z zVar = z.f19601a;
                String format = String.format("%02X:", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
                i.f(format, "format(format, *args)");
                stringBuffer.append(format);
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            return stringBuffer.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return Session.DEFAULT_M;
        }
    }

    public final boolean B(String str) {
        try {
            if (b0.J(str)) {
                return false;
            }
            String c10 = ma.i.c(str);
            if (b0.J(c10)) {
                return false;
            }
            i.f(c10, "decryptedSn");
            List M = ba.t.M(c10, new String[]{","}, false, 0, 6, (Object) null);
            if (M.size() <= 1) {
                return false;
            }
            i.c cVar = w6.i.f9510g;
            cVar.u0((String) M.get(0));
            if (t9.i.b(Session.DEFAULT_M, cVar.E())) {
                j();
                return true;
            }
            cVar.a0((String) M.get(1));
            if (M.size() > 2) {
                cVar.w0((String) M.get(2));
            }
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r2.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String C(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "this as java.lang.String…ing(startIndex, endIndex)"
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0187 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0187 }
            java.lang.String r4 = "/proc/net/arp"
            r3.<init>(r4)     // Catch:{ Exception -> 0x0187 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0187 }
        L_0x0010:
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r4 = "it"
            t9.i.f(r3, r4)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0184
            int r4 = r3.length()     // Catch:{ Exception -> 0x017e }
            r5 = 1
            int r4 = r4 - r5
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0024:
            r9 = 32
            if (r7 > r4) goto L_0x0049
            if (r8 != 0) goto L_0x002c
            r10 = r7
            goto L_0x002d
        L_0x002c:
            r10 = r4
        L_0x002d:
            char r10 = r3.charAt(r10)     // Catch:{ Exception -> 0x017e }
            int r10 = t9.i.i(r10, r9)     // Catch:{ Exception -> 0x017e }
            if (r10 > 0) goto L_0x0039
            r10 = 1
            goto L_0x003a
        L_0x0039:
            r10 = 0
        L_0x003a:
            if (r8 != 0) goto L_0x0043
            if (r10 != 0) goto L_0x0040
            r8 = 1
            goto L_0x0024
        L_0x0040:
            int r7 = r7 + 1
            goto L_0x0024
        L_0x0043:
            if (r10 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            int r4 = r4 + -1
            goto L_0x0024
        L_0x0049:
            int r4 = r4 + 1
            java.lang.CharSequence r3 = r3.subSequence(r7, r4)     // Catch:{ Exception -> 0x017e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x017e }
            int r4 = r3.length()     // Catch:{ Exception -> 0x017e }
            r7 = 63
            if (r4 < r7) goto L_0x017e
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ Exception -> 0x017e }
            java.lang.String r8 = "US"
            t9.i.f(r4, r8)     // Catch:{ Exception -> 0x017e }
            java.lang.String r4 = r3.toUpperCase(r4)     // Catch:{ Exception -> 0x017e }
            java.lang.String r8 = "this as java.lang.String).toUpperCase(locale)"
            t9.i.f(r4, r8)     // Catch:{ Exception -> 0x017e }
            java.lang.String r8 = "IP"
            r10 = 0
            r11 = 2
            boolean r4 = ba.t.o(r4, r8, r6, r11, r10)     // Catch:{ Exception -> 0x017e }
            if (r4 != 0) goto L_0x017e
            r4 = 17
            java.lang.String r4 = r3.substring(r6, r4)     // Catch:{ Exception -> 0x017e }
            t9.i.f(r4, r1)     // Catch:{ Exception -> 0x017e }
            int r8 = r4.length()     // Catch:{ Exception -> 0x017e }
            int r8 = r8 - r5
            r12 = 0
            r13 = 0
        L_0x0085:
            if (r12 > r8) goto L_0x00a8
            if (r13 != 0) goto L_0x008b
            r14 = r12
            goto L_0x008c
        L_0x008b:
            r14 = r8
        L_0x008c:
            char r14 = r4.charAt(r14)     // Catch:{ Exception -> 0x017e }
            int r14 = t9.i.i(r14, r9)     // Catch:{ Exception -> 0x017e }
            if (r14 > 0) goto L_0x0098
            r14 = 1
            goto L_0x0099
        L_0x0098:
            r14 = 0
        L_0x0099:
            if (r13 != 0) goto L_0x00a2
            if (r14 != 0) goto L_0x009f
            r13 = 1
            goto L_0x0085
        L_0x009f:
            int r12 = r12 + 1
            goto L_0x0085
        L_0x00a2:
            if (r14 != 0) goto L_0x00a5
            goto L_0x00a8
        L_0x00a5:
            int r8 = r8 + -1
            goto L_0x0085
        L_0x00a8:
            int r8 = r8 + 1
            java.lang.CharSequence r4 = r4.subSequence(r12, r8)     // Catch:{ Exception -> 0x017e }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x017e }
            r8 = 29
            java.lang.String r8 = r3.substring(r8, r9)     // Catch:{ Exception -> 0x017e }
            t9.i.f(r8, r1)     // Catch:{ Exception -> 0x017e }
            int r12 = r8.length()     // Catch:{ Exception -> 0x017e }
            int r12 = r12 - r5
            r13 = 0
            r14 = 0
        L_0x00c2:
            if (r13 > r12) goto L_0x00e5
            if (r14 != 0) goto L_0x00c8
            r15 = r13
            goto L_0x00c9
        L_0x00c8:
            r15 = r12
        L_0x00c9:
            char r15 = r8.charAt(r15)     // Catch:{ Exception -> 0x017e }
            int r15 = t9.i.i(r15, r9)     // Catch:{ Exception -> 0x017e }
            if (r15 > 0) goto L_0x00d5
            r15 = 1
            goto L_0x00d6
        L_0x00d5:
            r15 = 0
        L_0x00d6:
            if (r14 != 0) goto L_0x00df
            if (r15 != 0) goto L_0x00dc
            r14 = 1
            goto L_0x00c2
        L_0x00dc:
            int r13 = r13 + 1
            goto L_0x00c2
        L_0x00df:
            if (r15 != 0) goto L_0x00e2
            goto L_0x00e5
        L_0x00e2:
            int r12 = r12 + -1
            goto L_0x00c2
        L_0x00e5:
            int r12 = r12 + 1
            java.lang.CharSequence r8 = r8.subSequence(r13, r12)     // Catch:{ Exception -> 0x017e }
            r8.toString()     // Catch:{ Exception -> 0x017e }
            r8 = 41
            java.lang.String r3 = r3.substring(r8, r7)     // Catch:{ Exception -> 0x017e }
            t9.i.f(r3, r1)     // Catch:{ Exception -> 0x017e }
            int r7 = r3.length()     // Catch:{ Exception -> 0x017e }
            int r7 = r7 - r5
            r8 = 0
            r12 = 0
        L_0x00fe:
            if (r8 > r7) goto L_0x0121
            if (r12 != 0) goto L_0x0104
            r13 = r8
            goto L_0x0105
        L_0x0104:
            r13 = r7
        L_0x0105:
            char r13 = r3.charAt(r13)     // Catch:{ Exception -> 0x017e }
            int r13 = t9.i.i(r13, r9)     // Catch:{ Exception -> 0x017e }
            if (r13 > 0) goto L_0x0111
            r13 = 1
            goto L_0x0112
        L_0x0111:
            r13 = 0
        L_0x0112:
            if (r12 != 0) goto L_0x011b
            if (r13 != 0) goto L_0x0118
            r12 = 1
            goto L_0x00fe
        L_0x0118:
            int r8 = r8 + 1
            goto L_0x00fe
        L_0x011b:
            if (r13 != 0) goto L_0x011e
            goto L_0x0121
        L_0x011e:
            int r7 = r7 + -1
            goto L_0x00fe
        L_0x0121:
            int r7 = r7 + 1
            java.lang.CharSequence r3 = r3.subSequence(r8, r7)     // Catch:{ Exception -> 0x017e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x017e }
            java.lang.String r5 = "00:00:00:00:00:00"
            boolean r5 = ba.t.o(r3, r5, r6, r11, r10)     // Catch:{ Exception -> 0x017e }
            if (r5 != 0) goto L_0x017e
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x017e }
            if (r5 == 0) goto L_0x013b
            goto L_0x0010
        L_0x013b:
            boolean r5 = android.text.TextUtils.isEmpty(r17)     // Catch:{ Exception -> 0x017e }
            if (r5 != 0) goto L_0x014d
            r5 = r17
            boolean r6 = t9.i.b(r5, r4)     // Catch:{ Exception -> 0x0180 }
            if (r6 != 0) goto L_0x014a
            goto L_0x014f
        L_0x014a:
            r6 = r18
            goto L_0x015d
        L_0x014d:
            r5 = r17
        L_0x014f:
            boolean r6 = android.text.TextUtils.isEmpty(r18)     // Catch:{ Exception -> 0x0180 }
            if (r6 != 0) goto L_0x0180
            r6 = r18
            boolean r4 = t9.i.b(r6, r4)     // Catch:{ Exception -> 0x0010 }
            if (r4 == 0) goto L_0x0010
        L_0x015d:
            ba.i r4 = new ba.i     // Catch:{ Exception -> 0x0010 }
            java.lang.String r7 = ":"
            r4.<init>((java.lang.String) r7)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r3 = r4.c(r3, r0)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r4 = "(.{2}(?=.))"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch:{ Exception -> 0x0010 }
            java.util.regex.Matcher r3 = r4.matcher(r3)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r4 = "$1:"
            java.lang.String r3 = r3.replaceAll(r4)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r4 = "compile(\"(.{2}(?=.))\").m…er(mac).replaceAll(\"$1:\")"
            t9.i.f(r3, r4)     // Catch:{ Exception -> 0x0010 }
            return r3
        L_0x017e:
            r5 = r17
        L_0x0180:
            r6 = r18
            goto L_0x0010
        L_0x0184:
            r2.close()     // Catch:{ Exception -> 0x0187 }
        L_0x0187:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.C(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0115 A[Catch:{ all -> 0x0130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String D(android.content.Context r13) {
        /*
            r12 = this;
            java.lang.String r0 = ""
            r1 = 0
            android.net.Uri r8 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            r2 = 3
            java.lang.String[] r4 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r2 = "_id"
            r9 = 0
            r4[r9] = r2     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r2 = "_display_name"
            r3 = 1
            r4[r3] = r2     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r2 = "title"
            r5 = 2
            r4[r5] = r2     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            s6.a r2 = s6.a.f9335a     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            s6.b r2 = r2.a()     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r2 = r2.m()     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r6 = "relative_path LIKE ? AND title like ?"
            java.lang.String[] r7 = new java.lang.String[r5]     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            r5.<init>()     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            r10 = 37
            r5.append(r10)     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r10 = android.os.Environment.DIRECTORY_ALARMS     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            r5.append(r10)     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            r10 = 47
            r5.append(r10)     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            r5.append(r2)     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r2 = "/%"
            r5.append(r2)     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            r7[r9] = r2     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r2 = "%google%"
            r7[r3] = r2     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.String r10 = "_id DESC"
            android.content.ContentResolver r2 = r13.getContentResolver()     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            r3 = r8
            r5 = r6
            r6 = r7
            r7 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00fb, all -> 0x00f7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            r3.<init>()     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            t9.i.d(r2)     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            int r4 = r2.getCount()     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            if (r4 <= 0) goto L_0x00ea
            boolean r4 = r2.moveToNext()     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            if (r4 != 0) goto L_0x006f
            goto L_0x00ea
        L_0x006f:
            int r4 = r2.getInt(r9)     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            android.net.Uri r4 = android.net.Uri.withAppendedPath(r8, r4)     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            android.content.ContentResolver r5 = r13.getContentResolver()     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            java.io.InputStream r4 = r5.openInputStream(r4)     // Catch:{ Exception -> 0x00f2, all -> 0x00ee }
            if (r4 != 0) goto L_0x0089
            r2.close()
            return r0
        L_0x0089:
            r5 = 8046(0x1f6e, double:3.9753E-320)
            long r7 = r4.skip(r5)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x009a
            r2.close()
            r4.close()
            return r0
        L_0x009a:
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            t9.u r1 = new t9.u     // Catch:{ Exception -> 0x00e2 }
            r1.<init>()     // Catch:{ Exception -> 0x00e2 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r6]     // Catch:{ Exception -> 0x00e2 }
        L_0x00a8:
            int r8 = r5.read(r7, r9, r6)     // Catch:{ Exception -> 0x00e2 }
            r1.f19598a = r8     // Catch:{ Exception -> 0x00e2 }
            r10 = -1
            if (r8 == r10) goto L_0x00bc
            java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x00e2 }
            java.nio.charset.Charset r11 = ba.c.f11331b     // Catch:{ Exception -> 0x00e2 }
            r10.<init>(r7, r9, r8, r11)     // Catch:{ Exception -> 0x00e2 }
            r3.append(r10)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00a8
        L_0x00bc:
            w6.i$c r1 = w6.i.f9510g     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = r1.E()     // Catch:{ Exception -> 0x00e2 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00e2 }
            if (r1 == 0) goto L_0x00cf
            java.lang.String r1 = "3"
            java.lang.String r6 = "3:"
            com.mobile.brasiltv.utils.i1.G(r13, r1, r6)     // Catch:{ Exception -> 0x00e2 }
        L_0x00cf:
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r3 = "snData.toString()"
            t9.i.f(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            r2.close()
            r4.close()
            r5.close()
            return r1
        L_0x00e2:
            r1 = move-exception
            goto L_0x0100
        L_0x00e4:
            r13 = move-exception
            r5 = r1
            goto L_0x0131
        L_0x00e7:
            r3 = move-exception
            r5 = r1
            goto L_0x00f5
        L_0x00ea:
            r2.close()
            return r0
        L_0x00ee:
            r13 = move-exception
            r4 = r1
            r5 = r4
            goto L_0x0131
        L_0x00f2:
            r3 = move-exception
            r4 = r1
            r5 = r4
        L_0x00f5:
            r1 = r3
            goto L_0x0100
        L_0x00f7:
            r13 = move-exception
            r4 = r1
            r5 = r4
            goto L_0x0132
        L_0x00fb:
            r2 = move-exception
            r4 = r1
            r5 = r4
            r1 = r2
            r2 = r5
        L_0x0100:
            r1.printStackTrace()     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = "2"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r6.<init>()     // Catch:{ all -> 0x0130 }
            java.lang.String r7 = "2:"
            r6.append(r7)     // Catch:{ all -> 0x0130 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0130 }
            if (r1 != 0) goto L_0x0116
            r1 = r0
        L_0x0116:
            r6.append(r1)     // Catch:{ all -> 0x0130 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0130 }
            com.mobile.brasiltv.utils.i1.G(r13, r3, r1)     // Catch:{ all -> 0x0130 }
            if (r2 == 0) goto L_0x0125
            r2.close()
        L_0x0125:
            if (r4 == 0) goto L_0x012a
            r4.close()
        L_0x012a:
            if (r5 == 0) goto L_0x012f
            r5.close()
        L_0x012f:
            return r0
        L_0x0130:
            r13 = move-exception
        L_0x0131:
            r1 = r2
        L_0x0132:
            if (r1 == 0) goto L_0x0137
            r1.close()
        L_0x0137:
            if (r4 == 0) goto L_0x013c
            r4.close()
        L_0x013c:
            if (r5 == 0) goto L_0x0141
            r5.close()
        L_0x0141:
            goto L_0x0143
        L_0x0142:
            throw r13
        L_0x0143:
            goto L_0x0142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.D(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00da A[Catch:{ all -> 0x00f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String E(android.content.Context r12) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            r1 = 0
            android.net.Uri r8 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            r2 = 3
            java.lang.String[] r4 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r2 = "_id"
            r9 = 0
            r4[r9] = r2     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r2 = "_display_name"
            r3 = 1
            r4[r3] = r2     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r2 = "title"
            r3 = 2
            r4[r3] = r2     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            s6.a r2 = s6.a.f9335a     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            s6.b r2 = r2.a()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r2 = r2.l()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            r3.<init>()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r5 = "title like '%"
            r3.append(r5)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            r3.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r2 = "%'"
            r3.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r7 = "_id DESC"
            android.content.ContentResolver r2 = r12.getContentResolver()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            r6 = 0
            r3 = r8
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r3.<init>()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            t9.i.d(r2)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            int r4 = r2.getCount()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r4 <= 0) goto L_0x00b3
            boolean r4 = r2.moveToNext()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r4 != 0) goto L_0x0058
            goto L_0x00b3
        L_0x0058:
            int r4 = r2.getInt(r9)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            android.net.Uri r4 = android.net.Uri.withAppendedPath(r8, r4)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.io.InputStream r4 = r6.openInputStream(r4)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            t9.u r1 = new t9.u     // Catch:{ Exception -> 0x00b1 }
            r1.<init>()     // Catch:{ Exception -> 0x00b1 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r4]     // Catch:{ Exception -> 0x00b1 }
        L_0x007a:
            int r7 = r5.read(r6, r9, r4)     // Catch:{ Exception -> 0x00b1 }
            r1.f19598a = r7     // Catch:{ Exception -> 0x00b1 }
            r8 = -1
            if (r7 == r8) goto L_0x008e
            java.lang.String r8 = new java.lang.String     // Catch:{ Exception -> 0x00b1 }
            java.nio.charset.Charset r10 = ba.c.f11331b     // Catch:{ Exception -> 0x00b1 }
            r8.<init>(r6, r9, r7, r10)     // Catch:{ Exception -> 0x00b1 }
            r3.append(r8)     // Catch:{ Exception -> 0x00b1 }
            goto L_0x007a
        L_0x008e:
            w6.i$c r1 = w6.i.f9510g     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r1 = r1.E()     // Catch:{ Exception -> 0x00b1 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00b1 }
            if (r1 == 0) goto L_0x00a1
            java.lang.String r1 = "3"
            java.lang.String r4 = "3:"
            com.mobile.brasiltv.utils.i1.G(r12, r1, r4)     // Catch:{ Exception -> 0x00b1 }
        L_0x00a1:
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r3 = "snData.toString()"
            t9.i.f(r1, r3)     // Catch:{ Exception -> 0x00b1 }
            r2.close()
            r5.close()
            return r1
        L_0x00b1:
            r1 = move-exception
            goto L_0x00c5
        L_0x00b3:
            r2.close()
            return r0
        L_0x00b7:
            r12 = move-exception
            r5 = r1
            goto L_0x00f1
        L_0x00ba:
            r3 = move-exception
            r5 = r1
            r1 = r3
            goto L_0x00c5
        L_0x00be:
            r12 = move-exception
            r5 = r1
            goto L_0x00f2
        L_0x00c1:
            r2 = move-exception
            r5 = r1
            r1 = r2
            r2 = r5
        L_0x00c5:
            r1.printStackTrace()     // Catch:{ all -> 0x00f0 }
            java.lang.String r3 = "2"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f0 }
            r4.<init>()     // Catch:{ all -> 0x00f0 }
            java.lang.String r6 = "2:"
            r4.append(r6)     // Catch:{ all -> 0x00f0 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00f0 }
            if (r1 != 0) goto L_0x00db
            r1 = r0
        L_0x00db:
            r4.append(r1)     // Catch:{ all -> 0x00f0 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00f0 }
            com.mobile.brasiltv.utils.i1.G(r12, r3, r1)     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x00ea
            r2.close()
        L_0x00ea:
            if (r5 == 0) goto L_0x00ef
            r5.close()
        L_0x00ef:
            return r0
        L_0x00f0:
            r12 = move-exception
        L_0x00f1:
            r1 = r2
        L_0x00f2:
            if (r1 == 0) goto L_0x00f7
            r1.close()
        L_0x00f7:
            if (r5 == 0) goto L_0x00fc
            r5.close()
        L_0x00fc:
            goto L_0x00fe
        L_0x00fd:
            throw r12
        L_0x00fe:
            goto L_0x00fd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.E(android.content.Context):java.lang.String");
    }

    public final boolean F(Context context) {
        boolean z10;
        t9.i.g(context, f.X);
        if (p.a.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return false;
        }
        if (!h(context)) {
            i(context);
        }
        return true;
    }

    public final boolean G(Context context) {
        boolean z10;
        t9.i.g(context, f.X);
        na.f.k(context, "key_sn", "");
        boolean K = K(context);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 29) {
            if (K) {
                S();
                V(context);
                return true;
            }
            if (J()) {
                T(context);
                V(context);
            }
            return true;
        } else if (K) {
            R(context);
            V(context);
            return true;
        } else if (H(context)) {
            T(context);
            V(context);
            return true;
        } else {
            boolean z11 = false;
            if (i10 > 33) {
                if (p.a.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0) {
                    z11 = true;
                }
                if (!z11 || !h(context)) {
                    i(context);
                }
                return true;
            } else if (i10 == 33) {
                if (p.a.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    return false;
                }
                if (!h(context)) {
                    i(context);
                }
                return true;
            } else {
                if (!h(context)) {
                    i(context);
                }
                return true;
            }
        }
    }

    public final boolean H(Context context) {
        return B(D(context));
    }

    public final boolean I(Context context) {
        return B(E(context));
    }

    public final boolean J() {
        for (String file : s6.a.f9335a.a().n()) {
            File file2 = new File(file);
            if (file2.exists()) {
                try {
                    if (B(q9.c.b(file2, (Charset) null, 1, (Object) null))) {
                        return true;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        return false;
    }

    public final boolean K(Context context) {
        t9.i.g(context, f.X);
        return B(na.f.f(context, "SP_SN_BACKUP", ""));
    }

    public final void L() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M(android.content.Context r8, java.lang.String r9, android.net.Uri r10, int r11) {
        /*
            r7 = this;
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            s6.a r1 = s6.a.f9335a
            s6.b r1 = r1.a()
            java.lang.String r1 = r1.m()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = android.os.Environment.DIRECTORY_ALARMS
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "relative_path"
            r0.put(r2, r1)
            java.lang.String r1 = "google.wav"
            java.lang.String r2 = "google"
            if (r11 != 0) goto L_0x0032
            r11 = r1
            goto L_0x0046
        L_0x0032:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r11)
            java.lang.String r11 = ".wav"
            r3.append(r11)
            java.lang.String r11 = r3.toString()
        L_0x0046:
            java.lang.String r3 = "_display_name"
            r0.put(r3, r11)
            java.lang.String r11 = "mime_type"
            java.lang.String r3 = "audio/wav"
            r0.put(r11, r3)
            java.lang.String r11 = "title"
            r0.put(r11, r2)
            r11 = 0
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            android.net.Uri r10 = r2.insert(r10, r0)     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            t9.i.d(r10)     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            com.mobile.brasiltv.utils.i1.H(r8, r10)     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            java.lang.String r2 = "rw"
            java.io.OutputStream r10 = r0.openOutputStream(r10, r2)     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            r0.<init>(r10)     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            android.content.res.AssetManager r10 = r8.getAssets()     // Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
            java.io.InputStream r10 = r10.open(r1)     // Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r2 = "UTF_8"
            t9.i.f(r1, r2)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            byte[] r9 = r9.getBytes(r1)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r1 = "this as java.lang.String).getBytes(charset)"
            t9.i.f(r9, r1)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r1.<init>()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r11 = 1024(0x400, float:1.435E-42)
            byte[] r11 = new byte[r11]     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
        L_0x0096:
            int r2 = r10.read(r11)     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            r3 = -1
            r4 = 0
            if (r2 == r3) goto L_0x00a2
            r1.write(r11, r4, r2)     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            goto L_0x0096
        L_0x00a2:
            byte[] r11 = r1.toByteArray()     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r2 = r11.length     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r3 = r9.length     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r2 = r2 + r3
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r3 = r11.length     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            r5 = 8
            if (r3 <= r5) goto L_0x00d2
            int r3 = r11.length     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r3 = r3 - r5
            int r5 = r9.length     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r3 = r3 + r5
            int r5 = r3 >> 24
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            r6 = 7
            r11[r6] = r5     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r5 = r3 << 8
            int r5 = r5 >> 24
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            r6 = 6
            r11[r6] = r5     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r5 = r3 << 16
            int r5 = r5 >> 24
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            r6 = 5
            r11[r6] = r5     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r3 = r3 << 24
            int r3 = r3 >> 24
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            r5 = 4
            r11[r5] = r3     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
        L_0x00d2:
            int r3 = r11.length     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            java.lang.System.arraycopy(r11, r4, r2, r4, r3)     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r11 = r11.length     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            int r3 = r9.length     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            java.lang.System.arraycopy(r9, r4, r2, r11, r3)     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            r0.write(r2)     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            r0.close()
            r10.close()
        L_0x00e4:
            r1.close()
            goto L_0x012d
        L_0x00e8:
            r8 = move-exception
            goto L_0x00f5
        L_0x00ea:
            r9 = move-exception
            goto L_0x00fa
        L_0x00ec:
            r8 = move-exception
            r1 = r11
            goto L_0x00f5
        L_0x00ef:
            r9 = move-exception
            r1 = r11
            goto L_0x00fa
        L_0x00f2:
            r8 = move-exception
            r10 = r11
            r1 = r10
        L_0x00f5:
            r11 = r0
            goto L_0x012f
        L_0x00f7:
            r9 = move-exception
            r10 = r11
            r1 = r10
        L_0x00fa:
            r11 = r0
            goto L_0x0103
        L_0x00fc:
            r8 = move-exception
            r10 = r11
            r1 = r10
            goto L_0x012f
        L_0x0100:
            r9 = move-exception
            r10 = r11
            r1 = r10
        L_0x0103:
            r9.printStackTrace()     // Catch:{ all -> 0x012e }
            java.lang.String r0 = "12"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x012e }
            r2.<init>()     // Catch:{ all -> 0x012e }
            java.lang.String r3 = "insert uri failure and msg is "
            r2.append(r3)     // Catch:{ all -> 0x012e }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x012e }
            r2.append(r9)     // Catch:{ all -> 0x012e }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x012e }
            com.mobile.brasiltv.utils.i1.G(r8, r0, r9)     // Catch:{ all -> 0x012e }
            if (r11 == 0) goto L_0x0125
            r11.close()
        L_0x0125:
            if (r10 == 0) goto L_0x012a
            r10.close()
        L_0x012a:
            if (r1 == 0) goto L_0x012d
            goto L_0x00e4
        L_0x012d:
            return
        L_0x012e:
            r8 = move-exception
        L_0x012f:
            if (r11 == 0) goto L_0x0134
            r11.close()
        L_0x0134:
            if (r10 == 0) goto L_0x0139
            r10.close()
        L_0x0139:
            if (r1 == 0) goto L_0x013e
            r1.close()
        L_0x013e:
            goto L_0x0140
        L_0x013f:
            throw r8
        L_0x0140:
            goto L_0x013f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.M(android.content.Context, java.lang.String, android.net.Uri, int):void");
    }

    public final void N(Context context) {
        t9.i.g(context, f.X);
        V(context);
        Observable.just("(write sn)").map(new v0(new a(context))).compose(p0.c()).subscribe(new w0(b.f12660a), new x0(c.f12661a));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0117, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0118, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x011a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011b, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x013a, code lost:
        r3.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0117 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void R(android.content.Context r27) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            r3 = 0
            android.net.Uri r10 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x012e }
            r0 = 3
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = "_id"
            r11 = 0
            r6[r11] = r0     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = "_display_name"
            r12 = 1
            r6[r12] = r0     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = "title"
            r4 = 2
            r6[r4] = r0     // Catch:{ Exception -> 0x012e }
            s6.a r0 = s6.a.f9335a     // Catch:{ Exception -> 0x012e }
            s6.b r0 = r0.a()     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = r0.m()     // Catch:{ Exception -> 0x012e }
            java.lang.String r7 = "relative_path LIKE ? AND title like ?"
            java.lang.String[] r8 = new java.lang.String[r4]     // Catch:{ Exception -> 0x012e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r4.<init>()     // Catch:{ Exception -> 0x012e }
            r5 = 37
            r4.append(r5)     // Catch:{ Exception -> 0x012e }
            java.lang.String r5 = android.os.Environment.DIRECTORY_ALARMS     // Catch:{ Exception -> 0x012e }
            r4.append(r5)     // Catch:{ Exception -> 0x012e }
            r5 = 47
            r4.append(r5)     // Catch:{ Exception -> 0x012e }
            r4.append(r0)     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = "/%"
            r4.append(r0)     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x012e }
            r8[r11] = r0     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = "%google%"
            r8[r12] = r0     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = "_id DESC"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r0.<init>()     // Catch:{ Exception -> 0x012e }
            w6.i$c r4 = w6.i.f9510g     // Catch:{ Exception -> 0x012e }
            java.lang.String r5 = r4.E()     // Catch:{ Exception -> 0x012e }
            r0.append(r5)     // Catch:{ Exception -> 0x012e }
            r5 = 44
            r0.append(r5)     // Catch:{ Exception -> 0x012e }
            java.lang.String r13 = r4.l()     // Catch:{ Exception -> 0x012e }
            r0.append(r13)     // Catch:{ Exception -> 0x012e }
            r0.append(r5)     // Catch:{ Exception -> 0x012e }
            java.lang.String r4 = r4.G()     // Catch:{ Exception -> 0x012e }
            r0.append(r4)     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x012e }
            java.lang.String r13 = ma.i.g(r0)     // Catch:{ Exception -> 0x012e }
            android.content.ContentResolver r4 = r27.getContentResolver()     // Catch:{ Exception -> 0x012e }
            r5 = r10
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x012e }
            java.lang.String r5 = "uri"
            java.lang.String r6 = "fileContent"
            if (r4 == 0) goto L_0x011d
            int r0 = r4.getCount()     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            if (r0 > 0) goto L_0x0092
            goto L_0x011d
        L_0x0092:
            boolean r0 = r4.moveToNext()     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            if (r0 != 0) goto L_0x009c
            r4.close()
            return
        L_0x009c:
            java.lang.String r0 = r26.D(r27)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            boolean r0 = android.text.TextUtils.equals(r13, r0)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            if (r0 == 0) goto L_0x00aa
            r4.close()
            return
        L_0x00aa:
            int r0 = r4.getInt(r11)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            long r7 = (long) r0
            android.net.Uri r0 = android.content.ContentUris.withAppendedId(r10, r7)     // Catch:{ RecoverableSecurityException -> 0x00d5, Exception -> 0x00d0, all -> 0x0117 }
            java.lang.String r7 = "withAppendedId(uri, id.toLong())"
            t9.i.f(r0, r7)     // Catch:{ RecoverableSecurityException -> 0x00d5, Exception -> 0x00d0, all -> 0x0117 }
            android.content.ContentResolver r7 = r27.getContentResolver()     // Catch:{ RecoverableSecurityException -> 0x00d5, Exception -> 0x00d0, all -> 0x0117 }
            int unused = r7.delete(r0, r3)     // Catch:{ RecoverableSecurityException -> 0x00d5, Exception -> 0x00d0, all -> 0x0117 }
            java.lang.String r0 = "10"
            java.lang.String r3 = "delete uri successful"
            com.mobile.brasiltv.utils.i1.G(r2, r0, r3)     // Catch:{ RecoverableSecurityException -> 0x00d5, Exception -> 0x00d0, all -> 0x0117 }
            t9.i.f(r13, r6)     // Catch:{ RecoverableSecurityException -> 0x00d5, Exception -> 0x00d0, all -> 0x0117 }
            t9.i.f(r10, r5)     // Catch:{ RecoverableSecurityException -> 0x00d5, Exception -> 0x00d0, all -> 0x0117 }
            r1.M(r2, r13, r10, r11)     // Catch:{ RecoverableSecurityException -> 0x00d5, Exception -> 0x00d0, all -> 0x0117 }
            goto L_0x0113
        L_0x00d0:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            goto L_0x0113
        L_0x00d5:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            java.lang.String r0 = "11"
            java.lang.String r3 = "delete uri failure"
            com.mobile.brasiltv.utils.i1.G(r2, r0, r3)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            java.lang.String r14 = r4.getString(r12)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            java.lang.String r0 = "displayName"
            t9.i.f(r14, r0)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            java.lang.String r15 = ".wav"
            java.lang.String r16 = ""
            r17 = 0
            r18 = 4
            r19 = 0
            java.lang.String r20 = ba.s.j(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            java.lang.String r21 = "google"
            java.lang.String r22 = ""
            r23 = 0
            r24 = 4
            r25 = 0
            java.lang.String r0 = ba.s.j(r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            int r0 = com.mobile.brasiltv.utils.b0.Y(r0, r11)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            int r0 = r0 + r12
            t9.i.f(r13, r6)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            t9.i.f(r10, r5)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            r1.M(r2, r13, r10, r0)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
        L_0x0113:
            r4.close()
            goto L_0x0137
        L_0x0117:
            r0 = move-exception
            r3 = r4
            goto L_0x0138
        L_0x011a:
            r0 = move-exception
            r3 = r4
            goto L_0x012f
        L_0x011d:
            t9.i.f(r13, r6)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            t9.i.f(r10, r5)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            r1.M(r2, r13, r10, r11)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            if (r4 == 0) goto L_0x012b
            r4.close()
        L_0x012b:
            return
        L_0x012c:
            r0 = move-exception
            goto L_0x0138
        L_0x012e:
            r0 = move-exception
        L_0x012f:
            r0.printStackTrace()     // Catch:{ all -> 0x012c }
            if (r3 == 0) goto L_0x0137
            r3.close()
        L_0x0137:
            return
        L_0x0138:
            if (r3 == 0) goto L_0x013d
            r3.close()
        L_0x013d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.R(android.content.Context):void");
    }

    public final void S() {
        try {
            StringBuilder sb = new StringBuilder();
            i.c cVar = w6.i.f9510g;
            sb.append(cVar.E());
            sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            sb.append(cVar.l());
            sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            sb.append(cVar.G());
            String g10 = ma.i.g(sb.toString());
            for (String U : s6.a.f9335a.a().n()) {
                t9.i.f(g10, "encryptedSnData");
                U(U, g10);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void T(Context context) {
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.E());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(cVar.l());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(cVar.G());
        na.f.k(context, "SP_SN_BACKUP", ma.i.g(sb.toString()));
    }

    public final void U(String str, String str2) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            q9.c.e(file, str2, (Charset) null, 2, (Object) null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void V(Context context) {
        na.f.k(context, "key_sn", w6.i.f9510g.E());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:1|2|3|4|5|6|7|8|9|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|(2:14|15)|(2:18|19)|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0023 A[SYNTHETIC, Splitter:B:18:0x0023] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:9:0x0014=Splitter:B:9:0x0014, B:20:0x0026=Splitter:B:20:0x0026} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String d(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0027 }
            r1.<init>(r4)     // Catch:{ all -> 0x0027 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x001a }
            r2 = 1024(0x400, float:1.435E-42)
            r4.<init>(r1, r2)     // Catch:{ all -> 0x001a }
            java.lang.String r0 = r4.readLine()     // Catch:{ all -> 0x0018 }
            r1.close()     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r4.close()     // Catch:{ all -> 0x0027 }
            goto L_0x0027
        L_0x0018:
            r2 = move-exception
            goto L_0x001c
        L_0x001a:
            r2 = move-exception
            r4 = r0
        L_0x001c:
            r1.close()     // Catch:{ all -> 0x0020 }
            goto L_0x0021
        L_0x0020:
        L_0x0021:
            if (r4 == 0) goto L_0x0026
            r4.close()     // Catch:{ all -> 0x0026 }
        L_0x0026:
            throw r2     // Catch:{ all -> 0x0027 }
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.d(java.lang.String):java.lang.String");
    }

    public final boolean h(Context context) {
        if (!I(context)) {
            return false;
        }
        T(context);
        R(context);
        V(context);
        return true;
    }

    public final void i(Context context) {
        if (J()) {
            R(context);
            T(context);
            V(context);
        }
    }

    public final void j() {
        i.c cVar = w6.i.f9510g;
        cVar.u0("");
        cVar.a0("");
        cVar.w0("");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String k(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.Process r7 = r2.exec(r7)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            if (r7 != 0) goto L_0x0013
            java.lang.String r7 = ""
            return r7
        L_0x0013:
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0048, all -> 0x0044 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0048, all -> 0x0044 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x0048, all -> 0x0044 }
            r4 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0048, all -> 0x0044 }
        L_0x0023:
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x003e, all -> 0x003b }
            if (r1 != 0) goto L_0x0032
            r2.close()
            if (r7 == 0) goto L_0x005f
            r7.close()
            goto L_0x005f
        L_0x0032:
            r0.append(r1)     // Catch:{ Exception -> 0x003e, all -> 0x003b }
            java.lang.String r1 = "sb.append(line)"
            t9.i.f(r0, r1)     // Catch:{ Exception -> 0x003e, all -> 0x003b }
            goto L_0x0023
        L_0x003b:
            r0 = move-exception
            r1 = r2
            goto L_0x0045
        L_0x003e:
            r1 = move-exception
            r5 = r2
            r2 = r7
            r7 = r1
            r1 = r5
            goto L_0x0052
        L_0x0044:
            r0 = move-exception
        L_0x0045:
            r2 = r7
            r7 = r0
            goto L_0x006a
        L_0x0048:
            r2 = move-exception
            r5 = r2
            r2 = r7
            r7 = r5
            goto L_0x0052
        L_0x004d:
            r7 = move-exception
            r2 = r1
            goto L_0x006a
        L_0x0050:
            r7 = move-exception
            r2 = r1
        L_0x0052:
            r7.printStackTrace()     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x005a
            r1.close()
        L_0x005a:
            if (r2 == 0) goto L_0x005f
            r2.close()
        L_0x005f:
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "sb.toString()"
            t9.i.f(r7, r0)
            return r7
        L_0x0069:
            r7 = move-exception
        L_0x006a:
            if (r1 == 0) goto L_0x006f
            r1.close()
        L_0x006f:
            if (r2 == 0) goto L_0x0074
            r2.close()
        L_0x0074:
            goto L_0x0076
        L_0x0075:
            throw r7
        L_0x0076:
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.k(java.lang.String):java.lang.String");
    }

    public final String l(Context context) {
        t9.i.g(context, f.X);
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        if (string == null) {
            return "";
        }
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r2.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a6 A[SYNTHETIC, Splitter:B:37:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ae A[SYNTHETIC, Splitter:B:43:0x00ae] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m() {
        /*
            r14 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.lang.String r3 = "cat proc/cpuinfo"
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0099 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0099 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ IOException -> 0x0099 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0099 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0099 }
        L_0x001b:
            java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x0099 }
            if (r4 == 0) goto L_0x0090
            t9.i.d(r4)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r5 = "Serial"
            r6 = 2
            r12 = 0
            boolean r5 = ba.t.o(r4, r5, r12, r6, r1)     // Catch:{ IOException -> 0x0099 }
            if (r5 == 0) goto L_0x001b
            java.lang.String r7 = "Serial"
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r4
            int r1 = ba.t.y(r6, r7, r8, r9, r10, r11)     // Catch:{ IOException -> 0x0099 }
            int r1 = r1 + 6
            java.lang.String r1 = r4.substring(r1)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r3 = "this as java.lang.String).substring(startIndex)"
            t9.i.f(r1, r3)     // Catch:{ IOException -> 0x0099 }
            ba.i r3 = new ba.i     // Catch:{ IOException -> 0x0099 }
            java.lang.String r4 = ":"
            r3.<init>((java.lang.String) r4)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r1 = r3.c(r1, r0)     // Catch:{ IOException -> 0x0099 }
            ba.i r3 = new ba.i     // Catch:{ IOException -> 0x0099 }
            java.lang.String r4 = " "
            r3.<init>((java.lang.String) r4)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r1 = r3.c(r1, r0)     // Catch:{ IOException -> 0x0099 }
            int r3 = r1.length()     // Catch:{ IOException -> 0x0099 }
            r4 = 1
            int r3 = r3 - r4
            r5 = 0
            r6 = 0
        L_0x0062:
            if (r5 > r3) goto L_0x0087
            if (r6 != 0) goto L_0x0068
            r7 = r5
            goto L_0x0069
        L_0x0068:
            r7 = r3
        L_0x0069:
            char r7 = r1.charAt(r7)     // Catch:{ IOException -> 0x0099 }
            r8 = 32
            int r7 = t9.i.i(r7, r8)     // Catch:{ IOException -> 0x0099 }
            if (r7 > 0) goto L_0x0077
            r7 = 1
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            if (r6 != 0) goto L_0x0081
            if (r7 != 0) goto L_0x007e
            r6 = 1
            goto L_0x0062
        L_0x007e:
            int r5 = r5 + 1
            goto L_0x0062
        L_0x0081:
            if (r7 != 0) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            int r3 = r3 + -1
            goto L_0x0062
        L_0x0087:
            int r3 = r3 + r4
            java.lang.CharSequence r1 = r1.subSequence(r5, r3)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0099 }
        L_0x0090:
            r2.destroy()     // Catch:{ Exception -> 0x0094 }
            goto L_0x00a9
        L_0x0094:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x00a9
        L_0x0099:
            r1 = move-exception
            goto L_0x00a1
        L_0x009b:
            r0 = move-exception
            goto L_0x00ac
        L_0x009d:
            r2 = move-exception
            r13 = r2
            r2 = r1
            r1 = r13
        L_0x00a1:
            r1.printStackTrace()     // Catch:{ all -> 0x00aa }
            if (r2 == 0) goto L_0x00a9
            r2.destroy()     // Catch:{ Exception -> 0x0094 }
        L_0x00a9:
            return r0
        L_0x00aa:
            r0 = move-exception
            r1 = r2
        L_0x00ac:
            if (r1 == 0) goto L_0x00b6
            r1.destroy()     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00b6
        L_0x00b2:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00b6:
            goto L_0x00b8
        L_0x00b7:
            throw r0
        L_0x00b8:
            goto L_0x00b7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.m():java.lang.String");
    }

    public final String n() {
        boolean z10;
        boolean z11;
        String k10 = k("cat /sys/block/mmcblk0/device/type");
        String k11 = k("cat /sys/block/mmcblk0/device/name");
        String k12 = k("cat /sys/block/mmcblk0/device/cid");
        boolean z12 = true;
        if (k10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (k11.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (k12.length() != 0) {
                    z12 = false;
                }
                if (z12) {
                    return "";
                }
            }
        }
        return k10 + ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN + k11 + ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN + k12;
    }

    public final String o() {
        try {
            String d10 = d("/sys/class/net/eth0/address");
            if (d10 != null) {
                return d10;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String p() {
        byte[] hardwareAddress;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            NetworkInterface byName = NetworkInterface.getByName("eth1");
            if (byName == null || (hardwareAddress = byName.getHardwareAddress()) == null) {
                return Session.DEFAULT_M;
            }
            boolean z10 = false;
            for (byte valueOf : hardwareAddress) {
                z zVar = z.f19601a;
                String format = String.format("%02X:", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
                t9.i.f(format, "format(format, *args)");
                stringBuffer.append(format);
            }
            if (stringBuffer.length() > 0) {
                z10 = true;
            }
            if (z10) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            return stringBuffer.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return Session.DEFAULT_M;
        }
    }

    public final String q() {
        String p10 = p();
        String str = Session.DEFAULT_M;
        if (p10 == null) {
            p10 = str;
        }
        if (TextUtils.equals(str, p10) || TextUtils.isEmpty(p10)) {
            String o10 = o();
            if (o10 != null) {
                str = o10;
            }
            p10 = str;
        }
        if (!ba.t.o(p10, SOAP.DELIM, false, 2, (Object) null)) {
            p10 = Pattern.compile("(.{2}(?=.))").matcher(p10).replaceAll("$1:");
            t9.i.f(p10, "compile(\"(.{2}(?=.))\").m…er(mac).replaceAll(\"$1:\")");
        }
        Locale locale = Locale.getDefault();
        t9.i.f(locale, "getDefault()");
        String lowerCase = p10.toLowerCase(locale);
        t9.i.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public final String r() {
        String s10 = s();
        if (s10 != null) {
            String[] strArr = (String[]) new ba.i("\\.").e(s10, 0).toArray(new String[0]);
            if (strArr.length >= 4) {
                strArr[3] = "1";
                String str = strArr[0] + '.' + strArr[1] + '.' + strArr[2] + '.' + strArr[3];
                strArr[3] = "254";
                return C(str, strArr[0] + '.' + strArr[1] + '.' + strArr[2] + '.' + strArr[3]);
            }
        }
        return "";
    }

    public final String s() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            t9.i.f(networkInterfaces, "getNetworkInterfaces()");
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                t9.i.e(nextElement, "null cannot be cast to non-null type java.net.NetworkInterface");
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!(nextElement2 instanceof Inet6Address)) {
                        if (!t9.i.b("127.0.0.1", nextElement2.getHostAddress())) {
                            str = nextElement2.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return str;
    }

    public final String t() {
        try {
            int i10 = 0;
            String[] strArr = {"/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address"};
            while (i10 < 2) {
                try {
                    String d10 = d(strArr[i10]);
                    if (d10 != null) {
                        return d10;
                    }
                    i10++;
                } catch (Throwable unused) {
                }
            }
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final String u(Context context) {
        t9.i.g(context, f.X);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return "";
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            String formatFileSize = Formatter.formatFileSize(context, memoryInfo.totalMem);
            t9.i.f(formatFileSize, "formatFileSize(context, totalSize)");
            return formatFileSize;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String v(Context context) {
        String str;
        t9.i.g(context, f.X);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            str = Formatter.formatFileSize(context, statFs.getBlockSizeLong() * statFs.getBlockCountLong());
        } catch (Exception unused) {
            str = "";
        }
        t9.i.f(str, "{\n            try {\n    …\"\n            }\n        }");
        return str;
    }

    public final String w() {
        String str = Build.SERIAL;
        String str2 = "unknown";
        if (str == null) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str2, str)) {
            return str;
        }
        String x10 = x();
        if (x10 != null) {
            str2 = x10;
        }
        return str2;
    }

    public final String x() {
        try {
            return (String) Build.class.getMethod("getSerial", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String y(Context context) {
        String str;
        t9.i.g(context, f.X);
        int i10 = Build.VERSION.SDK_INT;
        String str2 = Session.DEFAULT_M;
        if (i10 >= 23 || (str = z(context)) == null) {
            str = str2;
        }
        if (TextUtils.equals(str2, str) || TextUtils.isEmpty(str)) {
            str = A();
        }
        if (TextUtils.equals(str2, str) || TextUtils.isEmpty(str)) {
            String t10 = t();
            if (t10 != null) {
                str2 = t10;
            }
            str = str2;
        }
        if (!ba.t.o(str, SOAP.DELIM, false, 2, (Object) null)) {
            str = Pattern.compile("(.{2}(?=.))").matcher(str).replaceAll("$1:");
            t9.i.f(str, "compile(\"(.{2}(?=.))\").m…ifiMac).replaceAll(\"$1:\")");
        }
        Locale locale = Locale.getDefault();
        t9.i.f(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        t9.i.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public final String z(Context context) {
        Object systemService = context.getSystemService("wifi");
        t9.i.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo.getMacAddress();
        }
        return null;
    }
}
