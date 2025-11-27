package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import b0.c1;
import java.util.Map;

public class c extends n {

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f3152d = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: e  reason: collision with root package name */
    public static final Property f3153e;

    /* renamed from: f  reason: collision with root package name */
    public static final Property f3154f;

    /* renamed from: g  reason: collision with root package name */
    public static final Property f3155g;

    /* renamed from: h  reason: collision with root package name */
    public static final Property f3156h;

    /* renamed from: i  reason: collision with root package name */
    public static final Property f3157i;

    /* renamed from: j  reason: collision with root package name */
    public static final Property f3158j;

    /* renamed from: k  reason: collision with root package name */
    public static l f3159k = new l();

    /* renamed from: a  reason: collision with root package name */
    public int[] f3160a = new int[2];

    /* renamed from: b  reason: collision with root package name */
    public boolean f3161b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3162c = false;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3163a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f3164b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f3165c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f3166d;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f3163a = viewGroup;
            this.f3164b = bitmapDrawable;
            this.f3165c = view;
            this.f3166d = f10;
        }

        public void onAnimationEnd(Animator animator) {
            c0.b(this.f3163a).b(this.f3164b);
            c0.g(this.f3165c, this.f3166d);
        }
    }

    public static class b extends Property {

        /* renamed from: a  reason: collision with root package name */
        public Rect f3168a = new Rect();

        public b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f3168a);
            Rect rect = this.f3168a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f3168a);
            this.f3168a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f3168a);
        }
    }

    /* renamed from: androidx.transition.c$c  reason: collision with other inner class name */
    public static class C0053c extends Property {
        public C0053c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    public static class d extends Property {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    public static class e extends Property {
        public e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    public static class f extends Property {
        public f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    public static class g extends Property {
        public g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            c0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f3169a;
        private k mViewBounds;

        public h(k kVar) {
            this.f3169a = kVar;
            this.mViewBounds = kVar;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3171a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f3172b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Rect f3173c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3174d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f3175e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3176f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3177g;

        public i(View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f3172b = view;
            this.f3173c = rect;
            this.f3174d = i10;
            this.f3175e = i11;
            this.f3176f = i12;
            this.f3177g = i13;
        }

        public void onAnimationCancel(Animator animator) {
            this.f3171a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3171a) {
                c1.r0(this.f3172b, this.f3173c);
                c0.f(this.f3172b, this.f3174d, this.f3175e, this.f3176f, this.f3177g);
            }
        }
    }

    public class j extends o {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3179a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3180b;

        public j(ViewGroup viewGroup) {
            this.f3180b = viewGroup;
        }

        public void a(n nVar) {
            z.c(this.f3180b, true);
        }

        public void c(n nVar) {
            z.c(this.f3180b, false);
        }

        public void d(n nVar) {
            if (!this.f3179a) {
                z.c(this.f3180b, false);
            }
            nVar.removeListener(this);
        }

        public void e(n nVar) {
            z.c(this.f3180b, false);
            this.f3179a = true;
        }
    }

    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public int f3182a;

        /* renamed from: b  reason: collision with root package name */
        public int f3183b;

        /* renamed from: c  reason: collision with root package name */
        public int f3184c;

        /* renamed from: d  reason: collision with root package name */
        public int f3185d;

        /* renamed from: e  reason: collision with root package name */
        public View f3186e;

        /* renamed from: f  reason: collision with root package name */
        public int f3187f;

        /* renamed from: g  reason: collision with root package name */
        public int f3188g;

        public k(View view) {
            this.f3186e = view;
        }

        public void a(PointF pointF) {
            this.f3184c = Math.round(pointF.x);
            this.f3185d = Math.round(pointF.y);
            int i10 = this.f3188g + 1;
            this.f3188g = i10;
            if (this.f3187f == i10) {
                b();
            }
        }

        public final void b() {
            c0.f(this.f3186e, this.f3182a, this.f3183b, this.f3184c, this.f3185d);
            this.f3187f = 0;
            this.f3188g = 0;
        }

        public void c(PointF pointF) {
            this.f3182a = Math.round(pointF.x);
            this.f3183b = Math.round(pointF.y);
            int i10 = this.f3187f + 1;
            this.f3187f = i10;
            if (i10 == this.f3188g) {
                b();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        f3153e = new b(cls, "boundsOrigin");
        f3154f = new C0053c(cls, "topLeft");
        f3155g = new d(cls, "bottomRight");
        f3156h = new e(cls, "bottomRight");
        f3157i = new f(cls, "topLeft");
        f3158j = new g(cls, "position");
    }

    public void captureEndValues(u uVar) {
        captureValues(uVar);
    }

    public void captureStartValues(u uVar) {
        captureValues(uVar);
    }

    public final void captureValues(u uVar) {
        View view = uVar.f3272b;
        if (c1.Q(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            uVar.f3271a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            uVar.f3271a.put("android:changeBounds:parent", uVar.f3272b.getParent());
            if (this.f3162c) {
                uVar.f3272b.getLocationInWindow(this.f3160a);
                uVar.f3271a.put("android:changeBounds:windowX", Integer.valueOf(this.f3160a[0]));
                uVar.f3271a.put("android:changeBounds:windowY", Integer.valueOf(this.f3160a[1]));
            }
            if (this.f3161b) {
                uVar.f3271a.put("android:changeBounds:clip", c1.s(view));
            }
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, u uVar, u uVar2) {
        int i10;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i11;
        Rect rect;
        Rect rect2;
        ObjectAnimator objectAnimator2;
        u uVar3 = uVar;
        u uVar4 = uVar2;
        if (uVar3 == null || uVar4 == null) {
            return null;
        }
        Map map = uVar3.f3271a;
        Map map2 = uVar4.f3271a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = uVar4.f3272b;
        if (r(viewGroup2, viewGroup3)) {
            Rect rect3 = (Rect) uVar3.f3271a.get("android:changeBounds:bounds");
            Rect rect4 = (Rect) uVar4.f3271a.get("android:changeBounds:bounds");
            int i12 = rect3.left;
            int i13 = rect4.left;
            int i14 = rect3.top;
            int i15 = rect4.top;
            int i16 = rect3.right;
            int i17 = rect4.right;
            int i18 = rect3.bottom;
            int i19 = rect4.bottom;
            int i20 = i16 - i12;
            int i21 = i18 - i14;
            int i22 = i17 - i13;
            int i23 = i19 - i15;
            View view3 = view2;
            Rect rect5 = (Rect) uVar3.f3271a.get("android:changeBounds:clip");
            Rect rect6 = (Rect) uVar4.f3271a.get("android:changeBounds:clip");
            if ((i20 == 0 || i21 == 0) && (i22 == 0 || i23 == 0)) {
                i10 = 0;
            } else {
                if (i12 == i13 && i14 == i15) {
                    i10 = 0;
                } else {
                    i10 = 1;
                }
                if (!(i16 == i17 && i18 == i19)) {
                    i10++;
                }
            }
            if ((rect5 != null && !rect5.equals(rect6)) || (rect5 == null && rect6 != null)) {
                i10++;
            }
            if (i10 <= 0) {
                return null;
            }
            Rect rect7 = rect6;
            Rect rect8 = rect5;
            if (!this.f3161b) {
                view = view3;
                c0.f(view, i12, i14, i16, i18);
                if (i10 == 2) {
                    if (i20 == i22 && i21 == i23) {
                        animator = g.a(view, f3158j, getPathMotion().a((float) i12, (float) i14, (float) i13, (float) i15));
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a10 = g.a(kVar, f3154f, getPathMotion().a((float) i12, (float) i14, (float) i13, (float) i15));
                        ObjectAnimator a11 = g.a(kVar, f3155g, getPathMotion().a((float) i16, (float) i18, (float) i17, (float) i19));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a10, a11});
                        animatorSet.addListener(new h(kVar));
                        animator = animatorSet;
                    }
                } else if (i12 == i13 && i14 == i15) {
                    animator = g.a(view, f3156h, getPathMotion().a((float) i16, (float) i18, (float) i17, (float) i19));
                } else {
                    animator = g.a(view, f3157i, getPathMotion().a((float) i12, (float) i14, (float) i13, (float) i15));
                }
            } else {
                view = view3;
                c0.f(view, i12, i14, Math.max(i20, i22) + i12, Math.max(i21, i23) + i14);
                if (i12 == i13 && i14 == i15) {
                    objectAnimator = null;
                } else {
                    objectAnimator = g.a(view, f3158j, getPathMotion().a((float) i12, (float) i14, (float) i13, (float) i15));
                }
                if (rect8 == null) {
                    i11 = 0;
                    rect = new Rect(0, 0, i20, i21);
                } else {
                    i11 = 0;
                    rect = rect8;
                }
                if (rect7 == null) {
                    rect2 = new Rect(i11, i11, i22, i23);
                } else {
                    rect2 = rect7;
                }
                if (!rect.equals(rect2)) {
                    c1.r0(view, rect);
                    l lVar = f3159k;
                    Object[] objArr = new Object[2];
                    objArr[i11] = rect;
                    objArr[1] = rect2;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", lVar, objArr);
                    ofObject.addListener(new i(view, rect7, i13, i15, i17, i19));
                    objectAnimator2 = ofObject;
                } else {
                    objectAnimator2 = null;
                }
                animator = t.c(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                z.c(viewGroup4, true);
                addListener(new j(viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) uVar3.f3271a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) uVar3.f3271a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) uVar4.f3271a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) uVar4.f3271a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f3160a);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c10 = c0.c(view2);
        c0.g(view2, 0.0f);
        c0.b(viewGroup).a(bitmapDrawable);
        h pathMotion = getPathMotion();
        int[] iArr = this.f3160a;
        int i24 = iArr[0];
        int i25 = iArr[1];
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{k.a(f3153e, pathMotion.a((float) (intValue - i24), (float) (intValue2 - i25), (float) (intValue3 - i24), (float) (intValue4 - i25)))});
        ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c10));
        return ofPropertyValuesHolder;
    }

    public String[] getTransitionProperties() {
        return f3152d;
    }

    public final boolean r(View view, View view2) {
        if (!this.f3162c) {
            return true;
        }
        u matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f3272b) {
            return true;
        }
        return false;
    }
}
