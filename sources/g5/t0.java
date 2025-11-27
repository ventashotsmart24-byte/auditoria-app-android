package g5;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.fragment.app.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public abstract class t0 extends w {

    /* renamed from: h  reason: collision with root package name */
    public final HashMap f17118h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public WeakReference f17119i;

    /* renamed from: j  reason: collision with root package name */
    public final List f17120j;

    public t0(o oVar, List list) {
        super(oVar);
        this.f17120j = list;
    }

    public abstract Fragment a(int i10);

    public abstract CharSequence b(Object obj);

    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        this.f17119i = new WeakReference(viewGroup);
        this.f17118h.remove(Integer.valueOf(i10));
        super.destroyItem(viewGroup, i10, obj);
    }

    public int getCount() {
        List list = this.f17120j;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Fragment getItem(int i10) {
        Fragment fragment = (Fragment) this.f17118h.get(Integer.valueOf(i10));
        if (fragment != null) {
            return fragment;
        }
        this.f17120j.get(i10);
        Fragment a10 = a(i10);
        this.f17118h.put(Integer.valueOf(i10), a10);
        return a10;
    }

    public CharSequence getPageTitle(int i10) {
        return b(this.f17120j.get(i10));
    }
}
