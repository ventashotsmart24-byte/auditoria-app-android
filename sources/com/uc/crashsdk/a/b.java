package com.uc.crashsdk.a;

import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f13472a = {126, 147, 115, 241, 101, 198, 215, 134};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f13473b = {125, 185, 233, 226, 129, 142, 151, 176};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f13474c = {238, 185, 233, 179, 129, 142, 151, 167};

    public static String a(String str) {
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[((int) file.length())];
                fileInputStream3.read(bArr);
                g.a((Closeable) fileInputStream3);
                byte[] a10 = a(bArr, f13472a);
                if (a10 == null || a10.length <= 0) {
                    g.a((Closeable) null);
                    return null;
                }
                int length = a10.length - 1;
                String str2 = a10[length] == 10 ? new String(a10, 0, length) : new String(a10);
                g.a((Closeable) null);
                return str2;
            } catch (Exception e10) {
                Exception exc = e10;
                fileInputStream = fileInputStream3;
                e = exc;
                try {
                    g.a((Throwable) e);
                    g.a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    g.a((Closeable) fileInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                fileInputStream2 = fileInputStream3;
                th = th2;
                g.a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
            g.a((Throwable) e);
            g.a((Closeable) fileInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            g.a((Closeable) fileInputStream2);
            throw th;
        }
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (!(bArr == null || iArr == null || iArr.length != 8)) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[(length + 2)];
                byte b10 = 0;
                for (int i10 = 0; i10 < length; i10++) {
                    byte b11 = bArr[i10];
                    bArr2[i10] = (byte) (iArr[i10 % 8] ^ b11);
                    b10 = (byte) (b10 ^ b11);
                }
                bArr2[length] = (byte) (iArr[0] ^ b10);
                bArr2[length + 1] = (byte) (iArr[1] ^ b10);
                return bArr2;
            } catch (Exception e10) {
                g.a((Throwable) e10);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0068 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            if (r9 != 0) goto L_0x0003
            return r7
        L_0x0003:
            boolean r0 = com.uc.crashsdk.a.g.a((java.lang.String) r7)
            if (r0 == 0) goto L_0x000a
            return r7
        L_0x000a:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x00c3
            long r1 = r0.length()
            r3 = 3145728(0x300000, double:1.554196E-317)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0022
            goto L_0x00c3
        L_0x0022:
            byte[] r1 = com.uc.crashsdk.a.g.e(r0)
            if (r1 == 0) goto L_0x00c3
            int r2 = r1.length
            if (r2 > 0) goto L_0x002d
            goto L_0x00c3
        L_0x002d:
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L_0x0088
            r9 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0050 }
            r4.<init>()     // Catch:{ all -> 0x0050 }
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x004b }
            r5.<init>(r4)     // Catch:{ all -> 0x004b }
            r5.write(r1)     // Catch:{ all -> 0x0049 }
            r4.flush()     // Catch:{ all -> 0x0049 }
            com.uc.crashsdk.a.g.a((java.io.Closeable) r4)
        L_0x0045:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r5)
            goto L_0x005b
        L_0x0049:
            r9 = move-exception
            goto L_0x0054
        L_0x004b:
            r5 = move-exception
            r6 = r5
            r5 = r9
            r9 = r6
            goto L_0x0054
        L_0x0050:
            r4 = move-exception
            r5 = r9
            r9 = r4
            r4 = r5
        L_0x0054:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r9)     // Catch:{ all -> 0x0080 }
            com.uc.crashsdk.a.g.a((java.io.Closeable) r4)
            goto L_0x0045
        L_0x005b:
            byte[] r1 = r4.toByteArray()     // Catch:{ all -> 0x0061 }
            r9 = 1
            goto L_0x0066
        L_0x0061:
            r9 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r9)
            r9 = 0
        L_0x0066:
            if (r9 == 0) goto L_0x007f
            if (r1 == 0) goto L_0x007f
            int r9 = r1.length
            if (r9 > 0) goto L_0x006e
            goto L_0x007f
        L_0x006e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = 1
            goto L_0x008a
        L_0x007f:
            return r7
        L_0x0080:
            r7 = move-exception
            com.uc.crashsdk.a.g.a((java.io.Closeable) r4)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r5)
            throw r7
        L_0x0088:
            r8 = r7
            r9 = 0
        L_0x008a:
            if (r9 == 0) goto L_0x00c3
            java.lang.String r9 = r0.getName()
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x00a9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            java.lang.String r4 = ".tmp"
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            r4 = 1
            goto L_0x00ab
        L_0x00a9:
            r9 = r8
            r4 = 0
        L_0x00ab:
            java.io.File r5 = new java.io.File
            r5.<init>(r9)
            boolean r9 = com.uc.crashsdk.a.g.a((java.io.File) r5, (byte[]) r1)
            if (r9 != 0) goto L_0x00b8
            r2 = 0
            goto L_0x00c0
        L_0x00b8:
            if (r4 == 0) goto L_0x00c0
            r0.delete()
            r5.renameTo(r0)
        L_0x00c0:
            if (r2 == 0) goto L_0x00c3
            return r8
        L_0x00c3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b10 = 0;
                for (int i10 = 0; i10 < length; i10++) {
                    byte b11 = (byte) (bArr[i10 + 0] ^ iArr[i10 % 8]);
                    bArr2[i10] = b11;
                    b10 = (byte) (b10 ^ b11);
                }
                if (bArr[length + 0] == ((byte) ((iArr[0] ^ b10) & UnsignedBytes.MAX_VALUE)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b10) & UnsignedBytes.MAX_VALUE))) {
                    return bArr2;
                }
                return null;
            } catch (Exception e10) {
                g.a((Throwable) e10);
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            g.a(th);
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b10 = b(str2.getBytes(), f13472a);
        if (b10 == null) {
            g.a((Closeable) fileOutputStream);
            return false;
        }
        try {
            fileOutputStream.write(b10);
            g.a((Closeable) fileOutputStream);
            return true;
        } catch (Throwable th2) {
            g.a((Closeable) fileOutputStream);
            throw th2;
        }
    }
}
