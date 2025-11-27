package retrofit2;

import ca.j;
import h9.l;
import h9.m;
import t9.i;

public final class KotlinExtensions$await$4$2 implements Callback<T> {
    final /* synthetic */ j $continuation;

    public KotlinExtensions$await$4$2(j jVar) {
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
        if (response.isSuccessful()) {
            this.$continuation.resumeWith(l.a(response.body()));
            return;
        }
        j jVar = this.$continuation;
        HttpException httpException = new HttpException(response);
        l.a aVar = l.f17317a;
        jVar.resumeWith(l.a(m.a(httpException)));
    }
}
