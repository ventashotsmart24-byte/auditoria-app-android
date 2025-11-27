package k6;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class i implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f17825a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f17826b;

    public /* synthetic */ i(o oVar, SwitchAccountBean switchAccountBean) {
        this.f17825a = oVar;
        this.f17826b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        o.H(this.f17825a, this.f17826b, observableEmitter);
    }
}
