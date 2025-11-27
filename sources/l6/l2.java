package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import t9.w;

public final /* synthetic */ class l2 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w f18515a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w f18516b;

    public /* synthetic */ l2(w wVar, w wVar2) {
        this.f18515a = wVar;
        this.f18516b = wVar2;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        p2.o(this.f18515a, this.f18516b, observableEmitter);
    }
}
