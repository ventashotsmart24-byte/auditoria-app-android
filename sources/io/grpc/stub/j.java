package io.grpc.stub;

public interface j {
    void onCompleted();

    void onError(Throwable th);

    void onNext(Object obj);
}
