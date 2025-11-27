package w5;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;

public final /* synthetic */ class i implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f19696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f19697b;

    public /* synthetic */ i(List list, String str) {
        this.f19696a = list;
        this.f19697b = str;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        m.N(this.f19696a, this.f19697b, observableEmitter);
    }
}
