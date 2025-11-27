package f5;

import com.mobile.brasiltv.activity.MyFavListActivity;
import io.reactivex.functions.Function;
import java.util.ArrayList;

public final /* synthetic */ class f2 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyFavListActivity f16580a;

    public /* synthetic */ f2(MyFavListActivity myFavListActivity) {
        this.f16580a = myFavListActivity;
    }

    public final Object apply(Object obj) {
        return MyFavListActivity.D3(this.f16580a, (ArrayList) obj);
    }
}
