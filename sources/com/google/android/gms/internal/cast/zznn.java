package com.google.android.gms.internal.cast;

import androidx.concurrent.futures.b;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

public abstract class zznn<V> extends zznp implements ListenableFuture<V> {
    /* access modifiers changed from: private */
    public static final boolean zza;
    private static final Logger zzb;
    /* access modifiers changed from: private */
    public static final zza zzc;
    private static final Object zzd = new Object();
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Object value;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile zzk waiters;

    abstract class zza {
        public /* synthetic */ zza(AnonymousClass1 r12) {
        }

        public abstract void zza(zzk zzk, @CheckForNull zzk zzk2);

        public abstract void zzb(zzk zzk, Thread thread);

        public abstract boolean zzc(zznn<?> zznn, @CheckForNull zzd zzd, zzd zzd2);

        public abstract boolean zzd(zznn<?> zznn, @CheckForNull Object obj, Object obj2);

        public abstract boolean zze(zznn<?> zznn, @CheckForNull zzk zzk, @CheckForNull zzk zzk2);
    }

    final class zzb {
        @CheckForNull
        static final zzb zza;
        @CheckForNull
        static final zzb zzb;
        final boolean zzc;
        @CheckForNull
        final Throwable zzd;

        static {
            if (zznn.zza) {
                zzb = null;
                zza = null;
                return;
            }
            zzb = new zzb(false, (Throwable) null);
            zza = new zzb(true, (Throwable) null);
        }

        public zzb(boolean z10, @CheckForNull Throwable th) {
            this.zzc = z10;
            this.zzd = th;
        }
    }

    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") {
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        public zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    final class zzd {
        static final zzd zza = new zzd();
        @CheckForNull
        zzd next;
        @CheckForNull
        final Runnable zzb;
        @CheckForNull
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zznn, zzk> zzc;
        final AtomicReferenceFieldUpdater<zznn, zzd> zzd;
        final AtomicReferenceFieldUpdater<zznn, Object> zze;

        public zze(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zznn, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zznn, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zznn, Object> atomicReferenceFieldUpdater5) {
            super((AnonymousClass1) null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        public final void zza(zzk zzk, @CheckForNull zzk zzk2) {
            this.zzb.lazySet(zzk, zzk2);
        }

        public final void zzb(zzk zzk, Thread thread) {
            this.zza.lazySet(zzk, thread);
        }

        public final boolean zzc(zznn<?> zznn, @CheckForNull zzd zzd2, zzd zzd3) {
            return b.a(this.zzd, zznn, zzd2, zzd3);
        }

        public final boolean zzd(zznn<?> zznn, @CheckForNull Object obj, Object obj2) {
            return b.a(this.zze, zznn, obj, obj2);
        }

        public final boolean zze(zznn<?> zznn, @CheckForNull zzk zzk, @CheckForNull zzk zzk2) {
            return b.a(this.zzc, zznn, zzk, zzk2);
        }
    }

    final class zzf<V> implements Runnable {
        final zznn<V> zza;
        final ListenableFuture<? extends V> zzb;

        public final void run() {
            throw null;
        }
    }

    final class zzg extends zza {
        public /* synthetic */ zzg(AnonymousClass1 r12) {
            super((AnonymousClass1) null);
        }

        public final void zza(zzk zzk, @CheckForNull zzk zzk2) {
            zzk.next = zzk2;
        }

        public final void zzb(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        public final boolean zzc(zznn<?> zznn, @CheckForNull zzd zzd, zzd zzd2) {
            synchronized (zznn) {
                if (zznn.listeners != zzd) {
                    return false;
                }
                zzd unused = zznn.listeners = zzd2;
                return true;
            }
        }

        public final boolean zzd(zznn<?> zznn, @CheckForNull Object obj, Object obj2) {
            synchronized (zznn) {
                if (zznn.value != obj) {
                    return false;
                }
                Object unused = zznn.value = obj2;
                return true;
            }
        }

        public final boolean zze(zznn<?> zznn, @CheckForNull zzk zzk, @CheckForNull zzk zzk2) {
            synchronized (zznn) {
                if (zznn.waiters != zzk) {
                    return false;
                }
                zzk unused = zznn.waiters = zzk2;
                return true;
            }
        }

        private zzg() {
            super((AnonymousClass1) null);
        }
    }

    interface zzh<V> extends ListenableFuture<V> {
    }

    abstract class zzi<V> extends zznn<V> implements zzh<V> {
    }

    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.cast.zznn.zzj.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.android.gms.internal.cast.zznn$zzk> r0 = com.google.android.gms.internal.cast.zznn.zzk.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.android.gms.internal.cast.zznn$zzj$1 r1 = new com.google.android.gms.internal.cast.zznn$zzj$1     // Catch:{ PrivilegedActionException -> 0x005d }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005d }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005d }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005d }
            L_0x0012:
                java.lang.Class<com.google.android.gms.internal.cast.zznn> r2 = com.google.android.gms.internal.cast.zznn.class
                java.lang.String r3 = "waiters"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzc = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "listeners"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzb = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "value"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zzd = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zze = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "next"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ Exception -> 0x0053 }
                zzf = r2     // Catch:{ Exception -> 0x0053 }
                zza = r1     // Catch:{ Exception -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                com.google.android.gms.internal.cast.zzdm.zza(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005d:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.String r2 = "Could not initialize intrinsics"
                java.lang.Throwable r0 = r0.getCause()
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zznn.zzj.<clinit>():void");
        }

        public /* synthetic */ zzj(AnonymousClass1 r12) {
            super((AnonymousClass1) null);
        }

        public final void zza(zzk zzk, @CheckForNull zzk zzk2) {
            zza.putObject(zzk, zzf, zzk2);
        }

        public final void zzb(zzk zzk, Thread thread) {
            zza.putObject(zzk, zze, thread);
        }

        public final boolean zzc(zznn<?> zznn, @CheckForNull zzd zzd2, zzd zzd3) {
            return b.a(zza, zznn, zzb, zzd2, zzd3);
        }

        public final boolean zzd(zznn<?> zznn, @CheckForNull Object obj, Object obj2) {
            return b.a(zza, zznn, zzd, obj, obj2);
        }

        public final boolean zze(zznn<?> zznn, @CheckForNull zzk zzk, @CheckForNull zzk zzk2) {
            return b.a(zza, zznn, zzc, zzk, zzk2);
        }

        private zzj() {
            super((AnonymousClass1) null);
        }
    }

    final class zzk {
        static final zzk zza = new zzk(false);
        @CheckForNull
        volatile zzk next;
        @CheckForNull
        volatile Thread thread;

        public zzk() {
            zznn.zzc.zzb(this, Thread.currentThread());
        }

        public zzk(boolean z10) {
        }
    }

    static {
        boolean z10;
        Throwable th;
        Throwable th2;
        zza zza2;
        Class<zzk> cls = zzk.class;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        zza = z10;
        Class<zznn> cls2 = zznn.class;
        zzb = Logger.getLogger(cls2.getName());
        try {
            zza2 = new zzj((AnonymousClass1) null);
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            zza2 = new zzg((AnonymousClass1) null);
        }
        zzc = zza2;
        if (th != null) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    private static Object zzk(ListenableFuture<?> listenableFuture) {
        Throwable zzh2;
        if (listenableFuture instanceof zzh) {
            Object obj = ((zznn) listenableFuture).value;
            if (obj instanceof zzb) {
                zzb zzb2 = (zzb) obj;
                if (zzb2.zzc) {
                    Throwable th = zzb2.zzd;
                    obj = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            obj.getClass();
            return obj;
        } else if ((listenableFuture instanceof zznp) && (zzh2 = ((zznp) listenableFuture).zzh()) != null) {
            return new zzc(zzh2);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!zza) && isCancelled) {
                zzb zzb3 = zzb.zzb;
                zzb3.getClass();
                return zzb3;
            }
            try {
                Object zzl = zzl(listenableFuture);
                if (isCancelled) {
                    String valueOf = String.valueOf(listenableFuture);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 84);
                    sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                    sb.append(valueOf);
                    return new zzb(false, new IllegalArgumentException(sb.toString()));
                } else if (zzl == null) {
                    return zzd;
                } else {
                    return zzl;
                }
            } catch (ExecutionException e10) {
                if (isCancelled) {
                    return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(listenableFuture)), e10));
                }
                return new zzc(e10.getCause());
            } catch (CancellationException e11) {
                if (!isCancelled) {
                    return new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(listenableFuture)), e11));
                }
                return new zzb(false, e11);
            } catch (Throwable th2) {
                return new zzc(th2);
            }
        }
    }

    private static <V> V zzl(Future<V> future) {
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

    private final void zzm(StringBuilder sb) {
        try {
            Object zzl = zzl(this);
            sb.append("SUCCESS, result=[");
            if (zzl == null) {
                sb.append("null");
            } else if (zzl == this) {
                sb.append("this future");
            } else {
                sb.append(zzl.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzl)));
            }
            sb.append("]");
        } catch (ExecutionException e10) {
            sb.append("FAILURE, cause=[");
            sb.append(e10.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e11) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e11.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zzn(StringBuilder sb) {
        String str;
        String str2;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzo(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("remaining delay=[");
                    sb2.append(delay);
                    sb2.append(" ms]");
                    str2 = sb2.toString();
                } else {
                    str2 = null;
                }
                str = zzdl.zza(str2);
            } catch (RuntimeException | StackOverflowError e10) {
                str = "Exception thrown from implementation: ".concat(String.valueOf(e10.getClass()));
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzm(sb);
        }
    }

    private final void zzo(StringBuilder sb, @CheckForNull Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e10) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e10.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    private static void zzp(zznn<?> zznn) {
        zznn<V> zznn2;
        zzd zzd2;
        zzd zzd3;
        zzd zzd4 = null;
        zznn<?> zznn3 = zznn;
        while (true) {
            zzk zzk2 = zznn3.waiters;
            if (zzc.zze(zznn3, zzk2, zzk.zza)) {
                while (zzk2 != null) {
                    Thread thread = zzk2.thread;
                    if (thread != null) {
                        zzk2.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzk2 = zzk2.next;
                }
                do {
                    zzd2 = zznn3.listeners;
                } while (!zzc.zzc(zznn3, zzd2, zzd.zza));
                while (true) {
                    zzd3 = zzd4;
                    zzd4 = zzd2;
                    if (zzd4 == null) {
                        break;
                    }
                    zzd2 = zzd4.next;
                    zzd4.next = zzd3;
                }
                while (zzd3 != null) {
                    zzd4 = zzd3.next;
                    Runnable runnable = zzd3.zzb;
                    runnable.getClass();
                    if (runnable instanceof zzf) {
                        zzf zzf2 = (zzf) runnable;
                        zznn<V> zznn4 = zzf2.zza;
                        if (zznn4.value == zzf2) {
                            if (zzc.zzd(zznn4, zzf2, zzk(zzf2.zzb))) {
                                zznn2 = zznn4;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = zzd3.zzc;
                        executor.getClass();
                        zzq(runnable, executor);
                    }
                    zzd3 = zzd4;
                }
                return;
            }
            zznn2 = zznn3;
            zznn3 = zznn2;
        }
    }

    private static void zzq(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), e10);
        }
    }

    private final void zzr(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zza) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (!zzc.zze(this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    private static final V zzs(Object obj) {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        } else if (obj == zzd) {
            return null;
        } else {
            return obj;
        }
    }

    public final void addListener(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzdj.zzc(runnable, "Runnable was null.");
        zzdj.zzc(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zza) {
            zzq(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzc.zzc(this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zza);
        zzq(runnable, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof com.google.android.gms.internal.cast.zznn.zzf
            r3 = r3 | r4
            if (r3 == 0) goto L_0x005f
            boolean r3 = zza
            if (r3 == 0) goto L_0x001f
            com.google.android.gms.internal.cast.zznn$zzb r3 = new com.google.android.gms.internal.cast.zznn$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0029
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.android.gms.internal.cast.zznn$zzb r3 = com.google.android.gms.internal.cast.zznn.zzb.zza
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.cast.zznn$zzb r3 = com.google.android.gms.internal.cast.zznn.zzb.zzb
        L_0x0026:
            r3.getClass()
        L_0x0029:
            r5 = 0
            r4 = r7
        L_0x002b:
            com.google.android.gms.internal.cast.zznn$zza r6 = zzc
            boolean r6 = r6.zzd(r4, r0, r3)
            if (r6 == 0) goto L_0x0058
            zzp(r4)
            boolean r4 = r0 instanceof com.google.android.gms.internal.cast.zznn.zzf
            if (r4 == 0) goto L_0x0056
            com.google.android.gms.internal.cast.zznn$zzf r0 = (com.google.android.gms.internal.cast.zznn.zzf) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.cast.zznn.zzh
            if (r4 == 0) goto L_0x0053
            r4 = r0
            com.google.android.gms.internal.cast.zznn r4 = (com.google.android.gms.internal.cast.zznn) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004b
            r5 = 1
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            boolean r6 = r0 instanceof com.google.android.gms.internal.cast.zznn.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0056
            r5 = 1
            goto L_0x002b
        L_0x0053:
            r0.cancel(r8)
        L_0x0056:
            r1 = 1
            goto L_0x005f
        L_0x0058:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.cast.zznn.zzf
            if (r6 != 0) goto L_0x002b
            r1 = r5
        L_0x005f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zznn.cancel(boolean):boolean");
    }

    public final V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                return zzs(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zza) {
                zzk zzk3 = new zzk();
                do {
                    zza zza2 = zzc;
                    zza2.zza(zzk3, zzk2);
                    if (zza2.zze(this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zzr(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zzf))));
                        return zzs(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zza);
            }
            Object obj3 = this.value;
            obj3.getClass();
            return zzs(obj3);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    public final boolean isDone() {
        boolean z10;
        Object obj = this.value;
        if (obj != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return (!(obj instanceof zzf)) & z10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.value instanceof zzb) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzm(sb);
        } else {
            zzn(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    @CheckForNull
    public final Throwable zzh() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    public boolean zzj(V v10) {
        if (!zzc.zzd(this, (Object) null, zzd)) {
            return false;
        }
        zzp(this);
        return true;
    }

    public final V get(long j10, TimeUnit timeUnit) {
        long j11 = j10;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j11);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z10 = true;
            if ((obj != null) && (!(obj instanceof zzf))) {
                return zzs(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zza) {
                    zzk zzk3 = new zzk();
                    do {
                        zza zza2 = zzc;
                        zza2.zza(zzk3, zzk2);
                        if (zza2.zze(this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                                        return zzs(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zzr(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzr(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zza);
                }
                Object obj3 = this.value;
                obj3.getClass();
                return zzs(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) && (!(obj4 instanceof zzf))) {
                    return zzs(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zznn = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j11);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = sb2.concat(" (plus ");
                long j12 = -nanos;
                long convert = timeUnit2.convert(j12, TimeUnit.NANOSECONDS);
                long nanos2 = j12 - timeUnit2.toNanos(convert);
                if (convert != 0 && nanos2 <= 1000) {
                    z10 = false;
                }
                if (convert > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z10) {
                        sb4 = sb4.concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z10) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(valueOf2.length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + zznn.length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(zznn);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }
}
