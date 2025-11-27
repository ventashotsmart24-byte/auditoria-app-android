package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class e4 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k4 f17684a;

    public /* synthetic */ e4(k4 k4Var) {
        this.f17684a = k4Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        k4.s(this.f17684a, observableEmitter);
    }
}
