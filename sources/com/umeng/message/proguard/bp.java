package com.umeng.message.proguard;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public final class bp {

    /* renamed from: a  reason: collision with root package name */
    private static File f15524a;

    public static File a(Context context) {
        return new File(context.getFilesDir(), "umeng_push_notify");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        r4 = null;
        r5 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e A[Catch:{ Exception -> 0x0068, all -> 0x0065 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084 A[Catch:{ Exception -> 0x0068, all -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089 A[SYNTHETIC, Splitter:B:41:0x0089] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(java.io.Serializable r8, java.io.File r9) {
        /*
            java.lang.Class<com.umeng.message.proguard.bp> r0 = com.umeng.message.proguard.bp.class
            monitor-enter(r0)
            r1 = 0
            r2 = 1
            if (r8 == 0) goto L_0x0091
            if (r9 != 0) goto L_0x000b
            goto L_0x0091
        L_0x000b:
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009e }
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.lang.String r5 = "u_push_"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.util.UUID r5 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.lang.String r6 = "-"
            java.lang.String r7 = ""
            java.lang.String r5 = r5.replace(r6, r7)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            r4.append(r5)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.io.File r5 = f15524a     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            if (r5 != 0) goto L_0x003b
            android.app.Application r5 = com.umeng.message.proguard.y.a()     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.io.File r5 = r5.getCacheDir()     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            f15524a = r5     // Catch:{ Exception -> 0x0077, all -> 0x006e }
        L_0x003b:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.io.File r6 = f15524a     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            r5.<init>(r6, r4)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            r5.createNewFile()     // Catch:{ Exception -> 0x006c, all -> 0x006e }
            r5.setReadable(r2)     // Catch:{ Exception -> 0x006c, all -> 0x006e }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x006c, all -> 0x006e }
            r4.<init>(r5)     // Catch:{ Exception -> 0x006c, all -> 0x006e }
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0079, all -> 0x006a }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0079, all -> 0x006a }
            r7.<init>(r4)     // Catch:{ Exception -> 0x0079, all -> 0x006a }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0079, all -> 0x006a }
            r6.writeObject(r8)     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            r6.flush()     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            com.umeng.message.proguard.f.a((java.io.Closeable) r6)     // Catch:{ all -> 0x009e }
            com.umeng.message.proguard.f.a((java.io.Closeable) r4)     // Catch:{ all -> 0x009e }
            r1 = 1
            goto L_0x007f
        L_0x0065:
            r8 = move-exception
            r3 = r6
            goto L_0x0070
        L_0x0068:
            r3 = r6
            goto L_0x0079
        L_0x006a:
            r8 = move-exception
            goto L_0x0070
        L_0x006c:
            r4 = r3
            goto L_0x0079
        L_0x006e:
            r8 = move-exception
            r4 = r3
        L_0x0070:
            com.umeng.message.proguard.f.a((java.io.Closeable) r3)     // Catch:{ all -> 0x009e }
            com.umeng.message.proguard.f.a((java.io.Closeable) r4)     // Catch:{ all -> 0x009e }
            throw r8     // Catch:{ all -> 0x009e }
        L_0x0077:
            r4 = r3
            r5 = r4
        L_0x0079:
            com.umeng.message.proguard.f.a((java.io.Closeable) r3)     // Catch:{ all -> 0x009e }
            com.umeng.message.proguard.f.a((java.io.Closeable) r4)     // Catch:{ all -> 0x009e }
        L_0x007f:
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0087
            r5.renameTo(r9)     // Catch:{ all -> 0x009e }
        L_0x0087:
            if (r5 == 0) goto L_0x008f
            r5.delete()     // Catch:{ Exception -> 0x008d }
            goto L_0x008f
        L_0x008d:
            monitor-exit(r0)
            return
        L_0x008f:
            monitor-exit(r0)
            return
        L_0x0091:
            java.lang.String r8 = "SerializeUtils"
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "parameter invalid"
            r9[r1] = r2     // Catch:{ all -> 0x009e }
            com.umeng.message.common.UPLog.e((java.lang.String) r8, (java.lang.Object[]) r9)     // Catch:{ all -> 0x009e }
            monitor-exit(r0)
            return
        L_0x009e:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.bp.a(java.io.Serializable, java.io.File):void");
    }

    public static synchronized <T> T a(File file) {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        synchronized (bp.class) {
            T t10 = null;
            try {
                if (!file.exists()) {
                    f.a((Closeable) null);
                    f.a((Closeable) null);
                    return null;
                }
                System.currentTimeMillis();
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                } catch (Throwable unused) {
                    objectInputStream = null;
                    f.a((Closeable) objectInputStream);
                    f.a((Closeable) fileInputStream);
                    return t10;
                }
                try {
                    t10 = objectInputStream.readObject();
                    f.a((Closeable) objectInputStream);
                } catch (Throwable unused2) {
                    f.a((Closeable) objectInputStream);
                    f.a((Closeable) fileInputStream);
                    return t10;
                }
                f.a((Closeable) fileInputStream);
                return t10;
            } catch (Throwable unused3) {
                objectInputStream = null;
                fileInputStream = null;
                f.a((Closeable) objectInputStream);
                f.a((Closeable) fileInputStream);
                return t10;
            }
        }
    }
}
