package com.titan.thumbnail;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import m8.b;
import m8.d;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import t9.i;

public final class ThumbnailRequest {
    public static final ThumbnailRequest INSTANCE = new ThumbnailRequest();
    /* access modifiers changed from: private */
    public static final String TAG = ThumbnailRequest.class.getSimpleName();
    private static long TIME_OUT = 15;
    private static final String baseUrl = baseUrl;
    /* access modifiers changed from: private */
    public static Disposable mDisposable;
    /* access modifiers changed from: private */
    public static ThumbnailCallback mthumbnailCallback;
    private static final ConnectionPool sConnectionPool = new ConnectionPool(5, 2, TimeUnit.MINUTES);

    private ThumbnailRequest() {
    }

    private final Retrofit getRetrofit(String str) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j10 = TIME_OUT;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder.connectTimeout(j10, timeUnit).readTimeout(TIME_OUT, timeUnit).writeTimeout(TIME_OUT, timeUnit).connectionPool(sConnectionPool).build();
        i.c(build, "builder.build()");
        Retrofit build2 = new Retrofit.Builder().baseUrl(baseUrl).client(build).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        i.c(build2, "Retrofit.Builder()\n     …e())\n            .build()");
        return build2;
    }

    private final Observable<ThumbnailResult> getThumbnailResult(String str) {
        Observable<R> compose = ((ThumbnailApi) getRetrofit(str).create(ThumbnailApi.class)).getThumbnail(str).compose(b.a());
        i.c(compose, "getRetrofit(snapInfoUrl)…chedulerHelper.io2main())");
        return compose;
    }

    /* access modifiers changed from: private */
    public final void request(String str) {
        if (d.a(str)) {
            ThumbnailCallback thumbnailCallback = mthumbnailCallback;
            if (thumbnailCallback != null) {
                thumbnailCallback.onGetThumbnail(false);
                return;
            }
            return;
        }
        Disposable disposable = mDisposable;
        if (disposable != null && !disposable.isDisposed()) {
            Disposable disposable2 = mDisposable;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            mDisposable = null;
        }
        getThumbnailResult(str).subscribe(new ThumbnailRequest$request$1());
    }

    public final void cancel() {
        Disposable disposable;
        Disposable disposable2 = mDisposable;
        if (!(disposable2 == null || disposable2.isDisposed() || (disposable = mDisposable) == null)) {
            disposable.dispose();
        }
        mDisposable = null;
    }

    public final void getThumbnail(String str) {
        i.h(str, "snapInfoUrl");
        Observable.just("ioSchedulers").compose(b.b()).subscribe(new ThumbnailRequest$getThumbnail$1(str), ThumbnailRequest$getThumbnail$2.INSTANCE);
    }

    public final void setThumbnailCallback(ThumbnailCallback thumbnailCallback) {
        mthumbnailCallback = thumbnailCallback;
    }
}
