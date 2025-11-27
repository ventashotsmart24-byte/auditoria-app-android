package e;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.e2;
import androidx.collection.h;
import com.hpplay.component.protocol.PlistBuilder;
import e.h;
import e.n;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import q.i;
import s.w;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class c extends n implements w {

    /* renamed from: p  reason: collision with root package name */
    public C0079c f6390p;

    /* renamed from: q  reason: collision with root package name */
    public g f6391q;

    /* renamed from: r  reason: collision with root package name */
    public int f6392r;

    /* renamed from: s  reason: collision with root package name */
    public int f6393s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6394t;

    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final Animatable f6395a;

        public b(Animatable animatable) {
            super();
            this.f6395a = animatable;
        }

        public void c() {
            this.f6395a.start();
        }

        public void d() {
            this.f6395a.stop();
        }
    }

    /* renamed from: e.c$c  reason: collision with other inner class name */
    public static class C0079c extends n.a {
        public androidx.collection.d K;
        public h L;

        public C0079c(C0079c cVar, c cVar2, Resources resources) {
            super(cVar, cVar2, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new androidx.collection.d();
            this.L = new h();
        }

        public static long D(int i10, int i11) {
            return ((long) i11) | (((long) i10) << 32);
        }

        public int B(int[] iArr, Drawable drawable, int i10) {
            int z10 = super.z(iArr, drawable);
            this.L.i(z10, Integer.valueOf(i10));
            return z10;
        }

        public int C(int i10, int i11, Drawable drawable, boolean z10) {
            long j10;
            int a10 = super.a(drawable);
            long D = D(i10, i11);
            if (z10) {
                j10 = IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            } else {
                j10 = 0;
            }
            long j11 = (long) a10;
            this.K.a(D, Long.valueOf(j11 | j10));
            if (z10) {
                this.K.a(D(i11, i10), Long.valueOf(IjkMediaMeta.AV_CH_WIDE_RIGHT | j11 | j10));
            }
            return a10;
        }

        public int E(int i10) {
            if (i10 < 0) {
                return 0;
            }
            return ((Integer) this.L.f(i10, 0)).intValue();
        }

        public int F(int[] iArr) {
            int A = super.A(iArr);
            if (A >= 0) {
                return A;
            }
            return super.A(StateSet.WILD_CARD);
        }

        public int G(int i10, int i11) {
            return (int) ((Long) this.K.g(D(i10, i11), -1L)).longValue();
        }

        public boolean H(int i10, int i11) {
            if ((((Long) this.K.g(D(i10, i11), -1L)).longValue() & IjkMediaMeta.AV_CH_WIDE_RIGHT) != 0) {
                return true;
            }
            return false;
        }

        public boolean I(int i10, int i11) {
            if ((((Long) this.K.g(D(i10, i11), -1L)).longValue() & IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) != 0) {
                return true;
            }
            return false;
        }

        public Drawable newDrawable() {
            return new c(this, (Resources) null);
        }

        public void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public Drawable newDrawable(Resources resources) {
            return new c(this, resources);
        }
    }

    public static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        public final x0.g f6396a;

        public d(x0.g gVar) {
            super();
            this.f6396a = gVar;
        }

        public void c() {
            this.f6396a.start();
        }

        public void d() {
            this.f6396a.stop();
        }
    }

    public static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        public final ObjectAnimator f6397a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6398b;

        public e(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
            super();
            int i10;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i11 = 0;
            if (z10) {
                i10 = numberOfFrames - 1;
            } else {
                i10 = 0;
            }
            i11 = !z10 ? numberOfFrames - 1 : i11;
            f fVar = new f(animationDrawable, z10);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i10, i11});
            ofInt.setAutoCancel(true);
            ofInt.setDuration((long) fVar.a());
            ofInt.setInterpolator(fVar);
            this.f6398b = z11;
            this.f6397a = ofInt;
        }

        public boolean a() {
            return this.f6398b;
        }

        public void b() {
            this.f6397a.reverse();
        }

        public void c() {
            this.f6397a.start();
        }

        public void d() {
            this.f6397a.cancel();
        }
    }

    public static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public int[] f6399a;

        /* renamed from: b  reason: collision with root package name */
        public int f6400b;

        /* renamed from: c  reason: collision with root package name */
        public int f6401c;

        public f(AnimationDrawable animationDrawable, boolean z10) {
            b(animationDrawable, z10);
        }

        public int a() {
            return this.f6401c;
        }

        public int b(AnimationDrawable animationDrawable, boolean z10) {
            int i10;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f6400b = numberOfFrames;
            int[] iArr = this.f6399a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f6399a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f6399a;
            int i11 = 0;
            for (int i12 = 0; i12 < numberOfFrames; i12++) {
                if (z10) {
                    i10 = (numberOfFrames - i12) - 1;
                } else {
                    i10 = i12;
                }
                int duration = animationDrawable.getDuration(i10);
                iArr2[i12] = duration;
                i11 += duration;
            }
            this.f6401c = i11;
            return i11;
        }

        public float getInterpolation(float f10) {
            float f11;
            int i10 = (int) ((f10 * ((float) this.f6401c)) + 0.5f);
            int i11 = this.f6400b;
            int[] iArr = this.f6399a;
            int i12 = 0;
            while (i12 < i11) {
                int i13 = iArr[i12];
                if (i10 < i13) {
                    break;
                }
                i10 -= i13;
                i12++;
            }
            if (i12 < i11) {
                f11 = ((float) i10) / ((float) this.f6401c);
            } else {
                f11 = 0.0f;
            }
            return (((float) i12) / ((float) i11)) + f11;
        }
    }

    public static abstract class g {
        public g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public c() {
        this((C0079c) null, (Resources) null);
    }

    public static c l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            c cVar = new c();
            cVar.m(context, resources, xmlPullParser, attributeSet, theme);
            return cVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public void h(h.c cVar) {
        super.h(cVar);
        if (cVar instanceof C0079c) {
            this.f6390p = (C0079c) cVar;
        }
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f6391q;
        if (gVar != null) {
            gVar.d();
            this.f6391q = null;
            g(this.f6392r);
            this.f6392r = -1;
            this.f6393s = -1;
        }
    }

    /* renamed from: k */
    public C0079c b() {
        return new C0079c(this.f6390p, this, (Resources) null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray k10 = i.k(resources, theme, attributeSet, R$styleable.f799a);
        setVisible(k10.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        s(k10);
        i(resources);
        k10.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    public Drawable mutate() {
        if (!this.f6394t && super.mutate() == this) {
            this.f6390p.r();
            this.f6394t = true;
        }
        return this;
    }

    public final void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals(PlistBuilder.KEY_ITEM)) {
                        p(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        q(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    public final void o() {
        onStateChange(getState());
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i10) {
        return super.onLayoutDirectionChanged(i10);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z10;
        int F = this.f6390p.F(iArr);
        if (F == c() || (!r(F) && !g(F))) {
            z10 = false;
        } else {
            z10 = true;
        }
        Drawable current = getCurrent();
        if (current != null) {
            return z10 | current.setState(iArr);
        }
        return z10;
    }

    public final int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable;
        int next;
        TypedArray k10 = i.k(resources, theme, attributeSet, R$styleable.f800b);
        int resourceId = k10.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = k10.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        if (resourceId2 > 0) {
            drawable = e2.h().j(context, resourceId2);
        } else {
            drawable = null;
        }
        k10.recycle();
        int[] j10 = j(attributeSet);
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                drawable = x0.n.c(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawable != null) {
            return this.f6390p.B(j10, drawable, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public final int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable;
        int next;
        TypedArray k10 = i.k(resources, theme, attributeSet, R$styleable.f801c);
        int resourceId = k10.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = k10.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = k10.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        if (resourceId3 > 0) {
            drawable = e2.h().j(context, resourceId3);
        } else {
            drawable = null;
        }
        boolean z10 = k10.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        k10.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                drawable = x0.g.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawable == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f6390p.C(resourceId, resourceId2, drawable, z10);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    public final boolean r(int i10) {
        int i11;
        int G;
        g gVar;
        g gVar2 = this.f6391q;
        if (gVar2 == null) {
            i11 = c();
        } else if (i10 == this.f6392r) {
            return true;
        } else {
            if (i10 != this.f6393s || !gVar2.a()) {
                i11 = this.f6392r;
                gVar2.d();
            } else {
                gVar2.b();
                this.f6392r = this.f6393s;
                this.f6393s = i10;
                return true;
            }
        }
        this.f6391q = null;
        this.f6393s = -1;
        this.f6392r = -1;
        C0079c cVar = this.f6390p;
        int E = cVar.E(i11);
        int E2 = cVar.E(i10);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            gVar = new e((AnimationDrawable) current, cVar.H(E, E2), I);
        } else if (current instanceof x0.g) {
            gVar = new d((x0.g) current);
        } else {
            if (current instanceof Animatable) {
                gVar = new b((Animatable) current);
            }
            return false;
        }
        gVar.c();
        this.f6391q = gVar;
        this.f6393s = i11;
        this.f6392r = i10;
        return true;
    }

    public final void s(TypedArray typedArray) {
        C0079c cVar = this.f6390p;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f6420d |= typedArray.getChangingConfigurations();
        }
        cVar.x(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f6425i));
        cVar.t(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f6428l));
        cVar.u(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.v(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f6440x));
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        super.scheduleDrawable(drawable, runnable, j10);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z10) {
        super.setAutoMirrored(z10);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z10) {
        super.setDither(z10);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        g gVar = this.f6391q;
        if (gVar != null && (visible || z11)) {
            if (z10) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public c(C0079c cVar, Resources resources) {
        super((n.a) null);
        this.f6392r = -1;
        this.f6393s = -1;
        h(new C0079c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
