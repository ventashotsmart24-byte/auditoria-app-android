package a7;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;

public final /* synthetic */ class c implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f10695a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10696b;

    public /* synthetic */ c(List list, String str) {
        this.f10695a = list;
        this.f10696b = str;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        d.d(this.f10695a, this.f10696b, observableEmitter);
    }
}
