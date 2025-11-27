package q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f8835a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap f8836b = new WeakHashMap(0);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f8837c = new Object();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ColorStateList f8838a;

        /* renamed from: b  reason: collision with root package name */
        public final Configuration f8839b;

        public a(ColorStateList colorStateList, Configuration configuration) {
            this.f8838a = colorStateList;
            this.f8839b = configuration;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f8840a;

        /* renamed from: b  reason: collision with root package name */
        public final Resources.Theme f8841b;

        public b(Resources resources, Resources.Theme theme) {
            this.f8840a = resources;
            this.f8841b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f8840a.equals(bVar.f8840a) || !a0.c.a(this.f8841b, bVar.f8841b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return a0.c.b(this.f8840a, this.f8841b);
        }
    }

    public static abstract class c {

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Typeface f8842a;

            public a(Typeface typeface) {
                this.f8842a = typeface;
            }

            public void run() {
                c.this.onFontRetrieved(this.f8842a);
            }
        }

        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f8844a;

            public b(int i10) {
                this.f8844a = i10;
            }

            public void run() {
                c.this.onFontRetrievalFailed(this.f8844a);
            }
        }

        public static Handler getHandler(Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        public final void callbackFailAsync(int i10, Handler handler) {
            getHandler(handler).post(new b(i10));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            getHandler(handler).post(new a(typeface));
        }

        public abstract void onFontRetrievalFailed(int i10);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    public static void a(b bVar, int i10, ColorStateList colorStateList) {
        synchronized (f8837c) {
            WeakHashMap weakHashMap = f8836b;
            SparseArray sparseArray = (SparseArray) weakHashMap.get(bVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(bVar, sparseArray);
            }
            sparseArray.append(i10, new a(colorStateList, bVar.f8840a.getConfiguration()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList b(q.h.b r4, int r5) {
        /*
            java.lang.Object r0 = f8837c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = f8836b     // Catch:{ all -> 0x0033 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0033 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0030
            int r2 = r1.size()     // Catch:{ all -> 0x0033 }
            if (r2 <= 0) goto L_0x0030
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0033 }
            q.h$a r2 = (q.h.a) r2     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0030
            android.content.res.Configuration r3 = r2.f8839b     // Catch:{ all -> 0x0033 }
            android.content.res.Resources r4 = r4.f8840a     // Catch:{ all -> 0x0033 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0033 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x002d
            android.content.res.ColorStateList r4 = r2.f8838a     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x002d:
            r1.remove(r5)     // Catch:{ all -> 0x0033 }
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            r4 = 0
            return r4
        L_0x0033:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: q.h.b(q.h$b, int):android.content.res.ColorStateList");
    }

    public static ColorStateList c(Resources resources, int i10, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i10, theme);
        }
        b bVar = new b(resources, theme);
        ColorStateList b10 = b(bVar, i10);
        if (b10 != null) {
            return b10;
        }
        ColorStateList i11 = i(resources, i10, theme);
        if (i11 == null) {
            return resources.getColorStateList(i10);
        }
        a(bVar, i10, i11);
        return i11;
    }

    public static Drawable d(Resources resources, int i10, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i10, theme);
        }
        return resources.getDrawable(i10);
    }

    public static Typeface e(Context context, int i10) {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i10, new TypedValue(), 0, (c) null, (Handler) null, false, false);
    }

    public static Typeface f(Context context, int i10, TypedValue typedValue, int i11, c cVar) {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i10, typedValue, i11, cVar, (Handler) null, true, false);
    }

    public static void g(Context context, int i10, c cVar, Handler handler) {
        a0.h.d(cVar);
        if (context.isRestricted()) {
            cVar.callbackFailAsync(-4, handler);
            return;
        }
        k(context, i10, new TypedValue(), 0, cVar, handler, false, false);
    }

    public static TypedValue h() {
        ThreadLocal threadLocal = f8835a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList i(Resources resources, int i10, Resources.Theme theme) {
        if (j(resources, i10)) {
            return null;
        }
        try {
            return a.a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.e("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    public static boolean j(Resources resources, int i10) {
        TypedValue h10 = h();
        resources.getValue(i10, h10, true);
        int i11 = h10.type;
        if (i11 < 28 || i11 > 31) {
            return false;
        }
        return true;
    }

    public static Typeface k(Context context, int i10, TypedValue typedValue, int i11, c cVar, Handler handler, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        int i12 = i10;
        resources.getValue(i10, typedValue, true);
        Typeface l10 = l(context, resources, typedValue, i10, i11, cVar, handler, z10, z11);
        if (l10 != null || cVar != null || z11) {
            return l10;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface l(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, q.h.c r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00aa
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = -3
            r14 = 0
            if (r1 != 0) goto L_0x0026
            if (r9 == 0) goto L_0x0025
            r9.callbackFailAsync(r13, r10)
        L_0x0025:
            return r14
        L_0x0026:
            android.graphics.Typeface r1 = r.e.f(r0, r4, r5)
            if (r1 == 0) goto L_0x0032
            if (r9 == 0) goto L_0x0031
            r9.callbackSuccessAsync(r1, r10)
        L_0x0031:
            return r1
        L_0x0032:
            if (r23 == 0) goto L_0x0035
            return r14
        L_0x0035:
            java.lang.String r1 = r12.toLowerCase()     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
            if (r1 == 0) goto L_0x0068
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
            q.d$a r2 = q.d.b(r1, r0)     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
            if (r2 != 0) goto L_0x0056
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
            if (r9 == 0) goto L_0x0055
            r9.callbackFailAsync(r13, r10)     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
        L_0x0055:
            return r14
        L_0x0056:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = r.e.c(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
            return r0
        L_0x0068:
            r1 = r15
            android.graphics.Typeface r0 = r.e.d(r15, r0, r4, r12, r5)     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
            if (r9 == 0) goto L_0x0078
            if (r0 == 0) goto L_0x0075
            r9.callbackSuccessAsync(r0, r10)     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
            goto L_0x0078
        L_0x0075:
            r9.callbackFailAsync(r13, r10)     // Catch:{ XmlPullParserException -> 0x008f, IOException -> 0x0079 }
        L_0x0078:
            return r0
        L_0x0079:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            goto L_0x00a4
        L_0x008f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
        L_0x00a4:
            if (r9 == 0) goto L_0x00a9
            r9.callbackFailAsync(r13, r10)
        L_0x00a9:
            return r14
        L_0x00aa:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q.h.l(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, q.h$c, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
