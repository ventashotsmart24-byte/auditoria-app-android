package e;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;

public abstract class h extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    public c f6402a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f6403b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f6404c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f6405d;

    /* renamed from: e  reason: collision with root package name */
    public int f6406e = 255;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6407f;

    /* renamed from: g  reason: collision with root package name */
    public int f6408g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f6409h = -1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6410i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f6411j;

    /* renamed from: k  reason: collision with root package name */
    public long f6412k;

    /* renamed from: l  reason: collision with root package name */
    public long f6413l;

    /* renamed from: m  reason: collision with root package name */
    public b f6414m;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            h.this.a(true);
            h.this.invalidateSelf();
        }
    }

    public static class b implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        public Drawable.Callback f6416a;

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f6416a;
            this.f6416a = null;
            return callback;
        }

        public b b(Drawable.Callback callback) {
            this.f6416a = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            Drawable.Callback callback = this.f6416a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f6416a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    public static abstract class c extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* renamed from: a  reason: collision with root package name */
        public final h f6417a;

        /* renamed from: b  reason: collision with root package name */
        public Resources f6418b;

        /* renamed from: c  reason: collision with root package name */
        public int f6419c = 160;

        /* renamed from: d  reason: collision with root package name */
        public int f6420d;

        /* renamed from: e  reason: collision with root package name */
        public int f6421e;

        /* renamed from: f  reason: collision with root package name */
        public SparseArray f6422f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable[] f6423g;

        /* renamed from: h  reason: collision with root package name */
        public int f6424h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f6425i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f6426j;

        /* renamed from: k  reason: collision with root package name */
        public Rect f6427k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f6428l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f6429m;

        /* renamed from: n  reason: collision with root package name */
        public int f6430n;

        /* renamed from: o  reason: collision with root package name */
        public int f6431o;

        /* renamed from: p  reason: collision with root package name */
        public int f6432p;

        /* renamed from: q  reason: collision with root package name */
        public int f6433q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f6434r;

        /* renamed from: s  reason: collision with root package name */
        public int f6435s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f6436t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f6437u;

        /* renamed from: v  reason: collision with root package name */
        public boolean f6438v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f6439w;

        /* renamed from: x  reason: collision with root package name */
        public boolean f6440x;

        /* renamed from: y  reason: collision with root package name */
        public boolean f6441y;

        /* renamed from: z  reason: collision with root package name */
        public int f6442z;

        public c(c cVar, h hVar, Resources resources) {
            Resources resources2;
            int i10;
            this.f6425i = false;
            this.f6428l = false;
            this.f6440x = true;
            this.A = 0;
            this.B = 0;
            this.f6417a = hVar;
            if (resources != null) {
                resources2 = resources;
            } else if (cVar != null) {
                resources2 = cVar.f6418b;
            } else {
                resources2 = null;
            }
            this.f6418b = resources2;
            if (cVar != null) {
                i10 = cVar.f6419c;
            } else {
                i10 = 0;
            }
            int f10 = h.f(resources, i10);
            this.f6419c = f10;
            if (cVar != null) {
                this.f6420d = cVar.f6420d;
                this.f6421e = cVar.f6421e;
                this.f6438v = true;
                this.f6439w = true;
                this.f6425i = cVar.f6425i;
                this.f6428l = cVar.f6428l;
                this.f6440x = cVar.f6440x;
                this.f6441y = cVar.f6441y;
                this.f6442z = cVar.f6442z;
                this.A = cVar.A;
                this.B = cVar.B;
                this.C = cVar.C;
                this.D = cVar.D;
                this.E = cVar.E;
                this.F = cVar.F;
                this.G = cVar.G;
                this.H = cVar.H;
                this.I = cVar.I;
                if (cVar.f6419c == f10) {
                    if (cVar.f6426j) {
                        this.f6427k = new Rect(cVar.f6427k);
                        this.f6426j = true;
                    }
                    if (cVar.f6429m) {
                        this.f6430n = cVar.f6430n;
                        this.f6431o = cVar.f6431o;
                        this.f6432p = cVar.f6432p;
                        this.f6433q = cVar.f6433q;
                        this.f6429m = true;
                    }
                }
                if (cVar.f6434r) {
                    this.f6435s = cVar.f6435s;
                    this.f6434r = true;
                }
                if (cVar.f6436t) {
                    this.f6437u = cVar.f6437u;
                    this.f6436t = true;
                }
                Drawable[] drawableArr = cVar.f6423g;
                this.f6423g = new Drawable[drawableArr.length];
                this.f6424h = cVar.f6424h;
                SparseArray sparseArray = cVar.f6422f;
                if (sparseArray != null) {
                    this.f6422f = sparseArray.clone();
                } else {
                    this.f6422f = new SparseArray(this.f6424h);
                }
                int i11 = this.f6424h;
                for (int i12 = 0; i12 < i11; i12++) {
                    Drawable drawable = drawableArr[i12];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f6422f.put(i12, constantState);
                        } else {
                            this.f6423g[i12] = drawableArr[i12];
                        }
                    }
                }
                return;
            }
            this.f6423g = new Drawable[10];
            this.f6424h = 0;
        }

        public final int a(Drawable drawable) {
            int i10 = this.f6424h;
            if (i10 >= this.f6423g.length) {
                o(i10, i10 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f6417a);
            this.f6423g[i10] = drawable;
            this.f6424h++;
            this.f6421e = drawable.getChangingConfigurations() | this.f6421e;
            p();
            this.f6427k = null;
            this.f6426j = false;
            this.f6429m = false;
            this.f6438v = false;
            return i10;
        }

        public final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i10 = this.f6424h;
                Drawable[] drawableArr = this.f6423g;
                for (int i11 = 0; i11 < i10; i11++) {
                    Drawable drawable = drawableArr[i11];
                    if (drawable != null && drawable.canApplyTheme()) {
                        drawableArr[i11].applyTheme(theme);
                        this.f6421e |= drawableArr[i11].getChangingConfigurations();
                    }
                }
                y(theme.getResources());
            }
        }

        public synchronized boolean c() {
            if (this.f6438v) {
                return this.f6439w;
            }
            e();
            this.f6438v = true;
            int i10 = this.f6424h;
            Drawable[] drawableArr = this.f6423g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getConstantState() == null) {
                    this.f6439w = false;
                    return false;
                }
            }
            this.f6439w = true;
            return true;
        }

        public boolean canApplyTheme() {
            int i10 = this.f6424h;
            Drawable[] drawableArr = this.f6423g;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f6422f.get(i11);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public void d() {
            this.f6429m = true;
            e();
            int i10 = this.f6424h;
            Drawable[] drawableArr = this.f6423g;
            this.f6431o = -1;
            this.f6430n = -1;
            this.f6433q = 0;
            this.f6432p = 0;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f6430n) {
                    this.f6430n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f6431o) {
                    this.f6431o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f6432p) {
                    this.f6432p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f6433q) {
                    this.f6433q = minimumHeight;
                }
            }
        }

        public final void e() {
            SparseArray sparseArray = this.f6422f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.f6423g[this.f6422f.keyAt(i10)] = s(((Drawable.ConstantState) this.f6422f.valueAt(i10)).newDrawable(this.f6418b));
                }
                this.f6422f = null;
            }
        }

        public final int f() {
            return this.f6423g.length;
        }

        public final Drawable g(int i10) {
            int indexOfKey;
            Drawable drawable = this.f6423g[i10];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f6422f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i10)) < 0) {
                return null;
            }
            Drawable s10 = s(((Drawable.ConstantState) this.f6422f.valueAt(indexOfKey)).newDrawable(this.f6418b));
            this.f6423g[i10] = s10;
            this.f6422f.removeAt(indexOfKey);
            if (this.f6422f.size() == 0) {
                this.f6422f = null;
            }
            return s10;
        }

        public int getChangingConfigurations() {
            return this.f6420d | this.f6421e;
        }

        public final int h() {
            return this.f6424h;
        }

        public final int i() {
            if (!this.f6429m) {
                d();
            }
            return this.f6431o;
        }

        public final int j() {
            if (!this.f6429m) {
                d();
            }
            return this.f6433q;
        }

        public final int k() {
            if (!this.f6429m) {
                d();
            }
            return this.f6432p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f6425i) {
                return null;
            }
            Rect rect2 = this.f6427k;
            if (rect2 != null || this.f6426j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i10 = this.f6424h;
            Drawable[] drawableArr = this.f6423g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i12 = rect3.left;
                    if (i12 > rect.left) {
                        rect.left = i12;
                    }
                    int i13 = rect3.top;
                    if (i13 > rect.top) {
                        rect.top = i13;
                    }
                    int i14 = rect3.right;
                    if (i14 > rect.right) {
                        rect.right = i14;
                    }
                    int i15 = rect3.bottom;
                    if (i15 > rect.bottom) {
                        rect.bottom = i15;
                    }
                }
            }
            this.f6426j = true;
            this.f6427k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f6429m) {
                d();
            }
            return this.f6430n;
        }

        public final int n() {
            int i10;
            if (this.f6434r) {
                return this.f6435s;
            }
            e();
            int i11 = this.f6424h;
            Drawable[] drawableArr = this.f6423g;
            if (i11 > 0) {
                i10 = drawableArr[0].getOpacity();
            } else {
                i10 = -2;
            }
            for (int i12 = 1; i12 < i11; i12++) {
                i10 = Drawable.resolveOpacity(i10, drawableArr[i12].getOpacity());
            }
            this.f6435s = i10;
            this.f6434r = true;
            return i10;
        }

        public void o(int i10, int i11) {
            Drawable[] drawableArr = new Drawable[i11];
            System.arraycopy(this.f6423g, 0, drawableArr, 0, i10);
            this.f6423g = drawableArr;
        }

        public void p() {
            this.f6434r = false;
            this.f6436t = false;
        }

        public final boolean q() {
            return this.f6428l;
        }

        public abstract void r();

        public final Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                boolean unused = drawable.setLayoutDirection(this.f6442z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f6417a);
            return mutate;
        }

        public final void t(boolean z10) {
            this.f6428l = z10;
        }

        public final void u(int i10) {
            this.A = i10;
        }

        public final void v(int i10) {
            this.B = i10;
        }

        public final boolean w(int i10, int i11) {
            boolean z10;
            int i12 = this.f6424h;
            Drawable[] drawableArr = this.f6423g;
            boolean z11 = false;
            for (int i13 = 0; i13 < i12; i13++) {
                Drawable drawable = drawableArr[i13];
                if (drawable != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        z10 = drawable.setLayoutDirection(i10);
                    } else {
                        z10 = false;
                    }
                    if (i13 == i11) {
                        z11 = z10;
                    }
                }
            }
            this.f6442z = i10;
            return z11;
        }

        public final void x(boolean z10) {
            this.f6425i = z10;
        }

        public final void y(Resources resources) {
            if (resources != null) {
                this.f6418b = resources;
                int f10 = h.f(resources, this.f6419c);
                int i10 = this.f6419c;
                this.f6419c = f10;
                if (i10 != f10) {
                    this.f6429m = false;
                    this.f6426j = false;
                }
            }
        }
    }

    public static int f(Resources resources, int i10) {
        if (resources != null) {
            i10 = resources.getDisplayMetrics().densityDpi;
        }
        if (i10 == 0) {
            return 160;
        }
        return i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f6407f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f6404c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L_0x0038
            long r9 = r13.f6412k
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x003a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.f6406e
            r3.setAlpha(r9)
            r13.f6412k = r6
            goto L_0x003a
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            e.h$c r9 = r13.f6402a
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f6406e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L_0x003b
        L_0x0038:
            r13.f6412k = r6
        L_0x003a:
            r3 = 0
        L_0x003b:
            android.graphics.drawable.Drawable r9 = r13.f6405d
            if (r9 == 0) goto L_0x0068
            long r10 = r13.f6413l
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x006a
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0055
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f6405d = r0
            r0 = -1
            r13.f6409h = r0
            r13.f6413l = r6
            goto L_0x006a
        L_0x0055:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            e.h$c r4 = r13.f6402a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f6406e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x006b
        L_0x0068:
            r13.f6413l = r6
        L_0x006a:
            r0 = r3
        L_0x006b:
            if (r14 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0077
            java.lang.Runnable r14 = r13.f6411j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.h.a(boolean):void");
    }

    public void applyTheme(Resources.Theme theme) {
        this.f6402a.b(theme);
    }

    public abstract c b();

    public int c() {
        return this.f6408g;
    }

    public boolean canApplyTheme() {
        return this.f6402a.canApplyTheme();
    }

    public final void d(Drawable drawable) {
        if (this.f6414m == null) {
            this.f6414m = new b();
        }
        drawable.setCallback(this.f6414m.b(drawable.getCallback()));
        try {
            if (this.f6402a.A <= 0 && this.f6407f) {
                drawable.setAlpha(this.f6406e);
            }
            c cVar = this.f6402a;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    s.h.o(drawable, cVar.F);
                }
                c cVar2 = this.f6402a;
                if (cVar2.I) {
                    s.h.p(drawable, cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f6402a.f6440x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                boolean unused = drawable.setLayoutDirection(getLayoutDirection());
            }
            drawable.setAutoMirrored(this.f6402a.C);
            Rect rect = this.f6403b;
            if (i10 >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f6414m.a());
        }
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f6404c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f6405d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final boolean e() {
        if (!isAutoMirrored() || s.h.f(this) != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(int r9) {
        /*
            r8 = this;
            int r0 = r8.f6408g
            r1 = 0
            if (r9 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            e.h$c r0 = r8.f6402a
            int r0 = r0.B
            r4 = -1
            r5 = 0
            r6 = 0
            if (r0 <= 0) goto L_0x0035
            android.graphics.drawable.Drawable r0 = r8.f6405d
            if (r0 == 0) goto L_0x001b
            r0.setVisible(r1, r1)
        L_0x001b:
            android.graphics.drawable.Drawable r0 = r8.f6404c
            if (r0 == 0) goto L_0x002e
            r8.f6405d = r0
            int r0 = r8.f6408g
            r8.f6409h = r0
            e.h$c r0 = r8.f6402a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r8.f6413l = r0
            goto L_0x003c
        L_0x002e:
            r8.f6405d = r5
            r8.f6409h = r4
            r8.f6413l = r6
            goto L_0x003c
        L_0x0035:
            android.graphics.drawable.Drawable r0 = r8.f6404c
            if (r0 == 0) goto L_0x003c
            r0.setVisible(r1, r1)
        L_0x003c:
            if (r9 < 0) goto L_0x005c
            e.h$c r0 = r8.f6402a
            int r1 = r0.f6424h
            if (r9 >= r1) goto L_0x005c
            android.graphics.drawable.Drawable r0 = r0.g(r9)
            r8.f6404c = r0
            r8.f6408g = r9
            if (r0 == 0) goto L_0x0060
            e.h$c r9 = r8.f6402a
            int r9 = r9.A
            if (r9 <= 0) goto L_0x0058
            long r4 = (long) r9
            long r2 = r2 + r4
            r8.f6412k = r2
        L_0x0058:
            r8.d(r0)
            goto L_0x0060
        L_0x005c:
            r8.f6404c = r5
            r8.f6408g = r4
        L_0x0060:
            long r0 = r8.f6412k
            r9 = 1
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x006d
            long r0 = r8.f6413l
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x007f
        L_0x006d:
            java.lang.Runnable r0 = r8.f6411j
            if (r0 != 0) goto L_0x0079
            e.h$a r0 = new e.h$a
            r0.<init>()
            r8.f6411j = r0
            goto L_0x007c
        L_0x0079:
            r8.unscheduleSelf(r0)
        L_0x007c:
            r8.a(r9)
        L_0x007f:
            r8.invalidateSelf()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.h.g(int):boolean");
    }

    public int getAlpha() {
        return this.f6406e;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f6402a.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f6402a.c()) {
            return null;
        }
        this.f6402a.f6420d = getChangingConfigurations();
        return this.f6402a;
    }

    public Drawable getCurrent() {
        return this.f6404c;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f6403b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f6402a.q()) {
            return this.f6402a.i();
        }
        Drawable drawable = this.f6404c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f6402a.q()) {
            return this.f6402a.m();
        }
        Drawable drawable = this.f6404c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f6402a.q()) {
            return this.f6402a.j();
        }
        Drawable drawable = this.f6404c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f6402a.q()) {
            return this.f6402a.k();
        }
        Drawable drawable = this.f6404c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f6404c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f6402a.n();
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f6404c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z10;
        Rect l10 = this.f6402a.l();
        if (l10 != null) {
            rect.set(l10);
            if ((l10.right | l10.left | l10.top | l10.bottom) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            Drawable drawable = this.f6404c;
            if (drawable != null) {
                z10 = drawable.getPadding(rect);
            } else {
                z10 = super.getPadding(rect);
            }
        }
        if (e()) {
            int i10 = rect.left;
            rect.left = rect.right;
            rect.right = i10;
        }
        return z10;
    }

    public void h(c cVar) {
        this.f6402a = cVar;
        int i10 = this.f6408g;
        if (i10 >= 0) {
            Drawable g10 = cVar.g(i10);
            this.f6404c = g10;
            if (g10 != null) {
                d(g10);
            }
        }
        this.f6409h = -1;
        this.f6405d = null;
    }

    public final void i(Resources resources) {
        this.f6402a.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f6402a;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable == this.f6404c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f6402a.C;
    }

    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.f6405d;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f6405d = null;
            this.f6409h = -1;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f6404c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f6407f) {
                this.f6404c.setAlpha(this.f6406e);
            }
        }
        if (this.f6413l != 0) {
            this.f6413l = 0;
            z10 = true;
        }
        if (this.f6412k != 0) {
            this.f6412k = 0;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f6410i && super.mutate() == this) {
            c b10 = b();
            b10.r();
            h(b10);
            this.f6410i = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f6405d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f6404c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i10) {
        return this.f6402a.w(i10, c());
    }

    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f6405d;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.f6404c;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        if (drawable == this.f6404c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j10);
        }
    }

    public void setAlpha(int i10) {
        if (!this.f6407f || this.f6406e != i10) {
            this.f6407f = true;
            this.f6406e = i10;
            Drawable drawable = this.f6404c;
            if (drawable == null) {
                return;
            }
            if (this.f6412k == 0) {
                drawable.setAlpha(i10);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z10) {
        c cVar = this.f6402a;
        if (cVar.C != z10) {
            cVar.C = z10;
            Drawable drawable = this.f6404c;
            if (drawable != null) {
                s.h.j(drawable, z10);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f6402a;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f6404c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z10) {
        c cVar = this.f6402a;
        if (cVar.f6440x != z10) {
            cVar.f6440x = z10;
            Drawable drawable = this.f6404c;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    public void setHotspot(float f10, float f11) {
        Drawable drawable = this.f6404c;
        if (drawable != null) {
            s.h.k(drawable, f10, f11);
        }
    }

    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f6403b;
        if (rect == null) {
            this.f6403b = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.f6404c;
        if (drawable != null) {
            s.h.l(drawable, i10, i11, i12, i13);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f6402a;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            s.h.o(this.f6404c, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f6402a;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            s.h.p(this.f6404c, mode);
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f6405d;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f6404c;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f6404c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
