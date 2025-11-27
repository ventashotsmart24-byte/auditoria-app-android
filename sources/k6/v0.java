package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import t9.w;

public final /* synthetic */ class v0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w f18121a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b1 f18122b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w f18123c;

    public /* synthetic */ v0(w wVar, b1 b1Var, w wVar2) {
        this.f18121a = wVar;
        this.f18122b = b1Var;
        this.f18123c = wVar2;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        b1.N0(this.f18121a, this.f18122b, this.f18123c, observableEmitter);
    }
}
