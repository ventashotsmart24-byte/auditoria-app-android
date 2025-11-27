package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class t0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z0 f18590a;

    public /* synthetic */ t0(z0 z0Var) {
        this.f18590a = z0Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        z0.r(this.f18590a, observableEmitter);
    }
}
