package r1;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import ba.s;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.EmptySignature;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.f;
import h9.t;
import java.io.File;
import java.io.IOException;
import s9.l;
import t9.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8975a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final String f8976b = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static final String f8977c = "image_manager_ad";

    /* renamed from: d  reason: collision with root package name */
    public static final long f8978d = 62914560;

    /* renamed from: e  reason: collision with root package name */
    public static volatile DiskLruCache f8979e;

    /* renamed from: r1.a$a  reason: collision with other inner class name */
    public static final class C0118a implements RequestListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f8980a;

        public C0118a(l lVar) {
            this.f8980a = lVar;
        }

        /* renamed from: a */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target target, DataSource dataSource, boolean z10) {
            i.g(gifDrawable, "resource");
            i.g(obj, Constants.KEY_MODEL);
            i.g(target, "target");
            i.g(dataSource, "dataSource");
            l lVar = this.f8980a;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.TRUE);
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            i.g(target, "target");
            l lVar = this.f8980a;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.FALSE);
            return false;
        }
    }

    public static final class b implements RequestListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f8981a;

        public b(l lVar) {
            this.f8981a = lVar;
        }

        /* renamed from: a */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z10) {
            i.g(drawable, "resource");
            i.g(obj, Constants.KEY_MODEL);
            i.g(target, "target");
            i.g(dataSource, "dataSource");
            l lVar = this.f8981a;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.TRUE);
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            i.g(target, "target");
            l lVar = this.f8981a;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.FALSE);
            return false;
        }
    }

    public static final class c implements RequestListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f8983b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f8984c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Integer f8985d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f8986e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f8987f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8988g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8989h;

        public c(String str, ImageView imageView, Context context, Integer num, l lVar, Integer num2, boolean z10, int i10) {
            this.f8982a = str;
            this.f8983b = imageView;
            this.f8984c = context;
            this.f8985d = num;
            this.f8986e = lVar;
            this.f8987f = num2;
            this.f8988g = z10;
            this.f8989h = i10;
        }

        public static final void b(Context context, ImageView imageView, String str, Integer num, l lVar, Integer num2, boolean z10) {
            i.g(context, "$context");
            i.g(imageView, "$iv");
            i.g(str, "$url");
            a.f8975a.g(context, imageView, str, num, lVar, num2, z10);
        }

        /* renamed from: c */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target target, DataSource dataSource, boolean z10) {
            i.g(gifDrawable, "resource");
            i.g(obj, Constants.KEY_MODEL);
            i.g(dataSource, "dataSource");
            int i10 = this.f8989h;
            if (i10 > 0) {
                gifDrawable.setLoopCount(i10);
            }
            l lVar = this.f8986e;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.TRUE);
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            i.g(target, "target");
            ImageView imageView = this.f8983b;
            imageView.post(new b(this.f8984c, imageView, this.f8982a, this.f8985d, this.f8986e, this.f8987f, this.f8988g));
            return false;
        }
    }

    public static final class d implements RequestListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8990a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f8991b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f8992c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Integer f8993d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f8994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f8995f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8996g;

        public d(String str, ImageView imageView, Context context, Integer num, l lVar, Integer num2, boolean z10) {
            this.f8990a = str;
            this.f8991b = imageView;
            this.f8992c = context;
            this.f8993d = num;
            this.f8994e = lVar;
            this.f8995f = num2;
            this.f8996g = z10;
        }

        public static final void b(Context context, ImageView imageView, String str, Integer num, l lVar, Integer num2, boolean z10) {
            i.g(context, "$context");
            i.g(imageView, "$iv");
            i.g(str, "$url");
            a.f8975a.g(context, imageView, str, num, lVar, num2, z10);
        }

        /* renamed from: c */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z10) {
            i.g(drawable, "resource");
            i.g(obj, Constants.KEY_MODEL);
            i.g(dataSource, "dataSource");
            l lVar = this.f8994e;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.TRUE);
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            i.g(target, "target");
            ImageView imageView = this.f8991b;
            imageView.post(new c(this.f8992c, imageView, this.f8990a, this.f8993d, this.f8994e, this.f8995f, this.f8996g));
            return false;
        }
    }

    public final boolean b(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isDestroyed();
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return false;
    }

    public final File c(Context context, String str) {
        i.g(context, f.X);
        i.g(str, "url");
        try {
            DiskLruCache.Value value = d(context).get(new SafeKeyGenerator().getSafeKey(new g(str, EmptySignature.obtain())));
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final DiskLruCache d(Context context) {
        if (f8979e == null) {
            synchronized (a.class) {
                if (f8979e == null) {
                    f8979e = DiskLruCache.open(new File(context.getCacheDir(), f8977c), 1, 1, f8978d);
                }
                t tVar = t.f17319a;
            }
        }
        DiskLruCache diskLruCache = f8979e;
        i.d(diskLruCache);
        return diskLruCache;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(android.content.Context r8, java.lang.String r9, java.io.File r10) {
        /*
            r7 = this;
            if (r10 == 0) goto L_0x00d2
            boolean r0 = r10.isDirectory()
            if (r0 != 0) goto L_0x00d2
            r0 = 0
            r1.g r1 = new r1.g     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            com.bumptech.glide.signature.EmptySignature r2 = com.bumptech.glide.signature.EmptySignature.obtain()     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            r1.<init>(r9, r2)     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            com.bumptech.glide.load.engine.cache.SafeKeyGenerator r2 = new com.bumptech.glide.load.engine.cache.SafeKeyGenerator     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            r2.<init>()     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            java.lang.String r1 = r2.getSafeKey(r1)     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            com.bumptech.glide.disklrucache.DiskLruCache r2 = r7.d(r8)     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r1 = r2.edit(r1)     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            if (r1 == 0) goto L_0x0067
            r2 = 0
            java.io.File r3 = r1.getFile(r2)     // Catch:{ all -> 0x005d }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ all -> 0x005d }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x005d }
            r5.<init>(r10)     // Catch:{ all -> 0x005d }
            r4.<init>(r5)     // Catch:{ all -> 0x005d }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x005a }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x005a }
            r6.<init>(r3)     // Catch:{ all -> 0x005a }
            r5.<init>(r6)     // Catch:{ all -> 0x005a }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0058 }
        L_0x0042:
            int r3 = r4.read(r0)     // Catch:{ all -> 0x0058 }
            r6 = -1
            if (r3 == r6) goto L_0x004d
            r5.write(r0, r2, r3)     // Catch:{ all -> 0x0058 }
            goto L_0x0042
        L_0x004d:
            r5.flush()     // Catch:{ all -> 0x0058 }
            r1.commit()     // Catch:{ all -> 0x0058 }
            r1.abortUnlessCommitted()     // Catch:{ Exception -> 0x0065 }
            r0 = r4
            goto L_0x0068
        L_0x0058:
            r0 = move-exception
            goto L_0x0061
        L_0x005a:
            r2 = move-exception
            r5 = r0
            goto L_0x0060
        L_0x005d:
            r2 = move-exception
            r4 = r0
            r5 = r4
        L_0x0060:
            r0 = r2
        L_0x0061:
            r1.abortUnlessCommitted()     // Catch:{ Exception -> 0x0065 }
            throw r0     // Catch:{ Exception -> 0x0065 }
        L_0x0065:
            r0 = move-exception
            goto L_0x0091
        L_0x0067:
            r5 = r0
        L_0x0068:
            r1.d r1 = r1.d.f9011a
            r1.a(r0)
            r1.a(r5)
            java.lang.String r10 = r1.f.b(r10)
            java.io.File r8 = r7.c(r8, r9)
            if (r8 == 0) goto L_0x00d2
            java.lang.String r9 = r1.f.b(r8)
            boolean r9 = android.text.TextUtils.equals(r10, r9)
            if (r9 != 0) goto L_0x00d2
        L_0x0084:
            r8.delete()
            goto L_0x00d2
        L_0x0088:
            r1 = move-exception
            r4 = r0
            r5 = r4
            r0 = r1
            goto L_0x00b2
        L_0x008d:
            r1 = move-exception
            r4 = r0
            r5 = r4
            r0 = r1
        L_0x0091:
            r0.printStackTrace()     // Catch:{ all -> 0x00b1 }
            r1.d r0 = r1.d.f9011a
            r0.a(r4)
            r0.a(r5)
            java.lang.String r10 = r1.f.b(r10)
            java.io.File r8 = r7.c(r8, r9)
            if (r8 == 0) goto L_0x00d2
            java.lang.String r9 = r1.f.b(r8)
            boolean r9 = android.text.TextUtils.equals(r10, r9)
            if (r9 != 0) goto L_0x00d2
            goto L_0x0084
        L_0x00b1:
            r0 = move-exception
        L_0x00b2:
            r1.d r1 = r1.d.f9011a
            r1.a(r4)
            r1.a(r5)
            java.lang.String r10 = r1.f.b(r10)
            java.io.File r8 = r7.c(r8, r9)
            if (r8 == 0) goto L_0x00d1
            java.lang.String r9 = r1.f.b(r8)
            boolean r9 = android.text.TextUtils.equals(r10, r9)
            if (r9 != 0) goto L_0x00d1
            r8.delete()
        L_0x00d1:
            throw r0
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.a.e(android.content.Context, java.lang.String, java.io.File):void");
    }

    public final boolean f(Context context, String str) {
        i.g(context, f.X);
        i.g(str, "url");
        File c10 = c(context, str);
        if (c10 != null && !c10.isDirectory()) {
            return true;
        }
        try {
            e(context, str, (File) Glide.with(context).downloadOnly().load((Object) e.a(str)).submit().get());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void g(Context context, ImageView imageView, String str, Integer num, l lVar, Integer num2, boolean z10) {
        if (!b(context)) {
            if (s.e(str, ".gif", false, 2, (Object) null)) {
                RequestBuilder<GifDrawable> load = Glide.with(context).asGif().load((Object) e.a(str));
                i.f(load, "with(context).asGif().load(url.toGlideUrl())");
                if (num2 != null) {
                    BaseRequestOptions override = load.override(num2.intValue(), num2.intValue());
                    i.f(override, "requestBuilder.override(size,size)");
                    load = (RequestBuilder) override;
                }
                if (z10) {
                    BaseRequestOptions dontAnimate = load.dontAnimate();
                    i.f(dontAnimate, "requestBuilder.dontAnimate()");
                    load = (RequestBuilder) dontAnimate;
                }
                if (num != null) {
                    BaseRequestOptions error = ((RequestBuilder) load.placeholder(num.intValue())).error(num.intValue());
                    i.f(error, "requestBuilder.placehold…urceId).error(resourceId)");
                    load = (RequestBuilder) error;
                }
                ((RequestBuilder) load.addListener(new C0118a(lVar)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(imageView);
                return;
            }
            RequestBuilder<Drawable> load2 = Glide.with(context).load((Object) e.a(str));
            i.f(load2, "with(context).load(url.toGlideUrl())");
            if (num2 != null) {
                BaseRequestOptions override2 = load2.override(num2.intValue(), num2.intValue());
                i.f(override2, "requestBuilder.override(size,size)");
                load2 = (RequestBuilder) override2;
            }
            if (z10) {
                BaseRequestOptions dontAnimate2 = load2.dontAnimate();
                i.f(dontAnimate2, "requestBuilder.dontAnimate()");
                load2 = (RequestBuilder) dontAnimate2;
            }
            if (num != null) {
                BaseRequestOptions error2 = ((RequestBuilder) load2.placeholder(num.intValue())).error(num.intValue());
                i.f(error2, "requestBuilder.placehold…urceId).error(resourceId)");
                load2 = (RequestBuilder) error2;
            }
            ((RequestBuilder) load2.addListener(new b(lVar)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(imageView);
        }
    }

    public final void h(Context context, ImageView imageView, String str, File file, Integer num, l lVar, Integer num2, boolean z10, int i10) {
        ImageView imageView2 = imageView;
        String str2 = str;
        File file2 = file;
        Context context2 = context;
        i.g(context, f.X);
        i.g(imageView, "iv");
        i.g(str, "url");
        if (!b(context)) {
            if (file2 != null) {
                try {
                    if (file.exists() && !file.isDirectory()) {
                        if (s.e(str, ".gif", false, 2, (Object) null)) {
                            BaseRequestOptions timeout = Glide.with(context).asGif().load(file2).timeout(0);
                            i.f(timeout, "with(context).asGif().load(cache).timeout(0)");
                            RequestBuilder requestBuilder = (RequestBuilder) timeout;
                            if (num2 != null) {
                                BaseRequestOptions override = requestBuilder.override(num2.intValue(), num2.intValue());
                                i.f(override, "requestBuilder.override(size,size)");
                                requestBuilder = (RequestBuilder) override;
                            }
                            if (z10) {
                                BaseRequestOptions dontAnimate = requestBuilder.dontAnimate();
                                i.f(dontAnimate, "requestBuilder.dontAnimate()");
                                requestBuilder = (RequestBuilder) dontAnimate;
                            }
                            if (num != null) {
                                BaseRequestOptions error = ((RequestBuilder) requestBuilder.placeholder(num.intValue())).error(num.intValue());
                                i.f(error, "requestBuilder.placehold…).error(placeholderResId)");
                                requestBuilder = (RequestBuilder) error;
                            }
                            requestBuilder.addListener(new c(str, imageView, context, num, lVar, num2, z10, i10)).into(imageView);
                            return;
                        }
                        RequestBuilder<Drawable> load = Glide.with(context).load(file2);
                        i.f(load, "with(context).load(cache)");
                        if (num2 != null) {
                            BaseRequestOptions override2 = load.override(num2.intValue(), num2.intValue());
                            i.f(override2, "requestBuilder.override(size,size)");
                            load = (RequestBuilder) override2;
                        }
                        if (z10) {
                            BaseRequestOptions dontAnimate2 = load.dontAnimate();
                            i.f(dontAnimate2, "requestBuilder.dontAnimate()");
                            load = (RequestBuilder) dontAnimate2;
                        }
                        if (num != null) {
                            BaseRequestOptions error2 = ((RequestBuilder) load.placeholder(num.intValue())).error(num.intValue());
                            i.f(error2, "requestBuilder.placehold…).error(placeholderResId)");
                            load = (RequestBuilder) error2;
                        }
                        load.addListener(new d(str, imageView, context, num, lVar, num2, z10)).into(imageView);
                        return;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            g(context, imageView, str, num, lVar, num2, z10);
        }
    }
}
