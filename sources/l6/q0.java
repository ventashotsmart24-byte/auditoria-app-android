package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class q0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z0 f18576a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f18577b;

    public /* synthetic */ q0(z0 z0Var, String str) {
        this.f18576a = z0Var;
        this.f18577b = str;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        z0.y(this.f18576a, this.f18577b, observableEmitter);
    }
}
