package g5;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.fragment.app.t;
import java.util.List;
import t9.i;

public final class a1 extends t {

    /* renamed from: a  reason: collision with root package name */
    public List f16851a;

    /* renamed from: b  reason: collision with root package name */
    public List f16852b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a1(List list, List list2, o oVar) {
        super(oVar);
        i.g(list, "fragList");
        i.g(list2, "titleList");
        i.g(oVar, "fm");
        this.f16851a = list;
        this.f16852b = list2;
    }

    public int getCount() {
        return this.f16852b.size();
    }

    public Fragment getItem(int i10) {
        return (Fragment) this.f16851a.get(i10);
    }

    public CharSequence getPageTitle(int i10) {
        return (CharSequence) this.f16852b.get(i10);
    }
}
