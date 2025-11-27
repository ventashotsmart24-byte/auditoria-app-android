package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.HashMap;
import java.util.List;
import t9.w;

public final /* synthetic */ class b2 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HashMap f17644a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g2 f17645b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f17646c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f17647d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ w f17648e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f17649f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List f17650g;

    public /* synthetic */ b2(HashMap hashMap, g2 g2Var, String str, String str2, w wVar, int i10, List list) {
        this.f17644a = hashMap;
        this.f17645b = g2Var;
        this.f17646c = str;
        this.f17647d = str2;
        this.f17648e = wVar;
        this.f17649f = i10;
        this.f17650g = list;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        g2.u0(this.f17644a, this.f17645b, this.f17646c, this.f17647d, this.f17648e, this.f17649f, this.f17650g, observableEmitter);
    }
}
