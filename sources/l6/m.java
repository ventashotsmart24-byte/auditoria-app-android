package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;

public final /* synthetic */ class m implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f18517a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f18518b;

    public /* synthetic */ m(q qVar, List list) {
        this.f18517a = qVar;
        this.f18518b = list;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        q.x(this.f18517a, this.f18518b, observableEmitter);
    }
}
