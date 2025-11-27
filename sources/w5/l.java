package w5;

import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class l implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMsg f19700a;

    public /* synthetic */ l(InAppMsg inAppMsg) {
        this.f19700a = inAppMsg;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        m.s(this.f19700a, observableEmitter);
    }
}
