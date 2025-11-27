package com.hpplay.sdk.source.localserver;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.hpplay.a.a.a.b.a;
import com.hpplay.a.a.a.c.b;
import com.hpplay.a.a.a.c.c;
import com.hpplay.a.a.a.d;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.logwriter.f;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.LogCache;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.UriUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class LelinkFileServer extends d {
    private static final String TAG = "LelinkFileServer";

    public LelinkFileServer(String str, int i10) {
        super(str, i10);
    }

    private c defaultRespond(Map<String, String> map, com.hpplay.a.a.a.c cVar, String str) {
        String replace = str.trim().replace(File.separatorChar, '/');
        if (replace.indexOf(63) >= 0) {
            replace = replace.substring(0, replace.indexOf(63));
        }
        String mimeTypeForFile = d.getMimeTypeForFile(replace);
        SourceLog.i(TAG, " uri path  " + replace);
        if (!TextUtils.isEmpty(replace) && replace.startsWith("/content")) {
            String substring = replace.substring(1, replace.length());
            Uri parse = Uri.parse(substring);
            if (Build.VERSION.SDK_INT > 28) {
                try {
                    InputStream openInputStream = HapplayUtils.getApplication().getContentResolver().openInputStream(parse);
                    SourceLog.i(TAG, " uri mode send stream " + substring);
                    if (parse.toString().contains("image")) {
                        mimeTypeForFile = "image/jpeg";
                    } else if (parse.toString().endsWith("mp4")) {
                        mimeTypeForFile = "video/mp4";
                    }
                    c serveFileForStream = serveFileForStream(parse, map, openInputStream, mimeTypeForFile);
                    if (serveFileForStream != null) {
                        return serveFileForStream;
                    }
                    return getNotFoundResponse();
                } catch (Exception e10) {
                    SourceLog.w(TAG, (Throwable) e10);
                    return getNotFoundResponse();
                }
            } else {
                replace = UriUtils.getFilePathByUri(HapplayUtils.getApplication(), parse);
            }
        } else if (!TextUtils.isEmpty(replace) && (replace.contains("slog") || replace.contains("scacheLog"))) {
            SourceLog.flushLogWriter();
            replace = LogCache.getLogOutputFilePath();
            if (TextUtils.isEmpty(replace)) {
                SourceLog.i(TAG, "logRespond,log zipFilePath is null ");
                return c.a((b) com.hpplay.a.a.a.c.d.NOT_FOUND, d.MIME_PLAINTEXT, "Error 404, log file not found.");
            }
            f.a().c(replace);
        }
        if (!new File(replace).exists()) {
            return getNotFoundResponse();
        }
        c serveFile = serveFile(replace, map, new File(replace), mimeTypeForFile);
        if (serveFile != null) {
            return serveFile;
        }
        return getNotFoundResponse();
    }

    private c newFixedFileResponse(File file, String str) {
        c a10 = c.a(com.hpplay.a.a.a.c.d.OK, str, new FileInputStream(file), (long) ((int) file.length()));
        a10.a(HttpHeaders.ACCEPT_RANGES, HTTP.CONTENT_RANGE_BYTES);
        return a10;
    }

    public static c newFixedLengthResponse(b bVar, String str, String str2) {
        c a10 = c.a(bVar, str, str2);
        a10.a(HttpHeaders.ACCEPT_RANGES, HTTP.CONTENT_RANGE_BYTES);
        return a10;
    }

    private c respond(Map<String, String> map, com.hpplay.a.a.a.c cVar, String str) {
        if (a.f10458f.equals(cVar.e())) {
            return c.a(com.hpplay.a.a.a.c.d.OK, d.MIME_PLAINTEXT, (InputStream) null, 0);
        }
        return defaultRespond(map, cVar, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        if ("".equals(r11) != false) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058 A[SYNTHETIC, Splitter:B:24:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f5 A[ADDED_TO_REGION, Catch:{ Exception -> 0x0141 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.hpplay.a.a.a.c.c serveFileForStream(android.net.Uri r24, java.util.Map<java.lang.String, java.lang.String> r25, java.io.InputStream r26, java.lang.String r27) {
        /*
            r23 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            java.lang.String r4 = "LelinkFileServer"
            java.lang.String r0 = "range"
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0145 }
            r5 = 0
            r6 = 1
            r9 = -1
            if (r0 == 0) goto L_0x004a
            java.lang.String r11 = "bytes="
            boolean r11 = r0.startsWith(r11)     // Catch:{ Exception -> 0x0145 }
            if (r11 == 0) goto L_0x004a
            r11 = 6
            java.lang.String r11 = r0.substring(r11)     // Catch:{ Exception -> 0x0145 }
            r0 = 45
            int r0 = r11.indexOf(r0)     // Catch:{ Exception -> 0x0145 }
            if (r0 <= 0) goto L_0x0046
            java.lang.String r12 = r11.substring(r5, r0)     // Catch:{ Exception -> 0x003f }
            long r12 = java.lang.Long.parseLong(r12)     // Catch:{ Exception -> 0x003f }
            int r0 = r0 + r6
            java.lang.String r0 = r11.substring(r0)     // Catch:{ Exception -> 0x003d }
            long r9 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x003d }
            goto L_0x0048
        L_0x003d:
            r0 = move-exception
            goto L_0x0042
        L_0x003f:
            r0 = move-exception
            r12 = 0
        L_0x0042:
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ Exception -> 0x0145 }
            goto L_0x0048
        L_0x0046:
            r12 = 0
        L_0x0048:
            r0 = r11
            goto L_0x004c
        L_0x004a:
            r12 = 0
        L_0x004c:
            java.lang.String r11 = "if-range"
            java.lang.Object r11 = r1.get(r11)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0145 }
            java.lang.String r14 = ""
            if (r11 == 0) goto L_0x005e
            boolean r11 = r14.equals(r11)     // Catch:{ Exception -> 0x0145 }
            if (r11 == 0) goto L_0x005f
        L_0x005e:
            r5 = 1
        L_0x005f:
            java.lang.String r6 = "if-none-match"
            java.lang.Object r1 = r1.get(r6)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0145 }
            if (r1 == 0) goto L_0x0075
            java.lang.String r6 = "*"
            boolean r6 = r6.equals(r1)     // Catch:{ Exception -> 0x0145 }
            if (r6 != 0) goto L_0x0075
            boolean r1 = r1.equals(r14)     // Catch:{ Exception -> 0x0145 }
        L_0x0075:
            int r1 = r26.available()     // Catch:{ Exception -> 0x0145 }
            long r7 = (long) r1
            java.lang.String r1 = "Content-Length"
            java.lang.String r6 = "Content-Range"
            java.lang.String r11 = "bytes"
            java.lang.String r15 = "Accept-Ranges"
            r16 = r4
            java.lang.String r4 = "ETag"
            if (r5 == 0) goto L_0x00f3
            if (r0 == 0) goto L_0x00f3
            r17 = 0
            int r19 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r19 < 0) goto L_0x00f3
            int r19 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r19 >= 0) goto L_0x00f3
            r19 = 1
            int r0 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r0 >= 0) goto L_0x009c
            long r9 = r7 - r19
        L_0x009c:
            long r21 = r9 - r12
            long r21 = r21 + r19
            int r0 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            r24 = r4
            if (r0 >= 0) goto L_0x00a9
            r4 = r17
            goto L_0x00ab
        L_0x00a9:
            r4 = r21
        L_0x00ab:
            r2.skip(r12)     // Catch:{ Exception -> 0x0141 }
            com.hpplay.a.a.a.c.d r0 = com.hpplay.a.a.a.c.d.PARTIAL_CONTENT     // Catch:{ Exception -> 0x0141 }
            com.hpplay.a.a.a.c.c r0 = com.hpplay.a.a.a.c.c.a(r0, r3, r2, r4)     // Catch:{ Exception -> 0x0141 }
            r0.a((java.lang.String) r15, (java.lang.String) r11)     // Catch:{ Exception -> 0x0141 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0141 }
            r2.<init>()     // Catch:{ Exception -> 0x0141 }
            r2.append(r14)     // Catch:{ Exception -> 0x0141 }
            r2.append(r4)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0141 }
            r0.a((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0141 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0141 }
            r1.<init>()     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = "bytes "
            r1.append(r2)     // Catch:{ Exception -> 0x0141 }
            r1.append(r12)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = "-"
            r1.append(r2)     // Catch:{ Exception -> 0x0141 }
            r1.append(r9)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch:{ Exception -> 0x0141 }
            r1.append(r7)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0141 }
            r0.a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x0141 }
            r4 = r24
            r0.a((java.lang.String) r4, (java.lang.String) r14)     // Catch:{ Exception -> 0x0141 }
            goto L_0x013e
        L_0x00f3:
            if (r5 == 0) goto L_0x011b
            if (r0 == 0) goto L_0x011b
            int r9 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x011b
            com.hpplay.a.a.a.c.d r0 = com.hpplay.a.a.a.c.d.RANGE_NOT_SATISFIABLE     // Catch:{ Exception -> 0x0141 }
            java.lang.String r1 = "text/plain"
            com.hpplay.a.a.a.c.c r0 = newFixedLengthResponse(r0, r1, r14)     // Catch:{ Exception -> 0x0141 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0141 }
            r1.<init>()     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = "bytes */"
            r1.append(r2)     // Catch:{ Exception -> 0x0141 }
            r1.append(r7)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0141 }
            r0.a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x0141 }
            r0.a((java.lang.String) r4, (java.lang.String) r14)     // Catch:{ Exception -> 0x0141 }
            goto L_0x013e
        L_0x011b:
            com.hpplay.a.a.a.c.d r0 = com.hpplay.a.a.a.c.d.OK     // Catch:{ Exception -> 0x0141 }
            int r5 = r26.available()     // Catch:{ Exception -> 0x0141 }
            long r5 = (long) r5     // Catch:{ Exception -> 0x0141 }
            com.hpplay.a.a.a.c.c r0 = com.hpplay.a.a.a.c.c.a(r0, r3, r2, r5)     // Catch:{ Exception -> 0x0141 }
            r0.a((java.lang.String) r15, (java.lang.String) r11)     // Catch:{ Exception -> 0x0141 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0141 }
            r2.<init>()     // Catch:{ Exception -> 0x0141 }
            r2.append(r14)     // Catch:{ Exception -> 0x0141 }
            r2.append(r7)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0141 }
            r0.a((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0141 }
            r0.a((java.lang.String) r4, (java.lang.String) r14)     // Catch:{ Exception -> 0x0141 }
        L_0x013e:
            r1 = r23
            goto L_0x0152
        L_0x0141:
            r0 = move-exception
            r1 = r16
            goto L_0x0147
        L_0x0145:
            r0 = move-exception
            r1 = r4
        L_0x0147:
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r1, (java.lang.Throwable) r0)
            java.lang.String r0 = "Reading file failed."
            r1 = r23
            com.hpplay.a.a.a.c.c r0 = r1.getForbiddenResponse(r0)
        L_0x0152:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.localserver.LelinkFileServer.serveFileForStream(android.net.Uri, java.util.Map, java.io.InputStream, java.lang.String):com.hpplay.a.a.a.c.c");
    }

    public c getForbiddenResponse(String str) {
        com.hpplay.a.a.a.c.d dVar = com.hpplay.a.a.a.c.d.FORBIDDEN;
        return c.a((b) dVar, d.MIME_PLAINTEXT, "FORBIDDEN: " + str);
    }

    public c getInternalErrorResponse(String str) {
        com.hpplay.a.a.a.c.d dVar = com.hpplay.a.a.a.c.d.INTERNAL_ERROR;
        return c.a((b) dVar, d.MIME_PLAINTEXT, "INTERNAL ERROR: " + str);
    }

    public c getNotFoundResponse() {
        return c.a((b) com.hpplay.a.a.a.c.d.NOT_FOUND, d.MIME_PLAINTEXT, "Error 404, file not found.");
    }

    public c serve(com.hpplay.a.a.a.c cVar) {
        Map<String, String> c10 = cVar.c();
        cVar.f();
        String i10 = cVar.i();
        SourceLog.i(TAG, i10);
        return respond(Collections.unmodifiableMap(c10), cVar, i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0049, code lost:
        r6 = r6.substring(6);
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096 A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098 A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0126 A[ADDED_TO_REGION, Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0150 A[ADDED_TO_REGION, Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0164 A[ADDED_TO_REGION, Catch:{ Exception -> 0x015e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hpplay.a.a.a.c.c serveFile(java.lang.String r21, java.util.Map<java.lang.String, java.lang.String> r22, java.io.File r23, java.lang.String r24) {
        /*
            r20 = this;
            r1 = r20
            r0 = r22
            r2 = r23
            r3 = r24
            java.lang.String r4 = ""
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
            r5.<init>()     // Catch:{ Exception -> 0x018e }
            java.lang.String r6 = r23.getAbsolutePath()     // Catch:{ Exception -> 0x018e }
            r5.append(r6)     // Catch:{ Exception -> 0x018e }
            long r6 = r23.lastModified()     // Catch:{ Exception -> 0x018e }
            r5.append(r6)     // Catch:{ Exception -> 0x018e }
            r5.append(r4)     // Catch:{ Exception -> 0x018e }
            long r6 = r23.length()     // Catch:{ Exception -> 0x018e }
            r5.append(r6)     // Catch:{ Exception -> 0x018e }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x018e }
            int r5 = r5.hashCode()     // Catch:{ Exception -> 0x018e }
            java.lang.String r5 = java.lang.Integer.toHexString(r5)     // Catch:{ Exception -> 0x018e }
            java.lang.String r6 = "range"
            java.lang.Object r6 = r0.get(r6)     // Catch:{ Exception -> 0x018e }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x018e }
            r7 = 0
            r8 = 1
            r11 = -1
            if (r6 == 0) goto L_0x0068
            java.lang.String r13 = "bytes="
            boolean r13 = r6.startsWith(r13)     // Catch:{ Exception -> 0x018e }
            if (r13 == 0) goto L_0x0068
            r13 = 6
            java.lang.String r6 = r6.substring(r13)     // Catch:{ Exception -> 0x018e }
            r13 = 45
            int r13 = r6.indexOf(r13)     // Catch:{ Exception -> 0x018e }
            if (r13 <= 0) goto L_0x0068
            java.lang.String r14 = r6.substring(r7, r13)     // Catch:{ Exception -> 0x0068 }
            long r14 = java.lang.Long.parseLong(r14)     // Catch:{ Exception -> 0x0068 }
            int r13 = r13 + r8
            java.lang.String r13 = r6.substring(r13)     // Catch:{ Exception -> 0x006a }
            long r11 = java.lang.Long.parseLong(r13)     // Catch:{ Exception -> 0x006a }
            goto L_0x006a
        L_0x0068:
            r14 = 0
        L_0x006a:
            java.lang.String r13 = "if-range"
            java.lang.Object r13 = r0.get(r13)     // Catch:{ Exception -> 0x018e }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x018e }
            if (r13 == 0) goto L_0x007d
            boolean r13 = r5.equals(r13)     // Catch:{ Exception -> 0x018e }
            if (r13 == 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r13 = 0
            goto L_0x007e
        L_0x007d:
            r13 = 1
        L_0x007e:
            java.lang.String r7 = "if-none-match"
            java.lang.Object r0 = r0.get(r7)     // Catch:{ Exception -> 0x018e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x018e }
            if (r0 == 0) goto L_0x0098
            java.lang.String r7 = "*"
            boolean r7 = r7.equals(r0)     // Catch:{ Exception -> 0x018e }
            if (r7 != 0) goto L_0x0096
            boolean r0 = r0.equals(r5)     // Catch:{ Exception -> 0x018e }
            if (r0 == 0) goto L_0x0098
        L_0x0096:
            r7 = 1
            goto L_0x0099
        L_0x0098:
            r7 = 0
        L_0x0099:
            long r9 = r23.length()     // Catch:{ Exception -> 0x018e }
            java.lang.String r0 = "Content-Range"
            java.lang.String r8 = "Content-Length"
            java.lang.String r1 = "ETag"
            if (r13 == 0) goto L_0x0124
            if (r6 == 0) goto L_0x0124
            r16 = 0
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 < 0) goto L_0x0124
            int r18 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r18 >= 0) goto L_0x0124
            if (r7 == 0) goto L_0x00be
            com.hpplay.a.a.a.c.d r0 = com.hpplay.a.a.a.c.d.NOT_MODIFIED     // Catch:{ Exception -> 0x015e }
            com.hpplay.a.a.a.c.c r0 = newFixedLengthResponse(r0, r3, r4)     // Catch:{ Exception -> 0x015e }
            r0.a((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x015e }
            goto L_0x015b
        L_0x00be:
            r6 = 1
            r16 = 0
            int r13 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r13 >= 0) goto L_0x00c8
            long r11 = r9 - r6
        L_0x00c8:
            long r18 = r11 - r14
            long r18 = r18 + r6
            int r6 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r6 >= 0) goto L_0x00d3
            r6 = r16
            goto L_0x00d5
        L_0x00d3:
            r6 = r18
        L_0x00d5:
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ Exception -> 0x015e }
            r13.<init>(r2)     // Catch:{ Exception -> 0x015e }
            r13.skip(r14)     // Catch:{ Exception -> 0x015e }
            com.hpplay.a.a.a.c.d r2 = com.hpplay.a.a.a.c.d.PARTIAL_CONTENT     // Catch:{ Exception -> 0x015e }
            com.hpplay.a.a.a.c.c r2 = com.hpplay.a.a.a.c.c.a(r2, r3, r13, r6)     // Catch:{ Exception -> 0x015e }
            java.lang.String r3 = "Accept-Ranges"
            java.lang.String r13 = "bytes"
            r2.a((java.lang.String) r3, (java.lang.String) r13)     // Catch:{ Exception -> 0x015e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015e }
            r3.<init>()     // Catch:{ Exception -> 0x015e }
            r3.append(r4)     // Catch:{ Exception -> 0x015e }
            r3.append(r6)     // Catch:{ Exception -> 0x015e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x015e }
            r2.a((java.lang.String) r8, (java.lang.String) r3)     // Catch:{ Exception -> 0x015e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015e }
            r3.<init>()     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "bytes "
            r3.append(r4)     // Catch:{ Exception -> 0x015e }
            r3.append(r14)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "-"
            r3.append(r4)     // Catch:{ Exception -> 0x015e }
            r3.append(r11)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ Exception -> 0x015e }
            r3.append(r9)     // Catch:{ Exception -> 0x015e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x015e }
            r2.a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x015e }
            r2.a((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x015e }
            goto L_0x014b
        L_0x0124:
            if (r13 == 0) goto L_0x014e
            if (r6 == 0) goto L_0x014e
            int r11 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x014e
            com.hpplay.a.a.a.c.d r2 = com.hpplay.a.a.a.c.d.RANGE_NOT_SATISFIABLE     // Catch:{ Exception -> 0x015e }
            java.lang.String r3 = "text/plain"
            com.hpplay.a.a.a.c.c r2 = newFixedLengthResponse(r2, r3, r4)     // Catch:{ Exception -> 0x015e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015e }
            r3.<init>()     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "bytes */"
            r3.append(r4)     // Catch:{ Exception -> 0x015e }
            r3.append(r9)     // Catch:{ Exception -> 0x015e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x015e }
            r2.a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x015e }
            r2.a((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x015e }
        L_0x014b:
            r1 = r20
            goto L_0x018c
        L_0x014e:
            if (r6 != 0) goto L_0x0162
            if (r7 == 0) goto L_0x0162
            com.hpplay.a.a.a.c.d r0 = com.hpplay.a.a.a.c.d.NOT_MODIFIED     // Catch:{ Exception -> 0x015e }
            com.hpplay.a.a.a.c.c r0 = newFixedLengthResponse(r0, r3, r4)     // Catch:{ Exception -> 0x015e }
            r0.a((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x015e }
        L_0x015b:
            r1 = r20
            goto L_0x019a
        L_0x015e:
            r0 = move-exception
            r1 = r20
            goto L_0x018f
        L_0x0162:
            if (r13 != 0) goto L_0x0170
            if (r7 == 0) goto L_0x0170
            com.hpplay.a.a.a.c.d r0 = com.hpplay.a.a.a.c.d.NOT_MODIFIED     // Catch:{ Exception -> 0x015e }
            com.hpplay.a.a.a.c.c r0 = newFixedLengthResponse(r0, r3, r4)     // Catch:{ Exception -> 0x015e }
            r0.a((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x015e }
            goto L_0x015b
        L_0x0170:
            r0 = r1
            r1 = r20
            com.hpplay.a.a.a.c.c r2 = r1.newFixedFileResponse(r2, r3)     // Catch:{ Exception -> 0x018e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
            r3.<init>()     // Catch:{ Exception -> 0x018e }
            r3.append(r4)     // Catch:{ Exception -> 0x018e }
            r3.append(r9)     // Catch:{ Exception -> 0x018e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x018e }
            r2.a((java.lang.String) r8, (java.lang.String) r3)     // Catch:{ Exception -> 0x018e }
            r2.a((java.lang.String) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x018e }
        L_0x018c:
            r0 = r2
            goto L_0x019a
        L_0x018e:
            r0 = move-exception
        L_0x018f:
            java.lang.String r2 = "LelinkFileServer"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r2, (java.lang.Throwable) r0)
            java.lang.String r0 = "Reading file failed."
            com.hpplay.a.a.a.c.c r0 = r1.getForbiddenResponse(r0)
        L_0x019a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.localserver.LelinkFileServer.serveFile(java.lang.String, java.util.Map, java.io.File, java.lang.String):com.hpplay.a.a.a.c.c");
    }
}
