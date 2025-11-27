package f5;

import com.mobile.brasiltv.activity.MyFavListActivity;
import io.reactivex.functions.Predicate;
import s9.l;

public final /* synthetic */ class e2 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f16573a;

    public /* synthetic */ e2(l lVar) {
        this.f16573a = lVar;
    }

    public final boolean test(Object obj) {
        return MyFavListActivity.C3(this.f16573a, obj);
    }
}
