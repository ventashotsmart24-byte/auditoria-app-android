package io.reactivex;

import fb.b;
import io.reactivex.annotations.NonNull;

public interface FlowableTransformer<Upstream, Downstream> {
    @NonNull
    b apply(@NonNull Flowable<Upstream> flowable);
}
