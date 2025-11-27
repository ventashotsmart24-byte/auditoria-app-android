package q9;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.http.HTTP;
import java.io.File;
import java.nio.charset.Charset;
import t9.i;

public abstract class c extends b {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        q9.a.a(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String a(java.io.File r2, java.nio.charset.Charset r3) {
        /*
            java.lang.String r0 = "<this>"
            t9.i.g(r2, r0)
            java.lang.String r0 = "charset"
            t9.i.g(r3, r0)
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            r0.<init>(r1, r3)
            java.lang.String r2 = q9.d.c(r0)     // Catch:{ all -> 0x001d }
            r3 = 0
            q9.a.a(r0, r3)
            return r2
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r3 = move-exception
            q9.a.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.c.a(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    public static /* synthetic */ String b(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = ba.c.f11331b;
        }
        return a(file, charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        q9.a.a(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void c(java.io.File r1, byte[] r2) {
        /*
            java.lang.String r0 = "<this>"
            t9.i.g(r1, r0)
            java.lang.String r0 = "array"
            t9.i.g(r2, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r1)
            r0.write(r2)     // Catch:{ all -> 0x0019 }
            h9.t r1 = h9.t.f17319a     // Catch:{ all -> 0x0019 }
            r1 = 0
            q9.a.a(r0, r1)
            return
        L_0x0019:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x001b }
        L_0x001b:
            r2 = move-exception
            q9.a.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.c.c(java.io.File, byte[]):void");
    }

    public static final void d(File file, String str, Charset charset) {
        i.g(file, "<this>");
        i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        i.g(charset, HTTP.CHARSET);
        byte[] bytes = str.getBytes(charset);
        i.f(bytes, "this as java.lang.String).getBytes(charset)");
        c(file, bytes);
    }

    public static /* synthetic */ void e(File file, String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = ba.c.f11331b;
        }
        d(file, str, charset);
    }
}
