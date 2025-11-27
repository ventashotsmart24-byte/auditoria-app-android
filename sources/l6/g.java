package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;

public final /* synthetic */ class g implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f18412a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f18413b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f18414c;

    public /* synthetic */ g(i iVar, int i10, List list) {
        this.f18412a = iVar;
        this.f18413b = i10;
        this.f18414c = list;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        i.N(this.f18412a, this.f18413b, this.f18414c, observableEmitter);
    }
}
