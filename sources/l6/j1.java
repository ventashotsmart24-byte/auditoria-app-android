package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class j1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m1 f18470a;

    public /* synthetic */ j1(m1 m1Var) {
        this.f18470a = m1Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        m1.r(this.f18470a, observableEmitter);
    }
}
