package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import t9.w;

public final /* synthetic */ class h0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w f18434a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w f18435b;

    public /* synthetic */ h0(w wVar, w wVar2) {
        this.f18434a = wVar;
        this.f18435b = wVar2;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        n0.y(this.f18434a, this.f18435b, observableEmitter);
    }
}
