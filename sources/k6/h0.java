package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class h0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j0 f17804a;

    public /* synthetic */ h0(j0 j0Var) {
        this.f17804a = j0Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        j0.J(this.f17804a, observableEmitter);
    }
}
