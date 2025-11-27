package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class t2 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h3 f18104a;

    public /* synthetic */ t2(h3 h3Var) {
        this.f18104a = h3Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        h3.H(this.f18104a, observableEmitter);
    }
}
