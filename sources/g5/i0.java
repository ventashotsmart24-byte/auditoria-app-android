package g5;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import java.util.ArrayList;
import t9.i;

public final class i0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f16932a;

    public i0(ArrayList arrayList) {
        i.g(arrayList, "viewList");
        this.f16932a = arrayList;
    }

    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        i.g(viewGroup, "container");
        i.g(obj, "object");
        viewGroup.removeView((View) this.f16932a.get(i10));
    }

    public int getCount() {
        return this.f16932a.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "container");
        Object obj = this.f16932a.get(i10);
        i.f(obj, "viewList[position]");
        View view = (View) obj;
        viewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj) {
        i.g(view, "view");
        i.g(obj, "object");
        return i.b(view, obj);
    }
}
