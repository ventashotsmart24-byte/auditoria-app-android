package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class m2 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p2 f17951a;

    public /* synthetic */ m2(p2 p2Var) {
        this.f17951a = p2Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        p2.y(this.f17951a, observableEmitter);
    }
}
