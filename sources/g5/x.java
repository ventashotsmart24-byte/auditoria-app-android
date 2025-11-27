package g5;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.fragment.app.t;
import java.util.List;
import t9.i;

public final class x extends t {

    /* renamed from: a  reason: collision with root package name */
    public List f17165a;

    /* renamed from: b  reason: collision with root package name */
    public List f17166b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(List list, List list2, o oVar) {
        super(oVar);
        i.g(list, "frag");
        i.g(list2, "titles");
        i.g(oVar, "fm");
        this.f17165a = list;
        this.f17166b = list2;
    }

    public int getCount() {
        return this.f17165a.size();
    }

    public Fragment getItem(int i10) {
        return (Fragment) this.f17165a.get(i10);
    }

    public int getItemPosition(Object obj) {
        i.g(obj, "frag");
        return super.getItemPosition(obj);
    }

    public CharSequence getPageTitle(int i10) {
        return (CharSequence) this.f17166b.get(i10);
    }
}
