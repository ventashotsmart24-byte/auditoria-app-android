package a7;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;

public final /* synthetic */ class b implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f10693a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10694b;

    public /* synthetic */ b(List list, String str) {
        this.f10693a = list;
        this.f10694b = str;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        d.m(this.f10693a, this.f10694b, observableEmitter);
    }
}
