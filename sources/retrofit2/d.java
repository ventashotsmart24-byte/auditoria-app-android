package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f10636a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callback f10637b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Response f10638c;

    public /* synthetic */ d(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r12, Callback callback, Response response) {
        this.f10636a = r12;
        this.f10637b = callback;
        this.f10638c = response;
    }

    public final void run() {
        this.f10636a.lambda$onResponse$0(this.f10637b, this.f10638c);
    }
}
