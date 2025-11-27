package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;

public final /* synthetic */ class x1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z1 f18620a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f18621b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f18622c;

    public /* synthetic */ x1(z1 z1Var, int i10, List list) {
        this.f18620a = z1Var;
        this.f18621b = i10;
        this.f18622c = list;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        z1.g0(this.f18620a, this.f18621b, this.f18622c, observableEmitter);
    }
}
