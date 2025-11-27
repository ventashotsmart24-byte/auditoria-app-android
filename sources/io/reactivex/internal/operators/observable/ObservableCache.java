package io.reactivex.internal.operators.observable;

import h3.b;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final AtomicBoolean once = new AtomicBoolean();
    volatile long size;
    Node<T> tail;
    int tailOffset;

    public static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final ObservableCache<T> parent;

        public CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.downstream = observer;
            this.parent = observableCache;
            this.node = observableCache.head;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.parent.remove(this);
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    public static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        public Node(int i10) {
            this.values = new Object[i10];
        }
    }

    public ObservableCache(Observable<T> observable, int i10) {
        super(observable);
        this.capacityHint = i10;
        Node<T> node = new Node<>(i10);
        this.head = node;
        this.tail = node;
        this.observers = new AtomicReference<>(EMPTY);
    }

    public void add(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.observers.get();
            if (cacheDisposableArr != TERMINATED) {
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[(length + 1)];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } else {
                return;
            }
        } while (!b.a(this.observers, cacheDisposableArr, cacheDisposableArr2));
    }

    public long cachedEventCount() {
        return this.size;
    }

    public boolean hasObservers() {
        if (((CacheDisposable[]) this.observers.get()).length != 0) {
            return true;
        }
        return false;
    }

    public boolean isConnected() {
        return this.once.get();
    }

    public void onComplete() {
        this.done = true;
        for (CacheDisposable replay : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            replay(replay);
        }
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        for (CacheDisposable replay : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            replay(replay);
        }
    }

    public void onNext(T t10) {
        int i10 = this.tailOffset;
        if (i10 == this.capacityHint) {
            Node<T> node = new Node<>(i10);
            node.values[0] = t10;
            this.tailOffset = 1;
            this.tail.next = node;
            this.tail = node;
        } else {
            this.tail.values[i10] = t10;
            this.tailOffset = i10 + 1;
        }
        this.size++;
        for (CacheDisposable replay : (CacheDisposable[]) this.observers.get()) {
            replay(replay);
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void remove(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.observers.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (cacheDisposableArr[i10] == cacheDisposable) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = EMPTY;
                    } else {
                        CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i10);
                        System.arraycopy(cacheDisposableArr, i10 + 1, cacheDisposableArr3, i10, (length - i10) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.observers, cacheDisposableArr, cacheDisposableArr2));
    }

    public void replay(CacheDisposable<T> cacheDisposable) {
        boolean z10;
        if (cacheDisposable.getAndIncrement() == 0) {
            long j10 = cacheDisposable.index;
            int i10 = cacheDisposable.offset;
            Node<T> node = cacheDisposable.node;
            Observer<? super T> observer = cacheDisposable.downstream;
            int i11 = this.capacityHint;
            int i12 = 1;
            while (!cacheDisposable.disposed) {
                boolean z11 = this.done;
                if (this.size == j10) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z11 && z10) {
                    cacheDisposable.node = null;
                    Throwable th = this.error;
                    if (th != null) {
                        observer.onError(th);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z10) {
                    if (i10 == i11) {
                        node = node.next;
                        i10 = 0;
                    }
                    observer.onNext(node.values[i10]);
                    i10++;
                    j10++;
                } else {
                    cacheDisposable.index = j10;
                    cacheDisposable.offset = i10;
                    cacheDisposable.node = node;
                    i12 = cacheDisposable.addAndGet(-i12);
                    if (i12 == 0) {
                        return;
                    }
                }
            }
            cacheDisposable.node = null;
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.onSubscribe(cacheDisposable);
        add(cacheDisposable);
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            replay(cacheDisposable);
        } else {
            this.source.subscribe(this);
        }
    }
}
