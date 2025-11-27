package b6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import t9.w;

public final /* synthetic */ class h2 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l2 f10970a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w f10971b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w f10972c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ w f10973d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ w f10974e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ w f10975f;

    public /* synthetic */ h2(l2 l2Var, w wVar, w wVar2, w wVar3, w wVar4, w wVar5) {
        this.f10970a = l2Var;
        this.f10971b = wVar;
        this.f10972c = wVar2;
        this.f10973d = wVar3;
        this.f10974e = wVar4;
        this.f10975f = wVar5;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        l2.r3(this.f10970a, this.f10971b, this.f10972c, this.f10973d, this.f10974e, this.f10975f, observableEmitter);
    }
}
