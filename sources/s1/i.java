package s1;

import android.content.Context;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class i implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9262a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9263b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9264c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f9265d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f9266e;

    public /* synthetic */ i(Context context, String str, String str2, boolean z10, String str3) {
        this.f9262a = context;
        this.f9263b = str;
        this.f9264c = str2;
        this.f9265d = z10;
        this.f9266e = str3;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        m.D(this.f9262a, this.f9263b, this.f9264c, this.f9265d, this.f9266e, observableEmitter);
    }
}
