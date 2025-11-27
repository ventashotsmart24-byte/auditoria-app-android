package com.umeng.message.proguard;

import android.os.SystemClock;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ct {

    /* renamed from: a  reason: collision with root package name */
    private static final ct f15683a = new ct();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, b> f15684b = new HashMap<>();

    public interface a {
        void a();

        void a(String str);
    }

    private ct() {
    }

    public static void a(final boolean z10, final String str, final a aVar) {
        ct ctVar = f15683a;
        if (str == null || str.length() == 0) {
            new IllegalArgumentException("url empty");
            aVar.a();
            return;
        }
        File a10 = ea.a(str);
        if (!a10.exists() || a10.length() <= 512) {
            cb.b(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r4 = this;
                        java.lang.Class<com.umeng.message.proguard.ct> r0 = com.umeng.message.proguard.ct.class
                        monitor-enter(r0)
                        com.umeng.message.proguard.ct r1 = com.umeng.message.proguard.ct.this     // Catch:{ all -> 0x0043 }
                        java.util.HashMap r1 = r1.f15684b     // Catch:{ all -> 0x0043 }
                        java.lang.String r2 = r8     // Catch:{ all -> 0x0043 }
                        java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0043 }
                        com.umeng.message.proguard.ct$b r1 = (com.umeng.message.proguard.ct.b) r1     // Catch:{ all -> 0x0043 }
                        if (r1 == 0) goto L_0x001a
                        com.umeng.message.proguard.ct$a r2 = r9     // Catch:{ all -> 0x0043 }
                        r1.a((com.umeng.message.proguard.ct.a) r2)     // Catch:{ all -> 0x0043 }
                        monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                        return
                    L_0x001a:
                        com.umeng.message.proguard.ct$b r1 = new com.umeng.message.proguard.ct$b     // Catch:{ all -> 0x0043 }
                        java.lang.String r2 = r8     // Catch:{ all -> 0x0043 }
                        com.umeng.message.proguard.ct$1$1 r3 = new com.umeng.message.proguard.ct$1$1     // Catch:{ all -> 0x0043 }
                        r3.<init>()     // Catch:{ all -> 0x0043 }
                        r1.<init>(r2, r3)     // Catch:{ all -> 0x0043 }
                        com.umeng.message.proguard.ct$a r2 = r9     // Catch:{ all -> 0x0043 }
                        r1.a((com.umeng.message.proguard.ct.a) r2)     // Catch:{ all -> 0x0043 }
                        com.umeng.message.proguard.ct r2 = com.umeng.message.proguard.ct.this     // Catch:{ all -> 0x0043 }
                        java.util.HashMap r2 = r2.f15684b     // Catch:{ all -> 0x0043 }
                        java.lang.String r3 = r8     // Catch:{ all -> 0x0043 }
                        r2.put(r3, r1)     // Catch:{ all -> 0x0043 }
                        boolean r2 = r7     // Catch:{ all -> 0x0043 }
                        if (r2 == 0) goto L_0x003e
                        r1.run()     // Catch:{ all -> 0x0043 }
                        goto L_0x0041
                    L_0x003e:
                        com.umeng.message.proguard.cb.a(r1)     // Catch:{ all -> 0x0043 }
                    L_0x0041:
                        monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                        return
                    L_0x0043:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ct.AnonymousClass1.run():void");
                }
            });
            return;
        }
        aVar.a(a10.getPath());
        cu.a(a10);
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f15690a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<a> f15691b;

        public b(String str, a aVar) {
            ArrayList<a> arrayList = new ArrayList<>();
            this.f15691b = arrayList;
            this.f15690a = str;
            arrayList.add(aVar);
        }

        public final void a(a aVar) {
            synchronized (ct.class) {
                this.f15691b.add(0, aVar);
            }
        }

        public final void run() {
            try {
                a(this.f15690a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            synchronized (ct.class) {
                this.f15691b.clear();
            }
        }

        private void a(String str) {
            HttpURLConnection httpURLConnection;
            byte[] bArr;
            int i10;
            String str2 = str;
            File a10 = ea.a(str);
            if (!a10.exists() || a10.length() <= 512) {
                String parent = a10.getParent();
                File file = new File(parent, a10.getName() + ".tmp");
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int i11 = 0;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(30000);
                        httpURLConnection2.setReadTimeout(30000);
                        InputStream inputStream = httpURLConnection2.getInputStream();
                        int contentLength = httpURLConnection2.getContentLength();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr2 = new byte[8192];
                        ce.a("VideoDownload", "video contentLength:".concat(String.valueOf(contentLength)));
                        long j10 = 0;
                        long j11 = 0;
                        while (true) {
                            int read = inputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr2, i11, read);
                            j10 += (long) read;
                            if (contentLength > 0) {
                                httpURLConnection = httpURLConnection2;
                                try {
                                    long j12 = (100 * j10) / ((long) contentLength);
                                    if (j11 != j12) {
                                        if (j12 % 50 == 0) {
                                            i10 = contentLength;
                                            bArr = bArr2;
                                            ce.a("VideoDownload", "video download progress:".concat(String.valueOf(j12)));
                                        } else {
                                            i10 = contentLength;
                                            bArr = bArr2;
                                        }
                                        j11 = j12;
                                    } else {
                                        i10 = contentLength;
                                        bArr = bArr2;
                                    }
                                    httpURLConnection2 = httpURLConnection;
                                    contentLength = i10;
                                    bArr2 = bArr;
                                    i11 = 0;
                                } catch (Throwable th) {
                                    th = th;
                                }
                            }
                        }
                        httpURLConnection = httpURLConnection2;
                        fileOutputStream.flush();
                        eb.a(fileOutputStream);
                        eb.a(inputStream);
                        a10.delete();
                        file.renameTo(a10);
                        cu.a(a10);
                        synchronized (ct.class) {
                            Iterator<a> it = this.f15691b.iterator();
                            while (it.hasNext()) {
                                it.next().a(a10.getPath());
                            }
                        }
                        httpURLConnection.disconnect();
                        ce.b("VideoDownload", "video download consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } catch (IOException e10) {
                    file.delete();
                    ce.d("VideoDownload", "video download error:", e10.getMessage());
                    ce.b("VideoDownload", "video download consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    synchronized (ct.class) {
                        Iterator<a> it2 = this.f15691b.iterator();
                        while (it2.hasNext()) {
                            new IOException("download video:" + str2 + " failed!");
                            it2.next().a();
                        }
                    }
                } catch (Throwable th3) {
                    ce.b("VideoDownload", "video download consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    throw th3;
                }
            } else {
                cu.a(a10);
                synchronized (ct.class) {
                    Iterator<a> it3 = this.f15691b.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(a10.getPath());
                    }
                }
            }
        }
    }
}
