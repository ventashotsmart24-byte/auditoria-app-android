package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.d;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class y {

    /* renamed from: a  reason: collision with root package name */
    public final k f2171a;

    /* renamed from: b  reason: collision with root package name */
    public final ClassLoader f2172b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f2173c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public int f2174d;

    /* renamed from: e  reason: collision with root package name */
    public int f2175e;

    /* renamed from: f  reason: collision with root package name */
    public int f2176f;

    /* renamed from: g  reason: collision with root package name */
    public int f2177g;

    /* renamed from: h  reason: collision with root package name */
    public int f2178h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2179i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2180j = true;

    /* renamed from: k  reason: collision with root package name */
    public String f2181k;

    /* renamed from: l  reason: collision with root package name */
    public int f2182l;

    /* renamed from: m  reason: collision with root package name */
    public CharSequence f2183m;

    /* renamed from: n  reason: collision with root package name */
    public int f2184n;

    /* renamed from: o  reason: collision with root package name */
    public CharSequence f2185o;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList f2186p;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList f2187q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2188r = false;

    /* renamed from: s  reason: collision with root package name */
    public ArrayList f2189s;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2190a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f2191b;

        /* renamed from: c  reason: collision with root package name */
        public int f2192c;

        /* renamed from: d  reason: collision with root package name */
        public int f2193d;

        /* renamed from: e  reason: collision with root package name */
        public int f2194e;

        /* renamed from: f  reason: collision with root package name */
        public int f2195f;

        /* renamed from: g  reason: collision with root package name */
        public d.c f2196g;

        /* renamed from: h  reason: collision with root package name */
        public d.c f2197h;

        public a() {
        }

        public a(int i10, Fragment fragment) {
            this.f2190a = i10;
            this.f2191b = fragment;
            d.c cVar = d.c.RESUMED;
            this.f2196g = cVar;
            this.f2197h = cVar;
        }

        public a(int i10, Fragment fragment, d.c cVar) {
            this.f2190a = i10;
            this.f2191b = fragment;
            this.f2196g = fragment.mMaxState;
            this.f2197h = cVar;
        }
    }

    public y(k kVar, ClassLoader classLoader) {
        this.f2171a = kVar;
        this.f2172b = classLoader;
    }

    public y b(int i10, Fragment fragment) {
        n(i10, fragment, (String) null, 1);
        return this;
    }

    public y c(int i10, Fragment fragment, String str) {
        n(i10, fragment, str, 1);
        return this;
    }

    public y d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public y e(Fragment fragment, String str) {
        n(0, fragment, str, 1);
        return this;
    }

    public void f(a aVar) {
        this.f2173c.add(aVar);
        aVar.f2192c = this.f2174d;
        aVar.f2193d = this.f2175e;
        aVar.f2194e = this.f2176f;
        aVar.f2195f = this.f2177g;
    }

    public y g(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract void k();

    public y l(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public y m() {
        if (!this.f2179i) {
            this.f2180j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public void n(int i10, Fragment fragment, String str, int i11) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 == null || str.equals(str2)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i10 != 0) {
            if (i10 != -1) {
                int i12 = fragment.mFragmentId;
                if (i12 == 0 || i12 == i10) {
                    fragment.mFragmentId = i10;
                    fragment.mContainerId = i10;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i10);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        f(new a(i11, fragment));
    }

    public y o(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public y p(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public y q(int i10, Fragment fragment) {
        return r(i10, fragment, (String) null);
    }

    public y r(int i10, Fragment fragment, String str) {
        if (i10 != 0) {
            n(i10, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public y s(Fragment fragment, d.c cVar) {
        f(new a(10, fragment, cVar));
        return this;
    }

    public y t(boolean z10) {
        this.f2188r = z10;
        return this;
    }

    public y u(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
