package w5;

import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class f implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMsg f19693a;

    public /* synthetic */ f(InAppMsg inAppMsg) {
        this.f19693a = inAppMsg;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        m.T(this.f19693a, observableEmitter);
    }
}
