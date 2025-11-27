package x0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import q.i;
import s.h;

public class g extends m implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    public b f9568b;

    /* renamed from: c  reason: collision with root package name */
    public Context f9569c;

    /* renamed from: d  reason: collision with root package name */
    public ArgbEvaluator f9570d;

    /* renamed from: e  reason: collision with root package name */
    public Animator.AnimatorListener f9571e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f9572f;

    /* renamed from: g  reason: collision with root package name */
    public final Drawable.Callback f9573g;

    public class a implements Drawable.Callback {
        public a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            g.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            g.this.scheduleSelf(runnable, j10);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            g.this.unscheduleSelf(runnable);
        }
    }

    public static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f9575a;

        /* renamed from: b  reason: collision with root package name */
        public n f9576b;

        /* renamed from: c  reason: collision with root package name */
        public AnimatorSet f9577c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList f9578d;

        /* renamed from: e  reason: collision with root package name */
        public androidx.collection.a f9579e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f9575a = bVar.f9575a;
                n nVar = bVar.f9576b;
                if (nVar != null) {
                    Drawable.ConstantState constantState = nVar.getConstantState();
                    if (resources != null) {
                        this.f9576b = (n) constantState.newDrawable(resources);
                    } else {
                        this.f9576b = (n) constantState.newDrawable();
                    }
                    n nVar2 = (n) this.f9576b.mutate();
                    this.f9576b = nVar2;
                    nVar2.setCallback(callback);
                    this.f9576b.setBounds(bVar.f9576b.getBounds());
                    this.f9576b.h(false);
                }
                ArrayList arrayList = bVar.f9578d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f9578d = new ArrayList(size);
                    this.f9579e = new androidx.collection.a(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = (Animator) bVar.f9578d.get(i10);
                        Animator clone = animator.clone();
                        String str = (String) bVar.f9579e.get(animator);
                        clone.setTarget(this.f9576b.d(str));
                        this.f9578d.add(clone);
                        this.f9579e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f9577c == null) {
                this.f9577c = new AnimatorSet();
            }
            this.f9577c.playTogether(this.f9578d);
        }

        public int getChangingConfigurations() {
            return this.f9575a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public g() {
        this((Context) null, (b) null, (Resources) null);
    }

    public static g a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        g gVar = new g(context);
        gVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return gVar;
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            h.a(drawable, theme);
        }
    }

    public final void b(String str, Animator animator) {
        animator.setTarget(this.f9568b.f9576b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        b bVar = this.f9568b;
        if (bVar.f9578d == null) {
            bVar.f9578d = new ArrayList();
            this.f9568b.f9579e = new androidx.collection.a();
        }
        this.f9568b.f9578d.add(animator);
        this.f9568b.f9579e.put(animator, str);
    }

    public final void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i10 = 0; i10 < childAnimations.size(); i10++) {
                c(childAnimations.get(i10));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f9570d == null) {
                    this.f9570d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f9570d);
            }
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return h.b(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f9568b.f9576b.draw(canvas);
        if (this.f9568b.f9577c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return h.d(drawable);
        }
        return this.f9568b.f9576b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f9568b.f9575a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return h.e(drawable);
        }
        return this.f9568b.f9576b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f9585a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f9585a.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f9568b.f9576b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f9568b.f9576b.getIntrinsicWidth();
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
        return this.f9568b.f9576b.getOpacity();
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

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            h.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray k10 = i.k(resources, theme, attributeSet, a.f9560e);
                    int resourceId = k10.getResourceId(0, 0);
                    if (resourceId != 0) {
                        n b10 = n.b(resources, resourceId, theme);
                        b10.h(false);
                        b10.setCallback(this.f9573g);
                        n nVar = this.f9568b.f9576b;
                        if (nVar != null) {
                            nVar.setCallback((Drawable.Callback) null);
                        }
                        this.f9568b.f9576b = b10;
                    }
                    k10.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f9561f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f9569c;
                        if (context != null) {
                            b(string, j.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f9568b.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return h.h(drawable);
        }
        return this.f9568b.f9576b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return c.a(drawable).isRunning();
        }
        return this.f9568b.f9577c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f9568b.f9576b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f9568b.f9576b.setBounds(rect);
        }
    }

    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        return this.f9568b.f9576b.setLevel(i10);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f9568b.f9576b.setState(iArr);
    }

    public void setAlpha(int i10) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f9568b.f9576b.setAlpha(i10);
        }
    }

    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            h.j(drawable, z10);
        } else {
            this.f9568b.f9576b.setAutoMirrored(z10);
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
            h.n(drawable, i10);
        } else {
            this.f9568b.f9576b.setTint(i10);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            h.o(drawable, colorStateList);
        } else {
            this.f9568b.f9576b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            h.p(drawable, mode);
        } else {
            this.f9568b.f9576b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f9568b.f9576b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    public void start() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            c.a(drawable).start();
        } else if (!this.f9568b.f9577c.isStarted()) {
            this.f9568b.f9577c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            c.a(drawable).stop();
        } else {
            this.f9568b.f9577c.end();
        }
    }

    public g(Context context) {
        this(context, (b) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f9585a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f9568b.f9576b.setColorFilter(colorFilter);
        }
    }

    public static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f9580a;

        public c(Drawable.ConstantState constantState) {
            this.f9580a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f9580a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f9580a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            g gVar = new g();
            Drawable newDrawable = this.f9580a.newDrawable();
            gVar.f9585a = newDrawable;
            newDrawable.setCallback(gVar.f9573g);
            return gVar;
        }

        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            Drawable newDrawable = this.f9580a.newDrawable(resources);
            gVar.f9585a = newDrawable;
            newDrawable.setCallback(gVar.f9573g);
            return gVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            g gVar = new g();
            Drawable a10 = this.f9580a.newDrawable(resources, theme);
            gVar.f9585a = a10;
            a10.setCallback(gVar.f9573g);
            return gVar;
        }
    }

    public g(Context context, b bVar, Resources resources) {
        this.f9570d = null;
        this.f9571e = null;
        this.f9572f = null;
        a aVar = new a();
        this.f9573g = aVar;
        this.f9569c = context;
        if (bVar != null) {
            this.f9568b = bVar;
        } else {
            this.f9568b = new b(context, bVar, aVar, resources);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
