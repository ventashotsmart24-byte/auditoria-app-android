package b6;

import b6.r1;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class w1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f11172a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r1 f11173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f11174c;

    public /* synthetic */ w1(String str, r1 r1Var, int i10) {
        this.f11172a = str;
        this.f11173b = r1Var;
        this.f11174c = i10;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        r1.o.l(this.f11172a, this.f11173b, this.f11174c, observableEmitter);
    }
}
