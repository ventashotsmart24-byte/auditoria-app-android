package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;

@IgnoreJRERequirement
final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    @IgnoreJRERequirement
    public static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        private final Type responseType;

        public BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        public Type responseType() {
            return this.responseType;
        }

        public CompletableFuture<R> adapt(final Call<R> call) {
            final AnonymousClass1 r02 = new CompletableFuture<R>() {
                public boolean cancel(boolean z10) {
                    if (z10) {
                        call.cancel();
                    }
                    return super.cancel(z10);
                }
            };
            call.enqueue(new Callback<R>() {
                public void onFailure(Call<R> call, Throwable th) {
                    c.a(r02, th);
                }

                public void onResponse(Call<R> call, Response<R> response) {
                    if (response.isSuccessful()) {
                        b.a(r02, response.body());
                    } else {
                        c.a(r02, new HttpException(response));
                    }
                }
            });
            return r02;
        }
    }

    @IgnoreJRERequirement
    public static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        private final Type responseType;

        public ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        public Type responseType() {
            return this.responseType;
        }

        public CompletableFuture<Response<R>> adapt(final Call<R> call) {
            final AnonymousClass1 r02 = new CompletableFuture<Response<R>>() {
                public boolean cancel(boolean z10) {
                    if (z10) {
                        call.cancel();
                    }
                    return super.cancel(z10);
                }
            };
            call.enqueue(new Callback<R>() {
                public void onFailure(Call<R> call, Throwable th) {
                    c.a(r02, th);
                }

                public void onResponse(Call<R> call, Response<R> response) {
                    b.a(r02, response);
                }
            });
            return r02;
        }
    }

    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != a.a()) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            if (CallAdapter.Factory.getRawType(parameterUpperBound) != Response.class) {
                return new BodyCallAdapter(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
