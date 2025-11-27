package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class k0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b1 f17907a;

    public /* synthetic */ k0(b1 b1Var) {
        this.f17907a = b1Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        b1.h1(this.f17907a, observableEmitter);
    }
}
