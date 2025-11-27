package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class h4 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k4 f17824a;

    public /* synthetic */ h4(k4 k4Var) {
        this.f17824a = k4Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        k4.G(this.f17824a, observableEmitter);
    }
}
