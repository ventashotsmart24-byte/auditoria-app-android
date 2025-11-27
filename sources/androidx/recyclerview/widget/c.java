package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b0.c1;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c extends q {

    /* renamed from: s  reason: collision with root package name */
    public static TimeInterpolator f2889s;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f2890h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f2891i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f2892j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f2893k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public ArrayList f2894l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public ArrayList f2895m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public ArrayList f2896n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public ArrayList f2897o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public ArrayList f2898p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public ArrayList f2899q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public ArrayList f2900r = new ArrayList();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2901a;

        public a(ArrayList arrayList) {
            this.f2901a = arrayList;
        }

        public void run() {
            Iterator it = this.f2901a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.S(jVar.f2935a, jVar.f2936b, jVar.f2937c, jVar.f2938d, jVar.f2939e);
            }
            this.f2901a.clear();
            c.this.f2895m.remove(this.f2901a);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2903a;

        public b(ArrayList arrayList) {
            this.f2903a = arrayList;
        }

        public void run() {
            Iterator it = this.f2903a.iterator();
            while (it.hasNext()) {
                c.this.R((i) it.next());
            }
            this.f2903a.clear();
            c.this.f2896n.remove(this.f2903a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c  reason: collision with other inner class name */
    public class C0042c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2905a;

        public C0042c(ArrayList arrayList) {
            this.f2905a = arrayList;
        }

        public void run() {
            Iterator it = this.f2905a.iterator();
            while (it.hasNext()) {
                c.this.Q((RecyclerView.d0) it.next());
            }
            this.f2905a.clear();
            c.this.f2894l.remove(this.f2905a);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f2907a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f2908b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f2909c;

        public d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2907a = d0Var;
            this.f2908b = viewPropertyAnimator;
            this.f2909c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2908b.setListener((Animator.AnimatorListener) null);
            this.f2909c.setAlpha(1.0f);
            c.this.G(this.f2907a);
            c.this.f2899q.remove(this.f2907a);
            c.this.V();
        }

        public void onAnimationStart(Animator animator) {
            c.this.H(this.f2907a);
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f2911a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2912b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f2913c;

        public e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2911a = d0Var;
            this.f2912b = view;
            this.f2913c = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2912b.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.f2913c.setListener((Animator.AnimatorListener) null);
            c.this.A(this.f2911a);
            c.this.f2897o.remove(this.f2911a);
            c.this.V();
        }

        public void onAnimationStart(Animator animator) {
            c.this.B(this.f2911a);
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f2915a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2916b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f2917c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f2918d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f2919e;

        public f(RecyclerView.d0 d0Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2915a = d0Var;
            this.f2916b = i10;
            this.f2917c = view;
            this.f2918d = i11;
            this.f2919e = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f2916b != 0) {
                this.f2917c.setTranslationX(0.0f);
            }
            if (this.f2918d != 0) {
                this.f2917c.setTranslationY(0.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f2919e.setListener((Animator.AnimatorListener) null);
            c.this.E(this.f2915a);
            c.this.f2898p.remove(this.f2915a);
            c.this.V();
        }

        public void onAnimationStart(Animator animator) {
            c.this.F(this.f2915a);
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f2921a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f2922b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f2923c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2921a = iVar;
            this.f2922b = viewPropertyAnimator;
            this.f2923c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2922b.setListener((Animator.AnimatorListener) null);
            this.f2923c.setAlpha(1.0f);
            this.f2923c.setTranslationX(0.0f);
            this.f2923c.setTranslationY(0.0f);
            c.this.C(this.f2921a.f2929a, true);
            c.this.f2900r.remove(this.f2921a.f2929a);
            c.this.V();
        }

        public void onAnimationStart(Animator animator) {
            c.this.D(this.f2921a.f2929a, true);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f2925a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f2926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f2927c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2925a = iVar;
            this.f2926b = viewPropertyAnimator;
            this.f2927c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2926b.setListener((Animator.AnimatorListener) null);
            this.f2927c.setAlpha(1.0f);
            this.f2927c.setTranslationX(0.0f);
            this.f2927c.setTranslationY(0.0f);
            c.this.C(this.f2925a.f2930b, false);
            c.this.f2900r.remove(this.f2925a.f2930b);
            c.this.V();
        }

        public void onAnimationStart(Animator animator) {
            c.this.D(this.f2925a.f2930b, false);
        }
    }

    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f2935a;

        /* renamed from: b  reason: collision with root package name */
        public int f2936b;

        /* renamed from: c  reason: collision with root package name */
        public int f2937c;

        /* renamed from: d  reason: collision with root package name */
        public int f2938d;

        /* renamed from: e  reason: collision with root package name */
        public int f2939e;

        public j(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
            this.f2935a = d0Var;
            this.f2936b = i10;
            this.f2937c = i11;
            this.f2938d = i12;
            this.f2939e = i13;
        }
    }

    public void Q(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f2897o.add(d0Var);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(d0Var, view, animate)).start();
    }

    public void R(i iVar) {
        View view;
        RecyclerView.d0 d0Var = iVar.f2929a;
        View view2 = null;
        if (d0Var == null) {
            view = null;
        } else {
            view = d0Var.itemView;
        }
        RecyclerView.d0 d0Var2 = iVar.f2930b;
        if (d0Var2 != null) {
            view2 = d0Var2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f2900r.add(iVar.f2929a);
            duration.translationX((float) (iVar.f2933e - iVar.f2931c));
            duration.translationY((float) (iVar.f2934f - iVar.f2932d));
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f2900r.add(iVar.f2930b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    public void S(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.itemView;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f2898p.add(d0Var);
        animate.setDuration(n()).setListener(new f(d0Var, i14, view, i15, animate)).start();
    }

    public final void T(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f2899q.add(d0Var);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(d0Var, animate, view)).start();
    }

    public void U(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.d0) list.get(size)).itemView.animate().cancel();
        }
    }

    public void V() {
        if (!p()) {
            i();
        }
    }

    public final void W(List list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (Y(iVar, d0Var) && iVar.f2929a == null && iVar.f2930b == null) {
                list.remove(iVar);
            }
        }
    }

    public final void X(i iVar) {
        RecyclerView.d0 d0Var = iVar.f2929a;
        if (d0Var != null) {
            Y(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f2930b;
        if (d0Var2 != null) {
            Y(iVar, d0Var2);
        }
    }

    public final boolean Y(i iVar, RecyclerView.d0 d0Var) {
        boolean z10 = false;
        if (iVar.f2930b == d0Var) {
            iVar.f2930b = null;
        } else if (iVar.f2929a != d0Var) {
            return false;
        } else {
            iVar.f2929a = null;
            z10 = true;
        }
        d0Var.itemView.setAlpha(1.0f);
        d0Var.itemView.setTranslationX(0.0f);
        d0Var.itemView.setTranslationY(0.0f);
        C(d0Var, z10);
        return true;
    }

    public final void Z(RecyclerView.d0 d0Var) {
        if (f2889s == null) {
            f2889s = new ValueAnimator().getInterpolator();
        }
        d0Var.itemView.animate().setInterpolator(f2889s);
        j(d0Var);
    }

    public boolean g(RecyclerView.d0 d0Var, List list) {
        if (!list.isEmpty() || super.g(d0Var, list)) {
            return true;
        }
        return false;
    }

    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        view.animate().cancel();
        int size = this.f2892j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((j) this.f2892j.get(size)).f2935a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(d0Var);
                this.f2892j.remove(size);
            }
        }
        W(this.f2893k, d0Var);
        if (this.f2890h.remove(d0Var)) {
            view.setAlpha(1.0f);
            G(d0Var);
        }
        if (this.f2891i.remove(d0Var)) {
            view.setAlpha(1.0f);
            A(d0Var);
        }
        for (int size2 = this.f2896n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f2896n.get(size2);
            W(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.f2896n.remove(size2);
            }
        }
        for (int size3 = this.f2895m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f2895m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((j) arrayList2.get(size4)).f2935a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f2895m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f2894l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f2894l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                A(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f2894l.remove(size5);
                }
            }
        }
        this.f2899q.remove(d0Var);
        this.f2897o.remove(d0Var);
        this.f2900r.remove(d0Var);
        this.f2898p.remove(d0Var);
        V();
    }

    public void k() {
        int size = this.f2892j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.f2892j.get(size);
            View view = jVar.f2935a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f2935a);
            this.f2892j.remove(size);
        }
        for (int size2 = this.f2890h.size() - 1; size2 >= 0; size2--) {
            G((RecyclerView.d0) this.f2890h.get(size2));
            this.f2890h.remove(size2);
        }
        int size3 = this.f2891i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = (RecyclerView.d0) this.f2891i.get(size3);
            d0Var.itemView.setAlpha(1.0f);
            A(d0Var);
            this.f2891i.remove(size3);
        }
        for (int size4 = this.f2893k.size() - 1; size4 >= 0; size4--) {
            X((i) this.f2893k.get(size4));
        }
        this.f2893k.clear();
        if (p()) {
            for (int size5 = this.f2895m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f2895m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f2935a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.f2935a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f2895m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f2894l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f2894l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = (RecyclerView.d0) arrayList2.get(size8);
                    d0Var2.itemView.setAlpha(1.0f);
                    A(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f2894l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f2896n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f2896n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f2896n.remove(arrayList3);
                    }
                }
            }
            U(this.f2899q);
            U(this.f2898p);
            U(this.f2897o);
            U(this.f2900r);
            i();
        }
    }

    public boolean p() {
        if (!this.f2891i.isEmpty() || !this.f2893k.isEmpty() || !this.f2892j.isEmpty() || !this.f2890h.isEmpty() || !this.f2898p.isEmpty() || !this.f2899q.isEmpty() || !this.f2897o.isEmpty() || !this.f2900r.isEmpty() || !this.f2895m.isEmpty() || !this.f2894l.isEmpty() || !this.f2896n.isEmpty()) {
            return true;
        }
        return false;
    }

    public void u() {
        long j10;
        long j11;
        boolean z10 = !this.f2890h.isEmpty();
        boolean z11 = !this.f2892j.isEmpty();
        boolean z12 = !this.f2893k.isEmpty();
        boolean z13 = !this.f2891i.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator it = this.f2890h.iterator();
            while (it.hasNext()) {
                T((RecyclerView.d0) it.next());
            }
            this.f2890h.clear();
            if (z11) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f2892j);
                this.f2895m.add(arrayList);
                this.f2892j.clear();
                a aVar = new a(arrayList);
                if (z10) {
                    c1.d0(((j) arrayList.get(0)).f2935a.itemView, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2893k);
                this.f2896n.add(arrayList2);
                this.f2893k.clear();
                b bVar = new b(arrayList2);
                if (z10) {
                    c1.d0(((i) arrayList2.get(0)).f2929a.itemView, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f2891i);
                this.f2894l.add(arrayList3);
                this.f2891i.clear();
                C0042c cVar = new C0042c(arrayList3);
                if (z10 || z11 || z12) {
                    long j12 = 0;
                    if (z10) {
                        j10 = o();
                    } else {
                        j10 = 0;
                    }
                    if (z11) {
                        j11 = n();
                    } else {
                        j11 = 0;
                    }
                    if (z12) {
                        j12 = m();
                    }
                    c1.d0(((RecyclerView.d0) arrayList3.get(0)).itemView, cVar, j10 + Math.max(j11, j12));
                    return;
                }
                cVar.run();
            }
        }
    }

    public boolean w(RecyclerView.d0 d0Var) {
        Z(d0Var);
        d0Var.itemView.setAlpha(0.0f);
        this.f2891i.add(d0Var);
        return true;
    }

    public boolean x(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
        if (d0Var == d0Var2) {
            return y(d0Var, i10, i11, i12, i13);
        }
        float translationX = d0Var.itemView.getTranslationX();
        float translationY = d0Var.itemView.getTranslationY();
        float alpha = d0Var.itemView.getAlpha();
        Z(d0Var);
        int i14 = (int) (((float) (i12 - i10)) - translationX);
        int i15 = (int) (((float) (i13 - i11)) - translationY);
        d0Var.itemView.setTranslationX(translationX);
        d0Var.itemView.setTranslationY(translationY);
        d0Var.itemView.setAlpha(alpha);
        if (d0Var2 != null) {
            Z(d0Var2);
            d0Var2.itemView.setTranslationX((float) (-i14));
            d0Var2.itemView.setTranslationY((float) (-i15));
            d0Var2.itemView.setAlpha(0.0f);
        }
        this.f2893k.add(new i(d0Var, d0Var2, i10, i11, i12, i13));
        return true;
    }

    public boolean y(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.itemView;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) d0Var.itemView.getTranslationY());
        Z(d0Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            E(d0Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX((float) (-i14));
        }
        if (i15 != 0) {
            view.setTranslationY((float) (-i15));
        }
        this.f2892j.add(new j(d0Var, translationX, translationY, i12, i13));
        return true;
    }

    public boolean z(RecyclerView.d0 d0Var) {
        Z(d0Var);
        this.f2890h.add(d0Var);
        return true;
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f2929a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.d0 f2930b;

        /* renamed from: c  reason: collision with root package name */
        public int f2931c;

        /* renamed from: d  reason: collision with root package name */
        public int f2932d;

        /* renamed from: e  reason: collision with root package name */
        public int f2933e;

        /* renamed from: f  reason: collision with root package name */
        public int f2934f;

        public i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f2929a = d0Var;
            this.f2930b = d0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2929a + ", newHolder=" + this.f2930b + ", fromX=" + this.f2931c + ", fromY=" + this.f2932d + ", toX=" + this.f2933e + ", toY=" + this.f2934f + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }

        public i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
            this(d0Var, d0Var2);
            this.f2931c = i10;
            this.f2932d = i11;
            this.f2933e = i12;
            this.f2934f = i13;
        }
    }
}
