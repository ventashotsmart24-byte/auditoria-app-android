package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import t9.w;

public final /* synthetic */ class n1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w f18551a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w f18552b;

    public /* synthetic */ n1(w wVar, w wVar2) {
        this.f18551a = wVar;
        this.f18552b = wVar2;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        z1.T(this.f18551a, this.f18552b, observableEmitter);
    }
}
