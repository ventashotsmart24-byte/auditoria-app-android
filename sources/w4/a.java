package w4;

import android.os.Process;
import android.text.TextUtils;
import java.io.InputStream;
import y4.b;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final b f19682a;

    /* renamed from: b  reason: collision with root package name */
    public final u4.a f19683b;

    /* renamed from: c  reason: collision with root package name */
    public final t4.a f19684c;

    /* renamed from: d  reason: collision with root package name */
    public final y4.a f19685d;

    /* renamed from: e  reason: collision with root package name */
    public final C0288a f19686e;

    /* renamed from: f  reason: collision with root package name */
    public long f19687f;

    /* renamed from: g  reason: collision with root package name */
    public InputStream f19688g;

    /* renamed from: w4.a$a  reason: collision with other inner class name */
    public interface C0288a {
        void b();

        void c();
    }

    public a(b bVar, u4.a aVar, t4.a aVar2, y4.a aVar3, C0288a aVar4) {
        long j10;
        this.f19682a = bVar;
        this.f19683b = aVar;
        this.f19684c = aVar2;
        this.f19685d = aVar3;
        if (aVar3.q()) {
            j10 = bVar.e();
        } else {
            j10 = 0;
        }
        this.f19687f = j10;
        this.f19686e = aVar4;
    }

    public final void a() {
        if (this.f19685d.p()) {
            throw new z4.b(7);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r11v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f6 A[SYNTHETIC, Splitter:B:57:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0102  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 0
            java.net.HttpURLConnection r11 = r10.d(r11)     // Catch:{ ProtocolException -> 0x00e7, IOException -> 0x00dc, b -> 0x00d9, a -> 0x00d6, Exception -> 0x00ca, all -> 0x00c7 }
            y4.b r1 = r10.f19682a     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            long r1 = r1.f()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            y4.a r3 = r10.f19685d     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            boolean r3 = r3.q()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            if (r3 == 0) goto L_0x0040
            y4.b r1 = r10.f19682a     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            long r1 = r1.f()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            long r3 = r10.f19687f     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            long r1 = r1 + r3
            java.lang.String r3 = "Range"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r4.<init>()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.lang.String r5 = "bytes="
            r4.append(r5)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r4.append(r1)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.lang.String r5 = "-"
            r4.append(r5)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            y4.b r5 = r10.f19682a     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            long r5 = r5.c()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r4.append(r5)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.lang.String r4 = r4.toString()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r11.setRequestProperty(r3, r4)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
        L_0x0040:
            int r3 = r11.getResponseCode()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r4 = 206(0xce, float:2.89E-43)
            if (r3 == r4) goto L_0x0066
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x004d
            goto L_0x0066
        L_0x004d:
            z4.a r1 = new z4.a     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r2.<init>()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.lang.String r4 = "UnSupported response code:"
            r2.append(r4)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r2.append(r3)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.lang.String r2 = r2.toString()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r4 = 8
            r1.<init>((int) r4, (int) r3, (java.lang.String) r2)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            throw r1     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
        L_0x0066:
            java.io.InputStream r3 = r11.getInputStream()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r10.f19688g = r3     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            y4.a r4 = r10.f19685d     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.lang.String r4 = r4.h()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.lang.String r5 = "rwd"
            r3.<init>(r4, r5)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r3.seek(r1)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r2 = 0
            r4 = 0
        L_0x0082:
            r10.a()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.io.InputStream r5 = r10.f19688g     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            int r5 = r5.read(r1)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r6 = -1
            if (r5 != r6) goto L_0x00a8
            w4.a$a r1 = r10.f19686e     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r1.b()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r10.a()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            java.io.InputStream r1 = r10.f19688g
            if (r1 == 0) goto L_0x00a4
            r1.close()     // Catch:{ IOException -> 0x00a0 }
            r10.f19688g = r0     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00a4
        L_0x00a0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a4:
            r11.disconnect()
            return
        L_0x00a8:
            r3.write(r1, r2, r5)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            int r4 = r4 + r5
            y4.b r5 = r10.f19682a     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            long r6 = r10.f19687f     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            long r8 = (long) r4     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            long r6 = r6 + r8
            r5.l(r6)     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            w4.a$a r5 = r10.f19686e     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            r5.c()     // Catch:{ ProtocolException -> 0x00c5, IOException -> 0x00c3, b -> 0x00c1, a -> 0x00bf, Exception -> 0x00bd }
            goto L_0x0082
        L_0x00bb:
            r1 = move-exception
            goto L_0x00f2
        L_0x00bd:
            r1 = move-exception
            goto L_0x00cc
        L_0x00bf:
            r1 = move-exception
            goto L_0x00d8
        L_0x00c1:
            r1 = move-exception
            goto L_0x00db
        L_0x00c3:
            r1 = move-exception
            goto L_0x00de
        L_0x00c5:
            r1 = move-exception
            goto L_0x00e9
        L_0x00c7:
            r1 = move-exception
            r11 = r0
            goto L_0x00f2
        L_0x00ca:
            r1 = move-exception
            r11 = r0
        L_0x00cc:
            z4.a r2 = new z4.a     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "Unknown error"
            r4 = 9
            r2.<init>((int) r4, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x00bb }
            throw r2     // Catch:{ all -> 0x00bb }
        L_0x00d6:
            r1 = move-exception
            r11 = r0
        L_0x00d8:
            throw r1     // Catch:{ all -> 0x00bb }
        L_0x00d9:
            r1 = move-exception
            r11 = r0
        L_0x00db:
            throw r1     // Catch:{ all -> 0x00bb }
        L_0x00dc:
            r1 = move-exception
            r11 = r0
        L_0x00de:
            z4.a r2 = new z4.a     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "IO error"
            r4 = 5
            r2.<init>((int) r4, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x00bb }
            throw r2     // Catch:{ all -> 0x00bb }
        L_0x00e7:
            r1 = move-exception
            r11 = r0
        L_0x00e9:
            z4.a r2 = new z4.a     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "Protocol error"
            r4 = 4
            r2.<init>((int) r4, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x00bb }
            throw r2     // Catch:{ all -> 0x00bb }
        L_0x00f2:
            java.io.InputStream r2 = r10.f19688g
            if (r2 == 0) goto L_0x0100
            r2.close()     // Catch:{ IOException -> 0x00fc }
            r10.f19688g = r0     // Catch:{ IOException -> 0x00fc }
            goto L_0x0100
        L_0x00fc:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0100:
            if (r11 == 0) goto L_0x0105
            r11.disconnect()
        L_0x0105:
            goto L_0x0107
        L_0x0106:
            throw r1
        L_0x0107:
            goto L_0x0106
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.a.b(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00df A[SYNTHETIC, Splitter:B:44:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            java.net.HttpURLConnection r11 = r10.d(r11)     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            y4.b r1 = r10.f19682a     // Catch:{ Exception -> 0x00ba }
            long r1 = r1.f()     // Catch:{ Exception -> 0x00ba }
            y4.a r3 = r10.f19685d     // Catch:{ Exception -> 0x00ba }
            boolean r3 = r3.q()     // Catch:{ Exception -> 0x00ba }
            if (r3 == 0) goto L_0x0040
            y4.b r1 = r10.f19682a     // Catch:{ Exception -> 0x00ba }
            long r1 = r1.f()     // Catch:{ Exception -> 0x00ba }
            long r3 = r10.f19687f     // Catch:{ Exception -> 0x00ba }
            long r1 = r1 + r3
            java.lang.String r3 = "Range"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r4.<init>()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = "bytes="
            r4.append(r5)     // Catch:{ Exception -> 0x00ba }
            r4.append(r1)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = "-"
            r4.append(r5)     // Catch:{ Exception -> 0x00ba }
            y4.b r5 = r10.f19682a     // Catch:{ Exception -> 0x00ba }
            long r5 = r5.c()     // Catch:{ Exception -> 0x00ba }
            r4.append(r5)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00ba }
            r11.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x00ba }
        L_0x0040:
            int r3 = r11.getResponseCode()     // Catch:{ Exception -> 0x00ba }
            r4 = 206(0xce, float:2.89E-43)
            if (r3 == r4) goto L_0x0066
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x004d
            goto L_0x0066
        L_0x004d:
            z4.a r1 = new z4.a     // Catch:{ Exception -> 0x00ba }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r2.<init>()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r4 = "UnSupported response code:"
            r2.append(r4)     // Catch:{ Exception -> 0x00ba }
            r2.append(r3)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ba }
            r4 = 8
            r1.<init>((int) r4, (int) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x00ba }
            throw r1     // Catch:{ Exception -> 0x00ba }
        L_0x0066:
            java.io.InputStream r3 = r11.getInputStream()     // Catch:{ Exception -> 0x00ba }
            r10.f19688g = r3     // Catch:{ Exception -> 0x00ba }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00ba }
            y4.a r4 = r10.f19685d     // Catch:{ Exception -> 0x00ba }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = "rwd"
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x00ba }
            r3.seek(r1)     // Catch:{ Exception -> 0x00ba }
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x00ba }
            r2 = 0
            r4 = 0
        L_0x0082:
            r10.a()     // Catch:{ Exception -> 0x00ba }
            java.io.InputStream r5 = r10.f19688g     // Catch:{ Exception -> 0x00ba }
            int r5 = r5.read(r1)     // Catch:{ Exception -> 0x00ba }
            r6 = -1
            if (r5 != r6) goto L_0x00a5
            w4.a$a r1 = r10.f19686e     // Catch:{ Exception -> 0x00ba }
            r1.b()     // Catch:{ Exception -> 0x00ba }
            r10.a()     // Catch:{ Exception -> 0x00ba }
            java.io.InputStream r12 = r10.f19688g
            if (r12 == 0) goto L_0x00d7
            r12.close()     // Catch:{ IOException -> 0x00a0 }
            r10.f19688g = r0     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00d7
        L_0x00a0:
            r12 = move-exception
            r12.printStackTrace()
            goto L_0x00d7
        L_0x00a5:
            r3.write(r1, r2, r5)     // Catch:{ Exception -> 0x00ba }
            int r4 = r4 + r5
            y4.b r5 = r10.f19682a     // Catch:{ Exception -> 0x00ba }
            long r6 = r10.f19687f     // Catch:{ Exception -> 0x00ba }
            long r8 = (long) r4     // Catch:{ Exception -> 0x00ba }
            long r6 = r6 + r8
            r5.l(r6)     // Catch:{ Exception -> 0x00ba }
            w4.a$a r5 = r10.f19686e     // Catch:{ Exception -> 0x00ba }
            r5.c()     // Catch:{ Exception -> 0x00ba }
            goto L_0x0082
        L_0x00b8:
            r12 = move-exception
            goto L_0x00db
        L_0x00ba:
            r1 = move-exception
            goto L_0x00c1
        L_0x00bc:
            r12 = move-exception
            r11 = r0
            goto L_0x00db
        L_0x00bf:
            r1 = move-exception
            r11 = r0
        L_0x00c1:
            r1.printStackTrace()     // Catch:{ all -> 0x00b8 }
            r10.b(r12)     // Catch:{ all -> 0x00b8 }
            java.io.InputStream r12 = r10.f19688g
            if (r12 == 0) goto L_0x00d5
            r12.close()     // Catch:{ IOException -> 0x00d1 }
            r10.f19688g = r0     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00d5
        L_0x00d1:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00d5:
            if (r11 == 0) goto L_0x00da
        L_0x00d7:
            r11.disconnect()
        L_0x00da:
            return
        L_0x00db:
            java.io.InputStream r1 = r10.f19688g
            if (r1 == 0) goto L_0x00e9
            r1.close()     // Catch:{ IOException -> 0x00e5 }
            r10.f19688g = r0     // Catch:{ IOException -> 0x00e5 }
            goto L_0x00e9
        L_0x00e5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e9:
            if (r11 == 0) goto L_0x00ee
            r11.disconnect()
        L_0x00ee:
            goto L_0x00f0
        L_0x00ef:
            throw r12
        L_0x00f0:
            goto L_0x00ef
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.a.c(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.HttpURLConnection d(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0074, all -> 0x006a }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0074, all -> 0x006a }
            java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Exception -> 0x0074, all -> 0x006a }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x0074, all -> 0x006a }
            t4.a r0 = r6.f19684c     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            int r0 = r0.a()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r7.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            t4.a r0 = r6.f19684c     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            int r0 = r0.h()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r7.setReadTimeout(r0)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            t4.a r0 = r6.f19684c     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r0 = r0.g()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r7.setRequestMethod(r0)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            y4.b r0 = r6.f19682a     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r0.f()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            y4.a r0 = r6.f19685d     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            boolean r0 = r0.q()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            if (r0 == 0) goto L_0x0061
            y4.b r0 = r6.f19682a     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            long r0 = r0.f()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            long r2 = r6.f19687f     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            long r0 = r0 + r2
            java.lang.String r2 = "Range"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r3.<init>()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r4 = "bytes="
            r3.append(r4)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r3.append(r0)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r0 = "-"
            r3.append(r0)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            y4.b r0 = r6.f19682a     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            long r0 = r0.c()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r3.append(r0)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r7.setRequestProperty(r2, r0)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
        L_0x0061:
            r7.disconnect()
            return r7
        L_0x0065:
            r0 = move-exception
            goto L_0x006e
        L_0x0067:
            r0 = r7
            goto L_0x0075
        L_0x006a:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x006e:
            if (r7 == 0) goto L_0x0073
            r7.disconnect()
        L_0x0073:
            throw r0
        L_0x0074:
        L_0x0075:
            if (r0 == 0) goto L_0x007a
            r0.disconnect()
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.a.d(java.lang.String):java.net.HttpURLConnection");
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            a();
            if ((this.f19682a.f() + this.f19687f) - 1 == this.f19682a.c()) {
                this.f19686e.b();
            } else if (TextUtils.isEmpty(this.f19682a.a())) {
                b(this.f19682a.h());
            } else {
                c(this.f19682a.h(), this.f19682a.a());
            }
        } catch (z4.a e10) {
            if (e10.a() == 7) {
                this.f19685d.C(6);
                this.f19685d.x(e10);
                this.f19683b.a(this.f19685d);
                return;
            }
            this.f19683b.b(this.f19685d, e10);
        }
    }
}
