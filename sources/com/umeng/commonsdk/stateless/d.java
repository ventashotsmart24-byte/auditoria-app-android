package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f14870a;

    /* renamed from: b  reason: collision with root package name */
    private static Object f14871b = new Object();

    public static boolean a(long j10, long j11) {
        return j10 > j11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b2, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b4, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0101, code lost:
        if (r1 == null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd A[Catch:{ IOException -> 0x00de, all -> 0x00b8, all -> 0x0108 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.content.Context r8, java.lang.String r9, java.lang.String r10, byte[] r11) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x010f
            r1 = 0
            r2 = 1
            java.lang.Object r3 = f14871b     // Catch:{ IOException -> 0x00de, all -> 0x00b8 }
            monitor-enter(r3)     // Catch:{ IOException -> 0x00de, all -> 0x00b8 }
            java.lang.String r4 = "walle"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r6.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = "[stateless] begin write envelope, thread is "
            r6.append(r7)     // Catch:{ all -> 0x00ae }
            java.lang.Thread r7 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00ae }
            r6.append(r7)     // Catch:{ all -> 0x00ae }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ae }
            r5[r0] = r6     // Catch:{ all -> 0x00ae }
            com.umeng.commonsdk.statistics.common.ULog.i((java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x00ae }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r5.<init>()     // Catch:{ all -> 0x00ae }
            java.io.File r6 = r8.getFilesDir()     // Catch:{ all -> 0x00ae }
            r5.append(r6)     // Catch:{ all -> 0x00ae }
            java.lang.String r6 = "/"
            r5.append(r6)     // Catch:{ all -> 0x00ae }
            java.lang.String r6 = com.umeng.commonsdk.stateless.a.f14848e     // Catch:{ all -> 0x00ae }
            r5.append(r6)     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ae }
            r4.<init>(r5)     // Catch:{ all -> 0x00ae }
            boolean r5 = r4.isDirectory()     // Catch:{ all -> 0x00ae }
            if (r5 != 0) goto L_0x004e
            r4.mkdir()     // Catch:{ all -> 0x00ae }
        L_0x004e:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r6.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = r4.getPath()     // Catch:{ all -> 0x00ae }
            r6.append(r4)     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = "/"
            r6.append(r4)     // Catch:{ all -> 0x00ae }
            r6.append(r9)     // Catch:{ all -> 0x00ae }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x00ae }
            r5.<init>(r9)     // Catch:{ all -> 0x00ae }
            boolean r9 = r5.isDirectory()     // Catch:{ all -> 0x00ae }
            if (r9 != 0) goto L_0x0074
            r5.mkdir()     // Catch:{ all -> 0x00ae }
        L_0x0074:
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r4.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = r5.getPath()     // Catch:{ all -> 0x00ae }
            r4.append(r5)     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = "/"
            r4.append(r5)     // Catch:{ all -> 0x00ae }
            r4.append(r10)     // Catch:{ all -> 0x00ae }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x00ae }
            r9.<init>(r10)     // Catch:{ all -> 0x00ae }
            boolean r10 = r9.exists()     // Catch:{ all -> 0x00ae }
            if (r10 != 0) goto L_0x009a
            r9.createNewFile()     // Catch:{ all -> 0x00ae }
        L_0x009a:
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ae }
            r10.<init>(r9)     // Catch:{ all -> 0x00ae }
            r10.write(r11)     // Catch:{ all -> 0x00ab }
            r10.close()     // Catch:{ all -> 0x00ab }
            monitor-exit(r3)     // Catch:{ all -> 0x00a8 }
            r0 = 1
            goto L_0x010f
        L_0x00a8:
            r9 = move-exception
            r10 = 1
            goto L_0x00b0
        L_0x00ab:
            r9 = move-exception
            r1 = r10
            goto L_0x00af
        L_0x00ae:
            r9 = move-exception
        L_0x00af:
            r10 = 0
        L_0x00b0:
            monitor-exit(r3)     // Catch:{ all -> 0x00b6 }
            throw r9     // Catch:{ IOException -> 0x00b4, all -> 0x00b2 }
        L_0x00b2:
            r9 = move-exception
            goto L_0x00ba
        L_0x00b4:
            r9 = move-exception
            goto L_0x00e0
        L_0x00b6:
            r9 = move-exception
            goto L_0x00b0
        L_0x00b8:
            r9 = move-exception
            r10 = 0
        L_0x00ba:
            java.lang.String r11 = "walle"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r3.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = "[stateless] write envelope, e is "
            r3.append(r4)     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = r9.getMessage()     // Catch:{ all -> 0x0108 }
            r3.append(r4)     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0108 }
            r2[r0] = r3     // Catch:{ all -> 0x0108 }
            com.umeng.commonsdk.statistics.common.ULog.i((java.lang.String) r11, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0108 }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r8, r9)     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x0106
            goto L_0x0103
        L_0x00de:
            r9 = move-exception
            r10 = 0
        L_0x00e0:
            java.lang.String r11 = "walle"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r3.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = "[stateless] write envelope, e is "
            r3.append(r4)     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = r9.getMessage()     // Catch:{ all -> 0x0108 }
            r3.append(r4)     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0108 }
            r2[r0] = r3     // Catch:{ all -> 0x0108 }
            com.umeng.commonsdk.statistics.common.ULog.i((java.lang.String) r11, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0108 }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r8, r9)     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x0106
        L_0x0103:
            r1.close()     // Catch:{ IOException -> 0x0106 }
        L_0x0106:
            r0 = r10
            goto L_0x010f
        L_0x0108:
            r8 = move-exception
            if (r1 == 0) goto L_0x010e
            r1.close()     // Catch:{ IOException -> 0x010e }
        L_0x010e:
            throw r8
        L_0x010f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.b(android.content.Context, java.lang.String, java.lang.String, byte[]):boolean");
    }

    public static File[] c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f14871b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f14849f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f14871b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        if (listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() {
                                /* renamed from: a */
                                public int compare(File file, File file2) {
                                    long lastModified = file.lastModified() - file2.lastModified();
                                    if (lastModified > 0) {
                                        return 1;
                                    }
                                    if (lastModified == 0) {
                                        return 0;
                                    }
                                    return -1;
                                }
                            });
                            return listFiles;
                        }
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String d(String str) {
        int lastIndexOf;
        int lastIndexOf2;
        if (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (lastIndexOf = str.lastIndexOf("_")) >= 0 && (lastIndexOf2 = str.lastIndexOf(".")) >= 0) {
            return str.substring(lastIndexOf + 1, lastIndexOf2);
        }
        return "";
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!a(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r1 == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        if (r1 == null) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r6, java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = 101(0x65, float:1.42E-43)
            if (r6 == 0) goto L_0x0075
            r1 = 0
            java.lang.Object r2 = f14871b     // Catch:{ IOException -> 0x0067, all -> 0x005d }
            monitor-enter(r2)     // Catch:{ IOException -> 0x0067, all -> 0x005d }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x005a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r4.<init>()     // Catch:{ all -> 0x005a }
            java.io.File r5 = r6.getFilesDir()     // Catch:{ all -> 0x005a }
            r4.append(r5)     // Catch:{ all -> 0x005a }
            java.lang.String r5 = java.io.File.separator     // Catch:{ all -> 0x005a }
            r4.append(r5)     // Catch:{ all -> 0x005a }
            r4.append(r7)     // Catch:{ all -> 0x005a }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x005a }
            r3.<init>(r7)     // Catch:{ all -> 0x005a }
            boolean r7 = r3.isDirectory()     // Catch:{ all -> 0x005a }
            if (r7 != 0) goto L_0x002e
            r3.mkdir()     // Catch:{ all -> 0x005a }
        L_0x002e:
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x005a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r4.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r3 = r3.getPath()     // Catch:{ all -> 0x005a }
            r4.append(r3)     // Catch:{ all -> 0x005a }
            r4.append(r5)     // Catch:{ all -> 0x005a }
            r4.append(r8)     // Catch:{ all -> 0x005a }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x005a }
            r7.<init>(r8)     // Catch:{ all -> 0x005a }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x005a }
            r8.<init>(r7)     // Catch:{ all -> 0x005a }
            r8.write(r9)     // Catch:{ all -> 0x0057 }
            r8.close()     // Catch:{ all -> 0x0057 }
            r0 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x005a }
            goto L_0x0075
        L_0x0057:
            r7 = move-exception
            r1 = r8
            goto L_0x005b
        L_0x005a:
            r7 = move-exception
        L_0x005b:
            monitor-exit(r2)     // Catch:{ all -> 0x005a }
            throw r7     // Catch:{ IOException -> 0x0067, all -> 0x005d }
        L_0x005d:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0075
        L_0x0063:
            r1.close()     // Catch:{ all -> 0x0075 }
            goto L_0x0075
        L_0x0067:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0075
            goto L_0x0063
        L_0x006e:
            r6 = move-exception
            if (r1 == 0) goto L_0x0074
            r1.close()     // Catch:{ all -> 0x0074 }
        L_0x0074:
            throw r6
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.a(android.content.Context, java.lang.String, java.lang.String, byte[]):int");
    }

    public static String c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0062 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0038 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0062=Splitter:B:21:0x0062, B:9:0x0038=Splitter:B:9:0x0038} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r11) {
        /*
            java.lang.Object r0 = f14871b
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x003c }
            java.lang.String r4 = "r"
            r3.<init>(r11, r4)     // Catch:{ IOException -> 0x003c }
            java.nio.channels.FileChannel r2 = r3.getChannel()     // Catch:{ IOException -> 0x003c }
            java.nio.channels.FileChannel$MapMode r6 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ IOException -> 0x003c }
            r7 = 0
            long r9 = r2.size()     // Catch:{ IOException -> 0x003c }
            r5 = r2
            java.nio.MappedByteBuffer r11 = r5.map(r6, r7, r9)     // Catch:{ IOException -> 0x003c }
            java.nio.MappedByteBuffer r11 = r11.load()     // Catch:{ IOException -> 0x003c }
            long r3 = r2.size()     // Catch:{ IOException -> 0x003c }
            int r4 = (int) r3     // Catch:{ IOException -> 0x003c }
            byte[] r3 = new byte[r4]     // Catch:{ IOException -> 0x003c }
            int r4 = r11.remaining()     // Catch:{ IOException -> 0x003c }
            if (r4 <= 0) goto L_0x0035
            int r4 = r11.remaining()     // Catch:{ IOException -> 0x003c }
            r11.get(r3, r1, r4)     // Catch:{ IOException -> 0x003c }
        L_0x0035:
            r2.close()     // Catch:{ all -> 0x0038 }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return r3
        L_0x003a:
            r11 = move-exception
            goto L_0x005d
        L_0x003c:
            r11 = move-exception
            java.lang.String r3 = "walle"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r5.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r6 = "[stateless] write envelope, e is "
            r5.append(r6)     // Catch:{ all -> 0x003a }
            java.lang.String r6 = r11.getMessage()     // Catch:{ all -> 0x003a }
            r5.append(r6)     // Catch:{ all -> 0x003a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x003a }
            r4[r1] = r5     // Catch:{ all -> 0x003a }
            com.umeng.commonsdk.statistics.common.ULog.i((java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ all -> 0x003a }
            throw r11     // Catch:{ all -> 0x003a }
        L_0x005d:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ all -> 0x0062 }
        L_0x0062:
            throw r11     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.a(java.lang.String):byte[]");
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f14871b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f14849f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f14871b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        if (listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() {
                                /* renamed from: a */
                                public int compare(File file, File file2) {
                                    long lastModified = file.lastModified() - file2.lastModified();
                                    if (lastModified > 0) {
                                        return 1;
                                    }
                                    if (lastModified == 0) {
                                        return 0;
                                    }
                                    return -1;
                                }
                            });
                            File file2 = listFiles[0];
                            return file2;
                        }
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < bArr.length; i10++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i10])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static File a(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File file = null;
        try {
            synchronized (f14871b) {
                ULog.i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                if (!(context == null || context.getApplicationContext() == null)) {
                    String str = context.getApplicationContext().getFilesDir() + File.separator + a.f14848e;
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            for (File file3 : listFiles) {
                                if (file3 != null && file3.isDirectory() && (listFiles2 = file3.listFiles()) != null && listFiles2.length > 0) {
                                    Arrays.sort(listFiles2, new Comparator<File>() {
                                        /* renamed from: a */
                                        public int compare(File file, File file2) {
                                            long lastModified = file.lastModified() - file2.lastModified();
                                            if (lastModified > 0) {
                                                return 1;
                                            }
                                            if (lastModified == 0) {
                                                return 0;
                                            }
                                            return -1;
                                        }
                                    });
                                    File file4 = listFiles2[0];
                                    if (file4 != null && (file == null || file.lastModified() > file4.lastModified())) {
                                        file = file4;
                                    }
                                }
                            }
                        }
                    }
                }
                ULog.i("walle", "get last envelope end, thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return file;
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, boolean z10) {
        String str;
        if (context == null) {
            return null;
        }
        if (z10) {
            try {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f14848e;
            } catch (Throwable unused) {
                return null;
            }
        } else {
            str = context.getApplicationContext().getFilesDir() + File.separator + a.f14849f;
        }
        return str;
    }

    public static void a(Context context, String str, int i10) {
        if (str == null) {
            try {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        } else {
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (f14871b) {
                File[] listFiles = file.listFiles();
                ULog.i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + Thread.currentThread());
                if (listFiles.length >= i10) {
                    ULog.i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i10) {
                        Collections.sort(arrayList, new Comparator<File>() {
                            /* renamed from: a */
                            public int compare(File file, File file2) {
                                if (file != null && file2 != null && file.lastModified() < file2.lastModified()) {
                                    return -1;
                                }
                                if (file == null || file2 == null || file.lastModified() != file2.lastModified()) {
                                    return 1;
                                }
                                return 0;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                                ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i11)).getPath());
                            }
                        }
                        for (int i12 = 0; i12 <= arrayList.size() - i10; i12++) {
                            if (arrayList.get(i12) != null) {
                                ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i12)).getPath());
                                try {
                                    ((File) arrayList.get(i12)).delete();
                                    arrayList.remove(i12);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                } else {
                    ULog.i("AmapLBS", "[lbs-build] file size < max");
                }
                ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
            }
        }
    }

    public static void a(Context context, String str, final String str2, int i10) {
        if (str != null) {
            try {
                File file = new File(str);
                if (file.isDirectory()) {
                    synchronized (f14871b) {
                        File[] listFiles = file.listFiles(new FilenameFilter() {
                            public boolean accept(File file, String str) {
                                if (str.startsWith(str2)) {
                                    return true;
                                }
                                return false;
                            }
                        });
                        if (listFiles == null || listFiles.length < i10) {
                            ULog.i("AmapLBS", "[lbs-build] file size < max");
                        } else {
                            ULog.i("AmapLBS", "[lbs-build] file size >= max");
                            ArrayList arrayList = new ArrayList();
                            for (File file2 : listFiles) {
                                if (file2 != null) {
                                    arrayList.add(file2);
                                }
                            }
                            if (arrayList.size() >= i10) {
                                Collections.sort(arrayList, new Comparator<File>() {
                                    /* renamed from: a */
                                    public int compare(File file, File file2) {
                                        if (file != null && file2 != null && file.lastModified() < file2.lastModified()) {
                                            return -1;
                                        }
                                        if (file == null || file2 == null || file.lastModified() != file2.lastModified()) {
                                            return 1;
                                        }
                                        return 0;
                                    }
                                });
                                if (ULog.DEBUG) {
                                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                                        ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i11)).getPath());
                                    }
                                }
                                for (int i12 = 0; i12 <= arrayList.size() - i10; i12++) {
                                    if (arrayList.get(i12) != null) {
                                        ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i12)).getPath());
                                        try {
                                            ((File) arrayList.get(i12)).delete();
                                            arrayList.remove(i12);
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            }
                        }
                        ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0046
            int r1 = r5.length
            if (r1 > 0) goto L_0x0007
            goto L_0x0046
        L_0x0007:
            java.util.zip.Deflater r1 = new java.util.zip.Deflater
            r1.<init>()
            r1.setInput(r5)
            r1.finish()
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]
            r2 = 0
            f14870a = r2
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003f }
            r3.<init>()     // Catch:{ all -> 0x003f }
        L_0x001e:
            boolean r0 = r1.finished()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x0031
            int r0 = r1.deflate(r5)     // Catch:{ all -> 0x003c }
            int r4 = f14870a     // Catch:{ all -> 0x003c }
            int r4 = r4 + r0
            f14870a = r4     // Catch:{ all -> 0x003c }
            r3.write(r5, r2, r0)     // Catch:{ all -> 0x003c }
            goto L_0x001e
        L_0x0031:
            r1.end()     // Catch:{ all -> 0x003c }
            r3.close()
            byte[] r5 = r3.toByteArray()
            return r5
        L_0x003c:
            r5 = move-exception
            r0 = r3
            goto L_0x0040
        L_0x003f:
            r5 = move-exception
        L_0x0040:
            if (r0 == 0) goto L_0x0045
            r0.close()
        L_0x0045:
            throw r5
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.a(byte[]):byte[]");
    }
}
