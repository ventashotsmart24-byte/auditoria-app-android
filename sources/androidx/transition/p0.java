package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.n;

public abstract class p0 extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f3241b = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: a  reason: collision with root package name */
    public int f3242a = 3;

    public class a extends o {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3243a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f3244b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f3245c;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.f3243a = viewGroup;
            this.f3244b = view;
            this.f3245c = view2;
        }

        public void a(n nVar) {
            if (this.f3244b.getParent() == null) {
                z.a(this.f3243a).c(this.f3244b);
            } else {
                p0.this.cancel();
            }
        }

        public void c(n nVar) {
            z.a(this.f3243a).d(this.f3244b);
        }

        public void d(n nVar) {
            this.f3245c.setTag(R$id.save_overlay_view, (Object) null);
            z.a(this.f3243a).d(this.f3244b);
            nVar.removeListener(this);
        }
    }

    public static class b extends AnimatorListenerAdapter implements n.g {

        /* renamed from: a  reason: collision with root package name */
        public final View f3247a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3248b;

        /* renamed from: c  reason: collision with root package name */
        public final ViewGroup f3249c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f3250d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3251e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f3252f = false;

        public b(View view, int i10, boolean z10) {
            this.f3247a = view;
            this.f3248b = i10;
            this.f3249c = (ViewGroup) view.getParent();
            this.f3250d = z10;
            g(true);
        }

        public void a(n nVar) {
            g(true);
        }

        public void b(n nVar) {
        }

        public void c(n nVar) {
            g(false);
        }

        public void d(n nVar) {
            f();
            nVar.removeListener(this);
        }

        public void e(n nVar) {
        }

        public final void f() {
            if (!this.f3252f) {
                c0.h(this.f3247a, this.f3248b);
                ViewGroup viewGroup = this.f3249c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z10) {
            ViewGroup viewGroup;
            if (this.f3250d && this.f3251e != z10 && (viewGroup = this.f3249c) != null) {
                this.f3251e = z10;
                z.c(viewGroup, z10);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f3252f = true;
        }

        public void onAnimationEnd(Animator animator) {
            f();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f3252f) {
                c0.h(this.f3247a, this.f3248b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f3252f) {
                c0.h(this.f3247a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3253a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3254b;

        /* renamed from: c  reason: collision with root package name */
        public int f3255c;

        /* renamed from: d  reason: collision with root package name */
        public int f3256d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f3257e;

        /* renamed from: f  reason: collision with root package name */
        public ViewGroup f3258f;
    }

    public void captureEndValues(u uVar) {
        captureValues(uVar);
    }

    public void captureStartValues(u uVar) {
        captureValues(uVar);
    }

    public final void captureValues(u uVar) {
        uVar.f3271a.put("android:visibility:visibility", Integer.valueOf(uVar.f3272b.getVisibility()));
        uVar.f3271a.put("android:visibility:parent", uVar.f3272b.getParent());
        int[] iArr = new int[2];
        uVar.f3272b.getLocationOnScreen(iArr);
        uVar.f3271a.put("android:visibility:screenLocation", iArr);
    }

    public Animator createAnimator(ViewGroup viewGroup, u uVar, u uVar2) {
        c r10 = r(uVar, uVar2);
        if (!r10.f3253a) {
            return null;
        }
        if (r10.f3257e == null && r10.f3258f == null) {
            return null;
        }
        if (r10.f3254b) {
            return t(viewGroup, uVar, r10.f3255c, uVar2, r10.f3256d);
        }
        return v(viewGroup, uVar, r10.f3255c, uVar2, r10.f3256d);
    }

    public String[] getTransitionProperties() {
        return f3241b;
    }

    public boolean isTransitionRequired(u uVar, u uVar2) {
        if (uVar == null && uVar2 == null) {
            return false;
        }
        if (uVar != null && uVar2 != null && uVar2.f3271a.containsKey("android:visibility:visibility") != uVar.f3271a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c r10 = r(uVar, uVar2);
        if (!r10.f3253a) {
            return false;
        }
        if (r10.f3255c == 0 || r10.f3256d == 0) {
            return true;
        }
        return false;
    }

    public final c r(u uVar, u uVar2) {
        c cVar = new c();
        cVar.f3253a = false;
        cVar.f3254b = false;
        if (uVar == null || !uVar.f3271a.containsKey("android:visibility:visibility")) {
            cVar.f3255c = -1;
            cVar.f3257e = null;
        } else {
            cVar.f3255c = ((Integer) uVar.f3271a.get("android:visibility:visibility")).intValue();
            cVar.f3257e = (ViewGroup) uVar.f3271a.get("android:visibility:parent");
        }
        if (uVar2 == null || !uVar2.f3271a.containsKey("android:visibility:visibility")) {
            cVar.f3256d = -1;
            cVar.f3258f = null;
        } else {
            cVar.f3256d = ((Integer) uVar2.f3271a.get("android:visibility:visibility")).intValue();
            cVar.f3258f = (ViewGroup) uVar2.f3271a.get("android:visibility:parent");
        }
        if (uVar != null && uVar2 != null) {
            int i10 = cVar.f3255c;
            int i11 = cVar.f3256d;
            if (i10 == i11 && cVar.f3257e == cVar.f3258f) {
                return cVar;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    cVar.f3254b = false;
                    cVar.f3253a = true;
                } else if (i11 == 0) {
                    cVar.f3254b = true;
                    cVar.f3253a = true;
                }
            } else if (cVar.f3258f == null) {
                cVar.f3254b = false;
                cVar.f3253a = true;
            } else if (cVar.f3257e == null) {
                cVar.f3254b = true;
                cVar.f3253a = true;
            }
        } else if (uVar == null && cVar.f3256d == 0) {
            cVar.f3254b = true;
            cVar.f3253a = true;
        } else if (uVar2 == null && cVar.f3255c == 0) {
            cVar.f3254b = false;
            cVar.f3253a = true;
        }
        return cVar;
    }

    public abstract Animator s(ViewGroup viewGroup, View view, u uVar, u uVar2);

    public Animator t(ViewGroup viewGroup, u uVar, int i10, u uVar2, int i11) {
        if ((this.f3242a & 1) != 1 || uVar2 == null) {
            return null;
        }
        if (uVar == null) {
            View view = (View) uVar2.f3272b.getParent();
            if (r(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f3253a) {
                return null;
            }
        }
        return s(viewGroup, uVar2.f3272b, uVar, uVar2);
    }

    public abstract Animator u(ViewGroup viewGroup, View view, u uVar, u uVar2);

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r0.mCanRemoveViews != false) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator v(android.view.ViewGroup r18, androidx.transition.u r19, int r20, androidx.transition.u r21, int r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r22
            int r5 = r0.f3242a
            r6 = 2
            r5 = r5 & r6
            r7 = 0
            if (r5 == r6) goto L_0x0012
            return r7
        L_0x0012:
            if (r2 != 0) goto L_0x0015
            return r7
        L_0x0015:
            android.view.View r5 = r2.f3272b
            if (r3 == 0) goto L_0x001c
            android.view.View r8 = r3.f3272b
            goto L_0x001d
        L_0x001c:
            r8 = r7
        L_0x001d:
            int r9 = androidx.transition.R$id.save_overlay_view
            java.lang.Object r10 = r5.getTag(r9)
            android.view.View r10 = (android.view.View) r10
            r11 = 0
            r12 = 1
            if (r10 == 0) goto L_0x002d
            r8 = r7
            r13 = 1
            goto L_0x0095
        L_0x002d:
            if (r8 == 0) goto L_0x0040
            android.view.ViewParent r10 = r8.getParent()
            if (r10 != 0) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r10 = 4
            if (r4 != r10) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            if (r5 != r8) goto L_0x0045
        L_0x003c:
            r10 = r8
            r13 = 0
            r8 = r7
            goto L_0x0048
        L_0x0040:
            if (r8 == 0) goto L_0x0045
            r10 = r7
            r13 = 0
            goto L_0x0048
        L_0x0045:
            r8 = r7
            r10 = r8
            r13 = 1
        L_0x0048:
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            if (r13 != 0) goto L_0x0051
            goto L_0x008b
        L_0x0051:
            android.view.ViewParent r13 = r5.getParent()
            boolean r13 = r13 instanceof android.view.View
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            android.view.View r13 = (android.view.View) r13
            androidx.transition.u r14 = r0.getTransitionValues(r13, r12)
            androidx.transition.u r15 = r0.getMatchedTransitionValues(r13, r12)
            androidx.transition.p0$c r14 = r0.r(r14, r15)
            boolean r14 = r14.f3253a
            if (r14 != 0) goto L_0x0074
            android.view.View r8 = androidx.transition.t.a(r1, r5, r13)
            goto L_0x008f
        L_0x0074:
            int r14 = r13.getId()
            android.view.ViewParent r13 = r13.getParent()
            if (r13 != 0) goto L_0x008f
            r13 = -1
            if (r14 == r13) goto L_0x008f
            android.view.View r13 = r1.findViewById(r14)
            if (r13 == 0) goto L_0x008f
            boolean r13 = r0.mCanRemoveViews
            if (r13 == 0) goto L_0x008f
        L_0x008b:
            r8 = r10
            r13 = 0
            r10 = r5
            goto L_0x0095
        L_0x008f:
            r13 = 0
            r16 = r10
            r10 = r8
            r8 = r16
        L_0x0095:
            if (r10 == 0) goto L_0x00e5
            if (r13 != 0) goto L_0x00c9
            java.util.Map r4 = r2.f3271a
            java.lang.String r7 = "android:visibility:screenLocation"
            java.lang.Object r4 = r4.get(r7)
            int[] r4 = (int[]) r4
            r7 = r4[r11]
            r4 = r4[r12]
            int[] r6 = new int[r6]
            r1.getLocationOnScreen(r6)
            r8 = r6[r11]
            int r7 = r7 - r8
            int r8 = r10.getLeft()
            int r7 = r7 - r8
            r10.offsetLeftAndRight(r7)
            r6 = r6[r12]
            int r4 = r4 - r6
            int r6 = r10.getTop()
            int r4 = r4 - r6
            r10.offsetTopAndBottom(r4)
            androidx.transition.x r4 = androidx.transition.z.a(r18)
            r4.c(r10)
        L_0x00c9:
            android.animation.Animator r2 = r0.u(r1, r10, r2, r3)
            if (r13 != 0) goto L_0x00e4
            if (r2 != 0) goto L_0x00d9
            androidx.transition.x r1 = androidx.transition.z.a(r18)
            r1.d(r10)
            goto L_0x00e4
        L_0x00d9:
            r5.setTag(r9, r10)
            androidx.transition.p0$a r3 = new androidx.transition.p0$a
            r3.<init>(r1, r10, r5)
            r0.addListener(r3)
        L_0x00e4:
            return r2
        L_0x00e5:
            if (r8 == 0) goto L_0x0107
            int r5 = r8.getVisibility()
            androidx.transition.c0.h(r8, r11)
            android.animation.Animator r1 = r0.u(r1, r8, r2, r3)
            if (r1 == 0) goto L_0x0103
            androidx.transition.p0$b r2 = new androidx.transition.p0$b
            r2.<init>(r8, r4, r12)
            r1.addListener(r2)
            androidx.transition.a.a(r1, r2)
            r0.addListener(r2)
            goto L_0x0106
        L_0x0103:
            androidx.transition.c0.h(r8, r5)
        L_0x0106:
            return r1
        L_0x0107:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.p0.v(android.view.ViewGroup, androidx.transition.u, int, androidx.transition.u, int):android.animation.Animator");
    }

    public void w(int i10) {
        if ((i10 & -4) == 0) {
            this.f3242a = i10;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
