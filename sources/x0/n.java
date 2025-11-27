package x0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.upnp.UPnP;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import r.d;

public class n extends m {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f9586k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    public h f9587b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffColorFilter f9588c;

    /* renamed from: d  reason: collision with root package name */
    public ColorFilter f9589d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9590e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9591f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable.ConstantState f9592g;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f9593h;

    /* renamed from: i  reason: collision with root package name */
    public final Matrix f9594i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f9595j;

    public static class b extends f {
        public b() {
        }

        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (q.i.j(xmlPullParser, "pathData")) {
                TypedArray k10 = q.i.k(resources, theme, attributeSet, a.f9559d);
                f(k10, xmlPullParser);
                k10.recycle();
            }
        }

        public final void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f9622b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f9621a = r.d.d(string2);
            }
            this.f9623c = q.i.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    public static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f9642a;

        /* renamed from: b  reason: collision with root package name */
        public g f9643b;

        /* renamed from: c  reason: collision with root package name */
        public ColorStateList f9644c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f9645d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9646e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f9647f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f9648g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f9649h;

        /* renamed from: i  reason: collision with root package name */
        public int f9650i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f9651j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f9652k;

        /* renamed from: l  reason: collision with root package name */
        public Paint f9653l;

        public h(h hVar) {
            this.f9644c = null;
            this.f9645d = n.f9586k;
            if (hVar != null) {
                this.f9642a = hVar.f9642a;
                g gVar = new g(hVar.f9643b);
                this.f9643b = gVar;
                if (hVar.f9643b.f9630e != null) {
                    gVar.f9630e = new Paint(hVar.f9643b.f9630e);
                }
                if (hVar.f9643b.f9629d != null) {
                    this.f9643b.f9629d = new Paint(hVar.f9643b.f9629d);
                }
                this.f9644c = hVar.f9644c;
                this.f9645d = hVar.f9645d;
                this.f9646e = hVar.f9646e;
            }
        }

        public boolean a(int i10, int i11) {
            if (i10 == this.f9647f.getWidth() && i11 == this.f9647f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.f9652k && this.f9648g == this.f9644c && this.f9649h == this.f9645d && this.f9651j == this.f9646e && this.f9650i == this.f9643b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void c(int i10, int i11) {
            if (this.f9647f == null || !a(i10, i11)) {
                this.f9647f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f9652k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f9647f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f9653l == null) {
                Paint paint = new Paint();
                this.f9653l = paint;
                paint.setFilterBitmap(true);
            }
            this.f9653l.setAlpha(this.f9643b.getRootAlpha());
            this.f9653l.setColorFilter(colorFilter);
            return this.f9653l;
        }

        public boolean f() {
            if (this.f9643b.getRootAlpha() < 255) {
                return true;
            }
            return false;
        }

        public boolean g() {
            return this.f9643b.f();
        }

        public int getChangingConfigurations() {
            return this.f9642a;
        }

        public boolean h(int[] iArr) {
            boolean g10 = this.f9643b.g(iArr);
            this.f9652k |= g10;
            return g10;
        }

        public void i() {
            this.f9648g = this.f9644c;
            this.f9649h = this.f9645d;
            this.f9650i = this.f9643b.getRootAlpha();
            this.f9651j = this.f9646e;
            this.f9652k = false;
        }

        public void j(int i10, int i11) {
            this.f9647f.eraseColor(0);
            this.f9643b.b(new Canvas(this.f9647f), i10, i11, (ColorFilter) null);
        }

        public Drawable newDrawable() {
            return new n(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new n(this);
        }

        public h() {
            this.f9644c = null;
            this.f9645d = n.f9586k;
            this.f9643b = new g();
        }
    }

    public n() {
        this.f9591f = true;
        this.f9593h = new float[9];
        this.f9594i = new Matrix();
        this.f9595j = new Rect();
        this.f9587b = new h();
    }

    public static int a(int i10, float f10) {
        return (i10 & UPnP.CONFIGID_UPNP_ORG_MAX) | (((int) (((float) Color.alpha(i10)) * f10)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static x0.n b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            x0.n r0 = new x0.n
            r0.<init>()
            android.graphics.drawable.Drawable r6 = q.h.d(r6, r7, r8)
            r0.f9585a = r6
            x0.n$i r6 = new x0.n$i
            android.graphics.drawable.Drawable r7 = r0.f9585a
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.f9592g = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x003d
            x0.n r6 = c(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            return r6
        L_0x003d:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            throw r6     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.n.b(android.content.res.Resources, int, android.content.res.Resources$Theme):x0.n");
    }

    public static n c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        n nVar = new n();
        nVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return nVar;
    }

    public static PorterDuff.Mode g(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f9585a;
        if (drawable == null) {
            return false;
        }
        s.h.b(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public Object d(String str) {
        return this.f9587b.f9643b.f9641p.get(str);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f9595j);
        if (this.f9595j.width() > 0 && this.f9595j.height() > 0) {
            ColorFilter colorFilter = this.f9589d;
            if (colorFilter == null) {
                colorFilter = this.f9588c;
            }
            canvas.getMatrix(this.f9594i);
            this.f9594i.getValues(this.f9593h);
            float abs = Math.abs(this.f9593h[0]);
            float abs2 = Math.abs(this.f9593h[4]);
            float abs3 = Math.abs(this.f9593h[1]);
            float abs4 = Math.abs(this.f9593h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f9595j.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f9595j.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f9595j;
                canvas.translate((float) rect.left, (float) rect.top);
                if (f()) {
                    canvas.translate((float) this.f9595j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f9595j.offsetTo(0, 0);
                this.f9587b.c(min, min2);
                if (!this.f9591f) {
                    this.f9587b.j(min, min2);
                } else if (!this.f9587b.b()) {
                    this.f9587b.j(min, min2);
                    this.f9587b.i();
                }
                this.f9587b.d(canvas, colorFilter, this.f9595j);
                canvas.restoreToCount(save);
            }
        }
    }

    public final void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = this.f9587b;
        g gVar = hVar.f9643b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f9633h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f9609b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f9641p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f9642a = cVar.f9624d | hVar.f9642a;
                    z10 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f9609b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f9641p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f9642a = bVar.f9624d | hVar.f9642a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f9609b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f9641p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f9642a = dVar2.f9618k | hVar.f9642a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public final boolean f() {
        if (!isAutoMirrored() || s.h.f(this) != 1) {
            return false;
        }
        return true;
    }

    public int getAlpha() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return s.h.d(drawable);
        }
        return this.f9587b.f9643b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f9587b.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return s.h.e(drawable);
        }
        return this.f9589d;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f9585a != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f9585a.getConstantState());
        }
        this.f9587b.f9642a = getChangingConfigurations();
        return this.f9587b;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f9587b.f9643b.f9635j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f9587b.f9643b.f9634i;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void h(boolean z10) {
        this.f9591f = z10;
    }

    public final void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        h hVar = this.f9587b;
        g gVar = hVar.f9643b;
        hVar.f9645d = g(q.i.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c10 = q.i.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c10 != null) {
            hVar.f9644c = c10;
        }
        hVar.f9646e = q.i.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f9646e);
        gVar.f9636k = q.i.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f9636k);
        float f10 = q.i.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f9637l);
        gVar.f9637l = f10;
        if (gVar.f9636k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f10 > 0.0f) {
            gVar.f9634i = typedArray.getDimension(3, gVar.f9634i);
            float dimension = typedArray.getDimension(2, gVar.f9635j);
            gVar.f9635j = dimension;
            if (gVar.f9634i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(q.i.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.f9639n = string;
                    gVar.f9641p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return s.h.h(drawable);
        }
        return this.f9587b.f9646e;
    }

    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful() || ((hVar = this.f9587b) != null && (hVar.g() || ((colorStateList = this.f9587b.f9644c) != null && colorStateList.isStateful())))) {
            return true;
        }
        return false;
    }

    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f9590e && super.mutate() == this) {
            this.f9587b = new h(this.f9587b);
            this.f9590e = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f9587b;
        ColorStateList colorStateList = hVar.f9644c;
        if (colorStateList == null || (mode = hVar.f9645d) == null) {
            z10 = false;
        } else {
            this.f9588c = j(this.f9588c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    public void setAlpha(int i10) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f9587b.f9643b.getRootAlpha() != i10) {
            this.f9587b.f9643b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            s.h.j(drawable, z10);
        } else {
            this.f9587b.f9646e = z10;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i10) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            s.h.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            s.h.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f9587b;
        if (hVar.f9644c != colorStateList) {
            hVar.f9644c = colorStateList;
            this.f9588c = j(this.f9588c, colorStateList, hVar.f9645d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            s.h.p(drawable, mode);
            return;
        }
        h hVar = this.f9587b;
        if (hVar.f9645d != mode) {
            hVar.f9645d = mode;
            this.f9588c = j(this.f9588c, hVar.f9644c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        return super.setVisible(z10, z11);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f9654a;

        public i(Drawable.ConstantState constantState) {
            this.f9654a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f9654a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f9654a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            n nVar = new n();
            nVar.f9585a = o.a(this.f9654a.newDrawable());
            return nVar;
        }

        public Drawable newDrawable(Resources resources) {
            n nVar = new n();
            nVar.f9585a = o.a(this.f9654a.newDrawable(resources));
            return nVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            n nVar = new n();
            nVar.f9585a = o.a(this.f9654a.newDrawable(resources, theme));
            return nVar;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f9589d = colorFilter;
        invalidateSelf();
    }

    public static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        public d.b[] f9621a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f9622b;

        /* renamed from: c  reason: collision with root package name */
        public int f9623c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f9624d;

        public f() {
            super();
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            d.b[] bVarArr = this.f9621a;
            if (bVarArr != null) {
                d.b.e(bVarArr, path);
            }
        }

        public d.b[] getPathData() {
            return this.f9621a;
        }

        public String getPathName() {
            return this.f9622b;
        }

        public void setPathData(d.b[] bVarArr) {
            if (!r.d.b(this.f9621a, bVarArr)) {
                this.f9621a = r.d.f(bVarArr);
            } else {
                r.d.j(this.f9621a, bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f9622b = fVar.f9622b;
            this.f9624d = fVar.f9624d;
            this.f9621a = r.d.f(fVar.f9621a);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            s.h.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f9587b;
        hVar.f9643b = new g();
        TypedArray k10 = q.i.k(resources, theme, attributeSet, a.f9556a);
        i(k10, xmlPullParser, theme);
        k10.recycle();
        hVar.f9642a = getChangingConfigurations();
        hVar.f9652k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f9588c = j(this.f9588c, hVar.f9644c, hVar.f9645d);
    }

    public n(h hVar) {
        this.f9591f = true;
        this.f9593h = new float[9];
        this.f9594i = new Matrix();
        this.f9595j = new Rect();
        this.f9587b = hVar;
        this.f9588c = j(this.f9588c, hVar.f9644c, hVar.f9645d);
    }

    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        public int[] f9596e;

        /* renamed from: f  reason: collision with root package name */
        public q.b f9597f;

        /* renamed from: g  reason: collision with root package name */
        public float f9598g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public q.b f9599h;

        /* renamed from: i  reason: collision with root package name */
        public float f9600i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f9601j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f9602k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f9603l = 1.0f;

        /* renamed from: m  reason: collision with root package name */
        public float f9604m = 0.0f;

        /* renamed from: n  reason: collision with root package name */
        public Paint.Cap f9605n = Paint.Cap.BUTT;

        /* renamed from: o  reason: collision with root package name */
        public Paint.Join f9606o = Paint.Join.MITER;

        /* renamed from: p  reason: collision with root package name */
        public float f9607p = 4.0f;

        public c() {
        }

        public boolean a() {
            if (this.f9599h.i() || this.f9597f.i()) {
                return true;
            }
            return false;
        }

        public boolean b(int[] iArr) {
            return this.f9597f.j(iArr) | this.f9599h.j(iArr);
        }

        public final Paint.Cap e(int i10, Paint.Cap cap) {
            if (i10 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i10 == 1) {
                return Paint.Cap.ROUND;
            }
            if (i10 != 2) {
                return cap;
            }
            return Paint.Cap.SQUARE;
        }

        public final Paint.Join f(int i10, Paint.Join join) {
            if (i10 == 0) {
                return Paint.Join.MITER;
            }
            if (i10 == 1) {
                return Paint.Join.ROUND;
            }
            if (i10 != 2) {
                return join;
            }
            return Paint.Join.BEVEL;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = q.i.k(resources, theme, attributeSet, a.f9558c);
            h(k10, xmlPullParser, theme);
            k10.recycle();
        }

        public float getFillAlpha() {
            return this.f9601j;
        }

        public int getFillColor() {
            return this.f9599h.e();
        }

        public float getStrokeAlpha() {
            return this.f9600i;
        }

        public int getStrokeColor() {
            return this.f9597f.e();
        }

        public float getStrokeWidth() {
            return this.f9598g;
        }

        public float getTrimPathEnd() {
            return this.f9603l;
        }

        public float getTrimPathOffset() {
            return this.f9604m;
        }

        public float getTrimPathStart() {
            return this.f9602k;
        }

        public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f9596e = null;
            if (q.i.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f9622b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f9621a = r.d.d(string2);
                }
                Resources.Theme theme2 = theme;
                this.f9599h = q.i.e(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f9601j = q.i.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f9601j);
                this.f9605n = e(q.i.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f9605n);
                this.f9606o = f(q.i.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f9606o);
                this.f9607p = q.i.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f9607p);
                this.f9597f = q.i.e(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f9600i = q.i.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f9600i);
                this.f9598g = q.i.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f9598g);
                this.f9603l = q.i.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f9603l);
                this.f9604m = q.i.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f9604m);
                this.f9602k = q.i.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f9602k);
                this.f9623c = q.i.g(typedArray, xmlPullParser, "fillType", 13, this.f9623c);
            }
        }

        public void setFillAlpha(float f10) {
            this.f9601j = f10;
        }

        public void setFillColor(int i10) {
            this.f9599h.k(i10);
        }

        public void setStrokeAlpha(float f10) {
            this.f9600i = f10;
        }

        public void setStrokeColor(int i10) {
            this.f9597f.k(i10);
        }

        public void setStrokeWidth(float f10) {
            this.f9598g = f10;
        }

        public void setTrimPathEnd(float f10) {
            this.f9603l = f10;
        }

        public void setTrimPathOffset(float f10) {
            this.f9604m = f10;
        }

        public void setTrimPathStart(float f10) {
            this.f9602k = f10;
        }

        public c(c cVar) {
            super(cVar);
            this.f9596e = cVar.f9596e;
            this.f9597f = cVar.f9597f;
            this.f9598g = cVar.f9598g;
            this.f9600i = cVar.f9600i;
            this.f9599h = cVar.f9599h;
            this.f9623c = cVar.f9623c;
            this.f9601j = cVar.f9601j;
            this.f9602k = cVar.f9602k;
            this.f9603l = cVar.f9603l;
            this.f9604m = cVar.f9604m;
            this.f9605n = cVar.f9605n;
            this.f9606o = cVar.f9606o;
            this.f9607p = cVar.f9607p;
        }
    }

    public static class g {

        /* renamed from: q  reason: collision with root package name */
        public static final Matrix f9625q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        public final Path f9626a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f9627b;

        /* renamed from: c  reason: collision with root package name */
        public final Matrix f9628c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f9629d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f9630e;

        /* renamed from: f  reason: collision with root package name */
        public PathMeasure f9631f;

        /* renamed from: g  reason: collision with root package name */
        public int f9632g;

        /* renamed from: h  reason: collision with root package name */
        public final d f9633h;

        /* renamed from: i  reason: collision with root package name */
        public float f9634i;

        /* renamed from: j  reason: collision with root package name */
        public float f9635j;

        /* renamed from: k  reason: collision with root package name */
        public float f9636k;

        /* renamed from: l  reason: collision with root package name */
        public float f9637l;

        /* renamed from: m  reason: collision with root package name */
        public int f9638m;

        /* renamed from: n  reason: collision with root package name */
        public String f9639n;

        /* renamed from: o  reason: collision with root package name */
        public Boolean f9640o;

        /* renamed from: p  reason: collision with root package name */
        public final androidx.collection.a f9641p;

        public g() {
            this.f9628c = new Matrix();
            this.f9634i = 0.0f;
            this.f9635j = 0.0f;
            this.f9636k = 0.0f;
            this.f9637l = 0.0f;
            this.f9638m = 255;
            this.f9639n = null;
            this.f9640o = null;
            this.f9641p = new androidx.collection.a();
            this.f9633h = new d();
            this.f9626a = new Path();
            this.f9627b = new Path();
        }

        public static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f9633h, f9625q, canvas, i10, i11, colorFilter);
        }

        public final void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f9608a.set(matrix);
            dVar.f9608a.preConcat(dVar.f9617j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f9609b.size(); i12++) {
                e eVar = (e) dVar.f9609b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f9608a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        public final void d(d dVar, f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f10 = ((float) i10) / this.f9636k;
            float f11 = ((float) i11) / this.f9637l;
            float min = Math.min(f10, f11);
            Matrix matrix = dVar.f9608a;
            this.f9628c.set(matrix);
            this.f9628c.postScale(f10, f11);
            float e10 = e(matrix);
            if (e10 != 0.0f) {
                fVar.d(this.f9626a);
                Path path = this.f9626a;
                this.f9627b.reset();
                if (fVar.c()) {
                    Path path2 = this.f9627b;
                    if (fVar.f9623c == 0) {
                        fillType2 = Path.FillType.WINDING;
                    } else {
                        fillType2 = Path.FillType.EVEN_ODD;
                    }
                    path2.setFillType(fillType2);
                    this.f9627b.addPath(path, this.f9628c);
                    canvas.clipPath(this.f9627b);
                    return;
                }
                c cVar = (c) fVar;
                float f12 = cVar.f9602k;
                if (!(f12 == 0.0f && cVar.f9603l == 1.0f)) {
                    float f13 = cVar.f9604m;
                    float f14 = (f12 + f13) % 1.0f;
                    float f15 = (cVar.f9603l + f13) % 1.0f;
                    if (this.f9631f == null) {
                        this.f9631f = new PathMeasure();
                    }
                    this.f9631f.setPath(this.f9626a, false);
                    float length = this.f9631f.getLength();
                    float f16 = f14 * length;
                    float f17 = f15 * length;
                    path.reset();
                    if (f16 > f17) {
                        this.f9631f.getSegment(f16, length, path, true);
                        this.f9631f.getSegment(0.0f, f17, path, true);
                    } else {
                        this.f9631f.getSegment(f16, f17, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f9627b.addPath(path, this.f9628c);
                if (cVar.f9599h.l()) {
                    q.b bVar = cVar.f9599h;
                    if (this.f9630e == null) {
                        Paint paint = new Paint(1);
                        this.f9630e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f9630e;
                    if (bVar.h()) {
                        Shader f18 = bVar.f();
                        f18.setLocalMatrix(this.f9628c);
                        paint2.setShader(f18);
                        paint2.setAlpha(Math.round(cVar.f9601j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(n.a(bVar.e(), cVar.f9601j));
                    }
                    paint2.setColorFilter(colorFilter);
                    Path path3 = this.f9627b;
                    if (cVar.f9623c == 0) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    path3.setFillType(fillType);
                    canvas.drawPath(this.f9627b, paint2);
                }
                if (cVar.f9597f.l()) {
                    q.b bVar2 = cVar.f9597f;
                    if (this.f9629d == null) {
                        Paint paint3 = new Paint(1);
                        this.f9629d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f9629d;
                    Paint.Join join = cVar.f9606o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.f9605n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.f9607p);
                    if (bVar2.h()) {
                        Shader f19 = bVar2.f();
                        f19.setLocalMatrix(this.f9628c);
                        paint4.setShader(f19);
                        paint4.setAlpha(Math.round(cVar.f9600i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(n.a(bVar2.e(), cVar.f9600i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f9598g * min * e10);
                    canvas.drawPath(this.f9627b, paint4);
                }
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a10 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a10) / max;
            }
            return 0.0f;
        }

        public boolean f() {
            if (this.f9640o == null) {
                this.f9640o = Boolean.valueOf(this.f9633h.a());
            }
            return this.f9640o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f9633h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f9638m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f9638m = i10;
        }

        public g(g gVar) {
            this.f9628c = new Matrix();
            this.f9634i = 0.0f;
            this.f9635j = 0.0f;
            this.f9636k = 0.0f;
            this.f9637l = 0.0f;
            this.f9638m = 255;
            this.f9639n = null;
            this.f9640o = null;
            androidx.collection.a aVar = new androidx.collection.a();
            this.f9641p = aVar;
            this.f9633h = new d(gVar.f9633h, aVar);
            this.f9626a = new Path(gVar.f9626a);
            this.f9627b = new Path(gVar.f9627b);
            this.f9634i = gVar.f9634i;
            this.f9635j = gVar.f9635j;
            this.f9636k = gVar.f9636k;
            this.f9637l = gVar.f9637l;
            this.f9632g = gVar.f9632g;
            this.f9638m = gVar.f9638m;
            this.f9639n = gVar.f9639n;
            String str = gVar.f9639n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f9640o = gVar.f9640o;
        }
    }

    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f9608a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList f9609b;

        /* renamed from: c  reason: collision with root package name */
        public float f9610c;

        /* renamed from: d  reason: collision with root package name */
        public float f9611d;

        /* renamed from: e  reason: collision with root package name */
        public float f9612e;

        /* renamed from: f  reason: collision with root package name */
        public float f9613f;

        /* renamed from: g  reason: collision with root package name */
        public float f9614g;

        /* renamed from: h  reason: collision with root package name */
        public float f9615h;

        /* renamed from: i  reason: collision with root package name */
        public float f9616i;

        /* renamed from: j  reason: collision with root package name */
        public final Matrix f9617j;

        /* renamed from: k  reason: collision with root package name */
        public int f9618k;

        /* renamed from: l  reason: collision with root package name */
        public int[] f9619l;

        /* renamed from: m  reason: collision with root package name */
        public String f9620m;

        public d(d dVar, androidx.collection.a aVar) {
            super();
            f fVar;
            this.f9608a = new Matrix();
            this.f9609b = new ArrayList();
            this.f9610c = 0.0f;
            this.f9611d = 0.0f;
            this.f9612e = 0.0f;
            this.f9613f = 1.0f;
            this.f9614g = 1.0f;
            this.f9615h = 0.0f;
            this.f9616i = 0.0f;
            Matrix matrix = new Matrix();
            this.f9617j = matrix;
            this.f9620m = null;
            this.f9610c = dVar.f9610c;
            this.f9611d = dVar.f9611d;
            this.f9612e = dVar.f9612e;
            this.f9613f = dVar.f9613f;
            this.f9614g = dVar.f9614g;
            this.f9615h = dVar.f9615h;
            this.f9616i = dVar.f9616i;
            this.f9619l = dVar.f9619l;
            String str = dVar.f9620m;
            this.f9620m = str;
            this.f9618k = dVar.f9618k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f9617j);
            ArrayList arrayList = dVar.f9609b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                Object obj = arrayList.get(i10);
                if (obj instanceof d) {
                    this.f9609b.add(new d((d) obj, aVar));
                } else {
                    if (obj instanceof c) {
                        fVar = new c((c) obj);
                    } else if (obj instanceof b) {
                        fVar = new b((b) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f9609b.add(fVar);
                    String str2 = fVar.f9622b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        public boolean a() {
            for (int i10 = 0; i10 < this.f9609b.size(); i10++) {
                if (((e) this.f9609b.get(i10)).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f9609b.size(); i10++) {
                z10 |= ((e) this.f9609b.get(i10)).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = q.i.k(resources, theme, attributeSet, a.f9557b);
            e(k10, xmlPullParser);
            k10.recycle();
        }

        public final void d() {
            this.f9617j.reset();
            this.f9617j.postTranslate(-this.f9611d, -this.f9612e);
            this.f9617j.postScale(this.f9613f, this.f9614g);
            this.f9617j.postRotate(this.f9610c, 0.0f, 0.0f);
            this.f9617j.postTranslate(this.f9615h + this.f9611d, this.f9616i + this.f9612e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f9619l = null;
            this.f9610c = q.i.f(typedArray, xmlPullParser, ParamsMap.MirrorParams.KEY_ROTATION, 5, this.f9610c);
            this.f9611d = typedArray.getFloat(1, this.f9611d);
            this.f9612e = typedArray.getFloat(2, this.f9612e);
            this.f9613f = q.i.f(typedArray, xmlPullParser, "scaleX", 3, this.f9613f);
            this.f9614g = q.i.f(typedArray, xmlPullParser, "scaleY", 4, this.f9614g);
            this.f9615h = q.i.f(typedArray, xmlPullParser, "translateX", 6, this.f9615h);
            this.f9616i = q.i.f(typedArray, xmlPullParser, "translateY", 7, this.f9616i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f9620m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.f9620m;
        }

        public Matrix getLocalMatrix() {
            return this.f9617j;
        }

        public float getPivotX() {
            return this.f9611d;
        }

        public float getPivotY() {
            return this.f9612e;
        }

        public float getRotation() {
            return this.f9610c;
        }

        public float getScaleX() {
            return this.f9613f;
        }

        public float getScaleY() {
            return this.f9614g;
        }

        public float getTranslateX() {
            return this.f9615h;
        }

        public float getTranslateY() {
            return this.f9616i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f9611d) {
                this.f9611d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f9612e) {
                this.f9612e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f9610c) {
                this.f9610c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f9613f) {
                this.f9613f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f9614g) {
                this.f9614g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f9615h) {
                this.f9615h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f9616i) {
                this.f9616i = f10;
                d();
            }
        }

        public d() {
            super();
            this.f9608a = new Matrix();
            this.f9609b = new ArrayList();
            this.f9610c = 0.0f;
            this.f9611d = 0.0f;
            this.f9612e = 0.0f;
            this.f9613f = 1.0f;
            this.f9614g = 1.0f;
            this.f9615h = 0.0f;
            this.f9616i = 0.0f;
            this.f9617j = new Matrix();
            this.f9620m = null;
        }
    }
}
