package v4;

import android.os.Process;
import android.text.TextUtils;
import java.net.HttpURLConnection;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final String f19661a = "GetFileInfoTask";

    /* renamed from: b  reason: collision with root package name */
    public final u4.a f19662b;

    /* renamed from: c  reason: collision with root package name */
    public final y4.a f19663c;

    /* renamed from: d  reason: collision with root package name */
    public final C0287a f19664d;

    /* renamed from: v4.a$a  reason: collision with other inner class name */
    public interface C0287a {
        void a(long j10, boolean z10);
    }

    public a(u4.a aVar, y4.a aVar2, C0287a aVar3) {
        this.f19662b = aVar;
        this.f19663c = aVar2;
        this.f19664d = aVar3;
    }

    public final void a() {
        if (this.f19663c.p()) {
            throw new z4.a(7);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r6) {
        /*
            r5 = this;
            y4.a r0 = r5.f19663c
            r0.w(r6)
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x007b, ProtocolException -> 0x006e, IOException -> 0x0061, all -> 0x005c }
            r1.<init>(r6)     // Catch:{ MalformedURLException -> 0x007b, ProtocolException -> 0x006e, IOException -> 0x0061, all -> 0x005c }
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ MalformedURLException -> 0x007b, ProtocolException -> 0x006e, IOException -> 0x0061, all -> 0x005c }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ MalformedURLException -> 0x007b, ProtocolException -> 0x006e, IOException -> 0x0061, all -> 0x005c }
            r0 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r0)     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            r6.setReadTimeout(r0)     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r0 = "GET"
            r6.setRequestMethod(r0)     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r0 = "Range"
            java.lang.String r1 = "bytes=0-"
            r6.setRequestProperty(r0, r1)     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            int r0 = r6.getResponseCode()     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x0032
            r0 = 0
            r5.d(r6, r0)     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            goto L_0x003a
        L_0x0032:
            r1 = 206(0xce, float:2.89E-43)
            if (r0 != r1) goto L_0x003e
            r0 = 1
            r5.d(r6, r0)     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
        L_0x003a:
            r6.disconnect()
            return
        L_0x003e:
            z4.a r1 = new z4.a     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            r2.<init>()     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r3 = "UnSupported response code:"
            r2.append(r3)     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            r2.append(r0)     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r2 = r2.toString()     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            r3 = 3
            r1.<init>((int) r3, (int) r0, (java.lang.String) r2)     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
            throw r1     // Catch:{ MalformedURLException -> 0x005a, ProtocolException -> 0x0058, IOException -> 0x0056 }
        L_0x0056:
            r0 = move-exception
            goto L_0x0065
        L_0x0058:
            r0 = move-exception
            goto L_0x0072
        L_0x005a:
            r0 = move-exception
            goto L_0x007f
        L_0x005c:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x0089
        L_0x0061:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0065:
            z4.a r1 = new z4.a     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "IO error"
            r3 = 5
            r1.<init>((int) r3, (java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0088 }
            throw r1     // Catch:{ all -> 0x0088 }
        L_0x006e:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0072:
            z4.a r1 = new z4.a     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "Protocol error"
            r3 = 4
            r1.<init>((int) r3, (java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0088 }
            throw r1     // Catch:{ all -> 0x0088 }
        L_0x007b:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x007f:
            z4.a r1 = new z4.a     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "Bad url."
            r3 = 2
            r1.<init>((int) r3, (java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0088 }
            throw r1     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r0 = move-exception
        L_0x0089:
            if (r6 == 0) goto L_0x008e
            r6.disconnect()
        L_0x008e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.a.b(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            y4.a r0 = r5.f19663c
            r0.w(r6)
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0053 }
            r6.setReadTimeout(r0)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r0 = "GET"
            r6.setRequestMethod(r0)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r0 = "Range"
            java.lang.String r1 = "bytes=0-"
            r6.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x0053 }
            int r0 = r6.getResponseCode()     // Catch:{ Exception -> 0x0053 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x0032
            r0 = 0
            r5.d(r6, r0)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0063
        L_0x0032:
            r1 = 206(0xce, float:2.89E-43)
            if (r0 != r1) goto L_0x003b
            r0 = 1
            r5.d(r6, r0)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0063
        L_0x003b:
            z4.a r1 = new z4.a     // Catch:{ Exception -> 0x0053 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r2.<init>()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = "UnSupported response code:"
            r2.append(r3)     // Catch:{ Exception -> 0x0053 }
            r2.append(r0)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0053 }
            r3 = 3
            r1.<init>((int) r3, (int) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0053 }
            throw r1     // Catch:{ Exception -> 0x0053 }
        L_0x0053:
            r0 = move-exception
            goto L_0x005b
        L_0x0055:
            r7 = move-exception
            goto L_0x0069
        L_0x0057:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x005b:
            r0.printStackTrace()     // Catch:{ all -> 0x0067 }
            r5.b(r7)     // Catch:{ all -> 0x0067 }
            if (r6 == 0) goto L_0x0066
        L_0x0063:
            r6.disconnect()
        L_0x0066:
            return
        L_0x0067:
            r7 = move-exception
            r0 = r6
        L_0x0069:
            if (r0 == 0) goto L_0x006e
            r0.disconnect()
        L_0x006e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.a.c(java.lang.String, java.lang.String):void");
    }

    public final void d(HttpURLConnection httpURLConnection, boolean z10) {
        long j10;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField) || headerField.equals("0") || headerField.equals("-1")) {
            j10 = (long) httpURLConnection.getContentLength();
        } else {
            j10 = Long.parseLong(headerField);
        }
        if (j10 > 0) {
            a();
            this.f19664d.a(j10, z10);
            return;
        }
        throw new z4.a(6, "length <= 0");
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            if (TextUtils.isEmpty(this.f19663c.a())) {
                b(this.f19663c.m());
            } else {
                c(this.f19663c.m(), this.f19663c.a());
            }
        } catch (z4.a e10) {
            this.f19662b.b(this.f19663c, e10);
        } catch (Exception e11) {
            this.f19662b.b(this.f19663c, new z4.a(9, (Throwable) e11));
        }
    }
}
