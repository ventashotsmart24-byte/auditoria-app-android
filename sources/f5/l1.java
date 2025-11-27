package f5;

import com.mobile.brasiltv.activity.MyFavListActivity;
import io.reactivex.functions.Predicate;
import s9.l;

public final /* synthetic */ class l1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f16625a;

    public /* synthetic */ l1(l lVar) {
        this.f16625a = lVar;
    }

    public final boolean test(Object obj) {
        return MyFavListActivity.y3(this.f16625a, obj);
    }
}
