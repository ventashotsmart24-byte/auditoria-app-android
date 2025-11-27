package k6;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class l implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f17928a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f17929b;

    public /* synthetic */ l(o oVar, SwitchAccountBean switchAccountBean) {
        this.f17928a = oVar;
        this.f17929b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        o.D(this.f17928a, this.f17929b, observableEmitter);
    }
}
