package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@Beta
public final class SimpleTimeLimiter implements TimeLimiter {
    private final ExecutorService executor;

    private SimpleTimeLimiter(ExecutorService executorService) {
        this.executor = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    /* access modifiers changed from: private */
    public <T> T callWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit, boolean z10) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<T> submit = this.executor.submit(callable);
        if (!z10) {
            return Uninterruptibles.getUninterruptibly(submit, j10, timeUnit);
        }
        try {
            return submit.get(j10, timeUnit);
        } catch (InterruptedException e10) {
            submit.cancel(true);
            throw e10;
        } catch (ExecutionException e11) {
            throw throwCause(e11, true);
        } catch (TimeoutException e12) {
            submit.cancel(true);
            throw new UncheckedTimeoutException((Throwable) e12);
        }
    }

    private static void checkPositiveTimeout(long j10) {
        boolean z10;
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "timeout must be positive: %s", j10);
    }

    public static SimpleTimeLimiter create(ExecutorService executorService) {
        return new SimpleTimeLimiter(executorService);
    }

    private static boolean declaresInterruptedEx(Method method) {
        for (Class<InterruptedException> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    private static Set<Method> findInterruptibleMethods(Class<?> cls) {
        HashSet newHashSet = Sets.newHashSet();
        for (Method method : cls.getMethods()) {
            if (declaresInterruptedEx(method)) {
                newHashSet.add(method);
            }
        }
        return newHashSet;
    }

    /* access modifiers changed from: private */
    public static Exception throwCause(Exception exc, boolean z10) {
        Throwable cause = exc.getCause();
        if (cause != null) {
            if (z10) {
                cause.setStackTrace((StackTraceElement[]) ObjectArrays.concat(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
            }
            if (cause instanceof Exception) {
                throw ((Exception) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw exc;
            }
        } else {
            throw exc;
        }
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        } else if (th instanceof RuntimeException) {
            throw new UncheckedExecutionException(th);
        } else {
            throw new ExecutionException(th);
        }
    }

    private void wrapAndThrowRuntimeExecutionExceptionOrError(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        throw new UncheckedExecutionException(th);
    }

    @CanIgnoreReturnValue
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<T> submit = this.executor.submit(callable);
        try {
            return Uninterruptibles.getUninterruptibly(submit, j10, timeUnit);
        } catch (TimeoutException e10) {
            submit.cancel(true);
            throw e10;
        } catch (ExecutionException e11) {
            wrapAndThrowExecutionExceptionOrError(e11.getCause());
            throw new AssertionError();
        }
    }

    public <T> T newProxy(T t10, Class<T> cls, long j10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t10);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Preconditions.checkArgument(cls.isInterface(), "interfaceType must be an interface type");
        final Set<Method> findInterruptibleMethods = findInterruptibleMethods(cls);
        final T t11 = t10;
        final long j11 = j10;
        final TimeUnit timeUnit2 = timeUnit;
        return newProxy(cls, new InvocationHandler() {
            /* access modifiers changed from: private */
            public static /* synthetic */ Object lambda$invoke$0(Method method, Object obj, Object[] objArr) {
                try {
                    return method.invoke(obj, objArr);
                } catch (InvocationTargetException e10) {
                    throw SimpleTimeLimiter.throwCause(e10, false);
                }
            }

            @CheckForNull
            public Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) {
                return SimpleTimeLimiter.this.callWithTimeout(new k(method, t11, objArr), j11, timeUnit2, findInterruptibleMethods.contains(method));
            }
        });
    }

    public void runUninterruptiblyWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<?> submit = this.executor.submit(runnable);
        try {
            Uninterruptibles.getUninterruptibly(submit, j10, timeUnit);
        } catch (TimeoutException e10) {
            submit.cancel(true);
            throw e10;
        } catch (ExecutionException e11) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e11.getCause());
            throw new AssertionError();
        }
    }

    public void runWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<?> submit = this.executor.submit(runnable);
        try {
            submit.get(j10, timeUnit);
        } catch (InterruptedException | TimeoutException e10) {
            submit.cancel(true);
            throw e10;
        } catch (ExecutionException e11) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e11.getCause());
            throw new AssertionError();
        }
    }

    private static <T> T newProxy(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    @CanIgnoreReturnValue
    public <T> T callWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<T> submit = this.executor.submit(callable);
        try {
            return submit.get(j10, timeUnit);
        } catch (InterruptedException | TimeoutException e10) {
            submit.cancel(true);
            throw e10;
        } catch (ExecutionException e11) {
            wrapAndThrowExecutionExceptionOrError(e11.getCause());
            throw new AssertionError();
        }
    }
}
