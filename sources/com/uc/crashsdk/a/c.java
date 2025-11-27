package com.uc.crashsdk.a;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13475a = true;

    /* renamed from: b  reason: collision with root package name */
    private static String f13476b = "";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z10) {
        return a(bArr, bArr2, z10, true);
    }

    private static boolean b(File file, String str, String str2) {
        try {
            byte[] a10 = a(file);
            if (a10 != null) {
                if (a10.length != 0) {
                    return a(a10, str, str2);
                }
            }
            return false;
        } catch (Exception e10) {
            g.a((Throwable) e10);
            return false;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z10, boolean z11) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(z10 ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (!z10) {
            return instance.doFinal(bArr);
        }
        if (!z11) {
            bArr = a(bArr);
        }
        return instance.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 16)];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i10 = 4; i10 < 16; i10++) {
            bArr2[i10] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] a() {
        return new byte[]{48, Ascii.EM, 6, 55};
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.io.Closeable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0094 A[SYNTHETIC, Splitter:B:42:0x0094] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r7, byte[] r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x0085 }
            r1.<init>(r7)     // Catch:{ all -> 0x0085 }
            java.net.URLConnection r7 = r1.openConnection()     // Catch:{ all -> 0x0085 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ all -> 0x0085 }
            r1 = 5000(0x1388, float:7.006E-42)
            r7.setConnectTimeout(r1)     // Catch:{ all -> 0x0083 }
            r7.setReadTimeout(r1)     // Catch:{ all -> 0x0083 }
            r1 = 1
            r7.setDoInput(r1)     // Catch:{ all -> 0x0083 }
            r7.setDoOutput(r1)     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = "POST"
            r7.setRequestMethod(r1)     // Catch:{ all -> 0x0083 }
            r1 = 0
            r7.setUseCaches(r1)     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r7.setRequestProperty(r2, r3)     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = "Content-Length"
            int r3 = r8.length     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0083 }
            r7.setRequestProperty(r2, r3)     // Catch:{ all -> 0x0083 }
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch:{ all -> 0x0083 }
            r2.write(r8)     // Catch:{ all -> 0x0080 }
            int r8 = r7.getResponseCode()     // Catch:{ all -> 0x0080 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r8 == r3) goto L_0x0051
            com.uc.crashsdk.a.g.a((java.io.Closeable) r2)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r0)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r0)
            r7.disconnect()     // Catch:{ all -> 0x0050 }
        L_0x0050:
            return r0
        L_0x0051:
            java.io.InputStream r8 = r7.getInputStream()     // Catch:{ all -> 0x0080 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x007e }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x007e }
            int r5 = r8.available()     // Catch:{ all -> 0x007e }
            r4.<init>(r5)     // Catch:{ all -> 0x007e }
        L_0x0062:
            int r5 = r8.read(r3)     // Catch:{ all -> 0x0089 }
            r6 = -1
            if (r5 == r6) goto L_0x006d
            r4.write(r3, r1, r5)     // Catch:{ all -> 0x0089 }
            goto L_0x0062
        L_0x006d:
            byte[] r0 = r4.toByteArray()     // Catch:{ all -> 0x0089 }
            com.uc.crashsdk.a.g.a((java.io.Closeable) r2)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r8)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r4)
            r7.disconnect()     // Catch:{ all -> 0x007d }
        L_0x007d:
            return r0
        L_0x007e:
            r4 = r0
            goto L_0x0089
        L_0x0080:
            r8 = r0
            r4 = r8
            goto L_0x0089
        L_0x0083:
            r8 = r0
            goto L_0x0087
        L_0x0085:
            r7 = r0
            r8 = r7
        L_0x0087:
            r2 = r8
            r4 = r2
        L_0x0089:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r2)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r8)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r4)
            if (r7 == 0) goto L_0x0097
            r7.disconnect()     // Catch:{ all -> 0x0097 }
        L_0x0097:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.c.a(java.lang.String, byte[]):byte[]");
    }

    public static void a(byte[] bArr, int i10, byte[] bArr2) {
        if (f13475a || bArr2.length == 4) {
            for (int i11 = 0; i11 < 4; i11++) {
                bArr[i11 + i10] = bArr2[i11];
            }
            return;
        }
        throw new AssertionError();
    }

    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        BufferedInputStream bufferedInputStream = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            int length = (int) file.length();
            fileInputStream = new FileInputStream(file);
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                try {
                    byte[] bArr2 = new byte[length];
                    int i10 = 0;
                    while (i10 < length) {
                        int read = bufferedInputStream2.read(bArr2, i10, length - i10);
                        if (-1 == read) {
                            break;
                        }
                        i10 += read;
                    }
                    g.a((Closeable) bufferedInputStream2);
                    g.a((Closeable) fileInputStream);
                    return bArr2;
                } catch (Exception e10) {
                    e = e10;
                    bufferedInputStream = bufferedInputStream2;
                    bArr = null;
                    try {
                        g.b((Throwable) e);
                        g.a((Closeable) bufferedInputStream);
                        g.a((Closeable) fileInputStream);
                        return bArr;
                    } catch (Throwable th) {
                        th = th;
                        g.a((Closeable) bufferedInputStream);
                        g.a((Closeable) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    g.a((Closeable) bufferedInputStream);
                    g.a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                bArr = null;
                g.b((Throwable) e);
                g.a((Closeable) bufferedInputStream);
                g.a((Closeable) fileInputStream);
                return bArr;
            }
        } catch (Exception e12) {
            e = e12;
            bArr = null;
            fileInputStream = null;
            g.b((Throwable) e);
            g.a((Closeable) bufferedInputStream);
            g.a((Closeable) fileInputStream);
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            g.a((Closeable) bufferedInputStream);
            g.a((Closeable) fileInputStream);
            throw th;
        }
    }

    public static boolean a(File file, String str, String str2) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (b(file, str, str2)) {
                return true;
            }
            a.a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x013e A[SYNTHETIC, Splitter:B:51:0x013e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(byte[] r10, java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "crashsdk"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Uploading to "
            r1.<init>(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            com.uc.crashsdk.a.a.a(r1)
            r1 = 0
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x012c }
            r3.<init>(r12)     // Catch:{ all -> 0x012c }
            java.net.URLConnection r12 = r3.openConnection()     // Catch:{ all -> 0x012c }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x012c }
            r3 = 10000(0x2710, float:1.4013E-41)
            r12.setConnectTimeout(r3)     // Catch:{ all -> 0x0128 }
            r3 = 60000(0xea60, float:8.4078E-41)
            r12.setReadTimeout(r3)     // Catch:{ all -> 0x0128 }
            r3 = 1
            r12.setDoInput(r3)     // Catch:{ all -> 0x0128 }
            r12.setDoOutput(r3)     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = "POST"
            r12.setRequestMethod(r4)     // Catch:{ all -> 0x0128 }
            r12.setUseCaches(r1)     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r4.<init>()     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = "------------izQ290kHh6g3Yn2IeyJCoc\r\n"
            r4.append(r5)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = "Content-Disposition: form-data; name=\"file\";"
            r4.append(r5)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = " filename=\""
            r4.append(r5)     // Catch:{ all -> 0x0128 }
            r4.append(r11)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = "\"\r\n"
            r4.append(r5)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = "Content-Type: application/octet-stream\r\n"
            r4.append(r5)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = "\r\n"
            r4.append(r5)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = "\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n"
            int r6 = r4.length()     // Catch:{ all -> 0x0128 }
            int r6 = r6 + 40
            int r7 = r10.length     // Catch:{ all -> 0x0128 }
            int r6 = r6 + r7
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc"
            r12.setRequestProperty(r7, r8)     // Catch:{ all -> 0x0128 }
            java.lang.String r7 = "Content-Disposition"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            java.lang.String r9 = "form-data; name=\"file\"; filename="
            r8.<init>(r9)     // Catch:{ all -> 0x0128 }
            r8.append(r11)     // Catch:{ all -> 0x0128 }
            java.lang.String r11 = r8.toString()     // Catch:{ all -> 0x0128 }
            r12.setRequestProperty(r7, r11)     // Catch:{ all -> 0x0128 }
            java.lang.String r11 = "Content-Length"
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0128 }
            r12.setRequestProperty(r11, r6)     // Catch:{ all -> 0x0128 }
            java.io.OutputStream r11 = r12.getOutputStream()     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0123 }
            byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x0123 }
            r11.write(r4)     // Catch:{ all -> 0x0123 }
            r11.write(r10)     // Catch:{ all -> 0x0123 }
            byte[] r10 = r5.getBytes()     // Catch:{ all -> 0x0123 }
            r11.write(r10)     // Catch:{ all -> 0x0123 }
            int r10 = r12.getResponseCode()     // Catch:{ all -> 0x0123 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0123 }
            java.lang.String r5 = "Response code: "
            r4.<init>(r5)     // Catch:{ all -> 0x0123 }
            r4.append(r10)     // Catch:{ all -> 0x0123 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0123 }
            com.uc.crashsdk.a.a.a(r0, r4)     // Catch:{ all -> 0x0123 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r10 == r4) goto L_0x00cc
            com.uc.crashsdk.a.g.a((java.io.Closeable) r11)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r2)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r2)
            r12.disconnect()     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            return r1
        L_0x00cc:
            java.io.InputStream r10 = r12.getInputStream()     // Catch:{ all -> 0x0123 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0120 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0120 }
            int r6 = r10.available()     // Catch:{ all -> 0x0120 }
            r5.<init>(r6)     // Catch:{ all -> 0x0120 }
        L_0x00dd:
            int r2 = r10.read(r4)     // Catch:{ all -> 0x011e }
            r6 = -1
            if (r2 == r6) goto L_0x00e8
            r5.write(r4, r1, r2)     // Catch:{ all -> 0x011e }
            goto L_0x00dd
        L_0x00e8:
            byte[] r2 = r5.toByteArray()     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x0111
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x011e }
            java.lang.String r6 = "Log upload response: "
            r4.<init>(r6)     // Catch:{ all -> 0x011e }
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x011e }
            r6.<init>(r2)     // Catch:{ all -> 0x011e }
            r4.append(r6)     // Catch:{ all -> 0x011e }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x011e }
            com.uc.crashsdk.a.a.a(r0, r2)     // Catch:{ all -> 0x011e }
            com.uc.crashsdk.a.g.a((java.io.Closeable) r11)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r10)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r5)
            r12.disconnect()     // Catch:{ all -> 0x0110 }
        L_0x0110:
            return r3
        L_0x0111:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r11)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r10)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r5)
            r12.disconnect()     // Catch:{ all -> 0x011d }
        L_0x011d:
            return r1
        L_0x011e:
            r0 = move-exception
            goto L_0x0126
        L_0x0120:
            r0 = move-exception
            r5 = r2
            goto L_0x0126
        L_0x0123:
            r0 = move-exception
            r10 = r2
            r5 = r10
        L_0x0126:
            r2 = r11
            goto L_0x0130
        L_0x0128:
            r0 = move-exception
            r10 = r2
            r5 = r10
            goto L_0x0130
        L_0x012c:
            r0 = move-exception
            r10 = r2
            r12 = r10
            r5 = r12
        L_0x0130:
            com.uc.crashsdk.a.g.b((java.lang.Throwable) r0)     // Catch:{ all -> 0x0142 }
            com.uc.crashsdk.a.g.a((java.io.Closeable) r2)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r10)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r5)
            if (r12 == 0) goto L_0x0141
            r12.disconnect()     // Catch:{ all -> 0x0141 }
        L_0x0141:
            return r1
        L_0x0142:
            r11 = move-exception
            com.uc.crashsdk.a.g.a((java.io.Closeable) r2)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r10)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r5)
            if (r12 == 0) goto L_0x0151
            r12.disconnect()     // Catch:{ all -> 0x0151 }
        L_0x0151:
            goto L_0x0153
        L_0x0152:
            throw r11
        L_0x0153:
            goto L_0x0152
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.c.a(byte[], java.lang.String, java.lang.String):boolean");
    }
}
