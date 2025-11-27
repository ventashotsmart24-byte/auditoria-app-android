package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class g implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f17713a;

    public /* synthetic */ g(o oVar) {
        this.f17713a = oVar;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        o.w(this.f17713a, observableEmitter);
    }
}
