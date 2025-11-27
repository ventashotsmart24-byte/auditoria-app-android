package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    public T getResult() {
        return this.zza;
    }

    public void setResult(T t10) {
        this.zza = t10;
    }

    public Response(T t10) {
        this.zza = t10;
    }
}
