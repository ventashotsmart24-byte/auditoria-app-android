package f5;

import com.mobile.brasiltv.activity.MyFavListActivity;
import io.reactivex.functions.Predicate;
import s9.l;

public final /* synthetic */ class t1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f16683a;

    public /* synthetic */ t1(l lVar) {
        this.f16683a = lVar;
    }

    public final boolean test(Object obj) {
        return MyFavListActivity.d4(this.f16683a, obj);
    }
}
