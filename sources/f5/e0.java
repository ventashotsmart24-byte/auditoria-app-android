package f5;

import com.mobile.brasiltv.activity.ColumnListAty;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class e0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f16570a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ColumnListAty f16571b;

    public /* synthetic */ e0(List list, ColumnListAty columnListAty) {
        this.f16570a = list;
        this.f16571b = columnListAty;
    }

    public final Object call() {
        return ColumnListAty.r3(this.f16570a, this.f16571b);
    }
}
