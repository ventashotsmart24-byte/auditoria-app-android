package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.resources.R$drawable;
import androidx.collection.h;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import x0.g;
import x0.n;

public final class e2 {

    /* renamed from: h  reason: collision with root package name */
    public static final PorterDuff.Mode f1221h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    public static e2 f1222i;

    /* renamed from: j  reason: collision with root package name */
    public static final c f1223j = new c(6);

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap f1224a;

    /* renamed from: b  reason: collision with root package name */
    public androidx.collection.a f1225b;

    /* renamed from: c  reason: collision with root package name */
    public h f1226c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakHashMap f1227d = new WeakHashMap(0);

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f1228e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1229f;

    /* renamed from: g  reason: collision with root package name */
    public e f1230g;

    public static class a implements d {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return e.c.l(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e10);
                return null;
            }
        }
    }

    public static class b implements d {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return g.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e10);
                return null;
            }
        }
    }

    public static class c extends androidx.collection.e {
        public c(int i10) {
            super(i10);
        }

        public static int b(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter c(int i10, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i10, mode)));
        }

        public PorterDuffColorFilter d(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i10, mode)), porterDuffColorFilter);
        }
    }

    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface e {
        Drawable a(e2 e2Var, Context context, int i10);

        ColorStateList b(Context context, int i10);

        boolean c(Context context, int i10, Drawable drawable);

        PorterDuff.Mode d(int i10);

        boolean e(Context context, int i10, Drawable drawable);
    }

    public static class f implements d {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return n.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e10);
                return null;
            }
        }
    }

    public static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized e2 h() {
        e2 e2Var;
        synchronized (e2.class) {
            if (f1222i == null) {
                e2 e2Var2 = new e2();
                f1222i = e2Var2;
                p(e2Var2);
            }
            e2Var = f1222i;
        }
        return e2Var;
    }

    public static synchronized PorterDuffColorFilter l(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter c10;
        synchronized (e2.class) {
            c cVar = f1223j;
            c10 = cVar.c(i10, mode);
            if (c10 == null) {
                c10 = new PorterDuffColorFilter(i10, mode);
                cVar.d(i10, mode, c10);
            }
        }
        return c10;
    }

    public static void p(e2 e2Var) {
        if (Build.VERSION.SDK_INT < 24) {
            e2Var.a("vector", new f());
            e2Var.a("animated-vector", new b());
            e2Var.a("animated-selector", new a());
        }
    }

    public static boolean q(Drawable drawable) {
        if ((drawable instanceof n) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            return true;
        }
        return false;
    }

    public static void w(Drawable drawable, p2 p2Var, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        if (!o1.a(drawable) || drawable.mutate() == drawable) {
            boolean z10 = p2Var.f1330d;
            if (z10 || p2Var.f1329c) {
                if (z10) {
                    colorStateList = p2Var.f1327a;
                } else {
                    colorStateList = null;
                }
                if (p2Var.f1329c) {
                    mode = p2Var.f1328b;
                } else {
                    mode = f1221h;
                }
                drawable.setColorFilter(g(colorStateList, mode, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public final void a(String str, d dVar) {
        if (this.f1225b == null) {
            this.f1225b = new androidx.collection.a();
        }
        this.f1225b.put(str, dVar);
    }

    public final synchronized boolean b(Context context, long j10, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.collection.d dVar = (androidx.collection.d) this.f1227d.get(context);
        if (dVar == null) {
            dVar = new androidx.collection.d();
            this.f1227d.put(context, dVar);
        }
        dVar.j(j10, new WeakReference(constantState));
        return true;
    }

    public final void c(Context context, int i10, ColorStateList colorStateList) {
        if (this.f1224a == null) {
            this.f1224a = new WeakHashMap();
        }
        h hVar = (h) this.f1224a.get(context);
        if (hVar == null) {
            hVar = new h();
            this.f1224a.put(context, hVar);
        }
        hVar.a(i10, colorStateList);
    }

    public final void d(Context context) {
        if (!this.f1229f) {
            this.f1229f = true;
            Drawable j10 = j(context, R$drawable.abc_vector_test);
            if (j10 == null || !q(j10)) {
                this.f1229f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    public final Drawable f(Context context, int i10) {
        Drawable drawable;
        if (this.f1228e == null) {
            this.f1228e = new TypedValue();
        }
        TypedValue typedValue = this.f1228e;
        context.getResources().getValue(i10, typedValue, true);
        long e10 = e(typedValue);
        Drawable i11 = i(context, e10);
        if (i11 != null) {
            return i11;
        }
        e eVar = this.f1230g;
        if (eVar == null) {
            drawable = null;
        } else {
            drawable = eVar.a(this, context, i10);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e10, drawable);
        }
        return drawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable i(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap r0 = r3.f1227d     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            androidx.collection.d r0 = (androidx.collection.d) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.f(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.d(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e2.i(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public synchronized Drawable j(Context context, int i10) {
        return k(context, i10, false);
    }

    public synchronized Drawable k(Context context, int i10, boolean z10) {
        Drawable r10;
        d(context);
        r10 = r(context, i10);
        if (r10 == null) {
            r10 = f(context, i10);
        }
        if (r10 == null) {
            r10 = p.a.getDrawable(context, i10);
        }
        if (r10 != null) {
            r10 = v(context, i10, z10, r10);
        }
        if (r10 != null) {
            o1.b(r10);
        }
        return r10;
    }

    public synchronized ColorStateList m(Context context, int i10) {
        ColorStateList n10;
        n10 = n(context, i10);
        if (n10 == null) {
            e eVar = this.f1230g;
            if (eVar == null) {
                n10 = null;
            } else {
                n10 = eVar.b(context, i10);
            }
            if (n10 != null) {
                c(context, i10, n10);
            }
        }
        return n10;
    }

    public final ColorStateList n(Context context, int i10) {
        h hVar;
        WeakHashMap weakHashMap = this.f1224a;
        if (weakHashMap == null || (hVar = (h) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.e(i10);
    }

    public PorterDuff.Mode o(int i10) {
        e eVar = this.f1230g;
        if (eVar == null) {
            return null;
        }
        return eVar.d(i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable r(android.content.Context r11, int r12) {
        /*
            r10 = this;
            androidx.collection.a r0 = r10.f1225b
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b2
            androidx.collection.h r0 = r10.f1226c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.e(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.a r3 = r10.f1225b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.h r0 = new androidx.collection.h
            r0.<init>()
            r10.f1226c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f1228e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f1228e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f1228e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = e(r0)
            android.graphics.drawable.Drawable r6 = r10.i(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00aa
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.h r8 = r10.f1226c     // Catch:{ Exception -> 0x00a2 }
            r8.a(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.a r8 = r10.f1225b     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.e2$d r3 = (androidx.appcompat.widget.e2.d) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00aa
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.b(r11, r4, r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r11 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00aa:
            if (r6 != 0) goto L_0x00b1
            androidx.collection.h r11 = r10.f1226c
            r11.a(r12, r2)
        L_0x00b1:
            return r6
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e2.r(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    public synchronized void s(Context context) {
        androidx.collection.d dVar = (androidx.collection.d) this.f1227d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    public synchronized Drawable t(Context context, x2 x2Var, int i10) {
        Drawable r10 = r(context, i10);
        if (r10 == null) {
            r10 = x2Var.c(i10);
        }
        if (r10 == null) {
            return null;
        }
        return v(context, i10, false, r10);
    }

    public synchronized void u(e eVar) {
        this.f1230g = eVar;
    }

    public final Drawable v(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList m10 = m(context, i10);
        if (m10 != null) {
            if (o1.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable r10 = s.h.r(drawable);
            s.h.o(r10, m10);
            PorterDuff.Mode o10 = o(i10);
            if (o10 == null) {
                return r10;
            }
            s.h.p(r10, o10);
            return r10;
        }
        e eVar = this.f1230g;
        if ((eVar == null || !eVar.e(context, i10, drawable)) && !x(context, i10, drawable) && z10) {
            return null;
        }
        return drawable;
    }

    public boolean x(Context context, int i10, Drawable drawable) {
        e eVar = this.f1230g;
        if (eVar == null || !eVar.c(context, i10, drawable)) {
            return false;
        }
        return true;
    }
}
