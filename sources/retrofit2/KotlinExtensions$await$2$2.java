package retrofit2;

import ca.j;
import com.google.firebase.analytics.FirebaseAnalytics;
import h9.d;
import h9.l;
import h9.m;
import java.lang.reflect.Method;
import t9.i;

public final class KotlinExtensions$await$2$2 implements Callback<T> {
    final /* synthetic */ j $continuation;

    public KotlinExtensions$await$2$2(j jVar) {
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
            T body = response.body();
            if (body == null) {
                Object tag = call.request().tag(Invocation.class);
                if (tag == null) {
                    i.q();
                }
                i.c(tag, "call.request().tag(Invocation::class.java)!!");
                Method method = ((Invocation) tag).method();
                StringBuilder sb = new StringBuilder();
                sb.append("Response from ");
                i.c(method, FirebaseAnalytics.Param.METHOD);
                Class<?> declaringClass = method.getDeclaringClass();
                i.c(declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                d dVar = new d(sb.toString());
                j jVar = this.$continuation;
                l.a aVar = l.f17317a;
                jVar.resumeWith(l.a(m.a(dVar)));
                return;
            }
            this.$continuation.resumeWith(l.a(body));
            return;
        }
        j jVar2 = this.$continuation;
        HttpException httpException = new HttpException(response);
        l.a aVar2 = l.f17317a;
        jVar2.resumeWith(l.a(m.a(httpException)));
    }
}
