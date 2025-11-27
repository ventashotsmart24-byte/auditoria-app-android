package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f10639a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callback f10640b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Throwable f10641c;

    public /* synthetic */ e(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r12, Callback callback, Throwable th) {
        this.f10639a = r12;
        this.f10640b = callback;
        this.f10641c = th;
    }

    public final void run() {
        this.f10639a.lambda$onFailure$1(this.f10640b, this.f10641c);
    }
}
