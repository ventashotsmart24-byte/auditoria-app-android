package com.uc.crashsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.hpplay.cybergarage.xml.XML;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.b;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;

public class g {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13498a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Context f13499b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f13500c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f13501d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f13502e = null;

    /* renamed from: f  reason: collision with root package name */
    private static String f13503f = null;

    /* renamed from: g  reason: collision with root package name */
    private static String f13504g = null;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f13505h = false;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f13506i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f13507j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(File file, File file2) {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            a((Closeable) fileInputStream2);
                            a((Closeable) fileOutputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        a((Closeable) fileInputStream);
                        a((Closeable) fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                a((Closeable) fileInputStream);
                a((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            a((Closeable) fileInputStream);
            a((Closeable) fileOutputStream);
            throw th;
        }
    }

    public static void b(File file) {
        a(file, "");
    }

    public static String c(File file) {
        String str = "";
        if (!file.exists()) {
            return str;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[256];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                str = sb.toString();
                a((Closeable) fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    a(th, false);
                    return str;
                } finally {
                    a((Closeable) fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            a(th, false);
            return str;
        }
        return str;
    }

    public static String d(File file) {
        return a(file, 64, true);
    }

    public static byte[] e(File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            byte[] bArr = new byte[((int) file.length())];
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                a((Closeable) fileInputStream);
                return bArr;
            } catch (Throwable th) {
                th = th;
                try {
                    a(th, false);
                    return null;
                } finally {
                    a((Closeable) fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            a(th, false);
            return null;
        }
    }

    public static boolean f() {
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            return false;
        }
        return true;
    }

    public static boolean g() {
        int indexOf;
        String i10 = i();
        if (!a(i10) && (indexOf = i10.indexOf(" root ")) > 0) {
            String substring = i10.substring(0, indexOf);
            if (substring.contains("x") || substring.contains("s")) {
                return true;
            }
        }
        return false;
    }

    public static String h() {
        l();
        if (a(f13503f)) {
            return "";
        }
        return f13503f;
    }

    public static String i() {
        l();
        if (a(f13504g)) {
            return "";
        }
        return f13504g;
    }

    public static void j() {
        f.a(0, new e(800), 15000);
    }

    public static void k() {
        if (b.f13531d && f13505h) {
            JNIBridge.set(123, f13503f);
            JNIBridge.set(124, f13504g);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        r2 = r2.trim();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void l() {
        /*
            boolean r0 = f13505h
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Object r0 = f13506i
            monitor-enter(r0)
            boolean r1 = f13505h     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            return
        L_0x000e:
            r1 = 3
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "sh"
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "-c"
            r5 = 1
            r2[r5] = r3     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "type su"
            r6 = 2
            r2[r6] = r3     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = a((java.lang.String[]) r2)     // Catch:{ all -> 0x0070 }
            boolean r3 = a((java.lang.String) r2)     // Catch:{ all -> 0x0070 }
            if (r3 != 0) goto L_0x0069
            java.lang.String r2 = r2.trim()     // Catch:{ all -> 0x0070 }
            r3 = 32
            int r3 = r2.indexOf(r3)     // Catch:{ all -> 0x0070 }
            if (r3 <= 0) goto L_0x0069
            java.lang.String r7 = "/su"
            boolean r7 = r2.contains(r7)     // Catch:{ all -> 0x0070 }
            if (r7 == 0) goto L_0x0069
            r7 = 47
            int r3 = r3 + r5
            int r3 = r2.indexOf(r7, r3)     // Catch:{ all -> 0x0070 }
            if (r3 <= 0) goto L_0x0069
            java.lang.String r2 = r2.substring(r3)     // Catch:{ all -> 0x0070 }
            f13503f = r2     // Catch:{ all -> 0x0070 }
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "ls"
            r1[r4] = r3     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "-l"
            r1[r5] = r3     // Catch:{ all -> 0x0070 }
            r1[r6] = r2     // Catch:{ all -> 0x0070 }
            java.lang.String r1 = a((java.lang.String[]) r1)     // Catch:{ all -> 0x0070 }
            boolean r2 = a((java.lang.String) r1)     // Catch:{ all -> 0x0070 }
            if (r2 != 0) goto L_0x0069
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0070 }
            f13504g = r1     // Catch:{ all -> 0x0070 }
        L_0x0069:
            f13505h = r5     // Catch:{ all -> 0x0070 }
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            k()
            return
        L_0x0070:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.g.l():void");
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String file2 : list) {
                if (!a(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static String d() {
        String str = f13502e;
        return str != null ? str : "";
    }

    public static void b(Throwable th) {
        a(th, true);
    }

    public static String d(String str) {
        try {
            byte[] bytes = str.getBytes(XML.CHARSET_UTF8);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            int i10 = length + 0;
            for (int i11 = 0; i11 < i10; i11++) {
                byte b10 = digest[i11];
                char[] cArr = f13507j;
                char c10 = cArr[(b10 & 240) >> 4];
                char c11 = cArr[b10 & 15];
                sb.append(c10);
                sb.append(c11);
            }
            return sb.toString();
        } catch (Exception e10) {
            a.a("crashsdk", "getMD5: ", e10);
            return null;
        }
    }

    public static String b() {
        return f13500c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022 A[SYNTHETIC, Splitter:B:14:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r4, int r5, boolean r6) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x001e }
            r2.<init>(r4)     // Catch:{ all -> 0x001e }
            byte[] r4 = new byte[r5]     // Catch:{ all -> 0x001c }
            int r5 = r2.read(r4)     // Catch:{ all -> 0x001c }
            if (r5 <= 0) goto L_0x0018
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x001c }
            r3.<init>(r4, r0, r5)     // Catch:{ all -> 0x001c }
            a((java.io.Closeable) r2)
            return r3
        L_0x0018:
            a((java.io.Closeable) r2)
            goto L_0x002b
        L_0x001c:
            r4 = move-exception
            goto L_0x0020
        L_0x001e:
            r4 = move-exception
            r2 = r1
        L_0x0020:
            if (r6 == 0) goto L_0x0018
            a((java.lang.Throwable) r4, (boolean) r0)     // Catch:{ all -> 0x0026 }
            goto L_0x0018
        L_0x0026:
            r4 = move-exception
            a((java.io.Closeable) r2)
            throw r4
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.g.a(java.io.File, int, boolean):java.lang.String");
    }

    public static boolean e() {
        if (g()) {
            return true;
        }
        return f();
    }

    public static long c(String str) {
        if (a(str)) {
            return 0;
        }
        try {
            long parseLong = Long.parseLong(str.trim());
            if (parseLong < 0) {
                return 0;
            }
            return parseLong;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static String c() {
        return f13501d;
    }

    public static ArrayList<String> a(File file, int i10) {
        BufferedReader bufferedReader;
        ArrayList<String> arrayList = new ArrayList<>();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2, 512);
                int i11 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        i11++;
                        if (i10 > 0 && i11 >= i10) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        try {
                            a(th, false);
                            a((Closeable) fileReader);
                            a((Closeable) bufferedReader);
                            return arrayList;
                        } catch (Throwable th2) {
                            a((Closeable) fileReader);
                            a((Closeable) bufferedReader);
                            throw th2;
                        }
                    }
                }
                a((Closeable) fileReader2);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                fileReader = fileReader2;
                a(th, false);
                a((Closeable) fileReader);
                a((Closeable) bufferedReader);
                return arrayList;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            a(th, false);
            a((Closeable) fileReader);
            a((Closeable) bufferedReader);
            return arrayList;
        }
        a((Closeable) bufferedReader);
        return arrayList;
    }

    /* JADX INFO: finally extract failed */
    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                a((Closeable) fileOutputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    a(th, false);
                    a((Closeable) fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    a((Closeable) fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            a(th, false);
            a((Closeable) fileOutputStream);
            return false;
        }
    }

    public static boolean a(File file, String str) {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str, 0, str.length());
                a((Closeable) fileWriter2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                try {
                    a(th, false);
                    return false;
                } finally {
                    a((Closeable) fileWriter);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            a(th, false);
            return false;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a(th, true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        if (r2.toLowerCase().startsWith(anet.channel.util.HttpConstant.HTTP) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r2, java.lang.String r3, boolean r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 == 0) goto L_0x002a
            java.lang.String r2 = com.uc.crashsdk.a.b.a(r2)
            boolean r0 = a((java.lang.String) r2)
            if (r0 == 0) goto L_0x0017
            goto L_0x002a
        L_0x0017:
            if (r4 == 0) goto L_0x0029
            java.lang.String r2 = r2.trim()
            java.lang.String r4 = r2.toLowerCase()
            java.lang.String r0 = "http"
            boolean r4 = r4.startsWith(r0)
            if (r4 == 0) goto L_0x002a
        L_0x0029:
            r1 = r2
        L_0x002a:
            if (r1 != 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r3 = r1
        L_0x002e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.g.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static void a(Throwable th) {
        a(th, false);
    }

    private static void a(Throwable th, boolean z10) {
        if (!z10) {
            try {
                if (!com.uc.crashsdk.g.P()) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        th.printStackTrace();
    }

    public static void a(Context context) {
        if (f13499b != null) {
            a.b("mContext is existed");
        }
        f13499b = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        f13500c = applicationInfo.dataDir;
        f13501d = applicationInfo.sourceDir;
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            if (obj != null && (obj instanceof String)) {
                f13502e = (String) obj;
            }
        } catch (Throwable th) {
            a(th, false);
        }
    }

    public static Context a() {
        return f13499b;
    }

    public static void a(int i10) {
        if (i10 == 800) {
            l();
        } else if (!f13498a) {
            throw new AssertionError();
        }
    }

    private static String a(String[] strArr) {
        BufferedReader bufferedReader;
        Reader reader;
        try {
            reader = new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream());
            try {
                bufferedReader = new BufferedReader(reader, 512);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                try {
                    a(th, false);
                    return null;
                } finally {
                    a((Closeable) bufferedReader);
                    a((Closeable) reader);
                }
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String trim = sb.toString().trim();
                        a((Closeable) bufferedReader);
                        a((Closeable) reader);
                        return trim;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                a(th, false);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            reader = bufferedReader;
            a(th, false);
            return null;
        }
    }
}
