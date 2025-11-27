package retrofit2;

import ca.j;
import h9.l;
import h9.m;
import t9.i;

public final class KotlinExtensions$awaitResponse$2$2 implements Callback<T> {
    final /* synthetic */ j $continuation;

    public KotlinExtensions$awaitResponse$2$2(j jVar) {
        this.$continuation = jVar;
    }

    public void onFailure(Call<T> call, Throwable th) {
        i.h(call, "call");
        i.h(th, "t");
        j jVar = this.$continuation;
        l.a aVar = l.f17317a;
        jVar.resumeWith(l.a(m.a(th)));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        i.h(call, "call");
        i.h(response, "response");
        this.$continuation.resumeWith(l.a(response));
    }
}
