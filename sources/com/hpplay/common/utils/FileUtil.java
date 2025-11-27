package com.hpplay.common.utils;

import android.os.StatFs;
import com.hpplay.common.log.LeLog;
import java.io.File;

public class FileUtil {
    private static final String TAG = "FileUtil";

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098 A[SYNTHETIC, Splitter:B:45:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a2 A[SYNTHETIC, Splitter:B:50:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ae A[SYNTHETIC, Splitter:B:56:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b8 A[SYNTHETIC, Splitter:B:61:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void compress(java.util.zip.ZipOutputStream r8, java.io.BufferedOutputStream r9, java.io.File r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "FileUtil"
            r1 = 0
            boolean r2 = r10.isDirectory()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r2 == 0) goto L_0x0050
            java.io.File[] r10 = r10.listFiles()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            int r2 = r10.length     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.lang.String r3 = "/"
            if (r2 != 0) goto L_0x002a
            java.util.zip.ZipEntry r9 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r10.<init>()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r10.append(r11)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r10.append(r3)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r8.putNextEntry(r9)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            goto L_0x004e
        L_0x002a:
            r2 = 0
        L_0x002b:
            int r4 = r10.length     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r2 >= r4) goto L_0x004e
            r4 = r10[r2]     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5.<init>()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5.append(r11)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5.append(r3)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r6 = r10[r2]     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5.append(r6)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            compress(r8, r9, r4, r5)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            int r2 = r2 + 1
            goto L_0x002b
        L_0x004e:
            r8 = r1
            goto L_0x006e
        L_0x0050:
            java.util.zip.ZipEntry r2 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r2.<init>(r11)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r8.putNextEntry(r2)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r8.<init>(r10)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0089, all -> 0x0084 }
            r10.<init>(r8)     // Catch:{ Exception -> 0x0089, all -> 0x0084 }
        L_0x0062:
            int r11 = r10.read()     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            r1 = -1
            if (r11 == r1) goto L_0x006d
            r9.write(r11)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            goto L_0x0062
        L_0x006d:
            r1 = r10
        L_0x006e:
            if (r1 == 0) goto L_0x0078
            r1.close()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r9 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x0078:
            if (r8 == 0) goto L_0x00aa
            r8.close()     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00aa
        L_0x007e:
            r9 = move-exception
            r1 = r10
            goto L_0x0085
        L_0x0081:
            r9 = move-exception
            r1 = r10
            goto L_0x008a
        L_0x0084:
            r9 = move-exception
        L_0x0085:
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00ac
        L_0x0089:
            r9 = move-exception
        L_0x008a:
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x0093
        L_0x008e:
            r8 = move-exception
            r9 = r1
            goto L_0x00ac
        L_0x0091:
            r8 = move-exception
            r9 = r1
        L_0x0093:
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r8)     // Catch:{ all -> 0x00ab }
            if (r1 == 0) goto L_0x00a0
            r1.close()     // Catch:{ Exception -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r8 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r8)
        L_0x00a0:
            if (r9 == 0) goto L_0x00aa
            r9.close()     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00aa
        L_0x00a6:
            r8 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r8)
        L_0x00aa:
            return
        L_0x00ab:
            r8 = move-exception
        L_0x00ac:
            if (r1 == 0) goto L_0x00b6
            r1.close()     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00b6
        L_0x00b2:
            r10 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r10)
        L_0x00b6:
            if (r9 == 0) goto L_0x00c0
            r9.close()     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c0
        L_0x00bc:
            r9 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x00c0:
            goto L_0x00c2
        L_0x00c1:
            throw r8
        L_0x00c2:
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.FileUtil.compress(java.util.zip.ZipOutputStream, java.io.BufferedOutputStream, java.io.File, java.lang.String):void");
    }

    public static void deleteAllChildFile(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String file2 : list) {
                deleteFile(new File(file, file2));
            }
        }
    }

    public static boolean deleteFile(String str) {
        return deleteFile(new File(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053 A[SYNTHETIC, Splitter:B:23:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005e A[SYNTHETIC, Splitter:B:28:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] file2Bytes(java.lang.String r4) {
        /*
            java.lang.String r0 = "file2String"
            java.lang.String r1 = "FileUtil"
            com.hpplay.common.log.LeLog.i(r1, r0)
            r0 = 0
            byte[] r0 = new byte[r0]
            java.io.File r2 = new java.io.File
            r2.<init>(r4)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x002a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r4 = " is not exist: "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.String) r4)
            return r0
        L_0x002a:
            r4 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004b, all -> 0x0047 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x004b, all -> 0x0047 }
            int r4 = r3.available()     // Catch:{ Exception -> 0x0045 }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0045 }
            r3.read(r4)     // Catch:{ Exception -> 0x0045 }
            r3.close()     // Catch:{ Exception -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.Throwable) r0)
        L_0x0041:
            r0 = r4
            goto L_0x005b
        L_0x0043:
            r4 = move-exception
            goto L_0x005c
        L_0x0045:
            r4 = move-exception
            goto L_0x004e
        L_0x0047:
            r0 = move-exception
            r3 = r4
            r4 = r0
            goto L_0x005c
        L_0x004b:
            r2 = move-exception
            r3 = r4
            r4 = r2
        L_0x004e:
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x005b
            r3.close()     // Catch:{ Exception -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.Throwable) r4)
        L_0x005b:
            return r0
        L_0x005c:
            if (r3 == 0) goto L_0x0066
            r3.close()     // Catch:{ Exception -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r0 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.Throwable) r0)
        L_0x0066:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.FileUtil.file2Bytes(java.lang.String):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0070, code lost:
        com.hpplay.common.log.LeLog.w(TAG, (java.lang.Throwable) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[SYNTHETIC, Splitter:B:22:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076 A[SYNTHETIC, Splitter:B:27:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String file2String(java.lang.String r6) {
        /*
            java.lang.String r0 = "file2String"
            java.lang.String r1 = "FileUtil"
            com.hpplay.common.log.LeLog.i(r1, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r2 = r0.exists()
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0029
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = " is not exist: "
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.String) r6)
            return r3
        L_0x0029:
            r2 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0050 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0050 }
            int r0 = r4.available()     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r4.read(r0)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            java.lang.String r5 = "UTF-8"
            r2.<init>(r0, r5)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r4.close()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r6 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.Throwable) r6)
        L_0x0047:
            r3 = r2
            goto L_0x0073
        L_0x0049:
            r6 = move-exception
            r2 = r4
            goto L_0x0074
        L_0x004c:
            r2 = r4
            goto L_0x0050
        L_0x004e:
            r6 = move-exception
            goto L_0x0074
        L_0x0050:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r0.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "read "
            r0.append(r4)     // Catch:{ all -> 0x004e }
            r0.append(r6)     // Catch:{ all -> 0x004e }
            java.lang.String r6 = " failed"
            r0.append(r6)     // Catch:{ all -> 0x004e }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x004e }
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r6 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.Throwable) r6)
        L_0x0073:
            return r3
        L_0x0074:
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ Exception -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r0 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.Throwable) r0)
        L_0x007e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.FileUtil.file2String(java.lang.String):java.lang.String");
    }

    public static long getAvailSize(String str) {
        StatFs statFs = new StatFs(str);
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[SYNTHETIC, Splitter:B:17:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049 A[SYNTHETIC, Splitter:B:20:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void string2File(java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "FileUtil"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x002d }
            r2.<init>(r5)     // Catch:{ Exception -> 0x002d }
            r2.delete()     // Catch:{ Exception -> 0x002d }
            r2.createNewFile()     // Catch:{ Exception -> 0x002d }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002d }
            r3.<init>(r2)     // Catch:{ Exception -> 0x002d }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
            r3.write(r4)     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
            r3.flush()     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
            r3.close()     // Catch:{ Exception -> 0x0021 }
            goto L_0x0046
        L_0x0021:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
            goto L_0x0046
        L_0x0026:
            r4 = move-exception
            r1 = r3
            goto L_0x0047
        L_0x0029:
            r1 = r3
            goto L_0x002d
        L_0x002b:
            r4 = move-exception
            goto L_0x0047
        L_0x002d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r4.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r2 = "string2File failed,"
            r4.append(r2)     // Catch:{ all -> 0x002b }
            r4.append(r5)     // Catch:{ all -> 0x002b }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002b }
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ Exception -> 0x0021 }
        L_0x0046:
            return
        L_0x0047:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ Exception -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r5 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r5)
        L_0x0051:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.FileUtil.string2File(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0057 A[SYNTHETIC, Splitter:B:38:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0061 A[SYNTHETIC, Splitter:B:43:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006b A[SYNTHETIC, Splitter:B:48:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0077 A[SYNTHETIC, Splitter:B:54:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0081 A[SYNTHETIC, Splitter:B:59:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x008b A[SYNTHETIC, Splitter:B:64:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zipFile(java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "FileUtil"
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004f, all -> 0x004b }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x004f, all -> 0x004b }
            r3.<init>(r5)     // Catch:{ Exception -> 0x004f, all -> 0x004b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x004f, all -> 0x004b }
            java.util.zip.ZipOutputStream r5 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x0046, all -> 0x0041 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0046, all -> 0x0041 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x003e, all -> 0x003b }
            r3.<init>(r5)     // Catch:{ Exception -> 0x003e, all -> 0x003b }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            java.lang.String r4 = r1.getName()     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            compress(r5, r3, r1, r4)     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            r2.close()     // Catch:{ Exception -> 0x0027 }
            goto L_0x002b
        L_0x0027:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x002b:
            r3.close()     // Catch:{ Exception -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x0033:
            r5.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0073
        L_0x0037:
            r4 = move-exception
            goto L_0x0044
        L_0x0039:
            r4 = move-exception
            goto L_0x0049
        L_0x003b:
            r4 = move-exception
            r3 = r1
            goto L_0x0044
        L_0x003e:
            r4 = move-exception
            r3 = r1
            goto L_0x0049
        L_0x0041:
            r4 = move-exception
            r5 = r1
            r3 = r5
        L_0x0044:
            r1 = r2
            goto L_0x0075
        L_0x0046:
            r4 = move-exception
            r5 = r1
            r3 = r5
        L_0x0049:
            r1 = r2
            goto L_0x0052
        L_0x004b:
            r4 = move-exception
            r5 = r1
            r3 = r5
            goto L_0x0075
        L_0x004f:
            r4 = move-exception
            r5 = r1
            r3 = r5
        L_0x0052:
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x005f
            r1.close()     // Catch:{ Exception -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x005f:
            if (r3 == 0) goto L_0x0069
            r3.close()     // Catch:{ Exception -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x0069:
            if (r5 == 0) goto L_0x0073
            r5.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x0073:
            return
        L_0x0074:
            r4 = move-exception
        L_0x0075:
            if (r1 == 0) goto L_0x007f
            r1.close()     // Catch:{ Exception -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r1 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x007f:
            if (r3 == 0) goto L_0x0089
            r3.close()     // Catch:{ Exception -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r1 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x0089:
            if (r5 == 0) goto L_0x0093
            r5.close()     // Catch:{ Exception -> 0x008f }
            goto L_0x0093
        L_0x008f:
            r5 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r5)
        L_0x0093:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.FileUtil.zipFile(java.lang.String, java.lang.String):void");
    }

    public static boolean deleteFile(File file) {
        LeLog.i(TAG, "delete dir: " + file.getAbsolutePath());
        try {
            if (file.isDirectory()) {
                deleteAllChildFile(file);
            }
            return file.delete();
        } catch (Exception e10) {
            LeLog.i(TAG, "deleteFile:" + e10);
            return false;
        }
    }
}
