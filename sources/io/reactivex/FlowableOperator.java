package io.reactivex;

import fb.c;
import io.reactivex.annotations.NonNull;

public interface FlowableOperator<Downstream, Upstream> {
    @NonNull
    c apply(@NonNull c cVar);
}
