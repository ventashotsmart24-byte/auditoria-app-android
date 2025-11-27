package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;

public final /* synthetic */ class n implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f18537a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f18538b;

    public /* synthetic */ n(q qVar, List list) {
        this.f18537a = qVar;
        this.f18538b = list;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        q.v(this.f18537a, this.f18538b, observableEmitter);
    }
}
