package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    @GwtIncompatible
    public static void awaitTerminationUninterruptibly(ExecutorService executorService) {
        Verify.verify(awaitTerminationUninterruptibly(executorService, Long.MAX_VALUE, TimeUnit.NANOSECONDS));
    }

    @GwtIncompatible
    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        boolean z10 = false;
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public static <V> V getUninterruptibly(Future<V> future) {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    @GwtIncompatible
    public static void joinUninterruptibly(Thread thread) {
        boolean z10 = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    @GwtIncompatible
    public static <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e10) {
        boolean z10 = false;
        while (true) {
            try {
                blockingQueue.put(e10);
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    @GwtIncompatible
    public static void sleepUninterruptibly(long j10, TimeUnit timeUnit) {
        long nanos;
        long nanoTime;
        boolean z10 = false;
        try {
            nanos = timeUnit.toNanos(j10);
            nanoTime = System.nanoTime() + nanos;
            while (true) {
                TimeUnit.NANOSECONDS.sleep(nanos);
                break;
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused) {
            z10 = true;
            nanos = nanoTime - System.nanoTime();
        } catch (Throwable th) {
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    public static <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        E take;
        boolean z10 = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    @GwtIncompatible
    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long j10, TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, j10, timeUnit);
    }

    @GwtIncompatible
    public static boolean tryLockUninterruptibly(Lock lock, long j10, TimeUnit timeUnit) {
        long nanos;
        boolean tryLock;
        boolean z10 = false;
        try {
            nanos = timeUnit.toNanos(j10);
            while (true) {
                tryLock = lock.tryLock(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            return tryLock;
        } catch (InterruptedException unused) {
            z10 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    public static boolean awaitTerminationUninterruptibly(ExecutorService executorService, long j10, TimeUnit timeUnit) {
        long nanos;
        boolean awaitTermination;
        boolean z10 = false;
        try {
            nanos = timeUnit.toNanos(j10);
            while (true) {
                awaitTermination = executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            return awaitTermination;
        } catch (InterruptedException unused) {
            z10 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, int i10, long j10, TimeUnit timeUnit) {
        long nanos;
        boolean tryAcquire;
        boolean z10 = false;
        try {
            nanos = timeUnit.toNanos(j10);
            while (true) {
                tryAcquire = semaphore.tryAcquire(i10, nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            return tryAcquire;
        } catch (InterruptedException unused) {
            z10 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j10, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z10 = false;
        try {
            nanos = timeUnit.toNanos(j10);
            while (true) {
                await = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z10 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> future, long j10, TimeUnit timeUnit) {
        long nanos;
        V v10;
        boolean z10 = false;
        try {
            nanos = timeUnit.toNanos(j10);
            while (true) {
                v10 = future.get(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            return v10;
        } catch (InterruptedException unused) {
            z10 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    public static void joinUninterruptibly(Thread thread, long j10, TimeUnit timeUnit) {
        long nanos;
        long nanoTime;
        Preconditions.checkNotNull(thread);
        boolean z10 = false;
        try {
            nanos = timeUnit.toNanos(j10);
            nanoTime = System.nanoTime() + nanos;
            while (true) {
                TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
                break;
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused) {
            z10 = true;
            nanos = nanoTime - System.nanoTime();
        } catch (Throwable th) {
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    public static boolean awaitUninterruptibly(Condition condition, long j10, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z10 = false;
        try {
            nanos = timeUnit.toNanos(j10);
            while (true) {
                await = condition.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z10 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }
}
