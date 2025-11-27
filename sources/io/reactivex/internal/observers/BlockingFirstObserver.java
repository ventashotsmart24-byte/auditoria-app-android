package io.reactivex.internal.observers;

public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        }
        countDown();
    }

    public void onNext(T t10) {
        if (this.value == null) {
            this.value = t10;
            this.upstream.dispose();
            countDown();
        }
    }
}
