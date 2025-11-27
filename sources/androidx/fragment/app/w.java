package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.d;
import androidx.viewpager.widget.a;
import java.util.ArrayList;
import m7.f;

public abstract class w extends a {

    /* renamed from: a  reason: collision with root package name */
    public final o f2161a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2162b;

    /* renamed from: c  reason: collision with root package name */
    public y f2163c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f2164d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f2165e;

    /* renamed from: f  reason: collision with root package name */
    public Fragment f2166f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2167g;

    public w(o oVar) {
        this(oVar, 0);
    }

    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment.m mVar;
        Fragment fragment = (Fragment) obj;
        if (this.f2163c == null) {
            this.f2163c = this.f2161a.m();
        }
        while (this.f2164d.size() <= i10) {
            this.f2164d.add((Object) null);
        }
        ArrayList arrayList = this.f2164d;
        if (fragment.isAdded()) {
            mVar = this.f2161a.k1(fragment);
        } else {
            mVar = null;
        }
        arrayList.set(i10, mVar);
        this.f2165e.set(i10, (Object) null);
        this.f2163c.p(fragment);
        if (fragment.equals(this.f2166f)) {
            this.f2166f = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        y yVar = this.f2163c;
        if (yVar != null) {
            if (!this.f2167g) {
                try {
                    this.f2167g = true;
                    yVar.k();
                    this.f2167g = false;
                } catch (Throwable th) {
                    this.f2167g = false;
                    throw th;
                }
            }
            this.f2163c = null;
        }
    }

    public abstract Fragment getItem(int i10);

    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        Fragment.m mVar;
        Fragment fragment;
        if (this.f2165e.size() > i10 && (fragment = (Fragment) this.f2165e.get(i10)) != null) {
            return fragment;
        }
        if (this.f2163c == null) {
            this.f2163c = this.f2161a.m();
        }
        Fragment item = getItem(i10);
        if (this.f2164d.size() > i10 && (mVar = (Fragment.m) this.f2164d.get(i10)) != null) {
            item.setInitialSavedState(mVar);
        }
        while (this.f2165e.size() <= i10) {
            this.f2165e.add((Object) null);
        }
        item.setMenuVisibility(false);
        if (this.f2162b == 0) {
            item.setUserVisibleHint(false);
        }
        this.f2165e.set(i10, item);
        this.f2163c.b(viewGroup.getId(), item);
        if (this.f2162b == 1) {
            this.f2163c.s(item, d.c.STARTED);
        }
        return item;
    }

    public boolean isViewFromObject(View view, Object obj) {
        if (((Fragment) obj).getView() == view) {
            return true;
        }
        return false;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f2164d.clear();
            this.f2165e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f2164d.add((Fragment.m) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith(f.f7907a)) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment o02 = this.f2161a.o0(bundle, str);
                    if (o02 != null) {
                        while (this.f2165e.size() <= parseInt) {
                            this.f2165e.add((Object) null);
                        }
                        o02.setMenuVisibility(false);
                        this.f2165e.set(parseInt, o02);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Bad fragment at key ");
                        sb.append(str);
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.f2164d.size() > 0) {
            bundle = new Bundle();
            Fragment.m[] mVarArr = new Fragment.m[this.f2164d.size()];
            this.f2164d.toArray(mVarArr);
            bundle.putParcelableArray("states", mVarArr);
        } else {
            bundle = null;
        }
        for (int i10 = 0; i10 < this.f2165e.size(); i10++) {
            Fragment fragment = (Fragment) this.f2165e.get(i10);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f2161a.b1(bundle, f.f7907a + i10, fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f2166f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f2162b == 1) {
                    if (this.f2163c == null) {
                        this.f2163c = this.f2161a.m();
                    }
                    this.f2163c.s(this.f2166f, d.c.STARTED);
                } else {
                    this.f2166f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f2162b == 1) {
                if (this.f2163c == null) {
                    this.f2163c = this.f2161a.m();
                }
                this.f2163c.s(fragment, d.c.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f2166f = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public w(o oVar, int i10) {
        this.f2163c = null;
        this.f2164d = new ArrayList();
        this.f2165e = new ArrayList();
        this.f2166f = null;
        this.f2161a = oVar;
        this.f2162b = i10;
    }
}
