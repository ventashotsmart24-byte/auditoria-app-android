package l6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import l6.u;

public final /* synthetic */ class v implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f18608a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u.b f18609b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u f18610c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f18611d;

    public /* synthetic */ v(String str, u.b bVar, u uVar, int i10) {
        this.f18608a = str;
        this.f18609b = bVar;
        this.f18610c = uVar;
        this.f18611d = i10;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        u.b.l(this.f18608a, this.f18609b, this.f18610c, this.f18611d, observableEmitter);
    }
}
