package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import l6.d1;

public final /* synthetic */ class e1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f18403a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1.b f18404b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d1 f18405c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f18406d;

    public /* synthetic */ e1(String str, d1.b bVar, d1 d1Var, int i10) {
        this.f18403a = str;
        this.f18404b = bVar;
        this.f18405c = d1Var;
        this.f18406d = i10;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        d1.b.l(this.f18403a, this.f18404b, this.f18405c, this.f18406d, observableEmitter);
    }
}
