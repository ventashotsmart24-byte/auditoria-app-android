package com.efs.sdk.net.a.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

public final class e extends FilterOutputStream {

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f5453b = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    private final Future<Void> f5454a;

    public static class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f5455a;

        /* renamed from: b  reason: collision with root package name */
        private final OutputStream f5456b;

        public a(InputStream inputStream, OutputStream outputStream) {
            this.f5455a = inputStream;
            this.f5456b = outputStream;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void call() {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.f5455a);
            try {
                i.a(gZIPInputStream, this.f5456b, new byte[1024]);
                gZIPInputStream.close();
                this.f5456b.close();
                return null;
            } catch (Throwable th) {
                gZIPInputStream.close();
                this.f5456b.close();
                throw th;
            }
        }
    }

    private e(OutputStream outputStream, Future<Void> future) {
        super(outputStream);
        this.f5454a = future;
    }

    public static e a(OutputStream outputStream) {
        PipedInputStream pipedInputStream = new PipedInputStream();
        return new e(new PipedOutputStream(pipedInputStream), f5453b.submit(new a(pipedInputStream, outputStream)));
    }

    public final void close() {
        try {
            super.close();
        } finally {
            try {
                a(this.f5454a);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:0|1|2) */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
        r1 = r1.getCause();
        com.efs.sdk.net.a.a.d.a(r1, java.io.IOException.class);
        com.efs.sdk.net.a.a.d.a(r1, java.lang.Error.class);
        com.efs.sdk.net.a.a.d.a(r1, java.lang.RuntimeException.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        throw new java.lang.RuntimeException(r1);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T a(java.util.concurrent.Future<T> r1) {
        /*
        L_0x0000:
            java.lang.Object r1 = r1.get()     // Catch:{ InterruptedException -> 0x0000, ExecutionException -> 0x0005 }
            return r1
        L_0x0005:
            r1 = move-exception
            java.lang.Throwable r1 = r1.getCause()
            java.lang.Class<java.io.IOException> r0 = java.io.IOException.class
            com.efs.sdk.net.a.a.d.a(r1, r0)
            java.lang.Class<java.lang.Error> r0 = java.lang.Error.class
            com.efs.sdk.net.a.a.d.a(r1, r0)
            java.lang.Class<java.lang.RuntimeException> r0 = java.lang.RuntimeException.class
            com.efs.sdk.net.a.a.d.a(r1, r0)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.net.a.a.e.a(java.util.concurrent.Future):java.lang.Object");
    }
}
