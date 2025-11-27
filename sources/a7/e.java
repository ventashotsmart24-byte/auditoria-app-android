package a7;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f10706a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final int f10707b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static int f10708c = 2048;

    public final boolean a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isDestroyed();
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009c, code lost:
        r9 = a3.e.a(r10, "key_poster");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a0, code lost:
        if (r9 == null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a2, code lost:
        r10 = com.mobile.brasiltv.utils.b0.W(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a7, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0123, code lost:
        r9 = a3.e.a(r10, "key_poster");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0127, code lost:
        if (r9 == null) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0129, code lost:
        r10 = com.mobile.brasiltv.utils.b0.W(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012e, code lost:
        r10 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.content.Context r9, java.lang.String r10, android.widget.ImageView r11, int r12) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            t9.i.g(r9, r0)
            java.lang.String r0 = "imageView"
            t9.i.g(r11, r0)
            boolean r0 = r8.a(r9)
            if (r0 == 0) goto L_0x0011
            return
        L_0x0011:
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with((android.content.Context) r9)
            java.lang.String r1 = "with(context)"
            t9.i.f(r0, r1)
            java.lang.Long r9 = com.mobile.brasiltv.utils.j1.c(r9)
            java.lang.String r1 = "totalMenu"
            t9.i.f(r9, r1)
            long r1 = r9.longValue()
            int r9 = f10708c
            long r3 = (long) r9
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 > 0) goto L_0x003e
            com.bumptech.glide.request.RequestOptions r9 = new com.bumptech.glide.request.RequestOptions
            r9.<init>()
            com.bumptech.glide.load.DecodeFormat r1 = com.bumptech.glide.load.DecodeFormat.PREFER_RGB_565
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.format(r1)
            com.bumptech.glide.request.RequestOptions r9 = (com.bumptech.glide.request.RequestOptions) r9
            r0.setDefaultRequestOptions(r9)
        L_0x003e:
            r9 = -1
            java.lang.String r1 = ""
            r2 = 2
            java.lang.String r3 = ".gif"
            r4 = 1
            r5 = 0
            java.lang.String r6 = "key_poster"
            r7 = 0
            if (r12 != r9) goto L_0x00c7
            if (r10 == 0) goto L_0x0054
            boolean r9 = ba.s.e(r10, r3, r7, r2, r5)
            if (r9 != r4) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r4 = 0
        L_0x0055:
            if (r4 == 0) goto L_0x008f
            com.bumptech.glide.RequestBuilder r9 = r0.asGif()
            boolean r12 = android.text.TextUtils.isEmpty(r10)
            if (r12 == 0) goto L_0x0066
            java.lang.String r5 = a3.e.a(r10, r6)
            goto L_0x0070
        L_0x0066:
            java.lang.String r10 = a3.e.a(r10, r6)
            if (r10 == 0) goto L_0x0070
            com.bumptech.glide.load.model.GlideUrl r5 = com.mobile.brasiltv.utils.b0.W(r10)
        L_0x0070:
            com.bumptech.glide.RequestBuilder r9 = r9.load((java.lang.Object) r5)
            int r10 = f10707b
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.timeout(r10)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.skipMemoryCache(r7)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.load.engine.DiskCacheStrategy r10 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.diskCacheStrategy(r10)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            r9.into((android.widget.ImageView) r11)
            goto L_0x0158
        L_0x008f:
            boolean r9 = android.text.TextUtils.isEmpty(r10)
            if (r9 == 0) goto L_0x009c
            if (r10 != 0) goto L_0x00a8
            java.lang.String r10 = a3.e.a(r1, r6)
            goto L_0x00a8
        L_0x009c:
            java.lang.String r9 = a3.e.a(r10, r6)
            if (r9 == 0) goto L_0x00a7
            com.bumptech.glide.load.model.GlideUrl r10 = com.mobile.brasiltv.utils.b0.W(r9)
            goto L_0x00a8
        L_0x00a7:
            r10 = r5
        L_0x00a8:
            com.bumptech.glide.RequestBuilder r9 = r0.load((java.lang.Object) r10)
            int r10 = f10707b
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.timeout(r10)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.skipMemoryCache(r7)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.load.engine.DiskCacheStrategy r10 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.diskCacheStrategy(r10)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            r9.into((android.widget.ImageView) r11)
            goto L_0x0158
        L_0x00c7:
            if (r10 == 0) goto L_0x00d0
            boolean r9 = ba.s.e(r10, r3, r7, r2, r5)
            if (r9 != r4) goto L_0x00d0
            goto L_0x00d1
        L_0x00d0:
            r4 = 0
        L_0x00d1:
            if (r4 == 0) goto L_0x0116
            com.bumptech.glide.RequestBuilder r9 = r0.asGif()
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L_0x00e2
            java.lang.String r5 = a3.e.a(r10, r6)
            goto L_0x00ec
        L_0x00e2:
            java.lang.String r10 = a3.e.a(r10, r6)
            if (r10 == 0) goto L_0x00ec
            com.bumptech.glide.load.model.GlideUrl r5 = com.mobile.brasiltv.utils.b0.W(r10)
        L_0x00ec:
            com.bumptech.glide.RequestBuilder r9 = r9.load((java.lang.Object) r5)
            int r10 = f10707b
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.timeout(r10)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.error((int) r12)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.skipMemoryCache(r7)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.placeholder((int) r12)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.load.engine.DiskCacheStrategy r10 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.diskCacheStrategy(r10)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            r9.into((android.widget.ImageView) r11)
            goto L_0x0158
        L_0x0116:
            boolean r9 = android.text.TextUtils.isEmpty(r10)
            if (r9 == 0) goto L_0x0123
            if (r10 != 0) goto L_0x012f
            java.lang.String r10 = a3.e.a(r1, r6)
            goto L_0x012f
        L_0x0123:
            java.lang.String r9 = a3.e.a(r10, r6)
            if (r9 == 0) goto L_0x012e
            com.bumptech.glide.load.model.GlideUrl r10 = com.mobile.brasiltv.utils.b0.W(r9)
            goto L_0x012f
        L_0x012e:
            r10 = r5
        L_0x012f:
            com.bumptech.glide.RequestBuilder r9 = r0.load((java.lang.Object) r10)
            int r10 = f10707b
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.timeout(r10)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.error((int) r12)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.skipMemoryCache(r7)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.placeholder((int) r12)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            com.bumptech.glide.load.engine.DiskCacheStrategy r10 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
            com.bumptech.glide.request.BaseRequestOptions r9 = r9.diskCacheStrategy(r10)
            com.bumptech.glide.RequestBuilder r9 = (com.bumptech.glide.RequestBuilder) r9
            r9.into((android.widget.ImageView) r11)
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.e.b(android.content.Context, java.lang.String, android.widget.ImageView, int):void");
    }
}
