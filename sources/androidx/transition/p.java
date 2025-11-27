package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import b0.c1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    public static n f3234a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static ThreadLocal f3235b = new ThreadLocal();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList f3236c = new ArrayList();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public n f3237a;

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup f3238b;

        /* renamed from: androidx.transition.p$a$a  reason: collision with other inner class name */
        public class C0054a extends o {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ androidx.collection.a f3239a;

            public C0054a(androidx.collection.a aVar) {
                this.f3239a = aVar;
            }

            public void d(n nVar) {
                ((ArrayList) this.f3239a.get(a.this.f3238b)).remove(nVar);
                nVar.removeListener(this);
            }
        }

        public a(n nVar, ViewGroup viewGroup) {
            this.f3237a = nVar;
            this.f3238b = viewGroup;
        }

        public final void a() {
            this.f3238b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f3238b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!p.f3236c.remove(this.f3238b)) {
                return true;
            }
            androidx.collection.a b10 = p.b();
            ArrayList arrayList = (ArrayList) b10.get(this.f3238b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                b10.put(this.f3238b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f3237a);
            this.f3237a.addListener(new C0054a(b10));
            this.f3237a.captureValues(this.f3238b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).resume(this.f3238b);
                }
            }
            this.f3237a.playTransition(this.f3238b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            p.f3236c.remove(this.f3238b);
            ArrayList arrayList = (ArrayList) p.b().get(this.f3238b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).resume(this.f3238b);
                }
            }
            this.f3237a.clearValues(true);
        }
    }

    public static void a(ViewGroup viewGroup, n nVar) {
        if (!f3236c.contains(viewGroup) && c1.Q(viewGroup)) {
            f3236c.add(viewGroup);
            if (nVar == null) {
                nVar = f3234a;
            }
            n clone = nVar.clone();
            d(viewGroup, clone);
            m.b(viewGroup, (m) null);
            c(viewGroup, clone);
        }
    }

    public static androidx.collection.a b() {
        androidx.collection.a aVar;
        WeakReference weakReference = (WeakReference) f3235b.get();
        if (weakReference != null && (aVar = (androidx.collection.a) weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a aVar2 = new androidx.collection.a();
        f3235b.set(new WeakReference(aVar2));
        return aVar2;
    }

    public static void c(ViewGroup viewGroup, n nVar) {
        if (nVar != null && viewGroup != null) {
            a aVar = new a(nVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    public static void d(ViewGroup viewGroup, n nVar) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((n) it.next()).pause(viewGroup);
            }
        }
        if (nVar != null) {
            nVar.captureValues(viewGroup, true);
        }
        m.a(viewGroup);
    }
}
