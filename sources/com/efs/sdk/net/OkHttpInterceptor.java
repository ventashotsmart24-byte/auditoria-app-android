package com.efs.sdk.net;

import com.efs.sdk.net.a.a.e;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class OkHttpInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final f f5426a = g.c();

    public static class a extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        private final ResponseBody f5427a;

        /* renamed from: b  reason: collision with root package name */
        private final BufferedSource f5428b;

        public a(ResponseBody responseBody, InputStream inputStream) {
            this.f5427a = responseBody;
            this.f5428b = Okio.buffer(Okio.source(inputStream));
        }

        public final long contentLength() {
            return this.f5427a.contentLength();
        }

        public final MediaType contentType() {
            return this.f5427a.contentType();
        }

        public final BufferedSource source() {
            return this.f5428b;
        }
    }

    public static class b implements f.b {

        /* renamed from: a  reason: collision with root package name */
        private final String f5429a;

        /* renamed from: b  reason: collision with root package name */
        private final Request f5430b;

        /* renamed from: c  reason: collision with root package name */
        private h f5431c;

        public b(String str, Request request, h hVar) {
            this.f5429a = str;
            this.f5430b = request;
            this.f5431c = hVar;
        }

        public final String a() {
            return this.f5429a;
        }

        public final String b() {
            return this.f5430b.url().toString();
        }

        public final String c() {
            return this.f5430b.method();
        }

        /* JADX INFO: finally extract failed */
        public final byte[] d() {
            OutputStream outputStream;
            RequestBody body = this.f5430b.body();
            if (body == null) {
                return null;
            }
            h hVar = this.f5431c;
            String header = this.f5430b.header("Content-Encoding");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if ("gzip".equals(header)) {
                outputStream = e.a((OutputStream) byteArrayOutputStream);
            } else if ("deflate".equals(header)) {
                outputStream = new InflaterOutputStream(byteArrayOutputStream);
            } else {
                outputStream = byteArrayOutputStream;
            }
            com.efs.sdk.net.a.a.a aVar = new com.efs.sdk.net.a.a.a(outputStream);
            hVar.f5462c = aVar;
            hVar.f5461b = byteArrayOutputStream;
            BufferedSink buffer = Okio.buffer(Okio.sink((OutputStream) aVar));
            try {
                body.writeTo(buffer);
                buffer.close();
                h hVar2 = this.f5431c;
                hVar2.b();
                return hVar2.f5461b.toByteArray();
            } catch (Throwable th) {
                buffer.close();
                throw th;
            }
        }

        public final int e() {
            return this.f5430b.headers().size();
        }

        public final String a(int i10) {
            return this.f5430b.headers().name(i10);
        }

        public final String b(int i10) {
            return this.f5430b.headers().value(i10);
        }
    }

    public static class c implements f.d {

        /* renamed from: a  reason: collision with root package name */
        private final String f5432a;

        /* renamed from: b  reason: collision with root package name */
        private final Request f5433b;

        /* renamed from: c  reason: collision with root package name */
        private final Response f5434c;

        /* renamed from: d  reason: collision with root package name */
        private final Connection f5435d;

        public c(String str, Request request, Response response, Connection connection) {
            this.f5432a = str;
            this.f5433b = request;
            this.f5434c = response;
            this.f5435d = connection;
        }

        public final String a() {
            return this.f5432a;
        }

        public final int b() {
            return this.f5434c.code();
        }

        public final int e() {
            return this.f5434c.headers().size();
        }

        public final String a(int i10) {
            return this.f5434c.headers().name(i10);
        }

        public final String b(int i10) {
            return this.f5434c.headers().value(i10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a3 A[SYNTHETIC, Splitter:B:31:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c7 A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0110 A[Catch:{ all -> 0x00aa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r10) {
        /*
            r9 = this;
            java.lang.String r0 = "NetTrace-Interceptor"
            okhttp3.Request r1 = r10.request()
            r2 = 0
            r3 = 0
            java.lang.String r4 = "begin intercept"
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ all -> 0x0093 }
            com.efs.sdk.net.NetConfigManager r4 = com.efs.sdk.net.NetManager.getNetConfigManager()     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x001b
            com.efs.sdk.net.NetConfigManager r4 = com.efs.sdk.net.NetManager.getNetConfigManager()     // Catch:{ all -> 0x0093 }
            boolean r3 = r4.enableTracer()     // Catch:{ all -> 0x0093 }
        L_0x001b:
            if (r3 != 0) goto L_0x0033
            boolean r4 = com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()     // Catch:{ all -> 0x002d }
            if (r4 == 0) goto L_0x0024
            goto L_0x0033
        L_0x0024:
            java.lang.String r4 = "net enable is false~"
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ all -> 0x002d }
            r0 = r2
            r4 = r0
            goto L_0x009d
        L_0x002d:
            r0 = move-exception
            r5 = r2
            r4 = r3
            r3 = r5
            goto L_0x0097
        L_0x0033:
            if (r1 == 0) goto L_0x004b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "intercept request is "
            r4.<init>(r5)     // Catch:{ all -> 0x002d }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x002d }
            r4.append(r5)     // Catch:{ all -> 0x002d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002d }
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ all -> 0x002d }
            goto L_0x0050
        L_0x004b:
            java.lang.String r4 = "intercept request is null~"
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ all -> 0x002d }
        L_0x0050:
            com.efs.sdk.net.a.a.f r4 = r9.f5426a     // Catch:{ all -> 0x002d }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "intercept request id is "
            java.lang.String r6 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x008e }
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x008e }
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r0, (java.lang.String) r5)     // Catch:{ all -> 0x008e }
            com.efs.sdk.net.a.a r0 = com.efs.sdk.net.a.a.a()     // Catch:{ all -> 0x008e }
            com.efs.sdk.net.a.c r0 = r0.a(r4)     // Catch:{ all -> 0x008e }
            okhttp3.HttpUrl r5 = r1.url()     // Catch:{ all -> 0x008e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x008e }
            r0.f5470c = r5     // Catch:{ all -> 0x008e }
            com.efs.sdk.net.a.a.h r0 = new com.efs.sdk.net.a.a.h     // Catch:{ all -> 0x008e }
            com.efs.sdk.net.a.a.f r5 = r9.f5426a     // Catch:{ all -> 0x008e }
            r0.<init>(r5, r4)     // Catch:{ all -> 0x008e }
            com.efs.sdk.net.OkHttpInterceptor$b r5 = new com.efs.sdk.net.OkHttpInterceptor$b     // Catch:{ all -> 0x0087 }
            r5.<init>(r4, r1, r0)     // Catch:{ all -> 0x0087 }
            com.efs.sdk.net.a.a.f r6 = r9.f5426a     // Catch:{ all -> 0x0087 }
            r6.a((com.efs.sdk.net.a.a.f.b) r5)     // Catch:{ all -> 0x0087 }
            goto L_0x009d
        L_0x0087:
            r5 = move-exception
            r8 = r3
            r3 = r0
            r0 = r5
            r5 = r4
            r4 = r8
            goto L_0x0097
        L_0x008e:
            r0 = move-exception
            r5 = r4
            r4 = r3
            r3 = r2
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            r3 = r2
            r5 = r3
            r4 = 0
        L_0x0097:
            r0.printStackTrace()
            r0 = r3
            r3 = r4
            r4 = r5
        L_0x009d:
            okhttp3.Response r5 = r10.proceed(r1)
            if (r3 != 0) goto L_0x00ac
            boolean r3 = com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()     // Catch:{ all -> 0x00aa }
            if (r3 == 0) goto L_0x011b
            goto L_0x00ac
        L_0x00aa:
            r10 = move-exception
            goto L_0x0118
        L_0x00ac:
            if (r0 == 0) goto L_0x00c1
            boolean r3 = r0.a()     // Catch:{ all -> 0x00aa }
            if (r3 == 0) goto L_0x00c1
            r0.b()     // Catch:{ all -> 0x00aa }
            com.efs.sdk.net.a.a.f r3 = r0.f5460a     // Catch:{ all -> 0x00aa }
            java.io.ByteArrayOutputStream r0 = r0.f5461b     // Catch:{ all -> 0x00aa }
            r0.size()     // Catch:{ all -> 0x00aa }
            r3.a()     // Catch:{ all -> 0x00aa }
        L_0x00c1:
            okhttp3.Connection r10 = r10.connection()     // Catch:{ all -> 0x00aa }
            if (r10 == 0) goto L_0x0110
            com.efs.sdk.net.a.a.f r0 = r9.f5426a     // Catch:{ all -> 0x00aa }
            com.efs.sdk.net.OkHttpInterceptor$c r3 = new com.efs.sdk.net.OkHttpInterceptor$c     // Catch:{ all -> 0x00aa }
            r3.<init>(r4, r1, r5, r10)     // Catch:{ all -> 0x00aa }
            r0.a((com.efs.sdk.net.a.a.f.d) r3)     // Catch:{ all -> 0x00aa }
            okhttp3.ResponseBody r10 = r5.body()     // Catch:{ all -> 0x00aa }
            if (r10 == 0) goto L_0x00e0
            okhttp3.MediaType r0 = r10.contentType()     // Catch:{ all -> 0x00aa }
            java.io.InputStream r1 = r10.byteStream()     // Catch:{ all -> 0x00aa }
            goto L_0x00e2
        L_0x00e0:
            r0 = r2
            r1 = r0
        L_0x00e2:
            com.efs.sdk.net.a.a.f r3 = r9.f5426a     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x00ea
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x00aa }
        L_0x00ea:
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r0 = r5.header(r0)     // Catch:{ all -> 0x00aa }
            com.efs.sdk.net.a.a.c r6 = new com.efs.sdk.net.a.a.c     // Catch:{ all -> 0x00aa }
            com.efs.sdk.net.a.a.f r7 = r9.f5426a     // Catch:{ all -> 0x00aa }
            r6.<init>(r7, r4)     // Catch:{ all -> 0x00aa }
            java.io.InputStream r0 = r3.a(r4, r2, r0, r1)     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x011b
            okhttp3.Response$Builder r1 = r5.newBuilder()     // Catch:{ all -> 0x00aa }
            com.efs.sdk.net.OkHttpInterceptor$a r2 = new com.efs.sdk.net.OkHttpInterceptor$a     // Catch:{ all -> 0x00aa }
            r2.<init>(r10, r0)     // Catch:{ all -> 0x00aa }
            okhttp3.Response$Builder r10 = r1.body(r2)     // Catch:{ all -> 0x00aa }
            okhttp3.Response r10 = r10.build()     // Catch:{ all -> 0x00aa }
            r5 = r10
            goto L_0x011b
        L_0x0110:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00aa }
            java.lang.String r0 = "No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?"
            r10.<init>(r0)     // Catch:{ all -> 0x00aa }
            throw r10     // Catch:{ all -> 0x00aa }
        L_0x0118:
            r10.printStackTrace()
        L_0x011b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.net.OkHttpInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
