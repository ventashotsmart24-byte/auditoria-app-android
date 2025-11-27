package s7;

public abstract class d {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            r4.<init>()     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            r4.append(r7)     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            java.lang.String r7 = r4.toString()     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            java.lang.Process r7 = r3.exec(r7)     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            java.io.InputStream r3 = r7.getInputStream()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            java.lang.String r2 = r4.readLine()     // Catch:{ IOException -> 0x004c }
            if (r2 == 0) goto L_0x0041
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x004c }
            if (r3 != 0) goto L_0x0041
            r7.destroy()
            java.io.Closeable[] r7 = new java.io.Closeable[r1]
            r7[r0] = r4
            s7.a.a(r7)
            return r2
        L_0x0041:
            r7.destroy()
            java.io.Closeable[] r7 = new java.io.Closeable[r1]
            r7[r0] = r4
            s7.a.a(r7)
            return r8
        L_0x004c:
            r2 = move-exception
            goto L_0x005c
        L_0x004e:
            r8 = move-exception
            r4 = r2
            goto L_0x0084
        L_0x0051:
            r3 = move-exception
            r4 = r2
            r2 = r3
            goto L_0x005c
        L_0x0055:
            r8 = move-exception
            r4 = r2
            goto L_0x0085
        L_0x0058:
            r7 = move-exception
            r4 = r2
            r2 = r7
            r7 = r4
        L_0x005c:
            java.lang.String r3 = "PropUtil"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r5.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r6 = "Exception in getProp and exception info is "
            r5.append(r6)     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0083 }
            r5.append(r2)     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0083 }
            s7.b.c(r3, r2)     // Catch:{ all -> 0x0083 }
            if (r7 == 0) goto L_0x007b
            r7.destroy()
        L_0x007b:
            java.io.Closeable[] r7 = new java.io.Closeable[r1]
            r7[r0] = r4
            s7.a.a(r7)
            return r8
        L_0x0083:
            r8 = move-exception
        L_0x0084:
            r2 = r7
        L_0x0085:
            if (r2 == 0) goto L_0x008a
            r2.destroy()
        L_0x008a:
            java.io.Closeable[] r7 = new java.io.Closeable[r1]
            r7[r0] = r4
            s7.a.a(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.d.a(java.lang.String, java.lang.String):java.lang.String");
    }
}
