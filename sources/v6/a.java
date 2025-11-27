package v6;

import com.mobile.brasiltv.service.NetService;
import io.reactivex.functions.Function;
import s9.l;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f19680a;

    public /* synthetic */ a(l lVar) {
        this.f19680a = lVar;
    }

    public final Object apply(Object obj) {
        return NetService.k(this.f19680a, obj);
    }
}
