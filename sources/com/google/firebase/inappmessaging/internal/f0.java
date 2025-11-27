package com.google.firebase.inappmessaging.internal;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class f0 implements Function {
    public final Object apply(Object obj) {
        return Observable.fromIterable((List) obj);
    }
}
