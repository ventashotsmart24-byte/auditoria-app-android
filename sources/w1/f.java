package w1;

import android.content.Context;
import com.advertlib.bean.AdInfo;
import com.bumptech.glide.disklrucache.DiskLruCache;
import h9.t;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.ResponseBody;
import retrofit2.Response;
import s1.m;
import s2.d;
import t2.a;
import t9.i;
import v1.b;
import x1.d;
import y1.c;

public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    public d f9490a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9491b = f.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public final String f9492c = "ad_video";

    /* renamed from: d  reason: collision with root package name */
    public final String f9493d = ".tmp";

    /* renamed from: e  reason: collision with root package name */
    public final long f9494e = 104857600;

    /* renamed from: f  reason: collision with root package name */
    public String f9495f = "";

    /* renamed from: g  reason: collision with root package name */
    public DiskLruCache f9496g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f9497h = new AtomicInteger(0);

    public f(d dVar) {
        i.g(dVar, "mAdRequestModel");
        this.f9490a = dVar;
    }

    public static final void e(f fVar, Context context, String str, AdInfo adInfo, b bVar) {
        i.g(fVar, "this$0");
        i.g(context, "$context");
        i.g(str, "$adType");
        i.g(adInfo, "$adInfo");
        fVar.m(context, str, adInfo, bVar);
        if (fVar.f9497h.decrementAndGet() == 0) {
            m.f9270a.M().a("video");
        }
    }

    public static final void k(b bVar, String str, boolean z10) {
        i.g(str, "$adType");
        if (bVar != null) {
            bVar.a(str, z10);
        }
    }

    public void a(Context context, String str, AdInfo adInfo, b bVar) {
        boolean z10;
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        c cVar = c.f9862a;
        String str2 = this.f9491b;
        StringBuilder sb = new StringBuilder();
        sb.append("send request: ");
        String url = adInfo.getUrl();
        i.d(url);
        sb.append(url);
        cVar.a(str2, sb.toString());
        String url2 = adInfo.getUrl();
        if (url2 == null || url2.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.f9497h.getAndIncrement();
            m.f9270a.Q().submit(new d.e("video cache", (Runnable) new d(this, context, str, adInfo, bVar), false));
        }
    }

    public File b(Context context, String str, AdInfo adInfo) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        n(context);
        String url = adInfo.getUrl();
        if (url == null) {
            url = "";
        }
        return g(url);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A[Catch:{ IOException -> 0x005c }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[Catch:{ IOException -> 0x005c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r4.f9495f     // Catch:{ IOException -> 0x005c }
            com.bumptech.glide.disklrucache.DiskLruCache r1 = r4.h(r1)     // Catch:{ IOException -> 0x005c }
            java.lang.String r2 = ""
            java.lang.String r5 = r1.f.c(r5, r2)     // Catch:{ IOException -> 0x005c }
            com.bumptech.glide.disklrucache.DiskLruCache$Value r5 = r1.get(r5)     // Catch:{ IOException -> 0x005c }
            if (r5 == 0) goto L_0x0018
            java.io.File r5 = r5.getFile(r0)     // Catch:{ IOException -> 0x005c }
            goto L_0x0019
        L_0x0018:
            r5 = 0
        L_0x0019:
            if (r5 == 0) goto L_0x005b
            boolean r1 = r5.exists()     // Catch:{ IOException -> 0x005c }
            if (r1 != 0) goto L_0x0022
            goto L_0x005b
        L_0x0022:
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ IOException -> 0x005c }
            java.lang.String r1 = "file.absolutePath"
            t9.i.f(r5, r1)     // Catch:{ IOException -> 0x005c }
            java.lang.String r5 = r4.i(r5)     // Catch:{ IOException -> 0x005c }
            r1 = 1
            if (r5 == 0) goto L_0x003b
            int r2 = r5.length()     // Catch:{ IOException -> 0x005c }
            if (r2 != 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r2 = 0
            goto L_0x003c
        L_0x003b:
            r2 = 1
        L_0x003c:
            if (r2 == 0) goto L_0x003f
            return r0
        L_0x003f:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x005c }
            r2.<init>(r5)     // Catch:{ IOException -> 0x005c }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x005c }
            if (r3 == 0) goto L_0x0050
            y1.b r5 = y1.b.f9861a     // Catch:{ IOException -> 0x005c }
            r5.b(r2)     // Catch:{ IOException -> 0x005c }
            return r0
        L_0x0050:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x005c }
            r2.<init>(r5)     // Catch:{ IOException -> 0x005c }
            boolean r5 = r2.exists()     // Catch:{ IOException -> 0x005c }
            r5 = r5 ^ r1
            return r5
        L_0x005b:
            return r0
        L_0x005c:
            r5 = move-exception
            r5.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.f.f(java.lang.String):boolean");
    }

    public final File g(String str) {
        boolean z10;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && f(str)) {
            try {
                DiskLruCache.Value value = h(this.f9495f).get(r1.f.c(str, ""));
                if (value != null) {
                    return value.getFile(0);
                }
                return null;
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public final DiskLruCache h(String str) {
        if (this.f9496g == null) {
            synchronized (f.class) {
                if (this.f9496g == null) {
                    this.f9496g = DiskLruCache.open(new File(str, this.f9492c), 1, 1, this.f9494e);
                }
                t tVar = t.f17319a;
            }
        }
        DiskLruCache diskLruCache = this.f9496g;
        i.d(diskLruCache);
        return diskLruCache;
    }

    public final String i(String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, str.length() - 2);
        i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(this.f9493d);
        return sb.toString();
    }

    public final void j(b bVar, String str, boolean z10) {
        m.f9270a.P().post(new e(bVar, str, z10));
    }

    public final boolean l(String str, String str2, InputStream inputStream) {
        DiskLruCache.Editor edit;
        File file;
        if (inputStream == null || (edit = h(str).edit(r1.f.c(str2, ""))) == null || (file = edit.getFile(0)) == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        i.f(absolutePath, "cacheFile.absolutePath");
        String i10 = i(absolutePath);
        y1.b bVar = y1.b.f9861a;
        bVar.d(i10);
        if (bVar.a(inputStream, file)) {
            bVar.c(i10);
            edit.commit();
            return true;
        }
        bVar.c(i10);
        edit.abortUnlessCommitted();
        return false;
    }

    public final void m(Context context, String str, AdInfo adInfo, b bVar) {
        n(context);
        String url = adInfo.getUrl();
        i.d(url);
        if (f(url)) {
            j(bVar, str, true);
            return;
        }
        try {
            x1.d dVar = this.f9490a;
            String url2 = adInfo.getUrl();
            i.d(url2);
            Response execute = dVar.m(url2).execute();
            if (!execute.isSuccessful()) {
                j(bVar, str, false);
                a.f9350a.q(x1.d.f9657g.b(), "key_ads");
                return;
            }
            ResponseBody responseBody = (ResponseBody) execute.body();
            if (responseBody == null) {
                j(bVar, str, false);
                return;
            }
            String str2 = this.f9495f;
            String url3 = adInfo.getUrl();
            if (url3 == null) {
                url3 = "";
            }
            if (l(str2, url3, responseBody.byteStream())) {
                j(bVar, str, true);
            } else {
                j(bVar, str, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            j(bVar, str, false);
            a.f9350a.q(x1.d.f9657g.b(), "key_ads");
        }
    }

    public final void n(Context context) {
        boolean z10;
        String str = this.f9495f;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String absolutePath = context.getCacheDir().getAbsolutePath();
            i.f(absolutePath, "context.cacheDir.absolutePath");
            this.f9495f = absolutePath;
        }
    }
}
