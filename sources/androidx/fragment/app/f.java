package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;
import androidx.fragment.app.z;
import b0.d0;
import x.b;

public abstract class f {

    public class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f1978a;

        public a(Fragment fragment) {
            this.f1978a = fragment;
        }

        public void a() {
            if (this.f1978a.getAnimatingAway() != null) {
                View animatingAway = this.f1978a.getAnimatingAway();
                this.f1978a.setAnimatingAway((View) null);
                animatingAway.clearAnimation();
            }
            this.f1978a.setAnimator((Animator) null);
        }
    }

    public class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Fragment f1980b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ z.g f1981c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ x.b f1982d;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                if (b.this.f1980b.getAnimatingAway() != null) {
                    b.this.f1980b.setAnimatingAway((View) null);
                    b bVar = b.this;
                    bVar.f1981c.b(bVar.f1980b, bVar.f1982d);
                }
            }
        }

        public b(ViewGroup viewGroup, Fragment fragment, z.g gVar, x.b bVar) {
            this.f1979a = viewGroup;
            this.f1980b = fragment;
            this.f1981c = gVar;
            this.f1982d = bVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f1979a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1984a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1985b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f1986c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ z.g f1987d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x.b f1988e;

        public c(ViewGroup viewGroup, View view, Fragment fragment, z.g gVar, x.b bVar) {
            this.f1984a = viewGroup;
            this.f1985b = view;
            this.f1986c = fragment;
            this.f1987d = gVar;
            this.f1988e = bVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1984a.endViewTransition(this.f1985b);
            Animator animator2 = this.f1986c.getAnimator();
            this.f1986c.setAnimator((Animator) null);
            if (animator2 != null && this.f1984a.indexOfChild(this.f1985b) < 0) {
                this.f1987d.b(this.f1986c, this.f1988e);
            }
        }
    }

    public static void a(Fragment fragment, d dVar, z.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        x.b bVar = new x.b();
        bVar.c(new a(fragment));
        gVar.a(fragment, bVar);
        if (dVar.f1989a != null) {
            e eVar = new e(dVar.f1989a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar.setAnimationListener(new b(viewGroup, fragment, gVar, bVar));
            fragment.mView.startAnimation(eVar);
            return;
        }
        Animator animator = dVar.f1990b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, bVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    public static int b(Fragment fragment, boolean z10, boolean z11) {
        if (z11) {
            if (z10) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        } else if (z10) {
            return fragment.getEnterAnim();
        } else {
            return fragment.getExitAnim();
        }
    }

    public static d c(Context context, Fragment fragment, boolean z10, boolean z11) {
        int nextTransition = fragment.getNextTransition();
        int b10 = b(fragment, z10, z11);
        boolean z12 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i10 = R$id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i10) != null) {
                fragment.mContainer.setTag(i10, (Object) null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z10, b10);
        if (onCreateAnimation != null) {
            return new d(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z10, b10);
        if (onCreateAnimator != null) {
            return new d(onCreateAnimator);
        }
        if (b10 == 0 && nextTransition != 0) {
            b10 = d(nextTransition, z10);
        }
        if (b10 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(b10));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, b10);
                    if (loadAnimation != null) {
                        return new d(loadAnimation);
                    }
                    z12 = true;
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            }
            if (!z12) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, b10);
                    if (loadAnimator != null) {
                        return new d(loadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, b10);
                        if (loadAnimation2 != null) {
                            return new d(loadAnimation2);
                        }
                    } else {
                        throw e11;
                    }
                }
            }
        }
        return null;
    }

    public static int d(int i10, boolean z10) {
        if (i10 != 4097) {
            if (i10 != 4099) {
                if (i10 != 8194) {
                    return -1;
                }
                if (z10) {
                    return R$animator.fragment_close_enter;
                }
                return R$animator.fragment_close_exit;
            } else if (z10) {
                return R$animator.fragment_fade_enter;
            } else {
                return R$animator.fragment_fade_exit;
            }
        } else if (z10) {
            return R$animator.fragment_open_enter;
        } else {
            return R$animator.fragment_open_exit;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f1989a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f1990b;

        public d(Animation animation) {
            this.f1989a = animation;
            this.f1990b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public d(Animator animator) {
            this.f1989a = null;
            this.f1990b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public static class e extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final ViewGroup f1991a;

        /* renamed from: b  reason: collision with root package name */
        public final View f1992b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1993c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1994d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1995e = true;

        public e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1991a = viewGroup;
            this.f1992b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j10, Transformation transformation) {
            this.f1995e = true;
            if (this.f1993c) {
                return !this.f1994d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f1993c = true;
                d0.a(this.f1991a, this);
            }
            return true;
        }

        public void run() {
            if (this.f1993c || !this.f1995e) {
                this.f1991a.endViewTransition(this.f1992b);
                this.f1994d = true;
                return;
            }
            this.f1995e = false;
            this.f1991a.post(this);
        }

        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f1995e = true;
            if (this.f1993c) {
                return !this.f1994d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f1993c = true;
                d0.a(this.f1991a, this);
            }
            return true;
        }
    }
}
