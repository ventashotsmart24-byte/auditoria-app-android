package g5;

import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.fragment.app.w;
import java.util.ArrayList;
import t9.i;

public final class x0 extends w {

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f17167h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f17168i;

    /* renamed from: j  reason: collision with root package name */
    public int f17169j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x0(o oVar, ArrayList arrayList, ArrayList arrayList2) {
        super(oVar);
        i.g(oVar, "fm");
        i.g(arrayList, "mFragmentList");
        i.g(arrayList2, "mStringList");
        this.f17167h = arrayList;
        this.f17168i = arrayList2;
    }

    public int getCount() {
        return this.f17167h.size();
    }

    public Fragment getItem(int i10) {
        Object obj = this.f17167h.get(i10);
        i.f(obj, "mFragmentList[position]");
        return (Fragment) obj;
    }

    public int getItemPosition(Object obj) {
        i.g(obj, "object");
        int i10 = this.f17169j;
        if (i10 <= 0) {
            return super.getItemPosition(obj);
        }
        this.f17169j = i10 - 1;
        return -2;
    }

    public CharSequence getPageTitle(int i10) {
        Object obj = this.f17168i.get(i10);
        i.f(obj, "mStringList[position]");
        return (CharSequence) obj;
    }

    public void notifyDataSetChanged() {
        this.f17169j = getCount();
        super.notifyDataSetChanged();
    }

    public Parcelable saveState() {
        return null;
    }
}
